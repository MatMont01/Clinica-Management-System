package grafica;

import com.toedter.calendar.JDateChooser;
import daos.cirugia.CirugiaDao;
import daos.cirugia.CirugiaDaoImp;
import daos.ingreso.IngresoDaoImp;
import dto.Tablas.CirugiaDto;
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

public class LaminaCirugia extends JPanel {

    ArrayList<CirugiaDto> tablaCirugia;

    JLabel lblingresoId;
    JLabel lblciFamiliar;
    JLabel lblcostoCirugia;
    JDateChooser datefecha;
    JLabel lbldetalle;
    JLabel lblhoraInicio;
    JLabel lblhoraFin;

    JTextField txtingresoId;
    JTextField txtciFamiliar;
    JTextField txtcostoCirugia;
    JTextField txtdetalle;
    JTextField txthoraInicio;
    JTextField txthoraFin;

    JButton btnGuardar;
    JButton btnMostrar;
    JButton btnEliminar;
    JButton btnActualizar;
    JButton btnVolver;

    //----tablas----//
    private JTable tabla;
    private DefaultTableModel modelo;
    //----tablas----//
    private GridBagConstraints gc = new GridBagConstraints();

    private String[][] matriz;
    private String titulos[];

    private CirugiaDaoImp dao;

    public LaminaCirugia(CirugiaDaoImp dao) {
        Border innerBorder = BorderFactory.createTitledBorder("Registrar Cirujia");
        Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
        setLayout(new GridBagLayout());

        this.dao = dao;
        modelo = new DefaultTableModel();
        tabla = new JTable(modelo);
        agregarComponentes();
        btnGuardarCirugiaActionListener();
        btnMostrarCirugiaActionListener();

    }

    public void agregarComponentes() {
        gc.gridx = 0;
        gc.gridy = 0;
        gc.weightx = 0.1;
        gc.weighty = 1;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;

        lblingresoId = new JLabel("Id Ingreso");
        add(lblingresoId, gc);

        gc.gridx = 1;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.LINE_START;
        txtingresoId = new JTextField(50);
        add(txtingresoId, gc);

        gc.gridx = 0;
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.LINE_END;
        lblciFamiliar = new JLabel("Ci Familiar");
        add(lblciFamiliar, gc);

        gc.gridx = 1;
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        txtciFamiliar = new JTextField(50);

        add(txtciFamiliar, gc);

        gc.gridx = 0;
        gc.gridy = 2;
        gc.anchor = GridBagConstraints.LINE_END;
        lblcostoCirugia = new JLabel("Costo Cirugia");
        add(lblcostoCirugia, gc);

        gc.gridx = 1;
        gc.gridy = 2;
        gc.anchor = GridBagConstraints.LINE_START;
        txtcostoCirugia = new JTextField(50);
        add(txtcostoCirugia, gc);


        JLabel lblFecha = new JLabel("Fecha");
        gc.gridx = 0;
        gc.gridy = 3;
        gc.anchor = GridBagConstraints.LINE_END;
        add(lblFecha, gc);
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.gridx = 1;
        gc.gridy = 3;
        gc.anchor = GridBagConstraints.LINE_END;
        datefecha = new JDateChooser();
        add(datefecha, gc);

        gc.fill = GridBagConstraints.NONE;
        gc.gridx = 0;
        gc.gridy = 4;
        gc.anchor = GridBagConstraints.LINE_END;
        lbldetalle = new JLabel("Detalle");
        add(lbldetalle, gc);

        gc.gridx = 1;
        gc.gridy = 4;
        gc.anchor = GridBagConstraints.LINE_START;
        txtdetalle = new JTextField(50);
        add(txtdetalle, gc);

        gc.gridx = 0;
        gc.gridy = 5;
        gc.anchor = GridBagConstraints.LINE_END;
        lblhoraInicio = new JLabel("Hora Inicio");
        add(lblhoraInicio, gc);

        gc.gridx = 1;
        gc.gridy = 5;
        gc.anchor = GridBagConstraints.LINE_START;
        txthoraInicio = new JTextField(50);
        add(txthoraInicio, gc);

        gc.gridx = 0;
        gc.gridy = 6;
        gc.anchor = GridBagConstraints.LINE_END;
        lblhoraFin = new JLabel("Hora Fin");
        add(lblhoraFin, gc);

        gc.gridx = 1;
        gc.gridy = 6;
        gc.anchor = GridBagConstraints.LINE_START;
        txthoraFin = new JTextField(50);
        add(txthoraFin, gc);

        gc.gridx = 1;
        gc.gridy = 7;

        btnGuardar = new JButton("Guardar");
        add(btnGuardar, gc);

        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.gridx = 1;
        gc.gridy = 8;
        gc.anchor = GridBagConstraints.LINE_START;
        add(new JScrollPane(tabla), gc);

        gc.fill = GridBagConstraints.NONE;
        gc.gridx = 1;
        gc.gridy = 9;

        btnMostrar = new JButton("Mostrar");
        add(btnMostrar, gc);

        gc.gridx = 1;
        gc.gridy = 10;
        btnVolver = new JButton("Volver");
        add(btnVolver, gc);

    }

    public void recorrerDatos() {
        titulos = new String[]{"fecha", "detalle", "hora inicio", "hora fin", "nombre doctor", "ci doctor"};
        tablaCirugia = dao.getAll();


        matriz = new String[tablaCirugia.size()][titulos.length];
        for (int i = 0; i < tablaCirugia.size(); i++) {
            for (int j = 0; j < titulos.length; j++) {
                switch (j) {
                    case 0:
                        matriz[i][j] = tablaCirugia.get(i).getFecha();
                        break;
                    case 1:
                        matriz[i][j] = tablaCirugia.get(i).getDetalle();
                        break;
                    case 2:
                        matriz[i][j] = tablaCirugia.get(i).getHoraInicio();
                        break;
                    case 3:
                        matriz[i][j] = tablaCirugia.get(i).getHoraFin();
                        break;
                    case 4:
                        matriz[i][j] = tablaCirugia.get(i).getDocotorResponsable();
                        break;
                    case 5:
                        matriz[i][j] = tablaCirugia.get(i).getDoctorId();
                        break;

                }
            }
        }

        modelo.setDataVector(matriz, titulos);

    }

    public void limpiar() {
        txtingresoId.setText("");
        txtciFamiliar.setText("");
        txtcostoCirugia.setText("");
        txtdetalle.setText("");
        txthoraInicio.setText("");
        txthoraFin.setText("");
    }

    public void btnGuardarCirugiaActionListener() {
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                Date date1 = datefecha.getDate();
                String format = formatter.format(date1);

                dao.registrarCirugia(txtingresoId.getText(), txtciFamiliar.getText(), txtcostoCirugia.getText(), format, txtdetalle.getText(), txthoraInicio.getText(), txthoraFin.getText());


            }
        });
    }

    public void btnMostrarCirugiaActionListener() {
        btnMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                recorrerDatos();
            }
        });
    }


    public JButton getBtnVolver() {
        return btnVolver;
    }
}
