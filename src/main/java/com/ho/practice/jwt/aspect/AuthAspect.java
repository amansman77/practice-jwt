package com.ho.practice.jwt.aspect;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.ho.practice.jwt.exception.UnauthorizedException;
import com.ho.practice.jwt.util.JwtTokenUtil;

import io.jsonwebtoken.ExpiredJwtException;

@Aspect
@Component
public class AuthAspect {

	@Autowired
	JwtTokenUtil jwtTokenUtil;
	
	@Pointcut("within(@org.springframework.web.bind.annotation.RestController *)")
	public void restController() {
	}

	@Before("restController()")
	public void validateAuth(JoinPoint joinPoint) throws UnauthorizedException {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
	    String authorization = request.getHeader("Authorization");
	    if(authorization == null) {
	    	System.out.println("Authorization 필드 없음");
	    	return;
	    }
	    
	    String[] split = authorization.split(" ");
        String type = split[0];
        String credential = split[1];
        
        // 정보 추출??
        if ("Bearer".equalsIgnoreCase(type)) {
        	// 유효성 확인
        	try {
        		jwtTokenUtil.validateToken(credential);
            } catch (Exception e) {
            	String msg;
            	if(e instanceof ExpiredJwtException) {
            		msg = "기간이 만료됐습니다.";
            	} else {
            		msg = "유효하지 않은 토큰입니다.";
            	}
            	throw new UnauthorizedException(msg);
            }
        }
	}
	
}
