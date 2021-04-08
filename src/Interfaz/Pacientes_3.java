package Interfaz;

import Conexion.Conexion;
import Interfaz.*;
import hospital.Hospital;
import static java.lang.System.exit;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Pacientes_3 extends javax.swing.JFrame {
    Conexion con = new Conexion();
    Hospital hosp = new Hospital();
    int cont = 0;
    /**
     * Creates new form Citas
     */
    public Pacientes_3() {
        initComponents();
        setLocationRelativeTo(null);
        
        
        //-------FONDO DE PANTALLA PRINCIPAL---------------
        ((JPanel)getContentPane()).setOpaque(false); 
        ImageIcon uno=new ImageIcon(this.getClass().getResource("/Imagenes/fondo1.jpg")); 
        JLabel fondo= new JLabel(); 
        fondo.setIcon(uno); 
        getLayeredPane().add(fondo,JLayeredPane.FRAME_CONTENT_LAYER); 
        fondo.setBounds(0,0,uno.getIconWidth(),uno.getIconHeight());
        
        comboPadecimiento();
        comboAlergias();
        btnFinalizar.setVisible(false);
    }
    
    void comboPadecimiento(){
        Connection connection = con.iniciarConexion();
        cmbPadecimiento.removeAllItems();
        
        String codigo = "";
        String nombre_padecimiento = "";
        
        
        String sql3 = "SELECT CODIGO_PADECIMIENTO,NOMBRE_PADECIMIENTO FROM PADECIMIENTO";
         
         try {
            Statement st2 = connection.createStatement();
            ResultSet rs2 = st2.executeQuery(sql3);
                    
            while (rs2.next()){
                 
                 codigo = rs2.getString("CODIGO_PADECIMIENTO").trim();
                 nombre_padecimiento = (rs2.getString("NOMBRE_PADECIMIENTO")).trim();
                 
                 cmbPadecimiento.addItem(codigo+". "+nombre_padecimiento);
                 codigo = "";
                 nombre_padecimiento = "";
                 
            }
                        
        } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
        }
   }
    
    
   void comboAlergias(){
        Connection connection = con.iniciarConexion();
        cmbAlergias.removeAllItems();
        
        String codigo = "";
        String nombre_alergia = "";
        
        
        String sql3 = "SELECT CODIGO_ALERGIA,NOMBRE_ALERGIA FROM ALERGIA";
         
         try {
            Statement st2 = connection.createStatement();
            ResultSet rs2 = st2.executeQuery(sql3);
                    
            while (rs2.next()){
                 
                 codigo = rs2.getString("CODIGO_ALERGIA").trim();
                 nombre_alergia = (rs2.getString("NOMBRE_ALERGIA")).trim();
                 
                 cmbAlergias.addItem(codigo+". "+nombre_alergia);
                 codigo = "";
                 nombre_alergia = "";
                 
            }
                        
        } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
        }
   }
   
   void InsertarPadecimientoPaciente(String Codigo){
       String codigo_paciente = hosp.getCodigo_paciente();
       String sql = "INSERT INTO PADECIMIENTO_PACIENTE VALUES (SECUENCIA_PAC_PADECIMIENTO.nextval, '"+Codigo+"', '"+codigo_paciente+"') ";
                
            
            Connection connection = con.iniciarConexion();
            try {
                 Statement sta = connection.createStatement();
                 sta.executeUpdate(sql);
                 sta.close();
            } catch (SQLException ex) {

                        JOptionPane.showMessageDialog(null,ex);
            }
       
   }
   
   void InsertarAlergiaPaciente(String Codigo){
       String codigo_paciente = hosp.getCodigo_paciente();
       String sql = "INSERT INTO ALERGIA_PACIENTE VALUES (SECUENCIA_ALERGIA_PACIENTE.nextval, '"+codigo_paciente+"', '"+Codigo+"') ";
                
            
            Connection connection = con.iniciarConexion();
            try {
                 Statement sta = connection.createStatement();
                 sta.executeUpdate(sql);
                 sta.close();
            } catch (SQLException ex) {

                        JOptionPane.showMessageDialog(null,ex);
            }
       
   }
   
   void cortadorPadecimiento(){
       cont++;
       int estado = 0;
       
       String codigo = cmbPadecimiento.getSelectedItem().toString();
       String lexe = "";
       for(int i=0;i<=codigo.length();i++){
                if(((int)codigo.charAt(i)!= 10)){
                    switch(estado){
                        case 0:
                            if((int)codigo.charAt(i)!= 46){
                                lexe+=codigo.charAt(i);
                                
                            }else{
                                System.out.println(lexe);
                                InsertarPadecimientoPaciente(lexe);
                                lexe = "";
                                estado = 1;
                                System.out.println("adiosito");
                            }
                        break;
                        case 1:
                            System.out.println("adios");
                            System.out.println(codigo.charAt(i));
                         break;
                    }
                    
                }
                if(estado == 1){
                    break;
                }
            }
       
       
   }
   
   void cortadorAlergia(){
       int estado = 0;
       
       String codigo = cmbAlergias.getSelectedItem().toString();
       String lexe = "";
       for(int i=0;i<=codigo.length();i++){
                if(((int)codigo.charAt(i)!= 10)){
                    switch(estado){
                        case 0:
                            if((int)codigo.charAt(i)!= 46){
                                lexe+=codigo.charAt(i);
                                
                            }else{
                                System.out.println(lexe);
                                InsertarAlergiaPaciente(lexe);
                                lexe = "";
                                estado = 1;
                                System.out.println("adiosito");
                            }
                        break;
                        case 1:
                            System.out.println("adios");
                            System.out.println(codigo.charAt(i));
                         break;
                    }
                    
                }
                if(estado == 1){
                    break;
                }
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
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cmbPadecimiento = new javax.swing.JComboBox();
        btnLlenarPadecimiento = new javax.swing.JLabel();
        btnLlenarAlergias = new javax.swing.JLabel();
        cmbAlergias = new javax.swing.JComboBox();
        btnGuardar = new javax.swing.JLabel();
        btnFinalizar = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(7, 7, 7, 7, new java.awt.Color(0, 0, 0)));
        jPanel3.setOpaque(false);

        jPanel1.setOpaque(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Padecimiento:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Alergias:");

        btnLlenarPadecimiento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/plus.png"))); // NOI18N
        btnLlenarPadecimiento.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLlenarPadecimiento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLlenarPadecimientoMouseClicked(evt);
            }
        });

        btnLlenarAlergias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/plus.png"))); // NOI18N
        btnLlenarAlergias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLlenarAlergiasMouseClicked(evt);
            }
        });

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/save.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuardarMouseClicked(evt);
            }
        });

        btnFinalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Terminado.png"))); // NOI18N
        btnFinalizar.setText("Finalizar");
        btnFinalizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFinalizarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmbPadecimiento, 0, 204, Short.MAX_VALUE)
                    .addComponent(cmbAlergias, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLlenarPadecimiento)
                    .addComponent(btnLlenarAlergias))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(141, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnGuardar)
                    .addComponent(btnFinalizar))
                .addGap(123, 123, 123))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnLlenarPadecimiento)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(cmbPadecimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmbAlergias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4))
                    .addComponent(btnLlenarAlergias))
                .addGap(25, 25, 25)
                .addComponent(btnGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addComponent(btnFinalizar)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Pacientes");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/close.png"))); // NOI18N
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(248, 248, 248)
                        .addComponent(jLabel1))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(193, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(68, Short.MAX_VALUE))
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
        exit(0);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void btnLlenarPadecimientoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLlenarPadecimientoMouseClicked
        // TODO add your handling code here:
        String alf = (JOptionPane.showInputDialog("Nuevo Padecimiento"));
        //System.out.println(alf);
        //String padecimiento= alf.trim();
        if(alf == null){
            //System.out.println("hola");
        }else{
            String tipo= alf.trim();
            
            String sql = "INSERT INTO PADECIMIENTO VALUES (SECUENCIA_PADECIMIENTO.nextval, '"+tipo+"') ";
                
            
            Connection connection = con.iniciarConexion();
            try {
                 Statement sta = connection.createStatement();
                 sta.executeUpdate(sql);
                 sta.close();
            } catch (SQLException ex) {

                        JOptionPane.showMessageDialog(null,ex);
            }
            comboPadecimiento();
        }
    }//GEN-LAST:event_btnLlenarPadecimientoMouseClicked

    private void btnLlenarAlergiasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLlenarAlergiasMouseClicked
        // TODO add your handling code here:
        String alf = (JOptionPane.showInputDialog("Nueva Alergia"));
        //System.out.println(alf);
        //String padecimiento= alf.trim();
        if(alf == null){
            //System.out.println("hola");
        }else{
            String tipo= alf.trim();
            
            String sql = "INSERT INTO ALERGIA VALUES (SECUENCIA_ALERGIA.nextval, '"+tipo+"') ";
                
            
            Connection connection = con.iniciarConexion();
            try {
                 Statement sta = connection.createStatement();
                 sta.executeUpdate(sql);
                 sta.close();
            } catch (SQLException ex) {

                        JOptionPane.showMessageDialog(null,ex);
            }
            comboAlergias();
        }
        
    }//GEN-LAST:event_btnLlenarAlergiasMouseClicked

    private void btnGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseClicked
        // TODO add your handling code here:
        cortadorPadecimiento();
        cortadorAlergia();
        JOptionPane.showMessageDialog(null,"Paciente Registrado Correctamente","Realizado",JOptionPane.INFORMATION_MESSAGE);
        if(cont>0){
            btnFinalizar.setVisible(true);
        }
        
        
    }//GEN-LAST:event_btnGuardarMouseClicked

    private void btnFinalizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFinalizarMouseClicked
        // TODO add your handling code here:
        MenuPrincipal menu = new MenuPrincipal();
        menu.setVisible(true);
        this.hide();
    }//GEN-LAST:event_btnFinalizarMouseClicked

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
            java.util.logging.Logger.getLogger(Pacientes_3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pacientes_3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pacientes_3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pacientes_3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new Pacientes_3().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnFinalizar;
    private javax.swing.JLabel btnGuardar;
    private javax.swing.JLabel btnLlenarAlergias;
    private javax.swing.JLabel btnLlenarPadecimiento;
    private javax.swing.JComboBox cmbAlergias;
    private javax.swing.JComboBox cmbPadecimiento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
