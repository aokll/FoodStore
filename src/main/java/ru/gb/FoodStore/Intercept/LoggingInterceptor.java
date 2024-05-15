package ru.gb.FoodStore.Intercept;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoggingInterceptor extends HandlerInterceptorAdapter {
    /**
     * регистрация URL каждого входящего запроса
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("RequestURL: " + request.getRequestURL().toString());
        return true;
    }

    /**
     * регистрация информации после обработки запроса
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("После обработки запроса"); ;
    }

    /**
     * регистрация информации после завершения обработки запроса
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("Запрос выполнен");
    }
}
