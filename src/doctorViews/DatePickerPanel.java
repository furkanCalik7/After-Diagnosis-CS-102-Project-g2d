package doctorViews;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DatePickerPanel extends JPanel implements PropertyChangeListener {

	private SimpleDateFormat formatter;
	private JFormattedTextField  textField;

		
		public DatePickerPanel()
		{
			formatter = new SimpleDateFormat("yyyy-MM-dd");
			 textField = new JFormattedTextField(formatter);
			textField.setValue(new Date());
			textField.setPreferredSize(new Dimension(130, 30));

			CalendarWindow calendarWindow = new CalendarWindow();
			calendarWindow.addPropertyChangeListener(this);
			JButton calendarButton = new JButton("Pick a Date");
					
			calendarButton.addActionListener(new ActionListener()
			{
			  public void actionPerformed(ActionEvent e)
			  {
				//render the calendar window below the text field
				calendarWindow.setLocation(textField.getLocationOnScreen().x, (textField.getLocationOnScreen().y + textField.getHeight()));
				//get the Date and assign it to the calendar
				Date d = (Date)textField.getValue();				
					
				calendarWindow.resetSelection(d);				
				calendarWindow.setUndecorated(true);
			    calendarWindow.setVisible(true);
			  }
			});

			//add the UI controls to the ContentPane
			add(textField);
			add(calendarButton);
			setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		}
		
        @Override
		public void propertyChange(PropertyChangeEvent event) {
			
        	//get the selected date from the calendar control and set it to the text field
			if (event.getPropertyName().equals("selectedDate")) {
	            
				java.util.Calendar cal = (java.util.Calendar)event.getNewValue();
				Date selDate =  cal.getTime();
				textField.setValue(selDate);
	        }
			
		}
		public String getSelectedDate(){
			return textField.getText();
		}

}
