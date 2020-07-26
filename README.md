# AWIPA Appplication

![](dokumentasi/1.png)

## Use Case
![](dokumentasi/desktop.png)

## Kegunaan
Aplikasi ditujukan untuk penyimpanan file pada sebuah organisasi dengan tujuan untuk mengatasi masalah penyimpanan berkas berlebihan pada ruangan, sehingga dengan menggunakan aplikasi ini dapat menghemat tempat yang terdapat pada ruangan. aplikasi ini dilengkapi pula dengan beberapa fitur keamanan yang dapat digunakan untuk menjaga kerahasaiaan file dan data.

## Fitur Keamanan
1. Menggunakan hash pada database data
2. Menggunakan two factor authentication
3. Menggunakan enkripsi dan dekripsi file
4. Data akun user tidak disatukan, namun terpisah

## Requirements
- download xampp atau lampp
- jaringan internet
- Email Google (gmail)

## Installasi
1. download awipa.sh pada github
```c
$ git clone https://github.com/tambunanprd/ArsipSystem.git
```
2. masuk ke terminal linux, untuk melakukan instalasi input:
```c
$ chmod +x awipa.sh
$ ./awipa.sh
```
3. klik next seperti pada gambar\
![](dokumentasi/install/1.jpg)
![](dokumentasi/install/2.jpg)
![](dokumentasi/install/4.jpg)
![](dokumentasi/install/3.jpg)
4. aplikasi sudah di install pada komputer anda\
![](dokumentasi/aplikasi/1.jpg)



### Registrasi
jika anda belum memiliki akun maka lakukan registrasi dengan melakukan klik pada tulisan di bawah tombol login\
![](dokumentasi/registrasi/1.jpg)
1. masukkan email dan password yang ingin anda daftarkan, lalu klik send code\
![](dokumentasi/registrasi/2.jpg)
2. buka email yang kamu daftarkan untuk mendapatkan kode otp\
![](dokumentasi/registrasi/3.jpg)
3. masukkan kode otp yang telah dikirimkan\
![](dokumentasi/registrasi/4.jpg)

### Login
1. masukkan email dan password\
![](dokumentasi/aplikasi/2.jpg)
2. jika berhasil login, akan masuk pada halaman awal aplikasi\
![](dokumentasi/aplikasi/3.jpg)

### Fitur aplikasi
##### Enkripsi
pada fitur ini *user* dapat melakukan enkripsi file yang ada pada komputer tanpa harus menyimpannya pada aplikasi serta dapat pula melakukan enkripsi pada file yang telah disimpan pada aplikasi\
![](dokumentasi/fitur/1.jpg)\
klik tombol merah untuk melakukan enkripsi, lalu masukkan kunci untuk melakukan enkripsi\
![](dokumentasi/fitur/2.jpg)
![](dokumentasi/fitur/3.jpg)\
![](dokumentasi/fitur/4.jpg)

#### Dekripsi
pada fitur ini *user* dapat melakukan dekripsi file yang telah di enkripsi sebelumnya dengan menggunakan kunci yang sama\
![](dokumentasi/fitur/5.jpg)
![](dokumentasi/fitur/6.jpg)
![](dokumentasi/fitur/7.jpg)

#### Upload
pada fitur ini *user* dapat melakukan penyimpanan file pada aplikasi. pilih file yang ingin di upload, lalu klik upload dan masukkan username yang ingin di letakkan di database\
![](dokumentasi/fitur/8.jpg)
![](dokumentasi/fitur/9.jpg)

#### Download
pada fitur ini *user* dapat mendownload kembali file yang pernah di upload pada aplikasi. pilih aplikasi pada tabel lalu klik tombol download\
![](dokumentasi/fitur/10.jpg)

#### Logout
*user* dapat melakukan logout pada aplikasi setelah melakukan login.

### Uninstall
dapat dilakukan uninstall aplikasi dengan cara masuk ke folder hasil instalasi
```c
$ ./uninstall
```
![](dokumentasi/uninstall/1.jpg)
![](dokumentasi/uninstall/2.jpg)
