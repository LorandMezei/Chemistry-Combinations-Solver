package combinations;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

public final class Frame extends JFrame implements ActionListener, TableModelListener{
	
	private static final Object[] TABLE_COLUMN_NAMES = new Object[]{"Component", "Weight", "Charge", "Use", "Sort", "Force", "Min", "Max"};

	private static final int TEXTFIELD_SIZE = 20;
	
	private static JFrame FRAME;
	private static JPanel MAIN_PANEL;
	private static JPanel PANEL_1;
	private static JPanel PANEL_2;
	private static JPanel PANEL_3;
	private static JTable COMPONENTS_TABLE;
	private static JScrollPane COMPONENTS_TABLE_SCROLL_PANE;
	private static JButton CALCULATE_BUTTON;
	private static JButton POPULATE_BUTTON;
	private static JButton SAVE_VALUES_BUTTON;
	private static JRadioButton PROFILE_1_BUTTON;
	private static JRadioButton PROFILE_2_BUTTON;
	private static JRadioButton PROFILE_3_BUTTON;
	private static JRadioButton PROFILE_4_BUTTON;
	private static JRadioButton PROFILE_5_BUTTON;
	private static JLabel SELECT_PROFILE_LABEL;
	private static JLabel CLEAR_TABLE_VALUES_LABEL;
	private static JLabel POPULATE_BUTTON_LABEL;
	private static JLabel FILE_LOAD_LABEL;
	private static JLabel USE_ALL_LABEL;
	private static JLabel TARGET_LABEL;
	private static JLabel RANGE_LABEL;
	private static JLabel CHARGE_LABEL;
	private static JLabel FILE_SAVE_LABEL;
	private static JCheckBox CLEAR_TABLE_VALUES_CHECKBOX;
	private static JCheckBox USE_ALL_CHECKBOX;
	private static JTextField FILE_LOAD_TEXTFIELD;
	private static JTextField TARGET_TEXTFIELD;
	private static JTextField RANGE_TEXTFIELD;
	private static JTextField CHARGE_TEXTFIELD;
	private static JTextField FILE_SAVE_TEXTFIELD;
		
	Frame() {
		this.prepareSelectProfiles();
		this.prepareProfileButtons();
		this.prepareFileLoad();
		this.prepareClearTableValues();
		this.preparePopulate();
		this.prepareSaveValues();
	    this.prepareComponentsTable();
        this.prepareUseAll();
        this.prepareTarget();
        this.prepareRange();
        this.prepareCharge();
        this.prepareFileSave();
        this.prepareCalculate();
        this.preparePanel1();
        this.preparePanel2();
        this.preparePanel3();
        this.prepareMainPanel();
        this.prepareFrame();
	}
	
	public static void main(String[] args) {    
        new Frame();
	}
	
	public void tableChanged(TableModelEvent e) {}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == POPULATE_BUTTON) {
			DataPopulator.populate();
		
		} else if (e.getSource() == SAVE_VALUES_BUTTON) {
			try {
				DataPopulator.saveTableModel();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
		} else if (e.getSource() == CALCULATE_BUTTON
				&& COMPONENTS_TABLE != null) {
			
			final long startTime = System.currentTimeMillis();
			
			final ArrayList<ArrayList<String>> listOfSolutionsList = CombinationsCalculator.calculate();
			
			final long endTime = System.currentTimeMillis();
			final long totalTime = endTime - startTime;
			System.out.println("Calculation took about " + (totalTime / 1000) + " seconds. Took exactly " + (totalTime) + " milliseconds." + "\n");
			
			if (listOfSolutionsList != null) {
				try {
					FilePrinter.createFiles(listOfSolutionsList);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			
			JOptionPane.showMessageDialog(this, "Combi-Nano by Lorand Mezei has finished running!");		}
	}
	
	private void prepareFrame() {
		FRAME = new JFrame("Combi-Nano by Lorand Mezei");
	    FRAME.add(MAIN_PANEL);
	    FRAME.setSize(1920, 1080);
	    FRAME.show();
	}
	
	private void prepareMainPanel() {
		MAIN_PANEL = new JPanel(); 
        MAIN_PANEL.add(PANEL_1);
        MAIN_PANEL.add(PANEL_2);
        MAIN_PANEL.add(PANEL_3);
	}
	
	private void preparePanel1() {
		PANEL_1 = new JPanel(new GridLayout(2, 0, 0, 0));   
		
		final JPanel profilePanel = new JPanel(new GridLayout(4, 1, 0, 0)); 
		BoxLayout radiobuttonpanellayout = new BoxLayout(profilePanel, BoxLayout.X_AXIS);
		profilePanel.setLayout(radiobuttonpanellayout);
		profilePanel.add(SELECT_PROFILE_LABEL);
		profilePanel.add(PROFILE_1_BUTTON);
		profilePanel.add(PROFILE_2_BUTTON);
		profilePanel.add(PROFILE_3_BUTTON);
		profilePanel.add(PROFILE_4_BUTTON);
		profilePanel.add(PROFILE_5_BUTTON);
		profilePanel.add(SAVE_VALUES_BUTTON);
		
		final JPanel populatePanel = new JPanel(new GridLayout(4, 1, 0, 0)); 
		populatePanel.add(CLEAR_TABLE_VALUES_LABEL);
		populatePanel.add(CLEAR_TABLE_VALUES_CHECKBOX);
		populatePanel.add(FILE_SAVE_LABEL);
        populatePanel.add(FILE_SAVE_TEXTFIELD);
        populatePanel.add(FILE_LOAD_LABEL);
        populatePanel.add(FILE_LOAD_TEXTFIELD);
        populatePanel.add(POPULATE_BUTTON_LABEL);
        populatePanel.add(POPULATE_BUTTON);
		
		PANEL_1.add(profilePanel);
		PANEL_1.add(populatePanel);
	}
	
	private void preparePanel2() {
		PANEL_2 = new JPanel();    
        PANEL_2.add(COMPONENTS_TABLE_SCROLL_PANE);
	}
	
	private void preparePanel3() {
		PANEL_3 = new JPanel(new GridLayout(12, 1, 0, 0));
        PANEL_3.add(USE_ALL_LABEL);
        PANEL_3.add(USE_ALL_CHECKBOX);
        PANEL_3.add(TARGET_LABEL);
        PANEL_3.add(TARGET_TEXTFIELD);
        PANEL_3.add(RANGE_LABEL);
        PANEL_3.add(RANGE_TEXTFIELD);
        PANEL_3.add(CHARGE_LABEL);
        PANEL_3.add(CHARGE_TEXTFIELD);
        PANEL_3.add(CALCULATE_BUTTON);
	}
			    		
	private void prepareProfileButtons() {
		PROFILE_1_BUTTON = new JRadioButton("1");
		PROFILE_1_BUTTON.setHorizontalAlignment(SwingConstants.CENTER);
		PROFILE_2_BUTTON = new JRadioButton("2");
		PROFILE_2_BUTTON.setHorizontalAlignment(SwingConstants.CENTER);
		PROFILE_3_BUTTON = new JRadioButton("3");
		PROFILE_3_BUTTON.setHorizontalAlignment(SwingConstants.CENTER);
		PROFILE_4_BUTTON = new JRadioButton("4");
		PROFILE_4_BUTTON.setHorizontalAlignment(SwingConstants.CENTER);
		PROFILE_5_BUTTON = new JRadioButton("5");
		PROFILE_5_BUTTON.setHorizontalAlignment(SwingConstants.CENTER);
		
		final ButtonGroup bgroup = new ButtonGroup();
		bgroup.add(PROFILE_1_BUTTON);
		bgroup.add(PROFILE_2_BUTTON);
		bgroup.add(PROFILE_3_BUTTON);
		bgroup.add(PROFILE_4_BUTTON);
		bgroup.add(PROFILE_5_BUTTON);
	}
	
	private void prepareSelectProfiles() {
		SELECT_PROFILE_LABEL = new JLabel("Select Profile (Default if none selected): ");
	}
	
	private void prepareFileLoad() {
		FILE_LOAD_LABEL = new JLabel("Components File Path (Optional): ");
		FILE_LOAD_TEXTFIELD = new JTextField(TEXTFIELD_SIZE);
	}
	
	private void prepareClearTableValues() {
		CLEAR_TABLE_VALUES_LABEL = new JLabel("Clear Values (Optional): ");
		CLEAR_TABLE_VALUES_CHECKBOX = new JCheckBox();
	}
	
	private void preparePopulate() {
		POPULATE_BUTTON_LABEL = new JLabel("Must press Populate before anything: ");
		POPULATE_BUTTON = new JButton("Populate");
	    POPULATE_BUTTON.setBounds(200, 100, 100, 50);
	    POPULATE_BUTTON.addActionListener(this);
	}
	
	private void prepareSaveValues() {
		SAVE_VALUES_BUTTON = new JButton("Save Values to Profile");
        SAVE_VALUES_BUTTON.setBounds(200, 100, 100, 50);
        SAVE_VALUES_BUTTON.addActionListener(this);
	}
	
	private void prepareComponentsTable() {
		COMPONENTS_TABLE_SCROLL_PANE = new JScrollPane(new JTable(new DefaultTableModel(TABLE_COLUMN_NAMES, 0)));
		COMPONENTS_TABLE_SCROLL_PANE.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        COMPONENTS_TABLE_SCROLL_PANE.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	}
	
	private void prepareUseAll() {
		USE_ALL_LABEL = new JLabel("Force All Components (Optional): ");
        USE_ALL_CHECKBOX = new JCheckBox();
	}
	
	private void prepareTarget() {
		TARGET_LABEL = new JLabel("Target Sum: ");
        TARGET_TEXTFIELD = new JTextField(TEXTFIELD_SIZE);
	}
	
	private void prepareRange() {
		RANGE_LABEL = new JLabel("Target Sum Range (+-): ");
        RANGE_TEXTFIELD = new JTextField(TEXTFIELD_SIZE);
	}
	
	private void prepareCharge() {
		CHARGE_LABEL = new JLabel("Target Charge: ");
		CHARGE_TEXTFIELD = new JTextField(TEXTFIELD_SIZE);
	}
	
	private void prepareFileSave() {
		FILE_SAVE_LABEL = new JLabel("File Path To Save (Optional): ");
        FILE_SAVE_TEXTFIELD = new JTextField(TEXTFIELD_SIZE);
	}
	
	private void prepareCalculate() {
		CALCULATE_BUTTON = new JButton("Calculate");
        CALCULATE_BUTTON.setBounds(200, 100, 100, 50);
        CALCULATE_BUTTON.addActionListener(this);
	}
	
	public static Object[] getTableColumnNames() {
		return TABLE_COLUMN_NAMES;
	}

	public static int getTextfieldSize() {
		return TEXTFIELD_SIZE;
	}

	public static JFrame getFrame() {
		return FRAME;
	}

	public static JPanel getMainPanel() {
		return MAIN_PANEL;
	}

	public static JPanel getPanel1() {
		return PANEL_1;
	}

	public static JPanel getPanel2() {
		return PANEL_2;
	}

	public static JPanel getPanel3() {
		return PANEL_3;
	}

	public static JTable getComponentsTable() {
		return COMPONENTS_TABLE;
	}

	public static JRadioButton getProfile1Button() {
		return PROFILE_1_BUTTON;
	}

	public static JRadioButton getProfile2Button() {
		return PROFILE_2_BUTTON;
	}

	public static JRadioButton getProfile3Button() {
		return PROFILE_3_BUTTON;
	}

	public static JRadioButton getProfile4Button() {
		return PROFILE_4_BUTTON;
	}

	public static JRadioButton getProfile5Button() {
		return PROFILE_5_BUTTON;
	}

	public static JLabel getSelectProfileLabel() {
		return SELECT_PROFILE_LABEL;
	}

	public static JLabel getClearTableValuesLabel() {
		return CLEAR_TABLE_VALUES_LABEL;
	}

	public static JLabel getPopulateButtonLabel() {
		return POPULATE_BUTTON_LABEL;
	}

	public static JLabel getFileLoadLabel() {
		return FILE_LOAD_LABEL;
	}

	public static JLabel getUseAllLabel() {
		return USE_ALL_LABEL;
	}

	public static JLabel getTargetLabel() {
		return TARGET_LABEL;
	}

	public static JLabel getRangeLabel() {
		return RANGE_LABEL;
	}

	public static JLabel getChargeLabel() {
		return CHARGE_LABEL;
	}

	public static JLabel getFileSaveLabel() {
		return FILE_SAVE_LABEL;
	}

	public static JCheckBox getClearTableValuesCheckbox() {
		return CLEAR_TABLE_VALUES_CHECKBOX;
	}

	public static JCheckBox getUseAllCheckBox() {
		return USE_ALL_CHECKBOX;
	}

	public static JTextField getFileLoadTextField() {
		return FILE_LOAD_TEXTFIELD;
	}

	public static JTextField getTargetTextField() {
		return TARGET_TEXTFIELD;
	}

	public static JTextField getRangeTextField() {
		return RANGE_TEXTFIELD;
	}

	public static JTextField getChargeTextField() {
		return CHARGE_TEXTFIELD;
	}

	public static JTextField getFileSaveTextField() {
		return FILE_SAVE_TEXTFIELD;
	}

	public static JButton getCalculateButton() {
		return CALCULATE_BUTTON;
	}

	public static JButton getPopulateButton() {
		return POPULATE_BUTTON;
	}

	public static JButton getSaveValuesButton() {
		return SAVE_VALUES_BUTTON;
	}

	public static JScrollPane getComponentsTableScrollPane() {
		return COMPONENTS_TABLE_SCROLL_PANE;
	}
	
	// !!!!!!!!!!!!!!! I USED THE GENERATE SETTERS FUNCTION. THAT IS WHY THE NAMES ARE MESSED UP.
	
	public static void setFRAME(JFrame fRAME) {
		FRAME = fRAME;
	}

	public static void setMAIN_PANEL(JPanel mAIN_PANEL) {
		MAIN_PANEL = mAIN_PANEL;
	}

	public static void setPANEL_1(JPanel pANEL_1) {
		PANEL_1 = pANEL_1;
	}

	public static void setPANEL_2(JPanel pANEL_2) {
		PANEL_2 = pANEL_2;
	}

	public static void setPANEL_3(JPanel pANEL_3) {
		PANEL_3 = pANEL_3;
	}

	public static void setCOMPONENTS_TABLE(JTable cOMPONENTS_TABLE) {
		COMPONENTS_TABLE = cOMPONENTS_TABLE;
	}

	public static void setCOMPONENTS_TABLE_SCROLL_PANE(JScrollPane cOMPONENTS_TABLE_SCROLL_PANE) {
		COMPONENTS_TABLE_SCROLL_PANE = cOMPONENTS_TABLE_SCROLL_PANE;
	}

	public static void setCALCULATE_BUTTON(JButton cALCULATE_BUTTON) {
		CALCULATE_BUTTON = cALCULATE_BUTTON;
	}

	public static void setPOPULATE_BUTTON(JButton pOPULATE_BUTTON) {
		POPULATE_BUTTON = pOPULATE_BUTTON;
	}

	public static void setSAVE_VALUES_BUTTON(JButton sAVE_VALUES_BUTTON) {
		SAVE_VALUES_BUTTON = sAVE_VALUES_BUTTON;
	}

	public static void setPROFILE_1_BUTTON(JRadioButton pROFILE_1_BUTTON) {
		PROFILE_1_BUTTON = pROFILE_1_BUTTON;
	}

	public static void setPROFILE_2_BUTTON(JRadioButton pROFILE_2_BUTTON) {
		PROFILE_2_BUTTON = pROFILE_2_BUTTON;
	}

	public static void setPROFILE_3_BUTTON(JRadioButton pROFILE_3_BUTTON) {
		PROFILE_3_BUTTON = pROFILE_3_BUTTON;
	}

	public static void setPROFILE_4_BUTTON(JRadioButton pROFILE_4_BUTTON) {
		PROFILE_4_BUTTON = pROFILE_4_BUTTON;
	}

	public static void setPROFILE_5_BUTTON(JRadioButton pROFILE_5_BUTTON) {
		PROFILE_5_BUTTON = pROFILE_5_BUTTON;
	}

	public static void setSELECT_PROFILE_LABEL(JLabel sELECT_PROFILE_LABEL) {
		SELECT_PROFILE_LABEL = sELECT_PROFILE_LABEL;
	}

	public static void setCLEAR_TABLE_VALUES_LABEL(JLabel cLEAR_TABLE_VALUES_LABEL) {
		CLEAR_TABLE_VALUES_LABEL = cLEAR_TABLE_VALUES_LABEL;
	}

	public static void setPOPULATE_BUTTON_LABEL(JLabel pOPULATE_BUTTON_LABEL) {
		POPULATE_BUTTON_LABEL = pOPULATE_BUTTON_LABEL;
	}

	public static void setFILE_LOAD_LABEL(JLabel fILE_LOAD_LABEL) {
		FILE_LOAD_LABEL = fILE_LOAD_LABEL;
	}

	public static void setUSE_ALL_LABEL(JLabel uSE_ALL_LABEL) {
		USE_ALL_LABEL = uSE_ALL_LABEL;
	}

	public static void setTARGET_LABEL(JLabel tARGET_LABEL) {
		TARGET_LABEL = tARGET_LABEL;
	}

	public static void setRANGE_LABEL(JLabel rANGE_LABEL) {
		RANGE_LABEL = rANGE_LABEL;
	}

	public static void setCHARGE_LABEL(JLabel cHARGE_LABEL) {
		CHARGE_LABEL = cHARGE_LABEL;
	}

	public static void setFILE_SAVE_LABEL(JLabel fILE_SAVE_LABEL) {
		FILE_SAVE_LABEL = fILE_SAVE_LABEL;
	}

	public static void setCLEAR_TABLE_VALUES_CHECKBOX(JCheckBox cLEAR_TABLE_VALUES_CHECKBOX) {
		CLEAR_TABLE_VALUES_CHECKBOX = cLEAR_TABLE_VALUES_CHECKBOX;
	}

	public static void setUSE_ALL_CHECKBOX(JCheckBox uSE_ALL_CHECKBOX) {
		USE_ALL_CHECKBOX = uSE_ALL_CHECKBOX;
	}

	public static void setFILE_LOAD_TEXTFIELD(JTextField fILE_LOAD_TEXTFIELD) {
		FILE_LOAD_TEXTFIELD = fILE_LOAD_TEXTFIELD;
	}

	public static void setTARGET_TEXTFIELD(JTextField tARGET_TEXTFIELD) {
		TARGET_TEXTFIELD = tARGET_TEXTFIELD;
	}

	public static void setRANGE_TEXTFIELD(JTextField rANGE_TEXTFIELD) {
		RANGE_TEXTFIELD = rANGE_TEXTFIELD;
	}

	public static void setCHARGE_TEXTFIELD(JTextField cHARGE_TEXTFIELD) {
		CHARGE_TEXTFIELD = cHARGE_TEXTFIELD;
	}

	public static void setFILE_SAVE_TEXTFIELD(JTextField fILE_SAVE_TEXTFIELD) {
		FILE_SAVE_TEXTFIELD = fILE_SAVE_TEXTFIELD;
	}
}
