//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import PatronBuilder.Email;
public class Main {
    public static void main(String[] args) {
        // Crear un correo utilizando el patrón Builder
        Email email = new Email.Builder()
                .addDestinatario("sintiaorellana1@gmail.com")
                .setAsunto("Notificacion")
                .setCuerpo("Se notifica.")
                .build();

        // Mostrar el contenido del correo
        System.out.println(email);
    }
}