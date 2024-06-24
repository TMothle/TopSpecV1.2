import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class carGameDiffLevel extends JFrame 
{
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					carGameDiffLevel frame = new carGameDiffLevel();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public carGameDiffLevel() 
	{
		setTitle("Top Spec");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHard = new JLabel("New label");
		lblHard.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent e) 
			{
				carGamePlay gamePlay;
				gamePlay = new carGamePlay();
				gamePlay.setVisible(true);
				gamePlay.setLocationRelativeTo(null);
				carGameDiffLevel.this.setVisible(false);
				carGame.diffLevel = "Hard";
			}
		});
		
		JLabel lblLogo = new JLabel("New label");
		Image logoImage = new ImageIcon(this.getClass().getResource("/TopSpecLogo.png")).getImage();
		lblLogo.setIcon(new ImageIcon(logoImage));
		lblLogo.setBounds(203, 42, 375, 146);
		contentPane.add(lblLogo);

		Image hardImage = new ImageIcon(this.getClass().getResource("/HardButton.png")).getImage();
		lblHard.setIcon(new ImageIcon(hardImage));
		lblHard.setBounds(554, 238, 140, 34);
		contentPane.add(lblHard);
		
		JLabel lblMedium = new JLabel("New label");
		lblMedium.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent e) 
			{
				carGamePlay gamePlay;
				gamePlay = new carGamePlay();
				gamePlay.setVisible(true);
				gamePlay.setLocationRelativeTo(null);
				carGameDiffLevel.this.setVisible(false);
				carGame.diffLevel = "Medium";
			}
		});
		Image mediumImage = new ImageIcon(this.getClass().getResource("/MediumButton.png")).getImage();
		lblMedium.setIcon(new ImageIcon(mediumImage));
		lblMedium.setBounds(320, 238, 140, 34);
		contentPane.add(lblMedium);
		
		JLabel lblEasy = new JLabel("New label");
		lblEasy.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent e) 
			{
				carGamePlay gamePlay;
				gamePlay = new carGamePlay();
				gamePlay.setVisible(true);
				gamePlay.setLocationRelativeTo(null);
				carGameDiffLevel.this.setVisible(false);
				carGame.diffLevel = "Easy";
			}
		});
		Image easyImage = new ImageIcon(this.getClass().getResource("/EasyButton.png")).getImage();
		lblEasy.setIcon(new ImageIcon(easyImage));
		lblEasy.setBounds(96, 238, 140, 34);
		contentPane.add(lblEasy);
		
		JLabel lblBack = new JLabel("New label");
		Image backImage = new ImageIcon(this.getClass().getResource("/CarGameBack.png")).getImage();
		lblBack.setIcon(new ImageIcon(backImage));
		lblBack.setBounds(0, 0, 784, 511);
		contentPane.add(lblBack);
	}

}
