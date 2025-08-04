/*
118. Pascal's Triangle
Solved
Easy
Topics
premium lock icon
Companies
Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

https://leetcode.com/problems/pascals-triangle/
*/

class Solution {
    public List<List<Integer>> generate(int numRows) {
        ArrayList<List<Integer>> output = new ArrayList<>();
        for(int i=0; i<numRows;i++){
            ArrayList<Integer> tmp = new ArrayList<>();
            if(i==0){
                tmp.add(1);
                output.add(tmp);
            }
            else if(i==1){
                tmp.add(1);
                tmp.add(1);
                output.add(tmp);
            }
            else{
                tmp.add(1);
                for(int j=0; j<output.size()-1;j++){
                    tmp.add(output.get(i-1).get(j)+output.get(i-1).get(j+1));
                }
                tmp.add(1);
                output.add(tmp);
            }
        }
        return output;
    }
}
