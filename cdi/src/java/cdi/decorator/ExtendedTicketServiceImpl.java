package cdi.decorator;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;

@Decorator
public class ExtendedTicketServiceImpl implements TicketService {

    @Inject
    @Delegate
    TicketService ticketService;

    public String orderTicket() {
        return ticketService.orderTicket() + " with some extras and special price !!!";
    }

}
