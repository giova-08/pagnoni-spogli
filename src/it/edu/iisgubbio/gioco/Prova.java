package it.edu.iisgubbio.gioco;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Prova extends Application{
	
	StackPane cellaSelezionata = null;
    ImageView pezzoSelezionato = null;
    
	@Override
    public void start(Stage primaryStage) {
		// Creazione della GridPane per la scacchiera
        GridPane grid = new GridPane();
        int dimensione=8;
        
        
        
        Image quadratoBianco = new Image(getClass().getResourceAsStream("quadrato_bianco.png"));
        Image quadratoNero = new Image(getClass().getResourceAsStream("quadrato_nero.png"));
        Image biancoPedone = new Image(getClass().getResourceAsStream("pedone_bianco-1.png"));  
        Image neroPedone = new Image(getClass().getResourceAsStream("pedone_nero-1.png"));
        Image biancoRe = new Image(getClass().getResourceAsStream("re_bianco-1.png"));
        Image neroRe = new Image(getClass().getResourceAsStream("re_nero-1.png"));
        Image biancoAlfiereDx = new Image(getClass().getResourceAsStream("alfiere_bianco-1.png"));
        Image biancoAlfiereSx = new Image(getClass().getResourceAsStream("alfiere_bianco-1.png"));
        Image neroAlfiereDx = new Image(getClass().getResourceAsStream("alfiere_nero-1.png"));
        Image neroAlfiereSx = new Image(getClass().getResourceAsStream("alfiere_nero-1.png"));
        Image biancoCavalloDx = new Image(getClass().getResourceAsStream("cavallo_bianco-1.png"));
        Image biancoCavalloSx = new Image(getClass().getResourceAsStream("cavallo_bianco-1.png"));
        Image neroCavalloDx = new Image(getClass().getResourceAsStream("cavallo_nero-1.png"));
        Image neroCavalloSx = new Image(getClass().getResourceAsStream("cavallo_nero-1.png"));
        Image biancoTorreDx = new Image(getClass().getResourceAsStream("torre_bianca-1.png"));
        Image biancoTorreSx = new Image(getClass().getResourceAsStream("torre_bianca-1.png"));
        Image neroTorreDx = new Image(getClass().getResourceAsStream("torre_nera-1.png"));
        Image neroTorreSx = new Image(getClass().getResourceAsStream("torre_nera-1.png"));
        Image biancoRegina = new Image(getClass().getResourceAsStream("regina_bianca-1.png"));
        Image neroRegina = new Image(getClass().getResourceAsStream("regina_nera-1.png"));
        
        
        
        
        
        for(int riga=0;riga<dimensione;riga++) {
        	for(int colonna=0;colonna<dimensione;colonna++) {
        		ImageView i = new ImageView();
        		ImageView p = new ImageView();
        		StackPane s=new StackPane();
        		grid.add(i, colonna, riga);
        		if(colonna%2==0 && riga%2==0) {
        			i=new ImageView(quadratoBianco);
        			i.setFitWidth(60);
        			i.setFitHeight(60);
        		}else {
        			if(!(colonna%2==0 || riga%2==0)) {
        				i=new ImageView(quadratoBianco);
        				i.setFitWidth(60);
            			i.setFitHeight(60);
        			}else {
        				i=new ImageView(quadratoNero);
        				i.setFitWidth(60);
            			i.setFitHeight(60);
        			}
        		}
        		s.getChildren().add(i);
        		grid.add(s, colonna, riga);
        		// Gestore evento click
                s.setOnMouseClicked(event -> mouseCliccato(s,p,event));
                if (riga == 6) {
                    p.setImage(biancoPedone); // Pedoni bianchi
                } else if (riga == 1) {
                    p.setImage(neroPedone); // Pedoni neri
                } else if (riga == 7 && colonna == 4) {
                    p.setImage(biancoRe); // Re bianco
                } else if (riga == 0 && colonna == 4) {
                    p.setImage(neroRe); // Re nero
                }else if (riga == 7 && colonna == 5) {
                    p.setImage(biancoAlfiereDx); // Alfiere bianco a destra del Re bianco
                }else if (riga == 7 && colonna == 2) {
                    p.setImage(biancoAlfiereSx); // Alfiere bianco a sinistra della Regina bianca
                }else if (riga == 0 && colonna == 5) {
                    p.setImage(neroAlfiereDx); // Alfiere nero a destra del Re nero
                }else if (riga == 0 && colonna == 2) {
                    p.setImage(neroAlfiereSx); // Alfiere nero a sinistra della Regina nera
                }else if (riga == 7 && colonna == 3) {
                    p.setImage(biancoRegina); //  Regina bianca
                }else if (riga == 0 && colonna == 3) {
                    p.setImage(neroRegina); //  Regina nera
                }else if (riga == 7 && colonna == 6) {
                    p.setImage(biancoCavalloDx); //  Cavallo bianco a destra del Re bianco
                }else if (riga == 7 && colonna == 1) {
                    p.setImage(biancoCavalloSx); //  Cavallo bianco a sinistra della Regina bianca
                }else if (riga == 0 && colonna == 6) {
                    p.setImage(neroCavalloDx); //  Cavallo nero a destra del Re nero
                }else if (riga == 0 && colonna == 1) {
                    p.setImage(neroCavalloSx); //  Cavallo nero a sinistra della Regina nera
                }else if (riga == 7 && colonna == 7) {
                    p.setImage(biancoTorreDx); //  Torre bianca a destra del Re bianco
                }else if (riga == 7 && colonna == 0) {
                    p.setImage(biancoTorreSx); //  Torre bianca a destra della Regina bianca
                }else if (riga == 0 && colonna == 7) {
                    p.setImage(neroTorreDx); //  Torre nera a destra del Re bianco
                }else if (riga == 0 && colonna == 0) {
                    p.setImage(neroTorreSx); //  Torre nera a sinistra della Regina nera
                }
             // Imposta la larghezza e altezza per ogni immagine
                p.setFitWidth(60);
                p.setFitHeight(60);
        		s.getChildren().add(p);
        		final StackPane cella = s;
                final ImageView pezzo = p;
        	}	
        }
        
        Scene scene = new Scene(grid, 480, 480);
        primaryStage.setTitle("Scacchiera");
        primaryStage.setScene(scene);
        primaryStage.show();
	}
        
	private void mouseCliccato(StackPane cella,ImageView pezzo, MouseEvent event){
		 // Seleziona un pezzo
        if (cellaSelezionata == null && pezzo.getImage() != null) {
            // Se il pezzo non è già selezionato, seleziona il pezzo
            cellaSelezionata = cella;
            pezzoSelezionato = pezzo;
            System.out.println("Pezzo selezionato: " + GridPane.getRowIndex(cella) + "," + GridPane.getColumnIndex(cella));
        } 
        // Sposta il pezzo
        else if (pezzoSelezionato != null) {
            int nuovaRiga = GridPane.getRowIndex(cella);
            int nuovaColonna = GridPane.getColumnIndex(cella);

            // Sposta il pezzo nella nuova cella, se la cella è vuota
            if (pezzo.getImage() == null || pezzo.getImage() != null) {  // La cella di destinazione deve essere vuota
                // Rimuovi il pezzo dalla posizione precedente
                cellaSelezionata.getChildren().remove(pezzoSelezionato);

                // Aggiungi il pezzo nella nuova posizione
                cella.getChildren().add(pezzoSelezionato);
                GridPane.setRowIndex(pezzoSelezionato, nuovaRiga);
                GridPane.setColumnIndex(pezzoSelezionato, nuovaColonna);
                System.out.println("Pezzo spostato a: " + nuovaRiga + "," + nuovaColonna);
            }

            // Deseleziona
            cellaSelezionata = null;
            pezzoSelezionato = null;
        }

        event.consume(); // Evita che l'evento venga propagato ulteriormente
    }
	
	public static void main(String[] args) {
        launch(args);
    } 
}
