package org.jfree.data;

import static org.junit.Assert.*; import org.jfree.data.Range; import org.jfree.data.*;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.*;

public class RangeTest {
    private Range exampleRange;
    
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception { exampleRange = new Range(-1, 1);
    }

    /**
	 * This test covers a nominal value for the exampleRange for contains() 
	 */
    @Test
    public void testInRangeValueForMethodContains() {
    	assertEquals("The expected boolean should be true", true, exampleRange.contains(0));
    }
    
    /**
	 * This test covers an out of range value above the upper boundary for the exampleRange for contains() 
	 */
    @Test
    public void testPositiveOutOfRangeValueForMethodContains() {
    	assertEquals("The expected boolean should be false", false, exampleRange.contains(25));
    }
    
    /**
	 * This test covers an out of range value below the lower boundary for the exampleRange for contains() 
	 */
    @Test
    public void testNegativeOutOfRangeValueForMethodContains() {
    	assertEquals("The expected boolean should be false", false, exampleRange.contains(-25));
    }
    
    /**
	 * This test covers a value slightly below the upper boundary for the exampleRange for contains() 
	 */
    @Test
    public void testBelowUpperBoundaryForMethodContains() {
    	assertEquals("The expected boolean should be true", true, exampleRange.contains(0.99));
    }
    
    /**
	 * This test covers a value equal to the upper boundary for the exampleRange for contains() 
	 */
    @Test
    public void testEqualToUpperBoundaryForMethodContains() {
    	assertEquals("The expected boolean should be true", true, exampleRange.contains(1));
    }
    
    /**
	 * This test covers a value slightly above the upper boundary for the exampleRange for contains() 
	 */
    @Test
    public void testAboveUpperBoundaryForMethodContains() {
    	assertEquals("The expected boolean should be false", false, exampleRange.contains(1.01));
    }
    
    /**
	 * This test covers a value slightly below the lower boundary for the exampleRange for contains() 
	 */
    @Test
    public void testBelowLowerBoundaryForMethodContains() {
    	assertEquals("The expected boolean should be false", false, exampleRange.contains(-1.01));
    }
    
    /**
	 * This test covers a value equal to the lower boundary for the exampleRange for contains() 
	 */
    @Test
    public void testEqualToLowerBoundaryForMethodContains() {
    	assertEquals("The expected boolean should be true", true, exampleRange.contains(-1));
    }
    
    /**
	 * This test covers a value slightly above the lower boundary for the exampleRange for contains() 
	 */
    @Test
    public void testAboveLowerBoundaryForMethodContains() {
    	assertEquals("The expected boolean should be true", true, exampleRange.contains(-0.99));
    }
    
    /**
	 * This test covers a nominal value for the exampleRange for contains() 
	 */
    @Test
    public void testNominalValueForMethodContains() {
    	assertEquals("The expected boolean should be true", true, exampleRange.contains(0.5));
    }
    
    /**
	 * This test covers the getCentralValue() method using the exampleRange 
	 */
    @Test
    public void testCentralValueShouldBeCorrect() {
        assertEquals("The central value of -1 and 1 should be 0",
        0, exampleRange.getCentralValue(), .000000001d);
    }
    
    /**
	 * This test covers the getLength() method using the exampleRange 
	 */
    @Test
    public void testLengthShouldBeCorrect() {
        assertEquals("The length of the -1 to 1 range should be 2",
        2, exampleRange.getLength(), .000000001d);
    }
    
    /**
	 * This test covers the getLowerBound() method using the exampleRange 
	 */
    @Test
    public void testMethodGetLowerBound() {
    	assertEquals("The expected value should be -1", -1.0, exampleRange.getLowerBound(), .000000001d);
    }
    
    /**
	 * This test covers the getUpperBound() method using the exampleRange 
	 */
    @Test
    public void testMethodGetUpperBound() {
    	assertEquals("The expected value should be 1", 1.0, exampleRange.getUpperBound(), .000000001d);
    }
    
    /**
	 * This test covers the getLength() method using the exampleRange when the
	 * lower boundary is negative and the upper boundary is positive 
	 */
    @Test
    public void testGetLengthWhenLowerNegativeAndUpperPositive() {
        assertEquals("The length of the -1 to 1 range should be 2",
        2, exampleRange.getLength(), .000000001d);
    }
    
    /**
	 * This test covers the getLength() method using the exampleRange when the
	 * lower boundary is less than the upper boundary
	 */
    @Test
    public void testGetLengthWhenLowerLessThanUpper() {
    	Range range = new Range(0, 10);
    	assertEquals("Failed when lower < upper", 10.0, range.getLength(), .000000001d);
    }
    
    /**
	 * This test covers the getLength() method using the exampleRange when the
	 * lower boundary is equal to the upper boundary and both are
	 * positive
	 */
    @Test
    public void testGetLengthWhenLowerEqualsUpperPostive() {
    	Range range = new Range(5, 5);
    	assertEquals("Failed when  positive lower = positive upper", 0.0, range.getLength(), .000000001d);
    }
    
    /**
	 * This test covers the getLength() method using the exampleRange when the
	 * lower boundary is equal to the upper boundary and both are negative
	 */
    @Test
    public void testGetLengthWhenLowerEqualsUpperNegative() {
    	Range range = new Range(-5, -5);
    	assertEquals("Failed when negative lower = negative upper", 0.0, range.getLength(), .000000001d);
    }
    
    /**
	 * This test covers the getLength() method using the exampleRange when the
	 * lower boundary is less than the upper boundary and both are negative
	 */
    @Test
    public void testGetLengthWhenLowerAndUpperNegative() {
    	Range range = new Range(-10, -5);
    	assertEquals("Failed for fully negative range", 5.0, range.getLength(), .000000001d);
    }

    /**
	 * This test covers the hashCode() method using the exampleRange
	 */
    @Test
    public void testHashCode() {
        assertEquals("The expected hash should be", -31457280, exampleRange.hashCode());
    }

    /**
	 * This test covers the toString() method using the exampleRange
	 */
    @Test
    public void testToString() {
        assertEquals("The expected string should be 'Range[-1.0,1.0]'", "Range[-1.0,1.0]", exampleRange.toString()); 
    }

    /**
	 * This test covers the intersect() method using the exampleRange when the
	 * first branch intersects
	 */
    @Test
    public void testFirstBranchIntersect() {
        assertTrue("Did not find it intersects", exampleRange.intersects(-1.5, 0.5));
    }

    /**
	 * This test covers the intersect() method using the exampleRange when the
	 * second branch intersects
	 */
    @Test
    public void testSecondBranchIntersect() {
        assertTrue("Did not find it intersects", exampleRange.intersects(0.5, 1.5));
    }

    /**
	 * This test covers the intersect() method using the exampleRange when the
	 * range is a new test range
	 */
    @Test
    public void testIntersectOtherRange() {
        Range testRange = new Range(0.5, 1.5);
        assertTrue("did not find it intersects", exampleRange.intersects(testRange));
    }

    // covers two branches of no zero crossing and else of shift with bool
    /**
	 * This test covers the shift() method using the exampleRange
	 */
    @Test
    public void testShift() {
        Range testRange = new Range(-1.5, 0.5);
        assertEquals("Did not return shifted range", testRange, Range.shift(exampleRange, -0.5));
    }

    /**
	 * This test covers the shift() method using the exampleRange with a
	 * shift with boolean
	 */
    @Test
    public void testFirstBranchShiftWithBool() {
        Range testRange = new Range(-1.5, 0.5);
        assertEquals("Did not return shifted range", testRange, Range.shift(exampleRange, -0.5, true));
    }

    /**
	 * This test covers the shift() method using the exampleRange for the
	 * else branch for shift with no zero crossing
	 */
    @Test
    public void testElseBranchShiftWithNoZeroCrossing() {
        Range specialRange = new Range(0.0, 1);
        Range testRange = new Range(-1, 0);
        assertEquals("Did not return shifted range", testRange, Range.shift(specialRange, -1, false));
    }
    
    /**
	 * This test covers the equals() method using the exampleRange with a
	 * valid Range object
	 */
    @Test
    public void testValidObjectForMethodEquals() {
    	assertTrue("The given object should be a valid Range object", exampleRange.equals(exampleRange));
    }
    
    /**
	 * This test covers the equals() method using the exampleRange with an
	 * invalid object, which is an object not of the type Range
	 */
    @Test
    public void testInvalidObjectTypeForMethodEquals() {
    	Number n = 1;
    	assertFalse("The given object should not be a valid Range object", exampleRange.equals(n));
    }
    
    /**
	 * This test covers the equals() method using the exampleRange with a
	 * test Range with the a different lower boundary and same upper
	 * boundary
	 */
    @Test
    public void testDifferentLowerBoundForMethodEquals() {
    	assertFalse("The given object should not be a valid Range object", exampleRange.equals(new Range(-2, 1)));
    }
    
    /**
	 * This test covers the equals() method using the exampleRange with a
	 * test Range with the same lower boundary and different upper
	 * boundary
	 */
    @Test
    public void testDifferentUpperBoundForMethodEquals() {
    	assertFalse("The given object should not be a valid Range object", exampleRange.equals(new Range(-1, 2)));
    }
    
    /**
	 * This test covers a nominal value for the constrain() method using the exampleRange
	 */
    @Test
    public void testNominalValueForMethodConstrain() {
    	assertEquals("The expected value should be 0.5", 0.5, exampleRange.constrain(0.5), .000000001d);
    }
    
    /**
	 * This test covers an above upper boundary value for the constrain() method using the exampleRange
	 */
    @Test
    public void testAboveUpperBoundaryValueForMethodConstrain() {
    	assertEquals("The expected value should be 1", 1, exampleRange.constrain(25), .000000001d);
    }
    
    /**
	 * This test covers an below lower boundary value for the constrain() method using the exampleRange
	 */
    @Test
    public void testBelowLowerBoundaryValueForMethodConstrain() {
    	assertEquals("The expected value should be -1", -1, exampleRange.constrain(-25), .000000001d);
    }
    
    /**
	 * This test covers valid ranges for the combine() method using the exampleRange
	 */
    @Test
    public void testValidRangesForMethodCombine() {
    	Range rangeOne = new Range(-1, 1);
    	Range rangeTwo = new Range(0, 5);
    	Range expectedRange = new Range(-1, 5);
    	assertEquals("The expected range should be {-1,5}", expectedRange, Range.combine(rangeOne, rangeTwo));
    }
    
    /**
	 * This test covers a null first range and valid second range for the combine() method using the exampleRange
	 */
    @Test
    public void testRangeOneIsNullForMethodCombine() {
    	Range rangeOne = null;
    	Range rangeTwo = new Range(-2, 2);
    	assertSame("The expected range should be {-2,2}", rangeTwo, Range.combine(rangeOne, rangeTwo));
    }
    
    /**
	 * This test covers a valid first range and null second range for the combine() method using the exampleRange
	 */
    @Test
    public void testRangeTwoIsNullForMethodCombine() {
    	Range rangeOne = new Range(-1, 1);
    	Range rangeTwo = null;
    	assertSame("The expected range should be {-1,1}", rangeOne, Range.combine(rangeOne, rangeTwo));
    }
    
    /**
	 * This test covers an expansion for both boundaries for the expand() method using the exampleRange
	 */
    @Test
    public void testFullExpansionForMethodExpand() {
    	Range expectedRange = new Range(-3, 3);
    	assertEquals("The expected range should be {-3,3}", expectedRange, Range.expand(exampleRange, 1, 1));
    }
    
    /**
	 * This test covers an expansion for the upper boundary for the expand() method using the exampleRange
	 */
    @Test
    public void testUpperExpansionForMethodExpand() {
    	Range expectedRange = new Range(-1, 3);
    	assertEquals("The expected range should be {-1,3}", expectedRange, Range.expand(exampleRange, 0, 1));
    }
    
    /**
	 * This test covers a negative expansion for the upper boundary for the expand() method using the exampleRange
	 */
    @Test
    public void testNegativeUpperBoundaryExpansionForMethodExpand() {
    	Range expectedRange = new Range(-2, -2);
    	assertEquals("The expected range should be {-2,-2}", expectedRange, Range.expand(exampleRange, 0, -2));
    }
    
    /**
	 * This test covers a null input range for the expandToInclude() method
	 */
    @Test
    public void testNullRangeForMethodExpandToInclude() {
    	exampleRange = null;
    	Range expectedRange = new Range(25, 25);
    	assertEquals("The expected range should be {25,25}", expectedRange, Range.expandToInclude(null, 25));
    }
    
    /**
	 * This test covers a below lower boundary value for the expandToInclude() method using the exampleRange
	 */
    @Test
    public void testLowerExpansionForMethodExpandToInclude() {
    	Range expectedRange = new Range(-5, 1);
    	assertEquals("The expected range should be {-5,1}", expectedRange, Range.expandToInclude(exampleRange, -5));
    }
    
    /**
	 * This test covers an above upper boundary value for the expandToInclude() method using the exampleRange
	 */
    @Test
    public void testUpperExpansionForMethodExpandToInclude() {
    	Range expectedRange = new Range(-1, 5);
    	assertEquals("The expected range should be {-1,5}", expectedRange, Range.expandToInclude(exampleRange, 5));
    }
    
    /**
	 * This test covers a scaling of the same size for the scale() method using the exampleRange
	 */
    @Test
    public void testSameScaleForMethodScale() {
    	Range expectedRange = new Range(-1, 1);
    	assertEquals("The expected range should be {-1,1}", expectedRange, exampleRange.scale(exampleRange, 1));
    }
    
    /**
	 * This test covers a negative scaling value for the scale() method using the exampleRange
	 */
    @Test
    public void testNegativeScaleForMethodScale() {
    	try {
            Range.scale(exampleRange, -1);
            fail("Expected IllegalArgumentException was not thrown");
        } catch (IllegalArgumentException e) {
            String expectedMessage = "Negative 'factor' argument.";
            assertEquals(expectedMessage, e.getMessage());
        }
    }
    
    /**
	 * This test covers two valid ranges for the combineIgnoringNaN() method
	 */
    @Test
    public void testValidRangesForMethodCombineIgnoringNaN() {
    	Range rangeOne = new Range(-1, 1);
    	Range rangeTwo = new Range(-2, 2);
    	Range expectedRange = new Range(-2, 2);
    	assertEquals("The expected range should be {-1,2}", expectedRange, Range.combineIgnoringNaN(rangeOne, rangeTwo));
    }
    
    /**
	 * This test covers a null first range and valid second range for the combineIgnoringNaN() method
	 */
    @Test
    public void testNullRangeOneValidRangeTwoForMethodCombineIgnoringNAN() {
    	Range rangeOne = null;
    	Range rangeTwo = new Range(-2, 2);
    	Range expectedRange = rangeTwo;
    	assertEquals("The expected range should be {-1,2}", expectedRange, Range.combineIgnoringNaN(rangeOne, rangeTwo));
    }
    
    /**
	 * This test covers a valid first range and NaN second range for the combineIgnoringNaN() method
	 */
    @Test
    public void testValidRangeOneNaNRangeTwoForMethodCombineIgnoringNAN() {
    	Range rangeOne = new Range(-1, 1);
    	Range rangeTwo = new Range(Double.NaN, Double.NaN);
    	Range expectedRange = rangeOne;
    	assertEquals("The expected value should be null", expectedRange, Range.combineIgnoringNaN(rangeOne, rangeTwo));
    }
    
    /**
	 * This test covers a valid first range and null second range for the combineIgnoringNaN() method
	 */
    @Test
    public void testValidRangeOneNullRangeTwoForMethodCombineIgnoringNAN() {
    	Range rangeOne = new Range(-1, 1);
    	Range rangeTwo = null;
    	Range expectedRange = rangeOne;
    	assertEquals("The expected range should be {-1,1}", expectedRange, Range.combineIgnoringNaN(rangeOne, rangeTwo));
    }
    
    /**
	 * This test covers a null first range and valid NaN range for the combineIgnoringNaN() method
	 */
    @Test
    public void testNullRangeOneNaNRangeTwoForMethodCombineIgnoringNAN() {
    	Range rangeOne = null;
    	Range rangeTwo = new Range(Double.NaN, Double.NaN);
    	assertNull("The expected value should be null", Range.combineIgnoringNaN(rangeOne, rangeTwo));
    }
    
    /**
	 * This test covers a NaN first range and null second range for the combineIgnoringNaN() method
	 */
    @Test
    public void testNaNRangeOneNullRangeTwoForMethodCombineIgnoringNAN() {
    	Range rangeOne = new Range(Double.NaN, Double.NaN);
    	Range rangeTwo = null;
    	assertNull("The expected value should be null", Range.combineIgnoringNaN(rangeOne, rangeTwo));
    }
    
    /**
	 * This test covers a NaN first range and NaN second range for the combineIgnoringNaN() method
	 */
    @Test
    public void testNaNBothRangesForMethodCombineIgnoringNAN() {
    	Range rangeOne = new Range(Double.NaN, Double.NaN);
    	Range rangeTwo = new Range(Double.NaN, Double.NaN);
    	assertNull("The expected value should be null", Range.combineIgnoringNaN(rangeOne, rangeTwo));
    }
    
    /**
	 * This test covers invalid lower and upper boundaries for the constructor Range()
	 */
    @Test
    public void testInvalidBoundariesForRange() {
    	try {
            Range invalidRange = new Range(1, -1);
            fail("Expected IllegalArgumentException was not thrown");
        } catch (IllegalArgumentException e) {
            String expectedMessage = "Range(double, double): require lower (" + 1.0
                    + ") <= upper (" + -1.0 + ").";
            assertEquals(expectedMessage, e.getMessage());
        }
    }
    

    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
    
}