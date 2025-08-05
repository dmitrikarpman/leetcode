/*
    3477 Fruits Into Baskets II easy

    https://leetcode.com/problems/fruits-into-baskets-ii/?envType=daily-question&envId=2025-08-05

You are given two arrays of integers, fruits and baskets, each of length n, where fruits[i] represents the quantity of the ith type of fruit, and baskets[j] represents the capacity of the jth basket.

From left to right, place the fruits according to these rules:

Each fruit type must be placed in the leftmost available basket with a capacity greater than or equal to the quantity of that fruit type.
Each basket can hold only one type of fruit.
If a fruit type cannot be placed in any basket, it remains unplaced.
Return the number of fruit types that remain unplaced after all possible allocations are made.
*/
class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        
        int[] usedup = new int[fruits.length];
        int unplaced = 0;

        // for all fruit
        for(int i=0; i<fruits.length; i++){
            // with each fruit run over baskets until placed
            // if basket is available and fruit can be placed: mark the basket as used up
            int placed = 0;
            for(int j=0; j<baskets.length; j++) {
                if(usedup[j] == 0 && baskets[j] >= fruits[i]){
                    usedup[j] = 1;
                    placed=1;
                    break;
                }
            }
            if(placed==1) continue;
            else unplaced++;

        }

        return unplaced;
    }
}
