package com.regawmod.engine2d;

/**
 * Handles FPS calculation
 * 
 * @author Dan Wager
 */
public class FPS
{
    private static long lastFPSTime = Time.getTime();
    private static int currentFrames = 0;
    private static int lastFPS = 0;

    /**
     * Get the most recent calculated FPS
     * 
     * @return The FPS
     */
    public static int getFPS()
    {
        return lastFPS;
    }

    /**
     * Update the FPS. Must be called every frame
     */
    public static void update()
    {
        if (Time.getTime() - lastFPSTime > 1000)
        {
            lastFPS = currentFrames;
            currentFrames = 0;
            lastFPSTime += 1000;
        }

        currentFrames++;
    }

    private FPS()
    {
    }
}
