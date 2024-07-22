package Clases;

public class Multa {
    private int codigo;
    private String nombreInfractor;
    private String tipo;
    private double monto;
    private boolean pagada;

    public static final double TIPO_LEVE = 800;  
    public static final double TIPO_MEDIO = 1500; 
    public static final double TIPO_GRAVE = 5000; 

    public Multa(int codigo, String nombreInfractor, String tipo) {
        this.codigo = codigo;
        this.nombreInfractor = nombreInfractor;
        this.tipo = validarTipo(tipo);
        this.pagada = false;
        this.monto = calcularMontoPagar();
    }

    public int getCodigo() {
        return codigo;
    }
    
    public String getNombre(){
        return nombreInfractor;
    }
    
    public String getTipo(){
        return tipo;
    }

    public double getMonto() {
        return monto;
    }

    public boolean estaPagada() {
        return pagada;
    }

    public String obtenerEstadoPago() {
        return pagada ? "Pagada por un monto de Lps. " + monto : "Multa pendiente";
    }

    public void realizarPago() {
        if (!pagada) {
            pagada = true;
        }
    }
    
    public void pay() {
        if (!pagada) {
            pagada = true;
        }
    }

    private String validarTipo(String tipo) {
        if ("LEVE".equals(tipo) || "MEDIO".equals(tipo) || "GRAVE".equals(tipo)) {
            return tipo;
        } else {
            return "LEVE";
        }
    }

    private double calcularMontoPagar() {
        switch (tipo) {
            case "LEVE":
                return TIPO_LEVE;
            case "MEDIO":
                return TIPO_MEDIO;
            case "GRAVE":
                return TIPO_GRAVE;
            default:
                return TIPO_LEVE;
        }
    }
}

