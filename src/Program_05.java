//   Written by Aakash Nadupalli

//5. Write a program to normalize a numeric vector using decimal scaling normalization.

import java.util.Arrays;


public class Program_05 {

    public static double[] get_decimal_scaling_normalized_vector(double[] vector)
    {
        double[] normalized_vector = new double[vector.length] ;
        double max_value = Arrays.stream(vector).max().getAsDouble();
        System.out.println("Max value = "+max_value);
        String max_value_digits = String.valueOf(Math.abs(max_value)).split("\\.")[0];
        System.out.println("Value without decimal  = "+max_value_digits);
        int exponent = 0;
        if(max_value_digits.equals("0")){
            exponent=0;
        }
        else{
            exponent = max_value_digits.length();
        }
        System.out.println("Exponent (Total Digits in above value) = "+exponent);
        for(int i=0;i<vector.length;i++){
            double normalized_value = vector[i]/(Math.pow(10,exponent)) ;
            normalized_vector[i] = Double.parseDouble(String.format("%."+exponent+"f",normalized_value));
        }

        return normalized_vector;

    }

    public static void main(String[] args) {
//        double[] vector = {1000.01,2000.05,3000.255,4000.55,5000.555,6000.255};
        double[] vector = {-1000.01,-2000.05,-3000.255,-4000.55,-5000.555,-6000.255};
//        double[] vector = {0.65,0.23};
              System.out.println("Original Vector  = "+ Arrays.toString(vector));
        System.out.println("Normalized Vector Using Decimal Scaling = "+ Arrays.toString(get_decimal_scaling_normalized_vector(vector)));

    }

}
