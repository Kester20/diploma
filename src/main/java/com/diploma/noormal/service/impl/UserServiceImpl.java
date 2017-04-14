package com.diploma.noormal.service.impl;

import com.diploma.noormal.exceptions.BusinessException;
import com.diploma.noormal.model.Users;
import com.diploma.noormal.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author Arsalan. Created on 14.04.2017.
 */
@Service
public class UserServiceImpl implements UserService {

    @Override
    public void createUser(Users user) throws BusinessException {

    }

    @Override
    public boolean checkIfExistUser(String email) {
        return false;
    }

    @Override
    public boolean logInUser(String email, String password) {
        return false;
    }

    @Override
    public Users getUserByEmailAndPassword(String email, String password) {
        return null;
    }

    @Override
    public void incrementUserFailedLogin(String email) {

    }

    @Override
    public void clearUserFailedLogin(String email) {

    }

    @Override
    public boolean checkUserHasBan(String email) {
        return false;
    }

    @Override
    public void clearBanAfterHalfAnHour(String email) {

    }
}
