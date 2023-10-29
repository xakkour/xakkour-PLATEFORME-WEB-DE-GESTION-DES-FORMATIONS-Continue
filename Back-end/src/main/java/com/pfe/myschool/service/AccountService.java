package com.pfe.myschool.service;

import com.pfe.myschool.model.User;

public interface AccountService {
    User addNewUser (String username ,String password ,String email ,String ConfirmPassword,String role);

}
