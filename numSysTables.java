/**Q. 34: Table of Binary, Octal and Hexadecimal Numbers
 *          Prints conversion tables for decimal numbers 1 to 256.
 */

public class numSysTables{
    public static String toBin(int n){
        String bin = "";
        while(n > 0){
            int x = n % 2;
            bin = bin + ((char)(x+48));
            n = n / 2;
        }
        String finbin = "";
        for(int i= bin.toCharArray().length - 1; i>=0; i--){
            finbin += bin.toCharArray()[i];
        }
        return(finbin);
    }

    public static String toOct(int n){
        String oct = "";
        while(n > 0){
            int x = n % 8;
            oct = oct + ((char)(x+48));
            n = n / 8;
        }
        String finoct = "";
        for(int i=oct.toCharArray().length - 1; i>=0; i--){
            finoct += oct.toCharArray()[i];
        }
        return(finoct);
    }

    public static String toHex(int n){
        char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        String hex = "";
        while(n > 0){
            int x = n % 16;
            hex = hex + hexDigits[x];
            n = n / 16;
        }
        String finhex = "";
        for(int i=hex.toCharArray().length - 1; i>=0; i--){
            finhex += hex.toCharArray()[i];
        }
        return(finhex);
    }

    public static void main(String a[]){
        System.out.println("Decimal\t\tBinary\t\tOctal\t\tHexadecimal");
        for(int i=1; i<=256; i++){
            System.out.println(i+"\t\t"+toBin(i)+"\t\t"+toOct(i)+"\t\t"+toHex(i));
        }
    }
}