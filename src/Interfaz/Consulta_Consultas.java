package Interfaz;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Conexion.Conexion;
import Interfaz.*;
import hospital.Hospital;
import static java.lang.System.exit;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Douglas
 */
public class Consulta_Consultas extends javax.swing.JFrame {
    Conexion con = new Conexion();
    String[] datos = {"Codigo","Fecha","Nombre del Paciente"};
    DefaultTableModel modelo = new DefaultTableModel(null, datos);
    /**
     * Creates new form Citas
     */
    public Consulta_Consultas() {
        initComponents();
        setLocationRelativeTo(null);
        
        
        //TablaVerCitas.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        
        
        
        
        //-------FONDO DE PANTALLA PRINCIPAL---------------
        ((JPanel)getContentPane()).setOpaque(false); 
        ImageIcon uno=new ImageIcon(this.getClass().getResource("/Imagenes/fondo1.jpg")); 
        JLabel fondo= new JLabel(); 
        fondo.setIcon(uno); 
        getLayeredPane().add(fondo,JLayeredPane.FRAME_CONTENT_LAYER); 
        fondo.setBounds(0,0,uno.getIconWidth(),uno.getIconHeight());
    }
    
    void BuscarPersona(){
        Connection connection = con.iniciarConexion();
        DefaultTableModel modelo = new DefaultTableModel(null, datos);
       // int ano = fecha.getCalendar().get(Calendar.YEAR);
        //int mes = fecha.getCalendar().get(Calendar.MONTH) + 1;
        //int dia = fecha.getCalendar().get(Calendar.DAY_OF_MONTH);
        String dpi=txt_dpi.getText();
        String datos[]=new String[3];
        String dia="";
        String mes="";
        String ano="";
        String fecha="";
        //System.out.println(dpi);
        
        
         String sql3 = "SELECT CODIGO_CONSULTA, CITA.DIA AS DIA, CITA.MES AS MES, CITA.ANO AS ANO, NOMBRE FROM PERSONA, PACIENTE, CITA, CONSULTA WHERE PERSONA.CODIGO_PERSONA = PACIENTE.CODIGO_PERSONA AND CITA.CODIGO_CITA = CONSULTA.CODIGO_CITA AND PACIENTE.CODIGO_PACIENTE = CITA.CODIGO_PACIENTE AND PACIENTE.CODIGO_PACIENTE = CONSULTA.CODIGO_PACIENTE AND PERSONA.DPI = '"+dpi+"'";
         
         try {
             //System.out.println("hola");
            Statement st2 = connection.createStatement();
            ResultSet rs2 = st2.executeQuery(sql3);
            //System.out.println("adios");        
            while (rs2.next()){
                 //existe = true;
                 //codigo_paciente = rs2.getString("CODIGO_PACIENTE");
                //System.out.println("22222");
                 datos[0] = (rs2.getString("CODIGO_CONSULTA")).trim();
                 dia = (rs2.getString("DIA")).trim();
                 mes = (rs2.getString("MES")).trim();
                 ano = (rs2.getString("ANO")).trim();
                 fecha= dia+"/"+mes+"/"+ano;
                 datos[1] = fecha;
                 datos[2] = (rs2.getString("NOMBRE")).trim();
                 //System.out.println("333333");
                 modelo.addRow(datos);
            }
            
            //Hospital cualquier = new Hospital();
            //cualquier.setCodigo_cita(datos[0]);
            //cualquier.setCodigo_paciente_cita(datos[1]);
            TablaVerCitas.setModel(modelo);
            int[] anchos = {50, 150, 300};
           // System.out.println("4444");
            //hacemos un bucle FOR desde cero hasta la cantidad de columnas de nuestra tabla

            for(int i = 0; i < TablaVerCitas.getColumnCount(); i++) {
                TablaVerCitas.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
            }
                        
        } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
        }    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaVerCitas = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txt_dpi = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(7, 7, 7, 7, new java.awt.Color(0, 0, 0)));
        jPanel3.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Citas");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/close.png"))); // NOI18N
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        TablaVerCitas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TablaVerCitas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaVerCitasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaVerCitas);

        jPanel1.setOpaque(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("DPI:");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/search.png"))); // NOI18N
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel3)
                .addGap(31, 31, 31)
                .addComponent(txt_dpi, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(txt_dpi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(292, 292, 292)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(166, 166, 166)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap(638, Short.MAX_VALUE)
                    .addComponent(jLabel2)
                    .addGap(10, 10, 10)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel2)
                    .addContainerGap(379, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        //this.hide();
        //Informe_Paciente nuevo = new Informe_Paciente();
        
        
        this.hide();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        BuscarPersona();
    }//GEN-LAST:event_jLabel5MouseClicked

    private void TablaVerCitasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaVerCitasMouseClicked
        // TODO add your handling code here:
       //  String [] seleccion = new String[4];
        //int lugar = 0;
        System.out.println("1");
        int row=TablaVerCitas.getSelectedRow();
        System.out.println("2");
        String valor = String.valueOf(TablaVerCitas.getValueAt(row, 0));
        System.out.println("3");
        Hospital cualquier = new Hospital();
         cualquier.setCodigo_consulta_paciente(valor);
         System.out.println("4");
       
    }//GEN-LAST:event_TablaVerCitasMouseClicked

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
            java.util.logging.Logger.getLogger(Consulta_Consultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Consulta_Consultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Consulta_Consultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Consulta_Consultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Consulta_Consultas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaVerCitas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txt_dpi;
    // End of variables declaration//GEN-END:variables
}