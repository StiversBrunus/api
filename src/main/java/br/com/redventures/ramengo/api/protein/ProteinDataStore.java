package br.com.redventures.ramengo.api.protein;

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

}
