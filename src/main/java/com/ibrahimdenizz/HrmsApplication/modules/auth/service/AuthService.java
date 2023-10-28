package com.ibrahimdenizz.HrmsApplication.modules.auth.service;


import com.ibrahimdenizz.HrmsApplication.modules.auth.exception.AuthEmployeeNotExists;

public interface AuthService {

    String login(String username, String password) throws AuthEmployeeNotExists;

    void updatePassword(String id, String newPassword);

}
