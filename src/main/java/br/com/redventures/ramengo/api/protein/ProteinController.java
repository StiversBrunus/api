package br.com.redventures.ramengo.api.protein;

import br.com.redventures.ramengo.api.BaseController;
import br.com.redventures.ramengo.api.order.request.OrderRequestForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/proteins")
public class ProteinController {

    private final BaseController baseController;

    @Autowired
    public ProteinController(BaseController baseController) {
        this.baseController = baseController;
    }
    @GetMapping
    public List<Protein> open (@RequestHeader(name = "x-api-key") String tokenAuthentication) throws OrderRequestForm.ValidationException {

        OrderRequestForm form = new OrderRequestForm(tokenAuthentication);
        baseController.auth(form);

        return baseController.proteinList();
    }

    @GetMapping("/list")
    public List<Protein> getProteins () {
        return baseController.proteinList();
    }
}
