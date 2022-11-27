package com.example.safehome.ControlPanel;


import java.net.NetworkInterface;

public class ControlPanel implements Panel{
    private String mode;
    private Characteristics keyPadCharacteristics;
    private Speaker speaker;
    private NetworkInterface networkInterface;
    private ControlPanel state;
    /**
     * Defines the input from terminal, screen or key pad
     *
     * @param keyStrokes the {@literal String} keyStroke input.
     */
    @Override
    public void readKeyStrokes(String keyStrokes) {
        // TODO: implement the reading of input
    }

    /**
     * Decodes keystroke to to utf-8 encoding
     *
     * @return the decoded key {@literal String} value
     */
    @Override
    public String decodeKey() {
        // TODO: decode the key stroke and return true if successful, false otherwise.
        return null;
    }

    /**
     * Defines the display status. True if display is available,
     * false otherwise.
     *
     * @return {@literal boolean}
     */
    @Override
    public boolean displayStatus() {
        // TODO: implement display status process and return true if successful, false otherwise.
        return false;
    }

    /**
     * Defines the screen mode to dark mode.
     *
     * @param mode the mode definition string to define the mode.
     * @return {@literal boolean}
     */
    @Override
    public boolean darkMode(String mode) {
        // TODO: implement darkMode process and return true if successful, false otherwise.
        return false;
    }

    /**
     * Sends a control message to initiate a task.
     *
     * @param msg the message string
     * @return {@literal boolean}
     */
    @Override
    public boolean sendControlMsg(String msg) {
        // TODO: implement sendControlMsg and return true if successful, false otherwise.
        return false;
    }
    /**
     * Contains the current state of the {@linkplain ControlPanel} object.
     * @return {@linkplain ControlPanelMomento}
     */
    public ControlPanelMomento saveState(){
        //println "Originator: Saving to ControlPanelMomento."
        return new ControlPanelMomento(this.state);
    }
    /**
     * Setting a new internal state of the {@linkplain ControlPanel}
     * @param state the current state of the {@linkplain ControlPanel}
     */
    public void setState(ControlPanel state){
        this.state = state;
    }
    /**
     * Restores the {@linkplain ControlPanel} to a previous state
     * @param controlPanelMomento the {@linkplain ControlPanelMomento} containing the
     *                            state of the {@linkplain ControlPanel}
     */
    public void restoreState(ControlPanelMomento controlPanelMomento){
        this.state = controlPanelMomento.getState();
    }

}
