package com.aop;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.util.JsonUtil;

@Component
@Aspect
public class LogAop {

	@Pointcut("@annotation(com.annotation.ControllerLogAnnotation)")
	public void pointCut(){}
	
	@Before("pointCut()")  
    public void before(JoinPoint joinPoint) throws Exception {  
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
    	String uri = request.getRequestURI();
    	Map<String,Object> map = getFieldsNameValueMap(joinPoint);
    	Logger logger = LoggerFactory.getLogger(joinPoint.getTarget().getClass());
    	
    	HashMap<String, Object> inputParam = new HashMap<String, Object>();
    	inputParam.put("uri", uri);
    	inputParam.put("RequestBody", map);
    	logger.info(JsonUtil.objectToJson(inputParam));
    }
	
	private Map<String,Object> getFieldsNameValueMap(JoinPoint joinPoint) throws Exception {   
		Signature signature = joinPoint.getSignature();  
		MethodSignature methodSignature = (MethodSignature) signature;  
		String[] parameters = methodSignature.getParameterNames(); 
		
		Object[] args = joinPoint.getArgs();
		
		Map<String,Object> map = new HashMap<String, Object>();
		for(int i=0; i<args.length; i++){
			map.put(parameters[i], args[i]);
		}
		return map;
    }
	
}
