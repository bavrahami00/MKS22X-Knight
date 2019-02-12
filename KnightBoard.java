public class KnightBoard {
  int[][] data;
  public KnightBoard(int rows, int cols) {
    data = new int[rows][cols];
  }
  public String toString() {
    String ans = "";
    for (int x = 0; x < board.length; x++) {
      for (int i = 0; i < board[0].length-1; i++) {
        if (board[x][i] < 10) {
          ans += " ";
         }
         ans += board[x][i] + " ";
      }
      if (board[x][board[x].length-1] < 10) {
        ans += " ";
      }
      ans += board[x][board[x].length];
      if (x != board.length-1) {
        ans += "\n";
      }
    }
    return ans;
  }
  public boolean add(int row, int col, int value) {
    if (board[row][col] != 0) {
      return false;
    }
    board[row][col] = value;
    return true;
  }
  public void remove(int row, int col) {
    board[row][col] = 0;
  }
  private boolean isEmpty() {
    for (int x = 0; x < board.length; x++) {
      for (int i = 0; i < board[0].length; i++) {
        if (!add(x,i,0)) {
          return false;
        }
      }
    }
    return true;
  }
}
