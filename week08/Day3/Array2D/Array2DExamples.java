package Day3.Array2D;

public class Array2DExamples {

    /*
     * 2D Arrays
     * - array of arrays
     * - they have rows and columns
     * - rows are has horizontal elements
     * - cols hsa vertical elements
     * 
     * int[row][col] = new int[][]
     * 
     * To find the total number of elements in a 2D array:
     *      number_of_rows * number_of_cols
     * 
     */
    public static void main(String[] args) {
        int[][] nums = new int[2][];
        nums[0] = new int[3];
        nums[1] = new int[4]; 
        nums[0][0] = 1;
        nums[0][1] = 3;
        nums[0][2] = 5;
        nums[1][0] = 1;
        nums[1][1] = 2;
        nums[1][2] = 2;
        nums[1][3] = 1;
        /*
         *        columns
         * rows   0   1   2   3
         *   0   [1] [3] [5] [ ]
         *   1   [1] [2] [2] [1]
         * 
         */

        System.out.println(nums[0][1]);
        System.out.println(countElements(nums));
        System.out.println(countElements(new int[5][6]));
        System.out.println("Sum of nums 2D array: " + sum(nums));
        System.out.println("Average of nums 2D array: " + average(nums));
        System.out.println("Max Value in nums 2D array: " + maxValue(nums));
        System.out.println("Min Value in nums 2D array: " + minValue(nums));

        int[][] nums2 = {{1,2,2,5},{2,3,1}};
        nums2[1][2] = 10;
        System.out.println(nums2[1][2]);

        String[][] friendGroups = {{"Josh", "Carlos"}, {"Sam", "Rod", "Nasser"},
                {"Sean", "Hunter"}, {null}
                };
        System.out.println(friendGroups[1][0]);;
        System.out.println("Concatenating the friend group 2D array: " + concatenate(friendGroups));

    }

    //Counts the total number of elements by traversing through each row and column
    public static int countElements(int[][] nums) {
        int count = 0;
        //iterates through the rows
        for(int i = 0; i < nums.length; i++) {
            //iterates through the cols
            for(int j = 0; j < nums[i].length; j++) {
                count++;
            }
        }
        return count;
    }

    //calculates sum of all the elements present in the array
    public static int sum(int[][] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < nums[i].length; j++) {
                //retrieves the value of the current row[i] and col[j]
                int value = nums[i][j];
                sum += value;
            }
        }
        return sum;
    }

    public static double average(int[][] nums) {
        int sum = sum(nums);
        int count = countElements(nums);

        return (double) sum / count;
        //return (double) sum(nums) / countElements(nums);
    }

    //find the max number in the 2D array
    public static int maxValue(int[][] nums) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < nums[i].length; j++) {
                max = Math.max(max, nums[i][j]);
            }
        }
        return max;
    }

    //find the minimum number in the 2D array
    public static int minValue(int[][] nums) {
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < nums[i].length; j++) {
                min = Math.min(min, nums[i][j]);
            }
        }
        return min;
    }

    //concatenating all the string in the 2D Array
    public static String concatenate(String[][] strs) {
        String result = "";
        for(int i = 0; i < strs.length; i++) {
            String row = ""; //reseting the string we're using to be empty
            for(int j = 0; j < strs[i].length; j++) {
                row += strs[i][j] + " ";
                //result += strs[i][j];
            }
            result += row;
        }
        return result;
    }
    
}
