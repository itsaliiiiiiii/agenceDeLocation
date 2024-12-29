package com.example.CarsRental.controller;

import java.util.List;
import java.util.Map;

import com.example.CarsRental.dto.contratDTO;
import com.example.CarsRental.dto.vehiculeDTO;
import com.example.CarsRental.entity.Vehicule;
import org.springframework.web.bind.annotation.*;
import com.example.CarsRental.service.vehiculeService;
import com.example.CarsRental.service.contratService;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/vehicules")
public class vehiculeController {

    @Autowired
    private vehiculeService vehiculeServ;

    @Autowired
    private contratService contratServ;


    @PostMapping
    public vehiculeDTO createVehicule(@RequestBody vehiculeDTO vehicule) {
        return vehiculeServ.createVehicule(vehicule);
    }
    @PutMapping("/{im}")
    public vehiculeDTO updateVehicule(@PathVariable String im , @RequestBody vehiculeDTO vehicule) {
        return vehiculeServ.updateVehiculeByIm(im,vehicule);
    }

    @GetMapping
    public List<vehiculeDTO> getAllVehicules() {
        return vehiculeServ.getAllVehicules();
    }

    @GetMapping("/{im}")
    public vehiculeDTO getVehicule(@PathVariable String im) {
        return vehiculeServ.getVehiculeByIm(im);
    }

    


    @GetMapping("/marques")
    public List <Map<String,Object>> getMarques()
    {
        return vehiculeServ.getPopularMarques();
    }
    @GetMapping("/contrat/{id}")
    public contratDTO getContrat(@PathVariable Long id )
    {
        return contratServ.generateContrat(id);
    }


    @DeleteMapping("/{im}")
    public void deleteVehiculeByImmatricule(@PathVariable String im) {
        vehiculeServ.deleteVehiculeByImmatricule(im);
    }

}
