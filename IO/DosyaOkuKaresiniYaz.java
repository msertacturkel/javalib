import java.util.Scanner;

public class DosyaOkuKaresiniYaz {

	public static void main(String[] args) {
		try {
			java.io.FileInputStream fi = new java.io.FileInputStream(
					"sayilar.txt");
			java.util.Scanner sc = new java.util.Scanner(fi);
			while (sc.hasNextLine()) {
				String satir = sc.nextLine();
				Scanner sc1=new Scanner(satir);
				while(sc1.hasNextInt()){
					int sayi=sc1.nextInt();
					System.out.print(sayi*sayi+"\t");
				}
				System.out.println();//satir atlatma
			}
		} catch (java.io.FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
