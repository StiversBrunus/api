package br.com.redventures.ramengo.api;

import br.com.redventures.ramengo.api.order.request.OrderRequestForm;
import br.com.redventures.ramengo.api.validation.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class BaseController {
    public void auth (OrderRequestForm form) throws ValidationException {
        try {
            form.validate();
        } catch (ValidationException ex) {

            if (ex.getMessage().contains("x-api-key header")){
                throw new BaseController.ForbiddenException(ex.getMessage());
            } else if (ex.getMessage().contains("are required")){
                throw  new BaseController.BadRequestException(ex.getMessage());
            }

            // if message is unknown, so throw Internal Error Server
            throw new InternalServerErrorException("could not place order");
        }
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    public static class ForbiddenException extends RuntimeException {
        public ForbiddenException(String message) {
            super(message);
        }
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public static class BadRequestException extends RuntimeException {
        public BadRequestException(String message){
            super(message);
        }
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public static class InternalServerErrorException extends RuntimeException {
        public InternalServerErrorException(String message){
            super(message);
        }
    }
}

