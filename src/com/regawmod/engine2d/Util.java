package com.regawmod.engine2d;

public class Util
{
    /**
     * Get the closest greater power of 2 to the fold number
     * 
     * @param fold The target number
     * @return The power of 2
     */
    public static int get2Fold(int fold)
    {
        int ret = 2;
        while (ret < fold)
            ret *= 2;

        return ret;
    }

    private Util()
    {
    }
}
