import java.util.*;

public class Palindrome {

    //The method will return a boolean value for the pallindrome being checked
    public static boolean stackmaster(Queue<Integer> Queue2) {
        Stack<Integer> TempStorage = new Stack<>();
        boolean isPalindrome=true;
        for (int i = 0; i < Queue2.size(); i++) {
            TempStorage.push(Queue2.peek());//This adds the value of each queue position to the stack
            Queue2.add(Queue2.remove());//this takes the position from the front and moves it to the back of the queue resetting the postion so it can
            //fully go through the code.

        }
        //if the queue is empty then it is a palindrome
        if (Queue2.isEmpty()) {
            isPalindrome=true;
        }
        //for each queue it checks if the values are equal and returns true if they are
        for (int i = 0; i < Queue2.size(); i++) {
            //if the queue and stack do not match it will return false
            if (!Queue2.peek().equals(TempStorage.pop())) {
                isPalindrome=false;
            //this statement resets the queue for the next pass around to compare with the popped value from stack.
            }Queue2.add(Queue2.remove());

        }
        return isPalindrome;
    }
}
