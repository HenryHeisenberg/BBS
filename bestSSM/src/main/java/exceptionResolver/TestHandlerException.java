package exceptionResolver;

import data.Result;

import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.UnauthenticatedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * TestHandlerException
 * 测试权限控制处理，当其他地方抛出权限不足的错误时，会进入此方法，返回“重定向到登录页面”的response
 */
@ControllerAdvice
@ResponseBody
public class TestHandlerException{

    @ResponseStatus(HttpStatus.FOUND)
    @ExceptionHandler(UnauthenticatedException.class)
    public Result UnauthenticatedExceptionHandler(HttpServletResponse response){
        response.setHeader("location", "login.html");
        return new Result("对不起权限不够,请先登录",null);
    }
    
}