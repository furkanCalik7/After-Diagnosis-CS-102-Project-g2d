package Doctor.Views;

import Doctor.Controller.FileChooserForDownloadController;
import Doctor.Model.Doctor;
import LabTechs.Model.Test;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.event.TableModelEvent;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;

public class LabTestsMainPanel extends JPanel {
    private JTextField patientNameTextField;
    private JTextField txtTestName;
    private JLayeredPane layeredPane;
    private JTable table;
    private JPanel seeAvailableTestsPanel;
    private Doctor doctor;
    MyTableModel myTableModel;
    RowSorter<MyTableModel> rowSorter;

    public void switchPanels( JPanel panel ) {
        layeredPane.removeAll();
        layeredPane.add(panel);
        layeredPane.repaint();
        layeredPane.revalidate();

    }

    public LabTestsMainPanel(Doctor doctor) {
        this.doctor = doctor;

        setLayout(new BorderLayout(0, 0));

        layeredPane = new JLayeredPane();
        layeredPane.setLayout(new CardLayout(0, 0));

        //Create Request Panel
        JPanel centerInfoPanel = new JPanel();
        add(centerInfoPanel, BorderLayout.CENTER);
        centerInfoPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 50));

        JPanel createRequestPanel = new JPanel();
        layeredPane.add(createRequestPanel, "name_911052869684500");
        createRequestPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JPanel createRequest = new JPanel();
        createRequest.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        createRequestPanel.add(createRequest);
        createRequest.setLayout(new BorderLayout(0, 0));

        JPanel buttonPanel = new JPanel();
        FlowLayout fl_buttonPanel = (FlowLayout) buttonPanel.getLayout();
        fl_buttonPanel.setAlignment(FlowLayout.RIGHT);
        createRequest.add(buttonPanel, BorderLayout.SOUTH);

        JButton sendRequestButton = new JButton("Send Requests");
        sendRequestButton.setFont(new Font("Century", Font.PLAIN, 20));
        buttonPanel.add(sendRequestButton);

        JPanel centerPanel = new JPanel();
        createRequest.add(centerPanel);
        centerPanel.setLayout(new GridLayout(2, 2, 0, 0));

        JPanel patientNamePanel = new JPanel();
        centerPanel.add(patientNamePanel);

        JLabel patientNameLbl = new JLabel("Patient Name:");
        patientNameLbl.setFont(new Font("Century", Font.PLAIN, 20));
        patientNamePanel.add(patientNameLbl);

        JPanel patientNameTxtFPanel = new JPanel();
        centerPanel.add(patientNameTxtFPanel);

        patientNameTextField = new HintTextField("Patient Name");
        patientNameTextField.setFont(new Font("Century", Font.PLAIN, 20));

        patientNameTxtFPanel.add(patientNameTextField);
        patientNameTextField.setColumns(10);

        JPanel testNamePanel = new JPanel();
        centerPanel.add(testNamePanel);

        JLabel lblNewLabel = new JLabel("Enter Wanted Test Name");
        lblNewLabel.setFont(new Font("Century", Font.PLAIN, 20));
        testNamePanel.add(lblNewLabel);

        JPanel testNameTxtFPanel = new JPanel();
        centerPanel.add(testNameTxtFPanel);

        txtTestName = new HintTextField( "Test Name");
        txtTestName.setFont(new Font("Century", Font.PLAIN, 20));
        testNameTxtFPanel.add(txtTestName);
        txtTestName.setColumns(10);

        centerInfoPanel.add(layeredPane);

        //See available Tests Panel
        seeAvailableTestsPanel = new JPanel();
        layeredPane.add(seeAvailableTestsPanel, "name_911055903035000");


        //Building the table.
        myTableModel = new MyTableModel();
        table = new JTable();
        table.setModel(myTableModel);

        table.getColumn("Download").setCellEditor(new DownloadButtonEditor(new JTextField()));
        table.getColumn("Download").setCellRenderer(new DownloadButtonRenderer());


        JScrollPane scrollPane = new JScrollPane( table );

        seeAvailableTestsPanel.add(scrollPane);

        //Buttons and more
        JPanel buttonsPanel = new JPanel();
        add(buttonsPanel, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        FlowLayout flowLayout = (FlowLayout) panel.getLayout();
        flowLayout.setHgap(0);
        buttonsPanel.add(panel);

        JButton labReqButton = new JButton("Create a Lab Request");
        labReqButton.setFont(new Font("Century", Font.PLAIN, 20));
        labReqButton.setBackground(new Color(38, 69, 191));
        panel.add(labReqButton);

        JButton availableTestsButton = new JButton("See Available Tests");
        availableTestsButton.setFont(new Font("Century", Font.PLAIN, 20));
        availableTestsButton.setBackground(new Color(240, 240, 240));
        panel.add(availableTestsButton);

        //Button Action Listeners.
        labReqButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switchPanels( createRequestPanel );
                availableTestsButton.setBackground(new Color(240, 240, 240));
                labReqButton.setBackground(new Color(38, 69, 191));
            }
        });

        availableTestsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switchPanels( seeAvailableTestsPanel );
                labReqButton.setBackground(new Color(240, 240, 240));
                availableTestsButton.setBackground(new Color(38, 69, 191));
            }
        });
    }

//    @Override
//    public void update() {
//        addRow();
//    }


    private class MyTableModel extends AbstractTableModel {
        private String[] columnNames = new String[]{
                "Doctor name","Patient Name", "Test Name", "Send Time", "Sent time", "Download"};

        private ArrayList<Test> tests;

        public MyTableModel() {
            tests = doctor.getTests();
        }


        public int getColumnCount() {
            return columnNames.length;
        }

        public int getRowCount() {
            return tests.size();
        }

        public String getColumnName(int col) {
            return columnNames[col];
        }


        public Object getValueAt(int row, int col) {
            Test test = tests.get(row);
            switch (col) {
                case 0:
                    return test.getSender_username();
                case 1:
                    return test.getPatient_username();
                case 2:
                    return test.getTest_name();
                case 3:
                    return test.getSent_date();
                case 4:
                    return test.getSent_time();
                case 5:
                    return "Download";
            }
            return "null";
        }

        public boolean isCellEditable(int row, int col) {
            return col >= 5;
        }

        public void newRowsAdded(TableModelEvent event) {
            fireTableChanged(event);
        }

    }

//    public void addRow() {
//        int rowIndex = patientSlot.getPatientInfo().getDrugs().size() - 1;
//        dataModel.newRowsAdded(new TableModelEvent(
//                dataModel, rowIndex, rowIndex, TableModelEvent.ALL_COLUMNS, TableModelEvent.INSERT)
//        );
//    }

    class DownloadButtonRenderer extends JButton implements TableCellRenderer {

        public DownloadButtonRenderer() {
            setOpaque(true);
        }

        public Component getTableCellRendererComponent(JTable table, Object value,
                                                       boolean isSelected, boolean hasFocus, int row, int column) {
            setText((value == null) ? "" : value.toString());
            return this;
        }
    }

    class DownloadButtonEditor extends DefaultCellEditor {
        protected JButton button;
        int i = 0;
        private String label;

        private boolean isPushed;

        public DownloadButtonEditor(JTextField textField) {
            super(textField);
            button = new JButton();
            button.setOpaque(true);
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    fireEditingStopped();
                }
            });
        }

        public Component getTableCellEditorComponent(JTable table, Object value,
                                                     boolean isSelected, int row, int column) {

            label = (value == null) ? "" : value.toString();
            button.setText(label);
            i = row;
            isPushed = true;
            return button;
        }

        public Object getCellEditorValue() {
            if (isPushed) {
                Test test = doctor.getTests().get(table.convertRowIndexToModel(i));
                new FileChooserForDownloadController(LabTestsMainPanel.this,test,doctor);
            }
            isPushed = false;
            return new String(label);
        }

        public boolean stopCellEditing() {
            isPushed = false;
            return super.stopCellEditing();
        }

        protected void fireEditingStopped() {
            super.fireEditingStopped();
        }

    }
}
