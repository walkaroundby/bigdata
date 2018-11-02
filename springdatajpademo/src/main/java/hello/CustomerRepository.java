package hello;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);

    @Query(value="SELECT * FROM Customer WHERE firstName LIKE ?1", nativeQuery = true)
    Customer findByNative(String firstName);

    @Query(value="FROM Customer WHERE firstName LIKE ?1")
    Customer findNotByNative(String firstName);
}
