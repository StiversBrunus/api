package br.com.redventures.ramengo.api.broth;

import br.com.redventures.ramengo.api.validation.ValidationException;
import io.micrometer.common.util.StringUtils;

import java.util.List;

public class BrothDataStore {

        /*************
         * FIELDS
         *********/

        public static final List<Broth> BROTH_LIST;

        static {
                BROTH_LIST = List.of(
                        new Broth(
                                "1",
                                "https://tech.redventures.com.br/icons/salt/inactive.svg",
                                "https://tech.redventures.com.br/icons/salt/active.svg",
                                "Salt",
                                "Simple like the seawater, nothing more",
                                10)
                );
        }

        /*************
         * METHODS
         **********/

        public static String getNameById(String id){

                for (Broth broth : BROTH_LIST){
                        if (broth.getId().equals(id)){
                                return broth.getName();
                        }
                }
                return null;
        }

        public static void validateBroth(String nameBroth) throws ValidationException {
                if(StringUtils.isBlank(nameBroth)){
                        throw new ValidationException("Broth not found!");
                }
        }
}
