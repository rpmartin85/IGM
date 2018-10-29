package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;

import logical.Highlight;

import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class IGM_Highlight {

	private JFrame frmHighlightAnnovarFiles;
	private JTextField txtFolder;
	private JFileChooser fc1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IGM_Highlight window = new IGM_Highlight();
					window.frmHighlightAnnovarFiles.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public IGM_Highlight() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHighlightAnnovarFiles = new JFrame();
		frmHighlightAnnovarFiles.setTitle("Highlight Annovar Files");
		frmHighlightAnnovarFiles.setBounds(100, 100, 450, 183);
		frmHighlightAnnovarFiles.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHighlightAnnovarFiles.getContentPane().setLayout(null);
		
		fc1 = new JFileChooser();

		fc1.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		
		JButton button = new JButton("+");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int returnVal = fc1.showOpenDialog(frmHighlightAnnovarFiles);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File file = fc1.getSelectedFile();

					txtFolder.setText(file.getAbsolutePath());

				} else {
					System.out.println("Calcelled by user.");

				}
				
				
				
				
				
			}
		});
		button.setBounds(373, 37, 62, 29);
		frmHighlightAnnovarFiles.getContentPane().add(button);
		
		txtFolder = new JTextField();
		txtFolder.setColumns(10);
		txtFolder.setBounds(94, 37, 267, 26);
		frmHighlightAnnovarFiles.getContentPane().add(txtFolder);
		
		JLabel lblFolder = new JLabel("Folder:");
		lblFolder.setBounds(20, 42, 86, 16);
		frmHighlightAnnovarFiles.getContentPane().add(lblFolder);
		
		JButton btnRun = new JButton("Run");
		btnRun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.out.println(txtFolder.getText());
				
				Highlight.doIt(txtFolder.getText());
				
				frmHighlightAnnovarFiles.dispose();
				
				
			}
		});
		btnRun.setBounds(70, 87, 122, 29);
		frmHighlightAnnovarFiles.getContentPane().add(btnRun);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frmHighlightAnnovarFiles.dispose();
				
				
			}
		});
		btnCancel.setBounds(254, 87, 122, 29);
		frmHighlightAnnovarFiles.getContentPane().add(btnCancel);
	}
}
