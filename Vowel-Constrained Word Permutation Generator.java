import java.util.*;

public class Main {
  static HashSet<String> record;
  static int count;
  static String give;

  public static void robot(String current, boolean last, String store) { // this section repeats the process of picking
                                                                         // a character out and attaching it
    if (current.length() == give.length()) { // once the possible arrangement is made with all the characters of the
                                             // word given this part checks if there is a duplicate, if there is it
                                             // won't be counted
      if (!record.contains(current)) {
        count = count + 1;
        record.add(current);
      }
      return;
    }
    for (int a = 0; a < store.length(); a++) { // this section of the runs through the give word and picks out one
                                               // character and attaches it to the new possible arrangement
      String uo = store.substring(0, a) + store.substring(a + 1, store.length());
      if (last) {
        if (store.charAt(a) != 'a' && store.charAt(a) != 'e' && store.charAt(a) != 'i' && store.charAt(a) != 'o'
            && store.charAt(a) != 'u') { // this line checks to make sure that the character is not a vowel
          robot(current + store.charAt(a), false, uo);
        }
      } else {
        if (store.charAt(a) != 'a' && store.charAt(a) != 'e' && store.charAt(a) != 'i' && store.charAt(a) != 'o'
            && store.charAt(a) != 'u') {
          robot(current + store.charAt(a), false, uo);
        } else {
          robot(current + store.charAt(a), true, uo);
        }
      }
    }
    return;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    count = 0; // a variable used to record the amount of possibilities
    System.out.println("Please enter a word in all lowercase letters:");
    give = sc.nextLine(); // input a word (all lowercase)
    record = new HashSet<String>(); // records the possibilities
    robot("", false, give);
    System.out.println("There are " + count + " amount of possibilities to arrange the word " + give
        + " if none of the vowels can be together."); // print the number of possibilities out
    System.out.println("Would you like to see all the possible arrangements? Y or N");
    String ask = sc.nextLine();
    if (ask.equals("Y")) {
      System.out.println("Here are all the possibilities:");
      for (String pastrecord : record) {
        System.out.println(pastrecord); // print the possibilities out
      }
    }
  }
}
