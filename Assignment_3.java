import java.util.*;
public class Assignment_3
{
    // ----------------Question-1------------------//
    
    public static int closestTarget(int nums[], int target) {
        int min = Integer.MAX_VALUE;
        int n = nums.length;
        int closestSum = 0;
        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                for(int k = j+1; k < n; k++) {
                    if(min > Math.abs(nums[i]+nums[j]+nums[k]-target)) {
                        closestSum = nums[i]+nums[j]+nums[k];
                        min = Math.abs(nums[i]+nums[j]+nums[k]-target);
                    }
                } 
            }
        }
        return closestSum;
    }
    
    // ----------------Question-2------------------//
    
    public static List<List<Integer>> targetSum(int nums[], int target) {
        List<List<Integer>> lol = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for(int i = 0; i < n-3; i++) {
            for(int j = i+1; j < n-2; j++) {
                int k = j+1, l = n-1;
                while(k < l) {
                    int sum = nums[i] + nums[j] + nums[k] + nums[l];
                    if(sum == target) {
                        List<Integer> t = new ArrayList<>();
                        t.add(nums[i]);
                        t.add(nums[j]);
                        t.add(nums[k]);
                        t.add(nums[l]);
                        lol.add(t);
                        k++;
                        l--;
                    }
                    else if(sum < target) {
                        k++;
                    }
                    else {
                        l--;
                    }
                }
                
            }
        }
        return lol;
    }
    // ----------------Question-3------------------//
    public static void nextPermutation(int nums[]) {
        int n = nums.length;
        for(int i = n-2; i >= 0; i--) {
            if(nums[i] < nums[i+1]) {
                int temp = nums[i];
                nums[i] = nums[i+1];
                nums[i+1] = temp;
                i = i+1;
                int j = n-1;
                while(i < j) {
                    if(nums[i] > nums[j]) {
                        temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                    }
                    i++;
                    j--;
                }
                return;
            }
        }
        int i = 0, j = n-1;
        while(i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
    // ----------------Question-4------------------//
    public static int findPosition(int nums[], int target) {
        int si = 0, ei = nums.length-1;
        while(si <= ei) {
            int mid = (si+ei)/2;
            if(nums[mid] == target) {
                return mid;
            }
            else if(nums[mid] < target){
                si = mid+1;
            }
            else {
                ei = mid-1;
            }
        }
        return si;
    }
    // ----------------Question-5------------------//
    
    public static int[] increasedArray(int digits[]) {
        int i = digits.length-1;
        while(digits[i] == 9) {
            digits[i] = 0;
            i--;
            if(i < 0) {
                int newDigits[] = new int[digits.length+1];
                Arrays.fill(newDigits, 0);
                newDigits[0] = 1;
                return newDigits;
            }
        }
        digits[i] = digits[i]+1;
        return digits;
    }
    
    // ----------------Question-6------------------//
    
    public static int singleNumber(int[] nums) {
        int result = 0;
        for (int i : nums) {
            result ^= i;
        }
        return result;
    }

    // ----------------Question-7------------------//
    public static List<List<Integer>> missingNum(int nums[], int upper, int lower) {
        List<List<Integer>> lol = new ArrayList<>();
        if(lower != nums[0]) {
            List<Integer> l = new ArrayList<>();
            l.add(lower);
            l.add(nums[0]-1);
            lol.add(l);
        }
        for(int i = 0; i < nums.length-1; i++) {
            if(nums[i] != nums[i+1]-1){
                List<Integer> l = new ArrayList<>();
                l.add(nums[i]+1);
                l.add(nums[i+1]-1);
                lol.add(l);
            }
        }
        if(upper != nums[nums.length-1]) {
            List<Integer> l = new ArrayList<>();
            l.add(nums[nums.length-1]+1);
            l.add(upper);
            lol.add(l);
        }
        return lol;
    }
    
    // ----------------Question-8------------------//
    public static boolean canAttend(int intervals[][]) {
        boolean canAttend = true;
        Arrays.sort(intervals, Comparator.comparingDouble(o -> o[0]));
        int end = 0;
        for(int i = 0; i < intervals.length; i++) {
            if(intervals[i][0] < end) {
                canAttend = false;
                break;
            }
            end = intervals[i][1];
        }
        return canAttend;
    }
	public static void main(String[] args) {
	    
	    // ----------------Question-1------------------//
	    System.out.println("----------------Question-1------------------");
	    
	    
	    int nums1[] = {-1,2,1,-4}, target1 = 1;
	    System.out.println(closestTarget(nums1,target1));
	    
	    // ----------------Question-2------------------//
	    System.out.println("----------------Question-2------------------");
	    
	    int nums2[] = {1,0,-1,0,-2,2}, target2 = 0;
	    System.out.println(targetSum(nums2, target2));
	    
	    // ----------------Question-3------------------//
	    System.out.println("----------------Question-3------------------");
	    
	    int nums3[] = {2,3,1};
	    nextPermutation(nums3);
	    for(int i: nums3) {
	        System.out.print(i+",");
	    }
	    System.out.println();
	    
	    // ----------------Question-4------------------//
	    System.out.println("----------------Question-4------------------");
	    int nums4[] = {1,3,5,6}, target4 = 5;
	    System.out.println(findPosition(nums4, target4));
	    
	    // ----------------Question-5------------------//
	    System.out.println("----------------Question-5------------------");
	    
	    int digits[] = {9,9,9};
	    digits = increasedArray(digits);
	    for(int i : digits) {
	        System.out.print(i);
	    }
	     System.out.println();
	     
	     // ----------------Question-6------------------//
	    System.out.println("----------------Question-6------------------");
	    
	    int nums6[] = {2,2,1};
	    System.out.println(singleNumber(nums6));
	    // ----------------Question-7------------------//
	    System.out.println("----------------Question-7------------------");
	    
	    int nums7[] = {0,1,3,50,75}, lower = 0, upper = 99;
	    System.out.println(missingNum(nums7, upper, lower));
	    
	    // ----------------Question-8------------------//
	    System.out.println("----------------Question-8------------------");
	    
	    int intervals[][] = {{0,30},{5,10},{15,20}};
	    System.out.println(canAttend(intervals));
	}
}
