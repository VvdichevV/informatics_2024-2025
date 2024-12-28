import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.ArrayList;

public class Inventory {
    private ArrayList<Product> products;
    private int space;

    public Inventory(int space) {
        this.space = space;
        this.products = new ArrayList<Product>();
    }

    void addProduct(Product product, JTextArea textArea) {
        if (products.size() < space) {
            products.add(product);
            textArea.setText("Product added successfully!");
        } else {
            textArea.setText("No space available in inventory!");
        }
    }

    void updateProduct(String name, double price, int quantity) {
        for (Product i : products) {
            if (i.getName().equals(name)) {
                i.setPrice(price);
                i.setQuantity(quantity);
                break;
            }
        }
    }

    void displayProducts(JTextArea textArea) {
        if (products.isEmpty()) {
            textArea.setText("No products in the inventory.");
        } else {
            textArea.setText("");
            for (Product i : products) {
                i.displayDetails(textArea);
            }
        }
    }

    public static void main(String[] args) {
        Inventory inventory = new Inventory(5);
        JFrame frame = new JFrame("Inventory Management System");
        frame.setSize(1200, 800);
        frame.setLayout(new GridLayout(6, 3));

        JPanel text = new JPanel(new FlowLayout());
        JTextArea textArea = new JTextArea(60, 30);
        textArea.setFont(new Font("Arial", Font.BOLD, 14));
        textArea.setForeground(Color.RED);
        text.add(textArea);

        JPanel textPanel = new JPanel(new FlowLayout());
        JTextField textFieldName = new JTextField("Name", 20);
        JTextField textFieldPrice = new JTextField("Price", 20);
        JTextField textFieldQuantity = new JTextField("Quantity", 20);
        textPanel.add(textFieldName);
        textPanel.add(textFieldPrice);
        textPanel.add(textFieldQuantity);

        JPanel addProduct = new JPanel(new FlowLayout());
        JButton addProductButton = new JButton("Add Product");
        buttonStyle(addProductButton);
        addProduct.add(addProductButton);

        JPanel updateProduct = new JPanel(new FlowLayout());
        JButton updateProductButton = new JButton("Update Product");
        buttonStyle(updateProductButton);
        updateProduct.add(updateProductButton);

        JPanel displayProducts = new JPanel(new FlowLayout());
        JButton displayProductsButton = new JButton("Display Products");
        buttonStyle(displayProductsButton);
        displayProducts.add(displayProductsButton);

        JPanel name = new JPanel(new FlowLayout());
        JLabel nameLabel = new JLabel("Made by Victor Dichev ;)");
        nameLabel.setFont(new Font("Algerian", Font.BOLD | Font.ITALIC, 22));
        name.add(nameLabel);

        frame.add(text);
        frame.add(textPanel);
        frame.add(addProduct);
        frame.add(updateProduct);
        frame.add(displayProducts);
        frame.add(name);
        frame.setVisible(true);

        addProductButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                    String name = textFieldName.getText();
                    double price = Double.parseDouble(textFieldPrice.getText());
                    int quantity = Integer.parseInt(textFieldQuantity.getText());
                    inventory.addProduct(new Product(name, price, quantity), textArea);
                }
        });

        updateProductButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = textFieldName.getText();
                double price = Double.parseDouble(textFieldPrice.getText());
                int quantity = Integer.parseInt(textFieldQuantity.getText());
                inventory.updateProduct(name, price, quantity);
                textArea.setText("Product " + name +  " updated successfully!");
            }
        });

        displayProductsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                inventory.displayProducts(textArea);
            }
        });


    }

    public static void buttonStyle(JButton button) {
        button.setFont(new Font("Arial", Font.BOLD, 32));
        button.setForeground(Color.BLUE);
    }
}

class Product {
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    void setPrice(double price) {
        this.price = price;
    }

    void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    String getName() {
        return this.name;
    }

    double getPrice() {
        return this.price;
    }

    int getQuantity() {
        return this.quantity;
    }

    void displayDetails(JTextArea textArea) {
        textArea.append("Name: " + this.name + ", Price: " + this.price + ", Quantity: " + this.quantity + "\n");
    }
}
