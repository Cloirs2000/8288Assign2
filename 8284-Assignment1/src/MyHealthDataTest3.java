import static org.junit.Assert.*;

import org.junit.Test;


/**
 * This Junit test is testing getBMI01 method. This is a incorrect method that is used to show a failed Junit test result.
 * @author Chang Liu
 *
 */
public class MyHealthDataTest3 {

	@Test
	public void testGetBMI01() {

          final double EPSILON = 1E-12;
		
		  MyHealthData mhd = new MyHealthData();
		  final double HEIGHT = 10;
		  final double WEIGHT = 20;
		  final double EXPECTED_BMI = 140.6;
		  mhd.setHeight(HEIGHT);
		  mhd.setWeight(WEIGHT);
		  double actualBMI = mhd.getBMI01();
		  assertEquals(EXPECTED_BMI, actualBMI, EPSILON);
		  mhd = null;
			 
	}

}
