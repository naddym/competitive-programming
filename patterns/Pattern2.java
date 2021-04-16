/**

    Print following pattern

    *****
    ****
    ***
    **
    *
    
*/

public class Pattern2 {

    public void pattern(int n) {
        for (int i = n; i >= 1; i--){
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}