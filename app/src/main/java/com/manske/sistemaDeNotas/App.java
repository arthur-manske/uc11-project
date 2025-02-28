package com.manske.sistemaDeNotas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JFrame {
	private JTextField  studentNameTxtField;
	private JTextField  studentGradeTxtField;
	private JTextArea   resultTxtArea;

	private JPanel      inputPanel;
	private JButton     displayResultsBtn;
	private JScrollPane scrollPane;

	public App(int w, int h)
	{
		this.inputPanel    = new JPanel();
		this.resultTxtArea = new JTextArea(5, 30);
		this.scrollPane    = new JScrollPane(this.resultTxtArea);

		this.setTitle("Sistema de Notas dos Estudantes");
		this.setSize(w, h);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

		this.setLayout(new BorderLayout());

		this.inputPanel.setLayout(new GridLayout(3, 2));

		this.inputPanel.add(new JLabel("Nome do estudante:"));
		this.inputPanel.add((this.studentNameTxtField = new JTextField()));
		this.inputPanel.add(new JLabel("Notas do estudante (0-100):"));
		this.inputPanel.add((this.studentGradeTxtField = new JTextField()));
		this.inputPanel.add((this.displayResultsBtn = new JButton("Obter resultados")));

		this.resultTxtArea.setEditable(false);

		this.add(this.scrollPane, BorderLayout.SOUTH);
		this.add(this.inputPanel, BorderLayout.CENTER);

		this.displayResultsBtn.addActionListener((ActionEvent _unused) -> {
			displayResults(this.studentNameTxtField.getText(), this.studentGradeTxtField.getText());
		});
	}

	private void displayResults(String name, String gradesTxt)
	{
		final var student = new Student(name);
		
		try {
			if (!student.setGrades(Float.parseFloat(gradesTxt))) throw new NumberFormatException();
			this.resultTxtArea.setText("Resultados para " + name + ":\n" + GradesRelations.evaluate(student));
		} catch (NumberFormatException ex) {
			this.resultTxtArea.setText("Entrada inválida!\nA nota do estudante deve ser um número válido de 0.0 até 100.0.");
		}
	}
	
	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(() -> {
			new App(800, 600).setVisible(true);
		});
	}
};
