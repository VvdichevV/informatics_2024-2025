import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.ArrayList;

public class Inventory {
    private ArrayList<Product> products; // List to store products in the inventory
    private int space; // Maximum number of products allowed in the inventory

    public Inventory(int space) {
        this.space = space;
        this.products = new ArrayList<Product>();
    }

    // Adds a product to the inventory if space is available
    void addProduct(Product product, JTextArea textArea) {
        if (products.size() < space) {
            products.add(product);
            textArea.setText("Product added successfully!");
        } else {
            textArea.setText("No space available in inventory!");
        }
    }

    // Updates the details of an existing product
    void updateProduct(String name, double price, int quantity, JTextArea textArea) {
        for (Product i : products) {
            if (i.getName().equals(name)) {
                i.setPrice(price);
                i.setQuantity(quantity);
                textArea.setText("Product updated successfully!");
                break;
            }
        }
        textArea.setText("There's no such product with that name!");

    }

    // Displays all products in the inventory
    void displayProducts(JTextArea textArea) {
        if (products.isEmpty()) {
            textArea.setText("No products in the inventory.");
        } else {
            textArea.setText(""); // Clear the text area
            for (Product i : products) {
                i.displayDetails(textArea); // Append each product's details
            }
        }
    }

    public static void main(String[] args) {
        Inventory inventory = new Inventory(3); // Create an inventory with space for 3 products
        JFrame frame = new JFrame("Inventory Management System");
        frame.setSize(1200, 800);
        frame.setLayout(new GridLayout(6, 3));

        // Panel to display messages
        JPanel text = new JPanel(new FlowLayout());
        JTextArea textArea = new JTextArea(60, 30);
        textArea.setFont(new Font("Arial", Font.BOLD, 18));
        textArea.setForeground(Color.RED);
        text.add(textArea);

        // Panel for input fields
        JPanel textPanel = new JPanel(new FlowLayout());
        JTextField textFieldName = new JTextField("Name", 20);
        JTextField textFieldPrice = new JTextField("Price", 20);
        JTextField textFieldQuantity = new JTextField("Quantity", 20);
        textPanel.add(textFieldName);
        textPanel.add(textFieldPrice);
        textPanel.add(textFieldQuantity);

        // Panel for the "Add Product" button
        JPanel addProduct = new JPanel(new FlowLayout());
        JButton addProductButton = new JButton("Add Product");
        buttonStyle(addProductButton);
        addProduct.add(addProductButton);

        // Panel for the "Update Product" button
        JPanel updateProduct = new JPanel(new FlowLayout());
        JButton updateProductButton = new JButton("Update Product");
        buttonStyle(updateProductButton);
        updateProduct.add(updateProductButton);

        // Panel for the "Display Products" button
        JPanel displayProducts = new JPanel(new FlowLayout());
        JButton displayProductsButton = new JButton("Display Products");
        buttonStyle(displayProductsButton);
        displayProducts.add(displayProductsButton);

        // Footer with the best programmer(me)'s name
        JPanel name = new JPanel(new FlowLayout());
        JLabel nameLabel = new JLabel("Made by Victor Dichev ;)");
        nameLabel.setFont(new Font("Algerian", Font.BOLD | Font.ITALIC, 22));
        name.add(nameLabel);

        // Adding panels to the frame
        frame.add(text);
        frame.add(textPanel);
        frame.add(addProduct);
        frame.add(updateProduct);
        frame.add(displayProducts);
        frame.add(name);
        frame.setVisible(true);

        // Action listener for "Add Product" button
        addProductButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = textFieldName.getText();
                double price = Double.parseDouble(textFieldPrice.getText());
                int quantity = Integer.parseInt(textFieldQuantity.getText());

                // Check for negative values
                if (price < 0 || quantity < 0) {
                    textArea.setText("No negative values!");
                    return;
                }

                inventory.addProduct(new Product(name, price, quantity), textArea);
            }
        });

        // Action listener for "Update Product" button
        updateProductButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = textFieldName.getText();
                double price = Double.parseDouble(textFieldPrice.getText());
                int quantity = Integer.parseInt(textFieldQuantity.getText());

                // Check for negative values
                if (price < 0 || quantity < 0) {
                    textArea.setText("No negative values!");
                    return;
                }

                inventory.updateProduct(name, price, quantity, textArea);
            }
        });

        // Action listener for "Display Products" button
        displayProductsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                inventory.displayProducts(textArea);
            }
        });
    }

    // Applies consistent styling to buttons
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

    // Sets the price of the product
    void setPrice(double price) {
        this.price = price;
    }

    // Sets the quantity of the product
    void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Returns the name of the product
    String getName() {
        return this.name;
    }

    // Returns the price of the product
    double getPrice() {
        return this.price;
    }

    // Returns the quantity of the product
    int getQuantity() {
        return this.quantity;
    }

    // Appends the product details to the JTextArea
    void displayDetails(JTextArea textArea) {
        textArea.append("Name: " + this.name + ", Price: " + this.price + ", Quantity: " + this.quantity + "\n");
    }
}
