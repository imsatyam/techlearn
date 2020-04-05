package com.satyam.ds.tree.expression;

import java.util.Stack;

/**
 * Use stack
 *
 * 1. if operand -> push to stack
 * 2. if it is an operand
 *     2a. Pop two values from the stack
 *     2b. put the operator between two operands - ( + op2 + operator + op1 + )
 *     2c. push the resulting string in stack
 * 3. If there is only one element in the stack -> return it
 */
public class PostfixToInfix {

    private static String toInfix(String expr) {
        Stack<String> stack = new Stack<>();
        for (int index = 0; index < expr.length(); index++) {
            char ch = expr.charAt(index);
            processChar(stack, ch);
        }
        return stack.pop();
    }

    private static void processChar(Stack<String> stack, char ch)  {
        if (Character.isLetterOrDigit(ch)) {
            stack.push(String.valueOf(ch));
        } else {
            String op1 = stack.pop();
            String op2 = stack.pop();
            stack.push("(" + op2 + ch + op1 + ")");
        }
    }

    public static void main(String[] args) {
        String exp = "abc++";
        System.out.println(toInfix(exp));
    }
}
