package com.regawmod.engine2d;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

public class TextureManager
{
    private static Map<Integer, Texture> registeredTextures;
    private static int textureIdCounter;

    static
    {
        registeredTextures = new HashMap<Integer, Texture>();
        textureIdCounter = 0;
    }

    public static int registerTexture(String texturePath, TextureType type)
    {
        try
        {
            Texture texture = TextureLoader.getTexture(type.name(), ResourceLoader.getResourceAsStream(texturePath));
            registeredTextures.put(++textureIdCounter, texture);
        }
        catch (IOException e)
        {
            System.err.println("Error registering texture: " + texturePath);
            e.printStackTrace();
            System.exit(-1);
        }

        return textureIdCounter;
    }

    public static void unregisterTexture(int id)
    {
        registeredTextures.remove(id);
    }

    public static Texture getRegisteredTexture(int id)
    {
        return registeredTextures.get(id);
    }
}
