package warscribe.ui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import warscribe.data.Attack;
import warscribe.data.Character;
import warscribe.data.Roller;

import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JScrollPane;

import java.awt.Font;

public class DMFrame extends javax.swing.JFrame {

	public DMFrame() {
		initComponents();
		setBounds(100, 50, getWidth(), getHeight());
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (dim.width - this.getSize().width) / 2;
		int y = (dim.height - this.getSize().height) / 2;
		this.setLocation(x, y);
	}

	private void initComponents() {

		filename = "";
		totalXP = 0;
		openfile = null;
		combatants = new ArrayList<Character>();
		library = new ArrayList<Character>();
		charactersByName = new HashMap<String, Character>();
		fc = new javax.swing.JFileChooser();
		numberMonsterSpinner = new javax.swing.JSpinner();
		addField = new javax.swing.JTextField();
		jScrollPane1 = new javax.swing.JScrollPane();
		combatList = new javax.swing.JList();
		jScrollPane2 = new javax.swing.JScrollPane();
		infoArea = new javax.swing.JTextArea();
		healthBar = new javax.swing.JProgressBar();
		jSeparator1 = new javax.swing.JSeparator();
		loadBtn = new javax.swing.JButton();
		damageSpinner = new javax.swing.JSpinner();
		dmgBtn = new javax.swing.JButton();
		jScrollPane3 = new javax.swing.JScrollPane();
		XPArea = new javax.swing.JTextArea();
		jSeparator2 = new javax.swing.JSeparator();
		initBtn = new javax.swing.JButton();
		healthField = new javax.swing.JTextField();
		jScrollPane4 = new javax.swing.JScrollPane();
		outputArea = new javax.swing.JTextArea();
		killBtn = new javax.swing.JButton();
		XPCheck = new javax.swing.JCheckBox();
		clearBtn = new javax.swing.JButton();
		xpField = new javax.swing.JTextField();
		initField = new javax.swing.JTextField();
		hpField = new javax.swing.JTextField();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		nameField = new javax.swing.JTextField();
		createBtn = new javax.swing.JButton();
		levelField = new javax.swing.JTextField();
		stunnedToggle = new javax.swing.JToggleButton();
		immobilizedToggle = new javax.swing.JToggleButton();
		proneToggle = new javax.swing.JToggleButton();
		restrainedToggle = new javax.swing.JToggleButton();
		encounterAdd = new javax.swing.JButton();
		attackList = new javax.swing.JList();
		attackBtn = new javax.swing.JButton();
		hitField = new javax.swing.JTextField();
		jScrollPane5 = new javax.swing.JScrollPane();
		damageField = new javax.swing.JTextField();
		outputTab = new javax.swing.JTabbedPane();
		newMonsterPanel = new javax.swing.JPanel();
		monsterCatalogList = new javax.swing.JList();

		addKeyListener(new KeyListener() {
			public void keyPressed(KeyEvent evt) {
				killHotkeyPressed(evt);
			}

			public void keyReleased(KeyEvent evt) {
			}

			public void keyTyped(KeyEvent evt) {
			}
		});

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("WarScribe v2.0.2");
		setResizable(false);

		addField.setText("");
		addField.setFont(new java.awt.Font("Sylfaen", 0, 20));
		addField.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				addFieldActionPerformed(evt);
			}
		});
		addField.addKeyListener(new java.awt.event.KeyListener() {
			public void keyTyped(KeyEvent e) {
			}

			public void keyPressed(KeyEvent e) {
			}

			public void keyReleased(KeyEvent e) {
				reloadMonsterCatalog();
			}
		});

		combatList.setBackground(new java.awt.Color(209, 206, 128));
		combatList.setFont(new java.awt.Font("Sylfaen", 2, 20));
		combatList.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Encounter List", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Sylfaen", 0, 16), new java.awt.Color(102, 51, 0)));
		combatList.setModel(new javax.swing.AbstractListModel<String>() {
			String[] strings = {};

			public int getSize() {
				return strings.length;
			}

			public String getElementAt(int i) {
				return strings[i];
			}
		});
		combatList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
			public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
				combatListValueChanged(evt);
			}
		});
		jScrollPane1.setViewportView(combatList);
		combatList.addKeyListener(new KeyListener() {
			public void keyPressed(KeyEvent evt) {
				killHotkeyPressed(evt);
			}

			public void keyReleased(KeyEvent evt) {
			}

			public void keyTyped(KeyEvent evt) {
			}
		});

		infoArea.setColumns(20);
		infoArea.setFont(new java.awt.Font("Sylfaen", 0, 18));
		infoArea.setEditable(false);
		infoArea.setRows(5);
		infoArea.setBorder(javax.swing.BorderFactory.createTitledBorder("Quick Info"));
		jScrollPane2.setViewportView(infoArea);

		jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

		loadBtn.setText("Load Monster Database");
		loadBtn.setFont(new java.awt.Font("Sylfaen", 0, 20));
		loadBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				loadBtnActionPerformed(evt);
			}
		});

		damageSpinner.setFont(new java.awt.Font("Sylfaen", 0, 30));

		dmgBtn.setText("Take damage");
		dmgBtn.setFont(new java.awt.Font("Sylfaen", 0, 16));
		dmgBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				dmgBtnActionPerformed(evt);
			}
		});

		XPArea.setBackground(new java.awt.Color(255, 255, 153));
		XPArea.setColumns(20);
		XPArea.setFont(new java.awt.Font("Sylfaen", 0, 18));
		XPArea.setRows(1);
		XPArea.setText("Total XP Gained:");
		jScrollPane3.setViewportView(XPArea);
		XPArea.setEditable(false);

		initBtn.setText("Roll for initiative!");
		initBtn.setFont(new java.awt.Font("Sylfaen", 0, 20));
		initBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				initBtnActionPerformed(evt);
			}
		});

		healthField.setText("Set HP manually");
		healthField.setFont(new java.awt.Font("Sylfaen", 0, 16));
		healthField.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				healthFieldActionPerformed(evt);
			}
		});

		outputArea.setColumns(20);
		outputArea.setEditable(false);
		outputArea.setRows(5);
		outputArea.setFont(new java.awt.Font("Sylfaen", 0, 16));
		outputArea.setBorder(javax.swing.BorderFactory.createTitledBorder("Output Window"));
		jScrollPane4.setViewportView(outputArea);

		killBtn.setText("Kill selected");
		killBtn.setFont(new java.awt.Font("Sylfaen", 0, 16));
		killBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				killBtnActionPerformed(evt);
			}
		});

		XPCheck.setFont(new java.awt.Font("Sylfaen", 0, 14));
		XPCheck.setText("XP for instant deaths");
		XPCheck.setSelected(true);
		XPCheck.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

		numberMonsterSpinner.setFont(new java.awt.Font("Sylfaen", 0, 18));
		numberMonsterSpinner.setValue(1);

		clearBtn.setText("Clear XP and Output");
		clearBtn.setFont(new java.awt.Font("Sylfaen", 0, 16));
		clearBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				clearBtnActionPerformed(evt);
			}
		});

		createBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				createBtnActionPerformed(evt);
			}
		});

		createBtn.setEnabled(false);
		nameField.setEnabled(false);
		initField.setEnabled(false);
		xpField.setEnabled(false);
		hpField.setEnabled(false);
		levelField.setEnabled(false);

		initField.setText("1d20+0");
		jLabel1.setText("Name");
		jLabel2.setText("Level");
		jLabel3.setText("XP Gain");
		jLabel4.setText("Maximum Health");
		jLabel5.setText("Initiative Roll");
		createBtn.setText("New entry");
		createBtn.setFont(new java.awt.Font("Sylfaen", 0, 16));
		jLabel1.setFont(new java.awt.Font("Sylfaen", 0, 16));
		jLabel2.setFont(new java.awt.Font("Sylfaen", 0, 16));
		jLabel3.setFont(new java.awt.Font("Sylfaen", 0, 16));
		jLabel4.setFont(new java.awt.Font("Sylfaen", 0, 16));
		jLabel5.setFont(new java.awt.Font("Sylfaen", 0, 16));
		createBtn.setFont(new java.awt.Font("Sylfaen", 0, 16));
		nameField.setFont(new java.awt.Font("Sylfaen", 0, 16));
		levelField.setFont(new java.awt.Font("Sylfaen", 0, 16));
		hpField.setFont(new java.awt.Font("Sylfaen", 0, 16));
		xpField.setFont(new java.awt.Font("Sylfaen", 0, 16));
		initField.setFont(new java.awt.Font("Sylfaen", 0, 16));

		stunnedToggle.setFont(new java.awt.Font("Sylfaen", 0, 16));
		stunnedToggle.setText("Stunned");
		stunnedToggle.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				stunnedToggleActionPerformed(evt);
			}
		});

		immobilizedToggle.setFont(new java.awt.Font("Sylfaen", 0, 16));
		immobilizedToggle.setText("Immobilized");
		immobilizedToggle.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				immobilizedToggleActionPerformed(evt);
			}
		});

		proneToggle.setFont(new java.awt.Font("Sylfaen", 0, 16));
		proneToggle.setText("Prone");
		proneToggle.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				proneToggleActionPerformed(evt);
			}
		});

		restrainedToggle.setFont(new java.awt.Font("Sylfaen", 0, 16));
		restrainedToggle.setText("Restrained");
		restrainedToggle.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				restrainedToggleActionPerformed(evt);
			}
		});

		encounterAdd.setFont(new java.awt.Font("Sylfaen", 1, 16));
		encounterAdd.setText("Add to encounter");
		encounterAdd.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				encounterAddActionPerformed(evt);
			}
		});

		attackList.setFont(new java.awt.Font("Sylfaen", 2, 16));
		attackList.setModel(new javax.swing.AbstractListModel<String>() {
			String[] strings = {};

			public int getSize() {
				return strings.length;
			}

			public String getElementAt(int i) {
				return strings[i];
			}
		});
		attackList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
			public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
				attackListValueChanged(evt);
			}
		});
		attackList.addKeyListener(new KeyListener() {
			public void keyPressed(KeyEvent evt) {
				rollHotkeyPressed(evt);
			}

			public void keyReleased(KeyEvent evt) {
			}

			public void keyTyped(KeyEvent evt) {
			}
		});
		jScrollPane5.setViewportView(attackList);

		attackBtn.setFont(new java.awt.Font("Sylfaen", 1, 16));
		attackBtn.setText("Roll!");
		attackBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				attackBtnActionPerformed(evt);
			}
		});

		outputTab.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
		outputTab.setFont(new java.awt.Font("Sylfaen", 0, 14));
		outputTab.addTab("Output Records", jScrollPane4);

		hitField.setFont(new java.awt.Font("Sylfaen", 0, 16));

		damageField.setFont(new java.awt.Font("Sylfaen", 0, 16));

		javax.swing.GroupLayout newMonsterPanelLayout = new javax.swing.GroupLayout(newMonsterPanel);
		newMonsterPanelLayout.setHorizontalGroup(newMonsterPanelLayout.createParallelGroup(Alignment.LEADING).addGroup(
						newMonsterPanelLayout.createSequentialGroup().addContainerGap().addGroup(
										newMonsterPanelLayout.createParallelGroup(Alignment.LEADING, false).addComponent(jLabel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(jLabel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)).addPreferredGap(ComponentPlacement.RELATED).addGroup(
										newMonsterPanelLayout.createParallelGroup(Alignment.LEADING, false).addComponent(xpField).addComponent(levelField).addComponent(nameField, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)).addPreferredGap(ComponentPlacement.UNRELATED).addGroup(
										newMonsterPanelLayout.createParallelGroup(Alignment.LEADING).addGroup(
														newMonsterPanelLayout.createSequentialGroup().addGroup(newMonsterPanelLayout.createParallelGroup(Alignment.LEADING).addComponent(jLabel5).addComponent(jLabel4)).addPreferredGap(ComponentPlacement.RELATED).addGroup(
																		newMonsterPanelLayout.createParallelGroup(Alignment.LEADING).addComponent(initField, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE).addComponent(hpField, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))).addGroup(
														newMonsterPanelLayout.createSequentialGroup().addComponent(createBtn, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE).addPreferredGap(ComponentPlacement.RELATED, 242, GroupLayout.PREFERRED_SIZE))).addGap(127)));
		newMonsterPanelLayout.setVerticalGroup(newMonsterPanelLayout.createParallelGroup(Alignment.LEADING).addGroup(
						newMonsterPanelLayout.createSequentialGroup().addGroup(
										newMonsterPanelLayout.createParallelGroup(Alignment.BASELINE).addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE).addComponent(nameField, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE).addComponent(hpField, GroupLayout.PREFERRED_SIZE, 44,
														GroupLayout.PREFERRED_SIZE).addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)).addPreferredGap(ComponentPlacement.UNRELATED).addGroup(
										newMonsterPanelLayout.createParallelGroup(Alignment.LEADING).addGroup(newMonsterPanelLayout.createSequentialGroup().addComponent(jLabel2, GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE).addGap(14)).addGroup(
														newMonsterPanelLayout.createSequentialGroup().addGroup(
																		newMonsterPanelLayout.createParallelGroup(Alignment.BASELINE).addComponent(levelField, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE).addComponent(jLabel5, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
																						.addComponent(initField, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)).addPreferredGap(ComponentPlacement.RELATED))).addGroup(
										newMonsterPanelLayout.createParallelGroup(Alignment.LEADING).addGroup(
														newMonsterPanelLayout.createParallelGroup(Alignment.BASELINE).addComponent(xpField, GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE).addComponent(createBtn, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)).addComponent(jLabel3,
														GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)).addGap(24)));
		newMonsterPanel.setLayout(newMonsterPanelLayout);

		outputTab.addTab("New Monster Creation", newMonsterPanel);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(
						layout.createSequentialGroup().addContainerGap().addGroup(
										layout.createParallelGroup(Alignment.TRAILING).addGroup(
														layout.createSequentialGroup().addGroup(
																		layout.createParallelGroup(Alignment.TRAILING).addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE).addGroup(
																						layout.createSequentialGroup().addComponent(addField, GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE).addPreferredGap(ComponentPlacement.RELATED).addComponent(numberMonsterSpinner, GroupLayout.PREFERRED_SIZE,
																										59, GroupLayout.PREFERRED_SIZE)).addComponent(encounterAdd, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)).addGap(14)).addComponent(initBtn, GroupLayout.DEFAULT_SIZE, 315,
														Short.MAX_VALUE)).addPreferredGap(ComponentPlacement.RELATED).addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 11, GroupLayout.PREFERRED_SIZE).addPreferredGap(ComponentPlacement.RELATED).addGroup(
										layout.createParallelGroup(Alignment.LEADING).addGroup(
														layout.createParallelGroup(Alignment.LEADING, false).addComponent(jSeparator2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addComponent(loadBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
																		Short.MAX_VALUE).addGroup(
																		layout.createSequentialGroup().addGroup(
																						layout.createParallelGroup(Alignment.LEADING).addGroup(
																										layout.createSequentialGroup().addComponent(damageSpinner, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE).addGap(18).addComponent(healthBar, GroupLayout.DEFAULT_SIZE, 360,
																														Short.MAX_VALUE)).addGroup(
																										layout.createSequentialGroup().addGroup(
																														layout.createParallelGroup(Alignment.LEADING).addComponent(killBtn, GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE).addComponent(dmgBtn, Alignment.TRAILING,
																																		GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)).addGap(18).addGroup(
																														layout.createParallelGroup(Alignment.LEADING, false).addComponent(XPCheck, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(healthField,
																																		GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE))).addGroup(
																										layout.createSequentialGroup().addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 333, GroupLayout.PREFERRED_SIZE).addPreferredGap(ComponentPlacement.RELATED).addGroup(
																														layout.createParallelGroup(Alignment.LEADING, false).addComponent(restrainedToggle, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(proneToggle,
																																		GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(immobilizedToggle, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
																																		Short.MAX_VALUE).addComponent(stunnedToggle, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)))).addPreferredGap(ComponentPlacement.UNRELATED)
																						.addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(jScrollPane5, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE).addGroup(
																										layout.createParallelGroup(Alignment.LEADING).addComponent(hitField, GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE).addComponent(damageField).addComponent(attackBtn, GroupLayout.DEFAULT_SIZE,
																														115, Short.MAX_VALUE))).addGap(16))).addGroup(
														layout.createSequentialGroup().addComponent(jScrollPane3, GroupLayout.PREFERRED_SIZE, 362, GroupLayout.PREFERRED_SIZE).addPreferredGap(ComponentPlacement.RELATED, 41, Short.MAX_VALUE).addComponent(clearBtn, GroupLayout.PREFERRED_SIZE, 229,
																		GroupLayout.PREFERRED_SIZE)).addComponent(outputTab, GroupLayout.PREFERRED_SIZE, 632, GroupLayout.PREFERRED_SIZE)).addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(
						layout.createSequentialGroup().addContainerGap().addGroup(
										layout.createParallelGroup(Alignment.TRAILING).addGroup(
														layout.createSequentialGroup().addComponent(loadBtn, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE).addPreferredGap(ComponentPlacement.RELATED).addComponent(jSeparator2, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(ComponentPlacement.RELATED).addGroup(
																						layout.createParallelGroup(Alignment.LEADING).addGroup(
																										layout.createSequentialGroup().addComponent(jScrollPane5, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE).addPreferredGap(ComponentPlacement.RELATED).addComponent(hitField,
																														GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE).addPreferredGap(ComponentPlacement.RELATED).addComponent(damageField, GroupLayout.PREFERRED_SIZE, 34,
																														GroupLayout.PREFERRED_SIZE).addPreferredGap(ComponentPlacement.RELATED).addComponent(attackBtn)).addGroup(
																										layout.createSequentialGroup().addGroup(
																														layout.createParallelGroup(Alignment.LEADING).addGroup(
																																		layout.createSequentialGroup().addComponent(stunnedToggle, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE).addGap(13).addComponent(immobilizedToggle,
																																						GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE).addPreferredGap(ComponentPlacement.RELATED).addComponent(proneToggle,
																																						GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE).addPreferredGap(ComponentPlacement.UNRELATED).addComponent(restrainedToggle,
																																						GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
																																		.addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)).addPreferredGap(ComponentPlacement.RELATED).addGroup(
																														layout.createParallelGroup(Alignment.LEADING, false).addComponent(healthBar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(damageSpinner))
																														.addGap(18).addGroup(
																																		layout.createParallelGroup(Alignment.BASELINE).addComponent(dmgBtn, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE).addComponent(healthField,
																																						GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)).addPreferredGap(ComponentPlacement.RELATED).addGroup(
																																		layout.createParallelGroup(Alignment.BASELINE).addComponent(killBtn).addComponent(XPCheck)))).addPreferredGap(ComponentPlacement.RELATED).addComponent(outputTab,
																						GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE).addPreferredGap(ComponentPlacement.RELATED).addGroup(
																						layout.createParallelGroup(Alignment.TRAILING).addComponent(jScrollPane3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addComponent(clearBtn, GroupLayout.PREFERRED_SIZE, 31,
																										GroupLayout.PREFERRED_SIZE))).addComponent(jSeparator1, GroupLayout.DEFAULT_SIZE, 669, Short.MAX_VALUE).addGroup(
														layout.createSequentialGroup().addGroup(
																		layout.createParallelGroup(Alignment.BASELINE).addComponent(addField, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE).addComponent(numberMonsterSpinner, GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE))
																		.addPreferredGap(ComponentPlacement.RELATED).addComponent(encounterAdd, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE).addPreferredGap(ComponentPlacement.RELATED).addComponent(jScrollPane1,
																						GroupLayout.PREFERRED_SIZE, 511, GroupLayout.PREFERRED_SIZE).addPreferredGap(ComponentPlacement.RELATED).addComponent(initBtn, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))).addContainerGap()));
		getContentPane().setLayout(layout);

		JScrollPane monsterCatalogPane = new JScrollPane();
		outputTab.addTab("Monster Catalog", null, monsterCatalogPane, null);

		monsterCatalogList.setFont(new Font("Dialog", Font.PLAIN, 16));
		monsterCatalogPane.setViewportView(monsterCatalogList);
		monsterCatalogList.setEnabled(false);
		monsterCatalogList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		monsterCatalogList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (e.getValueIsAdjusting())
					return;

				int selectedIndex = monsterCatalogList.getSelectedIndex();
				if (monsterCatalogCharacters == null || selectedIndex < 0 || selectedIndex >= monsterCatalogCharacters.size())
					return;

				Character selectedCharacter = (Character) monsterCatalogList.getModel().getElementAt(selectedIndex);
				addField.setText(selectedCharacter.getName());
				updateCharacterInfoDisplayWithCharacter(selectedCharacter);
			}
		});
		monsterCatalogList.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {
			}

			public void mousePressed(MouseEvent e) {
			}

			public void mouseExited(MouseEvent e) {
			}

			public void mouseEntered(MouseEvent e) {
			}

			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() < 2 || e.getClickCount() % 2 == 1)
					return;

				int selectedIndex = monsterCatalogList.getSelectedIndex();
				if (monsterCatalogCharacters == null || selectedIndex < 0 || selectedIndex >= monsterCatalogCharacters.size())
					return;

				Character selectedCharacter = (Character) monsterCatalogList.getModel().getElementAt(selectedIndex);
				addField.setText(selectedCharacter.getName());
				addMonster();
			}
		});
		monsterCatalogCharacters = new ArrayList<Character>();
		pack();
	}

	/*
	 * ==========================================================================
	 * ========================================
	 */

	private void addFieldActionPerformed(java.awt.event.ActionEvent evt) {
		addMonster();
	}

	/*
	 * ==========================================================================
	 * ========================================
	 */

	private void initBtnActionPerformed(java.awt.event.ActionEvent evt) {
		if (combatants.size() > 1) {
			for (int i = 0; i < combatants.size(); i++) {
				combatants.get(i).setInitiative();
			}
			sortInitiative();
			combatList.setModel(new javax.swing.AbstractListModel() {
				String[] names = updateList();

				public int getSize() {
					return names.length;
				}

				public Object getElementAt(int i) {
					return names[i];
				}
			});
			outputArea.append("=================INITIATIVE ROLL=================\n");
			for (int i = 0; i < combatants.size(); i++) {
				outputArea.append(combatants.get(i).getCombatantName() + " rolled " + combatants.get(i).getInitiative() + " for initiative.\n");
			}
			outputArea.append("\n");
			initBtn.setEnabled(false);
		} else {
			JOptionPane.showMessageDialog(null, "Please input more combatants before rolling for initiative.", "Warning!", JOptionPane.ERROR_MESSAGE);
		}
	}

	/*
	 * ==========================================================================
	 * ========================================
	 */

	private void dmgBtnActionPerformed(java.awt.event.ActionEvent evt) {
		takeDamage();
	}

	/*
	 * ==========================================================================
	 * ========================================
	 */

	private void loadBtnActionPerformed(java.awt.event.ActionEvent evt) {
		flushLib();
		int returnValue = fc.showOpenDialog(DMFrame.this);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			openfile = fc.getSelectedFile();
			filename = openfile.getName();
			Scanner in = null;
			int lastSuccessfullyParsedLineNumber = 0;
			try {
				in = new Scanner(openfile);
				outputArea.append("Loading from: " + openfile.getName() + "\n");

				while (in.hasNextLine()) {
					String line = in.nextLine();
					if (line.trim().length() == 0)
						continue;

					String name_ = line.substring(0, line.indexOf(";")).trim();
					line = line.substring(line.indexOf(";") + 1, line.length()).trim();

					int lvl = Integer.parseInt(line.substring(0, line.indexOf(";")));
					line = line.substring(line.indexOf(";") + 1, line.length()).trim();

					int xp = Integer.parseInt(line.substring(0, line.indexOf(";")));
					line = line.substring(line.indexOf(";") + 1, line.length()).trim();

					int hp = Integer.parseInt(line.substring(0, line.indexOf(";")));
					line = line.substring(line.indexOf(";") + 1, line.length()).trim();

					String init = line.substring(0, line.indexOf(";"));
					line = line.substring(line.indexOf(";") + 1, line.length()).trim();

					Character newCharacter = new Character(name_, lvl, xp, hp, init);
					library.add(newCharacter);
					charactersByName.put(name_.toLowerCase(), newCharacter);

					while (line.length() > 1) {
						String newAtk = line.substring(0, line.indexOf(";"));
						library.get(library.size() - 1).addAttack(new Attack(newAtk));
						line = line.substring(line.indexOf(";") + 1, line.length()).trim();
					}
					lastSuccessfullyParsedLineNumber++;

				}
				createBtn.setEnabled(true);
				nameField.setEnabled(true);
				initField.setEnabled(true);
				xpField.setEnabled(true);
				hpField.setEnabled(true);
				levelField.setEnabled(true);
				monsterCatalogList.setEnabled(true);
				outputArea.append("Successfully loaded: " + library.size() + " monsters.\n");
				reloadMonsterCatalog();

			} catch (Exception e) {
				outputArea.append("Error: parsing critically failed around line " + lastSuccessfullyParsedLineNumber + ".");

			} finally {
				if (in != null)
					in.close();
			}
		}
	}

	private void reloadMonsterCatalog() {
		String monsterFilterText = addField.getText().trim().toLowerCase();
		if (monsterFilterText.length() == 0 || library == null) {
			// In the case where we aren't trying to add monsters, don't filter
			// the catalog. Just display all known characters.
			monsterCatalogCharacters = library;

		} else {
			monsterCatalogCharacters = new ArrayList<Character>();
			for (Character character : library) {
				if (character.validSearchResultForTerm(monsterFilterText))
					monsterCatalogCharacters.add(character);
			}
		}

		monsterCatalogList.setModel(new javax.swing.AbstractListModel<Character>() {
			public int getSize() {
				if (monsterCatalogCharacters == null) {
					return 0;
				}

				return monsterCatalogCharacters.size();
			}

			public Character getElementAt(int index) {
				if (monsterCatalogCharacters == null || index >= monsterCatalogCharacters.size()) {
					return null;
				}

				return monsterCatalogCharacters.get(index);
			}
		});
	}

	/*
	 * ==========================================================================
	 * ========================================
	 */

	private void combatListValueChanged(javax.swing.event.ListSelectionEvent evt) {
		int index = combatList.getSelectedIndex();
		if (index != -1) {
			updateMonsterDisplay(index);
		} else {
			infoArea.setText("");
			attackBtn.setEnabled(false);
			healthBar.setStringPainted(false);
			healthBar.setValue(0);
		}
	}

	/*
	 * ==========================================================================
	 * ========================================
	 */

	private void healthFieldActionPerformed(java.awt.event.ActionEvent evt) {
		int index = combatList.getSelectedIndex();
		String input = healthField.getText();
		healthField.setText("");
		try {
			if (Integer.parseInt(input) > 0 && index != -1)
				combatants.get(index).setHealth(Integer.parseInt(input));
			updateMonsterDisplay(index);
		} catch (Exception e) {
		}
	}

	/*
	 * ==========================================================================
	 * ========================================
	 */

	private void killBtnActionPerformed(java.awt.event.ActionEvent evt) {
		int[] indices = combatList.getSelectedIndices();
		if (indices.length > 0) {
			for (int i = indices.length - 1; i >= 0; i--) {
				outputArea.append(combatants.get(indices[i]).getName() + " has died.\n");
				if (XPCheck.isSelected()) {
					outputArea.append("XP gained: " + combatants.get(indices[i]).getXP() + "\n");
					totalXP += combatants.get(indices[i]).getXP();
					XPArea.setText("Total XP Gained: " + totalXP);
				}
				combatants.remove(indices[i]);
				setList();
			}
		}
	}

	/*
	 * ==========================================================================
	 * ========================================
	 */

	private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {
		XPArea.setText("Total XP Gained: ");
		totalXP = 0;
		outputArea.setText("");
		combatList.clearSelection();
	}

	/*
	 * ==========================================================================
	 * ========================================
	 */

	private void createBtnActionPerformed(java.awt.event.ActionEvent evt) {
		if (nameField.getText().length() != 0 && levelField.getText().length() != 0 && initField.getText().length() != 0 && xpField.getText().length() != 0 && hpField.getText().length() != 0) {
			boolean found = false;
			for (int i = 0; i < library.size(); i++)
				if (library.get(i).getName().toLowerCase().compareTo(nameField.getText().toLowerCase()) == 0) {
					found = true;
				}
			if (!found)
				try {
					FileWriter savefile = new FileWriter(filename, true);
					savefile.write("\n" + nameField.getText() + ";");
					savefile.write(levelField.getText() + ";");
					savefile.write(xpField.getText() + ";");
					savefile.write(hpField.getText() + ";");
					savefile.write(initField.getText() + ";");
					savefile.close();
					Character newCharacter = new Character(nameField.getText(), Integer.parseInt(levelField.getText()), Integer.parseInt(xpField.getText()), Integer.parseInt(hpField.getText()), initField.getText());
					library.add(newCharacter);
					charactersByName.put(newCharacter.getName().toLowerCase(), newCharacter);
					outputArea.append("Successfully added: " + nameField.getText() + " to the database.\n");
					reloadMonsterCatalog();
				} catch (Exception e) {
					outputArea.append("Failed to add " + nameField.getText() + " to the database.\n");
				}
			else {
				javax.swing.JOptionPane.showMessageDialog(null, "The entry \"" + nameField.getText() + "\" is already in the database.", "Warning!", javax.swing.JOptionPane.ERROR_MESSAGE);
			}
			nameField.setText("");
			levelField.setText("");
			xpField.setText("");
			hpField.setText("");
			initField.setText("1d20+0");
		}
	}

	/*
	 * ==========================================================================
	 * ========================================
	 */

	private void stunnedToggleActionPerformed(java.awt.event.ActionEvent evt) {
		int index = combatList.getSelectedIndex();
		if (combatants.size() > 0) {
			if (combatList.getSelectedIndex() != -1) {
				combatants.get(index).setStunned(stunnedToggle.isSelected());
			}
			if (stunnedToggle.isSelected()) {
				outputArea.append(combatants.get(index).getCombatantName() + " is stunned.\n");
				stunnedToggle.setFont(new java.awt.Font("Sylfaen", 1, 16));
				stunnedToggle.setForeground(new java.awt.Color(153, 0, 0));
			} else {
				stunnedToggle.setFont(new java.awt.Font("Sylfaen", 0, 16));
				stunnedToggle.setForeground(new java.awt.Color(0, 0, 0));
			}
		}
	}

	/*
	 * ==========================================================================
	 * ========================================
	 */

	private void immobilizedToggleActionPerformed(java.awt.event.ActionEvent evt) {
		int index = combatList.getSelectedIndex();
		if (combatants.size() > 0) {
			if (combatList.getSelectedIndex() != -1) {
				combatants.get(index).setImmobilized(immobilizedToggle.isSelected());
			}
			if (immobilizedToggle.isSelected()) {
				outputArea.append(combatants.get(index).getCombatantName() + " is immobilized.\n");
				immobilizedToggle.setFont(new java.awt.Font("Sylfaen", 1, 16));
				immobilizedToggle.setForeground(new java.awt.Color(154, 0, 0));
			} else {
				immobilizedToggle.setFont(new java.awt.Font("Sylfaen", 0, 16));
				immobilizedToggle.setForeground(new java.awt.Color(0, 0, 0));
			}
		}
	}

	/*
	 * ==========================================================================
	 * ========================================
	 */

	private void proneToggleActionPerformed(java.awt.event.ActionEvent evt) {
		int index = combatList.getSelectedIndex();
		if (combatants.size() > 0) {
			if (combatList.getSelectedIndex() != -1) {
				combatants.get(index).setProne(proneToggle.isSelected());
			}
			if (proneToggle.isSelected()) {
				outputArea.append(combatants.get(index).getCombatantName() + " is prone.\n");
				proneToggle.setFont(new java.awt.Font("Sylfaen", 1, 16));
				proneToggle.setForeground(new java.awt.Color(154, 0, 0));
			} else {
				proneToggle.setFont(new java.awt.Font("Sylfaen", 0, 16));
				proneToggle.setForeground(new java.awt.Color(0, 0, 0));
			}
		}
	}

	/*
	 * ==========================================================================
	 * ========================================
	 */

	private void restrainedToggleActionPerformed(java.awt.event.ActionEvent evt) {
		int index = combatList.getSelectedIndex();
		if (combatants.size() > 0) {
			if (combatList.getSelectedIndex() != -1) {
				combatants.get(index).setRestrained(restrainedToggle.isSelected());
			}
			if (restrainedToggle.isSelected()) {
				outputArea.append(combatants.get(index).getCombatantName() + " is restrained.\n");
				restrainedToggle.setFont(new java.awt.Font("Sylfaen", 1, 16));
				restrainedToggle.setForeground(new java.awt.Color(154, 0, 0));
			} else {
				restrainedToggle.setFont(new java.awt.Font("Sylfaen", 0, 16));
				restrainedToggle.setForeground(new java.awt.Color(0, 0, 0));
			}
		}
	}

	/*
	 * ==========================================================================
	 * ========================================
	 */

	private void encounterAddActionPerformed(java.awt.event.ActionEvent evt) {
		addMonster();
	}

	/*
	 * ==========================================================================
	 * ========================================
	 */

	private void attackBtnActionPerformed(java.awt.event.ActionEvent evt) {
		int indexOfAttack = attackList.getSelectedIndex();
		int indexOfCombatant = combatList.getSelectedIndex();
		if (indexOfAttack == -1 || indexOfCombatant == -1 || hitField.getText().length() == 0 || damageField.getText().length() == 0)
			return;

		try {
			Character combatant = combatants.get(indexOfCombatant);
			int hitBonus = combatant.getAttacks().get(indexOfAttack).getHitMod();
			int hit = Roller.roll("1d20+0" + Integer.parseInt(hitField.getText()));
			int hit_secondary = combatant.getAttacks().get(indexOfAttack).returnHit();
			if (combatant.getAttacks().get(indexOfAttack).getHitMod() < 0)
				hit = hit_secondary;

			int damage = Roller.roll(damageField.getText());
			if (hit - Math.abs(hitBonus) == 1) {
				outputArea.append("\n" + combatant.getCombatantName() + " uses " + combatant.getAttacks().get(indexOfAttack).getAttackName() + ":\nCritical FAILURE\n");
				JOptionPane.showMessageDialog(null, "\n" + combatant.getCombatantName() + " uses " + combatant.getAttacks().get(indexOfAttack).getAttackName() + ":\n" + "Critical FAILURE\n", "Message", JOptionPane.PLAIN_MESSAGE);
			} else if (hit - Math.abs(hitBonus) == 20) {
				outputArea.append("\n" + combatant.getCombatantName() + " uses " + combatant.getAttacks().get(indexOfAttack).getAttackName() + ":\nCritical SUCCESS\nModify roll field and reroll for critical damage.\n");
				JOptionPane.showMessageDialog(null, "\n" + combatant.getCombatantName() + " uses " + combatant.getAttacks().get(indexOfAttack).getAttackName() + ":\nCritical SUCCESS\nModify roll field and reroll for critical damage.\n", "Roll results:", JOptionPane.PLAIN_MESSAGE);
			} else {
				outputArea.append("\n" + combatant.getCombatantName() + " uses " + combatant.getAttacks().get(indexOfAttack).getAttackName() + ":\nRoll for hit: " + hit + "\nRoll for damage: " + damage + "\n");
				JOptionPane.showMessageDialog(null, combatant.getCombatantName() + " uses " + combatant.getAttacks().get(indexOfAttack).getAttackName() + ":\n" + "Roll for hit: " + hit + "\nRoll for damage: " + damage, "Roll results:", JOptionPane.PLAIN_MESSAGE);
			}
		} catch (Exception e) {
			javax.swing.JOptionPane.showMessageDialog(null, "Please input the hit bonus and damage in proper format.", "Warning!", javax.swing.JOptionPane.ERROR_MESSAGE);
		}
		outputArea.setCaretPosition(outputArea.getText().length() - 1);
	}

	/*
	 * ==========================================================================
	 * ========================================
	 */

	private void attackListValueChanged(javax.swing.event.ListSelectionEvent evt) {
		int indexOfAttack = attackList.getSelectedIndex();
		int indexOfCharacter = combatList.getSelectedIndex();
		if (indexOfAttack != -1 && indexOfCharacter != -1) {
			attackBtn.setEnabled(true);
			hitField.setText(Integer.toString(combatants.get(indexOfCharacter).getAttacks().get(indexOfAttack).getHitMod()));
			damageField.setText(combatants.get(indexOfCharacter).getAttacks().get(indexOfAttack).getDamageRoll());
		} else {
			attackBtn.setEnabled(false);
			hitField.setText("Hit Bonus");
			damageField.setText("Damage Roll");
		}
	}

	/*
	 * ==========================================================================
	 * ========================================
	 */

	private void killHotkeyPressed(KeyEvent evt) {
		if (evt.getKeyChar() == 'x') {
			int[] indices = combatList.getSelectedIndices();
			if (indices.length > 0) {
				for (int i = indices.length - 1; i >= 0; i--) {
					outputArea.append(combatants.get(indices[i]).getName() + " has died.\n");
					if (XPCheck.isSelected()) {
						outputArea.append("XP gained: " + combatants.get(indices[i]).getXP() + "\n");
						totalXP += combatants.get(indices[i]).getXP();
						XPArea.setText("Total XP Gained: " + totalXP);
					}
					combatants.remove(indices[i]);
					setList();
				}
				outputArea.setCaretPosition(outputArea.getText().length() - 1);
			}
		}
	}

	/*
	 * ==========================================================================
	 * ========================================
	 */

	private void rollHotkeyPressed(KeyEvent evt) {
		if (evt.getKeyChar() == 'r') {
			int indexOfAttack = attackList.getSelectedIndex();
			int indexOfCharacter = combatList.getSelectedIndex();
			int hitBonus = combatants.get(indexOfCharacter).getAttacks().get(indexOfAttack).getHitMod();
			if (indexOfAttack != -1 && indexOfCharacter != -1 && hitField.getText().length() > 0 && damageField.getText().length() > 0) {
				try {
					int hit = Roller.roll("1d20+0" + Integer.parseInt(hitField.getText()));
					int hit_secondary = combatants.get(indexOfCharacter).getAttacks().get(indexOfAttack).returnHit();
					if (combatants.get(indexOfCharacter).getAttacks().get(indexOfAttack).getHitMod() < 0)
						hit = hit_secondary;
					int damage = Roller.roll(damageField.getText());
					if (hit - Math.abs(hitBonus) == 1) {
						outputArea.append("\n" + combatants.get(indexOfCharacter).getCombatantName() + " uses " + combatants.get(indexOfCharacter).getAttacks().get(indexOfAttack).getAttackName() + ":\n" + "Critical FAILURE\n");
						JOptionPane.showMessageDialog(null, "\n" + combatants.get(indexOfCharacter).getCombatantName() + " uses " + combatants.get(indexOfCharacter).getAttacks().get(indexOfAttack).getAttackName() + ":\n" + "Critical FAILURE\n", "Message", JOptionPane.PLAIN_MESSAGE);
					} else if (hit - Math.abs(hitBonus) == 20) {
						outputArea.append("\n" + combatants.get(indexOfCharacter).getCombatantName() + " uses " + combatants.get(indexOfCharacter).getAttacks().get(indexOfAttack).getAttackName() + ":\n" + "Critical SUCCESS" + "\nModify roll field and reroll for critical damage.\n");
						JOptionPane.showMessageDialog(null,
										"\n" + combatants.get(indexOfCharacter).getCombatantName() + " uses " + combatants.get(indexOfCharacter).getAttacks().get(indexOfAttack).getAttackName() + ":\n" + "Critical SUCCESS" + "\nModify roll field and reroll for critical damage.\n", "Roll results:",
										JOptionPane.PLAIN_MESSAGE);
					} else {
						outputArea.append("\n" + combatants.get(indexOfCharacter).getCombatantName() + " uses " + combatants.get(indexOfCharacter).getAttacks().get(indexOfAttack).getAttackName() + ":\n" + "Roll for hit: " + hit + "\nRoll for damage: " + damage + "\n");
						JOptionPane.showMessageDialog(null, combatants.get(indexOfCharacter).getCombatantName() + " uses " + combatants.get(indexOfCharacter).getAttacks().get(indexOfAttack).getAttackName() + ":\n" + "Roll for hit: " + hit + "\nRoll for damage: " + damage, "Roll results:",
										JOptionPane.PLAIN_MESSAGE);
					}
					outputArea.setCaretPosition(outputArea.getText().length() - 1);
				} catch (Exception e) {
					javax.swing.JOptionPane.showMessageDialog(null, "Please input the hit bonus and damage in proper format.", "Warning!", javax.swing.JOptionPane.ERROR_MESSAGE);
				}
			}
		}

	}

	/*
	 * ==========================================================================
	 * ========================================
	 */

	public String[] updateList() {
		String[] updated = new String[combatants.size()];
		for (int c = 0; c < combatants.size(); c++)
			updated[c] = combatants.get(c).getCombatantName();
		return updated;
	}

	/*
	 * ==========================================================================
	 * ========================================
	 */

	public void takeDamage() {
		try {
			int dmg = (Integer) damageSpinner.getValue();
			int index = combatList.getSelectedIndex();
			if (dmg > 0 && index != -1) {
				combatants.get(index).setHealth(combatants.get(index).getHealth() - dmg);
				updateMonsterDisplay(index);
				outputArea.append(combatants.get(index).getName() + " loses " + dmg + " hp.\n");
			}
			if (dmg < 0 && index != -1) {
				combatants.get(index).setHealth(combatants.get(index).getHealth() - dmg);
				updateMonsterDisplay(index);
				outputArea.append(combatants.get(index).getName() + " recovers " + (-1 * dmg) + " hp.\n");
			}
			if (combatants.get(index).getHealth() <= 0) {
				combatants.get(index).setHealth(0);
				updateMonsterDisplay(index);
				outputArea.append(combatants.get(index).getName() + " has fallen in battle!\n");
				if (XPCheck.isSelected()) {
					outputArea.append("XP gained: " + combatants.get(index).getXP() + "\n");
					totalXP += combatants.get(index).getXP();
					XPArea.setText("Total XP Gained: " + totalXP);
				}
				outputArea.setCaretPosition(outputArea.getText().length() - 1);
				combatants.remove(index);

				setList();
			}
		} catch (Exception e) {
		}
	}

	public String[] updateAttacks(int index) {
		String[] updated = new String[combatants.get(index).getAttacks().size()];
		for (int c = 0; c < combatants.get(index).getAttacks().size(); c++)
			updated[c] = combatants.get(index).getAttacks().get(c).getAttackName();
		return updated;
	}

	/*
	 * ==========================================================================
	 * ========================================
	 */

	public void addMonster() {
		String input = addField.getText().toLowerCase();
		addField.setText("");
		int monsterCount = (Integer) numberMonsterSpinner.getValue();
		if (!charactersByName.containsKey(input)) {
			outputArea.append("\nSorry. Your entry of \"" + input + "\" was not found.\n");
			return;
		}

		Character libraryCharacter = charactersByName.get(input);

		for (int i = 1; i <= monsterCount; i++) {
			combatants.add(combatantForCharacter(libraryCharacter));
		}
		if (monsterCount > 1)
			outputArea.append(monsterCount + " " + libraryCharacter.getName() + "s have joined the battle!\n");
		else if (monsterCount == 1)
			outputArea.append(libraryCharacter.getCombatantName() + " has joined the battle!\n");

		initBtn.setEnabled(true);
		setList();
		numberMonsterSpinner.setValue(1);
	}

	// Creates and returns a new character given the current list of combatants.
	// This new combatant will have an appropriate duplicate count that will not
	// be equal to the duplicate count of any other existing combatant.
	private Character combatantForCharacter(Character character) {
		int characterDuplicateCount = 0;
		for (Character combatant : combatants) {
			if (combatant.getName().equals(character.getName())) {
				characterDuplicateCount = Math.max(characterDuplicateCount, combatant.getDuplicateCount() + 1);
			}
		}
		return new Character(character, characterDuplicateCount);
	}

	/*
	 * ==========================================================================
	 * ========================================
	 */

	public void sortInitiative() {
		int min;
		Character temp;
		for (int outer = 0; outer < combatants.size() - 1; outer++) {
			min = outer;
			for (int inner = outer + 1; inner < combatants.size(); inner++) {
				if (combatants.get(inner).getCurrentInitiative() > combatants.get(min).getCurrentInitiative()) {
					min = inner;
				}
			}
			temp = combatants.get(outer);
			combatants.set(outer, combatants.get(min));
			combatants.set(min, temp);
		}
	}

	/*
	 * ==========================================================================
	 * ========================================
	 */

	public void flushLib() {
		library.clear();
		charactersByName.clear();
	}

	private void updateCharacterInfoDisplayWithCharacter(Character character) {
		if (character == null) {
			infoArea.setText("");
			return;
		}

		infoArea.setText(character.infoText());
		infoArea.setCaretPosition(0);
	}

	/*
	 * ==========================================================================
	 * ========================================
	 */

	public void updateMonsterDisplay(int index) {
		updateCharacterInfoDisplayWithCharacter(combatants.get(index));
		healthBar.setMaximum(combatants.get(index).getMaxHealth());
		healthBar.setValue(combatants.get(index).getHealth());
		healthBar.setStringPainted(true);
		healthBar.setString(combatants.get(index).getHealth() + "/" + combatants.get(index).getMaxHealth());

		if (combatants.get(index).isStunned()) {
			stunnedToggle.setSelected(true);
			stunnedToggle.setFont(new java.awt.Font("Sylfaen", 1, 16));
			stunnedToggle.setForeground(new java.awt.Color(153, 0, 0));
		} else {
			stunnedToggle.setSelected(false);
			stunnedToggle.setFont(new java.awt.Font("Sylfaen", 0, 16));
			stunnedToggle.setForeground(new java.awt.Color(0, 0, 0));
		}

		if (combatants.get(index).isImmobilized()) {
			immobilizedToggle.setSelected(true);
			immobilizedToggle.setFont(new java.awt.Font("Sylfaen", 1, 16));
			immobilizedToggle.setForeground(new java.awt.Color(153, 0, 0));
		} else {
			immobilizedToggle.setSelected(false);
			immobilizedToggle.setFont(new java.awt.Font("Sylfaen", 0, 16));
			immobilizedToggle.setForeground(new java.awt.Color(0, 0, 0));
		}

		if (combatants.get(index).isProne()) {
			proneToggle.setSelected(true);
			proneToggle.setFont(new java.awt.Font("Sylfaen", 1, 16));
			proneToggle.setForeground(new java.awt.Color(153, 0, 0));
		} else {
			proneToggle.setSelected(false);
			proneToggle.setFont(new java.awt.Font("Sylfaen", 0, 16));
			proneToggle.setForeground(new java.awt.Color(0, 0, 0));
		}

		if (combatants.get(index).isRestrained()) {
			restrainedToggle.setSelected(true);
			restrainedToggle.setFont(new java.awt.Font("Sylfaen", 1, 16));
			restrainedToggle.setForeground(new java.awt.Color(153, 0, 0));
		} else {
			restrainedToggle.setSelected(false);
			restrainedToggle.setFont(new java.awt.Font("Sylfaen", 0, 16));
			restrainedToggle.setForeground(new java.awt.Color(0, 0, 0));
		}

		setAttacks(index);

	}

	/*
	 * ==========================================================================
	 * ========================================
	 */

	public void setList() {
		combatList.setModel(new javax.swing.AbstractListModel() {
			String[] names = updateList();

			public int getSize() {
				return names.length;
			}

			public Object getElementAt(int i) {
				return names[i];
			}
		});
	}

	public void setAttacks(final int index) {
		attackList.setModel(new javax.swing.AbstractListModel() {
			String[] names = updateAttacks(index);

			public int getSize() {
				return names.length;
			}

			public Object getElementAt(int i) {
				return names[i];
			}
		});
	}

	public static void main() {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			try {
				UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			} catch (Exception exception) {
			}
		}
		new DMFrame().setVisible(true);
	}

	/*
	 * ==========================================================================
	 * ========================================
	 */

	public static javax.swing.JFileChooser fc;
	public static ArrayList<Character> library;
	public static HashMap<String, Character> charactersByName;
	public static ArrayList<Character> combatants;
	public static String filename;
	public static int totalXP;
	public static javax.swing.JTextArea XPArea;
	public static javax.swing.JCheckBox XPCheck;
	public static javax.swing.JTextField addField;
	public static javax.swing.JButton clearBtn;
	public static javax.swing.JList<String> combatList;
	public static javax.swing.JButton createBtn;
	public static javax.swing.JSpinner damageSpinner;
	public static javax.swing.JButton dmgBtn;
	public static javax.swing.JProgressBar healthBar;
	public static javax.swing.JTextField healthField;
	private javax.swing.JTextField hpField;
	public static javax.swing.JTextArea infoArea;
	public static javax.swing.JButton initBtn;
	public static javax.swing.JTextField initField;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JScrollPane jScrollPane3;
	private javax.swing.JScrollPane jScrollPane4;
	private javax.swing.JSeparator jSeparator1;
	private javax.swing.JSeparator jSeparator2;
	public static javax.swing.JButton killBtn;
	public static javax.swing.JTextField levelField;
	public static javax.swing.JButton loadBtn;
	public static javax.swing.JTextField nameField;
	public static javax.swing.JSpinner numberMonsterSpinner;
	public static javax.swing.JToggleButton immobilizedToggle;
	public static javax.swing.JToggleButton stunnedToggle;
	public static javax.swing.JToggleButton proneToggle;
	public static javax.swing.JToggleButton restrainedToggle;
	public static javax.swing.JTextArea outputArea;
	public static File openfile;
	public static javax.swing.JTextField xpField;
	public static javax.swing.JButton encounterAdd;
	public static javax.swing.JList<String> attackList;
	public static javax.swing.JTextField hitField;
	public static javax.swing.JTextField damageField;
	public static javax.swing.JButton attackBtn;
	private javax.swing.JScrollPane jScrollPane5;
	private static final String ACTION_KEY = "theAction";
	public static javax.swing.JPanel newMonsterPanel;
	public static javax.swing.JTabbedPane outputTab;
	public static javax.swing.JList<Character> monsterCatalogList;

	private ArrayList<Character> monsterCatalogCharacters;
}
