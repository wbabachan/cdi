package cdi.interceptor;

import static cdi.interceptor.PaymentImpl.CARD.GIRO;
import static cdi.interceptor.PaymentImpl.CARD.MASTER;
import static cdi.interceptor.PaymentImpl.CARD.VISA;

public class PaymentImpl implements Payment {

    public enum CARD {
        VISA,
        MASTER,
        GIRO
    }

    private int bill = 56;

    private CARD card = VISA;

    @Loggable
    @Override
    public String pay() {
        String result;
        if (card == VISA) {
            result = "Paying " + bill + " with " + VISA + " card";
        } else if (card == MASTER) {
            result = "Paying " + bill + " with " + MASTER + " card";
        } else {
            result = "Paying " + bill + " with " + GIRO + " card";
        }
        System.err.println(result);
        return result;
    }
}
