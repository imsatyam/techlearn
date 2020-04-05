package com.satyam.ds.tree.expression;

import com.satyam.common.CharacterUtils;

import java.util.Stack;

/**
 * Use stack
 *
 * 1. if operand -> print
 * 2. if character is ( -> push
 * 3. if scanned character is ) -> pop until ( and discard both
 * 4. If operator
 *      - if stack is empty | precedence > operator in stack | operator in stack is (  -> push it is stack
 *      - else pop all the operators [excluding(] from stack where precedence <= scanned operator
 *      - if scanned character is ( -> push
 */
public class InfixToPostfix {

    public static String toPostfix(String infixExpr) {

        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < infixExpr.length(); i++) {
            char ch = infixExpr.charAt(i);

            if (Character.isLetterOrDigit(ch)) {
                result.append(ch);
            }
            else if (ch == '(') {
                stack.push(ch);
            }
            else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }

                if (!stack.isEmpty() && stack.peek() != '(') {  // if last element in stack is not (
                    throw new IllegalArgumentException("Invalid expression");
                } else {
                    stack.pop(); // discard (
                }
            } else {
                int precedence = CharacterUtils.getPrecedence(ch);
                while(!stack.isEmpty() && CharacterUtils.getPrecedence(stack.peek()) >= precedence) {
                    if (stack.peek() == '(') {
                        throw new IllegalArgumentException("Invalid expression.");
                    }
                    result.append(stack.pop());
                }
                stack.push(ch);
            }
        }

        while (!stack.isEmpty()) {
            char ch = stack.pop();
            if (ch == '(') {
                throw new IllegalArgumentException("Invalid Expression");
            }
            result.append(ch);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String exp = "(L-K/A)*(C/B-A)";//"a+b*(c^d-e)^(f+g*h)-i";
        System.out.println(toPostfix(exp));  // abcd^e-fgh*+^*+i-
    }
}
