package conversor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class ConversorDivisas {

    private JFrame frame;

    public ConversorDivisas() {
        frame = new JFrame("Menú Principal");

        String[] options = {"Conversor de moneda", "Conversor de temperatura"};
        int choice = JOptionPane.showOptionDialog(frame, "Seleccione una opción de conversión", "Menú Principal", JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

        if (choice == 0) {
            showCurrencyConversionDialog();
        } else if (choice == 1) {
            showTemperatureConversionDialog();
        }
    }

    private void showCurrencyConversionDialog() {
        JLabel amountLabel = new JLabel("Ingresa la cantidad de dinero que deseas convertir");
        JTextField amountTextField = new JTextField(10);

        Object[] message = {amountLabel, amountTextField};

        int option = JOptionPane.showConfirmDialog(frame, message, "Conversor de moneda", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE);

        if (option == JOptionPane.OK_OPTION) {
            String amountString = amountTextField.getText();
            if (!isValidAmount(amountString)) {
                JOptionPane.showMessageDialog(frame, "El valor ingresado no es válido. Inténtalo nuevamente.");
                showCurrencyConversionDialog();
                return;
            }

            double amount = Double.parseDouble(amountString);
            String[] options = {"De Pesos a Dólar", "De Pesos a Euros", "De Pesos a Libras", "De Pesos a Yen", "De Pesos a Won coreano",
                    "De Dólar a Pesos", "De Euros a Pesos", "De Libras a Pesos", "De Yen a Pesos", "De Won coreano a Pesos"};

            String selectedOption = (String) JOptionPane.showInputDialog(frame, "Elige la moneda a la que deseas convertir tu dinero", "Monedas", JOptionPane.PLAIN_MESSAGE,
                    null, options, options[0]);

            if (selectedOption != null) {
                double convertedAmount = 0.0;
                String currency = "";

                DecimalFormat decimalFormat = new DecimalFormat("#.##");

                switch (selectedOption) {
                    case "De Pesos a Dólar":
                        convertedAmount = amount / 4168; // Tasa de cambio estimada
                        currency = "Dólares";
                        break;
                    case "De Pesos a Euros":
                        convertedAmount = amount / 4552.08; // Tasa de cambio estimada
                        currency = "Euros";
                        break;
                    case "De Pesos a Libras":
                        convertedAmount = amount / 5296.07; // Tasa de cambio estimada
                        currency = "Libras";
                        break;
                    case "De Pesos a Yen":
                        convertedAmount = amount / 28.88; // Tasa de cambio estimada
                        currency = "Yenes";
                        break;
                    case "De Pesos a Won coreano":
                        convertedAmount = amount / 3.17; // Tasa de cambio estimada
                        currency = "Won coreanos";
                        break;
                    case "De Dólar a Pesos":
                        convertedAmount = amount * 4168; // Tasa de cambio estimada
                        currency = "Pesos";
                        break;
                    case "De Euros a Pesos":
                        convertedAmount = amount * 4552.08; // Tasa de cambio estimada
                        currency = "Pesos";
                        break;
                    case "De Libras a Pesos":
                        convertedAmount = amount * 5296.07; // Tasa de cambio estimada
                        currency = "Pesos";
                        break;
                    case "De Yen a Pesos":
                        convertedAmount = amount * 28.88; // Tasa de cambio estimada
                        currency = "Pesos";
                        break;
                    case "De Won coreano a Pesos":
                        convertedAmount = amount * 3.17; // Tasa de cambio estimada
                        currency = "Pesos";
                        break;
                }

                JOptionPane.showMessageDialog(frame, "Tienes " + decimalFormat.format(convertedAmount) + " " + currency);
                showContinueDialog();
            } else {
                JOptionPane.showMessageDialog(frame, "¡Programa terminado!");
                System.exit(0);
            }
        } else if (option == JOptionPane.CANCEL_OPTION || option == JOptionPane.CLOSED_OPTION) {
            JOptionPane.showMessageDialog(frame, "¡Programa terminado!");
            System.exit(0);
        }
    }

    private void showTemperatureConversionDialog() {
        JLabel temperatureLabel = new JLabel("Ingresa la temperatura que deseas convertir");
        JTextField temperatureTextField = new JTextField(10);

        Object[] message = {temperatureLabel, temperatureTextField};

        int option = JOptionPane.showConfirmDialog(frame, message, "Conversor de temperatura", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE);

        if (option == JOptionPane.OK_OPTION) {
            String temperatureString = temperatureTextField.getText();
            if (!isValidTemperature(temperatureString)) {
                JOptionPane.showMessageDialog(frame, "El valor ingresado no es válido. Inténtalo nuevamente.");
                showTemperatureConversionDialog();
                return;
            }

            double temperature = Double.parseDouble(temperatureString);
            String[] options = {"De Celsius a Fahrenheit", "De Celsius a Kelvin", "De Fahrenheit a Celsius", "De Fahrenheit a Kelvin",
                    "De Kelvin a Celsius", "De Kelvin a Fahrenheit"};

            String selectedOption = (String) JOptionPane.showInputDialog(frame, "Elige la unidad a la que deseas convertir la temperatura", "Unidades de temperatura", JOptionPane.PLAIN_MESSAGE,
                    null, options, options[0]);

            if (selectedOption != null) {
                double convertedTemperature = 0.0;
                String unit = "";

                DecimalFormat decimalFormat = new DecimalFormat("#.##");

                switch (selectedOption) {
                    case "De Celsius a Fahrenheit":
                        convertedTemperature = (temperature * 9 / 5) + 32;
                        unit = "Fahrenheit";
                        JOptionPane.showMessageDialog(frame, decimalFormat.format(temperature) + " Grados Celsius son " + decimalFormat.format(convertedTemperature) + " Grados Fahrenheit");
                        break;
                    case "De Celsius a Kelvin":
                        convertedTemperature = temperature + 273.15;
                        unit = "Kelvin";
                        JOptionPane.showMessageDialog(frame, decimalFormat.format(temperature) + " Grados Celsius son " + decimalFormat.format(convertedTemperature) + " Kelvin");
                        break;
                    case "De Fahrenheit a Celsius":
                        convertedTemperature = (temperature - 32) * 5 / 9;
                        unit = "Celsius";
                        JOptionPane.showMessageDialog(frame, decimalFormat.format(temperature) + " Grados Fahrenheit son " + decimalFormat.format(convertedTemperature) + " Grados Celsius");
                        break;
                    case "De Fahrenheit a Kelvin":
                        convertedTemperature = (temperature + 459.67) * 5 / 9;
                        unit = "Kelvin";
                        JOptionPane.showMessageDialog(frame, decimalFormat.format(temperature) + " Grados Fahrenheit son " + decimalFormat.format(convertedTemperature) + " Kelvin");
                        break;
                    case "De Kelvin a Celsius":
                        convertedTemperature = temperature - 273.15;
                        unit = "Celsius";
                        JOptionPane.showMessageDialog(frame, decimalFormat.format(temperature) + " Kelvin son " + decimalFormat.format(convertedTemperature) + " Grados Celsius");
                        break;
                    case "De Kelvin a Fahrenheit":
                        convertedTemperature = (temperature * 9 / 5) - 459.67;
                        unit = "Fahrenheit";
                        JOptionPane.showMessageDialog(frame, decimalFormat.format(temperature) + " Kelvin son " + decimalFormat.format(convertedTemperature) + " Grados Fahrenheit");
                        break;
                }

                showContinueDialog();
            } else {
                JOptionPane.showMessageDialog(frame, "¡Programa terminado!");
                System.exit(0);
            }
        } else if (option == JOptionPane.CANCEL_OPTION || option == JOptionPane.CLOSED_OPTION) {
            JOptionPane.showMessageDialog(frame, "¡Programa terminado!");
            System.exit(0);
        }
    }

    private void showContinueDialog() {
        int option = JOptionPane.showOptionDialog(frame, "¿Deseas continuar?", "Continuar", JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, new String[]{"Yes", "No", "Cancel"}, null);
        if (option == JOptionPane.YES_OPTION) {
            new ConversorDivisas();
        } else if (option == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(frame, "¡Programa terminado!");
            System.exit(0);
        } else if (option == JOptionPane.CANCEL_OPTION || option == JOptionPane.CLOSED_OPTION) {
            JOptionPane.showMessageDialog(frame, "¡Programa terminado!");
            System.exit(0);
        }
    }

    private boolean isValidAmount(String amountString) {
        try {
            double amount = Double.parseDouble(amountString);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isValidTemperature(String temperatureString) {
        try {
            double temperature = Double.parseDouble(temperatureString);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ConversorDivisas();
            }
        });
    }
}