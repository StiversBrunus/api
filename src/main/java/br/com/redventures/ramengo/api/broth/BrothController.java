package br.com.redventures.ramengo.api.broth;

import br.com.redventures.ramengo.api.BaseController;
import br.com.redventures.ramengo.api.order.request.OrderRequestForm;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/broths")
public class BrothController {

    private final BaseController baseController;

    @Autowired
    public BrothController(BaseController baseController) {
        this.baseController = baseController;
    }
    @GetMapping()
    public List<Broth> open (@RequestHeader(name = "x-api-key") String tokenAuthentication) throws OrderRequestForm.ValidationException {

        OrderRequestForm form = new OrderRequestForm(tokenAuthentication);
        baseController.auth(form);

        return baseController.brothList();
    }

    @GetMapping("/list")
    public List<Broth> listBroths () {
        return baseController.brothList();
    }
}
