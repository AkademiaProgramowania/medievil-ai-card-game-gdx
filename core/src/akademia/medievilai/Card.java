package akademia.medievilai;

public class Card {

    final private Resources resource;
    private int amount;

    public Card(Resources resource, int amount) {
        this.resource = resource;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return resource + " amount"; //TODO w przyszlosci dodac ilosc surowca
    }

    public Resources getResource() {
        return resource;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
