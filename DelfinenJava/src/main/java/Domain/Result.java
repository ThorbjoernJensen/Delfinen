package Domain;

public class Result {
    private int resultId;
    private int mnr;
    private int time;
    private SwimmingStyle swimmingStyle;
    private Distance distance;

//    hvad bruger man interface og superklasse til i olive-projekt?

    public Result() {

    }

    public Result(int time, int mnr, SwimmingStyle swimmingStyle, Distance distance) {
        this.mnr = mnr;
        this.time = time;
        this.swimmingStyle = swimmingStyle;
        this.distance = distance;
    }

    public Result(int resultId, int time, int mnr, SwimmingStyle swimmingStyle, Distance distance) {
        this.resultId = resultId;
        this.mnr = mnr;
        this.time = time;
        this.swimmingStyle = swimmingStyle;
        this.distance = distance;
    }

    public int getMnr() {
        return mnr;
    }

    public void setMnr(int mnr) {
        this.mnr = mnr;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }



    public SwimmingStyle getSwimmingStyle() {
        return swimmingStyle;
    }

    public void setSwimmingStyle(SwimmingStyle swimmingStyle) {
        this.swimmingStyle = swimmingStyle;
    }

    public Distance getDistance() {
        return distance;
    }

    public void setDistance(Distance distance) {
        this.distance = distance;
    }

    public int getResultId() {
        return resultId;
    }

    public void setResultId(int resultId) {
        this.resultId = resultId;
    }
}
