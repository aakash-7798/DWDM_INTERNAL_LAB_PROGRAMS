//Written by Aakash Nadupalli

//3. Write a program to normalize a numeric vector using min-max normalization.

import java.util.Arrays;

public class Program_03 {
    public static double[] get_min_max_normalized_vector(double[] vector){
        double[] normalized_vector = new double[vector.length] ;

        double min_value = Arrays.stream(vector).min().getAsDouble();
        double max_value = Arrays.stream(vector).max().getAsDouble();

        System.out.println("Minimum Value = "+min_value+"      "+"Maximum Value = "+max_value);
        for(int i=0;i<vector.length;i++){
            double normalized_value = (vector[i]-min_value)/(max_value-min_value);
            normalized_vector[i] = Double.parseDouble(String.format("%.2f",normalized_value));
        }

        return normalized_vector;
    }
    public static void main(String[] args) {
//        double[] vector = {1000,2000,3000,4000,5000,6000};
        double[] vector = {5.0,10.0,3.0,8.0,1.0};
        System.out.println("Original Vector  = "+Arrays.toString(vector));
        System.out.println("Normalized Vector Using Min_Max = "+ Arrays.toString(get_min_max_normalized_vector(vector)));
    }
}
