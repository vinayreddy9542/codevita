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
public class Skate_Board {
    static int[][] ar;
    public static void main(String[] sai) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String rc = bf.readLine();
        int n = Integer.parseInt(rc);
        String[][] arr = new String[n][n];
        for(int i=0;i<n;i++){
            rc = bf.readLine();
            String[] cc = rc.split(",");
            System.arraycopy(cc, 0, arr[i], 0, n);
        }
        //getting ar array
        
        System.out.println();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
        findpaths(arr);
        System.out.println();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(ar[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static void findpaths(String[][] arr) {
        int n = arr.length;
        ar =  new int[n][n];
        for(int i=n-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                String str = arr[i][j];
                //System.out.println(i+" "+j+" "+str);
                switch (str) {
                    case "F":
                        ar[i][j]=1;
                        break;
                    case "D":
                        ar[i][j]=0;
                        break;
                    default:
                        for(int k = 0;k<str.length();k++){
                            char ch = str.charAt(k);
                            switch(ch){
                                case 'N':
                                    if(ar[i][j]!=1){
                                        if(i>0){
                                            ar[i][j]=-1;
                                        }
                                    }
                                    break;
                                case 'S':
                                    if(ar[i][j]!=1){
                                        if(i<n-1){
                                            ar[i][j]=ar[i+1][j];
                                        }
                                    }
                                    break;
                                case 'E':
                                    if(ar[i][j]!=1){
                                        if(j<n-1){
                                            ar[i][j]=ar[i][j+1];
                                        }
                                    }
                                    break;
                                case 'W':
                                    if(ar[i][j]!=1){
                                        if(j>0){
                                            ar[i][j]=-1;
                                        }
                                    }
                                    break;
                            }
                        }
                        break;
                }
            }
        }
    }
}
