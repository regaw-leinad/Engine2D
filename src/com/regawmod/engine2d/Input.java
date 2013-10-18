package com.regawmod.engine2d;

import java.util.ArrayList;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

/**
 * Handles Keyboard/Mouse input
 * 
 * @author Dan Wager
 */
public final class Input
{
    public static final int NUM_KEYCODES = 256;
    public static final int NUM_MOUSEBUTTONS = 5;

    public static final int MOUSE_LEFT = 0x00;
    public static final int MOUSE_RIGHT = 0x01;
    public static final int MOUSE_MIDDLE = 0x02;

    private static ArrayList<Integer> lastKeys = new ArrayList<Integer>();
    private static ArrayList<Integer> lastMouse = new ArrayList<Integer>();

    /**
     * Updates the Input. Must be called every frame by engine AFTER games input
     */
    static void update()
    {
        lastKeys.clear();

        for (int i = 0; i < NUM_KEYCODES; i++)
            if (isKeyDown(i))
                lastKeys.add(i);

        lastMouse.clear();

        for (int i = 0; i < NUM_MOUSEBUTTONS; i++)
            if (getMouse(i))
                lastMouse.add(i);
    }

    /**
     * Checks if a key is currently down
     * 
     * @param keyCode The key code
     * @return True if the key is down
     */
    public static boolean isKeyDown(int keyCode)
    {
        return Keyboard.isKeyDown(keyCode);
    }

    /**
     * Gets if the key was just pressed this frame
     * 
     * @param keyCode The key code
     * @return True if the key was just pressed this frame
     */
    public static boolean getKeyPress(int keyCode)
    {
        return isKeyDown(keyCode) && !lastKeys.contains(keyCode);
    }

    /**
     * Checks if key was just released this frame
     * 
     * @param keyCode The key code
     * @return True if the key was just released this frame
     */
    public static boolean getKeyUp(int keyCode)
    {
        return !isKeyDown(keyCode) && lastKeys.contains(keyCode);
    }

    /**
     * Checks if the specified mouse button is down
     * 
     * @param mouseButton The mouse button
     * @return True if the button is down
     */
    public static boolean getMouse(int mouseButton)
    {
        return Mouse.isButtonDown(mouseButton);
    }

    /**
     * Checks if the specified mouse button was pressed this frame
     * 
     * @param mouseButton The mouse button
     * @return True if the button was just pressed this frame
     */
    public static boolean getMouseDown(int mouseButton)
    {
        return getMouse(mouseButton) && !lastMouse.contains(mouseButton);
    }

    /**
     * Checks if the specified mouse button was released this frame
     * 
     * @param mouseButton The mouse button
     * @return True if the button was just released this frame
     */
    public static boolean getMouseUp(int mouseButton)
    {
        return !getMouse(mouseButton) && lastMouse.contains(mouseButton);
    }

    /**
     * Gets the mouse's current position as a 2D vector
     * 
     * @return The mouse's position
     */
    public static Vector2f getMousePosition()
    {
        return new Vector2f(Mouse.getX(), Mouse.getY());
    }

    /**
     * Initializes the Input class
     */
    static void init()
    {
        try
        {
            Keyboard.create();
            Mouse.create();
        }
        catch (LWJGLException e)
        {
            e.printStackTrace();
            System.exit(Engine.EXIT_ERROR);
        }
    }

    /**
     * Cleans up the Input class
     */
    public static void destroy()
    {
        Keyboard.destroy();
        Mouse.destroy();
    }

    private Input()
    {
    }
}