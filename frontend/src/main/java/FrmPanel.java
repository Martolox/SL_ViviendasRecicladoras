import api.Despachador;
import com.formdev.flatlaf.FlatDarkLaf;
import dtos.*;
import exceptions.*;
import test.Usuario;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.Locale;
import java.util.Objects;
import java.util.ResourceBundle;

import static javax.swing.GroupLayout.Alignment.*;
import static javax.swing.LayoutStyle.ComponentPlacement.RELATED;
import static javax.swing.LayoutStyle.ComponentPlacement.UNRELATED;

public class FrmPanel extends JFrame {

    DefaultTableModel tabla = new DefaultTableModel();
    private static final Despachador desp = new Despachador();

    private final Usuario usuario;
    private Font fntTitulo;
    private Font fntLabel2;
    private Font fntLabel;
    private ImageIcon icoBasura;
    private ImageIcon icoBuscar;
    private ImageIcon icoEliminar;
    private ImageIcon icoGuardar;
    private ImageIcon icoModificar;
    private ImageIcon icoNuevo;
    private ImageIcon icoRenovar;
    private ImageIcon imgAdministracion;
    private ImageIcon imgPedidos;
    private ImageIcon imgDuenio;
    private ImageIcon imgInscripciones;
    private ImageIcon imgMC;
    private ImageIcon imgPersonal;
    private ImageIcon imgRecolectores;
    private ImageIcon imgOrdenes;
    private ImageIcon imgVivienda;
    private ImageIcon imgBeneficios;
    private ImageIcon imgEco;
    private ImageIcon imgMunicipio;
    private JMenu jMenu1;
    private JMenu jMenu2;
    private JMenu MenuDuenio;
    private JMenu MenuMunicipio;
    private JMenu MenuPedidos;
    private JMenuBar jMenuBar1;
    private JMenuItem MenuInscripciones;
    private JMenuItem MenuOrdenes;
    private JMenuItem MenuPersonal;
    private JMenuItem MenuVivienda;
    private JButton btnAgregarVisita;
    private JButton btnCambiarPuntos;
    private JButton btnEliInsc;
    private JButton btnEliPersonal;
    private JButton btnLimpiarInsc;
    private JButton btnLimpiarPedido;
    private JButton btnModInsc;
    private JButton btnNuevoPersonal;
    private JButton btnOrdenesMC;
    private JButton btnRegDuenio;
    private JButton btnRegPedido;
    private JButton btnRegPersonal;
    private JButton btnRegVivienda;
    private JButton btnVisitasObs;
    private JComboBox<Object> cbxBeneficio;
    private JComboBox<Object> cbxEstado;
    private JCheckBox chxVehiculo;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JLabel jLabel10;
    private JLabel jLabel11;
    private JLabel jLabel12;
    private JLabel jLabel13;
    private JLabel jLabel14;
    private JLabel jLabel15;
    private JLabel jLabel16;
    private JLabel jLabel17;
    private JLabel jLabel18;
    private JLabel jLabel19;
    private JLabel jLabel20;
    private JLabel jLabel21;
    private JLabel jLabel22;
    private JLabel jLabel23;
    private JLabel jLabel24;
    private JLabel jLabel25;
    private JLabel jLabel26;
    private JLabel jLabel27;
    private JLabel jLabel28;
    private JLabel jLabel29;
    private JLabel jLabel30;
    private JLabel jLabel31;
    private JLabel jLabel32;
    private JLabel jLabel33;
    private JLabel jLabel34;
    private JLabel jLabel35;
    private JLabel jLabel36;
    private JLabel jLabel37;
    private JLabel jLabel38;
    private JLabel jLabel39;
    private JLabel jLabel40;
    private JLabel jLabel41;
    private JLabel jLabel42;
    private JLabel jLabel43;
    private JLabel jLabel44;
    private JLabel jLabel45;
    private JLabel jLabel46;
    private JLabel jLabel47;
    private JLabel jLabel48;
    private JLabel jLabel49;
    private JLabel jLabel50;
    private JLabel jLabel51;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JPanel jPanel5;
    private JPanel jPanel6;
    private JPanel jPanel7;
    private JPanel jPanel8;
    private JPanel jPanel9;
    private JPanel jPanel10;
    private JPanel jPanel11;
    private JPanel jPanel12;
    private JPanel jPanel13;
    private JPanel jPanel14;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;
    private JTabbedPane jTabbedPane1;
    private JTable tblInscripciones;
    private JTable tblOrdenes;
    private JTable tblPersonal;
    private JTextArea txtBenefActivos;
    private JTextField txtApeDuenio;
    private JTextField txtApeInsc;
    private JTextField txtApePersonal;
    private JTextField txtBarrioInsc;
    private JTextField txtBarrioVivienda;
    private JTextField txtBuscarOrden;
    private JTextField txtBuscarPersonal;
    private JTextField txtBuscarInsc;
    private JTextField txtCorreoDuenio;
    private JTextField txtCorreoInsc;
    private JTextField txtDirInsc;
    private JTextField txtDirOrdenes;
    private JTextField txtDirVivienda;
    private JTextField txtDocDuenio;
    private JTextField txtDocInsc;
    private JTextField txtDocMC;
    private JTextField txtDocPersonal;
    private JTextField txtDocVivienda;
    private JTextField txtFechaOrdenes;
    private JTextField txtIdInsc;
    private JTextField txtIdMC;
    private JTextField txtIdOrdenes;
    private JTextField txtIdPedido;
    private JTextField txtIdPersonal;
    private JTextField txtIdRecolector;
    private JTextField txtIdVivienda;
    private JTextField txtMetal;
    private JTextField txtNomDuenio;
    private JTextField txtNomPersonal;
    private JTextField txtNomInsc;
    private JTextField txtObsOrdenes;
    private JTextField txtObsPedido;
    private JTextField txtPapel;
    private JTextField txtPlastico;
    private JTextField txtPuntos;
    private JTextField txtTelDuenio;
    private JTextField txtTelInsc;
    private JTextField txtUbicacion;
    private JTextField txtVidrio;
    private JTextField txtZonaInsc;
    private JTextField txtZonaVivienda;
    private ResourceBundle labels;

    public FrmPanel() {
        iniciarComponentes();
        ubicarPaneles();

        setLocationRelativeTo(null);
        jTabbedPane1.setSelectedIndex(3);
        jTabbedPane1.setEnabledAt(0, true);
        jTabbedPane1.setEnabledAt(1, true);
        jTabbedPane1.setEnabledAt(2, true);
        jTabbedPane1.setEnabledAt(3, true);
        jTabbedPane1.setEnabledAt(4, true);
        jTabbedPane1.setEnabledAt(5, true);
        jTabbedPane1.setEnabledAt(6, true);
        txtIdInsc.setVisible(false);
        txtIdMC.setVisible(false);
        txtIdOrdenes.setVisible(false);
        txtIdPedido.setVisible(false);
        txtIdPersonal.setVisible(false);
        txtIdRecolector.setVisible(false);
        txtIdVivienda.setVisible(false);
        cbxBeneficio.removeAllItems();
        cbxEstado.removeAllItems();
        llenarBeneficios();
        llenarEstado();
        usuario = new Usuario("admin", "admin", "30237244");
    }

    private void iniciarComponentes() {
        labels = ResourceBundle.getBundle("lbl", new Locale.Builder().setLanguage("es").build());
        fntTitulo = new Font("Cambria", Font.BOLD, 18);
        fntLabel = new Font("Roboto", Font.BOLD, 14);
        fntLabel2 = new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14);
        icoBasura = new ImageIcon(Objects.requireNonNull(getClass().getResource("/img/icon_Delete.png")));
        icoBuscar = new ImageIcon(Objects.requireNonNull(getClass().getResource("/img/icon_FindInPage.png")));
        icoEliminar = new ImageIcon(Objects.requireNonNull(getClass().getResource("/img/icon_Cancel.png")));
        icoGuardar = new ImageIcon(Objects.requireNonNull(getClass().getResource("/img/icon_Save.png")));
        icoModificar = new ImageIcon(Objects.requireNonNull(getClass().getResource("/img/icon_EditNote.png")));
        icoNuevo = new ImageIcon(Objects.requireNonNull(getClass().getResource("/img/icon_NoteAdd.png")));
        icoRenovar = new ImageIcon(Objects.requireNonNull(getClass().getResource("/img/icon_AutoRenew.png")));
        imgAdministracion = new ImageIcon(Objects.requireNonNull(getClass().getResource("/img/icon_R1a_Administracion.png")));
        imgDuenio = new ImageIcon(Objects.requireNonNull(getClass().getResource("/img/icon_R3_Duenio.png")));
        imgInscripciones = new ImageIcon(Objects.requireNonNull(getClass().getResource("/img/icon_R1b_Inscripciones.png")));
        imgMC = new ImageIcon(Objects.requireNonNull(getClass().getResource("/img/icon_R6_MC.png")));
        imgPedidos = new ImageIcon(Objects.requireNonNull(getClass().getResource("/img/icon_R5_Pedidos.png")));
        imgPersonal = new ImageIcon(Objects.requireNonNull(getClass().getResource("/img/icon_R1c_Personal.png")));
        imgRecolectores = new ImageIcon(Objects.requireNonNull(getClass().getResource("/img/icon_R2a_Recolectores.png")));
        imgOrdenes = new ImageIcon(Objects.requireNonNull(getClass().getResource("/img/icon_R2b_Ordenes.png")));
        imgVivienda = new ImageIcon(Objects.requireNonNull(getClass().getResource("/img/icon_R4_Vivienda.png")));
        imgBeneficios = new ImageIcon(Objects.requireNonNull(getClass().getResource("/img/img_Beneficios.png")));
        imgEco = new ImageIcon(Objects.requireNonNull(getClass().getResource("/img/img_Eco.png")));
        imgMunicipio = new ImageIcon(Objects.requireNonNull(getClass().getResource("/img/img_Municipio.png")));
        btnAgregarVisita = new JButton();
        btnCambiarPuntos = new JButton();
        btnEliInsc = new JButton();
        btnEliPersonal = new JButton();
        btnLimpiarInsc = new JButton();
        btnLimpiarPedido = new JButton();
        btnModInsc = new JButton();
        btnNuevoPersonal = new JButton();
        btnOrdenesMC = new JButton();
        btnRegDuenio = new JButton();
        btnRegPedido = new JButton();
        btnRegPersonal = new JButton();
        btnRegVivienda = new JButton();
        btnVisitasObs = new JButton();
        cbxBeneficio = new JComboBox<>();
        cbxEstado = new JComboBox<>();
        chxVehiculo = new JCheckBox();
        jMenu1 = new JMenu();
        jMenu2 = new JMenu();
        MenuDuenio = new JMenu();
        MenuMunicipio = new JMenu();
        MenuPedidos = new JMenu();
        jMenuBar1 = new JMenuBar();
        MenuOrdenes = new JMenuItem();
        MenuInscripciones = new JMenuItem();
        MenuPersonal = new JMenuItem();
        MenuVivienda = new JMenuItem();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();
        jLabel7 = new JLabel();
        jLabel8 = new JLabel();
        jLabel9 = new JLabel();
        jLabel10 = new JLabel();
        jLabel11 = new JLabel();
        jLabel12 = new JLabel();
        jLabel13 = new JLabel();
        jLabel14 = new JLabel();
        jLabel15 = new JLabel();
        jLabel16 = new JLabel();
        jLabel17 = new JLabel();
        jLabel18 = new JLabel();
        jLabel19 = new JLabel();
        jLabel20 = new JLabel();
        jLabel21 = new JLabel();
        jLabel22 = new JLabel();
        jLabel23 = new JLabel();
        jLabel24 = new JLabel();
        jLabel25 = new JLabel();
        jLabel26 = new JLabel();
        jLabel27 = new JLabel();
        jLabel28 = new JLabel();
        jLabel29 = new JLabel();
        jLabel30 = new JLabel();
        jLabel31 = new JLabel();
        jLabel32 = new JLabel();
        jLabel33 = new JLabel();
        jLabel34 = new JLabel();
        jLabel35 = new JLabel();
        jLabel36 = new JLabel();
        jLabel37 = new JLabel();
        jLabel38 = new JLabel();
        jLabel39 = new JLabel();
        jLabel40 = new JLabel();
        jLabel41 = new JLabel();
        jLabel42 = new JLabel();
        jLabel43 = new JLabel();
        jLabel44 = new JLabel();
        jLabel45 = new JLabel();
        jLabel46 = new JLabel();
        jLabel47 = new JLabel();
        jLabel48 = new JLabel();
        jLabel49 = new JLabel();
        jLabel50 = new JLabel();
        jLabel51 = new JLabel();
        jPanel1 = new JPanel();
        jPanel2 = new JPanel();
        jPanel3 = new JPanel();
        jPanel4 = new JPanel();
        jPanel5 = new JPanel();
        jPanel6 = new JPanel();
        jPanel7 = new JPanel();
        jPanel8 = new JPanel();
        jPanel9 = new JPanel();
        jPanel10 = new JPanel();
        jPanel11 = new JPanel();
        jPanel12 = new JPanel();
        jPanel13 = new JPanel();
        jPanel14 = new JPanel();
        jScrollPane1 = new JScrollPane();
        jScrollPane2 = new JScrollPane();
        jScrollPane3 = new JScrollPane();
        jTabbedPane1 = new JTabbedPane();
        tblInscripciones = new JTable();
        tblOrdenes = new JTable();
        tblPersonal = new JTable();
        txtBenefActivos = new JTextArea();
        txtApeDuenio = new JTextField();
        txtApePersonal = new JTextField();
        txtApeInsc = new JTextField();
        txtBarrioInsc = new JTextField();
        txtBarrioVivienda = new JTextField();
        txtBuscarOrden = new JTextField();
        txtBuscarPersonal = new JTextField();
        txtBuscarInsc = new JTextField();
        txtCorreoDuenio = new JTextField();
        txtCorreoInsc = new JTextField();
        txtDirInsc = new JTextField();
        txtDirOrdenes = new JTextField();
        txtDirVivienda = new JTextField();
        txtDocDuenio = new JTextField();
        txtDocInsc = new JTextField();
        txtDocMC = new JTextField();
        txtDocPersonal = new JTextField();
        txtDocVivienda = new JTextField();
        txtFechaOrdenes = new JTextField();
        txtIdInsc = new JTextField();
        txtIdMC = new JTextField();
        txtIdOrdenes = new JTextField();
        txtIdPedido = new JTextField();
        txtIdPersonal = new JTextField();
        txtIdRecolector = new JTextField();
        txtIdVivienda = new JTextField();
        txtMetal = new JTextField();
        txtNomDuenio = new JTextField();
        txtNomPersonal = new JTextField();
        txtNomInsc = new JTextField();
        txtObsOrdenes = new JTextField();
        txtObsPedido = new JTextField();
        txtPapel = new JTextField();
        txtPlastico = new JTextField();
        txtPuntos = new JTextField();
        txtTelDuenio = new JTextField();
        txtTelInsc = new JTextField();
        txtUbicacion = new JTextField();
        txtVidrio = new JTextField();
        txtZonaInsc = new JTextField();
        txtZonaVivienda = new JTextField();
    }

    private void ubicarPaneles() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle(labels.getString("menu.Titulo"));
        setExtendedState(0);
        agregarTabPanel();
        pack();
    }

    private void agregarTabPanel() {
        agregarTabDuenio();
        agregarTabVivienda();
        agregarTabInscripciones();
        agregarTabPersonal();
        agregarTabPedidos();
        agregarTabOrdenes();
        agregarTabMunicipio();
        agregarMenuBar();
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout
                .createParallelGroup(LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTabbedPane1)
                        .addContainerGap()));
        layout.setVerticalGroup(layout
                .createParallelGroup(LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTabbedPane1, -2, 640, -2)
                        .addContainerGap(-1, 32767)));
    }

    private void agregarTabDuenio() {
        jPanel1.setBorder(BorderFactory.createTitledBorder(null, labels.getString("tabDuenio.Titulo"), 0, 0, fntTitulo));
        jLabel1.setIcon(imgVivienda);
        jLabel2.setIcon(imgRecolectores);
        jLabel3.setIcon(imgPedidos);
        jLabel4.setFont(fntLabel);
        jLabel4.setText(labels.getString("tabDuenio.Nombre"));
        jLabel5.setFont(fntLabel);
        jLabel5.setText(labels.getString("tabDuenio.Apellido"));
        jLabel6.setFont(fntLabel);
        jLabel6.setText(labels.getString("tabDuenio.Documento"));
        jLabel7.setFont(fntLabel);
        jLabel7.setText(labels.getString("tabDuenio.Correo"));
        jLabel8.setFont(fntLabel);
        jLabel8.setText(labels.getString("tabDuenio.Telefono"));
        btnRegDuenio.setIcon(icoModificar);
        btnRegDuenio.setText(labels.getString("tabDuenio.BtnRegistrarDuenio"));
        btnRegDuenio.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnRegDuenio.addActionListener(this::btnRegDuenioActionPerformed);
        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout
                .createParallelGroup(TRAILING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addPreferredGap(RELATED)
                                        .addComponent(txtNomDuenio, 245, 245, 245))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout
                                                .createParallelGroup(LEADING)
                                                .addGroup(jPanel1Layout.createParallelGroup(TRAILING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(jPanel1Layout
                                                                        .createParallelGroup(LEADING)
                                                                        .addComponent(jLabel1)
                                                                        .addComponent(jLabel4)
                                                                        .addComponent(jLabel5)
                                                                        .addComponent(jLabel6)
                                                                        .addComponent(jLabel7))
                                                                .addPreferredGap(RELATED, 25, 32767))
                                                        .addGap(78))
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addContainerGap()
                                                        .addComponent(jLabel8)
                                                        .addPreferredGap(RELATED)))
                                        .addGroup(jPanel1Layout.createParallelGroup(TRAILING, false)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addGap(38)
                                                        .addComponent(jLabel2)
                                                        .addPreferredGap(RELATED, -1, 32767)
                                                        .addComponent(jLabel3))
                                                .addComponent(txtDocDuenio)
                                                .addComponent(txtCorreoDuenio)
                                                .addComponent(txtApeDuenio)
                                                .addComponent(btnRegDuenio, -2, 245, -2)
                                                .addComponent(txtTelDuenio, LEADING))))
                        .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(jPanel1Layout
                .createParallelGroup(TRAILING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(LEADING)
                                .addComponent(jLabel1, -2, 80, -2)
                                .addComponent(jLabel2, -2, 80, -2)
                                .addComponent(jLabel3, -2, 80, -2)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(25)))
                        .addGap(27)
                        .addGroup(jPanel1Layout.createParallelGroup(BASELINE)
                                .addComponent(txtNomDuenio, -2, 35, -2)
                                .addComponent(jLabel4))
                        .addGap(27)
                        .addGroup(jPanel1Layout.createParallelGroup(BASELINE)
                                .addComponent(txtApeDuenio, -2, 35, -2)
                                .addComponent(jLabel5))
                        .addGap(27)
                        .addGroup(jPanel1Layout.createParallelGroup(BASELINE)
                                .addComponent(jLabel6)
                                .addComponent(txtDocDuenio, -2, 35, -2))
                        .addGap(27)
                        .addGroup(jPanel1Layout.createParallelGroup(BASELINE)
                                .addComponent(jLabel7)
                                .addComponent(txtCorreoDuenio, -2, 35, -2))
                        .addGap(27)
                        .addGroup(jPanel1Layout.createParallelGroup(BASELINE)
                                .addComponent(txtTelDuenio, -2, 35, -2)
                                .addComponent(jLabel8))
                        .addGap(60)
                        .addComponent(btnRegDuenio, -2, 51, -2)
                        .addGap(30))
        );
        jPanel1.setLayout(jPanel1Layout);
        jLabel9.setIcon(imgEco);
        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout
                .createParallelGroup(LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, -2, -1, -2)
                        .addGap(180, 180, 180)
                        .addComponent(jLabel9, -1, -1, 32767)
                        .addGap(6, 6, 6))
        );
        jPanel2Layout.setVerticalGroup(jPanel2Layout
                .createParallelGroup(LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jPanel1, -1, -1, 32767))
                .addComponent(jLabel9, -2, 0, 32767)
        );
        jTabbedPane1.addTab(labels.getString("tabDuenio.Rotulo"), jPanel2);
    }

    private void agregarTabVivienda() {
        jPanel3.setBorder(BorderFactory.createTitledBorder(null, labels.getString("tabVivienda.Titulo"), 0, 0, fntTitulo));
        jLabel10.setIcon(icoBuscar);
        jLabel11.setFont(fntLabel2);
        jLabel11.setText(labels.getString("tabVivienda.Doc"));
        jLabel12.setFont(fntLabel);
        jLabel12.setText(labels.getString("tabVivienda.Direccion"));
        jLabel13.setFont(fntLabel);
        jLabel13.setText(labels.getString("tabVivienda.Zona"));
        jLabel14.setFont(fntLabel);
        jLabel14.setText(labels.getString("tabVivienda.Barrio"));
        jLabel15.setFont(fntLabel);
        jLabel15.setText(labels.getString("tabVivienda.Ubicacion"));
        txtDocVivienda.setFocusable(false);
        txtDocVivienda.setEditable(false);
        txtUbicacion.setEditable(false);
        btnRegVivienda.setIcon(icoModificar);
        btnRegVivienda.setText(labels.getString("tabVivienda.BtnValidarUbicacion"));
        btnRegVivienda.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnRegVivienda.addActionListener(this::btnRegViviendaActionPerformed);
        GroupLayout jPanel1Layout = new GroupLayout(jPanel3);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout
                .createParallelGroup(TRAILING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addPreferredGap(RELATED)
                                        .addComponent(txtDirVivienda, 245, 245, 245))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(LEADING)
                                                .addGroup(jPanel1Layout.createParallelGroup(TRAILING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(jPanel1Layout.createParallelGroup(LEADING)
                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addComponent(jLabel10)
                                                                                .addComponent(jLabel11))
                                                                        .addComponent(jLabel10)
                                                                        .addComponent(jLabel12)
                                                                        .addComponent(jLabel13)
                                                                        .addComponent(jLabel14)
                                                                        .addComponent(jLabel15))
                                                                .addPreferredGap(RELATED, 25, 32767))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addContainerGap(30, 32767)
                                                                .addComponent(txtIdVivienda, -2, 18, -2)
                                                                .addGap(30))))
                                        .addGroup(jPanel1Layout.createParallelGroup(TRAILING, false)
                                                .addComponent(txtDocVivienda)
                                                .addComponent(txtBarrioVivienda)
                                                .addComponent(txtUbicacion)
                                                .addComponent(txtZonaVivienda, LEADING)
                                                .addComponent(btnRegVivienda, -2, 245, -2))))
                        .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(jPanel1Layout
                .createParallelGroup(TRAILING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(45)
                        .addGroup(jPanel1Layout.createParallelGroup(BASELINE)
                                .addComponent(jLabel10)
                                .addComponent(jLabel11)
                                .addComponent(txtDocVivienda, -2, 35, -2))
                        .addGap(27)
                        .addGroup(jPanel1Layout.createParallelGroup(BASELINE)
                                .addComponent(txtDirVivienda, -2, 35, -2)
                                .addComponent(jLabel12))
                        .addGap(27)
                        .addGroup(jPanel1Layout.createParallelGroup(BASELINE)
                                .addComponent(txtZonaVivienda, -2, 35, -2)
                                .addComponent(jLabel13))
                        .addGap(27)
                        .addGroup(jPanel1Layout.createParallelGroup(BASELINE)
                                .addComponent(jLabel14)
                                .addComponent(txtBarrioVivienda, -2, 35, -2))
                        .addGap(27)
                        .addGroup(jPanel1Layout.createParallelGroup(BASELINE)
                                .addComponent(jLabel15)
                                .addComponent(txtUbicacion, -2, 35, -2))
                        .addGap(115)
                        .addGroup(jPanel1Layout.createParallelGroup(BASELINE)
                                .addComponent(btnRegVivienda, -2, 51, -2)
                                .addComponent(txtIdVivienda, -2, -1, -2))
                        .addGap(30))
        );
        jPanel3.setLayout(jPanel1Layout);
        jLabel16.setIcon(imgEco);
        GroupLayout jPanel2Layout = new GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout
                .createParallelGroup(LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, -2, -1, -2)
                        .addGap(180, 180, 180)
                        .addComponent(jLabel16, -1, -1, 32767)
                        .addGap(6, 6, 6)));
        jPanel2Layout.setVerticalGroup(jPanel2Layout
                .createParallelGroup(LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jPanel3, -1, -1, 32767))
                .addComponent(jLabel16, -2, 0, 32767));
        jTabbedPane1.addTab(labels.getString("tabVivienda.Rotulo"), jPanel4);
    }

    private void agregarTabInscripciones() {
        jPanel5.setBorder(BorderFactory.createTitledBorder(null, labels.getString("tabInscripciones.Titulo"), 2, 0, fntTitulo));
        jLabel17.setFont(fntLabel2);
        jLabel17.setText(labels.getString("tabInscripciones.Doc"));
        jLabel18.setFont(fntLabel2);
        jLabel18.setText(labels.getString("tabInscripciones.Nombre"));
        jLabel19.setFont(fntLabel2);
        jLabel19.setText(labels.getString("tabInscripciones.Apellido"));
        jLabel20.setFont(fntLabel2);
        jLabel20.setText(labels.getString("tabInscripciones.Correo"));
        jLabel21.setFont(fntLabel2);
        jLabel21.setText(labels.getString("tabInscripciones.Telefono"));
        jLabel22.setFont(fntLabel2);
        jLabel22.setText(labels.getString("tabInscripciones.Direccion"));
        jLabel23.setFont(fntLabel2);
        jLabel23.setText(labels.getString("tabInscripciones.Zona"));
        jLabel24.setFont(fntLabel2);
        jLabel24.setText(labels.getString("tabInscripciones.Barrio"));
        btnModInsc.setIcon(icoModificar);
        btnModInsc.setText(labels.getString("tabInscripciones.BtnModificar"));
        btnModInsc.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnModInsc.addActionListener(this::btnModInscActionPerformed);
        btnEliInsc.setIcon(icoEliminar);
        btnEliInsc.setText(labels.getString("tabInscripciones.BtnEliminar"));
        btnEliInsc.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnEliInsc.addActionListener(this::btnEliInscActionPerformed);
        btnLimpiarInsc.setIcon(icoRenovar);
        btnLimpiarInsc.setText(labels.getString("tabInscripciones.BtnLimpiar"));
        btnLimpiarInsc.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnLimpiarInsc.addActionListener(this::btnLimpiarInscActionPerformed);
        GroupLayout jPanel5Layout = new GroupLayout(jPanel5);
        jPanel5Layout.setHorizontalGroup(
                jPanel5Layout.createParallelGroup(LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel5Layout.createParallelGroup(TRAILING)
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addComponent(jLabel17)
                                                .addPreferredGap(RELATED)
                                                .addGroup(jPanel5Layout.createParallelGroup(TRAILING)
                                                        .addComponent(txtDocInsc, -2, 246, -2)
                                                        .addGroup(LEADING, jPanel5Layout.createSequentialGroup()
                                                                .addComponent(btnModInsc)
                                                                .addGap(32)
                                                                .addComponent(btnEliInsc))
                                                        .addComponent(txtIdInsc, -2, -1, -2)
                                                        .addComponent(btnLimpiarInsc, -1, 275, 32767))
                                                .addContainerGap())
                                        .addGroup(LEADING, jPanel5Layout.createSequentialGroup()
                                                .addComponent(jLabel18)
                                                .addGap(15)
                                                .addComponent(txtNomInsc, -2, 246, -2))
                                        .addGroup(LEADING, jPanel5Layout.createSequentialGroup()
                                                .addComponent(jLabel19)
                                                .addGap(14)
                                                .addComponent(txtApeInsc, -2, 246, -2))
                                        .addGroup(LEADING, jPanel5Layout.createSequentialGroup()
                                                .addComponent(jLabel20)
                                                .addGap(23)
                                                .addComponent(txtCorreoInsc, -2, 246, -2))
                                        .addGroup(LEADING, jPanel5Layout.createSequentialGroup()
                                                .addComponent(jLabel21)
                                                .addGap(10)
                                                .addComponent(txtTelInsc, -2, 246, -2))
                                        .addGroup(LEADING, jPanel5Layout.createSequentialGroup()
                                                .addComponent(jLabel22)
                                                .addGap(6)
                                                .addComponent(txtDirInsc, -2, 246, -2))
                                        .addGroup(LEADING, jPanel5Layout.createSequentialGroup()
                                                .addComponent(jLabel23)
                                                .addGap(31)
                                                .addComponent(txtZonaInsc, -2, 246, -2))
                                        .addGroup(LEADING, jPanel5Layout.createSequentialGroup()
                                                .addComponent(jLabel24)
                                                .addGap(25)
                                                .addComponent(txtBarrioInsc, -2, 246, -2))))
        );
        jPanel5Layout.setVerticalGroup(
                jPanel5Layout.createParallelGroup(LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(txtIdInsc, -2, -1, -2)
                                .addGap(12)
                                .addGroup(jPanel5Layout.createParallelGroup(BASELINE)
                                        .addComponent(txtDocInsc, -2, 35, -2)
                                        .addComponent(jLabel17))
                                .addGap(6)
                                .addGroup(jPanel5Layout.createParallelGroup(BASELINE)
                                        .addComponent(txtNomInsc, -2, 35, -2)
                                        .addComponent(jLabel18))
                                .addGap(6)
                                .addGroup(jPanel5Layout.createParallelGroup(BASELINE)
                                        .addComponent(txtApeInsc, -2, 35, -2)
                                        .addComponent(jLabel19))
                                .addGap(6)
                                .addGroup(jPanel5Layout.createParallelGroup(BASELINE)
                                        .addComponent(txtCorreoInsc, -2, 35, -2)
                                        .addComponent(jLabel20))
                                .addGap(6)
                                .addGroup(jPanel5Layout.createParallelGroup(BASELINE)
                                        .addComponent(txtTelInsc, -2, 35, -2)
                                        .addComponent(jLabel21))
                                .addGap(6)
                                .addGroup(jPanel5Layout.createParallelGroup(BASELINE)
                                        .addComponent(txtDirInsc, -2, 35, -2)
                                        .addComponent(jLabel22))
                                .addGap(6)
                                .addGroup(jPanel5Layout.createParallelGroup(BASELINE)
                                        .addComponent(txtZonaInsc, -2, 35, -2)
                                        .addComponent(jLabel23))
                                .addGap(6)
                                .addGroup(jPanel5Layout.createParallelGroup(BASELINE)
                                        .addComponent(txtBarrioInsc, -2, 35, -2)
                                        .addComponent(jLabel24))
                                .addGap(27)
                                .addGroup(jPanel5Layout.createParallelGroup(BASELINE)
                                        .addComponent(btnEliInsc, -2, 40, -2)
                                        .addComponent(btnModInsc, -2, 40, -2))
                                .addGap(18)
                                .addComponent(btnLimpiarInsc, -2, 40, -2)
                                .addContainerGap(22, 32767))
        );
        jPanel5.setLayout(jPanel5Layout);
        tblInscripciones.setModel(new DefaultTableModel(new Object[0][], new String[]{
                labels.getString("tabInscripciones.TblId"),
                labels.getString("tabInscripciones.TblDocumento"),
                labels.getString("tabInscripciones.TblNombre"),
                labels.getString("tabInscripciones.TblApellido"),
                labels.getString("tabInscripciones.TblCorreo"),
                labels.getString("tabInscripciones.TblTelefono"),
                labels.getString("tabInscripciones.TblDireccion"),
                labels.getString("tabInscripciones.TblZona"),
                labels.getString("tabInscripciones.TblBarrio"),
                labels.getString("tabInscripciones.TblLatitud"),
                labels.getString("tabInscripciones.TblLongitud"),
                labels.getString("tabInscripciones.TblFecha")
        }));
        tblInscripciones.setRowHeight(20);
        tblInscripciones.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                tblInscMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblInscripciones);
        jLabel25.setIcon(icoBuscar);
        jLabel25.setText(labels.getString("tabInscripciones.Buscar"));
        txtBuscarInsc.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent evt) {
                txtBuscarInscKeyReleased();
            }
        });
        GroupLayout jPanel6Layout = new GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(jPanel6Layout
                .createParallelGroup(LEADING)
                .addGroup(jPanel6Layout
                        .createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel6Layout
                                .createParallelGroup(LEADING, false)
                                .addComponent(jPanel5, -2, -1, -2)
                                .addGroup(jPanel6Layout
                                        .createSequentialGroup()
                                        .addComponent(jLabel25)
                                        .addPreferredGap(RELATED, -1, 32767)
                                        .addComponent(txtBuscarInsc, -2, 193, -2)))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, -1, 936, 32767)
                        .addGap(23, 23, 23)));
        jPanel6Layout.setVerticalGroup(jPanel6Layout
                .createParallelGroup(LEADING)
                .addGroup(TRAILING, jPanel6Layout
                        .createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel6Layout
                                .createParallelGroup(LEADING)
                                .addGroup(jPanel6Layout
                                        .createSequentialGroup()
                                        .addGroup(jPanel6Layout
                                                .createParallelGroup(LEADING)
                                                .addGroup(jPanel6Layout
                                                        .createSequentialGroup()
                                                        .addComponent(jLabel25)
                                                        .addGap(0, 0, 32767))
                                                .addComponent(txtBuscarInsc))
                                        .addPreferredGap(UNRELATED)
                                        .addComponent(jPanel5, -2, 518, -2))
                                .addComponent(jScrollPane1, -1, 566, 32767))
                        .addGap(25, 25, 25)));
        jTabbedPane1.addTab(labels.getString("tabInscripciones.Rotulo"), jPanel6);
    }

    private void agregarTabPersonal() {
        jPanel7.setBorder(BorderFactory.createTitledBorder(null, labels.getString("tabPersonal.Titulo"), 2, 0, fntTitulo));
        jLabel26.setFont(fntLabel2);
        jLabel26.setText(labels.getString("tabPersonal.Nombre"));
        jLabel27.setFont(fntLabel2);
        jLabel27.setText(labels.getString("tabPersonal.Apellido"));
        jLabel28.setFont(fntLabel2);
        jLabel28.setText(labels.getString("tabPersonal.Documento"));
        btnRegPersonal.setIcon(icoGuardar);
        btnRegPersonal.setText(labels.getString("tabPersonal.BtnRegistrar"));
        btnRegPersonal.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnRegPersonal.addActionListener(this::btnRegPersonalActionPerformed);
        btnEliPersonal.setIcon(icoEliminar);
        btnEliPersonal.setText(labels.getString("tabPersonal.BtnEliminar"));
        btnEliPersonal.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnEliPersonal.addActionListener(this::btnEliPersonalActionPerformed);
        btnNuevoPersonal.setIcon(icoNuevo);
        btnNuevoPersonal.setText(labels.getString("tabPersonal.BtnNuevo"));
        btnNuevoPersonal.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnNuevoPersonal.addActionListener(this::btnNuevoPersonalActionPerformed);
        GroupLayout jPanel7Layout = new GroupLayout(jPanel7);
        jPanel7Layout.setHorizontalGroup(jPanel7Layout
                .createParallelGroup(LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel7Layout.createParallelGroup()
                                .addComponent(txtIdPersonal, -2, -1, -2)
                                .addComponent(jLabel26)
                                .addComponent(txtNomPersonal, 246, 246, 246)
                                .addComponent(jLabel27)
                                .addComponent(txtApePersonal, 246, 246, 246)
                                .addComponent(jLabel28)
                                .addComponent(txtDocPersonal, 246, 246, 246)
                                .addGroup(jPanel7Layout
                                        .createSequentialGroup()
                                        .addComponent(btnRegPersonal, -2, 126, -2)
                                        .addPreferredGap(RELATED, -1, 32767)
                                        .addComponent(btnEliPersonal, -1, -1, 32767)
                                )
                                .addComponent(btnNuevoPersonal, -1, 246, 32767))
                        .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(jPanel7Layout
                .createParallelGroup(LEADING)
                .addGroup(jPanel7Layout
                        .createSequentialGroup()
                        .addGap(30)
                        .addComponent(txtIdPersonal, -2, 35, -2)
                        .addComponent(jLabel26, -2, 35, -2)
                        .addComponent(txtNomPersonal, -2, 35, -2)
                        .addComponent(jLabel27, -2, 35, -2)
                        .addComponent(txtApePersonal, -2, 35, -2)
                        .addComponent(jLabel28, -2, 35, -2)
                        .addComponent(txtDocPersonal, -2, 35, -2)
                        .addGap(104)
                        .addGroup(jPanel7Layout.createParallelGroup(BASELINE)
                                .addComponent(btnRegPersonal, -2, 40, -2)
                                .addComponent(btnEliPersonal, -2, 40, -2))
                        .addGap(18)
                        .addComponent(btnNuevoPersonal, -2, 40, -2)
                        .addContainerGap(58, 32767))
        );
        jPanel7.setLayout(jPanel7Layout);
        tblPersonal.setModel(new DefaultTableModel(new Object[0][], new String[]{
                labels.getString("tabPersonal.TblId"),
                labels.getString("tabPersonal.TblNombre"),
                labels.getString("tabPersonal.TblApellido"),
                labels.getString("tabPersonal.TblDocumento")
        }));
        tblPersonal.setRowHeight(20);
        tblPersonal.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                tblPersonalMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblPersonal);
        jLabel29.setIcon(icoBuscar);
        jLabel29.setText("Buscar");
        txtBuscarPersonal.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent evt) {
                txtBuscarPersonalKeyReleased();
            }
        });
        GroupLayout jPanel8Layout = new GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(jPanel8Layout.createParallelGroup(LEADING)
                .addGroup(jPanel8Layout
                        .createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel8Layout.createParallelGroup(LEADING, false)
                                .addComponent(jPanel7, -2, -1, -2)
                                .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addComponent(jLabel29)
                                        .addPreferredGap(RELATED, -1, 32767)
                                        .addComponent(txtBuscarPersonal, -2, 184, -2)))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, -1, 936, 32767)
                        .addGap(23, 23, 23)));
        jPanel8Layout.setVerticalGroup(jPanel8Layout.createParallelGroup(LEADING)
                .addGroup(TRAILING, jPanel8Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel8Layout.createParallelGroup(TRAILING)
                                .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addGroup(jPanel8Layout.createParallelGroup(LEADING, false)
                                                .addComponent(jLabel29, -1, -1, 32767)
                                                .addComponent(txtBuscarPersonal, -1, 35, 32767))
                                        .addPreferredGap(RELATED, -1, 32767)
                                        .addComponent(jPanel7, -2, -1, -2))
                                .addComponent(jScrollPane2, -1, 566, 32767))
                        .addGap(25, 25, 25)));
        jTabbedPane1.addTab(labels.getString("tabPersonal.Rotulo"), jPanel8);
    }

    private void agregarTabPedidos() {
        jPanel9.setBorder(BorderFactory.createTitledBorder(null, labels.getString("tabPedidos.Titulo"), 2, 0, fntTitulo));
        jLabel30.setFont(fntLabel2);
        jLabel30.setIcon(icoBasura);
        jLabel30.setText(labels.getString("tabPedidos.Plastico"));
        jLabel31.setFont(fntLabel2);
        jLabel31.setText("Kg");
        jLabel32.setFont(fntLabel2);
        jLabel32.setIcon(icoBasura);
        jLabel32.setText(labels.getString("tabPedidos.Papel"));
        jLabel33.setFont(fntLabel2);
        jLabel33.setText("Kg");
        jLabel34.setFont(fntLabel2);
        jLabel34.setIcon(icoBasura);
        jLabel34.setText(labels.getString("tabPedidos.Vidrio"));
        jLabel35.setFont(fntLabel2);
        jLabel35.setText("Kg");
        jLabel36.setFont(fntLabel2);
        jLabel36.setIcon(icoBasura);
        jLabel36.setText(labels.getString("tabPedidos.Metal"));
        jLabel37.setFont(fntLabel2);
        jLabel37.setText("Kg");
        jLabel38.setFont(fntLabel2);
        jLabel38.setText(labels.getString("tabPedidos.Vehiculo"));
        jLabel39.setFont(fntLabel2);
        jLabel39.setText(labels.getString("tabPedidos.Observaciones"));
        btnRegPedido.setIcon(icoGuardar);
        btnRegPedido.setText(labels.getString("tabPedidos.BtnRegistrar"));
        btnRegPedido.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnRegPedido.addActionListener(this::btnRegPedidoActionPerformed);
        btnLimpiarPedido.setIcon(icoRenovar);
        btnLimpiarPedido.setText(labels.getString("tabPedidos.BtnLimpiar"));
        btnLimpiarPedido.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnLimpiarPedido.addActionListener(this::btnLimpiarPedidoActionPerformed);
        GroupLayout jPanel9Layout = new GroupLayout(jPanel9);
        jPanel9Layout.setHorizontalGroup(
                jPanel9Layout.createParallelGroup(LEADING)
                        .addGroup(jPanel9Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel9Layout.createParallelGroup(LEADING)
                                        .addGroup(LEADING, jPanel9Layout.createSequentialGroup()
                                                .addComponent(jLabel30)
                                                .addPreferredGap(RELATED, -1, 32767)
                                                .addComponent(txtPlastico, -2, 90, -2)
                                                .addPreferredGap(RELATED)
                                                .addComponent(jLabel31))
                                        .addGroup(LEADING, jPanel9Layout.createSequentialGroup()
                                                .addComponent(jLabel32)
                                                .addPreferredGap(RELATED, -1, 32767)
                                                .addComponent(txtPapel, -2, 90, -2)
                                                .addPreferredGap(RELATED)
                                                .addComponent(jLabel33))
                                        .addGroup(LEADING, jPanel9Layout.createSequentialGroup()
                                                .addComponent(jLabel34)
                                                .addPreferredGap(RELATED, -1, 32767)
                                                .addComponent(txtVidrio, -2, 90, -2)
                                                .addPreferredGap(RELATED)
                                                .addComponent(jLabel35))
                                        .addGroup(LEADING, jPanel9Layout.createSequentialGroup()
                                                .addComponent(jLabel36)
                                                .addPreferredGap(RELATED, -1, 32767)
                                                .addComponent(txtMetal, -2, 90, -2)
                                                .addPreferredGap(RELATED)
                                                .addComponent(jLabel37))
                                        .addGroup(LEADING, jPanel9Layout.createSequentialGroup()
                                                .addComponent(jLabel38)
                                                .addPreferredGap(RELATED, -1, 32767)
                                                .addComponent(chxVehiculo, -2, 35, -2))
                                        .addComponent(jLabel39, -2, 90, -2)
                                        .addComponent(txtObsPedido, -2, 280, -2)
                                        .addGroup(LEADING, jPanel9Layout.createSequentialGroup()
                                                .addComponent(btnRegPedido)
                                                .addPreferredGap(RELATED, -1, 32767)
                                                .addComponent(btnLimpiarPedido))
                                        .addComponent(txtIdPedido, -2, -1, -2))
                                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
                jPanel9Layout.createParallelGroup(LEADING)
                        .addGroup(jPanel9Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(txtIdPedido, -2, -1, -2)
                                .addPreferredGap(RELATED, -1, 32767)
                                .addGroup(jPanel9Layout.createParallelGroup(BASELINE)
                                        .addComponent(jLabel30)
                                        .addComponent(txtPlastico, -2, 35, -2)
                                        .addComponent(jLabel31))
                                .addGap(6)
                                .addGroup(jPanel9Layout.createParallelGroup(BASELINE)
                                        .addComponent(jLabel32)
                                        .addComponent(txtPapel, -2, 35, -2)
                                        .addComponent(jLabel33))
                                .addGap(6)
                                .addGroup(jPanel9Layout.createParallelGroup(BASELINE)
                                        .addComponent(jLabel34)
                                        .addComponent(txtVidrio, -2, 35, -2)
                                        .addComponent(jLabel35))
                                .addGap(6)
                                .addGroup(jPanel9Layout.createParallelGroup(BASELINE)
                                        .addComponent(jLabel36)
                                        .addComponent(txtMetal, -2, 35, -2)
                                        .addComponent(jLabel37))
                                .addGap(50)
                                .addGroup(jPanel9Layout.createParallelGroup(BASELINE)
                                        .addComponent(jLabel38, -2, 35, -2)
                                        .addComponent(chxVehiculo, -2, 35, -2))
                                .addGap(6)
                                .addComponent(jLabel39, -2, 35, -2)
                                .addComponent(txtObsPedido, -2, 70, -2)
                                .addGap(50)
                                .addGroup(jPanel9Layout.createParallelGroup(BASELINE)
                                        .addComponent(btnLimpiarPedido, -2, 45, -2)
                                        .addComponent(btnRegPedido, -2, 45, -2))
                                .addPreferredGap(RELATED, -1, 32767))
        );
        jPanel9.setLayout(jPanel9Layout);
        jLabel40.setIcon(imgEco);
        GroupLayout jPanel10Layout = new GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(jPanel10Layout
                .createParallelGroup(LEADING)
                .addGroup(jPanel10Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel9, -2, -1, -2)
                        .addGap(180, 180, 180)
                        .addComponent(jLabel40, -1, -1, 32767)
                        .addGap(6, 6, 6))
        );
        jPanel10Layout.setVerticalGroup(jPanel10Layout
                .createParallelGroup(LEADING)
                .addGroup(TRAILING, jPanel10Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jPanel9, -1, -1, 32767))
                .addComponent(jLabel40, -2, 0, 32767)
        );
        jTabbedPane1.addTab(labels.getString("tabPedidos.Rotulo"), jPanel10);
    }

    private void agregarTabOrdenes() {
        jPanel11.setBorder(BorderFactory.createTitledBorder(null, labels.getString("tabOrdenes.Titulo"), 2, 0, fntTitulo));
        jLabel41.setFont(fntLabel2);
        jLabel41.setText(labels.getString("tabOrdenes.Direccion"));
        jLabel42.setFont(fntLabel2);
        jLabel42.setText(labels.getString("tabOrdenes.Fecha"));
        jLabel43.setFont(fntLabel2);
        jLabel43.setText(labels.getString("tabOrdenes.Estado"));
        jLabel44.setFont(fntLabel2);
        jLabel44.setText(labels.getString("tabOrdenes.Observaciones"));
        btnVisitasObs.setIcon(icoGuardar);
        btnVisitasObs.setText(labels.getString("tabOrdenes.BtnVisitas"));
        btnVisitasObs.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnVisitasObs.addActionListener(this::btnVisitasObsActionPerformed);
        btnAgregarVisita.setIcon(icoModificar);
        btnAgregarVisita.setText(labels.getString("tabOrdenes.BtnAgregarVisita"));
        btnAgregarVisita.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnAgregarVisita.addActionListener(this::btnAgregarVisitaActionPerformed);
        GroupLayout jPanel11Layout = new GroupLayout(jPanel11);
        jPanel11Layout.setHorizontalGroup(
                jPanel11Layout.createParallelGroup(TRAILING)
                        .addGroup(LEADING, jPanel11Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel11Layout.createParallelGroup(LEADING)
                                        .addGroup(jPanel11Layout.createSequentialGroup()
                                                .addComponent(jLabel41)
                                                .addComponent(txtIdOrdenes, -2, 270, 270)
                                                .addComponent(txtIdRecolector, -2, 270, 270))
                                        .addGroup(jPanel11Layout.createSequentialGroup()
                                                .addComponent(btnVisitasObs, 0, 118, 32767)
                                                .addPreferredGap(RELATED, -1, 32767)
                                                .addComponent(btnAgregarVisita, 0, 158, 32767)
                                                .addContainerGap())
                                        .addComponent(jLabel42)
                                        .addComponent(jLabel43)
                                        .addComponent(jLabel44)
                                        .addGroup(TRAILING, jPanel11Layout.createSequentialGroup()
                                                .addGroup(jPanel11Layout.createParallelGroup(TRAILING)
                                                        .addComponent(txtDirOrdenes, LEADING, -1, 260, 32767)
                                                        .addComponent(txtFechaOrdenes, LEADING, -1, 260, 32767)
                                                        .addComponent(cbxEstado, LEADING, -1, 260, 32767)
                                                        .addComponent(txtObsOrdenes, -1, 260, 32767))
                                                .addContainerGap())))
        );
        jPanel11Layout.setVerticalGroup(
                jPanel11Layout.createParallelGroup(LEADING)
                        .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGroup(jPanel11Layout.createParallelGroup(LEADING)
                                        .addGroup(jPanel11Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jLabel41, -2, 35, -2))
                                        .addComponent(txtIdOrdenes, -2, -1, -2)
                                        .addComponent(txtIdRecolector, -2, -1, -2))
                                .addPreferredGap(RELATED)
                                .addComponent(txtDirOrdenes, -2, 35, -2)
                                .addPreferredGap(RELATED)
                                .addComponent(jLabel42, -2, 35, -2)
                                .addPreferredGap(RELATED)
                                .addComponent(txtFechaOrdenes, -2, 35, -2)
                                .addPreferredGap(RELATED)
                                .addComponent(jLabel43, -2, 35, -2)
                                .addPreferredGap(RELATED)
                                .addComponent(cbxEstado, -2, 35, -2)
                                .addPreferredGap(RELATED)
                                .addComponent(jLabel44, -2, 35, -2)
                                .addPreferredGap(RELATED)
                                .addComponent(txtObsOrdenes, -2, 70, -2)
                                .addGap(40)
                                .addGroup(jPanel11Layout.createParallelGroup(BASELINE)
                                        .addComponent(btnVisitasObs, -2, 45, -2)
                                        .addComponent(btnAgregarVisita, -2, 45, -2))
                                .addContainerGap(40, 32767))
        );
        jPanel11.setLayout(jPanel11Layout);
        tblOrdenes.setModel(new DefaultTableModel(new Object[0][], new String[]{
                labels.getString("tabOrdenes.TblId"),
                labels.getString("tabOrdenes.TblDuenio"),
                labels.getString("tabOrdenes.TblDireccion"),
                labels.getString("tabOrdenes.TblPersonal"),
                labels.getString("tabOrdenes.TblFecha"),
                labels.getString("tabOrdenes.TblEstado"),
                labels.getString("tabOrdenes.TblPlastico"),
                labels.getString("tabOrdenes.TblPapel"),
                labels.getString("tabOrdenes.TblVidrio"),
                labels.getString("tabOrdenes.TblMetal"),
                labels.getString("tabOrdenes.TblVehPes"),
                labels.getString("tabOrdenes.TblObs"),
        }));
        tblOrdenes.setRowHeight(20);
        tblOrdenes.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                tblOrdenesMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblOrdenes);
        jLabel45.setIcon(icoBuscar);
        jLabel45.setText(labels.getString("tabOrdenes.Buscar"));
        txtBuscarOrden.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent evt) {
                txtBuscarOrdenKeyReleased();
            }
        });
        GroupLayout jPanel12Layout = new GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(jPanel12Layout
                .createParallelGroup(LEADING)
                .addGroup(jPanel12Layout
                        .createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel12Layout
                                .createParallelGroup(LEADING, false)
                                .addGroup(jPanel12Layout
                                        .createSequentialGroup()
                                        .addComponent(jLabel45)
                                        .addGap(12, 12, 12)
                                        .addComponent(txtBuscarOrden, -2, 180, -2))
                                .addComponent(jPanel11, -1, -1, 32767))
                        .addPreferredGap(UNRELATED)
                        .addComponent(jScrollPane3, -1, 923, 32767)
                        .addGap(23, 23, 23)));
        jPanel12Layout.setVerticalGroup(jPanel12Layout
                .createParallelGroup(LEADING)
                .addGroup(TRAILING, jPanel12Layout
                        .createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel12Layout
                                .createParallelGroup(LEADING)
                                .addGroup(jPanel12Layout
                                        .createSequentialGroup()
                                        .addGroup(jPanel12Layout
                                                .createParallelGroup(LEADING)
                                                .addGroup(jPanel12Layout
                                                        .createSequentialGroup()
                                                        .addComponent(jLabel45)
                                                        .addGap(0, 0, 32767))
                                                .addGroup(TRAILING, jPanel12Layout
                                                        .createSequentialGroup()
                                                        .addGap(0, 0, 32767)
                                                        .addComponent(txtBuscarOrden, -2, 30, -2)))
                                        .addPreferredGap(UNRELATED)
                                        .addComponent(jPanel11, -2, -1, -2))
                                .addComponent(jScrollPane3, -1, 563, 32767))
                        .addGap(25, 25, 25)));
        jTabbedPane1.addTab(labels.getString("tabOrdenes.Rotulo"), jPanel12);
    }

    private void agregarTabMunicipio() {
        jPanel13.setBorder(BorderFactory.createTitledBorder(null, labels.getString("tabMunicipio.Titulo"), 2, 0, fntLabel2));
        jLabel46.setIcon(imgMunicipio);
        jLabel47.setFont(fntLabel2);
        jLabel47.setText(labels.getString("tabMunicipio.Documento"));
        jLabel48.setFont(fntLabel2);
        jLabel48.setText(labels.getString("tabMunicipio.Puntos"));
        jLabel49.setFont(fntLabel2);
        jLabel49.setText(labels.getString("tabMunicipio.ElegirBeneficio"));
        jLabel50.setFont(fntLabel2);
        jLabel50.setText(labels.getString("tabMunicipio.BeneficiosActivos"));
        jLabel51.setIcon(imgBeneficios);
        btnOrdenesMC.setIcon(icoRenovar);
        btnOrdenesMC.setText(labels.getString("tabMunicipio.BtnOrdenes"));
        btnOrdenesMC.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnOrdenesMC.addActionListener(this::btnOrdenesMCActionPerformed);
        btnCambiarPuntos.setIcon(icoNuevo);
        btnCambiarPuntos.setText(labels.getString("tabMunicipio.BtnCambiarPuntos"));
        btnCambiarPuntos.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnCambiarPuntos.addActionListener(this::btnCambiarPuntosActionPerformed);
        GroupLayout jPanel13Layout = new GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(jPanel13Layout
                .createParallelGroup(LEADING)
                .addGroup(jPanel13Layout
                        .createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel13Layout
                                .createParallelGroup(LEADING)
                                .addGroup(TRAILING, jPanel13Layout
                                        .createSequentialGroup()
                                        .addComponent(btnOrdenesMC, -1, -1, 32767)
                                        .addGap(93, 93, 93)
                                        .addComponent(btnCambiarPuntos, -1, 115, -1))
                                .addGroup(TRAILING, jPanel13Layout
                                        .createSequentialGroup()
                                        .addGap(0, 0, 32767)
                                        .addComponent(txtIdMC, -2, 74, -2))
                                .addGroup(jPanel13Layout
                                        .createSequentialGroup()
                                        .addGroup(jPanel13Layout
                                                .createParallelGroup(LEADING)
                                                .addComponent(jLabel48)
                                                .addComponent(jLabel49)
                                                .addComponent(jLabel47))
                                        .addGap(26, 26, 26)
                                        .addGroup(jPanel13Layout
                                                .createParallelGroup(LEADING)
                                                .addComponent(txtPuntos, 0, -1, 32767)
                                                .addComponent(cbxBeneficio, 0, -1, 32767)
                                                .addComponent(txtDocMC, 0, -1, 32767)))
                                .addGroup(TRAILING, jPanel13Layout
                                        .createSequentialGroup()
                                        .addGap(59, 59, 59)
                                        .addComponent(jLabel46)
                                        .addGap(0, 0, 32767))
                                .addGroup(jPanel13Layout
                                        .createSequentialGroup()
                                        .addComponent(jLabel50)
                                        .addGap(16, 16, 16)
                                        .addComponent(txtBenefActivos, -1, -1, 260)))
                        .addContainerGap()));
        jPanel13Layout.setVerticalGroup(jPanel13Layout
                .createParallelGroup(LEADING)
                .addGroup(jPanel13Layout
                        .createSequentialGroup()
                        .addComponent(jLabel46, -2, 0, 32767)
                        .addPreferredGap(UNRELATED)
                        .addGroup(jPanel13Layout
                                .createParallelGroup(BASELINE)
                                .addComponent(jLabel47)
                                .addComponent(txtDocMC, -2, 35, -2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel13Layout
                                .createParallelGroup(BASELINE)
                                .addComponent(jLabel48)
                                .addComponent(txtPuntos, -2, 35, -2))
                        .addGap(16, 16, 16)
                        .addGroup(jPanel13Layout
                                .createParallelGroup(BASELINE)
                                .addComponent(jLabel49)
                                .addComponent(cbxBeneficio, -2, 35, -2))
                        .addGap(16, 16, 16)
                        .addGroup(jPanel13Layout
                                .createParallelGroup(BASELINE)
                                .addComponent(jLabel50)
                                .addComponent(txtBenefActivos, -2, 70, -2))
                        .addGap(34, 34, 34)
                        .addComponent(txtIdMC, -2, -1, -2)
                        .addPreferredGap(RELATED)
                        .addGroup(jPanel13Layout
                                .createParallelGroup(BASELINE)
                                .addComponent(btnOrdenesMC, -2, 40, -2)
                                .addComponent(btnCambiarPuntos, -2, 40, -2))
                        .addGap(21, 21, 21))
        );

        GroupLayout jPanel14Layout = new GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(jPanel14Layout
                .createParallelGroup(LEADING)
                .addGroup(jPanel14Layout
                        .createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel14Layout
                                .createParallelGroup(LEADING, false)
                                .addComponent(jPanel13, -2, -1, -2))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel51, -1, 852, 32767)
                        .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(jPanel14Layout
                .createParallelGroup(LEADING)
                .addGroup(jPanel14Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel14Layout
                                .createParallelGroup(TRAILING, false)
                                .addComponent(jLabel51, -2, 568, -2)
                                .addGroup(LEADING, jPanel14Layout
                                        .createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jPanel13, -1, -1, 32767)))
                        .addContainerGap(29, 32767))
        );
        jTabbedPane1.addTab(labels.getString("tabMunicipio.Rotulo"), jPanel14);
    }

    private void agregarMenuBar() {
        jMenu1.setIcon(imgAdministracion);
        jMenu1.setText("Administración");
        MenuInscripciones.setIcon(imgInscripciones);
        MenuInscripciones.setText("Inscripciones");
        MenuInscripciones.setCursor(new Cursor(Cursor.HAND_CURSOR));
        MenuInscripciones.addActionListener(this::menuInscripcionesActionPerformed);
        jMenu1.add(MenuInscripciones);
        MenuPersonal.setIcon(imgPersonal);
        MenuPersonal.setText("Personal");
        MenuPersonal.setCursor(new Cursor(Cursor.HAND_CURSOR));
        MenuPersonal.addActionListener(this::menuPersonalActionPerformed);
        jMenu1.add(MenuPersonal);
        jMenuBar1.add(jMenu1);
        jMenu2.setIcon(imgRecolectores);
        jMenu2.setText("Recolectores");
        MenuOrdenes.setIcon(imgOrdenes);
        MenuOrdenes.setText("Órdenes");
        MenuOrdenes.setCursor(new Cursor(Cursor.HAND_CURSOR));
        MenuOrdenes.addActionListener(this::menuOrdenesActionPerformed);
        jMenu2.add(MenuOrdenes);
        jMenuBar1.add(jMenu2);
        MenuDuenio.setIcon(imgDuenio);
        MenuDuenio.setText("Dueño");
        MenuDuenio.setCursor(new Cursor(Cursor.HAND_CURSOR));
        MenuDuenio.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                menuDuenioMouseClicked();
            }
        });
        jMenuBar1.add(MenuDuenio);
        MenuVivienda.setIcon(imgVivienda);
        MenuVivienda.setText("Vivienda");
        MenuVivienda.setCursor(new Cursor(Cursor.HAND_CURSOR));
        MenuVivienda.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                menuViviendaMouseClicked();
            }
        });
        jMenuBar1.add(MenuVivienda);
        MenuPedidos.setIcon(imgPedidos);
        MenuPedidos.setText("Pedidos de Retiro");
        MenuPedidos.setCursor(new Cursor(Cursor.HAND_CURSOR));
        MenuPedidos.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                menuPedidosMouseClicked();
            }
        });
        jMenuBar1.add(MenuPedidos);
        MenuMunicipio.setIcon(imgMC);
        MenuMunicipio.setText("Municipio Club");
        MenuMunicipio.setCursor(new Cursor(Cursor.HAND_CURSOR));
        MenuMunicipio.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                menuMunicipioMouseClicked();
            }
        });
        jMenuBar1.add(MenuMunicipio);
        setJMenuBar(jMenuBar1);
    }

    // <<< -- ACCIONES DE MENU -- >>>

    private void menuDuenioMouseClicked() {
        MenuDuenio.setEnabled(false);
        MenuVivienda.setEnabled(true);
        MenuInscripciones.setEnabled(true);
        MenuPersonal.setEnabled(true);
        MenuPedidos.setEnabled(true);
        MenuOrdenes.setEnabled(true);
        MenuMunicipio.setEnabled(true);
        listarDuenio();
        jTabbedPane1.setSelectedIndex(0);
    }

    private void menuViviendaMouseClicked() {
        MenuDuenio.setEnabled(true);
        MenuVivienda.setEnabled(false);
        MenuInscripciones.setEnabled(true);
        MenuPersonal.setEnabled(true);
        MenuPedidos.setEnabled(true);
        MenuOrdenes.setEnabled(true);
        MenuMunicipio.setEnabled(true);
        listarVivienda();
        jTabbedPane1.setSelectedIndex(1);
    }

    private void menuInscripcionesActionPerformed() {
        MenuDuenio.setEnabled(true);
        MenuVivienda.setEnabled(true);
        MenuInscripciones.setEnabled(false);
        MenuPersonal.setEnabled(true);
        MenuPedidos.setEnabled(true);
        MenuOrdenes.setEnabled(true);
        MenuMunicipio.setEnabled(true);
        limpiarTabla();
        listarInscripciones();
        imgRegistrar(btnModInsc);
        jTabbedPane1.setSelectedIndex(2);
    }

    private void menuInscripcionesActionPerformed(ActionEvent evt) {
        menuInscripcionesActionPerformed();
    }

    private void menuPersonalActionPerformed(ActionEvent evt) {
        MenuDuenio.setEnabled(true);
        MenuVivienda.setEnabled(true);
        MenuInscripciones.setEnabled(true);
        MenuPersonal.setEnabled(false);
        MenuPedidos.setEnabled(true);
        MenuOrdenes.setEnabled(true);
        MenuMunicipio.setEnabled(true);
        limpiarTabla();
        listarPersonal();
        jTabbedPane1.setSelectedIndex(3);
    }

    private void menuPedidosMouseClicked() {
        MenuDuenio.setEnabled(true);
        MenuVivienda.setEnabled(true);
        MenuInscripciones.setEnabled(true);
        MenuPersonal.setEnabled(true);
        MenuPedidos.setEnabled(false);
        MenuOrdenes.setEnabled(true);
        MenuMunicipio.setEnabled(true);
        limpiarPedido();
        jTabbedPane1.setSelectedIndex(4);
    }

    private void menuOrdenesActionPerformed(ActionEvent evt) {
        MenuDuenio.setEnabled(true);
        MenuVivienda.setEnabled(true);
        MenuInscripciones.setEnabled(true);
        MenuPersonal.setEnabled(true);
        MenuPedidos.setEnabled(true);
        MenuOrdenes.setEnabled(false);
        MenuMunicipio.setEnabled(true);
        limpiarTabla();
        listarOrdenes();
        jTabbedPane1.setSelectedIndex(5);
    }

    private void menuMunicipioMouseClicked() {
        MenuDuenio.setEnabled(true);
        MenuVivienda.setEnabled(true);
        MenuInscripciones.setEnabled(true);
        MenuPersonal.setEnabled(true);
        MenuPedidos.setEnabled(true);
        MenuOrdenes.setEnabled(true);
        MenuMunicipio.setEnabled(false);
        listarPuntosMC();
        jTabbedPane1.setSelectedIndex(6);
    }

    // <<< -- ACCIONES DE BOTONES -- >>>

    private void btnAgregarVisitaActionPerformed(ActionEvent actionEvent) {
        String id = txtIdOrdenes.getText();
        if (id.isEmpty()) mostrarMensaje("Seleccione una órden a modificar.");
        else {
            String estado = Objects.requireNonNull(cbxEstado.getSelectedItem()).toString();
            String observacion = txtObsOrdenes.getText();
            try {
                desp.registrarVisita(id, estado, observacion);
                mostrarMensaje("Nota agregada");
            } catch (UbicacionIdNotFoundException e) {
                System.out.println("BAD_REQUEST " + e);
            } catch (SQLException e) {
                System.out.println("BAD_REQUEST " + "Fallo al recibir base de datos");
            } catch (Exception e) {
                System.out.println("ERROR " + e);
            }
        }
    }

    private void btnCambiarPuntosActionPerformed(ActionEvent evt) {
        String id = txtDocMC.getText();
        String beneficio = Objects.requireNonNull(cbxBeneficio.getSelectedItem()).toString();
        try {
            desp.cambiarPuntos(id, beneficio);
        } catch (PersonalIdNotFoundException e) {
            System.out.println("BAD_REQUEST " + e);
        } catch (SQLException e) {
            System.out.println("BAD_REQUEST " + "Fallo al recibir base de datos");
        } catch (Exception e) {
            System.out.println("ERROR " + e);
        }
        listarPuntosMC();
    }

    private void btnEliInscActionPerformed(ActionEvent evt) {
        if (txtIdInsc.getText().isEmpty()) {
            mostrarMensaje("Seleccine una fila");
        } else {
            int pregunta = pedirConfirmacion(String.format("documento %s", txtIdInsc.getText()));
            if (pregunta == 0) {
                try {
                    desp.eliminarDuenio(txtIdInsc.getText());
                    limpiarTabla();
                    limpiarInscripcion();
                    listarInscripciones();
                    mostrarMensaje("Inscripción Eliminada");
                } catch (DuenioFieldInvalidException | DuenioIdNotFoundException | NumberFormatException e) {
                    System.out.println("BAD_REQUEST " + e);
                } catch (SQLException e) {
                    System.out.println("BAD_REQUEST " + "Fallo al recibir base de datos");
                } catch (Exception e) {
                    System.out.println("ERROR " + e.getMessage());
                }
            }
        }
    }

    private void btnEliPersonalActionPerformed(ActionEvent evt) {
        String id = txtIdPersonal.getText();
        if (id.isEmpty()) {
            mostrarMensaje("Seleccine una fila");
        } else {
            String nomCompleto = txtNomPersonal.getText() + " " + txtApePersonal.getText();
            int pregunta = pedirConfirmacion(nomCompleto);
            if (pregunta == 0) {
                try {
                    desp.eliminarPersonal(txtDocPersonal.getText());
                    mostrarMensaje("Personal eliminado");
                    limpiarTabla();
                    limpiarPersonal();
                    listarPersonal();
                    imgRegistrar(btnRegPersonal);
                } catch (PersonalFieldInvalidException | PersonalIdNotFoundException | NumberFormatException e) {
                    System.out.println("BAD_REQUEST " + e.getMessage());
                } catch (SQLException e) {
                    System.out.println("BAD_REQUEST " + "Fallo al recibir base de datos");
                } catch (Exception e) {
                    System.out.println("ERROR " + e.getMessage());
                }
            }
        }
    }

    private void btnLimpiarInscActionPerformed(ActionEvent evt) {
        limpiarInscripcion();
        imgRegistrar(btnModInsc);
    }

    private void btnLimpiarPedidoActionPerformed(ActionEvent actionEvent) {
        limpiarPedido();
    }

    private void btnModInscActionPerformed(ActionEvent evt) {
        modificarInscripcion();
        limpiarTabla();
        listarInscripciones();
    }

    private void btnNuevoPersonalActionPerformed(ActionEvent evt) {
        limpiarPersonal();
        imgRegistrar(btnRegPersonal);
    }

    private void btnRegPedidoActionPerformed(ActionEvent actionEvent) {
        String duenio = usuario.getDocumento();
        String plastico = txtPlastico.getText();
        String papel = txtPapel.getText();
        String vidrio = txtVidrio.getText();
        String metal = txtMetal.getText();
        boolean vehiculo = chxVehiculo.isSelected();
        String observacion = txtObsPedido.getText();
        try {
            desp.registrarOrden(duenio, plastico, papel, vidrio, metal, vehiculo, observacion);
        } catch (OrdenFieldInvalidException | OrdenEntityExistsException |
                 DuenioIdNotFoundException | PersonalIdNotFoundException | NumberFormatException e) {
            System.out.println("BAD_REQUEST " + e);
        } catch (SQLException e) {
            System.out.println("BAD_REQUEST " + "Fallo al recibir base de datos");
        } catch (Exception e) {
            System.out.println("ERROR " + e);
        }
    }

    private void btnRegDuenioActionPerformed(ActionEvent evt) {
        String nombre = txtNomDuenio.getText();
        String apellido = txtApeDuenio.getText();
        String documento = txtDocDuenio.getText();
        String correo = txtCorreoDuenio.getText();
        String telefono = txtTelDuenio.getText();
        try {
            desp.registrarDuenio(nombre, apellido, documento, correo, telefono);
            mostrarMensaje(labels.getString("regDuenio.Ok") + nombre + " " + apellido);
            txtDocVivienda.setText(documento);
            usuario.setDocumento(documento);
            menuViviendaMouseClicked();
        } catch (DuenioFieldInvalidException e) {
            mostrarMensaje(labels.getString("regDuenio.DFIException") + e.getMessage());
        } catch (SQLException e) {
            if (e.getMessage().contains("Duplicate entry")) {
                mostrarMensaje(labels.getString("regDuenio.SQLExceptionDE"));
            } else {
                mostrarMensaje(labels.getString("regDuenio.SQLException"));
            }
        } catch (Exception e) {
            mostrarMensaje(labels.getString("regDuenio.Exception"));
            System.out.println(e.getMessage());
        }
    }

    private void btnRegPersonalActionPerformed(ActionEvent evt) {
        registrarPersonal();
        limpiarTabla();
        listarPersonal();
    }

    private void btnRegViviendaActionPerformed(ActionEvent evt) {
        if (txtUbicacion.getText().isEmpty()) {
            validarUbicacion();
        } else {
            registrarVivienda();
        }
    }

    private void btnOrdenesMCActionPerformed(ActionEvent evt) {
        try {
            var txt = desp.listarOrdenesMC(txtDocMC.getText());
            if (txt.isEmpty()) {
                mostrarMensaje("No se encontraron órdenes de visita\n pendientes para éste usuario");
            } else {
                mostrarMensaje(txt);
            }
        } catch (OrdenFieldInvalidException e) {
            System.out.println("BAD_REQUEST " + e);
        } catch (SQLException e) {
            System.out.println("BAD_REQUEST " + "Fallo al recibir base de datos");
        } catch (Exception e) {
            System.out.println("ERROR " + e);
        }
    }

    private void btnVisitasObsActionPerformed(ActionEvent evt) {
        String idOrden = txtIdOrdenes.getText();
        String idRecolector = txtIdRecolector.getText();
        String direccion = txtDirOrdenes.getText();
        String estado = Objects.requireNonNull(cbxEstado.getSelectedItem()).toString();
        if (idOrden.isEmpty()) mostrarMensaje("Debe seleccionar una órden de visita.");
        else {
            listarVisitas(idRecolector, direccion, estado);
        }
    }

    private void tblInscMouseClicked(MouseEvent evt) {
        int fila = tblInscripciones.rowAtPoint(evt.getPoint());

        txtIdInsc.setText(tblInscripciones.getValueAt(fila, 1).toString());
        txtDocInsc.setText(tblInscripciones.getValueAt(fila, 1).toString());
        txtNomInsc.setText(tblInscripciones.getValueAt(fila, 2).toString());
        txtApeInsc.setText(tblInscripciones.getValueAt(fila, 3).toString());
        txtCorreoInsc.setText(tblInscripciones.getValueAt(fila, 4).toString());
        txtTelInsc.setText(tblInscripciones.getValueAt(fila, 5).toString());
        txtDirInsc.setText(tblInscripciones.getValueAt(fila, 6).toString());
        txtZonaInsc.setText(tblInscripciones.getValueAt(fila, 7).toString());
        txtBarrioInsc.setText(tblInscripciones.getValueAt(fila, 8).toString());
        imgModificar(btnModInsc);
    }

    private void tblOrdenesMouseClicked(MouseEvent evt) {
        int fila = tblOrdenes.rowAtPoint(evt.getPoint());
        txtIdOrdenes.setText(tblOrdenes.getValueAt(fila, 0).toString());
        txtIdRecolector.setText(tblOrdenes.getValueAt(fila, 3).toString());
        txtDirOrdenes.setText(tblOrdenes.getValueAt(fila, 2).toString());
        txtFechaOrdenes.setText(tblOrdenes.getValueAt(fila, 4).toString());
        cbxEstado.setSelectedItem(tblOrdenes.getValueAt(fila, 5).toString());
    }

    private void tblPersonalMouseClicked(MouseEvent evt) {
        int fila = tblPersonal.rowAtPoint(evt.getPoint());
        txtIdPersonal.setText(tblPersonal.getValueAt(fila, 0).toString());
        txtNomPersonal.setText(tblPersonal.getValueAt(fila, 1).toString());
        txtApePersonal.setText(tblPersonal.getValueAt(fila, 2).toString());
        txtDocPersonal.setText(tblPersonal.getValueAt(fila, 3).toString());
        imgModificar(btnRegPersonal);
    }

    private void txtBuscarInscKeyReleased() {
        limpiarTabla();
        listarInscripcionesFiltradas(txtBuscarInsc.getText());
    }

    private void txtBuscarOrdenKeyReleased() {
        limpiarTabla();
        listarOrdenesFiltradas(txtBuscarOrden.getText());
    }

    private void txtBuscarPersonalKeyReleased() {
        limpiarTabla();
        listarPersonalFiltrado(txtBuscarPersonal.getText());
    }

    private void color(JTable tabla) {
        JTableHeader header = tabla.getTableHeader();
        header.setOpaque(false);
        header.setBackground(new Color(0, 110, 255));
        header.setForeground(Color.white);
    }

    private void imgModificar(JButton boton) {
        boton.setText("Modificar");
        boton.setIcon(icoModificar);
    }

    private void imgRegistrar(JButton boton) {
        boton.setText("Registrar");
        boton.setIcon(icoGuardar);
    }

    private void limpiarPedido() {
        txtPlastico.setText("");
        txtPapel.setText("");
        txtVidrio.setText("");
        txtMetal.setText("");
        chxVehiculo.setSelected(false);
        txtObsPedido.setText("");
    }

    private void limpiarInscripcion() {
        txtIdInsc.setText("");
        txtDocInsc.setText("");
        txtNomInsc.setText("");
        txtApeInsc.setText("");
        txtCorreoInsc.setText("");
        txtTelInsc.setText("");
        txtDirInsc.setText("");
        txtZonaInsc.setText("");
        txtBarrioInsc.setText("");
    }

    private void limpiarPersonal() {
        txtIdPersonal.setText("");
        txtNomPersonal.setText("");
        txtApePersonal.setText("");
        txtDocPersonal.setText("");
        txtBuscarPersonal.setText("");
    }

    public void limpiarTabla() {
        for (int i = 0; i < tabla.getRowCount(); i++) {
            tabla.removeRow(i);
            i = i - 1;
        }
    }

    private void listarDuenio() {
        try {
            DuenioDto d = desp.listarDuenioPorId(usuario.getDocumento());
            txtNomDuenio.setText(d.getNomDuenio());
            txtApeDuenio.setText(d.getApeDuenio());
            txtDocDuenio.setText(d.getDocDuenio());
            txtTelDuenio.setText(d.getTelDuenio());
            txtCorreoDuenio.setText(d.getCorreoDuenio());
            jTabbedPane1.setSelectedIndex(0);
        } catch (DuenioIdNotFoundException e) {
            System.out.println("BAD_REQUEST " + e);
        } catch (SQLException e) {
            System.out.println("BAD_REQUEST " + "Fallo al recibir base de datos");
        } catch (Exception e) {
            System.out.println("ERROR " + e);
        }
    }

    private void listarInscripciones() {
        try {
            var lista = desp.listarInscripciones();
            tabla = (DefaultTableModel) tblInscripciones.getModel();
            Object[] ob = new Object[12];
            for (InscripcionDto ins : lista) {
                ob[0] = ins.getId();
                ob[1] = ins.getDocumento();
                ob[2] = ins.getNombre();
                ob[3] = ins.getApellido();
                ob[4] = ins.getCorreo();
                ob[5] = ins.getTelefono();
                ob[6] = ins.getDireccion();
                ob[7] = ins.getZona();
                ob[8] = ins.getBarrio();
                ob[9] = ins.getLatitud();
                ob[10] = ins.getLongitud();
                ob[11] = ins.getFecha();
                tabla.addRow(ob);
            }
            tblInscripciones.setModel(tabla);
            color(tblInscripciones);
        } catch (SQLException e) {
            System.out.println("BAD_REQUEST " + "Fallo al recibir base de datos");
        } catch (Exception e) {
            System.out.println("ERROR " + e);
        }
    }

    private void listarInscripcionesFiltradas(String valor) {
        try {
            var lista = desp.listarInscripcionPor(valor);
            tabla = (DefaultTableModel) tblInscripciones.getModel();
            Object[] ob = new Object[12];
            for (InscripcionDto ins : lista) {
                ob[0] = ins.getId();
                ob[1] = ins.getDocumento();
                ob[2] = ins.getNombre();
                ob[3] = ins.getApellido();
                ob[4] = ins.getCorreo();
                ob[5] = ins.getTelefono();
                ob[6] = ins.getDireccion();
                ob[7] = ins.getZona();
                ob[8] = ins.getBarrio();
                ob[9] = ins.getLatitud();
                ob[10] = ins.getLongitud();
                ob[11] = ins.getFecha();
                tabla.addRow(ob);
            }
            tblInscripciones.setModel(tabla);
            color(tblInscripciones);
        } catch (SQLException e) {
            System.out.println("BAD_REQUEST " + "Fallo al recibir base de datos");
        } catch (Exception e) {
            System.out.println("ERROR " + e);
        }
    }

    private void listarOrdenes() {
        try {
            var lista = desp.listarOrdenes();
            tabla = (DefaultTableModel) tblOrdenes.getModel();
            Object[] ob = new Object[12];
            for (OrdenDto o : lista) {
                ob[0] = o.getId();
                ob[1] = o.getDuenio();
                ob[2] = o.getDireccion();
                ob[3] = o.getPersonal();
                ob[4] = o.getFecha();
                ob[5] = o.getEstado();
                ob[6] = o.getPlastico();
                ob[7] = o.getPapel();
                ob[8] = o.getVidrio();
                ob[9] = o.getMetal();
                ob[10] = o.isVehiculoPesado();
                ob[11] = o.getObservacion();
                tabla.addRow(ob);
            }
            tblOrdenes.setModel(tabla);
            color(tblOrdenes);
        } catch (SQLException e) {
            System.out.println("BAD_REQUEST " + "Fallo al recibir base de datos");
        } catch (Exception e) {
            System.out.println("ERROR " + e);
        }
    }

    private void listarOrdenesFiltradas(String valor) {
        try {
            var lista = desp.listarOrdenPor(valor);
            tabla = (DefaultTableModel) tblOrdenes.getModel();
            Object[] ob = new Object[12];
            for (OrdenDto o : lista) {
                ob[0] = o.getId();
                ob[1] = o.getDuenio();
                ob[2] = o.getDireccion();
                ob[3] = o.getPersonal();
                ob[4] = o.getFecha();
                ob[5] = o.getEstado();
                ob[6] = o.getPlastico();
                ob[7] = o.getPapel();
                ob[8] = o.getVidrio();
                ob[9] = o.getMetal();
                ob[10] = o.isVehiculoPesado();
                ob[11] = o.getObservacion();
                tabla.addRow(ob);
            }
            tblOrdenes.setModel(tabla);
            color(tblOrdenes);
        } catch (NumberFormatException e) {
            System.out.println("BAD_REQUEST " + e);
        } catch (SQLException e) {
            System.out.println("BAD_REQUEST " + "Fallo al recibir base de datos");
        } catch (Exception e) {
            System.out.println("ERROR " + e);
        }
    }

    private void listarPersonal() {

        try {
            var lista = desp.listarPersonal();
            tabla = (DefaultTableModel) tblPersonal.getModel();
            Object[] ob = new Object[4];
            for (int i = 0; i < lista.size(); i++) {
                ob[0] = i + 1;
                ob[1] = lista.get(i).getNomPersonal();
                ob[2] = lista.get(i).getApePersonal();
                ob[3] = lista.get(i).getDocPersonal();
                tabla.addRow(ob);
            }
            tblPersonal.setModel(tabla);
            color(tblPersonal);
        } catch (SQLException e) {
            System.out.println("BAD_REQUEST " + "Fallo al recibir base de datos");
        } catch (Exception e) {
            System.out.println("ERROR " + e);
        }
    }

    private void listarPersonalFiltrado(String valor) {
        try {
            var lista = desp.listarPersonalPor(valor);
            tabla = (DefaultTableModel) tblPersonal.getModel();
            Object[] ob = new Object[4];
            for (int i = 0; i < lista.size(); i++) {
                ob[0] = i + 1;
                ob[1] = lista.get(i).getNomPersonal();
                ob[2] = lista.get(i).getApePersonal();
                ob[3] = lista.get(i).getDocPersonal();
                tabla.addRow(ob);
            }
            tblInscripciones.setModel(tabla);
            color(tblInscripciones);
        } catch (SQLException e) {
            System.out.println("BAD_REQUEST " + "Fallo al recibir base de datos");
        } catch (Exception e) {
            System.out.println("ERROR " + e);
        }
    }

    private void listarPuntosMC() {
        String id = usuario.getDocumento();
        txtDocMC.setText(id);

        try {
            CampaniaDto campania = desp.listarCampaniaPorId(id);
            txtPuntos.setText(String.valueOf(campania.getPuntos()));
            txtBenefActivos.setText(campania.getBeneficios());
        } catch (PersonalIdNotFoundException e) {
            System.out.println("BAD_REQUEST " + e);
        } catch (SQLException e) {
            System.out.println("BAD_REQUEST " + "Fallo al recibir base de datos");
        } catch (Exception e) {
            System.out.println("ERROR " + e);
        }
    }

    private void listarVisitas(String idRecolector, String direccion, String estado) {
        try {
            var lista = desp.listarVisitasPorId(txtIdOrdenes.getText());
            var personal = desp.listarPersonalPorId(idRecolector);
            String texto = "";
            if (lista != null) {
                texto += String.format("Orden de Retiro %s - Vivienda %s ", lista.getFirst().getIdOrden(), direccion);
                texto += String.format("- Recolector %s %s%n", personal.getNomPersonal(), personal.getApePersonal());
                texto += String.format("(Estado %s)%n", estado);
                StringBuilder textoBuilder = new StringBuilder(texto);
                for (int i = 0; i < lista.size(); i++) {
                    textoBuilder.append(String.format("Visita %d: Fecha: %s -%n%s%n", (i + 1), lista.get(i).getFecha(),
                            lista.get(i).getObservacion()));
                }
                texto = textoBuilder.toString();
                mostrarMensaje(texto);
            }
        } catch (PersonalIdNotFoundException e) {
            System.out.println("BAD_REQUEST " + e);
        } catch (SQLException e) {
            System.out.println("BAD_REQUEST " + "Fallo al recibir base de datos");
        } catch (Exception e) {
            System.out.println("ERROR " + e);
        }
    }

    private void listarVivienda() {
        if (!usuario.getDocumento().isEmpty()) {
            try {
                ViviendaDto v = desp.listarViviendaPorId(usuario.getDocumento());
                txtDirVivienda.setText(v.getDireccion());
                txtZonaVivienda.setText(v.getZona());
                txtBarrioVivienda.setText(v.getBarrio());
            } catch (ViviendaIdNotFoundException e) {
                System.out.println("BAD_REQUEST " + e);
            } catch (SQLException e) {
                System.out.println("BAD_REQUEST " + "Fallo al recibir base de datos");
            } catch (Exception e) {
                System.out.println("ERROR " + e);
            }
//            mostrarMensaje("Problemas al recuperar datos de dirección.");
        }
    }

    private void llenarBeneficios() {
        cbxBeneficio.addItem("");
        cbxBeneficio.addItem("Beneficio 1");
        cbxBeneficio.addItem("Beneficio 2");
        cbxBeneficio.addItem("Beneficio 3");
        cbxBeneficio.addItem("Beneficio 4");
    }

    private void llenarEstado() {
        cbxEstado.addItem("");
        cbxEstado.addItem("PENDIENTE");
        cbxEstado.addItem("EN_EJECUCION");
        cbxEstado.addItem("CONCRETADO");
        cbxEstado.addItem("CANCELADO");
    }

    private void modificarInscripcion() {
        String id = txtIdInsc.getText();
        if (id.isEmpty()) {
            mostrarMensaje("Debe seleccionar alguna inscripción");
            return;
        }
        String nombre = txtNomInsc.getText();
        String apellido = txtApeInsc.getText();
        String correo = txtCorreoInsc.getText();
        String telefono = txtTelInsc.getText();
        String direccion = txtDirInsc.getText();
        String zona = txtZonaInsc.getText();
        String barrio = txtBarrioInsc.getText();
        try {
            desp.modificarInscripcion(id, nombre, apellido, correo, telefono, direccion, zona, barrio);
            mostrarMensaje("Incripción Modificada");
        } catch (InscripcionFieldInvalidException | DuenioIdNotFoundException | NumberFormatException e) {
            System.out.println("BAD_REQUEST " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("BAD_REQUEST " + "Fallo al recibir base de datos");
        } catch (Exception e) {
            System.out.println("ERROR " + e);
        }
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }

    private int pedirConfirmacion(String msj) {
        return JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar: " + msj + "?",
                "Pregunta", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
    }

    private void registrarPersonal() {
        String id = txtIdPersonal.getText();
        String nombre = txtNomPersonal.getText();
        String apellido = txtApePersonal.getText();
        String documento = txtDocPersonal.getText();
        if (id.isEmpty()) {
            try {
                desp.registrarPersonal(nombre, apellido, documento);
                mostrarMensaje(labels.getString("regPersonal.Ok") + nombre + " " + apellido);
            } catch (PersonalFieldInvalidException e) {
                mostrarMensaje(labels.getString("regPersonal.PFIException") + e.getMessage());
            } catch (SQLException e) {
                if (e.getMessage().contains("Duplicate entry")) {
                    mostrarMensaje(labels.getString("regPersonal.SQLExceptionDE"));
                } else {
                    mostrarMensaje(labels.getString("regPersonal.SQLException"));
                }
            } catch (Exception e) {
                mostrarMensaje(labels.getString("regPersonal.Exception"));
                System.out.println("Error inesperado: " + e.getMessage());
            }
        } else {
            try {
                desp.modificarPersonal(nombre, apellido, documento);
                mostrarMensaje("Personal Modificado");
            } catch (PersonalFieldInvalidException | PersonalIdNotFoundException | NumberFormatException e) {
                System.out.println("BAD_REQUEST " + e);
            } catch (SQLException e) {
                System.out.println("BAD_REQUEST " + "Fallo al recibir base de datos");
            } catch (Exception e) {
                System.out.println("ERROR " + e);
            }
        }
        limpiarPersonal();
        imgRegistrar(btnRegPersonal);
    }

    private void registrarVivienda() {
        String documento = usuario.getDocumento();
        String direccion = txtDirVivienda.getText();
        String zona = txtZonaVivienda.getText();
        String barrio = txtBarrioVivienda.getText();
        try {
            UbicacionDto ubicacion = desp.validarUbicacion(documento, direccion, barrio);
            desp.registrarVivienda(documento, direccion, zona, barrio);
            desp.registrarUbicacion(documento, ubicacion.getLatitud(), ubicacion.getLongitud());
            mostrarMensaje("Vivienda registrada satisfactoriamente");
            menuInscripcionesActionPerformed();
        } catch (ViviendaFieldInvalidException | ViviendaEntityExistsException | DuenioIdNotFoundException |
                 NumberFormatException | UbicacionFieldInvalidException | UbicacionEntityExistsException e) {
            System.out.println("BAD_REQUEST " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("BAD_REQUEST " + "Fallo al recibir base de datos");
        } catch (Exception e) {
            System.out.println("ERROR " + e.getMessage());
        }
    }

    private void validarUbicacion() {
        String documento = txtDocVivienda.getText();
        String direccion = txtDirVivienda.getText();
        String barrio = txtBarrioVivienda.getText();
        try {
            UbicacionDto ubicacion = desp.validarUbicacion(documento, direccion, barrio);
            mostrarMensaje("Ubicación hallada");
            txtDirVivienda.setEnabled(false);
            txtZonaVivienda.setEnabled(false);
            txtBarrioVivienda.setEnabled(false);
            txtUbicacion.setText(String.format("%s : %s", ubicacion.getLatitud(), ubicacion.getLongitud()));
            btnRegVivienda.setText("Registrar Vivienda");
        } catch (DuenioIdNotFoundException | UbicacionFieldInvalidException e) {
            System.out.println("BAD_REQUEST " + e.getMessage());
        } catch (Exception e) {
            System.out.println("ERROR " + e);
        }
    }

    public static void main(String[] args) {
        FlatDarkLaf.setup();
        UIManager.put("Button.arc", 12);
        java.awt.EventQueue.invokeLater(() -> new FrmPanel().setVisible(true));
    }
}