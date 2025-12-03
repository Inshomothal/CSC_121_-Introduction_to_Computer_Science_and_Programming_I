package csc121.project05;

public class Pokemon {
	
	
	public Pokemon()
	{
		// TODO: Take in initial field values as argument, 
		//       then set our fields here.
	}
	
	/***
	 * Prints out all of the properties of this Pokemon.
	 */
	public String toString()
	{
		return String.format("%s",
			"TODO: Print out all of this Pokemon's stats."
		);
		
	}
	
	/***
	 * Prints out all sortable values of this Pokemon.
	 * @return
	 */
	public String toSortableValuesString()
	{
		return String.format("%s",
				"TODO: Print ID#, name, types, and power."
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
		// TODO: Return this Pokemon's name.
		return "TODO: Name";
	}
	
	public int getNumber()
	{
		// TODO: Return this Pokemon's ID number.
		return 0;
	}
}
