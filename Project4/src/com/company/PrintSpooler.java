package com.company;

public class PrintSpooler {
    private static PrintSpooler spooler;

    public static PrintSpooler getSpooler() {
        // get a reference to the spooler
        if (spooler == null)
            spooler = new PrintSpooler();
        return spooler;
    }

    public void printDocument(String s) {
        // print a document
        // print a header
        System.out.println("--------------------------------------------------");
        System.out.println(s);
        System.out.println("--------------------------------------------------");
    }
}
