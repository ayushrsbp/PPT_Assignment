import java.util.*;
public class Assignment_4
{
    // -----------------Question-1-------------------//
    
    public static Integer[] common(int arr1[], int arr2[], int arr3[]) {
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> common = new ArrayList<>();
        
        for(int num : arr1) {
            set.add(num);
        }
        for(int num : arr2) {
            if(set.contains(num)) {
                common.add(num);
            }
        }
        set.clear();
        while(!common.isEmpty()){
            set.add(common.remove(0));
        }
        for(int num : arr3) {
            if(set.contains(num)) {
                common.add(num);
            }
        }
        Integer[] array = common.toArray(new Integer[common.size()]);
        return array;
    }
    // -----------------Question-2-------------------//
    
    public static List<List<Integer>> distinctInt(int nums1[], int nums2[]) {
        List<List<Integer>> lol = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums2) {
            set.add(num);
        }
        List<Integer> l = new ArrayList<>();
        for(int num : nums1) {
            if(!set.contains(num)) {
                l.add(num);
            }
        }
        lol.add(l);
        set.clear();
        for(int num : nums1) {
            set.add(num);
        }
        List<Integer> l1 = new ArrayList<>();
        for(int num : nums2) {
            if(!set.contains(num)) {
                l1.add(num);
            }
        }
        lol.add(l1);
        return lol;
    }
    
    // -----------------Question-3-------------------//
    
    public static int[][] transpose(int matrix[][]) {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = i; j < matrix.length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        return matrix;
    }
    
    // -----------------Question-4-------------------//
    
    public static int maxSum(int nums[]) {
        Arrays.sort(nums);
        int sum = 0;
        for(int i = 0; i < nums.length; i=i+2) {
            sum+=nums[i];
        }
        return sum;
    }
    
    // -----------------Question-5-------------------//
    
    public static int noStair(int n) {
        int count = 0;
        int cover = 1;
        while(n > 0) {
            n-=cover;
            cover++;
            count++;
            if(n < cover) {
                break;
            }
        }
        return count;
    }
    
    // -----------------Question-6-------------------//
    
    public static int[] square(int nums[]) {
        int n = nums.length;
        int square[] = new int[n];
        boolean isAllPos = true;
        for(int i = 0; i < n-1; i++) {
            if(nums[i] < 0) {
                isAllPos = false;
            }
            if(nums[i] < 0 && nums[i+1] >= 0) {
                int j = i+1, k = 0;
                while(i >= 0 && j <n) {
                    if(Math.abs(nums[i]) < nums[j]) {
                        square[k] = nums[i]*nums[i];
                        i--;
                    }
                    else {
                        square[k] = nums[j]*nums[j];
                        j++;
                    }
                    k++;
                }
                while(i >= 0) {
                    square[k] = nums[i]*nums[i];
                    k++;
                    i--;
                }
                while(j < n) {
                    square[k] = nums[j]*nums[j];
                    k++;
                    j++;
                }
                return square;
            }
        }
        int k = 0;
        for(int i : nums) {
            square[k] = i*i;
        }
        if(!isAllPos) {
            int i = 0, j = nums.length-1;
            while(i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        return square;
    }
    
    // -----------------Question-7-------------------//
    public static int maxNum(int m, int n, int ops[][]) {
        int matrix[][] = new int[m][n];
        int count = 0;
        for(int i = 0; i < ops.length; i++) {
            for(int j = 0; j < ops[i][0]; j++) {
                for(int k = 0; k < ops[i][1]; k++) {
                    matrix[j][k] += 1;
                    // max = Math.max(max, matrix[j][k]);
                    if(i == ops.length-1 && matrix[j][k] == matrix[0][0]) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
    
    // -----------------Question-8-------------------//
    
    public static int[] pairing(int nums[]) {
        int paired[] = new int[nums.length];
        int j = 0;
        for(int i = 0; i < nums.length/2; i++) {
            paired[j] = nums[i];
            paired[j+1] = nums[i+nums.length/2];
            j+=2;
        }
        return paired;
    }
	public static void main(String[] args) {
	    
	    // -----------------Question-1-------------------//
	    System.out.println("-----------------Question-1-------------------");
	    
	    int arr1[] = {1,2,3,4,5}, arr2[] = {1,2,5,7,9}, arr3[] = {1,3,4,5,8};
	    Integer common[] = common(arr1, arr2, arr3);
	    for(int num : common) {
	        System.out.print(num+",");
	    }
	    System.out.println();
	    // -----------------Question-2-------------------//
	    System.out.println("-----------------Question-2-------------------");
	    
	    int nums2a[] = {1,2,3}, nums2b[] = {2,4,6};
		System.out.println(distinctInt(nums2a, nums2b));
		
		// -----------------Question-3-------------------//
	    System.out.println("-----------------Question-3-------------------");
	    int matrix[][] = {{1,2,3},{4,5,6},{7,8,9}};
	    transpose(matrix);
	    for(int i[] : matrix) {
	        for(int num : i) {
	            System.out.print(num + " ");
	        }
	        System.out.println();
	    }
	    
	    // -----------------Question-4-------------------//
	    System.out.println("-----------------Question-4-------------------");
	    int nums4[] = {1,4,3,2};
	    System.out.println(maxSum(nums4));
	    
	    // -----------------Question-5-------------------//
	    System.out.println("-----------------Question-5-------------------");
	    
	    int x = 5;
	    System.out.println(noStair(x));
	    
	    // -----------------Question-6-------------------//
	    System.out.println("-----------------Question-6-------------------");
	    int nums6[] = {-4,-1,0,3,10};
	    int square[] = square(nums6);
	    for(int num : square) {
	        System.out.print(num+",");
	    }
	    System.out.println();
	    
	    // -----------------Question-7-------------------//
	    System.out.println("-----------------Question-7-------------------");
	    
	    int m = 3, n = 3, ops[][] = {{2,2},{3,3}};
	    System.out.println(maxNum(m,n,ops));
	    
	    // -----------------Question-8-------------------//
	    System.out.println("-----------------Question-8-------------------");
	    
	    int nums8[] = {2,5,1,3,4,7};
	    int paired[] = pairing(nums8);
	    for(int i : paired) {
	        System.out.print(i+",");
	    }
	    System.out.println();
	    
	}
}
