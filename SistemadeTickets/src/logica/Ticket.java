package logica;

public class Ticket {

    private static int consecutivo = 100;

    private final int codigo;
    private final String idCliente;

    public Ticket(String idCliente) {
        if (!Cliente.esIdValido(idCliente)) {
            throw new IllegalArgumentException("ID de cliente invalido para el ticket: " + idCliente);
        }
        this.idCliente = idCliente;
        this.codigo = consecutivo++;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getIdCliente() {
        return idCliente;
    }

    @Override
    public String toString() {
        return "Ticket [Codigo=" + codigo + ", ClienteID=" + idCliente + "]";
    }
}