package datos;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import View.Admin;

public class AdminJugadores extends JFrame {

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
		Stringjugador.setText(null);
		Stringposicion.setText(null);
		Intga.setText(null);
	}
	private JTextField Stringposicion;
	private JTextField Intga;
	private JTextField Stringpais;
	private JTextField Stringjugador;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminJugadores frame = new AdminJugadores();
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
	public AdminJugadores() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 677, 480);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 5, 68)); 
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		setTitle("Mantenimiento de Jugadores");
        setLocationRelativeTo(null);
        setResizable(false);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mantenimientos Jugadores");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(39, 24, 299, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Codigo de jugador:");
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
							.prepareStatement("SELECT  * FROM JUGADORES WHERE CODIGO = ?");
					ps.setString(1, Intcodigo.getText());
					rs = ps.executeQuery();
					
					if (rs.next()) {
						Stringjugador.setText(rs.getString("JUGADOR"));
						Stringpais.setText(rs.getString("PAIS"));
						Stringposicion.setText(rs.getString("POSICION"));
						Intga.setText(rs.getString("GA"));
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
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conexion = Conexion.conectar();
				try {
					ps = conexion
							.prepareStatement("UPDATE PARTIDOS SET GOLES_A = ?, GOLES_B = ? WHERE CODIGO = ?");
					ps.setString(1, Intga.getText());
					ps.setString(2, Intcodigo.getText());
					
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
		btnActualizar.setBounds(75, 342, 85, 21);
		contentPane.add(btnActualizar);
		
		JButton btnMostrar = new JButton("Mostrar");
		btnMostrar.setBounds(299, 342, 85, 21);
		contentPane.add(btnMostrar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin ini = new Admin();
				ini.setVisible(true);
				dispose();
			}
		});
		btnSalir.setBounds(522, 342, 85, 21);
		contentPane.add(btnSalir);
		
		JLabel lblNewLabel_4 = new JLabel("Posición:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4.setBounds(39, 194, 70, 13);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Goles Anotados:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5.setBounds(39, 235, 135, 13);
		contentPane.add(lblNewLabel_5);
		
		Stringposicion = new JTextField();
		Stringposicion.setBounds(221, 193, 96, 19);
		contentPane.add(Stringposicion);
		Stringposicion.setColumns(10);
		
		Intga = new JTextField();
		Intga.setBounds(221, 234, 96, 19);
		contentPane.add(Intga);
		Intga.setColumns(10);
		
		JLabel lblNewLabel_12 = new JLabel("");
		lblNewLabel_12.setIcon(new ImageIcon(AdminEquipos.class.getResource("/images/156.png")));
		lblNewLabel_12.setBounds(505, 10, 127, 83);
		contentPane.add(lblNewLabel_12);
		
		JLabel lblNewLabel_2 = new JLabel("Pais:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(39, 160, 55, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Jugador:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(39, 121, 70, 19);
		contentPane.add(lblNewLabel_3);
		
		Stringpais = new JTextField();
		Stringpais.setBounds(221, 157, 96, 19);
		contentPane.add(Stringpais);
		Stringpais.setColumns(10);
		
		Stringjugador = new JTextField();
		Stringjugador.setBounds(221, 115, 96, 19);
		contentPane.add(Stringjugador);
		Stringjugador.setColumns(10);
		
		
	}

}
