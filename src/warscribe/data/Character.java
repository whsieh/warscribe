package warscribe.data;

import java.util.ArrayList;

import warscribe.ui.PlayerFrame;

public class Character {

	String name;
	int level;
	int experience;
	int maxHealth;
	String initiative;
	int duplicateCount;
	boolean stunned = false;
	boolean prone = false;
	boolean immobilized = false;
	boolean restrained = false;
	ArrayList<Attack> attacks;
	String[] nameInParts;

	int currentHealth;
	int currentInitiative;

	public static Character parseFromString(String line) {
		String name_ = line.substring(0, line.indexOf(";")).trim();
		line = line.substring(line.indexOf(";") + 1, line.length()).trim();

		int lvl = Integer.parseInt(line.substring(0, line.indexOf(";")));
		line = line.substring(line.indexOf(";") + 1, line.length()).trim();

		int xp = Integer.parseInt(line.substring(0, line.indexOf(";")));
		line = line.substring(line.indexOf(";") + 1, line.length()).trim();

		int hp = Integer.parseInt(line.substring(0, line.indexOf(";")));
		line = line.substring(line.indexOf(";") + 1, line.length()).trim();

		String init = line.substring(0, line.indexOf(";"));
		line = line.substring(line.indexOf(";") + 1, line.length()).trim();

		Character newCharacter = new Character(name_, lvl, xp, hp, init);
		while (line.length() > 1) {
			String newAtk = line.substring(0, line.indexOf(";"));
			newCharacter.addAttack(new Attack(newAtk));
			line = line.substring(line.indexOf(";") + 1, line.length()).trim();
		}
		
		return newCharacter;
	}
	
	public Character(String name_, int lvl, int xp, int hp, String init) {
		name = name_;
		level = lvl;
		experience = xp;
		maxHealth = hp;
		initiative = init;
		currentHealth = maxHealth;
		currentInitiative = 0;
		duplicateCount = 0;

		setAttacks(new ArrayList<Attack>());
		nameInParts = name.split(" ");
		for (int i = 0; i < nameInParts.length; i++) {
			nameInParts[i] = nameInParts[i].trim().toLowerCase();
		}
	}

	public Character(Character character, int duplicateCount) {
		this(character.getName(), character.getLevel(), character.getXP(), character.getMaxHealth(), character.getInitiativeString());
		for (Attack attack : character.getAttacks()) {
			this.addAttack(attack);
		}
		this.duplicateCount = duplicateCount;
	}
	
	public String serializeAsString() {
		StringBuilder line = new StringBuilder();
		line.append(String.format("%s;%d;%d;%d;%s;", name, level, experience, maxHealth, initiative));
		for (Attack attack : attacks)
			line.append(String.format("%s;%d;%s;", attack.attackName, attack.hitMod, attack.damageRoll));
		return line.toString();
	}

	public int getXP() {
		return experience;
	}

	public int getCurrentInitiative() {
		return currentInitiative;
	}

	public String getName() {
		return name;
	}

	public int getLevel() {
		return level;
	}

	public void addAttack(Attack a) {
		getAttacks().add(a);
	}

	public void setInitiative() {
		int val = Roller.roll(initiative);
		currentInitiative = val;
	}

	public int getInitiative() {
		return currentInitiative;
	}

	public String getInitiativeString() {
		return initiative;
	}

	public void setHealth(int h) {
		currentHealth = h;
	}

	public int getMaxHealth() {
		return maxHealth;
	}

	public int getHealth() {
		return currentHealth;
	}

	public void takeDamage(int d) {
		currentHealth -= d;
		PlayerFrame.output.append("You have taken " + d + " damage.\n");
		if (currentHealth < 0) {
			PlayerFrame.output.append("You have died!\n");
			setHealth(0);
		}
	}

	public void healDamage(int d) {
		currentHealth += d;
		PlayerFrame.output.append("You have recovered " + d + " HP.\n");
		if (currentHealth > maxHealth)
			setHealth(maxHealth);
	}

	public boolean isStunned() {
		return stunned;
	}

	public void setStunned(boolean stunned) {
		this.stunned = stunned;
	}

	public boolean isImmobilized() {
		return immobilized;
	}

	public void setImmobilized(boolean immobilized) {
		this.immobilized = immobilized;
	}

	public boolean isProne() {
		return prone;
	}

	public void setProne(boolean prone) {
		this.prone = prone;
	}

	public boolean isRestrained() {
		return restrained;
	}

	public void setRestrained(boolean restrained) {
		this.restrained = restrained;
	}

	public ArrayList<Attack> getAttacks() {
		return attacks;
	}

	public void setAttacks(ArrayList<Attack> attacks) {
		this.attacks = attacks;
	}

	public int getDuplicateCount() {
		return duplicateCount;
	}

	public void setCount(int count) {
		this.duplicateCount = count;
	}

	public String toString() {
		return String.format("%s (Level %d)", name, level);
	}

	// Laughably inefficient, but for our small manually-created monster
	// databases it will be enough.
	public boolean validSearchResultForTerm(String searchTerms) {
		String[] terms = searchTerms.toLowerCase().trim().split(" ");
		for (String term : terms) {
			for (String namePart : nameInParts) {
				if (namePart.startsWith(term))
					return true;
			}
		}
		return false;
	}

	public String getCombatantName() {
		if (duplicateCount == 0)
			return name;

		// Adding 1 to the duplicate count means that duplicate combatants will
		// be numbered
		// starting at (2), so the original combatant will not display a
		// duplicate count.
		return String.format("%s (%d)", name, duplicateCount + 1);
	}

	public String infoText() {
		StringBuilder infoText = new StringBuilder();
		infoText.append(String.format("%s\nLevel: %d\nExperience Gain: %d\nMax Health: %d\n", name, level, experience, maxHealth));

		if (maxHealth / 2.0 > currentHealth)
			infoText.append("Bloodied!\n");

		if (attacks != null && attacks.size() > 0) {
			for (Attack attack : attacks) {
				infoText.append("  - " + attack.attackName + "\n");
			}
		} else {
			infoText.append("\nNo known attacks.");
		}

		return infoText.toString();
	}
}
