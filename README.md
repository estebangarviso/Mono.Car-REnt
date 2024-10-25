# Car-REnt - Sistema de Gestión de Arriendo de Vehículos

## Descripción

La empresa de arriendo de vehículos “Car-REnt” ha decidido implementar un sistema informático que permita mejorar la gestión de su empresa. Este sistema administra y almacena la información asociada a sus automóviles, clientes, arriendos y devoluciones, utilizando programación orientada a objetos y sus buenas prácticas.

## Especificaciones

### Vehículo

Un vehículo se caracteriza por:
- **Patente**: Largo 8, en mayúsculas.
- **Marca**: En mayúsculas.
- **Modelo**: En mayúsculas.
- **Año de fabricación**: Desde el año 2000 hasta el año actual.
- **Condición**: Puede ser `D` (disponible), `A` (arrendado) o `M` (en mantención). Inicialmente, un nuevo vehículo tiene la condición `D`.

### Cliente

Un cliente se caracteriza por:
- **Cédula**: Largo 10 con penúltimo dígito un guion y último dígito valor entre 0 al 9 o una `k`.
- **Nombre**.
- **Vigencia**: `true` (vigente) o `false` (no vigente). Inicialmente, un nuevo cliente es `true`.

### Arriendo

Un arriendo se caracteriza por:
- **Número de arriendo**.
- **Vehículo**.
- **Cliente**.
- **Fecha de arriendo**.
- **Número de días arrendado**: Mayor que 1 y menor que 10.
- **Monto del arriendo**: Calculado multiplicando el número de días por el precio diario ingresado por el usuario.

### Devolución

Una devolución se caracteriza por:
- **Arriendo específico**.
- **Fecha de devolución**: No puede ser menor a la fecha del arriendo.

## Funcionalidades

1. **Deshabilitar cliente**: Deja al cliente no vigente.
2. **Asignar vehículo en mantención**: Cambia la condición del vehículo a `M`, si no está arrendado.
3. **Evaluar arriendo**: Valida que el cliente esté vigente y el vehículo disponible (`D`). Retorna `true` o `false`.
4. **Ingresar arriendo**: Evalúa y, si es exitoso, actualiza la condición del auto a `A` y retorna `true`. Si no, retorna `false`.
5. **Obtener monto a pagar**: Calcula el monto multiplicando el número de días por el precio diario.
6. **Generar ticket de arriendo**: Muestra la información del arriendo ingresado.
7. **Ingresar devolución de un vehículo arrendado**: Valida los datos y, si son correctos, cambia la condición del auto a `D` y retorna `true`. Si no, retorna `false`.

## Requerimientos Adicionales

- Validaciones de atributos en los mutadores usando métodos públicos.
- Métodos para generar mensajes al usuario en cada clase.
- Método `main` en una clase de prueba para:
    - Crear y validar un cliente.
    - Crear y validar un vehículo.
    - Deshabilitar un cliente y validar.
    - Asignar un vehículo en mantención y validar.
    - Probar el ingreso de arriendos y generar tickets.
    - Probar devoluciones y validar.

## Ejemplo de Uso

```java
public class Main {
        public static void main(String[] args) {
                // Crear y validar cliente
                Cliente cliente = new Cliente("12345678-9", "JUAN PEREZ", true);
                System.out.println(cliente);

                // Crear y validar vehículo
                Vehiculo vehiculo = new Vehiculo("ABC12345", "TOYOTA", "COROLLA", 2021, 'D');
                System.out.println(vehiculo);

                // Deshabilitar cliente
                cliente.deshabilitar();
                System.out.println(cliente);

                // Asignar vehículo en mantención
                vehiculo.asignarMantencion();
                System.out.println(vehiculo);

                // Ingresar arriendo
                Arriendo arriendo = new Arriendo(1, vehiculo, cliente, "2023-10-01", 5, 10000);
                if (arriendo.ingresar()) {
                        System.out.println(arriendo.generarTicket());
                }

                // Ingresar devolución
                Devolucion devolucion = new Devolucion(arriendo, "2023-10-06");
                if (devolucion.ingresar()) {
                        System.out.println("Devolución exitosa");
                }
        }
}
```

## Comandos para compilar y ejecutar

```bash
mvn clean install
mvn exec:java -Dexec.mainClass="com.monocarrent.App"
```