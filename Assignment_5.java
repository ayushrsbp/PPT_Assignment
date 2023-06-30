import java.util.*;
public class Assignment_5
{
    // --------------Question-1--------------//
    public static int[][] oneDtoTwoD(int arr[], int m, int n) {
        int matrix[][] = new int[m][n];
        if(arr.length != m*n) {
            return matrix;
        }
        int k = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                matrix[i][j] = arr[k];
                k++;
            }
        }
        return matrix;
    }
    // --------------Question-2--------------//
    
    public static int noOfStair(int n) {
        int count = 0;
        int curr = 1;
        while(n > 0) {
            n-=curr;
            curr++;
            count++;
            if(n < curr) {
                break;
            }
        }
        return count;
    }
    // -----------------Question-3-------------------//
    
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
    
    // -----------------Question-4-------------------//
    
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
    // --------------Question-5--------------//
    
    public static int distValue(int arr1[], int arr2[], int d) {
        int count = 0;
        for(int i : arr1) {
            count++;
            for(int j : arr2) {
                if(Math.abs(i-j) <= 2) {
                    count--;
                    break;
                }
            }
        }
        return count;
    }
    
    // --------------Question-6--------------//
    
    public static List<Integer> doubleNum(int nums[]) {
        List<Integer> result = new ArrayList<>();
        
        for (int num : nums) {
            int idx = Math.abs(num) - 1;
            if (nums[idx] < 0) {
                result.add(Math.abs(num));
            } else {
                nums[idx] *= -1;
            }
        }
        
        return result;
    }
    
    // --------------Question-7--------------//
    
    public static int min(int nums[]) {
        int si = 0;
        int ei = nums.length - 1;
        
        while (si < ei) {
            int mid = (si+ei) / 2;
            
            if (nums[mid] > nums[ei]) {
                si = mid + 1;
            } else {
                ei = mid;
            }
        }
        
        return nums[si];
    }


    // --------------Question-8--------------//
    public static int[] originalArray(int[] changed) {
        if (changed.length % 2 != 0) {
            return new int[0];
        }
        
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int num : changed) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        
        List<Integer> original = new ArrayList<>();
        for (int num : changed) {
            if (count.getOrDefault(num, 0) == 0) {
                continue;
            }
            
            count.put(num, count.get(num) - 1);
            
            int doubledNum = num * 2;
            if (!count.containsKey(doubledNum) || count.get(doubledNum) == 0) {
                return new int[0];
            }
            
            count.put(doubledNum, count.get(doubledNum) - 1);
            
            original.add(num);
        }
        
        int[] result = new int[original.size()];
        for (int i = 0; i < original.size(); i++) {
            result[i] = original.get(i);
        }
        
        return result;
    }
	public static void main(String[] args) {
		// --------------Question-1--------------//
		System.out.println("--------------Question-1--------------");
		
		int original[] = {1,2,3,4}, m = 2, n = 2;
		int converted[][] = oneDtoTwoD(original, m, n);
		for(int i[] : converted) {
            for(int num : i) {
                System.out.print(num+ " ");
            }
            System.out.println();
        }
        
        // --------------Question-2--------------//
		System.out.println("--------------Question-2--------------");
		int x = 5;
		System.out.println(noOfStair(x));
		
		// -----------------Question-3-------------------//
	    System.out.println("-----------------Question-3-------------------");
	    int nums6[] = {-4,-1,0,3,10};
	    int square[] = square(nums6);
	    for(int num : square) {
	        System.out.print(num+",");
	    }
	    System.out.println();
		
		// -----------------Question-4-------------------//
	    System.out.println("-----------------Question-4-------------------");
	    
	    int nums2a[] = {1,2,3}, nums2b[] = {2,4,6};
		System.out.println(distinctInt(nums2a, nums2b));
		
		// --------------Question-5--------------//
		System.out.println("--------------Question-5--------------");
		int arr1[] = {4,5,8}, arr2[] = {10,9,1,8}, d = 2;
		System.out.println(distValue(arr1, arr2, d));
		
		// --------------Question-6--------------//
		System.out.println("--------------Question-6--------------");
		
		int nums5[] = {4,3,2,7,8,2,3,1};
		System.out.println(doubleNum(nums5));
		
		// --------------Question-7--------------//
		System.out.println("--------------Question-7--------------");
		
		int nums7[] = {3,4,5,1,2};
		System.out.println(min(nums7));
		
		// --------------Question-8--------------//
		System.out.println("--------------Question-8--------------");
		
		int changed[] = {1,3,4,2,6,8};
		int originl[] = originalArray(changed);
		for(int num: originl) {
		    System.out.print(num+",");
		}
		System.out.println();
	}
}
