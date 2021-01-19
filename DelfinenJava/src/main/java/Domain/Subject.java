package Domain;

public interface Subject {
    public void registerObserver(Member m);

    public void removeObserver(Member m);
    public void notifyObserver();
}
