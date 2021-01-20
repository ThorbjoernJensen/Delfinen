package Domain;

public class Subscription {
    private int subscriptionId;
    private int year;
    private int duedate;
    private int amount;

    public Subscription(int subscriptionId, int year, int duedate, int amount) {
        this.subscriptionId = subscriptionId;
        this.year = year;
        this.duedate = duedate;
        this.amount = amount;
    }

//    er vi afhængige af denne - så kasseren kan lave et objekt før den sendes til database og får genereret et id?
    public Subscription(int year, int duedate, int amount) {
        this.year = year;
        this.duedate = duedate;
        this.amount = amount;
    }
}
