package app.service;

import app.entity.Message;
import app.repo.MessageRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class MessageService {
    private final MessageRepo messageRepo;
    private final UserService userService;

    public void sendMessage(Long sender, Long receiver, String text) {
        messageRepo.save(
                new Message(
                        userService.findById(sender),
                        userService.findById(receiver),
                        text,
                        LocalDateTime.now()));
    }

}
