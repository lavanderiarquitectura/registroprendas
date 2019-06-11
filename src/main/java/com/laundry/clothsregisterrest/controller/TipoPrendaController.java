package com.laundry.clothsregisterrest.controller;

import com.laundry.clothsregisterrest.entity.TipoPrenda;
import com.laundry.clothsregisterrest.repository.TipoPrendaRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api")
public class TipoPrendaController {

    @Autowired
    TipoPrendaRepository tipoPrendaRepository;

    // Get All FabricTypes
    @GetMapping("/fabricTypes")
    public List<TipoPrenda> getAllFabricTypes() {
        return tipoPrendaRepository.findAll();
    }

    // Get a Single FabricType
    @GetMapping("/fabricTypes/{id}")
    public TipoPrenda getFabricTypeById(@PathVariable(value = "id") ObjectId fabricTypeId) {
        return tipoPrendaRepository.findBy_id(fabricTypeId);
    }

    // Create a new FabricType
    @PostMapping("/fabricTypes")
    public TipoPrenda createFabricType(@Valid @RequestBody TipoPrenda fabricType) {
        fabricType.set_id(ObjectId.get());
        return tipoPrendaRepository.save(fabricType);
    }

    // Update a FabricType
    @PutMapping("/fabricTypes/{id}")
    public TipoPrenda updateFabricType(@PathVariable(value = "id") ObjectId fabricTypeId,
                                       @Valid @RequestBody TipoPrenda fabricTypeDetails) {

        TipoPrenda fabricType = tipoPrendaRepository.findBy_id(fabricTypeId);

        TipoPrenda updatedFabricType = tipoPrendaRepository.save(fabricType);
        return updatedFabricType;
    }

    // Delete a FabricType
    @DeleteMapping("/fabricTypes/{id}")
    public ResponseEntity<?> deleteFabricType(@PathVariable(value = "id") ObjectId fabricTypeId) {
        TipoPrenda fabricType = tipoPrendaRepository.findBy_id(fabricTypeId);

        tipoPrendaRepository.delete(fabricType);

        return ResponseEntity.ok().build();
    }



}
