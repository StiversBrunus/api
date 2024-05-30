package br.com.redventures.ramengo.api.broth;

import br.com.redventures.ramengo.api.BaseController;
import br.com.redventures.ramengo.api.order.request.OrderRequestForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/broths")
public class BrothController extends BaseController {

    @Autowired
    private BrothApplicationService brothApplicationService;
    @GetMapping()
    public List<Broth> open (@RequestHeader(name = "x-api-key") String tokenAuthentication) throws OrderRequestForm.ValidationException {

        OrderRequestForm form = new OrderRequestForm(tokenAuthentication);
        BaseController baseController = new BaseController();
        baseController.auth(form);

        return brothApplicationService.getAllBroth();
    }
}
