public class invert{
    public static void main(String[] args) {
        int n = 8;
        //int number=1;
        System.out.println("inverted half pyramid rotated 180 degrees");

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                int sum =i+j;
                if (sum %2 == 0){
                    System.out.print("1    ");
                }
                else{
                    System.out.print("0    ");
                }
            }
            System.out.println();
        }
    }
}