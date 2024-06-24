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

public class carGameHome extends JFrame 
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
					carGameHome frame = new carGameHome();
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
	public carGameHome() 
	{
		setTitle("Top Spec");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblStart = new JLabel("New label");
		lblStart.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent e) 
			{
				carGameDiffLevel diffLevel;
				diffLevel = new carGameDiffLevel();
				diffLevel.setVisible(true);
				diffLevel.setLocationRelativeTo(null);
				carGameHome.this.setVisible(false);
			}
		});
		
		JLabel lblLogo = new JLabel("New label");
		Image logoImage = new ImageIcon(this.getClass().getResource("/TopSpecLogo.png")).getImage();
		lblLogo.setIcon(new ImageIcon(logoImage));
		lblLogo.setBounds(203, 42, 375, 146);
		contentPane.add(lblLogo);

		Image startImage = new ImageIcon(this.getClass().getResource("/StartButton.png")).getImage();
		lblStart.setIcon(new ImageIcon(startImage));
		lblStart.setBounds(276, 228, 230, 54);
		contentPane.add(lblStart);
		
		JLabel lblBack = new JLabel("New label");
		Image backImage = new ImageIcon(this.getClass().getResource("/CarGameBack.png")).getImage();
		lblBack.setIcon(new ImageIcon(backImage));
		lblBack.setBounds(0, 0, 784, 511);
		contentPane.add(lblBack);
	}
}
