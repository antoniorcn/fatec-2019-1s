package edu.curso.boundary;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.curso.entidade.Personagem;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class PersonagemBoundary extends Application implements EventHandler<ActionEvent>{
	private TextField txtId = new TextField();
	private TextField txtNome = new TextField();
	private TextField txtAltura = new TextField();
	private TextField txtForca = new TextField();
	private TextField txtHabilidade = new TextField();
	private CheckBox chkMal = new CheckBox();
	private TextField txtNascimento = new TextField();
	private Button btnSalvar = new Button("Salvar");
	private Button btnPesquisar = new Button("Pesquisar");

	private List<Personagem> lista = new ArrayList<>();
	
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	@Override
	public void start(Stage stage) throws Exception {
		GridPane grid = new GridPane();
		Scene scene = new Scene(grid, 300, 300);
		Label lblId = new Label("Id");
		grid.add(lblId, 0, 0);
		grid.add(txtId, 1, 0);
		grid.add(new Label("Nome"), 0, 1);
		grid.add(txtNome, 1, 1);
		grid.add(new Label("Altura"), 0, 2);
		grid.add(txtAltura, 1, 2);
		grid.add(new Label("Força"), 0, 3);
		grid.add(txtForca, 1, 3);
		grid.add(new Label("Habilidade"), 0, 4);
		grid.add(txtHabilidade, 1, 4);
		grid.add(new Label("Do Mal"), 0, 5);
		grid.add(chkMal, 1, 5);
		grid.add(new Label("Nascimento"), 0, 6);
		grid.add(txtNascimento, 1, 6);
		grid.add(btnSalvar, 0, 7);
		grid.add(btnPesquisar, 1, 7);
		btnSalvar.setOnAction(this);
		btnPesquisar.setOnAction(this);

		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void handle(ActionEvent e) {
		if (e.getTarget() == btnSalvar) { 
			Personagem p = boundaryToPersonagem();
			lista.add(p);
			System.out.println("Adicionando na lista Tamanho:" + lista.size());
		} else if (e.getTarget() == btnPesquisar) {
			System.out.println("Pesquisando na lista");
			for (Personagem p : lista) { 
				if(p.getNome().contains(txtNome.getText())) { 
					personagemToBoundary(p);		
				}
			}
		}
	}

	public void personagemToBoundary(Personagem p) {
		txtId.setText( String.format("%d", p.getId()) );
		txtNome.setText(  p.getNome() );
		txtAltura.setText(  String.format("%6.2f", p.getAltura()) );
		txtForca.setText(  String.format("%6.2f", p.getForca()) );
		txtHabilidade.setText(  p.getHabilidade() );
		chkMal.setSelected( p.isDoMal() );
		txtNascimento.setText(sdf.format(p.getNascimento()));
	}

	public Personagem boundaryToPersonagem() {
		Personagem p = new Personagem();
		try {
			p.setId( Long.parseLong(txtId.getText()) );
			p.setNome( txtNome.getText() );
			p.setAltura( Float.parseFloat(txtAltura.getText()) );
			p.setForca( Float.parseFloat(txtForca.getText()) );
			p.setHabilidade( txtHabilidade.getText() );
			p.setDoMal( chkMal.isSelected() );
			Date d = sdf.parse( txtNascimento.getText() );
			p.setNascimento( d );
		} catch (NumberFormatException e1) {
			e1.printStackTrace();
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		return p;
	}
}
