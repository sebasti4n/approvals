package com.approvals.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendApprovalNotification(String to, String requester, String description) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("Nueva solicitud pendiente de aprobación");
        message.setText("Hola,\n\nTienes una nueva solicitud pendiente:\n\n" +
                        "Solicitante: " + requester + "\n" +
                        "Descripción: " + description + "\n\n" +
                        "Por favor revisa la bandeja de aprobaciones en el sistema.");
        mailSender.send(message);
    }
}