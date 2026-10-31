class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // have to update the adjacent neigbours of the pixel 
        // so basically we have to find the graph which contains all nodes ajacently connected with starting color
        // and change the colors of all those nodes to  given "color" 
        int m = image.length;
        int n = image[0].length;

        int starting_color = image[sr][sc];
        int[][] vis = new int[m][n];
        dfs(sr,sc,starting_color,color,vis,image);

        return image;
    }

    void dfs(int i , int j , int start, int newColor,int[][] vis, int[][] image){
        if(i  < 0 || i >= image.length || j < 0 || j >= image[0].length) return ;
        if(image[i][j] == newColor) return ; // cause it already has been visited or if not then it is not equal to starting color
        if(image[i][j] != start) return; // not a valid neighbour

        //vis[i][j] = 1; // mark this node as visited
        image[i][j] = newColor; // change the color of node to starting_color
        dfs(i+1,j,start,newColor,vis,image);
        dfs(i-1,j,start,newColor,vis,image);
        dfs(i,j+1,start,newColor,vis,image);
        dfs(i,j-1,start,newColor,vis,image);
    }
}