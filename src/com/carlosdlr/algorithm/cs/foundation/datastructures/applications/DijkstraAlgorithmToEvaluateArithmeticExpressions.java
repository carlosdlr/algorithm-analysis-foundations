package com.carlosdlr.algorithm.cs.foundation.datastructures.applications;

import com.carlosdlr.algorithm.cs.foundation.datastructures.GenericStack;
/**
 * steps of this algorithm
 * 1. Value push onto the value stack
 * 2. operator push onto the operator stack
 * 3. Left parenthesis ignore
 * 4. right parenthesis pop operator and 2 values, push the result of the applying that operator to those values
 *    onto the operand stack
 */
public class DijkstraAlgorithmToEvaluateArithmeticExpressions {

    public static void main(String [] args) {

        String [] expression = {"(","1","+","(","(","2","+","3",")","*","(","4","*","5",")",")",")"};
        Double result = dijkstraAlgorithmEvaluation(expression);
        System.out.println(result);
    }

    private static Double dijkstraAlgorithmEvaluation (String [] expression) {
        GenericStack<String> operators = new GenericStack<>();
        GenericStack<Double> values = new GenericStack<>();

        for(String string: expression) {
            if(string.equals("("));
            else if (string.equals("+")) operators.push(string);
            else if (string.equals("*")) operators.push(string);
            else if (string.equals(")")) {
                String operator = operators.pop();
                if (operator.equals("+")) values.push(values.pop() + values.pop());
                else if (operator.equals("*")) values.push(values.pop() * values.pop());
            } else values.push(Double.parseDouble(string));
        }
        return values.pop();
    }
}
