
package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.Color;

public class Posiciones extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Posiciones frame = new Posiciones();
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
	public Posiciones() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 616, 415);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Posiciones");
		setLocationRelativeTo(null);
		setResizable(false);
		
		JButton btnNewButton = new JButton("Regresar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Invitados inv = new Invitados();
				inv.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(10, 11, 89, 23);
		contentPane.add(btnNewButton);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Roboto", Font.PLAIN, 12));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Seleccione el grupo", "Grupo A", "Grupo B", "Grupo C", "Grupo D", "Grupo E", "Grupo F", "Grupo G", "Grupo H"}));
		comboBox.setBounds(31, 180, 163, 29);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Tabla de posiciones");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Roboto", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setLabelFor(this);
		lblNewLabel.setBounds(138, 11, 346, 36);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(221, 122, 369, 137);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Pais", "PJ", "PG","PE","PP","GF","GC", "DG", "PTS"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class,String.class, String.class, String.class,String.class,String.class,String.class,String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Posiciones.class.getResource("/images/fondo2.png")));
		lblNewLabel_1.setBounds(0, 0, 600, 376);
		contentPane.add(lblNewLabel_1);
	}

}