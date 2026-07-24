# Project Status Tracker

Spring Boot ile geliştirilen proje ve haftalık rapor takip backend uygulamasıdır.

## Proje Amacı

Projelerin temel bilgilerini, ilerleme durumlarını ve haftalık raporlarını tek bir sistem üzerinden takip etmeyi amaçlar.

## Mevcut Özellikler

- Proje oluşturma, listeleme, güncelleme ve silme
- Haftalık rapor oluşturma ve listeleme
- Haftalık raporu ilgili projeye bağlama
- Belirli bir projeye ait raporları getirme

## Kullanılan Teknolojiler

- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA
- H2 Database
- Lombok
- Maven

## Uygulamayı Çalıştırma

1. Projeyi bilgisayarınıza indirin.
2. JDK 21 kurulu olmalıdır.
3. Proje klasöründe aşağıdaki komutu çalıştırın:


mvnw.cmd spring-boot:run

## API Adresleri

- `GET /api/health` — Uygulama sağlık kontrolü
- `GET /api/projects` — Projeleri listeleme
- `POST /api/projects` — Proje oluşturma
- `GET /api/projects/{id}` — Tek proje getirme
- `PUT /api/projects/{id}` — Proje güncelleme
- `DELETE /api/projects/{id}` — Proje silme
- `GET /api/weekly-reports` — Raporları listeleme
- `POST /api/weekly-reports` — Haftalık rapor oluşturma
- `GET /api/weekly-reports/project/{projectId}` — Projeye ait raporları getirme

## Test

API istekleri IntelliJ içindeki `project-api.http` dosyası ile test edilmiştir.

## Bilinen Eksikler

- H2 geçici bellek veritabanı kullanıldığı için uygulama yeniden başladığında test verileri silinir.
- Kullanıcı yönetimi, yetkilendirme ve arayüz sonraki geliştirme aşamalarında eklenecektir.