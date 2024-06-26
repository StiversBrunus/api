package br.com.redventures.ramengo.api.protein;

import br.com.redventures.ramengo.api.BaseController;
import br.com.redventures.ramengo.api.order.request.OrderRequestForm;
import br.com.redventures.ramengo.api.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/proteins")
public class ProteinController extends BaseController {

    @Autowired
    private ProteinApplicationService proteinApplicationService;
    @GetMapping
    public List<Protein> open (@RequestHeader(name = "x-api-key") String tokenAuthentication) throws ValidationException {

        // Create a new form and pass the header token as a constructor parameter
        OrderRequestForm form = new OrderRequestForm(tokenAuthentication);

        // Call BaseController for do request authentication
        BaseController baseController = new BaseController();
        baseController.auth(form);

        return proteinApplicationService.getAllProtein();
    }
}
