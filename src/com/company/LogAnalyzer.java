package com.company;
/**
 * Write a description of class LogAnalyzer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import com.company.LogEntry;

import javax.management.AttributeList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class LogAnalyzer
{

    private static ArrayList<LogEntry> records;
     
     public LogAnalyzer() {
         records = new ArrayList<LogEntry>();
         // complete constructor
     }
        
     public static void readFile(String filename) throws FileNotFoundException {
         File file = new File("C:\\Users\\Amit\\IdeaProjects\\CourseraWeek2\\src\\com\\company\\demo.txt");
         Scanner sc = new Scanner(file);
         WebLogParser wb= new WebLogParser();

         while(sc.hasNext()){
             records.add(wb.parseEntry(sc.nextLine()));
         }

         // complete method
     }
        
     public void printAll() {
         for (LogEntry le : records) {
             System.out.println(le);
         }
     }
    public int countUnique(){
         ArrayList<String> uniqueIPs = new ArrayList<String>();
         for(LogEntry le: records){
             String ipAddr = le.getIpAddress();
             if(!uniqueIPs.contains(ipAddr)){
                 uniqueIPs.add(ipAddr);
             }
         }
         return uniqueIPs.size();
    }
    public void printAllHigherThanNum(int num){
         for(LogEntry le: records){
             if(le.getStatusCode() > num){
                 System.out.println("all higher than "+ num+">>"+le);
             }
         }
    }
    public void uniqueIPVisitsOnDay(String someday) {
        ArrayList<String>  iPSomeday = new ArrayList<String>();

        for (LogEntry le : records) {
//            System.out.println("gg");
            String entry = le.getAccessTime().toString().substring(4, 10);
            if(entry.toString().equals(someday)) {
                String ipAddr = le.getIpAddress();
                if (!iPSomeday.contains(ipAddr)){
                    iPSomeday.add(ipAddr);
                    System.out.println(le.getIpAddress() + "\t" + someday);
                }
            }
        }
        System.out.println("len>>"+ iPSomeday.size());
    }
    public void countUniqueIPsInRange(int low, int high){
        ArrayList<String> uniqueIPs = new ArrayList<String>();

         for(LogEntry le: records){
             if(le.getStatusCode() <= high && le.getStatusCode()>= low){
                 String ipAddr = le.getIpAddress();
                 if(!uniqueIPs.contains(ipAddr)){
                     uniqueIPs.add(ipAddr);
                 System.out.println("low high "+ le);
                }
             }

        }
        System.out.println("amitKumar"+uniqueIPs.size());
    }
    public HashMap<String, Integer> countVisitsPerIP(){
         HashMap<String, Integer> counts = new HashMap<String, Integer>();
         for(LogEntry le: records){
             String ip = le.getIpAddress();
             if(!counts.containsKey(ip)){
                 counts.put(ip,1);
             }
             else{
                 counts.put(ip, counts.get(ip)+1);
             }
         }
         return counts;
    }
    public void mostNumberVisitsByIP(HashMap<String, Integer> map){
        System.out.println();
        int max =0;
        for(String key: map.keySet()){
            if(map.get(key)>max){
                max = map.get(key);
            }
        }
        System.out.println("Maximum visit by an IP xx: "+ max);
    }
    public void iPsMostVisits(HashMap<String, Integer> map){
         ArrayList<String> lst = new ArrayList<String>();
         int max=0;
        for(String key: map.keySet()){
            if(map.get(key)>max){
                max = map.get(key);
            }
        }
        for(String key:map.keySet()){
            if(map.get(key) == max){
                lst.add(key);
                System.out.println("max.."+key);
            }
        }

    }
    public HashMap<String, ArrayList<String>> iPsForDays(){
         HashMap<String,ArrayList<String>> map = new HashMap<String,ArrayList<String>>();
         ArrayList<String> arr = new ArrayList<String>();

         for (LogEntry le : records) {
            String key = le.getAccessTime().toString().substring(4, 10);
            String ip = le.getIpAddress();

           if(map.containsKey(key)) {
               arr = map.get(key);
               arr.add(ip);
               map.put(key, arr);
           }
           else{
               ArrayList<String> tmp = new ArrayList<>();
               tmp.add(ip);
               map.put(key,tmp);
           }

        }

         return map;

    }

    public void dayWithMostIPVisits(HashMap<String, ArrayList<String>> map){
         String out ="";
         int len=0;
         for(String key: map.keySet()){
             ArrayList<String> temp = map.get(key);

             if(temp.size()>len){
                 len = temp.size();
                 out = key;

             }
         }
        System.out.println("day with most IP visits: "+out);
    }
    public String iPsWithMostVisitsOnDay(HashMap<String, ArrayList<String>> map, String day ){
        ArrayList<String> lst = new ArrayList<>();
        lst = map.get(day);

        HashMap<String, Integer> tempMap = new HashMap<String, Integer>();
        for(String ip: lst){
            if(!tempMap.containsKey(ip)){
                tempMap.put(ip,1);
            }
            else{
                tempMap.put(ip,tempMap.get(ip)+1 );
            }
        }
        int max=0; String maxIP ="";
        for(String key: tempMap.keySet()){
            if(tempMap.get(key)>max){
                max = tempMap.get(key);
                maxIP = key;
            }
        }
         return maxIP;
    }
}
