package br.com.redventures.ramengo.api;

import br.com.redventures.ramengo.api.broth.Broth;
import br.com.redventures.ramengo.api.broth.BrothApplicationService;
import br.com.redventures.ramengo.api.order.request.OrderRequestForm;
import br.com.redventures.ramengo.api.protein.Protein;
import br.com.redventures.ramengo.api.protein.ProteinApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Component
public class BaseController {

    @Autowired
    private BrothApplicationService brothApplicationService;

    @Autowired
    private ProteinApplicationService proteinApplicationService;

    public List<Broth> brothList () {
        return brothApplicationService.getAllBroth();
    }

    public List<Protein> proteinList (){
        return proteinApplicationService.getAllProtein();
    }

    public void auth (OrderRequestForm form) throws OrderRequestForm.ValidationException {
        try {
            form.validate();
        } catch (OrderRequestForm.ValidationException ex) {
            throw new BaseController.ForbiddenException(ex.getMessage());
        }
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    public static class ForbiddenException extends RuntimeException {
        public ForbiddenException(String message) {
            super(message);
        }
    }
}

