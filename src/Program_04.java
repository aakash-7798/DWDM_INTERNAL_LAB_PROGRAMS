// Written by Aakash Nadupalli

//4. Write a program to normalize a numeric vector using z-score normalization.

import java.util.Arrays;


public class Program_04 {

    public static double[] get_z_score_normalized_vector(double[] vector){
        double[] normalized_vector = new double[vector.length] ;

        double mean = Arrays.stream(vector).average().getAsDouble();
        double std_dev = (double) Math.sqrt(Arrays.stream(vector).map(x->Math.pow(x-mean,2)).sum()/ vector.length);

        System.out.println("Mean = "+String.format("%.2f",mean)+"      "+"StandardDeviation = "+String.format("%.2f",std_dev));
        for(int i=0;i<vector.length;i++){
            double normalized_value = (vector[i]-mean)/std_dev;
            normalized_vector[i] = Double.parseDouble(String.format("%.2f",normalized_value));
        }

        return normalized_vector;
    }

    public static void main(String[] args) {
//        double[] vector = {5.0,10.0,3.0,8.0,1.0};
        double[] vector = {3,5,5,8,9,12,12,13,15,16,17,19,22,24,25,134};
        System.out.println("Original Vector  = "+ Arrays.toString(vector));
        System.out.println("Normalized Vector Using Z-score = "+ Arrays.toString(get_z_score_normalized_vector(vector)));
    }
}
