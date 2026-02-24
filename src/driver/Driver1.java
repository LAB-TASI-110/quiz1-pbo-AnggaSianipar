import java.util.*;

public class Driver1 {

    static class Menu {
        String nama;
        int harga;

        Menu(String nama, int harga) {
            this.nama = nama;
            this.harga = harga;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Daftar Menu
        Map<String, Menu> daftarMenu = new HashMap<>();
        daftarMenu.put("NGS", new Menu("Nasi Goreng Spesial", 15000));
        daftarMenu.put("AP", new Menu("Ayam Penyet", 20000));
        daftarMenu.put("SA", new Menu("Sate Ayam", 25000));
        daftarMenu.put("BU", new Menu("Bakso Urat", 18000));
        daftarMenu.put("MAP", new Menu("Mie Ayam Pangsit", 15000));
        daftarMenu.put("GG", new Menu("Gado-Gado", 15000));
        daftarMenu.put("SAM", new Menu("Soto Ayam", 17000));
        daftarMenu.put("RD", new Menu("Rendang Daging", 25000));
        daftarMenu.put("IB", new Menu("Ikan Bakar", 35000));
        daftarMenu.put("NUK", new Menu("Nasi Uduk Komplit", 20000));

        List<String> kodePesanan = new ArrayList<>();
        List<Integer> porsiPesanan = new ArrayList<>();

        System.out.println("Masukkan pesanan Butet (ketik END untuk selesai)");

        while (true) {
            System.out.print("Kode makanan: ");
            String kode = sc.nextLine().toUpperCase();

            if (kode.equals("END")) break;

            if (!daftarMenu.containsKey(kode)) {
                System.out.println("Kode tidak valid!");
                continue;
            }

            System.out.print("Jumlah porsi: ");
            int porsi = Integer.parseInt(sc.nextLine());

            kodePesanan.add(kode);
            porsiPesanan.add(porsi);
        }

        int totalSemua = 0;

        System.out.println("\n===============================================================");
        System.out.printf("%-25s %-8s %-10s %-10s\n", "Menu", "Porsi", "Harga", "Total");
        System.out.println("---------------------------------------------------------------");

        for (int i = 0; i < kodePesanan.size(); i++) {

            String kode = kodePesanan.get(i);
            int porsiPr = porsiPesanan.get(i);

            int totalPorsi = porsiPr + (porsiPr * 2); // digabung
            // atau bisa juga: int totalPorsi = porsiPr * 3;

            Menu m = daftarMenu.get(kode);

            int totalHarga = totalPorsi * m.harga;
            totalSemua += totalHarga;

            System.out.printf("%-25s %-8d %-10d %-10d\n",
                    m.nama,
                    totalPorsi,
                    m.harga,
                    totalHarga);
        }

        System.out.println("---------------------------------------------------------------");

        // DISKON
        double diskon = 0;

        if (totalSemua >= 500000) diskon = 0.25;
        else if (totalSemua >= 400000) diskon = 0.20;
        else if (totalSemua >= 300000) diskon = 0.15;
        else if (totalSemua >= 200000) diskon = 0.10;
        else if (totalSemua >= 100000) diskon = 0.05;

        double potongan = totalSemua * diskon;
        double totalBayar = totalSemua - potongan;

        System.out.println("Total Belanja        : Rp" + totalSemua);
        System.out.println("===============================================================");
    }
}