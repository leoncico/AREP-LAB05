package escuelaing.edu.co.crud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import escuelaing.edu.co.crud.model.Customer;
import escuelaing.edu.co.crud.model.Property;
import escuelaing.edu.co.crud.repository.CustomerRepository;
import escuelaing.edu.co.crud.repository.PropertyRepository;

@SpringBootApplication
public class AccessingDataJpaApplication {

  private static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);

  public static void main(String[] args) {
    SpringApplication.run(AccessingDataJpaApplication.class);
  }

  @Bean
  public CommandLineRunner demo(PropertyRepository propertyRepository, CustomerRepository repository) {
    return (args) -> {
      // save a few customers
      // repository.save(new Customer("Jack", "Bauer"));
      // repository.save(new Customer("Chloe", "O'Brian"));
      // repository.save(new Customer("Kim", "Bauer"));
      // repository.save(new Customer("David", "Palmer"));
      // repository.save(new Customer("Michelle", "Dessler"));

      // // fetch all customers
      // log.info("Customers found with findAll():");
      // log.info("-------------------------------");
      // repository.findAll().forEach(customer -> {
      //   log.info(customer.toString());
      // });
      // log.info("");

      // // fetch an individual customer by ID
      // Customer customer = repository.findById(1L);
      // log.info("Customer found with findById(1L):");
      // log.info("--------------------------------");
      // log.info(customer.toString());
      // log.info("");

      // // fetch customers by last name
      // log.info("Customer found with findByLastName('Bauer'):");
      // log.info("--------------------------------------------");
      // repository.findByLastName("Bauer").forEach(bauer -> {
      //   log.info(bauer.toString());
      // });
      // log.info("");
      
      // Property property1 = new Property("123 Main St", 250000, 120, "Casa familiar en una buena ubicación.");
      // Property property2 = new Property("456 Elm St", 300000, 150, "Amplia casa con jardín.");
      // Property property3 = new Property("789 Maple Ave", 200000, 80, "Departamento acogedor en el centro.");

      // propertyRepository.save(property1);
      // propertyRepository.save(property2);
      // propertyRepository.save(property3);
    };
  }

}