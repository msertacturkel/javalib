package boyut;

public class Boyut4 {
	private Object obj;

	public Boyut4(Object obj) {
		this.obj = obj;

	}

	public double alan3k() {
		if (obj instanceof Daire) {
			Daire da = (Daire) obj;
			return 3 * da.alan();
		}

		else if (obj instanceof Dikdortgen) {
			Dikdortgen di = (Dikdortgen) obj;
			return 3 * di.alan();
		}
		return -1;
	}
}
