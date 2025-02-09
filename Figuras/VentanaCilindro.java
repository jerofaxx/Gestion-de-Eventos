package Figuras;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaCilindro extends JFrame implements ActionListener {
    private Container contenedor;
    private JLabel radio, altura, volumen, superficie, imagenLabel;
    private JTextField campoRadio, campoAltura;
    private JButton calcular;

    public VentanaCilindro() {
        setTitle("Cilindro");
        setSize(350, 580);
        setLocationRelativeTo(null);
        setResizable(false);
        inicio();
    }

    private void inicio() {
        contenedor = getContentPane();
        contenedor.setLayout(null);

        radio = new JLabel("Radio (cm):");
        radio.setBounds(20, 20, 135, 23);
        campoRadio = new JTextField();
        campoRadio.setBounds(120, 20, 135, 23);

        altura = new JLabel("Altura (cm):");
        altura.setBounds(20, 50, 135, 23);
        campoAltura = new JTextField();
        campoAltura.setBounds(120, 50, 135, 23);

        calcular = new JButton("Calcular");
        calcular.setBounds(120, 80, 135, 23);
        calcular.addActionListener(this);

        volumen = new JLabel("Volumen (cm³):");
        volumen.setBounds(20, 110, 200, 23);

        superficie = new JLabel("Superficie (cm²):");
        superficie.setBounds(20, 140, 200, 23);

        try {
            java.net.URL imgURL = getClass().getResource("Cilindro.png");
            if (imgURL != null) {
                ImageIcon icono = new ImageIcon(imgURL);
                imagenLabel = new JLabel(icono);
                imagenLabel.setBounds(50, 180, icono.getIconWidth(), icono.getIconHeight());
                contenedor.add(imagenLabel);
            } else {
                throw new Exception("Imagen no encontrada");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "No se pudo cargar la imagen", "Error", JOptionPane.ERROR_MESSAGE);
        }

        contenedor.add(radio);
        contenedor.add(campoRadio);
        contenedor.add(altura);
        contenedor.add(campoAltura);
        contenedor.add(calcular);
        contenedor.add(volumen);
        contenedor.add(superficie);
    }

    public void actionPerformed(ActionEvent event) {
        boolean error = false;
        double radio = 0, altura = 0;
        try {
            radio = Double.parseDouble(campoRadio.getText());
            altura = Double.parseDouble(campoAltura.getText());
            Cilindro cilindro = new Cilindro(radio, altura);
            volumen.setText("Volumen (cm³): " + String.format("%.2f", cilindro.calcularVolumen()));
            superficie.setText("Superficie (cm²): " + String.format("%.2f", cilindro.calcularSuperficie()));
        } catch (Exception e) {
            error = true;
        } finally {
            if (error) {
                JOptionPane.showMessageDialog(null, "Campo nulo o error en formato de número", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
