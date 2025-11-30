## 🖥️ Documentación Técnica y Arquitectónica del Sistema de Gestión de Contenido Audiovisual

Este documento presenta una visión estructurada del proyecto de gestión de contenido audiovisual, destacando sus pilares de ingeniería de software (SOLID, MVC, Código Limpio) y proporcionando las directrices necesarias para su despliegue y validación.



### 1. 🏗️ Diseño Arquitectónico y Cumplimiento de Requisitos

El sistema se construyó bajo un estricto conjunto de principios de diseño para asegurar la **mantenibilidad** y la **extensibilidad** a largo plazo.

#### **a) Gestión de Persistencia y E/S Resiliente**

La funcionalidad de persistencia se diseñó para ser **robusta y segura**, aislando las operaciones de Entrada/Salida (I/O) de la lógica de negocio.

* **Lectura/Deserialización:** El sistema está diseñado para **leer y parsear** registros desde un archivo plano (`contenidos.csv`), mapeando cada línea a la jerarquía de objetos `ContenidoAudiovisual`.
* **Escritura/Serialización:** La **persistencia del estado** (`lista de contenidos`) se implementa serializando los objetos de vuelta al formato CSV.
* **Manejo de Excepciones:** Se incorpora un manejo de excepciones explícito para gestionar fallos comunes del sistema de archivos, como `IOException` y `FileNotFoundException`. Esto garantiza una **ejecución controlada** ante errores de I/O. 
* **Eficiencia de Recursos:** Se utiliza el patrón `try-with-resources` para el manejo determinista de los *streams* de I/O, previniendo fugas de recursos.

#### **b) Calidad del Código y Refactorización Estratégica**

La base de código se sometió a una refactorización para adherirse a los estándares de **Código Limpio** y mejorar la claridad funcional.

* **Claridad Semántica:** Se empleó una nomenclatura altamente descriptiva (ej., **`ContentService`**) para clases y métodos, haciendo que el propósito de cada componente sea autoexplicativo.
* **Modularidad de la Salida:** Se corrigió un defecto de diseño en los métodos de presentación (**`mostrarDetalles()`**). Ahora, en lugar de realizar I/O directo, cada método **construye y devuelve un `String` formateado**. Esta modularización desacopla el formato de la presentación, haciendo que el Modelo sea independiente de la Vista.
* **Coherencia de Inicialización:** Se eliminaron dependencias redundantes y se aseguraron **inicializaciones consistentes** dentro de los constructores (`Cortometraje`, `Podcast`, `SerieDeTV`), garantizando que todos los objetos se creen en un estado válido.

#### **c) Aplicación de Principios SOLID (Acoplamiento Bajo)**

El diseño del sistema está anclado en los principios **SOLID**, lo que proporciona una arquitectura flexible y preparada para el cambio.

* **SRP (Single Responsibility Principle):** Se observa una **cohesión alta** y **responsabilidad única**: `ContentService` (Negocio), `ConsoleView` (Interfaz), `CsvFileHandler` (Persistencia).
* **OCP (Open/Closed Principle):** La estructura de herencia (`ContenidoAudiovisual`) permite **extender** el catálogo (añadir nuevos tipos de contenido) simplemente creando nuevas subclases, sin **modificar** las clases de servicio existentes.
* **LSP (Liskov Substitution Principle):** La **sustitución** de la clase base (`ContenidoAudiovisual`) por cualquiera de sus subclases en la lógica de procesamiento es **segura**, gracias al contrato consistente del método **`mostrarDetalles()`**.
* **DIP (Dependency Inversion Principle):** Se implementa la **inversión de la dependencia** al hacer que el **`ContentService` dependa de la abstracción (`IFileHandler`)** y no de la clase concreta, facilitando el reemplazo de la tecnología de almacenamiento. 

#### **d) Patrón de Diseño Modelo-Vista-Controlador (MVC)**

La separación de preocupaciones sigue rigurosamente el patrón **MVC**, lo que organiza el código en capas funcionales claras.

* **Modelo:** Representado por las entidades del dominio (`Pelicula`, `SerieDeTV`, etc.), que contienen el estado y la lógica inherente a los datos.
* **Vista:** La clase **`ConsoleView`** es la interfaz de usuario, encargada de la renderización y la interacción.
* **Controlador:** El **`ContentService`** actúa como el orquestador, coordinando la interacción entre las otras dos capas.

#### **e) Estrategia de Pruebas Unitarias**

Se implementaron pruebas unitarias robustas para asegurar la fiabilidad de la lógica de negocio, mediante el **aislamiento** de la capa de servicio.

* **Herramientas:** Se utilizaron **JUnit 5** como marco de pruebas y **Mockito** para la creación de *mocks* (objetos simulados).
* **Aislamiento:** Las pruebas clave se centran en el **`ContentService`**. Al simular la dependencia `IFileHandler` con un **Mock**, se logra la **independencia total** de la capa de persistencia real. Esto hace que las pruebas sean **deterministas**, rápidas y altamente mantenibles.



### 2. 🚀 Instrucciones de Configuración y Despliegue

Para poner en marcha el proyecto, siga los siguientes pasos:

#### **Requisitos del Entorno**

* **JDK:** Java Development Kit, versión 16 o superior.
* **IDE:** Un entorno de desarrollo como IntelliJ IDEA.

#### **Pasos para la Ejecución**

1.  **Clonación del Repositorio:**
    ```bash
    git clone <URL_DEL_REPOSITORIO>
    ```

2.  **Configuración del IDE:**
    * Abra la carpeta clonada en IntelliJ IDEA (usando la opción `Open`).
    * Verifique y configure el **Project SDK** (`File` -> `Project Structure`) a una versión de JDK 16 o superior.

3.  **Ejecución Principal:**
    * Localice la clase principal **`MainController.java`**.
    * Ejecute el método `main()` para iniciar la aplicación de consola.



### 3. 🧪 Guía para la Validación de Pruebas Unitarias

La fiabilidad del sistema se valida a través de las pruebas de regresión automatizadas.

#### **Requisitos de Dependencias**

Asegúrese de que el proyecto tenga correctamente añadidas las librerías de prueba en su *classpath* (generalmente configurado automáticamente por el IDE):
* `junit-jupiter-api` y `junit-jupiter-engine`
* `mockito-core`

#### **Ejecución de Pruebas**

1.  **Localización:** Navegue hasta la carpeta de pruebas (`test`) y ubique el archivo clave **`ContentServiceTest.java`**.
2.  **Ejecución:** En IntelliJ IDEA, haga clic en el icono de "Ejecutar Pruebas" (botón verde de "Play") asociado a la clase `ContentServiceTest.java`.

Esto ejecutará todas las pruebas que validan el comportamiento de la lógica de negocio sin depender de recursos externos.
