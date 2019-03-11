import java.util.*;

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
    end = data.length - 1;
    int rando = (int) (Math.random() * (data.length));
    int pivot = data[rando];
    data[rando] = data[0];
    data[0] = pivot;
    while (start < end) {
      if (data[start] > pivot) {
        while (data[end] > pivot && end > start) {
          end--;
        }
        int s = data[start];
        int e = data[end];
        data[start] = e;
        data[end] = s;
      }
      start++;
    }
    if (data[start] < pivot) {
      data[0] = data[start];
      data[start] = pivot;
    }
    else if (data[start - 1] < pivot){
      data[0] = data[start - 1];
      data[start - 1] = pivot;
      start -= 1;
    }
    else {
      data[0] = data[start - 2];
      data[start - 2] = pivot;
      start -= 2;
    }
    return start;
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
  //  System.out.println(makeAllWords(2, 3));
  //  System.out.println(makeAllWords(2, 20));
  //  System.out.println(makeAllWords(5, 7));
    int[] ary = {17,61,67,47,93,12,20,4,44,78};
    System.out.println(partition(ary, 0, ary.length));
  }
}
