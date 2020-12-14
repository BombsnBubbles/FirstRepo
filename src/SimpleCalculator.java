import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SimpleCalculator extends JFrame implements ActionListener{

	/**
	 * Simple Calculator
	 * number 1:________
	 * number 2:________
	 * [add] [multiply] <-- buttons
	 * Result:________
	 */
	
	//Declare all components
	private JLabel labelNum1, labelNum2, labelResult;
	private JTextField textfld1, textfld2;
	private JButton buttonAdd, buttonMult;
	private JPanel panel;
	
	private static final int width = 205;
	private static final int height = 200;
	
	public SimpleCalculator() {
		//Initialize components and add them to the panel
		labelNum1 = new JLabel("Number 1: ");
		textfld1 = new JTextField(10);
		
		labelNum2 = new JLabel("Number 2: ");
		textfld2 = new JTextField(10);
		
		buttonAdd = new JButton("Add");
		buttonAdd.addActionListener(this);
		buttonMult = new JButton("Multiply");
		buttonMult.addActionListener(this);
		
		labelResult = new JLabel("Result: ");
		
		panel = new JPanel();
		panel.setLayout(new GridLayout(5,2));
		panel.add(labelNum1);
		panel.add(textfld1);
		panel.add(labelNum2);
		panel.add(textfld2);
		panel.add(buttonAdd);
		panel.add(buttonMult);
		panel.add(labelResult);
		
		add(panel);
	}
	
	public static void main(String args[]) {
		SimpleCalculator calc = new SimpleCalculator();
		
		calc.setSize(width,height);
		calc.setTitle("My Simple Calculator");
		calc.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		calc.setVisible(true);
		
	}

	public boolean isNumber(String s) {
		try {
			Integer.parseInt(s);
			return true;
		}
		catch (Exception e){
			return false;
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getActionCommand().equals("Add")) {
			if(isNumber(textfld1.getText()) && isNumber(textfld2.getText())){
				
				int x = Integer.parseInt(textfld1.getText());
				int y = Integer.parseInt(textfld2.getText());

				int z = x + y;

				labelResult.setText("Result: "+z);
			}
			else {
				JOptionPane.showMessageDialog(this,"Enter a valid number");
			}
		}
		if(e.getActionCommand().equals("Multiply")) {
			if(isNumber(textfld1.getText()) && isNumber(textfld2.getText())) {

				int x = Integer.parseInt(textfld1.getText());
				int y = Integer.parseInt(textfld2.getText());

				int z = x * y;

				labelResult.setText("Result: "+z);
			}
			else {
				JOptionPane.showMessageDialog(this,"Enter a valid number");
			}
		}
	}
}
