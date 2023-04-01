package curtainRod.repository;

import curtainRod.entity.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface CustomerFirstRepository {

    List<Customer> findAll();
    Optional<Customer> findById(Integer id);// bedzie zwracać pojedynczy taskGroup i wspiera lazy loading

    //boolean existsById(int id);
    Customer findTopByOrderByIdDesc();


    Customer save(Customer entity);




}
