package datos;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import View.Admin;
import View.Inicio;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class AdminEquipos extends JFrame {

	private JPanel contentPane;
	private JTextField Intcodigo;

	/**
	 * Launch the application.
	 */
	
	Connection conexion = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	private void limpiarCuadrosDeTexto() {
		Intcodigo.setText(null);
		Stringpais.setText(null);
		Stringgrupo.setText(null);
		Intpj.setText(null);
		Intpg.setText(null);
		Intpe.setText(null);
		Intpp.setText(null);
		Intgf.setText(null);
		Intgc.setText(null);
		Intdg.setText(null);
		Intpuntos.setText(null);
	}
	private JTextField Intpj;
	private JTextField Intpg;
	private JTextField Intpe;
	private JTextField Intpp;
	private JTextField Intgf;
	private JTextField Intgc;
	private JTextField Intdg;
	private JTextField Intpuntos;
	private JTextField Stringpais;
	private JTextField Stringgrupo;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminEquipos frame = new AdminEquipos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AdminEquipos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 677, 480);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 5, 68)); 
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		setTitle("Mantenimiento de Equipos");
        setLocationRelativeTo(null);
        setResizable(false);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mantenimiento Equipos");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(39, 24, 265, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Codigo de equipo:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(39, 65, 149, 25);
		contentPane.add(lblNewLabel_1);
		
		Intcodigo = new JTextField();
		Intcodigo.setBounds(221, 70, 96, 19);
		contentPane.add(Intcodigo);
		Intcodigo.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conexion = Conexion.conectar();
				try {
					ps = conexion
							.prepareStatement("SELECT  * FROM EQUIPOS WHERE CODIGO = ?");
					ps.setString(1, Intcodigo.getText());
					rs = ps.executeQuery();
					
					if (rs.next()) {
						Stringpais.setText(rs.getString("PAIS"));
						Stringgrupo.setText(rs.getString("GRUPO"));
						Intpj.setText(rs.getString("PJ"));
						Intpg.setText(rs.getString("PG"));
						Intpe.setText(rs.getString("PE"));
						Intpp.setText(rs.getString("PP"));
						Intgf.setText(rs.getString("GF"));
						Intgc.setText(rs.getString("GC"));
						Intdg.setText(rs.getString("DG"));
						Intpuntos.setText(rs.getString("PTS"));
					}else {
						JOptionPane.showMessageDialog(null, "Codigo de equipo no encontrado");
					}
					conexion.close();
				}catch(SQLException e1){
					JOptionPane.showMessageDialog(null, "Ocurrió un problema al acceder a la base de datos!");
				}
			}	
		});
		btnBuscar.setBounds(369, 69, 85, 21);
		contentPane.add(btnBuscar);
		
		JButton btnagregar = new JButton("Agregar");
		btnagregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conexion = Conexion.conectar();
				try {
					ps = conexion
							.prepareStatement("INSERT INTO EQUIPOS VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
					ps.setString(1, Intcodigo.getText());
					ps.setString(2, Stringpais.getText());
					ps.setString(3, Stringgrupo.getText());
					ps.setString(4, Intpj.getText());
					ps.setString(5, Intpg.getText());
					ps.setString(6, Intpe.getText());
					ps.setString(7, Intpp.getText());
					ps.setString(8, Intgf.getText());
					ps.setString(9, Intgc.getText());
					ps.setString(10, Intdg.getText());
					ps.setString(11, Intpuntos.getText());
					
					int resultado = ps.executeUpdate();
					if(resultado > 0) {
						JOptionPane.showMessageDialog(null, "Registro agregado correctamente!");
						limpiarCuadrosDeTexto();
						conexion.close();
					}else {
						JOptionPane.showMessageDialog(null, "No se pudo agregar el registro!");
						
					}
				}
				catch(SQLException e1){
					JOptionPane.showMessageDialog(null, "Ocurrió un error al acceder a la base de datos");
				}
			}
		});
		btnagregar.setBounds(36, 342, 85, 21);
		contentPane.add(btnagregar);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conexion = Conexion.conectar();
				try {
					ps = conexion
							.prepareStatement("UPDATE EQUIPOS SET PJ = ?, PG = ?, PE = ?, PP = ?,"
									+ "GF = ?, GC = ?, DG = ?, PTS = ? WHERE CODIGO = ?");
					ps.setString(1, Intpj.getText());
					ps.setString(2, Intpg.getText());
					ps.setString(3, Intpe.getText());
					ps.setString(4, Intpp.getText());
					ps.setString(5, Intgf.getText());
					ps.setString(6, Intgc.getText());
					ps.setString(7, Intdg.getText());
					ps.setString(8, Intpuntos.getText());
					ps.setString(9, Intcodigo.getText());
					
					int resultado = ps.executeUpdate();
					if(resultado > 0) {
						JOptionPane.showMessageDialog(null, "Registro modificado correctamente!");
						limpiarCuadrosDeTexto();
						conexion.close();
					}else {
						JOptionPane.showMessageDialog(null, "No se pudo actualizar el registro!");
						
					}
				}
				catch(SQLException e1){
					JOptionPane.showMessageDialog(null, "Ocurrió un error al acceder a la base de datos");
				}
			}
		});
		btnActualizar.setBounds(196, 342, 85, 21);
		contentPane.add(btnActualizar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conexion = Conexion.conectar();
				try {
					ps = conexion
							.prepareStatement("DELETE FROM EQUIPOS WHERE CODIGO = ?");
					
					ps.setString(1, Intcodigo.getText());
					
					int resultado = ps.executeUpdate();
					if(resultado > 0) {
						JOptionPane.showMessageDialog(null, "Registro eliminado correctamente!");
						limpiarCuadrosDeTexto();
						conexion.close();
					}else {
						JOptionPane.showMessageDialog(null, "No se pudo eliminar el registro!");
						
					}
				}
				catch(SQLException e1){
					JOptionPane.showMessageDialog(null, "Ocurrió un error al acceder a la base de datos");
				}
			}
		});
		btnEliminar.setBounds(369, 342, 85, 21);
		contentPane.add(btnEliminar);
		
		JButton btnMostrar = new JButton("Mostrar");
		btnMostrar.setBounds(533, 342, 85, 21);
		contentPane.add(btnMostrar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin ini = new Admin();
				ini.setVisible(true);
				dispose();
			}
		});
		btnSalir.setBounds(533, 390, 85, 21);
		contentPane.add(btnSalir);
		
		JLabel lblNewLabel_4 = new JLabel("PJ:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4.setBounds(39, 194, 45, 13);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("PG:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5.setBounds(39, 235, 45, 13);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("PE:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_6.setBounds(39, 274, 45, 13);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("PP:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_7.setBounds(384, 121, 45, 13);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("GF:");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_8.setBounds(384, 160, 45, 13);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("GC:");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_9.setBounds(384, 194, 45, 13);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("PUNTOS:");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_10.setBounds(384, 274, 70, 13);
		contentPane.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("DG:");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_11.setBounds(384, 235, 45, 13);
		contentPane.add(lblNewLabel_11);
		
		Intpj = new JTextField();
		Intpj.setBounds(221, 193, 96, 19);
		contentPane.add(Intpj);
		Intpj.setColumns(10);
		
		Intpg = new JTextField();
		Intpg.setBounds(221, 234, 96, 19);
		contentPane.add(Intpg);
		Intpg.setColumns(10);
		
		Intpe = new JTextField();
		Intpe.setBounds(221, 273, 96, 19);
		contentPane.add(Intpe);
		Intpe.setColumns(10);
		
		Intpp = new JTextField();
		Intpp.setBounds(485, 115, 96, 19);
		contentPane.add(Intpp);
		Intpp.setColumns(10);
		
		Intgf = new JTextField();
		Intgf.setBounds(485, 157, 96, 19);
		contentPane.add(Intgf);
		Intgf.setColumns(10);
		
		Intgc = new JTextField();
		Intgc.setBounds(485, 191, 96, 19);
		contentPane.add(Intgc);
		Intgc.setColumns(10);
		
		Intdg = new JTextField();
		Intdg.setBounds(485, 232, 96, 19);
		contentPane.add(Intdg);
		Intdg.setColumns(10);
		
		Intpuntos = new JTextField();
		Intpuntos.setBounds(485, 271, 96, 19);
		contentPane.add(Intpuntos);
		Intpuntos.setColumns(10);
		
		JLabel lblNewLabel_12 = new JLabel("");
		lblNewLabel_12.setIcon(new ImageIcon(AdminEquipos.class.getResource("/images/156.png")));
		lblNewLabel_12.setBounds(505, 10, 127, 83);
		contentPane.add(lblNewLabel_12);
		
		JLabel lblNewLabel_2 = new JLabel("Pais:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(39, 121, 45, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Grupo:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(39, 162, 55, 13);
		contentPane.add(lblNewLabel_3);
		
		Stringpais = new JTextField();
		Stringpais.setBounds(221, 115, 96, 19);
		contentPane.add(Stringpais);
		Stringpais.setColumns(10);
		
		Stringgrupo = new JTextField();
		Stringgrupo.setBounds(221, 159, 96, 19);
		contentPane.add(Stringgrupo);
		Stringgrupo.setColumns(10);
		
		
	}
}
