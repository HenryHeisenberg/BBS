package controller;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



import data.Result;
import service.EmailService;

/**
 * EmailCode
 */
@Controller
public class EmailCode {

    @Autowired
    private EmailService emailService;

    @Autowired
    private RedisTemplate<String,String> redis;


    @ResponseBody
    @RequestMapping("/email")
    public Result getEmailCode(String toEmail) {
        String code = this.gennerateCode();
        String message = "注册验证码:"+code+",有效期五分钟。";
        try {
            emailService.sendSimpleMail(toEmail, "注册验证码", message);
            redis.opsForValue().set("code:"+toEmail, code, Duration.ofMinutes(5));
        } catch (Exception e) {
            System.out.println("邮箱验证码发送错误");
            e.printStackTrace();
        }
        return new Result("已经发送邮件，注意查收",null);
    }

    /**
     * 生成验证码
     */
    private String gennerateCode(){
        int tmp =(int)((Math.random()*9+1)*100000);
        String code = String.valueOf(tmp);
        return code;
    }

    

}