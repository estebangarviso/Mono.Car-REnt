# Car-REnt - Sistema de Gestión de Arriendo de Vehículos

## Descripción

La empresa de arriendo de vehículos “Car-REnt” ha decidido implementar un sistema informático que permita mejorar la gestión de su empresa. Este sistema administra y almacena la información asociada a sus automóviles, clientes, arriendos y devoluciones, utilizando programación orientada a objetos y sus buenas prácticas.

## Especificaciones

EL código fuente se encuentra en la carpeta `src/main/java/com/mono_car_rent` y esta escrito en ingles para mantener la consistencia en el código. Sin embargo, los mensajes al usuario están en español para facilitar la comprensión.

## Comandos para compilar y ejecutar

```bash
mvn clean install
mvn exec:java -Dexec.mainClass="com.mono_car_rent.Main"
```

### Vehículo (Vehicle)

Un vehículo se caracteriza por:
- **Patente**: Largo 8, en mayúsculas.
- **Marca**: En mayúsculas.
- **Modelo**: En mayúsculas.
- **Año de fabricación**: Desde el año 2000 hasta el año actual.
- **Condición**: Puede ser `D` (disponible), `A` (arrendado) o `M` (en mantención). Inicialmente, un nuevo vehículo tiene la condición `D`.

### Cliente (Customer)

Un cliente se caracteriza por:
- **Cédula**: Largo 10 con penúltimo dígito un guion y último dígito valor entre 0 al 9 o una `k`.
- **Nombre**.
- **Vigencia**: `true` (vigente) o `false` (no vigente). Inicialmente, un nuevo cliente es `true`.

### Arriendo (Rental)

Un arriendo se caracteriza por:
- **Número de arriendo**.
- **Vehículo**.
- **Cliente**.
- **Fecha de arriendo**.
- **Número de días arrendado**: Mayor que 1 y menor que 10.
- **Monto del arriendo**: Calculado multiplicando el número de días por el precio diario ingresado por el usuario.

### Devolución (Rental Return)

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
- Clase `Main` con el método `main` para probar el sistema.
    - Crear y validar un cliente.
    - Crear y validar un vehículo.
    - Deshabilitar un cliente y validar.
    - Asignar un vehículo en mantención y validar.
    - Probar el ingreso de arriendos y generar tickets.
    - Probar devoluciones y validar.