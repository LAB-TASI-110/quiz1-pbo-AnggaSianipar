import java.util.Scanner;

public class Driver3 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int totalMahasiswa = 0;

        
        
        // Tampilan awal
        System.out.println("===================================");
        System.out.println("Selamat datang di Laundry Del");
        System.out.println("Siap melayani anda");
        System.out.println("*****(BINTANG 5)");
        System.out.println("===================================");

        // Stok laundry
        System.out.println("Stok Laundry:");
        System.out.println("Detergen : Ready");
        System.out.println("Pewangi  : Ready");
        System.out.println("Plastik  : Ready");
        System.out.println("===================================");

        while (true) {
            System.out.print("Masukkan berat laundry (kg) atau ketik END untuk selesai: ");
            String data = input.nextLine();

            if (data.equalsIgnoreCase("END")) {
                break;
            }

            try {
                double berat = Double.parseDouble(data);

                System.out.println("Berat laundry: " + berat + " kg");

                if (berat > 7) {
                    System.out.println("Status: Tidak Memenuhi Syarat");
                    System.out.println("Laundry tidak dapat diproses karena melebihi 7 kg.");
                } else if (berat <= 0) {
                    System.out.println("Berat tidak valid!");
                } else {
                    System.out.println("Status: Memenuhi Syarat");
                    System.out.println("Laundry sedang diproses...");
                    System.out.println("Laundry anda sudah selesai dan siap di antarkan");
                    totalMahasiswa++;
                }

                System.out.println("-----------------------------------");

            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid! Masukkan angka atau END.");
            }
        }

        System.out.println("===================================");
        System.out.println("Total mahasiswa yang menggunakan laundry: " + totalMahasiswa);
        System.out.println("Terima kasih telah menggunakan Laundry Del");
        System.out.println("===================================");

        input.close();
    }
}