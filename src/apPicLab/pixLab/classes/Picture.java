    package apPicLab.pixLab.classes;

    import java.awt.*;
    import java.awt.font.*;
    import java.awt.geom.*;
    import java.awt.image.BufferedImage;
    import java.text.*;
    import java.util.*;
    import java.util.List; // resolves problem with java.awt.List and java.util.List

    /**
    * A class that represents a picture.  This class inherits from
    * SimplePicture and allows the student to add functionality to
    * the Picture class.
    *
    * @author Barbara Ericson ericson@cc.gatech.edu
    */
    public class Picture extends SimplePicture
    {
    ///////////////////// constructors //////////////////////////////////

    /**
    * Constructor that takes no arguments
    */
    public Picture ()
    {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor
     */
    super();
    }

    /**
    * Constructor that takes a file name and creates the picture
    * @param fileName the name of the file to create the picture from
    */
    public Picture(String fileName)
    {
    // let the parent class handle this fileName
    super(fileName);
    }

    /**
    * Constructor that takes the width and height
    * @param height the height of the desired picture
    * @param width the width of the desired picture
    */
    public Picture(int height, int width)
    {
    // let the parent class handle this width and height
    super(width,height);
    }

    /**
    * Constructor that takes a picture and creates a
    * copy of that picture
    * @param copyPicture the picture to copy
    */
    public Picture(Picture copyPicture)
    {
    // let the parent class do the copy
    super(copyPicture);
    }

    /**
    * Constructor that takes a buffered image
    * @param image the buffered image to use
    */
    public Picture(BufferedImage image)
    {
    super(image);
    }

    ////////////////////// methods ///////////////////////////////////////

    /**
    * Method to return a string with information about this picture.
    * @return a string with information about the picture such as fileName,
    * height and width.
    */
    public String toString()
    {
    String output = "Picture, filename " + getFileName() +
      " height " + getHeight()
      + " width " + getWidth();
    return output;

    }

    /** Method to set the blue to 0 */
    public void zeroBlue()
    {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue(0);
      }
    }
    }

    /** Method to set everything except blue to 0 */
    public void keepOnlyBlue() {
      Pixel[][] pixels = this.getPixels2D();
      for (Pixel[] rowArray : pixels)
      {
          for (Pixel pixelObj : rowArray)
          {
              pixelObj.setRed(0);
              pixelObj.setGreen(0);
          }
      }
    }

    /** Method that negates all pixels */
    public void negate() {
      Pixel[][] pixels = this.getPixels2D();
      for (Pixel[] rowArray : pixels)
      {
          for (Pixel pixelObj : rowArray)
          {
              pixelObj.setRed(255 - pixelObj.getRed());
              pixelObj.setGreen(255 - pixelObj.getGreen());
              pixelObj.setBlue(255 - pixelObj.getBlue());
          }
      }
    }

    /** Method that grayscales all pixels */
    public void grayscale() {
      Pixel[][] pixels = this.getPixels2D();
      for (Pixel[] rowArray : pixels)
      {
          for (Pixel pixelObj : rowArray)
          {
              int i = pixelObj.getRed() + pixelObj.getGreen() + pixelObj.getBlue();
              pixelObj.setRed(i / 3);
              pixelObj.setGreen(i / 3);
              pixelObj.setBlue(i / 3);
          }
      }
    }

    /** Method that shows the fishies */
    public void fixUnderwater() {
      Pixel[][] pixels = this.getPixels2D();
      for (Pixel[] rowArray : pixels)
      {
          for (Pixel pixelObj : rowArray)
          {
              pixelObj.setRed(pixelObj.getRed() * 4);
          }
      }
    }
    /** Method that mirrors the picture around a
    * vertical mirror in the center of the picture
    * from left to right */
    public void mirrorVertical()
    {
        Pixel[][] pixels = this.getPixels2D();
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int width = pixels[0].length;
        for (int row = 0; row < pixels.length; row++)
        {
          for (int col = 0; col < width / 2; col++)
          {
            leftPixel = pixels[row][col];
            rightPixel = pixels[row][width - 1 - col];
            rightPixel.setColor(leftPixel.getColor());
          }
        }
    }
    public void mirrorVerticalRightToLeft()
    {
        Pixel[][] pixels = this.getPixels2D();
        int width = pixels[0].length;
        for (int row = 0; row < pixels.length; row++)
        {
            for (int col = 0; col < width / 2; col++)
            {
                pixels[row][col].setColor(pixels[row][width - 1 - col].getColor());
            }
        }
    }

    public void mirrorHorizontal()
    {
        Pixel[][] pixels = this.getPixels2D();
        for (int row = 0; row < pixels.length / 2; row++)
        {
            for (int col = 0; col < pixels[0].length; col++)
            {
                pixels[pixels.length - 1 - row][col].setColor(pixels[row][col].getColor());
            }
        }
    }
    public void mirrorHorizontalBotToTop()
    {
        Pixel[][] pixels = this.getPixels2D();
        for (int row = 0; row < pixels.length / 2; row++)
        {
            for (int col = 0; col < pixels[0].length; col++)
            {
                pixels[row][col].setColor(pixels[pixels.length - 1 - row][col].getColor());
            }
        }
    }
    public void mirrorDiagonal()
    {
        Pixel[][] pixels = this.getPixels2D();
        int minSide = Math.min(pixels.length, pixels[0].length);
        for (int i = 0; i < minSide; i++) {
            for (int j = 0; j <= i; j++) {
                pixels[j][i].setColor(pixels[i][j].getColor());
            }
        }
    }

    /** Mirror just part of a picture of a temple */
    public void mirrorTemple()
    {
        int mirrorPoint = 276;
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int count = 0;
        Pixel[][] pixels = this.getPixels2D();

        // loop through the rows
        for (int row = 27; row < 97; row++)
        {
          // loop from 13 to just before the mirror point
          for (int col = 13; col < mirrorPoint; col++)
          {

            leftPixel = pixels[row][col];
            rightPixel = pixels[row]
                             [mirrorPoint - col + mirrorPoint];
            rightPixel.setColor(leftPixel.getColor());
            count++;
          }
        }
        System.out.println(count);
    }

    /** Mirror arms of snowman */
    public void mirrorArms() {
        Pixel[][] pixels = this.getPixels2D();
        for (int row = 158; row < 200; row++) {
            for (int col = 97; col < 180; col++) {
                if (!(pixels[row][col].getGreen() > 100 && pixels[row][col].getBlue() > 100)) {
                    pixels[row + 50][pixels[0].length - 1 - col].setColor(pixels[row][col].getColor());
                }
            }
        }
        for (int row = 162; row < 200; row++) {
            for (int col = 232; col < 300; col++) {
                if (!(pixels[row][col].getGreen() > 100 && pixels[row][col].getBlue() > 100)) {
                    pixels[row + 50][pixels[0].length - 1 - col + 20].setColor(pixels[row][col].getColor());
                }
            }
        }
    }

    public void mirrorGull() {
        Pixel[][] pixels = this.getPixels2D();
        for (int row = 226; row < 332; row++) {
            for (int col = 226; col < 350; col++) {
                //pixels[row][col].setRed(pixels[row][col].getRed() * 2);
                if (pixels[row][col].getRed() * 2 > 250 || pixels[row][col].getRed() * 2 < 200) {
                    pixels[row - 10][col - 120].setColor(pixels[row][col].getColor());
                }
            }
        }
    }

    /** copy from the passed fromPic to the
    * specified startRow and startCol in the
    * current picture
    * @param fromPic the picture to copy from
    * @param startRow the start row to copy to
    * @param startCol the start col to copy to
    */
    public void copy(Picture fromPic,
                 int startRow, int startCol)
    {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow;
         fromRow < fromPixels.length &&
         toRow < toPixels.length;
         fromRow++, toRow++)
    {
      for (int fromCol = 0, toCol = startCol;
           fromCol < fromPixels[0].length &&
           toCol < toPixels[0].length;
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }
    }
        public void copy(Picture fromPic,
                         int pasteStartRow, int pasteStartCol,
                         int startRow, int endRow,
                         int startCol, int endCol)
        {
            Pixel fromPixel = null;
            Pixel toPixel = null;
            Pixel[][] toPixels = this.getPixels2D();
            Pixel[][] fromPixels = fromPic.getPixels2D();
            for (int fromRow = startRow, toRow = pasteStartRow;
                 fromRow < endRow &&
                         toRow < toPixels.length;
                 fromRow++, toRow++)
            {
                for (int fromCol = startCol, toCol = pasteStartCol;
                     fromCol < endCol &&
                             toCol < toPixels[0].length;
                     fromCol++, toCol++)
                {
                    fromPixel = fromPixels[fromRow][fromCol];
                    toPixel = toPixels[toRow][toCol];
                    toPixel.setColor(fromPixel.getColor());
                }
            }
        }

    /** Method to create a collage of several pictures */
    public void createCollage()
    {
    Picture a = new Picture("C:\\Users\\WillJ\\Dropbox\\CS\\AP Computer Science\\src\\apPicLab\\pixLab\\images\\arch.jpg");
    Picture b = new Picture("C:\\Users\\WillJ\\Dropbox\\CS\\AP Computer Science\\src\\apPicLab\\pixLab\\images\\flower1.jpg");
    Picture d = new Picture("C:\\Users\\WillJ\\Dropbox\\CS\\AP Computer Science\\src\\apPicLab\\pixLab\\images\\butterfly1.jpg");
    this.copy(a,0,480);
    this.copy(b,100,0);
    this.copy(a,200,0);
    this.copy(d, 300, 0);
    Picture c = new Picture(b);
    c.grayscale();
    d.keepOnlyBlue();
    this.copy(c,100,0);
    this.copy(a,600,0);
    this.copy(b,500,0);
    this.mirrorDiagonal();
    this.write("C:\\Users\\WillJ\\Dropbox\\CS\\AP Computer Science\\src\\apPicLab\\pixLab\\images\\collage.jpg");
    }



    /** Method to show large changes in color
    * @param edgeDist the distance for finding edges
    */
    public void edgeDetection(int edgeDist)
    {
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        Pixel[][] pixels = this.getPixels2D();
        Color rightColor = null;
        for (int row = 0; row < pixels.length; row++)
        {
          for (int col = 0;
               col < pixels[0].length-1; col++)
          {
            leftPixel = pixels[row][col];
            rightPixel = pixels[row][col+1];
            rightColor = rightPixel.getColor();
            if (leftPixel.colorDistance(rightColor) >
                edgeDist)
              leftPixel.setColor(Color.BLACK);
            else
              leftPixel.setColor(Color.WHITE);
          }
        }
        for (int row = 0; row < pixels.length - 1; row++)
        {
            for (int col = 0;
                 col < pixels[0].length; col++)
            {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row + 1][col];
                rightColor = rightPixel.getColor();
                if (leftPixel.colorDistance(rightColor) >
                        edgeDist)
                    leftPixel.setColor(Color.BLACK);
//                else
//                    leftPixel.setColor(Color.WHITE);
            }
        }
    }


    /* Main method for testing - each class in Java can have a main
    * method
    */
    public static void main(String[] args)
    {
    Picture water = new Picture("C:\\Users\\WillJ\\Dropbox\\CS\\AP Computer Science\\src\\apPicLab\\pixLab\\images\\water.jpg");
    water.explore();
    }

    } // this } is the end of class Picture, put all new methods before this
