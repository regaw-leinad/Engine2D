package com.regawmod.engine2d;

import static org.lwjgl.openal.AL10.*;

import java.nio.IntBuffer;

import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLException;
import org.lwjgl.openal.AL;
import org.newdawn.slick.openal.WaveData;

/**
 * Manager for the audio
 * 
 * @author Dan Wager
 */
public final class AudioManager
{
    private int[] buffers = new int[256];
    private int[] sources;
    private IntBuffer scratchBuffer;
    private boolean soundOutput;
    private int bufferIndex;
    private int sourceIndex;

    /**
     * Creates a new AudioManager
     */
    public AudioManager()
    {
        scratchBuffer = BufferUtils.createIntBuffer(256);
    }

    /**
     * Plays a sound effect
     * 
     * @param buffer Buffer index to play (from addSound)
     */
    public void playEffect(int buffer)
    {
        if (soundOutput)
        {
            // make sure we never choose last channel, since it is used for special sounds
            int channel = sources[(sourceIndex++ % (sources.length - 1))];

            // link buffer and source, and play it
            alSourcei(channel, AL_BUFFER, buffers[buffer]);
            alSourcePlay(channel);
        }
    }

    /**
     * Plays a sound on last source
     * 
     * @param buffer Buffer index to play (from addSound)
     */
    public void playSound(int buffer)
    {
        if (soundOutput)
        {
            alSourcei(sources[sources.length - 1], AL_BUFFER, buffers[buffer]);
            alSourcePlay(sources[sources.length - 1]);
        }
    }

    /**
     * Whether a sound is playing on last source
     * 
     * @return True if a source is playing right now
     */
    public boolean isPlayingSound()
    {
        return alGetSourcei(sources[sources.length - 1], AL_SOURCE_STATE) == AL_PLAYING;
    }

    /**
     * Initializes the SoundManager
     * 
     * @param channels Number of channels to create
     */
    public void initialize(int channels)
    {
        try
        {
            AL.create();

            // allocate sources
            scratchBuffer.limit(channels);
            alGenSources(scratchBuffer);
            scratchBuffer.rewind();
            scratchBuffer.get(sources = new int[channels]);

            // could we allocate all channels?
            if (alGetError() != AL_NO_ERROR)
            {
                throw new LWJGLException("Unable to allocate " + channels + " sources");
            }

            // we have sound
            soundOutput = true;
        }
        catch (LWJGLException le)
        {
            le.printStackTrace();
            System.out.println("Sound disabled");
        }
    }

    /**
     * Adds a sound to the Sound Managers pool
     * 
     * @param path Path to file to load
     * @return Index of sound
     */
    public int addSound(String path)
    {
        // Generate 1 buffer entry
        scratchBuffer.rewind().position(0).limit(1);
        alGenBuffers(scratchBuffer);
        buffers[bufferIndex] = scratchBuffer.get(0);

        // load wave data from buffer
        WaveData wavefile = WaveData.create("spaceinvaders/" + path);

        // copy to buffers
        alBufferData(buffers[bufferIndex], wavefile.format, wavefile.data, wavefile.samplerate);

        // unload file again
        wavefile.dispose();

        // return index for this sound
        return bufferIndex++;
    }

    /**
     * Destroy the SoundManager
     */
    public void destroy()
    {
        if (soundOutput)
        {
            // stop playing sounds
            scratchBuffer.position(0).limit(sources.length);
            scratchBuffer.put(sources).flip();
            alSourceStop(scratchBuffer);

            // destroy sources
            alDeleteSources(scratchBuffer);

            // destroy buffers
            scratchBuffer.position(0).limit(bufferIndex);
            scratchBuffer.put(buffers, 0, bufferIndex).flip();
            alDeleteBuffers(scratchBuffer);

            // destory OpenAL
            AL.destroy();
        }
    }
}