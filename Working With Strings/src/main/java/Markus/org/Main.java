package Markus.org;

import java.util.Arrays;
import java.util.Random;


public class Main {
    public static void main(String[] args) {

        Random random = new Random();
        // length of the string. //
        String j = "java";
        System.out.println(j.length());

        // What char is at index position 6 in the following String //
        String firstSentence = "Long example sentence";
        System.out.println(firstSentence.charAt(7));

        // what is the index position of 'o' in the following string
        String secondSentence = "Even long example sentence";
        System.out.println(secondSentence.indexOf("o"));

        //. Given the following String: "Ok this is not as long!"
        //create a substring of only "not as long" (excluding the
        //exclamation point) and print it out.

        String thirdSentence = "Ok this is not as long";
        String subThirdSentence = thirdSentence.substring(11);
        System.out.println(subThirdSentence);

        //Convert the following String: "CAPS EQUALS SCREAMING" to
        //lowercase and print it out. Then convert it back to
        //uppercase and print it out again.

        String fourthSentence = "CAPS EQUALS SCREAMING";
        System.out.println(fourthSentence.toLowerCase());
        System.out.println(fourthSentence.toUpperCase());

        //Correct the following String: "Java is the worst
        //programming language!" by replacing the (obviously
        //incorrect) word "worst" with the word "best". Then print
        //out the sentence.

        String fifthStentence = "Java is the worst programming language!";
        String correctSentence = (fifthStentence.replace("worst", "best"));
        System.out.println(correctSentence);

        // What is the output of the following String:
        //"\tJ\ta\tv\ta\t" after you trim it?

        String outPutOfString = "\tJ\ta\tv\ta\t";
        String correctOutput = outPutOfString.replace("\t", "");
        System.out.println(correctOutput);

        // Parse the following int: 20 to a String and add a 20 to the
        //end of the String. Printing it out should return: "2020".

        int twenty = 20;
        String twentyString = String.valueOf(twenty) + "20";
        System.out.println(twentyString);

// Oil and water don't go well together. Given the String:
//"Oil and Water", split them up into the words "Oil","Water"
//and store them in a String array.

        String oil = "Oil and Water";
        System.out.println(Arrays.toString(oil.split(" and ")));

        //  Split the following String: "Carl,Susie,Fredrick,Bob,Erik"
        //into an array. Print out all names separately.

        String names = "Carl,Susie,Fredrick,Bob,Erik";

        System.out.println(Arrays.toString(names.split(",")));

        //Convert the following String: "ThisShouldBeConverted" to
        //a char array. Iterate through the char array and print out
        //each element.

        String charArray = "ThisShouldBeConverted";
        char [] chars = charArray.toCharArray();
        System.out.println(Arrays.toString(chars));
        System.out.println(chars);

        // Convert the following char[]: {'J','a','v','a'} to a
        //String and print it out.

        char[] java = {'J','a','v','a'};
        System.out.println(Arrays.toString(java));
        System.out.println(java);



    }

}