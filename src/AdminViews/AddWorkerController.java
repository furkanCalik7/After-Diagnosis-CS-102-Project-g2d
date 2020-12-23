package AdminViews;

import Admin.model.Admin;
import AdminViews.AddWorkerMainPanel;

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
        panel.nameTextField.setText("");
        panel.surnameTextField.setText("");
        panel.textField_2.setText("");

    }
}
