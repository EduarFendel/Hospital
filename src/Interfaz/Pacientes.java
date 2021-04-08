package Interfaz;

import Conexion.Conexion;
import hospital.Hospital;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Pacientes extends javax.swing.JFrame {
    
    Conexion con = new Conexion();
    int contador = 0;
    /**
     * Creates new form Pacientes
     */
    public Pacientes() {
        initComponents();
        grupo_sexo.add(op_masculino);
        grupo_sexo.add(op_femenino);
        btn_Agregar.setVisible(false);
        setLocationRelativeTo(null);
        
        //-------FONDO DE PANTALLA PRINCIPAL---------------
        ((JPanel)getContentPane()).setOpaque(false); 
        ImageIcon uno=new ImageIcon(this.getClass().getResource("/Imagenes/fondo1.jpg")); 
        JLabel fondo= new JLabel(); 
        fondo.setIcon(uno); 
        getLayeredPane().add(fondo,JLayeredPane.FRAME_CONTENT_LAYER); 
        fondo.setBounds(0,0,uno.getIconWidth(),uno.getIconHeight());
    }
    
    void InsertarPersona(String dpi){
        String Sexo = "";
        if(op_masculino.isSelected()){
             Sexo = "Masculino";
        }else{
            Sexo = "Femenino";
        }
        
        String PrimerNombre = txtPrimerNombre.getText().trim();
        String SegundoNombre = txtSegundoNombre.getText().trim();
        String PrimerApellido = txtPrimerApellido.getText().trim();
        String SegundoApellido = txtSegundoApellido.getText().trim();
        String Edad = txtEdad.getText().trim();
        String Dpi = txtDpi.getText().trim();
        String Direccion = txtDireccion.getText().trim();
        String Telefono = txtTelefono.getText().trim();
        String Email = txtEmail.getText().trim();
        
        
        String sql6 = "INSERT INTO PERSONA VALUES (SECUENCIA_PERSONA.nextval, '"+PrimerNombre+"','"+SegundoNombre+"','"+PrimerApellido+"','"+SegundoApellido+"','"+Sexo+"','"+Edad+"','"+Dpi+"','"+Direccion+"') ";
                
        
        Connection connection = con.iniciarConexion();
        try {
             Statement sta7 = connection.createStatement();
             sta7.executeUpdate(sql6);
             sta7.close();
        } catch (SQLException ex) {
                    
                    JOptionPane.showMessageDialog(null,ex);
        }
        
        String codigo_persona = CodigoPersona(dpi);
        String sql = "INSERT INTO INFORMACION_ADICIONAL VALUES (secuencia_informacion.nextval,'"+Email+"','"+Telefono+"','"+codigo_persona+"')";
       
        try {
             Statement sta = connection.createStatement();
             sta.executeUpdate(sql);
             sta.close();
        } catch (SQLException ex) {
                    
                    JOptionPane.showMessageDialog(null,ex);
        }
        
        
        txtPrimerNombre.setEditable(false);
        txtSegundoNombre.setEditable(false);
        txtPrimerApellido.setEditable(false);
        txtSegundoApellido.setEditable(false);
        txtEdad.setEditable(false);
        txtDireccion.setEditable(false);
        btn_Agregar.setVisible(true);
        txtEmail.setText("");
        txtTelefono.setText("");
        
        ImageIcon uno=new ImageIcon(this.getClass().getResource("/Imagenes/next.png")); 
        btnGuardar.setIcon(uno);
        btnGuardar.setText("Siguiente"); 
        
        txtEmail.requestFocus();
        
    }
    
    String CodigoPersona(String dpi){
        String CodigoPersona="";
        Hospital hosp = new Hospital();
        
         Connection connection = con.iniciarConexion();
        
         String sql3 = "SELECT CODIGO_PERSONA FROM PERSONA WHERE DPI = '"+dpi+"'";
         
         try {
            Statement st2 = connection.createStatement();
            ResultSet rs2 = st2.executeQuery(sql3);
                    
            while (rs2.next()){
                CodigoPersona = rs2.getString("CODIGO_PERSONA");
                hosp.setCodigo_persona(CodigoPersona);
            }
                        
        } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
        }
        
        return CodigoPersona;
    }
    
    void InsertarInfoAdicional(String CodigoPersona){
      
        String Email = txtEmail.getText().trim();
        String Telefono = txtTelefono.getText().trim();
        
        String sql = "INSERT INTO INFORMACION_ADICIONAL VALUES (secuencia_informacion.nextval,'"+Email+"','"+Telefono+"','"+CodigoPersona+"')";
                
        
        Connection connection = con.iniciarConexion();
        try {
             Statement sta = connection.createStatement();
             sta.executeUpdate(sql);
             sta.close();
        } catch (SQLException ex) {
                    
                    JOptionPane.showMessageDialog(null,ex);
        }
        
    }
    
    void LlenarInfoAdicional(String codigo_persona){
        
        Connection connection = con.iniciarConexion();
        
        String telefono = "";
        String email = "";
        
        String sql3 = "SELECT EMAIL, TELEFONO FROM INFORMACION_ADICIONAL WHERE CODIGO_PERSONA = '"+codigo_persona+"'";
         
         try {
            Statement st2 = connection.createStatement();
            ResultSet rs2 = st2.executeQuery(sql3);
                    
            while (rs2.next()){
                 telefono = rs2.getString("TELEFONO").trim();
                 email = (rs2.getString("EMAIL")).trim();
            }
                        
        } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
        }
         
        txtEmail.setText(email);
        txtTelefono.setText(telefono);
    }
    
    void Limpiar(){
        txtPrimerNombre.setText("");
        txtSegundoNombre.setText("");
        txtPrimerApellido.setText("");
        txtSegundoApellido.setText("");
        txtEdad.setText("");
        txtDpi.setText("");
        txtDireccion.setText("");
        txtTelefono.setText("");
        txtSegundoNombre.setText("");
        txtEmail.setText("");
        op_masculino.setSelected(false);
        op_femenino.setSelected(false);
    
    }
    
    void Bloquear(){
        txtPrimerNombre.setEditable(false);
        txtEdad.setEditable(false);
        txtDpi.setEditable(false);
        txtDireccion.setEditable(false);
        //txtTelefono.setEditable(false);
        txtTelefono.setEditable(false);
        //txtPeso.setEditable(false);
        //txtOcupacion.setEditable(false);
        txtSegundoNombre.setEditable(false);
        //txtMedicamento.setEditable(false);
        //txtEmail.setEditable(false);
        txtEmail.setEditable(false);
        op_masculino.setEnabled(false);
        op_femenino.setEnabled(false);
    }
    
    void Modificar(){
        String Sexo = "";
        if(op_masculino.isSelected()){
             Sexo = "Masculino";
        }else{
            Sexo = "Femenino";
        }
        
        String PrimerNombre = txtPrimerNombre.getText().trim();
        String SegundoNombre = txtSegundoNombre.getText().trim();
        String PrimerApellido = txtPrimerApellido.getText().trim();
        String SegundoApellido = txtSegundoApellido.getText().trim();
        String Edad = txtEdad.getText().trim();
        String Dpi = txtDpi.getText().trim();
        String Direccion = txtDireccion.getText().trim();
       
        
        String Telefono = txtTelefono.getText().trim();
        String Email = txtEmail.getText().trim();
        
        
        String sql6 = "UPDATE PERSONA SET NOMBRE='"+PrimerNombre+"', SEGUNDO_NOMBRE = '"+SegundoNombre+"', PRIMER_APELLIDO = '"+PrimerApellido+"', SEGUNDO_APELLIDO = '"+SegundoApellido+"', SEXO = '"+Sexo+"', EDAD = '"+Edad+"', DIRECCION = '"+Direccion+"' WHERE DPI = '"+Dpi+"'";
                
        
        Connection connection = con.iniciarConexion();
        try {
             Statement sta7 = connection.createStatement();
             sta7.executeUpdate(sql6);
             sta7.close();
        } catch (SQLException ex) {
                    
                    JOptionPane.showMessageDialog(null,ex);
        }
        
        JOptionPane.showMessageDialog(null,"Paciente Actualizado","Realizado",JOptionPane.INFORMATION_MESSAGE);
        txtPrimerNombre.setText("");
        txtSegundoNombre.setText("");
        txtPrimerApellido.setText("");
        txtSegundoApellido.setText("");
        txtDpi.setText("");
        txtEdad.setText("");
        txtDireccion.setText("");
        txtEmail.setText("");
        txtTelefono.setText("");
        
        btnGuardar.setText("Guardar");
        btn_Agregar.setVisible(false);
        txtDpi.requestFocus();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupo_sexo = new javax.swing.ButtonGroup();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbl_close = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JLabel();
        btn_Agregar = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtDpi = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtPrimerNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        op_masculino = new javax.swing.JRadioButton();
        op_femenino = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        txtEdad = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtSegundoNombre = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtPrimerApellido = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtSegundoApellido = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(7, 7, 7, 7, new java.awt.Color(0, 0, 0)));
        jPanel3.setOpaque(false);
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Pacientes");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(247, 18, -1, -1));

        lbl_close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/close.png"))); // NOI18N
        lbl_close.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_closeMouseClicked(evt);
            }
        });
        jPanel3.add(lbl_close, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 10, -1, -1));

        jPanel2.setOpaque(false);
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("E-mail:");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 52, -1, -1));
        jPanel2.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 49, 194, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Telefono:");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 89, -1, -1));
        jPanel2.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 86, 194, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Direccion:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 14, -1, -1));
        jPanel2.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 11, 194, -1));

        btnGuardar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/save.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuardarMouseClicked(evt);
            }
        });
        jPanel2.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, -1, -1));

        btn_Agregar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_Agregar.setForeground(new java.awt.Color(255, 255, 255));
        btn_Agregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Edit-48.png"))); // NOI18N
        btn_Agregar.setText("Agregar");
        btn_Agregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Agregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_AgregarMouseClicked(evt);
            }
        });
        jPanel2.add(btn_Agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, 110, -1));

        jPanel3.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(387, 88, 340, 280));

        jPanel1.setOpaque(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("No. DPI:");

        txtDpi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDpiKeyTyped(evt);
            }
        });

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/search.png"))); // NOI18N
        btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBuscarMouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Primer Nombre:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Sexo:");

        op_masculino.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        op_masculino.setText("Masculino");

        op_femenino.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        op_femenino.setText("Femenino");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Edad:");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Segundo Nombre:");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Primer Apellido:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Segundo Apellido:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addComponent(txtPrimerNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtDpi, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(btnBuscar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(90, 90, 90)
                                .addComponent(op_masculino)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(op_femenino))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel7))
                                .addGap(21, 21, 21)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtSegundoNombre)
                                    .addComponent(txtPrimerApellido)
                                    .addComponent(txtSegundoApellido, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBuscar)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(txtDpi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrimerNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSegundoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtPrimerApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtSegundoApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(op_masculino)
                            .addComponent(op_femenino))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 88, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 742, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbl_closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_closeMouseClicked
        // TODO add your handling code here:
        this.hide();
    }//GEN-LAST:event_lbl_closeMouseClicked

    private void btnGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseClicked
        // TODO add your handling code here:
        Hospital hosp = new Hospital();
        btn_Agregar.setVisible(true);
        
        
        
        if(btnGuardar.getText().equals("Guardar")){
            String dpi = txtDpi.getText().trim();

            if(txtPrimerNombre.getText().isEmpty() || txtSegundoNombre.getText().isEmpty() || txtEdad.getText().isEmpty() || txtDpi.getText().isEmpty() ||
               txtPrimerApellido.getText().isEmpty() || txtSegundoApellido.getText().isEmpty() ||  txtDireccion.getText().isEmpty() || txtTelefono.getText().isEmpty() || txtEmail.getText().isEmpty()){

                JOptionPane.showMessageDialog(null,"Por Favor llene todos los campos","Error",JOptionPane.ERROR_MESSAGE);

            }else{
               
                    ImageIcon uno=new ImageIcon(this.getClass().getResource("/Imagenes/Edit-48.png"));
                    btn_Agregar.setIcon(uno);
                    btn_Agregar.setText("Agregar");
                    InsertarPersona(dpi);
                    //InsertarInfoAdicional(CodigoPersona(dpi));
                    
                    JOptionPane.showMessageDialog(null,"Datos Personales Ingresados","Realizado",JOptionPane.INFORMATION_MESSAGE);        
                    
                 }
              
        }else if(btnGuardar.getText().equals("Siguiente")){
            Pacientes_2 siguiente = new Pacientes_2();
            siguiente.setVisible(true);
            this.hide();
        }else if(btnGuardar.getText().equals("Modificar")){
            Modificar();
        }
    }//GEN-LAST:event_btnGuardarMouseClicked

    private void txtDpiKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDpiKeyTyped
        // TODO add your handling code here:
        
                    
    }//GEN-LAST:event_txtDpiKeyTyped

    private void btnBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMouseClicked
        // TODO add your handling code here:
        
        
        boolean existe = false;
        String codigo_persona= "";
        String sexo="";
        String nombre="";
        String edad="";
        String dpi= txtDpi.getText().trim();
        String segundo_nombre="";
        String primer_apellido="";
        String apellido="";
        String direccion = "";
        String segundo_apellido = "";
        
        
        Connection connection = con.iniciarConexion();
        
         String sql3 = "SELECT CODIGO_PERSONA, NOMBRE, SEGUNDO_NOMBRE, PRIMER_APELLIDO,SEGUNDO_APELLIDO, SEXO, EDAD, DIRECCION FROM PERSONA WHERE DPI = '"+dpi+"'";
         
         try {
            Statement st2 = connection.createStatement();
            ResultSet rs2 = st2.executeQuery(sql3);
                    
            while (rs2.next()){
                 existe = true;
                 codigo_persona = rs2.getString("CODIGO_PERSONA");
                 nombre = (rs2.getString("NOMBRE")).trim();
                 segundo_nombre = (rs2.getString("SEGUNDO_NOMBRE")).trim();
                 primer_apellido = (rs2.getString("PRIMER_APELLIDO")).trim();
                 segundo_apellido = (rs2.getString("SEGUNDO_APELLIDO")).trim();
                 sexo = (rs2.getString("SEXO")).trim();
                 edad = (rs2.getString("EDAD")).trim();
                 direccion = (rs2.getString("DIRECCION")).trim();
                 
            }
                        
        } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
        }
         
        if(existe){
            btn_Agregar.setVisible(true);
            btnGuardar.setText("Modificar");
            btn_Agregar.setText("Cancelar");
            ImageIcon uno=new ImageIcon(this.getClass().getResource("/Imagenes/Cancel.png"));
            btn_Agregar.setIcon(uno);
            txtPrimerNombre.setText(nombre);
            txtSegundoNombre.setText(segundo_nombre);
            txtPrimerApellido.setText(primer_apellido);
            txtSegundoApellido.setText(segundo_apellido);
            if(sexo.equals("Masculino")){
                op_masculino.setSelected(true);
            }else{
                op_femenino.setSelected(true);
            }
            txtEdad.setText(edad);
            txtDireccion.setText(direccion);
            
            LlenarInfoAdicional(codigo_persona);
          
            
        }else{
            JOptionPane.showMessageDialog(null,"Paciente No Encontrado","Mensaje",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnBuscarMouseClicked

    private void btn_AgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_AgregarMouseClicked
        // TODO add your handling code here:
        
        if(btn_Agregar.getText().equals("Agregar")) {
            
            if(txtEmail.getText().isEmpty() || txtTelefono.getText().isEmpty()){
               JOptionPane.showMessageDialog(null,"Por Favor llene los campos de Email y Telefono","Error",JOptionPane.ERROR_MESSAGE);
            }else{
                String dpi = txtDpi.getText().trim();
                InsertarInfoAdicional(CodigoPersona(dpi));
                JOptionPane.showMessageDialog(null,"Telefono, e-mail ingresados","Realizado",JOptionPane.INFORMATION_MESSAGE);        
                txtEmail.setText("");
                txtTelefono.setText("");
            }
            
        
        
        }else if(btn_Agregar.getText().equals("Cancelar")) {
            Limpiar();
            btn_Agregar.setVisible(false);
            btnGuardar.setText("Guardar");
        }  
        
        
    }//GEN-LAST:event_btn_AgregarMouseClicked

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
            java.util.logging.Logger.getLogger(Pacientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pacientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pacientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pacientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pacientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnBuscar;
    private javax.swing.JLabel btnGuardar;
    private javax.swing.JLabel btn_Agregar;
    private javax.swing.ButtonGroup grupo_sexo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lbl_close;
    private javax.swing.JRadioButton op_femenino;
    private javax.swing.JRadioButton op_masculino;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtDpi;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtPrimerApellido;
    private javax.swing.JTextField txtPrimerNombre;
    private javax.swing.JTextField txtSegundoApellido;
    private javax.swing.JTextField txtSegundoNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
