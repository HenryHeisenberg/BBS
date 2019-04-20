package controller;

import org.apache.logging.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

import mapper.UserMapper;
import data.Result;
import data.User;

/**
 * LoginAndRegister
 */
//@RestController
@Controller
public class LoginAndRegister {

    private static final Logger LOGGER = LogManager.getLogger(LoginAndRegister.class);

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisTemplate<String,String> redis;

    @ResponseBody
    @RequestMapping(value = "/login")
    public Result login(String username, String password, HttpServletResponse response){
        // TOOD 将密码解密
        LOGGER.debug("用户"+username+"---"+password+"进入到login");
        //User user =   userMapper.selectByPrimaryKey(username);
       // LOGGER.debug("获取到用户"+user);
        
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);

        try {
           // token.setRememberMe(true);
            subject.login(token);
        } catch(UnknownAccountException | IncorrectCredentialsException exception) {
            System.out.println("账号密码错误达瓦大");
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            return new Result("账号或密码错误", null);
        } catch(ExcessiveAttemptsException exception) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            return new Result("输入错误密码超过五次,账号锁定，请十分钟后再试试", null);
        } catch(DisabledAccountException exception){
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            return new Result("账号已经被拉入黑名单,请联系管理员解除黑名单",null);
        }
        catch (Exception e) {
            //TODO: handle exception
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            LOGGER.debug("登录失败");
            return new Result("登录失败", null);
        }
        
       
        return new Result("登录成功",null);
        
    }

    @ResponseBody
    @RequestMapping(value="/register")
    public Result register(String username, String password, String email, String code , HttpServletResponse response){
        User user = userMapper.selectByPrimaryKey(username);

        String realCode = redis.opsForValue().get("code:"+email);

        if (realCode==null || !realCode.equals(code)) {
            return new Result("验证码错误",null);
        }

        if (user!=null) {
          response.setStatus(HttpServletResponse.SC_CONFLICT);
          return new Result("账号已经存在",null);
        }else{
            String salt = new SecureRandomNumberGenerator().nextBytes(12).toHex();
            SimpleHash hash = new SimpleHash("md5", password, salt, 2);
           
            user = new User();
            user.setUserId(username);
            user.setPassword(hash.toHex());
            user.setEmail(email);
            user.setSalt(salt);
            
            //注册成功，插入用户，删除验证码
            userMapper.insertSelective(user);
            redis.delete("code:"+email);

            response.setStatus(HttpServletResponse.SC_OK);
            return new Result("注册成功", null);
        }
 
    }

    /**
     * @return the userMapper
     */
    public UserMapper getUserMapper() {
        return userMapper;
    }

    /**
     * @param userMapper the userMapper to set
     */
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    
}