import static org.junit.Assert.*;

import org.junit.Test;

/**
 * This Junit test is testing getBMI method. It will show a correct Junit test result.
 * @author Chang Liu
 *
 */
public class MyHealthDataTest2 {

	@Test
	public void testGetBMI() {

          final double EPSILON = 1E-12;
		
		  MyHealthData mhd = new MyHealthData();
		  final double HEIGHT = 10;
		  final double WEIGHT = 20;
		  final double EXPECTED_BMI = 140.6;
		  mhd.setHeight(HEIGHT);
		  mhd.setWeight(WEIGHT);
		  double actualBMI = mhd.getBMI();
		  assertEquals(EXPECTED_BMI, actualBMI, EPSILON);
		  mhd = null;
		 }


}
