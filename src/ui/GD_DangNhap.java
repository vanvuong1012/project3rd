package ui;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;

import connectDB.ConnectDB;

/**
 *
 * @author WIN10
 */
public class GD_DangNhap extends javax.swing.JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Creates new form Login
	 * 
	 * @throws MalformedURLException
	 */
	public GD_DangNhap() throws MalformedURLException {
		initComponents();
		setLocationRelativeTo(null);
		this.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
				.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "clickButton");
		this.getRootPane().getActionMap().put("clickButton", new AbstractAction() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent ae) {
				btn_DangNhap.doClick();
			}
		});
	}

	private void initComponents() {

		pn_LoginLeft = new javax.swing.JPanel();
		LogoHNV = new javax.swing.JLabel();
		pn_LoginRight = new javax.swing.JPanel();
		lbl_LogoLogin = new javax.swing.JLabel();
		lbl_TenTK = new javax.swing.JLabel();
		lbl_MatKhau = new javax.swing.JLabel();
		txt_TaiKhoan = new javax.swing.JTextField();
		txt_MatKhau = new javax.swing.JPasswordField();
		btn_DangNhap = new javax.swing.JButton();
		btn_Thoat = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		pn_LoginLeft.setBackground(new java.awt.Color(255, 255, 255));

		LogoHNV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo2.png"))); // NOI18N

		javax.swing.GroupLayout pn_LoginLeftLayout = new javax.swing.GroupLayout(pn_LoginLeft);
		pn_LoginLeft.setLayout(pn_LoginLeftLayout);
		pn_LoginLeftLayout
				.setHorizontalGroup(
						pn_LoginLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(pn_LoginLeftLayout.createSequentialGroup().addGap(62, 62, 62)
										.addComponent(LogoHNV, javax.swing.GroupLayout.PREFERRED_SIZE, 252,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap(70, Short.MAX_VALUE)));
		pn_LoginLeftLayout
				.setVerticalGroup(pn_LoginLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(pn_LoginLeftLayout.createSequentialGroup().addGap(168, 168, 168).addComponent(LogoHNV)
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		pn_LoginRight.setBackground(new java.awt.Color(176, 226, 255));

		lbl_LogoLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/login.png"))); // NOI18N

		lbl_TenTK.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
		lbl_TenTK.setText("Tên Tài Khoản:");

		lbl_MatKhau.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
		lbl_MatKhau.setText("Mật Khẩu:");

		btn_DangNhap.setText("ĐĂNG NHẬP");
		btn_DangNhap.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					gdChinh = new QLLD_Application();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					if (evenLogin()) {
						gdChinh.setVisible(true);
					}
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

		btn_Thoat.setText("THOÁT");

		javax.swing.GroupLayout pn_LoginRightLayout = new javax.swing.GroupLayout(pn_LoginRight);
		pn_LoginRight.setLayout(pn_LoginRightLayout);
		pn_LoginRightLayout.setHorizontalGroup(pn_LoginRightLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pn_LoginRightLayout.createSequentialGroup().addGap(44, 44, 44).addGroup(pn_LoginRightLayout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
						.addGroup(pn_LoginRightLayout.createSequentialGroup().addComponent(lbl_TenTK).addGap(18, 18, 18)
								.addComponent(txt_TaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 307,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_LoginRightLayout
								.createSequentialGroup().addComponent(lbl_MatKhau)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(pn_LoginRightLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(txt_MatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 307,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGroup(pn_LoginRightLayout.createSequentialGroup()
												.addComponent(btn_DangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 125,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(btn_Thoat, javax.swing.GroupLayout.PREFERRED_SIZE, 125,
														javax.swing.GroupLayout.PREFERRED_SIZE)))))
						.addContainerGap(82, Short.MAX_VALUE))
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						pn_LoginRightLayout.createSequentialGroup()
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lbl_LogoLogin).addGap(198, 198, 198)));
		pn_LoginRightLayout.setVerticalGroup(pn_LoginRightLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pn_LoginRightLayout.createSequentialGroup().addGap(23, 23, 23).addComponent(lbl_LogoLogin)
						.addGap(58, 58, 58)
						.addGroup(pn_LoginRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(pn_LoginRightLayout.createSequentialGroup().addGap(8, 8, 8)
										.addComponent(lbl_TenTK))
								.addComponent(txt_TaiKhoan, javax.swing.GroupLayout.Alignment.TRAILING,
										javax.swing.GroupLayout.PREFERRED_SIZE, 33,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(33, 33, 33)
						.addGroup(pn_LoginRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(lbl_MatKhau)
								.addComponent(txt_MatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 33,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(44, 44, 44)
						.addGroup(pn_LoginRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(btn_DangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 53,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(btn_Thoat, javax.swing.GroupLayout.PREFERRED_SIZE, 53,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addContainerGap(102, Short.MAX_VALUE)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(pn_LoginLeft, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(pn_LoginRight,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(pn_LoginLeft, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE)
				.addComponent(pn_LoginRight, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	public boolean keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			return true;
		}
		return false;
	}

	@SuppressWarnings("deprecation")
	public boolean evenLogin() throws MalformedURLException {
		String userName = txt_TaiKhoan.getText().trim();
		String passWord = txt_MatKhau.getText().trim();
		String sql = "SELECT * FROM tbl_TaiKhoan WHERE maNhanVien='" + userName + "' AND matKhau='" + passWord + "'";
		try {
			GD_DangNhap frame_Login = new GD_DangNhap();
			ResultSet rs = ConnectDB.executeQuery(sql);
			while (rs.next()) {
				frame_Login.setVisible(false);
				setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
				frame_Login.dispose();
				dispose();
				setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
				return true;
			}
		} catch (HeadlessException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, "Sai Tài Khoản Hoặc Mật Khẩu, Vui Lòng Thử Lại!");
		return false;

	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(GD_DangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(GD_DangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(GD_DangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(GD_DangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new GD_DangNhap().setVisible(true);
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private QLLD_Application gdChinh;
	private javax.swing.JLabel LogoHNV;
	private javax.swing.JButton btn_DangNhap;
	private javax.swing.JButton btn_Thoat;
	private javax.swing.JLabel lbl_LogoLogin;
	private javax.swing.JLabel lbl_MatKhau;
	private javax.swing.JLabel lbl_TenTK;
	private javax.swing.JPanel pn_LoginLeft;
	private javax.swing.JPanel pn_LoginRight;
	private javax.swing.JPasswordField txt_MatKhau;
	private javax.swing.JTextField txt_TaiKhoan;
	// End of variables declaration//GEN-END:variables
}
