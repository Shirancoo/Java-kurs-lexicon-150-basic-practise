public class Main {
    public static void main(String[] args) {

        /* Check whether Java is installed on your computer
        Java Version: 1.8.0_71
        Java Runtime Version: 1.8.0_71-b15
        Java Home: /opt/jdk/jdk1.8.0_71/jre
        Java Vendor: Oracle Corporation
        Java Vendor URL: http://Java.oracle.com/
        Java Class Path: .

         */


        System.out.println("your java version are: \n "
                +System.getProperty("java.version"));

        System.out.println("your java runtime are: \n"
                +System.getProperty("java.runtime.version"));

        System.out.println("your java home are: \n"
                +System.getProperty("java.home"));

        System.out.println("your java vendor are: \n"
                +System.getProperty("java.vendor"));

        System.out.println("your java vendor url are: \n"
                +System.getProperty("java.vendor.url"));

        System.out.println("your java class.path are: \n"
                +System.getProperty("java.class.path"));



    }
}