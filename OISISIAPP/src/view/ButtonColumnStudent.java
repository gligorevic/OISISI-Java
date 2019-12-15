package view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import dialogs.PrikaziProfesoraDialog;
import dialogs.PrikaziStudentaDialog;

public class ButtonColumnStudent extends AbstractCellEditor implements TableCellRenderer, TableCellEditor, MouseListener {

	private JTable table;
	private JButton renderButton;
	private JButton editorButton;
	
	private boolean isEditorActive = false;
	
	public ButtonColumnStudent(JTable table , int column) {
		this.table = table;
		this.table.getColumnModel().getColumn(column).setCellRenderer(this);
		this.table.getColumnModel().getColumn(column).setCellEditor(this);
		this.table.addMouseListener(this);
		
		this.renderButton = new JButton("Prikaži");
		this.editorButton = new JButton("Prikaži");
	
		this.editorButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				fireEditingStopped();
				PrikaziStudentaDialog psd = new PrikaziStudentaDialog(table.getSelectedRow());
				psd.setVisible(true);
			}
		});
		
		this.isEditorActive = false;
	}
	
	@Override
	public Object getCellEditorValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		if (table.isEditing() && table.getCellEditor() == this) {
			this.isEditorActive = true;
		}
		
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		if (isEditorActive && table.isEditing()) {
			table.getCellEditor().stopCellEditing();
		}
		isEditorActive = false;
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		// TODO Auto-generated method stub
		return this.editorButton;
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		// TODO Auto-generated method stub
		return this.renderButton;
	}

}
