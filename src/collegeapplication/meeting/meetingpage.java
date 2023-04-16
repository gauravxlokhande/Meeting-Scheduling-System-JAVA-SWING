package collegeapplication.meeting;

import java.awt.EventQueue;
import java.sql.*;
import java.text.MessageFormat;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class meetingpage {

	private JFrame frame;
	private JTextField name;
	private JTextField stime;
	private JTextField dur;
	private JTextField date;
	private JTextField parti;
	private JTable table;
	
	
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					meetingpage window = new meetingpage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public meetingpage() {
		initialize();
		Connect();
		MeetingTable();
	}

	
	
	Connection con;
	PreparedStatement pst;
	private JTextField mid;

	public void Connect()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3307/collegedata","root","");
        } catch (ClassNotFoundException ex) {
          
        } catch (SQLException ex) {
          
        }  
    }
	
	
	
	 public void MeetingTable()
	    {
	        try {
	            pst = con.prepareStatement("select * from meetings");
	             ResultSet rs = pst.executeQuery();
	             ResultSetMetaData RSM = rs.getMetaData();
	             int c;
	             c = RSM.getColumnCount();
	             DefaultTableModel DF = (DefaultTableModel)table.getModel();
	             DF.setRowCount(0);
	            
	             while(rs.next())
	             {
	            	   Vector<String> v2 = new Vector<>();
	                   for(int i = 1; i<=c; i++)
	                   {
	                	    v2.add(rs.getString("meeting_id"));
	                        v2.add(rs.getString("meeting_name"));
	                        v2.add(rs.getString("meet_description"));
	                        v2.add(rs.getString("meet_startTime"));
	                        v2.add(rs.getString("meet_duration"));
	                        v2.add(rs.getString("meet_date"));
	                        v2.add(rs.getString("noof_participants"));
	                        v2.add(rs.getString("meet_option"));
	                        
	                   }
	                   DF.addRow(v2);
	                   }
	            
	        } catch (SQLException ex) {
	          
	        }  
	    }
	
	
	
	
	
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(32, 178, 170));
		frame.setBounds(100, 100, 1234, 735);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(10, 86, 511, 530);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("Meeting Name :");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_1_1.setBounds(34, 92, 153, 41);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Meeting Description :");
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_1_2.setBounds(34, 180, 212, 41);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Start Time :");
		lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_1_3.setBounds(31, 251, 133, 33);
		panel.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Duration :");
		lblNewLabel_1_4.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_1_4.setBounds(34, 305, 117, 33);
		panel.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_4_1 = new JLabel("Date :");
		lblNewLabel_1_4_1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_1_4_1.setBounds(34, 364, 75, 41);
		panel.add(lblNewLabel_1_4_1);
		
		JLabel lblNewLabel_1_4_2 = new JLabel("No Of Participants :");
		lblNewLabel_1_4_2.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_1_4_2.setBounds(34, 466, 194, 41);
		panel.add(lblNewLabel_1_4_2);
		
		name = new JTextField();
		name.setColumns(10);
		name.setBounds(276, 99, 212, 33);
		panel.add(name);
		
		stime = new JTextField();
		stime.setColumns(10);
		stime.setBounds(276, 254, 212, 33);
		panel.add(stime);
		
		dur = new JTextField();
		dur.setColumns(10);
		dur.setBounds(276, 308, 212, 33);
		panel.add(dur);
		
		date = new JTextField();
		date.setColumns(10);
		date.setBounds(276, 371, 212, 33);
		panel.add(date);
		
		parti = new JTextField();
		parti.setColumns(10);
		parti.setBounds(276, 472, 212, 33);
		panel.add(parti);
		
		JTextArea descri = new JTextArea();
		descri.setBounds(276, 156, 212, 79);
		panel.add(descri);
		
		JLabel lblNewLabel_1_4_2_1 = new JLabel("Schedule :");
		lblNewLabel_1_4_2_1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_1_4_2_1.setBounds(34, 415, 117, 41);
		panel.add(lblNewLabel_1_4_2_1);
		
		JRadioButton wkly = new JRadioButton("Weekly");
		wkly.setFont(new Font("Times New Roman", Font.BOLD, 15));
		wkly.setBounds(276, 427, 103, 21);
		panel.add(wkly);
		
		JRadioButton mntly = new JRadioButton("Monthly");
		mntly.setFont(new Font("Times New Roman", Font.BOLD, 15));
		mntly.setBounds(385, 427, 103, 21);
		panel.add(mntly);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Meeting ID :");
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_1_1_1.setBounds(34, 31, 153, 41);
		panel.add(lblNewLabel_1_1_1);
		
		mid = new JTextField();
		mid.setColumns(10);
		mid.setBounds(276, 38, 212, 33);
		panel.add(mid);
		
		JLabel lblNewLabel = new JLabel("Shedule All Counselling Meetings");
		lblNewLabel.setBackground(Color.GREEN);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel.setBounds(20, 10, 445, 48);
		frame.getContentPane().add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(526, 86, 684, 530);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Meet_id", "MeetName", "MeetDescription", "Time", "Duration", "Date", "Schedule", "NoOFParticipants"
			}
		));
		
		
		
		// save button
		
		JButton save = new JButton("Save");
		save.addActionListener(new ActionListener() {
			String options;
			public void actionPerformed(ActionEvent e) {
				
				    String meetid =mid.getText();
				   String mname = name.getText();
			        String mdes = descri.getText();
			        String mtime = stime.getText();
			        String duration = dur.getText();
			        String mdate =date.getText();
			        
//			        
//			       SimpleDateFormat date_format = new SimpleDateFormat("dd-MM-yyyy");
//			       String startd = date_format.format(date.getText());
			        
			      
			       if(wkly.isSelected())
			         options="weekly";
			       else if(mntly.isSelected())
			         options="monthly";
			    
			       String patci = parti.getText();
			      
			        try {
			            pst = con.prepareStatement("insert into meetings(meeting_id,meeting_name,meet_description,meet_startTime,meet_duration,meet_date,noof_participants,meet_option)values(?,?,?,?,?,?,?,?)");
			            pst.setString(1,meetid);
			            pst.setString(2, mname);
			            pst.setString(3, mdes);
			            pst.setString(4, mtime);
			            pst.setString(5, duration);
			            pst.setString(6, options);
			            pst.setString(7, mdate);
			            pst.setString(8, patci);
			            
			            
			            int status = pst.executeUpdate();
			            
			            if(status==1)
			            {
			                JOptionPane.showMessageDialog(save, "Meeting Addedddddd");
			                MeetingTable();
			                
			                
			            }
			            else
			            {
			                JOptionPane.showMessageDialog(save, "Meeting Failedddd!!!");
			            }
			      
			        } catch (SQLException ex) {
			            Logger.getLogger(meetingpage.class.getName()).log(Level.SEVERE, null, ex);
			        }
				
				
				
				
			}
		});
		save.setBackground(new Color(192, 192, 192));
		save.setFont(new Font("Times New Roman", Font.BOLD, 27));
		save.setBounds(229, 638, 168, 50);
		frame.getContentPane().add(save);
		
		
		//print button
		
		JButton btnNewButton = new JButton("Print Table");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MessageFormat header =new MessageFormat("Heder");
				MessageFormat footer =new MessageFormat("page( 0, number, integer)");
				
				try {
					table.print(JTable.PrintMode.NORMAL, header, footer);
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
					
				}
				
				
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 27));
		btnNewButton.setBounds(679, 638, 373, 51);
		frame.getContentPane().add(btnNewButton);
	}
}



