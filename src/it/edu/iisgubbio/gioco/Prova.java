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
                    p.setUserData("pedone_bianco");
                } else if (riga == 1) {
                    p.setImage(neroPedone); // Pedoni neri
                    p.setUserData("pedone_nero");
                } else if (riga == 7 && colonna == 4) {
                    p.setImage(biancoRe); // Re bianco
                    p.setUserData("re_bianco");
                } else if (riga == 0 && colonna == 4) {
                    p.setImage(neroRe); // Re nero
                    p.setUserData("re_nero");
                }else if (riga == 7 && colonna == 5) {
                    p.setImage(biancoAlfiereDx); // Alfiere bianco a destra del Re bianco
                    p.setUserData("alfiereDx_bianco");
                }else if (riga == 7 && colonna == 2) {
                    p.setImage(biancoAlfiereSx); // Alfiere bianco a sinistra della Regina bianca
                    p.setUserData("alfiereSx_bianco");
                }else if (riga == 0 && colonna == 5) {
                    p.setImage(neroAlfiereDx); // Alfiere nero a destra del Re nero
                    p.setUserData("alfiereDx_nero");
                }else if (riga == 0 && colonna == 2) {
                    p.setImage(neroAlfiereSx); // Alfiere nero a sinistra della Regina nera
                    p.setUserData("alfiereSx_nero");
                }else if (riga == 7 && colonna == 3) {
                    p.setImage(biancoRegina); //  Regina bianca
                    p.setUserData("regina_bianco");
                }else if (riga == 0 && colonna == 3) {
                    p.setImage(neroRegina); //  Regina nera
                    p.setUserData("regina_nero");
                }else if (riga == 7 && colonna == 6) {
                    p.setImage(biancoCavalloDx); //  Cavallo bianco a destra del Re bianco
                    p.setUserData("cavalloDx_bianco");
                }else if (riga == 7 && colonna == 1) {
                    p.setImage(biancoCavalloSx); //  Cavallo bianco a sinistra della Regina bianca
                    p.setUserData("cavalloSx_bianco");
                }else if (riga == 0 && colonna == 6) {
                    p.setImage(neroCavalloDx); //  Cavallo nero a destra del Re nero
                    p.setUserData("cavalloDx_nero");
                }else if (riga == 0 && colonna == 1) {
                    p.setImage(neroCavalloSx); //  Cavallo nero a sinistra della Regina nera
                    p.setUserData("cavalloSx_nero");
                }else if (riga == 7 && colonna == 7) {
                    p.setImage(biancoTorreDx); //  Torre bianca a destra del Re bianco
                    p.setUserData("torreDx_bianco");
                }else if (riga == 7 && colonna == 0) {
                    p.setImage(biancoTorreSx); //  Torre bianca a destra della Regina bianca
                    p.setUserData("torreSx_bianco");
                }else if (riga == 0 && colonna == 7) {
                    p.setImage(neroTorreDx); //  Torre nera a destra del Re nero
                    p.setUserData("torreDx_nero");
                }else if (riga == 0 && colonna == 0) {
                    p.setImage(neroTorreSx); //  Torre nera a sinistra della Regina nera
                    p.setUserData("torreSx_nero");
                }
                
             // Aggiungi il pezzo alla cella
                if (p.getImage() != null) {
                    p.setFitWidth(60);
                    p.setFitHeight(60);
                    s.getChildren().add(p);
                }
                
             // Gestore evento click
                s.setOnMouseClicked(event -> mouseCliccato(s,event));
                
                // Aggiungi la cella alla scacchiera
                grid.add(s, colonna, riga);
        	}	
        }
        
        Scene scene = new Scene(grid, 480, 480);
        primaryStage.setTitle("Scacchiera");
        primaryStage.setScene(scene);
        primaryStage.show();
	}
        
	private void mouseCliccato(StackPane cella, MouseEvent event){
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
	    	
	    	// PrendO il tipo del pezzo con UserData
	        Object tipo = pezzo.getUserData();
	     // Verifico che il pezzo è un pedone
	        if (tipo != null && (tipo.equals("pedone_bianco") || tipo.equals("pedone_nero"))) {
	        	// Se è un pedone, lo seleziono
	            cellaSelezionata = cella;
	            pezzoSelezionato = pezzo;
	            System.out.println("Pezzo selezionato");
	        } else {
	        	//sennò annullo tutto
	            System.out.println("Pezzo non supportato. Selezione ignorata.");
	            cellaSelezionata = null;
	            pezzoSelezionato = null;
	        }
	    }
	    // Primo caso se c'è già un pezzo selezionato e si clicca su una nuova cella
	    else if (pezzoSelezionato != null) {
	    	// prendo le coordinate della cella di partenza
	    	 int startX = GridPane.getRowIndex(cellaSelezionata);
	         int startY = GridPane.getColumnIndex(cellaSelezionata);
	      // prendo le coordinate della cella cliccata 
	         int endX = GridPane.getRowIndex(cella);
	         int endY = GridPane.getColumnIndex(cella);

	      // prendo il tipo del pezzo selezionato
	         Object tipo = pezzoSelezionato.getUserData();
	      // imposto una variabile di controllo per capire se la mossa è valida o meno
	         boolean mossaValida = false;
	         //PEDONE BIANCO
	         if (tipo != null && tipo.equals("pedone_bianco")) {
	             // Avanti di 1 senza mangiare
	             if (startX - 1 == endX && startY == endY && pezzo == null) {
	                 mossaValida = true;
	             }
	             // Avanti di 2 dalla riga iniziale
	             else if (startX == 6 && endX == 4 && startY == endY && pezzo == null) {
	                 mossaValida = true;
	             }
	             // Mangia in diagonale
	             /* 
	              * controllo che va avanti di 1
	              * che si sposta di una colonna
	              * che sia un'altro pezzo da poter mangiare
	              * e che sia un pezzo nero
	              */
	             
	             else if (startX - 1 == endX && Math.abs(startY - endY) == 1 && 
	                      pezzo != null && pezzo.getUserData() != null &&
	                      pezzo.getUserData().toString().contains("nero")) {
	                 mossaValida = true;
	             }
	         } 
	         //PEDONE NERO
	         else if (tipo != null && tipo.equals("pedone_nero")) {
	        	// Avanti di 1 senza mangiare
	             if (startX + 1 == endX && startY == endY && pezzo == null) {
	                 mossaValida = true;
	             // Avanti di 2 dalla riga iniziale
	             } else if (startX == 1 && endX == 3 && startY == endY && pezzo == null) {
	                 mossaValida = true;
	             // Mangia in diagonale
	             /* 
		          * controllo che va avanti di 1
		          * che si sposta di una colonna
		          * che sia un'altro pezzo da poter mangiare
		          * e che sia un pezzo bianco
		         */
	             } else if (startX + 1 == endX && Math.abs(startY - endY) == 1 &&
	                        pezzo != null && pezzo.getUserData() != null &&
	                        pezzo.getUserData().toString().contains("bianco")) {
	                 mossaValida = true;
	             }
	         } else {
	             // Se è un tipo non supportato, annullo tutto
	             System.out.println("Movimento non supportato. Selezione annullata.");
	             cellaSelezionata = null;
	             pezzoSelezionato = null;
	             return;
	         }
	      // Se la mossa non è  valida, blocco l'azione
	         if (!mossaValida) {
	             System.out.println("Mossa non valida!");
	             cellaSelezionata = null;
	             pezzoSelezionato = null;
	             return;
	         }
	        //Ora sicuramente sarà una mossa valida
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

	    // Fermo l'evento prima che ad altri gestori arrivi l'input del click
	    event.consume();
                
	}
	
	public static void main(String[] args) {
        launch(args);
    } 
}
