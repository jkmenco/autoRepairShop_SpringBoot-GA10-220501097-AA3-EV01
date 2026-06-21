# Auto Repair Shop - Spring Boot

Aplicación web para gestionar una tienda de reparación de automóviles, desarrollada con **Spring Boot 3.2.5**, **Java 17** y **MySQL**.

## 📋 Descripción del Proyecto

**autoRepairShop_SpringBoot** es una aplicación web que permite:
- Autenticar usuarios mediante un sistema de login
- Gestionar productos/servicios de reparación
- Visualizar el catálogo de productos disponibles
- Administrar información de usuarios

## 🏗️ Arquitectura

El proyecto sigue una arquitectura en capas:

```
com.autorepairshop/
├── controller/          # Controladores web (MVC)
│   ├── LoginController
│   └── ProductController
├── dao/                 # Data Access Objects (JDBC)
│   ├── ProductDAO
│   └── UserDAO
└── model/               # Modelos de datos
    ├── Product
    └── User
```

## 🛠️ Tecnologías Utilizadas

| Tecnología | Versión | Descripción |
|-----------|---------|-------------|
| **Spring Boot** | 3.2.5 | Framework principal |
| **Java** | 17 | Lenguaje de programación |
| **MySQL** | - | Base de datos |
| **Thymeleaf** | Latest | Motor de plantillas HTML |
| **Spring JDBC** | Latest | Acceso a base de datos |
| **Maven** | 3.x+ | Gestor de dependencias |
| **Jakarta Servlet API** | 6.0.0 | API de servlets |

## 📦 Dependencias Principales

```xml
- spring-boot-starter-web
- spring-boot-starter-jdbc
- spring-boot-starter-thymeleaf
- mysql-connector-java:8.0.33
- spring-boot-starter-test (testing)
```

## ✅ Requisitos Previos

- **Java 17** o superior
- **Maven 3.6+**
- **MySQL 5.7+** o **MySQL 8.0+**
- **Git** (opcional)

## 🚀 Instalación y Configuración

### 1. Clonar el Repositorio

```bash
git clone <url-del-repositorio>
cd autoRepairShop_SpringBoot
```

### 2. Configurar la Base de Datos

Crear la base de datos en MySQL:

```sql
CREATE DATABASE autorepairshop;
```

### 3. Configurar `application.properties`

Editar el archivo `src/main/resources/application.properties`:

```properties
# Configuración de la base de datos
spring.datasource.url=jdbc:mysql://localhost:3306/autorepairshop
spring.datasource.username=root
spring.datasource.password=tu_contraseña
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# Configuración de la aplicación
server.port=8080
spring.application.name=autoRepairShop_SpringBoot

# Thymeleaf
spring.thymeleaf.prefix=classpath:/templates/
spring.thymeleaf.suffix=.html
```

### 4. Compilar el Proyecto

```bash
mvn clean install
```

## 🎯 Ejecución

### Opción 1: Ejecutar con Maven

```bash
mvn spring-boot:run
```

### Opción 2: Ejecutar el JAR

```bash
java -jar target/autoRepairShop_SpringBoot-0.0.1-SNAPSHOT.jar
```

### Acceder a la Aplicación

Una vez iniciada, acceder a:
```
http://localhost:8080
```

## 📁 Estructura de Archivos

```
autoRepairShop_SpringBoot/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/autorepairshop/
│   │   │       ├── AutoRepairShopApplication.java (Main)
│   │   │       ├── controller/
│   │   │       │   ├── LoginController.java
│   │   │       │   └── ProductController.java
│   │   │       ├── dao/
│   │   │       │   ├── ProductDAO.java
│   │   │       │   └── UserDAO.java
│   │   │       └── model/
│   │   │           ├── Product.java
│   │   │           └── User.java
│   │   └── resources/
│   │       ├── application.properties
│   │       └── templates/
│   │           ├── login.html
│   │           └── products.html
│   └── test/
│       └── java/com/example/demo/
├── pom.xml (Configuración Maven)
├── mvnw / mvnw.cmd (Maven Wrapper)
├── railway.yml (Configuración Railway.app)
└── README.md
```

## 🔑 Características Principales

### 🔐 Autenticación
- Sistema de login para usuarios
- Validación de credenciales contra la base de datos

### 📦 Gestión de Productos
- Listado de productos/servicios disponibles
- Vista de detalles de productos
- Interfaz web con Thymeleaf

### 💾 Persistencia de Datos
- Conexión a MySQL mediante JDBC
- DAOs para acceso a datos
- Operaciones CRUD básicas

## 🧪 Testing

Ejecutar los tests:

```bash
mvn test
```

El proyecto incluye dependencias de testing con **JUnit 5** y **Spring Boot Test**.

## 🐛 Resolución de Problemas

### Error de conexión a MySQL
- Verificar que MySQL esté ejecutándose
- Confirmar las credenciales en `application.properties`
- Verificar que la base de datos existe: `SHOW DATABASES;`

### Puerto 8080 en uso
- Cambiar el puerto en `application.properties`:
  ```properties
  server.port=8081
  ```

### Errores de compilación
```bash
# Limpiar cache de Maven
mvn clean
# Reinstalar dependencias
mvn install
```

## 🚢 Deployment

### En Railway.app
El proyecto incluye `railway.yml` para deployment automático:

```bash
railway link
railway up
```

## 📝 Notas de Desarrollo

- Versión actual: **0.0.1-SNAPSHOT**
- Java Version: **17**
- Spring Boot Version: **3.2.5**
- Estado: En desarrollo

## 🤝 Contribuir

Para contribuir al proyecto:

1. Crear una rama para tu feature (`git checkout -b feature/AmazingFeature`)
2. Commit cambios (`git commit -m 'Add AmazingFeature'`)
3. Push a la rama (`git push origin feature/AmazingFeature`)
4. Abrir un Pull Request

## 📄 Licencia

Este proyecto está bajo licencia MIT.

## 👨‍💻 Autor

Proyecto desarrollado con Spring Boot.

---

**Última actualización:** Junio 2026

Para más información sobre Spring Boot, visita: [spring.io](https://spring.io)
