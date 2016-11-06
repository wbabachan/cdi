package cdi.qualifier;

@French
public class FrenchTranslationService implements TranslationService {

    @Override
    public String translateHello() {
        return "Bonjour tout le monde!";
    }
}
