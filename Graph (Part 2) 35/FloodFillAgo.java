import java.util.*;

public class FloodFillAgo {

private void helper(int[][] image, int sr, int sc, int color, boolean[][] vis, int orgcol) {
   if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || image[sr][sc] != orgcol || vis[sr][sc]) {
      return;
   }
   vis[sr][sc] = true;
   image[sr][sc] = color;

   helper(image, sr, sc-1, color, vis, orgcol); // left
   helper(image, sr, sc+1, color, vis, orgcol); // right
   helper(image, sr-1, sc, color, vis, orgcol); // up
   helper(image, sr+1, sc, color, vis, orgcol); // down
}
public int [][] floodFill(int[][] image, int sr, int sc, int color) {
      boolean vis[][] = new boolean[image.length][image[0].length];
      int orgcol = image[sr][sc];
      if (orgcol != color) {
         helper(image, sr, sc, color, vis, orgcol);
      }
      return image;
   }
   public static void main(String args[]) {
      FloodFillAgo ff = new FloodFillAgo();
      int image[][] = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
      int sr = 1, sc = 1, color = 2;
      int result[][] = ff.floodFill(image, sr, sc, color);
      for (int i = 0; i < result.length; i++) {
         for (int j = 0; j < result[0].length; j++) {
            System.out.print(result[i][j] + " ");
         }
         System.out.println();
      }
   }
}