package Domain;

public enum MemberType {
    MOTIONIST, KONKURRENCE

//    kan vi få den til at printe noget andet i to string?
}




//    ACE("ACE", 1, 11), TWO("TWO", 2), THREE("THREE", 3), FOUR("FOUR", 4), FIVE("FIVE", 5), SIX("SIX", 6),
//        SEVEN("SEVEN",7), EIGHT("EIGHT", 8), NINE("NINE", 9), TEN("TEN", 10), JACK("JACK", 10), KING("KING", 10), QUEEN("QUEEN",10);
//
//private int value1;
//private int value2;
//private String name;
//
//private Cards(String name, int value1) {
//        this.value1 = value1;
//        }
//
//private Cards(String name, int value1, int value2) {
//        this.value1 = value1;
//        this.value2 = value2;
//        }
//
//public int getValue1() {
//        return value1;
//        }
//
//public int[] getValue2() {
//        int[] val = { value1, value2 };
//        return val;
//        }
//
//public String getName() {
//        return name;
//        }
//
//
//
//// get an array of all the cards
//private Card[]cards=Cards.values();
//// this generates random numbers
//private Random random = new Random();
//// choose a card at random
//final Card random(){
//        return cards[random.nextInt(cards.length)];
//        }