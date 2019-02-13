public class PlaceBoard {//extends Comparable{
  int[][] board;
  int[][] places;
  public PlaceBoard(int[][] b) {
    board = b;
    places = new int[board.length][board[0].length];
    setup();
  }
  public void setup() {
    for (int x = 0; x < places.length; x++) {
      for (int i = 0; i < places[x].length; i++) {
        if ((x == 0 || x == places.length-1) && (i == 0 || i == places[x].length-1)) {
          places[x][i] = 2;
        }
        else if (Math.min(x,places.length-1-x)+Math.min(i,places[x].length-1-i) == 1) {
          places[x][i] = 3;
        }
        else if ((Math.min(x,places.length-1-x)+Math.min(i,places[x].length-1-i) == 2) || x == 0 || x == places.length-1 || i == 0 || i == places[x].length-1) {
          places[x][i] = 4;
        }
        else if (x == 1 || x == places.length-2 || i == 1 || i == places[x].length - 2) {
          places[x][i] = 6;
        }
        else {
          places[x][i] = 8;
        }
      }
    }
  }
  public String toString() {
    String ans = "";
    for (int x = 0; x < places.length; x++) {
      for (int i = 0; i < places[0].length-1; i++) {
        if (places[x][i] < 10) {
          ans += " ";
         }
         ans += places[x][i] + " ";
      }
      if (places[x][places[x].length-1] < 10) {
        ans += " ";
      }
      ans += places[x][places[x].length-1];
      ans += "\n";
    }
    return ans;
  }
  public int[] min(int row, int col) {
    int[] hops = new int[] {row+2,col+1,row+2,col-1,row-2,col+1,row-2,col-1,row+1,col+2,row+1,col-2,row-1,col+2,row-1,col-2};
    int[] ans = new int[2];
    int small = 9;
    for (int x = 0; x < hops.length; x += 2) {
      if (places[hops[x]][hops[x+1]] < min) {
        min = places[hops[x]][hops[x+1]];
        ans[0] = hops[x];
        ans[1] = hops[x+1];
      }
    }
    return ans;
  }
}
