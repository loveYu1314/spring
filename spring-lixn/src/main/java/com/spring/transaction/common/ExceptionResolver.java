package com.spring.transaction.common;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Rubicon
 * @version v2.0
 * @date 2018/8/15 2:28
 * @desc 全局异常处理 bean 注解的目的是为了注入到 spring 容器当中
 */
@Component
public class ExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        ModelAndView modelAndView = new ModelAndView(new MappingJackson2JsonView());
        modelAndView.addObject("status", 1);
        modelAndView.addObject("msg", e.getMessage());
        modelAndView.addObject("data", e.toString());
        return modelAndView;
    }
}
