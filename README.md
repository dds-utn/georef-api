# Georef - API
En este repositorio encontrarás un ejemplo de consumo de una API real: **Georef**.
La intención es mostrar, a través de la implementación en código Java, cómo consumir una API.  Para lograr esto, se utiliza la biblioteca **Retrofit**, quien ayuda a realizar las requests de una forma más sencilla.

### Sobre Georef
Georef es la API del Servicio de Normalización de Datos Geográficos de Argentina, provisto por la secretaría de Modernización - Presidencia de La Nación.
Dejamos a disposición el [link](https://datosgobar.github.io/georef-ar-api/ "Página oficial de Georef") a la fuente oficial.

### Sobre Retrofit
Retrofit es una biblioteca que implementa un cliente HTTP para Java y Kotlin (Android).
Su utilización es muy sencilla y es por este motivo que optamos por ella y no por otras.
Las dependencias de Maven que se deberán tener en cuenta para su utilización son:
```maven
<dependency>
  <groupId>com.squareup.retrofit2</groupId>
  <artifactId>retrofit</artifactId>
  <version>2.5.0</version>
</dependency>
```

```maven
<dependency>
  <groupId>com.squareup.retrofit2</groupId>
  <artifactId>converter-gson</artifactId>
  <version>2.5.0</version>
</dependency>
```

Dejamos a disposición el [link](https://square.github.io/retrofit/ "Página oficial de Retrofit") a su página oficial.

### Consultas realizadas
Las consultas que se realizan a la API de Georef en el presente ejemplo son dos, a saber:
1.  Listar las provincias de la República Argentina:
	- Método HTTP: GET
	- URI: https://apis.datos.gob.ar/georef/api/provincias
	- Parámetros de la query:
		- campos (id, nombre por ejemplo)
	- Ejemplo de request: https://apis.datos.gob.ar/georef/api/provincias?campos=id,nombre
	- Ejemplo de respuesta:
	```json
	{
    "provincias": [
        {
            "nombre": "Chaco",
            "id": "22"
        },
    ],
    "cantidad": 24,
    "total": 24,
    "inicio": 0,
    "parametros": {}
	}
	```
2. Listar los municipios de una provincia en particular
	- Método HTTP: GET
	- URI: https://apis.datos.gob.ar/georef/api/municipios
	- Parámetros de la query: 
		- provincia (el int que representa el id de la provincia)
		- campos (id, nombre por ejemplo)
		- max (cantidad máxima de registros a traer en la consulta)
	- Ejemplo de request: https://apis.datos.gob.ar/georef/api/municipios?provincia=22&campos=id,nombre&max=100
	- Ejemplo de respuesta:
	```json
	{
    "municipios": [
        {
            "nombre": "Makallé",
            "id": "220161"
        },
    ],
    "cantidad": 68,
    "total": 68,
    "inicio": 0,
    "parametros": {}
	}
	```
  
### Entorno de desarrollo
Para probar el ejemplo, es necesario:
- Tener instalada la [JDK de Java 8](https://www.oracle.com/java/technologies/javase-jdk8-downloads.html "JDK de Java 8").
- Tener instalado [Maven](https://maven.apache.org/ "Maven") como gestor de dependencia.
- Tener instalado algún IDE. Recomendamos la utilización de [IntelliJ](https://www.jetbrains.com/es-es/idea/ "IntelliJ") (la versión Community es gratuita)

### Recomendaciones
Recomendamos la utilización de Postman para la inspección de requests, así como también para el testeo de APIs propias. Dejamos a disposición el [link](https://www.postman.com/ "Página oficial de Postman") a la página oficial.
