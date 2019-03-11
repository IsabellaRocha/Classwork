import java.util.ArrayList;

public class Classwork {
  public static ArrayList<String> makeAllWords(int k, int maxLetter) {
    ArrayList<String> L = new ArrayList<String>();
    wordsHelp(k, "", maxLetter, L);
    return L;
  }
  public static void wordsHelp(int k, String word, int maxLetter, ArrayList<String> L) {
    if (k == 0) {
      L.add(word);
    }
    else {
      for (int idx = 0; idx < maxLetter; idx++) {
        wordsHelp(k - 1, word + (char)(97 + idx), maxLetter, L);
      }
    }
  }
  public static int partition (int[] data, int start, int end) {
    start = 1;
    end = data.length;
    int rando = (int) Math.random() * data.length;
    int pivot = data[rando];
    int temp = data[start];
    data[0] = pivot;
    data[rando] = temp;
    while (start < end) {
      if (data[start] > pivot) {
        int cur = data[start];
        int swap = data[end];
        data[start] = swap;
        data[end] = cur;
        start++;
      }
      if (data[end] < pivot) {
        int cur = data[end];
        int swap = data[start];
        data[start] = cur;
        data[end] = swap;
        end++;
      }
    }
    if (data[start] < pivot) {
      data[0] = data[start];
      data[start] = pivot;
      return start;
    }
    else {
      data[0] = data[start - 1];
      data[start - 1] = pivot;
      return start - 1;
    }
  }

  public static void insertionSort(int[] ary) {
    for (int idx = 1; idx < ary.length; idx++) {
      int current = ary[idx]; // Storing value for later to move
      int curIdx = idx - 1;
      while (curIdx >= 0 && ary[curIdx] > current) {
        ary[curIdx + 1] = ary[curIdx]; // Shifting values over
        curIdx--;
      }
      ary[curIdx + 1] = current;
    //  System.out.println(Arrays.toString(ary));
    }
  }

  public static void main(String[] args) {
    System.out.println(makeAllWords(2, 3));
    System.out.println(makeAllWords(2, 20));
    System.out.println(makeAllWords(5, 7));
  }
}
