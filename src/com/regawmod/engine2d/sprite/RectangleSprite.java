package com.regawmod.engine2d.sprite;

import static org.lwjgl.opengl.GL11.*;

public class RectangleSprite extends NonTextureSprite
{
    private float r;
    private float g;
    private float b;

    public RectangleSprite(float width, float height)
    {
        this(width, height, 1.0f, 1.0f, 1.0f);
    }

    public RectangleSprite(float width, float height, float r, float g, float b)
    {
        super(width, height);

        this.r = r;
        this.g = g;
        this.b = b;
    }

    @Override
    public void render()
    {
        glColor3f(r, g, b);
        super.render();
    }
}
