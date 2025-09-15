# ToDo Uygulaması

Bu proje, Future tabanlı asenkron programlama ve katmanlı mimari kullanılarak geliştirilmiş bir Spring Boot uygulamasıdır.

## Özellikler

- Görev oluşturma, okuma, güncelleme ve silme (CRUD) işlemleri
- Asenkron işlemler için CompletableFuture kullanımı
- H2 veritabanı ile entegrasyon
- RESTful API endpoint'leri
- Global hata yönetimi
- Katmanlı mimari yapısı

## Teknolojiler

- Java 17
- Spring Boot 3.5.5
- Spring Data JPA
- H2 Database
- Lombok
- Maven

## Kurulum

1. Projeyi klonlayın:
   ```bash
   git clone [repo-url]
   cd todoapp
   ```

2. Uygulamayı çalıştırın:
   ```bash
   mvn spring-boot:run
   ```

3. Uygulama http://localhost:8080 adresinde çalışacaktır.

## API Endpoint'leri

### Tüm Görevleri Listele
```
GET /api/tasks
```

### ID ile Görev Getir
```
GET /api/tasks/{id}
```

### Yeni Görev Ekle
```
POST /api/tasks
Content-Type: application/json

{
    "title": "Alışveriş Yap",
    "description": "Market alışverişi yapılacak",
    "status": "PENDING",
    "dueDate": "2025-12-31T23:59:59"
}
```

### Görev Güncelle
```
PUT /api/tasks/{id}
Content-Type: application/json

{
    "title": "Güncellenmiş Görev",
    "description": "Güncellenmiş açıklama",
    "status": "IN_PROGRESS",
    "dueDate": "2025-12-31T23:59:59"
}
```

### Görev Sil
```
DELETE /api/tasks/{id}
```

### Duruma Göre Görevleri Listele
```
GET /api/tasks/status/{status}
```

### Görev Ara
```
GET /api/tasks/search?q=arama_terimi
```

## H2 Konsol

Uygulama çalışırken H2 veritabanı konsoluna erişmek için:
- URL: http://localhost:8080/h2-console
- JDBC URL: jdbc:h2:mem:tododb
- Username: sa
- Password: password

## Katmanlı Mimari

Proje aşağıdaki katmanlardan oluşmaktadır:

- **Controller**: HTTP isteklerini işler ve yanıtları döndürür
- **Service**: İş mantığını içerir
- **Repository**: Veritabanı işlemlerini yönetir
- **Model**: Veri modellerini içerir
- **DTO**: Veri transfer nesnelerini içerir
- **Exception**: Özel istisna sınıflarını içerir

## Lisans

Bu proje MIT lisansı altında lisanslanmıştır.
