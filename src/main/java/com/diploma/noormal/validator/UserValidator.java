package com.diploma.noormal.validator;

import com.diploma.noormal.model.User;
import com.diploma.noormal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import static com.diploma.noormal.util.Constants.ValidatorConstants.DIFF_USER_FORM_PASSWORD_CONFIRM;
import static com.diploma.noormal.util.Constants.ValidatorConstants.DUPLICATE_USER_FORM_USERNAME;
import static com.diploma.noormal.util.Constants.ValidatorConstants.NOT_EMPTY;
import static com.diploma.noormal.util.Constants.ValidatorConstants.PASSWORD;
import static com.diploma.noormal.util.Constants.ValidatorConstants.PASSWORD_CONFIRM;
import static com.diploma.noormal.util.Constants.ValidatorConstants.SIZE_USER_FORM_PASSWORD;
import static com.diploma.noormal.util.Constants.ValidatorConstants.SIZE_USER_FORM_USERNAME;
import static com.diploma.noormal.util.Constants.ValidatorConstants.USERNAME;

/**
 * @author Arsalan. Created on 17.04.2017.
 */
@Component
public class UserValidator implements Validator {

    private UserService userService;

    @Autowired
    public UserValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, USERNAME, NOT_EMPTY);
        if (user.getUsername().length() < 1 || user.getUsername().length() > 32) {
            errors.rejectValue(USERNAME, SIZE_USER_FORM_USERNAME);
        }
        if (userService.findByUsername(user.getUsername()) != null) {
            errors.rejectValue(USERNAME, DUPLICATE_USER_FORM_USERNAME);
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, PASSWORD, NOT_EMPTY);
        if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
            errors.rejectValue(PASSWORD, SIZE_USER_FORM_PASSWORD);
        }

        if (!user.getPasswordConfirm().equals(user.getPassword())) {
            errors.rejectValue(PASSWORD_CONFIRM, DIFF_USER_FORM_PASSWORD_CONFIRM);
        }
    }
}
