package Domain;

public enum SwimmingStyle {
    BUTTERFLY(1),	CRAWL(2),	RYGCRAWL(3), BRYSTSVØMNING(4);

    private int styleNr;

    private SwimmingStyle(int styleNr){
        this.styleNr = styleNr;
    }

    public int getStyleNr() {
        return styleNr;
    }

    public void setStyleNr(int styleNr) {
        this.styleNr = styleNr;
    }
}






