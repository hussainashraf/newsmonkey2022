package RedHat_Assingment;

public class ThreeXThreeMatrices {
    public static void main(String[] args) {
        /*
        Code for 3x3 matrices transpose and their multiplication
        we have taking one 2d array of 3x3 matrices
        and also one copy array of original array(used for multiplication)
         */
        int[][] arr1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};//Original array
        int[][] arr2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};//copy array
        System.out.println("Matrice Before Transpose"); //Printing 2D array before transpose
        for (int i = 0; i < arr1.length; i++) {
            for (int k = 0; k < arr1.length; k++)
                System.out.print(arr1[i][k] + " ");
            System.out.print("\n");
        }
        transposeMatric(arr1);//function to get transpose of 2d array
        System.out.println("Matrice After Transpose");//Printing 2D array before transpose
        for (int i = 0; i < arr1.length; i++) {
            for (int k = 0; k < arr1.length; k++)
                System.out.print(arr1[i][k] + " ");
            System.out.print("\n");
        }
        System.out.println("Matrice Multiplication");
        MatricMultiplication(arr2, arr1);//function to get multiplication of original array and transposed array
    }

    /*
    Function which help to get transpose of given matrices by interchanging the value without
    using extra space
     */
    public static void transposeMatric(int[][] arr1) {
        for (int i = 0; i < arr1.length; i++) { // loop for main array 1d
            for (int j = i + 1; j < arr1.length; j++) { //iterate over content of 1d array
                int temp = arr1[i][j]; // using temp variable to interchange the value
                arr1[i][j] = arr1[j][i];
                arr1[j][i] = temp;
            }
        }
    }

    /*
    Function which help to get the multiplication of original and transpose array
    as well as printing them
     */
    public static void MatricMultiplication(int[][] arr1, int[][] arr2) {
        int[][] arr3 = new int[arr1.length][arr1.length]; // creating new array to store the value after multiplication
        for (int i = 0; i < arr1.length; i++) { //for row
            for (int j = 0; j < arr1.length; j++) { // for column
                arr3[i][j] = 0;
                for (int k = 0; k < arr1.length; k++) {//for iterate over row and column content
                    arr3[i][j] += arr1[i][k] * arr2[k][j]; // storing values of multiplication into new array
                }
                System.out.print(arr3[i][j] + " ");//printing new matrices
            }
            System.out.println();
        }
    }
}

