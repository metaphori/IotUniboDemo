package it.unibo.bls.components;

import java.awt.event.ActionEvent;

import it.unibo.bls.applLogic.BlsApplicationLogic;
 
/*
 * An ActionLister that USES the given application logic
 */
public class ButtonListener extends ButtonListenerNaive {
private BlsApplicationLogic appLogic;
private String cmd;

	public ButtonListener(BlsApplicationLogic appLogic, String cmd){
		super();
		this.appLogic = appLogic;
		this.cmd = cmd;
	}
 	@Override
	public void actionPerformed(ActionEvent e) {
 		super.actionPerformed(e);
		String evCmd = e.getActionCommand();
		if( evCmd.equals(cmd)){
	 		appLogic.execute();
		}
  	}
}
