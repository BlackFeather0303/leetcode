/*
Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Example 1:

Input: [1,3,5,6], 5
Output: 2
Example 2:

Input: [1,3,5,6], 2
Output: 1
Example 3:

Input: [1,3,5,6], 7
Output: 4
Example 4:

Input: [1,3,5,6], 0
Output: 0
 */

//非常简单的一道题，注意最后有个return nums.length
public int searchInsert(int[] nums, int target) {
    for (int i = 0; i<nums.length; i++) {
        if (nums[i] >= target)
            return i;
    }
    return nums.length;
}

//更快的方法：二分查找
public int searchInsert(int[] nums, int target){
    int l = 0;
    int r = nums.length - 1;
    while(l <= r){
        int mid = l + (r - l) / 2;
        if (nums[mid] < target) {
            l = mid + 1;
        }else if (nums[mid] > target) {
            r = mid;
        }else
            return mid - 1;
    }
    return l;
}
