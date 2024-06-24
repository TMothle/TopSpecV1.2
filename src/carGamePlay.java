import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import java.sql.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class carGamePlay extends JFrame 
{
	String player = "";
	String comp = "";
	String imageNum = "";
	String carName;
	String queryOne;
	String category = "";
	String categoryTwo = "";
	String rep = "";
	String carNameTwo;
	String categoryThree = "";
	double playerScore = 0.0;
	double compScore = 0.0;
	
	Connection connection;
	Statement stmt;
	ResultSet rs;
	
	JLabel lblCarOne = new JLabel("");
	JLabel lblCarNameOne = new JLabel("Car Name");
	JComboBox cbxCategory = new JComboBox();
	JLabel lblCategoryOne = new JLabel("Category:");
	JLabel lblCategoryTwo = new JLabel("Category:");
	JLabel lblCarNameTwo = new JLabel("Car Name");
	JLabel lblCarTwo = new JLabel("");
	JLabel lblPlayerScore = new JLabel("0");
	JLabel lblCompScore = new JLabel("0");
	JLabel lblOKButton = new JLabel("New label");
	JLabel lblNextRound = new JLabel("New label");

	private JPanel contentPane;
	private final JLabel lblNewGame = new JLabel("New label");
	private final JLabel lblLogo = new JLabel("New label");

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
					carGamePlay frame = new carGamePlay();
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
	public carGamePlay() 
	{
		setTitle("Top Spec");
		addWindowListener(new WindowAdapter() 
		{
			public void windowOpened(WindowEvent e) 
			{
				player = "";
				
				try
				{
					Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
					connection = DriverManager.getConnection("jdbc:ucanaccess://Database//CarGame.accdb");
					System.out.println("Connection Successful");
				}
				catch(Exception d)
				{
					System.out.println("Connection Error");
				}
				
				for (int i = 1; i <= 10; i++)
				{
					int min = 1;
					int max = 20;
					int randomNoPlayer;
					int randomNoComp;
					
					randomNoPlayer = (int)Math.floor(Math.random() * (max - min + 1) + min);
					randomNoComp = (int)Math.floor(Math.random() * (max - min + 1) + min);
					player = player.concat("#" + Integer.toString(randomNoPlayer));
					comp = comp.concat("#" + Integer.toString(randomNoComp));
				}
				
				rep = player.concat("#");
				System.out.println(player);
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//JLabel lblOKButton = new JLabel("New label");
		lblOKButton.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent e) 
			{
				String chosenCat;
				String chosenCatVal;
				int min = 1;
				int max = 20;
				int randomNoComp;
				
				chosenCat = category;
				chosenCatVal = categoryTwo;
				
				randomNoComp = (int)Math.floor(Math.random() * (max - min + 1) + min);
				comp = Integer.toString(randomNoComp);
				
				if (carGame.diffLevel.equals("Easy"))
				{
					try
					{
						Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
						connection = DriverManager.getConnection("jdbc:ucanaccess://Database//CarGame.accdb");
						stmt = connection.createStatement();
						queryOne = "SELECT * FROM Specs WHERE ID = " + comp;
						rs = stmt.executeQuery(queryOne);
						if (rs.next())
						{
							carNameTwo = rs.getString(2);
							categoryThree = rs.getString(category);
						}
						connection.close();
					}
					catch(Exception d)
					{
						System.out.println("Connection Error");
					}
				}
				
				Image carTwoImage = new ImageIcon(this.getClass().getResource("/" + comp + ".jpg")).getImage();
				lblCarTwo.setIcon(new ImageIcon(carTwoImage));
				lblCarNameTwo.setText(carNameTwo);
				lblCategoryTwo.setText("Category: " + category + " " + categoryThree);
				
				if (Double.parseDouble(categoryTwo) > Double.parseDouble(categoryThree))
				{
					playerScore = playerScore + 1.0;
				}
				else
				{
					compScore = compScore + 1.0;
				}
				
				lblPlayerScore.setText(Double.toString(playerScore));
				lblCompScore.setText(Double.toString(compScore));
				
				lblOKButton.setBounds(lblOKButton.getX(), lblOKButton.getY() + 100, lblOKButton.getWidth(), lblOKButton.getHeight());
				lblNextRound.setBounds(lblNextRound.getX(), lblNextRound.getY() - 100, lblNextRound.getWidth(), lblNextRound.getHeight());
				
				if (lblPlayerScore.getText().equals("5.0"))
				{
					JOptionPane.showMessageDialog(null, "You Win!");
					lblNextRound.setBounds(lblNextRound.getX(), lblNextRound.getY() + 100, lblNextRound.getWidth(), lblNextRound.getHeight());
					lblNewGame.setBounds(lblNewGame.getX(), lblNewGame.getY() - 100, lblNewGame.getWidth(), lblNewGame.getHeight());
				}
				
				if (lblCompScore.getText().equals("5.0"))
				{
					JOptionPane.showMessageDialog(null, "Computer Wins!");
					lblNextRound.setBounds(lblNextRound.getX(), lblNextRound.getY() + 100, lblNextRound.getWidth(), lblNextRound.getHeight());
					lblNewGame.setBounds(lblNewGame.getX(), lblNewGame.getY() - 100, lblNewGame.getWidth(), lblNewGame.getHeight());
				}
			}
		});
		
		//JLabel lblNextRound = new JLabel("New label");
		lblNextRound.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) 
			{
				lblOKButton.setBounds(lblOKButton.getX(), lblOKButton.getY() - 100, lblOKButton.getWidth(), lblOKButton.getHeight());
				lblNextRound.setBounds(lblNextRound.getX(), lblNextRound.getY() + 100, lblNextRound.getWidth(), lblNextRound.getHeight());
				Image carOneImage = new ImageIcon(this.getClass().getResource("/Block.png")).getImage();
				lblCarOne.setIcon(new ImageIcon(carOneImage));
				Image carTwoImage = new ImageIcon(this.getClass().getResource("/Block.png")).getImage();
				lblCarTwo.setIcon(new ImageIcon(carTwoImage));
				lblCarNameOne.setText("Car Name");
				lblCarNameTwo.setText("Car Name");
				lblCategoryOne.setText("Category:");
				lblCategoryTwo.setText("Category:");
				cbxCategory.setSelectedIndex(0);
			}
		});
		lblNewGame.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) 
			{
				lblOKButton.setBounds(lblOKButton.getX(), lblOKButton.getY() - 100, lblOKButton.getWidth(), lblOKButton.getHeight());
				lblNextRound.setBounds(lblNextRound.getX(), lblNextRound.getY() + 100, lblNextRound.getWidth(), lblNextRound.getHeight());
				Image carOneImage = new ImageIcon(this.getClass().getResource("/Block.png")).getImage();
				lblCarOne.setIcon(new ImageIcon(carOneImage));
				Image carTwoImage = new ImageIcon(this.getClass().getResource("/Block.png")).getImage();
				lblCarTwo.setIcon(new ImageIcon(carTwoImage));
				lblCarNameOne.setText("Car Name");
				lblCarNameTwo.setText("Car Name");
				lblCategoryOne.setText("Category:");
				lblCategoryTwo.setText("Category:");
				cbxCategory.setSelectedIndex(0);
				lblPlayerScore.setText("0.0");
				lblCompScore.setText("0.0");
			}
		});
		Image logoImage = new ImageIcon(this.getClass().getResource("/TopSpecLogo2.png")).getImage();
		lblLogo.setIcon(new ImageIcon(logoImage));
		lblLogo.setBounds(351, 24, 84, 40);
		contentPane.add(lblLogo);
		
		Image newGameImage = new ImageIcon(this.getClass().getResource("/NewGameButton.png")).getImage();
		lblNewGame.setIcon(new ImageIcon(newGameImage));
		lblNewGame.setBounds(512, 531, 140, 34);
		contentPane.add(lblNewGame);
		
		Image nextRoundImage = new ImageIcon(this.getClass().getResource("/NextRoundButton.png")).getImage();
		lblNextRound.setIcon(new ImageIcon(nextRoundImage));
		lblNextRound.setBounds(322, 531, 140, 34);
		contentPane.add(lblNextRound);
		
		//JLabel lblCompScore = new JLabel("0");
		lblCompScore.setHorizontalAlignment(SwingConstants.TRAILING);
		lblCompScore.setForeground(Color.WHITE);
		lblCompScore.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCompScore.setBounds(662, 67, 50, 22);
		contentPane.add(lblCompScore);
		
		//JLabel lblPlayerScore = new JLabel("0");
		lblPlayerScore.setForeground(Color.WHITE);
		lblPlayerScore.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPlayerScore.setBounds(74, 67, 50, 22);
		contentPane.add(lblPlayerScore);
		
		Image okImage = new ImageIcon(this.getClass().getResource("/OKButton.png")).getImage();
		lblOKButton.setIcon(new ImageIcon(okImage));
		lblOKButton.setBounds(135, 431, 140, 34);
		contentPane.add(lblOKButton);
		
		JLabel lblForwardArrow = new JLabel("New label");
		lblForwardArrow.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent e) 
			{
				if (cbxCategory.getSelectedIndex() == 0)
				{
					JOptionPane.showMessageDialog(null, "Pick a Category.");
				}
				else
				{
					if (rep.length() == 1)
					{
						rep = player.concat("#");
					}
				
					rep = rep.replaceFirst("#", "");
					imageNum = String.copyValueOf(rep.toCharArray(), 0, rep.indexOf("#"));
					rep = rep.replace(imageNum, "");
					
					Image carOneImage = new ImageIcon(this.getClass().getResource("/" + imageNum + ".jpg")).getImage();
					lblCarOne.setIcon(new ImageIcon(carOneImage));
				
					try
					{
						Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
						connection = DriverManager.getConnection("jdbc:ucanaccess://Database//CarGame.accdb");
						stmt = connection.createStatement();
						queryOne = "SELECT * FROM Specs WHERE ID = " + imageNum;
						rs = stmt.executeQuery(queryOne);
						if (rs.next())
						{
							carName = rs.getString(2);
							categoryTwo = rs.getString(category);
						}
						connection.close();
					}
					catch(Exception d)
					{
						System.out.println("Connection Error");
					}
				
					lblCarNameOne.setText(carName);	
					lblCategoryOne.setText("Category: " + category + " " + categoryTwo);
				}
			}
		});
		Image fArrowImage = new ImageIcon(this.getClass().getResource("/ForwardArrow.png")).getImage();
		lblForwardArrow.setIcon(new ImageIcon(fArrowImage));
		lblForwardArrow.setBounds(178, 376, 58, 40);
		contentPane.add(lblForwardArrow);
		
		//JLabel lblCategoryTwo = new JLabel("Category:");
		lblCategoryTwo.setHorizontalAlignment(SwingConstants.CENTER);
		lblCategoryTwo.setForeground(Color.WHITE);
		lblCategoryTwo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCategoryTwo.setBounds(446, 281, 266, 22);
		contentPane.add(lblCategoryTwo);
		
		//JLabel lblCategoryOne = new JLabel("Category:");
		lblCategoryOne.setForeground(Color.WHITE);
		lblCategoryOne.setHorizontalAlignment(SwingConstants.CENTER);
		lblCategoryOne.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCategoryOne.setBounds(74, 281, 266, 22);
		contentPane.add(lblCategoryOne);
		
		//JComboBox cbxCategory = new JComboBox();
		cbxCategory.addItemListener(new ItemListener() 
		{
			public void itemStateChanged(ItemEvent e) 
			{
				int selectedCat;
				
				selectedCat = cbxCategory.getSelectedIndex();
				
				switch (selectedCat)
				{
					case 0:
						category = "";
						break;
					case 1:
						category = "Engine(L)";
						break;
					case 2:
						category = "HP(hp)";
						break;
					case 3:
						category = "0-100(km/h)";
						break;
					case 4:
						category = "Weight(kg)";
						break;
					case 5:
						category = "Torque(Nm)";
						break;
					case 6:
						category = "Power(kW)";
						break;
					case 7:
						category = "Top Speed(km/h)";
						break;
					case 8:
						category = "Cylinders";
						break;
					default: 
						category = "";
				}
			}
		});
		cbxCategory.setModel(new DefaultComboBoxModel(new String[] {"Pick a Category", "Engine(L)", "HP(hp)", "0-100(km/h)", "Weight(kg)", "Torque(Nm)", "Power(kW)", "Top Speed(km/h)", "Cylinders"}));
		cbxCategory.setSelectedIndex(0);
		cbxCategory.setToolTipText("");
		cbxCategory.setBounds(307, 328, 169, 22);
		contentPane.add(cbxCategory);
		
		//JLabel lblCarNameTwo = new JLabel("Car Name");
		lblCarNameTwo.setHorizontalAlignment(SwingConstants.CENTER);
		lblCarNameTwo.setForeground(Color.WHITE);
		lblCarNameTwo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCarNameTwo.setBounds(446, 248, 266, 22);
		contentPane.add(lblCarNameTwo);
		
		//JLabel lblCarNameOne = new JLabel("Car Name");
		lblCarNameOne.setHorizontalAlignment(SwingConstants.CENTER);
		lblCarNameOne.setForeground(new Color(255, 255, 255));
		lblCarNameOne.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCarNameOne.setBounds(74, 248, 266, 22);
		contentPane.add(lblCarNameOne);
		lblCarTwo.setHorizontalAlignment(SwingConstants.CENTER);
		
		//JLabel lblCarTwo = new JLabel("New label");
		Image carTwoImage = new ImageIcon(this.getClass().getResource("/Block.png")).getImage();
		lblCarTwo.setIcon(new ImageIcon(carTwoImage));
		lblCarTwo.setBounds(446, 100, 266, 140);
		contentPane.add(lblCarTwo);
		lblCarOne.setHorizontalAlignment(SwingConstants.CENTER);
		
		//JLabel lblCarOne = new JLabel("New label");
		Image carOneImage = new ImageIcon(this.getClass().getResource("/Block.png")).getImage();
		lblCarOne.setIcon(new ImageIcon(carOneImage));
		lblCarOne.setBounds(74, 100, 266, 140);
		contentPane.add(lblCarOne);
		
		JLabel lblBack = new JLabel("New label");
		Image backImage = new ImageIcon(this.getClass().getResource("/CarGameBack.png")).getImage();
		lblBack.setIcon(new ImageIcon(backImage));
		lblBack.setBounds(0, 0, 784, 511);
		contentPane.add(lblBack);
	}
}
