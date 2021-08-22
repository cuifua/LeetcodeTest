package com.top100.D_QueueStack;

import org.junit.Test;

import java.util.Stack;

/* ÓÃ¹þÏ£±í
public class parentheses
{

    public boolean isValid(String s)
    {
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        LinkedList<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray())
        {
            if (map.containsKey(c))
            {
                stack.add(c);
            }
            else
            {
                if (stack.isEmpty() || map.get(stack.removeLast()) != c)
                {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}

*/
class parentheses
{
    public boolean isValid(String s)
    {
        if (s.isEmpty()) return true;
        Stack<Character> help = new Stack<>();

        for (char c : s.toCharArray())
        {
            if (c == '(')
                help.push(')');


            else if (c == '{')
                help.push('}');

            else if (c == '[')
                help.push(']');

            else if (help.isEmpty() || c != help.pop())
                return false;

        }
        return help.isEmpty();
    }







    @Test
    public void test()
    {
        System.out.println(isValid("[({})]"));
    }
}
