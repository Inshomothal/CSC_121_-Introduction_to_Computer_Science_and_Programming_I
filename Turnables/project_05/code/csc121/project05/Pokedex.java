package csc121.project05;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.ListCellRenderer;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;


public class Pokedex {
	// ArrayList of our Pokemon. We will change the order of this list for sorting.
	@SuppressWarnings("FieldMayBeFinal")
	private static ArrayList<Pokemon> pokemon = new ArrayList<>();
	
	// A second ArrayList of Pokemon that will always stay ordered by number.
	@SuppressWarnings("FieldMayBeFinal")
	private static ArrayList<Pokemon> orderedPokemon = new ArrayList<>();

	// Dynamically updatable UI list.
	DefaultListModel<String> model = new DefaultListModel<>();

	// UI Image of our Pokemon.
	private JLabel screenImage;
	@SuppressWarnings("FieldMayBeFinal")
	private int screenImageSize = 150;

	// UI Colors
	@SuppressWarnings("FieldMayBeFinal")
	private Color textColor = Color.WHITE; // new Color(8, 170, 53)
	@SuppressWarnings("FieldMayBeFinal")
	private Color backgroundColor = new Color(8, 65, 53);
	
	// UI text of the chosen Pokemon.
	private JTextPane dexText;
	
	// Format String for the right-side table display.
	@SuppressWarnings("FieldMayBeFinal")
	private String headerString = String.format("%3s  %10s  %8s  %8s  %3s", "#", "Name", "Type-1", "Type-2", "POW");

	
	public static void main(String[] args) {
		loadData();
		SwingUtilities.invokeLater(() -> new Pokedex().build());
	}

	/***
	 * Makes the UI. 
	 * WARNING: Don't read this method unless you want a massive 
	 * migraine headache, like a Psyduck!
	 */
	public void build() 
	{
		JFrame frame = new JFrame("Custom GUI");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(950, 700);
		frame.setResizable(false);
		frame.setTitle("Pokédex");
		frame.setIconImage(new ImageIcon("src/project_05/src/main/java/data/images/pokeball.png").getImage());

		Image bg = new ImageIcon("src/project_05/src/main/java/data/images/pokedex.png").getImage();
		BackgroundPanel panel = new BackgroundPanel(bg);
		panel.setLayout(null);
		panel.setBackground(Color.DARK_GRAY);
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int x = e.getX(); // X inside the panel
				int y = e.getY(); // Y inside the panel
				System.out.println("Clicked UI at position: " + x + ", " + y);
			}
		});

		// Floating Sort buttons
		JButton buttonName = new JButton("Sort by NAME");
		buttonName.setBounds(710, 506, 150, 42);
		buttonName.setBackground(Color.CYAN);
		buttonName.addActionListener(e -> {
			JButton source = (JButton) e.getSource();
			System.out.println("Clicked " + source.getText() + ".");
			sortByName();
			updateScrollableList();
		});
		panel.add(buttonName);

		JButton buttonType = new JButton("Sort by TYPE");
		buttonType.setBounds(710, 548, 150, 42);
		buttonType.setBackground(Color.CYAN);
		buttonType.addActionListener(e -> {
			JButton source = (JButton) e.getSource();
			System.out.println("Clicked " + source.getText() + ".");
			sortByType();
			updateScrollableList();
		});
		panel.add(buttonType);

		JButton buttonPower = new JButton("Sort by POWER");
		buttonPower.setBounds(560, 548, 150, 42);
		buttonPower.setBackground(Color.CYAN);
		buttonPower.addActionListener(e -> {
			JButton source = (JButton) e.getSource();
			System.out.println("Clicked " + source.getText() + ".");
			sortByPower();
			updateScrollableList();
		});
		panel.add(buttonPower);

		JButton buttonNumber = new JButton("Sort by NUMBER");
		buttonNumber.setBounds(560, 506, 150, 42);
		buttonNumber.setBackground(Color.CYAN);
		buttonNumber.addActionListener(e -> {
			JButton source = (JButton) e.getSource();
			System.out.println("Clicked " + source.getText() + ".");
			sortByNumber();
			updateScrollableList();
		});
		panel.add(buttonNumber);

		// Create a new ImageIcon from the scaled image
		JLabel image = new JLabel();
		image.setBounds(89, 220, screenImageSize, screenImageSize);
		panel.add(image);
		screenImage = image;

		// Stats Header
		JTextArea header = new JTextArea(headerString);
		header.setEditable(false);   // Read-only
		header.setFocusable(false);  // Remove caret
		header.setOpaque(true);      // Allow background color
		header.setBackground(backgroundColor); // Custom background color
		header.setForeground(textColor);       // Custom text color
		header.setFont(new Font("Monospaced", Font.BOLD, 12));
		header.setLineWrap(true);
		header.setWrapStyleWord(true);
		header.setBorder(BorderFactory.createEmptyBorder()); // Remove border so it "floats".
		header.setBounds(564, 225, 300, 20); // Absolute positioning
		panel.add(header); 

		// Scrollable list
		updateScrollableList();
		JList<String> list = new JList<>(model);
		JScrollPane scroll = new JScrollPane(list);
		scroll.setBounds(563, 245, 310, 245);
		scroll.setBorder(null);
		list.setBackground(backgroundColor);
		list.setForeground(textColor);
		JScrollBar vertical = scroll.getVerticalScrollBar();
		vertical.setPreferredSize(new Dimension(12, Integer.MAX_VALUE));
		JScrollBar horizontal = scroll.getHorizontalScrollBar();
		horizontal.setPreferredSize(new Dimension(Integer.MAX_VALUE, 12));
		panel.add(scroll);
		list.setFont(new Font("Monospaced", Font.BOLD, 12));
		list.addListSelectionListener(e -> {
			if (!e.getValueIsAdjusting()) {
				String selectedValue = null;
				try {
					selectedValue = list.getSelectedValue().trim();
				} catch (Exception e1) {
					return;
				}

				if (selectedValue != null) {
					Scanner numScanner;
					try
					{
						numScanner = new Scanner(selectedValue);
						int num = numScanner.nextInt();
						numScanner.close();

						setScreenImage(num);
						setDexText(findPokemonByNumber(num));

					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
			}
		});
		list.setCellRenderer((ListCellRenderer<? super String>) new DefaultListCellRenderer() {
			private static final long serialVersionUID = 1L;

			@Override
			public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
					boolean cellHasFocus) {
				JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected,
						cellHasFocus);
				label.setHorizontalAlignment(SwingConstants.LEFT);
				return label;
			}
		});

		// Create a text box for dex entry.
		JTextPane box = new JTextPane();
		box.setEditable(false);  // Read-only
		box.setFocusable(false); // Remove caret
		box.setOpaque(true);     // Allow background color
		box.setBackground(backgroundColor); // Custom background color
		box.setForeground(textColor);       // Custom text color
		box.setFont(new Font("Monospaced", Font.BOLD, 12));
		box.setBorder(BorderFactory.createEmptyBorder()); // Remove border so it "floats".
		box.setBounds(245, 205, 130, 180);  // Absolute positioning

		// Create a centered paragraph style
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		SimpleAttributeSet left = new SimpleAttributeSet();
		StyleConstants.setAlignment(left, StyleConstants.ALIGN_LEFT);
		SimpleAttributeSet right = new SimpleAttributeSet();
		StyleConstants.setAlignment(right, StyleConstants.ALIGN_RIGHT);

		// Apply style to the entire document
		StyledDocument doc = box.getStyledDocument();
		doc.setParagraphAttributes(0, doc.getLength(), left, false);
		box.setText("");

		panel.add(box);
		dexText = box;

		frame.setContentPane(panel);
		frame.setVisible(true);
	}
	
	public void updateScrollableList() 
	{
		model.clear();
		for (Pokemon p : pokemon) {
			model.addElement(p.toSortableValuesString());
		}
	}

	public void setScreenImage(int number) 
	{
		// Floating PNG
		ImageIcon originalIcon = new ImageIcon("src/project_05/src/main/java/data/images/" + number + ".png");
		Image originalImage = originalIcon.getImage();

		// Scale the image to the JLabel bounds
		Image scaledImage = originalImage.getScaledInstance(screenImageSize, screenImageSize, Image.SCALE_SMOOTH);

		ImageIcon scaledIcon = new ImageIcon(scaledImage);
		screenImage.setIcon(scaledIcon);
	}

	public void setDexText(Pokemon p) 
	{
		if (p == null) {
			dexText.setText("ERROR!!!");
			return;
		}
		String text = p.toDexText();

		ArrayList<Pokemon> evolutions = getEvolutions(p);
		if (!evolutions.isEmpty()) {
			text += "\n--- Evolutions --";
			for (Pokemon evo : evolutions) 
			{
				String evoString = String.format("#%3d: %11s",
						evo.getNumber(), evo.getName());
				
				text += "\n" + evoString;
			}
		}
		dexText.setText(text);
	}

	/* -----------------------------------------------------
	 * Your code changes for this file go below this line.
	 * -----------------------------------------------------
	 */
	
	/***
	 * Loads the CSV data into individual Pokemon objects.<p>
	 * Fills in both our pokemon and orderedPokemon ArrayLists.
	 */
	public static void loadData() 
	{
		String dataFilename = "src/project_05/src/main/java/data/pokemon.csv";
		File file = new File(dataFilename);
		
		Scanner inputFile;
		try {
			inputFile = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.err.println("Error opening data file: " + dataFilename);
			e.printStackTrace();
			return;
		}

		// Use commas and newlines as delimeters.
		inputFile.useDelimiter(",|\\r?\\n");
		
		// Skip CSV column header.
		inputFile.nextLine();

		while (inputFile.hasNext()) 
		{
			int iD = inputFile.nextInt();
			String name = inputFile.next();
			String t1 = inputFile.next();
			String t2 = inputFile.next();
			int evo = inputFile.nextInt();
			int hp = inputFile.nextInt();
			int atk = inputFile.nextInt();
			int def = inputFile.nextInt();
			int spAtk = inputFile.nextInt();
			int spDef = inputFile.nextInt();
			int spd = inputFile.nextInt();
			int pwr = inputFile.nextInt();
			double ht = inputFile.nextDouble();
			double wt = inputFile.nextDouble();
			int ctRt = inputFile.nextInt();
			
			pokemon.add(new Pokemon(iD, name, t1, t2, evo, hp, atk, def, spAtk, spDef, spd, pwr, ht, wt, ctRt));
			System.out.println(pokemon.getLast().toString());
			orderedPokemon.add(new Pokemon(iD, name, t1, t2, evo, hp, atk, def, spAtk, spDef, spd, pwr, ht, wt, ctRt));
			
			inputFile.nextLine();
		}
		inputFile.close();
	}
	
	/**
	 * Sorts the "pokemon" ArrayList alphabetically A-Z by name.
	 */
	public void sortByName() 
	{
		for (int j = 0; j < pokemon.size(); j++)
		{
			int index = j;
			Pokemon orderedEntry = pokemon.get(j);

			for (int i = j; i < pokemon.size(); i++)
			{
				if ( orderedEntry.getName().compareToIgnoreCase(pokemon.get(i).getName()) > 0)
				{
					index = i;
					orderedEntry = pokemon.get(i);
				}
			}
			
			pokemon.set(index, pokemon.get(j));
			pokemon.set(j, orderedEntry);
		}
	}

	/**
	 * Sort the "pokemon" ArrayList alphabetically A-Z by type.
	 * 
	 * NOTE: Concatenates Strings Type-1 and Type-2 into one String,
	 * then sorts alphabetically based on that combined type String.
	 */
	public void sortByType() 
	{
		for (int j = 0; j < pokemon.size() - 1; j++)
		{
			for (int i = 0; i < pokemon.size() - j - 1; i++)
			{
				String types0 = pokemon.get(i).getTypes();
				String types1 = pokemon.get(i+1).getTypes();

				if (types1.compareToIgnoreCase(types0) < 0)
				{
					Pokemon temp = pokemon.get(i+1);
					pokemon.set(i+1, pokemon.get(i));
					pokemon.set(i, temp);
				}
				else if (types1.compareToIgnoreCase(types0) == 0)
				{
					if(pokemon.get(i+1).getNumber() < pokemon.get(i).getNumber())
					{
						Pokemon temp = pokemon.get(i+1);
						pokemon.set(i+1, pokemon.get(i));
						pokemon.set(i, temp);
					}
				}

			}
		}
	}

	/**
	 * Sort the "pokemon" ArrayList numerically by power rating.
	 * Highest numbers are at the front of the list.
	 */
	public void sortByPower() 
	{
		for (int j = 0; j < pokemon.size() - 1; j++)
		{
			Pokemon p = pokemon.get(j);
			int index = j;
			for (int i = j + 1; i < pokemon.size(); i++)
			{
				if (pokemon.get(i).getPower() < p.getPower())
				{
					System.out.println("Debugging: Swapping " + 
										p.getName() + "(" + p.getNumber() + ") with " +
										pokemon.get(i).getName() + "(" + pokemon.get(i).getNumber() + ")");

					p = pokemon.get(i);
					index = i;
				}
				else if (pokemon.get(i).getPower() == p.getPower())
				{
					System.out.println("Debugging Level 2:\n" +
										p.getName() + "(" + p.getNumber() + ") has same value as " +
										pokemon.get(i).getName() + "(" + pokemon.get(i).getNumber() + ").");

					index = (pokemon.get(i).getNumber() < p.getNumber() ? i : index);
					p = pokemon.get(index);
					System.out.println("The smallest should now be " + p.getName());
				}
			}
			if (p != pokemon.get(j))
			{
				pokemon.set(index, pokemon.get(j));
				pokemon.set(j, p);
			}
		}
	}

	/**
	 * Sort the "pokemon" ArrayList numerically by ID number.
	 * Lowest numbers are at the front of the list.
	 */
	public void sortByNumber() 
	{
		for (int j = 0; j < pokemon.size() - 1; j++)
		{
			Pokemon p = pokemon.get(j);
			int index = j;
			for (int i = j + 1; i < pokemon.size(); i++)
			{
				index = (pokemon.get(i).getNumber() < p.getNumber()) ? i : index;
				p = pokemon.get(index);
			}
			if (p != pokemon.get(j))
			{
				pokemon.set(index, pokemon.get(j));
				pokemon.set(j, p);
			}
		}
	}

	/**
	 * Uses binary search to find a pokemon in our "orderedPokemon" 
	 * ArrayList by its ID number.
	 * 
	 * NOTE: Be sure to not change the order of "orderedPokemon".
	 * The binary search algorithm requires a sorted list to work.
	 * 
	 * @param number 
	 * The ID number of the pokemon to find.
	 * 
	 * @return 
	 * Returns the pokemon if found, or null if not found.
	 */
	public Pokemon findPokemonByNumber(int number) 
	{
		Pokemon foundPokemon = null;
		int low = 0, high = (orderedPokemon.size() - 1);
		while (low <= high)
		{
			int mid = low + (high - low) / 2;
			int midNum = orderedPokemon.get(mid).getNumber();
			if (midNum == number) return orderedPokemon.get(mid);
			if (number < midNum) high = mid - 1;
			else low = mid + 1;
		}
		return foundPokemon;
	}

	/***
	 * Create and return an ArrayList of pokemon that are future 
	 * evolutions of the supplied pokemon p.
	 * 
	 * @param p 
	 * The root of the evolution list.
	 * 
	 * @return An 
	 * ArrayList of p's future evolutions.
	 */
	public ArrayList<Pokemon> getEvolutions(Pokemon p) 
	{
		ArrayList<Pokemon> evolutions = new ArrayList<>();
		findEvolutionsRecursively(p, evolutions);
		return evolutions;
	}

	/**
	 * Recursively searches for evolutions of p and adds them to the 
	 * input ArrayList. Mutates the ArrayList.
	 * 
	 * @param p 
	 * The evolution root.
	 * 
	 * @param evolutions 
	 * Found evolutions are added to this list.
	 */
	private void findEvolutionsRecursively(Pokemon p, ArrayList<Pokemon> evolutions) 
	{
		if (p.getEvolution() == 0)
		{
			return;
		} else
		{
			p = findPokemonByNumber(p.getEvolution());
			evolutions.add(p);
		}
		findEvolutionsRecursively(p, evolutions); 
	}
}
