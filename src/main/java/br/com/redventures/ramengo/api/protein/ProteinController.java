package br.com.redventures.ramengo.api.protein;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/proteins")
public class ProteinController {

    @Autowired
    private ProteinApplicationService proteinApplicationService;
    @GetMapping
    public String open (){
        return "Open protein!!!";
    }

    @GetMapping("/list")
    public List<Protein> getProteins () {

        return proteinApplicationService.getAllProtein();
    }
}
