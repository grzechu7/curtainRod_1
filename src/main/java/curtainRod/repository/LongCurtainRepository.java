package curtainRod.repository;


import curtainRod.entity.Longcurtain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LongCurtainRepository extends  JpaRepository<Longcurtain, Integer> {

    Longcurtain findByCustomerId(Integer customerId); //zwraca tylko jeden rekord dla danego customerId
    Integer findByCustomerIdAndLengthCurtainRod(Integer customerId, Integer getLengthCurtainRod);

}
