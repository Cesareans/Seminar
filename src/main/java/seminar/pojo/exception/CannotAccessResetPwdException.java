package seminar.pojo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Cesare
 */
@ResponseStatus(value = HttpStatus.FORBIDDEN)
public class CannotAccessResetPwdException extends RuntimeException {
}
