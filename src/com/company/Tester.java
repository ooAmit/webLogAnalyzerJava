package com.company;
/**
 * Write a description of class Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.io.FileNotFoundException;
import java.util.*;

public class Tester
{
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }
    
    public void testLogAnalyzer() throws FileNotFoundException {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("huhu");
        la.printAll();
        System.out.println(la.countUnique()+" Unique IPs");
        la.printAllHigherThanNum(400);
        la.uniqueIPVisitsOnDay("Sep 24");
        la.countUniqueIPsInRange(200,299);

        HashMap<String, Integer> count= la.countVisitsPerIP();
        System.out.println("countVisitsPerIP"+ count);
        la.mostNumberVisitsByIP(count);
        la.iPsMostVisits(count);

        HashMap<String, ArrayList<String>> out = la.iPsForDays();
        System.out.println(out);
        la.dayWithMostIPVisits(out);

        String maxIP =la.iPsWithMostVisitsOnDay(out, "Mar 17");
        System.out.println("the IP having maximum visits on Given day: "+maxIP);
    }





    public static void main(String[] args) throws FileNotFoundException {
        Tester t1 = new Tester();
//        t1.testLogEntry();
        t1.testLogAnalyzer();

    }
}
