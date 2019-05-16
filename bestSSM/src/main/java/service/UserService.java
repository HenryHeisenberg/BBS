package service;

import org.springframework.stereotype.Service;

import data.User;

/**
 * UserService
 */
@Service
public interface UserService {

    /**
     * 用户登陆
     * 
     * @param username
     * @param password
     * @return
     */
    boolean login(String username, String password);

    /**
     * 用户注册
     * 
     * @param user
     * @return
     */
    boolean register(User user);

    /**
     * 根据用户邮箱查询用户
     * 
     * @param email
     * @return
     */
    User findByEmail(String email);

    /**
     * 根据用户邮箱删除用户
     * 
     * @param email
     */
    void deleteByEmail(String email);

    /**
     * 查找此用户id的权限
     * 
     * @param id
     * @return
     */
    Integer findRoleByUserId(Long id);

    /**
     * 通过邮箱修改密码
     * 
     * @param email
     */
    void updatePasswordByEmail(String email);

    /**
     * 通过旧密码修改新密码
     * 
     * @param password
     */
    void updatePasswordByOldPassword(String password);
}