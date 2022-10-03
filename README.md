# Tugas Besar 1 Aljabar Linear Geometri - IF2123

## Dibuat Oleh
1. Matthew Mahendra - 13521007
2. Jason Rivalino - 13521008
3. Agsha Athalla Nurkareem - 13521027

## Deskripsi Singkat
Program ini berisi kelas-kelas Java yang memuat metode pada matriks untuk menyelesaikan permasalahan-permasalahan seperti
penyelesaian sistem persamaan linear, determinan matriks, balikan matriks, maupun aplikasi-aplikasi metode tersebut pada
problem yang ada.

Program ini dibuat menggunakan bahasa Java.

## Penjelasan Direktori
Direktori `src` berisi source code dari program ini. Direktori `doc` berisi dokumen laporan. Direktori `test` berisi kumpulan
test file dalam bentuk .txt yang digunakan untuk menguji program. Direktori `bin` berisi kelas-kelas dari program Java yang sudah dibuat.

## Cara Menjalankan
Program dijalankan pada `Main.java`. Langkah-langkahnya sebagai berikut
1. Change Directory ke `src`
2. Ketikkan `javac -d ../bin Main.java`
3. Ketikkan `java -cp ../bin Main`
4. Program sudah dapat dijalankan

Saat memasuki program ada beberapa menu yang dapat dipilih
### Sistem Persamaan Linear (SPL)
Berfungsi untuk menyelesaikan sebuah SPL dengan 4 metode yang berbeda seperti Gauss, Gauss-Jordan, Invers SPL, atau Kaidah Sarrus-Crammer

### Determinan
Berfungsi untuk mengeluarkan hasil determinan masukan matriks (jika ada) menggunakan metode Kofaktor atau Reduksi Baris

### Matriks Balikan
Berfungsi untuk membuat invers dari matriks balikan dengan metode reduksi baris atau adjoin kofaktor

### Interpolasi Polinom
Membuat persamaan garis yang melalui titik-titik input dan mengestimasi nilai x asal

### Interpolasi Bicubic
Metode pembesaran data 2D. Melakukan interpolasi bicubic matriks berukuran 4x4

### Regresi Linear Berganda
Berfungsi untuk memprediksi nilai x asal berdasarkan data-data yang sudah diinput sebelumnya

Pemilihan Menu dilakukan melalui keyboard sesuai dengan keluaran program

## Hal Input Matriks
Program ini dapat menerima matriks melalui dua cara. Pertama melalui keyboard yaitu dengan menginput ukuran baris dan kolom dari matriks (atau untuk matriks persegi langsung ukuran matriks perseginya) kemudian menginput elemennya sesuai keluaran program. Kedua melalui file .txt. File .txt berisi matriks dan atau nilai yang akan diuji (untuk kasus interpolasi polinom dan bikubik serta regresi linear). File .txt ini dapat ditemukan di folder `test`. Untuk memasukkan matriks dari file .txt, cukup menuliskan nama filenya misal `regresi.txt` sesuai keluaran dari program.

## Hal Penyimpanan Hasil
Hasil dari operasi dapat disimpan di akhir operasi matriks. Pengguna diberi pilihan apabila ingin menyimpan atau tidak. Jika ingin menyimpan diberi masukan `1` dan jika tidak diberi masukan `0`. File penyimpanan berupa `.txt` dan disimpan pada folder `test`. Nama file ditentukan oleh pengguna dengan contoh masukan `hasilmatriks.txt`. Nama file yang dimasukkan harus mengandung ekstensi file `.txt`.