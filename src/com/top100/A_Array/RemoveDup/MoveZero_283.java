package com.top100.A_Array.RemoveDup;

/*【题目】
 *      给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序
 * 【例题】
 *      输入: [0,1,0,3,12]
 *      输出: [1,3,12,0,0]
 * 【思路】
 *      设置一个index，表示非0数的个数，循环遍历数组，
 *      如果不是0，将非0值移动到第index位置,然后index + 1
 *      遍历结束之后，index值表示为非0的个数，再次遍历，从index位置后的位置此时都应该为0
 */

public class MoveZero_283
{
    public void movezero(int[] nums)
    {
        int index = 0;
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] != 0)
            {
                nums[index] = nums[i];
                index++;
            }
        }
        for(int i = index; i < nums.length; i++)
        {
            nums[i] = 0;
        }
    }
}

/*排序法
class MoveZero_283
{
    public void move (int[] nums)
    {
       if(nums==null)
		  return;

		//两个指针i和j
		int j = 0;
		for(int i=0;i<nums.length;i++)
		 {
			//当前元素!=0，就把其交换到左边，等于0的交换到右边
			if(nums[i]!=0) {
				int tmp = nums[i];
				nums[i] = nums[j];
				nums[j++] = tmp;
			}
		}
    }
}
 */

