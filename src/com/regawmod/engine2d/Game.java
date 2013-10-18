package com.regawmod.engine2d;


/**
 * The interface any game using this engine must implement
 * 
 * @author Dan Wager
 */
public interface Game extends Renderable
{
    /**
     * Initialize the game
     */
    void init();

    /**
     * Process all input here
     */
    void processInput();

    /**
     * Update all entities in game
     * 
     * @param delta The delta time between frames
     */
    void update(int delta);

    /**
     * Render the game to the window
     */
    @Override
    void render();
}
