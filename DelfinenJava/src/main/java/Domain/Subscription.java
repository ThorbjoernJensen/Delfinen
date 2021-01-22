package Domain;

public class Subscription {


    private int subscriptionId;
    private int year;
    private String duedate;
    private int amount;

    public Subscription(int subscriptionId, int year, String duedate, int amount) {
        this.subscriptionId = subscriptionId;
        this.year = year;
        this.duedate = duedate;
        this.amount = amount;
    }

//    er vi afhængige af denne - så kasseren kan lave et objekt før den sendes til database og får genereret et id?
    public Subscription(int year, String duedate, int amount) {
        this.year = year;
        this.duedate = duedate;
        this.amount = amount;
    }


    public int getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(int subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDuedate() {
        return duedate;
    }

    public void setDuedate(String duedate) {
        this.duedate = duedate;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
