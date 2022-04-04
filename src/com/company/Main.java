package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    private final static String FILE_URL_1 = "C:\\LICENCE 2\\S4\\Algorithmique 1\\TP3\\instances\\sac1.txt";
    private final static String FILE_URL_2 = "C:\\LICENCE 2\\S4\\Algorithmique 1\\TP3\\instances\\sac2.txt";
    private final static String FILE_URL_3 = "C:\\LICENCE 2\\S4\\Algorithmique 1\\TP3\\instances\\sac3.txt";
    private final static String FILE_URL_4 = "C:\\LICENCE 2\\S4\\Algorithmique 1\\TP3\\instances\\sac4.txt";
    private final static  int poidsMax = 2000 ;
    private final static int n = 20;
    private final static int [] list = new int [n];
    private final static int[] poids = {132, 165, 145, 198, 156, 152, 110, 144, 123, 115, 199, 134, 117, 182, 111, 154, 105, 169, 128, 156};
    private final static int[] values = {138772, 173636, 148055, 198705, 165087, 152665, 117838, 151242, 123145, 115281, 204756, 134767, 121259, 186944, 111389, 154316, 112132, 177607, 134188, 158942};
    private static int maxValue = 0;


    public static void main(String[] args) {
        search(0);
        //item(FILE_URL_1);



        /*
        File file = new File(FILE_URL_1);
        InputStream inputStream = new FileInputStream(file);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader reader = new BufferedReader(inputStreamReader);
        String line;
        ArrayList<Integer> poids = new ArrayList<>();
        ArrayList<Integer> value = new ArrayList<>();
        ArrayList<String[]> data = new ArrayList<>();
        while ((line = reader.readLine()) != null) {
            String[] result = line.split(" ");
            poids.add(Integer.valueOf(result[0]));
            //data.add(Arrays.toString(result));
            data.add(result);
        }
        int poidsMax = poids.get(0);
        data.remove(0);
        poids.remove(0);
        for (String[] element : data){
            value.add(Integer.valueOf(element[1]));
        }

        //System.out.println(data);
        System.out.println(poidsMax);
        System.out.println(poids);
        System.out.println(value);

         */
    }
    public static void item(String fileName) {
        try {
            File file = new File(fileName);
            InputStream inputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line;
            ArrayList<Integer> poids = new ArrayList<>();
            ArrayList<Integer> values = new ArrayList<>();
            ArrayList<String[]> data = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                String[] result = line.split(" ");
                poids.add(Integer.valueOf(result[0]));
                //data.add(Arrays.toString(result));
                data.add(result);
            }
            //int poidsMax = poids.get(0);
            data.remove(0);
            poids.remove(0);
            for (String[] element : data) {
                values.add(Integer.valueOf(element[1]));
            }
            int n = poids.size();
            System.out.println(data);
            //System.out.println(poidsMax);
            System.out.println(poids);
            System.out.println(values);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void search(int i){
        if (i >= n){
            checkMax();
        }
        else {
             list[i]= 0;
            search(i+1);
            list[i] = 1;
            search(i+1);
        }
    }
    public static void checkMax(){
        int weight = 0;
        int value = 0;
        for (int i = 0 ; i < n;i++){
            if (list[i] == 1){
                weight += poids[i];
                value += values[i];
            }
        }
        if (weight <= poidsMax){
            if (value >= maxValue){
                maxValue = value;
                System.out.print("The maximum value is:" + maxValue +"");
                System.out.print(", The selected item is (1 means selected, 0 means unselected): ");
                for(int j=0;j<n;j++)
                {
                    System.out.print(list[j]);
                    System.out.print(' ');
                }
                System.out.println("and the total weight : " + weight);
                System.out.print('\n');
            }
        }
    }

}
