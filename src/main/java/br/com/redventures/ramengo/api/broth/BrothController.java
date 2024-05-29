package br.com.redventures.ramengo.api.broth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/broths")
public class BrothController {

    @Autowired
    private BrothApplicationService brothApplicationService;
    @GetMapping()
    public String open () {

        return "Open broth!!!";
    }

    @GetMapping("/list")
    public List<Broth> listBroths () {

        return brothApplicationService.getAllBroth();
    }
}
