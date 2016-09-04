package com.attributegrouptest.Service.blueprint;

import com.attributegrouptest.Domain.User;

/**
 * Created by Noobs on 05/09/2016.
 */
public interface UserService {
    void save(User user);
    User findByUsername(String username);
}
