package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ListSelectionModel;

import static com.company.CarType.BENZINA;
import static com.company.CarType.MOTORINA;

public class InterfataMeniu {
    private static final int Label_width = 300;
    private static final int Input_Width = 165;
    private static final int Button_allignment = 30;
    private static final int Input_allignment = 120;
    public static final int List_Buttons_Allignment = 380;
    private static final int LIST_BUTTON_WIDTH = 150;
    private static int Label_allignment = 20;
    private static final int Field_Height = 25;
    private static final int Row_1 = 20;
    private static final int Row_2 = 70;
    private static final int Row_3 = 120;
    public static final int Row_4 = 150;
    public static final int Row_5 = 180;
    public static final int Row_6 = 200;
    public static final int Row_7 = 400;
    public static final int BUTTON_WIDTH = 200;
    private static JTextField carNameInput;
    private static JTextField serialNumberOfCarInput;
    private static JTextField horsePowerInput;

    private static JButton buttonAddCar;
    private static JButton buttonModify;
    private static JButton buttonExit;
    private static JButton btnSaveCar;
    private static JList<String> list;


    private static JRadioButton benzinaRadio;
    private static JRadioButton motorinaRadio;
    private static ButtonGroup radioGroup;
    private static JTextArea addressInput;

    private static JFrame frame;

    private static List<Object> carTypeList = new ArrayList<>();

    private static void goToAddPage(JPanel panel) {
        buttonAddCar.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        panel.removeAll();
                        panel.updateUI();
                        showAddPage(panel);
                    }
                }
        );
    }

    private static void showAddPage(JPanel panel) {
        JLabel carNameLabel = new JLabel("Nume Masina:");
        carNameLabel.setBounds(Label_allignment, Row_1, Label_width, Field_Height);
        panel.add(carNameLabel);

        carNameInput = new JTextField(20);
        carNameInput.setBounds(Input_allignment, Row_1, Input_Width, Field_Height);
        panel.add(carNameInput);

        JLabel serialNumberOfCarLabel = new JLabel("Numar Serie:");
        serialNumberOfCarLabel.setBounds(Label_allignment, Row_2, Label_width, Field_Height);
        panel.add(serialNumberOfCarLabel);

        InterfataMeniu.serialNumberOfCarInput = new JTextField(20);
        InterfataMeniu.serialNumberOfCarInput.setBounds(Input_allignment, Row_2, Input_Width, Field_Height);
        panel.add(InterfataMeniu.serialNumberOfCarInput);


        JLabel horsePowerLabel = new JLabel("Cai putere:");
        horsePowerLabel.setBounds(Label_allignment, Row_3, Label_width, Field_Height);
        panel.add(horsePowerLabel);

        horsePowerInput = new JTextField(20);
        horsePowerInput.setBounds(Input_allignment, Row_3, Input_Width, Field_Height);
        panel.add(horsePowerInput);

        JLabel typeOfEngine = new JLabel("Combustibil:");
        typeOfEngine.setBounds(Label_allignment, Row_4, Label_width, Field_Height);
        panel.add(typeOfEngine);

        radioGroup = new ButtonGroup();

        benzinaRadio = new JRadioButton();
        benzinaRadio.setText("Benzina");
        benzinaRadio.setBounds(100, Row_4, 80, Field_Height);

        motorinaRadio = new JRadioButton();
        motorinaRadio.setText("Motorina");
        motorinaRadio.setBounds(200, Row_4, 80, Field_Height);

        radioGroup.add(benzinaRadio);
        radioGroup.add(motorinaRadio);

        panel.add(benzinaRadio);
        panel.add(motorinaRadio);

        btnSaveCar = new JButton("Salveaza");
        btnSaveCar.setBounds(Button_allignment, Row_5, BUTTON_WIDTH, Field_Height);
        btnSaveCar.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Object carType = new Object();
                        carType.setNumeMasina(carNameInput.getText());
                        carType.setNumarSerie(serialNumberOfCarInput.getText());
                        carType.setCaiPutere(horsePowerInput.getText());
                        if(motorinaRadio.isSelected()) {
                            carType.setCombustibil(MOTORINA);
                        } else {
                            carType.setCombustibil(BENZINA);
                        }


                        carTypeList.add(carType);

                        carNameInput.getText();

                        panel.removeAll();
                        panel.updateUI();
                        showMenuPage(panel);
                    }
                }
        );
        panel.add(btnSaveCar);

        goToMenuPage(panel);
    }

    private static void showModified(JPanel panel, Object carType) {
        JLabel carNameLabel = new JLabel("Nume Masina:");
        carNameLabel.setBounds(Label_allignment, Row_1, Label_width, Field_Height);
        panel.add(carNameLabel);

        carNameInput = new JTextField(20);
        carNameInput.setBounds(Input_allignment, Row_1, Input_Width, Field_Height);
        carNameInput.setText(carType.getNumeMasina());
        panel.add(carNameInput);

        JLabel serialNumberOfCarLabel = new JLabel("Numar Serie:");
        serialNumberOfCarLabel.setBounds(Label_allignment, Row_2, Label_width, Field_Height);
        panel.add(serialNumberOfCarLabel);

        InterfataMeniu.serialNumberOfCarInput = new JTextField(20);
        InterfataMeniu.serialNumberOfCarInput.setBounds(Input_allignment, Row_2, Input_Width, Field_Height);
        serialNumberOfCarInput.setText(carType.getNumarSerie());
        panel.add(InterfataMeniu.serialNumberOfCarInput);


        JLabel horsePowerLabel = new JLabel("Cai putere:");
        horsePowerLabel.setBounds(Label_allignment, Row_3, Label_width, Field_Height);
        panel.add(horsePowerLabel);

        horsePowerInput = new JTextField(20);
        horsePowerInput.setBounds(Input_allignment, Row_3, Input_Width, Field_Height);
        horsePowerInput.setText(carType.getCaiPutere());
        panel.add(horsePowerInput);

        JLabel typeOfEngine = new JLabel("Combustibil:");
        typeOfEngine.setBounds(Label_allignment, Row_4, Label_width, Field_Height);
        panel.add(typeOfEngine);

        radioGroup = new ButtonGroup();

        benzinaRadio = new JRadioButton();
        benzinaRadio.setText("Benzina");
        benzinaRadio.setBounds(100, Row_4, 80, Field_Height);
        if(carType.getCombustibil().equals(BENZINA))
            benzinaRadio.setSelected(true);

        motorinaRadio = new JRadioButton();
        motorinaRadio.setText("Motorina");
        motorinaRadio.setBounds(200, Row_4, 80, Field_Height);
        if(carType.getCombustibil().equals(MOTORINA))
            benzinaRadio.setSelected(true);

        radioGroup.add(benzinaRadio);
        radioGroup.add(motorinaRadio);

        panel.add(benzinaRadio);
        panel.add(motorinaRadio);

        btnSaveCar = new JButton("Salveaza");
        btnSaveCar.setBounds(Button_allignment, Row_5, BUTTON_WIDTH, Field_Height);
        btnSaveCar.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        carType.setNumeMasina(carNameInput.getText());
                        carType.setNumarSerie(serialNumberOfCarInput.getText());
                        carType.setCaiPutere(horsePowerInput.getText());
                        if(motorinaRadio.isSelected()) {
                            carType.setCombustibil(MOTORINA);
                        } else {
                            carType.setCombustibil(BENZINA);
                        }




                        panel.removeAll();
                        panel.updateUI();
                        showListPage(panel);
                    }
                }
        );
        panel.add(btnSaveCar);

        goToMenuPage(panel);
    }

    private static void goToMenuPage(JPanel panel) {
        btnSaveCar.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        panel.removeAll();
                        panel.updateUI();
                        showMenuPage(panel);
                    }
                }
        );
    }


    public static JPanel buildPanel() {
        JFrame frame = new JFrame("Meniu:");
        frame.setSize(600, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);




        JPanel panel = new JPanel();
        frame.add(panel);

        showMenuPage(panel);


        frame.setVisible(true);

        return panel;
    }

    private static void showMenuPage(JPanel panel) {
        panel.setLayout(null);

        buttonAddCar = new JButton("Adauga o Masina:");
        buttonAddCar.setBounds(Button_allignment, Row_1, BUTTON_WIDTH, Field_Height);
        panel.add(buttonAddCar);

        buttonModify = new JButton("Lista masini:");
        buttonModify.setBounds(Button_allignment, Row_2, BUTTON_WIDTH, Field_Height);
        panel.add(buttonModify);

        buttonExit = new JButton("Exit");
        buttonExit.setBounds(Button_allignment, Row_3, BUTTON_WIDTH, Field_Height);
        buttonExit.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.exit(0);
                    }
                }
        );

        panel.add(buttonExit);

        goToAddPage(panel);

        goToListPage(panel);


    }

    private static void showListPage(JPanel panel) {
        DefaultListModel<String> carListModel = new DefaultListModel<>();

        carTypeList.forEach(carType -> carListModel.addElement(carType.getNumeMasina() + " " + carType.getNumarSerie()));


        JList<String> list = new JList<>(carListModel);
        list.setBounds(Button_allignment,Row_1, 300,500);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        panel.add(list);


        JButton buttonModify = new JButton("Modify");
        buttonModify.setBounds(List_Buttons_Allignment, Row_1, LIST_BUTTON_WIDTH, Field_Height);
        panel.add(buttonModify);
        buttonModify.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String selectedValue = list.getSelectedValue();
                        String[] carTypes = selectedValue.split(" ");

                        carTypeList.forEach(carType -> {
                            if (carType.getNumeMasina().equals(carTypes[0]) && carType.getNumarSerie().equals(carTypes[1])) {

                                panel.removeAll();
                                panel.updateUI();
                                showModified(panel, carType);


                            }
                        });

                    }
                }
        );

        JButton buttonDelete = new JButton("Delete");
        buttonDelete.setBounds(List_Buttons_Allignment, Row_2, LIST_BUTTON_WIDTH, Field_Height);
        buttonDelete.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        carListModel.removeElementAt(list.getSelectedIndex());
                        String selectedValue = list.getSelectedValue();
                        String[] carTypes = selectedValue.split(" ");

                        carTypeList.forEach(carType ->{
                            if(carType.getNumeMasina().equals(carTypes[0]) && carType.getNumarSerie().equals(carTypes[1])) {
                                carTypeList.remove(carType);


                            }
                        }
                        );
                        carListModel.clear();
                        carTypeList.forEach(carType -> carListModel.addElement(carType.getNumeMasina() + " " + carType.getNumarSerie()));
                        //carListModel.removeElementAt(list.getSelectedIndex());
                         panel.removeAll();
                        panel.updateUI();

                    }
                }
        );
        panel.add(buttonDelete);

        JButton buttonGoBackMenu = new JButton("Exit to Menu");
        buttonGoBackMenu.setBounds(List_Buttons_Allignment, Row_3, LIST_BUTTON_WIDTH, Field_Height);
        panel.add(buttonGoBackMenu);
        buttonGoBackMenu.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        panel.removeAll();
                       panel.updateUI();
                        showMenuPage(panel);
                    }
                }
        );


    }


    private static void goToListPage(JPanel panel) {
        buttonModify.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        panel.removeAll();
                        panel.updateUI();
                        showListPage(panel);
                    }
                }
        );

    }
}
