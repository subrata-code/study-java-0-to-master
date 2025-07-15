public class pyramid {

    public static void main (String args[]){

        int n = 4;
    
        System.out.println("Reverse half pyramid");

        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }
}