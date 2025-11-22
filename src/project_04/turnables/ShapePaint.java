package com.project4;

import java.io.File;
import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PVector;

/**
 * Shape Paint
 * 
 * Creates a canvas window to paint into with
 * various shape stamps.
 * 
 * Controls
 * Left Mouse Click: Add shape to canvas.
 * Right Mouse Click: Undo adding previous shape.
 * 1: Change shape.
 * 2: Change stroke color.
 * 3: Change fill color.
 * 4: Change background color.
 * 5: Rotates rectangle.
 * +: Increase size.
 * -: Decrease size.
 * 0: Save a screenshot to the screenshot path.
 * Backspace: Undo adding previous shapes.
 * DEL: Clear canvas.
 * Escape: Exit program.
 */
public class ShapePaint extends PApplet {
	
	float size = 10f;
	float sizeRH = size;
	float sizeRW = sizeRH * 2 ;
	final float sizeInc = 10.0f;
	
	boolean canTakeScreenshot = false;
	
	//============== THE MODES ===================
	final int MODE_CIRCLE = 0;
	final int MODE_SQUARE = 1;
	final int MODE_RECTANGLE = 2;
	final int MODE_TRIANGLE = 3;
	final int MODE_MAX = 4;
	int mode = MODE_CIRCLE;
	int rotation = 0;
	final int ROT_REGULAR = 0;
	final int ROT_FLIPPED = 1;
	
	//============= COLORS =======================
	final int WHITE   = color(255, 255, 255, 255);
	final int BLACK   = color(  0,   0,   0, 255);
	final int RED     = color(255,   0,   0, 255);
	final int MAGENTA     = color(255,   0,   255, 255);
	final int HOT_PINK     = color(255,   20,   147, 255);
	final int ORANGE     = color(255,   127,   0, 255);
	final int GOLD     = color(255,   191,   0, 255);
	final int YELLOW     = color(255,   255,   0, 255);
	final int LIME     = color(191,   255,   0, 255);
	final int GREEN     = color(0,   255,   0, 255);
	final int TURQUOISE     = color(0,   128,   128, 255);
	final int CYAN     = color(0,   255,   255, 255);
	final int BLUE     = color(0,   0,   255, 255);
	final int LAVENDER     = color(230,   230,   250, 255);
	final int INDIGO     = color(75,   0,   130, 255);
	final int VIOLET     = color(148,   0,   211, 255);
	int[] colorArray = {WHITE, BLACK, RED, MAGENTA, HOT_PINK,
						ORANGE, GOLD, YELLOW, LIME, GREEN,
						TURQUOISE, CYAN, BLUE, LAVENDER, INDIGO, VIOLET};
	int cS = 0, colorIndexStroke = colorArray[cS];
	int cF = 0, colorIndexFill = colorArray[cF];
	int cB = 1, colorIndexBackground = colorArray[cB];

	//=========== OBJECT ARRAYS ==================
	ArrayList<Circle> circles = new ArrayList<>();
	ArrayList<Rectangle> rectangles = new ArrayList<>();
	ArrayList<Triangle> triangles = new ArrayList<>();
	ArrayList<int[]> drawhistory = new ArrayList<>();
	
	
	
	/**
	 * The starting method of our program.
	 * @param args Program command line arguments.
	 */
	public static void main(String[] args) {
		// The String argument here to our PApplet
		// main method must match the package and 
		// class name of our program.
		PApplet.main("com.project4.ShapePaint");
	}
	
	/**
	 * Startup settings. First method called 
	 * after main. Used to initialize
	 * properties of our window/canvas.
	 */
	@Override
	public void settings() {
		// Set the size of the window.
		size(500, 500);
	}

	/**
	 * Setup. Called after settings(). 
	 * Used to initialize other elements of 
	 * the drawing program.
	 */
	@Override
	public void setup() {
		windowTitle("Shape Paint");
		stroke(255, 0, 0, 255);
		strokeWeight(5.0f);
		
		// Set rectangle draw mode so <x,y> 
		// represents the center of a rectangle.
		rectMode(CENTER);
		
		determineStartingScreenshotNumber();
	}

	/**
	 * Draw method.
	 * Called every frame to redraw our canvas.
	 */
	@Override
	public void draw() {
		// Clear background.
		drawBackground();
		
		// Draw our shape ArrayLists here.
		drawShapes();
		
		// Check if we should take a screenshot.
		checkForScreenshot();
		
		// Draw a shape at our mouse <x,y> position.
		drawShapeAtMouse();
	}
	
	/**
	 * Draw a single, solid color as the background.
	 */
	public void drawBackground()
	{
		background(colorIndexBackground);
	}
	
	/**
	 * Draws each shape in our shape lists.
	 * Takes each shape list and iterates 
	 * through them, calling the draw method 
	 * of each shape with "this" as argument.
	 */
	public void drawShapes()
	{
		for (int[] entry:drawhistory) {
			switch(entry[0])
			{
				case MODE_CIRCLE:
					circles.get(entry[1]).draw(this);
					break;
				case MODE_SQUARE:
				case MODE_RECTANGLE:
					rectangles.get(entry[1]).draw(this);
					break;
				case MODE_TRIANGLE:
					triangles.get(entry[1]).draw(this);
					break;
			}
		}

	}
	
	/**
	 * Checks if we should take a screenshot.
	 */
	public void checkForScreenshot() 
	{
		if (canTakeScreenshot)
		{
			saveScreenshot();
			canTakeScreenshot = false;
		}
	}
	
	/**
	 * Draws the currently selected shape 
	 * at the current mouse <x,y> position.
	 */
	public void drawShapeAtMouse()
	{
		int x = mouseX;
		int y = mouseY;

        PVector p1, p2, p3;
        float a1 = PApplet.radians(90), a2 = PApplet.radians(210), a3 = PApplet.radians(330);

        p1 = new PVector(x + size * PApplet.cos(a1), y + size * PApplet.sin(a1));
        p2 = new PVector(x + size * PApplet.cos(a2), y + size * PApplet.sin(a2));
        p3 = new PVector(x + size * PApplet.cos(a3), y + size * PApplet.sin(a3));		
		
		switch (mode)
		{
		case MODE_CIRCLE:
			stroke(colorIndexStroke);
			fill(colorIndexFill);
			circle(x, y, size);
			break;
			
		case MODE_SQUARE:
			stroke(colorIndexStroke);
			fill(colorIndexFill);
			rect(x, y, size, size);
			break;
			
		case MODE_RECTANGLE:
			stroke(colorIndexStroke);
			fill(colorIndexFill);
			rectangleRotation();
			rect(x, y, sizeRW, sizeRH);
			break;
			
		case MODE_TRIANGLE:
			stroke(colorIndexStroke);
			fill(colorIndexFill);
			triangle(p1.x, p1.y, p2.x, p2.y, p3.x, p3.y);
			break;
		}
	}

	/**
	 * Called to simulate rotation by flipping
	 * the rectangle's width and height.
	 */
	private void rectangleRotation()
	{
		switch (rotation%2)
		{
			case ROT_REGULAR:
				sizeRH = size;
				sizeRW = size * 2;
				break;
			case ROT_FLIPPED:
				sizeRH = size * 2;
				sizeRW = size;
				break;
		}
	}

	/**
	 * Called when a mouse button is released.
	 * Left: Add a shape.
	 * Right: Undo a shape.
	 */
	@Override
	public void mouseReleased()
	{
		if (mouseButton == LEFT) 
		{			
			switch (mode)
			{
			case MODE_CIRCLE:
				circles.add(new Circle(mouseX, mouseY, size, colorIndexStroke, colorIndexFill));
				drawhistory.add(new int[]{mode, circles.size() - 1});
				break;
				
			case MODE_SQUARE:
				rectangles.add(new Rectangle(mouseX, mouseY, size, colorIndexStroke, colorIndexFill));
				drawhistory.add(new int[]{mode, rectangles.size() - 1});
				break;
				
			case MODE_RECTANGLE:
				rectangleRotation();
				rectangles.add(new Rectangle(mouseX, mouseY, sizeRW, sizeRH, colorIndexStroke, colorIndexFill));
				drawhistory.add(new int[]{mode, rectangles.size() - 1});
				break;
				
			case MODE_TRIANGLE:
				triangles.add(new Triangle(mouseX, mouseY, size, colorIndexStroke, colorIndexFill));
				drawhistory.add(new int[]{mode, triangles.size() - 1});
				break;
			}
		} 
		else if (mouseButton == RIGHT) 
		{		
			undo();
		}
	}
	
	/**
	 * Remove the last shape added.
	 */
	public void undo()
	{
		try{
			int entry = drawhistory.getLast()[0];
			drawhistory.removeLast();

			switch (entry)
			{
				case MODE_CIRCLE:
					circles.removeLast();
					break;
				case MODE_SQUARE:
				case MODE_RECTANGLE:
					rectangles.removeLast();
					break;
				case MODE_TRIANGLE:
					triangles.removeLast();
					break;
					
			}
		}catch (Exception e) {
			System.out.println("No more to remove.");
		}
	}
	
	/**
	 * Clear the entire canvas.
	 * I.E. Delete all of our placed shapes.
	 */
	void clearCanvas()
	{
		drawhistory.clear();
		circles.clear();
		rectangles.clear();
		triangles.clear();
	}

	/**
	 * Called when a keyboard key is pressed.
	 * Handle controls like changing the shape type,
	 * stroke and fill colors, and size.
	 */
	@Override
	public void keyPressed()
	{
		switch (key)
		{
		case '+':
		case '=':
				size = ((size + sizeInc)%10 == 0)? size + sizeInc: 10;
			break;
		case '-':
		case '_':
				size = ((size - sizeInc) > 0)? size - sizeInc: 5;
			break;
		
		case '1':
			mode = (mode+1)%MODE_MAX;
			break;
			
		case '2':
			cS = (cS < colorArray.length - 1) ? (cS + 1) : 0;
			colorIndexStroke = colorArray[cS];
			break;
		case '3':
			cF = (cF < colorArray.length - 1) ? (cF + 1) : 0;
			colorIndexFill = colorArray[cF];
			break;
		case '4':
			cB = (cB < colorArray.length - 1) ? (cB + 1) : 0;
			colorIndexBackground = colorArray[cB];
			break;
		case '5':
			rotation++;
			break;
			
		case DELETE:
			clearCanvas();
			break;
			
		case BACKSPACE:
			undo();
			break;
			
		case '0':
		case 's':
		case 'S':
			canTakeScreenshot = true;
			break;
		}
	}
	
	/**
	 * Save a screenshot.
	 */
	final String screenshotPath = "./screenshots/";
	final String filename = "masterpiece_";
	final String extension = ".png";
	int pictureNumber = 1;
	void saveScreenshot() 
	{
		String screenshotFilename = 
			screenshotPath + filename + 
			((pictureNumber < 100) ? "0" : "") +
			((pictureNumber < 10)  ? "0" : "") +
			(pictureNumber++) + 
			extension;
		save(screenshotFilename);
		System.out.println(
			"Saved screenshot: " + screenshotFilename);
	}
	
	/**
	 * Look at our screenshot directory and check
	 * what the next image filename number should be.
	 */
	void determineStartingScreenshotNumber()
	{
		File directory = new File(screenshotPath);
		File[] files = directory.listFiles();
		if (files != null) {
			pictureNumber = files.length+1;
		} else {
			System.out.println("Error reading screenshot directory: " + screenshotPath);
		}
	}
}
