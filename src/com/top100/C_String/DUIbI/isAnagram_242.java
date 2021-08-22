package com.top100.C_String.DUIbI;

/*
 * ����Ŀ��
 *      ���������ַ��� s �� t ����дһ���������ж� t �Ƿ��� s ����ĸ��λ�ʡ�
 * �����⡿
 *      ����: s = "anagram", t = "nagaram"
 *      ���: true
 *
 *      ����: s = "rat", t = "car"
 *      ���: false
 * ��˼·��
 *      ûɶ˼·��������
 */
public class isAnagram_242
{
    public boolean isAnagram(String s, String t)
    {
        int[] cnts = new int[26];
        for (char c : s.toCharArray())
            cnts[c - 'a']++;

        for (char c : t.toCharArray())
            cnts[c - 'a']--;

        for (int cnt : cnts)
        {
            if (cnt != 0)
                return false;
        }
        return true;
    }
}
