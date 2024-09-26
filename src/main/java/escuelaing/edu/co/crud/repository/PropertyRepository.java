package escuelaing.edu.co.crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import escuelaing.edu.co.crud.model.Property;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Long> {

    public List<Property> getAllProperties();
        
    
}