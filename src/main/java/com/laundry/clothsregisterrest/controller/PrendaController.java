package com.laundry.clothsregisterrest.controller;

import com.laundry.clothsregisterrest.entity.Prenda;
import com.laundry.clothsregisterrest.repository.PrendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/register")
public class PrendaController {

    @Autowired
    private PrendaRepository prendaRepository;

    @GetMapping("/cloth")
    public List<Prenda> obtenerPrendas(){

        return prendaRepository.findAll();

    }


}
