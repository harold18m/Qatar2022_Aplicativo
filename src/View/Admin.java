package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import datos.AdminEquipos;
import datos.AdminJugadores;
import datos.AdminPartidos;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Panel;

public class Admin extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin frame = new Admin();
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
	public Admin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 616, 415);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setTitle("Administrador");
		setLocationRelativeTo(null);
		setResizable(false);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Jugadores");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminJugadores ini = new AdminJugadores();
				ini.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(429, 227, 121, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Equipos");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminEquipos ini = new AdminEquipos();
				ini.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(60, 227, 121, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Regresar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inicio ini = new Inicio();
				ini.setVisible(true);
				dispose();
			}
			
		});
		btnNewButton_2.setBounds(10, 11, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Partidos");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminPartidos ini = new AdminPartidos();
				ini.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setBounds(253, 227, 121, 23);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel = new JLabel("Mantenimiento");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Roboto Light", Font.BOLD, 30));
		lblNewLabel.setBounds(123, 11, 378, 37);
		contentPane.add(lblNewLabel);
		
		
		
		Panel panel = new Panel();
		panel.setBounds(10, 69, 580, 50);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Seleccione la opcion que desea realizar mantenimiento");
		lblNewLabel_2.setBounds(10, 0, 541, 52);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setBackground(new Color(255, 255, 255));
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setFont(new Font("Roboto Light", Font.ITALIC, 18));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Admin.class.getResource("/images/donde-queda-qatar1.png")));
		lblNewLabel_1.setBounds(0, 0, 600, 376);
		contentPane.add(lblNewLabel_1);
		
	}
}