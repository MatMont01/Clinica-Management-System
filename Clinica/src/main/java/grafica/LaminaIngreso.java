package grafica;

import com.toedter.calendar.JDateChooser;
import daos.ingreso.IngresoDaoImp;
import dto.Tablas.ConsultaDto;
import dto.Tablas.IngresoDto;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class LaminaIngreso extends JPanel {


    ArrayList<IngresoDto> tablaIngreso;
    //-----JLabel-----//
    JLabel lblIdReserva;
    JLabel lblIdHabitacion;
    JLabel lblMotivoIngreso;
    JLabel lblCostoIngreso;
    //-----JLabel-----//


    //-----JTextField-----//
    JTextField txtIdReserva;
    JTextField txtIdHabitacion;
    JTextField txtMotivoIngreso;
    JTextField txtCostoIngreso;
    //-----JTextField-----//

    //----JCalendar----//
    JDateChooser dateEntrada;
    JDateChooser dateSalida;
    //----JCalendar----//

    //----tablas----//
    private JTable tabla;
    private DefaultTableModel modelo;
    //----tablas----//

    //----JButton----//
    JButton btnGuardar;
    JButton btnMostrar;
    JButton btnVolver;
    //----JButton----//

    private GridBagConstraints gc = new GridBagConstraints();

    private String[][] matriz;
    private String titulos[];

    private IngresoDaoImp dao;


    public LaminaIngreso(IngresoDaoImp dao) {
        Border innerBorder = BorderFactory.createTitledBorder("Registrar Ingreso");
        Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
        setLayout(new GridBagLayout());

        this.dao = dao;
        modelo = new DefaultTableModel();
        tabla = new JTable(modelo);
        agregarComponentes();
        btnMostrarDatosIngresosPendientesActionListener();
        btnGuardarIngresoActionListener();
    }

    public void agregarComponentes() {

        gc.gridx = 0;
        gc.gridy = 0;
        gc.weightx = 0.1;
        gc.weighty = 1;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;

        lblIdReserva = new JLabel("Id Reserva");
        add(lblIdReserva, gc);

        gc.gridx = 1;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.LINE_START;
        txtIdReserva = new JTextField(50);
        add(txtIdReserva, gc);

        gc.gridx = 0;
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.LINE_END;
        lblIdHabitacion = new JLabel("Id Habitacion");
        add(lblIdHabitacion, gc);

        gc.gridx = 1;
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        txtIdHabitacion = new JTextField(50);
        add(txtIdHabitacion, gc);

        gc.gridx = 1;
        gc.gridy = 2;
        gc.anchor = GridBagConstraints.LINE_END;
        dateEntrada = new JDateChooser();
        gc.fill = GridBagConstraints.HORIZONTAL;
        add(dateEntrada, gc);

        gc.gridx = 1;
        gc.gridy = 3;
        gc.anchor = GridBagConstraints.LINE_END;
        dateSalida = new JDateChooser();
        gc.fill = GridBagConstraints.HORIZONTAL;
        add(dateSalida, gc);
        gc.fill = GridBagConstraints.NONE;
        gc.gridx = 0;
        gc.gridy = 4;
        gc.anchor = GridBagConstraints.LINE_END;
        lblMotivoIngreso = new JLabel("Motivo Ingreso");
        add(lblMotivoIngreso, gc);

        gc.gridx = 1;
        gc.gridy = 4;
        gc.anchor = GridBagConstraints.LINE_START;
        txtMotivoIngreso = new JTextField(50);
        add(txtMotivoIngreso, gc);

        gc.gridx = 0;
        gc.gridy = 5;
        gc.anchor = GridBagConstraints.LINE_END;
        lblCostoIngreso = new JLabel("Costo Ingreso");
        add(lblCostoIngreso, gc);

        gc.gridx = 1;
        gc.gridy = 5;
        gc.anchor = GridBagConstraints.LINE_START;
        txtCostoIngreso = new JTextField(50);

        add(txtCostoIngreso, gc);

        gc.gridx = 0;
        gc.gridy = 6;
        gc.anchor = GridBagConstraints.LINE_END;
        btnGuardar = new JButton("Guardar");
        add(btnGuardar, gc);


        //----tabla----//

        gc.anchor = GridBagConstraints.LINE_START;
        gc.fill = GridBagConstraints.BOTH;
        gc.weightx = 2;
        gc.gridx = 1;
        gc.gridy = 7;
        add(new JScrollPane(tabla), gc);
        //----tabla----//

        gc.fill = GridBagConstraints.NONE;
        gc.gridx = 0;
        gc.gridy = 8;
        gc.anchor = GridBagConstraints.LINE_END;
        btnMostrar = new JButton("Mostrar");
        add(btnMostrar, gc);


        gc.gridx = 0;
        gc.gridy = 9;
        gc.anchor = GridBagConstraints.LINE_END;
        btnVolver = new JButton("Volver");
        add(btnVolver, gc);


    }


    public void recorrerDatos() {
        titulos = new String[]{"Id", "fecha Captura", "fecha reserva", "nombre doctor", "nombre paciente", "detalle consulta"};
        tablaIngreso = dao.getAll();


        matriz = new String[tablaIngreso.size()][titulos.length];
        for (int i = 0; i < tablaIngreso.size(); i++) {
            for (int j = 0; j < titulos.length; j++) {
                switch (j) {
                    case 0:
                        matriz[i][j] = tablaIngreso.get(i).getId();
                        break;
                    case 1:
                        matriz[i][j] = tablaIngreso.get(i).getFechaCaptura();
                        break;
                    case 2:
                        matriz[i][j] = tablaIngreso.get(i).getFechaReserva();
                        break;
                    case 3:
                        matriz[i][j] = tablaIngreso.get(i).getNombreDoctor();
                        break;
                    case 4:
                        matriz[i][j] = tablaIngreso.get(i).getNombrePaciente();
                        break;
                    case 5:
                        matriz[i][j] = tablaIngreso.get(i).getObservaciones();
                        break;

                }
            }
        }

        modelo.setDataVector(matriz, titulos);

    }


    public void limpiar() {
        txtIdReserva.setText("");
        txtIdHabitacion.setText("");
        txtMotivoIngreso.setText("");
        txtCostoIngreso.setText("");
    }

    public void btnMostrarDatosIngresosPendientesActionListener() {
        btnMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                recorrerDatos();
            }
        });

    }

    public void btnGuardarIngresoActionListener() {
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                Date date1 = dateEntrada.getDate();
                String format = formatter.format(date1);
              //  SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd");
                Date date2 = dateSalida.getDate();
                String format2 = formatter.format(date2);
                dao.registrarIngreso(Integer.parseInt(txtIdReserva.getText()), Integer.parseInt(txtIdHabitacion.getText()), format, format2, txtMotivoIngreso.getText(), Double.parseDouble(txtCostoIngreso.getText()));
            }
        });
    }

    public JButton getBtnVolver() {
        return btnVolver;
    }
}





