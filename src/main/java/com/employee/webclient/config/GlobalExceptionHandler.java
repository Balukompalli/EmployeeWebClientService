package com.employee.webclient.config;


import lombok.extern.log4j.Log4j;
import org.springframework.boot.context.config.InactiveConfigDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.reactive.function.client.WebClientRequestException;

import java.util.logging.Logger;

@ControllerAdvice
public class GlobalExceptionHandler {

    Logger logger = Logger.getLogger(String.valueOf(GlobalExceptionHandler.class));

    @ExceptionHandler(WebClientRequestException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String  handleInternalServerException(WebClientRequestException webClientRequestException) {
        logger.info(webClientRequestException.getLocalizedMessage());
        return "Server not up & running";
    }

    @ExceptionHandler(InactiveConfigDataAccessException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String  handleDataBaseServerException(InactiveConfigDataAccessException inactiveConfigDataAccessException) {
        logger.info(inactiveConfigDataAccessException.getLocalizedMessage());
        return "Database is not up & running";
    }

}
