package cdi.decorator;


public class TicketServiceImpl implements TicketService {

    @Override
    public String orderTicket() {
        return "Ticket was ordered";
    }
}
