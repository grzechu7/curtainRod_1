package curtainRod.service;

import curtainRod.entity.Customer;
import curtainRod.repository.model.CustomerWriteModel;
import curtainRod.repository.CustomerFirstRepository;

import java.util.List;
//@Service // jesli przeniesiemy zmienne z repository do klasy LogicConfiguration mamy czysty kod Java nie springowy i nie musimy wstawiac adnotacji @Service
public class CustomerService {

    private CustomerFirstRepository repository;

    public CustomerService(CustomerFirstRepository repository) {
        this.repository = repository;
    }

    public Customer getCurtainById(Integer id){
        return repository.findById(id).get();
    }


    //odczytujemy klientów
    public List<Customer> readAll(){
        return repository.findAll();

    }


    public Customer save(final CustomerWriteModel toSave){

        return repository.save(toSave.toLongurtain());
    }

    public CustomerFirstRepository getRepository() {
        return repository;
    }

    public void setRepository(CustomerFirstRepository repository) {
        this.repository = repository;
    }

    // pobiera najwyższe ID wpisanego klienta dla sesji
    public long getHighestClientId() {
        Customer clientId = repository.findTopByOrderByIdDesc();
        if (clientId != null) {
            return clientId.getId();
        } else {
            return 0;
        }
    }




}
