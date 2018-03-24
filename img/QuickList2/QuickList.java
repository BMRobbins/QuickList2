package QuickList2;
import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;

public class QuickList {

	private JFrame frame;
	private JPanel RecipeChoice_Panel;
	private JPanel WeeklyItems_Panel;
	private JPanel CheckOut_Panel;
	private JTextArea Cart_TextField;
	private JPanel RecipeList_Panel;
	private JPanel WeeklyItems_chckBx_Panel;
	private Image img;
	private RecipeList RecipeChoices;
	private RecipeList UserChoices;
	private ItemCart itemCart;
	private JTextArea Items_TextField;
	private JTextArea Recipe_TextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuickList window = new QuickList();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public QuickList() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setup_Frame();
		setup_BackEndVaribles();
		setup_MainPanels();
		build_RecipeChoicePanel();
		build_WeeklyItemsPanel();
		build_CheckOutPanel();

	}
	private void setup_Frame()
	{
		frame = new JFrame();
		frame.setBounds(0, 0, 3000, 2000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
	}
	
	private void setup_BackEndVaribles()
	{
		RecipeChoices = new RecipeList();
		UserChoices = new RecipeList();
		AddRecipesToRecipeChoices();
	}
	
	private void AddRecipesToRecipeChoices()
	{
		RecipeChoices.addRecipe(new Recipe("Quinoa Tacos", "QuinoaTacos.JPG"));
		RecipeChoices.getRecipe(0).addItem(new Item("Quinoa", "Sprouts", 1));
		RecipeChoices.getRecipe(0).addItem(new Item("Salsa", "Sprouts", 1));
		RecipeChoices.getRecipe(0).addItem(new Item("Vegetable Broth", "Sprouts", 1));
		RecipeChoices.getRecipe(0).addItem(new Item("Tortilla", "Sprouts", 1));
		RecipeChoices.getRecipe(0).addItem(new Item("Tomato", "Sprouts", 1));
		RecipeChoices.getRecipe(0).addItem(new Item("Avacado", "Sprouts", 1));
		
		RecipeChoices.addRecipe(new Recipe("Spinach Pasta", "SpinachPasta.JPG"));
		RecipeChoices.getRecipe(1).addItem(new Item("Spagetti Pasta", "Costco", 1));
		RecipeChoices.getRecipe(1).addItem(new Item("Almonds", "Costco", 1));
		RecipeChoices.getRecipe(1).addItem(new Item("Garlic", "Sprouts", 1));
		RecipeChoices.getRecipe(1).addItem(new Item("Tomato", "Sprouts", 1));
		RecipeChoices.getRecipe(1).addItem(new Item("Spinach", "Sprouts", 1));

		RecipeChoices.addRecipe(new Recipe("Buffalo Cawliflower Tacos", "BuffaloCawliflowerTacos.jpg"));
		RecipeChoices.getRecipe(2).addItem(new Item("Cawliflower", "Sprouts", 1));
		RecipeChoices.getRecipe(2).addItem(new Item("Buffalo Sauce", "Target", 1));
		RecipeChoices.getRecipe(2).addItem(new Item("Tortilla", "Sprouts", 1));
		RecipeChoices.getRecipe(2).addItem(new Item("Avacado", "Sprouts", 1));
		RecipeChoices.getRecipe(2).addItem(new Item("Cilantro", "Sprouts", 1));

		RecipeChoices.addRecipe(new Recipe("Minestrone Soup", "MinestroneSoup.JPG"));
		RecipeChoices.getRecipe(3).addItem(new Item("Vegetable Broth", "Sprouts", 1));
		RecipeChoices.getRecipe(3).addItem(new Item("Red Potatos", "Sprouts", 4));
		RecipeChoices.getRecipe(3).addItem(new Item("Carrots", "Sprouts", 1));
		RecipeChoices.getRecipe(3).addItem(new Item("Asparugus", "Sprouts", 1));
		RecipeChoices.getRecipe(3).addItem(new Item("Navy Beans", "Sprouts", 1));
		RecipeChoices.getRecipe(3).addItem(new Item("Garlic", "Sprouts", 1));
		RecipeChoices.getRecipe(3).addItem(new Item("Lemon", "Sprouts", 1));
		
		RecipeChoices.addRecipe(new Recipe("Chile", "Chile.JPG"));
		RecipeChoices.getRecipe(4).addItem(new Item("Carrots", "Sprouts", 1));
		RecipeChoices.getRecipe(4).addItem(new Item("Vegetable Broth", "Sprouts", 1));
		RecipeChoices.getRecipe(4).addItem(new Item("Red BellPepper", "Sprouts", 1));
		RecipeChoices.getRecipe(4).addItem(new Item("Corn", "Sprouts", 1));
		RecipeChoices.getRecipe(4).addItem(new Item("Crushed Tomatoes", "Sprouts", 1));
		RecipeChoices.getRecipe(4).addItem(new Item("Garlic", "Sprouts", 1));
		RecipeChoices.getRecipe(4).addItem(new Item("Black Beans", "Sprouts", 1));

		RecipeChoices.addRecipe(new Recipe("Tortilla Bake", "TortillaBake.JPG"));
		RecipeChoices.getRecipe(5).addItem(new Item("Cashews", "Costco", 1));
		RecipeChoices.getRecipe(5).addItem(new Item("Vegetable Broth", "Sprouts", 1));
		RecipeChoices.getRecipe(5).addItem(new Item("Salsa", "Sprouts", 1));
		RecipeChoices.getRecipe(5).addItem(new Item("Corn", "Sprouts", 1));
		RecipeChoices.getRecipe(5).addItem(new Item("Black Beans", "Sprouts", 1));
		RecipeChoices.getRecipe(5).addItem(new Item("Tortillas", "Sprouts", 1));
		
		RecipeChoices.addRecipe(new Recipe("Black Bean Soup", "BlackBeanSoup.JPG"));
		RecipeChoices.getRecipe(6).addItem(new Item("Cilantro", "Sprouts", 1));
		RecipeChoices.getRecipe(6).addItem(new Item("Vegetable Broth", "Sprouts", 1));
		RecipeChoices.getRecipe(6).addItem(new Item("Carrots", "Sprouts", 1));
		RecipeChoices.getRecipe(6).addItem(new Item("Corn", "Sprouts", 1));
		RecipeChoices.getRecipe(6).addItem(new Item("Black Beans", "Sprouts", 1));
		RecipeChoices.getRecipe(6).addItem(new Item("Garlic", "Sprouts", 1));
		RecipeChoices.getRecipe(6).addItem(new Item("Celery", "Sprouts", 1));
		RecipeChoices.getRecipe(6).addItem(new Item("Tomato Sauce", "Sprouts", 1));
		RecipeChoices.getRecipe(6).addItem(new Item("Lemon", "Sprouts", 1));
		
		RecipeChoices.addRecipe(new Recipe("Two Bean Soup", "TwoBeanSoup.JPG"));
		RecipeChoices.getRecipe(7).addItem(new Item("Green BellPepper", "Sprouts", 1));
		RecipeChoices.getRecipe(7).addItem(new Item("Vegetable Broth", "Sprouts", 1));
		RecipeChoices.getRecipe(7).addItem(new Item("Corn", "Sprouts", 1));
		RecipeChoices.getRecipe(7).addItem(new Item("Navy Beans", "Sprouts", 1));
		RecipeChoices.getRecipe(7).addItem(new Item("Kidney Beans", "Sprouts", 1));
		RecipeChoices.getRecipe(7).addItem(new Item("Garlic", "Sprouts", 1));

	}
	
	private void setup_MainPanels()
	{
	        //  RecipeChoice_Panel
			RecipeChoice_Panel = new JPanel();
			RecipeChoice_Panel.setBackground(Color.WHITE);
			frame.getContentPane().add(RecipeChoice_Panel, "name_712472442621413");
			RecipeChoice_Panel.setVisible(true);
			
			// WeeklyItems_Panel
			WeeklyItems_Panel = new JPanel();
			WeeklyItems_Panel.setBackground(Color.WHITE);
			frame.getContentPane().add(WeeklyItems_Panel, "name_712476193991331");
			
			// CheckOut_Panel
			CheckOut_Panel = new JPanel();
			CheckOut_Panel.setBackground(Color.WHITE);
			frame.getContentPane().add(CheckOut_Panel, "name_712522448426551");
			CheckOut_Panel.setLayout(null);
	}
	
	private void build_RecipeChoicePanel()
	{
		build_RecipeChoicePanelOutline();
		AddFoodImages();
		AddRecipeLabels();
		AddRecipeButtons();
	}
	
	private void build_RecipeChoicePanelOutline()
	{
		// RecipeChoice items
		JLabel RCLogo_label = new JLabel("");
		RCLogo_label.setBounds(700, 28, 1422, 280);
		img = new ImageIcon(this.getClass().getResource("/QuickListLogo.png")).getImage();
		RecipeChoice_Panel.setLayout(null);
		RCLogo_label.setIcon(new ImageIcon(img));
		RecipeChoice_Panel.add(RCLogo_label);
		
		JLabel Recipe_Label = new JLabel("RECIPES");
		Recipe_Label.setBounds(79, 361, 344, 130);
		Recipe_Label.setFont(new Font("Tahoma", Font.PLAIN, 70));
		RecipeChoice_Panel.add(Recipe_Label);
		
		JLabel Cart_Label = new JLabel("CART");
		Cart_Label.setBounds(2414, 361, 344, 130);
		Cart_Label.setFont(new Font("Tahoma", Font.PLAIN, 70));
		RecipeChoice_Panel.add(Cart_Label);
		
		JButton btnNewButton = new JButton("NEXT ->");
		btnNewButton.setBounds(2377, 1622, 300, 130);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				WeeklyItems_Panel.setVisible(true);
				RecipeChoice_Panel.setVisible(false);
				updateItemCart();
			}
		});
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(0, 153, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 70));
		RecipeChoice_Panel.add(btnNewButton);
		
		RecipeList_Panel = new JPanel();
		RecipeList_Panel.setBounds(89, 500, 2033, 1007);
		RecipeChoice_Panel.add(RecipeList_Panel);
		RecipeList_Panel.setLayout(null);
		
		Cart_TextField = new JTextArea();
		Cart_TextField.setFont(new Font("Tahoma", Font.PLAIN, 40));
		Cart_TextField.setBackground(new Color(240,240,240));
		Cart_TextField.setBounds(2180, 500, 706, 1007);
		RecipeChoice_Panel.add(Cart_TextField);
	}
	
	private void updateItemCart()
	{
		itemCart = new ItemCart();
		for(int i=0; i < UserChoices.size(); i++)
		{
			for(int j= 0; j < UserChoices.getRecipe(i).size();j++)
			{
				if(itemCart.contains(UserChoices.getRecipe(i).getItem(j)))
				{}
				else
				{
					itemCart.addItem(UserChoices.getRecipe(i).getItem(j));
				}
				
			}
		}
	}
	
	private void AddFoodImages()
	{
		JLabel BlackBeanSoupImage = new JLabel("");
		BlackBeanSoupImage.setBounds(0, 25, 300, 200);
		Image img1 = new ImageIcon(this.getClass().getResource("/BlackBeanSoupThumb.jpg")).getImage();
		BlackBeanSoupImage.setIcon(new ImageIcon(img1));
		RecipeList_Panel.add(BlackBeanSoupImage);
		
		JLabel BuffaloCawlifowerTacosImage = new JLabel("");
		BuffaloCawlifowerTacosImage.setBounds(0, 275, 300, 200);
		Image img2 = new ImageIcon(this.getClass().getResource("/BuffaloCawliflowerTacosThumb.jpg")).getImage();
		BuffaloCawlifowerTacosImage.setIcon(new ImageIcon(img2));
		RecipeList_Panel.add(BuffaloCawlifowerTacosImage);
		
		JLabel ChileImage = new JLabel("");
		ChileImage.setBounds(0, 525, 300, 200);
		Image img3 = new ImageIcon(this.getClass().getResource("/ChileThumb.jpg")).getImage();
		ChileImage.setIcon(new ImageIcon(img3));
		RecipeList_Panel.add(ChileImage);
		
		JLabel MinestroneSoupImage = new JLabel("");
		MinestroneSoupImage.setBounds(0, 775, 300, 200);
		Image img4 = new ImageIcon(this.getClass().getResource("/MinestroneSoupThumb.jpg")).getImage();
		MinestroneSoupImage.setIcon(new ImageIcon(img4));
		RecipeList_Panel.add(MinestroneSoupImage);
		
		JLabel QuinoaTacosImage = new JLabel("");
		QuinoaTacosImage.setBounds(750, 25, 300, 200);
		Image img5 = new ImageIcon(this.getClass().getResource("/QuinoaTacosThumbs.jpg")).getImage();
		QuinoaTacosImage.setIcon(new ImageIcon(img5));
		RecipeList_Panel.add(QuinoaTacosImage);
		
		JLabel SpinachPastaImage = new JLabel("");
		SpinachPastaImage.setBounds(750, 275, 300, 200);
		Image img6 = new ImageIcon(this.getClass().getResource("/SpinachPastaThumb.jpg")).getImage();
		SpinachPastaImage.setIcon(new ImageIcon(img6));
		RecipeList_Panel.add(SpinachPastaImage);
		
		JLabel TortillaBakeImage = new JLabel("");
		TortillaBakeImage .setBounds(750, 525, 300, 200);
		Image img7 = new ImageIcon(this.getClass().getResource("/TortillaBakeThumb.jpg")).getImage();
		TortillaBakeImage .setIcon(new ImageIcon(img7));
		RecipeList_Panel.add(TortillaBakeImage );
		
		JLabel TwoBeanSoupImage = new JLabel("");
		TwoBeanSoupImage.setBounds(750, 775, 300, 200);
		Image img8 = new ImageIcon(this.getClass().getResource("/TwoBeanSoupThumb.jpg")).getImage();
		TwoBeanSoupImage.setIcon(new ImageIcon(img8));
		RecipeList_Panel.add(TwoBeanSoupImage);
	}

	
	private void AddRecipeLabels()
	{
		JLabel lblNewLabel = new JLabel("Black Bean Soup");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(346, 38, 300, 90);
		RecipeList_Panel.add(lblNewLabel);
		
		JLabel lblBuffaloCawliflowerTacos = new JLabel("Buffalo Cawliflower Tacos");
		lblBuffaloCawliflowerTacos.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblBuffaloCawliflowerTacos.setBounds(350, 295, 346, 90);
		RecipeList_Panel.add(lblBuffaloCawliflowerTacos);
		
		JLabel lblChile = new JLabel("Chile");
		lblChile.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblChile.setBounds(346, 537, 300, 90);
		RecipeList_Panel.add(lblChile);
		
		JLabel lblMinestroneSoup = new JLabel("Minestrone Soup");
		lblMinestroneSoup.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblMinestroneSoup.setBounds(346, 788, 300, 90);
		RecipeList_Panel.add(lblMinestroneSoup);
		
		JLabel lblQuinoaTacos = new JLabel("Quinoa Tacos");
		lblQuinoaTacos.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblQuinoaTacos.setBounds(1100, 38, 300, 90);
		RecipeList_Panel.add(lblQuinoaTacos);
		
		JLabel lblSpinachPasta = new JLabel("Spinach Pasta");
		lblSpinachPasta.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblSpinachPasta.setBounds(1100, 295, 346, 90);
		RecipeList_Panel.add(lblSpinachPasta);
		
		JLabel lblTortillaBake = new JLabel("Tortilla Bake");
		lblTortillaBake.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblTortillaBake.setBounds(1100, 537, 300, 90);
		RecipeList_Panel.add(lblTortillaBake);
		
		JLabel lblTwoBeanSoup = new JLabel("Two Bean Soup");
		lblTwoBeanSoup.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblTwoBeanSoup.setBounds(1100, 788, 300, 90);
		RecipeList_Panel.add(lblTwoBeanSoup);
	
	}
	
	private void AddRecipeButtons()
	{
		// Black Bean Soup
		JButton button_1 = new JButton("ADD");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserChoices.addRecipe(RecipeChoices.getRecipe(6));
				updateCart();
			}
		});
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		button_1.setBackground(new Color(0, 128, 0));
		button_1.setBounds(346, 127, 171, 41);
		RecipeList_Panel.add(button_1);
		
		JButton button_2 = new JButton("REMOVE");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserChoices.removeRecipe("Black Bean Soup");
				updateCart();
			}
		});
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		button_2.setBackground(Color.RED);
		button_2.setBounds(543, 127, 171, 41);
		RecipeList_Panel.add(button_2);
		
		// Buffalo Cawliflower Tacos
		JButton button_3 = new JButton("ADD");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserChoices.addRecipe(RecipeChoices.getRecipe(2));
				updateCart();
			}
		});
		button_3.setFont(new Font("Tahoma", Font.PLAIN, 30));
		button_3.setBackground(new Color(0, 128, 0));
		button_3.setBounds(346, 379, 171, 41);
		RecipeList_Panel.add(button_3);
		
		JButton button_4 = new JButton("REMOVE");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserChoices.removeRecipe("Buffalo Cawliflower Tacos");
				updateCart();
			}
		});
		button_4.setFont(new Font("Tahoma", Font.PLAIN, 30));
		button_4.setBackground(new Color(255, 0, 0));
		button_4.setBounds(543, 379, 171, 41);
		RecipeList_Panel.add(button_4);
		
		//Chile 
		JButton button_5 = new JButton("ADD");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserChoices.addRecipe(RecipeChoices.getRecipe(4));
				updateCart();
			}
		});
		button_5.setFont(new Font("Tahoma", Font.PLAIN, 30));
		button_5.setBackground(new Color(0, 128, 0));
		button_5.setBounds(346, 624, 171, 41);
		RecipeList_Panel.add(button_5);
		
		JButton button_6 = new JButton("REMOVE");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserChoices.removeRecipe("Chile");
				updateCart();
			}
		});
		button_6.setFont(new Font("Tahoma", Font.PLAIN, 30));
		button_6.setBackground(Color.RED);
		button_6.setBounds(543, 624, 171, 41);
		RecipeList_Panel.add(button_6);
		
		// MineStrone Soup
		
		JButton button_7 = new JButton("ADD");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserChoices.addRecipe(RecipeChoices.getRecipe(3));
				updateCart();
			}
		});
		button_7.setFont(new Font("Tahoma", Font.PLAIN, 30));
		button_7.setBackground(new Color(0, 128, 0));
		button_7.setBounds(346, 873, 171, 41);
		RecipeList_Panel.add(button_7);
		
		JButton button_8 = new JButton("REMOVE");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserChoices.removeRecipe("Minestrone Soup");
				updateCart();
			}
		});
		button_8.setFont(new Font("Tahoma", Font.PLAIN, 30));
		button_8.setBackground(Color.RED);
		button_8.setBounds(553, 873, 171, 41);
		RecipeList_Panel.add(button_8);
		
		// Quinoa Tacos
		JButton button_9 = new JButton("ADD");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserChoices.addRecipe(RecipeChoices.getRecipe(0));
				updateCart();
			}
		});
		button_9.setFont(new Font("Tahoma", Font.PLAIN, 30));
		button_9.setBackground(new Color(0, 128, 0));
		button_9.setBounds(1100, 127, 171, 41);
		RecipeList_Panel.add(button_9);
		
		JButton button_10 = new JButton("REMOVE");
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserChoices.removeRecipe("Quinoa Tacos");
				updateCart();
			}
		});
		button_10.setFont(new Font("Tahoma", Font.PLAIN, 30));
		button_10.setBackground(Color.RED);
		button_10.setBounds(1300, 127, 171, 41);
		RecipeList_Panel.add(button_10);
		
		// Spinach Pasta
		JButton button_11 = new JButton("ADD");
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserChoices.addRecipe(RecipeChoices.getRecipe(1));
				updateCart();
			}
		});
		button_11.setFont(new Font("Tahoma", Font.PLAIN, 30));
		button_11.setBackground(new Color(0, 128, 0));
		button_11.setBounds(1100, 375, 171, 41);
		RecipeList_Panel.add(button_11);
		
		JButton button_12 = new JButton("REMOVE");
		button_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserChoices.removeRecipe("Spinach Pasta");
				updateCart();
			}
		});
		button_12.setFont(new Font("Tahoma", Font.PLAIN, 30));
		button_12.setBackground(Color.RED);
		button_12.setBounds(1300, 375, 171, 41);
		RecipeList_Panel.add(button_12);
		
		// Tortilla Bake
		JButton button_13 = new JButton("ADD");
		button_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserChoices.addRecipe(RecipeChoices.getRecipe(5));
				updateCart();
			}
		});
		button_13.setFont(new Font("Tahoma", Font.PLAIN, 30));
		button_13.setBackground(new Color(0, 128, 0));
		button_13.setBounds(1100, 624, 171, 41);
		RecipeList_Panel.add(button_13);
		
		JButton button_14 = new JButton("REMOVE");
		button_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserChoices.removeRecipe("Tortilla Bake");
				updateCart();
			}
		});
		button_14.setFont(new Font("Tahoma", Font.PLAIN, 30));
		button_14.setBackground(Color.RED);
		button_14.setBounds(1300, 624, 171, 41);
		RecipeList_Panel.add(button_14);
		
		//Two Bean Soup
		JButton button_15 = new JButton("ADD");
		button_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserChoices.addRecipe(RecipeChoices.getRecipe(7));
				updateCart();
			}
		});
		button_15.setFont(new Font("Tahoma", Font.PLAIN, 30));
		button_15.setBackground(new Color(0, 128, 0));
		button_15.setBounds(1100, 873, 171, 41);
		RecipeList_Panel.add(button_15);
		
		
		JButton button_16= new JButton("REMOVE");
		button_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserChoices.removeRecipe("Two Bean Soup");
				updateCart();
			}
		});
		button_16.setFont(new Font("Tahoma", Font.PLAIN, 30));
		button_16.setBackground(Color.RED);
		button_16.setBounds(1300, 873, 171, 41);
		RecipeList_Panel.add(button_16);
	}
	private void updateCart()
	{
		String FormattedString = new String("\r\n");
		for(int i = 0; i < UserChoices.size(); i++)
		{
			FormattedString += "    " + UserChoices.getRecipe(i).getName() + "\r\n\r\n";
		}
		Cart_TextField.setText(FormattedString);
	}
	private void build_WeeklyItemsPanel()
	{
		build_WeeklyItemsPanelOutline();
		AddWeeklyItemsCheckBoxes();

		
		
	}
	private void build_WeeklyItemsPanelOutline()
	{
		WeeklyItems_Panel.setLayout(null);
		
		
		// WeeklyItems_Panel items
		
		JLabel WILogo_label = new JLabel("");
		WILogo_label.setBounds(700, 28, 1422, 280);
		WILogo_label.setIcon(new ImageIcon(img));
		WeeklyItems_Panel.add(WILogo_label);
		
		JLabel WeeklyItems_Label = new JLabel("Weekly Items");
		WeeklyItems_Label.setBounds(139, 377, 469, 130);
		WeeklyItems_Label.setFont(new Font("Tahoma", Font.PLAIN, 70));
		WeeklyItems_Panel.add(WeeklyItems_Label);
		
		
		
		WeeklyItems_chckBx_Panel = new JPanel();
		WeeklyItems_chckBx_Panel.setBounds(125, 521, 2712, 928);
		WeeklyItems_Panel.add(WeeklyItems_chckBx_Panel);
		WeeklyItems_chckBx_Panel.setLayout(null);
	}
	
	private void AddWeeklyItemsCheckBoxes()
	{
				
		JCheckBox CKBX_1 = new JCheckBox("Mixed Nuts");
		CKBX_1.setFont(new Font("Tahoma", Font.PLAIN, 40));
		CKBX_1.setBounds(22, 72, 540, 85);
		WeeklyItems_chckBx_Panel.add(CKBX_1);
		
		JCheckBox CKBX_2 = new JCheckBox("Cashews");
		CKBX_2.setFont(new Font("Tahoma", Font.PLAIN, 40));
		CKBX_2.setBounds(22, 252, 540, 85);
		WeeklyItems_chckBx_Panel.add(CKBX_2);
		
		JCheckBox CKBX_3 = new JCheckBox("Vegtable Tray");
		CKBX_3.setFont(new Font("Tahoma", Font.PLAIN, 40));
		CKBX_3.setBounds(22, 428, 540, 85);
		WeeklyItems_chckBx_Panel.add(CKBX_3);
		
		JCheckBox CKBX_4 = new JCheckBox("Bananas");
		CKBX_4.setFont(new Font("Tahoma", Font.PLAIN, 40));
		CKBX_4.setBounds(22, 796, 540, 85);
		WeeklyItems_chckBx_Panel.add(CKBX_4);
		
		JCheckBox CKBX_5 = new JCheckBox("Mushrooms");
		CKBX_5.setFont(new Font("Tahoma", Font.PLAIN, 40));
		CKBX_5.setBounds(22, 609, 540, 85);
		WeeklyItems_chckBx_Panel.add(CKBX_5);
		
		JCheckBox CKBX_6 = new JCheckBox("Toilet Paper");
		CKBX_6.setFont(new Font("Tahoma", Font.PLAIN, 40));
		CKBX_6.setBounds(580, 72, 540, 85);
		WeeklyItems_chckBx_Panel.add(CKBX_6);
		
		JCheckBox CKBX_7 = new JCheckBox("Foil");
		CKBX_7.setFont(new Font("Tahoma", Font.PLAIN, 40));
		CKBX_7.setBounds(580, 248, 540, 85);
		WeeklyItems_chckBx_Panel.add(CKBX_7);
		
		JCheckBox CKBX_8 = new JCheckBox("Laundry Detergent");
		CKBX_8.setFont(new Font("Tahoma", Font.PLAIN, 40));
		CKBX_8.setBounds(580, 435, 540, 85);
		WeeklyItems_chckBx_Panel.add(CKBX_8);
		
		JCheckBox CKBX_9 = new JCheckBox("Paper Towels");
		CKBX_9.setFont(new Font("Tahoma", Font.PLAIN, 40));
		CKBX_9.setBounds(580, 617, 540, 85);
		WeeklyItems_chckBx_Panel.add(CKBX_9);
		
		JCheckBox CKBX_10 = new JCheckBox("Hummus");
		CKBX_10.setFont(new Font("Tahoma", Font.PLAIN, 40));
		CKBX_10.setBounds(580, 809, 540, 85);
		WeeklyItems_chckBx_Panel.add(CKBX_10);
		
		JCheckBox CKBX_11 = new JCheckBox("Vegtable Bailey Soup");
		CKBX_11.setFont(new Font("Tahoma", Font.PLAIN, 40));
		CKBX_11.setBounds(1150, 72, 540, 85);
		WeeklyItems_chckBx_Panel.add(CKBX_11);
		
		JCheckBox CKBX_12 = new JCheckBox("Pop Corn");
		CKBX_12.setFont(new Font("Tahoma", Font.PLAIN, 40));
		CKBX_12.setBounds(1150, 248, 540, 85);
		WeeklyItems_chckBx_Panel.add(CKBX_12);
		
		JCheckBox CKBX_13 = new JCheckBox("Chips Variety Pack");
		CKBX_13.setFont(new Font("Tahoma", Font.PLAIN, 40));
		CKBX_13.setBounds(1150, 435, 540, 85);
		WeeklyItems_chckBx_Panel.add(CKBX_13);
		
		JCheckBox CKBX_14 = new JCheckBox("Spicy Mangos");
		CKBX_14.setFont(new Font("Tahoma", Font.PLAIN, 40));
		CKBX_14.setBounds(1150, 617, 540, 85);
		WeeklyItems_chckBx_Panel.add(CKBX_14);
		
		JCheckBox CKBX_15 = new JCheckBox("Quinoa");
		CKBX_15.setFont(new Font("Tahoma", Font.PLAIN, 40));
		CKBX_15.setBounds(1150, 809, 540, 85);
		WeeklyItems_chckBx_Panel.add(CKBX_15);
		
		JCheckBox CKBX_16 = new JCheckBox("Strawberries");
		CKBX_16.setFont(new Font("Tahoma", Font.PLAIN, 40));
		CKBX_16.setBounds(1709, 72, 540, 85);
		WeeklyItems_chckBx_Panel.add(CKBX_16);
		
		JCheckBox CKBX_17 = new JCheckBox("Blueberries");
		CKBX_17.setFont(new Font("Tahoma", Font.PLAIN, 40));
		CKBX_17.setBounds(1709, 248, 540, 85);
		WeeklyItems_chckBx_Panel.add(CKBX_17);
		
		JCheckBox CKBX_18 = new JCheckBox("Pineapple");
		CKBX_18.setFont(new Font("Tahoma", Font.PLAIN, 40));
		CKBX_18.setBounds(1708, 435, 540, 85);
		WeeklyItems_chckBx_Panel.add(CKBX_18);
		
		JCheckBox CKBX_19 = new JCheckBox("Apples");
		CKBX_19.setFont(new Font("Tahoma", Font.PLAIN, 40));
		CKBX_19.setBounds(1708, 617, 540, 85);
		WeeklyItems_chckBx_Panel.add(CKBX_19);
		
		JCheckBox CKBX_20 = new JCheckBox("Salsa");
		CKBX_20.setFont(new Font("Tahoma", Font.PLAIN, 40));
		CKBX_20.setBounds(1709, 809, 540, 85);
		WeeklyItems_chckBx_Panel.add(CKBX_20);
		
		JCheckBox CKBX_21 = new JCheckBox("Tortilla Chips");
		CKBX_21.setFont(new Font("Tahoma", Font.PLAIN, 40));
		CKBX_21.setBounds(2267, 72, 540, 85);
		WeeklyItems_chckBx_Panel.add(CKBX_21);
		

		JButton WISelectALL = new JButton("SELECT ALL");
		WISelectALL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CKBX_1.setSelected(true);
				CKBX_2.setSelected(true);
				CKBX_3.setSelected(true);
				CKBX_4.setSelected(true);
				CKBX_5.setSelected(true);
				CKBX_6.setSelected(true);
				CKBX_7.setSelected(true);
				CKBX_8.setSelected(true);
				CKBX_9.setSelected(true);
				CKBX_10.setSelected(true);
				CKBX_11.setSelected(true);
				CKBX_12.setSelected(true);
				CKBX_13.setSelected(true);
				CKBX_14.setSelected(true);
				CKBX_15.setSelected(true);
				CKBX_16.setSelected(true);
				CKBX_17.setSelected(true);
				CKBX_18.setSelected(true);
				CKBX_19.setSelected(true);
				CKBX_20.setSelected(true);
				CKBX_21.setSelected(true);
			}
		});
		WISelectALL.setBounds(200, 1622, 450, 130);
		WISelectALL.setForeground(new Color(0, 0, 0));
		WISelectALL.setBackground(new Color(200, 200, 200));
		WISelectALL.setFont(new Font("Tahoma", Font.PLAIN, 70));
		WeeklyItems_Panel.add(WISelectALL);
		

		JButton WINext = new JButton("NEXT ->");
		WINext.setBounds(2377, 1622, 300, 130);
		WINext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WeeklyItems_Panel.setVisible(false);
				CheckOut_Panel.setVisible(true);
				if(CKBX_1.isSelected())
				{
					itemCart.addItem(new Item("Mixed Nuts", "Costco", 1));
				}
				if(CKBX_2.isSelected())
				{
					itemCart.addItem(new Item("Cashews", "Costco", 1));
				}
				if(CKBX_3.isSelected())
				{
					itemCart.addItem(new Item("Vegtable Tray", "Costco", 1));
				}
				if(CKBX_4.isSelected())
				{
					itemCart.addItem(new Item("Bananas", "Sprouts", 5));
				}
				if(CKBX_5.isSelected())
				{
					itemCart.addItem(new Item("Mushrooms", "Sprouts", 1));
				}
				if(CKBX_6.isSelected())
				{
					itemCart.addItem(new Item("Toilet Paper", "Costco", 1));
				}
				if(CKBX_7.isSelected())
				{
					itemCart.addItem(new Item("Foil", "Costco", 1));
				}
				if(CKBX_8.isSelected())
				{
					itemCart.addItem(new Item("Laundry Detergent", "Costco", 1));
				}
				if(CKBX_9.isSelected())
				{
					itemCart.addItem(new Item("Paper Towels", "Costco", 1));
				}
				if(CKBX_10.isSelected())
				{
					itemCart.addItem(new Item("Hummus", "Costco", 1));
				}
				if(CKBX_11.isSelected())
				{
					itemCart.addItem(new Item("Vegtable Bailey Soup", "Costco", 1));
				}
				if(CKBX_12.isSelected())
				{
					itemCart.addItem(new Item("Pop Corn(Skinny Pop)", "Costco", 1));
				}
				if(CKBX_13.isSelected())
				{
					itemCart.addItem(new Item("Chips Variety Pack", "Costco", 1));
				}
				if(CKBX_14.isSelected())
				{
					itemCart.addItem(new Item("Spicy Mangos", "Sprouts", 1));
				}
				if(CKBX_15.isSelected())
				{
					itemCart.addItem(new Item("Quinoa", "Sprouts", 1));
				}
				if(CKBX_16.isSelected())
				{
					itemCart.addItem(new Item("Strawberries", "Sprouts", 1));
				}
				if(CKBX_17.isSelected())
				{
					itemCart.addItem(new Item("Blueberries", "Sprouts", 1));
				}
				if(CKBX_18.isSelected())
				{
					itemCart.addItem(new Item("Pineapple", "Sprouts", 1));
				}
				if(CKBX_19.isSelected())
				{
					itemCart.addItem(new Item("Apples", "Sprouts", 5));
				}
				if(CKBX_20.isSelected())
				{
					itemCart.addItem(new Item("Salsa", "Costco", 1));
				}
				if(CKBX_21.isSelected())
				{
					itemCart.addItem(new Item("Tortilla Chips", "Costco", 1));
				}
				updateRecipeCart();
				updateCheckOutCart();
			}
		});
		WINext.setForeground(new Color(0, 0, 0));
		WINext.setBackground(new Color(0, 153, 0));
		WINext.setFont(new Font("Tahoma", Font.PLAIN, 70));
		WeeklyItems_Panel.add(WINext);
		
		JButton WIBack = new JButton("<- BACK");
		WIBack.setBounds(2000, 1622, 300, 130);
		WIBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WeeklyItems_Panel.setVisible(false);
				RecipeChoice_Panel.setVisible(true);
			}
		});
		WIBack.setForeground(new Color(0, 0, 0));
		WIBack.setBackground(new Color(0, 153, 0));
		WIBack.setFont(new Font("Tahoma", Font.PLAIN, 70));
		WeeklyItems_Panel.add(WIBack);
		
	}
	
	private void build_CheckOutPanel()
	{

		
		// CheckOut_Panel items
		JLabel COLogo_label = new JLabel("");
		COLogo_label.setIcon(new ImageIcon(img));
		COLogo_label.setBounds(700, 28, 1422, 280);
		CheckOut_Panel.add(COLogo_label);
		
		Recipe_TextField = new JTextArea();
		Recipe_TextField.setBounds(200, 500, 1000, 1000);
		Recipe_TextField.setFont(new Font("Tahoma", Font.PLAIN, 40));
		Recipe_TextField.setBackground(new Color(240,240,240));
		CheckOut_Panel.add(Recipe_TextField);
		
		
		
		Items_TextField = new JTextArea(1000,1000);
		Items_TextField.setFont(new Font("Tahoma", Font.PLAIN, 40));
		Items_TextField.setBackground(new Color(240,240,240));
		Items_TextField.setLineWrap(true);
		Items_TextField.setWrapStyleWord(true);
		JScrollPane checkOutItemPanel = new JScrollPane(Items_TextField, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		checkOutItemPanel.setBounds(1700, 500, 1000, 1000);
		CheckOut_Panel.add(checkOutItemPanel);
		
		JLabel CORecipe_Label = new JLabel("RECIPES");
		CORecipe_Label.setFont(new Font("Tahoma", Font.PLAIN, 70));
		CORecipe_Label.setBounds(570, 350, 344, 130);
		CheckOut_Panel.add(CORecipe_Label);
		
		JLabel GroceryItems_Label = new JLabel("GROCERY ITEMS");
		GroceryItems_Label.setFont(new Font("Tahoma", Font.PLAIN, 70));
		GroceryItems_Label.setBounds(1950, 350, 550, 130);
		CheckOut_Panel.add(GroceryItems_Label);
		
		JButton COSave = new JButton("SAVE");
		COSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					writeToFile(UserChoices,itemCart);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		COSave.setForeground(new Color(0, 0, 0));
		COSave.setBackground(new Color(0, 153, 0));
		COSave.setFont(new Font("Tahoma", Font.PLAIN, 70));
		COSave.setBounds(2377, 1622, 300, 130);
		CheckOut_Panel.add(COSave);
		
		JButton COBack = new JButton("<- BACK");
		COBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WeeklyItems_Panel.setVisible(true);
				CheckOut_Panel.setVisible(true);
			}
		});
		COBack.setForeground(new Color(0, 0, 0));
		COBack.setBackground(new Color(0, 153, 0));
		COBack.setFont(new Font("Tahoma", Font.PLAIN, 70));
		COBack.setBounds(2000, 1622, 300, 130);
		CheckOut_Panel.add(COBack);
	}
	
	private void writeToFile(RecipeList choices, ItemCart Cart) throws FileNotFoundException
	{
		FileWriter outputStream = new FileWriter();
		String tempString;
		outputStream.write("Recipes:");
		for(int i = 0; i < choices.size(); i++)
		{
			outputStream.write(choices.getRecipe(i).getName());
		}
		
		outputStream.write("");
		outputStream.write("                            Sprouts");
		outputStream.write("Item                                                  Quantity");
		outputStream.write("------                                               ----------");
		for(int i = 0; i < Cart.size(); i++)
		{
			if(Cart.getItem(i).sameStore("Sprouts"))
			{
				tempString =  String.format("%-30s%30s", Cart.getItem(i).getName(), Integer.toString(Cart.getItem(i).getQuanity()));
				outputStream.write(tempString);
			}
		}
		
		outputStream.write("");
		outputStream.write("                            Costco");
		outputStream.write("Item                                                  Quantity");
		outputStream.write("------                                               ----------");
		for(int i = 0; i < Cart.size(); i++)
		{
			if(Cart.getItem(i).sameStore("Costco"))
			{
				tempString =  String.format("%-30s%30s", Cart.getItem(i).getName(), Integer.toString(Cart.getItem(i).getQuanity()));
				outputStream.write(tempString);
			}
		}
		
		outputStream.write("");
		outputStream.write("                            Target");
		outputStream.write("Item                                                  Quantity");
		outputStream.write("------                                               ----------");
		for(int i = 0; i < Cart.size(); i++)
		{
			if(Cart.getItem(i).sameStore("Target"))
			{
				tempString =  String.format("%-30s%30s", Cart.getItem(i).getName(), Integer.toString(Cart.getItem(i).getQuanity()));
				outputStream.write(tempString);
			}
		}
		outputStream.close();	
	}
	private void updateRecipeCart()
	{
		String FormattedString = new String("\r\n");
		for(int i = 0; i < UserChoices.size(); i++)
		{
			FormattedString += "    " + UserChoices.getRecipe(i).getName() + "\r\n\r\n";
		}
		Recipe_TextField.setText(FormattedString);
	}
	
	private void updateCheckOutCart()
	{
		String FormattedString = new String();
		for(int i = 0; i < itemCart.size(); i++)
		{
			FormattedString += "    " + itemCart.getItem(i).getName() + " " + itemCart.getItem(i).getQuanity() + "\r\n";
		}
		Items_TextField.setText(FormattedString);
		
	}
}
