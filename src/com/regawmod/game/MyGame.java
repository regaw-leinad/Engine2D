package com.regawmod.game;

import org.lwjgl.input.Keyboard;

import com.regawmod.engine2d.Engine;
import com.regawmod.engine2d.FPS;
import com.regawmod.engine2d.Game;
import com.regawmod.engine2d.Input;
import com.regawmod.engine2d.TextureManager;
import com.regawmod.engine2d.TextureType;
import com.regawmod.engine2d.Window;
import com.regawmod.engine2d.sprite.RectangleSprite;
import com.regawmod.engine2d.sprite.Sprite;

public class MyGame implements Game
{
    public static final int DISPLAY_WIDTH = 800;
    public static final int DISPLAY_HEIGHT = 600;

    private static final float SPEED = 100f;

    // TexturedSprite s;
    Sprite s;
    private int faceTexture;
    private float x;
    private float y;

    @Override
    public void init()
    {
        this.x = 300;
        this.y = 200;

        faceTexture = TextureManager.registerTexture("res/icon.png", TextureType.PNG);
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
    public void update(float dt)
    {
        if (Input.isKeyDown(Keyboard.KEY_W))
            this.y += SPEED * dt;

        if (Input.isKeyDown(Keyboard.KEY_S))
            this.y -= SPEED * dt;

        if (Input.isKeyDown(Keyboard.KEY_A))
            this.x -= SPEED * dt;

        if (Input.isKeyDown(Keyboard.KEY_D))
            this.x += SPEED * dt;

        Window.setTitle("FPS: " + FPS.getFPS());
    }

    @Override
    public void render()
    {
        s.render(x, y);
    }
}
