import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

/**
 * Created by Administrator on 2017-04-25.
 */
public class AddInvoice {
    private JPanel Invoice;
    private JTextField productField;
    private JComboBox clientList;
    private JComboBox typeBList;
    private JComboBox typeAList;
    private JTextField valueField;
    private JTextField taxField;
    private JButton addButton;
    private JLabel idLabel;
    private JSpinner amountSpinner;

    public AddInvoice() {
        // Lista Klientów
        // Dodawanie elementow do listy w GUI
        // To może być wczytywane z pliku później, albo z bazy jakiejś
        clientList.addItem("[0] Ktos tam");
        clientList.addItem("[1] Ktos tam inny");
        clientList.addItem("[2] Ktos tam całkiem inny");


        // Automatyczne generowanie numeru faktury na początku
        // Oraz stworzenie nowego obiektu faktury
        // Może od potem zostać zapisany do pliku(Invoice.saveToFile) lub bazy(Invoice.write)
        Invoice invoice = new Invoice();

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                invoice.setProduct(productField.getText());
                invoice.setAmount((int) amountSpinner.getValue());
                invoice.setValue(Float.parseFloat(valueField.getText()));
                invoice.setTax(Float.parseFloat(taxField.getText()));
                invoice.setClientid(clientList.getSelectedIndex());
                invoice.setTypeA((String) typeAList.getSelectedItem());
                invoice.setTypeB((String) typeBList.getSelectedItem());
                idLabel.setText(invoice.generateNumber());

                invoice.saveToFile();
            }
        });
    }

    public JPanel getInvoice() {
        return Invoice;
    }
}