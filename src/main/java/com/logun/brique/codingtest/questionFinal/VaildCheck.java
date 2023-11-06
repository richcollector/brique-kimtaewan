package com.logun.brique.codingtest.questionFinal;

import java.util.Stack;

public class VaildCheck {
    public static int vaildProcess(String question) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int max = 0;

        for (int i = 0; i < question.length(); i++) {
            if (question.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (!stack.isEmpty()) {
                    max = Math.max(max, i - stack.peek());
                } else {
                    stack.push(i);
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        String question = "(())))()()()";

        int result = vaildProcess(question);

        System.out.println("결과 보기: " + result);
    }
}






