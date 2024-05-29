package br.com.redventures.ramengo.api;

import br.com.redventures.ramengo.api.order.request.OrderRequestForm;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class BaseController {

    public void auth (OrderRequestForm form) throws OrderRequestForm.ValidationException {
        try {
            form.validate();
        } catch (OrderRequestForm.ValidationException ex) {
            throw new BaseController.ForbiddenException(ex.getMessage());
        }
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    public static class ForbiddenException extends RuntimeException {
        public ForbiddenException(String message) {
            super(message);
        }
    }
}

