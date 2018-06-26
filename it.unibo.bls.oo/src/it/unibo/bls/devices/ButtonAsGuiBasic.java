package it.unibo.bls.devices;
import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.ActionListener;
import it.unibo.bls.interfaces.IButton;

public class ButtonAsGuiBasic extends java.awt.Button implements IButton{
//Factory Method
	public static IButton createButton(Frame frame, String label, ActionListener listener) {
		return new ButtonAsGuiBasic(frame, label,listener);	
 	}
	public ButtonAsGuiBasic(Frame frame, String label,  ActionListener listener){
		super(label);
		this.addActionListener(  listener );
		frame.add(BorderLayout.WEST,this); 
		frame.validate();
	}
}