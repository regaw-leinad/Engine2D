package com.regawmod.engine2d;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

/**
 * Wrapper class for window manipulation
 * 
 * @author Dan Wager
 */
public class Window
{
    static void init(int width, int height, boolean vsync)
    {
        try
        {
            Display.setDisplayMode(new DisplayMode(width, height));
            Display.create();

            if (vsync)
                Display.setVSyncEnabled(true);

        }
        catch (LWJGLException e)
        {
            e.printStackTrace();
            System.exit(Engine.EXIT_ERROR);
        }
    }

    static boolean isCloseRequested()
    {
        return Display.isCloseRequested();
    }

    static void destroy()
    {
        Display.destroy();
    }

    public static int getWidth()
    {
        return Display.getWidth();
    }

    public static int getHeight()
    {
        return Display.getHeight();
    }

    public static void setTitle(String title)
    {
        Display.setTitle(title);
    }

    static void render()
    {
        Display.update();
        Display.sync(60);
    }

    private Window()
    {
    }
}
