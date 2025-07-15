import java.util.*;
public class pattern2 {

    public static void main (String args[]){

        int n = 4;
        int m = 5;
        System.out.println("Rectangle");

        for (int i=1; i<=n; i++){

            for (int j=1; j<=m; j++){
                
                if (i==0 || j==0 || i==n || j==m) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
                System.out.println();
            }
        }

    }
}