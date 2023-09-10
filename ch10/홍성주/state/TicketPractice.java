package livid_design_pattern.state;

public class TicketPractice {
    public static void main(String[] args) {
        TicketPrinter ticketPrinter = new TicketPrinter();
        CoinRepository coinRepository = new CoinRepository();

        TicketMachine ticketMachine = new TicketMachine(ticketPrinter, coinRepository);

        ticketMachine.insertCoin();
        ticketMachine.printTicket();
    }
}
