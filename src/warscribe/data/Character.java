package warscribe.data;

import java.util.ArrayList;

import warscribe.ui.PlayerFrame;

public class Character{

	String name;
	int level;
	int experience;
	int maxHealth;
	String initiative;
	String count;
    boolean stunned = false;
    boolean prone = false;
    boolean immobilized = false;
    boolean restrained = false;
    ArrayList <Attack> attacks;
    
    int currentHealth;
    int currentInitiative;

    
    public Character(String name_, int lvl, int xp, int hp, String init){
        name = name_;
        level = lvl;
        experience = xp;
        maxHealth = hp;
        initiative = init;
        currentHealth = maxHealth;
        currentInitiative = 0;
        setCount("");
        setAttacks(new ArrayList<Attack>());
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
    
    public void addAttack(Attack a){
        getAttacks().add(a);
    }
    
    public void setInitiative(){
    	int val = Roller.roll(initiative);
        currentInitiative = val;
    }
    
    public int getInitiative() {
    	return currentInitiative;
    }
    
    public String getMaxInitiative() {
    	return initiative;
    }
    
     public void setHealth(int h){
    	currentHealth = h;
    }
    
    public int getMaxHealth() {
    	return maxHealth;
    }
    
    public int getHealth() {
    	return currentHealth;
    }
    
    public void takeDamage(int d){
        currentHealth -= d;
        PlayerFrame.output.append("You have taken " + d + " damage.\n");
        if(currentHealth < 0){
            PlayerFrame.output.append("You have died!\n");
            setHealth(0);
        }
    }
    
    public void healDamage(int d){
        currentHealth += d;
        PlayerFrame.output.append("You have recovered " + d + " HP.\n");
        if(currentHealth > maxHealth)
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

	public ArrayList <Attack> getAttacks() {
		return attacks;
	}

	public void setAttacks(ArrayList <Attack> attacks) {
		this.attacks = attacks;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}
    

}
