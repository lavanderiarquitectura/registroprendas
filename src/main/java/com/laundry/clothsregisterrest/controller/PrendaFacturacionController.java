package com.laundry.clothsregisterrest.controller;

import com.laundry.clothsregisterrest.entity.PrendaFacturacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.GregorianCalendar;

@RestController
@RequestMapping("/cloth_fac")
public class PrendaFacturacionController {

//    @Autowired
//    private RegistroFacturacionService registroFacturacionService;

    @GetMapping("/get/{cloth_id}")
    public PrendaFacturacion obtenerPrendaFacPorID(@PathVariable("cloth_id") Integer clothId){

        //PrendaFacturacion prenda = registroFacturacionService.getPrendaFac(clothId);
        //return prenda;

        PrendaFacturacion prenda;
        prenda = new PrendaFacturacion(1, 1, "GC-001", new GregorianCalendar(2019, Calendar.MAY, 19).getTime(), new GregorianCalendar(2019, Calendar.MAY, 20).getTime(), 1,
                "Jean", 6.0F, 1, "Lavado en Seco", 10.0F);

        return prenda;
    }

}
