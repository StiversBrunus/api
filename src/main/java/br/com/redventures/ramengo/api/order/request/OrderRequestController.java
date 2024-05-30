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

        System.out.println("Como essa informação chega aqui >>> " + orderRequestForm);

        // I use the form information
        // Inject into the form the token that comes from the header together with order parameters
        // Say that this orderRequest isn't just authentication, but an order too.
        OrderRequestForm form = new OrderRequestForm(orderRequestForm.getBrothId(), orderRequestForm.getProteinId(), true, tokenAuthentication, null);

        // Call BaseController for do request authentication
        BaseController baseController = new BaseController();

        // How it's an order too, it will validate required fields
        baseController.auth(form);

        // It passes form for build and get the order
        OrderRequest order = orderRequestApplicationService.order(form);

        return ResponseEntity.status(HttpStatus.CREATED).body(order) ;
    }
}
