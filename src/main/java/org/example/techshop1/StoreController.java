package org.example.techshop1;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class StoreController {
    @FXML private ListView<String> productsList;
    @FXML private ListView<String> cartList;
    @FXML private Label totalLabel;

    @FXML
    public void initialize() {
        productsList.getItems().addAll(
                "Телевизор Samsung - 45000 руб",
                "Холодильник LG - 32000 руб",
                "Микроволновка Bosch - 8500 руб",
                "Пылесос Dyson - 28900 руб",
                "Кофемашина DeLonghi - 21500 руб"
        );
    }

    @FXML
    private void addToCart() {
        String selected = productsList.getSelectionModel().getSelectedItem();
        if (selected != null) {
            cartList.getItems().add(selected);
            updateTotal();
        }
    }

    @FXML
    private void clearCart() {
        cartList.getItems().clear();
        updateTotal();
    }


    @FXML
    private void checkout() {
        if (!cartList.getItems().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Покупка");
            alert.setHeaderText("Спасибо за покупку!");
            alert.setContentText("Сумма: " + totalLabel.getText());
            alert.showAndWait();
            cartList.getItems().clear();
            updateTotal();
        }
    }

    private void updateTotal() {
        double total = 0;
        for (String item : cartList.getItems()) {
            String priceStr = item.split(" - ")[1].replace(" руб", "");
            total += Double.parseDouble(priceStr);
        }
        totalLabel.setText(String.format("Итого: %.2f руб", total));
    }
}