/**
 * This class contains class (static) methods
 * that will help you test the Picture class 
 * methods.  Uncomment the methods and the code
 * in the main to test.
 * 
 * @author Barbara Ericson 
 */
public class PictureTester
{
  /** Method to test zeroBlue */
  public static void testZeroBlue()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
  /** Method to test mirrorVertical */
  public static void testMirrorVertical()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVertical();
    caterpillar.explore();
  }
  
  /** Method to test mirrorTemple */
  public static void testMirrorTemple()
  {
    Picture temple = new Picture("temple.jpg");
    temple.explore();
    temple.mirrorTemple();
    temple.explore();
  }
  
  /** Method to test the collage method */
  public static void testCollage()
  {
    Picture canvas = new Picture("640x480.jpg");
    canvas.createCollage();
    canvas.explore();
  }
  
  /** Method to test edgeDetection */
  public static void testEdgeDetection()
  {
    Picture swan = new Picture("swan.jpg");
    swan.edgeDetection(10);
    swan.explore();
  }
  
  public static void testKeepOnlyBlue(){
    Picture swan = new Picture("swan.jpg");
    swan.keepOnlyBlue();
    swan.explore();
  }

  public static void testNegate(){
    Picture swan = new Picture("swan.jpg");
    swan.negate();
    swan.explore();
  }

  public static void testGrayscale(){
    Picture swan = new Picture("snowman.jpg");
    swan.greyscale();;
    swan.explore();
  }

  public static void testFixUnderwater(){
    Picture fish = new Picture("water.jpg");
    fish.fixUnderwater();
    fish.explore();
  }

  public static void testMirrorVerticalRightToLeft(){
    Picture fish = new Picture("kitten2.jpg");
    fish.mirrorVerticalRightToLeft();
    fish.explore();
  }

  public static void testMirrorHorizontal(){
    Picture fish = new Picture("barbaraS.jpg");
    fish.mirrorHorizontal();
    fish.explore();
  }

  public static void testMirrorHorizontalBotTop(){
    Picture fish = new Picture("barbaraS.jpg");
    fish.mirrorHorizontalBotTop();
    fish.explore();
  }

  public static void testMirrorDiagonal(){
    Picture fish = new Picture("barbaraS.jpg");
    fish.mirrorDiagonal();
    fish.explore();
  }

  public static void testMirrorArms(){
    Picture fish = new Picture("snowman.jpg");
    fish.mirrorArms();
    fish.explore();
  }

  public static void testMirrorGull(){
    Picture fish = new Picture("seagull.jpg");
    fish.mirrorGull();
    fish.explore();
  }

  public static void testCopy(){
    Picture pic1 = new Picture("blue-mark.jpg");
    Picture pic2 = new Picture("beach.jpg");
    pic2.copy(pic1,0,0, 100, 100, 200, 200);
    pic2.explore();
    //pic2.write("testPic.jpg");
  }

  public static void testCreateMyCollage(){
    Picture pic = new Picture("whiteFlower.jpg");
    pic.createMyCollage();
    pic.explore();
  }

  public static void testEdge(){
    Picture pic = new Picture("swan.jpg");
    pic.edgeDetectionNew(10);
    pic.explore();
  }

  /** Main method for testing.  Every class can have a main
    * method in Java */
  public static void main(String[] args)
  {
    // uncomment a call here to run a test
    // and comment out the ones you don't want
    // to run
    //testZeroBlue();
    //testKeepOnlyBlue();
    //testKeepOnlyRed();
    //testKeepOnlyGreen();
    //testNegate();
    //testGrayscale();
    //testFixUnderwater();
    //testMirrorVerticalRightToLeft();
    //testMirrorHorizontalBotTop();
    //testMirrorHorizontal();
    //testMirrorDiagonal();
    //testMirrorTemple();
    //testMirrorArms();
    //testMirrorGull();
    //testMirrorDiagonal();
    //testCreateMyCollage();
    //testCopy();
    testEdge();
    //testEdgeDetection();
    //testEdgeDetection2();
    //testChromakey();
    //testEncodeAndDecode();
    //testGetCountRedOverValue(250);
    //testSetRedToHalfValueInTopHalf();
    //testClearBlueOverValue(200);
    //testGetAverageForColumn(0);
  }
}