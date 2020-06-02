package ui;

import postfix.Postfix;
import stack.Overflow;
import stack.Underflow;

import java.util.Scanner;

public class UI {
    public static void main(String[] args) throws Underflow, Overflow {
        Postfix postfix = new Postfix();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String pfx = postfix.infixToPostfix(input);
        System.out.println(postfix.evaluate(pfx));
    }
}