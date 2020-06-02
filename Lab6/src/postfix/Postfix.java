package postfix;

import stack.LinkedListStack;
import stack.Overflow;
import stack.Underflow;

public class Postfix {

    public double evaluate(String postfix) throws Underflow, Overflow {
        LinkedListStack<Object> stack = new LinkedListStack<>();
        postfix = postfix.replaceAll(" ", "");
        for (char c : postfix.toCharArray()) {
            if (Character.isDigit(c)) {
                stack.push(c - '0');
            } else {
                double rhs = Double.parseDouble(stack.pop().toString());
                double lhs = Double.parseDouble(stack.pop().toString());

                switch (c) {
                    case '^':
                        stack.push(Math.pow(lhs, rhs));
                        break;
                    case '*':
                        stack.push(lhs * rhs);
                        break;
                    case '/':
                        stack.push(lhs / rhs);
                        break;
                    case '+':
                        stack.push(lhs + rhs);
                        break;
                    case '-':
                        stack.push(lhs - rhs);
                        break;
                    default:
                        throw new IllegalArgumentException("Operator not valid: " + c);
                }
            }
        }
        return (double) stack.top();
    }

    public int precedence(char c) {
        switch (c) {
            case '^':
                return 3;
            case '/':
            case '*':
                return 2;
            case '-':
            case '+':
                return 1;
            default:
                return 0;
        }
    }

    public String infixToPostfix(String infix) throws Overflow, Underflow {
        String output = "";
        LinkedListStack<Object> infixstack = new LinkedListStack<>();
        infix = infix.replaceAll(" ", "");
        for (char c : infix.toCharArray()) {
            if (Character.isDigit(c))
                output += c + " ";
            else if (c == '(')
                infixstack.push(c);
            else if (c == ')') {
                while (!infixstack.isEmpty() && (char) infixstack.top() != '(') {
                    output += infixstack.top() + " ";
                    infixstack.pop();
                }
                // pop left brace
                infixstack.pop();
            }
            // operator
            else {
                while (!infixstack.isEmpty() && precedence(c) <= precedence((char) infixstack.top()) && (char) infixstack.top() != '(') {
                    output += infixstack.top() + " ";
                    infixstack.pop();
                }
                infixstack.push(c);
            }
        }
        while (!infixstack.isEmpty()) {
            output += infixstack.top() + " ";
            infixstack.pop();
        }

        output = output.substring(0, output.length() - 1);
        return output;
    }
}
