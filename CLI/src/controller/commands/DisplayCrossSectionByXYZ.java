package controller.commands;

import controller.Command;
import controller.Controller;
import controller.abstractCommand;
import model.Model;

public class DisplayCrossSectionByXYZ extends abstractCommand {
	
	private Model m;
	
	//c'tor
		public DisplayCrossSectionByXYZ(Controller c){
			super(c);
		}

	@Override
	public void doCommand(String args) {
		String[] tempArray = args.split(" ");
		
		//if after "display" we want to cross section by x, y, z
		if(tempArray.length > 5){
			if(tempArray[0].equals("cross")){
				int index = 0;
				try{
					//casting Integet to premitive int
				index = Integer.parseInt(tempArray[4]);
				}
				catch (NumberFormatException e){
					this.c.C_displayMessage("wrong input");
				}
				
				//get cross section by specific index
				String XYZ = tempArray[3];
				String mazeName = tempArray[5];
				this.c.C_displayCrossSectionByXYZ(XYZ, mazeName, index);
			}
		}

	}

}
