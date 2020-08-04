package app.controller;

import app.entity.Customer;
import app.service.CustomerService;
import app.service.SmtpMailSender;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import java.util.List;

@RestController
@AllArgsConstructor
public class UserController {

    private final CustomerService service;
    private final SmtpMailSender sender;

    @RequestMapping("select")
    public List<Customer> selectCustomers(@RequestParam int pay, @RequestParam int month){
        return service.select_customers(pay,month);
    }

    /**
     * http://localhost:8080/send?mail=rza.ayshan@gmail.com&pay=1000&month=12
     */
    @RequestMapping("send")
    public void sendMail(@RequestParam String mail,@RequestParam int pay, @RequestParam int month) throws MessagingException {
        String body = service.select_customers(pay, month).toString();

        sender.send(mail, "List of customers", body);
    }



}
