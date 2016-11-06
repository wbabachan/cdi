package cdi.producer;


import cdi.qualifier.FrenchTranslationService;
import cdi.qualifier.GermanTranslationService;
import cdi.qualifier.TranslationService;

import javax.enterprise.inject.New;
import javax.enterprise.inject.Produces;
import java.util.Calendar;

public class LanguageFactory {

    private int hour;

    public LanguageFactory() {
        hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
    }

    @Produces
    public TranslationService getTranslationService(@New GermanTranslationService german, @New FrenchTranslationService french) {
        if (hour>18 && hour<24) {
            return german;
        } else {
            return french;
        }
    }
}
