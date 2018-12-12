package seminar.service;

import seminar.entity.Team;

/**
 * @author Cesare
 */
public interface StudentService {

    /**
     * Modify a student's password when he/she forget his/her password
     *
     * @author cesare
     * @param sn       the student num
     * @param password the new password
     * @return whether the operation is success
     */
    boolean modifyPasswordViaSn(String sn, String password);
}
