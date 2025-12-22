/*Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.
*/
class Solution {
    public int[] twoSum(int[] nums, int target) {

        int[] ans=new int[2];

      /*for(int i=0;i<nums.length;i++)
      {
        for(int j=i+1;j<nums.length;j++)
        {
            if(nums[i]+nums[j]==target){ans[0]=i;ans[1]=j;}
        }
      } brute force*/
        HashMap<Integer,Integer> hs=new HashMap<>();
        hs.put(nums[0],0);
        for(int i=1;i<nums.length;i++)
        {
            if(hs.containsKey(target-nums[i])){ans[0]=hs.get(target-nums[i]);ans[1]=i; break;}
            else {hs.put(nums[i],i);}
        }
        return ans;
    }
}