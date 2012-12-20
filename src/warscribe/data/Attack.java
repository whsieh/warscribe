package warscribe.data;

public class Attack{

    String attackName;
    int hitMod;
    String damageRoll;
    private String offensive;
    private String defensive;

    public Attack(String name, int hit, String dmg){
        setAttackName(name);
        setHitMod(hit);
        setDamageRoll(dmg);
        setOffensive("");
        setDefensive("");
    }
    
    public Attack(String attack){
        
        setAttackName(attack.substring(0,attack.indexOf(",")));
        attack = attack.substring(attack.indexOf(",") + 1, attack.length());
        
        setHitMod(Integer.parseInt(attack.substring(0,attack.indexOf(","))));
        attack = attack.substring(attack.indexOf(",") + 1, attack.length());
        
        setDamageRoll(attack.substring(0,attack.length()));
    }
    
    public int returnHit(){
        if(getHitMod() < 0)
            return -1*getHitMod();
        else
            return Roller.roll("1d20+" + getHitMod());
    }
    
    public int returnDamage(){
        return Roller.roll(getDamageRoll());
    }
    
    public int[] debugRoll(int x){
        int[] damages = new int[x];
        for(int i = 0; i < x; i++){
            damages[i] = Roller.roll(getDamageRoll());
        }
        return damages;
    }
    
    public void setDefensive(String defensive_){
        defensive = defensive_;
    }
    
    public void setOffensive(String offensive_){
        offensive = offensive_;
    }
    
    public String getName(){
        return getAttackName();
    }

	public int getHitMod() {
		return hitMod;
	}

	public void setHitMod(int hitMod) {
		this.hitMod = hitMod;
	}

	public String getAttackName() {
		return attackName;
	}

	public void setAttackName(String attackName) {
		this.attackName = attackName;
	}

	public String getDamageRoll() {
		return damageRoll;
	}

	public void setDamageRoll(String damageRoll) {
		this.damageRoll = damageRoll;
	}

	public String getOffensive() {
		return offensive;
	}

	public String getDefensive() {
		return defensive;
	}
    
    
}
