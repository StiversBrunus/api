package br.com.redventures.ramengo.api.order.request;

import br.com.redventures.ramengo.api.infra.Security;
import br.com.redventures.ramengo.api.validation.ValidationException;
import io.micrometer.common.util.StringUtils;

public class OrderRequestItemForm {

    private String brothId;
    private String proteinId;

    private boolean isOrder = false;


    public OrderRequestItemForm() {
    }

    public OrderRequestItemForm(String brothId, String proteinId, boolean isOrder) {
        this.brothId = brothId;
        this.proteinId = proteinId;
        this.isOrder = isOrder;
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

    public void validate () throws ValidationException {

        // if order request be an order, so validate required fields
        if (this.isOrder() && (StringUtils.isBlank(this.getBrothId()) || StringUtils.isBlank(this.getProteinId()))) {
            throw new ValidationException("both brothId and proteinId are required");
        }
    }
}
