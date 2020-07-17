/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vista;

import Controlador.Control_Autores;
import Modelo.Autores;
import Modelo.NacionAutor;
import Modelo.PaisAutor;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mark-
 */
public class FRM_Autores extends javax.swing.JInternalFrame {
    Control_Autores cau=new Control_Autores();
    private int fila=-1;
    int Codaut;//variable que obtiene el valor de la columna 0 de la tabla (corresponde al codigo)
    DefaultTableModel tabla=new DefaultTableModel();
    private int sswitch=0;
    
    //metodo encargado de llenar la tabla con sus respectivos datos
    public void LlenarTabla(String Dato){
    tabla.setColumnCount(0);//la tabla parte con la columna 0
        //agregar las columnas
        tabla.addColumn("Codigo");
        tabla.addColumn("Nombre Autor/Pseudonimo");
        tabla.addColumn("Apellido Paterno");
        tabla.addColumn("Apellido Materno");
        tabla.addColumn("Nacionalidad");
        tabla.addColumn("Pais");
        //crear arraylist para recibir datos. recibe un arraylist con otro arraylist
        List<Autores> lista=cau.listarAutores(Dato);
        //medir el largo del arraylist para crear las filas de la tablas.
        tabla.setNumRows(lista.size());
        //mostrar la cantidad de registros
        registros.setText("CANTIDAD DE REGISTROS= "+lista.size());
        for (int i = 0; i < lista.size(); i++) {
            tabla.setValueAt(lista.get(i).getCod_autor(), i, 0);
            //si el pseudonimo del autor no existe
            if (lista.get(i).getPseu_autor()==(null)) {
                //toma solo el nombre del autor
                tabla.setValueAt(lista.get(i).getNom_autor(), i, 1);
            }else{
                //si no toma el nombre del autores junto al pseudonimo entre parentecis.
            tabla.setValueAt(lista.get(i).getNom_autor()+" "+"("+lista.get(i).getPseu_autor()+")", i, 1);
            }
            tabla.setValueAt(lista.get(i).getApp_autor(), i, 2);
            tabla.setValueAt(lista.get(i).getApm_autor(), i, 3);
            tabla.setValueAt(lista.get(i).getNom_nac(), i, 4);
            tabla.setValueAt(lista.get(i).getNom_pais(), i, 5);
        }
        jTable1.setModel(tabla);//el jtable recibe lo que es la tabla. con los nombres de sus columans.
        
        //poner invisible la columna de codigos, para una mejor visualizacion
        jTable1.getColumnModel().getColumn(0).setMaxWidth(0);
        jTable1.getColumnModel().getColumn(0).setMinWidth(0);
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(0);
    }
    

    //Llenar el combo box con los paises disponibles
    private void ComboPaises(){
       DefaultComboBoxModel combo = new DefaultComboBoxModel();
        Control_Autores conau=new Control_Autores();
        List<PaisAutor> lista=conau.comboPais();
        for(PaisAutor PA:lista){
            PA = new PaisAutor(PA.getCod_pais(), PA.getNom_pais());
            combo.addElement(PA);
        }
        Cpais.setModel(combo);
  }
    
    //llenar el combo box con las nacionalidades disponibles
    private void ComboNac(){
       DefaultComboBoxModel combo = new DefaultComboBoxModel();
        Control_Autores conau=new Control_Autores();
        List<NacionAutor> lista=conau.comboNacPais();
        for(NacionAutor NA:lista){
            NA = new NacionAutor(NA.getCod_nac(), NA.getNom_nac());
            combo.addElement(NA);
        }
        Cnacion.setModel(combo);
  }
    
    
    public FRM_Autores() {
        initComponents();
        ComboNac();//llama al metodo para llenar combo box 
        ComboPaises();//llama al metodo para llenar combo box
        LlenarTabla("");//llama al metodo para llenar la tabla con la lista de autores
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jButton5 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        Panel = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        jButton2 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        jRadioButton1 = new javax.swing.JRadioButton();
        Buscador = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        jToolBar2 = new javax.swing.JToolBar();
        registros = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        nom = new javax.swing.JTextField();
        pseu = new javax.swing.JTextField();
        app = new javax.swing.JTextField();
        apm = new javax.swing.JTextField();
        Cnacion = new javax.swing.JComboBox();
        agregarnac = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        Guardar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        NAC = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        Cpais = new javax.swing.JComboBox();
        guardarnac = new javax.swing.JButton();

        jButton5.setText("jButton5");

        jLabel7.setText("jLabel7");

        setBorder(null);
        setClosable(true);

        jPanel1.setLayout(new java.awt.BorderLayout());

        Panel.setBackground(new java.awt.Color(102, 102, 102));
        Panel.setForeground(new java.awt.Color(0, 0, 0));
        Panel.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jToolBar1.setBackground(new java.awt.Color(204, 204, 204));
        jToolBar1.setBorder(null);
        jToolBar1.setFloatable(false);
        jToolBar1.setForeground(new java.awt.Color(204, 204, 204));
        jToolBar1.setRollover(true);

        jButton1.setText("Agregar");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);
        jToolBar1.add(jSeparator1);

        jButton2.setText("Editar");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton2);
        jToolBar1.add(jSeparator2);

        jRadioButton1.setText("jRadioButton1");
        jRadioButton1.setFocusable(false);
        jRadioButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jRadioButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jRadioButton1);

        Buscador.setBackground(new java.awt.Color(70, 110, 196));
        Buscador.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        Buscador.setForeground(new java.awt.Color(0, 0, 0));
        Buscador.setText("Buscador");
        Buscador.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Buscador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BuscadorMouseClicked(evt);
            }
        });
        Buscador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                BuscadorKeyTyped(evt);
            }
        });
        jToolBar1.add(Buscador);
        jToolBar1.add(jSeparator3);

        jPanel2.add(jToolBar1, java.awt.BorderLayout.PAGE_END);

        jToolBar2.setBackground(new java.awt.Color(204, 204, 204));
        jToolBar2.setBorder(null);
        jToolBar2.setFloatable(false);
        jToolBar2.setForeground(new java.awt.Color(102, 102, 102));
        jToolBar2.setRollover(true);

        registros.setBackground(new java.awt.Color(0, 0, 0));
        registros.setForeground(new java.awt.Color(0, 0, 0));
        registros.setText("jLabel1");
        jToolBar2.add(registros);

        jPanel2.add(jToolBar2, java.awt.BorderLayout.PAGE_START);

        jTable1.setBackground(new java.awt.Color(204, 204, 204));
        jTable1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jTable1.setForeground(new java.awt.Color(0, 0, 0));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setAlignmentX(2.0F);
        jTable1.setAlignmentY(2.0F);
        jTable1.setMinimumSize(new java.awt.Dimension(65, 70));
        jTable1.setName(""); // NOI18N
        jTable1.setRowHeight(25);
        jTable1.setSelectionBackground(new java.awt.Color(70, 110, 196));
        jTable1.setSelectionForeground(new java.awt.Color(51, 51, 51));
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel2.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        Panel.addTab("Listado Autores", jPanel2);

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));
        jPanel3.setForeground(new java.awt.Color(153, 153, 153));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Nombre:");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Pseudonimo:");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Apellido P. :");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Apellido M. :");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Nacion:");

        nom.setBackground(new java.awt.Color(70, 110, 196));
        nom.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        nom.setForeground(new java.awt.Color(0, 0, 0));

        pseu.setBackground(new java.awt.Color(70, 110, 196));
        pseu.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        pseu.setForeground(new java.awt.Color(0, 0, 0));

        app.setBackground(new java.awt.Color(70, 110, 196));
        app.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        app.setForeground(new java.awt.Color(0, 0, 0));

        apm.setBackground(new java.awt.Color(70, 110, 196));
        apm.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        apm.setForeground(new java.awt.Color(0, 0, 0));

        Cnacion.setBackground(new java.awt.Color(70, 110, 196));
        Cnacion.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        Cnacion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        agregarnac.setBackground(new java.awt.Color(204, 204, 204));
        agregarnac.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        agregarnac.setForeground(new java.awt.Color(0, 0, 0));
        agregarnac.setText("Agregar");
        agregarnac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarnacActionPerformed(evt);
            }
        });

        Guardar.setBackground(new java.awt.Color(204, 204, 204));
        Guardar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        Guardar.setForeground(new java.awt.Color(0, 0, 0));
        Guardar.setText("Guardar");
        Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("+ Nacionalidades");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator4)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(app, javax.swing.GroupLayout.DEFAULT_SIZE, 878, Short.MAX_VALUE)
                            .addComponent(nom)
                            .addComponent(pseu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 878, Short.MAX_VALUE)
                            .addComponent(apm, javax.swing.GroupLayout.DEFAULT_SIZE, 878, Short.MAX_VALUE)
                            .addComponent(Cnacion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addComponent(agregarnac, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                    .addContainerGap(749, Short.MAX_VALUE)
                    .addComponent(Guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(56, 56, 56)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(pseu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(app, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(apm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(Cnacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(agregarnac, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                    .addContainerGap(306, Short.MAX_VALUE)
                    .addComponent(Guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(141, 141, 141)))
        );

        Panel.addTab("Operaciones", jPanel3);

        jPanel4.setBackground(new java.awt.Color(153, 153, 153));
        jPanel4.setForeground(new java.awt.Color(153, 153, 153));

        jLabel9.setBackground(new java.awt.Color(0, 0, 0));
        jLabel9.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Agregar Nacionalidades");

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Pais:");

        NAC.setBackground(new java.awt.Color(70, 110, 196));
        NAC.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        NAC.setForeground(new java.awt.Color(0, 0, 0));

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Nacionalidad:");
        jLabel11.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Cpais.setBackground(new java.awt.Color(70, 110, 196));
        Cpais.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        Cpais.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        guardarnac.setBackground(new java.awt.Color(204, 204, 204));
        guardarnac.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        guardarnac.setForeground(new java.awt.Color(0, 0, 0));
        guardarnac.setText("Guardar");
        guardarnac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarnacActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator5, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(369, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(NAC, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(221, 221, 221))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(Cpais, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(219, 219, 219))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(guardarnac, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(331, 331, 331))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addComponent(NAC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(Cpais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(guardarnac, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        Panel.addTab("Agregar Nacionalidad", jPanel4);

        jPanel1.add(Panel, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //boton para agregar mas autores
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        sswitch=0;//mantiene a la variable sswitch en 0
        Panel.setSelectedIndex(1);//redirecciona y posiciona la vista en el panel de agregar mas autores.
        nom.grabFocus();//posiciona la careta en el campo del nombre del autor.
    }//GEN-LAST:event_jButton1ActionPerformed

    //boton para guardar datos de nuevos datos de autores o datos editados de autores
    private void GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarActionPerformed
        //instancia de la clase nacion de autores para seleccionar el dato en el combobox
        NacionAutor nacion=(NacionAutor)Cnacion.getSelectedItem();
        //compara los campos con espacios vacios.
        if (nom.getText().equals("") && pseu.getText().equals("") && app.getText().equals("") && apm.getText().equals("")){
            //arroja un mensaje para ingresar todos los datos
            JOptionPane.showMessageDialog(this, "DEBE INGRESAR AL MENOS UN DATO", "La biblioteca",JOptionPane.OK_OPTION+JOptionPane.INFORMATION_MESSAGE);
            nom.grabFocus();
        }else{
            //si switch = 0 se insertan los datos hacia el control de autores en el metodo de Insertar.
            if (sswitch==0) cau.InsertarAutores(nom.getText(), pseu.getText(), app.getText(), apm.getText(), nacion.getCod_nac());
            //si no se envian los datos a los parametros del metodo editar.
            else cau.EditarAutores(Codaut, nom.getText(), pseu.getText(), app.getText(), apm.getText(), nacion.getCod_nac());  
        }   
    nom.setText("");
    pseu.setText("");
    app.setText("");
    apm.setText("");
    LlenarTabla("");
    sswitch=0;
    Panel.setSelectedIndex(0);//se selecciona automaticamente el panel 0, donde se encuentra la tabla.
        //envia un mensaje para aclarar que la operacion fue realizada
        JOptionPane.showMessageDialog(this, "OPERACION REALIZADA", "EL MUSEO",JOptionPane.OK_OPTION+JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_GuardarActionPerformed

    //boton para editar los datos que se escogan.
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (fila>-1) {//si la fila es mayor que -1, debe poder editar la fila.
            //se pone la variable codaut al valor que tiene la fila, al presionarla.
            Codaut=Integer.parseInt(String.valueOf(jTable1.getValueAt(fila, 0)));
            //pone los datos a los textfields correspondientes
            nom.setText(String.valueOf(jTable1.getValueAt(fila, 1)));
            app.setText(String.valueOf(jTable1.getValueAt(fila, 2)));
            apm.setText(String.valueOf(jTable1.getValueAt(fila, 3)));
            //swwitch vale 1
            sswitch=1;
            //redireccion al panel 1
            Panel.setSelectedIndex(1);
        } else {
            //mensaje en caso de escoger ninguna fila a editar
           JOptionPane.showMessageDialog(this, "DEBE SELECCIONAR UNA FILA","ADVERTENCIA",JOptionPane.OK_OPTION+JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        fila=jTable1.rowAtPoint(evt.getPoint());
    }//GEN-LAST:event_jTable1MouseClicked

    private void agregarnacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarnacActionPerformed
        //redirecciona al panel 2, para agregar nacionalidades.
        Panel.setSelectedIndex(2);
    }//GEN-LAST:event_agregarnacActionPerformed

    private void guardarnacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarnacActionPerformed
        //instancia de la clase paises de autores para seleccionar el dato en el combobox
        PaisAutor pais=(PaisAutor)Cpais.getSelectedItem();
        //compara los campos con espacios vacios.
        if (NAC.getText().equals("")){
            //arroja un mensaje para ingresar todos los datos
            JOptionPane.showMessageDialog(this, "DEBE INGRESAR DATOS", "LA BIBLIOTECA",JOptionPane.OK_OPTION+JOptionPane.INFORMATION_MESSAGE);
            NAC.grabFocus();
            Panel.setSelectedIndex(2);
        }else{
            cau.IngresarNacion(NAC.getText(), pais.getCod_pais());
            
        }   
    NAC.setText("");
    ComboNac();
    Panel.setSelectedIndex(1);//se selecciona automaticamente el panel 1, donde se encuentra el combo box de las naciones.
        //envia un mensaje para aclarar que la operacion fue realizada
        JOptionPane.showMessageDialog(this, "OPERACION REALIZADA", "LA BIBLIOTECA",JOptionPane.OK_OPTION+JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_guardarnacActionPerformed

    private void BuscadorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BuscadorKeyTyped
        LlenarTabla(Buscador.getText());
    }//GEN-LAST:event_BuscadorKeyTyped

    private void BuscadorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BuscadorMouseClicked
        Buscador.setText("");
    }//GEN-LAST:event_BuscadorMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Buscador;
    private javax.swing.JComboBox Cnacion;
    private javax.swing.JComboBox Cpais;
    private javax.swing.JButton Guardar;
    private javax.swing.JTextField NAC;
    private javax.swing.JTabbedPane Panel;
    private javax.swing.JButton agregarnac;
    private javax.swing.JTextField apm;
    private javax.swing.JTextField app;
    private javax.swing.JButton guardarnac;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JTextField nom;
    private javax.swing.JTextField pseu;
    private javax.swing.JLabel registros;
    // End of variables declaration//GEN-END:variables
}