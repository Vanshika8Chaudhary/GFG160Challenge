package ArraysConcepts;

import java.util.*;

public class GFG160Arrays {
    //Second Largest
    public int getSecondLargest(int[] arr) {
        int max = arr[0];
        int smax = -1;
        for(int i=1;i<arr.length;i++){
            if (arr[i]>max) {
                smax = max;
                max = arr[i];
            }
            if (arr[i]<max && arr[i]>smax) {
                smax = arr[i];
            }
        }
        return smax;
    }
   
    //Move All Zeroes to End
   public void pushZerosToEnd(int[] nums) {
        // code here
      int j=-1;
      for(int i=0;i<nums.length;i++){
          if(nums[i]== 0){
              j = i;
              break;
          }
      }
      if(j==-1)return;
      
        for(int i=j+1;i<nums.length;i++){
            if(nums[i] != 0){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
        
    }
    //Reverse Array
    public void reverseArray(int nums[]) {
    int i=0;
    int j = nums.length-1;
    while (i<j) {
        int temp = nums[i];
        nums[i] = nums[j];
         nums[j] = temp;
         i++;
         j--;
    }
    }

    //Rotate Array
    public static void reverse(int arr[], int i, int j){
        while(i<j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
    static void rotateArr(int arr[], int d) {
        if(d == 0)return;
        d = d%arr.length;
        // add your code here
        reverse(arr, 0, d-1);
        reverse(arr,d,arr.length-1);
        reverse(arr,0,arr.length-1);
    }
    
    //Next Permutation
   public void nextPermutation(int[] arr) {
        
        // code here
        int n = arr.length;
        int golaIndex = -1;
        for(int i= n-1;i>0;i--){
            if(arr[i-1]<arr[i]){
                golaIndex = i-1;
                break;
            }
        }
        
        if(golaIndex == -1){
            reverse(arr,0,n-1);
            return;
        }
        int swapIndex = -1;
        for(int i=n-1;i>=golaIndex;i--){
            if(arr[i]>arr[golaIndex]){
                swapIndex = i;
                break;
            }
        }
        int temp = arr[swapIndex];
        arr[swapIndex] = arr[golaIndex];
        arr[golaIndex] = temp;
        
        reverse(arr, golaIndex+1,n-1);
        
    }
   //Majority Element
        public List<Integer> findMajority(int[] nums) {
        // Your code goes here.
        List<Integer>  ans = new ArrayList<>();
        int cnt1 = 0;
        int cnt2 = 0;
        int el1 = Integer.MIN_VALUE;
        int el2 = Integer.MIN_VALUE;
        
        for(int i=0;i<nums.length;i++){
            if(cnt1 == 0 && nums[i] != el2){
                el1 = nums[i];
                cnt1 = 1;
            }
            else if(cnt2 == 0 && nums[i] != el1){
                el2 = nums[i];
                cnt2 = 1;
            }
            else  if(nums[i] == el1){
                cnt1++;
            }
            else  if(nums[i] == el2){
                cnt2++;
            }
            else{
                cnt1--;
                cnt2--;
            }
            
            
        }
        
        cnt1 = 0;
        cnt2 = 0;
 for(int i=0;i<nums.length;i++){
       if(nums[i] == el1){
                cnt1++;
            }
        if(nums[i] == el2){
                cnt2++;
            }
 }
 
 if(cnt1>nums.length/3){
     ans.add(el1);
 }
  if(cnt2>nums.length/3){
     ans.add(el2);
 }
 Collections.sort(ans);
 return ans;
    }

    //Stock Buy and Sell – Multiple Transaction Allowed
    public int maximumProfitMultiple(int prices[]) {
        // code here
        int totalProfit = 0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]>prices[i-1]){
                totalProfit += prices[i]-prices[i-1];
                
            }
        }
        return totalProfit;
    }
    //Stock Buy and Sell – Max one Transaction Allowed
    public int maximumProfit(int prices[]) {
        // Code here
        int max = 0;
        int min = prices[0];
        for(int i=1;i<prices.length;i++){
             int cost = prices[i]-min;
             max = Math.max(max, cost);
             min = Math.min(min , prices[i]);
        }
        return max;
    }
    
    //Minimize the Heights II
    int getMinDiff(int[] arr, int k) {
        // code here
        int n = arr.length;
        Arrays.sort(arr);
        int res = arr[n-1]- arr[0];
        for(int i=1;i<n;i++){
            if(arr[i]-k<0)continue;
            int minH = Math.min(arr[0]+k, arr[i]-k);
            int maxH = Math.max(arr[i-1]+k, arr[n-1]-k);
            res = Math.min(res, maxH-minH);
        }
        return res;
    }
   //Kadane's Algorithm
    int maxSubarraySum(int[] arr) {

        int sum = 0;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            max = Math.max(max, sum); 
            if (sum < 0) sum = 0;   
        }

        return max; 
    }

    //Maximum product subarray
    public int maxProduct(int[] arr) {
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        int prefix = 1;
        int suffix = 1;
        for(int i=0;i<arr.length;i++){
            if(prefix == 0 )prefix = 1;
            if(suffix == 0 )suffix = 1;
            prefix *= arr[i];
            suffix *= arr[n-1-i];
            max = Math.max(max, Math.max(prefix,suffix));
        }
        return max;
    }

    //Circular Maximum Subarray Sum 
    public int kadanesMax(int[] arr) {

        int sum = arr[0];
        int max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            sum = Math.max(arr[i], sum + arr[i]);
            max = Math.max(max, sum); 
               
        }

        return max; 
    }

        public int kadanesMin(int[] arr) {

        int sum = arr[0];
        int min = arr[0];

        for (int i = 1; i < arr.length; i++) {
            sum = Math.min(arr[i], sum + arr[i]);
            min = Math.min(min, sum); 
            
        }

        return min; 
    }

    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int totalSum = 0;
        for(int i=0;i<n;i++){
            totalSum += nums[i];
        }
        int maxSum = kadanesMax(nums);
        int minSum = kadanesMin(nums);
        int circularSum = totalSum - minSum;
        if(maxSum >0){
            return Math.max(maxSum ,circularSum);
        }
        return maxSum;

    }
    //Split array in three equal sum subarrays
    public List<Integer> findSplit(int[] arr) {
        // Return an array of possible answer, driver code will judge and return true or
        // false based on
        int n = arr.length;
        int tsum = 0;
        for(int i=0;i<arr.length;i++){
            tsum += arr[i];
        }
        List<Integer>  ans = new ArrayList<>();
        if(tsum %3 != 0){
            ans.add(-1);
            ans.add(-1);
            return ans;
        } 
        int ans1 = -1;
        int k = tsum/3;
        int sum1 = 0;
        for(int i=0;i<n;i++){
            sum1 += arr[i];
            if(sum1 == k){
               ans1 = i;
               break;
            }
        }
        int ans2 = -1;
        int sum2 = 0;
        for(int i=ans1+1;i<n;i++){
            sum2 += arr[i];
            if(sum2 == k){
                ans2 = i;
                break;
            }
        }
        if(ans1 != -1 && ans2 != -1 && ans2<n-1){
        ans.add(ans1);
        ans.add(ans2);
        }
        else{
            ans.add(-1);
            ans.add(-1);
        }
        return ans;
    }

    //Repetitive Addition Of Digits
    public int singleDigit(int n) {
        // code here
        int sum = 0;
        while(n>0 || sum>9){
            if(n==0){
                n= sum;
                sum = 0;
            }
            
            sum += n%10;
            n /= 10;
        }
        return sum;
        
        
    }
    
    //Maximize Number of 1's
    public int maxOnes(int arr[], int k) {
        // code here
       
        int l = 0;
        int r = 0;
        int max= 0;
        int zeros = 0;
        while(r<arr.length){
            if(arr[r] == 0)zeros++;
            while(zeros>k){
                if(arr[l] == 0)zeros--;
                l++;
            }
            if(zeros<=k){
                max = Math.max(max,(r-l+1));
            }
            r++;
        }
        return max;
    }

    //Last Moment Before All Ants Fall Out of a Plank
    public int getLastMoment(int n, int left[], int right[]) {
        // code here
       int res = 0;
       for(int num : left){
           res = Math.max(res, num);
       }
       
       for(int num : right){
           res = Math.max(res, n-num);
       }
       return res;
       
    }


    public static void main(String[] args) {
        
    }
}
