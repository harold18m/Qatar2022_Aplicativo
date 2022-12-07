package View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.EventQueue;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class Inicio extends JFrame {

	private JPanel contentPane;
	
	


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	
	public Inicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 616, 415);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setTitle("Inicio");
		setLocationRelativeTo(null);
		setResizable(false);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnIniciarSesion = new JButton("Iniciar Sesión");
		btnIniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login log = new Login();
				log.setVisible(true);
				dispose();
			}
		});
		btnIniciarSesion.setBounds(470, 11, 120, 23);
		contentPane.add(btnIniciarSesion);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Invitados inv = new Invitados();
				inv.setVisible(true);
				dispose();
			}
		});
		btnIngresar.setBounds(154, 342, 328, 23);
		contentPane.add(btnIngresar);
		
		JLabel lblIcono = new JLabel("");
		lblIcono.setHorizontalAlignment(SwingConstants.CENTER);
		lblIcono.setIcon(new ImageIcon(Inicio.class.getResource("/images/descarga.jpg")));
		lblIcono.setBounds(154, 45, 328, 275);
		contentPane.add(lblIcono);
		
		
		JButton btnsalir = new JButton("Salir");
		btnsalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(EXIT_ON_CLOSE);
			}
		});
		btnsalir.setBounds(492, 64, 85, 21);
		contentPane.add(btnsalir);
	}
}
