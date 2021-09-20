package edu.brown.cs.student.main;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MathBotTest {

  @Test
  public void testAddition() {
    MathBot matherator9000 = new MathBot();
    double output = matherator9000.add(10.5, 3);
    assertEquals(13.5, output, 0.01);
  }

  @Test
  public void testLargerNumbers() {
    MathBot matherator9001 = new MathBot();
    double output = matherator9001.add(100000, 200303);
    assertEquals(300303, output, 0.01);
  }

  @Test
  public void testSubtraction() {
    MathBot matherator9002 = new MathBot();
    double output = matherator9002.subtract(18, 17);
    assertEquals(1, output, 0.01);
  }

  // TODO: add more unit tests of your own

  /**
   * Method tests to see how two negative numbers are handled for each
   * add and subtract function
   */
  @Test
  public void testNegativeNumbers() {
    MathBot matherator9003 = new MathBot();
    double output1 = matherator9003.add(-1,-1);
    double output2 = matherator9003.subtract(-1,-1);
    assertEquals(-2,output1,0.01);
    assertEquals(0,output2,0.01);
  }

  /**
   * Method tests to see how decimals less than one are handled when
   * added or subtracted from each other
   */
  @Test
  public void testDecimals() {
    MathBot matherator9004 = new MathBot();
    double output1 = matherator9004.add(0.1,0.1);
    double output2 = matherator9004.subtract(0.5,0.5);
    assertEquals(0.2,output1,0.01);
    assertEquals(0,output2,0.01);

  }
}
