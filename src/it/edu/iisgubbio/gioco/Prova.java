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
        		StackPane s=new StackPane();
        		
        		ImageView i = new ImageView();
        		if(colonna%2==0 && riga%2==0) {
        			i=new ImageView(quadratoBianco);      			
        		}else {
        			if(!(colonna%2==0 || riga%2==0)) {
        				i=new ImageView(quadratoBianco);     				
        			}else {
        				i=new ImageView(quadratoNero);
        			}
        		}
        		i.setFitWidth(60);
                i.setFitHeight(60);
        		s.getChildren().add(i);
        		
        		ImageView p = new ImageView();
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
                
             // Aggiungi il pezzo alla cella
                if (p.getImage() != null) {
                    p.setFitWidth(60);
                    p.setFitHeight(60);
                    s.getChildren().add(p);
                }
                
        		final StackPane cella = s;
                final ImageView pezzo = p;
             // Gestore evento click
                s.setOnMouseClicked(event -> mouseCliccato(s,null,event));
                
                // Aggiungi la cella alla scacchiera
                grid.add(s, colonna, riga);
        	}	
        }
        
        Scene scene = new Scene(grid, 480, 480);
        primaryStage.setTitle("Scacchiera");
        primaryStage.setScene(scene);
        primaryStage.show();
	}
        
	private void mouseCliccato(StackPane cella,ImageView ignored, MouseEvent event){
		ImageView pezzo = null;

	    // Cerco nella cella cliccata se c'è un pezzo (escludendo il primo ImageView che è lo sfondo)
	    for (var node : cella.getChildren()) {
	        if (node instanceof ImageView iv) {
	            // Controllo che non è il primo ImageView ovvero lo sfondo e che ci sia un'immagine
	            if (cella.getChildren().indexOf(iv) != 0 && iv.getImage() != null) {
	                pezzo = iv;  // Assegno il pezzo trovato
	                break;       // Esco dal ciclo appena trovo il pezzo
	            }
	        }
	    }

	    // Controllo se non c'e nessun pezzo selezionato e se nella cella che clicco c'è un pezzo
	    if (cellaSelezionata == null && pezzo != null) {
	        // Seleziono la cella e il pezzo cliccati
	        cellaSelezionata = cella;
	        pezzoSelezionato = pezzo;
	        System.out.println("Pezzo selezionato");
	    }
	    // Primo caso se c'è già un pezzo selezionato e si clicca su una nuova cella
	    else if (pezzoSelezionato != null) {
	        // Adesso guardo se la nuova cella contiene un pezzo diverso da quello selezionato
	        if (pezzo != null && !pezzo.equals(pezzoSelezionato)) {
	            // Rimuovo il pezzo mangiato
	            cella.getChildren().remove(pezzo);
	            System.out.println("Pezzo mangiato!");
	        }

	        // Altro caso sposto il pezzo selezionato nella nuova cella
	        if (!cella.getChildren().contains(pezzoSelezionato)) {
	            // Rimuovo il pezzo dalla cella da cui l'ho spostato
	            cellaSelezionata.getChildren().remove(pezzoSelezionato);

	            // Aggiungo il pezzo alla nuova cella
	            cella.getChildren().add(pezzoSelezionato);
	            System.out.println("Pezzo spostato.");
	        }

	        // Resetto la selezione
	        cellaSelezionata = null;
	        pezzoSelezionato = null;
	    }

	    // Fermo che l'evento prima che ad altri gestori arrivi l'input del click
	    event.consume();
                
	}
	
	public static void main(String[] args) {
        launch(args);
    } 
}
