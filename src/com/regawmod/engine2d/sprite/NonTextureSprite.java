package com.regawmod.engine2d.sprite;

import static org.lwjgl.opengl.GL11.*;

import java.awt.Dimension;

public class NonTextureSprite extends Sprite
{
    public NonTextureSprite(Dimension dimensions)
    {
        super(dimensions);
    }

    public NonTextureSprite(float width, float height)
    {
        super(width, height);
    }

    @Override
    public void render()
    {
        glEnable(GL_TEXTURE_2D);

        super.render();

        glDisable(GL_TEXTURE_2D);
    }
}
