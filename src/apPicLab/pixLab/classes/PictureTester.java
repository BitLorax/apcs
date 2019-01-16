    package apPicLab.pixLab.classes;

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
    Picture beach = new Picture("C:\\Users\\WillJ\\Dropbox\\CS\\AP Computer Science\\src\\apPicLab\\pixLab\\images\\beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
    }

    /** Method to test zeroBlue */
    public static void testKeepOnlyBlue()
    {
    Picture beach = new Picture("C:\\Users\\WillJ\\Dropbox\\CS\\AP Computer Science\\src\\apPicLab\\pixLab\\images\\beach.jpg");
    beach.explore();
    beach.keepOnlyBlue();
    beach.explore();
    }

    /** Method to test negate */
    public static void testNegate()
    {
      Picture beach = new Picture("C:\\Users\\WillJ\\Dropbox\\CS\\AP Computer Science\\src\\apPicLab\\pixLab\\images\\beach.jpg");
      beach.explore();
      beach.negate();
      beach.explore();
    }

    /** Method to test grayscale */
    public static void testGrayscale()
    {
      Picture wall = new Picture("C:\\Users\\WillJ\\Dropbox\\CS\\AP Computer Science\\src\\apPicLab\\pixLab\\images\\wall.jpg");
      wall.explore();
      wall.grayscale();
      wall.explore();
    }

    /** Method to test fixUnderwater */
    public static void testFixUnderwater()
    {
    Picture water = new Picture("C:\\Users\\WillJ\\Dropbox\\CS\\AP Computer Science\\src\\apPicLab\\pixLab\\images\\water.jpg");
    water.explore();
    water.fixUnderwater();
    water.explore();
    }

    /** Method to test mirrorVertical */
    public static void testMirrorVertical()
    {
    Picture caterpillar = new Picture("C:\\Users\\WillJ\\Dropbox\\CS\\AP Computer Science\\src\\apPicLab\\pixLab\\images\\holiday.jpg");
    caterpillar.explore();
    caterpillar.mirrorVertical();
    caterpillar.explore();
    }

    public static void testMirrorVerticalRightToLeft()
    {
        Picture caterpillar = new Picture("C:\\Users\\WillJ\\Dropbox\\CS\\AP Computer Science\\src\\apPicLab\\pixLab\\images\\holiday.jpg");
        caterpillar.explore();
        caterpillar.mirrorVerticalRightToLeft();
        caterpillar.explore();
    }

    public static void testMirrorHorizontal()
    {
        Picture motorcycle = new Picture("C:\\Users\\WillJ\\Dropbox\\CS\\AP Computer Science\\src\\apPicLab\\pixLab\\images\\holiday.jpg");
        motorcycle.explore();
        motorcycle.mirrorHorizontal();
        motorcycle.explore();
    }

    public static void testMirrorHorizontalBotToTop()
    {
        Picture motorcycle = new Picture("C:\\Users\\WillJ\\Dropbox\\CS\\AP Computer Science\\src\\apPicLab\\pixLab\\images\\holiday.jpg");
        motorcycle.explore();
        motorcycle.mirrorHorizontalBotToTop();
        motorcycle.explore();
    }

    public static void testMirrorDiagonal()
    {
        Picture beach = new Picture("C:\\Users\\WillJ\\Dropbox\\CS\\AP Computer Science\\src\\apPicLab\\pixLab\\images\\holiday.jpg");
        beach.explore();
        beach.mirrorDiagonal();
        beach.explore();
    }


        /** Method to test mirrorTemple */
    public static void testMirrorTemple()
    {
    Picture temple = new Picture("C:\\Users\\WillJ\\Dropbox\\CS\\AP Computer Science\\src\\apPicLab\\pixLab\\images\\temple.jpg");
    temple.explore();
    temple.mirrorTemple();
    temple.explore();
    }

    /** Method to test the collage method */
    public static void testCollage()
    {
    Picture canvas = new Picture("C:\\Users\\WillJ\\Dropbox\\CS\\AP Computer Science\\src\\apPicLab\\pixLab\\images\\640x480.jpg");
    canvas.createCollage();
    canvas.explore();
    }

    /** Method to test edgeDetection */
    public static void testEdgeDetection()
    {
    Picture swan = new Picture("C:\\Users\\WillJ\\Dropbox\\CS\\AP Computer Science\\src\\apPicLab\\pixLab\\images\\swan.jpg");
    swan.edgeDetection(20);
    swan.explore();
    }

    public static void testMirrorArms()
    {
        Picture snowman = new Picture("C:\\Users\\WillJ\\Dropbox\\CS\\AP Computer Science\\src\\apPicLab\\pixLab\\images\\snowman.jpg");
        snowman.mirrorArms();
        snowman.explore();
    }

    public static void testMirrorGull() {
        Picture seagull = new Picture("C:\\Users\\WillJ\\Dropbox\\CS\\AP Computer Science\\src\\apPicLab\\pixLab\\images\\seagull.jpg");
        seagull.mirrorGull();
        seagull.explore();
    }

    /** Main method for testing.  Every class can have a main
    * method in Java */
    public static void main(String[] args)
    {
//        Picture pic = new Picture("C:\\Users\\WillJ\\Dropbox\\CS\\AP Computer Science\\src\\apPicLab\\pixLab\\images\\seagull.jpg");
//        pic.explore();
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
    //testMirrorVertical();
    //testMirrorTemple();
    //testMirrorArms();
    //testMirrorGull();
//    testMirrorDiagonal();
//    testMirrorHorizontal();
//    testMirrorHorizontalBotToTop();
//    testMirrorVerticalRightToLeft();
    //testCollage();
    //testCopy();
    testEdgeDetection();
    //testEdgeDetection2();
    //testChromakey();
    //testEncodeAndDecode();
    //testGetCountRedOverValue(250);
    //testSetRedToHalfValueInTopHalf();
    //testClearBlueOverValue(200);
    //testGetAverageForColumn(0);
    }
    }