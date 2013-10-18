package com.regawmod.engine2d.sprite;

import static org.lwjgl.opengl.GL11.*;

import org.newdawn.slick.Color;
import org.newdawn.slick.opengl.Texture;

import com.regawmod.engine2d.TextureManager;

/**
 * Implementation of sprite that uses an OpenGL Quad and a texture
 * to render a given image to the screen.
 * 
 * @author Dan Wager
 */
public class TexturedSprite extends Sprite
{
    /** The texture that stores the image for this sprite */
    private Texture texture;

    /**
     * Create a new sprite from a specified image.
     * 
     * @param ref A reference to the image on which this sprite should be based
     */
    private TexturedSprite(Texture texture)
    {
        super(texture.getImageWidth(), texture.getImageHeight());

        this.texture = texture;
    }

    /**
     * Draw the sprite at the specified location
     * 
     * @param x The x location at which to draw this sprite
     * @param y The y location at which to draw this sprite
     */
    @Override
    public void render()
    {
        Color.white.bind();
        this.texture.bind();

        // draw a quad textured to match the sprite
        glBegin(GL_QUADS);
        {
            glTexCoord2f(1, 1);
            glVertex2f(0, 0);

            glTexCoord2f(0, 1);
            glVertex2f(this.width, 0);

            glTexCoord2f(0, 0);
            glVertex2f(this.width, this.height);

            glTexCoord2f(1, 0);
            glVertex2f(0, this.height);
        }
        glEnd();
    }

    public static TexturedSprite create(int textureId)
    {
        return new TexturedSprite(TextureManager.getRegisteredTexture(textureId));
    }
}