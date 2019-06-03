package com.laundry.clothsregisterrest.controller;

import com.laundry.clothsregisterrest.entity.Prenda;
import com.laundry.clothsregisterrest.repository.PrendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/cloth_register")
public class PrendaController {

    @Autowired
    private PrendaRepository prendaRepository;

    @GetMapping("/get")
    public List<Prenda> obtenerPrendas(){

        return prendaRepository.findAll();

    }

    @GetMapping("/get/{cloth_id}")
    public Prenda obtenerPrendaPorID(@PathVariable("cloth_id") Integer clothId){

        return prendaRepository.findOne(clothId);

    }


    @PostMapping("/create")
    public Prenda crearPrenda(@RequestBody Prenda prenda)
    {
        return prendaRepository.save(prenda);
    }


    @PutMapping("/update/{cloth_id}")
    public Prenda actualizarPrenda(@PathVariable("cloth_id") Integer clothId, @RequestBody Prenda userObject)
    {
        Prenda prenda = prendaRepository.findOne(clothId);
        prenda.setColor(userObject.getColor());
        prenda.setFecha_entrega(userObject.getFecha_entrega());
        prenda.setFecha_ingreso(userObject.getFecha_ingreso());
        prenda.setMarca(userObject.getMarca());
        prenda.setId_cuarto(userObject.getId_cuarto());
        prenda.setTipo_operacion_id_tipo_operacion(userObject.getTipo_operacion_id_tipo_operacion());
        prenda.setTipo_tela_id_tipo_tela(userObject.getTipo_tela_id_tipo_tela());

        return prendaRepository.save(prenda);
    }

    @DeleteMapping("/delete/{cloth_id}")
    public Prenda eliminarPrenda(@PathVariable("cloth_id") Integer clothId)
    {

        Prenda prendaAEliminar = prendaRepository.findOne(clothId);

        if(prendaAEliminar != null)
            this.prendaRepository.delete(prendaAEliminar);
        return prendaAEliminar;
    }

}
