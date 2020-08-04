package app.controller;

import app.entity.Customer;
import app.security.UserrDetails;
import app.service.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class MessageController {
    private final MessageService service;
    @PostMapping("send")
    public void send(@RequestParam Optional<String> text, @RequestParam Optional<Integer> pay,
                     @RequestParam Optional<String> way, @RequestParam Optional<List<Customer>> customers,
                     @RequestParam Optional<Long> receiverID, Authentication au){
        if(text.isPresent() && pay.isPresent() && way.isPresent() && customers.isPresent() && receiverID.isPresent()){
            service.sendMessage(getLoggedUser(au).getId(), receiverID.get(),
                    String.format("%s\nPay: %s\nWay: %s\nCustomers:%s",text, pay, way, customers));
        }
        else{
            throw new RuntimeException();
        }
    }

    UserrDetails getLoggedUser(Authentication authentication) {
        return (UserrDetails) authentication.getPrincipal();
    }
}
