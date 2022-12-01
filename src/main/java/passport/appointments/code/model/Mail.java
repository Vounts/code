package passport.appointments.code.model;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Mail 
{
	private String mailFrom;
    private String mailTo;
    private String mailCc;
    private String mailBcc;
    private String mailSubject;
    private String mailContent;
    private String contentType = "text/plain";
    private List <Object> attachments;

    public Mail() {
    }

    public Mail(String mailFrom, String mailTo, String mailCc, String mailBcc, String mailSubject, String mailContent, String contentType, List<Object> attachments) {
        this.mailFrom = mailFrom;
        this.mailTo = mailTo;
        this.mailCc = mailCc;
        this.mailBcc = mailBcc;
        this.mailSubject = mailSubject;
        this.mailContent = mailContent;
        this.contentType = contentType;
        this.attachments = attachments;
    }

    public String getMailFrom() {
        return this.mailFrom;
    }

    public void setMailFrom(String mailFrom) {
        this.mailFrom = mailFrom;
    }

    public String getMailTo() {
        return this.mailTo;
    }

    public void setMailTo(String mailTo) {
        this.mailTo = mailTo;
    }

    public String getMailCc() {
        return this.mailCc;
    }

    public void setMailCc(String mailCc) {
        this.mailCc = mailCc;
    }

    public String getMailBcc() {
        return this.mailBcc;
    }

    public void setMailBcc(String mailBcc) {
        this.mailBcc = mailBcc;
    }

    public String getMailSubject() {
        return this.mailSubject;
    }

    public void setMailSubject(String mailSubject) {
        this.mailSubject = mailSubject;
    }

    public String getMailContent() {
        return this.mailContent;
    }

    public void setMailContent(String mailContent) {
        this.mailContent = mailContent;
    }

    public String getContentType() {
        return this.contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public List<Object> getAttachments() {
        return this.attachments;
    }

    public void setAttachments(List<Object> attachments) {
        this.attachments = attachments;
    }

    public Mail mailFrom(String mailFrom) {
        setMailFrom(mailFrom);
        return this;
    }

    public Mail mailTo(String mailTo) {
        setMailTo(mailTo);
        return this;
    }

    public Mail mailCc(String mailCc) {
        setMailCc(mailCc);
        return this;
    }

    public Mail mailBcc(String mailBcc) {
        setMailBcc(mailBcc);
        return this;
    }

    public Mail mailSubject(String mailSubject) {
        setMailSubject(mailSubject);
        return this;
    }

    public Mail mailContent(String mailContent) {
        setMailContent(mailContent);
        return this;
    }

    public Mail contentType(String contentType) {
        setContentType(contentType);
        return this;
    }

    public Mail attachments(List<Object> attachments) {
        setAttachments(attachments);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Mail)) {
            return false;
        }
        Mail mail = (Mail) o;
        return Objects.equals(mailFrom, mail.mailFrom) && Objects.equals(mailTo, mail.mailTo) && Objects.equals(mailCc, mail.mailCc) && Objects.equals(mailBcc, mail.mailBcc) && Objects.equals(mailSubject, mail.mailSubject) && Objects.equals(mailContent, mail.mailContent) && Objects.equals(contentType, mail.contentType) && Objects.equals(attachments, mail.attachments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mailFrom, mailTo, mailCc, mailBcc, mailSubject, mailContent, contentType, attachments);
    }

    @Override
    public String toString() {
        return "{" +
            " mailFrom='" + getMailFrom() + "'" +
            ", mailTo='" + getMailTo() + "'" +
            ", mailCc='" + getMailCc() + "'" +
            ", mailBcc='" + getMailBcc() + "'" +
            ", mailSubject='" + getMailSubject() + "'" +
            ", mailContent='" + getMailContent() + "'" +
            ", contentType='" + getContentType() + "'" +
            ", attachments='" + getAttachments() + "'" +
            "}";
    }
    
    public Date getMailSendDate() {
        return new Date();
    }
}