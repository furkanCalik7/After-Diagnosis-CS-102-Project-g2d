package Patient.Views;

import Admin.model.UserInfoCard;
import AdminViews.HospitalWorkersInfoPanel;
import Doctor.Model.DoctorInfoCard;
import Doctor.Model.Drug;
import Patient.Model.Patient;

import javax.swing.*;

import java.awt.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.TableModelEvent;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;

public class MyDrugsPanel extends JPanel {
    private JTextField textField;
    private JTable currentTable;
    private JTable expiredTable;
    private JPanel currentTablePanel;
    private JPanel expiredTablePanel;
    private JLayeredPane layeredPane;
    private JTextField textField_1;
    private Patient patient;
    private TableRowSorter<CurrentTableModel> rowSorter;


    /**
     * Create the panel.
     */
    public void switchPanels(JPanel panel) {
        layeredPane.removeAll();
        layeredPane.add(panel);
        layeredPane.repaint();
        layeredPane.revalidate();
    }

    public MyDrugsPanel(Patient patient) {

        this.patient = patient;
        setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();

        panel.setBackground(new Color(101, 180, 206));

        add(panel, BorderLayout.NORTH);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JButton currentMedicationsButton = new JButton("Current Medications");

        panel.add(currentMedicationsButton);

        JButton expiredMedicationsButton = new JButton("Your Expired Medications");

        panel.add(expiredMedicationsButton);

        layeredPane = new JLayeredPane();
        layeredPane.setBackground(new Color(101, 180, 206));
        add(layeredPane, BorderLayout.CENTER);
        layeredPane.setLayout(new CardLayout(0, 0));

        JPanel currentMedicationsPanel = new JPanel();
        currentMedicationsPanel.setBackground( new Color(101, 180, 206) );
        layeredPane.add(currentMedicationsPanel, "name_1117144943200400");
        currentMedicationsPanel.setLayout(new BorderLayout(0, 0));

        JPanel currentHeadPanel = new JPanel();
        currentHeadPanel.setBackground(new Color(101, 180, 206));
        currentMedicationsPanel.add(currentHeadPanel, BorderLayout.NORTH);
        currentHeadPanel.setLayout(new GridLayout(2, 0, 0, 0));

        JLabel lblSearchByName = new JLabel("Search By Name");
        currentHeadPanel.add(lblSearchByName);

        JPanel panel_2 = new JPanel();
        panel_2.setBackground(new Color(101, 180, 206));
        currentHeadPanel.add(panel_2);
        panel_2.setLayout(new GridLayout(0, 3, 0, 0));

        textField = new JTextField();
        panel_2.add(textField);
        textField.setColumns(10);



        JPanel currentCenterPanel = new JPanel();

        currentCenterPanel.setBackground(new Color(101, 180, 206));

        currentMedicationsPanel.add(currentCenterPanel, BorderLayout.CENTER);
        currentCenterPanel.setLayout(new BorderLayout(0, 0));

        currentTable = new JTable();
        CurrentTableModel currentTableModel = new CurrentTableModel();
        currentTable.setModel(currentTableModel);
        rowSorter = new TableRowSorter<>(currentTableModel);
        currentTable.setRowSorter(rowSorter);
        currentTable.setEnabled(false);

        JScrollPane scrollPane = new JScrollPane(currentTable);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        currentTablePanel = new JPanel();
        currentTablePanel.setBackground(new Color(101, 180, 206));
        currentTablePanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

        currentTablePanel.add(scrollPane);


        currentCenterPanel.add(currentTablePanel, BorderLayout.WEST);

        JPanel drugsPanel = new JPanel();
        drugsPanel.setBackground(new Color(101, 180, 206));
        currentCenterPanel.add(drugsPanel, BorderLayout.NORTH);


        JPanel expiredMedicationsPanel = new JPanel();
        expiredMedicationsPanel.setBackground(new Color(101, 180, 206));
        layeredPane.add(expiredMedicationsPanel, "name_1117149041432400");
        expiredMedicationsPanel.setLayout(new BorderLayout(0, 0));

        JPanel expiredHeadPanel = new JPanel();

        expiredHeadPanel.setBackground(new Color(101, 180, 206));

        expiredMedicationsPanel.add(expiredHeadPanel, BorderLayout.NORTH);
        expiredHeadPanel.setLayout(new GridLayout(2, 0, 0, 0));

        JLabel lblNewLabel_1 = new JLabel("Search By Name");
        expiredHeadPanel.add(lblNewLabel_1);

        JPanel panel_5 = new JPanel();
        panel_5.setBackground(new Color(101, 180, 206));
        expiredHeadPanel.add(panel_5);
        panel_5.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

        textField_1 = new JTextField();
        panel_5.add(textField_1);
        textField_1.setColumns(10);

        textField.getDocument().addDocumentListener(
                new DocumentListener() {
                    public void changedUpdate(DocumentEvent e) {
                        newFilter();
                    }

                    public void insertUpdate(DocumentEvent e) {
                        newFilter();
                    }

                    public void removeUpdate(DocumentEvent e) {
                        newFilter();
                    }
                });

        expiredTable = new JTable();
        expiredTable.setEnabled(false);
        ExpiredTableModel expiredModel = new ExpiredTableModel();
        expiredTable.setModel(expiredModel);
        expiredTable.setRowSorter(rowSorter);



        JScrollPane scrollPane2 = new JScrollPane(expiredTable);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        expiredTablePanel = new JPanel();
        expiredTablePanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

        expiredTablePanel.add(scrollPane2);
        expiredMedicationsPanel.add(expiredTablePanel, BorderLayout.WEST);


        currentMedicationsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switchPanels(currentMedicationsPanel);
            }
        });
        expiredMedicationsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switchPanels(expiredMedicationsPanel);
            }
        });
    }

    class CurrentTableModel extends AbstractTableModel {
        protected String[] columnNames = new String[]{
                "Drug name", "Final Date", "Dose", "Hungry/Full", "Drug times"};

        protected ArrayList<Drug> drugs;

        public CurrentTableModel() {
            drugs = patient.getDrugs();
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
            Drug data = drugs.get(row);
            String times = "";

            switch (col) {
                case 0:
                    return data.getName();
                case 1:
                    return data.getFinalDate();
                case 2:
                    return data.getDose();
                case 3:
                    if(data.isHungry())
                        return "Hungry";
                    return "Full";
                case 4:
                    if(data.isMorning())
                        times += "Morning ";
                    if(data.isAfternoon())
                        times += "Afternoon ";
                    if(data.isEvening())
                        times += "Evening";
                    return times;
            }
            return "null";
        }

        public boolean isCellEditable(int row, int col) {
            return false;
        }

        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

            fireTableCellUpdated(rowIndex, columnIndex);
        }

        public void newRowsAdded(TableModelEvent event) {
            fireTableChanged(event);
        }

    }

    private void newFilter() {
        RowFilter<CurrentTableModel, Object> rf = null;
        try {
            rf = RowFilter.regexFilter(textField.getText(), 0);
        } catch (java.util.regex.PatternSyntaxException e) {
            return;
        }
        rowSorter.setRowFilter(rf);
    }

    class ExpiredTableModel extends CurrentTableModel {

        private String[] columns = new String[]{
                "Pill name", "Start Date", "End Date"};

        private ArrayList<Drug> expiredDrugs;



        public ExpiredTableModel() {
            super();
        }

        public int getColumnCount() {
            return columns.length;
        }

        public String getColumnName(int col) {
            return columns[col];
        }

        public Object getValueAt(int row, int col) {
            Drug data = drugs.get(row);

            Date date = new Date(Calendar.getInstance().getTime().getTime());
            if(data.getFinalDate().compareTo(date) < 0) {
                switch (col) {
                    case 0:
                        return data.getName();
                    case 1:
                        return data.getStartDate();
                    case 2:
                        return data.getFinalDate();
                }
            }
            return "null";
        }




    }

    /*public void addRow() {
        int rowIndex = admin.getWorkers().size();
        dataModel.newRowsAdded(new TableModelEvent(
                dataModel, rowIndex, rowIndex, TableModelEvent.ALL_COLUMNS, TableModelEvent.INSERT)
        );
    }

    public void update() {
        addRow();
    }*/

}



