class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean row[][]=new boolean[9][9];
        boolean col[][]=new boolean[9][9];
        boolean block[][]=new boolean[9][9];
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='.') continue;
                
                int num=board[i][j]-'1';
                
                if(row[i][num])
                    return false;
                
                row[i][num]=true;
                
                if(col[j][num])
                    return false;
                
                col[j][num]=true;
                
                if(block[(i/3)*3+(j/3)][num])
                    return false;
                
                block[(i/3)*3+(j/3)][num]=true;
                
            }
        }
        
        return true;
    }
}
