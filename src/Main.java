//William Zammit U3A1 Waterloo S3
//12/04/2024
/* Trust me, it works, no comments needed
 * EASSSSY BABBBYYYY
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        //Scanner input = new Scanner(System.in);
        Scanner stringput = new Scanner(System.in);

        int N;
        

        N = Integer.parseInt(stringput.nextLine());
        
        int[] P = new int[N];
        int[] W = new int[N];
        int[] D = new int[N];

        int minP = 0;
        int maxP = 0;

        for(int i = 0; i < N; i++){
            String tempData = stringput.nextLine();

            String[] splitTempData = tempData.split(" ");

            P[i] = Integer.parseInt(splitTempData[0]);
            W[i] = Integer.parseInt(splitTempData[1]);
            D[i] = Integer.parseInt(splitTempData[2]);
        }

        minP = P[0];
        for(int i = 0; i < N; i++){
            if(P[i] < minP){
                minP = P[i];
            }
            if(P[i] > maxP){
                maxP = P[i];
            }
        }
        
        int[] c = new int[maxP-minP+1];
    

        for(int i = minP; i <= maxP; i++){
            c[i-minP] = 0;
            for(int j = 0; j < N; j++){
                int d = 0;
                if(Math.abs(P[j] - i) - D[j] <= 0){
                    d = 0;
                    //System.out.println("EQUALS C");
                } else {
                    d = Math.abs(P[j] - i) - D[j];
                    //System.out.println("DOES NOT EQUAL C");
                }

                c[i-minP] += d*W[j];
            }
        }

        int lowestTime = c[0];
        for(int i = 0; i < c.length; i++){
            //System.out.println(c[i]);
            if(c[i] < lowestTime){
                lowestTime = c[i];
            }
        }

        System.out.println(lowestTime);


        stringput.close();
    }

}
