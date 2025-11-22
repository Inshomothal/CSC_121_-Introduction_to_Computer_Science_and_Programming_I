package com.project4;

import processing.core.PApplet;
import processing.core.PVector;

public class Triangle
{
    private final float x, y, diameter;
    private final int colorStroke, colorFill;

    public Triangle (float inX, float inY, float inSideLength, int colorS, int colorF )
    {
        x = inX;
        y = inY;
        diameter = inSideLength;
        colorStroke = colorS;
        colorFill = colorF;
    }

    public void draw ( PApplet canvas )
    {
        PVector p1, p2, p3;
        float a1 = PApplet.radians(90), a2 = PApplet.radians(210), a3 = PApplet.radians(330);

        p1 = new PVector(x + diameter * PApplet.cos(a1), y + diameter * PApplet.sin(a1));
        p2 = new PVector(x + diameter * PApplet.cos(a2), y + diameter * PApplet.sin(a2));
        p3 = new PVector(x + diameter * PApplet.cos(a3), y + diameter * PApplet.sin(a3));

        
        
        canvas.stroke(colorStroke);
        canvas.fill(colorFill);
        canvas.triangle(p1.x, p1.y, p2.x, p2.y, p3.x, p3.y);
    }
}