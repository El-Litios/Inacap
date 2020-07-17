/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Control_Clientes;
import Controlador.Control_Trabajador;
import Modelo.Cliente;
import Modelo.RolTrabajador;
import Modelo.Trabajador;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mark-
 */
public class Gestion_Personas extends javax.swing.JInternalFrame {
    Control_Trabajador crt=new Control_Trabajador();
    Control_Clientes crc=new Control_Clientes();
    
    int codTrabajador;
    int codCliente;
    
    private int filaT=-1;
    private int filaC=-1;
    
    private int sswitchT=0;
    private int sswitchC=0;
    
    DefaultTableModel tablaT=new DefaultTableModel();
    DefaultTableModel tablaC=new DefaultTableModel();
    
    //llenar tabla de trabajadores
    public void LlenarTablaTrabajador(String dato){
    tablaT.setColumnCount(0);
        tablaT.addColumn("Codigo");
        tablaT.addColumn("Rut");
        tablaT.addColumn("Nombre");
        tablaT.addColumn("Direccion 1");
        tablaT.addColumn("Direccion 2");
        tablaT.addColumn("Celular");
        tablaT.addColumn("Telefono Fijo");
        tablaT.addColumn("Correo");
        tablaT.addColumn("Inicio de Servicio");
        tablaT.addColumn("Rol");
        List<Trabajador> lista=crt.listarTrabajador(dato);
        tablaT.setNumRows(lista.size());
        RegistrosTrabajadores.setText("CANTIDAD DE TRABAJADORES= "+lista.size());
        for (int i = 0; i < lista.size(); i++) {
            tablaT.setValueAt(lista.get(i).getCod_traba(), i, 0);
            tablaT.setValueAt(lista.get(i).getRut_traba(), i, 1);
            tablaT.setValueAt(lista.get(i).getNom_traba(), i, 2);
            tablaT.setValueAt(lista.get(i).getDirec1_traba(), i, 3);
            
            if (lista.get(i).getDirec2_traba().toString().equalsIgnoreCase("null")) {
                tablaT.setValueAt("--------------------------------", i, 4);
            }else if (lista.get(i).getDirec2_traba().toString().equalsIgnoreCase("")) {
                tablaT.setValueAt("--------------------------------", i, 4);
            }else{
                tablaT.setValueAt(lista.get(i).getDirec2_traba(), i, 4);
            }
            
            tablaT.setValueAt(lista.get(i).getTel1_traba(), i, 5);
            
            if (lista.get(i).getTel2_traba().toString().equalsIgnoreCase("null")) {
                tablaT.setValueAt("--------------------------------", i, 6);
            }else if (lista.get(i).getTel2_traba().toString().equalsIgnoreCase("")) {
                tablaT.setValueAt("--------------------------------", i, 6);
            }else{
                tablaT.setValueAt(lista.get(i).getTel2_traba(), i, 6);
            }
            
            
            tablaT.setValueAt(lista.get(i).getCorreo_traba(), i, 7);
            tablaT.setValueAt(lista.get(i).getFecini_traba(), i, 8);
            tablaT.setValueAt(lista.get(i).getNom_rol(), i, 9);
        }
        TablaTrabajadores.setModel(tablaT);
        
        TablaTrabajadores.getColumnModel().getColumn(0).setMaxWidth(0);
        TablaTrabajadores.getColumnModel().getColumn(0).setMinWidth(0);
        TablaTrabajadores.getColumnModel().getColumn(0).setPreferredWidth(0);
    }
    
    public void LlenarTablaCliente(String dato){
    tablaC.setColumnCount(0);
        tablaC.addColumn("Codigo");
        tablaC.addColumn("Rut");
        tablaC.addColumn("Nombre Completo");
        tablaC.addColumn("Fecha de Nacimiento");
        tablaC.addColumn("Direccion 1");
        tablaC.addColumn("Direccion 2");
        tablaC.addColumn("Celular");
        tablaC.addColumn("Telefono Fijo");
        tablaC.addColumn("Correo");        
        List<Cliente> lista=crc.ListaClientes(dato);
        tablaC.setNumRows(lista.size());
        RegistrosClientes1.setText("CLIENTES ALMACENADOS= "+lista.size());
        for (int i = 0; i < lista.size(); i++) {
            tablaC.setValueAt(lista.get(i).getCod_cliente(), i, 0);
            tablaC.setValueAt(lista.get(i).getRut_cliente(), i, 1);
            tablaC.setValueAt(lista.get(i).getNom_cliente(), i, 2);
            tablaC.setValueAt(lista.get(i).getFecn_cliente(), i, 3);
            tablaC.setValueAt(lista.get(i).getDirec1_cliente(), i, 4);
            
            if (lista.get(i).getDirec2_cliente().toString().equalsIgnoreCase("null")) {
                tablaC.setValueAt("------------------------------------", i, 5);
            }else if (lista.get(i).getDirec2_cliente().toString().equalsIgnoreCase("")) {
                tablaC.setValueAt("------------------------------------", i, 5);
            }else{
                tablaC.setValueAt(lista.get(i).getDirec2_cliente(), i, 5);
            }
            
            tablaC.setValueAt(lista.get(i).getTel1_cliente(), i, 6);
            
            if (lista.get(i).getTel2_cliente().toString().equalsIgnoreCase("null")) {
                tablaC.setValueAt("------------------------------------", i, 7);
            }else if (lista.get(i).getTel2_cliente().toString().equalsIgnoreCase("")) {
                tablaC.setValueAt("------------------------------------", i, 7);
            }else{
                tablaC.setValueAt(lista.get(i).getTel2_cliente(), i, 7);
            }
            tablaC.setValueAt(lista.get(i).getCo_cliente(), i, 8);
        }
        
        TablaClientes1.setModel(tablaC);
        TablaClientes1.getColumnModel().getColumn(0).setMaxWidth(0);
        TablaClientes1.getColumnModel().getColumn(0).setMinWidth(0);
        TablaClientes1.getColumnModel().getColumn(0).setPreferredWidth(0);
    }
    
    //combobox de ROles para trabajadores
    private void ComboboxRol(){
       DefaultComboBoxModel combo = new DefaultComboBoxModel();
        Control_Trabajador crt=new Control_Trabajador();
        List<RolTrabajador> lista=crt.comboboxRoles();
        for(RolTrabajador T:lista){
            T = new RolTrabajador(T.getCod_rol(), T.getNom_rol());
            combo.addElement(T);
        }
        ComboRolTrabajador.setModel(combo);
    }
    
    public Gestion_Personas() {
        initComponents();
        LlenarTablaTrabajador("");
        LlenarTablaCliente("");
        ComboboxRol();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane7 = new javax.swing.JTabbedPane();
        jPanel22 = new javax.swing.JPanel();
        PanelTrabajadores = new javax.swing.JTabbedPane();
        jPanel20 = new javax.swing.JPanel();
        jToolBar25 = new javax.swing.JToolBar();
        RegistrosTrabajadores = new javax.swing.JLabel();
        jToolBar26 = new javax.swing.JToolBar();
        AgregarTrabajador5 = new javax.swing.JButton();
        jSeparator86 = new javax.swing.JToolBar.Separator();
        jSeparator87 = new javax.swing.JToolBar.Separator();
        jLabel86 = new javax.swing.JLabel();
        EditarVenta5 = new javax.swing.JButton();
        jSeparator88 = new javax.swing.JToolBar.Separator();
        jLabel13 = new javax.swing.JLabel();
        jSeparator89 = new javax.swing.JToolBar.Separator();
        buscadorT = new javax.swing.JTextField();
        jSeparator90 = new javax.swing.JToolBar.Separator();
        EliminarVenta5 = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        TablaTrabajadores = new javax.swing.JTable();
        jPanel21 = new javax.swing.JPanel();
        jLabel87 = new javax.swing.JLabel();
        GuardarTrabajador = new javax.swing.JButton();
        jLabel88 = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        ComboRolTrabajador = new javax.swing.JComboBox();
        jSeparator9 = new javax.swing.JSeparator();
        RutTrabajador = new javax.swing.JTextField();
        jLabel90 = new javax.swing.JLabel();
        NombreTrabajador = new javax.swing.JTextField();
        jLabel91 = new javax.swing.JLabel();
        Dir1Trabajador = new javax.swing.JTextField();
        jLabel92 = new javax.swing.JLabel();
        Dir2Trabajador = new javax.swing.JTextField();
        jLabel93 = new javax.swing.JLabel();
        Tel1Trabajo = new javax.swing.JTextField();
        jLabel94 = new javax.swing.JLabel();
        Tel2Trabajador = new javax.swing.JTextField();
        jLabel95 = new javax.swing.JLabel();
        CorreoTrabajador = new javax.swing.JTextField();
        jLabel96 = new javax.swing.JLabel();
        FechaTrabajador = new javax.swing.JFormattedTextField();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        PanelClientes = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jToolBar13 = new javax.swing.JToolBar();
        RegistrosClientes1 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        TablaClientes1 = new javax.swing.JTable();
        jToolBar16 = new javax.swing.JToolBar();
        AgregarCliente = new javax.swing.JButton();
        jSeparator54 = new javax.swing.JToolBar.Separator();
        jSeparator55 = new javax.swing.JToolBar.Separator();
        jLabel51 = new javax.swing.JLabel();
        EditarCliente = new javax.swing.JButton();
        jSeparator56 = new javax.swing.JToolBar.Separator();
        jLabel3 = new javax.swing.JLabel();
        BuscadorCliente = new javax.swing.JTextField();
        jSeparator58 = new javax.swing.JToolBar.Separator();
        EliminarCliente = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        GuardarCliente = new javax.swing.JButton();
        jLabel31 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        RutCliente = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        NombreCliente = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        Dir1Cliente = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        Dir2Cliente = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        Tel1Cliente = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        Tel2Cliente = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        CorreoCliente = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        FechaCliente = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(102, 102, 102));

        jTabbedPane7.setBackground(new java.awt.Color(105, 149, 236));
        jTabbedPane7.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        jTabbedPane7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        jPanel22.setLayout(new java.awt.BorderLayout());

        PanelTrabajadores.setBackground(new java.awt.Color(153, 153, 153));
        PanelTrabajadores.setForeground(new java.awt.Color(0, 0, 0));
        PanelTrabajadores.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);
        PanelTrabajadores.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jPanel20.setLayout(new java.awt.BorderLayout());

        jToolBar25.setBackground(new java.awt.Color(204, 204, 204));
        jToolBar25.setFloatable(false);
        jToolBar25.setForeground(new java.awt.Color(204, 204, 204));
        jToolBar25.setRollover(true);

        RegistrosTrabajadores.setForeground(new java.awt.Color(0, 0, 0));
        RegistrosTrabajadores.setText("jLabel5");
        jToolBar25.add(RegistrosTrabajadores);

        jPanel20.add(jToolBar25, java.awt.BorderLayout.PAGE_START);

        jToolBar26.setBackground(new java.awt.Color(204, 204, 204));
        jToolBar26.setFloatable(false);
        jToolBar26.setRollover(true);

        AgregarTrabajador5.setBackground(new java.awt.Color(153, 153, 153));
        AgregarTrabajador5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/trabajador.png"))); // NOI18N
        AgregarTrabajador5.setFocusable(false);
        AgregarTrabajador5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        AgregarTrabajador5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        AgregarTrabajador5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarTrabajador5ActionPerformed(evt);
            }
        });
        jToolBar26.add(AgregarTrabajador5);
        jToolBar26.add(jSeparator86);
        jToolBar26.add(jSeparator87);
        jToolBar26.add(jLabel86);

        EditarVenta5.setBackground(new java.awt.Color(153, 153, 153));
        EditarVenta5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lapiz.png"))); // NOI18N
        EditarVenta5.setFocusable(false);
        EditarVenta5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        EditarVenta5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        EditarVenta5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarVenta5ActionPerformed(evt);
            }
        });
        jToolBar26.add(EditarVenta5);
        jToolBar26.add(jSeparator88);

        jLabel13.setText("                                                                                                                                                  ");
        jToolBar26.add(jLabel13);
        jToolBar26.add(jSeparator89);

        buscadorT.setBackground(new java.awt.Color(70, 110, 196));
        buscadorT.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        buscadorT.setForeground(new java.awt.Color(0, 0, 0));
        buscadorT.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        buscadorT.setText("Buscador");
        buscadorT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buscadorTMouseClicked(evt);
            }
        });
        buscadorT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                buscadorTKeyTyped(evt);
            }
        });
        jToolBar26.add(buscadorT);
        jToolBar26.add(jSeparator90);

        EliminarVenta5.setBackground(new java.awt.Color(153, 153, 153));
        EliminarVenta5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/basura.png"))); // NOI18N
        EliminarVenta5.setFocusable(false);
        EliminarVenta5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        EliminarVenta5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        EliminarVenta5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarVenta5ActionPerformed(evt);
            }
        });
        jToolBar26.add(EliminarVenta5);

        jPanel20.add(jToolBar26, java.awt.BorderLayout.PAGE_END);

        TablaTrabajadores.setBackground(new java.awt.Color(204, 204, 204));
        TablaTrabajadores.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        TablaTrabajadores.setForeground(new java.awt.Color(0, 0, 0));
        TablaTrabajadores.setModel(new javax.swing.table.DefaultTableModel(
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
        TablaTrabajadores.setMinimumSize(new java.awt.Dimension(60, 100));
        TablaTrabajadores.setName(""); // NOI18N
        TablaTrabajadores.setRowHeight(30);
        TablaTrabajadores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaTrabajadoresMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(TablaTrabajadores);

        jPanel20.add(jScrollPane8, java.awt.BorderLayout.CENTER);

        PanelTrabajadores.addTab("Lista de Trabajadores", jPanel20);

        jPanel21.setBackground(new java.awt.Color(153, 153, 153));

        jLabel87.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel87.setForeground(new java.awt.Color(0, 0, 0));
        jLabel87.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel87.setText("Agregar Trabajador@");

        GuardarTrabajador.setBackground(new java.awt.Color(204, 204, 204));
        GuardarTrabajador.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        GuardarTrabajador.setText("Guardar Datos");
        GuardarTrabajador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarTrabajadorActionPerformed(evt);
            }
        });

        jLabel88.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel88.setForeground(new java.awt.Color(0, 0, 0));
        jLabel88.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel88.setText("Rut:");

        jLabel89.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel89.setForeground(new java.awt.Color(0, 0, 0));
        jLabel89.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel89.setText("Rol:");

        ComboRolTrabajador.setBackground(new java.awt.Color(70, 110, 196));
        ComboRolTrabajador.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        ComboRolTrabajador.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ComboRolTrabajador.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        RutTrabajador.setBackground(new java.awt.Color(70, 110, 196));
        RutTrabajador.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        RutTrabajador.setForeground(new java.awt.Color(0, 0, 0));
        RutTrabajador.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel90.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel90.setForeground(new java.awt.Color(0, 0, 0));
        jLabel90.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel90.setText("Nombre Completo:");

        NombreTrabajador.setBackground(new java.awt.Color(70, 110, 196));
        NombreTrabajador.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        NombreTrabajador.setForeground(new java.awt.Color(0, 0, 0));
        NombreTrabajador.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel91.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel91.setForeground(new java.awt.Color(0, 0, 0));
        jLabel91.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel91.setText("Direccion 2:");

        Dir1Trabajador.setBackground(new java.awt.Color(70, 110, 196));
        Dir1Trabajador.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        Dir1Trabajador.setForeground(new java.awt.Color(0, 0, 0));
        Dir1Trabajador.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel92.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel92.setForeground(new java.awt.Color(0, 0, 0));
        jLabel92.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel92.setText("Direccion 1:");

        Dir2Trabajador.setBackground(new java.awt.Color(70, 110, 196));
        Dir2Trabajador.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        Dir2Trabajador.setForeground(new java.awt.Color(0, 0, 0));
        Dir2Trabajador.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel93.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel93.setForeground(new java.awt.Color(0, 0, 0));
        jLabel93.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel93.setText("Celular;");

        Tel1Trabajo.setBackground(new java.awt.Color(70, 110, 196));
        Tel1Trabajo.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        Tel1Trabajo.setForeground(new java.awt.Color(0, 0, 0));
        Tel1Trabajo.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel94.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel94.setForeground(new java.awt.Color(0, 0, 0));
        jLabel94.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel94.setText("Telefono Fijo:");

        Tel2Trabajador.setBackground(new java.awt.Color(70, 110, 196));
        Tel2Trabajador.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        Tel2Trabajador.setForeground(new java.awt.Color(0, 0, 0));
        Tel2Trabajador.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel95.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel95.setForeground(new java.awt.Color(0, 0, 0));
        jLabel95.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel95.setText("Correo:");

        CorreoTrabajador.setBackground(new java.awt.Color(70, 110, 196));
        CorreoTrabajador.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        CorreoTrabajador.setForeground(new java.awt.Color(0, 0, 0));
        CorreoTrabajador.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel96.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel96.setForeground(new java.awt.Color(0, 0, 0));
        jLabel96.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel96.setText("Inicio de Servicio:");

        FechaTrabajador.setBackground(new java.awt.Color(70, 110, 196));
        FechaTrabajador.setForeground(new java.awt.Color(0, 0, 0));
        try {
            FechaTrabajador.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-##-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        FechaTrabajador.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        FechaTrabajador.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/regreso.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("(YYYY/MM/DD)");

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator9, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel21Layout.createSequentialGroup()
                                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel21Layout.createSequentialGroup()
                                        .addGap(457, 457, 457)
                                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel91)
                                                .addComponent(jLabel94)
                                                .addComponent(jLabel92)
                                                .addComponent(jLabel93, javax.swing.GroupLayout.Alignment.TRAILING))
                                            .addComponent(jLabel88)
                                            .addComponent(jLabel95)
                                            .addComponent(jLabel96)
                                            .addComponent(jLabel89))
                                        .addGap(23, 23, 23))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jLabel90)
                                        .addGap(18, 18, 18)))
                                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(RutTrabajador, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE)
                                        .addComponent(NombreTrabajador, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE)
                                        .addComponent(Dir1Trabajador, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE)
                                        .addComponent(Dir2Trabajador, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE)
                                        .addComponent(Tel1Trabajo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE)
                                        .addComponent(Tel2Trabajador, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE)
                                        .addComponent(CorreoTrabajador, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE)
                                        .addComponent(FechaTrabajador, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addComponent(ComboRolTrabajador, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel21Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jButton2)
                                .addGap(62, 62, 62)
                                .addComponent(GuardarTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 331, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel21Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel87, javax.swing.GroupLayout.DEFAULT_SIZE, 1477, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RutTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel88))
                .addGap(32, 32, 32)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(NombreTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel90))
                .addGap(32, 32, 32)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Dir1Trabajador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel92))
                .addGap(32, 32, 32)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Dir2Trabajador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel91))
                .addGap(32, 32, 32)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel93)
                    .addComponent(Tel1Trabajo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel94)
                    .addComponent(Tel2Trabajador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel95)
                    .addComponent(CorreoTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addGap(4, 4, 4)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel96)
                    .addComponent(FechaTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboRolTrabajador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel89))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 157, Short.MAX_VALUE)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                        .addComponent(GuardarTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(15, 15, 15))))
            .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel21Layout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addComponent(jLabel87, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(841, Short.MAX_VALUE)))
        );

        PanelTrabajadores.addTab("Gestión de Trabajadores", jPanel21);

        jPanel22.add(PanelTrabajadores, java.awt.BorderLayout.CENTER);

        jTabbedPane7.addTab("Trabajadores", jPanel22);

        jPanel1.setLayout(new java.awt.BorderLayout());

        PanelClientes.setBackground(new java.awt.Color(153, 153, 153));
        PanelClientes.setForeground(new java.awt.Color(0, 0, 0));
        PanelClientes.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);
        PanelClientes.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jPanel2.setLayout(new java.awt.BorderLayout());

        jToolBar13.setBackground(new java.awt.Color(204, 204, 204));
        jToolBar13.setFloatable(false);
        jToolBar13.setForeground(new java.awt.Color(204, 204, 204));
        jToolBar13.setRollover(true);

        RegistrosClientes1.setForeground(new java.awt.Color(0, 0, 0));
        RegistrosClientes1.setText("jLabel5");
        jToolBar13.add(RegistrosClientes1);

        jPanel2.add(jToolBar13, java.awt.BorderLayout.PAGE_START);

        TablaClientes1.setBackground(new java.awt.Color(204, 204, 204));
        TablaClientes1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        TablaClientes1.setForeground(new java.awt.Color(0, 0, 0));
        TablaClientes1.setModel(new javax.swing.table.DefaultTableModel(
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
        TablaClientes1.setMinimumSize(new java.awt.Dimension(60, 100));
        TablaClientes1.setName(""); // NOI18N
        TablaClientes1.setRowHeight(30);
        TablaClientes1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaClientes1MouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(TablaClientes1);

        jPanel2.add(jScrollPane10, java.awt.BorderLayout.CENTER);

        jToolBar16.setBackground(new java.awt.Color(204, 204, 204));
        jToolBar16.setFloatable(false);
        jToolBar16.setRollover(true);

        AgregarCliente.setBackground(new java.awt.Color(153, 153, 153));
        AgregarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cliente.png"))); // NOI18N
        AgregarCliente.setFocusable(false);
        AgregarCliente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        AgregarCliente.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        AgregarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarClienteActionPerformed(evt);
            }
        });
        jToolBar16.add(AgregarCliente);
        jToolBar16.add(jSeparator54);
        jToolBar16.add(jSeparator55);
        jToolBar16.add(jLabel51);

        EditarCliente.setBackground(new java.awt.Color(153, 153, 153));
        EditarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lapiz.png"))); // NOI18N
        EditarCliente.setFocusable(false);
        EditarCliente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        EditarCliente.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        EditarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarClienteActionPerformed(evt);
            }
        });
        jToolBar16.add(EditarCliente);
        jToolBar16.add(jSeparator56);

        jLabel3.setText("                                                                                                                                                  ");
        jToolBar16.add(jLabel3);

        BuscadorCliente.setBackground(new java.awt.Color(70, 110, 196));
        BuscadorCliente.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        BuscadorCliente.setForeground(new java.awt.Color(0, 0, 0));
        BuscadorCliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        BuscadorCliente.setText("Buscador");
        BuscadorCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BuscadorClienteMouseClicked(evt);
            }
        });
        BuscadorCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                BuscadorClienteKeyTyped(evt);
            }
        });
        jToolBar16.add(BuscadorCliente);
        jToolBar16.add(jSeparator58);

        EliminarCliente.setBackground(new java.awt.Color(153, 153, 153));
        EliminarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/basura.png"))); // NOI18N
        EliminarCliente.setFocusable(false);
        EliminarCliente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        EliminarCliente.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        EliminarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarClienteActionPerformed(evt);
            }
        });
        jToolBar16.add(EliminarCliente);

        jPanel2.add(jToolBar16, java.awt.BorderLayout.PAGE_END);

        PanelClientes.addTab("Lista de Clientes", jPanel2);

        jPanel11.setBackground(new java.awt.Color(153, 153, 153));

        jLabel46.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(0, 0, 0));
        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel46.setText("Agregar Cliente@");

        GuardarCliente.setBackground(new java.awt.Color(204, 204, 204));
        GuardarCliente.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        GuardarCliente.setText("Guardar Datos");
        GuardarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarClienteActionPerformed(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(0, 0, 0));
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("Rut:");

        RutCliente.setBackground(new java.awt.Color(70, 110, 196));
        RutCliente.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        RutCliente.setForeground(new java.awt.Color(0, 0, 0));
        RutCliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel39.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(0, 0, 0));
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel39.setText("Nombre Completo:");

        NombreCliente.setBackground(new java.awt.Color(70, 110, 196));
        NombreCliente.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        NombreCliente.setForeground(new java.awt.Color(0, 0, 0));
        NombreCliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel40.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(0, 0, 0));
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel40.setText("Direccion 2:");

        Dir1Cliente.setBackground(new java.awt.Color(70, 110, 196));
        Dir1Cliente.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        Dir1Cliente.setForeground(new java.awt.Color(0, 0, 0));
        Dir1Cliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel41.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(0, 0, 0));
        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel41.setText("Direccion 1:");

        Dir2Cliente.setBackground(new java.awt.Color(70, 110, 196));
        Dir2Cliente.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        Dir2Cliente.setForeground(new java.awt.Color(0, 0, 0));
        Dir2Cliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel42.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(0, 0, 0));
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel42.setText("Telefono 1:");

        Tel1Cliente.setBackground(new java.awt.Color(70, 110, 196));
        Tel1Cliente.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        Tel1Cliente.setForeground(new java.awt.Color(0, 0, 0));
        Tel1Cliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel43.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(0, 0, 0));
        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel43.setText("Telefono 2:");

        Tel2Cliente.setBackground(new java.awt.Color(70, 110, 196));
        Tel2Cliente.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        Tel2Cliente.setForeground(new java.awt.Color(0, 0, 0));
        Tel2Cliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel44.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(0, 0, 0));
        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel44.setText("Correo:");

        CorreoCliente.setBackground(new java.awt.Color(70, 110, 196));
        CorreoCliente.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        CorreoCliente.setForeground(new java.awt.Color(0, 0, 0));
        CorreoCliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel47.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(0, 0, 0));
        jLabel47.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel47.setText("Fecha de Nacimiento:");

        FechaCliente.setBackground(new java.awt.Color(70, 110, 196));
        FechaCliente.setForeground(new java.awt.Color(0, 0, 0));
        try {
            FechaCliente.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-##-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        FechaCliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        FechaCliente.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("(YYYY/MM/DD)");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/regreso.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addContainerGap(298, Short.MAX_VALUE)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel31)
                                            .addComponent(jLabel44)
                                            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel42)
                                                .addComponent(jLabel40)
                                                .addComponent(jLabel43)
                                                .addComponent(jLabel41)))
                                        .addGap(23, 23, 23))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel47)
                                            .addComponent(jLabel39))
                                        .addGap(18, 18, 18)))
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(RutCliente, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(NombreCliente, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Dir1Cliente, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Dir2Cliente, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Tel1Cliente, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Tel2Cliente, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CorreoCliente, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(FechaCliente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jButton1)
                                .addGap(83, 83, 83)
                                .addComponent(GuardarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 470, Short.MAX_VALUE))
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel11Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel46, javax.swing.GroupLayout.DEFAULT_SIZE, 1477, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RutCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31))
                .addGap(32, 32, 32)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(NombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel39))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addGap(4, 4, 4)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel47)
                    .addComponent(FechaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Dir1Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel41))
                .addGap(32, 32, 32)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Dir2Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel40))
                .addGap(32, 32, 32)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42)
                    .addComponent(Tel1Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(Tel2Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel44)
                    .addComponent(CorreoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 223, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addComponent(GuardarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(23, 23, 23))))
            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel11Layout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(841, Short.MAX_VALUE)))
        );

        PanelClientes.addTab("Gestión de Clientes", jPanel11);

        jPanel1.add(PanelClientes, java.awt.BorderLayout.CENTER);

        jTabbedPane7.addTab("Clientes", jPanel1);

        getContentPane().add(jTabbedPane7, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //EVENTOS PARA TRABAJADORES
    
    //Boton agregar trabajadores
    private void AgregarTrabajador5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarTrabajador5ActionPerformed
        sswitchT=0;
        PanelTrabajadores.setSelectedIndex(1);
        RutTrabajador.grabFocus();
    }//GEN-LAST:event_AgregarTrabajador5ActionPerformed

    //Boton para Editar trabajadores
    private void EditarVenta5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarVenta5ActionPerformed
        if (filaT>-1) {
            codTrabajador=Integer.parseInt(String.valueOf(TablaTrabajadores.getValueAt(filaT ,0)));
            RutTrabajador.setText(String.valueOf(TablaTrabajadores.getValueAt(filaT, 1)));
            NombreTrabajador.setText(String.valueOf(TablaTrabajadores.getValueAt(filaT, 2)));
            Dir1Trabajador.setText(String.valueOf(TablaTrabajadores.getValueAt(filaT, 3)));
            
            if (!String.valueOf(TablaTrabajadores.getValueAt(filaT, 4)).equals("--------------------------------")) {
                Dir2Trabajador.setText(String.valueOf(TablaTrabajadores.getValueAt(filaT, 4)));
            }
             
            Tel1Trabajo.setText(String.valueOf(TablaTrabajadores.getValueAt(filaT, 5)));
            
            if (!String.valueOf(TablaTrabajadores.getValueAt(filaT, 6)).equals("--------------------------------")) {
                Tel2Trabajador.setText(String.valueOf(TablaTrabajadores.getValueAt(filaT, 6)));
            }
            
            CorreoTrabajador.setText(String.valueOf(TablaTrabajadores.getValueAt(filaT, 7)));
            FechaTrabajador.setText(String.valueOf(TablaTrabajadores.getValueAt(filaT, 8)));
            sswitchT=1;
            PanelTrabajadores.setSelectedIndex(1);
        } else {
           JOptionPane.showMessageDialog(this, "DEBE SELECCIONAR UNA FILA","ADVERTENCIA",JOptionPane.OK_OPTION+JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_EditarVenta5ActionPerformed

    //Boton eliminar trabajador
    private void EliminarVenta5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarVenta5ActionPerformed
        if (filaT>-1) {
            int respuesta=JOptionPane.showConfirmDialog(this, "¿REALMENTE DESEA ELEMINAR EL REGISTRO? NO VOLVERA A RECUPERAR EL REGISTRO...","ADVERTENCIA",JOptionPane.YES_NO_OPTION+JOptionPane.WARNING_MESSAGE);
            if (respuesta==0) {
                crt.EliminarTrabajadores(Integer.parseInt(String.valueOf(TablaTrabajadores.getValueAt(filaT, 0))));
                LlenarTablaTrabajador("");
                JOptionPane.showMessageDialog(this, "TRABAJADOR ELIMINADO", "LA BIBLIOTECA",JOptionPane.OK_OPTION+JOptionPane.INFORMATION_MESSAGE);
                filaT=-1;
            }
        } else {
           JOptionPane.showMessageDialog(this, "DEBE SELECCIONAR UNA FILA","ADVERTENCIA",JOptionPane.OK_OPTION+JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_EliminarVenta5ActionPerformed

    //tomar codigo de trabajador al hacer click en una fila
    private void TablaTrabajadoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaTrabajadoresMouseClicked
        filaT=TablaTrabajadores.rowAtPoint(evt.getPoint());
    }//GEN-LAST:event_TablaTrabajadoresMouseClicked

    //vaciar buscador al hacer click
    private void buscadorTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buscadorTMouseClicked
        buscadorT.setText("");
    }//GEN-LAST:event_buscadorTMouseClicked

    //buscar por teclado
    private void buscadorTKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscadorTKeyTyped
        LlenarTablaTrabajador(buscadorT.getText());
    }//GEN-LAST:event_buscadorTKeyTyped

    //boton para guardar datos de trabajadores
    private void GuardarTrabajadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarTrabajadorActionPerformed
        RolTrabajador rol=(RolTrabajador)ComboRolTrabajador.getSelectedItem();
        if (RutTrabajador.getText().equals("") || NombreTrabajador.getText().equals("") || Dir1Trabajador.getText().equals("")  || Tel1Trabajo.getText().equals("")  
            ||   CorreoTrabajador.getText().equals("") || FechaTrabajador.getText().equals("") ){
            JOptionPane.showMessageDialog(this, "DEBE INGRESAR TODOS LOS DATOS!!!", "La biblioteca",JOptionPane.OK_OPTION+JOptionPane.INFORMATION_MESSAGE);
        }else{
            if (sswitchT==0) crt.InsertarTrabajadores(RutTrabajador.getText(), NombreTrabajador.getText(), Dir1Trabajador.getText(), 
                    Dir2Trabajador.getText(), Tel1Trabajo.getText(), Tel2Trabajador.getText(), CorreoTrabajador.getText(), Date.valueOf(FechaTrabajador.getText()), rol.getCod_rol());
            
            else crt.EditarTrabajadores(codTrabajador, RutTrabajador.getText(), NombreTrabajador.getText(), Dir1Trabajador.getText(), 
                    Dir2Trabajador.getText(), Tel1Trabajo.getText(), Tel2Trabajador.getText(), CorreoTrabajador.getText(), Date.valueOf(FechaTrabajador.getText()), rol.getCod_rol());
                
        }   
        RutTrabajador.setText("");
        NombreTrabajador.setText("");
        Dir1Trabajador.setText("");
        Dir2Trabajador.setText("");
        Tel1Trabajo.setText("");
        Tel2Trabajador.setText("");
        CorreoTrabajador.setText("");
        FechaTrabajador.setText("");
        LlenarTablaTrabajador("");
        PanelTrabajadores.setSelectedIndex(0); 
        JOptionPane.showMessageDialog(this, "OPERACION REALIZADA", "LA BIBLIOTECA",JOptionPane.OK_OPTION+JOptionPane.INFORMATION_MESSAGE);
        sswitchT=0;
    }//GEN-LAST:event_GuardarTrabajadorActionPerformed

    //boton para volver al panel de la lista de trabajadores
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        PanelTrabajadores.setSelectedIndex(0);
    }//GEN-LAST:event_jButton2ActionPerformed

    
    //EVENTOS DE GESTION DE CLIENTES
    
    //boton para agregar Clientes
    private void AgregarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarClienteActionPerformed
        sswitchC=0;
        PanelClientes.setSelectedIndex(1);
        RutCliente.grabFocus();
    }//GEN-LAST:event_AgregarClienteActionPerformed

    //boton para volver a la lista de Clientes
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        PanelClientes.setSelectedIndex(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    //boton para editar los datos de clientes
    private void EditarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarClienteActionPerformed
        if (filaC>-1) {
            codCliente=Integer.parseInt(String.valueOf(TablaClientes1.getValueAt(filaC ,0)));
            RutCliente.setText(String.valueOf(TablaClientes1.getValueAt(filaC, 1)));
            NombreCliente.setText(String.valueOf(TablaClientes1.getValueAt(filaC, 2)));
            FechaCliente.setText(String.valueOf(TablaClientes1.getValueAt(filaC, 3)));
            Dir1Cliente.setText(String.valueOf(TablaClientes1.getValueAt(filaC, 4)));
            if (!String.valueOf(TablaClientes1.getValueAt(filaC, 5)).equals("------------------------------------")) {
                Dir2Cliente.setText(String.valueOf(TablaClientes1.getValueAt(filaC, 5)));
            }
            Tel1Cliente.setText(String.valueOf(TablaClientes1.getValueAt(filaC, 6)));
            if (!String.valueOf(TablaClientes1.getValueAt(filaC, 7)).equals("------------------------------------")) {
                Tel2Cliente.setText(String.valueOf(TablaClientes1.getValueAt(filaC, 7)));
            }
            CorreoCliente.setText(String.valueOf(TablaClientes1.getValueAt(filaC, 8)));
            sswitchC=1;
            PanelClientes.setSelectedIndex(1);
        } else {
           JOptionPane.showMessageDialog(this, "DEBE SELECCIONAR UNA FILA","ADVERTENCIA",JOptionPane.OK_OPTION+JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_EditarClienteActionPerformed

    //boton para eliminar Cliente de la base de datos
    private void EliminarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarClienteActionPerformed
        if (filaC>-1) {
            int respuesta=JOptionPane.showConfirmDialog(this, "¿REALMENTE DESEA ELEMINAR EL REGISTRO? NO VOLVERA A RECUPERAR EL REGISTRO...","ADVERTENCIA",JOptionPane.YES_NO_OPTION+JOptionPane.WARNING_MESSAGE);
            if (respuesta==0) {
                crc.EliminarClientes(Integer.parseInt(String.valueOf(TablaClientes1.getValueAt(filaC, 0))));
                LlenarTablaCliente("");
                JOptionPane.showMessageDialog(this, "CLIENTE ELIMINADO", "LA BIBLIOTECA",JOptionPane.OK_OPTION+JOptionPane.INFORMATION_MESSAGE);
                filaC=-1;
            }
        } else {
           JOptionPane.showMessageDialog(this, "DEBE SELECCIONAR UNA FILA","ADVERTENCIA",JOptionPane.OK_OPTION+JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_EliminarClienteActionPerformed

    //boton para guardar datos de clientes
    private void GuardarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarClienteActionPerformed
        if (RutCliente.getText().equals("") || NombreCliente.getText().equals("") || FechaCliente.getText().equals("")  || Dir1Cliente.getText().equals("")  
            ||   Tel1Cliente.getText().equals("") || CorreoCliente.getText().equals("") ){
            JOptionPane.showMessageDialog(this, "DEBE INGRESAR TODOS LOS DATOS!!!", "La biblioteca",JOptionPane.OK_OPTION+JOptionPane.INFORMATION_MESSAGE);
        }else{
            if (sswitchC==0) crc.InsertarClientes(RutCliente.getText(), NombreCliente.getText(), Dir1Cliente.getText(), 
                    Dir2Cliente.getText(), Tel1Cliente.getText(), Tel2Cliente.getText(),CorreoCliente.getText(), Date.valueOf(FechaCliente.getText()));
            
            else crc.EditarClientes(codCliente, RutCliente.getText(), NombreCliente.getText(), Dir1Cliente.getText(), 
                    Dir2Cliente.getText(), Tel1Cliente.getText(), Tel2Cliente.getText(),CorreoCliente.getText(), Date.valueOf(FechaCliente.getText()));
                
        }   
        RutCliente.setText("");
        NombreCliente.setText("");
        Dir1Cliente.setText("");
        Dir2Cliente.setText("");
        Tel1Cliente.setText("");
        Tel2Cliente.setText("");
        CorreoCliente.setText("");
        FechaCliente.setText("");
        LlenarTablaCliente("");
        PanelClientes.setSelectedIndex(0); 
        JOptionPane.showMessageDialog(this, "OPERACION REALIZADA", "LA BIBLIOTECA",JOptionPane.OK_OPTION+JOptionPane.INFORMATION_MESSAGE);
        sswitchC=0;
    }//GEN-LAST:event_GuardarClienteActionPerformed

    //tomar el codigo desde una fila en la tabla de Clientes
    private void TablaClientes1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaClientes1MouseClicked
        filaC=TablaClientes1.rowAtPoint(evt.getPoint());
    }//GEN-LAST:event_TablaClientes1MouseClicked

    private void BuscadorClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BuscadorClienteMouseClicked
        BuscadorCliente.setText("");
    }//GEN-LAST:event_BuscadorClienteMouseClicked

    private void BuscadorClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BuscadorClienteKeyTyped
        LlenarTablaCliente(BuscadorCliente.getText());
    }//GEN-LAST:event_BuscadorClienteKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AgregarCliente;
    private javax.swing.JButton AgregarTrabajador5;
    private javax.swing.JTextField BuscadorCliente;
    private javax.swing.JComboBox ComboRolTrabajador;
    private javax.swing.JTextField CorreoCliente;
    private javax.swing.JTextField CorreoTrabajador;
    private javax.swing.JTextField Dir1Cliente;
    private javax.swing.JTextField Dir1Trabajador;
    private javax.swing.JTextField Dir2Cliente;
    private javax.swing.JTextField Dir2Trabajador;
    private javax.swing.JButton EditarCliente;
    private javax.swing.JButton EditarVenta5;
    private javax.swing.JButton EliminarCliente;
    private javax.swing.JButton EliminarVenta5;
    private javax.swing.JFormattedTextField FechaCliente;
    private javax.swing.JFormattedTextField FechaTrabajador;
    private javax.swing.JButton GuardarCliente;
    private javax.swing.JButton GuardarTrabajador;
    private javax.swing.JTextField NombreCliente;
    private javax.swing.JTextField NombreTrabajador;
    private javax.swing.JTabbedPane PanelClientes;
    private javax.swing.JTabbedPane PanelTrabajadores;
    private javax.swing.JLabel RegistrosClientes1;
    private javax.swing.JLabel RegistrosTrabajadores;
    private javax.swing.JTextField RutCliente;
    private javax.swing.JTextField RutTrabajador;
    private javax.swing.JTable TablaClientes1;
    private javax.swing.JTable TablaTrabajadores;
    private javax.swing.JTextField Tel1Cliente;
    private javax.swing.JTextField Tel1Trabajo;
    private javax.swing.JTextField Tel2Cliente;
    private javax.swing.JTextField Tel2Trabajador;
    private javax.swing.JTextField buscadorT;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JToolBar.Separator jSeparator54;
    private javax.swing.JToolBar.Separator jSeparator55;
    private javax.swing.JToolBar.Separator jSeparator56;
    private javax.swing.JToolBar.Separator jSeparator58;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JToolBar.Separator jSeparator86;
    private javax.swing.JToolBar.Separator jSeparator87;
    private javax.swing.JToolBar.Separator jSeparator88;
    private javax.swing.JToolBar.Separator jSeparator89;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JToolBar.Separator jSeparator90;
    private javax.swing.JTabbedPane jTabbedPane7;
    private javax.swing.JToolBar jToolBar13;
    private javax.swing.JToolBar jToolBar16;
    private javax.swing.JToolBar jToolBar25;
    private javax.swing.JToolBar jToolBar26;
    // End of variables declaration//GEN-END:variables
}
