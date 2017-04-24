
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowFocusListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.sql.*;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import History.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

public class Login extends JFrame implements ActionListener, Runnable {

	public static String name1 = "";
	public static String name = "";
	public static String name2 = "";
	public static String name3 = "";
	public static String searchtag = "";
	public static Thread T = null;
	JLabel btime;
	public static String timeString = "";

	int hours = 0, minutes = 0, seconds = 0;

	public static Connection Conect() {

		try {
			Class.forName("org.firebirdsql.jdbc.FBDriver");
			Connection con = DriverManager.getConnection("jdbc:firebirdsql:localhost/3050:C:\\DATA\\CSLAB.FDB",
					"sysdba", "masterkey");
			return con;

		} catch (Exception e) {
			System.out.println(e);
		}
		return null;

	}

	public Login() {

		Container pan = getContentPane();
		this.setLayout(null);
		JLabel l12 = new JLabel();
		JLabel l = new JLabel("R.M.K College Of Engineering And Technology");
		JLabel l1 = new JLabel("Puduvoyal");
		JLabel l2 = new JLabel("Laboratory Resource Management System");
		JLabel l3 = new JLabel("Admin Login");
		JLabel l4 = new JLabel("User Name");
		JLabel l5 = new JLabel("Password");
		JTextField t = new JTextField(10);
		JPasswordField t1 = new JPasswordField(10);
		JButton b = new JButton("Login");
		JButton dev = new JButton("Developer");
		JLabel loading = new JLabel();

		T = new Thread(this);
		T.start();
		// Toolkit tool=Toolkit.getDefaultToolkit();
		// img = tool.getImage("C:\\Users\\raj kumar\\Gallery\\Capture23.PNG");
		l.setFont(new Font("Rock Well", Font.PLAIN, 40));
		l1.setFont(new Font("Rock Well", Font.PLAIN, 40));
		l2.setFont(new Font("Rock Well", Font.PLAIN, 40));
		l3.setFont(new Font("Rock Well", Font.PLAIN, 20));
		l4.setFont(new Font("Rock Well", Font.PLAIN, 20));
		l5.setFont(new Font("Rock Well", Font.PLAIN, 20));
		b.setFont(new Font("Rock Well", Font.PLAIN, 15));

		dev.setFont(new Font("Rock Well", Font.PLAIN, 15));
		l.setForeground(Color.blue);

		l1.setForeground(Color.blue);
		l2.setForeground(Color.orange);
		l3.setForeground(Color.black);
		l4.setForeground(Color.black);
		l5.setForeground(Color.black);
		b.setForeground(Color.black);

		dev.setForeground(Color.black);
		dev.setBackground(Color.orange);
		l.setBounds(250, 20, 1500, 100);
		l1.setBounds(550, 70, 1500, 100);
		l2.setBounds(300, 130, 1500, 100);
		l3.setBounds(600, 250, 200, 80);
		l4.setBounds(400, 350, 100, 40);
		l5.setBounds(400, 450, 100, 40);
		t.setBounds(600, 350, 150, 40);
		t1.setBounds(600, 450, 150, 40);
		b.setBounds(580, 550, 100, 30);
		dev.setBounds(1100, 600, 100, 30);

		btime = new JLabel();
		btime.setForeground(Color.blue);
		btime.setBounds(1170, 20, 200, 50);
		btime.setBackground(Color.white);
		btime.setFont(new Font("Rock Well", Font.PLAIN, 30));
		// btime.setText(Login.timeString);
		// pan.add(new JLabel(img));

		pan.add(btime);
		pan.add(l);
		pan.add(l1);
		pan.add(l2);
		pan.add(l3);
		pan.add(dev);
		pan.add(l4);
		pan.add(l5);
		pan.add(t);
		pan.add(t1);
		pan.add(b);
		pan.add(loading);
		setVisible(true);
		setSize(1400, 1000);

		dev.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Desktop d = Desktop.getDesktop();
				try {
					d.browse(new URI("https://drive.google.com/open?id=0Bxul3RF_yDdcQmpqaFpRSmNJeDQ"));
				} catch (Exception url) {
					JOptionPane.showMessageDialog(null, "Unable to connect");
				}
			}
		});

		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String user_name = t.getText();
				String str = "rmkcet";
				/*
				 * String path="C:\\Users\\raj kumar\\Gallery\\Load.gif";
				 * loading.setIcon(new ImageIcon(path)); loading.setBounds(400,
				 * 200, 350, 300);
				 */
				String passwrd = new String(t1.getPassword());
				String pass = new String(passwrd);
				if (user_name.equals(str) && pass.equalsIgnoreCase(str)) {

					// JOptionPane.showMessageDialog(null, "Logined
					// Successfully");
					try {

						TimeUnit.SECONDS.sleep(2);
						String path = "C:\\Users\\raj kumar\\Gallery\\Load.gif";
						loading.setIcon(new ImageIcon(path));
						loading.setBounds(400, 150, 350, 300);
						loading.setVisible(true);

					} catch (Exception e1) {
						e1.printStackTrace();
					}
					Panel2 p2 = new Panel2();

				} else {
					JOptionPane.showMessageDialog(null, "Invalid Data");
					t.setText("");
					t1.setText("");
				}
			}
		});

	}

	public void run() {
		try {
			while (true) {

				Calendar cal = Calendar.getInstance();
				hours = cal.get(Calendar.HOUR_OF_DAY);
				if (hours > 12)
					hours -= 12;
				minutes = cal.get(Calendar.MINUTE);
				seconds = cal.get(Calendar.SECOND);

				SimpleDateFormat formatter = new SimpleDateFormat("hh:mm:ss");
				Date date = cal.getTime();
				timeString = formatter.format(date);
				btime.setText(timeString);

				T.sleep(1000); // interval given in milliseconds
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/*
	 * public void paint(Graphics g){ g.drawImage(img,10,20,null); }
	 */
	public static void main(String args[]) {
		
		Login L = new Login();
		

	}

	public class Panel2 extends JFrame {
		Panel2() {
			Container pan1 = getContentPane();
			JOptionPane.showMessageDialog(null, "Login Success");

			this.setLayout(null);
			JLabel lp1 = new JLabel("R.M.K College Of Engineering And Technology");
			JLabel lp2 = new JLabel("Computer Science Laboratory");
			JLabel lp3 = new JLabel("*****************************************");
			JLabel lp4 = new JLabel("Notepad");
			JTextField tp = new JTextField(500);
			ImageIcon image = new ImageIcon("C:\\Users\\raj kumar\\Gallery\\Data.PNG");
			JButton bp = new JButton("New Device");
			JButton bp1 = new JButton("Device Service");
			JButton bp2 = new JButton("Damaged Devices");
			JButton bp3 = new JButton("Working Devices");
			JButton bp4 = new JButton("Invoice");
			JButton bp5 = new JButton("Save");
			JButton bp6 = new JButton("Serviced Devices");
			JButton bp7 = new JButton("List Damaged Devices");
			JButton bp8 = new JButton("Devices History");

			JButton search = new JButton();
			search.setIcon(image);
			JTextField tp22 = new JTextField("Search_By_ID");
			lp1.setFont(new Font("Rock Well", Font.HANGING_BASELINE, 40));
			lp2.setFont(new Font("Rock Well", Font.HANGING_BASELINE, 40));
			lp3.setFont(new Font("Rock Well", Font.PLAIN, 40));
			bp.setFont(new Font("Rock Well", Font.PLAIN, 15));
			bp1.setFont(new Font("Rock Well", Font.PLAIN, 15));
			bp2.setFont(new Font("Rock Well", Font.PLAIN, 15));
			bp3.setFont(new Font("Rock Well", Font.PLAIN, 15));
			bp4.setFont(new Font("Rock Well", Font.PLAIN, 15));
			bp5.setFont(new Font("Rock Well", Font.PLAIN, 15));
			bp6.setFont(new Font("Rock Well", Font.PLAIN, 15));
			bp7.setFont(new Font("Rock Well", Font.PLAIN, 15));
			bp8.setFont(new Font("Rock Well", Font.PLAIN, 15));
			tp.setFont(new Font("Rock Well", Font.PLAIN, 20));
			lp4.setFont(new Font("Rock Well", Font.PLAIN, 20));
			lp1.setForeground(Color.blue);
			lp2.setForeground(Color.blue);
			lp3.setForeground(Color.blue);
			lp4.setForeground(Color.black);
			tp22.setBounds(280, 200, 800, 30);
			search.setBounds(1100, 200, 80, 30);
			lp1.setBounds(250, 20, 1500, 100);
			lp2.setBounds(350, 70, 1500, 100);
			lp3.setBounds(290, 130, 1500, 100);
			lp4.setBounds(600, 270, 100, 30);
			tp.setBounds(600, 300, 200, 100);
			bp.setBounds(300, 270, 200, 30);
			bp1.setBounds(300, 370, 200, 30);
			bp2.setBounds(300, 470, 200, 30);
			bp3.setBounds(300, 570, 200, 30);
			bp4.setBounds(600, 550, 200, 30);
			bp5.setBounds(600, 450, 200, 30);
			bp6.setBounds(900, 270, 200, 30);
			bp7.setBounds(900, 370, 200, 30);
			bp8.setBounds(900, 470, 200, 30);
			pan1.add(lp4);
			pan1.add(lp1);
			pan1.add(lp2);
			pan1.add(lp3);
			pan1.add(bp);
			pan1.add(bp1);
			pan1.add(bp2);
			pan1.add(bp3);
			pan1.add(tp);
			pan1.add(bp4);
			pan1.add(bp5);
			pan1.add(bp6);
			pan1.add(bp7);
			pan1.add(bp8);
			pan1.add(search);
			pan1.add(tp22);
			tp22.addFocusListener(new FocusListener() {
				public void focusGained(FocusEvent e) {
					tp22.setText("");
				}

				@Override
				public void focusLost(FocusEvent e) {
					// TODO Auto-generated method stub

				}
			});

			setVisible(true);
			setSize(1400, 1000);
			bp4.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					PanelInvoice invoice = new PanelInvoice();

				}
			});
			bp5.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String path = "";
					String str = "";
					String data = tp.getText();
					str = JOptionPane.showInputDialog("File Name");
					path = "C:\\Users\\raj kumar\\pdf\\" + str + ".txt";
					boolean flag = true;
					try {
						File f = new File(path);
						f.getParentFile().mkdirs();
						f.createNewFile();
						try (BufferedWriter b = new BufferedWriter(new FileWriter(path))) {
							b.write(data);
						} catch (Exception writer) {
							JOptionPane.showMessageDialog(null, "Sorry Problem Occured Contact Admin!");
						}

						if (flag) {

							JOptionPane.showMessageDialog(null,
									"Successfully added to C:\\Users\\raj kumar\\pdf\\" + str);
							tp.setText(" ");
						}
					} catch (Exception file) {
						JOptionPane.showMessageDialog(null, "Problem In Writing Data Contact Admin");
					}

				}
			});
			bp.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					Newpanel1 N = new Newpanel1();

				}
			});
			bp1.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					Newpanel2 N1 = new Newpanel2();

				}
			});
			bp2.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					panel4 N2 = new panel4();

				}
			});
			bp6.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					panel5 N3 = new panel5();

				}
			});
			bp7.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					Newpanel7 p7 = new Newpanel7();

				}
			});
			bp3.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					panel6 N3 = new panel6();

				}
			});
			search.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					searchtag = tp22.getText();
					Newpanel8 pan8 = new Newpanel8();

				}
			});
			bp8.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					HistoryPanel h = new HistoryPanel();
					// h.HistoryDb();

				}
			});

		}

	}

	class Newpanel1 extends JFrame {
		Newpanel1() {

			this.setLayout(null);
			Container pan2 = getContentPane();

			String[] ch2 = { "Monitor", "CPU", "KeyBoard", "Mouse", "Projector", "Junction Box", "Battery(UPS)",
					"Wires/Cabels", "Speakers" };
			JComboBox<String> ch3 = new JComboBox<String>(ch2);
			pan2.add(ch3);

			JLabel np = new JLabel("New Device Details");
			JLabel np1 = new JLabel("-----------------------------------------------------");
			JLabel np2 = new JLabel("Vendor Name");
			JLabel np3 = new JLabel("Device");
			JLabel np4 = new JLabel("Invoice Number");
			JLabel np5 = new JLabel("Date Of Purchase");
			JLabel np6 = new JLabel("Device Unique ID");
			JLabel np7 = new JLabel("Device Cost");
			JLabel np8 = new JLabel("Note* : Please CHECK the details  it cant be UNDONE or MODIFIED later");
			JTextField tp = new JTextField(50);
			JTextField tp1 = new JTextField(5);
			JTextField tp2 = new JTextField("DD/MM/YYYY");
			JTextField tp3 = new JTextField(20);
			JTextField tp4 = new JTextField(20);
			JButton bn1 = new JButton("Save");
			JButton bn2 = new JButton("Back");
			JButton bn3 = new JButton("Reset");
			np.setFont(new Font("Rock Well", Font.PLAIN, 40));
			np1.setFont(new Font("Rock Well", Font.PLAIN, 40));
			np2.setFont(new Font("Rock Well", Font.PLAIN, 20));
			np3.setFont(new Font("Rock Well", Font.PLAIN, 20));
			np4.setFont(new Font("Rock Well", Font.PLAIN, 20));
			np5.setFont(new Font("Rock Well", Font.PLAIN, 20));
			np6.setFont(new Font("Rock Well", Font.PLAIN, 20));
			np7.setFont(new Font("Rock Well", Font.PLAIN, 20));
			np8.setFont(new Font("Rock Well", Font.ITALIC, 20));
			bn1.setFont(new Font("Rock Well", Font.PLAIN, 15));
			bn2.setFont(new Font("Rock Well", Font.PLAIN, 15));
			bn3.setFont(new Font("Rock Well", Font.PLAIN, 15));
			bn1.setBounds(500, 500, 200, 30);
			bn2.setBounds(300, 500, 150, 30);
			bn3.setBounds(750, 500, 150, 30);

			np.setBounds(5, 40, 1500, 70);
			np1.setBounds(5, 80, 1500, 70);
			np2.setBounds(10, 130, 200, 30);
			tp.setBounds(250, 130, 400, 30);
			np3.setBounds(10, 190, 200, 30);
			np4.setBounds(10, 250, 300, 30);
			np5.setBounds(10, 310, 200, 30);
			np6.setBounds(10, 370, 200, 30);
			np7.setBounds(10, 430, 200, 30);
			np8.setBounds(100, 650, 700, 30);
			tp1.setBounds(250, 250, 50, 30);
			tp2.setBounds(250, 310, 100, 30);
			tp3.setBounds(250, 370, 100, 30);
			tp4.setBounds(250, 430, 100, 30);
			ch3.setBounds(250, 190, 260, 30);
			np.setForeground(Color.orange);
			np1.setForeground(Color.MAGENTA);
			np2.setForeground(Color.black);
			np4.setForeground(Color.black);
			np5.setForeground(Color.black);
			np6.setForeground(Color.black);
			np7.setForeground(Color.black);
			bn1.setForeground(Color.black);
			np8.setForeground(Color.red);
			pan2.add(np);
			pan2.add(np1);
			pan2.add(np2);
			pan2.add(tp);
			pan2.add(np3);
			pan2.add(bn3);
			pan2.add(bn2);
			pan2.add(np4);
			pan2.add(tp1);
			pan2.add(np5);
			pan2.add(tp2);
			pan2.add(np6);
			pan2.add(tp3);
			pan2.add(np7);
			pan2.add(np8);
			pan2.add(tp4);
			pan2.add(bn1);

			tp2.addFocusListener(new FocusListener() {
				public void focusGained(FocusEvent e) {
					tp2.setText("");
				}

				@Override
				public void focusLost(FocusEvent e) {
					// TODO Auto-generated method stub

				}
			});
			ch3.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					name1 = (String) ch3.getSelectedItem();

				}
			});
			bn3.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					tp.setText("");
					tp1.setText("");
					tp2.setText("");
					tp3.setText("");
					tp4.setText("");

				}
			});
			bn2.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub

					Panel2 backaccess = new Panel2();

				}
			});

			bn1.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					int flag = JOptionPane.showConfirmDialog(null, "Make Sure Details are Correct,Cannot be Undone");

					if (flag == 0) {
						int p1 = 1, p2 = 1, p3 = 1, p4 = 1, j = 0, p5 = 1;
						int uniqid;
						Statement stm = null;

						ResultSet res;
						Connection con = Login.Conect();

						String vendor = tp.getText();
						String nam = Login.name1;
						String invoice = tp1.getText();
						String dop = tp2.getText();
						String temp = "1";
						String uni = tp3.getText();
						String cost = tp4.getText();
						int len = invoice.length();
						int u = Integer.parseInt(tp3.getText());
						char inv[] = invoice.toCharArray();
						for (j = 0; j < len; j++) {
							if (!Character.isDigit(inv[j])) {
								JOptionPane.showMessageDialog(null, "Invalid Invoice Number");
								tp1.setText("");
								p1 = 0;
								break;
							}
						}
						if (p1 != 0) {
							if (!dop.matches("([0-3]{1})([0-9]{1})/([0-1]{1})([0-9]{1})/([0-9]{4})")) {
								JOptionPane.showMessageDialog(null, "Invalid Date");
								tp2.setText("");
								p2 = 0;
							}
						}
						if (p2 != 0 && p1 != 0) {
							try {
								uniqid = Integer.parseInt(tp3.getText());
							} catch (Exception integ) {
								JOptionPane.showMessageDialog(null, "Invalid ID");
								tp3.setText("");
								p3 = 0;
							}
						}

						if (p3 != 0 && p2 != 0 && p1 != 0) {
							try {
								int cos = Integer.parseInt(cost);
							} catch (Exception integ2) {
								JOptionPane.showMessageDialog(null, "Invalid Cost");
								tp4.setText("");
								p4 = 0;
							}
						}
						try {
							stm = con.createStatement();
							res = stm.executeQuery("SELECT *FROM newdevice");
							while (res.next()) {
								String uniq = res.getString("uniqueid");
								if (uni.equals(uniq) && nam.equals("device")) {

									JOptionPane.showMessageDialog(null, "ID Already Exists");
									p5 = 0;
									break;
								}

							}
						} catch (Exception duplicate) {
							JOptionPane.showMessageDialog(null, "Error In Database");
						}

						if (p1 == 1 && p2 == 1 && p3 == 1 && p4 == 1 && p5 == 1)
							try {
								if (con != null) {
									stm = con.createStatement();
									// String query= uni +',' + nam +','+ temp +
									// ',' + vendor + ',' + invoice +','+ dop
									// +',' + cost ;
									// res=stm.executeQuery("INSERT INTO
									// newdevice " + "(uniqueid , device ,
									// device_status , vendor_name , invoice ,
									// dop , cost)" + "VALUES(" + query +")");
									try (PreparedStatement pstmt = con.prepareStatement(
											"INSERT INTO newdevice (uniqueid, device, device_status, vendor_name, invoice, dop, cost) VALUES(?, ?, ?, ?, ?, ?, ?)")) {
										pstmt.setInt(1, u);
										pstmt.setString(2, nam);
										pstmt.setString(3, temp);
										pstmt.setString(4, vendor);
										pstmt.setString(5, invoice);
										pstmt.setString(6, dop);
										pstmt.setString(7, cost);
										pstmt.executeUpdate();
										res = stm.executeQuery("SELECT *FROM newdevice");
										while (res.next()) {
											System.out.println(res.getString("uniqueid") + "   "
													+ res.getString("device") + "  " + res.getString("device_status"));
										}
									} catch (Exception db2) {
										JOptionPane.showMessageDialog(null, "Problem in inserting data");
									}
								}

								JOptionPane.showMessageDialog(null, "Successfully Saved");
								tp.setText("");
								tp1.setText("");
								tp2.setText("");
								tp3.setText("");
								tp4.setText("");
							} catch (Exception db) {
								System.out.println(db);
								JOptionPane.showMessageDialog(null, "Database Error");
							}

					} else {
						JOptionPane.showMessageDialog(null, "Recheck the details ");
					}
				}
			});

			// System.out.println(name);
			setVisible(true);
			setSize(1400, 1000);

		}

		@Override
		public synchronized void addWindowFocusListener(WindowFocusListener l) {
			// TODO Auto-generated method stub
			super.addWindowFocusListener(l);
		}
	}

	class Newpanel2 extends JFrame {
		Newpanel2() {
			Container pan3 = getContentPane();
			this.setLayout(null);
			String[] ch3 = { "Monitor", "CPU", "KeyBoard", "Mouse", "Projector", "Junction Box", "Battery(UPS)",
					"Wires/Cabels", "Speakers" };
			JComboBox<String> ch4 = new JComboBox<String>(ch3);
			pan3.add(ch4);

			String name;
			JLabel npl = new JLabel("Device Service Details");
			JLabel npl1 = new JLabel("-----------------------------------------------------");
			JLabel npl2 = new JLabel("Company Name");
			JLabel npl3 = new JLabel("Location");
			JLabel npl7 = new JLabel("Device");
			JLabel npl4 = new JLabel("Date");
			JLabel npl5 = new JLabel("Device Unique ID");
			JLabel npl6 = new JLabel("Problem in Device");
			JLabel npl8 = new JLabel("Note:Monitors,Keyboard,Mouse(Serial No)");
			JTextField tpl = new JTextField(20);
			JTextField tpl1 = new JTextField(15);
			JTextField tpl2 = new JTextField("DD/MM/YYYY");
			JTextField tpl3 = new JTextField(10);
			JTextField tpl4 = new JTextField(200);
			JButton bp3 = new JButton("Save");
			npl.setFont(new Font("Rock Well", Font.PLAIN, 40));
			npl1.setFont(new Font("Rock Well", Font.PLAIN, 40));
			npl2.setFont(new Font("Rock Well", Font.PLAIN, 20));
			npl3.setFont(new Font("Rock Well", Font.PLAIN, 20));
			npl4.setFont(new Font("Rock Well", Font.PLAIN, 20));
			npl5.setFont(new Font("Rock Well", Font.PLAIN, 20));
			npl6.setFont(new Font("Rock Well", Font.PLAIN, 20));
			npl7.setFont(new Font("Rock Well", Font.PLAIN, 20));
			bp3.setFont(new Font("Rock Well", Font.PLAIN, 15));
			npl8.setFont(new Font("Rock Well", Font.ITALIC, 10));

			npl.setBounds(5, 40, 1500, 70);
			npl1.setBounds(5, 80, 1500, 70);
			npl2.setBounds(10, 130, 200, 30);
			tpl.setBounds(250, 130, 400, 30);
			npl3.setBounds(10, 190, 200, 30);
			tpl1.setBounds(250, 190, 260, 30);
			npl4.setBounds(10, 250, 300, 30);
			npl7.setBounds(10, 250, 300, 30);
			ch4.setBounds(250, 250, 300, 30);
			npl5.setBounds(10, 310, 200, 30);
			tpl3.setBounds(250, 310, 100, 30);
			npl4.setBounds(10, 370, 200, 30);
			tpl2.setBounds(250, 370, 100, 30);
			npl6.setBounds(10, 430, 200, 30);
			tpl4.setBounds(250, 430, 300, 100);
			npl8.setBounds(360, 310, 700, 20);
			bp3.setBounds(500, 600, 200, 30);
			npl.setForeground(Color.orange);
			npl1.setForeground(Color.MAGENTA);
			npl2.setForeground(Color.black);
			npl4.setForeground(Color.black);
			npl5.setForeground(Color.black);
			npl6.setForeground(Color.black);
			npl7.setForeground(Color.black);
			bp3.setForeground(Color.black);
			npl8.setForeground(Color.black);

			pan3.add(npl8);
			pan3.add(npl);
			pan3.add(npl1);
			pan3.add(npl2);
			pan3.add(npl3);
			pan3.add(npl4);
			pan3.add(npl5);
			pan3.add(npl6);
			pan3.add(npl7);
			pan3.add(tpl);
			pan3.add(tpl1);

			pan3.add(tpl2);
			pan3.add(tpl3);
			pan3.add(tpl4);
			pan3.add(bp3);

			tpl2.addFocusListener(new FocusListener() {
				public void focusGained(FocusEvent e) {
					tpl2.setText("");
				}

				@Override
				public void focusLost(FocusEvent e) {
					// TODO Auto-generated method stub

				}
			});

			ch4.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					Login.name = (String) ch4.getSelectedItem();

				}
			});
			bp3.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					int p1 = 1, p2 = 1;
					boolean pass = false;
					int flag = JOptionPane.showConfirmDialog(null, "Make Sure Details are Correct,Cannot be Undone");
					if (flag == 0) {
						Connection con = Login.Conect();
						Statement stm = null;
						int unid = Integer.parseInt(tpl3.getText());
						String device = Login.name;
						String device_stat = "0";
						String comp = tpl.getText();
						String loc = tpl1.getText();
						String dos = tpl2.getText();
						String feedbk = tpl4.getText();
						String dates[] = dos.split("/");
						try {
							stm = con.createStatement();
							ResultSet resdup = stm.executeQuery("SELECT *FROM newdevice");
							while (resdup.next()) {
								if (resdup.getString("uniqueid").equals(tpl3.getText())
										&& resdup.getString("device").equals(device)) {
									pass = true;
									break;
								}
							}
						} catch (Exception er) {
							JOptionPane.showMessageDialog(null, "Error in Database Connection");
						}
						if (pass) {
							try {
								int uni = Integer.parseInt(tpl3.getText());
							} catch (Exception integ) {
								p1 = 0;
								JOptionPane.showMessageDialog(null, "Invalid Unique ID");
							} // "([0-9]{2})/([0-9]{2})/([0-9]{4})")
							if (p1 != 0)
								if (!dos.matches("([0-3]{1})([0-9]{1})/([0-1]{1})([0-9]{1})/([0-9]{4})")) {
									p2 = 0;
									JOptionPane.showMessageDialog(null, "Invalid Date");

								}

							if (p1 != 0 && p2 != 0) {
								try (PreparedStatement p = con.prepareStatement(
										"INSERT INTO servicedevice(uniqid ,device ,device_status ,company_name ,location ,dos ,problem)VALUES(?,?,?,?,?,?,?)")) {
									p.setInt(1, unid);
									p.setString(2, device);
									p.setString(3, device_stat);
									p.setString(4, comp);
									p.setString(5, loc);
									p.setString(6, dos);
									p.setString(7, feedbk);

									String upd = "UPDATE newdevice SET device_status= ?" + "WHERE uniqueid= ?" + "AND "
											+ "device= ?";
									try (PreparedStatement ptm = con.prepareStatement(upd)) {
										String stat = "0";

										ptm.setString(1, stat);
										ptm.setInt(2, unid);
										ptm.setString(3, device);
										ptm.executeUpdate();
										JOptionPane.showMessageDialog(null, "Updated Successfully");
									} catch (Exception db4) {
										System.out.println(db4.getMessage());
										JOptionPane.showMessageDialog(null, "Data Not Available");
									}
								} catch (Exception db3) {
									JOptionPane.showMessageDialog(null, "Unable to Insert Data");
								}

								try (PreparedStatement ps = con
										.prepareStatement("INSERT INTO history(mn,yr)VALUES(?,?)")) {
									ps.setString(1, dates[1]);
									ps.setString(2, dates[2]);
									ps.executeUpdate();
								} catch (Exception hist) {
									hist.printStackTrace();
								}
							}

						} else
							JOptionPane.showMessageDialog(null, "Device and uniqueid Does'nt Match");
					} else {
						JOptionPane.showMessageDialog(null, "Recheck the details ");
					}
				}
			});

			setVisible(true);
			setSize(1400, 1000);
		}
	}

	class panel4 extends JFrame {
		panel4() {
			Container pan4 = getContentPane();
			this.setLayout(null);
			String[] ch4 = { "Monitor", "CPU", "KeyBoard", "Mouse", "Projector", "Junction Box", "Battery(UPS)",
					"Wires/Cabels", "Speakers" };
			JComboBox<String> ch5 = new JComboBox<String>(ch4);
			pan4.add(ch5);

			JLabel np4 = new JLabel("Damaged Devices");
			JLabel np41 = new JLabel("-----------------------------------------------------");
			JLabel np42 = new JLabel("Device");
			JLabel np45 = new JLabel("Device Unique ID");
			JLabel np43 = new JLabel("Fault Due to");

			JTextField tp4 = new JTextField(20);
			JTextField tp41 = new JTextField(200);
			JButton bp4 = new JButton("Save");
			np4.setFont(new Font("Rock Well", Font.PLAIN, 40));
			np41.setFont(new Font("Rock Well", Font.PLAIN, 40));
			np42.setFont(new Font("Rock Well", Font.PLAIN, 20));
			np45.setFont(new Font("Rock Well", Font.PLAIN, 20));
			np43.setFont(new Font("Rock Well", Font.PLAIN, 20));

			np4.setForeground(Color.orange);
			np41.setForeground(Color.MAGENTA);
			np42.setForeground(Color.black);
			np43.setForeground(Color.black);
			np45.setForeground(Color.black);

			np4.setBounds(5, 40, 1500, 70);
			np41.setBounds(5, 80, 1500, 70);
			np42.setBounds(10, 200, 200, 30);
			np45.setBounds(10, 270, 200, 30);
			np43.setBounds(10, 340, 200, 30);
			ch5.setBounds(240, 200, 250, 30);

			tp4.setBounds(240, 270, 250, 30);
			tp41.setBounds(240, 340, 250, 90);
			bp4.setBounds(400, 500, 200, 30);
			pan4.add(np4);
			pan4.add(np41);
			pan4.add(np42);
			pan4.add(np45);
			pan4.add(np43);
			pan4.add(ch5);
			pan4.add(tp4);
			pan4.add(tp41);
			pan4.add(bp4);
			setSize(1400, 1000);
			setVisible(true);

			ch5.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					Login.name2 = (String) ch5.getSelectedItem();

				}
			});

			bp4.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {

					// TODO Auto-generated method stub
					int flag = JOptionPane.showConfirmDialog(null, "Make Sure Details are Correct,Cannot be Undone");
					if (flag == 0) {
						String unique = tp4.getText();
						String fault = tp41.getText();
						String device = Login.name2;
						boolean pass1 = false, pass = false;
						int uni = Integer.parseInt(unique);
						Statement stm = null;
						Connection con = Login.Conect();
						try {

							stm = con.createStatement();
							ResultSet res = stm.executeQuery("SELECT *FROM newdevice");
							while (res.next()) {
								if (res.getString("uniqueid").equals(Integer.toString(uni))
										&& res.getString("device").equals(device)) {
									pass = true;
									break;
								}
							}
						} catch (Exception Result) {
							Result.printStackTrace();
						}
						try {
							int temp = Integer.parseInt(unique);
							pass1 = true;
						} catch (Exception temp1) {

							JOptionPane.showMessageDialog(null, "Invalid Unique Id");
						}

						if (pass == true && pass1 == true) {
							try (PreparedStatement prp = con.prepareStatement(
									"INSERT INTO damagedevice(uniqueid,device,problem)VALUES (?,?,?)")) {
								prp.setInt(1, uni);
								prp.setString(2, device);
								prp.setString(3, fault);
								prp.executeUpdate();
								String upd = "UPDATE newdevice SET device_status= ?" + "WHERE uniqueid= ?" + "AND "
										+ "device= ?";
								try (PreparedStatement ptm = con.prepareStatement(upd)) {
									String stat = "0";

									ptm.setString(1, stat);
									ptm.setInt(2, uni);
									ptm.setString(3, device);
									ptm.executeUpdate();
									JOptionPane.showMessageDialog(null, "Updated Successfully");
								} catch (Exception db5) {

									JOptionPane.showMessageDialog(null, "Unable to Update Record");
								}
								JOptionPane.showMessageDialog(null, "Updated Successfully");
							} catch (Exception db5) {

								JOptionPane.showMessageDialog(null, "Unable to Update Record");
							}

						} else
							JOptionPane.showMessageDialog(null, "Data Not Exist");

					} else {
						JOptionPane.showMessageDialog(null, "Recheck Details");
					}
				}
			});

		}

	}

	class panel5 extends JFrame {
		panel5() {

			Container pan5 = getContentPane();
			this.setLayout(null);
			String[] ch5 = { "Monitor", "CPU", "KeyBoard", "Mouse", "Projector", "Junction Box", "Battery(UPS)",
					"Wires/Cabels", "Speakers" };
			JComboBox<String> ch6 = new JComboBox<String>(ch5);
			pan5.add(ch6);
			Connection con = Login.Conect();

			JLabel np5 = new JLabel("Serviced Devices");
			JLabel np51 = new JLabel("-----------------------------------------------------");
			JLabel np52 = new JLabel("Device *");
			JLabel np53 = new JLabel("Device Unique ID *");
			JTextField tp5 = new JTextField(20);
			JButton bp5 = new JButton("Save");

			np5.setFont(new Font("Rock Well", Font.PLAIN, 40));
			np51.setFont(new Font("Rock Well", Font.PLAIN, 40));
			np52.setFont(new Font("Rock Well", Font.PLAIN, 20));
			np53.setFont(new Font("Rock Well", Font.PLAIN, 20));

			np5.setForeground(Color.orange);
			np51.setForeground(Color.MAGENTA);
			np52.setForeground(Color.black);
			np53.setForeground(Color.black);

			np5.setBounds(5, 40, 1500, 70);
			np51.setBounds(5, 80, 1500, 70);
			np52.setBounds(10, 200, 200, 30);
			np53.setBounds(10, 270, 200, 30);

			ch6.setBounds(240, 200, 250, 30);

			tp5.setBounds(240, 270, 250, 30);

			bp5.setBounds(400, 500, 200, 30);
			pan5.add(np5);
			pan5.add(np51);
			pan5.add(np52);
			pan5.add(np53);
			pan5.add(tp5);
			pan5.add(bp5);
			setVisible(true);
			setSize(1400, 1000);
			ch6.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					Login.name3 = (String) ch6.getSelectedItem();

				}
			});

			bp5.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					int unique = Integer.parseInt(tp5.getText());
					boolean pass = false;

					try {
						Statement stm = null;
						stm = con.createStatement();
						ResultSet res = stm.executeQuery("SELECT *FROM newdevice");
						while (res.next()) {
							if (res.getString("uniqueid").equals(tp5.getText())
									&& res.getString("device").equals(name3)) {
								pass = true;
								break;
							}
						}
					} catch (Exception check) {
						JOptionPane.showMessageDialog(null, "Erron In Database");
					}
					if (pass == true) {
						try (PreparedStatement prp = con.prepareStatement("UPDATE newdevice SET device_status= ?"
								+ " WHERE device= ?" + " AND" + " uniqueid= ?")) {

							prp.setString(1, "1");
							prp.setString(2, Login.name3);
							prp.setInt(3, unique);
							prp.executeUpdate();
							JOptionPane.showMessageDialog(null, "Updated Successfully");

						} catch (Exception db) {
							JOptionPane.showMessageDialog(null, "Unable to Update Data");
						}

					} else
						JOptionPane.showMessageDialog(null, "No Data Found");
				}
			});

		}
	}

	class panel6 extends JFrame {
		JTable tab;

		panel6() {

			JFrame pan6;
			pan6 = new JFrame();
			pan6.setLayout(new FlowLayout());
			JButton print = new JButton("Print");
			String column[] = { "System_Number", "Device_Name", "Device_Status" };

			try {
				int l = -1, k = 0;
				Connection conn = Login.Conect();
				Statement stm = conn.createStatement();
				ResultSet res1 = stm.executeQuery("SELECT *FROM" + " newdevice");

				while (res1.next()) {
					k++;
				}

				String rows[][] = new String[k][1000];
				ResultSet res = stm.executeQuery("SELECT *FROM" + " newdevice");
				while (res.next()) {
					rows[++l][++k] = res.getString("uniqueid");
					rows[l][++k] = res.getString("device");
					String temp = res.getString("device_status");
					if (temp.equals("1")) {
						rows[l][++k] = "Working";
					} else
						rows[l][++k] = "Not Working";
					/*
					 * d[l][++k]=res.getString("vendor_name");
					 * 
					 * d[l][++k]=res.getString("invoice");
					 * d[l][++k]=res.getString("dop");
					 * d[l][++k]=res.getString("cost");
					 */
					k = -1;
				}
				tab = new JTable(rows, column);

				JScrollPane sp = new JScrollPane(add(new JScrollPane(tab)));
				tab.setPreferredScrollableViewportSize(new Dimension(500, 200));
				tab.setSelectionBackground(Color.GREEN);
				tab.setSelectionForeground(Color.red);
				tab.setForeground(Color.black);
				tab.setBackground(Color.cyan);
				tab.setBounds(30, 40, 1200, 1000);

				print.setBounds(300, 600, 50, 30);

				pan6.add(new JScrollPane(tab));
				pan6.add(sp);
				pan6.add(print);
				pan6.setVisible(true);
				pan6.setSize(600, 300);

			} catch (Exception ee) {
				System.out.println(ee.getMessage());
				JOptionPane.showMessageDialog(null, "Problem in Retrieving Data Contact System Administrator");

			}
			print.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					try {
						MessageFormat message = new MessageFormat("Laboratory Details");
						MessageFormat footer = new MessageFormat("-{0}-");
						tab.print(JTable.PrintMode.FIT_WIDTH, message, footer);
					} catch (Exception prnt) {
						JOptionPane.showMessageDialog(null, "Unable To Print");
					}
				}
			});

		}

	}

	class Newpanel7 extends JFrame {
		JTable tab;

		Newpanel7() {

			JFrame pan7 = new JFrame();
			pan7.setLayout(new FlowLayout());
			JButton print = new JButton("Print");
			print.setBounds(300, 600, 50, 30);
			String columns[] = { "System_Number", "Device_Name", "Problem" };
			try {
				int l = -1, k = 0;
				String query = "SELECT *FROM damagedevice";
				Statement stm = null;
				Connection con = Login.Conect();
				stm = con.createStatement();
				ResultSet res = stm.executeQuery(query);
				while (res.next()) {

					k++;
				}
				String rows[][] = new String[k][50];

				k = 0;
				ResultSet res1 = stm.executeQuery(query);
				while (res1.next()) {
					rows[k][++l] = res1.getString("uniqueid");
					rows[k][++l] = res1.getString("device");
					rows[k][++l] = res1.getString("problem");
					k++;
					l = -1;

				}
				// System.out.println(rows[1][1]);
				tab = new JTable(rows, columns);
				JScrollPane sp = new JScrollPane(add(new JScrollPane(tab)));
				tab.setPreferredScrollableViewportSize(new Dimension(500, 200));
				tab.setSelectionBackground(Color.red);
				tab.setSelectionForeground(Color.yellow);
				tab.setForeground(Color.black);
				tab.setBackground(Color.cyan);
				tab.setBounds(30, 40, 1200, 1000);

				pan7.add(new JScrollPane(tab));
				pan7.add(sp);
				pan7.add(print);
				pan7.setVisible(true);
				pan7.setSize(600, 300);
			} catch (Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Problem in Retrieving Data Contact System Administrator");
			}
			print.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					try {
						MessageFormat message = new MessageFormat("Damaged Details");
						MessageFormat footer = new MessageFormat("-{0}-");
						tab.print(JTable.PrintMode.FIT_WIDTH, message, footer);
					} catch (Exception print) {
						print.printStackTrace();
					}

				}
			});
		}

	}

	class Newpanel8 extends JFrame {
		Newpanel8() {
			String uniq = "", device = "", dev_status = "";
			String result[] = new String[20];
			int k = 0, l = 0, flag = 0;
			Connection con = Login.Conect();
			try {
				Statement stm = con.createStatement();
				ResultSet res = stm.executeQuery("SELECT *FROM newdevice");
				String search = Login.searchtag;
				while (res.next()) {

					if (search.equals(res.getString("uniqueid"))) {
						result[l++] = res.getString("uniqueid");
						result[l++] = res.getString("device");
						if (res.getString("device_status").equals("1")) {
							result[l++] = "Working";
						} else {
							result[l++] = "Not Working";
							flag = 1;
						}
						k++;
					}

				}

				JLabel res1 = new JLabel("<html> System Id= " + result[0] + "<br><br> " + "\n" + "Name= " + result[1]
						+ "<br><br>" + "\n " + "Status=" + result[2] + "<br><br>" + "\n" + "Name= " + result[4]
						+ "<br><br>" + "\n" + "Status=" + result[5] + "<br><br>" + "\n" + "Name= " + result[7]
						+ "<br><br>" + "\n" + "Status=" + result[8] + "<br><br>" + "\n" + "Name= " + result[10]
						+ "<br><br>" + "\n" + "Status=" + result[11] + "</html>");
				res1.setForeground(Color.blue);
				JLabel res3 = new JLabel("Status  Good");
				JLabel res2 = new JLabel("Status  Bad");
				res2.setForeground(Color.red);
				res3.setForeground(Color.green);
				if (flag == 1)
					JOptionPane.showConfirmDialog(null, res2);
				else
					JOptionPane.showConfirmDialog(null, res3);
				if (k >= 1) {
					// JOptionPane.showConfirmDialog(null,res1);
					JOptionPane.showConfirmDialog(null, res1);
				} else
					JOptionPane.showConfirmDialog(null, "Search Not Found");
			} catch (Exception src) {
				JOptionPane.showConfirmDialog(null, "Error Occurred");
			}
		}
	}

	class PanelInvoice extends JFrame {
		public PanelInvoice() {
			Container pan = getContentPane();
			JTable tab;
			String column[] = { "Serial No", "Date", "Invoices" };
			File fold = new File("C:\\Users\\raj kumar\\Gallery");
			File[] filelist = fold.listFiles();
			String FilePath = "", Tempfile = "", Fdate;
			int len = filelist.length, k = 0, l = 0;
			String rows[][] = new String[len][100];
			for (int i = 0; i < len; i++) {
				Tempfile = filelist[i].getName();
				rows[k][l++] = Integer.toString(i + 1);
				rows[k][l + 1] = Tempfile;
				FilePath = "C:\\Users\\raj kumar\\Gallery\\" + Tempfile;
				try {
					Path path = Paths.get(FilePath);
					BasicFileAttributes attr;
					attr = Files.readAttributes(path, BasicFileAttributes.class);
					FileTime date = attr.creationTime();
					DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
					Fdate = df.format(date.toMillis());
					rows[k][l] = Fdate;
					k++;
				} catch (Exception file) {
					JOptionPane.showMessageDialog(null, "SomeThing Went Wrong!!");
					System.out.println(file.getMessage());
				}
				l = 0;
			}
			tab = new JTable(rows, column);

			tab.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			tab.setEnabled(false);
			tab.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					if (e.getClickCount() == 2) {

						int selectedRow = tab.rowAtPoint(e.getPoint());
						String file = rows[selectedRow][2];
						new panelPhoto(selectedRow, file);
					}
				}
			});

			JScrollPane scroll = new JScrollPane(new JScrollPane(tab));
			tab.setPreferredScrollableViewportSize(new Dimension(500, 200));
			tab.setSelectionBackground(Color.GREEN);
			tab.setSelectionForeground(Color.red);
			tab.setForeground(Color.black);
			tab.setBackground(Color.yellow);
			tab.setBounds(30, 40, 1200, 1000);
			pan.add(tab);
			pan.add(new JScrollPane(tab));
			setVisible(true);
			setSize(300, 300);
		}
	}

	class panelPhoto extends JFrame {
		panelPhoto(int count, String file) {
			Container pandup = getContentPane();

			this.setLayout(null);
			setSize(300, 700);
			setVisible(true);

			try {

				String path = "C:\\Users\\raj kumar\\Gallery\\" + file;
				JLabel fileLable = new JLabel();
				fileLable.setBounds(5, 5, 300, 700);
				fileLable.setIcon(new ImageIcon(path));
				pandup.add(fileLable);
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		}
	}

	public class HistoryPanel {
		HistoryPanel() {

			int month[] = { 10, 60, 43, 56, 87, 99, 56, 78, 43, 54, 65, 78 };

			int yr = Calendar.getInstance().get(Calendar.YEAR);
			String monthName[] = { "January", "February", "March", "April", "May", "June", "July", "August",
					"September", "October", "November", "December" };

			try {
				Connection con = Login.Conect();
				Statement stm = con.createStatement();
				ResultSet res = stm.executeQuery("SELECT *FROM history");
				while (res.next()) {
					if (Integer.parseInt(res.getString("yr")) == yr) {
						int month1 = Integer.parseInt(res.getString("mn"));
						month[month1]++;
						System.out.println(month[month1]);
					}
				}

			} catch (Exception History) {
				JOptionPane.showMessageDialog(null, "Sorry Something Went Wrong!");
			}

			DefaultCategoryDataset dataset = new DefaultCategoryDataset();
			dataset.setValue(month[0], monthName[0], "Month");
			dataset.setValue(month[1], monthName[1], "Month");
			dataset.setValue(month[2], monthName[2], "Month");
			dataset.setValue(month[3], monthName[3], "Month");
			dataset.setValue(month[4], monthName[4], "Month");
			dataset.setValue(month[5], monthName[5], "Month");
			dataset.setValue(month[6], monthName[6], "Month");
			dataset.setValue(month[7], monthName[7], "Month");
			dataset.setValue(month[8], monthName[8], "Month");
			dataset.setValue(month[9], monthName[9], "Month");
			dataset.setValue(month[10], monthName[10], "Month");
			dataset.setValue(month[11], monthName[11], "Month");
			JFreeChart chart = ChartFactory.createBarChart("History", "Month", "Damaged", dataset,
					PlotOrientation.VERTICAL, true, false, true);
			CategoryPlot p = chart.getCategoryPlot();
			p.setRangeGridlinePaint(Color.BLUE);
			ChartFrame frame = new ChartFrame("Devices History", chart);
			frame.setVisible(true);
			frame.setSize(400, 400);

		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
