package Figuras;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaCubo extends JFrame implements ActionListener {
    private Container contenedor;
    private JLabel lado, volumen, superficie, imagenLabel;
    private JTextField campoLado;
    private JButton calcular;

    public VentanaCubo() {
        setTitle("Cubo");
        setSize(380, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        inicio();
    }

    private void inicio() {
        contenedor = getContentPane();
        contenedor.setLayout(null);

        lado = new JLabel("Lado (cm):");
        lado.setBounds(20, 20, 135, 23);
        campoLado = new JTextField();
        campoLado.setBounds(120, 20, 135, 23);

        calcular = new JButton("Calcular");
        calcular.setBounds(120, 50, 135, 23);
        calcular.addActionListener(this);

        volumen = new JLabel("Volumen (cm³):");
        volumen.setBounds(20, 80, 200, 23);

        superficie = new JLabel("Superficie (cm²):");
        superficie.setBounds(20, 110, 200, 23);

        try {
            java.net.URL imgURL = getClass().getResource("Cubo.png");
            if (imgURL != null) {
                ImageIcon icono = new ImageIcon(imgURL);
                imagenLabel = new JLabel(icono);
                imagenLabel.setBounds(50, 150, icono.getIconWidth(), icono.getIconHeight());
                contenedor.add(imagenLabel);
            } else {
                throw new Exception("Imagen no encontrada");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "No se pudo cargar la imagen", "Error", JOptionPane.ERROR_MESSAGE);
        }

        contenedor.add(lado);
        contenedor.add(campoLado);
        contenedor.add(calcular);
        contenedor.add(volumen);
        contenedor.add(superficie);
    }

    public void actionPerformed(ActionEvent event) {
        boolean error = false;
        double lado = 0;
        try {
            lado = Double.parseDouble(campoLado.getText());
            Cubo cubo = new Cubo(lado);
            volumen.setText("Volumen (cm³): " + String.format("%.2f", cubo.calcularVolumen()));
            superficie.setText("Superficie (cm²): " + String.format("%.2f", cubo.calcularSuperficie()));
        } catch (Exception e) {
            error = true;
        } finally {
            if (error) {
                JOptionPane.showMessageDialog(null, "Campo nulo o error en formato de número", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
