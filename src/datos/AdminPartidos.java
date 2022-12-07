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

public class AdminPartidos extends JFrame {

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
		Stringfecha.setText(null);
		Stringgrupo.setText(null);
		Stringhora.setText(null);
		Stringestadio.setText(null);
		StringequipA.setText(null);
		IntgolA.setText(null);
		IntgolB.setText(null);
		StringequipB.setText(null);
	}
	private JTextField Stringhora;
	private JTextField Stringestadio;
	private JTextField StringequipA;
	private JTextField IntgolA;
	private JTextField IntgolB;
	private JTextField StringequipB;
	private JTextField Stringfecha;
	private JTextField Stringgrupo;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPartidos frame = new AdminPartidos();
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
	public AdminPartidos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 677, 480);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 5, 68)); 
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mantenimiento Partidos");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(39, 24, 265, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Codigo de partido:");
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
							.prepareStatement("SELECT  * FROM PARTIDOS WHERE CODIGO = ?");
					ps.setString(1, Intcodigo.getText());
					rs = ps.executeQuery();
					
					if (rs.next()) {
						Stringgrupo.setText(rs.getString("GRUPO"));
						Stringfecha.setText(rs.getString("FECHA"));
						Stringhora.setText(rs.getString("HORA"));
						Stringestadio.setText(rs.getString("ESTADIO"));
						StringequipA.setText(rs.getString("EQUIPO_A"));
						IntgolA.setText(rs.getString("GOLES_A"));
						IntgolB.setText(rs.getString("GOLES_B"));
						StringequipB.setText(rs.getString("EQUIPO_B"));
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
					ps.setString(1, IntgolA.getText());
					ps.setString(2, IntgolB.getText());
					ps.setString(3, Intcodigo.getText());
					
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
		
		JLabel lblNewLabel_4 = new JLabel("Hora:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4.setBounds(39, 194, 45, 13);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Estadio:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5.setBounds(39, 235, 70, 13);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_7 = new JLabel("Equipo A:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_7.setBounds(384, 121, 74, 13);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Goles Eq A:");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_8.setBounds(384, 160, 96, 13);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Goles Eq B:");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_9.setBounds(384, 194, 96, 13);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_11 = new JLabel("Equipo B:");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_11.setBounds(384, 235, 74, 13);
		contentPane.add(lblNewLabel_11);
		
		Stringhora = new JTextField();
		Stringhora.setBounds(221, 193, 96, 19);
		contentPane.add(Stringhora);
		Stringhora.setColumns(10);
		
		Stringestadio = new JTextField();
		Stringestadio.setBounds(221, 234, 96, 19);
		contentPane.add(Stringestadio);
		Stringestadio.setColumns(10);
		
		StringequipA = new JTextField();
		StringequipA.setBounds(485, 115, 96, 19);
		contentPane.add(StringequipA);
		StringequipA.setColumns(10);
		
		IntgolA = new JTextField();
		IntgolA.setBounds(485, 157, 96, 19);
		contentPane.add(IntgolA);
		IntgolA.setColumns(10);
		
		IntgolB = new JTextField();
		IntgolB.setBounds(485, 191, 96, 19);
		contentPane.add(IntgolB);
		IntgolB.setColumns(10);
		
		StringequipB = new JTextField();
		StringequipB.setBounds(485, 232, 96, 19);
		contentPane.add(StringequipB);
		StringequipB.setColumns(10);
		
		JLabel lblNewLabel_12 = new JLabel("");
		lblNewLabel_12.setIcon(new ImageIcon(AdminEquipos.class.getResource("/images/156.png")));
		lblNewLabel_12.setBounds(505, 10, 127, 83);
		contentPane.add(lblNewLabel_12);
		
		JLabel lblNewLabel_2 = new JLabel("Fecha:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(39, 160, 55, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Grupo:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(39, 121, 55, 13);
		contentPane.add(lblNewLabel_3);
		
		Stringfecha = new JTextField();
		Stringfecha.setBounds(221, 157, 96, 19);
		contentPane.add(Stringfecha);
		Stringfecha.setColumns(10);
		
		Stringgrupo = new JTextField();
		Stringgrupo.setBounds(221, 115, 96, 19);
		contentPane.add(Stringgrupo);
		Stringgrupo.setColumns(10);
		
		
	}

}
