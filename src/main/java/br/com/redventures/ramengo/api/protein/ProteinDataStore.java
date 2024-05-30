package br.com.redventures.ramengo.api.protein;

import br.com.redventures.ramengo.api.broth.Broth;

import java.util.Arrays;
import java.util.List;

public class ProteinDataStore {

    public static final List<Protein> PROTEIN_LIST;

    static {
            PROTEIN_LIST = Arrays.asList(
                    new Protein(
                            "1",
                            "https://tech.redventures.com.br/icons/pork/inactive.svg",
                            "https://tech.redventures.com.br/icons/pork/active.svg",
                            "Chasu",
                            "A sliced flavourful pork meat with a selection of season vegetables.",
                            10)
            );
    };

    public static String getNameById(String id){

        for (Protein protein : PROTEIN_LIST){
            if (protein.getId().equals(id)){
                return protein.getName();
            }
        }
        return null;
    }

}
