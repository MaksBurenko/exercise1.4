import java.util.*;

public class Main {
    public static void main(String[] args) {

        int i = 0;
        int j = 0;
        int n = 0;
        int k = 0;
        List <Long> list = new ArrayList<>();

        try {

     //   Scanner scanner = new Scanner(System.in);
            Scanner scanner = new Scanner("5 2" + "\n" + "1  2  1  3  5");

        while (scanner.hasNextLine() && i<2) {
            switch (i) {
                case 0:
                    n = scanner.nextInt();
                    k = scanner.nextInt();

                case 1:
                    while (scanner.hasNext()){
                        list.add(scanner.nextLong());
                    }
            }
            i++;
        }

        Collections.sort(list);

        scanner.close();

        } catch (IndexOutOfBoundsException | NoSuchElementException e) {
            e.printStackTrace(System.out);
        }
    }
}







    int number = 123456;
    int numDigits = (int)Math.log10(number) + 1;





