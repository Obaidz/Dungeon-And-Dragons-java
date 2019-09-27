
class items {
	
	private int Helmet;
	private int Armour;
	private int Stick;
	private int Sword;
	private int Potion;
	private int DragonSeed;
	private int score;
	
	public items( int H, int Ar, int St, int Swd, int Pot, int dra, int scr) {
	Helmet = H;
	Armour = Ar;
	Stick = St;
	Sword = Swd;
	Potion = Pot;
	DragonSeed = dra;
	score = scr;
	}
	
	public int getHelmet() {
		return Helmet;
	}
	
	public void setHelmet(int H) {
		Helmet = H;
	}
	
	public int getArmour() {
		return Armour;
	}
	
	public void setArmour(int Ar) {
		Armour = Ar;
	}
	
	public int getStick() {
		return Stick;
	}
	                                         
	public void setStick(int St) {
		Stick = St;
	}
	
	public int getSword() {
		return Sword;
	}
	
	public void setSword(int Swd) {
		Sword = Swd;
	}
	public int getPotion() {
		return Potion;
	}
	
	public void setPotion(int Pot) {
		Potion = Pot;
	}
	public int getDragonSeed() {
		return DragonSeed;
	}
	
	public void setDragonSeed(int dra) {
		DragonSeed = dra;
	}
	public int getscore() {
		return score;
	}
	
	public void setscore(int scr) {
		score = scr;
	}
	
}