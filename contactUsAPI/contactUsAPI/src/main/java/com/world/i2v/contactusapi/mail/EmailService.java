package com.world.i2v.contactusapi.mail;

import com.world.i2v.contactusapi.model.ContactRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailService {


    private final JavaMailSender mailSender;

    // HR email loaded from application.yml → mail.hr.to
    @Value("${mail.hr.to}")
    private String hrEmail;


    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Async  // recommended so email sending doesn't slow API response
    public void sendContactNotification(ContactRecord record) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(hrEmail);
        System.out.println("Sending email to: " + hrEmail);
        message.setSubject("New Contact Submission from: " + record.getName());

        String body = buildEmailBody(record);

        message.setText(body);
        System.out.println("Email body: " + body);

        mailSender.send(message);
    }

    // Compose the email content
    private String buildEmailBody(ContactRecord record) {
        StringBuilder sb = new StringBuilder();
        sb.append("A new contact form has been submitted:\n\n");
        sb.append("Name: ").append(record.getName()).append("\n");
        sb.append("Email: ").append(record.getEmail()).append("\n");
        sb.append("Message: ").append(record.getMessage()).append("\n\n");
        sb.append("Submitted At: ").append(record.getCreatedAt()).append("\n");
        sb.append("IP Address: ").append(record.getIpAddress()).append("\n");
        sb.append("Location Source: ").append(record.getSource()).append("\n");

        if (record.getLat() != null && record.getLng() != null) {
            sb.append("Location: ").append(record.getLat())
                    .append(", ").append(record.getLng()).append("\n");
        }

        return sb.toString();
    }
}
