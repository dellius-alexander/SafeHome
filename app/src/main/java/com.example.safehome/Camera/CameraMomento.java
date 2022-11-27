package com.example.safehome.Camera;

import com.example.safehome.Momento;

public class CameraMomento implements Momento<Camera> {
    private Camera state;

    /**
     * Create a momento of the state of on object, save it for
     * later use to restore the state of the object.
     * @param state the state the object
     */
    public CameraMomento(Camera state){
        this.state = state;
    }

    /**
     * Retrieves the state of the saved state of the Camera state.
     * @return the saved Object state
     */
    @Override
    public Camera getState()
    {
        return this.state;
    }

    /**
     * Saves the state of the Camera object.
     * @param state the state the object
     */
    @Override
    public void setState(Camera state)
    {
        this.state = state;
    }

}
