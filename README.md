# BackendFuel

Proyecto académico de la asignatura **Arquitectura de Software**, correspondiente al laboratorio de implementación de un backend REST. BackendFuel simula la gestión de una red de distribución de combustible: estaciones de servicio, distribuidores, abastecimientos, usuarios, ventas y estadísticas del sistema.

> **Nota:** este repositorio corresponde a una versión **BETA** de prueba, usada para validar las funcionalidades de la API antes de integrarlas en el proyecto final de la asignatura.

## Descripción

El sistema expone una API REST construida con **JAX-RS** sobre **Java EE**, siguiendo una arquitectura en capas (entidad, persistencia, lógica de negocio y servicios). Permite:

- Registrar y consultar **estaciones de servicio** y **distribuidores**.
- Relacionar una estación con su distribuidor asignado.
- Realizar **abastecimientos** de combustible desde un distribuidor hacia una estación, validando la capacidad disponible.
- Registrar **usuarios** y sus **ventas** de combustible.
- Consultar **estadísticas globales** del sistema (ventas, ingresos, combustible vendido, abastecimientos).

## Características

- API REST con operaciones **CRUD** completas para estaciones de servicio (crear, consultar, actualizar, eliminar).
- Relación **Many-to-One** entre `EstacionServicio` y `Distribuidor`, y entre `Venta`/`Abastecimiento` y sus entidades relacionadas.
- Validaciones de negocio en la capa lógica: capacidad insuficiente del distribuidor, entidades inexistentes, cantidades inválidas.
- Endpoint de estadísticas que agrega datos de ventas y abastecimientos en una sola respuesta.
- Persistencia mediante **JPA (EclipseLink)** contra una base de datos **Apache Derby**.

## Tecnologías utilizadas

| Tecnología | Uso en el proyecto |
|---|---|
| **Java 8** | Lenguaje principal del backend |
| **Java EE 7 (JAX-RS)** | Construcción de la API REST |
| **JPA 2.1 / EclipseLink** | Mapeo objeto-relacional (ORM) |
| **Apache Derby** | Base de datos relacional (modo cliente-servidor) |
| **GlassFish** | Servidor de aplicaciones donde se despliega el WAR |
| **NetBeans + Apache Ant** | Entorno de desarrollo y build |
| **Postman** | Pruebas manuales de los endpoints REST |

## Arquitectura del proyecto

El proyecto sigue una arquitectura en capas típica de aplicaciones Java EE:

```
Cliente (Postman / navegador)
        │
        ▼
  servicios/     → Recursos JAX-RS (@Path). Reciben las peticiones HTTP y devuelven Response.
        │
        ▼
  logica/        → Reglas de negocio y validaciones (ej. capacidad del distribuidor).
        │
        ▼
  persistencia/  → DAOs. Acceso a datos mediante EntityManager (JPA).
        │
        ▼
  entidad/       → Clases anotadas con @Entity, mapeadas a tablas de la base de datos.
```

Esta separación permite que cada capa tenga una responsabilidad única: los servicios no conocen SQL, la lógica no conoce HTTP, y la persistencia no conoce reglas de negocio.

## Estructura del proyecto

```
ArquitecturaSoftware-BackendFuel/
├── src/
│   ├── java/
│   │   ├── api/
│   │   │   ├── ApplicationConfig.java   # Registra los servicios JAX-RS y define el path base "api"
│   │   │   └── GenericResource.java     # Recurso de ejemplo generado por NetBeans (sin uso funcional)
│   │   ├── entidad/                     # Clases @Entity (JPA)
│   │   │   ├── Distribuidor.java
│   │   │   ├── EstacionServicio.java
│   │   │   ├── Abastecimiento.java
│   │   │   ├── Usuario.java
│   │   │   └── Venta.java
│   │   ├── persistencia/                # DAOs: acceso a datos con EntityManager
│   │   │   ├── DistribuidorDAO.java
│   │   │   ├── EstacionDAO.java
│   │   │   ├── AbastecimientoDAO.java
│   │   │   ├── UsuarioDAO.java
│   │   │   └── VentaDAO.java
│   │   ├── logica/                      # Reglas de negocio
│   │   │   ├── AbastecimientoLogic.java
│   │   │   └── VentaLogic.java
│   │   └── servicios/                   # Endpoints REST (JAX-RS)
│   │       ├── EstacionService.java
│   │       ├── DistribuidorService.java
│   │       ├── AbastecimientoService.java
│   │       ├── UsuarioService.java
│   │       ├── VentaService.java
│   │       └── EstadisticaService.java
│   └── conf/
│       └── persistence.xml              # Configuración de la unidad de persistencia (CombustiblePU)
├── web/
│   └── index.html                       # Página estática de bienvenida (sin contenido funcional)
├── build.xml                            # Build de Apache Ant
└── nbproject/                           # Configuración interna de NetBeans
```

## Modelo de datos

| Entidad | Descripción | Relaciones |
|---|---|---|
| `Distribuidor` | Proveedor de combustible, con una capacidad disponible | — |
| `EstacionServicio` | Estación que recibe combustible y realiza ventas | `@ManyToOne` → `Distribuidor` |
| `Abastecimiento` | Registro de una entrega de combustible de un distribuidor a una estación | `@ManyToOne` → `Distribuidor`, `@ManyToOne` → `EstacionServicio` |
| `Usuario` | Persona que compra combustible | — |
| `Venta` | Registro de una venta de combustible a un usuario en una estación | `@ManyToOne` → `Usuario`, `@ManyToOne` → `EstacionServicio` |

## Instalación y ejecución

### Requisitos previos

- **JDK 8**
- **NetBeans IDE** (con soporte para proyectos Java Web)
- **GlassFish Server** configurado como servidor de aplicaciones
- **Apache Derby** corriendo en modo red (`localhost:1527`), con una base de datos llamada `combustibleDB`

### Pasos

1. Clonar el repositorio:
   ```bash
   git clone https://github.com/juandiegogalindo/ArquitecturaSoftware-BackendFuel.git
   ```
2. Abrir el proyecto en NetBeans (`Archivo → Abrir Proyecto`).
3. Verificar que el servidor **GlassFish** esté configurado en las propiedades del proyecto.
4. Iniciar el servidor de base de datos **Derby** (Network Server) desde NetBeans o desde línea de comandos.
5. Ejecutar el proyecto (`Ejecutar → Ejecutar Proyecto`). NetBeans desplegará el WAR en GlassFish automáticamente.
6. La API quedará disponible en:
   ```
   http://localhost:8080/EjercicioArqSoftware-BackendFuel/api
   ```

> La base de datos se crea automáticamente al iniciar (`eclipselink.ddl-generation=create-tables`), por lo que no es necesario crear las tablas manualmente.

## Autor

**Juan Diego Galindo**
Estudiante de Ingeniería de Sistemas - Septimo Semestre
 
- GitHub: [@juandiegogalindo](https://github.com/juandiegogalindo)
- LinkedIn: [Juan Diego Galindo - Full Stack](https://linkedin.com/in/jdgalindo6)
