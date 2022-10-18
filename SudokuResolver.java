public class SudokuResolver {
  static int[] VALUES = {1,2,3,4,5,6,7,8,9};

  boolean solve(int[][] board) {
    for (int row = 0; row < board.length; row++) {
      for (int column = 0; column < board[row].length; column++) {
        if (board[row][column] == 0) {
          for (int value: VALUES) {
            if (isValidPosition(board, value, row, column)) {
              board[row][column] = value;
              
              if (solve(board)) {
                return true;
              }

              board[row][column] = 0;
            }
          }
          return false;
        }
      }
    }
    return true;
  }

  private boolean isValidPosition(int[][] board, int value, int row, int column) {
    return isValueValidInRow(board, value, row)
            && isValueValidInColumn(board, value, column)
            && isValueValidInSquare(board, value, row, column);
  }

  private boolean isValueValidInRow(int[][] board, int value, int row) {
    for (int i = 0; i < board[row].length; i++) {
      if (board[row][i] == value) return false;
    }
    return true;
  }
  
  private boolean isValueValidInColumn(int[][] board, int value, int column) {
    for (int i = 0; i < board.length; i++) {
      if (board[i][column] == value) return false;
    }
    return true;
  }

  private boolean isValueValidInSquare(int[][] board, int value, int row, int column) {
    int squareRow = row - row % 3;
    int squareColumn = column - column % 3;

    for (int i = squareRow; i < squareRow + 3; i++) {
      for (int j = squareColumn; j < squareColumn + 3; j++) {
        if (board[i][j] == value) return false;
      }
    }
    return true;
  }

  void printBoard(int[][] board) {
    for (int i = 0; i < board.length; i++) {
      if (i % 3 == 0 && i != 0) {
        System.out.println("-----------");
      }
      for (int j = 0; j < board[i].length; j ++) {
        if (j % 3 == 0 && j != 0) {
          System.out.print("|");
        }
        System.out.print(board[i][j]);
      }
      System.out.println();
    }
  }

}
