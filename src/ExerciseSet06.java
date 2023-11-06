import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
public class ExerciseSet06 {
    public static void main(String[] args) {
        menu();
    }
    public static int[] getRandomArray(int size, int min, int max) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(min,max);
        }
        return arr;
    }
    public static void guessNumber() {
        Random rand = new Random();
        int num = rand.nextInt(0,20);
        Scanner scanner = new Scanner(System.in);
        System.out.println("I found a number between 1 and 20. Guess its value ...");
        while (true) {
            int i = scanner.nextInt();
            System.out.println("Your number: " + i);
            if (i < num) {
                System.out.println("My number is larger!");
            } else if (i > num) {
                System.out.println("My number is smaller!");
            } else {
                break;
            }
        }
        System.out.println("You got it!");
    }
    public static int find (String text, String pattern) {
        for (int i = 0; i < text.length(); i++) {
            if (i+pattern.length() > text.length()) {
                return -1;
            } else if (pattern.isEmpty()) {
                return -1;
            }
            int j = 0;
            while (text.charAt(i+j) == pattern.charAt(j)) {
                if (pattern.length() == j+1) {
                    return i;
                }
                j++;
            }
        }
        return -1;
    }
    public static void tourPlanner() {
        int tfinal = 0;
        String[] names;
        int[] heights;
        int[] dists;
        int v_u;
        int v_d;
        int v_h;
        int places = Terminal.readInt("Number of places (-1 for default route)");
        if (places == -1) {
            places = 3;
            names = new String[]{"A", "B", "C"};
            heights = new int[]{400, 1000, 500};
            dists = new int[]{0, 4, 12};
            v_u = 300;
            v_d = -500;
            v_h = 4;
        }
        else {
            names = new String[places];
            heights = new int[places];
            dists = new int[places];
            for (int i = 0; i < places; i++) {
                System.out.println(i + ". Place");
                names[i] = Terminal.readString("   Name ");
                heights[i] = Terminal.readInt("   Height [m] ");
                dists[i] = Terminal.readInt("   Dist. from start [km] ");
            }
            v_u = Terminal.readInt("Upward speed [m/h] ");
            v_d = Terminal.readInt("Downward speed [m/h] ")*-1;
            v_h = Terminal.readInt("Horizontal speed [km/h] ");
        }
        System.out.println(names[0] +" 0:00");
        for (int i = 1; i < places; i++) {
            int dDist = dists[i] - dists[i-1];
            int tPlain = dDist*60 / v_h; // t in min;
            int dHeight = (heights[i] - heights[i-1]);
            int tHeight = (dHeight > 0 ? dHeight / v_u : dHeight / v_d)*60;
            tfinal += (int) (tHeight > tPlain ? (0.5*tPlain + tHeight) : (0.5*tHeight + tPlain));
            System.out.printf("%s %d:%d\n", names[i], tfinal/60, tfinal%60);
        }
    }
    public static void menu() {
        while (true) {
            System.out.print(
                    """
                    
                    1 : Array Demo
                    2 : Rate Spiel
                    3 : String find()
                    4 : Tour Planer
                    0 : Beenden
                    """
            );
            switch (Terminal.readInt("Ihre Wahl")) {
                case 0:
                    return;
                case 1:
                    int size = Terminal.readInt("Größe des Arrays");
                    int min = Terminal.readInt("Mindestgröße der enthaltenen Zahlen");
                    int max = Terminal.readInt("Maximalgröße der enthaltenen Zahlen");
                    System.out.println(Arrays.toString(getRandomArray(size,min,max)));
                    break;
                case 2:
                    guessNumber();
                    break;
                case 3:
                    String string = Terminal.readString("String");
                    String pattern = Terminal.readString("Pattern");
                    System.out.println(find(string,pattern));
                    break;
                case 4:
                    tourPlanner();
                    break;
            }
        }
    }
}
