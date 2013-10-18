package com.regawmod.game;

import com.regawmod.engine2d.Engine;

public class Main
{
    public static void main(String[] args)
    {
        Engine.init(new MyGame(), MyGame.DISPLAY_WIDTH, MyGame.DISPLAY_HEIGHT);
        Engine.start();
    }
}
