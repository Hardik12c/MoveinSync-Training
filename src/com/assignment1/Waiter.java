package com.assignment1;

import javax.swing.*;
import java.util.HashMap;
import java.awt.Color;
import java.awt.Font;
import javax.swing.text.html.HTMLEditorKit;

public class Waiter {

    Chef kitchen=new Chef();
    static int acknowledgment=1;
    public static void main(String[] args) {

        Waiter w = new Waiter();
        int mxtime = Integer.MIN_VALUE;


//      Mapping of the items to not use the if else more time
        HashMap<Integer, String> mpp = new HashMap<>();
        HashMap<String, Integer> smallmpp = new HashMap<>();
        smallmpp.put("Sandwhich", 5);
        smallmpp.put("Coffee", 3);
        smallmpp.put("Cereal", 3);
        smallmpp.put("Pizza", 7);

        mpp.put(1, "Sandwhich");
        mpp.put(2, "Coffee");
        mpp.put(3, "Cereal");
        mpp.put(4, "Pizza");


//        Making a complete panel to hold the Ids of the item
        String message = "<html><body><p>Here is the menu sir what you want to order sir.</p><p>1  Sandwhich</p><p>2  Coffee</p><p>3  Cereal</p><p>4  Pizza</p><p>Please Enter the id of the item you want</p><p>Enter -1 to complete your order</p></body></html>";

        // Create a panel to hold the input fields
        JPanel panel = new JPanel();
        panel.add(new JLabel("Item Id:"));
        JTextField IdField = new JTextField(10);
        panel.add(IdField);
        JTextPane textPane = new JTextPane();
        HTMLEditorKit kit = new HTMLEditorKit();
        textPane.setEditorKit(kit);
        textPane.setText(message);
        textPane.setEditable(false);
        textPane.setOpaque(false);
        textPane.setFont(new Font("Dialog", Font.PLAIN, 14));
        textPane.setForeground(Color.BLACK);
        Object[] components = {textPane, panel};

    while(true){
        while (true) {
            int option = JOptionPane.showConfirmDialog(null, components, "", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            if (option == JOptionPane.OK_CANCEL_OPTION) break;
            if (option == JOptionPane.OK_OPTION) {
                String input = IdField.getText();
                if (input == null) break;
                if (!input.equals("-1") && (input.equals("") || input.length() > 1 || !Character.isDigit(input.charAt(0)))) {
                    JOptionPane.showMessageDialog(null, "Please Enter a valid Order Id \uD83D\uDE21");
                    IdField.setText("");
                    continue;
                }
                Integer Id = Integer.parseInt(input);
                if (Id == -1) break;
                IdField.setText("");
                if (mpp.containsKey(Id)) {
                    mxtime = Integer.max(mxtime, smallmpp.get(mpp.get(Id)));
                    w.kitchen.processThefood(smallmpp.get(mpp.get(Id)));
                } else {
                    JOptionPane.showMessageDialog(null, "Please Enter a valid Order Id \uD83D\uDE21");
                }
            }
        }
        if (w.kitchen.getthetime() == null) {
            JOptionPane.showMessageDialog(null, "You didn't ordered anything");
        } else {
            JOptionPane.showMessageDialog(null, "Your order number is " + w.acknowledgment + " and order will get ready in " + w.kitchen.getthetime());
            w.acknowledgment++;
        }
        String order = JOptionPane.showInputDialog("Please Enter 0 to make a new order");
        if (order.equals("0")) continue;
        break;
    }
    }

}
