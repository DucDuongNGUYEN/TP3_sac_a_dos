package com.company;

import java.io.*;
import java.util.ArrayList;

public class knapsackProblem {

    public int getCapacity(String fileName){
        ArrayList<String[]> data = item(fileName);
        data.remove(0);
        int cap = data.size() ;
        return cap;
    }
    public int maxWeight(String fileName){
        int poids = Integer.parseInt(item(fileName).get(0)[0]);
        return poids;
    }

    public ArrayList<String[]> item(String fileName) {
        try {
            File file = new File(fileName);
            InputStream inputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line;
            ArrayList<String[]>data = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                String[] result = line.split(" ");
                data.add(result);
            }
            return data;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public int[] poidsItems(String fileName){
        int i = 0;
        ArrayList<String[]> data = item(fileName);
        data.remove(0);
        int[] poids = new int[data.size()];
        for (String[] element : data){
            poids[i] = Integer.parseInt(element[0]);
            i++;
        }
        return poids;
    }
    public int[] valuesItems(String fileName){
        int i = 0;
        ArrayList<String[]> data = item(fileName);
        data.remove(0);
        int[] values = new int[data.size()];
        for (String[] element : data){
            values[i] = Integer.parseInt(element[1]);
            i++;
        }
        return values;

    }
}
