package View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import datos.AdminPartidos;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField passwordFieldContraseña;

	/**
	 * Launch the application.
	 */
	
	

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 616, 415);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 0, 76));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setTitle("Login");
		setLocationRelativeTo(null);
		setResizable(false);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(134, 176, 333, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		passwordFieldContraseña = new JPasswordField();
		passwordFieldContraseña.setBounds(134, 262, 333, 20);
		contentPane.add(passwordFieldContraseña);
		
		JLabel lblContraseña = new JLabel("Ingresé su contraseña");
		lblContraseña.setForeground(Color.WHITE);
		lblContraseña.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblContraseña.setBounds(134, 237, 333, 14);
		contentPane.add(lblContraseña);
		
		JLabel lblUsuario = new JLabel("Ingresé su usuario");
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblUsuario.setBounds(134, 151, 333, 14);
		contentPane.add(lblUsuario);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setBackground(Color.WHITE);
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Roboto", Font.PLAIN, 22));
		lblLogin.setBounds(134, 61, 333, 47);
		contentPane.add(lblLogin);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin ini = new Admin();
				ini.setVisible(true);
				dispose();
			}
		});
		btnIngresar.setBounds(261, 322, 89, 23);
		contentPane.add(btnIngresar);
		
		JButton btnRetroceder = new JButton("Inicio");
		btnRetroceder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inicio ini = new Inicio();
				ini.setVisible(true);
				dispose();
			}
		});
		btnRetroceder.setBounds(10, 11, 89, 23);
		contentPane.add(btnRetroceder);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(Login.class.getResource("/images/156.png")));
		lblLogo.setBounds(473, 11, 117, 55);
		contentPane.add(lblLogo);
		
		JButton btnsalir = new JButton("Salir");
		btnsalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(EXIT_ON_CLOSE);
			}
		});
		btnsalir.setBounds(505, 347, 85, 21);
		contentPane.add(btnsalir);
	}
}