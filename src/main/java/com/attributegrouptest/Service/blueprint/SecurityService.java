package com.attributegrouptest.Service.blueprint;

/**
 * Created by Noobs on 05/09/2016.
 */
public interface SecurityService {

    String findLoggedInUser();

    void autoLogin(String username,String password);
}
