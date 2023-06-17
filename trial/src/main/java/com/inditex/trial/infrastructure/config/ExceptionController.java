package com.inditex.trial.infrastructure.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.NotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionController {
  @ExceptionHandler(Exception.class)
  public ModelAndView handleError(HttpServletRequest request, Exception e) {
    Logger.getLogger(getClass().getName())
        .log(Level.SEVERE, "Request: " + request.getRequestURL() + " raised " + e);
    return new ModelAndView("error");
  }

  @ExceptionHandler(NotFoundException.class)
  public ModelAndView handleError404(HttpServletRequest request, Exception e) {
    Logger.getLogger(getClass().getName())
        .log(Level.INFO, "Request: " + request.getRequestURL() + " raised " + e);
    return new ModelAndView("404");
  }
}
