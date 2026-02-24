import java.util.Scanner;

public class Driver2 {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // 1. Input jumlah total data
        System.out.print("Masukkan jumlah total data: ");
        int N = input.nextInt();
        input.nextLine(); // membersihkan newline
        
        // Membuat array
        int[] nilai = new int[N];
        String[] kelompok = new String[N];
        
        // 2. Input nilai dan kode kelompok
        for (int i = 0; i < N; i++) {
            System.out.println("Data siswa ke-" + (i + 1));
            
            System.out.print("Nilai : ");
            nilai[i] = input.nextInt();
            input.nextLine(); 
            
            System.out.print("Kode Kelompok siswa: ");
            kelompok[i] = input.nextLine();
        }
        
        // 3. Input kode kelompok yang ingin dijumlahkan
        System.out.print("\nMasukkan kode kelompok yang ingin dijumlahkan: ");
        String cariKelompok = input.nextLine();
        
        int total = 0;
        boolean ditemukan = false; // penanda
        
        // Proses penjumlahan
        for (int i = 0; i < N; i++) {
            if (kelompok[i].equalsIgnoreCase(cariKelompok)) {
                total += nilai[i];
                ditemukan = true;
            }
        }
        
        // Output hasil
        if (ditemukan) {
            System.out.println("Total nilai untuk kelompok " + cariKelompok + " adalah: " + total);
        } else {
            System.out.println("Kode kelompok tersebut tidak ada.");
        }
        
        input.close();
    }
}
