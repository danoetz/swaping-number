import java.util.*;

public class swap 
{

  static int numAuto = 0;
  static int numManual = 0;
  static Scanner in = new Scanner(System.in);

    public static void main(String[] args) 
    {        
        System.out.print("=== Swap number app ===\n");

        question();
    }

    private static void question() {
      System.out.print("Running sample input output? [Yes|No] (Yes) ");
      String choosen = in.nextLine();

      String isAuto = choosen.length() == 0 ? "yes" : choosen.toLowerCase();

      if (isAuto.equals("yes")){
        autoRun();
      } else if (isAuto.equals("no")) {
        System.out.print("Type an array of number (separate by space): ");
        String s = in.nextLine(); 
        System.out.println("input: " + s + "\n");

        String[] array = s.split(" ");
        List<String> swapList = new ArrayList<>(Arrays.asList(array));
        askQuestion(swapList);
      } else {
        System.out.println("Wrong answer! This is YES or NO question.\n");
        question();
      }
    }

    private static void autoRun() {
      
      String[] array = { "4", "9", "7", "5", "8", "9", "3" };
      List<String> list = new ArrayList<>(Arrays.asList(array));

      String sampleArray = String.join(" ", list);
      System.out.println("Sample input: " + sampleArray + "\n");

      System.out.println("Sample output: ");
      swapAndPrint(list, 7, 9, 1, 2);
      swapAndPrint(list, 5, 9, 2, 3);
      swapAndPrint(list, 5, 7, 1, 2);
      swapAndPrint(list, 8, 9, 3, 4);
      swapAndPrint(list, 3, 9, 5, 6);
      swapAndPrint(list, 3, 9, 4, 5);
      swapAndPrint(list, 3, 8, 3, 4);
      swapAndPrint(list, 3, 7, 2, 3);
      swapAndPrint(list, 3, 5, 1, 2);
      swapAndPrint(list, 3, 4, 0, 1);

      System.out.println("Jumlah swap: " + numAuto);

    }

    private static void swapAndPrint(List<String> list, int x, int y, int a, int b) {
        numAuto++;
        Collections.swap(list, a, b);
        String result = String.join(" ", list);
        System.out.println(numAuto+ ". [" + x +","+ y + "] -> " + result);

    }

    private static void askQuestion(List<String> list) {

      System.out.print("Type two number to swap (separate by space): ");
      String ab = in.nextLine();

      if (ab.length() == 0) {
        System.out.println("Jumlah swap: " + numManual);
      } else {
        String[] arr = ab.split(" ");
        String a = arr[0];
        String b = arr[1];

        int j = 0;
        for (j = 0; j < list.size(); j++) {
          
          if(list.get(j).equals(arr[1])) {
            // System.out.println(arr[1] + " = " + list.get(j));
            if(list.get(j-1).equals(arr[0])) {
              // System.out.println(arr[0] + " = " + list.get(j-1));
              numManual++;
              Collections.swap(list, j-1, j);
              String result = String.join(" ", list);
              System.out.println(numManual+ ". [" + a +","+ b + "] -> " + result);

              askQuestion(list);
            } else {
              System.out.println("Numbers can only be swapped if they are in sequence.");
              askQuestion(list);
            }
            
          }
        } 
      }
    }

}

