package Clases;

public class Tránsito {
    private Multa[] multas;
    private int contadorMultas;

    public Tránsito() {
        this.multas = new Multa[100];
        this.contadorMultas = 0;
    }

    public Multa buscarMulta(int codigo) {
        for (int i = 0; i < contadorMultas; i++) {
            if (multas[i].getCodigo() == codigo) {
                return multas[i];
            }
        }
        return null;
    }

    public void agregarMulta(int codigo, String nombre, String tipo) {
        if (contadorMultas < multas.length) {
            if (buscarMulta(codigo) == null) {
                multas[contadorMultas] = new Multa(codigo, nombre, tipo);
                contadorMultas++;
            }
        }
    }

    public void pagarMulta(int codigo) {
        Multa multa = buscarMulta(codigo);
        if (multa != null) {
            multa.pay();
        }
    }
    
    public Multa[] getMultas() {
        return multas;
    }

    public int getContadorMultas() {
        return contadorMultas;
    }

    public String obtenerInformacionTodasLasMultas() {
        String infoMultas = "Información de TODAS las multas:\n";
        infoMultas += "Cantidad de Multas generadas: " + contadorMultas + "\n";

        int contadorPagadas = 0;
        double montoPagadas = 0.0;
        int contadorPendientes = 0;
        double montoPendientes = 0.0;

        for (int i = 0; i < contadorMultas; i++) {
            Multa multa = multas[i];

            if (multa.estaPagada()) {
                contadorPagadas++;
                montoPagadas += multa.getMonto();
            } else {
                contadorPendientes++;
                montoPendientes += multa.getMonto();
            }
        }

        infoMultas += "Cantidad de Multas Pagadas: " + contadorPagadas + " con un monto total de Lps. " + montoPagadas + "\n";
        infoMultas += "Cantidad de Multas Pendientes de Pagar: " + contadorPendientes + " con un monto total de Lps. " + montoPendientes;

        return infoMultas;
    }
}

