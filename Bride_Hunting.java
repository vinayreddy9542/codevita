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
public class Bride_Hunting {
    static String ans="";
    static int max = 0;
    static int dist = Integer.MAX_VALUE;
    static int cout = 0;
    public static void main(String[] sai) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String rc = bf.readLine();
        String[] rr = rc.split(" ");
        int row = Integer.parseInt(rr[0]);
        int col = Integer.parseInt(rr[1]);
        int[][] arr = new int[row][col];
        for(int i=0;i<row;i++){
            rc = bf.readLine();
            String[] cc = rc.split(" ");
            for(int j = 0;j<col;j++){
                arr[i][j] = Integer.parseInt(cc[j]);
            }
        }
        findqualities(arr);
        System.out.println(ans);
    }

    private static void findqualities(int[][] arr) {
        int row = arr.length;
        int col = arr[0].length;
        int[][] qua = new int[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                int count = 0;
                if(!(i==0 && j==0)){
                    if(arr[i][j] == 1){
                        //top
                        if(i==0 && j<col-1){
                            if(arr[i][j-1]==1){
                                count++;
                            }
                            if(arr[i][j+1]==1){
                                count++;
                            }
                            if(arr[i+1][j]==1){
                                count++;
                            }
                            if(arr[i+1][j+1]==1){
                                count++;
                            }
                            if(arr[i+1][j-1]==1){
                                count++;
                            }
                        }
                        //top right
                        else if(i==0 && j==col-1){
                            if(arr[i][j-1]==1){
                                count++;
                            }
                            if(arr[i+1][j]==1){
                                count++;
                            }
                            if(arr[i+1][j-1]==1){
                                count++;
                            }
                        }
                        //left
                        else if(i<row-1 && j==0){
                            if(arr[i-1][j]==1){
                                count++;
                            }
                            if(arr[i+1][j]==1){
                                count++;
                            }
                            if(arr[i-1][j+1]==1){
                                count++;
                            }
                            if(arr[i+1][j+1]==1){
                                count++;
                            }
                            if(arr[i][j+1]==1){
                                count++;
                            }
                        }
                        //left bottom
                        else if(i==row-1 && j==0){
                            if(arr[i-1][j]==1){
                                count++;
                            }
                            if(arr[i][j+1]==1){
                                count++;
                            }
                            if(arr[i-1][j+1]==1){
                                count++;
                            }
                        }
                        //bottom
                        else if(i==row-1 && j<col-1){
                            if(arr[i][j-1]==1){
                                count++;
                            }
                            if(arr[i][j+1]==1){
                                count++;
                            }
                            if(arr[i-1][j-1]==1){
                                count++;
                            }
                            if(arr[i-1][j+1]==1){
                                count++;
                            }
                            if(arr[i-1][j]==1){
                                count++;
                            }
                        }
                        //bottom right
                        else if(i==row-1 && j==col-1){
                            if(arr[i-1][j]==1){
                                count++;
                            }
                            if(arr[i][j-1]==1){
                                count++;
                            }
                            if(arr[i-1][j-1]==1){
                                count++;
                            }
                        }
                        //right
                        else if(i<row-1 && j==col-1){
                            if(arr[i-1][j]==1){
                                count++;
                            }
                            if(arr[i+1][j]==1){
                                count++;
                            }
                            if(arr[i-1][j-1]==1){
                                count++;
                            }
                            if(arr[i+1][j-1]==1){
                                count++;
                            }
                            if(arr[i][j-1]==1){
                                count++;
                            }
                        }
                        //middle
                        else{
                            if(arr[i-1][j]==1){
                                count++;
                            }
                            if(arr[i+1][j]==1){
                                count++;
                            }
                            if(arr[i-1][j-1]==1){
                                count++;
                            }
                            if(arr[i+1][j-1]==1){
                                count++;
                            }
                            if(arr[i][j-1]==1){
                                count++;
                            }
                            if(arr[i-1][j+1]==1){
                                count++;
                            }
                            if(arr[i+1][j+1]==1){
                                count++;
                            }
                            if(arr[i][j+1]==1){
                                count++;
                            }
                        }
                    }
                }
                if(count>max){
                    max = count;
                    dist = Math.max(i, j);
                    ans = i+1+":"+(j+1)+":"+count;
                }
                else if(count == max){
                    int d = Math.max(i, j);
                    if(d == dist){
                        cout=2;
                    }
                    if(d<dist){
                        dist = d;
                        ans = i+1+":"+(j+1)+":"+count;
                    }
                }
                qua[i][j] = count;
            }
        }
    }
}
