package com.top100.A_Array.RemoveDup;

/*����Ŀ��
 *      ����һ������ nums����дһ������������ 0 �ƶ��������ĩβ��ͬʱ���ַ���Ԫ�ص����˳��
 * �����⡿
 *      ����: [0,1,0,3,12]
 *      ���: [1,3,12,0,0]
 * ��˼·��
 *      ����һ��index����ʾ��0���ĸ�����ѭ���������飬
 *      �������0������0ֵ�ƶ�����indexλ��,Ȼ��index + 1
 *      ��������֮��indexֵ��ʾΪ��0�ĸ������ٴα�������indexλ�ú��λ�ô�ʱ��Ӧ��Ϊ0
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

/*����
class MoveZero_283
{
    public void move (int[] nums)
    {
       if(nums==null)
		  return;

		//����ָ��i��j
		int j = 0;
		for(int i=0;i<nums.length;i++)
		 {
			//��ǰԪ��!=0���Ͱ��佻������ߣ�����0�Ľ������ұ�
			if(nums[i]!=0) {
				int tmp = nums[i];
				nums[i] = nums[j];
				nums[j++] = tmp;
			}
		}
    }
}
 */

