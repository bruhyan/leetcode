package leetcode.ProductOtherThanSelf;

import java.util.Arrays;

public class ProductOtherThanSelf {
  public static void main(String[] args) {
    int[] arr = {10, 3, 5, 6, 2};
    // int[] result = ProductOtherThanSelfNaive(arr);
    // int[] result = ProductOtherThanSelfBetter(arr);
    int [] result = ProductOtherThanSelfDivision(arr);

    System.out.println(Arrays.toString(result));
  }

  // 2 array method;
  // time complexity = O(n)
  // space complexity = O(2n) = O(n)
  public static int[] ProductOtherThanSelfNaive(int[] arr) {
    int len = arr.length;
    int[] result = new int[len];
    int[] left = new int[len];
    int[] right = new int[len];

    left[0] = 1; // leftmost element of left array is always 1
  
    right[len-1] = 1; //right most element of right array is always 1

    for (int i = 1; i < len; i++) {
      left[i] = left[i-1] * arr[i-1];
    }

    for (int j = len - 2; j >= 0; j--) {
      right[j] = right[j+1] * arr[j+1];
    }

    for(int k = 0; k < len; k++) {
      result[k] = left[k] * right[k];
    }

    return result;
  }

  public static int[] ProductOtherThanSelfBetter(int[] arr) {
    int len = arr.length;
    int[] result = new int[len];
    Arrays.fill(result, 1);

    int temp = 1;

    // go from left to right
    // temp = product of elements on left side excluding arr[i]
    for(int i = 0; i < len; i++) {
      result[i] = temp;
      temp *= arr[i];
    }

    temp = 1;

    // go from right to left
    // temp is the product of elements on the right side excluding arr[i]
    for(int j = len - 1; j >= 0; j--) {
      result[j] *= temp;
      temp *= arr[j];
    }

    return result;
  }

  public static int[] ProductOtherThanSelfDivision(int [] arr) {
    int len = arr.length;
    int flag = 0; // keep track of number of zeros in the input
    int[] result = new int[len];

    int totalProduct = 1;

    for (int i = 0; i < len; i++) {
      if (arr[i] == 0) {
        flag++;
      } else {
        totalProduct *= arr[i]; // if encounter zero do not multiply with totalProduct
      }
    }

    for (int j = 0; j < len; j++) {
      if (flag > 1) { // if more than 1 zeros in arr, then product arr will all be zero
        result[j] = 0;
      } else if (flag == 0) { // if no zeros at all, then divide totalProduct by current number
        result[j] = (totalProduct / arr[j]);
      } else if (flag == 1 && arr[j] != 0) { // if there is 1 zero and the current number IS NOT THE ZERO == zero is in the neighbours == product will be zero
        result[j] = 0;
      } else {
        result[j] = totalProduct; // if there is 1 zero and the current number IS THE ZERO == zero is not the neighbours == product will be total{roduct
      }
    }

    return result;
  }
  
}
