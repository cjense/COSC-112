public class OddSum {
    public static void main(String args[]) {
        public int oddSum(int n) {
            if(n % 2 != 0) {
                return oddSum(n) + oddSum(n-1);
            } else {
                return 0;
            }
        }
        OddSum(4);
    }
}