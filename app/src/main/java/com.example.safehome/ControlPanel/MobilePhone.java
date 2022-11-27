package ControlPanel;

public abstract class MobilePhone<controlPanelMomentoList extends List<ControlPanelMomento>> {

	/**
	 * 
	 * @param controlPanelMomento
	 */
	public abstract void addControlPanelMomento(int controlPanelMomento);

	public abstract ControlPanelMomento getControlPanelMomento();

}