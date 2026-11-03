# 💰 GastosIngresos

<p align="center">
  <img src="src/main/resources/imagenes/logo.png" alt="Logo GastosIngresos" width="180">
</p>

<h3 align="center">Aplicación de escritorio para gestionar ingresos y gastos personales</h3>

<p align="center">
  <img src="https://img.shields.io/badge/Java-Swing-orange?logo=openjdk" alt="Java Swing">
  <img src="https://img.shields.io/badge/Maven-Build-blue?logo=apachemaven" alt="Maven">
  <img src="https://img.shields.io/badge/IDE-NetBeans-blue?logo=apache-netbeans-ide" alt="NetBeans">
</p>

---

## 📌 Descripción del proyecto

**GastosIngresos** es una aplicación de escritorio desarrollada en Java mediante Swing.
Su objetivo es permitir al usuario gestionar sus ingresos y gastos,
así como consultar un resumen de su situación económica.

El proyecto se desarrolla de forma colaborativa utilizando Git y GitHub,
con una arquitectura organizada por paquetes para separar las interfaces gráficas,
los modelos de datos y la lógica de control.

## 🛠️ Tecnologías utilizadas

| Tecnología | Uso |
|---|---|
| ☕ Java | Lenguaje de programación. |
| 🖥️ Java Swing | Desarrollo de interfaces gráficas. |
| 📦 Maven | Gestión y configuración del proyecto. |
| 💻 NetBeans | Entorno de desarrollo. |
| 🌿 Git | Control de versiones. |
| 🐙 GitHub | Colaboración y alojamiento del repositorio. |

## 📁 Estructura del proyecto

El proyecto utiliza la estructura estándar de Maven:

```text
GastosIngresos/
│
├── 📂 src/
│   ├── 📂 main/
│   │   ├── 📂 java/
│   │   │   └── 📂 com/mycompany/gastosingresos/
│   │   │       ├── 📂 config/
│   │   │       │   └── ConfiguracionVentanas.java
│   │   │       │
│   │   │       ├── 📂 controlador/
│   │   │       │   ├── ControladorGastos.java
│   │   │       │   ├── ControladorIngresos.java
│   │   │       │   └── ControladorResumen.java
│   │   │       │
│   │   │       ├── 📂 modelo/
│   │   │       │   ├── Gastos.java
│   │   │       │   └── Ingresos.java
│   │   │       │
│   │   │       ├── 📂 vista/
│   │   │       │   ├── InterfazBienvenida.java
│   │   │       │   ├── InterfazCarga.java
│   │   │       │   ├── InterfazGastos.java
│   │   │       │   ├── InterfazIngresos.java
│   │   │       │   └── InterfazResumen.java
│   │   │       │
│   │   │       └── GastosIngresos.java
│   │   │
│   │   └── 📂 resources/
│   │       └── 📂 imagenes/
│   │           ├── icono_balances.png
│   │           ├── icono_gastos.png
│   │           ├── icono_ingresos.png
│   │           └── logo.png
│   │
│   └── 📂 test/
│
├── 📂 target/
├── .gitignore
├── README.md
└── pom.xml
```

### 🧩 Organización de paquetes

| Paquete | Responsabilidad |
|---|---|
| ⚙️ `config` | Configuraciones comunes de la aplicación y sus ventanas. |
| 🎮 `controlador` | Gestión de eventos, validaciones y comunicación entre vistas y modelos. |
| 📊 `modelo` | Clases que representan los datos de ingresos y gastos. |
| 🖥️ `vista` | Interfaces gráficas desarrolladas con Java Swing. |
| 🚀 Paquete principal | Contiene el punto de entrada de la aplicación. |

## 🚧 Estado actual del desarrollo

El proyecto ya cuenta con la estructura de paquetes y las clases principales creadas. 
Actualmente, el trabajo está centrado en el desarrollo de las interfaces gráficas.

### 🖥️ Interfaces gráficas — `vista`

| Clase | Funcionalidad |
|---|---|
| 🚀 `InterfazCarga.java` | Pantalla inicial de carga de la aplicación. |
| 🏠 `InterfazBienvenida.java` | Pantalla principal desde la que se accede a las distintas secciones. |
| 💸 `InterfazGastos.java` | Formulario para registrar gastos. |
| 💵 `InterfazIngresos.java` | Formulario para registrar ingresos. |
| 📈 `InterfazResumen.java` | Pantalla destinada a mostrar los totales y el balance económico. |

### 📦 Modelos — `modelo`

**💸 Gastos.java**
- Representar los datos de un gasto.
- Almacenar concepto, cantidad y fecha.
- Incorporar constructor, getters, setters y `toString()`.

**💵 Ingresos.java**
- Representar los datos de un ingreso.
- Almacenar concepto, cantidad y fecha.
- Incorporar constructor, getters, setters y `toString()`.

### 🎮 Controladores — `controlador`

**💸 ControladorGastos.java**
- Recoger los datos de la interfaz de gastos.
- Validar que la cantidad sea numérica y mayor que cero.
- Gestionar el registro de gastos.

**💵 ControladorIngresos.java**
- Recoger y validar los datos de los ingresos.
- Gestionar su registro.

**📊 ControladorResumen.java**
- Calcular el total de ingresos.
- Calcular el total de gastos.
- Obtener el balance final:

  `Balance = Ingresos - Gastos`

### ⚙️ Configuración — `config`

**ConfiguracionVentanas.java**
- Centralizar configuraciones comunes de las ventanas.
- Facilitar la reutilización de elementos como el icono de la aplicación.

### 🚀 Punto de entrada

**GastosIngresos.java**
- Contiene el método `main`.
- Inicializa el hilo de eventos de Swing.
- Inicia el proceso de apertura de la aplicación.

## 🖼️ Recursos gráficos

Las imágenes y los iconos utilizados por las interfaces se encuentran en:

`src/main/resources/imagenes/`

Se cargan mediante rutas de recursos del proyecto para facilitar su utilización desde las distintas clases.

## 👥 Colaboración y trabajo en equipo

El desarrollo se organiza mediante Git y GitHub.
Cada integrante trabajará preferentemente en una rama independiente para evitar conflictos y facilitar la integración de funcionalidades.

### 🌿 Flujo de trabajo recomendado

**1. 🔄 Actualizar la rama principal**

Antes de comenzar una tarea, comprobar que no existen cambios locales pendientes y actualizar la rama principal:

```bash
git checkout main
git pull origin main
```

**2. 🌱 Crear una rama para la funcionalidad**

```bash
git checkout -b feature/nombre-de-la-funcionalidad
```

Ejemplos:

```bash
git checkout -b feature/interfaz-gastos
git checkout -b feature/interfaz-ingresos
git checkout -b feature/interfaz-resumen
```

**3. 💾 Guardar los cambios**

```bash
git add .
git commit -m "feat(vista): diseño inicial de la interfaz de gastos"
```

**4. ☁️ Subir la rama a GitHub**

```bash
git push -u origin feature/nombre-de-la-funcionalidad
```

**5. 🔀 Integrar los cambios**

Cuando la funcionalidad esté terminada y probada:

- Crear una Pull Request en GitHub.
- Revisar los cambios realizados.
- Resolver posibles conflictos.
- Integrar la rama en `main`.

### 📝 Convención para los mensajes de commit

Se recomienda utilizar el siguiente formato:

```text
tipo(área): descripción del cambio
```

| Tipo | Uso |
|---|---|
| ✨ `feat` | Nueva funcionalidad. |
| 🐛 `fix` | Corrección de errores. |
| ♻️ `refactor` | Mejora o reorganización del código. |
| 🎨 `style` | Cambios visuales o de formato. |
| 📚 `docs` | Actualización de documentación. |
| 🧪 `test` | Incorporación o modificación de pruebas. |

Ejemplos:

```bash
git commit -m "feat(vista): crear interfaz de gastos"
git commit -m "feat(modelo): implementar clase Gastos"
git commit -m "fix(vista): corregir dimensiones de la ventana"
git commit -m "docs(readme): actualizar documentación"
```

## 🎯 Objetivo final

Desarrollar una aplicación de escritorio organizada, funcional y fácil de mantener que permita:

- 💸 Registrar y consultar gastos.
- 💵 Registrar y consultar ingresos.
- 📊 Calcular los totales de ingresos y gastos.
- 📈 Visualizar el balance económico del usuario.

El desarrollo se realizará progresivamente, completando primero las interfaces gráficas y posteriormente integrando los modelos,
controladores y funcionalidades necesarias.

---

<p align="center">
  <b>💰 GastosIngresos</b><br>
  <sub>Organiza tus finanzas de forma sencilla.</sub>
</p>
