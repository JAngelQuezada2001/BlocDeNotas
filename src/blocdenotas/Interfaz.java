package blocdenotas;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.attribute.standard.JobMessageFromOperator;
import javax.swing.JFileChooser;

/**
 *
 * @author TenmaAlonso0712
 */
public class Interfaz extends javax.swing.JFrame {

    private File ficheroActual;

    public Interfaz() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu2 = new javax.swing.JMenu();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtareaContenido = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuNuevo = new javax.swing.JMenu();
        menuAbrir = new javax.swing.JMenu();
        miGuardar = new javax.swing.JMenu();
        miGuardarComo = new javax.swing.JMenu();

        jMenu2.setText("jMenu2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtareaContenido.setColumns(20);
        txtareaContenido.setRows(5);
        jScrollPane1.setViewportView(txtareaContenido);

        jMenu1.setText("Archivos");

        menuNuevo.setText("Nuevo");
        menuNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miNuevoActionPerformed(evt);
            }
        });
        jMenu1.add(menuNuevo);

        menuAbrir.setText("Abrir");
        menuAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAbrirActionPerformed(evt);
            }
        });
        jMenu1.add(menuAbrir);

        miGuardar.setText("Guardar");
        miGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miGuardarActionPerformed(evt);
            }
        });
        jMenu1.add(miGuardar);

        miGuardarComo.setText("Guardar Como");
        miGuardarComo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miGuardarComoActionPerformed(evt);
            }
        });
        jMenu1.add(miGuardarComo);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 746, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miNuevoActionPerformed
        this.txtareaContenido.setText("");
        this.ficheroActual = null;
    }//GEN-LAST:event_miNuevoActionPerformed

    private void miAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAbrirActionPerformed
        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int seleccion = fc.showOpenDialog(this.getContentPane());
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            this.ficheroActual = fc.getSelectedFile();
            try (FileReader fr = new FileReader(this.ficheroActual)) {
                String cadena = "";
                int valor = fr.read();
                while (valor != -1) {
                    cadena += (char) valor;
                    valor = fr.read();
                }
                this.txtareaContenido.setText(cadena);
            } catch (FileNotFoundException ex) {
                JobMessageFromOperator jobMessageFromOperator = new JobMessageFromOperator(ex.getMessage(), Locale.ITALY);
            } catch (IOException ex) {
                JobMessageFromOperator jobMessageFromOperator = new JobMessageFromOperator(ex.getMessage(), Locale.ITALY);
            }
        }
    }//GEN-LAST:event_miAbrirActionPerformed
    private void miGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miGuardarActionPerformed
        if (this.ficheroActual == null) {
            this.abrirVentanaGuardar();
        } else {
            this.escribirFichero();
        }
    }//GEN-LAST:event_miGuardarActionPerformed
    private void miGuardarComoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miGuardarComoActionPerformed
        this.abrirVentanaGuardar();
    }//GEN-LAST:event_miGuardarComoActionPerformed
    private void abrirVentanaGuardar() {
        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int seleccion = fc.showSaveDialog(this.getContentPane());
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            this.ficheroActual = fc.getSelectedFile();
            this.escribirFichero();
        }
    }
    private void escribirFichero() {
        try (FileWriter fw = new FileWriter(this.ficheroActual)) {
            fw.write(this.txtareaContenido.getText());
        } catch (IOException ex) {
            Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenu menuAbrir;
    private javax.swing.JMenu menuNuevo;
    private javax.swing.JMenu miGuardar;
    private javax.swing.JMenu miGuardarComo;
    private javax.swing.JTextArea txtareaContenido;
    // End of variables declaration//GEN-END:variables
}