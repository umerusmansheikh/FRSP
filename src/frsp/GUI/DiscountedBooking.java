package frsp.GUI;

import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;
import com.github.lgooddatepicker.components.TimePickerSettings;
import com.github.lgooddatepicker.optionalusertools.CalendarBorderProperties;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


public class DiscountedBooking extends JPanel
{
    JComboBox<String> flightOriginField;
    JComboBox<String> flightDestinationField;
    JTextField flightDistanceField;
    JTextField flightMilePriceField;
    JTextField departureDateField;
    JTextField returnDateField;

    DatePicker flightDepartureField;
    DatePicker flightReturnField;

    JButton book;
    JButton logOut;
    JButton placeholder;

    JScrollPane scroll;
    JPanel buttonPanel;

    public DiscountedBooking() {


            JPanel flightOriginPanel = new JPanel();
            JPanel flightDestinationPanel = new JPanel();
            JPanel flightDeparturePanel = new JPanel();
            JPanel flightReturnPanel = new JPanel();
            JPanel flightFieldsPanel = new JPanel();
            JPanel flightFieldsTwoPanel = new JPanel();

            ImageIcon headerImage = new ImageIcon(
                            "images/header.png");
            JLabel headerImageLabel = new JLabel(headerImage);

            placeholder = new JButton("");
            placeholder.setFocusPainted(false);
            placeholder.setBorder(null);
            placeholder.setBackground(Color.decode("#333333"));
            placeholder.setPreferredSize(new Dimension(200, 48));
            placeholder.setOpaque(true);

            logOut = new JButton("");
            logOut.setFocusPainted(false);
            logOut.setText("");
            logOut.setBorder(null);
            logOut.setForeground(Color.WHITE);
            logOut.setBackground(Color.decode("#333333"));
            logOut.setFont(new Font("Avenir", Font.PLAIN, 15));
            logOut.setPreferredSize(new Dimension(200, 48));
            logOut.setOpaque(true);

            JPanel header = new JPanel();
            header.setLayout(new GridBagLayout());
            GridBagConstraints c = new GridBagConstraints();
            header.setBorder(new EmptyBorder(0, 0, 0, -1));
            header.setBackground(Color.WHITE);

            c.anchor = GridBagConstraints.FIRST_LINE_START;
            c.fill = GridBagConstraints.HORIZONTAL;
            c.gridx = 0;
            c.gridy = 0;
            header.add(headerImageLabel, c);

            c.anchor = GridBagConstraints.FIRST_LINE_START;
            c.fill = GridBagConstraints.HORIZONTAL;
            c.gridx = 1;
            c.gridy = 0;
            header.add(placeholder, c);

            c.anchor = GridBagConstraints.FIRST_LINE_START;
            c.fill = GridBagConstraints.HORIZONTAL;
            c.gridx = 2;
            c.gridy = 0;
            header.add(logOut, c);

            JLabel flightLabel = new JLabel("You missed a flight! Book a Flight on 50% Discount");
            flightLabel.setForeground(Color.decode("#D62027"));
            flightLabel.setFont(new Font("Avenir", Font.BOLD, 25));
            flightLabel.setBorder(new EmptyBorder(20, 0, 20, 0));

            flightOriginPanel.setBackground(Color.WHITE);
            JLabel flightOriginLabel = new JLabel("Origin");
            flightOriginLabel.setFont(new Font("Avenir", Font.PLAIN, 15));
            flightOriginField = new JComboBox();
            flightOriginField.setPreferredSize(new Dimension(250, 40));
            flightOriginField.addItem("New York, USA");
            flightOriginField.addItem("Florida, USA");
            flightOriginField.addItem("Texas, USA");
            flightOriginField.addItem("California, USA");

            flightOriginPanel.setLayout(new BorderLayout());
            flightOriginPanel.setBorder(new EmptyBorder(10, 0, 0, 0));
            flightOriginPanel.add(flightOriginLabel, BorderLayout.CENTER);
            flightOriginPanel.add(flightOriginField, BorderLayout.EAST);

            flightDestinationPanel.setBackground(Color.WHITE);
            JLabel flightDestinationLabel = new JLabel("Destination");
            flightDestinationLabel.setFont(new Font("Avenir", Font.PLAIN, 15));
            flightDestinationField = new JComboBox();
            flightDestinationField.setPreferredSize(new Dimension(250, 40));
            
            flightDestinationField.addItem("New York, USA");
            flightDestinationField.addItem("Florida, USA");
            flightDestinationField.addItem("Texas, USA");
            flightDestinationField.addItem("California, USA");

            
            flightDestinationPanel.setLayout(new BorderLayout());
            flightDestinationPanel.setBorder(new EmptyBorder(10, 0, 0, 0));
            flightDestinationPanel.add(flightDestinationLabel, BorderLayout.CENTER);
            flightDestinationPanel.add(flightDestinationField, BorderLayout.EAST);

            flightFieldsPanel.setLayout(new BorderLayout());
            flightFieldsPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
            flightFieldsPanel.setBackground(Color.WHITE);
            flightFieldsPanel.add(flightOriginPanel, BorderLayout.CENTER);
            flightFieldsPanel.add(flightDestinationPanel, BorderLayout.SOUTH);

            DatePickerSettings dateSettings = new DatePickerSettings();
            dateSettings.setFormatForDatesCommonEra("yyyy-MM-dd");
            dateSettings.setFormatForDatesBeforeCommonEra("uuuu-MM-dd");
            dateSettings.setSizeDatePanelMinimumHeight(200);
            dateSettings.setSizeDatePanelMinimumWidth(100);
            dateSettings.setVisibleDateTextField(true);
            dateSettings.setColor(DatePickerSettings.DateArea.CalendarBackgroundNormalDates, Color.WHITE);
            dateSettings.setColor(DatePickerSettings.DateArea.BackgroundOverallCalendarPanel, Color.WHITE);
            dateSettings.setColor(DatePickerSettings.DateArea.BackgroundMonthAndYearMenuLabels, Color.WHITE);
            dateSettings.setColor(DatePickerSettings.DateArea.BackgroundTodayLabel, Color.WHITE);
            dateSettings.setColor(DatePickerSettings.DateArea.BackgroundClearLabel, Color.WHITE);
            dateSettings.setColor(DatePickerSettings.DateArea.BackgroundMonthAndYearNavigationButtons, Color.WHITE);
            dateSettings.setColorBackgroundWeekdayLabels(Color.decode("#BFBFBF"), true);

            ArrayList<CalendarBorderProperties> borderProperties = new ArrayList<CalendarBorderProperties>();
            borderProperties.add(new CalendarBorderProperties(new Point(1, 1), new Point(5, 5), Color.WHITE, 0));

            dateSettings.setBorderPropertiesList(borderProperties);

            Font randomFont = new Font("Avenir", Font.PLAIN, 15);
            dateSettings.setFontMonthAndYearMenuLabels(randomFont);
            dateSettings.setFontMonthAndYearNavigationButtons(randomFont);
            dateSettings.setFontTodayLabel(randomFont);
            dateSettings.setFontClearLabel(randomFont);
            dateSettings.setFontCalendarDateLabels(randomFont);
            dateSettings.setFontCalendarWeekdayLabels(randomFont);
            dateSettings.setFontCalendarWeekNumberLabels(randomFont);

            TimePickerSettings timeSettings = new TimePickerSettings();
            timeSettings.setDisplayToggleTimeMenuButton(false);
            timeSettings.setDisplaySpinnerButtons(true);

            flightDeparturePanel.setBackground(Color.WHITE);
            JLabel flightDepartureLabel = new JLabel("Departure");
            flightDepartureLabel.setFont(new Font("Avenir", Font.PLAIN, 15));
            flightDepartureField = new DatePicker(dateSettings);
            flightDepartureField.setBackground(Color.WHITE);

            departureDateField = flightDepartureField.getComponentDateTextField();
            departureDateField.setBackground(Color.WHITE);
            departureDateField.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 0, Color.decode("#BFBFBF")));
            departureDateField.setPreferredSize(new Dimension(100, 40));
            JButton departureDate = flightDepartureField.getComponentToggleCalendarButton();
            departureDate.setFocusPainted(false);
            departureDate.setText("Date");
            departureDate.setBorder(null);
            departureDate.setForeground(Color.WHITE);
            departureDate.setBackground(Color.decode("#D62027"));
            departureDate.setFont(new Font("Avenir", Font.PLAIN, 15));
            departureDate.setPreferredSize(new Dimension(50, 40));
            departureDate.setOpaque(true);

            flightDepartureField.setBackground(Color.WHITE);
            flightDepartureField.setBorder(new EmptyBorder(10, 0, 0, 0));
            flightDeparturePanel.setLayout(new BorderLayout());
            flightDeparturePanel.setBorder(new EmptyBorder(0, 0, 0, 0));
            flightDeparturePanel.add(flightDepartureLabel, BorderLayout.CENTER);
            flightDeparturePanel.add(flightDepartureField, BorderLayout.EAST);

            dateSettings = new DatePickerSettings();
            dateSettings.setFormatForDatesCommonEra("yyyy-MM-dd");
            dateSettings.setFormatForDatesBeforeCommonEra("uuuu-MM-dd");
            dateSettings.setSizeDatePanelMinimumHeight(200);
            dateSettings.setSizeDatePanelMinimumWidth(100);
            dateSettings.setVisibleDateTextField(true);
            dateSettings.setColor(DatePickerSettings.DateArea.CalendarBackgroundNormalDates, Color.WHITE);
            dateSettings.setColor(DatePickerSettings.DateArea.BackgroundOverallCalendarPanel, Color.WHITE);
            dateSettings.setColor(DatePickerSettings.DateArea.BackgroundMonthAndYearMenuLabels, Color.WHITE);
            dateSettings.setColor(DatePickerSettings.DateArea.BackgroundTodayLabel, Color.WHITE);
            dateSettings.setColor(DatePickerSettings.DateArea.BackgroundClearLabel, Color.WHITE);
            dateSettings.setColor(DatePickerSettings.DateArea.BackgroundMonthAndYearNavigationButtons, Color.WHITE);
            dateSettings.setColorBackgroundWeekdayLabels(Color.decode("#BFBFBF"), true);

            dateSettings.setBorderPropertiesList(borderProperties);

            dateSettings.setFontMonthAndYearMenuLabels(randomFont);
            dateSettings.setFontMonthAndYearNavigationButtons(randomFont);
            dateSettings.setFontTodayLabel(randomFont);
            dateSettings.setFontClearLabel(randomFont);
            dateSettings.setFontCalendarDateLabels(randomFont);
            dateSettings.setFontCalendarWeekdayLabels(randomFont);
            dateSettings.setFontCalendarWeekNumberLabels(randomFont);

            timeSettings = new TimePickerSettings();
            timeSettings.setDisplayToggleTimeMenuButton(false);
            timeSettings.setDisplaySpinnerButtons(true);

            flightReturnPanel.setBackground(Color.WHITE);
            JLabel flightReturnLabel = new JLabel("Return");
            flightReturnLabel.setFont(new Font("Avenir", Font.PLAIN, 15));
            flightReturnField = new DatePicker(dateSettings);
            flightReturnField.setBackground(Color.WHITE);

            returnDateField = flightReturnField.getComponentDateTextField();
            returnDateField.setBackground(Color.WHITE);
            returnDateField.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 0, Color.decode("#BFBFBF")));
            returnDateField.setPreferredSize(new Dimension(100, 40));
            JButton returnDate = flightReturnField.getComponentToggleCalendarButton();
            returnDate.setFocusPainted(false);
            returnDate.setText("Date");
            returnDate.setBorder(null);
            returnDate.setForeground(Color.WHITE);
            returnDate.setBackground(Color.decode("#D62027"));
            returnDate.setFont(new Font("Avenir", Font.PLAIN, 15));
            returnDate.setPreferredSize(new Dimension(50, 40));
            returnDate.setOpaque(true);

            flightReturnField.setBackground(Color.WHITE);
            flightReturnField.setBorder(new EmptyBorder(10, 0, 0, 0));
            flightReturnPanel.setLayout(new BorderLayout());
            flightReturnPanel.setBorder(new EmptyBorder(10, 0, 0, 0));
            flightReturnPanel.add(flightReturnLabel, BorderLayout.CENTER);
            flightReturnPanel.add(flightReturnField, BorderLayout.EAST);

            flightFieldsTwoPanel.setLayout(new BorderLayout());
            flightFieldsTwoPanel.setBorder(new EmptyBorder(0, 20, 10, 0));
            flightFieldsTwoPanel.setBackground(Color.WHITE);
            flightFieldsTwoPanel.add(flightDeparturePanel, BorderLayout.CENTER);
            flightFieldsTwoPanel.add(flightReturnPanel, BorderLayout.SOUTH);

            book = new JButton("Book");
            book.setFocusPainted(false);
            book.setText("Book");
            book.setBorder(null);
            book.setForeground(Color.WHITE);
            book.setBackground(Color.decode("#D62027"));
            book.setFont(new Font("Avenir", Font.PLAIN, 15));
            book.setPreferredSize(new Dimension(40, 40));
            book.setOpaque(true);

            buttonPanel = new JPanel();
            buttonPanel.setLayout(new BorderLayout());
            buttonPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
            buttonPanel.setBackground(Color.WHITE);


            JPanel gridPanelTwo = new JPanel();
            gridPanelTwo.setLayout(new GridBagLayout());
            c = new GridBagConstraints();
            gridPanelTwo.setBorder(new EmptyBorder(0, 20, 20, 20));
            gridPanelTwo.setBackground(Color.WHITE);

            c.weightx = 1.0;
            c.fill = GridBagConstraints.HORIZONTAL;
            c.gridx = 0;
            c.gridy = 0;
            gridPanelTwo.add(flightLabel, c);

            c.anchor = GridBagConstraints.FIRST_LINE_START;
            c.fill = GridBagConstraints.HORIZONTAL;
            c.weighty = 0.1;
            c.gridx = 0;
            c.gridy = 1;
            gridPanelTwo.add(flightFieldsPanel, c);

            c.anchor = GridBagConstraints.FIRST_LINE_START;
            c.fill = GridBagConstraints.HORIZONTAL;
            c.weighty = 0.1;
            c.gridx = 1;
            c.gridy = 1;
            gridPanelTwo.add(flightFieldsTwoPanel, c);

            JPanel bookFlight = new JPanel();
            bookFlight.setLayout(new BorderLayout(10, 15));
            bookFlight.setBorder(new EmptyBorder(0, 20, 20, 20));
            bookFlight.setBackground(Color.WHITE);
            bookFlight.add(gridPanelTwo, BorderLayout.CENTER);
            bookFlight.add(book, BorderLayout.SOUTH);

            this.setLayout(new BorderLayout(10, 15));
            this.setBorder(new EmptyBorder(0, 0, 0, 0));
            this.setBackground(Color.WHITE);
            this.add(header, BorderLayout.NORTH);
            this.add(bookFlight, BorderLayout.SOUTH);
    }
    
    public JButton getLogoutBtn(){
        return logOut;
    }
    public JButton getBookingBtn(){
        return book;
    }
    public String getDepartureDate(){
        return departureDateField.getText();
    }
    public String getOriginDate(){
        return returnDateField.getText();
    }
    public String getOrigin(){
        return String.valueOf(flightOriginField.getSelectedItem());
    }
    public String getDestination(){
        return String.valueOf(flightDestinationField.getSelectedItem());
    }
}
