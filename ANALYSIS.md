# Kısa Analiz Dokümanı

## Problem

Proje yöneticileri ve yöneticiler, projelerin güncel durumunu ve haftalık ilerlemesini tek ekrandan takip etmek ister. Bilgilerin farklı yerlerde tutulması takip sürecini zorlaştırır ve zaman kaybettirir.

## Roller

- Admin: Sistem ve kullanıcı yönetiminden sorumludur.
- Proje Yöneticisi: Proje oluşturur ve proje bilgilerini günceller.
- Ekip Lideri: Proje ilerlemesini ve haftalık raporları takip eder.
- CTO / Yönetici: Projelerin genel durumunu ve raporlarını görüntüler.

## MVP Kapsamı

- Proje oluşturma, listeleme, güncelleme ve silme
- Haftalık rapor oluşturma ve listeleme
- Haftalık raporun ilgili projeye bağlanması
- Belirli bir projeye ait raporların getirilmesi
- Lokal H2 veritabanı ile çalıştırma ve HTTP istekleriyle test

## Kapsam Dışı

- Kullanıcı yönetimi ve rol bazlı yetkilendirme
- WorkItem yönetimi
- Web arayüzü
- Kalıcı üretim veritabanı ve deployment

## Kullanıcı Akışları

1. Proje yöneticisi yeni bir proje oluşturur.
2. Projenin bilgileri gerektiğinde güncellenir.
3. Haftalık rapor, proje id'si kullanılarak ilgili projeye bağlanır.
4. Yönetici, bir projenin haftalık raporlarını görüntüler.

## Veri Yapısı

### Project

`id`, `name`, `description`, `startDate`, `deadline`

### WeeklyReport

`id`, `weekStartDate`, `completionPercentage`, `completedWork`, `risksOrBlockers`, `project`

Bir proje birden fazla haftalık rapora sahip olabilir.

## Kabul Kriterleri

- Proje CRUD işlemleri API üzerinden çalışmalıdır.
- Haftalık rapor bir projeye bağlı olarak kaydedilmelidir.
- Belirli bir projenin raporları filtrelenerek getirilmelidir.
- Uygulama lokal ortamda çalıştırılabilmelidir.

## Açık Konular ve Riskler

- Yetkilendirme kuralları netleştirilmelidir.
- H2 geçici bellek veritabanı olduğu için veriler uygulama yeniden başlayınca silinir.
- WorkItem ve kullanıcı yönetimi sonraki geliştirme aşamasına bırakılmıştır.