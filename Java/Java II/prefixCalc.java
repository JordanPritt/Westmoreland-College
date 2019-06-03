import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

/**
 * Created by: Jordan Pritt Date: 4/26/17
 */
public class PrefixCalc extends JFrame {

  // variables to work with in application
  private JTextField txtEquation = new JTextField(10);
  private JTextField txtResults = new JTextField(10);
  private JTextField txtEnterEquation = new JTextField(10);
  private JLabel lblEquation = new JLabel("Prefix Equation: ");
  private JLabel lblResults = new JLabel("Results: ");
  private JLabel lblEnterEquation = new JLabel("Enter Prefix Equation: ");

  private PrefixCalc() {
    // set a title
    setTitle("Prefix Calculator");

    // set width height
    setSize(50, 200);

    // create a panel for content
    JPanel panel = new JPanel(new GridLayout(3, 2));
    panel.setBorder(new EmptyBorder(10, 10, 10, 10));

    // set properties for textField
    txtEquation.setEditable(false);
    txtResults.setEditable(false);

    panel.add(lblEquation);
    panel.add(txtEquation);
    panel.add(lblResults);
    panel.add(txtResults);
    panel.add(lblEnterEquation);
    panel.add(txtEnterEquation);

    // add panel to window
    add(panel, BorderLayout.CENTER);

    //
    ActionListener text = new textEntered();

    // Process entered text
    txtEnterEquation.addActionListener(text);

    // pack, set close app on exit, and load in center of screen
    pack();
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setVisible(true);

  }

  // implement action listener to check for texField changes
  private class textEntered implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      String pExpr = txtEnterEquation.getText();
      Node exprTree = buildExpr(new Scanner(pExpr));
      int value = eval(exprTree);
      txtResults.setText(String.valueOf(value));
      txtEquation.setText(setExpBox());
    }
  }

  // class for binary tree node
  private class Node {
    String value;
    Node left, right;

    Node(String a, Node b, Node c) {
      value = a;
      left = b;
      right = c;
    }
  }

  // set expression box
  private String setExpBox() {
    String exp = txtEnterEquation.getText();
    return exp;
  }

  // build binary tree
  private Node buildExpr(Scanner input) {
    String s = input.next();
    if (isNumber(s))
      return new Node(s, null, null);
    else {
      Node left = buildExpr(input);
      Node right = buildExpr(input);
      return new Node(s, left, right);
    }
  }

  // evaluate for the prefix expression
  private int eval(Node tree) {
    if (tree.left == null && tree.right == null) {
      return Integer.parseInt(tree.value);
    } else {
      int left = eval(tree.left);
      int right = eval(tree.right);
      if (tree.value.equals("*")) {
        return left * right;
      }
      if (tree.value.equals("+")) {
        return left + right;
      }
      if (tree.value.equals("-")) {
        return left - right;
      }
      if (tree.value.equals("/")) {
        return left / right;
      }
    }

    return 0;
  }

  // check if string is number or prefix
  private boolean isNumber(String s) {
    try {
      double num = Double.parseDouble(s);
    } catch (NumberFormatException nfe) {
      return false;
    }
    return true;
  }

  public static void main(String[] args) {
    new PrefixCalc();
  }

}