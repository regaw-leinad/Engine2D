package com.regawmod.engine2d;

import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.opengl.Display;

/**
 * Utility class for rendering
 * 
 * @author Dan Wager
 */
class RenderUtil
{
    /**
     * Clears the screen
     */
    static void clearScreen()
    {
        glClear(GL_COLOR_BUFFER_BIT);
    }

    /**
     * Initializes OpenGL
     */
    static void initGraphics()
    {
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        glOrtho(0, Display.getWidth(), 0, Display.getHeight(), -1, 1);
        glMatrixMode(GL_MODELVIEW);

        glDisable(GL_DEPTH_TEST);
        glClearColor(0f, 0f, 0f, 0f);
        glEnable(GL_TEXTURE_2D);
    }

    private RenderUtil()
    {
    }
}
