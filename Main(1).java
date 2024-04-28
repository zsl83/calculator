
/* References
 https://www.youtube.com/watch?v=dfhmTyRTCSQ
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements ActionListener {


    JFrame frame;

    JPanel panel1;


    JTextField textfield;

    JButton[] number = new JButton[10];
    JButton[] function = new JButton[9];
    JButton plus, minus, multiplication, divide;
    JButton decimal, equal, delete, clear, negative ;

    JPanel panel;

    Font font = new Font("Cambria", Font.BOLD, 40);


    double num1 = 0, num2 = 0, result = 0;
    char operator;


    Main() {


        panel1 = new JPanel();
        panel1.setBackground(new Color(60 , 60 ,120));
        panel1.setBounds(0,0,600 ,800);

        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(580, 800);
        frame.setLayout(null);

        textfield = new JTextField();
        textfield.setBounds(81, 70, 399, 80);
        textfield.setFont(font);
        textfield.setEditable(false);


        plus = new JButton("+");
        minus = new JButton("-");
        multiplication = new JButton("*");
        divide = new JButton("/");
        decimal= new JButton(".");
        equal = new JButton("=");
        delete = new JButton("Del");
        clear= new JButton("Clr");
        negative= new JButton("(-)");


        function[0] = plus;
        function[1] = minus;
        function[2] = multiplication;
        function[3] = divide;
        function[4] = decimal;
        function[5] = equal;
        function[6] = delete;
        function[7] = clear;
        function[8] = negative;


        for (int i = 0; i < 9; i++) {

            function[i].addActionListener(this);
            function[i].setFont(font);
            function[i].setFocusable(false);

        }


        for (int j = 0; j < 10; j++) {

            number[j] = new JButton(String.valueOf(j));
            number[j].addActionListener(this);
            number[j].setFont(font);
            number[j].setFocusable(false);

        }


        negative.setBounds(83, 650, 125,60);
        delete.setBounds(222, 650, 125, 60);
        clear.setBounds(361, 650, 123, 60);


        panel = new JPanel();
        panel.setBounds(80, 200, 400, 400);
        panel.setBackground(new Color(50,80,100));
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        frame.add(textfield);
        panel.add(number[1]);
        panel.add(number[2]);
        panel.add(number[3]);
        panel.add(plus);
        panel.add(number[4]);
        panel.add(number[5]);
        panel.add(number[6]);
        panel.add(minus);
        panel.add(number[7]);
        panel.add(number[8]);
        panel.add(number[9]);
        panel.add(multiplication);
        panel.add(decimal);
        panel.add(number[0]);
        panel.add(equal);
        panel.add(divide);


        frame.add(panel);


        frame.add(negative);
        frame.add(delete);
        frame.add(clear);


        frame.add(panel1);

        frame.setVisible(true);

    }


    public static void main(String[] args) {

        Main calc = new Main();

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < 10; i++) {

            if (e.getSource() == number[i]) {

                textfield.setText(textfield.getText().concat(String.valueOf(i)));

            }

        }

        if (e.getSource() == decimal) {

            textfield.setText(textfield.getText().concat("."));

        }

        if (e.getSource() == plus) {

            num1 = Double.parseDouble(textfield.getText());
            operator = '+';
            textfield.setText("");

        }

        if (e.getSource() == minus) {

            num1 = Double.parseDouble(textfield.getText());
            operator = '-';
            textfield.setText("");

        }

        if (e.getSource() == multiplication) {

            num1 = Double.parseDouble(textfield.getText());
            operator = '*';
            textfield.setText("");

        }

        if (e.getSource() == divide) {

            num1 = Double.parseDouble(textfield.getText());
            operator = '/';
            textfield.setText("");

        }

        if (e.getSource() == equal) {

            num2 = Double.parseDouble(textfield.getText());

            switch (operator) {

                case '+':
                    result = num1 + num2;
                    break;

                case '-':
                    result = num1 - num2;
                    break;

                case '*':
                    result = num1 * num2;
                    break;

                case '/':
                    result = num1 / num2;
                    break;

            }

            textfield.setText(String.valueOf(result));

            num1 = result;

        }

        if (e.getSource() == clear) {

            textfield.setText("");

        }

        if (e.getSource() == delete) {

            String string = textfield.getText();
            textfield.setText("");
            for (int j = 0; j < string.length() - 1; j++) {

                textfield.setText(textfield.getText() + string.charAt(j));

            }

        }

        if (e.getSource() == negative) {

            double num3 = Double.parseDouble(textfield.getText());
            num3 *= -1;
            textfield.setText(String.valueOf(num3));

        }

    }
}

