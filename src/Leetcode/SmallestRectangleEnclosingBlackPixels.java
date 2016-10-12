package Leetcode;

public class SmallestRectangleEnclosingBlackPixels {
    public int minArea(char[][] image, int x, int y) {
        int m = image.length;
        if (m == 0) {
            return 0;
        }
        int n = image[0].length;
        
        // find top row boundary;
        int b = 0, e = x;
        int topRow = x;
        while (b <= e) {
            int mid = b + (e - b) / 2;
            boolean midRow = rowHasOne(image, m, n, mid);
            if (midRow && (mid == 0 || !rowHasOne(image, m, n, mid - 1))) {
                topRow = mid;
                break;
            } else if (midRow) {
                e = mid - 1;
            } else {
                b = mid + 1;
            }
        }
        
        // find botom row boundary;
        b = x;
        e = m - 1;
        int bottomRow = x;
        while (b <= e) {
            int mid = b + (e - b) / 2;
            boolean midRow = rowHasOne(image, m, n, mid);
            if (midRow && (mid == m - 1 || !rowHasOne(image, m, n, mid + 1))) {
                bottomRow = mid;
                break;
            } else if (midRow) {
                b = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        
        //find left column boundary
        b = 0;
        e = y;
        int leftCol = y;
        while (b <= e) {
            int mid = b + (e - b) / 2;
            boolean midCol = columnHasOne(image, m, n, mid);
            if (midCol && (mid == 0 || !columnHasOne(image, m, n, mid - 1))) {
                leftCol = mid;
                break;
            } else if (midCol) {
                e = mid - 1;
            } else {
                b = mid + 1;
            }
        }
        
        //find right column boundary
        b = y;
        e = n - 1;
        int rightCol = y;
        while (b <= e) {
            int mid = b + (e - b) / 2;
            boolean midCol = columnHasOne(image, m, n, mid);
            if (midCol && (mid == n - 1 || !columnHasOne(image, m, n, mid + 1))) {
                rightCol = mid;
                break;
            } else if (midCol) {
                b = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        
        return (bottomRow - topRow + 1) * (rightCol - leftCol + 1); 
    }
    
    private boolean rowHasOne(char[][] image, int m, int n, int row) {
        if (row < 0 || row >= m) {
            return false;
        }
        
        for (int j = 0; j < n; j++) {
            if (image[row][j] == '1') {
                return true;
            }
        }
        return false;
    }
    
    private boolean columnHasOne(char[][] image, int m, int n, int col) {
        if (col < 0 || col >= n) {
            return false;
        }
        
        for (int i = 0; i < m; i++) {
            if (image[i][col] == '1') {
                return true;
            }
        }
        return false;
    }
}
