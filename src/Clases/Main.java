package Clases;

import javax.swing.JOptionPane;
import java.util.List;
import java.util.ArrayList;
import Clases.PagarMulta;
import java.util.Arrays;

public class Main extends javax.swing.JFrame {
    private Tránsito transito;

    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
        transito = new Tránsito();
        pagarMulta.setText("Pagar Multa");
        pagarMulta.addActionListener(evt -> pagarMultaActionPerformed(evt));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton5 = new javax.swing.JButton();
        crearMulta = new javax.swing.JButton();
        infoMultas = new javax.swing.JButton();
        listarMultas = new javax.swing.JButton();
        pagarMulta = new javax.swing.JButton();

        jButton5.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        crearMulta.setText("Crear Multa");
        crearMulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearMultaActionPerformed(evt);
            }
        });

        infoMultas.setText("Información");
        infoMultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                infoMultasActionPerformed(evt);
            }
        });

        listarMultas.setText("Listar Multas");
        listarMultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listarMultasActionPerformed(evt);
            }
        });

        pagarMulta.setText("Pagar Multa");
        pagarMulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pagarMultaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(202, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pagarMulta, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(crearMulta, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(listarMultas, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(infoMultas, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(169, 169, 169))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(100, Short.MAX_VALUE)
                .addComponent(crearMulta, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pagarMulta, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(listarMultas, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(infoMultas, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(103, 103, 103))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void crearMultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearMultaActionPerformed
        CrearMulta crearMultaPanel = new CrearMulta();

    int result = JOptionPane.showConfirmDialog(this, crearMultaPanel, "Crear Multa", JOptionPane.OK_CANCEL_OPTION);

    if (result == JOptionPane.OK_OPTION) {
        String codigoText = crearMultaPanel.getCodigoTextField().getText();
        String nombre = crearMultaPanel.getNombreTextField().getText();
        String tipo = crearMultaPanel.getTipoTextField().getText();

        if (!codigoText.isEmpty()) {
            try {
                int codigo = Integer.parseInt(codigoText);

                if (transito.getContadorMultas() < transito.getMultas().length) {
                    transito.agregarMulta(codigo, nombre, tipo);
                    JOptionPane.showMessageDialog(this, "Multa creada exitosamente");
                } else {
                    JOptionPane.showMessageDialog(this, "No hay espacio para más multas", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "El código debe ser un número entero", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un código", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    }//GEN-LAST:event_crearMultaActionPerformed

    private void pagarMultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pagarMultaActionPerformed
      PagarMulta pagarMultaPanel = new PagarMulta();

  int result = JOptionPane.showConfirmDialog(this, pagarMultaPanel, "Pagar Multa", JOptionPane.OK_CANCEL_OPTION);

  if (result == JOptionPane.OK_OPTION) {
    String codigoMultaAPagar = pagarMultaPanel.getCodigoMultaAPagar();

    if (!codigoMultaAPagar.isEmpty()) {
      try {
        int codigo = Integer.parseInt(codigoMultaAPagar);

        Multa multa = transito.buscarMulta(codigo);

        if (multa!= null) {
          if (multa.estaPagada()) {
            JOptionPane.showMessageDialog(this, "La multa ya ha sido pagada anteriormente.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
          } else {
            multa.realizarPago(); 
            JOptionPane.showMessageDialog(this, "Multa pagada exitosamente.", "Pago Realizado", JOptionPane.INFORMATION_MESSAGE);
          }
        } else {
          JOptionPane.showMessageDialog(this, "No se encontró ninguna multa con el código ingresado.", "Error", JOptionPane.ERROR_MESSAGE);
        }
      } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "El código de la multa debe ser un número entero", "Error", JOptionPane.ERROR_MESSAGE);
      }
    } else {
      JOptionPane.showMessageDialog(this, "Por favor, ingrese un código de multa", "Error", JOptionPane.ERROR_MESSAGE);
    }
  }
    }//GEN-LAST:event_pagarMultaActionPerformed

    private void listarMultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listarMultasActionPerformed
      Multa[] multas = transito.getMultas();
    List<Multa> multasNoNulas = new ArrayList<>();
    
    for (Multa multa : multas) {
        if (multa != null) {
            multasNoNulas.add(multa);
        }
    }
    
    if (!multasNoNulas.isEmpty()) {
        ListarMultas listarMultasPanel = new ListarMultas(multasNoNulas.toArray(new Multa[0]));

        StringBuilder multasTexto = new StringBuilder();
        for (Multa multa : multasNoNulas) {
            multasTexto.append("Código: ").append(multa.getCodigo())
                        .append(", Nombre: ").append(multa.getNombre())
                        .append(", Tipo: ").append(multa.getTipo())
                        .append(", Monto: ").append(multa.getMonto())
                        .append(", Estado: ").append(multa.obtenerEstadoPago())
                        .append("\n");
        }

        listarMultasPanel.getMultasListadas().setText(multasTexto.toString());
        JOptionPane.showConfirmDialog(this, listarMultasPanel, "Listar Multas", JOptionPane.PLAIN_MESSAGE);
    } else {
        JOptionPane.showMessageDialog(this, "No hay multas para mostrar.", "Información", JOptionPane.INFORMATION_MESSAGE);
    }
    }//GEN-LAST:event_listarMultasActionPerformed

    private void actualizarInformacionMultas() {
    int cantidadMultasGeneradas = transito.getContadorMultas();

    int cantidadMultasPagadas = 0;
    double montoMultasPagadas = 0;

    int cantidadMultasPendientes = 0;
    double montoMultasPendientes = 0;

    for (Multa multa : transito.getMultas()) {
        if (multa != null) {
            String estadoPago = multa.obtenerEstadoPago();
            if (estadoPago.equals("Pagada")) {
                cantidadMultasPagadas++;
                montoMultasPagadas += multa.getMonto();
            } else {
                cantidadMultasPendientes++;
                montoMultasPendientes += multa.getMonto();
            }
        }
    }

    String mensaje="Cantidad de Multas generadas: "+cantidadMultasGeneradas+"\n"
            +"Cantidad de Multas Pagadas: "+cantidadMultasPagadas+" con monto total de Lps."
            +montoMultasPagadas+"\n"+"Cantidad de Multas Pendientes de Pagar: "+cantidadMultasPendientes
            +" con monto de Lps."+montoMultasPendientes;

    JOptionPane.showMessageDialog(this, mensaje, "Información de Multas", JOptionPane.INFORMATION_MESSAGE);
}
    private void infoMultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_infoMultasActionPerformed
        actualizarInformacionMultas();
    }//GEN-LAST:event_infoMultasActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton crearMulta;
    private javax.swing.JButton infoMultas;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton listarMultas;
    private javax.swing.JButton pagarMulta;
    // End of variables declaration//GEN-END:variables
}