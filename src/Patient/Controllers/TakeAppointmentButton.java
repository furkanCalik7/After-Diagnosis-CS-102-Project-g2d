package Patient.Controllers;

import Patient.Model.Patient;
import Patient.Views.AppointmentPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class TakeAppointmentButton extends JButton {

    private Patient patient;
    private AppointmentPanel panel;

    public TakeAppointmentButton(Patient patient, AppointmentPanel panel) {
        setText("Complete");
        this.patient = patient;
        this.panel = panel;
        addActionListener(new AppointmentButttonListener());
    }

    class AppointmentButttonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String doctorUsername = panel.getDoctorUsernameTextField().getText();
            String date = panel.getDatePickPanel().getSelectedDate();
            String startTime = panel.getStartDateTextfield().getText();
            String endTime = panel.getEndDateTextField().getText();

            Date appDate = Date.valueOf(date);
            DateFormat formatter = new SimpleDateFormat("HH:mm");
            try {
                Time time1 =  new java.sql.Time(formatter.parse(startTime).getTime());
                Time time2 =  new java.sql.Time(formatter.parse(startTime).getTime());
                patient.addAppointment(doctorUsername, appDate, time1, time2);
                JOptionPane.showMessageDialog(panel, "New Appointment is arranged");
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
    }


}
