package com.satyam.ds.graph;

/**

 Time Complexity = O (row * col)

 Idea:
    Use dfs.

 */
public class IslandCounter {

    private static final int[] NODE_NEIGHBOURS_X = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
    private static final int[] NODE_NEIGHBOURS_Y = new int[]{-1, 0, 1, -1, -1, -1, 0, 1};
    private static final int ROW = 5;
    private static final int COL = 5;

    private static int getNumberOfIslands(int[][] mtx) {
        boolean[][] visited = new boolean[ROW][COL];
        int count = 0;

        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (mtx[i][j] == 1 && !visited[i][j] ) {
                    applyDfs(mtx, visited, i, j);
                    count++;
                }
            }
        }

        return count;
    }

    private static void applyDfs(int[][] mtx, boolean[][] visited, int row, int col) {

        visited[row][col] = true;

        for (int k = 0; k < 8; k++) {
            int nextRow = row + NODE_NEIGHBOURS_X[k];
            int nextCol = col + NODE_NEIGHBOURS_Y[k];
            if (isSafe(mtx, visited, nextRow, nextCol)) {
                applyDfs(mtx, visited, nextRow, nextCol);
            }
        }
    }

    private static boolean isSafe(int[][] mtx, boolean[][] visited, int nextRow, int nextCol) {
        return nextRow >= 0 && nextRow < ROW
                && nextCol >= 0 && nextCol < COL
                && mtx[nextRow][nextCol] == 1
                && !visited[nextRow][nextCol];
    }

    public static void main(String[] args) {
        int[][] mtx = new int[][] { { 1, 1, 0, 0, 0 },
                { 0, 1, 0, 0, 1 },
                { 1, 0, 0, 1, 1 },
                { 0, 0, 0, 0, 0 },
                { 1, 0, 1, 0, 1 } };
        System.out.println("Number of islands: " + getNumberOfIslands(mtx));
    }
}
