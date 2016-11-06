package cdi.qualifier;

@German
public class GermanTranslationService implements TranslationService {

    @Override
    public String translateHello() {
        return "Hallo Welt!";
    }

}
