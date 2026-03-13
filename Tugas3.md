Tugas 1: Membuat Program di Server dengan API untuk CRUD KTP menggunakan Spring Boot dan MySQL

Database: Buat database MySQL dengan schema spring dan tabel KTP yang memiliki kolom berikut:

id (Int, Primary Key, Auto Increment)
nomorKtp (VARCHAR, Unique)
namaLengkap (VARCHAR)
alamat (VARCHAR)
tanggalLahir (DATE)
jenisKelamin (VARCHAR)
Spring Boot: Gunakan Spring Boot sebagai framework untuk membangun aplikasi server-side.

Implementasikan REST API dengan endpoint berikut:
POST /ktp: Untuk menambah data KTP baru.
GET /ktp: Untuk mengambil seluruh data KTP.
GET /ktp/{id}: Untuk mengambil data KTP berdasarkan id.
PUT /ktp/{id}: Untuk memperbarui data KTP berdasarkan id.
DELETE /ktp/{id}: Untuk menghapus data KTP berdasarkan id.
Controller: Buat controller di Spring Boot untuk menangani setiap request API dan menghubungkannya dengan service dan repository yang sesuai.

Service Layer: Implementasikan service untuk menangani logika bisnis, seperti validasi data dan proses CRUD.

Repository Layer: Gunakan Spring Data JPA untuk berinteraksi dengan database MySQL.

Error Handling: Pastikan terdapat validasi data dan penanganan error yang baik (contohnya, jika nomor KTP sudah ada atau data tidak ditemukan).

Documentation: Dokumentasikan API dan screenshot tampilan website ke dalam Readme

Tugas 2: Membuat Program Client-side menggunakan HTML, CSS, JavaScript, dan Ajax JQuery

HTML/CSS: Buat tampilan web sederhana yang berisi form untuk menambahkan, melihat, memperbarui, dan menghapus data KTP. Halaman tersebut minimal memiliki:

Form untuk memasukkan data KTP baru (Nomor KTP, Nama Lengkap, Alamat, Tanggal Lahir, Jenis Kelamin) untuk form tanggal lahir gunakan format date dan jenis kelamin menggunakan dropdown.
Tabel atau daftar untuk menampilkan data KTP yang ada.
Tombol untuk mengedit dan menghapus data KTP.
JavaScript (JQuery): Gunakan Ajax dengan JQuery untuk berinteraksi dengan API yang dibuat di server.

POST: Mengirim data baru ke API dan menambahkannya ke database.
GET: Mengambil data dari model API dan menampilkan di halaman web.
PUT: Memperbarui data KTP yang sudah ada.
DELETE: Menghapus data KTP berdasarkan id.
Ajax JQuery: Setiap operasi CRUD harus dilakukan tanpa refresh halaman dengan menggunakan Ajax untuk mengirimkan request ke API Spring Boot.

Feedback: Berikan notifikasi atau pesan kepada pengguna tentang hasil dari setiap operasi (misalnya, data berhasil ditambahkan, dihapus, atau jika terjadi error).