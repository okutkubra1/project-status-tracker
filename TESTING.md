# Test Kanıtları

Testler, uygulama lokal ortamda çalışırken IntelliJ içindeki `project-api.http` dosyası kullanılarak yapıldı.

## Başarılı Testler

| Senaryo | İstek | Sonuç |
|---|---|---|
| Uygulama sağlık kontrolü | `GET /api/health` | 200 - API çalışıyor |
| Proje oluşturma | `POST /api/projects` | 200 - Proje kaydedildi |
| Proje güncelleme | `PUT /api/projects/1` | 200 - Proje bilgileri güncellendi |
| Haftalık rapor oluşturma | `POST /api/weekly-reports` | 200 - Rapor proje id 1 ile ilişkilendirildi |
| Projeye ait raporları getirme | `GET /api/weekly-reports/project/1` | 200 - İlgili rapor listelendi |

## Hata Kayıtları ve Düzeltmeler

| Durum | Gözlenen Hata | Düzeltme |
|---|---|---|
| Proje id'si olmadan silme isteği | 405 Method Not Allowed | URL'ye `/{id}` eklenerek doğru DELETE isteği kullanıldı |
| Var olmayan proje id'si ile rapor ekleme | 500 No value present | Önce proje oluşturuldu ve geçerli proje id'si kullanıldı |

## Kalan Riskler

- H2 geçici bellek veritabanı kullanıldığı için uygulama yeniden başlatılınca test verileri silinir.
- Geçersiz id durumlarında daha açıklayıcı hata mesajları ve 404 yanıtları sonraki geliştirme aşamasında eklenmelidir.

## Hata Yönetimi Testleri

- `GET /api/projects/999` isteği başlangıçta 500 hatası döndürüyordu. `ResponseStatusException` kullanılarak 404 Not Found ve “Proje bulunamadı” mesajı dönecek şekilde güncellendi.
- Geçersiz proje id’siyle haftalık rapor ekleme isteği test edildi. İstek 404 Not Found döndü ve rapor kaydedilmedi.
- Hata cevaplarındaki teknik stack trace bilgisi `server.error.include-stacktrace=never` ayarıyla gizlendi.