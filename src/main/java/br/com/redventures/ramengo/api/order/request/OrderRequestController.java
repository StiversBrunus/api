package br.com.redventures.ramengo.api.order.request;

import br.com.redventures.ramengo.api.BaseController;
import br.com.redventures.ramengo.api.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/orders")
public class OrderRequestController extends BaseController {

    @Autowired
    private OrderRequestApplicationService orderRequestApplicationService;

    @PostMapping
    public ResponseEntity<OrderRequest> open (@RequestHeader(name = "x-api-key") String tokenAuthentication, @RequestBody OrderRequestForm orderRequestForm) throws ValidationException, IOException, InterruptedException {

        // I use the form information
        // Injection token of the header on form with another information
        OrderRequestForm form = new OrderRequestForm(tokenAuthentication, orderRequestForm.getBrothId(), orderRequestForm.getProteinId());
        form.setOrder(true);

        BaseController baseController = new BaseController();
        baseController.auth(form);

        OrderRequest order = orderRequestApplicationService.order(form);

        return ResponseEntity.status(HttpStatus.CREATED).body(order) ;
    }
}
