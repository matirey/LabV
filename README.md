## Reynoso Matias tp5

### Maven goals

- mvn clean: borra todos los archivos generados por la compilacion previa
- mvn compile: compila el codigo fuente del proyecto
- mvn package: toma el codigo compilado y empaqueta el proyecto en un JAR
- mvn install: instala nuestro artefacto en nuestro repositorio local (~/.m2/repository por defecto)

### Maven scopes

- compile: si no se especifica otro, es el contexto por defecto. Las dependencias de compilacion estan disponibles en todos los classpaths.
- provided: similar a compile, pero indica que espera encontrar la dependencia del JDK o contenedor en tiempo de ejecucion. Solo esta disponible en compilacion y test.
- runtime: indica que la dependencia no se necesita para compilar, pero si en tiempo de ejecucion. Esta en los classpath de tiempo de ejecucion y test, pero no en compilacion.
- test: indica que la dependencia no es necesaria para el uso normal de la aplicacion y solo esta disponible en la compilación y ejecucion de los test.
- system: similar a provided, pero se debe proporcionar el JAR de manera explicita. Esta siempre disponible y no se encuentra en los repositorios.
- import: utilizado en dependencias de tipo pom en el apartado. De este modo se importan las dependencias definidas en otro pom.

### Maven Archetype

Es un patrón o modelo sobre el que se pueden desarrollar todas aquellas tareas que son de un mismo tipo.
Puede decirse que son plantillas, parametrizadas o configuradas para utilizar determinadas tecnologías que los desarrolladores utilizan como base para escribir y organizar el código de la aplicación.
Proporciona las ventajas de:
- Homogeneidad entre distintos desarrollos que utilizan las mismas tecnologías.
- Reutilizacion y construcción de unos arquetipos como suma de otros.
- Estandarizacion de los proyectos dentro de una organización.
- Reduccion del tiempo necesario para la construcción de los diversos servicios.

Su estructura base se compone de:
1. Un pom.xml a nivel raíz del arquetipo, necesario para la construcción del mismo.
2. Los ficheros que compondrán el cuerpo del arquetipo. Se sitúan bajo src/main/resources/archetype-resources/.
3. Los pom.xml de los módulos que componen el prototipo del arquetipo.
4. El descriptor de arquetipos archetype.xml, que se sitúa en el directorio src/main/resources/META-INF y que indica al mecanismo de generación de arquetipos todo el contenido del que estamos definiendo.

### Spring Stereotypes
![stereotypes](https://www.arquitecturajava.com/wp-content/uploads/SpringStereotypes.png)

- @Component: Es el estereotipo general y permite anotar un bean para que Spring lo considere uno de sus objetos.
- @Repository: Es el estereotipo que se encarga de dar de alta un bean para que implemente el patrón repositorio que es el encargado de almacenar datos en una base de datos o repositorio de información que se necesite.
![repo](https://www.arquitecturajava.com/wp-content/uploads/SpringStereotypesRepository.png)
- @Service : Este estereotipo se encarga de gestionar las operaciones de negocio más importantes a nivel de la aplicación y aglutina llamadas a varios repositorios de forma simultánea. Su tarea fundamental es la de agregador.
![serv](https://www.arquitecturajava.com/wp-content/uploads/SpringStereotypesService.png)
- @Controller : El último de los estereotipos que es el que realiza las tareas de controlador y gestión de la comunicación entre el usuario y el aplicativo.

![control](https://www.arquitecturajava.com/wp-content/uploads/SpringStereotypesController.png)

### REST: verbos HTTP

|	Peticion	|	Definicion									|
|:---------------------:|:-------------------------------------------------------------------------------------:|
|	GET	|El método GET  solicita una representación de un recurso específico. Las peticiones que usan el método GET sólo deben recuperar datos.|
|	HEAD	|El método HEAD pide una respuesta idéntica a la de una petición GET, pero sin el cuerpo de la respuesta.|
|	POST	|El método POST se utiliza para enviar una entidad a un recurso en específico, causando a menudo un cambio en el estado o efectos secundarios en el servidor.|
|	PUT	|El modo PUT reemplaza todas las representaciones actuales del recurso de destino con la carga útil de la petición.|
|	DELETE	|El método DELETE borra un recurso en específico.|
|	CONNECT	|El método CONNECT establece un túnel hacia el servidor identificado por el recurso.|
|	OPTIONS	|El método OPTIONS es utilizado para describir las opciones de comunicación para el recurso de destino.|
|	TRACE	|El método TRACE  realiza una prueba de bucle de retorno de mensaje a lo largo de la ruta al recurso de destino.|
|	PATCH	|El método PATCH  es utilizado para aplicar modificaciones parciales a un recurso.|

