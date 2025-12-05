package csc121.project05;

public class Pokemon {
	private int iDNumber, evolution, health, attack, defense, specialAttack, specialDefense, speed, power, catchRate;
	private String name, type_1, type_2;
	private double height, weight;
	
	public Pokemon(int id, String name, String t1,
					String t2, int evo, int hp,
					int atk, int def, int spAtk,
					int spDef, int spd, int pwr,
					double ht, double wt, int ctRt)
	{
		attack = atk;
		catchRate = ctRt;
		defense = def;
		evolution = evo;
		health = hp;
		iDNumber = id;
		power = pwr;
		specialAttack = spAtk;
		specialDefense = spDef;
		speed = spd;
		this.name = name;
		type_1 = t1;
		type_2 = t2;
		height = ht;
		weight = wt;
	}
	
	/***
	 * Prints out all of the properties of this Pokemon.
	 */
	@Override
	public String toString()
	{
		return String.format(iDNumber + "\t" +
							name + "\t" +
							type_1 + "\t" +
							type_2 + "\t" +
							evolution + "\t" +
							health + "\t" +
							attack + "\t" +
							defense + "\t" +
							specialAttack + "\t" +
							specialDefense + "\t" +
							speed + "\t" +
							power + "\t" +
							height + "\t" +
							weight + "\t" +
							catchRate);
		
	}
	
	/***
	 * Prints out all sortable values of this Pokemon.
	 * @return
	 */
	public String toSortableValuesString()
	{
		return String.format("%3d  %10s  %8s  %8s  %3d",
				iDNumber, name, type_1, type_2, power
			);
	}
	
	/***
	 * @return A String with the descriptive text of this pokemon, 
	 *         formatted to be shown on the pokedex viewport.
	 */
	public String toDexText()
	{
		// TODO: Add some more stats of your choice to this String.
		//       There's not much space in the printing area, so
		//       you can't print everything. Test your code to make
		//       sure it looks nice when it runs.

		// TIP: This panel has 18 spaces but 17 is better to work with.
		
		// Title
		int padding = 17 - name.length();
		int pad = (padding / 2);
		String row1 = String.format("%" + pad + "s%s%" + pad + "s", "", name, "");

		// Type 
		String types = type_1 + "/" + (type_2.isEmpty() ? null : type_2);
		padding = 17 - types.length();
		pad = (padding / 2);
		if (pad > 0)
			types = String.format ("%" + pad + "s%s%" + pad + "s", "", types, "");
		else
			types = String.format (" %s", types);
		String typeSection = String.format("%s", types);
		
		// Stats
		String statSection = "";
		String stat = String.format("HT:  " + health);
		String column1 = String.format("%-8s", stat);
		String column2 = " CR:  " + catchRate + "%";
		statSection = column1 + column2;

		stat = "ATK: " + attack;
		column1 = String.format("%-8s", stat);
		column2 = " DEF: " + defense;
		statSection += "\n" + column1 + column2;
		
		return String.format (	"""
								%s
								%s
								%s
								""",
								row1, typeSection, statSection
							);

		

		// return String.format(
		// 	"#%3d: %11s\n%s",
		// 	-1, "Temp Name",
		// 	"TODO: Pick some other stats to print."
		// );
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getNumber()
	{
		return iDNumber;
	}

	public void outputString()
	{
		System.out.println(	iDNumber + "\t" +
							name + "\t" +
							type_1 + "\t" +
							type_2 + "\t" +
							evolution + "\t" +
							health + "\t" +
							attack + "\t" +
							defense + "\t" +
							specialAttack + "\t" +
							specialDefense + "\t" +
							speed + "\t" +
							power + "\t" +
							height + "\t" +
							weight + "\t" +
							catchRate
						);
	}
}
