package com.example.controller;

import com.example.model.Manufacturer;
import com.example.service.ManufacturerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

@RestController
@RequestMapping("/api")
public class ManufacturerController {

    private final ManufacturerService service;
    @Autowired
    public ManufacturerController(ManufacturerService service) {
        this.service = service;
    }

    /*
    GET http://localhost:8080/api/manufacturers
     */
    @GetMapping("/manufacturers")
    public ResponseEntity<List<Manufacturer>> findAll(){
        List<Manufacturer> manufacturers = this.service.findAll();
        if (manufacturers.isEmpty())
            return ResponseEntity.notFound().build();

       return ResponseEntity.ok(manufacturers);
    }

    /*
    GET http://localhost:8080/api/manufacturers/year/1990
     */
    @GetMapping("/manufacturers/year/{year}")
    public ResponseEntity<List<Manufacturer>> findAllByYear(@PathVariable Integer year){
        List<Manufacturer> manufacturers = this.service.findAllByYear(year);
        if (manufacturers.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(manufacturers);
    }
    /*
    GET http://localhost:8080/api/manufacturers?year=1990
     */
    @GetMapping("/manufacturers/year")
    public ResponseEntity<List<Manufacturer>> findAllByYearRequest(@RequestParam Integer year) {
        List<Manufacturer> manufacturers = this.service.findAllByYear(year);
        if (manufacturers.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(manufacturers);
    }

    @GetMapping("/manufacturers/initialDate/{initialDate}")
    // initialDate viaja como String y DateTimeFormat lo convierte a Date
    public ResponseEntity<List<Manufacturer>> findAllByInitialDate( @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")  Date initialDate){
        List<Manufacturer> manufacturers = this.service.findAllByInitialDate(initialDate);
        if (manufacturers.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(manufacturers);
    }
    //GET /manufacturers/byDate?initialDate=2025-03-26T17:20:42
    /*
    @GetMapping("/byDate")
public ResponseEntity<List<Manufacturer>> findAllByInitialDate(
        @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") Date initialDate) {
    // Lógica del controlador
}

     */
    /*
    GET http://localhost:8080/api/manufacturers/7
     */
    @GetMapping("/manufacturers/{id}")
    public ResponseEntity<Manufacturer> findById(@PathVariable Long id){
        return this.service.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/manufacturers")
    public ResponseEntity<Manufacturer> create(@RequestBody Manufacturer manufacturer){
        // comprobaciones
        if(manufacturer.getId() != null)
            return ResponseEntity.badRequest().build();

        this.service.save(manufacturer);
        return ResponseEntity.ok(manufacturer);
    }

    @PutMapping("/manufacturers")
    public ResponseEntity<Manufacturer> update(@RequestBody Manufacturer manufacturer){
        this.service.save(manufacturer);
        return ResponseEntity.ok(manufacturer);
    }

    @DeleteMapping("/manufacturers/{identifier}")
    public ResponseEntity<Manufacturer> deleteById(@PathVariable("identifier") Long id){
        this.service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
