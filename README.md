# Proyecto Final Libre - Viviendas Recicladoras

Una cooperativa de trabajo, dedicada a la recolección de residuos reciclables, de
la ciudad de Viedma quiere implementar un sistema. La misma desea tener un
registro de las viviendas que estén dispuestas a separar residuos reciclables.

### Vistas

![Viviendas 1](/img/Viviendas1.png)

![Viviendas 1](/img/Viviendas2.png)

## Requerimientos Funcionales

- Los registros de las viviendas se podrán realizar cualquier día del año. Se deberá
  registrar fecha y hora de registro, datos del dueño (nombre, apellido, dni, etc.)
  y la ubicación determinada por la dirección, zona, barrio y latitud/longitud de la
  misma.
- Por otra parte, la cooperativa desea tener un registro de su personal. De estos
  recolectores se desea contar con su nombre, apellido y DNI.
- Los ciudadanos podrán informar a la cooperativa, a través del sistema, cuando
  cuenten con residuos en sus viviendas para ser retirados, realizando un pedido
  de retiro el cual debe contar con los siguientes datos: fecha de emisión, residuos
  a retirar, si se requiere vehículo de carga pesada y una observación.
- De esta manera se busca administrar las órdenes de retiros las cuales son
  generadas a partir de los pedidos. En las órdenes de retiro se establece que
  recolector retirará los residuos, la vivienda a visitar, el día y hora en la que se
  genera y un estado.
  Estas órdenes de retiro serán tomadas por los recolectores de la cooperativa, los cuales se encargarán de realizar las
  visitas.
- De cada visita se registra el dia y la hora, datos del retiro (cantidad de residuos en kg y tipo) y una observación.
- Además, los residuos estarán discriminados por tipo, por ejemplo, plástico, papel
  y cartón, vidrio, metal, etc. Donde cada tipo contará con un puntaje por kg.
- El municipio lanzó una campaña denominada “Municipio Club (Mc)” permitiendo
  al ciudadano(dueño) acumular puntos de acuerdo a los órdenes de retiro con
  estado CONCRETADO que se realice para este, estableciendo ventajas sobre el
  mismo, proporcionando premios como reducción de impuestos, reconocimiento
  al ciudadano, etc.
- Se deberá llevar a cabo una funcionalidad en el sistema que permita conocer la
  cantidad de puntos que acumuló cada ciudadano y la posibilidad de canjear los
  puntos en un catálogo que brindará el sistema.

### Diagrama de Casos de Uso

![Caso de Uso 1](/img/Diagrama_CU.png)

### Diagrama de Clases

![Diagrama de Clases 1](/img/Diagrama_de_Clases.png)

### Diagrama Conceptual

![Diagrama de Clases 2](/img/Diagrama_Conceptual.png)