package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class MainGUI extends JFrame {
	
	
	

	public static final Color UW_PURPLE = new Color(51, 0, 111);
	public static final Color UW_GOLD = new Color(232, 211, 162);
	public static final Color UW_METALIC_GOLD = new Color(145, 123, 76);
	public static final Color UW_LIGHT_GRAY = new Color(216, 217, 218);
	public static final Color UW_DART_GRAY = new Color(153, 153, 153);
	
    /**
     * A ToolKit.
     */
    private static final Toolkit KIT = Toolkit.getDefaultToolkit();

	/**
     * The Dimension of the screen.
     */
    private static final Dimension SCREEN_SIZE = KIT.getScreenSize();
	
	
	public static void main(String[] theArgs) {
		new MainGUI();
	}
	
	public MainGUI() {
		super("UWT IT Student Tracker - TCSS 360 GROUP 7");
		setBackground(Color.WHITE);
		
		crateComponents();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
		setSize(1248, 720);
        setLocation(SCREEN_SIZE.width / 2 - getWidth() / 2,
                (int) (SCREEN_SIZE.getHeight() / 4 - getHeight() / 4));
	}

	private void crateComponents() {
		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.setBackground(Color.WHITE);



		JComponent student = makeTextPanel("Student");
		tabbedPane.addTab("Student", student);

		JComponent program = makeTextPanel("Program");
		tabbedPane.addTab("Program", program);

		JComponent skill = makeTextPanel("Skill");
		tabbedPane.addTab("Skill", skill);
		
		JComponent employment = makeTextPanel("Employment");
		tabbedPane.addTab("Employment", employment);

		tabbedPane.setSize(500, 1350);
		
		// TODO- set tab design
//		tabbedPane.setUI((new BasicTabbedPaneUI() {
//			   @Override
//			   protected void installDefaults() {
//			       super.installDefaults();
//			       highlight = Color.pink;
//			       lightHighlight = Color.WHITE;
//			       shadow = Color.red;
//			       darkShadow = Color.cyan;
//			       focus = Color.yellow;
//			   }
//			}));
		
		
		
		// add all panels to the frame
		add(createLogoPanel(), BorderLayout.WEST);
		add(tabbedPane, BorderLayout.CENTER);
		
		
	}

	private JLabel createLogoPanel() {
		final JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);

		final JLabel logoLabel = new JLabel();
		logoLabel.setBackground(Color.WHITE);
		ImageIcon logo = null;
		try {
			logo = new ImageIcon(ImageIO.read(new File("image/logo.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		logoLabel.setIcon(logo);
		panel.add(logoLabel);
		
		return logoLabel;
	}
	
	private JComponent makeTextPanel(String type) {
		final JPanel panel = new JPanel();
		
		if (type.equalsIgnoreCase("Student")) {
			panel.add(new StudentGUI());
		}
//		 else if (type.equalsIgnoreCase("Program")) { TODO - after adding panels
//			panel.add(new DegreeGUI());
//		} else if (type.equalsIgnoreCase("Skill")) {
//			panel.add(new SkillGUI());
//		} else {
//			panel.add(new EmploymentGUL());
//		}
		
		return panel;

	}
	
	
	
	
	

}
