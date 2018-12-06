package seminar.service;

/**
 * @author Cesare
 */

public interface MailService {
    /**
     * Send a captcha to targetEmail
     * @author cesare
     * @param captcha the sending captcha
     * @param targetEmail the target user's email
     */
    public void sendCaptcha(String captcha, String targetEmail);

    /**
     * Send a email with content as text to target email.
     * @author cesare
     * @param content the sending content
     * @param targetEmail the target user's email
     */
    public void sendMail(String content, String targetEmail);
}
