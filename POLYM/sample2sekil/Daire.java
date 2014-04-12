package sample2sekil;

	public class Daire extends Sekil {

		private double r;

		public Daire(double r) {
			this.r=r;
		}

		public double alan() {
			return Math.PI * r * r;
		}

		public double cevre() {
			return 2 * Math.PI * r;
		}
	}
