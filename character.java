
class character {
	private String name;
	private int healthvalue;
	private int attackvalue;
	private int defencevalue;
	private int items;
	
	public character(String n, int h, int a, int d, int i) {
	name = n;
	healthvalue = h;
	attackvalue = a;
	defencevalue = d;
	items = i;
	}
	
	public String getname() {
		return name;
	}
	
	public void setname(String n) {
		name = n;
	}
	
	public int gethealthvalue() {
		return healthvalue;
	}
	
	public void sethealthvalue(int h) {
		healthvalue = h;
	}
	
	public int getattackvalue() {
		return attackvalue;
	}
	                                         
	public void setattackvalue(int a) {
		attackvalue = a;
	}
	
	public int getdefencevalue() {
		return defencevalue;
	}
	
	public void setdefencevalue(int d) {
		defencevalue = d;
	}
	public int getitems() {
		return items;
	}
	
	public void setitems(int i) {
		items = i;
	}
	
}