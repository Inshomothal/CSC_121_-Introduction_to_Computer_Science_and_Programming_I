package com.project4;

import java.io.File;

import processing.core.PApplet;

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
 * +: Increase size.
 * -: Decrease size.
 * 0: Save a screenshot to the screenshot path.
 * Backspace: Undo adding previous shapes.
 * DEL: Clear canvas.
 * Escape: Exit program.
 */
public class ShapePaint extends PApplet {
	
	float size = 100f;
	final float sizeInc = 10.0f;
	
	boolean canTakeScreenshot = false;
	
	final int MODE_CIRCLE = 0;
	final int MODE_SQUARE = 1;
	final int MODE_RECTANGLE = 2;
	final int MODE_TRIANGLE = 3;
	final int MODE_MAX = 4;
	int mode = MODE_CIRCLE;
	
	final int WHITE   = color(255, 255, 255, 255);
	final int BLACK   = color(  0,   0,   0, 255);
	final int RED     = color(255,   0,   0, 255);
	int colorIndexStroke = 0;
	int colorIndexFill = 0;
	int colorIndexBackground = 0;
	// TODO: Create an int array of colors.
	
	// TODO: Create lists here to hold instances of our shapes.
	
	
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
	public void settings() {
		// Set the size of the window.
		size(500, 500);
	}

	/**
	 * Setup. Called after settings(). 
	 * Used to initialize other elements of 
	 * the drawing program.
	 */
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
		// TODO: Replace hard-coded BLACK here with 
		// contents of the color array at the index
		// of colorIndexBackground.
		background(BLACK);
	}
	
	/**
	 * Draws each shape in our shape lists.
	 * Takes each shape list and iterates 
	 * through them, calling the draw method 
	 * of each shape with "this" as argument.
	 */
	public void drawShapes()
	{
		// TODO: Iterate through each of our shape ArrayLists,
		// and call the draw method of each shape in the lists.
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

		// TODO: Create an instance of our current mode's shape
		// using the switch statement below, and draw that shape 
		// at the mouse's <x,y>. Until then, we'll just temporarily 
		// draw a white dot at the mouse position.
		stroke(WHITE);
		fill(WHITE);
		circle(x, y, 10);
		
		// TODO: Fill in.
		switch (mode)
		{
		case MODE_CIRCLE:
			break;
			
		case MODE_SQUARE:
			break;
			
		case MODE_RECTANGLE:
			break;
			
		case MODE_TRIANGLE:
			break;
		}
	}

	/**
	 * Called when a mouse button is released.
	 * Left: Add a shape.
	 * Right: Undo a shape.
	 */
	public void mouseReleased()
	{
		if (mouseButton == LEFT) 
		{
			System.out.println("Clicked left mouse button.");
			
			// TODO: First, Remember which shape we just made here
			// so we can "undo" it later if we want to.
			
			// TODO: Second, add a new shape to our shape ArrayLists.
			switch (mode)
			{
			case MODE_CIRCLE:
				break;
				
			case MODE_SQUARE:
				break;
				
			case MODE_RECTANGLE:
				break;
				
			case MODE_TRIANGLE:
				break;
			}
		} 
		else if (mouseButton == RIGHT) 
		{
			System.out.println("Clicked right mouse button.");
			
			undo();
		}
	}
	
	/**
	 * Remove the last shape added.
	 */
	public void undo()
	{
		// TODO: Undo last shape added.
	}
	
	/**
	 * Clear the entire canvas.
	 * I.E. Delete all of our placed shapes.
	 */
	void clearCanvas()
	{
		// TODO: Clear all of our shape lists.
	}

	/**
	 * Called when a keyboard key is pressed.
	 * Handle controls like changing the shape type,
	 * stroke and fill colors, and size.
	 */
	public void keyPressed()
	{
		switch (key)
		{
		case '+':
		case '=':
			size += sizeInc;
			break;
		case '-':
		case '_':
			size -= sizeInc;
			break;
		
		case '1':
			mode = (mode+1)%MODE_MAX;
			break;
			
		case '2':
			// TODO: Update the stroke color index.
			colorIndexStroke = 0;
			break;
		case '3':
			// TODO: Update the fill color index.
			colorIndexFill = 0;
			break;
		case '4':
			// TODO: Update the background color index.
			colorIndexBackground = 0;
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
