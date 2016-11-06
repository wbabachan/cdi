package cdi.qualifier;

import static cdi.qualifier.Language.Languages.FRENCH;

@Language(FRENCH)
public class LanguageFrenchTranslationService implements TranslationService {

    @Override
    public String translateHello() {
        return "Bonjour tout le monde!";
    }
}
