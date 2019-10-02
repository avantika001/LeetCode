class Solution {
    public void sortColors(int[] nums) {
        int i=0,j=nums.length-1,k=0,temp;
        
        while(k<=j){
            switch(nums[k]){
                case 0: temp=nums[k];
                        nums[k]=nums[i];
                        nums[i]=temp;
                        i++;k++;break;
                case 1: k++; break;
                case 2://swap with j
                    temp=nums[k];
                    nums[k]=nums[j];
                    nums[j]=temp;
                    j--;break;
            }
        }
    }
}
