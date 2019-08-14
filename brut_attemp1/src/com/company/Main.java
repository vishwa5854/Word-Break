package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        String input = scanner.nextLine();
        int number_of_words_in_dictionary = scanner.nextInt();
        ArrayList<String> dictionary = new ArrayList<>();
        for(int i=0;i<number_of_words_in_dictionary;i++){
            dictionary.add(scanner.next());
        }
        int start = 0;
        int stop = dictionary.size();
        ArrayList<String> space = new ArrayList<>(dictionary);
        for(int i=0;i<number_of_words_in_dictionary;i++) {
            generateTwoAtATime(start,stop,dictionary,number_of_words_in_dictionary,space);
            start = stop;
            stop = dictionary.size();
        }

        searchForAnswer(input, dictionary, space);
    }

    private static void searchForAnswer(String input, ArrayList<String> dictionary, ArrayList<String> space) {
        for(int i=0;i<dictionary.size();i++){
            if(dictionary.get(i).compareTo(input) == 0){
                System.out.println(space.get(i));
                dictionary.remove(i);
                space.remove(i);
            }
        }
    }


    private static void generateTwoAtATime(int start,int end,ArrayList<String> med,int initial,ArrayList<String> space) {
        for(int i=start;i<end;i++){
            for(int j=0;j<initial;j++){
                med.add(med.get(i) + med.get(j));
                space.add(space.get(i) + " " + space.get(j));
            }
        }
    }
}
