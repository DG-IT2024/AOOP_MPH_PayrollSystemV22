import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;

public class CSVReader extends JFrame {

	private JTable table;

	/**
	 * Set up the main frame
	 */
	public CSVReader() {
		setTitle("CSV Reader");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);

		// Create a table model with no data yet
		DefaultTableModel model = new DefaultTableModel();
		table = new JTable(model);

		// Set the font for the table cells
		Font tableFont = new Font("Arial", Font.PLAIN, 30);
		table.setFont(tableFont);

		table.setRowHeight(30);

		// Set the font for the table header
		table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 30));

		// Create a scroll pane to hold the table
		JScrollPane scrollPane = new JScrollPane(table);

		// Create a button to open the file chooser
		JButton btnOpen = new JButton("Open CSV File");

		// Set the font for the button
		Font buttonFont = new Font("Arial", Font.BOLD, 30);
		btnOpen.setFont(buttonFont);

		// Add an action listener to the button
		btnOpen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				openFileChooser();// Call method to open file chooser
			}
		});

		// Create a panel to hold the button
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(btnOpen);

		// Create a panel to hold the button and add some padding
		JPanel topPanel = new JPanel(new BorderLayout());
		topPanel.add(buttonPanel, BorderLayout.NORTH);
		topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		// Add the components to the frame
		add(topPanel, BorderLayout.NORTH);
		add(scrollPane, BorderLayout.CENTER);

		// Enable sorting for the table
		TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
		table.setRowSorter(sorter);

		// set the frame visible
		setVisible(true);

	}

	private void openFileChooser() {
		// Create a file chooser dialog
		JFileChooser fileChooser = new JFileChooser();
		FileFilter fileFilter = new FileNameExtensionFilter("CSV Files", "csv");
		fileChooser.setFileFilter(fileFilter);

		// Show the file chooser dialog
		int result = fileChooser.showOpenDialog(this);

		// Check if the user selected a file
		if (result == JFileChooser.APPROVE_OPTION) {
			// User selected a file
			String selectedFilePath = fileChooser.getSelectedFile().getAbsolutePath();

			// Read CSV file and populate the table
			readCSVFile(selectedFilePath);
		}
	}

	/**
	 * Method to read data from a CSV file and populate the table
	 * 
	 * @param selectedFilePath
	 */
	private void readCSVFile(String selectedFilePath) {
		clearTable();
		try (BufferedReader reader = new BufferedReader(new FileReader(selectedFilePath))) {
			// Read the header line to get column names
			String headerLine = reader.readLine();
			String[] columns = headerLine.split(",");// Example: Name,Age,Gender,Country

			// Set the column in the table model
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.setColumnIdentifiers(columns);

			// Read data lines and add to the table model
			String line;
			while ((line = reader.readLine()) != null) {
				String[] data = line.split(",");
				model.addRow(data);
			}

		} catch (IOException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "Error reading CSV file:" + e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	/**
	 * Method to clear the table
	 */
	private void clearTable() {
		//Clear all columns in the table
		TableColumnModel tableColumnModel=  (TableColumnModel) table.getColumnModel();
		while(tableColumnModel.getColumnCount()!=0) {
			TableColumn tb=tableColumnModel.getColumn(0);
			tableColumnModel.removeColumn(tb);
		}
		//Clear all rows in the table
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		for(int i=table.getRowCount()-1;i>=0;i--) {
			model.removeRow(i);
		}
		table.setModel(model);
	}

	public static void main(String[] args) {
		// Launch the application
		SwingUtilities.invokeLater(() -> new CSVReader());

	}

}
