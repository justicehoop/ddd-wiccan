package com.woowahan.wiccan.global.exception.handler;

/**
 * Created by justicehoop on 2016. 8. 11..
 */

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Throwables;
import com.woowahan.wiccan.commons.ex.LockedAccountException;
import com.woowahan.wiccan.commons.ex.ResourceNotFoundException;
import com.woowahan.wiccan.delivery.ex.UnableAccessDeliveryException;
import com.woowahan.wiccan.delivery.ex.UnableAllocateRiderException;
import com.woowahan.wiccan.delivery.ex.UnableCreateDeliveryException;
import com.woowahan.wiccan.delivery.ex.UnableMaxLimitSearchDateException;
import com.woowahan.wiccan.legacyadapter.ex.EatoutOrderProcessException;
import com.woowahan.wiccan.legacyadapter.ex.UnableOrderZzimException;
import com.woowahan.wiccan.management.ex.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;

import javax.naming.NoPermissionException;
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

    @ExceptionHandler({EatoutOrderProcessException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorMessage handleEatoutOrderProcessException(EatoutOrderProcessException ex) {
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.BAD_REQUEST.name(), ex.getMessage(), ex);
        return errorMessage;
    }

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

    @ExceptionHandler(UnableAllocateRiderException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorMessage handleUnableAllocatedRiderException(Exception ex) {
        UnableAllocateRiderException riderException = (UnableAllocateRiderException) ex;
        ErrorMessage errorMessage = new ErrorMessage(riderException.getAllocatedFailedResult().name(), riderException.getMessage(), ex);
        return errorMessage;
    }


    @ExceptionHandler(DuplicatedUserIdExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorMessage handleDuplicatedUserIdExistsException(Exception ex) {
        DuplicatedUserIdExistsException ex_ = (DuplicatedUserIdExistsException) ex;
        ErrorMessage errorMessage = new ErrorMessage(ex_.CODE, ex.getMessage(), ex);
        return errorMessage;
    }

    @ExceptionHandler(DuplicatedAgencyExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorMessage handleDuplicatedAgencyExistsException(Exception ex) {
        DuplicatedAgencyExistsException ex_ = (DuplicatedAgencyExistsException) ex;
        ErrorMessage errorMessage = new ErrorMessage(ex_.CODE, ex.getMessage(), ex);
        return errorMessage;
    }

    @ExceptionHandler(UnableMaxLimitSearchDateException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorMessage handleUnableDeliveryFeeListSearchForRiderRequestException(Exception ex) {
        UnableMaxLimitSearchDateException ex_ = (UnableMaxLimitSearchDateException) ex;
        ErrorMessage errorMessage = new ErrorMessage(ex_.CODE, ex.getMessage(), ex);
        return errorMessage;
    }

    @ExceptionHandler(InvalidPasswordBaeminzAccountException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorMessage handleInvalidPasswordBaeminzAccountException(Exception ex) {
        InvalidPasswordBaeminzAccountException ex_ = (InvalidPasswordBaeminzAccountException) ex;
        ErrorMessage errorMessage = new ErrorMessage(ex_.CODE, ex.getMessage(), ex);
        return errorMessage;
    }

    @ExceptionHandler(NewPasswordBaeminzAccountException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorMessage handleNewPasswordBaeminzAccountException(Exception ex) {
        NewPasswordBaeminzAccountException ex_ = (NewPasswordBaeminzAccountException) ex;
        ErrorMessage errorMessage = new ErrorMessage(ex_.CODE, ex.getMessage(), ex);
        return errorMessage;
    }

    @ExceptionHandler(RiderAccountStatusBlockException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorMessage handleRiderAccountStatusBlockException(Exception ex) {
        RiderAccountStatusBlockException ex_ = (RiderAccountStatusBlockException) ex;
        ErrorMessage errorMessage = new ErrorMessage(ex_.CODE, ex.getMessage(), ex);
        return errorMessage;
    }

    @ExceptionHandler(UnableCreateDeliveryException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorMessage handleUnableCreateDeliveryException(Exception ex) {
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.BAD_REQUEST.name(), ex.getMessage(), ex);
        return errorMessage;
    }

    @ExceptionHandler(BadCredentialsException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public ErrorMessage handleBadCredentialsException(Exception ex) {
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.UNAUTHORIZED.name(), ex.getMessage(), ex);
        return errorMessage;
    }

    @ExceptionHandler(LockedAccountException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public ErrorMessage handleLockedRiderAccountException(Exception ex) {
        ErrorMessage errorMessage = new ErrorMessage("LOCKED_RIDER_ACCOUNT", ex.getMessage(), ex);
        return errorMessage;
    }

    @ExceptionHandler({NoPermissionException.class, UnableAccessDeliveryException.class})
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ResponseBody
    public ErrorMessage handleForbiddenException(Exception ex) {
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.FORBIDDEN.name(), ex.getMessage(), ex);
        return errorMessage;
    }

    @ExceptionHandler(RiderStatusReadyException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorMessage handleRiderStatusReadyException(Exception ex) {
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.BAD_REQUEST.name(), ex.getMessage(), ex);
        return errorMessage;
    }

    @ExceptionHandler(UnableOrderZzimException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorMessage handleUnableOrderZzimException(UnableOrderZzimException ex) {
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.BAD_REQUEST.name(), ex.getMessage(), ex);
        return errorMessage;
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorMessage handleException(Exception ex) {
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR.name(), ex.getMessage(), ex);
        return errorMessage;
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorMessage handleRiderAccountEmptyException(RiderAccountEmptyException ex) {
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.NOT_FOUND.name(), ex.getMessage(), ex);
        return errorMessage;
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorMessage handleResourceNotFoundException(ResourceNotFoundException ex) {
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.NOT_FOUND.name(), ex.getMessage(), ex);
        return errorMessage;
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorMessage handleAgencyGroupDeleteDeniedException(AgencyGroupDeleteDeniedException ex) {
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.BAD_REQUEST.name(), ex.getMessage(), ex);
        return errorMessage;
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
            this.detailedMsg = Throwables.getStackTraceAsString(t);

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