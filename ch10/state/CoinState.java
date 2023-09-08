package livid_design_pattern.state;

public class CoinState implements State{

    TicketMachine ticketMachine;
    TicketPrinter ticketPrinter;

    public CoinState(TicketMachine ticketMachine,TicketPrinter ticketPrinter) {
        this.ticketMachine = ticketMachine;
        this.ticketPrinter = ticketPrinter;
    }

    @Override
    public void insertCoin() {
        System.out.println("이미 동전이 들어 있습니다.");
    }

    @Override
    public void printTicket() {
        if(ticketPrinter.getTicket() == 0) {
            System.out.println("티켓의 장수가 부족합니다. 동전을 반환합니다.");
            ticketMachine.setState(ticketMachine.getNoCoinState());
            return;
        }
        ticketMachine.setState(ticketMachine.getSoldState());
        ticketMachine.printTicket();
    }

    @Override
    public void chargeTicket() {
        System.out.println("코인이 없는 상태에서만 가능한 동작입니다.");
    }
}
