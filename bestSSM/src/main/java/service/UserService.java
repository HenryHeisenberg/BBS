package service;

import org.springframework.stereotype.Service;

import data.User;

/**
 * UserService
 */
@Service
public class UserService {

    public boolean login(String username, String password){
        if(username==null || password==null){
            return false;
        }
        //TODO
        return false;
    }

    public boolean register(User user){
        return false;
    }
}