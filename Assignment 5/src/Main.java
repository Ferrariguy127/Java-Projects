//David D Bulin,
//Assignment 5 BST Comparisons
//November 13 2023
//Using BSTS compare their speed as they traverse a random set of numbers between 0 and 9999 using 500 of them
//Then rank them from fastest to slowest.


import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


class TraversalInfo {
    String method;
    double averageTime;

    public TraversalInfo(String method, double averageTime) {
        this.method = method;
        this.averageTime = averageTime;
    }
}


public class Main {
    private static List<Integer> generateUniqueRandomNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 9999; i++) {
            numbers.add(i);
        }
        List<Integer> only500 = new ArrayList<>();
        for (int i = 0; i < Math.min(numbers.size(), 500); i++) {
            only500.add(numbers.get(i));
        }
        return only500;
    }


    public static void main(String[] args) {
        int runs = 10;
        List<TraversalInfo> traversalInfoList = new ArrayList<>();

        //This
        String[] traversalMethods = {"inorder", "preorder", "postorder", "levelorder"};
        for (String method : traversalMethods) {
            double totalRuntime = 0;
            BinarySearchTree bst = new BinarySearchTree();
            for (int run = 0; run < runs; run++) {
                List<Integer> randomNumbers = generateUniqueRandomNumbers();
                for (int num : randomNumbers) {
                    bst.insert(num);
                }

                //This creates several files at a time, it currently makes 10 runs for each method, but could be adjusted for more runs,
                String fileName = "bst_elements" + method + "_run_" + (run + 1) + ".txt";//allows the program to run through all 10 trials for it

                try (FileWriter writer = new FileWriter(fileName)) {
                    double startTime = System.nanoTime(); //stores a value for what time the method starts at to compare against endTime later on. recommended fix is change double to long, as it stores longer values,
                    //these try if/catch statements pull the method name from the traversalMethods string[] made earlier

                    if ("inorder".equals(method)) {
                        bst.inorderTraversal(bst.root, writer);
                    } else if ("preorder".equals(method)) {
                        bst.preorderTraversal(bst.root, writer);
                    } else if ("postorder".equals(method)) {
                        bst.postorderTraversal(bst.root, writer);
                    } else if ("levelorder".equals(method)) {
                        bst.levelOrderTraversal(bst.root, writer);
                    } else {
                        // Handle the case where 'method' does not match any expected values
                        System.out.println("There is no method for that " + method);
                        return;
                    }

                    double endTime = System.nanoTime();  //https://www.educative.io/answers/what-is-the-systemnanotime-function-in-java is the site that explains nano time code for when we forget later.
                    totalRuntime += endTime - startTime;//It suggests swapping to a long variable type, but we haven't discussed that yet,
                } catch (IOException e) {
                }
            }

            double averageTime = totalRuntime / runs; //total time over the 10 trials per method
            traversalInfoList.add(new TraversalInfo(method, averageTime));
            System.out.printf("%s average run time is : %.2f nanoseconds\n", method.toUpperCase(), averageTime);
        }


        // Rank the traversal methods based on average run times
        //I used a similar method in assignment 4 where the list moves through traversalInfoList by adding a temp value to hold positions and swap them if needed
        int n = traversalInfoList.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (traversalInfoList.get(j).averageTime > traversalInfoList.get(j + 1).averageTime) {
                    // Swap elements if they are in the wrong order
                    TraversalInfo temp = traversalInfoList.get(j);
                    traversalInfoList.set(j, traversalInfoList.get(j + 1));
                    traversalInfoList.set(j + 1, temp);
                }
            }
        }

        System.out.println("\nRanking:");
        int rank = 1;
        for (TraversalInfo info : traversalInfoList) {
            System.out.printf("%d. %s: %.2f nanoseconds\n", rank++, info.method.toUpperCase(), info.averageTime);
        }
    }
}
