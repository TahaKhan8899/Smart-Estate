package smart_estate;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.TextArea;

public class Window {

	private JFrame frame;
	private JTextField txtIncome;
	private JTextField txtState;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window window = new Window();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// create frame
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		// create income text field
		txtIncome = new JTextField();
		txtIncome.setText("income");
		txtIncome.setBounds(157, 40, 130, 26);
		frame.getContentPane().add(txtIncome);
		txtIncome.setColumns(10);
		
		TextArea txtNieghbours = new TextArea();
		txtNieghbours.setEditable(false);
		txtNieghbours.setBounds(6, 141, 434, 129);
		frame.getContentPane().add(txtNieghbours);

		// create buy button
		JButton btnBuy = new JButton("Housing Price");
		btnBuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// buy action
				String in = txtIncome.getText();
				String out = buttonBestState(in, fieldT.housing_price);
		
				txtNieghbours.setText(null);
				String out2 = nieghbours(BreadthFirstSearch.neighbourStates(out));
				System.out.println(out2);
				txtNieghbours.setText(out2);
				txtState.setText(out);
			}
		});
		btnBuy.setBounds(6, 63, 117, 29);
		frame.getContentPane().add(btnBuy);

		// create sell button
		JButton btnSell = new JButton("Crime Rate");
		btnSell.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// sell action
				String in = txtIncome.getText();
				String out = buttonBestState(in, fieldT.crime_rate);
				txtState.setText(out);
				
				String out2 = nieghbours(BreadthFirstSearch.neighbourStates(out));
				txtNieghbours.setText(out2);
				txtState.setText(out);
			}
		});
		btnSell.setBounds(119, 63, 117, 29);
		frame.getContentPane().add(btnSell);

		// create invest button
		JButton btnInvest = new JButton("HPI");
		btnInvest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// invest action
				String in = txtIncome.getText();
				String out = buttonBestState(in, fieldT.hpi);
				txtState.setText(out);
				
				txtNieghbours.setText("");
				String out2 = nieghbours(BreadthFirstSearch.neighbourStates(out));
				txtNieghbours.setText(out2);
				txtState.setText(out);
			}
		});
		btnInvest.setBounds(237, 63, 117, 29);
		frame.getContentPane().add(btnInvest);

		// create income label
		JLabel lblEnterAnnualIncome = new JLabel("Enter Annual Income:");
		lblEnterAnnualIncome.setBounds(6, 45, 151, 16);
		frame.getContentPane().add(lblEnterAnnualIncome);

		// create output state text field
		txtState = new JTextField();
		txtState.setEditable(false);
		txtState.setText("state");
		txtState.setBounds(92, 87, 130, 26);
		frame.getContentPane().add(txtState);
		txtState.setColumns(10);

		// create best state label
		JLabel lblBestState = new JLabel("Best State:");
		lblBestState.setBounds(16, 92, 97, 16);
		frame.getContentPane().add(lblBestState);
		
		// create instruction label
		JLabel lblInstructions = new JLabel("intructional blurb");
		lblInstructions.setBounds(6, 17, 422, 16);
		frame.getContentPane().add(lblInstructions);
		
		// create nieghbours label
		JLabel lblNieghbours = new JLabel("Nieghbouring States:");
		lblNieghbours.setBounds(6, 119, 143, 16);
		frame.getContentPane().add(lblNieghbours);
		
		
	}

	// general action button
	private String buttonBestState(String in, fieldT field) {
		// init state info
		StateInfo[] states = new StateInfo[50];
		states = PopulateStateInfo.populateStateInfo();

		if (checkIncome(in)) { // if input is numeric
			double income = Double.parseDouble(in); // convert input
			// main action goes here
			return binSearch.binSearch(states, field, income).getState();
		} else {
			return "Error";
		}

	}

	// function to check if income is numeric
	private boolean checkIncome(String in) {
		try {
			Double.parseDouble(in);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
	// function to string nieghbour states
	private String nieghbours(StateInfo[] states) {
		String out = "";
		for (StateInfo st : states) {
			out = out + st.toString() + "\n";
		}
		return out;
	}
}
