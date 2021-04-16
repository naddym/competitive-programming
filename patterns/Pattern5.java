/**

    Print following pattern
        
     *
    ***
   *****
    ***
     *
*/

public class Pattern5 {

    public void pattern(int n) {
        int space = n / 2;
        int star = 1;
        for (int i = 1; i <= n; i++){

            // print space
            for (int j = 1; j <= space; j++) {
                System.out.print(" ");
            }
            // print star
            for (int j = 1; j <= star; j++) {
                System.out.print("*");
            }

            if (i <= n / 2){
                space--;
                star = star + 2;              
            } else {
                space++;
                star = star - 2; 
            }

            System.out.println();
        }
    }
}