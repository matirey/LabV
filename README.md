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
- test: indica que la dependencia no es necesaria para el uso normal de la aplicacion y solo esta disponible en la compilaci�n y ejecucion de los test.
- system: similar a provided, pero se debe proporcionar el JAR de manera explicita. Esta siempre disponible y no se encuentra en los repositorios.
- import: utilizado en dependencias de tipo pom en el apartado. De este modo se importan las dependencias definidas en otro pom.

### Maven Archetype

Es un patr�n o modelo sobre el que se pueden desarrollar todas aquellas tareas que son de un mismo tipo.
Puede decirse que son plantillas, parametrizadas o configuradas para utilizar determinadas tecnolog�as que los desarrolladores utilizan como base para escribir y organizar el c�digo de la aplicaci�n.
Proporciona las ventajas de:
- Homogeneidad entre distintos desarrollos que utilizan las mismas tecnolog�as.
- Reutilizacion y construcci�n de unos arquetipos como suma de otros.
- Estandarizacion de los proyectos dentro de una organizaci�n.
- Reduccion del tiempo necesario para la construcci�n de los diversos servicios.

Su estructura base se compone de:
1. Un pom.xml a nivel ra�z del arquetipo, necesario para la construcci�n del mismo.
2. Los ficheros que compondr�n el cuerpo del arquetipo. Se sit�an bajo src/main/resources/archetype-resources/.
3. Los pom.xml de los m�dulos que componen el prototipo del arquetipo.
4. El descriptor de arquetipos archetype.xml, que se sit�a en el directorio src/main/resources/META-INF y que indica al mecanismo de generaci�n de arquetipos todo el contenido del que estamos definiendo.

### Spring Stereotypes
![stereotypes](https://www.arquitecturajava.com/wp-content/uploads/SpringStereotypes.png)

- @Component: Es el estereotipo general y permite anotar un bean para que Spring lo considere uno de sus objetos.
- @Repository: Es el estereotipo que se encarga de dar de alta un bean para que implemente el patr�n repositorio que es el encargado de almacenar datos en una base de datos o repositorio de informaci�n que se necesite.
![repo](https://www.arquitecturajava.com/wp-content/uploads/SpringStereotypesRepository.png)
- @Service : Este estereotipo se encarga de gestionar las operaciones de negocio m�s importantes a nivel de la aplicaci�n y aglutina llamadas a varios repositorios de forma simult�nea. Su tarea fundamental es la de agregador.
![serv](https://www.arquitecturajava.com/wp-content/uploads/SpringStereotypesService.png)
- @Controller : El �ltimo de los estereotipos que es el que realiza las tareas de controlador y gesti�n de la comunicaci�n entre el usuario y el aplicativo.

![control](https://www.arquitecturajava.com/wp-content/uploads/SpringStereotypesController.png)

### REST: verbos HTTP

|	Peticion	|	Definicion									|
|:---------------------:|:-------------------------------------------------------------------------------------:|
|	GET	|El m�todo GET  solicita una representaci�n de un recurso espec�fico. Las peticiones que usan el m�todo GET s�lo deben recuperar datos.|
|	HEAD	|El m�todo HEAD pide una respuesta id�ntica a la de una petici�n GET, pero sin el cuerpo de la respuesta.|
|	POST	|El m�todo POST se utiliza para enviar una entidad a un recurso en espec�fico, causando a menudo un cambio en el estado o efectos secundarios en el servidor.|
|	PUT	|El modo PUT reemplaza todas las representaciones actuales del recurso de destino con la carga �til de la petici�n.|
|	DELETE	|El m�todo DELETE borra un recurso en espec�fico.|
|	CONNECT	|El m�todo CONNECT establece un t�nel hacia el servidor identificado por el recurso.|
|	OPTIONS	|El m�todo OPTIONS es utilizado para describir las opciones de comunicaci�n para el recurso de destino.|
|	TRACE	|El m�todo TRACE  realiza una prueba de bucle de retorno de mensaje a lo largo de la ruta al recurso de destino.|
|	PATCH	|El m�todo PATCH  es utilizado para aplicar modificaciones parciales a un recurso.|

