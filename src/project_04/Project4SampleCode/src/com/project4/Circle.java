package com.project4;

import processing.core.PApplet;

public class Circle {
    private float x, y, diameter;
    private int colorStroke, colorFill;

    public Circle (float inX, float inY, float d, int colorS, int colorF )
    {
        x = inX;
        y = inY;
        diameter = d;
        colorStroke = colorS;
        colorFill = colorF;
    }

    public void draw ( PApplet canvas )
    {
        canvas.stroke(colorStroke);
        canvas.fill(colorFill);
        canvas.circle(x, y, diameter);

    }
    
}