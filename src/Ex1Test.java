import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * This JUnit class represents a very partial test class for Ex1.
 * Make sure you complete all the needed JUnits
 */
public class Ex1Test {
        @Test
        void computeNumberTest() {
            String s2 = "1011b2";
            int v = Ex1.number2Int(s2);
            assertEquals(v,11);
            String s10 = "1011bA";
            v = Ex1.number2Int(s10);
            s2 = Ex1.int2Number(v,2);
            int v2 = Ex1.number2Int(s2);
            assertEquals(v,v2);
            assertTrue(Ex1.equals(s10,s2));
        }

        @Test
        void isBasisNumberTest() {
            String[] good = {"1", "1b2", "01b2", "123bA", "ABbG", "0bA"};
            for(int i=0;i<good.length;i=i+1) {
                boolean ok = Ex1.isNumber(good[i]);
                assertTrue(ok);
            }
            String[] not_good = {"b2", "2b2", "1G3bG", " BbG", "0bbA", "abB", "!@b2", "A", "1bb2","-3b5","3 b4","GbG","",null,"1234b11"};
            for(int i=0;i<not_good.length;i=i+1) {
                boolean not_ok = Ex1.isNumber(not_good[i]);
                assertFalse(not_ok);
            }
        }

        @Test
        void int2NumberTest() {
            assertEquals("11b2", Ex1.int2Number(3, 2));
            assertEquals("78bG", Ex1.int2Number(120, 16));
            assertEquals("", Ex1.int2Number(-1, 10));
            assertEquals("", Ex1.int2Number(10, 1));
        }

        @Test
        void maxIndexTest() {
            String[] arr = {"1b2", "10b2", "1bA", "AAbG"};
            assertEquals(3, Ex1.maxIndex(arr));
            String[] arr2 = {"1b2", "10b2", "1bA", "AAbG", "AAbG"};
            assertEquals(3, Ex1.maxIndex(arr2));
        }

        @Test
        void validNumbersTest() {
            assertTrue(Ex1.isNumber("135bA"));
            assertTrue(Ex1.isNumber("100111b2"));
            assertTrue(Ex1.isNumber("12345b6"));
            assertTrue(Ex1.isNumber("012b5"));
            assertTrue(Ex1.isNumber("123bG"));
            assertTrue(Ex1.isNumber("EFbG"));
        }


        @Test
        void invalidNumbersTest() {
            assertFalse(Ex1.isNumber("b2"));
            assertFalse(Ex1.isNumber("0b1"));
            assertFalse(Ex1.isNumber("123b"));
            assertFalse(Ex1.isNumber("1234b11"));
            assertFalse(Ex1.isNumber("3b3"));
            assertFalse(Ex1.isNumber("-3b5"));
            assertFalse(Ex1.isNumber("3 b4"));
            assertFalse(Ex1.isNumber("GbG"));
            assertFalse(Ex1.isNumber(""));
            assertFalse(Ex1.isNumber(null));
        }

        @Test
        void sumProductTest() {
            String num1 = "10b2";
            String num2 = "11b2";
            int value1 = Ex1.number2Int(num1);
            int value2 = Ex1.number2Int(num2);
            int base = 2;
            String sum = Ex1.int2Number(value1 + value2, base);
            String product = Ex1.int2Number(value1 * value2, base);
            String[] arr = {num1, num2, sum, product};
            int maxIdx = Ex1.maxIndex(arr);
            assertEquals("101b2", sum);
            assertEquals("110b2", product);
            assertEquals(3, maxIdx);
        }


        @Test
        void fullScenrioTest() {
            String num1 = "1001b2";
            String num2 = "11b3";
            String num3 = "1DbG";
            String num4 = "AAbB";
    
            // Validation
            assertTrue(Ex1.isNumber(num1));
            assertTrue(Ex1.isNumber(num2));
            assertTrue(Ex1.isNumber(num3));
            assertTrue(Ex1.isNumber(num4));
    
            // Conversion and Arithmetic
            int value1 = Ex1.number2Int(num1);
            int value2 = Ex1.number2Int(num2);
            int value3 = Ex1.number2Int(num3);
            int value4 = Ex1.number2Int(num4);
    
            assertEquals(9, value1);
            assertEquals(4, value2);
            assertEquals(29, value3);
            assertEquals(120, value4);
    
            // Addition and Multiplication
            int sum = value1 + value2;
            int product = value1 * value2;
    
            String sumStr = Ex1.int2Number(sum, 10);
            String productStr = Ex1.int2Number(product, 10);

            //this is also in main in order to remove the base from the output as decimal numbers don't need to have bA at the end
            sumStr = sumStr.substring(0, sumStr.length() - 2);
            productStr = productStr.substring(0, productStr.length() - 2);

            assertEquals("13", sumStr);
            assertEquals("36", productStr);
    
            // Equality Check
            assertTrue(Ex1.equals(num3, "29"));
            assertFalse(Ex1.equals(num3, "30"));
    
            // Finding Maximum Value
            String[] arr = {num1, num2, num3, num4, sumStr, productStr};
            int maxIdx = Ex1.maxIndex(arr);
            assertEquals(3, maxIdx); // Index of "AAbB"
    }
}
    