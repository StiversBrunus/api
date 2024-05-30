package br.com.redventures.ramengo.api.order.request;

import br.com.redventures.ramengo.api.BaseController;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderRequestController extends BaseController {

    @PostMapping
    public String open (@RequestHeader(name = "x-api-key") String tokenAuthentication,  @RequestBody OrderRequestForm orderRequestForm) throws OrderRequestForm.ValidationException {

        // I use the form information
        // Injection token of the header on form with another information
        OrderRequestForm form = new OrderRequestForm(tokenAuthentication, orderRequestForm.getBrothId(), orderRequestForm.getProteinId());
        form.setOrder(true);

        BaseController baseController = new BaseController();
        baseController.auth(form);

        return "Open Order Request!!!";
    }
}
