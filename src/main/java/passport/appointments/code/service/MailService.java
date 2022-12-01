package passport.appointments.code.service;

import passport.appointments.code.model.Mail;



public interface MailService 
{
	public String sendEmail(Mail mail);
}