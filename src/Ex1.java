/**
 * This class represents a simple solution for Ex1.
 * As defined here: https://docs.google.com/document/d/1AJ9wtnL1qdEs4DAKqBlO1bXCM6r6GJ_J/r/edit/edit
 * In this assignment, we will design a number formatting converter and calculator.
 * In general, we will use Strings as numbers over basis of binary till Hexa.
 * [2-16], 10-16 are represented by A,B,..G.
 * The general representation of the numbers is as a String with the following format:
 * <number><b><base> e.g., “135bA” (i.e., “135”, as 10 is the default base), “100111b2”, “12345b6”,”012b5”, “123bG”, “EFbG”.
 * The following are NOT in the format (not a valid number):
 * “b2”, “0b1”, “123b”, “1234b11”, “3b3”, “-3b5”, “3 b4”, “GbG”, "", null,
 * You should implement the following static functions:
 */
public class Ex1 {
        /**
         * Convert the given number (num) to a decimal representation (as int).
         * It the given number is not in a valid format returns -1.
         * @param num a String representing a number in basis [2,16]
         * @return
         */
        public static int number2Int(String num) {
            if (!isNumber(num))
            {
                return -1;
            } 
            String[] parts = num.split("b");
            int base = getBase(parts[1]);
            try { //I am using try and catch to catch the exception if the number is not in the correct format
                return Integer.parseInt(parts[0], base); //This allows me to convert the number to an integer in the given base from getBase function
            } catch (NumberFormatException e) {
                return -1;
            }
        }
        
        /**
         * This static function checks if the given String (g) is in a valid "number" format.
         * @param a a String representing a number
         * @return true iff the given String is in a number format
         * 
         */
        public static boolean isNumber(String a) {
            boolean ans = true;
            if (a == null || a.isEmpty()) 
            {
                ans = false;
            } 
            else 
            {
                int bIndex = a.indexOf('b');
                if (bIndex == -1 || bIndex == 0 || bIndex == a.length() - 1) 
                {
                    ans = false;
                } 
                else {
                    String numberPart = a.substring(0, bIndex);
                    String basePart = a.substring(bIndex + 1);
                    if (!isValidBase(basePart))
                    {
                        ans = false;
                    } 
                    else
                    {
                        if (!isValidNumber(numberPart, getBase(basePart))) 
                        {
                            ans = false;
                        }
                    }
                }
            }
            return ans;
        }

        
        /**
         * This function returns the integer value of the given base. 
         * for example, if the base is 2, the function returns 2. If the base is A, the function returns 10.
         *  If the base is not valid, the function returns -1. (Added this function to avoid code duplication in isNumber function) 
         */
        private static int getBase(String base) {
            if (base.length() == 1) 
            {
                char c = base.charAt(0);
                if (c >= '2' && c <= '9')
                { 
                    return c - '0';
                }
                if (c >= 'A' && c <= 'G')
                {
                    return c - 'A' + 10;
                } 
            }
            return -1;
        }
        

        /** 
        * Converts a given base value to its corresponding character representation.
        *The base value to be converted. It should be in the range of 2 to 16.
        *             - For values between 2 and 9 (inclusive), the char will between will be '2' to '9'.
        *             - For values between 10 and 16 (inclusive), the char will between be 'A' to 'F'.
        * The char representation of the base value. If the base is not within the valid range, (' ') is returned.
        */
        private static char getBaseChar(int base) {
            char ans = ' ';
            if (base >= 2 && base <= 9)
            {
                ans = (char) ('0' + base);
            } 
            if (base >= 10 && base <= 16)
            {
                ans = (char) ('A' + base - 10);
            } 
            
            return ans;
        }

        /**
         * This function checks if the given base is valid.
         * If the base is not valid, the function returns false. 
         * (Added this function to account for the case where the base is not valid in isNumber function - test)
         */
        private static boolean isValidBase(String base) {
            return getBase(base) != -1;
        }
        
        /**
         * This function checks if the given number is valid.
         * If the number is not valid, the function returns false. (Added this function to account for the case where the number is not valid in isNumber function - test)
         */
        private static boolean isValidNumber(String number, int base) {
            for (char c : number.toCharArray()) {
                int value = Character.digit(c, base); // I used the Character.digit function to get the value of the character in the given base
                if (value == -1)
                { 
                    return false;
                }
            }
            return true;
        }
        /**
         * Calculate the number representation (in basis base)
         * of the given natural number (represented as an integer).
         * If num<0 or base is not in [2,16] the function should return "" (the empty String).
         * @param num the natural number (include 0).
         * @param base the basis [2,16]
         * @return a String representing a number (in base) equals to num, or an empty String (in case of wrong input).
         */
        public static String int2Number(int num, int base) {
            String ans = "";
            if (num < 0 || base < 2 || base > 16) 
            {
                ans = Integer.toString(num, base) + "b" + getBaseChar(base);
            }
            return ans;
        }

        /**
         * Checks if the two numbers have the same value.
         * @param n1 first number
         * @param n2 second number
         * @return true iff the two numbers have the same values.
         */
        public static boolean equals(String n1, String n2) {
            boolean ans = true;
            if (!isNumber(n1) || !isNumber(n2)) 
            {
                ans = false;
            } 
            else 
            {
                int num1 = number2Int(n1);
                int num2 = number2Int(n2);
                if (num1 != num2) 
                {
                    ans = false;
                }
            }
            return ans;
        }

        /**
         * This static function search for the array index with the largest number (in value).
         * In case there are more than one maximum - returns the first index.
         * Note: you can assume that the array is not null and is not empty, yet it may contain null or none-valid numbers (with value -1).
         * @param arr an array of numbers
         * @return the index in the array in with the largest number (in value).
         *
         */
        public static int maxIndex(String[] arr) {
            int ans = 0;
            int max = number2Int(arr[0]);
            for (int i = 1; i < arr.length; i++) {
                int num = number2Int(arr[i]);
                if (num > max) {
                    max = num;
                    ans = i;
                }
            }
            return ans;
        }
}