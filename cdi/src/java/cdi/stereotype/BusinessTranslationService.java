package cdi.stereotype;

import cdi.qualifier.TranslationService;

@Business
@Translator
public class BusinessTranslationService implements TranslationService {

    @Override
    public String translateHello() {
        return "Hello World! This business translator is stereotype annotated object !!!";
    }

}
