package Domain;

public enum Distance {
    SPRINT("50 m"), KORT("100 m"), MELLEMLANG("200 m"), LANG("800 m");

    public String distanceName;

    private Distance(String distanceName){
        this.distanceName = distanceName;
    }

    public String getDistanceName() {
        return distanceName;
    }


}
