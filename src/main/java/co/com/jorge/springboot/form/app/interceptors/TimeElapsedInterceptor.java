package co.com.jorge.springboot.form.app.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.Random;

@Component("timeElapsedInterceptor")
public class TimeElapsedInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(TimeElapsedInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("TimeElapsed: preHandle() entrando....");

        if (request.getMethod().equalsIgnoreCase("POST")){
            return true;
        }

        long timeStart = System.currentTimeMillis();

        request.setAttribute("timeStart", timeStart);

        Random random = new Random();
        Integer delay = random.nextInt(100);

        Thread.sleep(delay);

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        if (request.getMethod().equalsIgnoreCase("POST")){
            return;
        }

        long timeEnd = System.currentTimeMillis();
        long timeStart = (Long) request.getAttribute("timeStart");
        long timeElapsed = timeEnd - timeStart;

        if (modelAndView != null){
            modelAndView.addObject("timeElapsed", timeElapsed);
        }

        logger.info("TimeElapsed: " + timeElapsed + " milisegundos");
        logger.info("TimeElapsed: postHandle() saliendo....");

    }
}
