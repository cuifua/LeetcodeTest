package com.top100.A_Array.RemoveDup;

/*
 * 【题目】
 *      给你一个<有序数组> nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 *      不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。。
 * 【例题】
 *      输入：nums = [3,2,2,3], val = 3
 *      输出：2, nums = [2,2]
 *      解释：函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。你不需要考虑数组中超出新长度后面的元素。
 *           例如，函数返回的新长度为 2 ，而 nums = [2,2,3,3] 或 nums = [2,2,0,0]，也会被视作正确答案。
 *
 *      输入：nums = [0,1,2,2,3,0,4,2], val = 2
 *      输出：5, nums = [0,1,4,0,3]
 *      解释：函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。注意这五个元素可为任意顺序。你不需要考虑数组中超出新长度后面的元素。
 * 【思路】
        一个指针 i 进行数组遍历，另外一个指针 result指向有效数组的最后一个位置。
        只有当 i 所指向的值和 result 不一致（不重复），才将 i 的值添加到 result 的下一位置。
        */
public class RemoveDuplicates_26
{
    /*
    通用解法思路：由于是保留 k 个相同数字，对于前 k 个数字，我们可以直接保留。------------------index < k
    对于后面的任意数字，能够保留的前提是：与当前写入的位置前面的第 k 个元素进行比较，不相同则保留---nums[index - k]
     */
    public int removeDuplicates(int[] nums)
    {
        return process(nums, 1);
    }

    int process(int[] nums, int k)
    {
        int index = 0;
        for (int num : nums)
        {
            if (index < k || nums[index - k] != num)
                nums[index++] = num;
        }
        return index;
    }
}

/*  此题的解法，不过建议用上面的通用解法
    public int removeDuplicates(int[] nums)
    {
        int n = nums.length;
        int result = 0;
        for(int i = 0; i < n; i++)
        {
            if(nums[i] != nums[result])         //当前遍历到的数字和存贮有效值的result的值不一样说明不重复
                nums[++result] = nums[i];       //就可以把所指的这个值赋给result的下一个下标
        }
        return result+1;                        //result数组的最后一个下标就是全部有效数组，然后返回下标+1即就是最终这个有效数组的全部数字
    }
 */
