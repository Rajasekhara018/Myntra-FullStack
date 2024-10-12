package com.myntra.service;

import com.myntra.AESencryption.AESAlgorithm;
import com.myntra.constants.MyntraConstants;
import com.myntra.model.AuthRegister;
import com.myntra.model.MailStructure;
import jakarta.activation.DataSource;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.util.ByteArrayDataSource;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.encryption.AccessPermission;
import org.apache.pdfbox.pdmodel.encryption.StandardProtectionPolicy;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Calendar;

@Service
public class MailSenderService {

	private static final Logger log = LoggerFactory.getLogger(MailSenderService.class);
	@Autowired
	private  JavaMailSender mailSender;

	@Autowired
	private AESAlgorithm aesAlgorithm;

	@Autowired
	private TemplateEngine templateEngine;

	public void sendMail(MailStructure mailStructure) {

//		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
//		var email="rajshekarbadam001@gmail.com";
//		simpleMailMessage.setFrom(email);
//		simpleMailMessage.setSubject(mailStructure.getSubject());
//		simpleMailMessage.setText(mailStructure.getMessage());
//		simpleMailMessage.setTo(mail);
//		mailSender.send(simpleMailMessage);
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		try {
			helper.setFrom("rajshekarbadam001@gmail.com");
			helper.setTo(mailStructure.getTo());
			helper.setSubject(mailStructure.getSubject());
			helper.setText(mailStructure.getBody());
			mailSender.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		}

    }
	public void sendMail(String to,String subject,String body) {
//		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
//		var email="rajshekarbadam001@gmail.com";
//		simpleMailMessage.setFrom(email);
//		simpleMailMessage.setSubject(mailStructure.getSubject());
//		simpleMailMessage.setText(mailStructure.getMessage());
//		simpleMailMessage.setTo(mail);
//		mailSender.send(simpleMailMessage);
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		try {
			helper.setFrom("rajshekarbadam001@gmail.com");
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(body);
			mailSender.send(message);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

//	public void SendRegisterMail(User request) {
////		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
////		simpleMailMessage.setFrom(null);
////		simpleMailMessage.setTo(request.getEmail());
////		simpleMailMessage.setText(null);
//		MimeMessage message = mailSender.createMimeMessage();
//		MimeMessageHelper helper = new MimeMessageHelper(message);
//		try {
//			helper.setFrom("rajshekarbadam001@gmail.com");
//			helper.setTo(request.getEmail());
//			helper.setSubject("Registered Details");
//			helper.setText(userRepository.findByUsername(request.getUsername()).toString());
//			mailSender.send(message);
//		} catch (MessagingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}
	
	public void EmailTemplate() {
		MimeMessage message = mailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message,
					MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
					StandardCharsets.UTF_8.name());
			helper.setFrom("rajshekarbadam001@gmail.com");
			helper.setTo("rajshekarbadam001@gmail.com");
			helper.setSubject("Mail Template");
			helper.setText("Hello, This a email Template");
			mailSender.send(message);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//	MailStructure mailStructure
	public void RegistrationConfirmation(AuthRegister authRegister) throws IOException, MessagingException {
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
//		LocalDate today = LocalDate.now();
//		String templatePath = "src/main/resources/templates/RegitrationTemplate.html";
//		String htmlContent = new String(Files.readAllBytes(Paths.get(templatePath)));
//		htmlContent = htmlContent.replace("${userName}", authRegister.getUserName())
//				.replace("${email}", authRegister.getEmail())
//				.replace("${registrationDate}", "2024-09-15");

		Context context = new Context();
		context.setVariable("userName", authRegister.getUserName());
		context.setVariable("email", aesAlgorithm.decrypt(authRegister.getEmail(), MyntraConstants.SECRET_KEY));
		context.setVariable("registrationDate", authRegister.getDob());
		String htmlContent = templateEngine.process("RegitrationTemplate", context);

		ClassPathResource logo = new ClassPathResource("static/images/Myntra-Logo.png");
		try {
			helper.setFrom("rajshekarbadam001@gmail.com");
			helper.setTo("rajshekarbadam001@gmail.com");
			helper.setSubject("RegistrationConfirmation");
//			helper.setTo(mailStructure.getTo());
//			helper.setSubject(mailStructure.getSubject());
//			helper.setText(mailStructure.getBody());
			helper.setText(htmlContent, true);
			helper.addInline("myntraLogo", logo);
			mailSender.send(message);
			log.info("Mail has sent Succesfully!");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}


	public void RegistrationConfirmationWithPdf(AuthRegister authRegister) throws IOException, MessagingException {
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);

		PDDocument pdDocument = new PDDocument();
		PDPage pdPage = new PDPage();
		try (PDPageContentStream contentStream = new PDPageContentStream(pdDocument, pdPage)) {
			contentStream.beginText();
			contentStream.setFont(PDType1Font.HELVETICA_BOLD,12);
			contentStream.newLineAtOffset(100, 700);
			contentStream.showText("Hello, World!");
			contentStream.endText();
		}
		pdDocument.addPage(pdPage);
		PDDocumentInformation pdDocumentInformation = pdDocument.getDocumentInformation();
		pdDocumentInformation.setAuthor(aesAlgorithm.decrypt(authRegister.getUserName(), MyntraConstants.SECRET_KEY));
		pdDocumentInformation.setTitle("Registration Confirmation");
		pdDocumentInformation.setCreator("Apache PDFBox");
		pdDocumentInformation.setSubject("Registration Confirmation");
		pdDocumentInformation.setCreationDate(Calendar.getInstance());
		pdDocumentInformation.setKeywords("PDFBox, Java PDF, Apache PDF");
		final int KeyLength = 128;
		AccessPermission accessPermission = new AccessPermission();
		accessPermission.setCanPrint(false);
		accessPermission.setCanModify(false);
		StandardProtectionPolicy protectionPolicy = new StandardProtectionPolicy("Welcome@123",aesAlgorithm.decrypt(authRegister.getPassword(), MyntraConstants.SECRET_KEY),accessPermission);
		protectionPolicy.setEncryptionKeyLength(KeyLength);
		protectionPolicy.setPermissions(accessPermission);
		pdDocument.protect(protectionPolicy);
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		pdDocument.save(byteArrayOutputStream);
		pdDocument.close();
		Context context = new Context();
		context.setVariable("userName", authRegister.getUserName());
		context.setVariable("email", aesAlgorithm.decrypt(authRegister.getEmail(), MyntraConstants.SECRET_KEY));
		context.setVariable("registrationDate", authRegister.getDob());
		String htmlContent = templateEngine.process("RegitrationTemplate", context);

		ClassPathResource logo = new ClassPathResource("static/images/Myntra-Logo.png");
		try {
			helper.setFrom("rajshekarbadam001@gmail.com");
			helper.setTo(aesAlgorithm.decrypt(authRegister.getEmail(),MyntraConstants.SECRET_KEY));
			helper.setSubject("Registration Confirmation");
			helper.setText(htmlContent, true);
			DataSource dataSource = new ByteArrayDataSource(byteArrayOutputStream.toByteArray(), "application/pdf");
			helper.addAttachment("ProtectedDocument.pdf", dataSource);
			helper.addInline("myntraLogo", logo);
			mailSender.send(message);
			log.info("Mail has sent Succesfully!");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
    }
}
