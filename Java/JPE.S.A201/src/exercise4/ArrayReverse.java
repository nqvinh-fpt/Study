package exercise4;

public class ArrayReverse {
    public static void main(String[] args) {
        int[] myIntArray = {43, 32, 53, 23, 12, 34, 3, 12, 43, 32};
        System.out.print("Original Array: ");
        for (int i= 0; i<myIntArray.length;i++) {
            if(i!=myIntArray.length-1){
                System.out.print(myIntArray[i] + ", ");
            }else {
                System.out.print(myIntArray[i]);
            }
        }
        System.out.println();
        int[] reversedArray = new int[myIntArray.length];
        for (int i = 0; i < myIntArray.length; i++) {
            reversedArray[i] = myIntArray[myIntArray.length - 1 - i];
        }
        System.out.print("Reversed Array: ");
        for (int i= 0; i<reversedArray.length;i++) {
            if(i!=reversedArray.length-1){
                System.out.print(reversedArray[i] + ", ");
            }else {
                System.out.print(reversedArray[i]);
            }

        }
        System.out.print("s");
    }
}
