public class BankaS {

	public static void main(String[] args) {
		HesapS hesap = new HesapS(1000);
		VatandasS v = new VatandasS(hesap);
		HortumcuS ho = new HortumcuS(hesap);
		// Thread'ler baslasin
		v.start();
		ho.start();

		// Ara ara bakiyeye bakalim
		for (int i = 1; i <= 10; i++) {
			System.out.println(hesap.info());
			// Biraz beklet
			try {
				Thread.sleep(10);// 10 milisaniye
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		v.stop();
		ho.stop();

	}

}
