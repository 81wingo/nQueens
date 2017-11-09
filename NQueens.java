
public class NQueens {
        public int[][] solution;
        public NQueens(int n) {
            solution = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    solution[i][j] = 0;
                }
            }
        }

        public void solve(int n) {
            if (placeQueens(0, n)) {
                //print
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        System.out.print(" " + solution[i][j]);
                    }
                    System.out.println();
                }
            } else {
                System.out.println("No Solution");
            }
        }

        public boolean placeQueens(int queen, int n) {
            // will place the queens one at a time
            if (queen == n) {
                //problem solved
                return true;
            }
            for (int row = 0; row < n; row++) {
                // check if queen can be placed 
                if (tryPlace(solution, row, queen)) {
                    // place queen
                    solution[row][queen] = 1;
                    // solve next queen
                    if (placeQueens(queen + 1, n)) {
                        return true;
                    }
                    //Back track
                    solution[row][queen] = 0; // have to figure out how to make this a space
                    
                }
            }

            return false;

        }

       // placement check row and diagonals
        public boolean tryPlace(int[][] matrix, int row, int column) {
        for (int i = 0; i < column; i++) {
            if (matrix[row][i] == 1) {
                return false;
            }
        }
        for (int i = row, j = column; i >= 0 && j >= 0; i--, j--) {
            if (matrix[i][j] == 1) {
                return false;
            }
        }
        for (int i = row, j = column; i < matrix.length && j >= 0; i++, j--) {
            if (matrix[i][j] == 1) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int N = 8;
        NQueens q = new NQueens(N);
        q.solve(N);
    }
}
