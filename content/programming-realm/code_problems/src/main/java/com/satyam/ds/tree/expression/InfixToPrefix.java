package com.satyam.ds.tree.expression;

/**
 * Use postfix
 *
 * 1. Reverse the given infix string
 *      1.a every ( becomes ) and vice-versa
 * 2. Apply infixToPostfix on reversed string
 * 3. Reverse the postfix result
 */
public class InfixToPrefix {

    private static String toPrefix(String infixExpr) {
        String reversedExpr = reverse(infixExpr);
        String postfixExpr = InfixToPostfix.toPostfix(reversedExpr);
        return reverse(postfixExpr);
    }

    private static String reverse(String infixExpr) {
        StringBuilder builder = new StringBuilder();
        for (int i = infixExpr.length() - 1; i >= 0; i--) {
            char ch = infixExpr.charAt(i);
            if (ch == '(') {
                ch = ')';
            } else if (ch == ')') {
                ch = '(';
            }
            builder.append(ch);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        String exp = "(A-B/C)*(A/K-L)";
        System.out.println(toPrefix(exp));
    }
}
