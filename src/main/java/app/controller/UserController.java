package app.controller;

import app.entity.Customer;
import app.security.UserrDetails;
import app.service.CustomerService;
import app.service.SmtpMailSender;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.List;

@Controller
@AllArgsConstructor
public class UserController {

    private final CustomerService service;
    private final SmtpMailSender sender;


    @PostMapping("select")
    public String selectCustomers(@RequestParam int pay, @RequestParam int month, Model model, Authentication au){
        if(getLoggedUser(au).getId()==0)
            throw new RuntimeException();
        model.addAttribute("customers", service.select_customers(pay,month));
        return "select";
    }


//    /**
//     * http://localhost:8080/send?mail=rza.ayshan@gmail.com&pay=1000&month=12
//     */
//    @RequestMapping("send")
//    public void sendMail(@RequestParam String mail,@RequestParam int pay, @RequestParam int month, Authentication au) throws MessagingException {
//        if(getLoggedUser(au).getId()==0)
//            throw new RuntimeException();
//
//        String body = service.select_customers(pay, month).toString();
//
//        sender.send(mail, "List of customers", body);
//    }

    UserrDetails getLoggedUser(Authentication authentication) {
        return (UserrDetails) authentication.getPrincipal();
    }



}
