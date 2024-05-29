package br.com.redventures.ramengo.api.broth;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrothApplicationService {

    public List<Broth> getAllBroth () {

        return BrothDataStore.BROTH_LIST;
    }
}
