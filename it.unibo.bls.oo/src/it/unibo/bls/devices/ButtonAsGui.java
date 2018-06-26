package it.unibo.bls.devices;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import it.unibo.bls.applLogic.BlsApplicationLogic;
import it.unibo.bls.interfaces.IButtonObservable;
import it.unibo.bls.interfaces.IObserver;

public class ButtonAsGui extends Observable implements IButtonObservable, ActionListener{
//Factory method
public static ButtonAsGui createButton( Frame frame, String cmd, BlsApplicationLogic obs ){
	ButtonAsGui button = new ButtonAsGui();
	ButtonAsGuiBasic.createButton(frame, cmd, button);	//button is the listener
	button.addObserver(obs);
	return button;
}
	@Override
	public void addObserver(IObserver observer) {
		 super.addObserver(observer);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		this.setChanged();
		this.notifyObservers("pressed");
	}
}
