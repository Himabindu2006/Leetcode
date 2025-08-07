class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int count = 1; 
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[count] = nums[i]; 
                count++;
            }
        }
        return count;
    }
}
/*class Solution {
    public int removeDuplicates(int[] nums) {
        int count = 0;
        for(int i=0;i<nums.length-1;i++){
            if(i<nums.length-1 && nums[i]==nums[i+1]){
                continue;
            }else{
                nums[count]=nums[i];
                count++;
            }
        }
        return count;
    }
}
*/