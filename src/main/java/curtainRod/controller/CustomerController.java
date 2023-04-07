package curtainRod.controller;

import curtainRod.entity.Customer;
import curtainRod.entity.Longcurtain;
import curtainRod.repository.model.CustomerWriteModel;
import curtainRod.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;


@Controller
//@RequestMapping("/")
public class CustomerController {

    @Autowired
    private final CustomerService service;


    public CustomerController(CustomerService service) {
        this.service = service;

    }



    @GetMapping("/")
    String showIndex(HttpSession session,
            Model model){
        //var customerToEdit = new CustomerWriteModel();
       // customerToEdit.setPlace("test"); // wyświetlanie słowa w formularzu
        model.addAttribute("customer", new CustomerWriteModel());
        long highestClientId = service.getHighestClientId();
        session.setAttribute("clientId", highestClientId + 1);
        System.out.println("zobacz sesję get: " + session.getId());
/*
        List<String> options = Arrays.asList("na lewo", "na prawo");
        model.addAttribute("options", options);

 */
        return "index";
    }

    @PostMapping("/curtainRoads")
    String addCustomer(@ModelAttribute("customer") @Valid CustomerWriteModel current,
                       BindingResult bindingResult, // walidacja czy poprzedni argument miał jakieś błedy
                      //@ModelAttribute("wave") @Valid DictWave dictWave, // działa gdy mamy tylko w formularzu html name = "wave" bez th:field="*{steps[__${stepStat.index}__].wave}"
                       @RequestParam("clientId")int clientId,
                       HttpSession session,

                       Model model){// zaraz po pozytywnym dodaniu bedziemy modyfikować CustomerWriteModel
        System.out.println("zobacz");

        if(bindingResult.hasErrors()){
            return "index";
        }

        session.setAttribute("clientId", clientId);
        CustomerWriteModel customerWriteModel = new CustomerWriteModel();
       // model.getAttribute("clientId");
        current.toLongurtain();

        model.addAttribute("customer", customerWriteModel);
        service.save(current);



        //model.addAttribute("message", "Dodano wymiary");
        return "redirect:/curtainRoads";
    }


    @PostMapping(value ="addStep", params = "addStep")
    String addCurtainStep(@ModelAttribute("customer") CustomerWriteModel current){
        current.getSteps().add(new Longcurtain()); // bierzemy listę kroków i do tej listy dodajemy nową długość karniszy, znak + na stronie
        return "index";
    }



}
