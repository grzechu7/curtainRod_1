package curtainRod.repository;


import curtainRod.entity.Longcurtain;

import java.util.List;

public interface LongCurtainFirstRepository extends LongCurtainRepository {

    Longcurtain getCurtainById(Integer id);
    List<Longcurtain> findAll();


    //szuka klienta o konkretnym Id
    List<Longcurtain> findByCustomer_id(Integer customer_id);



    void deleteById(Integer id);
    Longcurtain save(Integer id);



}
