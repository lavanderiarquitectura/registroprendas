package com.laundry.clothsregisterrest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
//import com.laundry.clothsregisterrest.ServicesConfiguration;
import com.laundry.clothsregisterrest.entity.Lotelista;
import com.laundry.clothsregisterrest.entity.Prenda;
import com.laundry.clothsregisterrest.repository.PrendaRepository;
import com.laundry.clothsregisterrest.entity.Lote;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/cloth_register")
public class PrendaController {

    @Autowired
    private PrendaRepository prendaRepository;

//    @Autowired
//    private ServicesConfiguration servicesConfigurationInstance;

    RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/get")
    public List<Prenda> obtenerPrendas(){

        return prendaRepository.findAll();

    }

    @GetMapping("/get/{cloth_id}")
    public Prenda obtenerPrendaPorID(@PathVariable("cloth_id") ObjectId clothId){

        return prendaRepository.findBy_id(clothId);

    }

    @GetMapping("/get/lot/{lot_id}")
    public List<Prenda> obtenerPrendasPorIDLote(@PathVariable("lot_id") Integer lot_id){

        return prendaRepository.findById_Lote(lot_id);

    }


    @GetMapping("/get/room/{room_id}")
    public List<Prenda>  obtenerPrendaPorIDCuarto(@PathVariable("room_id") Integer roomId){

        return prendaRepository.findById_cuarto(roomId);

    }

    @PostMapping("/create")
    public Prenda crearPrenda(@RequestBody Prenda prenda)
    {
        prenda.set_id(ObjectId.get());
        return prendaRepository.save(prenda);
    }

    @PostMapping("/create_list")
    public List<Prenda> crearPrenda(@RequestBody List<Prenda> prendas)
    {
        List<Prenda> prendas_insertadas = new ArrayList<>();
        Lote maxLote = new Lote(), tempLote;
        String tempLoteList = "";

        for(Prenda prenda : prendas)
        {
            prenda.set_id(ObjectId.get());
            try {
                tempLote = null;

                maxLote = restTemplate.getForObject("http://localhost:5000/lots"+"/max", Lote.class);

                tempLoteList = restTemplate.getForObject("http://localhost:5000/lots"+ "/" + prenda.getTipo_operacion_id_tipo_operacion()
                         + "/" + prenda.getTipo_tela_id_tipo_tela() + "/false", String.class);

                ObjectMapper mapper = new ObjectMapper();
                CollectionType tipoLista = mapper.getTypeFactory().constructCollectionType(ArrayList.class, Lote.class);
                List<Lote> ob = mapper.readValue(tempLoteList, tipoLista);

                if(ob.size() > 0){
                    tempLote = ob.get(0);
                }

                if(tempLote != null && tempLote.getCapacity().intValue() <= 100){
                    prenda.setId_lote(tempLote.getId().intValue());
                    tempLote.setCapacity(tempLote.getCapacity() + 1);
                    restTemplate.put("http://localhost:5000/lots/" + tempLote.getId().toString(), tempLote);

                }else{

                    Integer con_id;

                    if(maxLote != null)
                         con_id= new Integer(maxLote.getId().intValue() + 1);
                    else
                        con_id = new Integer(1);


                    tempLote = new Lote();
                    tempLote.setId(con_id.longValue());
                    tempLote.setTypeFabric(prenda.getTipo_tela_id_tipo_tela());
                    tempLote.setTypeOperation(prenda.getTipo_operacion_id_tipo_operacion());
                    tempLote.setIsFinished(false);
                    tempLote.setTypeService(prenda.getTipo_operacion_id_tipo_operacion().toString());
                    tempLote.setCapacity(1);

                    prenda.setId_lote(con_id);

                    restTemplate.postForObject("http://localhost:5000/lots", tempLote, Lote.class);
                }


            } catch (Exception e) {
                e.printStackTrace();
            }
            prendas_insertadas.add(prendaRepository.save(prenda));
        }
        return prendas_insertadas;
    }


    @PutMapping("/update/{cloth_id}")
    public Prenda actualizarPrenda(@PathVariable("cloth_id") ObjectId clothId, @RequestBody Prenda userObject)
    {
        Prenda prenda = prendaRepository.findBy_id(clothId);
        prenda.setColor(userObject.getColor());
        prenda.setFecha_entrega(userObject.getFecha_entrega());
        prenda.setFecha_ingreso(userObject.getFecha_ingreso());
        prenda.setMarca(userObject.getMarca());
        prenda.setId_cuarto(userObject.getId_cuarto());
        prenda.setId_lote(userObject.getId_lote());
        prenda.setTipo_prenda_id_tipo_prenda(userObject.getTipo_prenda_id_tipo_prenda());
        prenda.setTipo_operacion_id_tipo_operacion(userObject.getTipo_operacion_id_tipo_operacion());
        prenda.setTipo_tela_id_tipo_tela(userObject.getTipo_tela_id_tipo_tela());

        return prendaRepository.save(prenda);
    }

    @DeleteMapping("/delete/{cloth_id}")
    public Prenda eliminarPrenda(@PathVariable("cloth_id") ObjectId clothId)
    {

        Prenda prendaAEliminar = prendaRepository.findBy_id(clothId);

        if(prendaAEliminar != null)
            this.prendaRepository.delete(prendaAEliminar);
        return prendaAEliminar;
    }

}
