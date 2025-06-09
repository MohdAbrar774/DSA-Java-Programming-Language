public class FLOOD_FILL {

    public static void floodFillUtil(int[][] image, int sr, int sc, int color, boolean[][] vis, int orgColor) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || vis[sr][sc]
                || image[sr][sc] != orgColor) {

            return;
        }

        image[sr][sc] = 2;
        vis[sr][sc] = true;

        // left
        floodFillUtil(image, sr, sc + 1, color, vis, orgColor);

        // right
        floodFillUtil(image, sr, sc - 1, color, vis, orgColor);

        // up
        floodFillUtil(image, sr - 1, sc, color, vis, orgColor);
        // down
        floodFillUtil(image, sr + 1, sc, color, vis, orgColor);

    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {

        boolean[][] vis = new boolean[image.length][image[0].length];

        floodFillUtil(image, sr, sc, color, vis, image[sr][sc]);

        return image;
    }

    public static void main(String[] args) {

        int[][] image = { { 1, 1, 1 },
                { 1, 1, 0 },
                { 1, 0, 1 } };

        int ans[][] = floodFill(image, 1, 1, 1);

        for (int[] a : ans) {

            System.out.print(a[0] + " ");
            System.out.print(a[1] + " ");
            System.out.print(a[2] + " ");
            System.out.println();

        }

    }
}
