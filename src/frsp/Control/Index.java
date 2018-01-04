package frsp.Control;

import frsp.GUI.DiscountedBooking;
import frsp.GUI.ErrorPage;
import frsp.GUI.Login;
import frsp.GUI.Notification;
import frsp.GUI.SuccessPage;
import frsp.GUI.UserPage;
import frsp.Model.Booking;
import frsp.Model.BookingProcess;
import frsp.Model.DiscountProcess;
import frsp.Model.LoginProcess;
import frsp.Model.RegisterProcess;
import frsp.Model.Users;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Index {
    private static final String LOGIN_CARD = "login";
    private static final String USER_CARD = "userpage";
    private static final String SUCCESS_CARD  = "successpage";
    private static final String ERROR_CARD = "errorpage";
    
    private JFrame frame;
    private CardLayout cardLayout;
    private JPanel contentPane;
    private static String userID;
    private int discount;
    
    public Index(){
        frame = new JFrame("Flight Reservation System");
        cardLayout = new PageViewer();
        contentPane = new JPanel(cardLayout);
        Login loginPanel = new Login();
        contentPane.add(loginPanel, LOGIN_CARD);
        cardLayout.show(contentPane, LOGIN_CARD);
        loginPanel.getLoginBtn().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                loginControl(loginPanel);
            }
        });
        loginPanel.getRegisterBtn().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                registerControl(loginPanel);
            }
        });
        frame.add(contentPane, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(100, 10);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
    }
    private void loginControl(Login loginPanel){
        Users u = new Users(null,loginPanel.getLoginEmail(),loginPanel.getLoginPass());
        if(LoginProcess.hasAccount(u)){
            UserPage up = new UserPage();
            contentPane.add(up, USER_CARD);
            userID = LoginProcess.getLoginID();
            
            
            updateBooking(up, userID);
            cardLayout.show(contentPane, USER_CARD);
            frame.pack();
            up.getLogoutBtn().addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    cardLayout.show(contentPane, LOGIN_CARD);
                    loginPanel.setLoginEmpty();
                    frame.pack();
                }
            });
            up.getBookingBtn().addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    Booking b = new Booking(userID,up.getOrigin(),up.getDestination(),up.getDepartureDate(),up.getOriginDate(),"UM-66");
                    BookingProcess bp = new BookingProcess(b.getMiles(),b);
                    if((bp.verifyDate()) && (b.getMiles() != 0)){
                        if(bp.addBooking()){
                            SuccessPage sp = new SuccessPage("Successfully booked a flight.");
                            contentPane.add(sp, SUCCESS_CARD);
                            cardLayout.show(contentPane, SUCCESS_CARD);
                            sp.getReturnBtn().addActionListener(new ActionListener(){
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    updateBooking(up, userID);
                                    cardLayout.show(contentPane, USER_CARD);
                                    frame.pack();
                                }
                            });
                            frame.pack();
                        }else{
                            ErrorPage ep = new ErrorPage("Cannot enter input.");
                            contentPane.add(ep, ERROR_CARD);
                            loginPanel.setLoginEmpty();
                            ep.getReturnBtn().addActionListener(new ActionListener(){
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    cardLayout.show(contentPane, USER_CARD);
                                    frame.pack();
                                }
                            });
                            cardLayout.show(contentPane, ERROR_CARD);
                            frame.pack();
                        }
                    }else{
                        ErrorPage ep = new ErrorPage("Please select correct format of date or destination.");
                        contentPane.add(ep, ERROR_CARD);
                        loginPanel.setLoginEmpty();
                        ep.getReturnBtn().addActionListener(new ActionListener(){
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                cardLayout.show(contentPane, USER_CARD);
                                frame.pack();
                            }
                        });
                        cardLayout.show(contentPane, ERROR_CARD);
                        frame.pack();
                    }
                }
            });
            up.getCancelBtn().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent event) {
                            if (up.getTable().getSelectedRow() != -1) {
                                    String selectedObject = (String) up.getTable().getModel().getValueAt(up.getTable().getSelectedRow(), 0);
                                try {
                                    Booking.addData(Booking.removeElement(selectedObject));
                                } catch (IOException ex) {
                                    Logger.getLogger(Index.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                    try {
                                            up.getTableModel().removeRow(up.getTable().getSelectedRow());
                                    } catch (Exception e) {
                                            System.out.println(e);
                                    }
                            }
                    }
            });
            up.getCheckInBtn().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent event) {
                            if (up.getTable().getSelectedRow() != -1) {
                                    String selectedObject = (String) up.getTable().getModel().getValueAt(up.getTable().getSelectedRow(), 0);
                                try {
                                    Booking.addData(Booking.removeElement(selectedObject));
                                } catch (IOException ex) {
                                    Logger.getLogger(Index.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                    try {
                                            up.getTableModel().removeRow(up.getTable().getSelectedRow());
                                    } catch (Exception e) {
                                            System.out.println(e);
                                    }
                            }
                    }
            });
        }else{
            ErrorPage ep = new ErrorPage("Can not authenticate.");
            contentPane.add(ep, ERROR_CARD);
            loginPanel.setLoginEmpty();
            ep.getReturnBtn().addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    cardLayout.show(contentPane, LOGIN_CARD);
                    frame.pack();
                }
            });
            cardLayout.show(contentPane, ERROR_CARD);
            frame.pack();
        }
    }
    public void registerControl(Login loginPanel){
        Users r = new Users(loginPanel.getRegisterName(), loginPanel.getRegisterUsername(),loginPanel.getRegisterPass());
        if(!loginPanel.getRegisterName().equals("") && !loginPanel.getRegisterName().equals(null) ||
                !loginPanel.getRegisterUsername().equals("") && !loginPanel.getRegisterUsername().equals(null) ||
                !loginPanel.getRegisterPass().equals("") && !loginPanel.getRegisterPass().equals(null)
                ){
            RegisterProcess.createAccount(r);
            SuccessPage sp = new SuccessPage("Account has been created successfully");
            contentPane.add(sp, SUCCESS_CARD);
            cardLayout.show(contentPane, SUCCESS_CARD);
            sp.getReturnBtn().addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    loginPanel.setRegisterEmpty();
                    cardLayout.show(contentPane, LOGIN_CARD);
                    frame.pack();
                }
            });
            frame.pack();
        }else{
            ErrorPage ep = new ErrorPage("Cannot create account now!");
            contentPane.add(ep, ERROR_CARD);
            loginPanel.setRegisterEmpty();
            cardLayout.show(contentPane, ERROR_CARD);
            ep.getReturnBtn().addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    cardLayout.show(contentPane, LOGIN_CARD);
                    frame.pack();
                }
            });
            frame.pack();
        }
    }
    public void updateBooking(UserPage l, String id){
        l.getTableModel().setRowCount(0);
        String[] data = getAllBooking();
        if(data != null)
            for(String book : data){
                String[] getData = book.split("%");
                if(getData[0].equals(id)){
                    l.getTableModel().addRow(new Object[]{getData[1],getData[6],getData[2],getData[3],getData[4],getData[5],getData[7]});
                    l.setPanel();
                    DateFormat d = new SimpleDateFormat("yyyy-MM-dd");
                    Date d2 = new Date();
                    if(DiscountProcess.compareDate(getData[4],String.valueOf(d.format(d2)))){
                        try {
                            Booking.addData(Booking.removeElement(getData[1]));
                        } catch (IOException ex) {
                            Logger.getLogger(Index.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        giveDiscount(50);
                    }
                            
                    if(getData[4].equals(String.valueOf(d.format(d2))))
                        showNotification(getData[1],getData[6]);
                }
            }
    }
    public void showNotification(String id, String flightName){
        JFrame f = new JFrame("Notification!");
        Notification n = new Notification("You have a "+flightName+" ("+id+") flight today!");
        f.add(n);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        n.getReturnBtn().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
            }
        });
        f.pack();
        f.setVisible(true);
    }
    public String[] getAllBooking(){
        String[] bookings;
        try{
            FileReader f = new FileReader("Booking.dat");
            BufferedReader br = new BufferedReader(f);
            String s = br.readLine();
            if(!s.equals(null) && !s.equals(""))
                return bookings = s.split("£");
        }catch(IOException e){
            System.out.println(e);
        }
        return null;
    }
    public void giveDiscount(double discount){
        JFrame dis = new JFrame("Get 50% Discount");
        DiscountedBooking dp = new DiscountedBooking();
        dp.getBookingBtn().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Booking b = new Booking(userID,dp.getOrigin(),dp.getDestination(),dp.getDepartureDate(),dp.getOriginDate(),"UM-66");
                DiscountProcess d = new DiscountProcess(50,b.getMiles(),b);
                if((d.verifyDate()) && (b.getMiles() != 0)){
                    if(d.addBooking()){
                        dis.dispose();
                    }
                }
            }
        });
        dis.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        dis.add(dp);
        dis.setResizable(false);
        dis.pack();
        dis.setVisible(true);
    }
}
class PageViewer extends CardLayout {

    @Override
    public Dimension preferredLayoutSize(Container parent) {
            Component current = findCurrentComponent(parent);
            if (current != null) {
                    Insets insets = parent.getInsets();
                    Dimension pref = current.getPreferredSize();
                    pref.width += insets.left + insets.right;
                    pref.height += insets.top + insets.bottom;
                    return pref;
            }
            return super.preferredLayoutSize(parent);
    }

    public Component findCurrentComponent(Container parent) {
        for (Component comp : parent.getComponents()) {
                if (comp.isVisible()) {
                        return comp;
                }
        }
        return null;
    }
}