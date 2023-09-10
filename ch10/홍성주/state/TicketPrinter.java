package livid_design_pattern.state;

public class TicketPrinter {
    int ticket;

    public TicketPrinter() {
        this.ticket = 100;
    }

    public int getTicket() {
        return this.ticket;
    }

    public void minusTicket(int count) {
        this.ticket -= count;
    }

    public void print() {
        System.out.println("print ticket...");
    }

    public void add(int ticket) {
        this.ticket += ticket;
    }
}
