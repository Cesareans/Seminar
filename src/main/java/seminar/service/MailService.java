package seminar.service;

/**
 * @author Cesare
 */

public interface MailService {
    /**
     * Send a captcha to targetEmail
     *
     * @param captcha     the sending captcha
     * @param targetEmail the target user's email
     * @author cesare
     */
    public void sendCaptcha(String captcha, String targetEmail);

    /**
     * Send a email with content as text to target email.
     *
     * @param content     the sending content
     * @param targetEmail the target user's email
     * @author cesare
     */
    public void sendMail(String content, String targetEmail);
}
