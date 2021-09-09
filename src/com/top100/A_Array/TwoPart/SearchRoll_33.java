package com.top100.A_Array.TwoPart;

/*
����Ŀ��
    �������� nums ���������У������е�ֵ ������ͬ ��
    �ڴ��ݸ�����֮ǰ��nums ��Ԥ��δ֪��ĳ���±� k��0 <= k < nums.length���Ͻ����� ��ת��
    ʹ�����Ϊ [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]���±� �� 0 ��ʼ ��������
    ���磬 [0,1,2,4,5,6,7] ���±� 3 ������ת����ܱ�Ϊ[4,5,6,7,0,1,2] ��

    ���� ��ת�� ������ nums ��һ������ target ����� nums �д������Ŀ��ֵ target ���򷵻������±꣬���򷵻�-1��


��ʾ�� 1��
    ���룺nums = [4,5,6,7,0,1,2], target = 0
    �����4

��ʾ��2����
    ���룺nums = [4,5,6,7,0,1,2], target = 3
    �����-1

��˼·��
    //����м����С�����ұߵ��������Ұ��������ģ�
    //���м����������ұ������������������
    //����ֻҪ������İ��������β�����������ж�Ŀ��ֵ�Ƿ�����һ�����ڣ������Ϳ���ȷ�������İ����
 */
public class SearchRoll_33
{
    public int search(int[] nums, int target)
    {
        int left = 0;
        int right = nums.length-1;

        while(left <= right)
        {
            int mid = left + (right-left)/2;

            if(nums[mid] == target)
                return mid;

            else if(nums[mid] < nums[right])//�ұ��Ѿ�������
            {
                if(target > nums[mid] && target <= nums[right])
                    left = mid + 1;
                else
                    right = mid -1;
            }

            else//�������
            {
                if(target >= nums[left] && target < nums[mid])
                    right = mid-1;
                else
                    left = mid+1;
            }
        }
        return -1;
    }
}
