package AdminViews;

import Admin.model.Admin;
import AdminViews.AddWorkerMainPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class AddWorkerController implements ActionListener {

    private Admin admin;
    private AddWorkerMainPanel panel;
    public AddWorkerController(Admin admin, AddWorkerMainPanel panel) {
        this.admin = admin;
        this.panel = panel;
    }

    public void actionPerformed(ActionEvent e) {
        Object[] options = {"OK", "Cancel"};
        int n = JOptionPane.showOptionDialog(null,
                "New Hospital worker will be added to hospital crew. Do" +
                        " you want to continue?",
                "Warning",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[1]);

        if(n == 0) {
            String name = panel.nameTextField.getText();
            String surname = panel.surnameTextField.getText();
            String email = panel.textField_2.getText();

            String speciality = panel.comboBox.getSelectedItem().toString();

            if (panel.doctorButton.isSelected()) {
                try {
                    admin.addDoctor(name, surname, email, "M", speciality);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            } else {
                try {
                    admin.addLabTech(name, surname, email, "M");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
            panel.nameTextField.setText("");
            panel.surnameTextField.setText("");
            panel.textField_2.setText("");

    }
}
