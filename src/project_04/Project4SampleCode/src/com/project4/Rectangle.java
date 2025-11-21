package com.project4;

import processing.core.PApplet;

public class Rectangle
{
    private float x, y, width, height;
    private int colorStroke, colorFill;

    public Rectangle (float inX, float inY, float inSideLength, int colorS, int colorF)
    {
        x = inX;
        y = inY;
        width = inSideLength;
        height = inSideLength;
        colorStroke = colorS;
        colorFill = colorF;
    }

    public Rectangle (float inX, float inY, float w, float h, int colorS, int colorF)
    {
        x = inX;
        y = inY;
        width = w;
        height = y;
        colorStroke = colorS;
        colorFill = colorF;
    }

    public void draw( PApplet canvas )
    {
        canvas.rect(x, y, width, height);
    }
}