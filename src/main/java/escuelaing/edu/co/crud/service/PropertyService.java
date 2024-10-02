package escuelaing.edu.co.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import escuelaing.edu.co.crud.model.Property;
import escuelaing.edu.co.crud.repository.PropertyRepository;

@Service
public class PropertyService {

    private final PropertyRepository propertyRepository;

    @Autowired
    public PropertyService(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    public List<Property> getAllProperties() {
        return propertyRepository.findAll();
    }

    public Property getPropertyById(Long id) {
        return propertyRepository.findById(id).orElse(null);
    }

    public void createProperty(Property property) {
        propertyRepository.save(property);
    }

    public void updateProperty(Long id, Property propertyDetails) {
        Property property = propertyRepository.findById(id).orElseThrow();
        property.setAddress(propertyDetails.getAddress());
        property.setPrice(propertyDetails.getPrice());
        property.setSize(propertyDetails.getSize());
        property.setDescription(propertyDetails.getDescription());
        propertyRepository.save(property);
    }

    public void deleteProperty(Long id) {
        propertyRepository.deleteById(id);
    }
}
