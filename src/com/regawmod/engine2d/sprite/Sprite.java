package com.regawmod.engine2d.sprite;

import static org.lwjgl.opengl.GL11.*;

import java.awt.Dimension;

import com.regawmod.engine2d.Renderable;

/**
 * Base abstract class for a Sprite
 * 
 * @author Dan Wager
 */
public abstract class Sprite implements Renderable
{
    protected float width;
    protected float height;

    /**
     * Creates a new Sprite
     * 
     * @param dimensions The dimensions of the sprite
     */
    public Sprite(Dimension dimensions)
    {
        this(dimensions.width, dimensions.height);
    }

    /**
     * Creates a new Sprite
     * 
     * @param width The width of the sprite
     * @param height The height of the sprite
     */
    public Sprite(float width, float height)
    {
        this.width = width;
        this.height = height;
    }

    public float getWidth()
    {
        return width;
    }

    public float getHeight()
    {
        return height;
    }

    /**
     * Render the sprite to the window
     */
    @Override
    public void render()
    {
        glBegin(GL_QUADS);
        {
            glVertex2f(0, 0);
            glVertex2f(this.width, 0);
            glVertex2f(this.width, this.height);
            glVertex2f(0, this.height);
        }
        glEnd();
    }

    public void render(float x, float y)
    {
        glPushMatrix();
        {
            glTranslatef(x, y, 0);
            render();
        }
        glPopMatrix();
    }
}
