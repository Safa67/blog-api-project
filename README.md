# Blog API & Web UI Project - Pera Soft

Bu proje, **Pera Soft** teknik staj programı kapsamında geliştirilmiş kapsamlı bir RESTful API ve Web servisidir. Proje, modern yazılım mühendisliği standartlarına uygun olarak katmanlı mimari ile tasarlanmış, veri izolasyonu için DTO deseni kullanılmış ve kullanıcı güvenliği için Spring Security ile donatılmıştır.

## 🚀 Kullanılan Teknolojiler
- **Java 21+**
- **Spring Boot 4.1.x** (Web, Data JPA, Validation, Security)
- **Spring Security** (Oturum yönetimi, Kimlik Doğrulama ve Yetkilendirme)
- **Thymeleaf & Spring Security Dialect** (Sunucu taraflı dinamik HTML)
- **MapStruct** (Entity-DTO arası otomatik haritalama)
- **PostgreSQL / H2** (Veritabanı yönetimi)
- **Docker & Docker Compose** (Veritabanı izolasyonu ve kalıcılığı)
- **Maven** (Bağımlılık yönetimi)
- **Lombok** (Boilerplate kod azaltımı)

## 🏗️ Mimari ve Temel Özellikler
- **Katmanlı Mimari:** Controller, Service ve Repository katmanları birbirinden tamamen izole edilmiştir.
- **Güvenlik (Security) ve Yetkilendirme (Authorization):** Kullanıcı kayıt/giriş işlemleri yönetilir. Kullanıcılar sadece kendi oluşturdukları Blog ve Yorumları silebilirler. Form bazlı (Session) otantikasyon kullanılır.
- **UI (Kullanıcı Arayüzü):** Thymeleaf kullanılarak dinamik sayfalar (`index`, `post-details`, `login`, `register`, `create-post`) oluşturulmuş, kullanıcı giriş durumuna göre menüler değişken hale getirilmiştir.
- **DTO ve MapStruct:** İstemci ile sunucu arasındaki veri transferi, veritabanı varlıklarından bağımsız DTO'lar üzerinden `MapStruct` ile sağlanmaktadır.
- **Sayfalama ve Sıralama:** Büyük veri setleri (Blog, Comment) `Pageable` ile sayfalama yapılarak çekilir ve en yeni gönderiler en üstte olacak şekilde otomatik sıralanır.
- **İlişkisel Veritabanı ve Cascade:** Veritabanı ilişkileri (OneToMany, ManyToMany) doğru kurulmuş, Cascade yapıları (Post silinince yorumların da silinmesi) kurgulanmıştır.
- **Global Exception Handling:** Hatalar ve Unique Constraint çakışmaları (Örn: Aynı kullanıcı adıyla kayıt olma) merkezi olarak yönetilip kullanıcıya şık bir dille yansıtılır.

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

## 📌 Sayfalar ve Uç Noktalar (Endpoints)

### 🖥️ Web UI (Thymeleaf) Sayfaları
- `GET /home` - Anasayfa (Tüm blog yazıları kronolojik olarak listelenir).
- `GET /login` - Kullanıcı giriş ekranı.
- `GET /register` - Yeni kullanıcı kayıt ekranı.
- `GET /create-post` - Blog oluşturma ekranı (Sadece giriş yapmış kullanıcılar).
- `GET /categories` - Kategoriler sayfası.
- `GET /blog/{id}` - Blog detayı ve yorumları okuma sayfası.
- `POST /blog/{id}/delete` - Sadece post sahibinin kullanabileceği blog silme işlemi.
- `POST /comment/{id}/delete` - Sadece yorum sahibinin kullanabileceği yorum silme işlemi.

### ⚙️ REST API Uç Noktaları
Projeye ait saf veri dönüşleri (JSON) yapan API uç noktaları aşağıdadır:

#### Kullanıcı (User) İşlemleri
- `POST /api/user` - Yeni kullanıcı oluşturur.
- `GET /api/user/{id}` - ID'ye göre kullanıcı getirir.
- `GET /api/user` - Kullanıcıları sayfalamalı getirir (Varsayılan: `?page=0&size=10`).
- `PUT /api/user/{id}` - Kullanıcı bilgilerini günceller.
- `DELETE /api/user/{id}` - ID'ye göre kullanıcıyı siler.

#### Blog İşlemleri
- `POST /api/blogs` - Yeni blog yazısı oluşturur.
- `GET /api/blogs/{id}` - ID'ye göre blog yazısı getirir.
- `GET /api/blogs` - Blog yazılarını sayfalamalı getirir (Varsayılan: `?page=0&size=10`).
- `PUT /api/blogs/{id}` - Blog yazısını günceller.
- `DELETE /api/blogs/{id}` - ID'ye göre blog yazısını siler.

#### Kategori (Category) İşlemleri
- `POST /api/categories` - Yeni kategori oluşturur.
- `GET /api/categories/{id}` - ID'ye göre kategori getirir.
- `GET /api/categories` - Tüm kategorileri liste olarak getirir (Sayfalama yoktur).
- `PUT /api/categories/{id}` - Kategori bilgilerini günceller.
- `DELETE /api/categories/{id}` - ID'ye göre kategoriyi siler.

#### Etiket (Tag) İşlemleri
- `POST /api/tag` - Yeni etiket oluşturur.
- `GET /api/tag/{id}` - ID'ye göre etiket getirir.
- `GET /api/tag` - Tüm etiketleri liste olarak getirir (Sayfalama yoktur).
- `PUT /api/tag/{id}` - Etiket bilgilerini günceller.
- `DELETE /api/tag/{id}` - ID'ye göre etiketi siler.

#### Yorum (Comment) İşlemleri
- `POST /api/comment` - Blog yazısına yorum ekler.
- `GET /api/comment/{id}` - ID'ye göre yorum getirir.
- `GET /api/comment` - Yorumları sayfalamalı getirir (Varsayılan: `?page=0&size=10`).
- `PUT /api/comment/{id}` - Yorumu günceller.
- `DELETE /api/comment/{id}` - ID'ye göre yorumu siler.

---
*Geliştirici: Safa - Trakya Üniversitesi Bilgisayar Mühendisliği*
