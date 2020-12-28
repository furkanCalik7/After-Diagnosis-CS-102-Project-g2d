package common;

import Appointment.Appointment;

import java.util.ArrayList;

/**
 * An interface which will be implemented by classes which have appointment.
 */
public interface HasAppointment {
    ArrayList<Appointment> getAppointmentDates();
}
