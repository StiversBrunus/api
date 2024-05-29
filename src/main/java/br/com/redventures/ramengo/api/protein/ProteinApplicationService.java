package br.com.redventures.ramengo.api.protein;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProteinApplicationService {

    public List<Protein> getAllProtein (){

        return ProteinDataStore.PROTEIN_LIST;
    }
}
