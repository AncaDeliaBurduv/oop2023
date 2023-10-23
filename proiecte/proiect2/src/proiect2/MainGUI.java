package proiect2;

import proiect2.entities.Flight;
import proiect2.entities.Passenger;
import proiect2.entities.Ticket;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainGUI extends JFrame {
    public ArrayList<Passenger> passengers = new ArrayList<>();
    public  ArrayList<Ticket> tickets = new ArrayList<>();
    private JTextField operatorInput;
    private JTextField idInput;
    private JTextField departureInput;
    private JTextField destinationInput;
    private JTextField priceInput;
    private JLabel operatorLabel;
    private JLabel idLabel;
    private JLabel departureLabel;
    private JLabel destinationLabel;
    private JLabel priceLabel;
    private JButton addFligthButton;
    private JPanel MainPanel;
    private JTextField firstNameInput;
    private JTextField lastNameInput;
    private JTextField emailInput;
    private JButton bookingButton;
    private JLabel firstNameLabel;
    private JLabel lastNameLabel;
    private JLabel emailLabel;
    private JList<Flight> flightList;
    private JButton flightInfoButton;
    private JLabel passengersLabel;
    private JLabel passengersList;
    private JPanel passengerListPanel;
    private JScrollPane passListScroll;
    private JButton editFlightButton;
    private DefaultListModel<Flight> flightListModel = new DefaultListModel<>();

    public MainGUI(){
        setContentPane(MainPanel);
        setTitle("Proiect 2");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800,600);
        setLocationRelativeTo(null);
        setVisible(true);

        flightList.setModel(flightListModel);
        flightList.setCellRenderer(new DefaultListCellRenderer());
        flightList.setVisible(true);

        //adaugare valori initiale
        flightListModel.addElement(new Flight("WizzAir",123,"Cluj-Napoca",
                "London", 456.78));
        flightListModel.addElement(new Flight("RyanAir",445,"Madrid",
                "Berlin", 631.99));

        //adaugare zbor la lista de zboruri
        addFligthButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id=0;
                double price=0;
                boolean validId=false, validPrice=false;
                String operator = operatorInput.getText();
                try {
                    id = Integer.parseInt(idInput.getText());
                    validId=true;
                }
                catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(MainGUI.this,"ID must be an integer");
                }
                String departure = departureInput.getText();
                String destination = destinationInput.getText();
                try {
                    price = Double.parseDouble(priceInput.getText());
                    validPrice=true;
                }
                catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(MainGUI.this,"Invalid price input");
                }
                if(!operator.isEmpty() && !departure.isEmpty() && !destination.isEmpty() && validId &&validPrice) {
                    flightListModel.addElement(new Flight(operator, id, departure, destination, price));
                }
            }
        });

        //efectuare rezervare
        bookingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!firstNameInput.getText().isEmpty() && !lastNameInput.getText().isEmpty()) {
                    if (null != flightList.getSelectedValue()) {
                        if (!flightList.getSelectedValue().isFull()) {
                            Passenger p=Proiect2Util.getPassangerFromList(passengers,firstNameInput.getText(),
                                    lastNameInput.getText());
                            //nu se creaza pasager nou daca deja exista
                            if(null==p) {
                                if (emailInput.getText().isEmpty()) {
                                    p = new Passenger(firstNameInput.getText(), lastNameInput.getText());
                                } else {
                                    if (emailInput.getText().matches("[A-Za-z0-9_.-]{1,64}@[A-Za-z0-9-]{1,64}\\.[A-Za-z]{2,10}")) {
                                        p = new Passenger(firstNameInput.getText(), lastNameInput.getText(), emailInput.getText());
                                    } else {
                                        JOptionPane.showMessageDialog(MainGUI.this, "Invalid email could " +
                                                "not be added");
                                        p = new Passenger(firstNameInput.getText(), lastNameInput.getText());
                                    }
                                }
                                passengers.add(p);
                            }
                            flightList.getSelectedValue().addPassenger();
                            tickets.add(new Ticket(p, flightList.getSelectedValue()));
                            //modificare label cu lista de pasageri
                            StringBuffer s = new StringBuffer(passengersList.getText());
                            s.delete(passengersList.getText().length() - 7, passengersList.getText().length());
                            s.append(p.toString());
                            s.append("<br/>");
                            s.append("</html>");
                            passengersList.setText(s.toString());
                        } else {
                            JOptionPane.showMessageDialog(MainGUI.this, "entities.Flight " +
                                    flightList.getSelectedValue() + " is fully booked.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(MainGUI.this, "Please select flight");
                    }
                }
                else {
                    JOptionPane.showMessageDialog(MainGUI.this, "Please enter your full name");
                }
            }
        });
        //afisare informatii despre zbor
        flightInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(MainGUI.this, flightList.getSelectedValue().fullInfo());
            }
        });

        //modificare label cu lista de pasageri la selectarea altui zbor
        flightList.getSelectionModel().addListSelectionListener(e -> {
            StringBuffer passListDisplay=new StringBuffer("<html>");
            for(Ticket ticket: tickets){
                if(ticket.getFlight().equals(flightList.getSelectedValue())){
                    passListDisplay.append(ticket.getPassenger().toString());
                    passListDisplay.append("<br/>");
                }
            }
            passListDisplay.append("</html>");
            passengersList.setText(passListDisplay.toString());
        });

        //modificare zbor selectat cu valori nenule
        editFlightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!operatorInput.getText().isEmpty()){
                    flightList.getSelectedValue().setOperator(operatorInput.getText());
                }
                if(!idInput.getText().isEmpty()){
                    int id=Integer.parseInt(idInput.getText());
                    flightList.getSelectedValue().setFlightId(id);
                }
                if(!departureInput.getText().isEmpty()){
                    flightList.getSelectedValue().setDeparture(departureInput.getText());
                }
                if(!destinationInput.getText().isEmpty()){
                    flightList.getSelectedValue().setDestination(destinationInput.getText());
                }
                if(!priceInput.getText().isEmpty()){
                    double price=Double.parseDouble(priceInput.getText());
                    flightList.getSelectedValue().setBasePrice(price);
                }
            }
        });
    }
}
