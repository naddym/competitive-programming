/**

    Print following pattern
        
        *
       **
      ***
     ****
    *****
*/

public class Pattern3 {

    public void pattern(int n) {
        for (int i = 1; i <= n; i++){
            for (int j = n; j > i; j--) {
                System.out.print(" ");
            }

            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }
}