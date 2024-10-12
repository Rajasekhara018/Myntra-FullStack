package com.myntra.service;

import com.myntra.model.EmailResponse;
import com.myntra.repository.MailResponseReposirory;
import jakarta.mail.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.util.Date;
import java.util.Properties;

@Service
public class MailFetchService {
    private static final Logger log = LoggerFactory.getLogger(MailFetchService.class);
    @Autowired
    private MailResponseReposirory emailResponseRepository;

    @Scheduled(fixedRate = 60000) // Check for new emails every minute
    public void fetchEmails() {
        try {
            Properties properties = new Properties();
            properties.put("mail.store.protocol", "imaps");
            Session emailSession = Session.getDefaultInstance(properties);
            Store store = emailSession.getStore("imaps");
            store.connect("imap.example.com", "rajshekarbadam001@gmail.com", "gxqsyjnstodtmdgz");

            Folder emailFolder = store.getFolder("INBOX");
            emailFolder.open(Folder.READ_ONLY);
            log.info("Mail Fetch Started");
            Message[] messages = emailFolder.getMessages();
            for (Message message : messages) {
                Date lastCheckedDate = new Date();
                if (message.getReceivedDate().after(lastCheckedDate)) {
                    String sender = message.getFrom()[0].toString();
                    String subject = message.getSubject();
                    String body = getTextFromMessage(message);

                    EmailResponse emailResponse = new EmailResponse();
                    emailResponse.setSender(sender);
                    emailResponse.setSubject(subject);
                    emailResponse.setBody(body);
                    log.info("mail Response",emailResponse);
                    emailResponseRepository.save(emailResponse);
                }
            }

            emailFolder.close(false);
            store.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getTextFromMessage(Message message) throws Exception {
        if (message.isMimeType("text/plain")) {
            return message.getContent().toString();
        } else if (message.isMimeType("multipart/*")) {
            Multipart multipart = (Multipart) message.getContent();
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < multipart.getCount(); i++) {
                BodyPart bodyPart = multipart.getBodyPart(i);
                result.append(bodyPart.getContent().toString());
            }
            return result.toString();
        }
        return "";
    }
}
//@Service
//public class EmailFetchService {
//    @Autowired
//    private EmailResponseRepository emailResponseRepository;
//
//    @Scheduled(fixedRate = 60000) // Check for new emails every minute
//    public void fetchEmails() {
//        try {
//            Properties properties = new Properties();
//            properties.put("mail.store.protocol", "imaps");
//            Session emailSession = Session.getDefaultInstance(properties);
//            Store store = emailSession.getStore("imaps");
//            store.connect("imap.example.com", "your-email@example.com", "your-email-password");
//
//            Folder emailFolder = store.getFolder("INBOX");
//            emailFolder.open(Folder.READ_ONLY);
//
//            Message[] messages = emailFolder.getMessages();
//            for (Message message : messages) {
//                if (message.getReceivedDate().after(lastCheckedDate)) {
//                    String sender = message.getFrom()[0].toString();
//                    String subject = message.getSubject();
//                    String body = getTextFromMessage(message);
//
//                    EmailResponse emailResponse = new EmailResponse();
//                    emailResponse.setSender(sender);
//                    emailResponse.setSubject(subject);
//                    emailResponse.setBody(body);
//                    emailResponse.setReceivedAt(message.getReceivedDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
//                    emailResponseRepository.save(emailResponse);
//                }
//            }
//
//            emailFolder.close(false);
//            store.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    private String getTextFromMessage(Message message) throws Exception {
//        if (message.isMimeType("text/plain")) {
//            return message.getContent().toString();
//        } else if (message.isMimeType("multipart/*")) {
//            Multipart multipart = (Multipart) message.getContent();
//            StringBuilder result = new StringBuilder();
//            for (int i = 0; i < multipart.getCount(); i++) {
//                BodyPart bodyPart = multipart.getBodyPart(i);
//                result.append(bodyPart.getContent().toString());
//            }
//            return result.toString();
//        }
//        return "";
//    }
//}
