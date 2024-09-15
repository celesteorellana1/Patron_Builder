package PatronBuilder;

import java.util.ArrayList;
import java.util.List;

public class Email {
    // Campos obligatorios
    private List<String> destinatarios;
    private String asunto;
    private String cuerpo;

    // Constructor privado para que solo el Builder pueda crear instancias
    private Email(Builder builder) {
        this.destinatarios = builder.destinatarios;
        this.asunto = builder.asunto;
        this.cuerpo = builder.cuerpo;
    }

    // Getters para acceder a los campos del Email
    public List<String> getDestinatarios() {
        return destinatarios;
    }

    public String getAsunto() {
        return asunto;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    @Override
    public String toString() {
        return "Email{" +
                "destinatarios=" + destinatarios +
                ", asunto='" + asunto + '\'' +
                ", cuerpo='" + cuerpo + '\'' +
                '}';
    }

    // Clase estática interna Builder
    public static class Builder {
        // Campos necesarios para construir el email
        private List<String> destinatarios = new ArrayList<>();
        private String asunto;
        private String cuerpo;

        // Método para agregar un destinatario
        public Builder addDestinatario(String destinatario) {
            this.destinatarios.add(destinatario);
            return this;
        }

        // Método para establecer el asunto
        public Builder setAsunto(String asunto) {
            this.asunto = asunto;
            return this;
        }

        // Método para establecer el cuerpo
        public Builder setCuerpo(String cuerpo) {
            this.cuerpo = cuerpo;
            return this;
        }

        // Método de validación y creación del objeto Email
        public Email build() {
            // Validar que hay al menos un destinatario
            if (destinatarios.isEmpty()) {
                throw new IllegalStateException("Debe haber al menos un destinatario.");
            }
            // Validar que el asunto no es nulo o vacío
            if (asunto == null || asunto.isEmpty()) {
                throw new IllegalStateException("El asunto no puede ser nulo o vacío.");
            }
            // Validar que el cuerpo no es nulo o vacío
            if (cuerpo == null || cuerpo.isEmpty()) {
                throw new IllegalStateException("El cuerpo no puede ser nulo o vacío.");
            }
            return new Email(this);
        }
    }

}
