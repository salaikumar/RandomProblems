/* IMPORTANT: class must not be public. */


// uncomment this if you want to read input.
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;


class TestClass {


    public static void main(String args[] ) throws Exception {

        int[][] inputM;
        int[]   output;
        int[]   line1;
        int[]   line2;
    	
        /*
         * Read input from stdin and provide input before running
		 */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        inputM  = new int[N+1][N+1];
        output = new int[N+1];
        line1  = new int[2];
        line2  = new int[2];

        for (int i = 1; i < N; i++) {
            inputM[i][0] = input.nextInt();
            inputM[i][1] = input.nextInt();
            inputM[i][2] = input.nextInt();
        }

        int Q = input.nextInt();
        int[] questions = new int[Q];
        for(int j=0; j < Q; j++){
            questions[j] = input.nextInt() ;
        }


//       Loop and Calculate if lines are perpendicular.
        for(int x=1; x<N+1; ++x){

            line1[0] = inputM[x][0];
            line1[1] = inputM[x][1];

            for( int y = 1; y < N+1; ++y){
                line2[0] = inputM[y][0];
                line2[1] = inputM[y][1];
                int value = (line1[0] * line2[0]) + (line1[1] * line2[1]);
                if(value == 0)
                    output[x]++;
            }
        }

//		 Print the result as per the question
        for(int z = 0 ; z < Q; ++z){
            System.out.println(output [ questions[z] ] );
        }

    }
}
