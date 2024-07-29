package module;

public abstract class info {
	private static int IdCounter = 0;
	private final static int IdLenght = 4;
	
	private int ID;
	
	public int getID() {
		return this.ID;
	}
	
	public void setID() {
		IdCounter+=1;
		this.ID = IdCounter;
	}
	
	public void setID(int id) {
		if (checkIdLen(id)) {
			this.ID = id;
		}
	}
	
	private boolean checkIdLen(int id) {
		return String.valueOf(id).length() <= IdLenght;
	}
	
	public void print() {
		System.out.println("print content in console");
	}
}
