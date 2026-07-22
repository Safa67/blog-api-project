# Blog API Project - Pera Soft

Bu proje, **Pera Soft** teknik staj programı kapsamında geliştirilmiş kapsamlı bir RESTful API servisidir. Proje, modern yazılım mühendisliği standartlarına uygun olarak katmanlı mimari ile tasarlanmış ve veri izolasyonu için DTO deseni kullanılmıştır.

## 🚀 Kullanılan Teknolojiler
- **Java 21+**
- **Spring Boot 4.1.x** (Web, Data JPA, Validation)
- **PostgreSQL** (Docker üzerinden çalıştırılmıştır)
- **Docker & Docker Compose** (Veritabanı izolasyonu ve kalıcılığı)
- **Maven** (Bağımlılık yönetimi)
- **Lombok** (Boilerplate kod azaltımı)

## 🏗️ Mimari ve Temel Özellikler
- **Katmanlı Mimari:** Controller, Service ve Repository katmanları birbirinden tamamen izole edilmiştir.
- **DTO Deseni:** İstemci ile sunucu arasındaki veri transferi, veritabanı varlıklarından (Entity) bağımsız DTO'lar üzerinden sağlanmaktadır.
- **Sayfalama (Pagination):** Büyük veri setlerinin (Blog, Comment, User) performanslı bir şekilde getirilmesi için Spring Data `Pageable` entegrasyonu yapılmıştır.
- **İlişkisel Veritabanı Tasarımı:** One-to-Many (Yazar-Blog, Kategori-Blog) ve Many-to-Many (Blog-Etiket) ilişkiler doğru yapılandırılmıştır.
- **Global Exception Handling:** Bulunamayan kaynaklar (`ResourceNotFoundException`) ve doğrulama (Validation) hataları merkezi olarak yönetilmektedir.

## 🛠️ Kurulum ve Çalıştırma

Projeyi yerel ortamınızda çalıştırmak için aşağıdaki adımları izleyebilirsiniz.

### 1. Projeyi Klonlayın
```bash
git clone https://github.com/Safa67/blog-api-project.git
cd blog-api-project
```

### 2. Veritabanını Ayağa Kaldırın
Proje, veritabanı olarak PostgreSQL kullanmaktadır. Docker yüklü sisteminizde aşağıdaki komutla veritabanını başlatabilirsiniz:
```bash
docker-compose up -d
```
*(Not: Veritabanı dosyaları `blog_db_data` klasöründe tutulacak olup, `.gitignore` ile repodan izole edilmiştir.)*

### 3. Projeyi Derleyin ve Çalıştırın
```bash
mvn clean install
mvn spring-boot:run
```

## 📌 API Uç Noktaları (Endpoints)

Tüm Controller sınıfları incelenerek projedeki uç noktalar aşağıda listelenmiştir.

### Kullanıcı (User) İşlemleri
- `POST /api/user` - Yeni kullanıcı oluşturur.
- `GET /api/user/{id}` - ID'ye göre kullanıcı getirir.
- `GET /api/user` - Kullanıcıları sayfalamalı getirir (Varsayılan: `?page=0&size=10`).
- `PUT /api/user/{id}` - Kullanıcı bilgilerini günceller.
- `DELETE /api/user/{id}` - ID'ye göre kullanıcıyı siler.

### Blog İşlemleri
- `POST /api/blogs` - Yeni blog yazısı oluşturur.
- `GET /api/blogs/{id}` - ID'ye göre blog yazısı getirir.
- `GET /api/blogs` - Blog yazılarını sayfalamalı getirir (Varsayılan: `?page=0&size=10`).
- `PUT /api/blogs/{id}` - Blog yazısını günceller.
- `DELETE /api/blogs/{id}` - ID'ye göre blog yazısını siler.

### Kategori (Category) İşlemleri
- `POST /api/categories` - Yeni kategori oluşturur.
- `GET /api/categories/{id}` - ID'ye göre kategori getirir.
- `GET /api/categories` - Tüm kategorileri liste olarak getirir (Sayfalama yoktur).
- `PUT /api/categories/{id}` - Kategori bilgilerini günceller.
- `DELETE /api/categories/{id}` - ID'ye göre kategoriyi siler.

### Etiket (Tag) İşlemleri
- `POST /api/tag` - Yeni etiket oluşturur.
- `GET /api/tag/{id}` - ID'ye göre etiket getirir.
- `GET /api/tag` - Tüm etiketleri liste olarak getirir (Sayfalama yoktur).
- `PUT /api/tag/{id}` - Etiket bilgilerini günceller.
- `DELETE /api/tag/{id}` - ID'ye göre etiketi siler.

### Yorum (Comment) İşlemleri
- `POST /api/comment` - Blog yazısına yorum ekler.
- `GET /api/comment/{id}` - ID'ye göre yorum getirir.
- `GET /api/comment` - Yorumları sayfalamalı getirir (Varsayılan: `?page=0&size=10`).
- `PUT /api/comment/{id}` - Yorumu günceller.
- `DELETE /api/comment/{id}` - ID'ye göre yorumu siler.

---
*Geliştirici: Safa - Trakya Üniversitesi Bilgisayar Mühendisliği*
