package Doctor.Views;

import Admin.model.IViewer;
import Doctor.Model.Doctor;
import Doctor.Model.Drug;
import Doctor.Model.PatientSlot;
import Doctor.Controller.AddDrugController;

import javax.swing.*;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.border.MatteBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.table.AbstractTableModel;

public class myPatientsDrugPanelView extends JPanel implements ActionListener, IViewer {
    private String[] drugNameArray;
    private JTextField dose;

    private DatePickerPanel dataPickerStart;

    private DatePickerPanel dataPickerEnd;
    private JTable table;
    private JScrollPane scrollPane;
    private ButtonGroup hungryButtonGroup;

    private JComboBox drugComboBox;
    private JCheckBox isEvening;
    private JCheckBox isAfternoon;
    private JCheckBox isMorning;
    private String patient_username;
    private PatientSlot patientSlot;
    private MyPatientsLayeredPanelView layeredPanelView;
    private final MyTableModel dataModel;


    public JTextField getDose() {
        return dose;
    }

    public ButtonGroup getHungryButtonGroup() {
        return hungryButtonGroup;
    }

    public DatePickerPanel getDataPickerStart() {
        return dataPickerStart;
    }

    public DatePickerPanel getDataPickerEnd() {
        return dataPickerEnd;
    }

    public JComboBox getDrugComboBox() {
        return drugComboBox;
    }

    public JCheckBox getIsEvening() {
        return isEvening;
    }

    public JCheckBox getIsAfternoon() {
        return isAfternoon;
    }

    public JCheckBox getIsMorning() {
        return isMorning;
    }

    public String getPatient_username() {
        return patient_username;
    }

    /**
     * Create the panel.
     */
    public myPatientsDrugPanelView(PatientSlot patientSlot, Doctor doctor, MyPatientsLayeredPanelView layeredPanelView) {
        this.layeredPanelView = layeredPanelView;
        patient_username = patientSlot.getPatientInfo().getUsername();
        this.patientSlot = patientSlot;
        BorderLayout borderLayout = new BorderLayout();
        borderLayout.setVgap(5);
        setLayout(borderLayout);


        JPanel centerPanel = new JPanel();
        add(centerPanel, BorderLayout.CENTER);
        centerPanel.setLayout(new GridLayout(2, 1, 0, 5));


        JPanel inputPanel = new JPanel();
        centerPanel.add(inputPanel);
        inputPanel.setLayout(new GridLayout(0, 3, 5, 15));


        JPanel drugInputPanel = new JPanel();
        inputPanel.add(drugInputPanel);
        drugInputPanel.setLayout(new GridLayout(3, 0, 10, 15));

        JPanel drugNamePanel = new JPanel();
        drugNamePanel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        drugInputPanel.add(drugNamePanel);

        JLabel drugLabel = new JLabel("Drug Name:");
        drugLabel.setFont(new Font("Century", Font.PLAIN, 15));
        drugNamePanel.add(drugLabel);

        //Most common prescriptions. Will be added to the drug choices.
        drugNameArray = new String[]{"Vicodin", "Amoxil", "Lipitor", "Motrin", "Synthroid", "Delasone"};

        drugComboBox = new JComboBox(drugNameArray);
        drugComboBox.setFont(new Font("Century", Font.PLAIN, 13));
        drugNamePanel.add(drugComboBox);

        JPanel dosePanel = new JPanel();
        dosePanel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        drugInputPanel.add(dosePanel);

        JLabel enterDoseLabel = new JLabel("Enter Doses:");
        enterDoseLabel.setFont(new Font("Century", Font.PLAIN, 15));
        dosePanel.add(enterDoseLabel);

        dose = new JTextField();
        dosePanel.add(dose);
        dose.setColumns(10);

        JPanel panel = new JPanel();
        panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        drugInputPanel.add(panel);
        panel.setLayout(new GridLayout(0, 2, 0, 0));

        JPanel statusPanel = new JPanel();
        panel.add(statusPanel);

        JLabel lblNewLabel = new JLabel("Hungry/Full");
        lblNewLabel.setFont(new Font("Century", Font.PLAIN, 15));
        statusPanel.add(lblNewLabel);

        JPanel choicePanel = new JPanel();
        panel.add(choicePanel);
        choicePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        //Hungry Full radiobuttons.
        JRadioButton hungryButton = new JRadioButton("Hungry");
        choicePanel.add(hungryButton);
        hungryButton.setActionCommand("Hungry");

        JRadioButton fullButton = new JRadioButton("Full");
        choicePanel.add(fullButton);
        fullButton.setActionCommand("Full");

        hungryButtonGroup = new ButtonGroup();
        hungryButtonGroup.add(fullButton);
        hungryButtonGroup.add(hungryButton);
        hungryButton.setSelected(true);

        JPanel schedulePanel = new JPanel();
        schedulePanel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        inputPanel.add(schedulePanel);
        schedulePanel.setLayout(new BorderLayout(12, 0));

        JPanel scheduleLabelHolderPanel = new JPanel();
        schedulePanel.add(scheduleLabelHolderPanel, BorderLayout.NORTH);

        JLabel scheduleLabel = new JLabel("Daily Schedule:");
        scheduleLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        scheduleLabelHolderPanel.add(scheduleLabel);

        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.CYAN));
        schedulePanel.add(panel_1);
        panel_1.setLayout(new GridLayout(3, 2, 0, 0));

        JPanel morningHolderPanel = new JPanel();
        morningHolderPanel.setBorder(new EmptyBorder(0, 5, 0, 5));
        panel_1.add(morningHolderPanel);

        isMorning = new JCheckBox("Morning");
        morningHolderPanel.add(isMorning);

        JPanel anoonHolderPanel = new JPanel();
        panel_1.add(anoonHolderPanel);

        isAfternoon = new JCheckBox("Afternoon");
        anoonHolderPanel.add(isAfternoon);

        JPanel eveningHolderPanel = new JPanel();
        panel_1.add(eveningHolderPanel);

        isEvening = new JCheckBox("Evening");
        eveningHolderPanel.add(isEvening);

        JPanel datePanel = new JPanel();
        inputPanel.add(datePanel);
        datePanel.setLayout(new GridLayout(3, 0, 0, 5 ));
        JPanel startDatePanel = new JPanel();
        JLabel dateStartPromptLabel = new JLabel("Start Date:");
        dateStartPromptLabel.setFont(new Font("Century", Font.PLAIN, 15));
        dataPickerStart = new DatePickerPanel();
        startDatePanel.add(dateStartPromptLabel);
        startDatePanel.add(dataPickerStart);
        datePanel.add(startDatePanel);

        JPanel endDatePanel = new JPanel();
        JLabel endDate = new JLabel("End Date:");
        endDate.setFont(new Font("Century", Font.PLAIN, 15));
        dataPickerEnd = new DatePickerPanel();
        endDatePanel.add(endDate);
        endDatePanel.add(dataPickerEnd);
        datePanel.add(endDatePanel);

        JPanel panel_3 = new JPanel();
        FlowLayout flowLayout_1 = (FlowLayout) panel_3.getLayout();
        flowLayout_1.setAlignment(FlowLayout.TRAILING);
        datePanel.add(panel_3);

        JButton btnNewButton = new JButton("Create New Drug");
        btnNewButton.setFont(new Font("Century", Font.PLAIN, 16));
        panel_3.add(btnNewButton);
        btnNewButton.addActionListener(new AddDrugController(this, doctor, patientSlot));

        JPanel tablePanel = new JPanel();
        centerPanel.add(tablePanel);
        tablePanel.setLayout(new BorderLayout(0, 0));

        table = new JTable();

        dataModel = new MyTableModel();
        table.setModel(dataModel);
        scrollPane = new JScrollPane(table);
        tablePanel.add(scrollPane);
        table.setAutoCreateRowSorter(true);

        JPanel welcomePanel = new JPanel();
        FlowLayout flowLayout = (FlowLayout) welcomePanel.getLayout();
        flowLayout.setAlignment(FlowLayout.LEFT);
        add(welcomePanel, BorderLayout.NORTH);


        JButton backButton = new JButton("<--");
        backButton.addActionListener(this);

        JLabel welcomeLabel = new JLabel("Patient Information: " + patientSlot.getPatientInfo().getName() + " " + patientSlot.getPatientInfo().getSurname() + "'s Drug List");
        welcomeLabel.setFont(new Font("Century", Font.PLAIN, 20));
        welcomePanel.add(backButton);
        welcomePanel.add(welcomeLabel);

        JPanel nextButtonPanel = new JPanel();
        FlowLayout fl_nextButtonPanel = (FlowLayout) nextButtonPanel.getLayout();
        fl_nextButtonPanel.setAlignment(FlowLayout.RIGHT);
        add(nextButtonPanel, BorderLayout.SOUTH);

        JPanel colorPanel = new JPanel();
        tablePanel.add(colorPanel, BorderLayout.WEST);

        JPanel colorPanel_1 = new JPanel();
        tablePanel.add(colorPanel_1, BorderLayout.EAST);

        //color
        inputPanel.setBackground(new Color(237, 241, 254));
        choicePanel.setBackground(Color.WHITE);
        drugNamePanel.setBackground(Color.WHITE);
        dosePanel.setBackground(Color.WHITE);
        statusPanel.setBackground(Color.WHITE);
        startDatePanel.setBackground(Color.WHITE);
        endDatePanel.setBackground(Color.WHITE);
        datePanel.setBackground(new Color(237, 241, 254));
        panel_3.setBackground(new Color(237, 241, 254));
        welcomePanel.setBackground(new Color(101, 180, 206));
        nextButtonPanel.setBackground(new Color(101, 180, 206));
        tablePanel.setBackground(new Color(101, 180, 206));
        this.setBackground(new Color(101, 180, 206));
        centerPanel.setBackground(new Color(101, 180, 206));
        colorPanel.setBackground(new Color(101, 180, 206));
        colorPanel_1.setBackground(new Color(101, 180, 206));
    }

    @Override
    public void update() {
        addRow();
    }


    class MyTableModel extends AbstractTableModel {
        private String[] columnNames = new String[]{
                "Drug Name", "Start Date", "End Date", "Dose", "Day Routine", "Condition"};

        private ArrayList<Drug> drugs;

        public MyTableModel() {
            drugs = patientSlot.getPatientInfo().getDrugs();
        }


        public int getColumnCount() {
            return columnNames.length;
        }

        public int getRowCount() {
            return drugs.size();
        }

        public String getColumnName(int col) {
            return columnNames[col];
        }


        public Object getValueAt(int row, int col) {
            Drug drug = drugs.get(row);
            switch (col) {
                case 0:
                    return drug.getName();
                case 1:
                    return drug.getStartDate();
                case 2:
                    return drug.getFinalDate();
                case 3:
                    return drug.getDose();
                case 4:
                    String temp = "";
                    if (drug.isMorning()) {
                        temp += " Morning";
                    }
                    if (drug.isAfternoon()) {
                        temp += " Afternoon";
                    }
                    if (drug.isEvening()) {
                        temp += " Evening";
                    }
                    return temp;
                case 5:
                    if (drug.isHungry()) {
                        return "Hungry";
                    } else {
                        return "Full";
                    }
            }
            return "null";
        }

        public boolean isCellEditable(int row, int col) {
            return false;
        }

        public void newRowsAdded(TableModelEvent event) {
            fireTableChanged(event);
        }
    }

    public void addRow() {
        int rowIndex = patientSlot.getPatientInfo().getDrugs().size() - 1;
        dataModel.newRowsAdded(new TableModelEvent(
                dataModel, rowIndex, rowIndex, TableModelEvent.ALL_COLUMNS, TableModelEvent.INSERT)
        );
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        layeredPanelView.switchMainPanel();
    }
}
