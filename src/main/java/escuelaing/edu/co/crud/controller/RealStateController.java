package escuelaing.edu.co.crud.controller;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import escuelaing.edu.co.crud.model.Property;
import escuelaing.edu.co.crud.service.PropertyService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/properties")
public class RealStateController {

    private final PropertyService propertyService;

    @Autowired
    public RealStateController(PropertyService propertyService) {
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

    @GetMapping("/{id}")
    public ResponseEntity<Property> getPropertyById(@PathVariable Long id) {
        Property property = propertyService.getPropertyById(id);
        if (property != null) {
            return new ResponseEntity<>(property, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProperty(@PathVariable Long id, @RequestBody Property propertyDetails) {
        propertyService.updateProperty(id, propertyDetails);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProperty(@PathVariable Long id) {
        propertyService.deleteProperty(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
