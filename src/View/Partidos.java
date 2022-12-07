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

public class Partidos extends JFrame {
	
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


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Partidos frame = new Partidos();
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
	public Partidos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 793, 498);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("VISTA FECHAS");
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
		
		JButton btnMostrar1 = new JButton("Fecha 1");
		btnMostrar1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String []  nombresColumnas = {"GRUPO", "FECHA", "HORA", "ESTADIO", "EQUIPO_A", "GOLES_A", "GOLES_B", "EQUIPO_B"};
                String [] datos = new String [8];
                DefaultTableModel model = new DefaultTableModel(null,nombresColumnas);

                table.setModel(model);
                String sql ="SELECT * FROM FECHA_1";
                PreparedStatement ps = null;
                Connection con = null;
                ResultSet rs = null;
                   try {
                       con = getConection();
                    ps =con.prepareStatement(sql);
                    rs = ps.executeQuery();
                    while(rs.next())
                    {
                        datos[0]=rs.getString("GRUPO");
                        datos[1]=rs.getString("FECHA");
                        datos[2]=rs.getString("HORA");
                        datos[3]=rs.getString("ESTADIO");
                        datos[4]=rs.getString("EQUIPO_A");
                        datos[5]=rs.getString("GOLES_A");
                        datos[6]=rs.getString("GOLES_B");
                        datos[7]=rs.getString("EQUIPO_B");
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
		btnMostrar1.setBounds(20, 388, 85, 21);
		contentPane.add(btnMostrar1);
		
		JButton btnFecha2 = new JButton("Fecha 2");
		btnFecha2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String []  nombresColumnas = {"GRUPO", "FECHA", "HORA", "ESTADIO", "EQUIPO_A", "GOLES_A", "GOLES_B", "EQUIPO_B"};
                String [] datos = new String [8];
                DefaultTableModel model = new DefaultTableModel(null,nombresColumnas);

                table.setModel(model);
                String sql ="SELECT * FROM FECHA_2";
                PreparedStatement ps = null;
                Connection con = null;
                ResultSet rs = null;
                   try {
                       con = getConection();
                    ps =con.prepareStatement(sql);
                    rs = ps.executeQuery();
                    while(rs.next())
                    {
                        datos[0]=rs.getString("GRUPO");
                        datos[1]=rs.getString("FECHA");
                        datos[2]=rs.getString("HORA");
                        datos[3]=rs.getString("ESTADIO");
                        datos[4]=rs.getString("EQUIPO_A");
                        datos[5]=rs.getString("GOLES_A");
                        datos[6]=rs.getString("GOLES_B");
                        datos[7]=rs.getString("EQUIPO_B");
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
		btnFecha2.setBounds(190, 388, 85, 21);
		contentPane.add(btnFecha2);
		
		JButton btnMostrar3 = new JButton("Fecha 3");
		btnMostrar3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String []  nombresColumnas = {"GRUPO", "FECHA", "HORA", "ESTADIO", "EQUIPO_A", "GOLES_A", "GOLES_B", "EQUIPO_B"};
                String [] datos = new String [8];
                DefaultTableModel model = new DefaultTableModel(null,nombresColumnas);

                table.setModel(model);
                String sql ="SELECT * FROM FECHA_2";
                PreparedStatement ps = null;
                Connection con = null;
                ResultSet rs = null;
                   try {
                       con = getConection();
                    ps =con.prepareStatement(sql);
                    rs = ps.executeQuery();
                    while(rs.next())
                    {
                        datos[0]=rs.getString("GRUPO");
                        datos[1]=rs.getString("FECHA");
                        datos[2]=rs.getString("HORA");
                        datos[3]=rs.getString("ESTADIO");
                        datos[4]=rs.getString("EQUIPO_A");
                        datos[5]=rs.getString("GOLES_A");
                        datos[6]=rs.getString("GOLES_B");
                        datos[7]=rs.getString("EQUIPO_B");
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
		btnMostrar3.setBounds(335, 388, 85, 21);
		contentPane.add(btnMostrar3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 64, 759, 289);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"GRUPO", "FECHA", "HORA", "ESTADIO", "EQUIPO_A", "GOLES_A", "GOLES_B", "EQUIPO_B"
			}
		));
		scrollPane.setViewportView(table);
		
		
		
		
		
		
		
		
		
		
		
	
		
		
		
	}
}