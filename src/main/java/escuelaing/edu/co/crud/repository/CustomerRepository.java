package escuelaing.edu.co.crud.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import escuelaing.edu.co.crud.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

  List<Customer> findByLastName(String lastName);

  Customer findById(long id);
}