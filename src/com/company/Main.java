package com.company;

public class Main {
    private final static String FILE_URL = "C:\\LICENCE 2\\S4\\Algorithmique 1\\TP3\\instances\\sac1.txt";

    static knapsackProblem sac = new knapsackProblem();
    private final static int [] list = new int [sac.getCapacity(FILE_URL)];
    private final static  int poidsMax = sac.maxWeight(FILE_URL);
    private final static int n = sac.getCapacity(FILE_URL);
    private final static int[] poids = sac.poidsItems(FILE_URL);
    private final static int[] values = sac.valuesItems(FILE_URL);
    private static int maxValue = 0;

    public static void main(String[] args) {
        search(0);
        //knapsack_Solution2(poidsMax,poids,values,n);
    }
    //la methode Backtracking
    public static void search(int i){ // I represent the recursion depth
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
                System.out.print(", The selected item is : ");
                System.out.print('\n');
                for(int j=0;j<n;j++)
                {
                    if (list[j] == 1){
                        System.out.print(poids[j]);
                        System.out.print(' ');
                        System.out.println(values[j]);
                        System.out.print(' ');
                    }
                }
                System.out.println("and the total weight : " + weight);
                System.out.print('\n');
            }
        }

    }
    ////////////////////////////////////////////////////////////////////////
    public static int max(int a, int b)
    {
        return Math.max(a, b);
    }
    public static void knapsack_Solution2(int maxCap, int wt[],
                        int val[], int n)
    {
        int i, w;
        int K[][] = new int[n + 1][maxCap + 1];

        // Build table K[][] in bottom up manner
        for (i = 0; i <= n; i++)
        {
            for (w = 0; w <= maxCap; w++)
            {
                if (i == 0 || w == 0)
                    K[i][w] = 0;
                else if (wt[i - 1] <= w)
                    K[i][w] = max(val[i - 1] + K[i - 1][w - wt[i - 1]], K[i - 1][w]);
                else
                    K[i][w] = K[i - 1][w];
            }
        }
        System.out.println("The maximum value is : " + K[n][maxCap]);
    }

}
