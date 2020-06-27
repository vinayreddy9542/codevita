/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codevita;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author reddy
 */
public class Bank_Compare {
    public static void main(String[] sai) throws IOException{
        //input start
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        double principal = Double.parseDouble(bf.readLine());
        int years = Integer.parseInt(bf.readLine());
        //bank 1
        int n1 = Integer.parseInt(bf.readLine());
        int[] arrn1 = new int[n1];
        double[] arr1 = new double[n1];
        double sum1 =0;
        for(int i=0;i<n1;i++){
            String str = bf.readLine();
            String[] ss = str.split(" ");
            arrn1[i] = Integer.parseInt(ss[0]);
            arr1[i] = Double.parseDouble(ss[1]);
            double emi = principal*(arr1[i]/(1-(1/(Math.pow((1+arr1[i]),arrn1[i]*12)))));
            sum1+=emi;
        }
        //bank 2
        int n2 = Integer.parseInt(bf.readLine());
        int[] arrn2 = new int[n2];
        double[] arr2 = new double[n2];
        double sum2 = 0;
        for(int i=0;i<n1;i++){
            String str = bf.readLine();
            String[] ss = str.split(" ");
            arrn2[i] = Integer.parseInt(ss[0]);
            arr2[i] = Double.parseDouble(ss[1]);
            double emi = principal*(arr2[i]/(1-(1/(Math.pow((1+arr2[i]),arrn2[i]*12)))));
            sum1+=emi;
        }
        //input over
        if(sum1<sum2){
            System.out.println("A");
        }
        else{
            System.out.println("B");
        }
    }
}
