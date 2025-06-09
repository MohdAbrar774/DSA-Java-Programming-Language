import java.util.*;

public class MAX_AREA_OF_ISLAND {
     static class Grid {
        int i;
        int j;

        public Grid(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    static int[][] direction = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public static int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<Grid> q = new LinkedList<>();
        int maxArea = 0;

        boolean[][] vis = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (!vis[i][j] && grid[i][j] == 1) {
                    q.add(new Grid(i, j));
                    vis[i][j] = true;
                    int currArea = 1;
                    while (!q.isEmpty()) {
                        Grid curr = q.remove();
                        int x = curr.i;
                        int y = curr.j;

                        for (int[] dir : direction) {
                            int newX = x + dir[0];
                            int newY = y + dir[1];

                            if (newX >= 0 && newX < m && newY >= 0 && newY < n && grid[newX][newY] == 1
                                    && !vis[newX][newY]) {
                                currArea += 1;
                                q.add(new Grid(newX, newY));
                                vis[newX][newY] = true;
                            }
                        }

                    }
                    maxArea = Math.max(currArea, maxArea);
                }
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[][] grid = {{0, 0, 1, 1, 0},
                        {0, 0, 1, 1, 0},
                        {0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 1}};

                        System.out.println(maxAreaOfIsland(grid));
    }
}
