package leetcode.string.TwoSum;

import java.util.Arrays;
import java.util.HashMap;

// Given an integer array, return a pair of indices [X, Y] of the array that sums up to a given target value Z.
// i.e. arr[X] + arr[Y] = Z
// if said pair does not exist, return [0, 0];
// the input array will only contain one unique or no solution

public class TwoSum {
  public static void main(String[] args) {
    int[] input = {1, 2, 3, 4, 5};
    int target = 13;

    int[] result = getTwoSum(input, target);

    System.out.println(Arrays.toString(result));
  }

  public static int[] getTwoSum(int[] input, int target) {
    int[] result = {0,0};

    HashMap<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < input.length; i++) {
      int toFind = target - input[i];

      if (map.containsKey(toFind)) {
        result[0] = i;
        result[1] = map.get(toFind);
        return result;
      }

      map.put(input[i], i);
    }

    return result;
  }
}
