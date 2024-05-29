package br.com.redventures.ramengo.api.order.request;

import br.com.redventures.ramengo.api.BaseController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderRequestController extends BaseController {

    @GetMapping
    public String open (@RequestHeader(name = "x-api-key") String tokenAuthentication) throws OrderRequestForm.ValidationException {

        OrderRequestForm form = new OrderRequestForm(tokenAuthentication);
        BaseController baseController = new BaseController();
        baseController.auth(form);

        return "Open Order Request!!!";
    }
}
