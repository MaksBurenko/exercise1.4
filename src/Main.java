import java.util.*;

public class Main {
    public static void main(String[] args) {

        int i = 0;
        int j = 0;
        int n = 0;
        int k = 0;
        long sumOld = 0;
        long sumNew = 0;
        long result = 0;

        List <Long> list = new ArrayList<>();

        Map<Integer, ArrayList<Long>> map = new TreeMap<>();

        try {

     //   Scanner scanner = new Scanner(System.in);
            Scanner scanner = new Scanner("5 2" + "\n" + "1  7  10  5  777 555 525 12");

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

        for (long temp : list) {
            sumOld += temp;
            map.put(scanNumbers(temp), new ArrayList<>());
        }

        for(long temp : list){
            int t = scanNumbers(temp);
            for (Integer key : map.keySet()) {
               if(t==key){
                   map.get(key).add(temp);
               }
            }
        }

            System.out.println(map);

        } catch (IndexOutOfBoundsException | NoSuchElementException e) {
            e.printStackTrace(System.out);
        }
    }

    public static int scanNumbers (long number){
        return (int)Math.log10(number) + 1;
    }
}





