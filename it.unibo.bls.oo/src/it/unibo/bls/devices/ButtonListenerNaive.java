package it.unibo.bls.devices;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar; 

public class ButtonListenerNaive implements ActionListener {
private int count    = 0;
private Format sdf   = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 

	@Override
	public void actionPerformed(ActionEvent e) {
		count++;
	 	System.out.println("ButtonListenerNaive actionPerformed " +  sdf.format(Calendar.getInstance().getTime()) );
    }
	
	public int getNumOfClicks(){
		return count;
	}
}
