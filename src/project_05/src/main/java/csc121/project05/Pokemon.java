package csc121.project05;

public class Pokemon {
    @SuppressWarnings("FieldMayBeFinal")
	private int iDNumber, evolution, health, attack, defense, specialAttack, specialDefense, speed, power, catchRate;
    @SuppressWarnings("FieldMayBeFinal")
	private String name, type_1, type_2;
    @SuppressWarnings("FieldMayBeFinal")
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
		// TIP: This panel has 18 spaces but 17 is better to work with.
		
		// Title
		int padding = 17 - name.length() - String.valueOf(catchRate).length() - 1;
		int pad = (padding / 2);
		String row1 = String.format("%" + pad + "s%-1s %d%-" + pad + "s", "", name, catchRate, "%");

		// Types 
		String types = type_1 + (type_2.isEmpty() ? "" : "/" + type_2);
		padding = 17 - types.length();
		pad = (padding / 2);
		if (pad > 0)
			types = String.format ("%" + pad + "s%s%" + pad + "s", "", types, "");
		else
			types = String.format (" %s", types);
		String typeSection = String.format("%s", types);
		
		// Stats
		String statSection;
		String stat = "HLT:" + String.format("%4d", health);
		String column1 = String.format("%-8s", stat);
		String column2 = " SPD:" + String.format("%4d", speed);
		statSection = column1 + column2;

		stat = "ATK:" + String.format("%4d", attack);
		column1 = String.format("%-8s", stat);
		column2 = " DEF:" + String.format("%4d", defense);
		statSection += "\n" + column1 + column2;

		stat = "S-A:" + String.format("%4d", specialAttack);
		column1 = String.format("%-8s", stat);
		column2 = " S-D:" + String.format("%4d", specialDefense);
		statSection += "\n" + column1 + column2;

		stat = "HT:" + String.format("%5.1f", height);
		column1 = String.format("%-8s", stat);
		column2 = " WT:" + String.format("%5.1f", weight);
		statSection += "\n" + column1 + column2;


		
		
		return String.format (	"""
								%s
								%s
								%s
								""",
								row1, typeSection, statSection
							);
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getNumber()
	{
		return iDNumber;
	}

	public int getEvolution()
	{
		return evolution;
	}

	public String getTypes()
	{
		return type_1 + type_2;
	}

	public int getPower()
	{
		return power;
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
