package br.com.redventures.ramengo.api.order.request;

import br.com.redventures.ramengo.api.infra.Security;
import br.com.redventures.ramengo.api.validation.ValidationException;
import io.micrometer.common.util.StringUtils;

public class OrderRequestForm {

    /*************
     * FIELDS
     *********/

    String token;
    String brothId;
    String proteinId;
    private boolean isOrder = false;

    /***************
     * BUILDERS
     ***********/

    // This constructor is being used for auth get method
    public OrderRequestForm (String token){
        this.token = token;
    }

    // This constructor is being used for auth and build order of the post method
    public OrderRequestForm(String token, String brothId, String proteinId) {
        this.token = token;
        this.brothId = brothId;
        this.proteinId = proteinId;
    }

    /*************
     * METHODS
     **********/

    public void validate () throws ValidationException {

        if (StringUtils.isBlank(this.getToken())){
            throw new ValidationException("x-api-key header missing");
        }

        // if token isn't equals, return 'invalid token'
        if (!Security.AUTH_TOKEN.equals(this.getToken())){
            throw new ValidationException("x-api-key header invalid");
        }

        // if order request be an order, so validate required fields
        if (this.isOrder() && (StringUtils.isBlank(this.getBrothId()) || StringUtils.isBlank(this.getProteinId()))) {
            throw new ValidationException("both brothId and proteinId are required");
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

    public String getBrothId() {
        return brothId;
    }

    public void setBrothId(String brothId) {
        this.brothId = brothId;
    }

    public String getProteinId() {
        return proteinId;
    }

    public void setProteinId(String proteinId) {
        this.proteinId = proteinId;
    }

    public boolean isOrder() {
        return isOrder;
    }

    public void setOrder(boolean order) {
        isOrder = order;
    }
}
