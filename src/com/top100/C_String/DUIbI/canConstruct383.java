package com.top100.C_String.DUIbI;
/*
����Ŀ������һ������� (ransom) �ַ�����һ����־(magazine)�ַ������жϵ�һ���ַ��� ransom �ܲ����ɵڶ����ַ��� magazines ������ַ����ɡ�������Թ��ɣ����� true �����򷵻� false��
      (��Ŀ˵����Ϊ�˲���¶������ּ���Ҫ����־������������Ҫ����ĸ����ɵ����������˼����־�ַ����е�ÿ���ַ�ֻ����������ַ�����ʹ��һ�Ρ�)

�����⡿
        ���룺ransomNote = "a", magazine = "b"
        �����false

        ���룺ransomNote = "aa", magazine = "ab"
        �����false

        ���룺ransomNote = "aa", magazine = "aab"
        �����true
 */
public class canConstruct383
{
    public boolean canconstruct(String ransomNote, String magazine)
    {
        int[] alpha = new int[26];
        for (int i = 0; i < magazine.length(); i++)
        {
            char ch = magazine.charAt(i);
            alpha[ch - 'a']++;
        }

        for (int i = 0; i < ransomNote.length(); i++)
        {
            char ch = ransomNote.charAt(i);
            if(--alpha[ch] - 'a' < 0)       return false;
        }
        return true;
    }
}
