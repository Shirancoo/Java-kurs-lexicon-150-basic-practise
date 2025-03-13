package Markus.org;

public class Main {
    public static void main(String[] args) {


        name("Markus");
        name("Agersten");
        System.out.println(addNumbers(1, 2));
        System.out.println(addNumbers(5, 10));
        System.out.println( multiNumbers(1, 2, 3));
        System.out.println(multiNumbers(1, 3, 4));
        System.out.println(evenOrNot(1));
        System.out.println(biggestNumber(6, 5));
        System.out.println(biggestNumber(55, 55));
        System.out.println(median(10, 5));
        System.out.println(median(20.5, 55.5));


    }


    //Skriv en metod sägaHej(String namn) som tar emot ett namn och skriver ut "Hej, [namn]!".
    static void name(String names) {
        System.out.println(names);
    }

    //Skriv en metod addera(int a, int b) som tar emot två tal och returnerar summan.
    static double addNumbers(double add1, double add2) {
        return add1 + add2;
    }

    static double multiNumbers(double multi1, double multi2, double multi3) {
        //Skriv en metod multipliceraTreTal(int a, int b, int c) som tar emot tre tal och returnerar resultatet.
        return multi1 * multi2 * multi3;

    }


    //Skriv en metod ärJämnt(int tal) som returnerar true om talet är jämnt och false om det är udda.
    public static boolean evenOrNot(int isEven) {

        if (isEven % 2 == 0)
            return true;
        else {
            return false;
        }

    }

    //Skriv en metod störstaTal(int a, int b) som returnerar det största talet av de två.
    public static double biggestNumber(double dd3, double dd4) {
        if (dd3 > dd4)
            return dd3;
        else if (dd3 < dd4) {
            return dd4;
        }
        System.out.println("they are equal");
        return dd4;
        }

        //Beräkna medelvärde
        // Skriv en metod `beräknaMedelvärde(double x, double y)` som returnerar medelvärdet av två tal


    public static double median(double median1, double median2) {
        return (median1 + median2) / 2;
    }

}







