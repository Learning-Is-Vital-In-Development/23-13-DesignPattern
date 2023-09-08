package livid_design_pattern.state;

public class SoldState implements State{
    TicketMachine ticketMachine;
    TicketPrinter ticketPrinter;
    CoinRepository coinRepository;

    public SoldState(TicketMachine ticketMachine, TicketPrinter ticketPrinter, CoinRepository coinRepository) {
        this.ticketMachine = ticketMachine;
        this.ticketPrinter = ticketPrinter;
        this.coinRepository = coinRepository;
    }

    @Override
    public void insertCoin() {
        System.out.println("티켓을 출력하는 중입니다.");
    }

    @Override
    public void printTicket() {
        System.out.println("티켓을 출력합니다.");
        ticketPrinter.print();
        coinRepository.add(1);
        ticketPrinter.minusTicket(1);

        System.out.println(ticketPrinter.getTicket());
        if(ticketPrinter.getTicket() > 0) {
            ticketMachine.setState(ticketMachine.getNoCoinState());
        }
        else {
            ticketMachine.setState(ticketMachine.getChargeState());
        }
    }

    @Override
    public void chargeTicket() {
        System.out.println("티켓을 출력하는 중입니다.");
    }
}
