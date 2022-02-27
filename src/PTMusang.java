import java.util.Scanner;
import java.util.Vector;
import java.util.Iterator;
import java.util.Random;

public class PTMusang {
Random r = new Random ();
Scanner sc = new Scanner(System.in);

String kode, kodeHuruf, nama, jenisKelamin, jabatan;
Integer kodeAngka, gaji;

Vector<String> KodeHuruf = new Vector<String>();
Vector<String> KodeKaryawan = new Vector<String>();
Vector<String> NamaKaryawan = new Vector<String>();
Vector<String> KelaminKaryawan = new Vector<String>();
Vector<String> JabatanKaryawan = new Vector<String>();
Vector<Integer> GajiKaryawan = new Vector<Integer>();
Vector<Integer> KodeAngka = new Vector<Integer>();

public PTMusang() {
	  Menu();
  }
  
public void Menu() {
	
	int choose; 
	  do {
		  System.out.println("Data Karyawan PT Musang");
		  System.out.println("_______________________");
		  System.out.println("1. Insert Data");
		  System.out.println("2. View Data  ");
		  System.out.println("3. Update Data");
		  System.out.println("4. Delete Data");
		  System.out.println("_______________________");
		  System.out.print("Masukan Input =  ");
		  choose = sc.nextInt();sc.nextLine();
			
		if (choose < 1 || choose > 4) {
			System.out.println("Pilih Angka Yang Benar !");
			System.out.println("________________________");
			}
	    else {
	    	
		switch (choose) {
		case 1:
			Insert();
			break;

		case 2:
			View();
			break;
			
		case 3:
			Update();
			break;
			
		case 4:
			Delete();
			break;
		}
		}
	} while (choose >1 || choose <4);
}
		 
public void Insert() {
	
	int min = 1000;
	int max = 9999;
	int range = max - min + 1 ;
	int angka = ((int) (Math.random()*range)+ min );
	
	String pertama = Character.toString( (char) ('A' + r.nextInt(26)));
	String kedua = Character.toString( (char) ('A' + r.nextInt(26)));
	
		do {
			System.out.print("Tulis Nama Karyawan [Min 3 huruf]: ");
			nama = sc.nextLine();
		} while (nama.length()<3);
		    	
		do {
			System.out.print("Jenis Kelamin [Laki-laki / Perempuan] (Case Sensitive): ");
			jenisKelamin = sc.nextLine();
		} while (!(jenisKelamin.equals("Laki-laki") || jenisKelamin.equals("Perempuan")));
		
		do {
			System.out.print("Jabatan [Manager / Supervisor / Admin] (Case Sensitive): ");
			jabatan = sc.nextLine();
			
			if (jabatan.equals("Manager")) {
				gaji = 8000000;	
			}
			else if (jabatan.equals("Supervisor")) {
				gaji = 6000000;
			}
			else {
				gaji = 4000000;
			}
		} while (!(jabatan.equals("Manager") || jabatan.equals("Supervisor") || jabatan.equals("Admin")));
		
		kodeHuruf = pertama + kedua;
		kodeAngka = angka;
		String kodekaryawan = kodeHuruf +"-"+ kodeAngka;
		System.out.println("Berhasil Menambahkan Karyawan Dengan ID : " + kodekaryawan);
		System.out.println("Tekan enter untuk kembali ke menu");
	
		KodeKaryawan.add(kodekaryawan);
		NamaKaryawan.add(nama);
		KelaminKaryawan.add(jenisKelamin);
		JabatanKaryawan.add(jabatan);
		GajiKaryawan.add(gaji);
		
		sc.nextLine();
		}
	
public void View() {
		
		if (NamaKaryawan.isEmpty()) {
			System.out.println("Tidak ada nama didalam data");
			System.out.println("___________________________");
			Menu();
		}
		else {
			
			System.out.println("No | Kode Karyawan | Nama Karyawan | Jenis Kelamin | Jabatan | Gaji Karyawan |");
			System.out.println("------------------------------------------------------------------------------");
		
		for (int i = 0; i < NamaKaryawan.size(); i++) {
		    System.out.println((i+1) + " | " + KodeKaryawan.get(i) + " | " + NamaKaryawan.get(i) + " | " + KelaminKaryawan.get(i) + " | " + JabatanKaryawan.get(i) +" | " + GajiKaryawan.get(i) + " | ");
		}
		    System.out.println("------------------------------------------------------------------------------");
		    System.out.println("Tekan enter untuk kembali ke menu");
		    sc.nextLine();
		}
	}
	
public void Update() {
	View();
	
	Integer choose, newGajiKaryawan;
	String newNamaKaryawan, newKelaminKaryawan, newJabatanKaryawan;
	
	do {
		System.out.println("Input Nomor Urutan Karyawan yang ingin diupdate :");
		choose = sc.nextInt(); sc.nextLine();
	} while (choose < 1 || choose > NamaKaryawan.size());
	
	do {
		System.out.println("Input Nama Karyawan :");
		newNamaKaryawan = sc.nextLine();
	} while (newNamaKaryawan.length() < 3);
	
	do {
		System.out.println("Input Jenis Kelamin Karyawan [Laki-laki / Perempuan]:");
		newKelaminKaryawan = sc.nextLine();
	} while (!(newKelaminKaryawan.equals ("Laki-laki") || newKelaminKaryawan.equals ("Perempuan")));
	
	do {
		System.out.println("Input Jabatan Karyawan [Manager/ Supervisor/ Admin] :");
		newJabatanKaryawan = sc.nextLine();
		
	if (newJabatanKaryawan.equals ("Manager")) {
		
	}
		if (newJabatanKaryawan.equals("Manager")) {
			newGajiKaryawan = 8000000;
		}
		else if (newJabatanKaryawan.equals("Supervisor")) {
			newGajiKaryawan = 6000000;
		}
		else {
			newGajiKaryawan = 4000000;
		}
		if (newJabatanKaryawan.equals("Manager") || newJabatanKaryawan.equals("Supervisor") || newJabatanKaryawan.equals("Admin")) {
			JabatanKaryawan.set(choose-1, newJabatanKaryawan);
			GajiKaryawan.set(choose-1, newGajiKaryawan);
		}
		else if (newJabatanKaryawan.equals("0")) {
			
		}
	} while (!(newJabatanKaryawan.equals("Manager") || newJabatanKaryawan.equals("Supervisor") || newJabatanKaryawan.equals("Admin") || newJabatanKaryawan.equals("0")));

	NamaKaryawan.set(choose-1, newNamaKaryawan);
	KelaminKaryawan.set(choose-1, newKelaminKaryawan);
	JabatanKaryawan.set(choose-1, newJabatanKaryawan);
	GajiKaryawan.set(choose-1, newGajiKaryawan);

	
	    System.out.println("Berhasil Mengupdate Data Karyawan dengan  ID : " + KodeKaryawan);
		System.out.println("Tekan enter untuk kembali ke menu");sc.nextLine();
	}

public void Delete() {
		View();
		
		int choose;

		do {
			System.out.print("Nomor urutan karyawan yang ingin dihapus: ");
			choose = sc.nextInt();sc.nextLine();
		} while (choose < 1 || choose > NamaKaryawan.size());

		System.out.println("Karyawan berhasil dihapus");
		
		NamaKaryawan.remove(choose-1);
		KodeKaryawan.remove(choose-1);
		KelaminKaryawan.remove(choose-1);
		JabatanKaryawan.remove(choose-1);
		GajiKaryawan.remove(choose-1);
		
		System.out.println("Tekan enter untuk kembali ke awal");
		sc.nextLine();
	}

public static void main(String[] args) {
		new PTMusang();

	}

}
