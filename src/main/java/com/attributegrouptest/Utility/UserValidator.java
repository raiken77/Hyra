package com.attributegrouptest.Utility;

import com.attributegrouptest.Domain.User;
import com.attributegrouptest.Service.blueprint.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by Noobs on 05/09/2016.
 */
@Component
public class UserValidator implements Validator {

    private UserService userService;

    @Autowired
    public UserValidator(UserService userService) {
        this.userService = userService;
    }


    @Override
    public boolean supports(Class<?> customClass) {
        return User.class.equals(customClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

        User user = (User) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"username","NotEmpty");

        if(user.getUsername().length() < 6 || user.getUsername().length() > 32)
        {
            errors.rejectValue("username","userForm.username.Size");
        }

        if(userService.findByUsername(user.getUsername()) != null)
        {
            errors.rejectValue("username","userForm.username.exists");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"password","NotEmpty");

        if(user.getPassword().length() < 8)
        {
            errors.rejectValue("password","userForm.password.Size");
        }

        if(!user.getPasswordConfirm().equals(user.getPassword()))
        {
            errors.rejectValue("passwordConfirm","userForm.passwordConfirm.same");
        }



    }
}
