package RedHat_Assingment;

import java.util.ArrayList;

public class DigitCombination {
    public static final String DIGITS = "123456789";

    public static void main(String[] args) {
        int target  = 100;
        printcombinatios(target);
    }
/*
* Function responsible for printing all the combinations
* */
    public static void printcombinatios(int target) {
        System.out.println("All Combinations are--");
        for (String ans : digitcombination(target)) {
            System.out.println(ans);
        }
    }
/*
*Function return all the possible combinations
* */
    public static ArrayList<String> digitcombination(int target) {
        ArrayList<String> results = new ArrayList<>();
        generatecombination(0, 0, target, new StringBuilder(), results);//calling function which generate all the combinationsz
        return results;
    }
/*
Function responsible for generating all combinations
by recurrsion and backtracking
 */
    public static void generatecombination(int start, int sum, int target, StringBuilder path, ArrayList<String> results) {
        if (start == DIGITS.length()) { // check if the start comes at the end of digit string
            if (sum == target) {//if the sum = target
                results.add(path.toString());//then it add the current combination into results
            }
            return;//if the condition didnt satisfy then it goes back
        }

        int length = path.length();
        int num = 0;
        for (int i = start; i < DIGITS.length(); i++) { //iterate loop over 123.. to get the all possible comninations
            num = num * 10 + DIGITS.charAt(i) - '0';

            if(start!=0) path.append("+");//if the path contain something it appends + sign
            path.append(num);//append number after evaluation
            generatecombination(i+1,sum+num,target,path,results);//recursive call for remaining numbers(for + operations)
            path.setLength(length);

            path.append('-');
            path.append(num);
            generatecombination(i+1,sum-num,target,path,results);////recursive call for remaining numbers(for - operations)
            path.setLength(length);

        }

    }
}
