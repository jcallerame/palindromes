import static org.hamcrest.CoreMatchers.equalTo;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.elsewhen.palindromes.Application;

public class ApplicationTest {
    @Test public void testIsPalindromeMethod() {
        assertTrue("isPalindrome should return true", 
        		Application.isPalindrome("AManAPlanACanalPanama"));
        assertFalse("isPalindrome should return false", 
        		Application.isPalindrome("FooBar"));
    }
    
    @Test public void testGetPermutationsMethod() {
    	Set<String> expectedResult = new HashSet<>();
    	expectedResult.addAll(Arrays.asList(
    			new String[] {"ab", "ac", "ba", "bc", "ca", "cb"}));
    	assertThat(Application.getPermutations(2, 
    			Arrays.asList(new String[] {"a", "b", "c"})),
    			equalTo(expectedResult));
    }
}
