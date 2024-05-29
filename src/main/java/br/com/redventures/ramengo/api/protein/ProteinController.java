package br.com.redventures.ramengo.api.protein;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/protein")
public class ProteinController {

    @GetMapping
    public String open (){
        return "Open protein!!!";
    }
}
