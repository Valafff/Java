package org.top.airportdirectoryapp.api.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.top.airportdirectoryapp.api.message.CommonApiMessages.ErrorMessage;

@RestController
public class ApplicationErrorController implements ErrorController {

    @RequestMapping("/error")
    public ErrorMessage handleError(HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        Object message = request.getAttribute(RequestDispatcher.ERROR_EXCEPTION);
        if (message == null || message.toString().isEmpty()) {
            message = request.getAttribute(RequestDispatcher.ERROR_MESSAGE);
        }
        if (status == null) {
            status = "200";
        }
        return new ErrorMessage(status.toString(), message.toString());
    }
}
