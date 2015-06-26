package ba.bitcamp.homework.additionaltask;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * Window that provides information of the previous game and asks players if they want another game.
 * @author Ognjen
 *
 */
public class OptionWindow extends JFrame{
	
	private static final long serialVersionUID = -6947550631366359694L;

	private JLabel message;
	private JButton yesBtn;
	private JButton noBtn;
	JPanel btnPanel; 
	
	/**
	 * @param text Text to be displayed.
	 */
	public OptionWindow(String text) {
		super();
		setLayout(new BorderLayout());
		
		message = new JLabel(text, JLabel.CENTER);
		message.setFont(new Font("Calibri", Font.BOLD, 22));
		message.setForeground(Color.WHITE);
		message.setOpaque(true);
		message.setBackground(new Color(0, 0, 205));
		
		yesBtn = new JButton("YES");
		yesBtn.setBackground(new Color(65, 105, 225));
		yesBtn.setFont(new Font("Calibri", Font.BOLD, 18));
		yesBtn.setForeground(Color.WHITE);
		yesBtn.addActionListener(new Action());
		
		noBtn = new JButton("NO");
		noBtn.setBackground(new Color(65, 105, 225));
		noBtn.setFont(new Font("Calibri", Font.BOLD, 18));
		noBtn.setForeground(Color.WHITE);
		noBtn.addActionListener(new Action());
		
		btnPanel = new JPanel();
		btnPanel.setLayout(new GridLayout());
		btnPanel.add(yesBtn);
		btnPanel.add(noBtn);
		
		add(message);
		add(btnPanel, BorderLayout.SOUTH);
		
		setTitle("Tic Tac Toe");
		setSize(300, 200);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	private class Action implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == yesBtn){
				setVisible(false);
				new TicTacToeGUI();
			} else if(e.getSource() == noBtn){
				System.exit(0);
			}
		}
	}
}
