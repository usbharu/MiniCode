package harujisaku.minicode.panel;

import harujisaku.minicode.*;
import harujisaku.minicode.panel.*;
import harujisaku.minicode.pane.*;

import java.io.File;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;

public class MainPanel extends JPanel {
	CodePaneManager codePanelList;
	public MainPanel(CodePaneManager codePanelList){
		this.codePanelList=codePanelList;
		setLayout(new BorderLayout());
		JConsolePanel console = new JConsolePanel();
		codePanelList.add(4,new File("C:\\Users\\haruj\\Documents\\GitHub\\MiniCode\\src\\harujisaku\\minicode\\panel\\JCodePanel.java"));
		System.out.println(codePanelList.getCodePaneList().size());
		JSplitPane splitpane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		splitpane.setResizeWeight(1.0);
		splitpane.setBottomComponent(console);
		splitpane.setTopComponent(codePanelList.get(0));
		splitpane.setDividerLocation(-1);
		SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run(){
				add(splitpane,BorderLayout.CENTER);
			}
		});
	}
	
	public JCodePanel getSelectedPane(){
		return codePanelList.get(0);
	}
}