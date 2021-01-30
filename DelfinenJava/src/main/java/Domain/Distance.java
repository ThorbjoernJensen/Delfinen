package Domain;

public enum Distance {
    SPRINT("50 m", 1), KORT("100 m", 2), MELLEMLANG("200 m", 3), LANG("800 m", 4);


    public String distanceName;
    private int distanceNr;

//    hvornår har man brug for en constructor til en enum?
    private Distance(String distanceName, int distanceNr){
        this.distanceName = distanceName;
        this.distanceNr = distanceNr;
    }

    public String getDistanceName() {
        return distanceName;
    }

    public int getDistanceNr() {
        return distanceNr;
    }

}
