package seminar.service;

/**
 * @author Cesare
 */
public interface CaptchaService {
    /**
     * Generate random digit captcha for verification which length should be 6;
     * @return a random captcha with 6 digits.
     */
    public String generateCaptcha();
}
