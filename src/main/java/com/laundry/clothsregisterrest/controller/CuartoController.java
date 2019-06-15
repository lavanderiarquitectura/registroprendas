package com.laundry.clothsregisterrest.controller;

import com.laundry.clothsregisterrest.entity.Cuarto;
import com.laundry.clothsregisterrest.repository.CuartoRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api")
public class CuartoController {

    @Autowired
    private CuartoRepository cuartoRepository;

    RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/rooms")
    public List<Cuarto> obtenerCuartos(){

        return cuartoRepository.findAll();

    }

    @GetMapping("/rooms/{room_id}")
    public Cuarto obtenerPrendaPorID(@PathVariable("room_id") ObjectId clothId){

        return cuartoRepository.findBy_id(clothId);

    }

    @PostMapping("/rooms")
    public Cuarto crearCuarto(@RequestBody Cuarto cuarto)
    {
        cuarto.set_id(ObjectId.get());
        return cuartoRepository.save(cuarto);
    }

    @PutMapping("/rooms/{room_id}")
    public Cuarto actualizarCuarto(@PathVariable("room_id") ObjectId clothId, @RequestBody Cuarto userObject)
    {
        Cuarto prenda = cuartoRepository.findBy_id(clothId);

        return cuartoRepository.save(prenda);
    }

    @DeleteMapping("/rooms/{room_id}")
    public Cuarto eliminarPrenda(@PathVariable("room_id") ObjectId clothId)
    {

        Cuarto cuartoAEliminar = cuartoRepository.findBy_id(clothId);

        if(cuartoAEliminar != null)
            this.cuartoRepository.delete(cuartoAEliminar);
        return cuartoAEliminar;
    }

}
