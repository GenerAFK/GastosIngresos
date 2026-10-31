# GastosIngresos

# 💰 Gestor de Gastos e Ingresos (DAM - 2º Trimestre)

Aplicación de escritorio desarrollada en **Java** utilizando **Java Swing** para las interfaces gráficas y aplicando una arquitectura limpia **MVC (Modelo-Vista-Controlador)**.
Proyecto colaborativo para control de versiones con Git y GitHub.

---

## 📂 Estructura del Proyecto y Paquetes

El código fuente está organizado de la forma modular para evitar conflictos al trabajar en equipo:

```text
src/
└── com/
    └── mycompany/
        └── gastosingresos/
            ├── app/               <-- Punto de entrada de la aplicación
            ├── modelo/            <-- Clases de negocio / entidades de datos
            ├── vista/             <-- Interfaces gráficas (Java Swing - JFrame)
            └── controlador/       <-- Lógica de negocio, eventos y validaciones


👥 Guía de Tareas por Clase (Para el Equipo)
A continuación se detalla qué debe programar cada compañero en su respectiva clase/paquete:

1. 🚀 Paquete app
GastosIngresos.java

Qué debe hacer: Contiene el método main. Se encarga exclusivamente de inicializar el hilo de Swing y arrancar la primera pantalla
 de la aplicación (InterfazBienvenida).

2. 📊 Paquete modelo
Gastos.java

Qué debe hacer: Representa la entidad de un gasto. Debe almacenar atributos como concepto, cantidad y fecha. Incluir constructor,
 getters, setters y el método toString().

Ingresos.java

Qué debe hacer: Representa la entidad de un ingreso con los mismos atributos base que los gastos (concepto, cantidad, fecha).
 (Opcional: Si queréis refinarlo, podéis crear una clase abstracta padre llamada Transacción).

3. 🎮 Paquete controlador
ControladorGastos.java

Qué debe hacer: Recoger los datos introducidos en InterfazGastos, validar que la cantidad sea numérica y mayor que cero,
y gestionar el almacenamiento del gasto.

ControladorIngresos.java

Qué debe hacer: Validar y procesar de forma equivalente los datos introducidos desde la interfaz de ingresos (InterfazIngresos).

ControladorResumen.java

Qué debe hacer: Calcular los totales de gastos e ingresos, así como el balance final (Ingresos - Gastos) para enviárselos
 a la pantalla de resumen.

4. 🖥️ Paquete vista (Java Swing)
InterfazBienvenida.java

Qué debe hacer: Pantalla Splash o de presentación que da acceso al menú principal de la aplicación.

InterfazGastos.java

Qué debe hacer: Formulario visual con campos de texto para el concepto, cantidad y fecha, acompañado de un botón "Guardar Gasto"
 que invocará al ControladorGastos.

InterfazIngresos.java

Qué debe hacer: Formulario visual equivalente para registrar los ingresos interactuando con su respectivo controlador.

InterfazResumen.java

Qué debe hacer: Pantalla encargada de mostrar mediante tablas o etiquetas los totales calculados por el ControladorResumen.


⚙️ Instrucciones para Colaborar en Git
Haz siempre un pull antes de empezar a picar código:

Bash
git pull origin main
Crea una rama para tu funcionalidad (opcional pero recomendado):

Bash
git checkout -b feature/nombre-de-tu-pantalla
Haz commits descriptivos:

Bash
git add .
git commit -m "feat(vista): diseño inicial de la interfaz de gastos"
git push origin feature/nombre-de-tu-pantalla
