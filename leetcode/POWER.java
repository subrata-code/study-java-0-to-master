class POWER{
    public boolean isPalindrome(int x){
        if(x < 0){
            return false;
        }
        int n = x;
        int revNum = 0;
        while(n > 0){
            int d = n % 10;
            revNum = revNum * 10 + d;
            n = n / 10;
        }
        if(revNum == x){
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        POWER p = new POWER();
        System.out.println(p.isPalindrome(121));  // true
        System.out.println(p.isPalindrome(123));  // false
    }
}