//修改账户信息。
package team.nwsh.nwshospital.AdminSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import team.nwsh.nwshospital.MySQLConnect;

import java.awt.Label;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class AdminSystemAccChange extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminSystemAccChange frame = new AdminSystemAccChange();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AdminSystemAccChange() {
		setTitle("\u8D26\u6237\u4FEE\u6539");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Label label = new Label("\u7528\u6237\u540D\uFF1A");
		label.setBounds(98, 76, 77, 25);
		contentPane.add(label);
		
		Label label_1 = new Label("\u5BC6\u7801\uFF1A");
		label_1.setBounds(112, 113, 52, 25);
		contentPane.add(label_1);
		
		Label label_2 = new Label("\u6240\u5C5E\u79D1\u5BA4\uFF1A");
		label_2.setBounds(80, 149, 77, 25);
		contentPane.add(label_2);
		
		Label label_3 = new Label("\u7528\u6237ID(\u9ED8\u8BA4\u4E0D\u53D8)\uFF1A");
		label_3.setBounds(32, 39, 129, 25);
		contentPane.add(label_3);
		
		textField = new JTextField();
		textField.setBounds(199, 40, 100, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(199, 76, 100, 24);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(199, 114, 100, 24);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(199, 150, 100, 24);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("\u4FDD\u5B58");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String sql="UPDATE ACCOUNTS SET ACC_NAME=('"+textField_1.getText()+"') ,ACC_PASSWORD = ('"+textField_2.getText()+"'),SEC_ID = ('"+textField_3.getText()+"') WHERE ACC_ID =('"+textField.getText()+"')";
				   MySQLConnect con=new MySQLConnect(sql);
				   int key=1;//定义一个中间变量，来判断输入信息的窗口，如果成功 则 保存成功
				   try{
					if(textField.getText().equals("")||textField_1.getText().equals("")||textField_2.getText().equals("")||textField_3.getText().equals("")) 
				   {JOptionPane.showMessageDialog(null, "内容不能为空"); key=0;}	
				   if(key==1) { con.pst.executeUpdate();   JOptionPane.showMessageDialog(null, "保存成功");}
				   }catch(SQLException e1){
					   e1.printStackTrace();
				   }
			}
		});
		btnNewButton.setBounds(337, 174, 81, 27);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u5173\u95ED");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 dispose();
			}
		});
		btnNewButton_1.setBounds(338, 213, 80, 27);
		contentPane.add(btnNewButton_1);
	}

}
