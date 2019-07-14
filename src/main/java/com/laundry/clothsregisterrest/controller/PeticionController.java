package com.laundry.clothsregisterrest.controller;

import com.laundry.clothsregisterrest.entity.Peticion;
import com.laundry.clothsregisterrest.repository.PeticionRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/petition")
public class PeticionController {
    @Autowired
    private PeticionRepository peticionRepository;

    @GetMapping("/get")
    public List<Peticion> obtenerPeticiones(){

        return peticionRepository.findAll();

    }

    @GetMapping("/get/{pet_id}")
    public Peticion obtenerPeticionPorID(@PathVariable("pet_id") ObjectId clothId){

        return peticionRepository.findBy_id(clothId);

    }

    @PostMapping("/create")
    public Peticion crearPeticion(@RequestBody Peticion peticion)
    {
        peticion.set_id(ObjectId.get());
        return peticionRepository.save(peticion);
    }

    @PutMapping("/update/{pet_id}")
    public Peticion actualizarPeticion(@PathVariable("pet_id") ObjectId clothId, @RequestBody Peticion userObject)
    {
        Peticion peticion = peticionRepository.findBy_id(clothId);
        peticion.setId_room(userObject.getId_room());

        return peticionRepository.save(peticion);
    }

    @DeleteMapping("/delete/{pet_id}")
    public Peticion eliminarPrenda(@PathVariable("pet_id") ObjectId clothId)
    {

        Peticion peticion = peticionRepository.findBy_id(clothId);

        if(peticion != null)
            this.peticionRepository.delete(peticion);
        return peticion;
    }
}
