public class ToyCar {
    public int numberOfBlockReached(int[][] board, int x){
        //Edge case
        if (board.length==0) return 0;
        //Initialize row, col and reached block count
        int m = board.length;
        int n = board[0].length;
        int reachedBlock = 0;
        //Tracking variables
        int digitSum;
        int rowValue = 0;
        //Go through grid
        for (int i=0; i<m; i++){
            //Set total digit sum back to zero
            digitSum = 0;
            //Initialize row digit to track integer value >= 10
            int rowDigits = i;
            //row digit calculation
            while (rowDigits>0){
                digitSum += rowDigits %10;
                rowValue = digitSum;
                rowDigits /= 10;
            }
            for (int j=1; j<n;j++){
                //Initialize column digit to track integer value >= 10
                int colDigits = j;
                //column digit calculation
                while (colDigits>0){
                    digitSum += colDigits %10;
                    colDigits /= 10;
                }
                //It will break column when its > x
                if (digitSum>x){
                    break;
                }
                //Increment reached block
                reachedBlock++;
                //Keep digit sum to current row value to calculate with column digits
                digitSum = rowValue;
            }
        }
        return reachedBlock;
    }
    public static void main(String[] args) {
        int[][] arr = new int[20][20];
        ToyCar tc = new ToyCar();
        System.out.println(tc.numberOfBlockReached(arr,8));
    }
}
