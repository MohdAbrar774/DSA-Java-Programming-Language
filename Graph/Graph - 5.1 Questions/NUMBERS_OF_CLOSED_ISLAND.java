import java.util.*;

public class NUMBERS_OF_CLOSED_ISLAND {
    static class Grid {
        int i;
        int j;

        public Grid(int i, int j) {
            this.i = i;
            this.j = j;
        }

    }

    static int[][] directions = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

    public static boolean bfs(int X, int Y, int m, int n, int[][] mat, boolean[][] vis) {

        Queue<Grid> q = new LinkedList<>();
        vis[X][Y] = true;
        q.offer(new Grid(X, Y));
        boolean isClosed = true;

        while (!q.isEmpty()) {
            Grid curr = q.poll();

            int x = curr.i;
            int y = curr.j;

            //check in all 4 directions
            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                if (newX < 0 || newX >= m || newY < 0 || newY >= n) {
                    isClosed = false;
                } else if (!vis[newX][newY] && mat[newX][newY] == 0) {
                    q.offer(new Grid(newX, newY));
                    vis[newX][newY] = true;
                }
            }
        }
        return isClosed;
    }

    public static int NoClosed(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        boolean[][] vis = new boolean[m][n];

        int island = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                //0 = island , 1 = water
                if (!vis[i][j] && mat[i][j] == 0 && bfs(i, j, m, n, mat, vis)) {
                    island++;
                }
            }
        }

        return island;
    }
    public static void main(String[] args) {
        int mat[][] = {{0, 0, 0, 0, 0, 0, 0, 1},
                       {0, 1, 1, 1, 1, 0, 0, 1},
                       {0, 1, 0, 1, 0, 1, 0, 1},
                       {0, 1, 1, 1, 1, 0, 1, 0},
                       {0, 0, 0, 0, 0, 0, 0, 1}};

                       System.out.println(NoClosed(mat));
    }

}
