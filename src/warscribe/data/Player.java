package warscribe.data;

import java.util.ArrayList;

import warscribe.ui.PlayerFrame;

public class Player extends Character {

	int[] stats;
	int healingSurges;
	int healingSurgeAmt;
	ArrayList<Power> powers;
	private int currentHealingSurges;

	public Player(String name_, int level_, int experience_, int maxHealth_, String initiative_, int[] stats_, int healingSurges_) {
		super(name_, level_, experience_, maxHealth_, initiative_);
		stats = stats_.clone();
		powers = new java.util.ArrayList<Power>(0);
		healingSurges = healingSurges_;
		setCurrentHealingSurges(healingSurges_);
	}

	public int getStr() {
		return stats[0];
	}

	public int getDex() {
		return stats[1];
	}

	public int getCon() {
		return stats[2];
	}

	public int getIntel() {
		return stats[3];
	}

	public int getWis() {
		return stats[4];
	}

	public int getCha() {
		return stats[5];
	}

	public int getAcrobatics() {
		return stats[6];
	}

	public int getArcana() {
		return stats[7];
	}

	public int getBluff() {
		return stats[8];
	}

	public int getDiplomacy() {
		return stats[9];
	}

	public int getDungeoneering() {
		return stats[10];
	}

	public int getEndurance() {
		return stats[11];
	}

	public int getHeal() {
		return stats[12];
	}

	public int getHistory() {
		return stats[13];
	}

	public int getInsight() {
		return stats[14];
	}

	public int getIntimidate() {
		return stats[15];
	}

	public int getNature() {
		return stats[16];
	}

	public int getPerception() {
		return stats[17];
	}

	public int getReligion() {
		return stats[18];
	}

	public int getStealth() {
		return stats[19];
	}

	public int getStreetwise() {
		return stats[20];
	}

	public int getThievery() {
		return stats[21];
	}

	public int getAthletics() {
		return stats[22];
	}

	public void addPower(Power p) {
		powers.add(p);
	}

	public boolean useHealingSurge() {
		if (getCurrentHealingSurges() > 0) {
			PlayerFrame.output.append("Used healing surge.\n");
			healDamage(maxHealth / 4);
			setCurrentHealingSurges(getCurrentHealingSurges() - 1);
			return true;
		} else
			return false;
	}

	public int addXP(int xp) {
		experience += xp;
		return xp;
	}

	public boolean setXP(int xp) {
		if (xp > 0) {
			experience = xp;
			return true;
		} else {
			return false;
		}
	}

	public boolean isBloodied() {
		if (1.00 * currentHealth / maxHealth < 0.5)
			return true;
		else
			return false;
	}

	public int getNumPowers() {
		return powers.size();
	}

	public int getNumWeapons(String power) {
		for (int i = 0; i < getNumPowers(); i++) {
			if (powers.get(i).getName().compareTo(power) == 0)
				return powers.get(i).getNumWeapons();
		}
		return -1;
	}

	public ArrayList<Power> getPowers() {
		return powers;
	}

	public String[] getPowerNames() {
		String[] powerNames = new String[getNumPowers()];
		for (int i = 0; i < powerNames.length; i++) {
			powerNames[i] = powers.get(i).getName();
		}
		return powerNames;
	}

	public String getName() {
		return name;
	}

	public int getCurrentHealingSurges() {
		return currentHealingSurges;
	}

	public void setCurrentHealingSurges(int currentHealingSurges) {
		this.currentHealingSurges = currentHealingSurges;
	}

}
