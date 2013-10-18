package com.regawmod.engine2d;

import org.lwjgl.Sys;

public class Time
{
    // Time at last frame
    private static long lastFrameMillis = 0;

    /**
     * Initializes the Time class
     */
    public static void init()
    {
        getDelta();
    }

    /**
     * Get the high resolution time in milliseconds
     * 
     * @return The high resolution time in milliseconds
     */
    public static long getTime()
    {
        return (Sys.getTime() * 1000) / Sys.getTimerResolution();
    }

    /**
     * Calculate how many milliseconds have passed
     * since last frame.
     * 
     * @return milliseconds passed since last frame
     */
    public static int getDelta()
    {
        long time = getTime();
        int delta = (int)(time - lastFrameMillis);
        lastFrameMillis = time;

        return delta;
    }

    /**
     * Sleep for a fixed number of milliseconds.
     * 
     * @param duration The amount of time in milliseconds to sleep for
     */
    public static void sleep(long duration)
    {
        try
        {
            Thread.sleep((duration * Sys.getTimerResolution()) / 1000);
        }
        catch (InterruptedException e)
        {
        }
    }

    private Time()
    {
    }
}
