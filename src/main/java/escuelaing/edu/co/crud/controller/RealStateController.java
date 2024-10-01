package escuelaing.edu.co.crud.controller;

import java.util.List;

import java.util.Map;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import escuelaing.edu.co.crud.model.Property;
import escuelaing.edu.co.crud.service.PropertyService;

@RestController
@RequestMapping("/properties")
public class RealStateController {

    private final PropertyService propertyService;

    @Autowired
    public RealStateController(PropertyService propertyService){
        this.propertyService = propertyService;
    }

    @GetMapping
    public ResponseEntity<List<Property>> getAllProperties() {
        List<Property> properties = propertyService.getAllProperties();
        return new ResponseEntity<>(properties, HttpStatus.OK);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<?> createProperty(@RequestBody Property property) {
        propertyService.createProperty(property);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
