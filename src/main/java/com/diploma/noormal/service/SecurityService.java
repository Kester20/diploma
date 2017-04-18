package com.diploma.noormal.service;

/**
 * @author Arsalan. Created on 17.04.2017.
 */
public interface SecurityService {

    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
