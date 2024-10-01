package escuelaing.edu.co.crud.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import escuelaing.edu.co.crud.model.Property;

@Repository
public interface PropertyRepository extends CrudRepository<Property, Long> {

    List<Property> findAll();
        
    
}