package Product;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProdcutionMain {

    public static void main(String[] args) {
        // JFrame 생성 Windwo
        JFrame frame = new JFrame("자동차 모터 생산 공정");

        // Layout
        frame.setLayout(new FlowLayout());
        frame.setSize(300, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Text Field and Label
        JLabel motorAssemblyLabel = new JLabel("Motor Assembly 수량: ");
        JTextField mototAssemblyFiled = new JTextField(10);

        JLabel motorTestLabel = new JLabel("Motor Test 수량: ");
        JTextField mototTestFiled = new JTextField(10);

        JLabel motorPackingLabel = new JLabel("Motor Packing 수량: ");
        JTextField mototPackingFiled = new JTextField(10);

        JLabel motorShippingLabel = new JLabel("Shipping 수량: ");
        JTextField mototShippingFiled = new JTextField(10);

        // Button
        JButton calculateButton = new JButton("Shipping 수량 계산");

        // Print Result
        JTextArea resultArea = new JTextArea(5, 20);
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);

        // Components
        frame.add(motorAssemblyLabel);
        frame.add(motorTestLabel);
        frame.add(motorShippingLabel);

        //
        frame.setVisible(true);
    }
}
