package escuelaing.edu.co.crud.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import escuelaing.edu.co.crud.model.Property;
import escuelaing.edu.co.crud.repository.PropertyRepository;

@Service
public class PropertyService{

    
    private final PropertyRepository propertyRepository;

    @Autowired
    public PropertyService(PropertyRepository propertyRepository){
        this.propertyRepository = propertyRepository;
    }

    public List<Property> getAllProperties(){
        return propertyRepository.getAllProperties();
    }
}
