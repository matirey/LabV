## Reynoso Matias tp2 

### Ciclo de ejecucion:

- Se crea uno o mas Automóviles
- Se crea uno o mas Mecánicos por cada Automóvil y se le asigna el auto a observar
- Ante cualquier modificacion de los atributos del Automóvil, el Mecánico es notificado (solo si el valor cambia, sino no)
- El metodo update() en este caso, recibe como parametro el Automovil modificado, el método que disparó el notifyObserver() y el valor antiguo
- Dependiendo el tipo de dato que reciba y el método, muestra un mensaje por pantalla con lo que haya cambiado