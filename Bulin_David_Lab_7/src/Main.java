import java.util.*;
import java.util.EmptyStackException;
// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Stack<Character> S = new Stack<Character>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the equation to be evaluated. ");
        String formula = sc.nextLine();

        for (int i=0; i<formula.length(); i++) {
            char q = formula.charAt(i);
            char q2 = 0;
            if  (q=='(' || q=='{' || q=='['){
                S.push(q);
            }

            else if (q == ')' || q=='}' || q==']'){
                q2 =S.pop();
            }
            if (q ==')'&& q2=='(' || q=='}' && q2 =='{' || q==']' && q2 =='['){
                System.out.println("Balanced");
            }

            if (q ==')'&& q2 != '(' || q=='}' && q2 !='{' || q==']' && q2 !='[') {
                System.out.println("Unbalanced");
            }
            else
                System.out.println("No Parenthesis found! ");

        }
        System.out.println(S);
        System.out.println(formula);

        //if balanced return "balanced"


        //if unbalanced return "unbalanced"


        //if no parenthesis return "no parenthesis"
        //boolean for if S is empty or not.

    }
}