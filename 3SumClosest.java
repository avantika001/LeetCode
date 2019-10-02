class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n=nums.length;
        if(n<3||nums==null) return Integer.MAX_VALUE;
        int maxsum=nums[0]+nums[1]+nums[2];
        
        for(int i=0;i<=n-3;i++){
            if(i>0&&nums[i]==nums[i-1]) continue;
            int l=i+1;
            int r=n-1;
            while(l<r){
               if(nums[l]+nums[r]+nums[i]==target){
                   maxsum=nums[i]+nums[l]+nums[r];
                   return maxsum;
               }else if(nums[l]+nums[r]+nums[i]<target){
                   if(Math.abs((nums[l]+nums[r]+nums[i])-target)<=Math.abs(maxsum-target)){
                       maxsum=nums[l]+nums[r]+nums[i];
                   }
                   l++;
                   while(l<r&&nums[l]==nums[l-1]) l++;
               }else if(nums[l]+nums[r]+nums[i]>target){
                   if(Math.abs(target-(nums[l]+nums[r]+nums[i]))<=Math.abs(target-maxsum)){
                       maxsum=nums[l]+nums[r]+nums[i];
                   }
                   r--;
                   while(l<r&&nums[r]==nums[r+1]) r--;
               }
                
            }
        }
        return maxsum;
        
    }
}
