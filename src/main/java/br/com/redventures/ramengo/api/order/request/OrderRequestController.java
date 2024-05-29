package br.com.redventures.ramengo.api.order.request;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orderRequest")
public class OrderRequestController {

    @GetMapping
    public String open () {

        return "Open Order Request!!!";
    }
}
