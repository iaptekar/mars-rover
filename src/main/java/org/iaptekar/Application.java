package org.iaptekar;

public class Application {

    public static void main(String[] args) throws Exception {
        if (args.length == 2 && args[1].equals("-f")) {
            System.out.println("Program must be called using -f <filename>");
            System.exit(1);
        }
        new FileInstructionLoader(args[1]).execute().forEach(System.out::println);
    }
}