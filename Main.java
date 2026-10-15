import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 1. Crear usuario y activar algunas suscripciones
        Usuario usuario = new Usuario("Uriel");
        usuario.activarSuscripcion(ServicioStreaming.DISNEY);
        usuario.activarSuscripcion(ServicioStreaming.WARNER);

        // 2. Crear los catálogos concretos
        CatalogoPeliculas disney = new CatalogoDisney();
        CatalogoPeliculas paramount = new CatalogoParamount();
        CatalogoPeliculas warner = new CatalogoWarner();

        // 3. Envolver los catálogos con el decorador de suscripción
        CatalogoPeliculas disneyDecorado = new SuscripcionDecorator(disney, usuario);
        CatalogoPeliculas paramountDecorado = new SuscripcionDecorator(paramount, usuario);
        CatalogoPeliculas warnerDecorado = new SuscripcionDecorator(warner, usuario);

        // 4. Probar accesos
        probarAcceso(disneyDecorado);
        probarAcceso(warnerDecorado);

        // Intentar acceder a Paramount sin suscripción activa
        probarAcceso(paramountDecorado);

        // Activar Paramount e reintentar
        System.out.println("\n--- Activando suscripcion a Paramount ---");
        usuario.activarSuscripcion(ServicioStreaming.PARAMOUNT);
        probarAcceso(paramountDecorado);
    }

    private static void probarAcceso(CatalogoPeliculas catalogo) {
        try {
            List<String> peliculas = catalogo.obtenerPeliculas();
            System.out.println("Acceso PERMITIDO a " + catalogo.getServicio().getNombre() + ": " + peliculas);
        } catch (IllegalStateException e) {
            System.out.println("Acceso DENEGADO: " + e.getMessage());
        }
    }
}