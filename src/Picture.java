import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture. This class inherits from SimplePicture and
 * allows the student to add functionality to the Picture class.
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture {
	///////////////////// constructors //////////////////////////////////

	/**
	 * Constructor that takes no arguments
	 */
	public Picture() {
		/*
		 * not needed but use it to show students the implicit call to super()
		 * child constructors always call a parent constructor
		 */
		super();
	}

	/**
	 * Constructor that takes a file name and creates the picture
	 * 
	 * @param fileName
	 *            the name of the file to create the picture from
	 */
	public Picture(String fileName) {
		// let the parent class handle this fileName
		super(fileName);
	}

	/**
	 * Constructor that takes the width and height
	 * 
	 * @param height
	 *            the height of the desired picture
	 * @param width
	 *            the width of the desired picture
	 */
	public Picture(int height, int width) {
		// let the parent class handle this width and height
		super(width, height);
	}

	/**
	 * Constructor that takes a picture and creates a copy of that picture
	 * 
	 * @param copyPicture
	 *            the picture to copy
	 */
	public Picture(Picture copyPicture) {
		// let the parent class do the copy
		super(copyPicture);
	}

	/**
	 * Constructor that takes a buffered image
	 * 
	 * @param image
	 *            the buffered image to use
	 */
	public Picture(BufferedImage image) {
		super(image);
	}

	////////////////////// methods ///////////////////////////////////////

	/**
	 * Method to return a string with information about this picture.
	 * 
	 * @return a string with information about the picture such as fileName,
	 *         height and width.
	 */
	public String toString() {
		String output = "Picture, filename " + getFileName() + " height " + getHeight() + " width " + getWidth();
		return output;

	}

	/** Method to set the blue to 0 */
	public void zeroBlue() {
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels) {
			for (Pixel pixelObj : rowArray) {
				pixelObj.setBlue(0);
			}
		}
	}

	/**
	 * Method that mirrors the picture around a vertical mirror in the center of
	 * the picture from left to right
	 */
	public void mirrorVertical() {
		Pixel[][] pixels = this.getPixels2D();
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		int width = pixels[0].length;
		for (int row = 0; row < pixels.length; row++) {
			for (int col = 0; col < width / 2; col++) {
				leftPixel = pixels[row][col];
				rightPixel = pixels[row][width - 1 - col];
				rightPixel.setColor(leftPixel.getColor());
			}
		}
	}

	/** Mirror just part of a picture of a temple */
	public void mirrorTemple() {
		int mirrorPoint = 276;
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		int count = 0;
		Pixel[][] pixels = this.getPixels2D();

		// loop through the rows
		for (int row = 27; row < 97; row++) {
			// loop from 13 to just before the mirror point
			for (int col = 13; col < mirrorPoint; col++) {
				count ++;
				leftPixel = pixels[row][col];
				rightPixel = pixels[row][mirrorPoint - col + mirrorPoint];
				rightPixel.setColor(leftPixel.getColor());
			}
			System.out.println(count);
		}
	}

	/**
	 * copy from the passed fromPic to the specified startRow and startCol in
	 * the current picture
	 * 
	 * @param fromPic
	 *            the picture to copy from
	 * @param startRow
	 *            the start row to copy to
	 * @param startCol
	 *            the start col to copy to
	 */
	public void copy(Picture fromPic, int startRow, int startCol) {
		Pixel fromPixel = null;
		Pixel toPixel = null;
		Pixel[][] toPixels = this.getPixels2D();
		Pixel[][] fromPixels = fromPic.getPixels2D();
		for (int fromRow = 0, toRow = startRow; fromRow < fromPixels.length
				&& toRow < toPixels.length; fromRow++, toRow++) {
			for (int fromCol = 0, toCol = startCol; fromCol < fromPixels[0].length
					&& toCol < toPixels[0].length; fromCol++, toCol++) {
				fromPixel = fromPixels[fromRow][fromCol];
				toPixel = toPixels[toRow][toCol];
				toPixel.setColor(fromPixel.getColor());
			}
		}
	}

	public void copy(Picture fromPic, int startRow, int startCol, int startRowCopy, int startColCopy, int endRowCopy, int endColCopy) {
		Pixel fromPixel = null;
		Pixel toPixel = null;
		Pixel[][] toPixels = this.getPixels2D();
		Pixel[][] fromPixels = fromPic.getPixels2D();
		for (int fromRow = startRowCopy, toRow = startRow; fromRow < endRowCopy
				&& toRow < toPixels.length; fromRow++, toRow++) {
			for (int fromCol = startColCopy, toCol = startCol; fromCol < endColCopy
					&& toCol < toPixels[0].length; fromCol++, toCol++) {
				fromPixel = fromPixels[fromRow][fromCol];
				toPixel = toPixels[toRow][toCol];
				toPixel.setColor(fromPixel.getColor());
			}
		}
	}
	/** Method to create a collage of several pictures */
	public void createCollage() {
		Picture flower1 = new Picture("flower1.jpg");
		Picture flower2 = new Picture("flower2.jpg");
		this.copy(flower1, 0, 0);
		this.copy(flower2, 100, 0);
		this.copy(flower1, 200, 0);
		Picture flowerNoBlue = new Picture(flower2);
		flowerNoBlue.zeroBlue();
		this.copy(flowerNoBlue, 300, 0);
		this.copy(flower1, 400, 0);
		this.copy(flower2, 500, 0);
		this.mirrorVertical();
		this.write("collage.jpg");
	}

	public void createMyCollage() {
		Picture flower1 = new Picture("blue-mark.jpg");
		Picture flower2 = new Picture("beach.jpg");
		Picture flower3 = new Picture("barbaraS.jpg");
		this.copy(flower1, 0, 0);
		this.copy(flower2, 100, 0);
		this.copy(flower3, 200, 50);
		this.copy(flower1, 200, 0);
		Picture flowerNoBlue = new Picture(flower2);
		flowerNoBlue.zeroBlue();
		this.copy(flowerNoBlue, 300, 0);
		this.copy(flower1, 400, 0);
		this.copy(flower2, 500, 0);
		this.mirrorVertical();
		this.write("collage.jpg");
	}

	/**
	 * Method to show large changes in color
	 * 
	 * @param edgeDist
	 *            the distance for finding edges
	 */
	public void edgeDetection(int edgeDist) {
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		Pixel bottomPixel = null;
		Pixel[][] pixels = this.getPixels2D();
		Color rightColor = null;
		Color bottomColor = null;
		for (int row = 0; row < pixels.length-1; row++) {
			for (int col = 0; col < pixels[0].length - 2; col++) {
				leftPixel = pixels[row][col];
				rightPixel = pixels[row][col + 1];
				bottomPixel = pixels[row+1][col];
				rightColor = rightPixel.getColor();
				bottomColor = bottomPixel.getColor();
				if (leftPixel.colorDistance(rightColor) > edgeDist)
					leftPixel.setColor(Color.BLACK);
				else if(leftPixel.colorDistance(bottomColor) > edgeDist)
					leftPixel.setColor(Color.BLACK);
				else
					leftPixel.setColor(Color.WHITE);
			}
		}
	}

	public void edgeDetectionNew(int edgeDist) {
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		Pixel bottomPixel = null;
		Pixel[][] pixels = this.getPixels2D();
		Color rightColor = null;
		Color bottomColor = null;
		double leftAvg = 0;
		double rightAvg = 0;
		double bottomAvg = 0;
		for (int row = 0; row < pixels.length-1; row++) {
			for (int col = 0; col < pixels[0].length - 2; col++) {
				leftPixel = pixels[row][col];
				rightPixel = pixels[row][col + 1];
				bottomPixel = pixels[row+1][col];
				rightColor = rightPixel.getColor();
				bottomColor = bottomPixel.getColor();
				leftAvg = leftPixel.getAverage();
				rightAvg = rightPixel.getAverage();
				bottomAvg = bottomPixel.getAverage();
				if (Math.abs(leftAvg - rightAvg) > edgeDist)
					leftPixel.setColor(Color.BLACK);
				else if(Math.abs(leftAvg - bottomAvg) > edgeDist)
					leftPixel.setColor(Color.BLACK);
				else
					leftPixel.setColor(Color.WHITE);
			}
		}
	}

	public void keepOnlyBlue(){
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels) {
			for (Pixel pixelObj : rowArray) {
				pixelObj.setRed(0);
				pixelObj.setGreen(0);
			}
		}
	}

	public void negate(){
		Pixel[][] pixels = this.getPixels2D();
		for(Pixel[] rowArray : pixels){
			for(Pixel pixelObj : rowArray){
				pixelObj.setBlue(255-pixelObj.getBlue());
				pixelObj.setRed(255-pixelObj.getRed());
				pixelObj.setGreen(255-pixelObj.getGreen());
			}
		}
	}

	public void greyscale(){
		Pixel[][] pixels = this.getPixels2D();
		for(Pixel[] rowArray : pixels){
			for(Pixel pixelObj : rowArray){
				int average = (pixelObj.getBlue() + pixelObj.getGreen() + pixelObj.getRed())/3;
				pixelObj.setBlue(average);
				pixelObj.setRed(average);
				pixelObj.setGreen(average);
			}
		}
	}

	public void fixUnderwater(){
		Pixel[][] pixels = this.getPixels2D();
		for(Pixel[] rowArray : pixels){
			for(Pixel pixelObj : rowArray){
				if(pixelObj.getBlue() > pixelObj.getGreen()){
					pixelObj.setBlue(0);
					pixelObj.setRed(255);
					pixelObj.setGreen(0);
				}
			}
		}
	}

	public void mirrorVerticalRightToLeft() {
		Pixel[][] pixels = this.getPixels2D();
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		int width = pixels[0].length;
		for (int row = 0; row < pixels.length; row++) {
			for (int col = 0; col < width/2; col++) {
				leftPixel = pixels[row][col];
				rightPixel = pixels[row][width - 1 - col];
				leftPixel.setColor(rightPixel.getColor());
			}
		}
	}

	public void mirrorHorizontal() {
		Pixel[][] pixels = this.getPixels2D();
		Pixel topPixel = null;
		Pixel botPixel = null;
		int width = pixels[0].length;
		for (int row = 0; row < pixels.length/2; row++) {
			for (int col = 0; col < width; col++) {
				topPixel = pixels[row][col];
				botPixel = pixels[pixels.length-1-row][col];
				botPixel.setColor(topPixel.getColor());
			}
		}
	}

	public void mirrorHorizontalBotTop() {
		Pixel[][] pixels = this.getPixels2D();
		Pixel topPixel = null;
		Pixel botPixel = null;
		int width = pixels[0].length;
		for (int row = 0; row < pixels.length/2; row++) {
			for (int col = 0; col < width; col++) {
				topPixel = pixels[row][col];
				botPixel = pixels[pixels.length-1-row][col];
				topPixel.setColor(botPixel.getColor());
			}
		}
	}

	public void mirrorDiagonal() {
		Pixel[][] pixels = this.getPixels2D();
		Pixel leftPixel = null;
		Pixel rightPixel = null;

		for (int row = 0; row < pixels.length; row++) {
			if(row < pixels[0].length){
				for (int col = 0; col <= row; col++) {
					leftPixel = pixels[row][col];
					rightPixel = pixels[col][row];
					leftPixel.setColor(rightPixel.getColor());
				}
			}
		}
	}


	//row 158 to 191
	//col 104 to 169
	//col 206 mirror pt
	public void mirrorArms(){
		Pixel[][] pixels = this.getPixels2D();
		Pixel firstPixel = null;
		Pixel copyPixel1 = null;
		Pixel copyPixel2 = null;
		int diff = 0;
		
		for (int row = 158; row <= 191; row++) {
			for (int col = 104; col <= 169; col++) {
				diff = 206 - col;
				firstPixel = pixels[row][col];
				copyPixel1 = pixels[row+80][206 + diff];
				copyPixel2 = pixels[row+80][col];
				copyPixel1.setColor(firstPixel.getColor());
				copyPixel2.setColor(firstPixel.getColor());
			}
		}
	}
	//row 233 to 315
	//col 237 to 345
	public void mirrorGull(){
		Pixel[][] pixels = this.getPixels2D();
		Pixel firstPixel = null;
		Pixel copyPixel1 = null;
		int diff = 0;
		
		for (int row = 233; row <= 315; row++) {
			for (int col = 237; col <= 345; col++) {
				diff = 206 - col;
				firstPixel = pixels[row][col];
				
				copyPixel1 = pixels[row+80][206 + diff];
				copyPixel1.setColor(firstPixel.getColor());
				
			}
		}
	}

	/*
	 * Main method for testing - each class in Java can have a main method
	 */
	public static void main(String[] args) {
		Picture beach = new Picture("beach.jpg");
		beach.explore();
		beach.zeroBlue();
		beach.explore();
	}

} // this } is the end of class Picture, put all new methods before this
