## Reynoso Matias tp1 
  
- Se necesita al menos 1 consumidor para que el stock llegue a 0, ya que el productor tiene un tiempo finito de produccion.
  
- Los bloques synchronized deben serlo así, para asegurar de que ingrese un hilo a la vez.

- El recurso compartido (BeerHouse) es por el cual compiten los Threads y contiene los metodos synchronized.
Tanto el productor como el consumidor tienen un listado de cervezas compartido. Ambos eligen un tipo de aleatorio de cerveza
para producir o consumir segun corresponda.
La clase BeerHouse maneja el stock de cerveza y sus metodos son los que dedicen cuando un hilo debe esperar, continuar o
interrumpir su ejecucion.

### Las 3 formas de instanciar un Thread son:

- Una clase que implemente la interfaz Runnable
- Una clase que extienda de la clase Thread
- La tercera te la debo, no se si la vieron en clase pero no la sé (si queres edita esto)
