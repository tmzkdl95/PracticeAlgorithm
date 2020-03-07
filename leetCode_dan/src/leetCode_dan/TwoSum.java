package leetCode_dan;

/*
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * 
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 * 
 */


public class TwoSum {

	 public int[] twoSum(int[] nums, int target) {
	        
	        int answer[] = new int[2];
	        for(int i=0; i<nums.length; i++){
	            for(int j=i+1; j<nums.length; j++){
	                if(nums[i]+nums[j] == target){
	                    answer[0] = i;
	                    answer[1] = j;
	                    break;
	                }
	            }
	        }
	        
	        return answer;
	}
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TwoSum s1 = new TwoSum();
		int[] nums = {2,7,11,15};
		int target = 9;
		int[] answer;
		
		answer = s1.twoSum(nums, target);
		System.out.println(answer[0]+", "+answer[1]);

	}

}
