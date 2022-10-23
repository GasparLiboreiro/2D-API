package lineasEncadenadas;

public class Util {
	public static Util instance = null;
	
	private Util() {}
	
	public void startInstance() {
		if(instance == null)
			instance = new Util();
	}
	
	public Util getInstance() {
		return instance;
	}
}
