package com.javarush.breslavetc.entrypoint;

public class ConsoleRunner {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java ConsoleRunner <command> <file_path> [<key>]");
            System.out.println("Commands:");
            System.out.println("  encrypt <file_path> <key>");
            System.out.println("  decrypt <file_path> <key>");
            System.out.println("  crack <file_path>");
            return;
        }

    }
}
