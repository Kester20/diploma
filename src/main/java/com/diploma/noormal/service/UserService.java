package com.diploma.noormal.service;

import com.diploma.noormal.exceptions.BusinessException;
import com.diploma.noormal.model.Users;

/**
 * @author Arsalan. Created on 14.04.2017.
 */
public interface UserService {

    void createUser(Users user) throws BusinessException;

    boolean checkIfExistUser(String email);

    boolean logInUser(String email, String password);

    Users getUserByEmailAndPassword(String email, String password);

    void incrementUserFailedLogin(String email);

    void clearUserFailedLogin(String email);

    boolean checkUserHasBan(String email);

    void clearBanAfterHalfAnHour(String email);


}
