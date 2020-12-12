package harujisaku.minicode;

import harujisaku.minicode.pane.*;
import harujisaku.minicode.file.*;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JMenuBar{
	public Menu(MiniCode m){
		JMenu file = new JMenu("ファイル(F)");
		JMenu edit = new JMenu("編集(E)");
		JMenu view = new JMenu("表示(V)");
		JMenu tabSize = new JMenu("タブ幅");
		JMenuItem save = new JMenuItem("保存");
		JMenuItem saveAs = new JMenuItem("名前を付けて保存");
		JMenuItem open = new JMenuItem("開く");
		JRadioButtonMenuItem tab2 = new JRadioButtonMenuItem("2");
		JRadioButtonMenuItem tab4 = new JRadioButtonMenuItem("4");
		JRadioButtonMenuItem tab8 = new JRadioButtonMenuItem("8");
		
		file.setMnemonic(KeyEvent.VK_F);
		edit.setMnemonic(KeyEvent.VK_E);
		view.setMnemonic(KeyEvent.VK_V);
		save.setMnemonic(KeyEvent.VK_S);
		save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,InputEvent.CTRL_DOWN_MASK));
		saveAs.setAccelerator(KeyStroke.getKeyStroke("control shift S"));
		save.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				m.getMainPanel().getSelectedPane().save();
				System.out.println("aa");
				m.getCodePaneManager().updateTabTitle();
			}
		});
		saveAs.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				m.getMainPanel().getSelectedPane().saveAs();
				System.out.println("aa");
				m.getCodePaneManager().updateTabTitle();
			}
		});
		open.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				m.getCodePaneManager().add(FileManager.load());
				m.getCodePaneManager().setSelectedIndex(m.getCodePaneManager().getTabCount()-1);
			}
		});
		tab2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				m.getMainPanel().getSelectedPane().setTabSize(2);
			}
		});
		tab4.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				m.getMainPanel().getSelectedPane().setTabSize(4);
			}
		});
		tab8.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				m.getMainPanel().getSelectedPane().setTabSize(8);
			}
		});
		
		tab4.setSelected(true);
		
		ButtonGroup tabSizeGroup = new ButtonGroup();
		
		tabSizeGroup.add(tab2);
		tabSizeGroup.add(tab4);
		tabSizeGroup.add(tab8);
		
		file.add(save);
		file.add(saveAs);
		file.add(open);
		tabSize.add(tab2);
		tabSize.add(tab4);
		tabSize.add(tab8);
		view.add(tabSize);
		add(file);
		add(edit);
		add(view);
	}
}