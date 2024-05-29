package br.com.redventures.ramengo.api.order.request;

import br.com.redventures.ramengo.api.BaseController;
import br.com.redventures.ramengo.api.infra.Security;
import io.micrometer.common.util.StringUtils;

public class OrderRequestForm {

    /*************
     * FIELDS
     *********/
    String token;

    /***************
     * BUILDERS
     ***********/
    public OrderRequestForm (String token){
        this.token = token;
    }

    /*************
     * METHODS
     **********/
    public void validate () throws ValidationException {

        if (StringUtils.isBlank(this.getToken())){
            throw new ValidationException("x-api-key header missing");
        }

        if (!Security.AUTH_TOKEN.equals(this.getToken())){
            throw new ValidationException("x-api-key header invalid");
        }
    }

    public static class ValidationException extends Exception {
        public ValidationException(String message) {
            super(message);
        }
    }

    /*******************
     * GETS AND SETS
     ****************/
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
