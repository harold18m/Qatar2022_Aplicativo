package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Jugadores extends JFrame {
	
	public static final String URL = "jdbc:mysql://localhost:3306/qatar_2022?useSSL=false";
	public static final String USER= "root";
	public static final String PASSWORD = "";
	private JTable table;
	
	public static Connection getConection() {
		Connection con =null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = (Connection) DriverManager.getConnection(URL, USER, PASSWORD);
			JOptionPane.showMessageDialog(null, "Conectado");
		}catch(Exception e) {
			System.out.println(e);
		}
		return con;}

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Jugadores frame = new Jugadores();
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
	public Jugadores() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 616, 415);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("JUGADORES");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 15));
		lblNewLabel.setBounds(88, 18, 264, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnRegresar = new JButton("<");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Invitados Usu = new Invitados();
                Usu.setVisible(true);
                dispose();
			}
		});
		btnRegresar.setBounds(10, 9, 50, 23);
		contentPane.add(btnRegresar);
		
		JButton btnEstadisticas = new JButton("Mostrar");
		btnEstadisticas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String []  nombresColumnas = {"CODIGO", "JUGADOR","PAIS", "POSICION", "GA"};
                String [] datos = new String [8];
                DefaultTableModel model = new DefaultTableModel(null,nombresColumnas);

                table.setModel(model);
                String sql ="SELECT * FROM JUGADORES";
                PreparedStatement ps = null;
                Connection con = null;
                ResultSet rs = null;
                   try {
                       con = getConection();
                    ps =con.prepareStatement(sql);
                    rs = ps.executeQuery();
                    while(rs.next())
                    {
                        datos[0]=rs.getString("CODIGO");
                        datos[1]=rs.getString("JUGADOR");
                        datos[2]=rs.getString("PAIS");
                        datos[3]=rs.getString("POSICION");
                        datos[4]=rs.getString("GA");
                       model.addRow(datos);
                    }
                }catch(SQLException e2) {
                JOptionPane.showMessageDialog(null, "error");
                }
                   finally {
                       try {
                           if (rs!= null) rs.close();
                           if (ps!= null) ps.close();
                           if (con!= null) con.close();


                       }catch(SQLException e2)
                       {
                           JOptionPane.showMessageDialog(null, e);
                       }
                   }
                   return;
			}
		});
		btnEstadisticas.setBounds(434, 17, 85, 21);
		contentPane.add(btnEstadisticas);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 64, 570, 287);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"CODIGO", "JUGADOR","PAIS", "POSICION", "GA"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Jugadores.class.getResource("/images/donde-queda-qatar1.png")));
		lblNewLabel_1.setBounds(0, 0, 602, 378);
		contentPane.add(lblNewLabel_1);
	}
}
