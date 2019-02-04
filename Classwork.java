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
  public static void main(String[] args) {
    System.out.println(makeAllWords(2, 3));
    System.out.println(makeAllWords(2, 20));
  }
}
