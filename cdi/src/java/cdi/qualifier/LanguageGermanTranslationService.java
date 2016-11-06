package cdi.qualifier;

import static cdi.qualifier.Language.Languages.GERMAN;

@Language(GERMAN)
public class LanguageGermanTranslationService implements TranslationService {

    @Override
    public String translateHello() {
        return "Hallo Welt!";
    }

}
