package warscribe.ui;

//XML FILE PARSING
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;

import javax.swing.UIManager;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import warscribe.data.Attack;
import warscribe.data.Player;
import warscribe.data.Power;
import warscribe.data.Roller;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import org.json.*;

public class PlayerFrame extends javax.swing.JFrame {

	public PlayerFrame() {
		initComponents();
		setBounds(100, 100, 1047, 704);
		healthBar.setValue(0);
		disableAll();
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (dim.width - this.getSize().width) / 2;
		int y = (dim.height - this.getSize().height) / 2;
		this.setLocation(x, y);
	}

	private void initComponents() {
		// INTERNAL COMPONENTS
		characterFile = null;
		fc = new javax.swing.JFileChooser();
		player = null;
		characterFileName = "";
		selectedPower = null;
		selectedWeapon = null;

		// UI COMPONENTS
		characterLabel = new javax.swing.JLabel();
		healthPanel = new javax.swing.JPanel();
		healthBar = new javax.swing.JProgressBar();
		dmgBtn = new javax.swing.JButton();
		dmgSpinner = new javax.swing.JSpinner();
		healingSurgeBtn = new javax.swing.JButton();
		healingSurgeLabel = new javax.swing.JLabel();
		healthBtn = new javax.swing.JButton();
		healthField = new javax.swing.JTextField();
		CombatPanel = new javax.swing.JPanel();
		stunnedToggle = new javax.swing.JToggleButton();
		dazedToggle = new javax.swing.JToggleButton();
		immobilizedToggle = new javax.swing.JToggleButton();
		proneToggle = new javax.swing.JToggleButton();
		slowedToggle = new javax.swing.JToggleButton();
		markedToggle = new javax.swing.JToggleButton();
		bloodiedToggle = new javax.swing.JToggleButton();
		skillScrollPanel = new javax.swing.JScrollPane();
		skillPanel = new javax.swing.JPanel();
		acrobaticsBtn = new javax.swing.JButton();
		arcanaBtn = new javax.swing.JButton();
		athleticsBtn = new javax.swing.JButton();
		bluffBtn = new javax.swing.JButton();
		diplomacyBtn = new javax.swing.JButton();
		dungeoneeringBtn = new javax.swing.JButton();
		enduranceBtn = new javax.swing.JButton();
		healBtn = new javax.swing.JButton();
		historyBtn = new javax.swing.JButton();
		insightBtn = new javax.swing.JButton();
		intimidateBtn = new javax.swing.JButton();
		natureBtn = new javax.swing.JButton();
		perceptionBtn = new javax.swing.JButton();
		religionBtn = new javax.swing.JButton();
		stealthBtn = new javax.swing.JButton();
		streetwiseBtn = new javax.swing.JButton();
		thieveryBtn = new javax.swing.JButton();
		manageTabPanel = new javax.swing.JTabbedPane();
		managePanel = new javax.swing.JPanel();
		resetSurgeBtn = new javax.swing.JButton();
		loadBtn = new javax.swing.JButton();
		refreshBtn = new javax.swing.JButton();
		outputPane = new javax.swing.JScrollPane();
		output = new javax.swing.JTextArea();
		combatPane = new javax.swing.JTabbedPane();
		attackPanel = new javax.swing.JPanel();
		powerScroll = new javax.swing.JScrollPane();
		powerList = new javax.swing.JList();
		dmgField = new javax.swing.JTextField();
		hitField = new javax.swing.JTextField();
		rollBtn = new javax.swing.JButton();
		infoScroll = new javax.swing.JScrollPane();
		infoArea = new javax.swing.JTextArea();
		weaponListScroll = new javax.swing.JScrollPane();
		weaponList = new javax.swing.JList();
		XPPane = new javax.swing.JPanel();
		currentXPAreaScroll = new javax.swing.JScrollPane();
		currentXPArea = new javax.swing.JTextArea();
		addXPSpinner = new javax.swing.JSpinner();
		addXPBtn = new javax.swing.JButton();
		setXPField = new javax.swing.JTextField();
		setXPBtn = new javax.swing.JButton();
		sneakCheck = new javax.swing.JCheckBox();
		combatAdvCheck = new javax.swing.JCheckBox();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("WarScribe v2.0.5");
		setResizable(false);

		healthPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Health", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Sylfaen", 0, 13), new java.awt.Color(153, 0, 0))); // NOI18N

		healthBar.setFont(new java.awt.Font("Sylfaen", 0, 14)); // NOI18N
		healthBar.setString("Health: __ / __");
		healthBar.setStringPainted(true);

		dmgBtn.setFont(new java.awt.Font("Sylfaen", 0, 14));
		dmgBtn.setText("Take Damage");
		dmgBtn.setToolTipText("Automatically take x damage");
		dmgBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				dmgBtnActionPerformed(evt);
			}
		});

		dmgSpinner.setFont(new java.awt.Font("Sylfaen", 0, 14));

		healingSurgeBtn.setFont(new java.awt.Font("Sylfaen", 0, 14));
		healingSurgeBtn.setText("Use Healing Surge");
		healingSurgeBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				healingSurgeBtnActionPerformed(evt);
			}
		});

		healingSurgeLabel.setFont(new java.awt.Font("Sylfaen", 0, 14));
		healingSurgeLabel.setText("Healing Surges Remaining:");

		healthBtn.setFont(new java.awt.Font("Sylfaen", 0, 14));
		healthBtn.setText("Set Health");
		healthBtn.setToolTipText("Manually set your character's health");
		healthBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				healthBtnActionPerformed(evt);
			}
		});

		healthField.setFont(new java.awt.Font("Sylfaen", 0, 14));
		healthField.setText("0");
		healthField.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				healthFieldActionPerformed(evt);
			}
		});

		resetSurgeBtn.setFont(new java.awt.Font("Sylfaen", 0, 14));
		resetSurgeBtn.setText("Reset Surges");
		resetSurgeBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				resetSurgeBtnActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout healthPanelLayout = new javax.swing.GroupLayout(healthPanel);
		healthPanelLayout.setHorizontalGroup(
			healthPanelLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(healthPanelLayout.createSequentialGroup()
					.addGroup(healthPanelLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(healthPanelLayout.createSequentialGroup()
							.addGroup(healthPanelLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(healthField)
								.addComponent(dmgSpinner, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(healthPanelLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(healthBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(dmgBtn, GroupLayout.PREFERRED_SIZE, 125, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(healthPanelLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(healingSurgeBtn, GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
								.addComponent(healingSurgeLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(resetSurgeBtn, GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)))
						.addComponent(healthBar, GroupLayout.PREFERRED_SIZE, 421, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		healthPanelLayout.setVerticalGroup(
			healthPanelLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(healthPanelLayout.createSequentialGroup()
					.addGroup(healthPanelLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(healthPanelLayout.createSequentialGroup()
							.addGroup(healthPanelLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(dmgSpinner, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
								.addComponent(dmgBtn, GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE))
							.addGap(8)
							.addGroup(healthPanelLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(healthBtn, GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
								.addComponent(healthField, GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)))
						.addGroup(healthPanelLayout.createSequentialGroup()
							.addComponent(healingSurgeLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(healingSurgeBtn, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(resetSurgeBtn, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(healthBar, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
		);
		healthPanel.setLayout(healthPanelLayout);

		CombatPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Combat Status", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Sylfaen", 0, 13), new java.awt.Color(102, 0, 0))); // NOI18N

		stunnedToggle.setFont(new java.awt.Font("Sylfaen", 0, 14));
		stunnedToggle.setText("Stunned");
		stunnedToggle.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				stunnedToggleActionPerformed(evt);
			}
		});

		dazedToggle.setFont(new java.awt.Font("Sylfaen", 0, 14));
		dazedToggle.setText("Dazed");
		dazedToggle.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				dazedToggleActionPerformed(evt);
			}
		});

		immobilizedToggle.setFont(new java.awt.Font("Sylfaen", 0, 14));
		immobilizedToggle.setText("Immobilized");
		immobilizedToggle.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				immobilizedToggleActionPerformed(evt);
			}
		});

		proneToggle.setFont(new java.awt.Font("Sylfaen", 0, 14));
		proneToggle.setText("Prone");
		proneToggle.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				proneToggleActionPerformed(evt);
			}
		});

		slowedToggle.setFont(new java.awt.Font("Sylfaen", 0, 14));
		slowedToggle.setText("Slowed");
		slowedToggle.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				slowedToggleActionPerformed(evt);
			}
		});

		markedToggle.setFont(new java.awt.Font("Sylfaen", 0, 14));
		markedToggle.setText("Marked");
		markedToggle.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				markedToggleActionPerformed(evt);
			}
		});

		bloodiedToggle.setFont(new java.awt.Font("Sylfaen", 0, 14));
		bloodiedToggle.setText("Bloodied");
		bloodiedToggle.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				bloodiedToggleActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout CombatPanelLayout = new javax.swing.GroupLayout(CombatPanel);
		CombatPanel.setLayout(CombatPanelLayout);
		CombatPanelLayout.setHorizontalGroup(CombatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
						CombatPanelLayout.createSequentialGroup().addContainerGap().addGroup(
										CombatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(stunnedToggle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE).addComponent(dazedToggle,
														javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE).addComponent(immobilizedToggle, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE).addComponent(proneToggle, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
														.addComponent(slowedToggle, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE).addComponent(markedToggle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE).addComponent(
																		bloodiedToggle, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)).addContainerGap()));
		CombatPanelLayout.setVerticalGroup(CombatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
						CombatPanelLayout.createSequentialGroup().addContainerGap().addComponent(stunnedToggle, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(dazedToggle,
										javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(immobilizedToggle, javax.swing.GroupLayout.PREFERRED_SIZE, 38,
										javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(proneToggle, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(slowedToggle, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(
										markedToggle, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(bloodiedToggle, javax.swing.GroupLayout.PREFERRED_SIZE, 38,
										javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap(9, Short.MAX_VALUE)));

		skillScrollPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Skill Checks", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Sylfaen", 0, 14), new java.awt.Color(153, 153, 0))); // NOI18N
		skillScrollPanel.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		skillScrollPanel.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		skillScrollPanel.getVerticalScrollBar().setUnitIncrement(15);

		acrobaticsBtn.setFont(new java.awt.Font("Sylfaen", 0, 14));
		acrobaticsBtn.setText("Acrobatics +?");
		acrobaticsBtn.setToolTipText("Click to roll for a skill check.");
		acrobaticsBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				acrobaticsBtnActionPerformed(evt);
			}
		});

		arcanaBtn.setFont(new java.awt.Font("Sylfaen", 0, 14));
		arcanaBtn.setText("Arcana +?");
		arcanaBtn.setToolTipText("Click to roll for a skill check.");
		arcanaBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				arcanaBtnActionPerformed(evt);
			}
		});

		athleticsBtn.setFont(new java.awt.Font("Sylfaen", 0, 14));
		athleticsBtn.setText("Athletics +?");
		athleticsBtn.setToolTipText("Click to roll for a skill check.");
		athleticsBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				athleticsBtnActionPerformed(evt);
			}
		});

		bluffBtn.setFont(new java.awt.Font("Sylfaen", 0, 14));
		bluffBtn.setText("Bluff +?");
		bluffBtn.setToolTipText("Click to roll for a skill check.");
		bluffBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				bluffBtnActionPerformed(evt);
			}
		});

		diplomacyBtn.setFont(new java.awt.Font("Sylfaen", 0, 14));
		diplomacyBtn.setText("Diplomacy +?");
		diplomacyBtn.setToolTipText("Click to roll for a skill check.");
		diplomacyBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				diplomacyBtnActionPerformed(evt);
			}
		});

		dungeoneeringBtn.setFont(new java.awt.Font("Sylfaen", 0, 14));
		dungeoneeringBtn.setText("Dungeoneering +?");
		dungeoneeringBtn.setToolTipText("Click to roll for a skill check.");
		dungeoneeringBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				dungeoneeringBtnActionPerformed(evt);
			}
		});

		enduranceBtn.setFont(new java.awt.Font("Sylfaen", 0, 14));
		enduranceBtn.setText("Endurance +?");
		enduranceBtn.setToolTipText("Click to roll for a skill check.");
		enduranceBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				enduranceBtnActionPerformed(evt);
			}
		});

		healBtn.setFont(new java.awt.Font("Sylfaen", 0, 14));
		healBtn.setText("Heal +?");
		healBtn.setToolTipText("Click to roll for a skill check.");
		healBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				healBtnActionPerformed(evt);
			}
		});

		historyBtn.setFont(new java.awt.Font("Sylfaen", 0, 14));
		historyBtn.setText("History +?");
		historyBtn.setToolTipText("Click to roll for a skill check.");
		historyBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				historyBtnActionPerformed(evt);
			}
		});

		insightBtn.setFont(new java.awt.Font("Sylfaen", 0, 14));
		insightBtn.setText("Insight +?");
		insightBtn.setToolTipText("Click to roll for a skill check.");
		insightBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				insightBtnActionPerformed(evt);
			}
		});

		intimidateBtn.setFont(new java.awt.Font("Sylfaen", 0, 14));
		intimidateBtn.setText("Intimidate +?");
		intimidateBtn.setToolTipText("Click to roll for a skill check.");
		intimidateBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				intimidateBtnActionPerformed(evt);
			}
		});

		natureBtn.setFont(new java.awt.Font("Sylfaen", 0, 14));
		natureBtn.setText("Nature +?");
		natureBtn.setToolTipText("Click to roll for a skill check.");
		natureBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				natureBtnActionPerformed(evt);
			}
		});

		perceptionBtn.setFont(new java.awt.Font("Sylfaen", 0, 14));
		perceptionBtn.setText("Perception +?");
		perceptionBtn.setToolTipText("Click to roll for a skill check.");
		perceptionBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				perceptionBtnActionPerformed(evt);
			}
		});

		religionBtn.setFont(new java.awt.Font("Sylfaen", 0, 14));
		religionBtn.setText("Religion +?");
		religionBtn.setToolTipText("Click to roll for a skill check.");
		religionBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				religionBtnActionPerformed(evt);
			}
		});

		stealthBtn.setFont(new java.awt.Font("Sylfaen", 0, 14));
		stealthBtn.setText("Stealth +?");
		stealthBtn.setToolTipText("Click to roll for a skill check.");
		stealthBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				stealthBtnActionPerformed(evt);
			}
		});

		streetwiseBtn.setFont(new java.awt.Font("Sylfaen", 0, 14));
		streetwiseBtn.setText("Streetwise +?");
		streetwiseBtn.setToolTipText("Click to roll for a skill check.");
		streetwiseBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				streetwiseBtnActionPerformed(evt);
			}
		});

		thieveryBtn.setFont(new java.awt.Font("Sylfaen", 0, 14));
		thieveryBtn.setText("Thievery +?");
		thieveryBtn.setToolTipText("Click to roll for a skill check.");
		thieveryBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				thieveryBtnActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout skillPanelLayout = new javax.swing.GroupLayout(skillPanel);
		skillPanel.setLayout(skillPanelLayout);
		skillPanelLayout.setHorizontalGroup(skillPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
						skillPanelLayout.createSequentialGroup().addContainerGap().addGroup(
										skillPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false).addComponent(arcanaBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(acrobaticsBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE).addComponent(diplomacyBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
																		Short.MAX_VALUE).addComponent(bluffBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(athleticsBtn, javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(healBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(dungeoneeringBtn,
																		javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(enduranceBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(
																		historyBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(insightBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(intimidateBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(natureBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(perceptionBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(religionBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(stealthBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(streetwiseBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(thieveryBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)).addContainerGap(34, Short.MAX_VALUE)));
		skillPanelLayout.setVerticalGroup(skillPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
						skillPanelLayout.createSequentialGroup().addContainerGap().addComponent(acrobaticsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(arcanaBtn,
										javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(athleticsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
										javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(bluffBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(diplomacyBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(
										dungeoneeringBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(enduranceBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
										javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(healBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(historyBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(insightBtn,
										javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(intimidateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
										javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(natureBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(perceptionBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(religionBtn,
										javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(stealthBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(streetwiseBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
														javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(thieveryBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap(12,
														Short.MAX_VALUE)));

		skillScrollPanel.setViewportView(skillPanel);

		manageTabPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

		managePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Manage File", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Sylfaen", 0, 14))); // NOI18N

		loadBtn.setFont(new java.awt.Font("Sylfaen", 0, 14));
		loadBtn.setText("Load Character (.dnd4e file)");
		loadBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				loadBtnActionPerformed(evt);
			}
		});

		refreshBtn.setFont(new java.awt.Font("Sylfaen", 0, 14));
		refreshBtn.setText("Refresh Character");
		refreshBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				refreshBtnActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout managePanelLayout = new javax.swing.GroupLayout(managePanel);
		managePanelLayout.setHorizontalGroup(
			managePanelLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(managePanelLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(managePanelLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(loadBtn, GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
						.addComponent(refreshBtn, GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE))
					.addContainerGap())
		);
		managePanelLayout.setVerticalGroup(
			managePanelLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(managePanelLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(loadBtn, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(refreshBtn, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(40, Short.MAX_VALUE))
		);
		managePanel.setLayout(managePanelLayout);

		manageTabPanel.addTab("Manage", managePanel);

		output.setColumns(20);
		output.setFont(new java.awt.Font("Sylfaen", 0, 14));
		output.setRows(5);
		output.setText("Load a character file (.dnd4e) to begin.");
		output.setBorder(javax.swing.BorderFactory.createTitledBorder("Event History"));
		outputPane.setViewportView(output);
		output.setEditable(false);

		manageTabPanel.addTab("Output", outputPane);

		attackPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Attacks", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Sylfaen", 0, 14), new java.awt.Color(255, 51, 0))); // NOI18N

		powerList.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Powers", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Sylfaen", 0, 14), new java.awt.Color(0, 102, 204))); // NOI18N
		powerList.setFont(new java.awt.Font("Sylfaen", 0, 16)); // NOI18N
		powerList.setModel(new javax.swing.AbstractListModel() {
			String[] strings = {};

			public int getSize() {
				return strings.length;
			}

			public Object getElementAt(int i) {
				return strings[i];
			}
		});
		powerList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
			public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
				powerListValueChanged(evt);
			}
		});
		powerScroll.setViewportView(powerList);
		powerScroll.getVerticalScrollBar().setUnitIncrement(10);

		dmgField.setFont(new java.awt.Font("Sylfaen", 0, 14));
		dmgField.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				dmgFieldActionPerformed(evt);
			}
		});

		hitField.setFont(new java.awt.Font("Sylfaen", 0, 14));
		hitField.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				hitFieldActionPerformed(evt);
			}
		});

		rollBtn.setFont(new java.awt.Font("Sylfaen", 0, 14));
		rollBtn.setText("Roll!");
		rollBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				rollBtnActionPerformed(evt);
			}
		});

		infoArea.setColumns(20);
		infoArea.setEditable(false);
		infoArea.setFont(new java.awt.Font("Sylfaen", 0, 13));
		infoArea.setLineWrap(true);
		infoArea.setRows(5);
		infoArea.setTabSize(4);
		infoArea.setText("Usage:\nType:\nOffensive Stat:\nDefensive Stat:");
		infoArea.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Sylfaen", 0, 14))); // NOI18N
		infoScroll.setViewportView(infoArea);
		infoScroll.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

		weaponList.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Weapons", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Sylfaen", 0, 14), new java.awt.Color(0, 102, 204))); // NOI18N
		weaponList.setFont(new java.awt.Font("Sylfaen", 0, 16)); // NOI18N
		weaponList.setModel(new javax.swing.AbstractListModel() {
			String[] strings = {};

			public int getSize() {
				return strings.length;
			}

			public Object getElementAt(int i) {
				return strings[i];
			}
		});
		weaponList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
			public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
				weaponListValueChanged(evt);
			}
		});
		weaponListScroll.setViewportView(weaponList);

		sneakCheck.setText("Sneak Attack");
		sneakCheck.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				sneakCheckActionPerformed(evt);
			}
		});

		combatAdvCheck.setText("Combat Adv.");
		combatAdvCheck.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				combatAdvCheckActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout attackPanelLayout = new javax.swing.GroupLayout(attackPanel);
		attackPanelLayout.setHorizontalGroup(
			attackPanelLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(attackPanelLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(attackPanelLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(attackPanelLayout.createSequentialGroup()
							.addGroup(attackPanelLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(attackPanelLayout.createSequentialGroup()
									.addComponent(hitField, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(dmgField, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE))
								.addComponent(rollBtn, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(attackPanelLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(combatAdvCheck)
								.addComponent(sneakCheck)))
						.addComponent(powerScroll, GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(attackPanelLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(infoScroll, 0, 0, Short.MAX_VALUE)
						.addComponent(weaponListScroll, GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE))
					.addGap(38))
		);
		attackPanelLayout.setVerticalGroup(
			attackPanelLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(attackPanelLayout.createSequentialGroup()
					.addGroup(attackPanelLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(attackPanelLayout.createSequentialGroup()
							.addComponent(weaponListScroll, GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(infoScroll, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE))
						.addGroup(attackPanelLayout.createSequentialGroup()
							.addComponent(powerScroll, GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(attackPanelLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(dmgField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(sneakCheck)
								.addComponent(hitField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(attackPanelLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(combatAdvCheck)
								.addComponent(rollBtn, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap())
		);
		attackPanel.setLayout(attackPanelLayout);

		combatPane.addTab("Combat", attackPanel);

		XPPane.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Experience Calculator", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Sylfaen", 0, 14), new java.awt.Color(0, 153, 51))); // NOI18N

		currentXPArea.setColumns(20);
		currentXPArea.setEditable(false);
		currentXPArea.setFont(new java.awt.Font("Sylfaen", 0, 18));
		currentXPArea.setRows(3);
		currentXPArea.setText("\nCurrent Experience:\n");
		currentXPAreaScroll.setViewportView(currentXPArea);

		addXPSpinner.setFont(new java.awt.Font("Sylfaen", 0, 14));

		addXPBtn.setFont(new java.awt.Font("Sylfaen", 0, 14));
		addXPBtn.setText("Add experience");
		addXPBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				addXPBtnActionPerformed(evt);
			}
		});

		setXPField.setFont(new java.awt.Font("Sylfaen", 0, 14));
		setXPField.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				setXPFieldActionPerformed(evt);
			}
		});

		setXPBtn.setFont(new java.awt.Font("Sylfaen", 0, 14));
		setXPBtn.setText("Set experience");
		setXPBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				setXPBtnActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout XPPaneLayout = new javax.swing.GroupLayout(XPPane);
		XPPane.setLayout(XPPaneLayout);
		XPPaneLayout.setHorizontalGroup(XPPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						XPPaneLayout.createSequentialGroup().addContainerGap().addGroup(
										XPPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(addXPSpinner, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE).addComponent(currentXPAreaScroll,
														javax.swing.GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE).addComponent(setXPBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE).addComponent(setXPField,
														javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE).addComponent(addXPBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE))
										.addContainerGap()));
		XPPaneLayout.setVerticalGroup(XPPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
						XPPaneLayout.createSequentialGroup().addContainerGap().addComponent(addXPSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(addXPBtn,
										javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(currentXPAreaScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 96,
										javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(setXPField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(setXPBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE).addContainerGap()));

		combatPane.addTab("Experience", XPPane);

		characterLabel.setFont(new java.awt.Font("Sylfaen", 3, 24)); // NOI18N
		characterLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.TRAILING)
				.addGroup(layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addComponent(characterLabel, GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
						.addGroup(layout.createSequentialGroup()
							.addComponent(CombatPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(skillScrollPanel, GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE))
						.addComponent(healthPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addComponent(combatPane, GroupLayout.PREFERRED_SIZE, 553, GroupLayout.PREFERRED_SIZE)
						.addComponent(manageTabPanel, GroupLayout.PREFERRED_SIZE, 543, GroupLayout.PREFERRED_SIZE))
					.addGap(12))
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.TRAILING)
				.addGroup(layout.createSequentialGroup()
					.addContainerGap()
					.addComponent(characterLabel, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(layout.createSequentialGroup()
							.addComponent(combatPane, GroupLayout.PREFERRED_SIZE, 367, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(manageTabPanel, 0, 0, Short.MAX_VALUE))
						.addGroup(layout.createSequentialGroup()
							.addComponent(healthPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(layout.createParallelGroup(Alignment.LEADING)
								.addComponent(skillScrollPanel, GroupLayout.PREFERRED_SIZE, 387, GroupLayout.PREFERRED_SIZE)
								.addComponent(CombatPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap())
		);
		getContentPane().setLayout(layout);

		pack();
	}

	private void healthFieldActionPerformed(java.awt.event.ActionEvent evt) {
		player.setHealth(Integer.parseInt(healthField.getText()));
		updateUI();
	}

	private void healthBtnActionPerformed(java.awt.event.ActionEvent evt) {
		player.setHealth(Integer.parseInt(healthField.getText()));
		updateUI();
	}

	private void dmgBtnActionPerformed(java.awt.event.ActionEvent evt) {
		player.takeDamage((Integer) dmgSpinner.getValue());
		updateUI();
	}

	private void setXPBtnActionPerformed(java.awt.event.ActionEvent evt) {
		player.setXP(Integer.parseInt(setXPField.getText()));
		updateUI();
	}

	private void rollBtnActionPerformed(java.awt.event.ActionEvent evt) {
		if (selectedWeapon != null && selectedPower != null) {
			int hit = Integer.parseInt(hitField.getText().trim());
			String attack = dmgField.getText().trim();
			int hitResult = Roller.roll("1d20+" + hit);
			int dmgResult;
			output.append("\n=============ATTACK=============\n");
			if (hitResult - hit == 20) {
				String hitResult_ = "CRITICAL SUCCESS";
				output.append(selectedPower.getName() + " (" + selectedWeapon.getName() + "):\n");
				output.append("    Attack roll: " + hitResult_ + "\n");
				dmgResult = Roller.roll(attack);
				dmgResult += Roller.roll(attack);
				output.append("    Damage roll (x2): " + dmgResult + "\n");
				javax.swing.JOptionPane.showMessageDialog(null, "    Attack roll: " + hitResult_ + "\n" + "    Damage roll: " + dmgResult + "\n", "Attack Roll", javax.swing.JOptionPane.INFORMATION_MESSAGE);
			} else if (hitResult - hit == 1) {
				String hitResult_ = "CRITICAL FAILURE";
				output.append(selectedPower.getName() + " (" + selectedWeapon.getName() + "):\n");
				output.append("    Attack roll: " + hitResult_ + "\n");
				dmgResult = 0;
				output.append("    Damage roll: " + dmgResult + "\n");
				javax.swing.JOptionPane.showMessageDialog(null, "    Attack roll: " + hitResult_ + "\n" + "    Damage roll: " + dmgResult + "\n", "Attack Roll", javax.swing.JOptionPane.INFORMATION_MESSAGE);
			} else {
				String hitResult_ = new Integer(hitResult).toString();
				;
				output.append(selectedPower.getName() + " (" + selectedWeapon.getName() + "):\n");
				output.append("    Attack roll: " + hitResult_ + "\n");
				dmgResult = Roller.roll(attack);
				output.append("    Damage roll: " + dmgResult + "\n");
				javax.swing.JOptionPane.showMessageDialog(null, "    Attack roll: " + hitResult_ + "\n" + "    Damage roll: " + dmgResult + "\n", "Attack Roll", javax.swing.JOptionPane.INFORMATION_MESSAGE);
			}
			output.setCaretPosition(output.getText().length() - 1);
		}
	}

	private void dmgFieldActionPerformed(java.awt.event.ActionEvent evt) {
		if (selectedWeapon != null && selectedPower != null) {
			int hit = Integer.parseInt(hitField.getText().trim());
			String attack = dmgField.getText().trim();
			int hitResult = Roller.roll("1d20+" + hit);
			int dmgResult;
			output.append("\n=============ATTACK=============\n");
			if (hitResult - hit == 20) {
				String hitResult_ = "CRITICAL SUCCESS";
				output.append(selectedPower.getName() + " (" + selectedWeapon.getName() + "):\n");
				output.append("    Attack roll: " + hitResult_ + "\n");
				dmgResult = Roller.roll(attack);
				dmgResult += Roller.roll(attack);
				output.append("    Damage roll (x2): " + dmgResult + "\n");
				javax.swing.JOptionPane.showMessageDialog(null, "    Attack roll: " + hitResult_ + "\n" + "    Damage roll: " + dmgResult + "\n", "Attack Roll", javax.swing.JOptionPane.INFORMATION_MESSAGE);
			} else if (hitResult - hit == 1) {
				String hitResult_ = "CRITICAL FAILURE";
				output.append(selectedPower.getName() + " (" + selectedWeapon.getName() + "):\n");
				output.append("    Attack roll: " + hitResult_ + "\n");
				dmgResult = 0;
				output.append("    Damage roll: " + dmgResult + "\n");
				javax.swing.JOptionPane.showMessageDialog(null, "    Attack roll: " + hitResult_ + "\n" + "    Damage roll: " + dmgResult + "\n", "Attack Roll", javax.swing.JOptionPane.INFORMATION_MESSAGE);
			} else {
				String hitResult_ = new Integer(hitResult).toString();
				;
				output.append(selectedPower.getName() + " (" + selectedWeapon.getName() + "):\n");
				output.append("    Attack roll: " + hitResult_ + "\n");
				dmgResult = Roller.roll(attack);
				output.append("    Damage roll: " + dmgResult + "\n");
				javax.swing.JOptionPane.showMessageDialog(null, "    Attack roll: " + hitResult_ + "\n" + "    Damage roll: " + dmgResult + "\n", "Attack Roll", javax.swing.JOptionPane.INFORMATION_MESSAGE);
			}
			output.setCaretPosition(output.getText().length() - 1);
		}
	}

	private void hitFieldActionPerformed(java.awt.event.ActionEvent evt) {
		if (selectedWeapon != null && selectedPower != null) {
			int hit = Integer.parseInt(hitField.getText().trim());
			String attack = dmgField.getText().trim();
			int hitResult = Roller.roll("1d20+" + hit);
			int dmgResult;
			output.append("\n=============ATTACK=============\n");
			if (hitResult - hit == 20) {
				String hitResult_ = "CRITICAL SUCCESS";
				output.append(selectedPower.getName() + " (" + selectedWeapon.getName() + "):\n");
				output.append("    Attack roll: " + hitResult_ + "\n");
				dmgResult = Roller.roll(attack);
				dmgResult += Roller.roll(attack);
				output.append("    Damage roll (x2): " + dmgResult + "\n");
				javax.swing.JOptionPane.showMessageDialog(null, "    Attack roll: " + hitResult_ + "\n" + "    Damage roll: " + dmgResult + "\n", "Attack Roll", javax.swing.JOptionPane.INFORMATION_MESSAGE);
			} else if (hitResult - hit == 1) {
				String hitResult_ = "CRITICAL FAILURE";
				output.append(selectedPower.getName() + " (" + selectedWeapon.getName() + "):\n");
				output.append("    Attack roll: " + hitResult_ + "\n");
				dmgResult = 0;
				output.append("    Damage roll: " + dmgResult + "\n");
				javax.swing.JOptionPane.showMessageDialog(null, "    Attack roll: " + hitResult_ + "\n" + "    Damage roll: " + dmgResult + "\n", "Attack Roll", javax.swing.JOptionPane.INFORMATION_MESSAGE);
			} else {
				String hitResult_ = new Integer(hitResult).toString();
				;
				output.append(selectedPower.getName() + " (" + selectedWeapon.getName() + "):\n");
				output.append("    Attack roll: " + hitResult_ + "\n");
				dmgResult = Roller.roll(attack);
				output.append("    Damage roll: " + dmgResult + "\n");
				javax.swing.JOptionPane.showMessageDialog(null, "    Attack roll: " + hitResult_ + "\n" + "    Damage roll: " + dmgResult + "\n", "Attack Roll", javax.swing.JOptionPane.INFORMATION_MESSAGE);
			}
			output.setCaretPosition(output.getText().length() - 1);
		}
	}

	private void weaponListValueChanged(javax.swing.event.ListSelectionEvent evt) {
		if (weaponList.getSelectedIndex() != -1) {
			selectedWeapon = selectedPower.getWeapons().get(weaponList.getSelectedIndex());
		}
		updateInfo();
		weaponList.setSelectedIndex(weaponList.getSelectedIndex());
	}

	private void powerListValueChanged(javax.swing.event.ListSelectionEvent evt) {
		if (powerList.getSelectedIndex() != -1) {
			selectedPower = player.getPowers().get(powerList.getSelectedIndex());
			if (selectedPower.getNumWeapons() > 0)
				weaponList.setSelectedIndex(0);
			else
				selectedWeapon = null;
		}
		updateWeapons();
		updateInfo();
	}

	private void loadBtnActionPerformed(java.awt.event.ActionEvent evt) {
		parseCharacterFile();
		manageTabPanel.setSelectedIndex(1);
	}

	private void refreshBtnActionPerformed(java.awt.event.ActionEvent evt) {
		selectedWeapon = null;
		selectedPower = null;
		player = null;
		try {
			String name_ = "<Missing Name>";
			int level_ = -1;
			int experience_ = -1;
			int maxHealth_ = -1;
			String initiative_ = "1d20+0";
			int[] stats_ = new int[23];
			int healingSurges_ = -1;
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(characterFile);
			doc.getDocumentElement().normalize();

			NodeList details = doc.getElementsByTagName("Details");
			Node detailsNode = details.item(0);
			if (detailsNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) detailsNode;

				name_ = getTagValue("name", eElement, 1).trim();
				level_ = Integer.parseInt(getTagValue("Level", eElement, 1).trim());
				experience_ = Integer.parseInt(getTagValue("Experience", eElement, 1).trim());
				characterLabel.setText(name_ + " (Level " + level_ + ")");
			}

			NodeList stat = doc.getElementsByTagName("Stat");
			for (int temp = 0; temp < stat.getLength(); temp++) {

				Node statNode = stat.item(temp);
				if (statNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) statNode;
					String n = eElement.getAttribute("name").trim();
					int v = Integer.parseInt(eElement.getAttribute("value").trim());
					if (n.compareTo("Hit Points") == 0) {
						maxHealth_ = new Integer(v);
					} else if (n.compareTo("Healing Surges") == 0) {
						healingSurges_ = new Integer(v);
					} else if (n.compareTo("Initiative") == 0) {
						initiative_ = "1d20+" + (new Integer(v)).toString();
					} else {
						stats_ = parseStat(n, v, stats_);
					}
				}
			}

			player = new Player(name_, level_, experience_, maxHealth_, initiative_, stats_, healingSurges_);

			NodeList powerstats = doc.getElementsByTagName("Power");
			for (int temp = 0; temp < powerstats.getLength(); temp++) {

				String powername_ = "<No name>";
				String powerUsage_ = "<?>";
				String actionType_ = "<?>";

				Node powerNode = powerstats.item(temp);
				if (powerNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) powerNode;
					powername_ = new String(eElement.getAttribute("name").trim());
					powerUsage_ = getTagValue("specific", eElement, 1).trim();
					actionType_ = getTagValue("specific", eElement, 2).trim();

					Power p = new Power(powername_, powerUsage_, actionType_);

					NodeList weapons = doc.getElementsByTagName("Weapon");
					for (int loop = 0; loop < weapons.getLength(); loop++) {

						String attackname_ = "";
						int hitmod_ = 0;
						String damage_ = "";
						String offensive_ = "";
						String defensive_ = "";

						Node weaponNode = weapons.item(loop);
						if (weaponNode.getParentNode() == eElement) {
							Element e = (Element) weaponNode;
							attackname_ = new String(e.getAttribute("name").trim());
							attackname_ = attackname_.replaceAll("&apos;", "'");
							hitmod_ = Integer.parseInt(new String(getTagValue("AttackBonus", e, 1).trim()));
							damage_ = new String(getTagValue("Damage", e, 1).trim());
							damage_ = damage_.replaceAll("-", "+-");
							offensive_ = new String(getTagValue("AttackStat", e, 1).trim());
							defensive_ = new String(getTagValue("Defense", e, 1).trim());
							Attack w = new Attack(attackname_, hitmod_, damage_);
							w.setOffensive(offensive_);
							w.setDefensive(defensive_);
							p.addWeapon(w);
						}
					}
					player.addPower(p);
				}
			}
			enableAll();
			updateUI();

			output.setText("");
			output.append("Loaded character: " + player.getName() + " from " + characterFileName + "\n");
			output.setCaretPosition(output.getText().length() - 1);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void acrobaticsBtnActionPerformed(java.awt.event.ActionEvent evt) {
		int roll = Roller.roll("1d20+" + player.getAcrobatics());
		String result;
		if (roll - player.getAcrobatics() == 20)
			result = "CRITICAL SUCCESS";
		else if (roll - player.getAcrobatics() == 1)
			result = "CRITICAL FAILURE";
		else
			result = new Integer(roll).toString();
		javax.swing.JOptionPane.showMessageDialog(null, "Acrobatics roll: " + result, "Roll Result", javax.swing.JOptionPane.INFORMATION_MESSAGE);
		output.append("\n==========SKILL CHECK==========\n");
		output.append("Acrobatics roll: " + result + "\n");
		output.setCaretPosition(output.getText().length() - 1);
	}

	private void arcanaBtnActionPerformed(java.awt.event.ActionEvent evt) {
		int roll = Roller.roll("1d20+" + player.getArcana());
		String result;
		if (roll - player.getArcana() == 20)
			result = "CRITICAL SUCCESS";
		else if (roll - player.getArcana() == 1)
			result = "CRITICAL FAILURE";
		else
			result = new Integer(roll).toString();
		javax.swing.JOptionPane.showMessageDialog(null, "Arcana roll: " + result, "Roll Result", javax.swing.JOptionPane.INFORMATION_MESSAGE);
		output.append("\n==========SKILL CHECK==========\n");
		output.append("Arcana roll: " + result + "\n");
		output.setCaretPosition(output.getText().length() - 1);
	}

	private void athleticsBtnActionPerformed(java.awt.event.ActionEvent evt) {
		int roll = Roller.roll("1d20+" + player.getAthletics());
		String result;
		if (roll - player.getAthletics() == 20)
			result = "CRITICAL SUCCESS";
		else if (roll - player.getAthletics() == 1)
			result = "CRITICAL FAILURE";
		else
			result = new Integer(roll).toString();
		javax.swing.JOptionPane.showMessageDialog(null, "Athletics roll: " + result, "Roll Result", javax.swing.JOptionPane.INFORMATION_MESSAGE);
		output.append("\n==========SKILL CHECK==========\n");
		output.append("Athletics roll: " + result + "\n");
		output.setCaretPosition(output.getText().length() - 1);
	}

	private void bluffBtnActionPerformed(java.awt.event.ActionEvent evt) {
		int roll = Roller.roll("1d20+" + player.getBluff());
		String result;
		if (roll - player.getBluff() == 20)
			result = "CRITICAL SUCCESS";
		else if (roll - player.getBluff() == 1)
			result = "CRITICAL FAILURE";
		else
			result = new Integer(roll).toString();
		javax.swing.JOptionPane.showMessageDialog(null, "Bluff roll: " + result, "Roll Result", javax.swing.JOptionPane.INFORMATION_MESSAGE);
		output.append("\n==========SKILL CHECK==========\n");
		output.append("Bluff roll: " + result + "\n");
		output.setCaretPosition(output.getText().length() - 1);
	}

	private void diplomacyBtnActionPerformed(java.awt.event.ActionEvent evt) {
		int roll = Roller.roll("1d20+" + player.getDiplomacy());
		String result;
		if (roll - player.getDiplomacy() == 20)
			result = "CRITICAL SUCCESS";
		else if (roll - player.getDiplomacy() == 1)
			result = "CRITICAL FAILURE";
		else
			result = new Integer(roll).toString();
		javax.swing.JOptionPane.showMessageDialog(null, "Diplomacy roll: " + result, "Roll Result", javax.swing.JOptionPane.INFORMATION_MESSAGE);
		output.append("\n==========SKILL CHECK==========\n");
		output.append("Diplomacy roll: " + result + "\n");
		output.setCaretPosition(output.getText().length() - 1);
	}

	private void dungeoneeringBtnActionPerformed(java.awt.event.ActionEvent evt) {
		int roll = Roller.roll("1d20+" + player.getDungeoneering());
		String result;
		if (roll - player.getDungeoneering() == 20)
			result = "CRITICAL SUCCESS";
		else if (roll - player.getDungeoneering() == 1)
			result = "CRITICAL FAILURE";
		else
			result = new Integer(roll).toString();
		javax.swing.JOptionPane.showMessageDialog(null, "Dungeoneering roll: " + result, "Roll Result", javax.swing.JOptionPane.INFORMATION_MESSAGE);
		output.append("\n==========SKILL CHECK==========\n");
		output.append("Dungeoneering roll: " + result + "\n");
		output.setCaretPosition(output.getText().length() - 1);
	}

	private void enduranceBtnActionPerformed(java.awt.event.ActionEvent evt) {
		int roll = Roller.roll("1d20+" + player.getEndurance());
		String result;
		if (roll - player.getEndurance() == 20)
			result = "CRITICAL SUCCESS";
		else if (roll - player.getEndurance() == 1)
			result = "CRITICAL FAILURE";
		else
			result = new Integer(roll).toString();
		javax.swing.JOptionPane.showMessageDialog(null, "Endurance roll: " + result, "Roll Result", javax.swing.JOptionPane.INFORMATION_MESSAGE);
		output.append("\n==========SKILL CHECK==========\n");
		output.append("Endurance roll: " + result + "\n");
		output.setCaretPosition(output.getText().length() - 1);
	}

	private void healBtnActionPerformed(java.awt.event.ActionEvent evt) {
		int roll = Roller.roll("1d20+" + player.getHeal());
		String result;
		if (roll - player.getHeal() == 20)
			result = "CRITICAL SUCCESS";
		else if (roll - player.getHeal() == 1)
			result = "CRITICAL FAILURE";
		else
			result = new Integer(roll).toString();
		javax.swing.JOptionPane.showMessageDialog(null, "Heal roll: " + result, "Roll Result", javax.swing.JOptionPane.INFORMATION_MESSAGE);
		output.append("\n==========SKILL CHECK==========\n");
		output.append("Heal roll: " + result + "\n");
		output.setCaretPosition(output.getText().length() - 1);
	}

	private void historyBtnActionPerformed(java.awt.event.ActionEvent evt) {
		int roll = Roller.roll("1d20+" + player.getHistory());
		String result;
		if (roll - player.getHistory() == 20)
			result = "CRITICAL SUCCESS";
		else if (roll - player.getHistory() == 1)
			result = "CRITICAL FAILURE";
		else
			result = new Integer(roll).toString();
		javax.swing.JOptionPane.showMessageDialog(null, "History roll: " + result, "Roll Result", javax.swing.JOptionPane.INFORMATION_MESSAGE);
		output.append("\n==========SKILL CHECK==========\n");
		output.append("History roll: " + result + "\n");
		output.setCaretPosition(output.getText().length() - 1);
	}

	private void insightBtnActionPerformed(java.awt.event.ActionEvent evt) {
		int roll = Roller.roll("1d20+" + player.getInsight());
		String result;
		if (roll - player.getInsight() == 20)
			result = "CRITICAL SUCCESS";
		else if (roll - player.getInsight() == 1)
			result = "CRITICAL FAILURE";
		else
			result = new Integer(roll).toString();
		javax.swing.JOptionPane.showMessageDialog(null, "Insight roll: " + result, "Roll Result", javax.swing.JOptionPane.INFORMATION_MESSAGE);
		output.append("\n==========SKILL CHECK==========\n");
		output.append("Insight roll: " + result + "\n");
		output.setCaretPosition(output.getText().length() - 1);
	}

	private void natureBtnActionPerformed(java.awt.event.ActionEvent evt) {
		int roll = Roller.roll("1d20+" + player.getNature());
		String result;
		if (roll - player.getNature() == 20)
			result = "CRITICAL SUCCESS";
		else if (roll - player.getNature() == 1)
			result = "CRITICAL FAILURE";
		else
			result = new Integer(roll).toString();
		javax.swing.JOptionPane.showMessageDialog(null, "Nature roll: " + result, "Roll Result", javax.swing.JOptionPane.INFORMATION_MESSAGE);
		output.append("\n==========SKILL CHECK==========\n");
		output.append("Nature roll: " + result + "\n");
		output.setCaretPosition(output.getText().length() - 1);
	}

	private void intimidateBtnActionPerformed(java.awt.event.ActionEvent evt) {
		int roll = Roller.roll("1d20+" + player.getIntimidate());
		String result;
		if (roll - player.getIntimidate() == 20)
			result = "CRITICAL SUCCESS";
		else if (roll - player.getIntimidate() == 1)
			result = "CRITICAL FAILURE";
		else
			result = new Integer(roll).toString();
		javax.swing.JOptionPane.showMessageDialog(null, "Intimidate roll: " + result, "Roll Result", javax.swing.JOptionPane.INFORMATION_MESSAGE);
		output.append("\n==========SKILL CHECK==========\n");
		output.append("Intimidate roll: " + result + "\n");
		output.setCaretPosition(output.getText().length() - 1);
	}

	private void perceptionBtnActionPerformed(java.awt.event.ActionEvent evt) {
		int roll = Roller.roll("1d20+" + player.getPerception());
		String result;
		if (roll - player.getPerception() == 20)
			result = "CRITICAL SUCCESS";
		else if (roll - player.getPerception() == 1)
			result = "CRITICAL FAILURE";
		else
			result = new Integer(roll).toString();
		javax.swing.JOptionPane.showMessageDialog(null, "Perception roll: " + result, "Roll Result", javax.swing.JOptionPane.INFORMATION_MESSAGE);
		output.append("\n==========SKILL CHECK==========\n");
		output.append("Perception roll: " + result + "\n");
		output.setCaretPosition(output.getText().length() - 1);
	}

	private void religionBtnActionPerformed(java.awt.event.ActionEvent evt) {
		int roll = Roller.roll("1d20+" + player.getReligion());
		String result;
		if (roll - player.getReligion() == 20)
			result = "CRITICAL SUCCESS";
		else if (roll - player.getReligion() == 1)
			result = "CRITICAL FAILURE";
		else
			result = new Integer(roll).toString();
		javax.swing.JOptionPane.showMessageDialog(null, "Religion roll: " + result, "Roll Result", javax.swing.JOptionPane.INFORMATION_MESSAGE);
		output.append("\n==========SKILL CHECK==========\n");
		output.append("Religion roll: " + result + "\n");
		output.setCaretPosition(output.getText().length() - 1);
	}

	private void stealthBtnActionPerformed(java.awt.event.ActionEvent evt) {
		int roll = Roller.roll("1d20+" + player.getStealth());
		String result;
		if (roll - player.getStealth() == 20)
			result = "CRITICAL SUCCESS";
		else if (roll - player.getStealth() == 1)
			result = "CRITICAL FAILURE";
		else
			result = new Integer(roll).toString();
		javax.swing.JOptionPane.showMessageDialog(null, "Stealth roll: " + result, "Roll Result", javax.swing.JOptionPane.INFORMATION_MESSAGE);
		output.append("\n==========SKILL CHECK==========\n");
		output.append("Stealth roll: " + result + "\n");
		output.setCaretPosition(output.getText().length() - 1);
	}

	private void thieveryBtnActionPerformed(java.awt.event.ActionEvent evt) {
		int roll = Roller.roll("1d20+" + player.getThievery());
		String result;
		if (roll - player.getThievery() == 20)
			result = "CRITICAL SUCCESS";
		else if (roll - player.getThievery() == 1)
			result = "CRITICAL FAILURE";
		else
			result = new Integer(roll).toString();
		javax.swing.JOptionPane.showMessageDialog(null, "Thievery roll: " + result, "Roll Result", javax.swing.JOptionPane.INFORMATION_MESSAGE);
		output.append("\n==========SKILL CHECK==========\n");
		output.append("Thievery roll: " + result + "\n");
		output.setCaretPosition(output.getText().length() - 1);
	}

	private void streetwiseBtnActionPerformed(java.awt.event.ActionEvent evt) {
		int roll = Roller.roll("1d20+" + player.getStreetwise());
		String result;
		if (roll - player.getStreetwise() == 20)
			result = "CRITICAL SUCCESS";
		else if (roll - player.getStreetwise() == 1)
			result = "CRITICAL FAILURE";
		else
			result = new Integer(roll).toString();
		javax.swing.JOptionPane.showMessageDialog(null, "Streetwise roll: " + result, "Roll Result", javax.swing.JOptionPane.INFORMATION_MESSAGE);
		output.append("\n==========SKILL CHECK==========\n");
		output.append("Streetwise roll: " + result + "\n");
		output.setCaretPosition(output.getText().length() - 1);
	}

	private void stunnedToggleActionPerformed(java.awt.event.ActionEvent evt) {
		if (stunnedToggle.isSelected()) {
			output.append(player.getName() + " is stunned.\n");
			stunnedToggle.setFont(new java.awt.Font("Sylfaen", 1, 16));
			stunnedToggle.setForeground(new java.awt.Color(154, 0, 0));
		} else {
			stunnedToggle.setFont(new java.awt.Font("Sylfaen", 0, 14));
			stunnedToggle.setForeground(new java.awt.Color(0, 0, 0));
		}
		output.setCaretPosition(output.getText().length() - 1);
	}

	private void dazedToggleActionPerformed(java.awt.event.ActionEvent evt) {
		if (dazedToggle.isSelected()) {
			output.append(player.getName() + " is dazed.\n");
			dazedToggle.setFont(new java.awt.Font("Sylfaen", 1, 16));
			dazedToggle.setForeground(new java.awt.Color(154, 0, 0));
		} else {
			dazedToggle.setFont(new java.awt.Font("Sylfaen", 0, 14));
			dazedToggle.setForeground(new java.awt.Color(0, 0, 0));
		}
		output.setCaretPosition(output.getText().length() - 1);
	}

	private void immobilizedToggleActionPerformed(java.awt.event.ActionEvent evt) {
		if (immobilizedToggle.isSelected()) {
			output.append(player.getName() + " is immobilized.\n");
			immobilizedToggle.setFont(new java.awt.Font("Sylfaen", 0, 14));
			immobilizedToggle.setForeground(new java.awt.Color(154, 0, 0));
		} else {
			immobilizedToggle.setFont(new java.awt.Font("Sylfaen", 0, 14));
			immobilizedToggle.setForeground(new java.awt.Color(0, 0, 0));
		}
		output.setCaretPosition(output.getText().length() - 1);
	}

	private void proneToggleActionPerformed(java.awt.event.ActionEvent evt) {
		if (proneToggle.isSelected()) {
			output.append(player.getName() + " is prone.\n");
			proneToggle.setFont(new java.awt.Font("Sylfaen", 1, 16));
			proneToggle.setForeground(new java.awt.Color(154, 0, 0));
		} else {
			proneToggle.setFont(new java.awt.Font("Sylfaen", 0, 14));
			proneToggle.setForeground(new java.awt.Color(0, 0, 0));
		}
		if (selectedWeapon != null && hitField.getText().trim().compareTo("") != 0) {
			hitField.setText(setHitValue(selectedWeapon.getHitMod()) + "");
		}
		output.setCaretPosition(output.getText().length() - 1);
	}

	private void slowedToggleActionPerformed(java.awt.event.ActionEvent evt) {
		if (slowedToggle.isSelected()) {
			output.append(player.getName() + " is slowed.\n");
			slowedToggle.setFont(new java.awt.Font("Sylfaen", 1, 16));
			slowedToggle.setForeground(new java.awt.Color(154, 0, 0));
		} else {
			slowedToggle.setFont(new java.awt.Font("Sylfaen", 0, 14));
			slowedToggle.setForeground(new java.awt.Color(0, 0, 0));
		}
		output.setCaretPosition(output.getText().length() - 1);
	}

	private void markedToggleActionPerformed(java.awt.event.ActionEvent evt) {
		if (markedToggle.isSelected()) {
			output.append(player.getName() + " is marked.\n");
			markedToggle.setFont(new java.awt.Font("Sylfaen", 1, 16));
			markedToggle.setForeground(new java.awt.Color(154, 0, 0));
		} else {
			markedToggle.setFont(new java.awt.Font("Sylfaen", 0, 14));
			markedToggle.setForeground(new java.awt.Color(0, 0, 0));
		}
		if (selectedWeapon != null && hitField.getText().trim().compareTo("") != 0) {
			hitField.setText(setHitValue(selectedWeapon.getHitMod()) + "");
		}
		output.setCaretPosition(output.getText().length() - 1);
	}

	private void bloodiedToggleActionPerformed(java.awt.event.ActionEvent evt) {
		if (player.isBloodied()) {
			bloodiedToggle.setSelected(true);
			output.append(player.getName() + " is bloodied.\n");
			markedToggle.setFont(new java.awt.Font("Sylfaen", 1, 16));
			markedToggle.setForeground(new java.awt.Color(154, 0, 0));
		} else {
			bloodiedToggle.setSelected(false);
			markedToggle.setFont(new java.awt.Font("Sylfaen", 0, 14));
			markedToggle.setForeground(new java.awt.Color(0, 0, 0));
		}
		output.setCaretPosition(output.getText().length() - 1);
	}

	private void healingSurgeBtnActionPerformed(java.awt.event.ActionEvent evt) {
		player.useHealingSurge();
		updateUI();
	}

	private void addXPBtnActionPerformed(java.awt.event.ActionEvent evt) {
		output.append("Gained: " + player.addXP((Integer) addXPSpinner.getValue()) + " XP.\n");
		updateUI();
		output.setCaretPosition(output.getText().length() - 1);
	}

	private void setXPFieldActionPerformed(java.awt.event.ActionEvent evt) {
		player.setXP(Integer.parseInt(setXPField.getText()));
		updateUI();
	}

	private void resetSurgeBtnActionPerformed(java.awt.event.ActionEvent evt) {
		player.setCurrentHealingSurges(player.getCurrentHealingSurges());
		updateUI();
	}

	private void sneakCheckActionPerformed(java.awt.event.ActionEvent evt) {
		if (selectedWeapon != null && dmgField.getText().trim().compareTo("") != 0) {
			if (sneakCheck.isSelected() && dmgField.getText().indexOf("&2d8") == -1) {
				dmgField.setText(dmgField.getText() + "&2d8");
			} else {
				dmgField.setText(dmgField.getText().replaceAll("&2d8", ""));
			}
		}
	}

	private void combatAdvCheckActionPerformed(java.awt.event.ActionEvent evt) {
		if (selectedWeapon != null && hitField.getText().trim().compareTo("") != 0) {
			hitField.setText(setHitValue(selectedWeapon.getHitMod()) + "");
		}
	}

	/*
	 * =======================================Handling
	 * Methods====================
	 * ================================================
	 * ====================================== debug: ... parseXML: reads an XML
	 * file in .dnd4e format getTagValue: returns a tag value given tag name
	 * parseStat: identifies and sets a stat updateUI: updates the UI based on
	 * the currently loaded character updatePowers: updates the list display for
	 * the player's powers updateWeapons: updates the list display for the
	 * power's weapons updateInfo: updates the text area displaying the weapon's
	 * stats disableAll: disables all components enableAll: enables all
	 * components setHitValue: sets the hit state given all relevant variables
	 */

	static void debug() {

	}

	// This is hideous but I don't feel like refactoring all the character loading code.
	void parseCharacterFileFromJSON() {
		
	}
	
	/*
	 * ==========================================================================
	 * ==========================
	 */

	void parseCharacterFile() {
		// Initialize file chooser window
		int returnValue = fc.showOpenDialog(PlayerFrame.this);
		// If the user confirms...
		if (returnValue == javax.swing.JFileChooser.APPROVE_OPTION) {
			try {
				// Sets 'openfile' as the user selected file
				characterFile = fc.getSelectedFile();
				// Sets filename as the name of 'openfile'
				characterFileName = characterFile.getName();
				if (characterFileName.contains(".json")) {
					parseCharacterFileFromJSON();
					return;
				}
			} catch (Exception e) {
				output.append("Failed to load character file. Check that the file exists.");
				return;
			}
			
			try {
				String name_ = "<Missing Name>";
				int level_ = -1;
				int experience_ = -1;
				int maxHealth_ = -1;
				String initiative_ = "1d20+0";
				int[] stats_ = new int[23];
				int healingSurges_ = -1;
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				Document doc = dBuilder.parse(characterFile);
				doc.getDocumentElement().normalize();

				NodeList details = doc.getElementsByTagName("Details");
				Node detailsNode = details.item(0);
				if (detailsNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) detailsNode;

					name_ = getTagValue("name", eElement, 1).trim();
					level_ = Integer.parseInt(getTagValue("Level", eElement, 1).trim());
					experience_ = Integer.parseInt(getTagValue("Experience", eElement, 1).trim());
					characterLabel.setText(name_ + " (Level " + level_ + ")");
				}

				NodeList stat = doc.getElementsByTagName("Stat");
				for (int temp = 0; temp < stat.getLength(); temp++) {

					Node statNode = stat.item(temp);
					if (statNode.getNodeType() == Node.ELEMENT_NODE) {
						Element eElement = (Element) statNode;
						String n = eElement.getAttribute("name").trim();
						int v = Integer.parseInt(eElement.getAttribute("value").trim());
						if (n.compareTo("Hit Points") == 0) {
							maxHealth_ = new Integer(v);
						} else if (n.compareTo("Healing Surges") == 0) {
							healingSurges_ = new Integer(v);
						} else if (n.compareTo("Initiative") == 0) {
							initiative_ = "1d20+" + (new Integer(v)).toString();
						} else {
							stats_ = parseStat(n, v, stats_);
						}
					}
				}

				player = new Player(name_, level_, experience_, maxHealth_, initiative_, stats_, healingSurges_);

				NodeList powerstats = doc.getElementsByTagName("Power");
				for (int temp = 0; temp < powerstats.getLength(); temp++) {

					String powername_ = "<No name>";
					String powerUsage_ = "<?>";
					String actionType_ = "<?>";

					Node powerNode = powerstats.item(temp);
					if (powerNode.getNodeType() == Node.ELEMENT_NODE) {

						Element eElement = (Element) powerNode;
						powername_ = new String(eElement.getAttribute("name").trim());
						powerUsage_ = getTagValue("specific", eElement, 1).trim();
						actionType_ = getTagValue("specific", eElement, 2).trim();

						Power p = new Power(powername_, powerUsage_, actionType_);

						NodeList weapons = doc.getElementsByTagName("Weapon");
						for (int loop = 0; loop < weapons.getLength(); loop++) {

							String attackname_ = "";
							int hitmod_ = 0;
							String damage_ = "";
							String offensive_ = "";
							String defensive_ = "";

							Node weaponNode = weapons.item(loop);
							if (weaponNode.getParentNode() == eElement) {
								Element e = (Element) weaponNode;
								attackname_ = new String(e.getAttribute("name").trim());
								attackname_ = attackname_.replaceAll("&apos;", "'");
								hitmod_ = Integer.parseInt(new String(getTagValue("AttackBonus", e, 1).trim()));
								damage_ = new String(getTagValue("Damage", e, 1).trim());
								damage_ = damage_.replaceAll("-", "+-");
								offensive_ = new String(getTagValue("AttackStat", e, 1).trim());
								defensive_ = new String(getTagValue("Defense", e, 1).trim());
								Attack w = new Attack(attackname_, hitmod_, damage_);
								w.setOffensive(offensive_);
								w.setDefensive(defensive_);
								p.addWeapon(w);
							}
						}
						player.addPower(p);
					}
				}
				enableAll();
				updateUI();

				output.setText("");
				output.append("Loaded character: " + player.getName() + " from " + characterFileName + "\n");

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * ==========================================================================
	 * ==========================
	 */

	String getTagValue(String s, Element e, int c) {
		NodeList list = e.getElementsByTagName(s).item(c - 1).getChildNodes();
		Node n = (Node) list.item(0);
		return n.getNodeValue();
	}

	/*
	 * ==========================================================================
	 * ==========================
	 */

	int[] parseStat(String stat, int value, int[] stats) {
		if (stat.compareTo("Strength") == 0) {
			stats[0] = new Integer(value);
		}
		if (stat.compareTo("Dexterity") == 0) {
			stats[1] = new Integer(value);
		}
		if (stat.compareTo("Constitution") == 0) {
			stats[2] = new Integer(value);
		}
		if (stat.compareTo("Intelligence") == 0) {
			stats[3] = new Integer(value);
		}
		if (stat.compareTo("Wisdom") == 0) {
			stats[4] = new Integer(value);
		}
		if (stat.compareTo("Charisma") == 0) {
			stats[5] = new Integer(value);
		}
		if (stat.compareTo("Acrobatics") == 0) {
			stats[6] = new Integer(value);
		}
		if (stat.compareTo("Arcana") == 0) {
			stats[7] = new Integer(value);
		}
		if (stat.compareTo("Bluff") == 0) {
			stats[8] = new Integer(value);
		}
		if (stat.compareTo("Diplomacy") == 0) {
			stats[9] = new Integer(value);
		}
		if (stat.compareTo("Dungeoneering") == 0) {
			stats[10] = new Integer(value);
		}
		if (stat.compareTo("Endurance") == 0) {
			stats[11] = new Integer(value);
		}
		if (stat.compareTo("Heal") == 0) {
			stats[12] = new Integer(value);
		}
		if (stat.compareTo("History") == 0) {
			stats[13] = new Integer(value);
		}
		if (stat.compareTo("Insight") == 0) {
			stats[14] = new Integer(value);
		}
		if (stat.compareTo("Intimidate") == 0) {
			stats[15] = new Integer(value);
		}
		if (stat.compareTo("Nature") == 0) {
			stats[16] = new Integer(value);
		}
		if (stat.compareTo("Perception") == 0) {
			stats[17] = new Integer(value);
		}
		if (stat.compareTo("Religion") == 0) {
			stats[18] = new Integer(value);
		}
		if (stat.compareTo("Stealth") == 0) {
			stats[19] = new Integer(value);
		}
		if (stat.compareTo("Streetwise") == 0) {
			stats[20] = new Integer(value);
		}
		if (stat.compareTo("Thievery") == 0) {
			stats[21] = new Integer(value);
		}
		if (stat.compareTo("Athletics") == 0) {
			stats[22] = new Integer(value);
		}
		return stats;
	}

	/*
	 * ==========================================================================
	 * ==========================
	 */

	void updateUI() {
		// Update health bar
		healthBar.setString("Health: " + player.getHealth() + " / " + player.getMaxHealth());
		healthBar.setMaximum(player.getMaxHealth());
		healthBar.setValue(player.getHealth());
		// Update healing surges
		healingSurgeLabel.setText("Healing Surges Remaining: " + player.getCurrentHealingSurges());
		// Update acrobatics
		acrobaticsBtn.setText("Acrobatics + " + player.getAcrobatics());
		// Update arcana
		arcanaBtn.setText("Arcana + " + player.getArcana());
		// Update bluff
		bluffBtn.setText("Bluff + " + player.getBluff());
		// Update diplomacy
		diplomacyBtn.setText("Diplomacy + " + player.getDiplomacy());
		// Update dungeon
		dungeoneeringBtn.setText("Dungeoneering + " + player.getDungeoneering());
		// Update endurance
		enduranceBtn.setText("Endurance + " + player.getEndurance());
		// Update heal
		healBtn.setText("Heal + " + player.getHeal());
		// Update history
		historyBtn.setText("History + " + player.getHistory());
		// Update insight
		insightBtn.setText("Insight + " + player.getInsight());
		// Update intimidate
		intimidateBtn.setText("Intimidate + " + player.getIntimidate());
		// Update nature
		natureBtn.setText("Nature + " + player.getNature());
		// Update perception
		perceptionBtn.setText("Perception + " + player.getPerception());
		// Update religion
		religionBtn.setText("Religion + " + player.getReligion());
		// Update stealth
		stealthBtn.setText("Stealth + " + player.getStealth());
		// Update streetwise
		streetwiseBtn.setText("Streetwise + " + player.getStreetwise());
		// Update thievery
		thieveryBtn.setText("Thievery + " + player.getThievery());
		// Update athletics
		athleticsBtn.setText("Athletics + " + player.getAthletics());
		// Update list of powers
		updatePowers();
		// Update list of weapon attacks
		if (selectedPower != null)
			updateWeapons();
		// Update weapon stat display
		if (selectedPower != null && selectedWeapon != null)
			updateInfo();
		// Update experience
		currentXPArea.setText("Current Experience: " + player.getXP());
		// Update bloodied state
		if (player.isBloodied()) {
			bloodiedToggle.setSelected(true);
			output.append(player.getName() + " is bloodied.\n");
			bloodiedToggle.setFont(new java.awt.Font("Sylfaen", 1, 16));
			bloodiedToggle.setForeground(new java.awt.Color(154, 0, 0));
		} else {
			bloodiedToggle.setSelected(false);
			bloodiedToggle.setFont(new java.awt.Font("Sylfaen", 0, 14));
			bloodiedToggle.setForeground(new java.awt.Color(0, 0, 0));
		}
	}

	void updatePowers() {
		if (player != null) {
			powerList.setModel(new javax.swing.AbstractListModel() {
				String[] labels = player.getPowerNames();

				public int getSize() {
					return labels.length;
				}

				public Object getElementAt(int i) {
					return labels[i];
				}
			});
		}
	}

	void updateWeapons() {
		if (selectedPower != null) {
			weaponList.setModel(new javax.swing.AbstractListModel() {
				String[] labels = selectedPower.getWeaponNames();

				public int getSize() {
					return labels.length;
				}

				public Object getElementAt(int i) {
					return labels[i];
				}
			});
		}
	}

	void updateInfo() {
		infoArea.setText("");
		hitField.setText("");
		dmgField.setText("");
		if (selectedPower != null && (selectedWeapon != null || selectedPower.getNumWeapons() == 0)) {
			infoArea.append(selectedPower.getName() + "\n");
			infoArea.append("Usage: " + selectedPower.getPowerUsage() + "\n");
			infoArea.append("Type: " + selectedPower.getActionType() + "\n");
			if (selectedWeapon != null) {
				infoArea.append("Offensive Stat: " + selectedWeapon.getOffensive() + "\n");
				infoArea.append("Defensive Stat: " + selectedWeapon.getDefensive() + "\n");
				int hit = new Integer(selectedWeapon.getHitMod());
				hit = setHitValue(hit);
				String dmg = selectedWeapon.getDamageRoll();

				hitField.setText(hit + "");
				dmgField.setText(dmg);
			}
		}
		infoArea.setCaretPosition(0);
	}

	void disableAll() {

		healthBar.setEnabled(false);
		dmgBtn.setEnabled(false);
		dmgSpinner.setEnabled(false);
		healingSurgeBtn.setEnabled(false);
		healingSurgeLabel.setEnabled(false);
		healthBtn.setEnabled(false);
		healthField.setEnabled(false);
		stunnedToggle.setEnabled(false);
		dazedToggle.setEnabled(false);
		immobilizedToggle.setEnabled(false);
		proneToggle.setEnabled(false);
		slowedToggle.setEnabled(false);
		markedToggle.setEnabled(false);
		bloodiedToggle.setEnabled(false);
		acrobaticsBtn.setEnabled(false);
		arcanaBtn.setEnabled(false);
		athleticsBtn.setEnabled(false);
		bluffBtn.setEnabled(false);
		diplomacyBtn.setEnabled(false);
		dungeoneeringBtn.setEnabled(false);
		enduranceBtn.setEnabled(false);
		healBtn.setEnabled(false);
		historyBtn.setEnabled(false);
		insightBtn.setEnabled(false);
		intimidateBtn.setEnabled(false);
		natureBtn.setEnabled(false);
		perceptionBtn.setEnabled(false);
		religionBtn.setEnabled(false);
		stealthBtn.setEnabled(false);
		streetwiseBtn.setEnabled(false);
		thieveryBtn.setEnabled(false);
		resetSurgeBtn.setEnabled(false);
		refreshBtn.setEnabled(false);
		output.setEnabled(false);
		powerList.setEnabled(false);
		dmgField.setEnabled(false);
		hitField.setEnabled(false);
		rollBtn.setEnabled(false);
		infoArea.setEnabled(false);
		weaponListScroll.setEnabled(false);
		weaponList.setEnabled(false);
		currentXPAreaScroll.setEnabled(false);
		currentXPArea.setEnabled(false);
		addXPSpinner.setEnabled(false);
		addXPBtn.setEnabled(false);
		setXPField.setEnabled(false);
		setXPBtn.setEnabled(false);
		combatAdvCheck.setEnabled(false);
		sneakCheck.setEnabled(false);

	}

	void enableAll() {

		healthBar.setEnabled(true);
		dmgBtn.setEnabled(true);
		dmgSpinner.setEnabled(true);
		healingSurgeBtn.setEnabled(true);
		healingSurgeLabel.setEnabled(true);
		healthBtn.setEnabled(true);
		healthField.setEnabled(true);
		stunnedToggle.setEnabled(true);
		dazedToggle.setEnabled(true);
		immobilizedToggle.setEnabled(true);
		proneToggle.setEnabled(true);
		slowedToggle.setEnabled(true);
		markedToggle.setEnabled(true);
		bloodiedToggle.setEnabled(true);
		acrobaticsBtn.setEnabled(true);
		arcanaBtn.setEnabled(true);
		athleticsBtn.setEnabled(true);
		bluffBtn.setEnabled(true);
		diplomacyBtn.setEnabled(true);
		dungeoneeringBtn.setEnabled(true);
		enduranceBtn.setEnabled(true);
		healBtn.setEnabled(true);
		historyBtn.setEnabled(true);
		insightBtn.setEnabled(true);
		intimidateBtn.setEnabled(true);
		natureBtn.setEnabled(true);
		perceptionBtn.setEnabled(true);
		religionBtn.setEnabled(true);
		stealthBtn.setEnabled(true);
		streetwiseBtn.setEnabled(true);
		thieveryBtn.setEnabled(true);
		resetSurgeBtn.setEnabled(true);
		refreshBtn.setEnabled(true);
		output.setEnabled(true);
		powerList.setEnabled(true);
		dmgField.setEnabled(true);
		hitField.setEnabled(true);
		rollBtn.setEnabled(true);
		infoArea.setEnabled(true);
		weaponListScroll.setEnabled(true);
		weaponList.setEnabled(true);
		currentXPAreaScroll.setEnabled(true);
		currentXPArea.setEnabled(true);
		addXPSpinner.setEnabled(true);
		addXPBtn.setEnabled(true);
		setXPField.setEnabled(true);
		setXPBtn.setEnabled(true);
		combatAdvCheck.setEnabled(true);
		sneakCheck.setEnabled(true);
	}

	int setHitValue(int hit) {
		if (combatAdvCheck.isSelected())
			hit += 2;
		if (markedToggle.isSelected())
			hit -= 2;
		if (proneToggle.isSelected())
			hit -= 2;
		return hit;
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main() {

		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			try {
				UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			} catch (Exception exception) {
			}
		}

		java.awt.EventQueue.invokeLater(new Runnable() {

			public void run() {
				new PlayerFrame().setVisible(true);
			}
		});
	}

	// UI COMPONENTS
	public static javax.swing.JLabel characterLabel;
	public static javax.swing.JPanel CombatPanel;
	public static javax.swing.JPanel XPPane;
	public static javax.swing.JButton acrobaticsBtn;
	public static javax.swing.JButton addXPBtn;
	public static javax.swing.JSpinner addXPSpinner;
	public static javax.swing.JButton arcanaBtn;
	public static javax.swing.JButton athleticsBtn;
	public static javax.swing.JPanel attackPanel;
	public static javax.swing.JToggleButton bloodiedToggle;
	public static javax.swing.JButton bluffBtn;
	public static javax.swing.JTabbedPane combatPane;
	public static javax.swing.JTextArea currentXPArea;
	public static javax.swing.JScrollPane currentXPAreaScroll;
	public static javax.swing.JToggleButton dazedToggle;
	public static javax.swing.JButton diplomacyBtn;
	public static javax.swing.JButton dmgBtn;
	public static javax.swing.JTextField dmgField;
	public static javax.swing.JSpinner dmgSpinner;
	public static javax.swing.JButton dungeoneeringBtn;
	public static javax.swing.JButton enduranceBtn;
	public static javax.swing.JButton healBtn;
	public static javax.swing.JButton healingSurgeBtn;
	public static javax.swing.JLabel healingSurgeLabel;
	public static javax.swing.JProgressBar healthBar;
	public static javax.swing.JButton healthBtn;
	public static javax.swing.JTextField healthField;
	public static javax.swing.JPanel healthPanel;
	public static javax.swing.JButton historyBtn;
	public static javax.swing.JTextField hitField;
	public static javax.swing.JToggleButton immobilizedToggle;
	public static javax.swing.JTextArea infoArea;
	public static javax.swing.JScrollPane infoScroll;
	public static javax.swing.JButton insightBtn;
	public static javax.swing.JButton intimidateBtn;
	public static javax.swing.JButton loadBtn;
	public static javax.swing.JPanel managePanel;
	public static javax.swing.JTabbedPane manageTabPanel;
	public static javax.swing.JToggleButton markedToggle;
	public static javax.swing.JButton natureBtn;
	public static javax.swing.JTextArea output;
	public static javax.swing.JScrollPane outputPane;
	public static javax.swing.JButton perceptionBtn;
	public static javax.swing.JList powerList;
	public static javax.swing.JScrollPane powerScroll;
	public static javax.swing.JToggleButton proneToggle;
	public static javax.swing.JButton refreshBtn;
	public static javax.swing.JButton religionBtn;
	public static javax.swing.JButton resetSurgeBtn;
	public static javax.swing.JButton rollBtn;
	public static javax.swing.JButton setXPBtn;
	public static javax.swing.JTextField setXPField;
	public static javax.swing.JPanel skillPanel;
	public static javax.swing.JScrollPane skillScrollPanel;
	public static javax.swing.JToggleButton slowedToggle;
	public static javax.swing.JButton stealthBtn;
	public static javax.swing.JButton streetwiseBtn;
	public static javax.swing.JToggleButton stunnedToggle;
	public static javax.swing.JButton thieveryBtn;
	public static javax.swing.JList weaponList;
	public static javax.swing.JScrollPane weaponListScroll;
	public static javax.swing.JCheckBox combatAdvCheck;
	public static javax.swing.JCheckBox sneakCheck;
	// INTERNAL COMPONENTS
	public static File characterFile;
	public static javax.swing.JFileChooser fc;
	public static Player player;
	public static String characterFileName;
	public static Power selectedPower;
	public static Attack selectedWeapon;

}
