/**Q. 35: Computer-Assisted Instruction
 *          Provides two random single digit numbers to practice multiplication.
 *          Checks and verifies answers. 
 */
import java.util.Random;
import java.util.Scanner;
public class cai{
    public static int[] newQues(){
        Random r = new Random();
        int q[] = {r.nextInt(10), r.nextInt(10)};
        return(q);
    }

    public static Boolean check(int ans, int q[]){
        if (q[0]*q[1] == ans){
            return(true);
        }
        return(false);
    }

    public static void main(String a[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Computer Aided Instruction : Multiplication");
        System.out.println("Enter y to continue and n to exit.");
        char ch = sc.next().charAt(0);
        while(ch!='n' && ch!= 'N'){
            int x[] = newQues();
            while(true){
                System.out.println("What is "+x[0]+" multipled by "+x[1]+"?");
                int y = sc.nextInt();
                if(check(y, x)){
                    System.out.println("Very good!");
                    break;
                }
                else{
                    System.out.println("Try again.");
                }
            }
            System.out.println("Enter y to continue and n to exit.");
            ch = sc.next().charAt(0);
        }
    }
}