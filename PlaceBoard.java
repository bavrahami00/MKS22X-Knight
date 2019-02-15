import java.util.ArrayList;
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
    ArrayList<Integer> hops = new ArrayList<Integer>();
    hops.add(row+2);  hops.add(col+1);
    hops.add(row+2);  hops.add(col-1);
    hops.add(row-2);  hops.add(col+1);
    hops.add(row-2);  hops.add(col-1);
    hops.add(row+1);  hops.add(col+2);
    hops.add(row+1);  hops.add(col-2);
    hops.add(row-1);  hops.add(col+2);
    hops.add(row-1);  hops.add(col-2);
    for (int x = 0; x < hops.size(); x += 2) {
      try {
        if (board[hops.get(x)][hops.get(x+1)] != 0) {
          hops.remove(x);
          hops.remove(x);
          x -= 2;
        }
      }
      catch (ArrayIndexOutOfBoundsException a) {
        hops.remove(x);
        hops.remove(x);
        x -= 2;
      }
    }
    int[] ans = new int[hops.size()];
    int so = 0;
    while (hops.size() > 0) {
      int small = 9;
      int num = -1;
      for (int x = 0; x < hops.size(); x += 2) {
        if (places[hops.get(x)][hops.get(x+1)] < small) {
          num = x;
          small = places[hops.get(x)][hops.get(x+1)];
        }
      }
      ans[so] = hops.get(num);
      ans[so+1] = hops.get(num+1);
      hops.remove(num);
      hops.remove(num);
      so += 2;
    }
    return ans;
  }
}
