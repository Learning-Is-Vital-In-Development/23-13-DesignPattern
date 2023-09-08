package livid_design_pattern.state;

public class TicketMachine {
    State noCoinState;
    State coinState;
    State soldState;
    State chargeState;
    State currentState;

    TicketPrinter ticketPrinter;

    CoinRepository coinRepository;

    public TicketMachine(TicketPrinter ticketPrinter, CoinRepository coinRepository) {
        this.noCoinState = new NoCoinState(this, ticketPrinter);
        this.coinState = new CoinState(this, ticketPrinter);
        this.soldState = new SoldState(this, ticketPrinter, coinRepository);
        this.chargeState = new ChargeState(this, ticketPrinter);

        this.currentState = noCoinState;
    }

    public void insertCoin() {
        currentState.insertCoin();
    }
    public void printTicket() {
        currentState.printTicket();
    }
    public void chargeTicket() {
        currentState.chargeTicket();
    }

    public void setState(State newState) {
        this.currentState = newState;
    }

    public State getNoCoinState() {
        return noCoinState;
    }

    public State getCoinState() {
        return coinState;
    }

    public State getSoldState() {
        return soldState;
    }

    public State getChargeState() {
        return chargeState;
    }
}
