package com.attributegrouptest.Service.impl;

import com.attributegrouptest.Domain.Repository.RoleRepository;
import com.attributegrouptest.Domain.Repository.UserRepository;
import com.attributegrouptest.Domain.Role;
import com.attributegrouptest.Domain.User;
import com.attributegrouptest.Service.blueprint.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

/**
 * Created by Noobs on 05/09/2016.
 */
@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(populateSet(roleRepository.findAll()));
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User findById(Long id) {
        return this.userRepository.findOne(id);
    }

    @SuppressWarnings("unchecked")
    private HashSet<Role> populateSet(Iterable<Role> roles)
    {
        HashSet rolesSet = new HashSet<>();

        roles.forEach((Role role) ->
        {
            rolesSet.add(role);
        });

        return rolesSet;
    }
}
