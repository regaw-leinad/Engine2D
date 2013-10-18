package com.regawmod.game;

import org.lwjgl.input.Keyboard;

import com.regawmod.engine2d.Engine;
import com.regawmod.engine2d.FPS;
import com.regawmod.engine2d.Game;
import com.regawmod.engine2d.Input;
import com.regawmod.engine2d.Window;
import com.regawmod.engine2d.sprite.RectangleSprite;
import com.regawmod.engine2d.sprite.Sprite;

public class MyGame implements Game
{
    public static final int DISPLAY_WIDTH = 800;
    public static final int DISPLAY_HEIGHT = 600;

    // TexturedSprite s;
    Sprite s;
    private int faceTexture;

    @Override
    public void init()
    {
        // faceTexture = TextureManager.registerTexture("res/kurt2.png", TextureType.PNG);
        // s = TexturedSprite.create(faceTexture);
        s = new RectangleSprite(50f, 80f, 0.0f, 0.0f, 1.0f);
    }

    @Override
    public void processInput()
    {
        if (Input.isKeyDown(Keyboard.KEY_ESCAPE))
            Engine.stop();
    }

    @Override
    public void update(int delta)
    {
        Window.setTitle("FPS: " + FPS.getFPS());
    }

    @Override
    public void render()
    {
        s.render(300, 200);
    }
}
