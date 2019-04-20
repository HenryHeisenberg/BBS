package service;


import java.time.Duration;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import data.User;
import mapper.UserMapper;

public class MyRealm extends AuthorizingRealm {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisTemplate<String, Integer> redis;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = (String) principals.getPrimaryPrincipal();
        byte role = userMapper.selectByPrimaryKey(username).getRole();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addRole(String.valueOf(role));
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        String username = usernamePasswordToken.getUsername();
        User user = userMapper.selectByPrimaryKey(username);

        if (user==null) {
            throw new UnknownAccountException();
        }
        //短时间内登录次数限制五次
        if(!this.loginLimit(username)){
            throw new ExcessiveAttemptsException();
        }
        
        //如果用户是黑名单用户，3代表黑名单
        if(user.getRole()==3){
            throw new DisabledAccountException();
        }

        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username, user.getPassword(), ByteSource.Util.bytes(user.getSalt()), this.getName());
        return info;
    }

    /**
     * 
     * @return 未限制返回true，限制返回false
     */
    private boolean loginLimit(String username){
        String key = "login:"+username;
        Integer times = redis.opsForValue().get("login:"+username);
        if(times==null){
            redis.opsForValue().set(key,0,Duration.ofMinutes(30));
            return true;
        }else{
            times++;
            redis.opsForValue().set(key, times, Duration.ofMinutes(30));
        }

        if(times>5){
            return false;
        }
        
        return true;
    }

}