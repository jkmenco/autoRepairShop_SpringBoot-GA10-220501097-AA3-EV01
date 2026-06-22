Guía para recrear db_credentials.properties

Este archivo es fundamental para mantener seguras las credenciales de conexión a la base de datos en tu proyecto autoRepairShop_SpringBoot. Aquí aprenderás cómo crearlo y configurarlo correctamente.

1. Ubicación del archivo

El archivo debe estar dentro de la carpeta de recursos del proyecto:

src/main/resources/db_credentials.properties

2. Contenido del archivo

Agrega las credenciales de tu base de datos Railway en formato clave=valor:

jdbc.url=jdbc:mysql:[pastehere]?useSSL=false&serverTimezone=UTC
jdbc.username=root
jdbc.password=[pastehere]

jdbc.url → La URL de conexión JDBC que incluye host, puerto y nombre de la base de datos.

jdbc.username → El usuario de la base de datos.

jdbc.password → La contraseña de la base de datos.

3. Uso en los DAOs

Cada clase DAO debe cargar este archivo para obtener las credenciales. Ejemplo:

try (InputStream input = getClass().getClassLoader().getResourceAsStream("db_credentials.properties")) {
    Properties prop = new Properties();
    prop.load(input);
    jdbcURL = prop.getProperty("jdbc.url");
    jdbcUsername = prop.getProperty("jdbc.username");
    jdbcPassword = prop.getProperty("jdbc.password");
}

4. Seguridad con Git

Para evitar subir credenciales al repositorio, añade la siguiente línea en tu archivo .gitignore:

src/main/resources/db_credentials.properties

De esta forma, el archivo será ignorado por Git y tus credenciales estarán protegidas.

5. Resultado esperado

El proyecto se conecta correctamente a la base de datos Railway.

Las credenciales están centralizadas en un único archivo.

No se exponen datos sensibles en el repositorio.

El código es más fácil de mantener y compartir.

Con esta guía podrás recrear el archivo db_credentials.properties en cualquier entorno de desarrollo y mantener tu aplicación segura.