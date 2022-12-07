package View;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import datos.AdminPartidos;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class Invitados extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Invitados frame = new Invitados();
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
	public Invitados() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 616, 415);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 5, 68));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setTitle("Invitado");
		setLocationRelativeTo(null);
		setResizable(false);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Fechas de partidos");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Partidos par = new Partidos();
				par.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(23, 143, 213, 44);
		contentPane.add(btnNewButton);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(Login.class.getResource("/images/156.png")));
		lblLogo.setBounds(470, 11, 120, 59);
		contentPane.add(lblLogo);
		
		JButton btnPaises = new JButton("Tabla de posiciones");
		btnPaises.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Posiciones pos = new Posiciones();
				pos.setVisible(true);
				dispose();
			}
		});
		btnPaises.setBounds(344, 143, 213, 44);
		contentPane.add(btnPaises);
		
		JButton btnJugadores = new JButton("Jugadores");
		btnJugadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Jugadores jug = new Jugadores();
				jug.setVisible(true);
				dispose();
			}
		});
		btnJugadores.setBounds(23, 321, 213, 44);
		contentPane.add(btnJugadores);
		
		JButton btnEstadisticas = new JButton("Estadisticas");
		btnEstadisticas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Estadisticas est = new Estadisticas();
				est.setVisible(true);
				dispose();
			}
		});
		btnEstadisticas.setBounds(344, 321, 213, 44);
		contentPane.add(btnEstadisticas);
		
		JButton btnNewButton_1 = new JButton("Regresar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inicio ini = new Inicio();
				ini.setVisible(true);
				dispose();
			}
			
		});
		btnNewButton_1.setBounds(10, 11, 103, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Invitados.class.getResource("/images/fondo1.png")));
		lblNewLabel.setBounds(-42, 0, 556, 365);
		contentPane.add(lblNewLabel);
	}

}