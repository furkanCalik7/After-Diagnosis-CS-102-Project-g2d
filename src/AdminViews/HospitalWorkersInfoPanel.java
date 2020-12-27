package AdminViews;

import Admin.model.Admin;
import Admin.model.IViewer;
import Admin.model.UserInfoCard;
import Doctor.Model.Doctor;
import Doctor.Model.DoctorInfoCard;
import Doctor.Model.PatientSlot;
import Doctor.Views.*;

import javax.swing.*;

import java.awt.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.TableModelEvent;
import javax.swing.table.*;
import javax.swing.event.TableModelEvent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class HospitalWorkersInfoPanel extends JPanel implements IViewer {
    private JTextField searchField;
    private JTable table;
    private TableRowSorter<MyTableModel> rowSorter;
    private JComboBox sortComboBox;
    private Admin admin;
    private JComboBox workersBox;
    private MyTableModel dataModel;

    /**
     * Create the panel.
     */
    public HospitalWorkersInfoPanel(Admin admin) {
        this.admin = admin;
        setBorder(new EmptyBorder(0, 0, 0, 0));
        setLayout(new BorderLayout(0, 0));

        JLabel lblNewLabel = new JLabel("Hosptal Workers Information");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(lblNewLabel, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(101, 180, 206));
        add(panel, BorderLayout.CENTER);
        panel.setLayout(new BorderLayout(0, 0));

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(101, 180, 206));
        panel.add(panel_1, BorderLayout.NORTH);
        panel_1.setLayout(new GridLayout(0, 2, 0, 0));

        JPanel panel_3 = new JPanel();
        panel_3.setBackground(new Color(101, 180, 206));
        panel_1.add(panel_3);
        panel_3.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

        JLabel lblNewLabel_3 = new JLabel("Search");
        panel_3.add(lblNewLabel_3);

        searchField = new HintTextField("Search Worker By Name");
        panel_3.add(searchField);
        searchField.setColumns(10);

        searchField.getDocument().addDocumentListener(
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


        JPanel panel_4 = new JPanel();
        panel_4.setBackground(new Color(101, 180, 206));
        panel_1.add(panel_4);
        panel_4.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));

        JLabel lblNewLabel_1 = new JLabel("Choose From");
        panel_4.add(lblNewLabel_1);

        String[] workers = new String[]{"All Workers", "Doctors", "Lab Technicians"};
        workersBox = new JComboBox(workers);
        panel_4.add(workersBox);
        workersBox.addActionListener(new FilterListener());

        JLabel lblNewLabel_2 = new JLabel("Sort By");
        panel_4.add(lblNewLabel_2);

        String[] sortingInfo = new String[]{"Name", "Worker Type", "Speciality"};
        sortComboBox = new JComboBox(sortingInfo);
        panel_4.add(sortComboBox);

        //Panel including the table

        JPanel panel_2 = new JPanel();
        panel_2.setBackground(new Color(101, 180, 206));
        panel.add(panel_2, BorderLayout.CENTER);
        panel_2.setLayout(new BorderLayout(0, 0));


        table = new JTable();
        dataModel = new MyTableModel();
        table.setModel(dataModel);
        rowSorter = new TableRowSorter<>(dataModel);
        table.setRowSorter(rowSorter);
        table.setEnabled(false);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        panel_2.add(scrollPane);

    }

    class MyTableModel extends AbstractTableModel {
        private String[] columnNames = new String[]{
                "Name and Surname", "Worker Type", "Speciality", "Mail Address"};

        private ArrayList<UserInfoCard> workers;

        public MyTableModel() {
            workers = admin.getWorkers();
        }

        public int getColumnCount() {
            return columnNames.length;
        }

        public int getRowCount() {
            return workers.size();
        }

        public String getColumnName(int col) {
            return columnNames[col];
        }


        public Object getValueAt(int row, int col) {
            UserInfoCard data = workers.get(row);

            switch (col) {
                case 0:
                    return data.getName() + " " + data.getSurname();
                case 1:
                    return data.getUserType();
                case 2:
                    if (data.getUserType().equals("Doctor")) {
                        return ((DoctorInfoCard) data).getDoctorSpeciality();
                    } else {
                        return "null";
                    }
                case 3:
                    return data.getEmail();

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
        RowFilter<MyTableModel, Object> rf = null;
        try {

            if (!searchField.getText().equals("Search Worker By Name")) {
                rf = RowFilter.regexFilter(searchField.getText(), 0);
            }
        } catch (java.util.regex.PatternSyntaxException e) {
            return;
        }
        rowSorter.setRowFilter(rf);
    }

    class FilterListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String item = workersBox.getSelectedItem().toString();
            RowFilter<MyTableModel, Object> rf = null;

            if(item.equals("Doctors"))
                rf = RowFilter.regexFilter("Doctor", 1);
            else if(item.equals("Lab Technicians")) {
                rf = RowFilter.regexFilter("LabTechnician", 1);
            }
            rowSorter.setRowFilter(rf);
        }
    }

    public void addRow() {
        int rowIndex = admin.getWorkers().size() - 1;
        dataModel.newRowsAdded(new TableModelEvent(
                dataModel, rowIndex, rowIndex, TableModelEvent.ALL_COLUMNS, TableModelEvent.INSERT)
        );
    }

    public void update() {
        addRow();
    }
}


