package String;

/*
Solve the given equation and return the value of variable x in the form of string "x=some number". The equation only contains '+', '-' operation, the variable x and its coefficient.

        If there is no solution to the equation, output "No solution".

        If there are infinite number of solutions, output "Infinite solutions".

        If there is only one solution, output the result, for example "x=1".

        Example 1:

        Input = "x+1=2x"

        Output = "x=1"

        Example 2:

        Input = "x+1=x+1"

        Output = "Infinite solutions"

        Example 3:

        Input = "x+1=x+2"

        Output = "No solution"

        Assumption:

        If the given equation has a solution, the value of the solution is guaranteed integer.
*/

public class SolveLinearEquation {
    // time complexity: O(n)
    // space complexity: O(1)
    public String solveEquation(String equation) {
        int xCount = 0;
        int numCount = 0;
        boolean equalSymbol = false;
        int op = 1;
        int i = 0;
        while (i < equation.length()) {
            char var = equation.charAt(i);
            // op
            if (var == '+') {
                op = 1;
                i++;
            } else if (var == '-') {
                op = -1;
                i++;
            } else if (var == '=') {
                op = 1;
                equalSymbol = true;
                i++;
            }

            // case 1: before =
            // case 2: after =
            if (!equalSymbol) {
                int count = 0;
                boolean counted = false;
                // count
                if (Character.isDigit(equation.charAt(i))) {
                    while (i < equation.length() && Character.isDigit(equation.charAt(i))) {
                        counted = true;
                        count = count * 10 + Character.getNumericValue(equation.charAt(i));
                        i++;
                    }
                }

                // assign value
                if (equation.charAt(i) == 'x') {
                    if (!counted) {
                        xCount += op;
                    } else {
                        xCount += op * count;
                    }
                    i++;
                } else {
                    numCount += op * count;
                }
            } else {
                int count = 0;
                boolean counted = false;
                // count
                if (Character.isDigit(equation.charAt(i))) {
                    while (i < equation.length() && Character.isDigit(equation.charAt(i))) {
                        counted = true;
                        count = count * 10 + Character.getNumericValue(equation.charAt(i));
                        i++;
                    }
                }

                // assign value
                if (i < equation.length() && equation.charAt(i) == 'x') {
                    if (!counted) {
                        xCount -= op;
                    } else {
                        xCount -= op * count;
                    }
                    i++;
                } else {
                    numCount -= op * count;
                }
            }
        }

        // calculation
        if (xCount == 0) {
            if (numCount == 0) {
                return "Infinite solutions";
            } else {
                return "No solution";
            }
        } else {
            return "x=" + (- numCount / xCount);
        }
    }

    public static void main(String[] args) {
        SolveLinearEquation test = new SolveLinearEquation();
        System.out.println(test.solveEquation("-22x=6x+0x+252"));
    }
}
