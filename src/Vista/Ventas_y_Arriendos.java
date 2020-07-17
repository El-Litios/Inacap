/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vista;

import Controlador.Control_Arriendos;
import Controlador.Control_Morosidad;
import Controlador.Control_Opcion;
import Controlador.Control_Ventas;
import Modelo.BoletaOfactura;
import Modelo.Cliente;
import Modelo.DetalleArriendo;
import Modelo.DetalleVentas;
import Modelo.Libros;
import Modelo.Morosidad;
import Modelo.Opcion;
import Modelo.Trabajador;
import java.sql.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mark-
 */
public class Ventas_y_Arriendos extends javax.swing.JInternalFrame {
    //Controladores
    Control_Arriendos cra=new Control_Arriendos();
    Control_Morosidad crm=new Control_Morosidad();
    Control_Opcion cro=new Control_Opcion();
    Control_Ventas crv=new Control_Ventas();
    //filas
    private int filaArriedo=-1;//valor fila de tabla de arriendos
    private int filaMorosos=-1;//valor fila de tabla de Morosidades
    private int filaVentas=-1;//valor fila de tabla de Ventas
    //codigos
    int codArriendo;
    int codMorosidad;
    int codVenta;
    //tablas
    DefaultTableModel tablaArriendo=new DefaultTableModel();//tabla de Arriendos.
    DefaultTableModel tablaMorosidad=new DefaultTableModel();//tabla de Morosidades.
    DefaultTableModel tablaVenta=new DefaultTableModel();
    //switchs
    private int sswitchArriendo;//switch de Arriendos
    private int sswitchVenta;//switch de Ventas
    
    //METODOS LLENAR TABLAS
    
    //llenar tabla de arriendos
    public void LlenarTablaArriendo(String Dato){
    tablaArriendo.setColumnCount(0);
        tablaArriendo.addColumn("Codigo");
        tablaArriendo.addColumn("Fecha de Entrega");
        tablaArriendo.addColumn("Fecha de Devolucion");
        tablaArriendo.addColumn("ISBN/Libro/Pág");
        tablaArriendo.addColumn("Folio/Precio Boleta");
        tablaArriendo.addColumn("Fecha/Hora Boleta");
        tablaArriendo.addColumn("Rut/Cliente");
        tablaArriendo.addColumn("Rut/Trabajador");
        List<DetalleArriendo> lista=cra.ListaArriendo(Dato);
        tablaArriendo.setNumRows(lista.size());
        RegistrosArriendo.setText("CANTIDAD DE REGISTROS= "+lista.size());
        for (int i = 0; i < lista.size(); i++) {
            tablaArriendo.setValueAt(lista.get(i).getCod_detArriendo(), i, 0);
            tablaArriendo.setValueAt(lista.get(i).getFecha_entrega(), i, 1);
            tablaArriendo.setValueAt(lista.get(i).getFecha_estimada(), i, 2);
            tablaArriendo.setValueAt(lista.get(i).getIsbn_libro()+" / "+lista.get(i).getTitulo_libro()+" / "+lista.get(i).getPag_libro(), i, 3);
            tablaArriendo.setValueAt(lista.get(i).getFolio()+" / $"+lista.get(i).getPrecio_iva(), i, 4);
            tablaArriendo.setValueAt(lista.get(i).getFecha()+" / "+lista.get(i).getHora(), i, 5);
            tablaArriendo.setValueAt(lista.get(i).getRut_cliente()+" / "+lista.get(i).getNom_cliente(), i, 6);
            tablaArriendo.setValueAt(lista.get(i).getRut_traba()+" / "+lista.get(i).getNom_traba(), i, 7);
 
        }
        TablaArriendo.setModel(tablaArriendo);//el jtable recibe lo que es la tabla. con los nombres de sus columans.
        
        //poner invisible la columna de codigos, para una mejor visualizacion
        TablaArriendo.getColumnModel().getColumn(0).setMaxWidth(0);
        TablaArriendo.getColumnModel().getColumn(0).setMinWidth(0);
        TablaArriendo.getColumnModel().getColumn(0).setPreferredWidth(0);
    }
    
    //llenar tabla de Morosidades
    public void LlenarTablaMorosidades(String Dato){
    tablaMorosidad.setColumnCount(0);
        tablaMorosidad.addColumn("Codigo");
        tablaMorosidad.addColumn("Dias/Monto Morosidad");
        tablaMorosidad.addColumn("Fecha de Arriendo/Fecha de Devolución");
        tablaMorosidad.addColumn("Rut/Trabajador");
        tablaMorosidad.addColumn("Rut/Cliente");
        tablaMorosidad.addColumn("Folio/Precio Boleta");
        tablaMorosidad.addColumn("ISBN/Libro");
        tablaMorosidad.addColumn("Estado");
        List<Morosidad> lista=crm.ListaMorosidad(Dato);
        tablaMorosidad.setNumRows(lista.size());
        RegistrosMorosos.setText("CANTIDAD DE REGISTROS= "+lista.size());
        for (int i = 0; i < lista.size(); i++) {
            tablaMorosidad.setValueAt(lista.get(i).getCod_morosidad(), i, 0);
            tablaMorosidad.setValueAt(lista.get(i).getDias_morosidad()+" / $"+lista.get(i).getMonto_morosidad(), i, 1);
            tablaMorosidad.setValueAt(lista.get(i).getFecha_entrega()+" / "+lista.get(i).getFecha_estimada(), i, 2);
            tablaMorosidad.setValueAt(lista.get(i).getRut_traba()+" / "+lista.get(i).getNom_traba(), i, 3);
            tablaMorosidad.setValueAt(lista.get(i).getRut_cliente()+" / "+lista.get(i).getNom_cliente(), i, 4);
            tablaMorosidad.setValueAt(lista.get(i).getFolio()+" / "+lista.get(i).getPrecio_iva(), i, 5);
            tablaMorosidad.setValueAt(lista.get(i).getIsbn_libro()+" / "+lista.get(i).getTitulo_libro(), i, 6);
            tablaMorosidad.setValueAt(lista.get(i).getNom_estadoM(), i, 7);
        }
        TablaMorosidad.setModel(tablaMorosidad);//el jtable recibe lo que es la tabla. con los nombres de sus columans.
        
        //poner invisible la columna de codigos, para una mejor visualizacion
        TablaMorosidad.getColumnModel().getColumn(0).setMaxWidth(0);
        TablaMorosidad.getColumnModel().getColumn(0).setMinWidth(0);
        TablaMorosidad.getColumnModel().getColumn(0).setPreferredWidth(0);
    }
    
    //llenar tabla de Ventas
    public void LlenarTablaVentas(String Dato){
    tablaVenta.setColumnCount(0);
        tablaVenta.addColumn("Codigo");
        tablaVenta.addColumn("Rut/Trabajador");
        tablaVenta.addColumn("Rut/Cliente");
        tablaVenta.addColumn("ISBN/Libro/Pág");
        tablaVenta.addColumn("Folio/Precio B o F");
        List<DetalleVentas> lista=crv.ListaVenta(Dato);
        tablaVenta.setNumRows(lista.size());
        RegistrosVentas.setText("CANTIDAD DE VENTAS= "+lista.size());
        for (int i = 0; i < lista.size(); i++) {
            tablaVenta.setValueAt(lista.get(i).getCod_detventa(), i, 0);
            tablaVenta.setValueAt(lista.get(i).getRut_traba()+" / "+lista.get(i).getNom_traba(), i, 1);
            tablaVenta.setValueAt(lista.get(i).getRut_cliente()+" / "+lista.get(i).getNom_cliente(), i, 2);
            tablaVenta.setValueAt(lista.get(i).getIsbn_libro()+" / "+lista.get(i).getTitulo_libro()+" / "+lista.get(i).getPag_libro(), i, 3);
            tablaVenta.setValueAt(lista.get(i).getFolio()+" / $"+lista.get(i).getPrecio_iva(), i, 4);
        }
        TablaVentas.setModel(tablaVenta);//el jtable recibe lo que es la tabla. con los nombres de sus columans.
        
        //poner invisible la columna de codigos, para una mejor visualizacion
        TablaVentas.getColumnModel().getColumn(0).setMaxWidth(0);
        TablaVentas.getColumnModel().getColumn(0).setMinWidth(0);
        TablaVentas.getColumnModel().getColumn(0).setPreferredWidth(0);
    }
    
    //METODOS PARA COMBOBOXS
    
    //combobox Trabajadores
    private void ComboBoxTrabajador(){
       DefaultComboBoxModel combo = new DefaultComboBoxModel();
        Control_Opcion cro=new Control_Opcion();
        List<Trabajador> lista=cro.ComboBoxTrabajador();
        for(Trabajador T:lista){
            T = new Trabajador(T.getCod_traba(), T.getNom_traba());
            combo.addElement(T);
        }
        ComboTrabajador.setModel(combo);
        ComboTrabajador1.setModel(combo);
    }
    
    //combobox Clientes
    private void ComboBoxClientes(){
       DefaultComboBoxModel combo = new DefaultComboBoxModel();
        Control_Opcion cro=new Control_Opcion();
        List<Cliente> lista=cro.ComboBoxCliente();
        for(Cliente C:lista){
            C = new Cliente(C.getCod_cliente(), C.getNom_cliente());
            combo.addElement(C);
        }
        ComboCliente.setModel(combo);
        ComboCliente1.setModel(combo);
    }
    
    //combobox Boleta o Factura
    public void ComboBoxBoF(){
       DefaultComboBoxModel combo = new DefaultComboBoxModel();
        Control_Opcion cro=new Control_Opcion();
        List<BoletaOfactura> lista=cro.ComboBoxBoF();
        for(BoletaOfactura BF:lista){
            BF = new BoletaOfactura(BF.getCod_bof(), BF.getFolio());
            combo.addElement(BF);
        }
        ComboBoF.setModel(combo);
        ComboBoF1.setModel(combo);
    }
    
    //combobox Opcion
    private void ComboBoxOPC(){
       DefaultComboBoxModel combo = new DefaultComboBoxModel();
        Control_Arriendos cra=new Control_Arriendos();
        List<Opcion> lista=cra.ComboBoxOpc();
        for(Opcion O:lista){
            O = new Opcion(O.getCod_opcion(), O.getFolio());
            combo.addElement(O);
        }
        ComboOpcArriendo.setModel(combo);
    }
    
    //combobox Libros
    private void ComboBoxLibros(){
       DefaultComboBoxModel combo = new DefaultComboBoxModel();
        Control_Arriendos cra=new Control_Arriendos();
        List<Libros> lista=cra.ComboBoxLibros();
        for(Libros L:lista){
            L = new Libros(L.getCod_libro(), L.getTitulo_libro());
            combo.addElement(L);
        }
        ComboLibroArriendo.setModel(combo);
    }
    
     //combobox Libros para Ventas
    private void ComboBoxLibrosVentas(){
       DefaultComboBoxModel combo = new DefaultComboBoxModel();
        Control_Ventas crv=new Control_Ventas();
        List<Libros> lista=crv.ComboBoxLibros();
        for(Libros L:lista){
            L = new Libros(L.getCod_libro(), L.getTitulo_libro());
            combo.addElement(L);
        }
        ComboLibroVenta.setModel(combo);
    }
    
    //combobox Opcion de Ventas
    private void ComboBoxOpcVenta(){
       DefaultComboBoxModel combo = new DefaultComboBoxModel();
        Control_Ventas crv=new Control_Ventas();
        List<Opcion> lista=crv.ComboBoxOpc();
        for(Opcion O:lista){
            O = new Opcion(O.getCod_opcion(), O.getFolio());
            combo.addElement(O);
        }
        ComboOpcVenta.setModel(combo);
    }
    
    public Ventas_y_Arriendos() {
        initComponents();
        //Llenar tablas
        LlenarTablaArriendo("");//tabla de arriendos
        LlenarTablaMorosidades("");//tabla de morosidad
        LlenarTablaVentas("");//tabla de Ventas
        
        //Combobox
        ComboBoxTrabajador();//llenar combobox de trabajadores para opc de Arriendos
        ComboBoxClientes();//llenar combobox de clientes para opc de Arriendos
        ComboBoxBoF();//llenar combobox de Boletas o Facturas para opc de Arriendos
        ComboBoxOPC();//llenar combobox de Opcion para Arriendos
        ComboBoxLibros();//llenar combobox de Libros para Arriendos
        ComboBoxLibrosVentas();
        ComboBoxOpcVenta();
        
        //Tool Lips
        ListaLibros.setToolTipText("Lista de Libros en Arriendo");
        ActualizarLibros.setToolTipText("Actualizar ComboBox de Libros en Stock");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        PanelVentas = new javax.swing.JTabbedPane();
        jPanel7 = new javax.swing.JPanel();
        jToolBar14 = new javax.swing.JToolBar();
        RegistrosVentas = new javax.swing.JLabel();
        jToolBar17 = new javax.swing.JToolBar();
        AgregarVenta = new javax.swing.JButton();
        jSeparator61 = new javax.swing.JToolBar.Separator();
        jSeparator62 = new javax.swing.JToolBar.Separator();
        jLabel52 = new javax.swing.JLabel();
        EditarVenta = new javax.swing.JButton();
        jSeparator63 = new javax.swing.JToolBar.Separator();
        jLabel1 = new javax.swing.JLabel();
        jSeparator64 = new javax.swing.JToolBar.Separator();
        buscadorVentas = new javax.swing.JTextField();
        jSeparator65 = new javax.swing.JToolBar.Separator();
        EliminarVenta = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        TablaVentas = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        ComboTrabajador1 = new javax.swing.JComboBox();
        jLabel19 = new javax.swing.JLabel();
        ComboCliente1 = new javax.swing.JComboBox();
        jLabel20 = new javax.swing.JLabel();
        ComboBoF1 = new javax.swing.JComboBox();
        jLabel44 = new javax.swing.JLabel();
        GuardarAriendo1 = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        ComboOpcVenta = new javax.swing.JComboBox();
        jLabel22 = new javax.swing.JLabel();
        ComboLibroVenta = new javax.swing.JComboBox();
        GuardarOpcion1 = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        ActualizarBoF1 = new javax.swing.JButton();
        ListaBoF1 = new javax.swing.JButton();
        ActualizarCliente = new javax.swing.JButton();
        ListaCliente = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        PanelArriendos = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jToolBar12 = new javax.swing.JToolBar();
        RegistrosArriendo = new javax.swing.JLabel();
        jToolBar15 = new javax.swing.JToolBar();
        AgregarArriendos = new javax.swing.JButton();
        jSeparator51 = new javax.swing.JToolBar.Separator();
        jSeparator52 = new javax.swing.JToolBar.Separator();
        jLabel50 = new javax.swing.JLabel();
        AgregarMorosidad = new javax.swing.JButton();
        jSeparator53 = new javax.swing.JToolBar.Separator();
        jSeparator55 = new javax.swing.JToolBar.Separator();
        BuscadorArriendos = new javax.swing.JTextField();
        jSeparator57 = new javax.swing.JToolBar.Separator();
        EliminarArriendos = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaArriendo = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        ComboTrabajador = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        ComboCliente = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        ComboBoF = new javax.swing.JComboBox();
        jLabel42 = new javax.swing.JLabel();
        GuardarAriendo = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        ComboOpcArriendo = new javax.swing.JComboBox();
        jLabel14 = new javax.swing.JLabel();
        ComboLibroArriendo = new javax.swing.JComboBox();
        GuardarOpcion = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel15 = new javax.swing.JLabel();
        FechaEntregaArriendo = new javax.swing.JFormattedTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        FechaDevolucionArriendo = new javax.swing.JFormattedTextField();
        ActualizarBoF = new javax.swing.JButton();
        ListaLibros = new javax.swing.JButton();
        ActualizarLibros = new javax.swing.JButton();
        ListaBoF = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jToolBar13 = new javax.swing.JToolBar();
        RegistrosMorosos = new javax.swing.JLabel();
        jToolBar16 = new javax.swing.JToolBar();
        AgragarMorosos = new javax.swing.JButton();
        jSeparator54 = new javax.swing.JToolBar.Separator();
        jSeparator56 = new javax.swing.JToolBar.Separator();
        jLabel51 = new javax.swing.JLabel();
        MorosidadPagada = new javax.swing.JButton();
        jSeparator58 = new javax.swing.JToolBar.Separator();
        jSeparator59 = new javax.swing.JToolBar.Separator();
        BuscadorMorosidad = new javax.swing.JTextField();
        jSeparator60 = new javax.swing.JToolBar.Separator();
        EliminarMorosidad = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaMorosidad = new javax.swing.JTable();

        setBackground(new java.awt.Color(102, 102, 102));
        setBorder(null);

        jTabbedPane2.setBackground(new java.awt.Color(105, 149, 236));
        jTabbedPane2.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        jTabbedPane2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        jPanel2.setLayout(new java.awt.BorderLayout());

        PanelVentas.setBackground(new java.awt.Color(153, 153, 153));
        PanelVentas.setForeground(new java.awt.Color(0, 0, 0));
        PanelVentas.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);
        PanelVentas.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jPanel7.setLayout(new java.awt.BorderLayout());

        jToolBar14.setBackground(new java.awt.Color(204, 204, 204));
        jToolBar14.setFloatable(false);
        jToolBar14.setForeground(new java.awt.Color(204, 204, 204));
        jToolBar14.setRollover(true);

        RegistrosVentas.setForeground(new java.awt.Color(0, 0, 0));
        RegistrosVentas.setText("jLabel5");
        jToolBar14.add(RegistrosVentas);

        jPanel7.add(jToolBar14, java.awt.BorderLayout.PAGE_START);

        jToolBar17.setBackground(new java.awt.Color(204, 204, 204));
        jToolBar17.setFloatable(false);
        jToolBar17.setRollover(true);

        AgregarVenta.setBackground(new java.awt.Color(153, 153, 153));
        AgregarVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/mas.png"))); // NOI18N
        AgregarVenta.setFocusable(false);
        AgregarVenta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        AgregarVenta.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        AgregarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarVentaActionPerformed(evt);
            }
        });
        jToolBar17.add(AgregarVenta);
        jToolBar17.add(jSeparator61);
        jToolBar17.add(jSeparator62);
        jToolBar17.add(jLabel52);

        EditarVenta.setBackground(new java.awt.Color(153, 153, 153));
        EditarVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lapiz.png"))); // NOI18N
        EditarVenta.setFocusable(false);
        EditarVenta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        EditarVenta.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        EditarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarVentaActionPerformed(evt);
            }
        });
        jToolBar17.add(EditarVenta);
        jToolBar17.add(jSeparator63);

        jLabel1.setText("                                                                                                                                                  ");
        jToolBar17.add(jLabel1);
        jToolBar17.add(jSeparator64);

        buscadorVentas.setBackground(new java.awt.Color(70, 110, 196));
        buscadorVentas.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        buscadorVentas.setText("Buscador");
        buscadorVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buscadorVentasMouseClicked(evt);
            }
        });
        buscadorVentas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                buscadorVentasKeyTyped(evt);
            }
        });
        jToolBar17.add(buscadorVentas);
        jToolBar17.add(jSeparator65);

        EliminarVenta.setBackground(new java.awt.Color(153, 153, 153));
        EliminarVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/basura.png"))); // NOI18N
        EliminarVenta.setFocusable(false);
        EliminarVenta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        EliminarVenta.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        EliminarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarVentaActionPerformed(evt);
            }
        });
        jToolBar17.add(EliminarVenta);

        jPanel7.add(jToolBar17, java.awt.BorderLayout.PAGE_END);

        TablaVentas.setBackground(new java.awt.Color(204, 204, 204));
        TablaVentas.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        TablaVentas.setForeground(new java.awt.Color(0, 0, 0));
        TablaVentas.setModel(new javax.swing.table.DefaultTableModel(
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
        TablaVentas.setMinimumSize(new java.awt.Dimension(60, 100));
        TablaVentas.setName(""); // NOI18N
        TablaVentas.setRowHeight(30);
        TablaVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaVentasMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(TablaVentas);

        jPanel7.add(jScrollPane3, java.awt.BorderLayout.CENTER);

        PanelVentas.addTab("Ventas", jPanel7);

        jPanel5.setBackground(new java.awt.Color(153, 153, 153));

        jLabel43.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(0, 0, 0));
        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel43.setText("Agregar Ventas");

        jLabel18.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setText("Cliente:");

        ComboTrabajador1.setBackground(new java.awt.Color(70, 110, 196));
        ComboTrabajador1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        ComboTrabajador1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ComboTrabajador1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel19.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 0));
        jLabel19.setText("Trabajador:");

        ComboCliente1.setBackground(new java.awt.Color(70, 110, 196));
        ComboCliente1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        ComboCliente1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ComboCliente1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel20.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 0, 0));
        jLabel20.setText("Boleta/Factura:");

        ComboBoF1.setBackground(new java.awt.Color(70, 110, 196));
        ComboBoF1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        ComboBoF1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ComboBoF1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel44.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(0, 0, 0));
        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel44.setText("Agregar Opciones");

        GuardarAriendo1.setBackground(new java.awt.Color(204, 204, 204));
        GuardarAriendo1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        GuardarAriendo1.setText("Guardar Venta");
        GuardarAriendo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarAriendo1ActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 0, 0));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Folio/Trabajador/Cliente:");

        ComboOpcVenta.setBackground(new java.awt.Color(70, 110, 196));
        ComboOpcVenta.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        ComboOpcVenta.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ComboOpcVenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel22.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 0, 0));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("ISBN/Libro:");

        ComboLibroVenta.setBackground(new java.awt.Color(70, 110, 196));
        ComboLibroVenta.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        ComboLibroVenta.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ComboLibroVenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        GuardarOpcion1.setBackground(new java.awt.Color(204, 204, 204));
        GuardarOpcion1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        GuardarOpcion1.setText("Guardar Opcion");
        GuardarOpcion1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarOpcion1ActionPerformed(evt);
            }
        });

        ActualizarBoF1.setBackground(new java.awt.Color(153, 153, 153));
        ActualizarBoF1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/actualizar.png"))); // NOI18N
        ActualizarBoF1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualizarBoF1ActionPerformed(evt);
            }
        });

        ListaBoF1.setBackground(new java.awt.Color(153, 153, 153));
        ListaBoF1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/listado1.png"))); // NOI18N
        ListaBoF1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListaBoF1ActionPerformed(evt);
            }
        });

        ActualizarCliente.setBackground(new java.awt.Color(153, 153, 153));
        ActualizarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/actualizar.png"))); // NOI18N
        ActualizarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualizarClienteActionPerformed(evt);
            }
        });

        ListaCliente.setBackground(new java.awt.Color(153, 153, 153));
        ListaCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/listado1.png"))); // NOI18N
        ListaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListaClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator4)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(GuardarAriendo1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(107, 107, 107)
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ComboBoF1, javax.swing.GroupLayout.PREFERRED_SIZE, 882, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(ActualizarBoF1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ListaBoF1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(128, 128, 128)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel19))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ComboTrabajador1, javax.swing.GroupLayout.PREFERRED_SIZE, 883, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(ComboCliente1, javax.swing.GroupLayout.PREFERRED_SIZE, 882, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(ActualizarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ListaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(ComboOpcVenta, javax.swing.GroupLayout.Alignment.TRAILING, 0, 882, Short.MAX_VALUE)
                                    .addComponent(ComboLibroVenta, javax.swing.GroupLayout.Alignment.TRAILING, 0, 882, Short.MAX_VALUE))))
                        .addGap(0, 308, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel44, javax.swing.GroupLayout.DEFAULT_SIZE, 1487, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(93, 93, 93)
                    .addComponent(GuardarOpcion1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(1224, Short.MAX_VALUE)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboTrabajador1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel18)
                                .addComponent(ComboCliente1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(ListaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(ComboBoF1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel20))
                                    .addComponent(ListaBoF1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addGap(166, 166, 166)
                                .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(ActualizarBoF1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ComboOpcVenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21))
                        .addGap(89, 89, 89)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ComboLibroVenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
                        .addComponent(GuardarAriendo1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(ActualizarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(808, Short.MAX_VALUE)))
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(330, 330, 330)
                    .addComponent(GuardarOpcion1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(483, Short.MAX_VALUE)))
        );

        PanelVentas.addTab("Gestión de Ventas", jPanel5);

        jPanel2.add(PanelVentas, java.awt.BorderLayout.CENTER);

        jTabbedPane2.addTab("Ventas", jPanel2);

        jPanel3.setLayout(new java.awt.BorderLayout());

        PanelArriendos.setBackground(new java.awt.Color(153, 153, 153));
        PanelArriendos.setForeground(new java.awt.Color(0, 0, 0));
        PanelArriendos.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);
        PanelArriendos.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jPanel6.setLayout(new java.awt.BorderLayout());

        jToolBar12.setBackground(new java.awt.Color(204, 204, 204));
        jToolBar12.setFloatable(false);
        jToolBar12.setForeground(new java.awt.Color(204, 204, 204));
        jToolBar12.setRollover(true);

        RegistrosArriendo.setForeground(new java.awt.Color(0, 0, 0));
        RegistrosArriendo.setText("jLabel5");
        jToolBar12.add(RegistrosArriendo);

        jPanel6.add(jToolBar12, java.awt.BorderLayout.PAGE_START);

        jToolBar15.setBackground(new java.awt.Color(204, 204, 204));
        jToolBar15.setFloatable(false);
        jToolBar15.setRollover(true);

        AgregarArriendos.setBackground(new java.awt.Color(153, 153, 153));
        AgregarArriendos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/mas.png"))); // NOI18N
        AgregarArriendos.setFocusable(false);
        AgregarArriendos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        AgregarArriendos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        AgregarArriendos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarArriendosActionPerformed(evt);
            }
        });
        jToolBar15.add(AgregarArriendos);
        jToolBar15.add(jSeparator51);
        jToolBar15.add(jSeparator52);

        jLabel50.setText("                                                                                                                                            ");
        jToolBar15.add(jLabel50);

        AgregarMorosidad.setBackground(new java.awt.Color(153, 153, 153));
        AgregarMorosidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/crimen.png"))); // NOI18N
        AgregarMorosidad.setFocusable(false);
        AgregarMorosidad.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        AgregarMorosidad.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        AgregarMorosidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarMorosidadActionPerformed(evt);
            }
        });
        jToolBar15.add(AgregarMorosidad);
        jToolBar15.add(jSeparator53);
        jToolBar15.add(jSeparator55);

        BuscadorArriendos.setBackground(new java.awt.Color(70, 110, 196));
        BuscadorArriendos.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        BuscadorArriendos.setText("Buscador");
        BuscadorArriendos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BuscadorArriendosMouseClicked(evt);
            }
        });
        BuscadorArriendos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                BuscadorArriendosKeyTyped(evt);
            }
        });
        jToolBar15.add(BuscadorArriendos);
        jToolBar15.add(jSeparator57);

        EliminarArriendos.setBackground(new java.awt.Color(153, 153, 153));
        EliminarArriendos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/basura.png"))); // NOI18N
        EliminarArriendos.setFocusable(false);
        EliminarArriendos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        EliminarArriendos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        EliminarArriendos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarArriendosActionPerformed(evt);
            }
        });
        jToolBar15.add(EliminarArriendos);

        jPanel6.add(jToolBar15, java.awt.BorderLayout.PAGE_END);

        TablaArriendo.setBackground(new java.awt.Color(204, 204, 204));
        TablaArriendo.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        TablaArriendo.setForeground(new java.awt.Color(0, 0, 0));
        TablaArriendo.setModel(new javax.swing.table.DefaultTableModel(
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
        TablaArriendo.setMinimumSize(new java.awt.Dimension(60, 100));
        TablaArriendo.setName(""); // NOI18N
        TablaArriendo.setRowHeight(30);
        TablaArriendo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaArriendoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaArriendo);

        jPanel6.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        PanelArriendos.addTab("Arriendos", jPanel6);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        jLabel41.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(0, 0, 0));
        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel41.setText("Agregar Arriendo");

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Cliente:");

        ComboTrabajador.setBackground(new java.awt.Color(70, 110, 196));
        ComboTrabajador.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        ComboTrabajador.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ComboTrabajador.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Trabajador:");

        ComboCliente.setBackground(new java.awt.Color(70, 110, 196));
        ComboCliente.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        ComboCliente.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ComboCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Boleta/Factura:");

        ComboBoF.setBackground(new java.awt.Color(70, 110, 196));
        ComboBoF.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        ComboBoF.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ComboBoF.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel42.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(0, 0, 0));
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel42.setText("Agregar Opciones");

        GuardarAriendo.setBackground(new java.awt.Color(204, 204, 204));
        GuardarAriendo.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        GuardarAriendo.setText("Guardar Arriendo");
        GuardarAriendo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarAriendoActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Folio/Trabajador/Cliente:");

        ComboOpcArriendo.setBackground(new java.awt.Color(70, 110, 196));
        ComboOpcArriendo.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        ComboOpcArriendo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ComboOpcArriendo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("ISBN/Libro:");

        ComboLibroArriendo.setBackground(new java.awt.Color(70, 110, 196));
        ComboLibroArriendo.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        ComboLibroArriendo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ComboLibroArriendo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        GuardarOpcion.setBackground(new java.awt.Color(204, 204, 204));
        GuardarOpcion.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        GuardarOpcion.setText("Guardar Opcion");
        GuardarOpcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarOpcionActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Fecha de Entrega:");

        FechaEntregaArriendo.setBackground(new java.awt.Color(70, 110, 196));
        try {
            FechaEntregaArriendo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-##-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        FechaEntregaArriendo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        FechaEntregaArriendo.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        jLabel16.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("(AAAA-MM-DD)");

        jLabel17.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Fecha de Devolución:");

        FechaDevolucionArriendo.setBackground(new java.awt.Color(70, 110, 196));
        try {
            FechaDevolucionArriendo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-##-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        FechaDevolucionArriendo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        FechaDevolucionArriendo.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        ActualizarBoF.setBackground(new java.awt.Color(153, 153, 153));
        ActualizarBoF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/actualizar.png"))); // NOI18N
        ActualizarBoF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualizarBoFActionPerformed(evt);
            }
        });

        ListaLibros.setBackground(new java.awt.Color(153, 153, 153));
        ListaLibros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/listado1.png"))); // NOI18N
        ListaLibros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListaLibrosActionPerformed(evt);
            }
        });

        ActualizarLibros.setBackground(new java.awt.Color(153, 153, 153));
        ActualizarLibros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/actualizar.png"))); // NOI18N
        ActualizarLibros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualizarLibrosActionPerformed(evt);
            }
        });

        ListaBoF.setBackground(new java.awt.Color(153, 153, 153));
        ListaBoF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/listado1.png"))); // NOI18N
        ListaBoF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListaBoFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator2)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(FechaEntregaArriendo, javax.swing.GroupLayout.DEFAULT_SIZE, 879, Short.MAX_VALUE)
                                    .addComponent(FechaDevolucionArriendo)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(GuardarAriendo, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(621, 621, 621)
                                .addComponent(jLabel16))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(ComboOpcArriendo, javax.swing.GroupLayout.Alignment.TRAILING, 0, 882, Short.MAX_VALUE)
                                    .addComponent(ComboLibroArriendo, javax.swing.GroupLayout.Alignment.TRAILING, 0, 882, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ActualizarLibros, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ListaLibros, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(107, 107, 107)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ComboBoF, javax.swing.GroupLayout.PREFERRED_SIZE, 882, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(ActualizarBoF, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ListaBoF, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(128, 128, 128)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ComboTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, 883, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ComboCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 882, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 304, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel42, javax.swing.GroupLayout.DEFAULT_SIZE, 1487, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(93, 93, 93)
                    .addComponent(GuardarOpcion, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(1224, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboTrabajador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(ComboCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(ComboBoF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel12))
                            .addComponent(ListaBoF, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(166, 166, 166)
                        .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ComboOpcArriendo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ListaLibros, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(ComboLibroArriendo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel14))
                            .addComponent(ActualizarLibros, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(FechaEntregaArriendo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(FechaDevolucionArriendo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                        .addComponent(GuardarAriendo, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(ActualizarBoF, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(808, Short.MAX_VALUE)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(330, 330, 330)
                    .addComponent(GuardarOpcion, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(483, Short.MAX_VALUE)))
        );

        PanelArriendos.addTab("Gestión de Arriendos", jPanel1);

        jPanel4.setLayout(new java.awt.BorderLayout());

        jToolBar13.setBackground(new java.awt.Color(204, 204, 204));
        jToolBar13.setFloatable(false);
        jToolBar13.setForeground(new java.awt.Color(204, 204, 204));
        jToolBar13.setRollover(true);

        RegistrosMorosos.setForeground(new java.awt.Color(0, 0, 0));
        RegistrosMorosos.setText("jLabel5");
        jToolBar13.add(RegistrosMorosos);

        jPanel4.add(jToolBar13, java.awt.BorderLayout.PAGE_START);

        jToolBar16.setBackground(new java.awt.Color(204, 204, 204));
        jToolBar16.setFloatable(false);
        jToolBar16.setRollover(true);

        AgragarMorosos.setText("Agregar");
        AgragarMorosos.setFocusable(false);
        AgragarMorosos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        AgragarMorosos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        AgragarMorosos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgragarMorososActionPerformed(evt);
            }
        });
        jToolBar16.add(AgragarMorosos);
        jToolBar16.add(jSeparator54);
        jToolBar16.add(jSeparator56);

        jLabel51.setText("                                                                                                                                            ");
        jToolBar16.add(jLabel51);

        MorosidadPagada.setText("Pagada");
        MorosidadPagada.setFocusable(false);
        MorosidadPagada.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        MorosidadPagada.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        MorosidadPagada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MorosidadPagadaActionPerformed(evt);
            }
        });
        jToolBar16.add(MorosidadPagada);
        jToolBar16.add(jSeparator58);
        jToolBar16.add(jSeparator59);

        BuscadorMorosidad.setBackground(new java.awt.Color(70, 110, 196));
        BuscadorMorosidad.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        BuscadorMorosidad.setText("Buscador");
        BuscadorMorosidad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BuscadorMorosidadMouseClicked(evt);
            }
        });
        BuscadorMorosidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                BuscadorMorosidadKeyTyped(evt);
            }
        });
        jToolBar16.add(BuscadorMorosidad);
        jToolBar16.add(jSeparator60);

        EliminarMorosidad.setText("Eliminar");
        EliminarMorosidad.setFocusable(false);
        EliminarMorosidad.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        EliminarMorosidad.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        EliminarMorosidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarMorosidadActionPerformed(evt);
            }
        });
        jToolBar16.add(EliminarMorosidad);

        jPanel4.add(jToolBar16, java.awt.BorderLayout.PAGE_END);

        TablaMorosidad.setBackground(new java.awt.Color(204, 204, 204));
        TablaMorosidad.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        TablaMorosidad.setForeground(new java.awt.Color(0, 0, 0));
        TablaMorosidad.setModel(new javax.swing.table.DefaultTableModel(
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
        TablaMorosidad.setMinimumSize(new java.awt.Dimension(60, 100));
        TablaMorosidad.setName(""); // NOI18N
        TablaMorosidad.setRowHeight(30);
        TablaMorosidad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaMorosidadMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TablaMorosidad);

        jPanel4.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        PanelArriendos.addTab("Morosidad", jPanel4);

        jPanel3.add(PanelArriendos, java.awt.BorderLayout.CENTER);

        jTabbedPane2.addTab("Arriendos", jPanel3);

        getContentPane().add(jTabbedPane2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //EVENTOS PARA ARRIENDOS
    
    //Boton agregar arriendos
    private void AgregarArriendosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarArriendosActionPerformed
        sswitchArriendo=0;
        PanelArriendos.setSelectedIndex(1);
    }//GEN-LAST:event_AgregarArriendosActionPerformed

    //Boton eliminar arriendos
    private void EliminarArriendosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarArriendosActionPerformed
        if (filaArriedo>-1) {
            int respuesta=JOptionPane.showConfirmDialog(this, "¿REALMENTE DESEA ELEMINAR EL REGISTRO? NO VOLVERA A RECUPERAR EL REGISTRO...");
            if (respuesta==0) {
                cra.EliminarArriendo(Integer.parseInt(String.valueOf(TablaArriendo.getValueAt(filaArriedo, 0))));
                LlenarTablaArriendo("");
                JOptionPane.showMessageDialog(this, "ARRIENDO ELIMINADO", "LA BIBLIOTECA",JOptionPane.OK_OPTION+JOptionPane.INFORMATION_MESSAGE);
                filaArriedo=-1;
            }
        } else {
           JOptionPane.showMessageDialog(this, "DEBE SELECCIONAR UNA FILA","ADVERTENCIA",JOptionPane.OK_OPTION+JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_EliminarArriendosActionPerformed

    //Toma codigo desde la Tabla de Arriendos
    private void TablaArriendoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaArriendoMouseClicked
        filaArriedo=TablaArriendo.rowAtPoint(evt.getPoint());
    }//GEN-LAST:event_TablaArriendoMouseClicked

    //Boton agregar morosidad a un arriendo
    private void AgregarMorosidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarMorosidadActionPerformed
        if (filaArriedo>-1) {
            codArriendo=Integer.parseInt(String.valueOf(TablaArriendo.getValueAt(filaArriedo, 0)));
            PanelArriendos.setSelectedIndex(2);
            crm.InsertarMorosidad(codArriendo);
            LlenarTablaMorosidades("");
        } else {
           JOptionPane.showMessageDialog(this, "DEBE SELECCIONAR UNA FILA PARA AGREGAR MOROSIDAD","ADVERTENCIA",JOptionPane.OK_OPTION+JOptionPane.WARNING_MESSAGE);
        }
        codArriendo=0;
    }//GEN-LAST:event_AgregarMorosidadActionPerformed

    //Vacia el buscador
    private void BuscadorArriendosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BuscadorArriendosMouseClicked
        BuscadorArriendos.setText("");
    }//GEN-LAST:event_BuscadorArriendosMouseClicked

    //Buscar por escritura
    private void BuscadorArriendosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BuscadorArriendosKeyTyped
        LlenarTablaArriendo(BuscadorArriendos.getText());
    }//GEN-LAST:event_BuscadorArriendosKeyTyped

    //Boton para guardar Opcion
    private void GuardarOpcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarOpcionActionPerformed
        Trabajador t=(Trabajador)ComboTrabajador.getSelectedItem();
        Cliente c=(Cliente)ComboCliente.getSelectedItem();
        BoletaOfactura bof=(BoletaOfactura)ComboBoF.getSelectedItem(); 
        cro.InsertarOpcArriendo(t.getCod_traba(), c.getCod_cliente(), bof.getCod_bof());
        ComboBoxOPC();
        JOptionPane.showMessageDialog(this, "OPCION AGREGADA", "LA BIBLIOTECA",JOptionPane.OK_OPTION+JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_GuardarOpcionActionPerformed

    //Boton para guardar Arriendo
    private void GuardarAriendoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarAriendoActionPerformed
        Libros l=(Libros)ComboLibroArriendo.getSelectedItem();
        Opcion o=(Opcion)ComboOpcArriendo.getSelectedItem();
        if (sswitchArriendo==0) {cra.InsertarArriendo(o.getCod_opcion(), l.getCod_libro(), Date.valueOf(FechaEntregaArriendo.getText()), Date.valueOf(FechaDevolucionArriendo.getText()));}
        LlenarTablaArriendo("");
        sswitchArriendo=0;
        PanelArriendos.setSelectedIndex(0);
        JOptionPane.showMessageDialog(this, "OPERACION REALIZADA", "LA BIBLIOTECA",JOptionPane.OK_OPTION+JOptionPane.INFORMATION_MESSAGE);
        ComboBoxLibros();
    }//GEN-LAST:event_GuardarAriendoActionPerformed

    //Boton para Agregar Morosidades desde la Tabla Morosidad
    private void AgragarMorososActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgragarMorososActionPerformed

        PanelArriendos.setSelectedIndex(0);
    }//GEN-LAST:event_AgragarMorososActionPerformed

    //Boton para cambiar el estado de morosidad a pagada
    private void MorosidadPagadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MorosidadPagadaActionPerformed
        if (filaMorosos>-1) {
            codMorosidad=Integer.parseInt(String.valueOf(TablaMorosidad.getValueAt(filaMorosos, 0)));
            crm.EditarMorosidadPagada(codMorosidad);
            LlenarTablaMorosidades("");
        } else {
           JOptionPane.showMessageDialog(this, "DEBE SELECCIONAR UNA FILA PARA ACTUALIZAR MOROSIDAD","ADVERTENCIA",JOptionPane.OK_OPTION+JOptionPane.WARNING_MESSAGE);
        }
        codMorosidad=0;
        filaMorosos=-1;
    }//GEN-LAST:event_MorosidadPagadaActionPerformed

    //Tomar el codigo de morosidad desde su tabla
    private void TablaMorosidadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaMorosidadMouseClicked
        filaMorosos=TablaMorosidad.rowAtPoint(evt.getPoint());
    }//GEN-LAST:event_TablaMorosidadMouseClicked

    //Boton para Borrar una morosidad
    private void EliminarMorosidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarMorosidadActionPerformed
        if (filaMorosos>-1) {
            int respuesta=JOptionPane.showConfirmDialog(this, "¿REALMENTE DESEA ELEMINAR EL REGISTRO? NO VOLVERA A RECUPERAR EL REGISTRO...");
            if (respuesta==0) {
                crm.EliminarMorosidad(Integer.parseInt(String.valueOf(TablaMorosidad.getValueAt(filaMorosos, 0))));
                LlenarTablaMorosidades("");
                JOptionPane.showMessageDialog(this, "ARRIENDO ELIMINADO", "LA BIBLIOTECA",JOptionPane.OK_OPTION+JOptionPane.INFORMATION_MESSAGE);
                filaMorosos=-1;
            }
        } else {
           JOptionPane.showMessageDialog(this, "DEBE SELECCIONAR UNA FILA","ADVERTENCIA",JOptionPane.OK_OPTION+JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_EliminarMorosidadActionPerformed

    //Borrar buscador de Morosidades al hacer click
    private void BuscadorMorosidadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BuscadorMorosidadMouseClicked
        BuscadorMorosidad.setText("");
    }//GEN-LAST:event_BuscadorMorosidadMouseClicked

    //buscar datos en tabla morosidades por escritura
    private void BuscadorMorosidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BuscadorMorosidadKeyTyped
        LlenarTablaMorosidades(BuscadorMorosidad.getText());
    }//GEN-LAST:event_BuscadorMorosidadKeyTyped

    //boton para abrir un formulario para cambiar estados de libros de en arriendo a Stock
    private void ListaLibrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListaLibrosActionPerformed
        FRM_Libros frml =new FRM_Libros();
        Principal.PanelDesktop.add(frml);
        Principal.centrar(frml);
    }//GEN-LAST:event_ListaLibrosActionPerformed

    //boton para actualizar el ComboBox con libros en Stock
    private void ActualizarLibrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualizarLibrosActionPerformed
        ComboBoxLibros();
    }//GEN-LAST:event_ActualizarLibrosActionPerformed

    //boton para abrir el formulario de boletas o facturas de COMPRAS
    private void ListaBoFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListaBoFActionPerformed
        FRM_Boleta_o_Factura frm =new FRM_Boleta_o_Factura();
        Principal.PanelDesktop.add(frm);
        Principal.centrar(frm);
    }//GEN-LAST:event_ListaBoFActionPerformed

    //boton para actualizar el ComboBox de boletas o facturas de COMPRAS
    private void ActualizarBoFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualizarBoFActionPerformed
        ComboBoxBoF();
    }//GEN-LAST:event_ActualizarBoFActionPerformed

    ///EVENTOS PARA LA VENTA///
    
    //boton para agregar Arriendo
    private void AgregarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarVentaActionPerformed
        sswitchVenta=0;
        PanelVentas.setSelectedIndex(1);
    }//GEN-LAST:event_AgregarVentaActionPerformed

    //boton para editar ventas
    private void EditarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarVentaActionPerformed
        if (filaVentas>-1) {
            codVenta=Integer.parseInt(String.valueOf(TablaVentas.getValueAt(filaVentas, 0)));
            sswitchVenta=1;
            PanelVentas.setSelectedIndex(1);
        } else {
           JOptionPane.showMessageDialog(this, "DEBE SELECCIONAR UNA FILA","ADVERTENCIA",JOptionPane.OK_OPTION+JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_EditarVentaActionPerformed

    //vaciar la caja de texto al hacer click 
    private void buscadorVentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buscadorVentasMouseClicked
        buscadorVentas.setText("");
    }//GEN-LAST:event_buscadorVentasMouseClicked

    //buscar ventas por escritura
    private void buscadorVentasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscadorVentasKeyTyped
        LlenarTablaVentas(buscadorVentas.getText());
    }//GEN-LAST:event_buscadorVentasKeyTyped

    //boton para eliminar ventas
    private void EliminarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarVentaActionPerformed
        if (filaVentas>-1) {
            int respuesta=JOptionPane.showConfirmDialog(this, "¿REALMENTE DESEA ELEMINAR EL REGISTRO? NO VOLVERA A RECUPERAR EL REGISTRO...");
            if (respuesta==0) {
                crv.EliminarVenta(Integer.parseInt(String.valueOf(TablaVentas.getValueAt(filaVentas, 0))));
                LlenarTablaVentas("");
                JOptionPane.showMessageDialog(this, "VENTA ELIMINADA", "LA BIBLIOTECA",JOptionPane.OK_OPTION+JOptionPane.INFORMATION_MESSAGE);
                filaVentas=-1;
            }
        } else {
           JOptionPane.showMessageDialog(this, "DEBE SELECCIONAR UNA FILA","ADVERTENCIA",JOptionPane.OK_OPTION+JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_EliminarVentaActionPerformed

    //tomar codigo por la fila de la tabla
    private void TablaVentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaVentasMouseClicked
        filaVentas=TablaVentas.rowAtPoint(evt.getPoint());
    }//GEN-LAST:event_TablaVentasMouseClicked

    //boton para guardar opcion
    private void GuardarOpcion1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarOpcion1ActionPerformed
        Trabajador t=(Trabajador)ComboTrabajador1.getSelectedItem();
        Cliente c=(Cliente)ComboCliente1.getSelectedItem();
        BoletaOfactura bof=(BoletaOfactura)ComboBoF1.getSelectedItem(); 
        cro.InsertarOpcVenta(t.getCod_traba(), c.getCod_cliente(), bof.getCod_bof());
        ComboBoxOpcVenta();
        JOptionPane.showMessageDialog(this, "OPCION AGREGADA", "LA BIBLIOTECA",JOptionPane.OK_OPTION+JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_GuardarOpcion1ActionPerformed

    //boton para actualizar el combobox de la boleta o factura
    private void ActualizarBoF1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualizarBoF1ActionPerformed
        ComboBoxBoF();
    }//GEN-LAST:event_ActualizarBoF1ActionPerformed

    //boton para abrir el formulario de las boletas o facturas
    private void ListaBoF1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListaBoF1ActionPerformed
       FRM_Boleta_o_Factura frm =new FRM_Boleta_o_Factura();
        Principal.PanelDesktop.add(frm);
        Principal.centrar(frm);
    }//GEN-LAST:event_ListaBoF1ActionPerformed

    private void GuardarAriendo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarAriendo1ActionPerformed
        Libros l=(Libros)ComboLibroVenta.getSelectedItem();
        Opcion o=(Opcion)ComboOpcVenta.getSelectedItem();
        if (sswitchVenta==0) crv.InsertarVenta(o.getCod_opcion(), l.getCod_libro());
        else crv.EditarVenta(codVenta, o.getCod_opcion(), l.getCod_libro());
        LlenarTablaVentas("");
        sswitchVenta=0;
        PanelVentas.setSelectedIndex(0);
        JOptionPane.showMessageDialog(this, "OPERACION REALIZADA", "LA BIBLIOTECA",JOptionPane.OK_OPTION+JOptionPane.INFORMATION_MESSAGE);
        ComboBoxLibros();
        ComboBoxLibrosVentas();
    }//GEN-LAST:event_GuardarAriendo1ActionPerformed

    private void ActualizarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualizarClienteActionPerformed
        ComboBoxClientes();
    }//GEN-LAST:event_ActualizarClienteActionPerformed

    private void ListaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListaClienteActionPerformed
        FRM_Cliente frmc=new FRM_Cliente();
        Principal.PanelDesktop.add(frmc);
        Principal.centrar(frmc);
    }//GEN-LAST:event_ListaClienteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ActualizarBoF;
    private javax.swing.JButton ActualizarBoF1;
    private javax.swing.JButton ActualizarCliente;
    private javax.swing.JButton ActualizarLibros;
    private javax.swing.JButton AgragarMorosos;
    private javax.swing.JButton AgregarArriendos;
    private javax.swing.JButton AgregarMorosidad;
    private javax.swing.JButton AgregarVenta;
    private javax.swing.JTextField BuscadorArriendos;
    private javax.swing.JTextField BuscadorMorosidad;
    private javax.swing.JComboBox ComboBoF;
    private javax.swing.JComboBox ComboBoF1;
    private javax.swing.JComboBox ComboCliente;
    private javax.swing.JComboBox ComboCliente1;
    private javax.swing.JComboBox ComboLibroArriendo;
    private javax.swing.JComboBox ComboLibroVenta;
    private javax.swing.JComboBox ComboOpcArriendo;
    private javax.swing.JComboBox ComboOpcVenta;
    private javax.swing.JComboBox ComboTrabajador;
    private javax.swing.JComboBox ComboTrabajador1;
    private javax.swing.JButton EditarVenta;
    private javax.swing.JButton EliminarArriendos;
    private javax.swing.JButton EliminarMorosidad;
    private javax.swing.JButton EliminarVenta;
    private javax.swing.JFormattedTextField FechaDevolucionArriendo;
    private javax.swing.JFormattedTextField FechaEntregaArriendo;
    private javax.swing.JButton GuardarAriendo;
    private javax.swing.JButton GuardarAriendo1;
    private javax.swing.JButton GuardarOpcion;
    private javax.swing.JButton GuardarOpcion1;
    private javax.swing.JButton ListaBoF;
    private javax.swing.JButton ListaBoF1;
    private javax.swing.JButton ListaCliente;
    private javax.swing.JButton ListaLibros;
    private javax.swing.JButton MorosidadPagada;
    private javax.swing.JTabbedPane PanelArriendos;
    private javax.swing.JTabbedPane PanelVentas;
    private javax.swing.JLabel RegistrosArriendo;
    private javax.swing.JLabel RegistrosMorosos;
    private javax.swing.JLabel RegistrosVentas;
    private javax.swing.JTable TablaArriendo;
    private javax.swing.JTable TablaMorosidad;
    private javax.swing.JTable TablaVentas;
    private javax.swing.JTextField buscadorVentas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator51;
    private javax.swing.JToolBar.Separator jSeparator52;
    private javax.swing.JToolBar.Separator jSeparator53;
    private javax.swing.JToolBar.Separator jSeparator54;
    private javax.swing.JToolBar.Separator jSeparator55;
    private javax.swing.JToolBar.Separator jSeparator56;
    private javax.swing.JToolBar.Separator jSeparator57;
    private javax.swing.JToolBar.Separator jSeparator58;
    private javax.swing.JToolBar.Separator jSeparator59;
    private javax.swing.JToolBar.Separator jSeparator60;
    private javax.swing.JToolBar.Separator jSeparator61;
    private javax.swing.JToolBar.Separator jSeparator62;
    private javax.swing.JToolBar.Separator jSeparator63;
    private javax.swing.JToolBar.Separator jSeparator64;
    private javax.swing.JToolBar.Separator jSeparator65;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JToolBar jToolBar12;
    private javax.swing.JToolBar jToolBar13;
    private javax.swing.JToolBar jToolBar14;
    private javax.swing.JToolBar jToolBar15;
    private javax.swing.JToolBar jToolBar16;
    private javax.swing.JToolBar jToolBar17;
    // End of variables declaration//GEN-END:variables
}
