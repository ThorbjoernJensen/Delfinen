package Domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Resultsgenerator {
//    tag antallet af medlemmer, vælg en tilfældig, og find på en tid, stil og distance
//    vælg antal resultateter

    private Result newResult;
    private List<Result> newResults;
    private SwimmingStyle[] swimmingStyles = SwimmingStyle.values();
    private Distance[] distances = Distance.values();


    public List<Result> generateNewResults(int antalReultater, int antalDeltagere) {
        Random random = new Random();
        newResults = new ArrayList<>();
//        Random randomDeltager = new Random();

        for (int i = 0; i < antalReultater - 1; i++) {
            int time = random.nextInt(100) + 50;
            int mnr = random.nextInt(antalDeltagere) + 1;

            SwimmingStyle randomSwimmingStyle = swimmingStyles[random.nextInt(swimmingStyles.length)];
//            System.out.println("den valgte svømmestil er: " + randomSwimmingStyle.toString());

            Distance randomDistance = distances[random.nextInt(distances.length)];
//            System.out.println("den valgte distance er " + randomDistance.distanceName);

            newResult = new Result(time, mnr, randomSwimmingStyle, randomDistance);
            newResults.add(newResult);
        }

        return newResults;


    }

}
