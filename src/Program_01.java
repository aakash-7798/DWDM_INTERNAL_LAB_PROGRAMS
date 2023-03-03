// Written by Aakash Nadupalli

//1. Write a program to remove noise by smoothing the data by bin means and bin boundaries.


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Program_01 {

    public static void BinMeans(double[] data , int binsize) {
        System.out.println("Smoothing by Bin Means : ");
        int ct=0;
        for (int i = 0; i < data.length; i = i + binsize) {
            int end_slice = i + binsize;
            if (end_slice < data.length) {
                end_slice = end_slice;
            } else {
                end_slice = data.length;
            }
            double[] sliced_data = Arrays.copyOfRange(data, i, end_slice);
            double mean = Arrays.stream(Arrays.copyOfRange(data, i, end_slice)).average().getAsDouble();
            Arrays.fill(sliced_data,mean);
            ct+=1;
            System.out.println("\t\t"+" Bin "+ct+" : "+Arrays.toString(sliced_data));
        }
    }

    public static void BinBoundaries(double[] data,int binsize){
        System.out.println("Smoothing by Bin Boundaries :");
        int ct = 0;
        for(int i=0;i<data.length;i=i+binsize){
            int end_slice = i + binsize;
            if (end_slice < data.length) {
                end_slice = end_slice;
            } else {
                end_slice = data.length;
            }
            ct+=1;
            double [] sliced_data = Arrays.copyOfRange(data,i,end_slice);
            double min_value = Arrays.stream(sliced_data).min().getAsDouble();
            double max_value = Arrays.stream(sliced_data).max().getAsDouble();
            for(int j=0;j<sliced_data.length;j++){
                if((sliced_data[j]-min_value) < (max_value-sliced_data[j]) ){
                    sliced_data[j] = min_value;
                }
                else{
                    sliced_data[j] = max_value;
                }
            }
            System.out.println("\t\t"+" Bin "+ct+" : "+Arrays.toString(sliced_data));
        }

    }

    public static void main(String[] args) {
        double[] data = {4, 8, 9, 15, 21, 21, 24, 25, 26, 28, 29, 34};
//        double[] data = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0};
//        double[] data = {-1.0, -2.0, -3.0, -4.0, -5.0, -6.0, -7.0, -8.0, -9.0, -10.0};
        int binSize = 4;
        int ct = 0;
        System.out.println("Partitioned Data ");
        for(int i =0;i< data.length;i+=binSize){
            int sz = i+binSize;
            ct+=1;
            if(binSize< data.length){sz=sz;}else{sz= data.length;}
            System.out.println("\t\t"+" Bin "+ct+" : "+Arrays.toString(Arrays.copyOfRange(data,i,sz)));
        }

        BinMeans(data,binSize);
        BinBoundaries(data,binSize);
    }


}
