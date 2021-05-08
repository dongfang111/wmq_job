package com.example.demo.agorithm.stack;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import static javax.swing.UIManager.put;

/**
 * 有效括号
 *
 * @author wmqing
 * @Date 2021/5/7 20:07
 **/
public class ValidBracket {

    public static void main(String[] args) {
        String s = "{[([)]}";
        System.out.println(validBracket(s));
    }

    public static boolean validBracket(String s) {
        Map<Character, Character> characterMap = new HashMap<Character, Character>() {{
            put(')', '(');
            put('}', '{');
            put(']', '[');
        }};

        LinkedList<Character> list = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (characterMap.containsKey(c)) {
                if (list.isEmpty() || !list.peek().equals(characterMap.get(c))) {
                    return false;
                }
                list.pop();
            } else {
                list.push(c);
            }
        }
        return list.isEmpty();
    }
}
