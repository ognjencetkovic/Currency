package ba.bitcamp.homework.task9;

import java.awt.BorderLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Task9 extends JFrame {

	private static final long serialVersionUID = -1987958333141206959L;

	private JTextField txtFilePath = new JTextField();
	private JTextArea txtFileContent = new JTextArea(); 
	private String filePath;
	
	public Task9() {
		setLayout(new BorderLayout());
		txtFilePath.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				super.keyPressed(e);
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					try {
						filePath = txtFilePath.getText();
						TextIO.readFile(filePath);
						String text = "";
						while (!TextIO.eof()) {
							text += TextIO.getln() + "\n";
						}
						txtFileContent.setText(text);
						//txtFileContent.setEnabled(false);
						add(txtFileContent, BorderLayout.CENTER);
						System.out.println(text);
						repaint();
					} catch (IllegalArgumentException ex) {
						JOptionPane.showMessageDialog(null, "No such file", "Error", JOptionPane.ERROR_MESSAGE);
					}
					
				}
			}
		});
		add(txtFilePath, BorderLayout.NORTH);
		
		setTitle("Task 9");
		setSize(400, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Task9();
	}
}
