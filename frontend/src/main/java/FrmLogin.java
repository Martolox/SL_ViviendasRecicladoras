import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class FrmLogin extends JFrame {
    private JButton btnLogin;

    public FrmLogin() {
        iniciarComponentes();
        this.setLocationRelativeTo(null);
        btnLogin.setBackground(new Color(0, 153, 153));
        btnLogin.setOpaque(true);
    }

    private void iniciarComponentes() {
        JLabel jLabel1 = new JLabel();
        JLabel jLabel2 = new JLabel();
        JLabel jLabel3 = new JLabel();
        JPanel jPanel1 = new JPanel();
        JPanel jPanel2 = new JPanel();
        btnLogin = new JButton();
        JTextField txtUsuario = new JTextField();
        JPasswordField txtClave = new JPasswordField();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new AbsoluteLayout());
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/img/img_Casa.png"))));
        jLabel1.setHorizontalTextPosition(SwingConstants.CENTER);
        getContentPane().add(jLabel1, new AbsoluteConstraints(0, 0, 480, 490));

        jPanel1.setBackground(new Color(255, 255, 255));
        jPanel2.setBackground(new Color(255, 255, 255));
        jPanel1.setLayout(new AbsoluteLayout());

        btnLogin.setBackground(new Color(0, 153, 153));
        btnLogin.setForeground(new Color(255, 255, 255));
        btnLogin.setText("Login");
        btnLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnLogin.setOpaque(false);
        btnLogin.addActionListener(evt -> {
        });
        jPanel1.add(btnLogin, new AbsoluteConstraints(120, 420, 260, 47));

        txtUsuario.setFont(new Font("Times New Roman", Font.BOLD, 14));
        txtUsuario.setHorizontalAlignment(JTextField.CENTER);
        txtUsuario.setBorder(BorderFactory.createTitledBorder(null, "Usuario", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14)));
        txtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
        });
        jPanel1.add(txtUsuario, new AbsoluteConstraints(120, 270, 260, 60));
        jLabel2.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/img/avatar.png"))));
        jLabel2.setText("jLabel2");
        jPanel1.add(jLabel2, new AbsoluteConstraints(160, 90, 170, 160));
        jLabel3.setFont(new java.awt.Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
        jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel3.setText("Iniciar Sesión");
        jPanel1.add(jLabel3, new AbsoluteConstraints(100, 40, 300, -1));
        txtClave.setHorizontalAlignment(JTextField.CENTER);
        txtClave.setBorder(BorderFactory.createTitledBorder(null, "Contraseña", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new Font("Times New Roman", 3, 14)));
        txtClave.addKeyListener(new java.awt.event.KeyAdapter() {
        });
        jPanel1.add(txtClave, new AbsoluteConstraints(120, 340, 260, 60));
        getContentPane().add(jPanel1, new AbsoluteConstraints(420, 0, 440, 490));
        getContentPane().add(jPanel2, new AbsoluteConstraints(0, 0, 440, 490));
        pack();
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmLogin().setVisible(true);
            }
        });
    }
}

