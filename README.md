
# Prueba Técnica

En este repositorio vamos a encontrar las soluciones a las preguntas 1 de la prueba técnica.

## Pregunta 1 - Administrar Vehiculos :
Construya una aplicación en Spring Boot que resuelva el siguiente problema:
Una empresa de arriendo de vehículos necesita una aplicación para administrar los distintos tipos de vehículos que posee. Para ello, se solicita crear la capa de servicios (API) que permita ingresar nuevos vehículos, editarlos, eliminarlos, listar y/o buscar alguno en específico (CRUD). Además se requiere que el sistema sea capaz llevar un registro de las mantenciones realizadas a cada vehículo.


### Indice

 - [Estructura](#Estructura)
 - [Configuracion](#Configuracion)
 - [Ejecucion](#Ejecucion)
 - [APIs](#APIs)
 - [Recursos](#Recursos)
 - [Tecnologías](#Tecnologias)

### Estructura

- **config:** Paquete donde se encuentran las clases de configuración (Config, Handler, etc).
- **controllers:** Paquete donde se encuentran las clases controladoras o los endpoints que van hacer expuestos para su consumo.
- **dto:** Paquete donde se encuentran las clases para transmitir información entre el cliente y el servidor.
- **model:** Paquete donde se encuentran las clases que hacen referencia a nuestro modelo de datos.
- **repository:** Paquete donde se encuentran las clases que establecen comunicación con la BD.
- **services:** Paquete donde se encuentran las clases que realizan la lógica de negocio o comercial.
- **App.java:** Clase .java para el arranque del proyecto.

### Configuracion

#### Requisitos
- Java 11 (JDK completo, no JRE)
- Herramienta de línea de comando git
- IDE preferido (yo utilizo IDEA IntelliJ)
- MySql Server instalado localmente o con Docker 

#### Pasos
##### **Configurando la BD**
- Puede iniciar MySQL instalado localmente que se conectará a través del puerto 3306.
- Puede descargar MySQL vía docker e iniciarlo, para este ejemplo estamos exponiendo el puerto 33060.
```bash
  docker pull mysql
  docker run -d -p 33060:3306 --name=mysql -e MYSQL_ROOT_PASSWORD=mysql mysql:latest
```
##### **Spring Administrar Vehiculos**
- Clonar el proyecto en tu ordenador
```bash
  git clone
```
- Dentro de IntelliJ ```File-> Open ``` y seleccionas la ruta donde se encuentra el proyecto que descargaste en el paso anterior. Haz click en el botón ```Ok```
- Una vez que el proyecto este abierto dirígete al archivo ```pom.xml``` en la raiz de la estructura del proyecto.
- Selecciona click derecho en el archivo, se abrirá una ventana de opciones, dirígete a ```Maven -> Reload project```. Lo que hara con esta selección es descargar todos las librerías que se utilizarán en el pryecto.

### Ejecucion
##### **Ejecución de la BD**
Podemos generar el modelo de la BD de 2 formas:
- Mediante el script de creación ubicado en la carpeta ```src -> main -> resource -> script```
- Mediante Spring boot:
    - Nos ubicamos en la carpeta ```src -> main -> resource -> application.properties``` y modficamos la propiedad ```spring.jpa.hibernate.ddl-auto```. Con el valor ```create``` lo que realizará Spring es generar las tablas en base a los modelos ubicados en la carpeta model. Una vez generado el modelo podemos cambiar el valor a ```none```.
    ```bash
        spring.jpa.hibernate.ddl-auto=create
    ```
    - Nos ubicamos en la clase ```App.java``` ubicado en ```src -> main -> java -> com -> myhotel```, seleccionamos click derecho ```Run```.
##### **Ejecución Spring Administrar Vehículos**
- Nos ubicamos en el archivo ```application.properties``` ubicado en ```src -> main -> resource```. Aquí podemos validar los valores para la configuración y ejecución del proyecto:
    ```bash
        ### Puerto en donde se ejecutará el proyecto
        server.port=9080

        ### JDC donde se encuentra la BD
        spring.datasource.url=jdbc:mysql://localhost:33060/rentcar
        
        ### usuario y password BD
        spring.datasource.username=root
        spring.datasource.password=mysql
    ```
- Nos ubicamos en la clase ```App.java``` ubicado en ```src -> main -> java -> com -> myhotel```, seleccionamos click derecho ```Run```.
- Ingresamos a la siguiente URL ```http://localhost:9080/swagger-ui.html``` ya que tenemos Swagger incorporado en nuestro proyecto podemos ver la interfaz de usuario.
## APIs

#### Retorna todos los vehiculos

```http
  GET /vehiculo
```
#### Retorna un solo vehiculo

```http
  GET /vehiculo/${id}
```

| Parámetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `Integer` | **Obligatorio**. ID del vehiculo |

#### Agregar vehículo

```http
  POST /vehiculo
```

| Parámetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| Vehiculo      | Models | **Obligatorio**. Modelo que contiene todos los datos del Vehiculo y su detalle. |

#### Actualizar vehículo

```http
  PUT /vehiculo/${id}
```

| Parámetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `Integer` | **Obligatorio**. ID del vehiculo |
| Vehiculo      | Models | **Obligatorio**. Modelo que contiene todos los datos del Vehiculo y su detalle. |

#### Eliminar vehículo

```http
  DELETE /vehiculo/${id}
```

| Parámetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `Integer` | **Obligatorio**. ID del vehiculo |

Para mayor información consulte ```http://localhost:9080/swagger-ui.html```
#### Recursos
- Script de BD ubicado en la carpeta ```src -> main -> resource -> script``` con nombre ```rentcar.sql```

#### Tecnologias

- [Spring boot](#) 
- [Spring Data](#)
- [Spring Web](#)
- [Spring Validation](#)
- [Swagger](#)
- [Lombok](#) 
- [ModelMapper](#) 
- [Maven](#) 
- [Java 11](#) 
- [MySql](#) 
