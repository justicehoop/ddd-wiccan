package com.woowahan.wiccan.global.exception.handler;

/**
 * Created by justicehoop on 2016. 8. 11..
 */

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 */
@Slf4j
@ControllerAdvice
public class GlobalControllerExceptionHandler {

    @Autowired
    private ObjectMapper objectMapper;


    @ExceptionHandler({ServletRequestBindingException.class, HttpMessageNotReadableException.class, IllegalStateException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorMessage handleBadRequestException(Exception ex) {
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.BAD_REQUEST.name(), ex.getMessage(), ex);
        return errorMessage;
    }

    @ExceptionHandler(HttpClientErrorException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorMessage handleRestClientException(HttpClientErrorException e) {
        Map<String,String> errorMsgMap = null;
        try {
            errorMsgMap = objectMapper.readValue(e.getResponseBodyAsString(), new TypeReference<HashMap<String, String>>() {
            });
        } catch (IOException ioe) {
            log.error("error occur during parse error message!",ioe);
            return new ErrorMessage("999", e.getResponseBodyAsString(), e);
        }
        return new ErrorMessage("999",errorMsgMap.get("message"), e);
    }

    public static class ErrorMessage {

        private static final String IS_DEBUG_PARAMETER_NAME = "debug";
        private static final String EMPTY_STRING = "";
        private String code;
        private String error;
        private String detailedMsg;


        public ErrorMessage(String code, String error, Throwable t) {
            this.code = code;
            this.error = error;
//            this.detailedMsg = Throwables.getStackTraceAsString(t);

        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getError() {
            return error;
        }

        public void setError(String error) {
            this.error = error;
        }

        public String getDetailedMsg() {
            return detailedMsg;
        }
    }

}