package livid_design_pattern.state;

public class ChargeState implements State{
    TicketMachine ticketMachine;
    TicketPrinter ticketPrinter;

    public ChargeState(TicketMachine ticketMachine, TicketPrinter ticketPrinter) {
        this.ticketMachine = ticketMachine;
        this.ticketPrinter = ticketPrinter;
    }

    @Override
    public void insertCoin() {
        System.out.println("티켓 충전중...");
    }

    @Override
    public void printTicket() {
        System.out.println("티켓 충전중...");
    }

    @Override
    public void chargeTicket() {
        System.out.println("티켓을 충전합니다.");
        ticketPrinter.add(100);
        ticketMachine.setState(ticketMachine.getNoCoinState());
    }
}
