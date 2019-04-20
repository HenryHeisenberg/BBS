package service;

public interface EmailService {

    public void sendSimpleMail(String to, String subject, String content) throws Exception;
 
}