package br.com.redventures.ramengo.api.broth;

import java.util.Arrays;
import java.util.List;

public class BrothDataStore {

        public static final List<Broth> BROTH_LIST;

        static {
                BROTH_LIST = Arrays.asList(
                        new Broth(
                                "1",
                                "https://tech.redventures.com.br/icons/salt/inactive.svg",
                                "https://tech.redventures.com.br/icons/salt/active.svg",
                                "Salt",
                                "Simple like the seawater, nothing more",
                                10)
                );
        }

        public static String getNameById(String id){

                for (Broth broth : BROTH_LIST){
                        if (broth.getId().equals(id)){
                                return broth.getName();
                        }
                }
                return null;
        }

}
