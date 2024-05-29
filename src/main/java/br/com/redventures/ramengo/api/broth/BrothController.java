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
public class BrothController extends BaseController {

    @Autowired
    private BrothApplicationService brothApplicationService;
    @GetMapping()
    public List<Broth> open (@RequestHeader String tokenAuthentication) throws OrderRequestForm.ValidationException {

        OrderRequestForm form = new OrderRequestForm(tokenAuthentication);
        BaseController baseController = new BaseController();
        baseController.auth(form);

        return this.listBroths();
    }

    @GetMapping("/list")
    public List<Broth> listBroths () {

        return brothApplicationService.getAllBroth();
    }
}
