package vues;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

import controller.AnnouncementController;
import controller.UserController;
import models.Announcement;
import models.User;
import javax.swing.JTable;
import javax.swing.JPanel;

public class VintudVue {

	private JFrame frame;	
	private JFrame frame1;
	private JFrame frame2;

	
	UserController userController =  new UserController() ;
	AnnouncementController announcementController = new AnnouncementController() ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VintudVue window = new VintudVue();
					window.frame.setVisible(true);
					window.frame1.setVisible(false);
					window.frame2.setVisible(false);


				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VintudVue() {
		initialize();
	}

	ArrayList<User> listAllUsers =userController.getAllUsers() ;
	ArrayList<Announcement> listAllUAnnonces = announcementController.getAllAnnonces() ;

	private JTable table_1;
	private JTable table_2;


	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(400, 400, 750, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		
		/*****************************************************************************/
		
		frame1 = new JFrame();
		frame1.setBounds(400, 400, 750, 600);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		
		/**********************************************************/
		
		frame2 = new JFrame();
		frame2.setBounds(400, 400, 750, 600);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		
		/*****************************************************************************/
		
		
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		
		JPanel panel1 = new JPanel();

		frame1.getContentPane().add(panel1, BorderLayout.CENTER);

		JPanel panel2 = new JPanel();

		frame2.getContentPane().add(panel2, BorderLayout.CENTER);

		

		
		JButton btnAfficherAnnonces= new JButton("Afficher toutes les annonces");		
		panel.add(btnAfficherAnnonces);
		
		JButton btnAfficherUsers = new JButton("Afficher tous les utilisateurs");
		panel.add(btnAfficherUsers);
		
		
		
		
		JButton retour1= new JButton("retour choix");		
		panel1.add(retour1);
		
		JButton retour2 = new JButton("retour choix");
		panel2.add(retour2);
		
		
		
		table_1 = new JTable(listAllUsers.size()+1, 9);
		panel1.add(table_1);
		
		
		table_2 = new JTable(listAllUAnnonces.size()+1, 11);
		panel2.add(table_2);
		
		
		btnAfficherUsers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				frame.setVisible(false);
				frame1.setVisible(true);
				frame2.setVisible(false);

				
				table_1.setValueAt("***USER ID ***", 0, 0);
				table_1.setValueAt("***FIRSTNAME ***", 0, 1);
				table_1.setValueAt("***NAME ***", 0, 2);
				table_1.setValueAt("***PSEUDO***", 0, 3);
				table_1.setValueAt("***MAIL ***", 0, 4);
				table_1.setValueAt("***PWD ***", 0, 5);
				table_1.setValueAt("**PHONE ***", 0, 6);
				table_1.setValueAt("***ADDRESS***", 0, 7);
				table_1.setValueAt("***ROLE ***", 0, 8);

				
				
				for(int i =1 ; i<listAllUsers.size()+1;i++) {
					
					table_1.setValueAt(listAllUsers.get(i-1).getId_user(), i, 0);
					table_1.setValueAt(listAllUsers.get(i-1).getFirstname(), i, 1);
					table_1.setValueAt(listAllUsers.get(i-1).getName(), i, 2);
					table_1.setValueAt(listAllUsers.get(i-1).getPseudo(), i, 3);
					table_1.setValueAt(listAllUsers.get(i-1).getMail(), i, 4);
					table_1.setValueAt(listAllUsers.get(i-1).getU_password(), i, 5);
					table_1.setValueAt(listAllUsers.get(i-1).getPhone(), i, 6);
					table_1.setValueAt(listAllUsers.get(i-1).getAddress(), i, 7);
					table_1.setValueAt(listAllUsers.get(i-1).getRole_id(), i, 8);

					
					
				}
				
				
		
			
		}}) ;
		
				
		btnAfficherAnnonces.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				frame1.setVisible(false);
				frame2.setVisible(true);

				
				table_2.setValueAt("***ANNONCE ID ***", 0, 0);
				table_2.setValueAt("***TITLE ***", 0, 1);
				table_2.setValueAt("***DESCRIPTION ***", 0, 2);
				table_2.setValueAt("***CATEGORY ID***", 0, 3);
				table_2.setValueAt("***PRICE ***", 0, 4);
				table_2.setValueAt("***PICTURE ***", 0, 5);
				table_2.setValueAt("**DATE ***", 0, 6);
				table_2.setValueAt("***AVAILABILITY***", 0, 7);
				table_2.setValueAt("***NBR VIEW ***", 0, 8);
				table_2.setValueAt("***LOCALISATION***", 0,9);
				table_2.setValueAt("***USER ID***", 0, 10);


				
				
				for(int i =1 ; i<listAllUAnnonces.size()+1;i++) {
					
					table_2.setValueAt(listAllUAnnonces.get(i-1).getId_annoucement(), i, 0);
					table_2.setValueAt(listAllUAnnonces.get(i-1).getTitle(), i, 1);
					table_2.setValueAt(listAllUAnnonces.get(i-1).getDescription(), i, 2);
					table_2.setValueAt(listAllUAnnonces.get(i-1).getCategory_id(), i, 3);
					table_2.setValueAt(listAllUAnnonces.get(i-1).getPrice(), i, 4);
					table_2.setValueAt(listAllUAnnonces.get(i-1).getPicture(), i, 5);
					table_2.setValueAt(listAllUAnnonces.get(i-1).getPublication_date(), i, 6);
					table_2.setValueAt(listAllUAnnonces.get(i-1).isIs_available(), i, 7);
					table_2.setValueAt(listAllUAnnonces.get(i-1).getView_number(), i, 8);
					table_2.setValueAt(listAllUAnnonces.get(i-1).getLocalisation(), i, 9);
					table_2.setValueAt(listAllUAnnonces.get(i-1).getUser_id(), i, 10);


					
					
				}
			}
		});
		
		retour1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(true);
				frame1.setVisible(false);
				frame2.setVisible(false);
					
				}
			
		});
		
		retour2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(true);
				frame1.setVisible(false);
				frame2.setVisible(false);
					
				}
			
		});
		
		
				
				
};
		
		
	}

	
	

