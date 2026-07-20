class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
         int m = grid.length;
        int n = grid[0].length;
        int total = m * n;

        k %= total;

        int[][] res = new int[m][n];

        for (int i = 0; i < total; i++) {
            int newIndex = (i + k) % total;

            int r1 = i / n;
            int c1 = i % n;

            int r2 = newIndex / n;
            int c2 = newIndex % n;

            res[r2][c2] = grid[r1][c1];
        }

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(res[i][j]);
            }
            ans.add(row);
        }

        return ans;
    }
}