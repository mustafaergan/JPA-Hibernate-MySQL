# JPA ve Hibernate ile MySQL Örnekleri

JPA'yı Hibernate sağlayıcısıyla MySQL üzerinde anlatan küçük bir ders projesi: tek bir `Deneme` entity'si
üzerinden ekleme, okuma, güncelleme, JPQL, Criteria API ve native sorgu örnekleri.

> **Not:** Bu depo 2017 yılında eğitim amaçlı yazıldı ve artık güncellenmiyor. Bağımlılıkları eskidir ve
> bilinen güvenlik açıkları içerir; üretimde kullanmayın.

## İçerik

`JPAHello/src/com/mustafaergan/java/entity` altında, her biri kendi `main` metoduyla çalışan sınıflar:

| Sınıf | Ne gösterir |
|---|---|
| `Deneme` | Örneklerde kullanılan entity |
| `Islem` | `persist`, `find`, güncelleme, JPQL ile listeleme ve `LIKE` sorgusu, Criteria API ile seçim |
| `CriteriaQueryExample` | `CriteriaBuilder` ve parametreli Criteria sorguları |
| `NativeQue` | `createNativeQuery` ile SQL sorguları |
| `Security` | Bağlantı bilgilerini `persistence.xml` yerine kodda `Map` ile verip `EntityManagerFactory` oluşturma |

`src/META-INF/persistence.xml` iki persistence unit içerir: bağlantı bilgisi dosyada olan `JPAHello` ve bağlantı
bilgisini çalışırken alan `JPASecurity`.

## Teknolojiler

- Java 8, Maven
- JPA 2.1, Hibernate 5.2.10 (`hibernate-core`, `hibernate-entitymanager`)
- MySQL, `mysql-connector-java` 5.1.31

## Çalıştırma

1. Yerelde bir MySQL sunucusu çalıştırın ve `proje_takip` adında bir veritabanı oluşturun.
   Tablo, `hibernate.hbm2ddl.auto=update` ayarı sayesinde ilk çalıştırmada oluşturulur.
2. Veritabanı kullanıcı adı ve şifresini kendi kurulumunuza göre `JPAHello/src/META-INF/persistence.xml` ve
   `Security.java` içinde değiştirin.
3. `JPAHello` klasörünü Eclipse ya da IntelliJ'e Maven projesi olarak alın ve `Islem` sınıfını çalıştırın.
