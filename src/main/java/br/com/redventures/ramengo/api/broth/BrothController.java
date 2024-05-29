package br.com.redventures.ramengo.api.broth;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/broth")
public class BrothController {

    @GetMapping()
    public String open () {
        return "Open broth!!!";
    }
}
