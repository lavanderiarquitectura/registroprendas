package com.laundry.clothsregisterrest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
//import com.laundry.clothsregisterrest.ServicesConfiguration;
import com.laundry.clothsregisterrest.entity.*;
import com.laundry.clothsregisterrest.repository.PeticionRepository;
import com.laundry.clothsregisterrest.repository.PrendaRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/cloth_register")
public class PrendaController {

    @Autowired
    private PrendaRepository prendaRepository;

    @Autowired
    private PeticionRepository peticionController;

//    @Autowired
//    private ServicesConfiguration servicesConfigurationInstance;

    RestTemplate restTemplate = new RestTemplate();

    String ipLotes = "http://100.26.191.111:5000/lots";
    String ipfacturacion = "http://100.26.191.111:3000";

    //String ipLotes = "http://localhost:5000/lots";

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

    @GetMapping("/get/operation/{op_id}")
    public List<Prenda> obtenerPrendasPorIDTipoOperacion(@PathVariable("op_id") Integer lot_id){

        String tempLoteList = "";
        List<Prenda> respuesta = new ArrayList<Prenda>();
        List<Prenda> temp = new ArrayList<Prenda>();

        try{
            tempLoteList = restTemplate.getForObject(ipLotes + "/" + lot_id.toString()
                    + "/" + "/false", String.class);

            ObjectMapper mapper = new ObjectMapper();
            CollectionType tipoLista = mapper.getTypeFactory().constructCollectionType(ArrayList.class, Lote.class);
            List<Lote> ob = mapper.readValue(tempLoteList, tipoLista);

            for(Lote lote : ob){
                temp = prendaRepository.findById_Lote(new Integer(lote.getId().intValue()));
                respuesta.addAll(temp);

//                for(Prenda prenda : temp)
//                    respuesta.add(prenda);
            }
                //ids.add( new Integer(lote.getId().intValue()) );



        }
        catch(Exception e){
            e.printStackTrace();
        }

        return respuesta;

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
        List<PrendaFacturacion> factura_prendas = new ArrayList<>();
        Lote maxLote = new Lote(), tempLote;
        String tempLoteList = "";
        Factura factura = new Factura();
        Peticion peticion = new Peticion();

        for(Prenda prenda : prendas)
        {
            prenda.set_id(ObjectId.get());
            try {
                tempLote = null;

                maxLote = restTemplate.getForObject(ipLotes +"/max", Lote.class);

                tempLoteList = restTemplate.getForObject(ipLotes + "/" + prenda.getTipo_operacion_id_tipo_operacion()
                         + "/" + prenda.getTipo_tela_id_tipo_tela() + "/false", String.class);

                ObjectMapper mapper = new ObjectMapper();
                CollectionType tipoLista = mapper.getTypeFactory().constructCollectionType(ArrayList.class, Lote.class);
                List<Lote> ob = mapper.readValue(tempLoteList, tipoLista);

                if(ob.size() > 0){
                    tempLote = ob.get(0);
                }

                if(tempLote != null && tempLote.getCapacity() == null)
                    tempLote.setCapacity(0);

                if(tempLote != null && tempLote.getCapacity().intValue() <= 100){
                    prenda.setId_lote(tempLote.getId().intValue());
                    tempLote.setCapacity(new Integer(tempLote.getCapacity() + 1));
                    restTemplate.put(ipLotes + "/" + tempLote.getId().toString(), tempLote);
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
                    tempLote.setCapacity(1);
                    tempLote.setState(0);

                    prenda.setId_lote(con_id);

                    restTemplate.postForObject(ipLotes , tempLote, Lote.class);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }


            PrendaFacturacion prendaFac = new PrendaFacturacion();

            prendaFac.setId_prenda(prenda.get_id());

            SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
            //String dateInString = prenda.get;
            String  fecha_formato = sdf.format(prenda.getFecha_ingreso());

            prendaFac.setFecha_ingreso(fecha_formato);
            prendaFac.setId_operacion(prenda.getTipo_operacion_id_tipo_operacion());

            factura_prendas.add(prendaFac);
            prendas_insertadas.add(prendaRepository.save(prenda));

        }

        try {

            factura.setFactura(factura_prendas);
            factura.setId_cuarto(prendas_insertadas.get(0).getId_cuarto());

            //peticion.set_id(ObjectId.get());
            peticion.setId_room(prendas_insertadas.get(0).getId_cuarto());

            peticionController.save(peticion);
            restTemplate.postForObject(ipfacturacion + "/postfacprendas", factura, Factura.class);

        }catch (Exception e){
            e.printStackTrace();
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
