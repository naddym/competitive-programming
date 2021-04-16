/**

    Print following pattern

    *
    **
    ***
    ****
    *****
*/

public class Pattern1 {

    public void pattern(int n) {
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}