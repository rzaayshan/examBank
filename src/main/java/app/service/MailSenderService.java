package app.service;


import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;

@Component
@Log4j2
@AllArgsConstructor
public class MailSenderService {

  private final JavaMailSender javaMailSender;

  public void send(String to, String subject, String body) throws MessagingException {

    MimeMessage message = javaMailSender.createMimeMessage();
    MimeMessageHelper helper = new MimeMessageHelper(message, true);

    try {
      InternetAddress addressFrom = new InternetAddress("username", "Handy Team");
      helper.setSubject(subject);
      helper.setTo(to);
      helper.setText(body, true);
      helper.setFrom(addressFrom);

      javaMailSender.send(message);
    } catch (UnsupportedEncodingException e) {
      log.warn("UnsupportedEncodingException caught while message sending");
    }

  }

}
