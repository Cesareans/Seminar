package seminar.service;

/**
 * @author Cesare
 */
public interface StudentService {

    /**
     * Modify a student's password when he/she forget his/her password
     *
     * @param sn       the student num
     * @param password the new password
     * @return whether the operation is success
     * @author cesare
     */
    boolean modifyPasswordViaSn(String sn, String password);
}
