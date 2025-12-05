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
		
		return String.format(
			"#%3d: %11s\n%s",
			-1, "Temp Name",
			"TODO: Pick some other stats to print."
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
