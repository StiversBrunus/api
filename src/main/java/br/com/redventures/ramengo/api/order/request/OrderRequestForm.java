package br.com.redventures.ramengo.api.order.request;

import br.com.redventures.ramengo.api.infra.Security;
import br.com.redventures.ramengo.api.validation.ValidationException;
import io.micrometer.common.util.StringUtils;

import java.util.List;

public class OrderRequestForm extends  OrderRequestItemForm{

    /*************
     * FIELDS
     *********/

    String token;

    private List<OrderRequestItemForm> orderList;

    /***************
     * BUILDERS
     ***********/

    // This constructor is being used for auth get method
    // This constructor is being used for auth and build order of the post method
    public OrderRequestForm(String brothId, String proteinId, boolean isOrder, String token, List<OrderRequestItemForm> orderList) {
        super(brothId, proteinId, isOrder);
        this.token = token;
        this.orderList = orderList;
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

    @Override
    public String toString() {
        return "OrderRequestForm{" +
                "token='" + token + '\'' +
                ", orderList=" + orderList +
                '}';
    }
}
