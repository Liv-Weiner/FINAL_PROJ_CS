import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Controller implements ActionListener {
	private Game model;
	private View view;

	

	public Controller(Game m, View v) {
		this.model = m;
		this.view = v;

	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		String str = e.getActionCommand();
		
		if(str.equals("Guess A Letter")) {
			model.setChoice("Guess");			
			model.setWait(false);			
			view.getLetterGuess();
			
		}
		else if(str.equals("Solve")) {
			model.setChoice("Solve");
			model.setWait(false);
			view.getSolveGuess();
			
		}
		
			//doneBefore = true;
			//}
//		else {
//			if(view.getBool()) {
//			model.setLetter(str.charAt(0));
//			model.letterChosen(true);
//			}
			
		

		
	}


	

	

	
}