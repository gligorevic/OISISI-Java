package dialogs;

import java.awt.BorderLayout;

import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import model.BazaPredmet;
import model.Predmet;
import view.MainFrame;

public class PrikaziStudenteDialog extends JDialog {
	
	private static final long serialVersionUID = -3450726041014947809L;

	public PrikaziStudenteDialog(int id) {
		super(MainFrame.getInstance(), "Spisak studenata", true);
		Predmet predmet = BazaPredmet.getInstance().getRow(id);
		
		this.setLayout(new BorderLayout());
	
		DefaultListModel<String> model = new DefaultListModel<>();
		predmet.getStudenti().forEach(s -> {
			model.addElement(s.getBrojIndeksa());
		});

        JList<String> lista = new JList<>();

        JPanel jp = new JPanel(new BorderLayout());

        lista.setModel(model);
        
        jp.add(lista);
        
        if(model.size() == 0) {
        	this.add(new JLabel("Nema studenata na predmetu"));
        } else {
        	this.add(jp, BorderLayout.CENTER);
        }
        
        
        setSize(350,350);
		setLocationRelativeTo(MainFrame.getInstance());
	}
}
