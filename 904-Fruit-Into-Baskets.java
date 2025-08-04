/*904 Fruit Into Baskets - medium
 *
 * You are visiting a farm that has a single row of fruit trees arranged from left to right. The trees are represented by an integer array fruits where fruits[i] is the type of fruit the ith tree produces.

You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:

You only have two baskets, and each basket can only hold a single type of fruit. There is no limit on the amount of fruit each basket can hold.
Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree) while moving to the right. The picked fruits must fit in one of your baskets.
Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
Given the integer array fruits, return the maximum number of fruits you can pick.

*/
class Solution {
    public int totalFruit(int[] fruits) {
        
        if(fruits.length<3) return fruits.length;

        int basket1 = fruits[0];
        int basket2 = fruits[1];
        int sInd = 0;
        int maxLen = 2;
        int prevPtr = 0;
        int ptr = (basket1 == basket2) ? 0 : 1;

        for(int i=2; i < fruits.length; i++){
            
             if(fruits[i] == basket2){
                // do nothing
             }
             else{
                prevPtr = ptr;
                ptr = i;

                //System.out.println("["+basket1+","+basket2+"]");
                if(fruits[i] != basket1) sInd = prevPtr;

                basket1 = basket2;
                basket2 = fruits[i];
             }



            maxLen = (maxLen < i - sInd + 1) ? i - sInd + 1 : maxLen;

            //System.out.println("i="+i+", ptr="+ptr+", prevPtr="+prevPtr+", sInd="+sInd+", maxLen="+maxLen);
        }

        return maxLen;
    }
}

