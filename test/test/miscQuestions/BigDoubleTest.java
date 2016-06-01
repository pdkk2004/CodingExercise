package test.miscQuestions;

import org.junit.Assert;
import org.junit.Test;

import MiscQuestions.BigDouble;

public class BigDoubleTest {

	@Test
	public void testSubstract() {
		
		BigDouble bd = new BigDouble();
		
		double eps = 0.00000001;
		String d1 = "1234.56";
		String d2 = "4392.789";
		System.out.println(d1 + ", " + d2);
		String sum = bd.strSubstract(d1, d2);
		System.out.println(sum);
		System.out.println();
		Assert.assertTrue(Double.valueOf(d1) - Double.valueOf(d2) - Double.valueOf(sum) <= eps);
		
		d1 = "1234";
		d2 = "4392.789";
		sum = bd.strSubstract(d1, d2);
		System.out.println(d1 + ", " + d2);
		System.out.println(sum);
		System.out.println();
		Assert.assertTrue(Double.valueOf(d1) - Double.valueOf(d2) - Double.valueOf(sum) <= eps);
		
		d2 = "1234";
		d1 = "4392.789";
		sum = bd.strSubstract(d1, d2);
		System.out.println(d1 + ", " + d2);
		System.out.println(sum);
		System.out.println();
		Assert.assertTrue(Double.valueOf(d1) - Double.valueOf(d2) - Double.valueOf(sum) <= eps);
		
		d1 = "1234.0";
		d2 = "4392.789";
		sum = bd.strSubstract(d1, d2);
		System.out.println(d1 + ", " + d2);
		System.out.println(sum);
		System.out.println();
		Assert.assertTrue(Double.valueOf(d1) - Double.valueOf(d2) - Double.valueOf(sum) <= eps);
		
		d2 = "1234.0";
		d1 = "4392.789";
		sum = bd.strSubstract(d1, d2);
		System.out.println(d1 + ", " + d2);
		System.out.println(sum);
		System.out.println();
		Assert.assertTrue(Double.valueOf(d1) - Double.valueOf(d2) - Double.valueOf(sum) <= eps);
		
		d1 = "1234.0456";
		d2 = "4392.789";
		sum = bd.strSubstract(d1, d2);
		System.out.println(d1 + ", " + d2);
		System.out.println(sum);
		System.out.println();
		Assert.assertTrue(Double.valueOf(d1) - Double.valueOf(d2) - Double.valueOf(sum) <= eps);
		
		d2 = "1234.0456";
		d1 = "4392.789";
		sum = bd.strSubstract(d1, d2);
		System.out.println(d1 + ", " + d2);
		System.out.println(sum);
		System.out.println();
		Assert.assertTrue(Double.valueOf(d1) - Double.valueOf(d2) - Double.valueOf(sum) <= eps);
		
		d1 = "1234.00";
		d2 = "4392.789";
		sum = bd.strSubstract(d1, d2);
		System.out.println(d1 + ", " + d2);
		System.out.println(sum);
		System.out.println();
		Assert.assertTrue(Double.valueOf(d1) - Double.valueOf(d2) - Double.valueOf(sum) <= eps);
		
		d2 = "1234.00";
		d1 = "4392.789";
		sum = bd.strSubstract(d1, d2);
		System.out.println(d1 + ", " + d2);
		System.out.println(sum);
		System.out.println();
		Assert.assertTrue(Double.valueOf(d1) - Double.valueOf(d2) - Double.valueOf(sum) <= eps);
		
		d1 = "1234.00000";
		d2 = "4392.789";
		sum = bd.strSubstract(d1, d2);
		System.out.println(d1 + ", " + d2);
		System.out.println(sum);
		System.out.println();
		Assert.assertTrue(Double.valueOf(d1) - Double.valueOf(d2) - Double.valueOf(sum) <= eps);
		
		d2 = "1234.00000";
		d1 = "4392.789";
		sum = bd.strSubstract(d1, d2);
		System.out.println(d1 + ", " + d2);
		System.out.println(sum);
		System.out.println();
		Assert.assertTrue(Double.valueOf(d1) - Double.valueOf(d2) - Double.valueOf(sum) <= eps);
		
		d1 = "1234.211";
		d2 = "4392.789";
		sum = bd.strSubstract(d1, d2);
		System.out.println(d1 + ", " + d2);
		System.out.println(sum);
		System.out.println();
		Assert.assertTrue(Double.valueOf(d1) - Double.valueOf(d2) - Double.valueOf(sum) <= eps);
		
		d2 = "1234.211";
		d1 = "4392.789";
		sum = bd.strSubstract(d1, d2);
		System.out.println(d1 + ", " + d2);
		System.out.println(sum);
		System.out.println();
		Assert.assertTrue(Double.valueOf(d1) - Double.valueOf(d2) - Double.valueOf(sum) <= eps);
		
		d1 = "1234.011";
		d2 = "4392.789";
		sum = bd.strSubstract(d1, d2);
		System.out.println(d1 + ", " + d2);
		System.out.println(sum);
		System.out.println();
		Assert.assertTrue(Double.valueOf(d1) - Double.valueOf(d2) - Double.valueOf(sum) <= eps);
		
		d2 = "1234.011";
		d1 = "4392.789";
		sum = bd.strSubstract(d1, d2);
		System.out.println(d1 + ", " + d2);
		System.out.println(sum);
		System.out.println();
		Assert.assertTrue(Double.valueOf(d1) - Double.valueOf(d2) - Double.valueOf(sum) <= eps);
		
		d1 = "1234";
		d2 = "4392.789";
		sum = bd.strSubstract(d1, d2);
		System.out.println(d1 + ", " + d2);
		System.out.println(sum);
		System.out.println();
		Assert.assertTrue(Double.valueOf(d1) - Double.valueOf(d2) - Double.valueOf(sum) <= eps);
		
		d2 = "1234";
		d1 = "4392.789";
		sum = bd.strSubstract(d1, d2);
		System.out.println(d1 + ", " + d2);
		System.out.println(sum);
		System.out.println();
		Assert.assertTrue(Double.valueOf(d1) - Double.valueOf(d2) - Double.valueOf(sum) <= eps);
		
		d1 = "11234";
		d2 = "4392.789";
		sum = bd.strSubstract(d1, d2);
		System.out.println(d1 + ", " + d2);
		System.out.println(sum);
		System.out.println();
		Assert.assertTrue(Double.valueOf(d1) - Double.valueOf(d2) - Double.valueOf(sum) <= eps);
		
		d1 = "11234.00";
		d2 = "4392.789";
		sum = bd.strSubstract(d1, d2);
		System.out.println(d1 + ", " + d2);
		System.out.println(sum);
		System.out.println();
		Assert.assertTrue(Double.valueOf(d1) - Double.valueOf(d2) - Double.valueOf(sum) <= eps);
	}

	@Test
	public void testAdd() {
		
		BigDouble bd = new BigDouble();
		
		double eps = 0.000001;
		String d1 = "1234.56";
		String d2 = "4392.789";
		String sum = bd.strAdd(d1, d2);
		Assert.assertEquals(String.valueOf(Float.valueOf(d1) + Float.valueOf(d2)), sum);
		
		d1 = "1234";
		d2 = "4392.789";
		sum = bd.strAdd(d1, d2);
		Assert.assertEquals(String.valueOf(Float.valueOf(d1) + Float.valueOf(d2)), sum);
		
		d1 = "1234.0";
		d2 = "4392.789";
		sum = bd.strAdd(d1, d2);
		Assert.assertEquals(String.valueOf(Float.valueOf(d1) + Float.valueOf(d2)), sum);
		
		d1 = "1234.0456";
		d2 = "4392.789";
		sum = bd.strAdd(d1, d2);
		Assert.assertEquals(String.valueOf(Double.valueOf(d1) + Double.valueOf(d2)), sum);
		
		d1 = "1234.00";
		d2 = "4392.789";
		sum = bd.strAdd(d1, d2);
		Assert.assertEquals(String.valueOf(Double.valueOf(d1) + Double.valueOf(d2)), sum);
		
		d1 = "1234.00000";
		d2 = "4392.789";
		sum = bd.strAdd(d1, d2);
		Assert.assertEquals(String.valueOf(Double.valueOf(d1) + Double.valueOf(d2)), sum);
		
		d1 = "1234.211";
		d2 = "4392.789";
		sum = bd.strAdd(d1, d2);
		Assert.assertEquals(String.valueOf(Double.valueOf(d1) + Double.valueOf(d2)), sum);
		
		d1 = "1234.011";
		d2 = "4392.789";
		sum = bd.strAdd(d1, d2);
		Assert.assertTrue(Double.valueOf(d1) + Double.valueOf(d2) - Double.valueOf(sum) <= eps);
	}
}
