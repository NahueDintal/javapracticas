public class Email extends Notificacion {
  private String asunto;

  public Email(String destinatario, String mensaje, String asunto) {
    super(destinatario, mensaje);
    this.asunto = asunto;
  }

  public String getAsunto() {
    return asunto;
  }

  public void setAsunto(String asunto) {
    this.asunto = asunto;
  }

  @Override
  public void Enviar(){
    System.out.println("Enviando email a: " + Destinatario + "con el asunto: " Asunto);

  }
}
