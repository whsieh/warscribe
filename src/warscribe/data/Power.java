package warscribe.data;

import java.util.ArrayList;

public class Power {

	String name;
	private String powerUsage;
	private String actionType;
	ArrayList<Attack> weapons = new ArrayList<Attack>();

	public Power(String name_, String powerUsage_, String actionType_) {
		name = name_;
		setPowerUsage(powerUsage_);
		setActionType(actionType_);
		weapons = new ArrayList<Attack>(0);
	}

	public void addWeapon(Attack w) {
		weapons.add(w);
	}

	public String getName() {
		return name;
	}

	public int getNumWeapons() {
		return weapons.size();
	}

	public String[] getWeaponNames() {
		String[] weaponNames = new String[getNumWeapons()];
		for (int i = 0; i < weaponNames.length; i++) {
			weaponNames[i] = weapons.get(i).getName();
		}
		return weaponNames;
	}

	public ArrayList<Attack> getWeapons() {
		return weapons;
	}

	public String getActionType() {
		return actionType;
	}

	public void setActionType(String actionType) {
		this.actionType = actionType;
	}

	public String getPowerUsage() {
		return powerUsage;
	}

	public void setPowerUsage(String powerUsage) {
		this.powerUsage = powerUsage;
	}

}
