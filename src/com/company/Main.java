package com.company;


import javafx.css.Size;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Array;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

class CharacterInPlay{
    private ArrayList<String> characterName;
    private ArrayList<Integer> characterCount;

    void update(String person){

    }
    void findAllCharacters(){

    }
}


class WordFrequencies {
    private ArrayList<String> myWords;
    private ArrayList<String> uniqueWords;
    private ArrayList<Integer> frequency;

    public WordFrequencies() {
        myWords = new ArrayList<String>();
        uniqueWords = new ArrayList<String>();
        frequency = new ArrayList<Integer>();
    }

    public void findUnique() {
        for (String word : myWords) {
            int index = uniqueWords.indexOf(word);
            if (index == -1) {
                uniqueWords.add(word);
                System.out.println(word);
            }
        }
    }

    public void uniqueWordNo() {
        int count = 0;
        for (String item : uniqueWords) {
            count++;
        }
        System.out.println("unique word count>>" + count);
    }

    public void freqs() {
        int k = 0;
        for (String item : uniqueWords) {
            frequency.add(k, 0);
            k++;
        }
        System.out.println("frequency length" + frequency.size());
        int vale = 0;
        for (String word : myWords) {
            int index = uniqueWords.indexOf(word);

            vale = frequency.get(index);
//            System.out.println(integer);
            frequency.set(index, (1 + vale));
        }
        System.out.println("frequency array");
        for (int num : frequency) {
            System.out.println(num);
        }
    }

    public void maxFreq() {
        int max = 0;
        int index = 0;
        int i = 0;
        for (int item : frequency) {
//            System.out.println(item);
            if (item > max) {
                max = item;
                index = i;
            }
            i++;
        }
        System.out.println("word>>" + uniqueWords.get(index) + "\t Maximum fre>>" + (max));
//
    }
//

    public void readFile() throws FileNotFoundException {
        File file = new File("C:\\Users\\Amit\\IdeaProjects\\CourseraWeek2\\src\\com\\company\\demo2");
        Scanner sc = new Scanner(file);
        while (sc.hasNext()) {
            String next = sc.next();
            myWords.add(next.toLowerCase());
        }
//        for(String Item: myWords){
//            System.out.println(Item);
//        }

    }

    public void out() {
        int p = 0;
        for (String item : uniqueWords) {
            System.out.println("word: " + uniqueWords.get(p) + '\t' + "freq: " + frequency.get(p));
            p++;

        }
    }
}

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        WordFrequencies check = new WordFrequencies();
        check.readFile();
        check.findUnique();
        check.uniqueWordNo();
        check.freqs();
        check.maxFreq();
        check.out();

    }
}
