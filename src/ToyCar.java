public class ToyCar {
    public int numberOfBlockReached(int[][] board, int x){
        //Edge case
        if (board.length==0) return 0;
        //Initialize row, col and reached block count
        int m = board.length;
        int n = board[0].length;
        int reachedBlock = 0;
        //Go through grid
        for (int i=0; i<m; i++){
            //Need to set j = 1 because 0,0, 1,0, 2,0.... should not count as reached block
            for (int j=1; j<n;j++){
                //Calculate digit sum
                int digitSum = (i%10)+(i/10)+(j);
                //It will break column when its > x
                if (digitSum>x){
                    break;
                }
                //Increment reached block
                reachedBlock++;
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
