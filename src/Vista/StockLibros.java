/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Control_Libros;
import Modelo.Categoria2;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mark-
 */
public class StockLibros extends javax.swing.JInternalFrame {
    DefaultTableModel tabla=new DefaultTableModel();
    Control_Libros crl=new Control_Libros();
    
    
    public void StockDeLibros(String dato){
    tabla.setColumnCount(0);
        tabla.addColumn("Titulo");
        tabla.addColumn("N° de Paginas");
        tabla.addColumn("Precio $");
        tabla.addColumn("Editorial");
        tabla.addColumn("Nombre / Pseudonimo Autor");
        tabla.addColumn("Idioma");
        tabla.addColumn("Categoria");
        tabla.addColumn("Stock Disponible");
        List<Categoria2> lista=crl.ListarLibrosClientes(dato);
        tabla.setNumRows(lista.size());
        CantTotal.setText("Total de Libros en Stock= "+lista.size());
        for (int i = 0; i < lista.size(); i++) {
            tabla.setValueAt(lista.get(i).getTitulo_libro(), i, 0);
            tabla.setValueAt(lista.get(i).getPag_libro(), i, 1);
            tabla.setValueAt(lista.get(i).getPrecio_libro(), i, 2);
            tabla.setValueAt(lista.get(i).getNom_edit(), i, 3);
            tabla.setValueAt(lista.get(i).getNom_autor()+" / "+ lista.get(i).getPseu_autor(), i, 4);
            tabla.setValueAt(lista.get(i).getNom_idioma(), i, 5);
            tabla.setValueAt(lista.get(i).getNom_cate(), i, 6);
            tabla.setValueAt(lista.get(i).getStock(), i, 7);
            
            TablaLibros.setModel(tabla);
        }
        
    } 
    public StockLibros() {
        initComponents();
        StockDeLibros("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar12 = new javax.swing.JToolBar();
        CantTotal = new javax.swing.JLabel();
        jToolBar10 = new javax.swing.JToolBar();
        jSeparator36 = new javax.swing.JToolBar.Separator();
        jSeparator37 = new javax.swing.JToolBar.Separator();
        jLabel40 = new javax.swing.JLabel();
        jSeparator38 = new javax.swing.JToolBar.Separator();
        jSeparator41 = new javax.swing.JToolBar.Separator();
        BuscadorLibros = new javax.swing.JTextField();
        jSeparator42 = new javax.swing.JToolBar.Separator();
        jScrollPane9 = new javax.swing.JScrollPane();
        TablaLibros = new javax.swing.JTable();

        setBackground(new java.awt.Color(102, 102, 102));

        jToolBar12.setBackground(new java.awt.Color(204, 204, 204));
        jToolBar12.setFloatable(false);
        jToolBar12.setForeground(new java.awt.Color(204, 204, 204));
        jToolBar12.setRollover(true);

        CantTotal.setForeground(new java.awt.Color(0, 0, 0));
        CantTotal.setText("jLabel5");
        jToolBar12.add(CantTotal);

        getContentPane().add(jToolBar12, java.awt.BorderLayout.PAGE_START);

        jToolBar10.setBackground(new java.awt.Color(204, 204, 204));
        jToolBar10.setFloatable(false);
        jToolBar10.setRollover(true);
        jToolBar10.add(jSeparator36);
        jToolBar10.add(jSeparator37);

        jLabel40.setText("                                                                                                          ");
        jToolBar10.add(jLabel40);
        jToolBar10.add(jSeparator38);
        jToolBar10.add(jSeparator41);

        BuscadorLibros.setBackground(new java.awt.Color(70, 110, 196));
        BuscadorLibros.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
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

        getContentPane().add(jToolBar10, java.awt.BorderLayout.PAGE_END);

        TablaLibros.setBackground(new java.awt.Color(204, 204, 204));
        TablaLibros.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        TablaLibros.setForeground(new java.awt.Color(0, 0, 0));
        TablaLibros.setModel(new javax.swing.table.DefaultTableModel(
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
        TablaLibros.setRowHeight(25);
        jScrollPane9.setViewportView(TablaLibros);

        getContentPane().add(jScrollPane9, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BuscadorLibrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BuscadorLibrosMouseClicked
        BuscadorLibros.setText("");
    }//GEN-LAST:event_BuscadorLibrosMouseClicked

    private void BuscadorLibrosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BuscadorLibrosKeyTyped
        StockDeLibros(BuscadorLibros.getText());
    }//GEN-LAST:event_BuscadorLibrosKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField BuscadorLibros;
    private javax.swing.JLabel CantTotal;
    private javax.swing.JTable TablaLibros;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JToolBar.Separator jSeparator36;
    private javax.swing.JToolBar.Separator jSeparator37;
    private javax.swing.JToolBar.Separator jSeparator38;
    private javax.swing.JToolBar.Separator jSeparator41;
    private javax.swing.JToolBar.Separator jSeparator42;
    private javax.swing.JToolBar jToolBar10;
    private javax.swing.JToolBar jToolBar12;
    // End of variables declaration//GEN-END:variables
}