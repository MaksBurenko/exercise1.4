import java.util.*;

import static java.lang.Long.parseLong;

public class Main {
    public static void main(String[] args) {

        int n = 0;
        int k = 0;

        long sumOld = 0;
        long sumNew = 0;
        long result = 0;

        List <Long> list = new ArrayList<>();
        Map<Integer, ArrayList<Long>> map = new TreeMap<>();

        try {

            //   Scanner scanner = new Scanner(System.in);
            Scanner scanner = new Scanner("1  10" + "\n" + "9999");

            int i = 0;
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

            Set<Integer> keys = map.keySet();
            Integer[] arrayKeys = new Integer[keys.size()];
            arrayKeys = keys.toArray(arrayKeys);
            Arrays.sort(arrayKeys, Collections.reverseOrder());

            int j=0;

            for (Integer key : arrayKeys) {
                ArrayList<Long> values = map.get(key);
                ArrayList<Long> tempList = new ArrayList<>(values);

                for (long value : values) {
                    if(j < k) {
                        long newNumber = numberChange(value, key);

                        tempList.remove(value);
                        tempList.add(newNumber);

                        j++;
                    }
                    else{
                        break;
                    }
                }
                map.put(key, tempList);
            }
            for(Integer key : keys){
                long sum = sumValues(map.get(key));
                sumNew = sumNew + sum;
            }
            result = sumNew - sumOld;

        System.out.println(result);
    }

    public static int scanNumbers (long number){
        return (int)Math.log10(number) + 1;
    }

    public static long numberChange (long value, int key) {

        long newNumber = 0;
        StringBuilder stringNumber = new StringBuilder();

        long[] separatedNumbers = new long[key];
        for (int i = separatedNumbers.length-1; i >= 0; i--) {
            separatedNumbers[i] = value % 10;
            value = value / 10;
        }
        for (int temp = 0; temp < separatedNumbers.length; temp++){
            if (separatedNumbers[temp] < 9){
                separatedNumbers[temp] = 9;
                break;
            }
        }
        for (long number : separatedNumbers) {
            stringNumber.append(number);
        }
        newNumber = parseLong(stringNumber.toString());

        return newNumber;
    }

    public static long sumValues(ArrayList<Long> values){
        long sum = 0;
        for(long value : values){
           sum = sum + value;
        }
        return sum;
    }
}
