/*
 *@author James Sherwood
 * @Version 3/06/2022
 *
 * @TCSS 321 Discrete Structures I
 * @HW#8 Extra Credit Assignment
 * @Professor Teredesai
 */

import java.util.*;
public class ArrayMaker {
    private final int size;

    //Constructor
    public ArrayMaker(int size){
        this.size = size;
        makeArray(size);
    }

    /**
     * Method: getSize
     * @Param: none
     * @return: int (size value)
     */
    public int getSize(){
        return this.size;
    }

    /**
     * Method: Create Array of specified size, populate with random integers.
     * @param size
     * @return Array of type int.
     */
    public int[] makeArray(int size){
        Random rand = new Random();
        int[] numbers = new int[size];
        for (int i = 0; i < size; i++){
            numbers[i] = rand.nextInt();
        }

        return numbers;
    }

}
