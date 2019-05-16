package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import data.User;
import mapper.UserMapper;
import service.BaseService;
import service.UserService;

@Service
public class UserServiceImpl extends BaseService implements UserService {

    @Autowired
    private UserMapper userMapper;

    public boolean login(String username, String password) {
        if (username == null || password == null) {
            return false;
        }
        // TODO
        return false;
    }

    public boolean register(User user) {
        return false;
    }

    @Override
    public User findByEmail(String email) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deleteByEmail(String email) {
        // TODO Auto-generated method stub

    }

    @Override
    public Integer findRoleByUserId(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void updatePasswordByEmail(String email) {
        // TODO Auto-generated method stub

    }

    @Override
    public void updatePasswordByOldPassword(String password) {
        // TODO Auto-generated method stub

    }
}
