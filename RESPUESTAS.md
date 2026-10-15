# Respuestas de Análisis - Patrón Decorator

### 1. ¿Qué responsabilidad añade 'SuscripcionDecorator' al catálogo que envuelve?
Añade la responsabilidad de control de acceso y validación de suscripciones. Antes de delegar la obtención de la lista de películas al catálogo base, verifica si el usuario tiene contratado el servicio correspondiente.

### 2. ¿Por qué 'CatalogoDecorator' guarda una referencia de tipo 'CatalogoPeliculas' y no de una clase concreta?
Para cumplir con el Principio de Inversión de Dependencias (DIP) y el principio de programación hacia interfaces. Al usar la interfaz base `CatalogoPeliculas`, el decorador puede envolver cualquier catálogo concreto (Disney, Paramount, Warner) o incluso a otros decoradores en anidaciones futuras de forma transparente.

### 3. ¿Qué ventaja tiene comprobar la suscripción al consultar el catálogo, en vez de generar una clase para cada combinación de suscripciones?
Evita la explosión de clases y rigidez en el diseño. Si creáramos subclases estáticas para cada combinación, tendríamos un número exponencial de clases. Con Decorator, agregamos dinámicamente comportamientos o responsabilidades en tiempo de ejecución.

### 4. ¿Qué cambiarías si un usuario pudiera acceder a varios catálogos con una única suscripción de paquete?
Crearía un nuevo servicio en el 'Enum' o una regla dentro de `SuscripcionDecorator` que verifique si el usuario posee la suscripción específica del catálogo o la suscripción del paquete combo global.