package livid_design_pattern.state;

public class CoinRepository {
    int coin;

    public CoinRepository() {
        this.coin = 0;
    }

    public void add(int coin) {
        this.coin += coin;
    }
}
