// Written by Aakash Nadupalli

//2. Write a program to perform correlation analysis between two numeric attributes and specify
//        whether they are positively correlated, negatively correlated or independent.

// Formula =     Summation((x - meanofx)(y - meanofy))  /    Squareroot( product(      summation(square(x-meanofx)) and  summation(square(y-meanofy))  ) )

import java.util.Arrays;

public class Program_02 {
    public static double calculate_correlation(double[] X,double[] Y){
        double r = 0;

        double X_mean = Arrays.stream(X).average().getAsDouble();
        double Y_mean = Arrays.stream(Y).average().getAsDouble();

        double numerator = 0;
        for(int i=0;i<X.length;i++){
            numerator+= ( (X[i]-X_mean) * (Y[i]-Y_mean));
        }

        double denom_x = Math.sqrt(Arrays.stream(X).map(x->Math.pow(x-X_mean,2)).sum());
        double denom_y = Math.sqrt(Arrays.stream(Y).map(y->Math.pow(y-Y_mean,2)).sum());

        r = numerator/(denom_x*denom_y);

        return r;
    }
    public static void tell_correlation_type(double r){
        if(r<0){
            System.out.println("Correlation Type =  Negatively Correlated");
        }
        else if(r>0){
            System.out.println("Correlation Type =  Positively Correlated");
        }
        else{
            System.out.println("Correlation Type =  Both are Independent ");
        }
    }
    public static void main(String[] args) {
        double[] X_observations = {8,2,6,4,2};
        double[] Y_observations = {98,75,87,82,72};
        System.out.println("Correlation Coefficient = "+String.format("%.2f",calculate_correlation(X_observations,Y_observations)));
        tell_correlation_type(calculate_correlation(X_observations,Y_observations));
    }
}
