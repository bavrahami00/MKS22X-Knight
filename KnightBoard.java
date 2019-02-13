public class KnightBoard {
  int[][] board;
  public KnightBoard(int rows, int cols) {
    board = new int[rows][cols];
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
      ans += board[x][board[x].length-1];
      ans += "\n";
    }
    return ans;
  }
  public boolean add(int row, int col, int value) {
    try {
      if (board[row][col] != 0) {
        return false;
      }
    }
    catch (ArrayIndexOutOfBoundsException a) {
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
  public boolean solve(int startRow, int startCol) {
    if (!isEmpty()) {
      throw new IllegalStateException();
    }
    try {
      board[startRow][startCol] = 1;
    }
    catch (ArrayIndexOutOfBoundsException a) {
      throw new IllegalArgumentException();
    }
    boolean ans = solveHelper(startRow,startCol,1);
    if (!ans) {
      board[startRow][startCol] = 0;
    }
    return ans;
  }
  private boolean solveHelper(int row,int col,int index) {
    if (index == board.length * board[0].length) {
      return true;
    }
    int[] hops = new int[] {row+2,col+1,row+2,col-1,row-2,col+1,row-2,col-1,row+1,col+2,row+1,col-2,row-1,col+2,row-1,col-2};
    for (int x = 0; x < hops.length; x += 2) {
      if (add(hops[x],hops[x+1],index+1)) {
        if (solveHelper(hops[x],hops[x+1],index+1)) {
          return true;
        }
        remove(hops[x],hops[x+1]);
      }
    }
    return false;
  }
  public int countSolutions(int startRow, int startCol) {
    if (!isEmpty()) {
      throw new IllegalStateException();
    }
    try {
      board[startRow][startCol] = 1;
    }
    catch (ArrayIndexOutOfBoundsException a) {
      throw new IllegalArgumentException();
    }
    int ans = count(startRow,startCol,1);
    board = new int[board.length][board[0].length];
    return ans;
  }
  private int count(int row,int col,int index) {
    if (index == board.length * board[0].length) {
      return 1;
    }
    int ans = 0;
    int[] hops = new int[] {row+2,col+1,row+2,col-1,row-2,col+1,row-2,col-1,row+1,col+2,row+1,col-2,row-1,col+2,row-1,col-2};
    for (int x = 0; x < hops.length; x += 2) {
      if (add(hops[x],hops[x+1],index+1)) {
        ans += count(hops[x],hops[x+1],index+1);
        remove(hops[x],hops[x+1]);
      }
    }
    return ans;
  }
}
