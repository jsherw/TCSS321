/*
 * @author James Sherwood
 * @Version 3/06/2022
 *
 * @TCSS 321 Discrete Structures I
 * @HW#8 Extra Credit Assignment
 * @Professor Teredesai
 *
 * Code for methods "range1", "range2", and "range3" provided by Professor Teredesai.
 */
import java.util.*;
public class RuntimeTest {
    public static void main(String[] args) {

        //Variable declarations
        int size = 1000;
        int diff;                   //Provided algorithms included unused return values.
        long startTime;
        long endTime;

        //Maps to store N values with corresponding run time tests.
        LinkedHashMap<Integer, Long> rangeTimes1 = new LinkedHashMap<>();
        LinkedHashMap<Integer, Long> rangeTimes2 = new LinkedHashMap<>();
        LinkedHashMap<Integer, Long> rangeTimes3 = new LinkedHashMap<>();

        // Loop to test run times of three alogrithms, doubling the size of N after each iteration.
        while (size <= 128000){
            ArrayMaker temp = new ArrayMaker(size);
            int[] numbers = temp.makeArray(temp.getSize());

            startTime = System.nanoTime();
            diff = range1(numbers);
            endTime = ((System.nanoTime() - startTime) / 1000000);
            rangeTimes1.put(size, endTime);

            startTime = System.nanoTime();
            diff = range2(numbers);
            endTime = ((System.nanoTime() - startTime) / 1000000);
            rangeTimes2.put(size, endTime);

            startTime = System.nanoTime();
            diff = range3(numbers);
            endTime = ((System.nanoTime() - startTime) / 1000000);
            rangeTimes3.put(size, endTime);

            //Store values, print according to range type.
            size *= 2;
        }

        //Print results of tests
        System.out.println("Algorithm Number One:" + "\n");
        dataTimes(rangeTimes1);
        System.out.println("""

                Algorithm Number Two:
                """);
        dataTimes(rangeTimes2);
        System.out.println("""
                
                Algorithm Number Three:
                """);
        dataTimes(rangeTimes3);

    }

    /**
     * Method: Test first algorithm (least efficient)
     * @param numbers ArrayMaker object
     * @return unused integer, for testing purposes.
     */
    public static int range1(int[] numbers){
        int maxDiff = 0;
        for (int i= 0; i < numbers.length; i++){
            for(int j = 0; j < numbers.length; j++){
                int diff = Math.abs(numbers[j] - numbers[i]);
                if (diff > maxDiff){
                    maxDiff = diff;
                }
            }
        }
        return maxDiff;
    }
    /**
     * Method: Test Second algorithm (medium efficiency)
     * @param numbers ArrayMaker object
     * @return unused integer, for testing purposes.
     */
    public static int range2(int[] numbers){
        int maxDiff = 0;
        for (int i= 0; i < numbers.length; i++){
            for(int j = i+1; j < numbers.length; j++){
                int diff = Math.abs(numbers[j] - numbers[i]);
                if (diff > maxDiff){
                    maxDiff = diff;
                }
            }
        }
        return maxDiff;
    }
    /**
     * Method: Test third algorithm (most efficient)
     * @param numbers ArrayMaker object
     * @return unused integer, for testing purposes.
     */
    public static int range3(int[] numbers){
        int max = numbers[0];
        int min = max;
        for (int i= 0; i < numbers.length; i++){
            if (numbers[i] < min){
                min = numbers[i];
            }
            if (numbers[i] > max){
                max = numbers[i];
            }
        }
        return max - min;
    }

    /**
     * Method: Iterate through HashMap, print key and value pairs.
     * @param ranges HashMap with "n" as keys, runtimes as values.
     */
    public static void dataTimes(HashMap<Integer, Long> ranges){
        Set<Map.Entry<Integer, Long>> mapSet = ranges.entrySet();
        Iterator<Map.Entry<Integer, Long>> itr = mapSet.iterator();

        while(itr.hasNext()){
            Map.Entry<Integer, Long> entry = itr.next();
            System.out.println("N = " + entry.getKey() + " Time = " + entry.getValue() + " ms");
        }
    }
}