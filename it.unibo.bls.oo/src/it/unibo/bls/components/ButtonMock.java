package it.unibo.bls.components;

import java.util.Observable;
import it.unibo.bls.interfaces.IButton;
import it.unibo.bls.interfaces.IObservable;
import it.unibo.bls.interfaces.IObserver;

public class ButtonMock extends Observable implements IObservable, IButton{
private boolean buttonState = false;

//Factory method
public static ButtonMock createButton( IObserver obs ){
	 ButtonMock button = new ButtonMock();
	 button.addObserver(obs);
	 return button;
}

	@Override
	public void addObserver(IObserver observer) {
		 super.addObserver(observer);		
	}

	public void press() {
 		System.out.println("ButtonMock press"   );
		buttonState = ! buttonState;
		this.setChanged();
		this.notifyObservers("pressed");
	}
}
