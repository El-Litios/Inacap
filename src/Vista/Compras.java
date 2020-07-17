/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vista;


import Controlador.Control_AutorLibro;
import Controlador.Control_Autores;
import Controlador.Control_CategoriaLibro;
import Controlador.Control_Compra;
import Controlador.Control_Distribuidor;
import Controlador.Control_Factura;
import Controlador.Control_IdiomaLibro;
import Controlador.Control_Libros;
import Controlador.Control_OrdenCLibro;
import Controlador.Control_OrdenDeCompra;
import Modelo.AutorLibro;
import Modelo.Autores;
import Modelo.Categoria;
import Modelo.CategoriaLibro;
import Modelo.Compra;
import Modelo.Comuna;
import Modelo.Distribuidor;
import Modelo.Editorial;
import Modelo.EstadoLibro;
import Modelo.EstadoOC;
import Modelo.FacturaCompra;
import Modelo.Idioma;
import Modelo.IdiomaLibro;
import Modelo.Libros;
import Modelo.MetodoCompra;
import Modelo.NacionAutor;
import Modelo.OrdenC_Libros;
import Modelo.OrdenCompra;
import Modelo.PaisAutor;
import Modelo.PaisDist;
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
public class Compras extends javax.swing.JInternalFrame {
    //Controladores
    Control_OrdenDeCompra cro=new Control_OrdenDeCompra();
    Control_OrdenCLibro crol=new Control_OrdenCLibro();
    Control_Factura crf= new Control_Factura();
    Control_Compra crC=new Control_Compra();
    Control_Distribuidor crd=new Control_Distribuidor();
    Control_Libros crl=new Control_Libros();
    Control_Autores cra=new Control_Autores();
    Control_AutorLibro cral=new Control_AutorLibro();
    Control_IdiomaLibro cril=new Control_IdiomaLibro();
    Control_CategoriaLibro crcl=new Control_CategoriaLibro();
    //Filas
    private int fila=-1;//fila para orden de compra
    private int filaFact=-1;//fila para facturas
    private int filaCompras=-1;//fila para compras
    private int filaDist=-1;//fila para distribuidores
    private int filaLib=-1;//fila para libros
    private int filaEdit=-1;//fila para editoriales
    private int filaAutor=-1;//fila para autores
    //Codigos
    int codOrdenCompra;//codigo orden de comrpra
    int codFactura;//codigo para facturas
    int codCompra;//codigo para compras
    int codDist;//codigo para distribuidores
    int codLibro;//codigo para Libros
    int codEdit;//codigo para Editoriales
    int codAutor;//codigo para Autores
    //Tablas
    DefaultTableModel tabla=new DefaultTableModel();//tabla de ordenes de compra.
    DefaultTableModel tabla1=new DefaultTableModel();//tabla de libros en ordenes de compra
    DefaultTableModel tabla2=new DefaultTableModel();//tabla de facturas
    DefaultTableModel tabla3=new DefaultTableModel();//tabla de Compras
    DefaultTableModel tabla4=new DefaultTableModel();//tabla de Distribuidores
    DefaultTableModel tabla5=new DefaultTableModel();//tabla de Libros
    DefaultTableModel tabla6=new DefaultTableModel();//tabla de Editoriales
    DefaultTableModel tabla7=new DefaultTableModel();//tabla de Autores
    DefaultTableModel tabla8=new DefaultTableModel();//tabla de Nacionalidades
    DefaultTableModel tabla9=new DefaultTableModel();//tabla de Autores en Libros
    DefaultTableModel tabla10=new DefaultTableModel();//tabla de Idiomas en Libros
    DefaultTableModel tabla11=new DefaultTableModel();//tabla de Idiomas en Libros
    //Switches
    private int sswitch=0;//switch para orden de compra

    private int sswitch2=0;//switch para facturas
    private  int sswitch3=0;//switch para compras

    private int sswitch5=0;//switch para libros

    private int sswitch7=0;//switch para autores

    
    
    //METODOS PARA LLENAR TABLAS//
    
    
    
    //llenar tabla de ordenes de compra
    public void LlenarTablaOrdenC(String Dato){
    tabla.setColumnCount(0);
        tabla.addColumn("Codigo");
        tabla.addColumn("Folio de Orden");
        tabla.addColumn("Fecha de Emision");
        tabla.addColumn("Distribuidor");
        tabla.addColumn("Trabajador Encargado");
        tabla.addColumn("Estado de Orden");
        List<OrdenCompra> lista=cro.ListarOrdenesC(Dato);
        tabla.setNumRows(lista.size());
        registros.setText("CANTIDAD DE REGISTROS= "+lista.size());
        for (int i = 0; i < lista.size(); i++) {
            tabla.setValueAt(lista.get(i).getCod_orden(), i, 0);
            tabla.setValueAt(lista.get(i).getFolio_orden(), i, 1);
            tabla.setValueAt(lista.get(i).getFecha_emision(), i, 2);
            tabla.setValueAt(lista.get(i).getNom_dist(), i, 3);
            tabla.setValueAt(lista.get(i).getNom_traba(), i, 4);
            tabla.setValueAt(lista.get(i).getNom_estado(), i, 5);
        }
        jTable1.setModel(tabla);//el jtable recibe lo que es la tabla. con los nombres de sus columans.
        
        //poner invisible la columna de codigos, para una mejor visualizacion
        jTable1.getColumnModel().getColumn(0).setMaxWidth(0);
        jTable1.getColumnModel().getColumn(0).setMinWidth(0);
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(0);
    }
    
    //llenar tabla de facturas
    public void LlenarTablaFacturas(String Dato){
    tabla2.setColumnCount(0);
        tabla2.addColumn("Codigo");
        tabla2.addColumn("Precio Neto");
        tabla2.addColumn("Costo Iva");
        tabla2.addColumn("Precio Total");
        tabla2.addColumn("Fecha de Ingreso");
        tabla2.addColumn("Distribuidor");
        tabla2.addColumn("Metodo de Pago");
        List<FacturaCompra> lista=crf.listarFacturas(Dato);
        tabla2.setNumRows(lista.size());
        RegistroFact.setText("CANTIDAD DE REGISTROS= "+lista.size());
        for (int i = 0; i < lista.size(); i++) {
            tabla2.setValueAt(lista.get(i).getCod_fact(), i, 0);
            tabla2.setValueAt(lista.get(i).getPrec_neto(), i, 1);
            tabla2.setValueAt(lista.get(i).getCosto_iva(), i, 2);
            tabla2.setValueAt(lista.get(i).getPrec_iva(), i, 3);
            tabla2.setValueAt(lista.get(i).getFec_compra(), i, 4);
            tabla2.setValueAt(lista.get(i).getNom_dist(), i, 5);
            tabla2.setValueAt(lista.get(i).getNom_metC(), i, 6);
        }
        jTable3.setModel(tabla2);//el jtable recibe lo que es la tabla. con los nombres de sus columans.
        
        //poner invisible la columna de codigos, para una mejor visualizacion
        jTable3.getColumnModel().getColumn(0).setMaxWidth(0);
        jTable3.getColumnModel().getColumn(0).setMinWidth(0);
        jTable3.getColumnModel().getColumn(0).setPreferredWidth(0);
    }
    
    //listar compras
    public void LlenarTablaC(String dato){
    tabla3.setColumnCount(0);
        tabla3.addColumn("Codigo");
        tabla3.addColumn("Comentarios");
        tabla3.addColumn("Folio de Orden");
        tabla3.addColumn("Fecha de Orden");
        tabla3.addColumn("Trabajador Encargado");
        tabla3.addColumn("Precio por Unidad");
        tabla3.addColumn("Fecha de Factura");
        tabla3.addColumn("Distribuidor");
        List<Compra> lista=crC.ListarCompras(dato);
        tabla3.setNumRows(lista.size());
        for (int i = 0; i < lista.size(); i++) {
            tabla3.setValueAt(lista.get(i).getCod_compra(), i, 0);
            tabla3.setValueAt(lista.get(i).getComentarios(), i, 1);
            tabla3.setValueAt(lista.get(i).getFolio_orden(), i, 2);
            tabla3.setValueAt(lista.get(i).getFecha_emision(), i, 3);
            tabla3.setValueAt(lista.get(i).getNom_traba(), i, 4);
            tabla3.setValueAt(lista.get(i).getPrec_iva(), i, 5);
            tabla3.setValueAt(lista.get(i).getFec_compra(), i, 6);
            tabla3.setValueAt(lista.get(i).getNom_dist(), i, 7);
        }
        jTable4.setModel(tabla3);
        jTable4.getColumnModel().getColumn(0).setMaxWidth(0);
        jTable4.getColumnModel().getColumn(0).setMinWidth(0);
        jTable4.getColumnModel().getColumn(0).setPreferredWidth(0);
    }
    
    
    
    //tabla de Libros
    public void LlenarTablaLibros(String Dato){
    tabla5.setColumnCount(0);
        tabla5.addColumn("Codigo");
        tabla5.addColumn("ISBN");
        tabla5.addColumn("Titulo");
        tabla5.addColumn("Paginas");
        tabla5.addColumn("Precio");
        tabla5.addColumn("Estado");
        tabla5.addColumn("Editorial");
        List<Libros> lista=crl.ListarLibros1(Dato);
        tabla5.setNumRows(lista.size());
        RegistrosLibros.setText("CANTIDAD DE REGISTROS= "+lista.size());
        for (int i = 0; i < lista.size(); i++) {
            tabla5.setValueAt(lista.get(i).getCod_libro(), i, 0);
            tabla5.setValueAt(lista.get(i).getIsbn_libro(), i, 1);
            tabla5.setValueAt(lista.get(i).getTitulo_libro(), i, 2);
            tabla5.setValueAt(lista.get(i).getPag_libro(), i, 3);
            tabla5.setValueAt(lista.get(i).getPrecio_libro(), i, 4);
            tabla5.setValueAt(lista.get(i).getNom_estado(), i, 5);
            tabla5.setValueAt(lista.get(i).getNom_edit(), i, 6);
        }
        jTable7.setModel(tabla5);//el jtable recibe lo que es la tabla. con los nombres de sus columans.
        
        //poner invisible la columna de codigos, para una mejor visualizacion
        jTable7.getColumnModel().getColumn(0).setMaxWidth(0);
        jTable7.getColumnModel().getColumn(0).setMinWidth(0);
        jTable7.getColumnModel().getColumn(0).setPreferredWidth(0);
    }
    
    
    //tabla de autores
    public void LlenarTablaAutor(String Dato){
    tabla7.setColumnCount(0);
        tabla7.addColumn("Codigo");
        tabla7.addColumn("Nombre Autor/Pseudonimo");
        tabla7.addColumn("Apellido Paterno");
        tabla7.addColumn("Apellido Materno");
        tabla7.addColumn("Nacionalidad");
        tabla7.addColumn("Pais");
        List<Autores> lista=cra.listarAutores(Dato);
        tabla7.setNumRows(lista.size());
        RegistroAutor.setText("CANTIDAD DE REGISTROS= "+lista.size());
        for (int i = 0; i < lista.size(); i++) {
            tabla7.setValueAt(lista.get(i).getCod_autor(), i, 0);
            if (lista.get(i).getPseu_autor()==(null)) {
                tabla7.setValueAt(lista.get(i).getNom_autor(), i, 1);
            }else{
            tabla7.setValueAt(lista.get(i).getNom_autor()+" "+"("+lista.get(i).getPseu_autor()+")", i, 1);
            }
            tabla7.setValueAt(lista.get(i).getApp_autor(), i, 2);
            tabla7.setValueAt(lista.get(i).getApm_autor(), i, 3);
            tabla7.setValueAt(lista.get(i).getNom_nac(), i, 4);
            tabla7.setValueAt(lista.get(i).getNom_pais(), i, 5);
        }
        jTable9.setModel(tabla7);
        jTable9.getColumnModel().getColumn(0).setMaxWidth(0);
        jTable9.getColumnModel().getColumn(0).setMinWidth(0);
        jTable9.getColumnModel().getColumn(0).setPreferredWidth(0);
    }
    
    ///////////////////////////////////////METODOS PARA COMBOBOX///////////////////////////////////////////////////////
    
    //COMBOBOX PARA ORDENES DE COMPRA//
    private void ComboDistribuidores(){
       DefaultComboBoxModel combo = new DefaultComboBoxModel();
        Control_OrdenDeCompra croc=new Control_OrdenDeCompra();
        List<Distribuidor> lista=croc.ComboBoxDistribuidor();
        for(Distribuidor D:lista){
            D = new Distribuidor(D.getCod_dist(), D.getNom_dist());
            combo.addElement(D);
        }
        Cdist.setModel(combo);
    }
    
    private void ComboTrabajadores(){
       DefaultComboBoxModel combo = new DefaultComboBoxModel();
        Control_OrdenDeCompra croc=new Control_OrdenDeCompra();
        List<Trabajador> lista=croc.ComboBoxTrabajador();
        for(Trabajador T:lista){
            T = new Trabajador(T.getCod_traba(), T.getNom_traba());
            combo.addElement(T);
        }
        Ctraba.setModel(combo);
    }
    
    private void ComboEstadoOrden(){
       DefaultComboBoxModel combo = new DefaultComboBoxModel();
        Control_OrdenDeCompra croc=new Control_OrdenDeCompra();
        List<EstadoOC> lista=croc.ComboBoxEstadoOrden();
        for(EstadoOC E:lista){
            E = new EstadoOC(E.getCod_estado(), E.getNom_estado());
            combo.addElement(E);
        }
        Cestado.setModel(combo);
    }

    //////////////////////////////////////////////////////////////////////////
    
    //COMBOBOX PARA FACTURAS//
    private void ComboDistFact(){
       DefaultComboBoxModel combo = new DefaultComboBoxModel();
        Control_Factura cof=new Control_Factura();
        List<Distribuidor> lista=cof.ComboBoxDistribuidor();
        for(Distribuidor D:lista){
            D = new Distribuidor(D.getCod_dist(), D.getNom_dist());
            combo.addElement(D);
        }
        CdistFact.setModel(combo);
    }
    
    private void ComboMetod(){
       DefaultComboBoxModel combo = new DefaultComboBoxModel();
        Control_Factura cof=new Control_Factura();
        List<MetodoCompra> lista=cof.ComboBoxMedioPago();
        for(MetodoCompra M:lista){
            M = new MetodoCompra(M.getCod_metC(), M.getNom_metC());
            combo.addElement(M);
        }
        Cmetod.setModel(combo);
    }
    
    private void ComboOrdenC(){
       DefaultComboBoxModel combo = new DefaultComboBoxModel();
        Control_Compra coc=new Control_Compra();
        List<OrdenCompra> lista=coc.ComboBoxOrdenes();
        for(OrdenCompra O:lista){
            O = new OrdenCompra(O.getCod_orden(), O.getFolio_orden());
            combo.addElement(O);
        }
        CordenC.setModel(combo);
    }
    
    private void ComboFact(){
       DefaultComboBoxModel combo = new DefaultComboBoxModel();
        Control_Compra coc=new Control_Compra();
        List<FacturaCompra> lista=coc.ComboBoxFacturas();
        for(FacturaCompra F:lista){
            F = new FacturaCompra(F.getCod_fact(), F.getFec_compra());
            combo.addElement(F);
        }
        ComboFecha.setModel(combo);
    }
    /////////////////////////////////////////////////////////////////////////
    
    
    //COMBOBOXS PARA GESTION DE LIBROS//
    private void ComboEstadoLibro(){
       DefaultComboBoxModel combo = new DefaultComboBoxModel();
        Control_Libros col=new Control_Libros();
        List<EstadoLibro> lista=col.comboboxEstado();
        for(EstadoLibro E:lista){
            E = new EstadoLibro(E.getCod_estado(), E.getNom_estado());
            combo.addElement(E);
        }
        CEstadoL.setModel(combo);
    }
    
    private void ComboEditorialLibro(){
       DefaultComboBoxModel combo = new DefaultComboBoxModel();
        Control_Libros col=new Control_Libros();
        List<Editorial> lista=col.comboboxEditorial();
        for(Editorial E:lista){
            E = new Editorial(E.getCod_edit(), E.getNom_edit());
            combo.addElement(E);
        }
        CeditorialL.setModel(combo);
    }
    
    /////////////////////////////////////////////////////////////////////////////
    
    //COMBOBOXS PARA GESTION DE AUTORES//
    private void ComboNacionPaisAutor(){
       DefaultComboBoxModel combo = new DefaultComboBoxModel();
        Control_Autores ca=new Control_Autores();
        List<NacionAutor> lista=ca.comboNacPais();
        for(NacionAutor N:lista){
            N = new NacionAutor(N.getCod_nac(), N.getNom_nac());
            combo.addElement(N);
        }
        CPNac.setModel(combo);
    }
    
    ////////////////////////////////////////////////////////////////////////////
    
    public Compras() {
        initComponents();
        //TABLAS//
        LlenarTablaOrdenC("");
        LlenarTablaFacturas("");
        LlenarTablaC("");
        LlenarTablaLibros("");
        LlenarTablaAutor("");
        //RADIOBUTTONES//
        //estados de ordenes de compra
        estadosOrdenC.add(aprobada);
        estadosOrdenC.add(anulado);
        estadosOrdenC.add(proceso);
        
        //estados de libros
        EstadoLibros.add(btnStock);
        EstadoLibros.add(btnArrendado);
        EstadoLibros.add(btnEnCompra);
        EstadoLibros.add(btnVendido);
        
        //COMBOBOXS//
        //ordenes de compra
        ComboDistribuidores();
        ComboTrabajadores();
        ComboEstadoOrden();

        //facturas
        ComboDistFact();
        ComboMetod();
        ComboOrdenC();
        ComboFact();
        
        //Libros
        ComboEstadoLibro();
        ComboEditorialLibro();
        
        //Autor
        ComboNacionPaisAutor();

        //tooltips
        BTNCategorias.setToolTipText("Categorias de Libros");
        BTNIdiomas.setToolTipText("Idiomas de Libros");
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator7 = new javax.swing.JSeparator();
        jSeparator16 = new javax.swing.JSeparator();
        jSeparator22 = new javax.swing.JSeparator();
        jSeparator23 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        estadosOrdenC = new javax.swing.ButtonGroup();
        EstadoLibros = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        PanelOrdenesCompra = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jToolBar4 = new javax.swing.JToolBar();
        registros = new javax.swing.JLabel();
        jToolBar2 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        Editar = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        jLabel2 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        aprobada = new javax.swing.JRadioButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        anulado = new javax.swing.JRadioButton();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        proceso = new javax.swing.JRadioButton();
        jSeparator6 = new javax.swing.JToolBar.Separator();
        buscador = new javax.swing.JTextField();
        jSeparator9 = new javax.swing.JToolBar.Separator();
        Eliminar = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        folio = new javax.swing.JTextField();
        Cdist = new javax.swing.JComboBox();
        Ctraba = new javax.swing.JComboBox();
        Cestado = new javax.swing.JComboBox();
        fecha = new javax.swing.JFormattedTextField();
        Guardar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        ListaLibros1 = new javax.swing.JButton();
        ActualizarLibros1 = new javax.swing.JButton();
        jLabel51 = new javax.swing.JLabel();
        BTNOrdenLibro = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        PanelFacturas = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jToolBar6 = new javax.swing.JToolBar();
        RegistroFact = new javax.swing.JLabel();
        jToolBar3 = new javax.swing.JToolBar();
        AgregarFacturas = new javax.swing.JButton();
        jSeparator11 = new javax.swing.JToolBar.Separator();
        EditarFacturas = new javax.swing.JButton();
        jSeparator12 = new javax.swing.JToolBar.Separator();
        jLabel5 = new javax.swing.JLabel();
        jSeparator13 = new javax.swing.JToolBar.Separator();
        jSeparator14 = new javax.swing.JToolBar.Separator();
        jSeparator15 = new javax.swing.JToolBar.Separator();
        jSeparator17 = new javax.swing.JToolBar.Separator();
        buscarFacturas = new javax.swing.JTextField();
        jSeparator18 = new javax.swing.JToolBar.Separator();
        EliminarFacturas = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        Precio = new javax.swing.JTextField();
        CdistFact = new javax.swing.JComboBox();
        Cmetod = new javax.swing.JComboBox();
        FechaIngreso = new javax.swing.JFormattedTextField();
        GuardarFact = new javax.swing.JButton();
        jSeparator19 = new javax.swing.JSeparator();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        ComboFecha = new javax.swing.JComboBox();
        jLabel19 = new javax.swing.JLabel();
        CordenC = new javax.swing.JComboBox();
        G = new javax.swing.JButton();
        buscadorCompras = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        EditarCompras = new javax.swing.JButton();
        BorrarCompras = new javax.swing.JButton();
        comen1 = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        ListaLibros = new javax.swing.JButton();
        ActualizarLibros = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        PanelLibros = new javax.swing.JTabbedPane();
        jPanel12 = new javax.swing.JPanel();
        jToolBar12 = new javax.swing.JToolBar();
        RegistrosLibros = new javax.swing.JLabel();
        jToolBar10 = new javax.swing.JToolBar();
        AgregarLibros = new javax.swing.JButton();
        jSeparator36 = new javax.swing.JToolBar.Separator();
        EditarLibros = new javax.swing.JButton();
        jSeparator37 = new javax.swing.JToolBar.Separator();
        jLabel40 = new javax.swing.JLabel();
        btnStock = new javax.swing.JRadioButton();
        jSeparator38 = new javax.swing.JToolBar.Separator();
        btnEnCompra = new javax.swing.JRadioButton();
        jSeparator39 = new javax.swing.JToolBar.Separator();
        btnArrendado = new javax.swing.JRadioButton();
        jSeparator40 = new javax.swing.JToolBar.Separator();
        btnVendido = new javax.swing.JRadioButton();
        jSeparator41 = new javax.swing.JToolBar.Separator();
        BuscadorLibros = new javax.swing.JTextField();
        jSeparator42 = new javax.swing.JToolBar.Separator();
        EliminarLibros = new javax.swing.JButton();
        jScrollPane12 = new javax.swing.JScrollPane();
        jTable7 = new javax.swing.JTable();
        jPanel13 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        CEstadoL = new javax.swing.JComboBox();
        CeditorialL = new javax.swing.JComboBox();
        jLabel47 = new javax.swing.JLabel();
        titulo = new javax.swing.JTextField();
        paginas = new javax.swing.JTextField();
        precio = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        Isbn1 = new javax.swing.JTextField();
        GuardarLibros = new javax.swing.JButton();
        jLabel49 = new javax.swing.JLabel();
        jSeparator20 = new javax.swing.JSeparator();
        ListaEditorial = new javax.swing.JButton();
        ActualizarEditorial = new javax.swing.JButton();
        BTNCategorias = new javax.swing.JButton();
        BTNIdiomas = new javax.swing.JButton();
        BTNIdiomas1 = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        jToolBar14 = new javax.swing.JToolBar();
        RegistroAutor = new javax.swing.JLabel();
        jToolBar15 = new javax.swing.JToolBar();
        AgregarAutor = new javax.swing.JButton();
        jSeparator51 = new javax.swing.JToolBar.Separator();
        EditarAutor = new javax.swing.JButton();
        jSeparator52 = new javax.swing.JToolBar.Separator();
        jLabel50 = new javax.swing.JLabel();
        jSeparator53 = new javax.swing.JToolBar.Separator();
        jSeparator54 = new javax.swing.JToolBar.Separator();
        jSeparator55 = new javax.swing.JToolBar.Separator();
        jSeparator56 = new javax.swing.JToolBar.Separator();
        BuscadorAutor = new javax.swing.JTextField();
        jSeparator57 = new javax.swing.JToolBar.Separator();
        EliminarAutor = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTable9 = new javax.swing.JTable();
        jPanel15 = new javax.swing.JPanel();
        jLabel53 = new javax.swing.JLabel();
        NombreAutor = new javax.swing.JTextField();
        CPNac = new javax.swing.JComboBox();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        PseuAutor = new javax.swing.JTextField();
        AppPAutor = new javax.swing.JTextField();
        AppMAutor = new javax.swing.JTextField();
        GuardarAutor = new javax.swing.JButton();
        jLabel59 = new javax.swing.JLabel();
        ListaNac = new javax.swing.JButton();
        ActualizarComboNac = new javax.swing.JButton();

        setBackground(new java.awt.Color(102, 102, 102));
        setBorder(null);
        setClosable(true);

        jTabbedPane1.setBackground(new java.awt.Color(105, 149, 236));
        jTabbedPane1.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        jTabbedPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTabbedPane1.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);
        jTabbedPane1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setLayout(new java.awt.BorderLayout());

        PanelOrdenesCompra.setBackground(new java.awt.Color(153, 153, 153));
        PanelOrdenesCompra.setForeground(new java.awt.Color(0, 0, 0));
        PanelOrdenesCompra.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        PanelOrdenesCompra.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);
        PanelOrdenesCompra.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        PanelOrdenesCompra.setOpaque(true);

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jToolBar4.setBackground(new java.awt.Color(204, 204, 204));
        jToolBar4.setFloatable(false);
        jToolBar4.setForeground(new java.awt.Color(204, 204, 204));
        jToolBar4.setRollover(true);

        registros.setForeground(new java.awt.Color(0, 0, 0));
        registros.setText("jLabel5");
        jToolBar4.add(registros);

        jPanel2.add(jToolBar4, java.awt.BorderLayout.PAGE_START);

        jToolBar2.setBackground(new java.awt.Color(204, 204, 204));
        jToolBar2.setFloatable(false);
        jToolBar2.setRollover(true);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/mas orden de comrpa.png"))); // NOI18N
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar2.add(jButton1);
        jToolBar2.add(jSeparator1);

        Editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lapiz.png"))); // NOI18N
        Editar.setFocusable(false);
        Editar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Editar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarActionPerformed(evt);
            }
        });
        jToolBar2.add(Editar);
        jToolBar2.add(jSeparator2);

        jLabel2.setText("                                               ");
        jToolBar2.add(jLabel2);
        jToolBar2.add(jSeparator3);

        aprobada.setBackground(new java.awt.Color(204, 204, 204));
        aprobada.setForeground(new java.awt.Color(0, 0, 0));
        aprobada.setText("Aprobadas");
        aprobada.setFocusable(false);
        aprobada.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        aprobada.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        aprobada.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                aprobadaMouseClicked(evt);
            }
        });
        jToolBar2.add(aprobada);
        jToolBar2.add(jSeparator4);

        anulado.setBackground(new java.awt.Color(204, 204, 204));
        anulado.setForeground(new java.awt.Color(0, 0, 0));
        anulado.setText("Anuladas");
        anulado.setFocusable(false);
        anulado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        anulado.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        anulado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                anuladoMouseClicked(evt);
            }
        });
        jToolBar2.add(anulado);
        jToolBar2.add(jSeparator5);

        proceso.setBackground(new java.awt.Color(204, 204, 204));
        proceso.setForeground(new java.awt.Color(0, 0, 0));
        proceso.setText("En Proceso");
        proceso.setFocusable(false);
        proceso.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        proceso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                procesoMouseClicked(evt);
            }
        });
        jToolBar2.add(proceso);
        jToolBar2.add(jSeparator6);

        buscador.setBackground(new java.awt.Color(70, 110, 196));
        buscador.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        buscador.setForeground(new java.awt.Color(0, 0, 0));
        buscador.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        buscador.setText("Buscador");
        buscador.setBorder(null);
        buscador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buscadorMouseClicked(evt);
            }
        });
        buscador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                buscadorKeyTyped(evt);
            }
        });
        jToolBar2.add(buscador);
        jToolBar2.add(jSeparator9);

        Eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/basura.png"))); // NOI18N
        Eliminar.setFocusable(false);
        Eliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Eliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });
        jToolBar2.add(Eliminar);

        jPanel2.add(jToolBar2, java.awt.BorderLayout.PAGE_END);

        jTable1.setBackground(new java.awt.Color(204, 204, 204));
        jTable1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
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
        jTable1.setRowHeight(25);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(jTable1);

        jPanel2.add(jScrollPane6, java.awt.BorderLayout.CENTER);

        PanelOrdenesCompra.addTab("Lista Ordenes de Compra", jPanel2);

        jPanel4.setBackground(new java.awt.Color(153, 153, 153));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Fecha de Emision:");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Distribuidor:");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Trabajador Encargado:");

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Estado de Orden:");

        folio.setBackground(new java.awt.Color(70, 110, 196));
        folio.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        folio.setForeground(new java.awt.Color(0, 0, 0));
        folio.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        Cdist.setBackground(new java.awt.Color(70, 110, 196));
        Cdist.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        Cdist.setForeground(new java.awt.Color(0, 0, 0));
        Cdist.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        Ctraba.setBackground(new java.awt.Color(70, 110, 196));
        Ctraba.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        Ctraba.setForeground(new java.awt.Color(0, 0, 0));
        Ctraba.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        Cestado.setBackground(new java.awt.Color(70, 110, 196));
        Cestado.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        Cestado.setForeground(new java.awt.Color(0, 0, 0));
        Cestado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        fecha.setBackground(new java.awt.Color(70, 110, 196));
        fecha.setForeground(new java.awt.Color(0, 0, 0));
        try {
            fecha.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-##-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        fecha.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fecha.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        Guardar.setBackground(new java.awt.Color(204, 204, 204));
        Guardar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        Guardar.setText("Guardar");
        Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Folio de Orden:");

        ListaLibros1.setBackground(new java.awt.Color(153, 153, 153));
        ListaLibros1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/listado1.png"))); // NOI18N
        ListaLibros1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListaLibros1ActionPerformed(evt);
            }
        });

        ActualizarLibros1.setBackground(new java.awt.Color(153, 153, 153));
        ActualizarLibros1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/actualizar.png"))); // NOI18N
        ActualizarLibros1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualizarLibros1ActionPerformed(evt);
            }
        });

        jLabel51.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(0, 0, 0));
        jLabel51.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel51.setText("Gestión de Ordenes de Compra");

        BTNOrdenLibro.setBackground(new java.awt.Color(153, 153, 153));
        BTNOrdenLibro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/orden.png"))); // NOI18N
        BTNOrdenLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNOrdenLibroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(294, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 932, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(folio, javax.swing.GroupLayout.PREFERRED_SIZE, 932, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Ctraba, javax.swing.GroupLayout.PREFERRED_SIZE, 932, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cestado, javax.swing.GroupLayout.PREFERRED_SIZE, 932, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(Cdist, javax.swing.GroupLayout.PREFERRED_SIZE, 932, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ActualizarLibros1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ListaLibros1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(233, 233, 233))
            .addComponent(jLabel51, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(Guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(BTNOrdenLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel51)
                .addGap(104, 104, 104)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(folio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(40, 40, 40)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(40, 40, 40)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Cdist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(ListaLibros1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                        .addComponent(ActualizarLibros1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addGap(40, 40, 40)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(Ctraba, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(Cestado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(111, 111, 111)
                .addComponent(Guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(151, 151, 151)
                .addComponent(BTNOrdenLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(251, 251, 251))
        );

        PanelOrdenesCompra.addTab("Agregar Ordenes", jPanel4);

        jPanel1.add(PanelOrdenesCompra, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("Ordenes de Compra", jPanel1);

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));
        jPanel3.setLayout(new java.awt.BorderLayout());

        PanelFacturas.setBackground(new java.awt.Color(153, 153, 153));
        PanelFacturas.setForeground(new java.awt.Color(0, 0, 0));
        PanelFacturas.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        PanelFacturas.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);
        PanelFacturas.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        PanelFacturas.setOpaque(true);

        jPanel6.setBackground(new java.awt.Color(102, 102, 102));
        jPanel6.setLayout(new java.awt.BorderLayout());

        jToolBar6.setBackground(new java.awt.Color(204, 204, 204));
        jToolBar6.setFloatable(false);
        jToolBar6.setForeground(new java.awt.Color(204, 204, 204));
        jToolBar6.setRollover(true);

        RegistroFact.setForeground(new java.awt.Color(0, 0, 0));
        RegistroFact.setText("jLabel5");
        jToolBar6.add(RegistroFact);

        jPanel6.add(jToolBar6, java.awt.BorderLayout.PAGE_START);

        jToolBar3.setBackground(new java.awt.Color(204, 204, 204));
        jToolBar3.setFloatable(false);
        jToolBar3.setRollover(true);

        AgregarFacturas.setText("Agregar");
        AgregarFacturas.setFocusable(false);
        AgregarFacturas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        AgregarFacturas.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        AgregarFacturas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarFacturasActionPerformed(evt);
            }
        });
        jToolBar3.add(AgregarFacturas);
        jToolBar3.add(jSeparator11);

        EditarFacturas.setText("Editar");
        EditarFacturas.setFocusable(false);
        EditarFacturas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        EditarFacturas.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        EditarFacturas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarFacturasActionPerformed(evt);
            }
        });
        jToolBar3.add(EditarFacturas);
        jToolBar3.add(jSeparator12);

        jLabel5.setText("                                                                                              ");
        jToolBar3.add(jLabel5);
        jToolBar3.add(jSeparator13);
        jToolBar3.add(jSeparator14);
        jToolBar3.add(jSeparator15);
        jToolBar3.add(jSeparator17);

        buscarFacturas.setBackground(new java.awt.Color(70, 110, 196));
        buscarFacturas.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        buscarFacturas.setText("Buscador");
        buscarFacturas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buscarFacturasMouseClicked(evt);
            }
        });
        buscarFacturas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                buscarFacturasKeyTyped(evt);
            }
        });
        jToolBar3.add(buscarFacturas);
        jToolBar3.add(jSeparator18);

        EliminarFacturas.setText("Eliminar");
        EliminarFacturas.setFocusable(false);
        EliminarFacturas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        EliminarFacturas.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        EliminarFacturas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarFacturasActionPerformed(evt);
            }
        });
        jToolBar3.add(EliminarFacturas);

        jPanel6.add(jToolBar3, java.awt.BorderLayout.PAGE_END);

        jTable3.setBackground(new java.awt.Color(204, 204, 204));
        jTable3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jTable3.setForeground(new java.awt.Color(0, 0, 0));
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable3.setRowHeight(25);
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable3MouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(jTable3);

        jPanel6.add(jScrollPane7, java.awt.BorderLayout.CENTER);

        PanelFacturas.addTab("Lista Facturas", jPanel6);

        jPanel7.setBackground(new java.awt.Color(153, 153, 153));

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel12.setText("Folio de Orden");

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Fecha de Ingreso ");

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Distribuidor:");

        jLabel15.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("Metodo de Pago:");

        Precio.setBackground(new java.awt.Color(70, 110, 196));
        Precio.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        Precio.setForeground(new java.awt.Color(0, 0, 0));
        Precio.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        CdistFact.setBackground(new java.awt.Color(70, 110, 196));
        CdistFact.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        CdistFact.setForeground(new java.awt.Color(0, 0, 0));
        CdistFact.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        Cmetod.setBackground(new java.awt.Color(70, 110, 196));
        Cmetod.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        Cmetod.setForeground(new java.awt.Color(0, 0, 0));
        Cmetod.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        FechaIngreso.setBackground(new java.awt.Color(70, 110, 196));
        FechaIngreso.setForeground(new java.awt.Color(0, 0, 0));
        try {
            FechaIngreso.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-##-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        FechaIngreso.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        FechaIngreso.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        GuardarFact.setBackground(new java.awt.Color(204, 204, 204));
        GuardarFact.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        GuardarFact.setText("Guardar");
        GuardarFact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarFactActionPerformed(evt);
            }
        });

        jSeparator19.setBackground(new java.awt.Color(0, 0, 0));

        jLabel17.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Agregar Compras");

        jLabel18.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setText("Precio Neto");

        ComboFecha.setBackground(new java.awt.Color(70, 110, 196));
        ComboFecha.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        ComboFecha.setForeground(new java.awt.Color(0, 0, 0));
        ComboFecha.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel19.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel19.setText("Fecha de Factura");

        CordenC.setBackground(new java.awt.Color(70, 110, 196));
        CordenC.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        CordenC.setForeground(new java.awt.Color(0, 0, 0));
        CordenC.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        G.setBackground(new java.awt.Color(204, 204, 204));
        G.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        G.setText("Guardar");
        G.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GActionPerformed(evt);
            }
        });

        buscadorCompras.setBackground(new java.awt.Color(70, 110, 196));
        buscadorCompras.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        buscadorCompras.setForeground(new java.awt.Color(0, 0, 0));
        buscadorCompras.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        buscadorCompras.setText("Buscador");
        buscadorCompras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buscadorComprasMouseClicked(evt);
            }
        });
        buscadorCompras.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                buscadorComprasKeyTyped(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel16.setText("Comentarios");

        EditarCompras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lapiz.png"))); // NOI18N
        EditarCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarComprasActionPerformed(evt);
            }
        });

        BorrarCompras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/basura.png"))); // NOI18N
        BorrarCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BorrarComprasActionPerformed(evt);
            }
        });

        comen1.setBackground(new java.awt.Color(70, 110, 196));
        comen1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        comen1.setForeground(new java.awt.Color(0, 0, 0));
        comen1.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jTable4.setBackground(new java.awt.Color(204, 204, 204));
        jTable4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jTable4.setForeground(new java.awt.Color(0, 0, 0));
        jTable4.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable4.setRowHeight(25);
        jTable4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable4MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable4);

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

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator19, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(174, 174, 174)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(20, 20, 20))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(18, 18, 18))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel13))
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(Cmetod, javax.swing.GroupLayout.Alignment.LEADING, 0, 932, Short.MAX_VALUE)
                            .addComponent(CdistFact, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(FechaIngreso, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Precio, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(12, 12, 12)
                        .addComponent(ActualizarLibros, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ListaLibros, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(GuardarFact, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(721, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(21, 21, 21)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ComboFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CordenC, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comen1, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(G, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(144, 144, 144))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(EditarCompras)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BorrarCompras)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buscadorCompras, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jScrollPane3)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Precio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FechaIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ActualizarLibros, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(CdistFact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel14))
                    .addComponent(ListaLibros, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Cmetod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGap(18, 18, 18)
                .addComponent(GuardarFact, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator19, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17)
                .addGap(44, 44, 44)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EditarCompras)
                    .addComponent(BorrarCompras)
                    .addComponent(buscadorCompras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 187, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(comen1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CordenC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(G, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addGap(66, 66, 66))
        );

        PanelFacturas.addTab("Agregar Facturas", jPanel7);

        jPanel3.add(PanelFacturas, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("Facturas", jPanel3);

        jPanel5.setLayout(new java.awt.BorderLayout());

        PanelLibros.setBackground(new java.awt.Color(153, 153, 153));
        PanelLibros.setForeground(new java.awt.Color(0, 0, 0));
        PanelLibros.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        PanelLibros.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);
        PanelLibros.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        PanelLibros.setOpaque(true);

        jPanel12.setBackground(new java.awt.Color(102, 102, 102));
        jPanel12.setLayout(new java.awt.BorderLayout());

        jToolBar12.setBackground(new java.awt.Color(204, 204, 204));
        jToolBar12.setFloatable(false);
        jToolBar12.setForeground(new java.awt.Color(204, 204, 204));
        jToolBar12.setRollover(true);

        RegistrosLibros.setForeground(new java.awt.Color(0, 0, 0));
        RegistrosLibros.setText("jLabel5");
        jToolBar12.add(RegistrosLibros);

        jPanel12.add(jToolBar12, java.awt.BorderLayout.PAGE_START);

        jToolBar10.setBackground(new java.awt.Color(204, 204, 204));
        jToolBar10.setFloatable(false);
        jToolBar10.setRollover(true);

        AgregarLibros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/maslibros.png"))); // NOI18N
        AgregarLibros.setFocusable(false);
        AgregarLibros.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        AgregarLibros.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        AgregarLibros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarLibrosActionPerformed(evt);
            }
        });
        jToolBar10.add(AgregarLibros);
        jToolBar10.add(jSeparator36);

        EditarLibros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lapiz.png"))); // NOI18N
        EditarLibros.setFocusable(false);
        EditarLibros.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        EditarLibros.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        EditarLibros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarLibrosActionPerformed(evt);
            }
        });
        jToolBar10.add(EditarLibros);
        jToolBar10.add(jSeparator37);

        jLabel40.setText("                                       ");
        jToolBar10.add(jLabel40);

        btnStock.setBackground(new java.awt.Color(204, 204, 204));
        btnStock.setForeground(new java.awt.Color(0, 0, 0));
        btnStock.setText("En Stock");
        btnStock.setFocusable(false);
        btnStock.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        btnStock.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnStock.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnStockMouseClicked(evt);
            }
        });
        jToolBar10.add(btnStock);
        jToolBar10.add(jSeparator38);

        btnEnCompra.setBackground(new java.awt.Color(204, 204, 204));
        btnEnCompra.setForeground(new java.awt.Color(0, 0, 0));
        btnEnCompra.setText("En Compra");
        btnEnCompra.setFocusable(false);
        btnEnCompra.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        btnEnCompra.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnEnCompra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEnCompraMouseClicked(evt);
            }
        });
        jToolBar10.add(btnEnCompra);
        jToolBar10.add(jSeparator39);

        btnArrendado.setBackground(new java.awt.Color(204, 204, 204));
        btnArrendado.setForeground(new java.awt.Color(0, 0, 0));
        btnArrendado.setText("Arrendado");
        btnArrendado.setFocusable(false);
        btnArrendado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnArrendado.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnArrendado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnArrendadoMouseClicked(evt);
            }
        });
        jToolBar10.add(btnArrendado);
        jToolBar10.add(jSeparator40);

        btnVendido.setBackground(new java.awt.Color(204, 204, 204));
        btnVendido.setForeground(new java.awt.Color(0, 0, 0));
        btnVendido.setText("Vendido");
        btnVendido.setFocusable(false);
        btnVendido.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnVendido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVendidoMouseClicked(evt);
            }
        });
        jToolBar10.add(btnVendido);
        jToolBar10.add(jSeparator41);

        BuscadorLibros.setBackground(new java.awt.Color(70, 110, 196));
        BuscadorLibros.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        BuscadorLibros.setForeground(new java.awt.Color(0, 0, 0));
        BuscadorLibros.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        BuscadorLibros.setText("Buscador");
        BuscadorLibros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BuscadorLibrosMouseClicked(evt);
            }
        });
        BuscadorLibros.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                BuscadorLibrosKeyTyped(evt);
            }
        });
        jToolBar10.add(BuscadorLibros);
        jToolBar10.add(jSeparator42);

        EliminarLibros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/basura.png"))); // NOI18N
        EliminarLibros.setFocusable(false);
        EliminarLibros.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        EliminarLibros.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        EliminarLibros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarLibrosActionPerformed(evt);
            }
        });
        jToolBar10.add(EliminarLibros);

        jPanel12.add(jToolBar10, java.awt.BorderLayout.PAGE_END);

        jTable7.setBackground(new java.awt.Color(204, 204, 204));
        jTable7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jTable7.setForeground(new java.awt.Color(0, 0, 0));
        jTable7.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable7.setRowHeight(25);
        jTable7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable7MouseClicked(evt);
            }
        });
        jScrollPane12.setViewportView(jTable7);

        jPanel12.add(jScrollPane12, java.awt.BorderLayout.CENTER);

        PanelLibros.addTab("Lista de Libros", jPanel12);

        jPanel13.setBackground(new java.awt.Color(153, 153, 153));

        jLabel43.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(0, 0, 0));
        jLabel43.setText("Titulo:");

        jLabel44.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(0, 0, 0));
        jLabel44.setText("Paginas:");

        jLabel45.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(0, 0, 0));
        jLabel45.setText("Precio:");

        CEstadoL.setBackground(new java.awt.Color(70, 110, 196));
        CEstadoL.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        CEstadoL.setForeground(new java.awt.Color(0, 0, 0));
        CEstadoL.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        CeditorialL.setBackground(new java.awt.Color(70, 110, 196));
        CeditorialL.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        CeditorialL.setForeground(new java.awt.Color(0, 0, 0));
        CeditorialL.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel47.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(0, 0, 0));
        jLabel47.setText("ISBN:");

        titulo.setBackground(new java.awt.Color(70, 110, 196));
        titulo.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        titulo.setForeground(new java.awt.Color(0, 0, 0));
        titulo.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        paginas.setBackground(new java.awt.Color(70, 110, 196));
        paginas.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        paginas.setForeground(new java.awt.Color(0, 0, 0));
        paginas.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        precio.setBackground(new java.awt.Color(70, 110, 196));
        precio.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        precio.setForeground(new java.awt.Color(0, 0, 0));
        precio.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel46.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(0, 0, 0));
        jLabel46.setText("Estado:");

        jLabel48.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(0, 0, 0));
        jLabel48.setText("Editorial:");

        Isbn1.setBackground(new java.awt.Color(70, 110, 196));
        Isbn1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        Isbn1.setForeground(new java.awt.Color(0, 0, 0));
        Isbn1.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        GuardarLibros.setBackground(new java.awt.Color(204, 204, 204));
        GuardarLibros.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        GuardarLibros.setText("Guardar");
        GuardarLibros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarLibrosActionPerformed(evt);
            }
        });

        jLabel49.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(0, 0, 0));
        jLabel49.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel49.setText("Gestión de Libros");

        jSeparator20.setForeground(new java.awt.Color(0, 0, 0));

        ListaEditorial.setBackground(new java.awt.Color(153, 153, 153));
        ListaEditorial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/listado1.png"))); // NOI18N
        ListaEditorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListaEditorialActionPerformed(evt);
            }
        });

        ActualizarEditorial.setBackground(new java.awt.Color(153, 153, 153));
        ActualizarEditorial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/actualizar.png"))); // NOI18N
        ActualizarEditorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualizarEditorialActionPerformed(evt);
            }
        });

        BTNCategorias.setBackground(new java.awt.Color(153, 153, 153));
        BTNCategorias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/categoria.png"))); // NOI18N
        BTNCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNCategoriasActionPerformed(evt);
            }
        });

        BTNIdiomas.setBackground(new java.awt.Color(153, 153, 153));
        BTNIdiomas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/idioma.png"))); // NOI18N
        BTNIdiomas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNIdiomasActionPerformed(evt);
            }
        });

        BTNIdiomas1.setBackground(new java.awt.Color(153, 153, 153));
        BTNIdiomas1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/shakespeare (1).png"))); // NOI18N
        BTNIdiomas1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNIdiomas1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel49, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(GuardarLibros, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel43)
                        .addGap(18, 18, 18)
                        .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 1023, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGap(355, 355, 355)
                                .addComponent(jLabel47))
                            .addComponent(jLabel44, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel45, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel46, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel48, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CeditorialL, javax.swing.GroupLayout.PREFERRED_SIZE, 1023, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(Isbn1)
                                .addComponent(paginas, javax.swing.GroupLayout.PREFERRED_SIZE, 1023, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(precio, javax.swing.GroupLayout.PREFERRED_SIZE, 1023, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(CEstadoL, javax.swing.GroupLayout.PREFERRED_SIZE, 1023, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addComponent(ActualizarEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ListaEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 190, Short.MAX_VALUE))
            .addComponent(jSeparator20)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BTNCategorias)
                .addGap(18, 18, 18)
                .addComponent(BTNIdiomas, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BTNIdiomas1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(jLabel49)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator20, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel47)
                    .addComponent(Isbn1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel43))
                .addGap(42, 42, 42)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(paginas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel44))
                .addGap(42, 42, 42)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(precio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel45))
                .addGap(42, 42, 42)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CEstadoL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel46))
                .addGap(42, 42, 42)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CeditorialL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel48))
                        .addComponent(ListaEditorial, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ActualizarEditorial, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 339, Short.MAX_VALUE)
                .addComponent(GuardarLibros, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(165, 165, 165)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BTNIdiomas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BTNCategorias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BTNIdiomas1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        PanelLibros.addTab("Gestion de Libros", jPanel13);

        jPanel14.setLayout(new java.awt.BorderLayout());

        jToolBar14.setBackground(new java.awt.Color(204, 204, 204));
        jToolBar14.setFloatable(false);
        jToolBar14.setForeground(new java.awt.Color(204, 204, 204));
        jToolBar14.setRollover(true);

        RegistroAutor.setForeground(new java.awt.Color(0, 0, 0));
        RegistroAutor.setText("jLabel5");
        jToolBar14.add(RegistroAutor);

        jPanel14.add(jToolBar14, java.awt.BorderLayout.PAGE_START);

        jToolBar15.setBackground(new java.awt.Color(204, 204, 204));
        jToolBar15.setFloatable(false);
        jToolBar15.setRollover(true);

        AgregarAutor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/mas autores.png"))); // NOI18N
        AgregarAutor.setFocusable(false);
        AgregarAutor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        AgregarAutor.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        AgregarAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarAutorActionPerformed(evt);
            }
        });
        jToolBar15.add(AgregarAutor);
        jToolBar15.add(jSeparator51);

        EditarAutor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lapiz.png"))); // NOI18N
        EditarAutor.setFocusable(false);
        EditarAutor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        EditarAutor.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        EditarAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarAutorActionPerformed(evt);
            }
        });
        jToolBar15.add(EditarAutor);
        jToolBar15.add(jSeparator52);

        jLabel50.setText("                                                                                                                                                      ");
        jToolBar15.add(jLabel50);
        jToolBar15.add(jSeparator53);
        jToolBar15.add(jSeparator54);
        jToolBar15.add(jSeparator55);
        jToolBar15.add(jSeparator56);

        BuscadorAutor.setBackground(new java.awt.Color(70, 110, 196));
        BuscadorAutor.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        BuscadorAutor.setForeground(new java.awt.Color(0, 0, 0));
        BuscadorAutor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        BuscadorAutor.setText("Buscador");
        BuscadorAutor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BuscadorAutorMouseClicked(evt);
            }
        });
        BuscadorAutor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                BuscadorAutorKeyTyped(evt);
            }
        });
        jToolBar15.add(BuscadorAutor);
        jToolBar15.add(jSeparator57);

        EliminarAutor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/basura.png"))); // NOI18N
        EliminarAutor.setFocusable(false);
        EliminarAutor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        EliminarAutor.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        EliminarAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarAutorActionPerformed(evt);
            }
        });
        jToolBar15.add(EliminarAutor);

        jPanel14.add(jToolBar15, java.awt.BorderLayout.PAGE_END);

        jTable9.setBackground(new java.awt.Color(204, 204, 204));
        jTable9.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jTable9.setForeground(new java.awt.Color(0, 0, 0));
        jTable9.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable9.setRowHeight(25);
        jTable9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable9MouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(jTable9);

        jPanel14.add(jScrollPane8, java.awt.BorderLayout.CENTER);

        PanelLibros.addTab("Lista de Autores", jPanel14);

        jPanel15.setBackground(new java.awt.Color(153, 153, 153));

        jLabel53.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(0, 0, 0));
        jLabel53.setText("Nacionalidad/Origen :");

        NombreAutor.setBackground(new java.awt.Color(70, 110, 196));
        NombreAutor.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        NombreAutor.setForeground(new java.awt.Color(0, 0, 0));
        NombreAutor.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        CPNac.setBackground(new java.awt.Color(70, 110, 196));
        CPNac.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        CPNac.setForeground(new java.awt.Color(0, 0, 0));
        CPNac.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel55.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(0, 0, 0));
        jLabel55.setText("Nombre:");

        jLabel56.setBackground(new java.awt.Color(0, 0, 0));
        jLabel56.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(0, 0, 0));
        jLabel56.setText("Pseudonimo:");

        jLabel57.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(0, 0, 0));
        jLabel57.setText("Apellido P. :");

        jLabel58.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(0, 0, 0));
        jLabel58.setText("Apellido M. :");

        PseuAutor.setBackground(new java.awt.Color(70, 110, 196));
        PseuAutor.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        PseuAutor.setForeground(new java.awt.Color(0, 0, 0));
        PseuAutor.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        AppPAutor.setBackground(new java.awt.Color(70, 110, 196));
        AppPAutor.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        AppPAutor.setForeground(new java.awt.Color(0, 0, 0));
        AppPAutor.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        AppMAutor.setBackground(new java.awt.Color(70, 110, 196));
        AppMAutor.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        AppMAutor.setForeground(new java.awt.Color(0, 0, 0));
        AppMAutor.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        GuardarAutor.setBackground(new java.awt.Color(204, 204, 204));
        GuardarAutor.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        GuardarAutor.setText("Guardar");
        GuardarAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarAutorActionPerformed(evt);
            }
        });

        jLabel59.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(0, 0, 0));
        jLabel59.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel59.setText("Agregar Autor");

        ListaNac.setBackground(new java.awt.Color(153, 153, 153));
        ListaNac.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/listado1.png"))); // NOI18N
        ListaNac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListaNacActionPerformed(evt);
            }
        });

        ActualizarComboNac.setBackground(new java.awt.Color(153, 153, 153));
        ActualizarComboNac.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/actualizar.png"))); // NOI18N
        ActualizarComboNac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualizarComboNacActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(203, 203, 203)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel58)
                            .addComponent(jLabel53)
                            .addComponent(jLabel57)
                            .addComponent(jLabel56)
                            .addComponent(jLabel55))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PseuAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 1072, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NombreAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 1072, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AppPAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 1072, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AppMAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 1072, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addComponent(CPNac, javax.swing.GroupLayout.PREFERRED_SIZE, 1072, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(ActualizarComboNac, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ListaNac, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 180, Short.MAX_VALUE))
                    .addComponent(jLabel59, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(GuardarAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel59)
                .addGap(72, 72, 72)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NombreAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel55))
                .addGap(47, 47, 47)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PseuAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel56))
                .addGap(47, 47, 47)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AppPAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel57))
                .addGap(47, 47, 47)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AppMAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel58))
                .addGap(47, 47, 47)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(CPNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel53))
                    .addComponent(ListaNac, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ActualizarComboNac, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 380, Short.MAX_VALUE)
                .addComponent(GuardarAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(245, 245, 245))
        );

        PanelLibros.addTab("Gestion de Autores", jPanel15);

        jPanel5.add(PanelLibros, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("Libros", jPanel5);

        getContentPane().add(jTabbedPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //boton para guardar facturas
    private void GuardarFactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarFactActionPerformed
        Distribuidor dist=(Distribuidor)CdistFact.getSelectedItem();
        MetodoCompra met=(MetodoCompra)Cmetod.getSelectedItem();
        FacturaCompra fc=(FacturaCompra)ComboFecha.getSelectedItem();
        
        if (Precio.getText().equals("") && FechaIngreso.getText().equals("")){
            JOptionPane.showMessageDialog(this, "DEBE INGRESAR LOS DATOS!!!", "La biblioteca",JOptionPane.OK_OPTION+JOptionPane.INFORMATION_MESSAGE);
            Precio.grabFocus();
        }else{
            if (sswitch2==0) crf.InsertarFacturas(Integer.parseInt(Precio.getText()), Date.valueOf(FechaIngreso.getText()), dist.getCod_dist(), met.getCod_metC());
            else crf.EditarFacturas(codFactura, Integer.parseInt(Precio.getText()), Date.valueOf(FechaIngreso.getText()), dist.getCod_dist(), met.getCod_metC());
        }   
        folio.setText("");
        fecha.setText("");
        ComboFecha.removeAllItems();
        ComboFact();
        LlenarTablaFacturas("");
        sswitch2=0;
        PanelFacturas.setSelectedIndex(0);
            JOptionPane.showMessageDialog(this, "OPERACION REALIZADA", "LA BIBLIOTECA",JOptionPane.OK_OPTION+JOptionPane.INFORMATION_MESSAGE);

    }//GEN-LAST:event_GuardarFactActionPerformed

    //boton de eliminar Facturas
    private void EliminarFacturasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarFacturasActionPerformed
        FacturaCompra f=(FacturaCompra)ComboFecha.getSelectedItem();
        if (filaFact>-1) {
            int respuesta=JOptionPane.showConfirmDialog(this, "¿REALMENTE DESEA ELEMINAR EL REGISTRO? NO VOLVERA A RECUPERAR EL REGISTRO..."+" "
                    +String.valueOf(jTable3.getValueAt(filaFact, 1)),"ADVERTENCIA",JOptionPane.YES_NO_OPTION+JOptionPane.WARNING_MESSAGE);
            if (respuesta==0) {
                crf.eliminar(Integer.parseInt(String.valueOf(jTable3.getValueAt(filaFact, 0))));
                LlenarTablaFacturas("");
                JOptionPane.showMessageDialog(this, "FACTURA ELIMINADA", "LA BIBLIOTECA",JOptionPane.OK_OPTION+JOptionPane.INFORMATION_MESSAGE);
                ComboFecha.removeAllItems();
                ComboFact();
                filaFact=-1;
            }
        } else {
           JOptionPane.showMessageDialog(this, "DEBE SELECCIONAR UNA FILA","ADVERTENCIA",JOptionPane.OK_OPTION+JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_EliminarFacturasActionPerformed

    //buscador por letras en facturas
    private void buscarFacturasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarFacturasKeyTyped
        LlenarTablaFacturas(buscarFacturas.getText());
    }//GEN-LAST:event_buscarFacturasKeyTyped

    //vaciar el buscador de facturas
    private void buscarFacturasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buscarFacturasMouseClicked
        buscarFacturas.setText("");
    }//GEN-LAST:event_buscarFacturasMouseClicked

    //boton editar de Facturas
    private void EditarFacturasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarFacturasActionPerformed
        if (filaFact>-1) {
            codFactura=Integer.parseInt(String.valueOf(jTable3.getValueAt(filaFact, 0)));
            Precio.setText(String.valueOf(jTable3.getValueAt(filaFact, 1)));
            fecha.setText(String.valueOf(jTable3.getValueAt(filaFact, 2)));
            sswitch2=1;
            PanelFacturas.setSelectedIndex(1);
        } else {
           JOptionPane.showMessageDialog(this, "DEBE SELECCIONAR UNA FILA","ADVERTENCIA",JOptionPane.OK_OPTION+JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_EditarFacturasActionPerformed

    //boton de agregar Facturas nuevas
    private void AgregarFacturasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarFacturasActionPerformed
        sswitch2=0;
        PanelFacturas.setSelectedIndex(1);
        Precio.grabFocus();
    }//GEN-LAST:event_AgregarFacturasActionPerformed

    //boton para agregar mas Compras a la Tabla
    private void GActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GActionPerformed
        FacturaCompra fc=(FacturaCompra)ComboFecha.getSelectedItem();
        OrdenCompra oc=(OrdenCompra)CordenC.getSelectedItem();
         if (buscadorCompras.getText().equals("")){
            JOptionPane.showMessageDialog(this, "DEBE INGRESAR LOS DATOS!!!", "La biblioteca",JOptionPane.OK_OPTION+JOptionPane.INFORMATION_MESSAGE);
            buscadorCompras.grabFocus();
         }else{    
             if (sswitch3==0) crC.guardarCompra(comen1.getText(), fc.getCod_fact(), oc.getCod_orden());
             else crC.EditarCompras(codCompra, comen1.getText(), fc.getCod_fact(), oc.getCod_orden());           
         }
        LlenarTablaC("");
        sswitch3=0;
        JOptionPane.showMessageDialog(this, "OPERACION REALIZADA", "LA BIBLIOTECA",JOptionPane.OK_OPTION+JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_GActionPerformed

    //boton para editar Compras
    private void EditarComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarComprasActionPerformed
        if (filaCompras>-1) {
            codCompra=Integer.parseInt(String.valueOf(jTable4.getValueAt(filaCompras, 0)));
            comen1.setText(String.valueOf(jTable4.getValueAt(filaCompras, 1)));
            sswitch3=1;
            PanelFacturas.setSelectedIndex(1);
        } else {
           JOptionPane.showMessageDialog(this, "DEBE SELECCIONAR UNA FILA","ADVERTENCIA",JOptionPane.OK_OPTION+JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_EditarComprasActionPerformed

    //boton para eliminar Compras
    private void BorrarComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BorrarComprasActionPerformed
        if (filaCompras>-1) {
            int respuesta=JOptionPane.showConfirmDialog(this, "¿REALMENTE DESEA ELEMINAR EL REGISTRO? NO VOLVERA A RECUPERAR EL REGISTRO..."+" "
                    +String.valueOf(jTable4.getValueAt(filaCompras, 1)),"ADVERTENCIA",JOptionPane.YES_NO_OPTION+JOptionPane.WARNING_MESSAGE);
            if (respuesta==0) {
                crC.BorrarCompra(Integer.parseInt(String.valueOf(jTable4.getValueAt(filaCompras, 0))));
                LlenarTablaC("");
                JOptionPane.showMessageDialog(this, "COMPRA ELIMINADA", "LA BIBLIOTECA",JOptionPane.OK_OPTION+JOptionPane.INFORMATION_MESSAGE);
                filaCompras=-1;
            }
        } else {
           JOptionPane.showMessageDialog(this, "DEBE SELECCIONAR UNA FILA","ADVERTENCIA",JOptionPane.OK_OPTION+JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_BorrarComprasActionPerformed

    private void buscadorComprasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buscadorComprasMouseClicked
        buscadorCompras.setText("");
    }//GEN-LAST:event_buscadorComprasMouseClicked

    private void buscadorComprasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscadorComprasKeyTyped
        LlenarTablaC(buscadorCompras.getText());
    }//GEN-LAST:event_buscadorComprasKeyTyped
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //EVENTOS DE LIBROS
    
    private void AgregarAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarAutorActionPerformed
        sswitch7=0;
        PanelLibros.setSelectedIndex(3);
        NombreAutor.grabFocus();
    }//GEN-LAST:event_AgregarAutorActionPerformed

    private void EditarAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarAutorActionPerformed
        if (filaAutor>-1) {
            codAutor=Integer.parseInt(String.valueOf(jTable9.getValueAt(filaAutor, 0)));
            NombreAutor.setText(String.valueOf(jTable9.getValueAt(filaAutor, 1)));
            PseuAutor.setText(String.valueOf(jTable9.getValueAt(filaAutor, 1)));
            AppPAutor.setText(String.valueOf(jTable9.getValueAt(filaAutor, 2)));
            AppMAutor.setText(String.valueOf(jTable9.getValueAt(filaAutor, 3)));
            sswitch7=1;
            PanelLibros.setSelectedIndex(3);
        } else {
           JOptionPane.showMessageDialog(this, "DEBE SELECCIONAR UNA FILA","ADVERTENCIA",JOptionPane.OK_OPTION+JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_EditarAutorActionPerformed

    private void BuscadorAutorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BuscadorAutorMouseClicked
        filaAutor=jTable9.rowAtPoint(evt.getPoint());
    }//GEN-LAST:event_BuscadorAutorMouseClicked

    private void BuscadorAutorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BuscadorAutorKeyTyped
        LlenarTablaAutor(BuscadorAutor.getText());
    }//GEN-LAST:event_BuscadorAutorKeyTyped

    private void EliminarAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarAutorActionPerformed
        
        if (filaAutor>-1) {
            int respuesta=JOptionPane.showConfirmDialog(this, "¿REALMENTE DESEA ELEMINAR EL REGISTRO? NO VOLVERA A RECUPERAR EL REGISTRO..."+" "
                    ,"ADVERTENCIA",JOptionPane.YES_NO_OPTION+JOptionPane.WARNING_MESSAGE);
            if (respuesta==0) {
                cra.EliminarAutores(Integer.parseInt(String.valueOf(jTable9.getValueAt(filaAutor, 0))));
                LlenarTablaAutor("");
                JOptionPane.showMessageDialog(this, "AUTOR ELIMINADO", "LA BIBLIOTECA",JOptionPane.OK_OPTION+JOptionPane.INFORMATION_MESSAGE);
                filaAutor=-1;
            }
        } else {
           JOptionPane.showMessageDialog(this, "DEBE SELECCIONAR UNA FILA","ADVERTENCIA",JOptionPane.OK_OPTION+JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_EliminarAutorActionPerformed

    //Boton para Agregar Libros
    private void AgregarLibrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarLibrosActionPerformed
        sswitch5=0;
        PanelLibros.setSelectedIndex(1);
        Isbn1.grabFocus();
    }//GEN-LAST:event_AgregarLibrosActionPerformed

    //boton para editar Libros
    private void EditarLibrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarLibrosActionPerformed
        if (filaLib>-1) {
            codLibro=Integer.parseInt(String.valueOf(jTable7.getValueAt(filaLib, 0)));
            Isbn1.setText(String.valueOf(jTable7.getValueAt(filaLib, 1)));
            titulo.setText(String.valueOf(jTable7.getValueAt(filaLib, 2)));
            paginas.setText(String.valueOf(jTable7.getValueAt(filaLib, 3)));
            precio.setText(String.valueOf(jTable7.getValueAt(filaLib, 4)));
            sswitch5=1;
            PanelLibros.setSelectedIndex(1);
        } else {
           JOptionPane.showMessageDialog(this, "DEBE SELECCIONAR UNA FILA","ADVERTENCIA",JOptionPane.OK_OPTION+JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_EditarLibrosActionPerformed

    private void btnEnCompraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEnCompraMouseClicked
        LlenarTablaLibros("EN COMPRA");
    }//GEN-LAST:event_btnEnCompraMouseClicked

    private void btnArrendadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnArrendadoMouseClicked
        LlenarTablaLibros("ARRENDADO");
    }//GEN-LAST:event_btnArrendadoMouseClicked

    private void btnVendidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVendidoMouseClicked
        LlenarTablaLibros("VENDIDO");
    }//GEN-LAST:event_btnVendidoMouseClicked

    private void BuscadorLibrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BuscadorLibrosMouseClicked
        BuscadorLibros.setText("");
    }//GEN-LAST:event_BuscadorLibrosMouseClicked

    private void BuscadorLibrosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BuscadorLibrosKeyTyped
        LlenarTablaLibros(BuscadorLibros.getText());
    }//GEN-LAST:event_BuscadorLibrosKeyTyped

    //Boton Eliminar Libros
    private void EliminarLibrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarLibrosActionPerformed
    //ComboFecha.getSelectedItem();
        if (filaLib>-1) {
            int respuesta=JOptionPane.showConfirmDialog(this, "¿REALMENTE DESEA ELEMINAR EL REGISTRO? NO VOLVERA A RECUPERAR EL REGISTRO..."+" "
                    +String.valueOf(jTable7.getValueAt(filaLib, 2)),"ADVERTENCIA",JOptionPane.YES_NO_OPTION+JOptionPane.WARNING_MESSAGE);
            if (respuesta==0) {
                crl.EliminarLibros(Integer.parseInt(String.valueOf(jTable7.getValueAt(filaLib, 0))));
                LlenarTablaLibros("");
                JOptionPane.showMessageDialog(this, "LIBRO ELIMINADO", "LA BIBLIOTECA",JOptionPane.OK_OPTION+JOptionPane.INFORMATION_MESSAGE);
                filaLib=-1;
            }
        } else {
           JOptionPane.showMessageDialog(this, "DEBE SELECCIONAR UNA FILA","ADVERTENCIA",JOptionPane.OK_OPTION+JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_EliminarLibrosActionPerformed

    private void btnStockMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnStockMouseClicked
        LlenarTablaLibros("EN STOCK");
    }//GEN-LAST:event_btnStockMouseClicked

    //boton para guardar libros
    private void GuardarLibrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarLibrosActionPerformed
        EstadoLibro est=(EstadoLibro)CEstadoL.getSelectedItem();
        Editorial ed=(Editorial)CeditorialL.getSelectedItem();
        if (Isbn1.getText().equals("") || titulo.getText().equals("") || paginas.getText().equals("") 
            ||  precio.getText().equals("")){
            JOptionPane.showMessageDialog(this, "DEBE INGRESAR TODOS LOS DATOS!!!", "La biblioteca",JOptionPane.OK_OPTION+JOptionPane.INFORMATION_MESSAGE);
            Isbn1.grabFocus();
        }else{
            if (sswitch5==0) crl.InsertarLibros(Isbn1.getText(), titulo.getText(), 
                    Integer.parseInt(paginas.getText()), Integer.parseInt(precio.getText()), est.getCod_estado(), ed.getCod_edit());
            
            else crl.EditarLibros(codLibro, Isbn1.getText(), titulo.getText(), 
                    Integer.parseInt(paginas.getText()), Integer.parseInt(precio.getText()), est.getCod_estado(), ed.getCod_edit());
            
            JOptionPane.showMessageDialog(this, "OPERACION REALIZADA", "LA BIBLIOTECA",JOptionPane.OK_OPTION+JOptionPane.INFORMATION_MESSAGE);
            PanelLibros.setSelectedIndex(0);     
        }   
        Isbn1.setText("");
        titulo.setText("");
        paginas.setText("");
        precio.setText("");
        LlenarTablaLibros("");
        sswitch5=0;
    }//GEN-LAST:event_GuardarLibrosActionPerformed

    private void GuardarAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarAutorActionPerformed
        NacionAutor na=(NacionAutor)CPNac.getSelectedItem();
            if (sswitch7==0) {
                if (NombreAutor.getText().equalsIgnoreCase("")){
                    cra.InsertarAutores(" ", PseuAutor.getText(), AppPAutor.getText(), AppMAutor.getText(), na.getCod_nac());
                    JOptionPane.showMessageDialog(this, "OPERACION REALIZADA", "LA BIBLIOTECA",JOptionPane.OK_OPTION+JOptionPane.INFORMATION_MESSAGE);
                    PanelLibros.setSelectedIndex(2); 
                }else{
                    if (PseuAutor.getText().equalsIgnoreCase("")){
                    cra.InsertarAutores(NombreAutor.getText(), " ", AppPAutor.getText(), AppMAutor.getText(), na.getCod_nac());
                        JOptionPane.showMessageDialog(this, "OPERACION REALIZADA", "LA BIBLIOTECA",JOptionPane.OK_OPTION+JOptionPane.INFORMATION_MESSAGE);
                        PanelLibros.setSelectedIndex(2); 
                    }else{
                        cra.InsertarAutores(NombreAutor.getText(), PseuAutor.getText(), AppPAutor.getText(), AppMAutor.getText(), na.getCod_nac());
                        JOptionPane.showMessageDialog(this, "OPERACION REALIZADA", "LA BIBLIOTECA",JOptionPane.OK_OPTION+JOptionPane.INFORMATION_MESSAGE);
                        PanelLibros.setSelectedIndex(2); 
                    }  
                }
            }else{ 
                cra.EditarAutores(codAutor, NombreAutor.getText(), 
                    PseuAutor.getText(), AppPAutor.getText(), AppMAutor.getText(), na.getCod_nac());
            
            JOptionPane.showMessageDialog(this, "OPERACION REALIZADA", "LA BIBLIOTECA",JOptionPane.OK_OPTION+JOptionPane.INFORMATION_MESSAGE);
            PanelLibros.setSelectedIndex(2);     
            }
        NombreAutor.setText("");
        PseuAutor.setText("");
        AppPAutor.setText("");
        AppMAutor.setText("");
        
        
        LlenarTablaAutor("");
        sswitch7=0;
    }//GEN-LAST:event_GuardarAutorActionPerformed

    private void jTable4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable4MouseClicked
        filaCompras=jTable4.rowAtPoint(evt.getPoint());
    }//GEN-LAST:event_jTable4MouseClicked

    private void jTable7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable7MouseClicked
        filaLib=jTable7.rowAtPoint(evt.getPoint());
    }//GEN-LAST:event_jTable7MouseClicked

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked
        filaFact=jTable3.rowAtPoint(evt.getPoint());
    }//GEN-LAST:event_jTable3MouseClicked

    private void jTable9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable9MouseClicked
        filaAutor=jTable9.rowAtPoint(evt.getPoint());
    }//GEN-LAST:event_jTable9MouseClicked

    //Boton para guardar los datos de Ordenes de Compra
    private void GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarActionPerformed
        Distribuidor dist=(Distribuidor)Cdist.getSelectedItem();
        Trabajador trab=(Trabajador)Ctraba.getSelectedItem();
        EstadoOC estado=(EstadoOC)Cestado.getSelectedItem();


        if (folio.getText().equals("") && fecha.getText().equals("")){
            JOptionPane.showMessageDialog(this, "DEBE INGRESAR LOS DATOS!!!", "La biblioteca",JOptionPane.OK_OPTION+JOptionPane.INFORMATION_MESSAGE);
            folio.grabFocus();
        }else{
            if (sswitch==0) cro.InsertarOrdenesC(folio.getText(), Date.valueOf(fecha.getText()), dist.getCod_dist(), trab.getCod_traba(), estado.getCod_estado());
            else cro.EditarOrdenesC(codOrdenCompra, folio.getText(), Date.valueOf(fecha.getText()), dist.getCod_dist(), trab.getCod_traba(), estado.getCod_estado());
        }
        folio.setText("");
        fecha.setText("");
        LlenarTablaOrdenC("");
        sswitch=0;
        PanelOrdenesCompra.setSelectedIndex(0);
        JOptionPane.showMessageDialog(this, "OPERACION REALIZADA", "LA BIBLIOTECA",JOptionPane.OK_OPTION+JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_GuardarActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        fila=jTable1.rowAtPoint(evt.getPoint());
    }//GEN-LAST:event_jTable1MouseClicked

    //Boton para Eliminar los datos de Ordenes de Compra
    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed

        if (fila>-1) {
            int respuesta=JOptionPane.showConfirmDialog(this, "¿REALMENTE DESEA ELEMINAR EL REGISTRO? NO VOLVERA A RECUPERAR EL REGISTRO..."+" "
                +String.valueOf(jTable1.getValueAt(fila, 1)),"ADVERTENCIA",JOptionPane.YES_NO_OPTION+JOptionPane.WARNING_MESSAGE);
            if (respuesta==0) {
                cro.EliminarOrdenesC(Integer.parseInt(String.valueOf(jTable1.getValueAt(fila, 0))));
                LlenarTablaOrdenC("");
                JOptionPane.showMessageDialog(this, "ORDEN DE COMPRA ELIMINADA", "LA BIBLIOTECA",JOptionPane.OK_OPTION+JOptionPane.INFORMATION_MESSAGE);
                fila=-1;
            }
        } else {
            JOptionPane.showMessageDialog(this, "DEBE SELECCIONAR UNA FILA","ADVERTENCIA",JOptionPane.OK_OPTION+JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_EliminarActionPerformed

    //Buscador por letras de Ordene de Compra
    private void buscadorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscadorKeyTyped
        LlenarTablaOrdenC(buscador.getText());
    }//GEN-LAST:event_buscadorKeyTyped

    //Buscador de Ordenes de Compra
    private void buscadorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buscadorMouseClicked
        buscador.setText("");
    }//GEN-LAST:event_buscadorMouseClicked

    //radio button orden de compra En Proceso
    private void procesoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_procesoMouseClicked
        LlenarTablaOrdenC("En Proceso");
    }//GEN-LAST:event_procesoMouseClicked

    //radio button orden de compra anulada
    private void anuladoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_anuladoMouseClicked
        LlenarTablaOrdenC("Anulada");
    }//GEN-LAST:event_anuladoMouseClicked

    ///////////////////////////////////////EVENTOS//////////////////////////////////////////
    
    //Eventos Ordenes de Compra//
    //radio button orden de compra aprobada
    private void aprobadaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aprobadaMouseClicked
        LlenarTablaOrdenC("Aprobada");
    }//GEN-LAST:event_aprobadaMouseClicked

    //Boton para Editar los datos de Ordenes de Compra
    private void EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarActionPerformed
        if (fila>-1) {
            codOrdenCompra=Integer.parseInt(String.valueOf(jTable1.getValueAt(fila, 0)));
            folio.setText(String.valueOf(jTable1.getValueAt(fila, 1)));
            fecha.setText(String.valueOf(jTable1.getValueAt(fila, 2)));
            sswitch=1;
            PanelOrdenesCompra.setSelectedIndex(1);
        } else {
            JOptionPane.showMessageDialog(this, "DEBE SELECCIONAR UNA FILA","ADVERTENCIA",JOptionPane.OK_OPTION+JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_EditarActionPerformed

    //boton para ir a agregar nuevas ordenes de compra y/o libros en ordenes de compra
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        sswitch=0;
        PanelOrdenesCompra.setSelectedIndex(1);
        folio.grabFocus();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ListaLibrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListaLibrosActionPerformed
        FRM_Distribuidores frmd =new FRM_Distribuidores();
        Principal.PanelDesktop.add(frmd);
        Principal.centrar(frmd);
    }//GEN-LAST:event_ListaLibrosActionPerformed

    private void ActualizarLibrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualizarLibrosActionPerformed
        ComboDistFact();
    }//GEN-LAST:event_ActualizarLibrosActionPerformed

    private void ListaLibros1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListaLibros1ActionPerformed
        FRM_Distribuidores frmd =new FRM_Distribuidores();
        Principal.PanelDesktop.add(frmd);
        Principal.centrar(frmd);
    }//GEN-LAST:event_ListaLibros1ActionPerformed

    private void ActualizarLibros1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualizarLibros1ActionPerformed
        ComboDistribuidores();
    }//GEN-LAST:event_ActualizarLibros1ActionPerformed

    private void ListaEditorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListaEditorialActionPerformed
        FRM_Editorial frme=new FRM_Editorial();
        Principal.PanelDesktop.add(frme);
        Principal.centrar(frme);
    }//GEN-LAST:event_ListaEditorialActionPerformed

    private void ActualizarEditorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualizarEditorialActionPerformed
        ComboEditorialLibro();
    }//GEN-LAST:event_ActualizarEditorialActionPerformed

    private void ListaNacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListaNacActionPerformed
        FRM_Nacionalidad frmn=new FRM_Nacionalidad();
        Principal.PanelDesktop.add(frmn);
        Principal.centrar(frmn);
    }//GEN-LAST:event_ListaNacActionPerformed

    private void ActualizarComboNacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualizarComboNacActionPerformed
        ComboNacionPaisAutor();
    }//GEN-LAST:event_ActualizarComboNacActionPerformed

    private void BTNCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNCategoriasActionPerformed
        FRM_Categorias frmc=new FRM_Categorias();
        Principal.PanelDesktop.add(frmc);
        Principal.centrar(frmc);
    }//GEN-LAST:event_BTNCategoriasActionPerformed

    private void BTNIdiomasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNIdiomasActionPerformed
        FRM_Idiomas frmi=new FRM_Idiomas();
        Principal.PanelDesktop.add(frmi);
        Principal.centrar(frmi);
    }//GEN-LAST:event_BTNIdiomasActionPerformed

    private void BTNIdiomas1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNIdiomas1ActionPerformed
        FRM_AutorLibro frmal=new FRM_AutorLibro();
        Principal.PanelDesktop.add(frmal);
        Principal.centrar(frmal);
    }//GEN-LAST:event_BTNIdiomas1ActionPerformed

    private void BTNOrdenLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNOrdenLibroActionPerformed
        FRM_OrdenLibros frmol=new FRM_OrdenLibros();
        Principal.PanelDesktop.add(frmol);
        Principal.centrar(frmol);
    }//GEN-LAST:event_BTNOrdenLibroActionPerformed

    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ActualizarComboNac;
    private javax.swing.JButton ActualizarEditorial;
    private javax.swing.JButton ActualizarLibros;
    private javax.swing.JButton ActualizarLibros1;
    private javax.swing.JButton AgregarAutor;
    private javax.swing.JButton AgregarFacturas;
    private javax.swing.JButton AgregarLibros;
    private javax.swing.JTextField AppMAutor;
    private javax.swing.JTextField AppPAutor;
    private javax.swing.JButton BTNCategorias;
    private javax.swing.JButton BTNIdiomas;
    private javax.swing.JButton BTNIdiomas1;
    private javax.swing.JButton BTNOrdenLibro;
    private javax.swing.JButton BorrarCompras;
    private javax.swing.JTextField BuscadorAutor;
    private javax.swing.JTextField BuscadorLibros;
    private javax.swing.JComboBox CEstadoL;
    private javax.swing.JComboBox CPNac;
    private javax.swing.JComboBox Cdist;
    private javax.swing.JComboBox CdistFact;
    private javax.swing.JComboBox CeditorialL;
    private javax.swing.JComboBox Cestado;
    private javax.swing.JComboBox Cmetod;
    private javax.swing.JComboBox ComboFecha;
    private javax.swing.JComboBox CordenC;
    private javax.swing.JComboBox Ctraba;
    private javax.swing.JButton Editar;
    private javax.swing.JButton EditarAutor;
    private javax.swing.JButton EditarCompras;
    private javax.swing.JButton EditarFacturas;
    private javax.swing.JButton EditarLibros;
    private javax.swing.JButton Eliminar;
    private javax.swing.JButton EliminarAutor;
    private javax.swing.JButton EliminarFacturas;
    private javax.swing.JButton EliminarLibros;
    private javax.swing.ButtonGroup EstadoLibros;
    private javax.swing.JFormattedTextField FechaIngreso;
    private javax.swing.JButton G;
    private javax.swing.JButton Guardar;
    private javax.swing.JButton GuardarAutor;
    private javax.swing.JButton GuardarFact;
    private javax.swing.JButton GuardarLibros;
    private javax.swing.JTextField Isbn1;
    private javax.swing.JButton ListaEditorial;
    private javax.swing.JButton ListaLibros;
    private javax.swing.JButton ListaLibros1;
    private javax.swing.JButton ListaNac;
    private javax.swing.JTextField NombreAutor;
    private javax.swing.JTabbedPane PanelFacturas;
    private javax.swing.JTabbedPane PanelLibros;
    private javax.swing.JTabbedPane PanelOrdenesCompra;
    private javax.swing.JTextField Precio;
    private javax.swing.JTextField PseuAutor;
    private javax.swing.JLabel RegistroAutor;
    private javax.swing.JLabel RegistroFact;
    private javax.swing.JLabel RegistrosLibros;
    private javax.swing.JRadioButton anulado;
    private javax.swing.JRadioButton aprobada;
    private javax.swing.JRadioButton btnArrendado;
    private javax.swing.JRadioButton btnEnCompra;
    private javax.swing.JRadioButton btnStock;
    private javax.swing.JRadioButton btnVendido;
    private javax.swing.JTextField buscador;
    private javax.swing.JTextField buscadorCompras;
    private javax.swing.JTextField buscarFacturas;
    private javax.swing.JTextField comen1;
    private javax.swing.ButtonGroup estadosOrdenC;
    private javax.swing.JFormattedTextField fecha;
    private javax.swing.JTextField folio;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator11;
    private javax.swing.JToolBar.Separator jSeparator12;
    private javax.swing.JToolBar.Separator jSeparator13;
    private javax.swing.JToolBar.Separator jSeparator14;
    private javax.swing.JToolBar.Separator jSeparator15;
    private javax.swing.JSeparator jSeparator16;
    private javax.swing.JToolBar.Separator jSeparator17;
    private javax.swing.JToolBar.Separator jSeparator18;
    private javax.swing.JSeparator jSeparator19;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JSeparator jSeparator20;
    private javax.swing.JSeparator jSeparator22;
    private javax.swing.JSeparator jSeparator23;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator36;
    private javax.swing.JToolBar.Separator jSeparator37;
    private javax.swing.JToolBar.Separator jSeparator38;
    private javax.swing.JToolBar.Separator jSeparator39;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator40;
    private javax.swing.JToolBar.Separator jSeparator41;
    private javax.swing.JToolBar.Separator jSeparator42;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JToolBar.Separator jSeparator51;
    private javax.swing.JToolBar.Separator jSeparator52;
    private javax.swing.JToolBar.Separator jSeparator53;
    private javax.swing.JToolBar.Separator jSeparator54;
    private javax.swing.JToolBar.Separator jSeparator55;
    private javax.swing.JToolBar.Separator jSeparator56;
    private javax.swing.JToolBar.Separator jSeparator57;
    private javax.swing.JToolBar.Separator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JToolBar.Separator jSeparator9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable7;
    private javax.swing.JTable jTable9;
    private javax.swing.JToolBar jToolBar10;
    private javax.swing.JToolBar jToolBar12;
    private javax.swing.JToolBar jToolBar14;
    private javax.swing.JToolBar jToolBar15;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JToolBar jToolBar3;
    private javax.swing.JToolBar jToolBar4;
    private javax.swing.JToolBar jToolBar6;
    private javax.swing.JTextField paginas;
    private javax.swing.JTextField precio;
    private javax.swing.JRadioButton proceso;
    private javax.swing.JLabel registros;
    private javax.swing.JTextField titulo;
    // End of variables declaration//GEN-END:variables
}
