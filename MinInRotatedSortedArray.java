class Solution {
    public int findMin(int[] nums) {
        if(nums.length==0) return -1;
        if(nums.length==1) return nums[0];
        int mid=0,l=0,h=nums.length-1;
        if(nums[0]<nums[nums.length-1]){
            return nums[0];
        }
        while(l<h){
            mid=l+(h-l)/2;
            if(nums[mid]>nums[mid+1]) return nums[mid+1];
            if(nums[mid]<nums[mid-1]) return nums[mid];
            else if(nums[mid]>nums[nums.length-1]){
                l=mid+1;
            }else{
                h=mid-1;
            }
        }
        return -1;
    }
}
