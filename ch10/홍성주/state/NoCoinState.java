package livid_design_pattern.state;

public class NoCoinState implements State{
    TicketMachine ticketMachine;
    TicketPrinter ticketPrinter;

    public NoCoinState(TicketMachine ticketMachine, TicketPrinter ticketPrinter) {
        this.ticketMachine = ticketMachine;
        this.ticketPrinter = ticketPrinter;
    }

    @Override
    public void insertCoin() {
        if(ticketPrinter.getTicket() > 0) {
            System.out.println("동전 투입");
            ticketMachine.setState(ticketMachine.getCoinState());
        }
        else {
            System.out.println("티켓 장수가 부족합니다. 동전을 반환합니다.");
            ticketMachine.setState(ticketMachine.getChargeState());
            ticketMachine.chargeTicket();
        }

    }

    @Override
    public void printTicket() {
        System.out.println("동전이 없습니다. 동전을 넣어주세요");
    }

    @Override
    public void chargeTicket() {
        if(ticketPrinter.getTicket() > 0) {
            System.out.println("티켓의 장수가 0일때만 충전가능합니다..");
        }
        else {
            ticketMachine.setState(ticketMachine.getChargeState());
        }
    }
}
