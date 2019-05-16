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