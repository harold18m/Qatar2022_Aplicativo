package View;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Tabla extends JFrame {

    private JTable tabla = null;
    DefaultTableModel modelo = null;
    JScrollPane desplazamiento = null;

    public Tabla() {
        String[] columnas = {"Columna 0", "Columna 1", "Columna 2", "Columna 3"};
        tabla = new JTable();
        modelo = new DefaultTableModel();
        desplazamiento = new JScrollPane(tabla);       

        // Parametros de la ventana
        this.setTitle("JTable");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        // Modelo de la tabla
        modelo.setColumnIdentifiers(columnas);

        // Barras de desplazamiento
        desplazamiento.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        desplazamiento.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        // Propiedades de la tabla
        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tabla.setFillsViewportHeight(true);

        tabla.setModel(modelo);

        // Agregamos datos
        this.agregarDatos(modelo);
        
        
        // Agregando elementos a la ventana
        this.getContentPane().add(desplazamiento, BorderLayout.NORTH);
        this.pack();
    }
    
    private void agregarDatos(DefaultTableModel modelo) {
        // Borramos todas las filas en la tabla
        modelo.setRowCount(0);
        
        // Creamos los datos de una fila de la tabla
        Object[] datosFila = {"Datos 0,0", "Datos 0,1", "Datos 0,2", "Datos 0,3"};
        
        // agregamos esos datos
        modelo.addRow(datosFila);
        
        // Agregamos MUCHOS mas datos
        for(int x=0; x < 500; x++) {
            datosFila[0] = "Datos " + x + ", 0";
            datosFila[1] =  "Datos " + x + ", 1";
            datosFila[2] = "Datos " + x + ", 2";
            datosFila[3] = "Datos " + x + ", 3";
            
            modelo.addRow(datosFila);
        }
    }
    
    static public void main(String[] args) {
        Tabla tabla = new Tabla();
        
        tabla.setLocationRelativeTo(null);
        tabla.setVisible(true);
        
    }
}
