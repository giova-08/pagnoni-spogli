package it.edu.iisgubbio.gioco;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Prova extends Application {

	StackPane cellaSelezionata = null;
	ImageView pezzoSelezionato = null;
	public GridPane grid;
	private boolean turnoBianco = true; // true = tocca ai bianchi, false = ai neri
	public Label titolo;
	public Label mosse;
	public Label pedone;
	public Label torre;
	public Label alfiere;
	public Label cavallo;
	public Label re;
	public Label regina;
	Label turno = new Label("Turno: Bianco");
	public Label informazioni;


	@Override
	public void start(Stage primaryStage) {
		// Creazione della GridPane per la scacchiera
		grid = new GridPane();
		int dimensione = 8;

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

		//For per impostare le immagini dentro l'imageview e poi aggiungerle allo stackpane
		//e poi aggiungere tutto alla griglia, imposto anche le dimensioni delle immagini
		for (int riga = 0; riga < dimensione; riga++) {
			for (int colonna = 0; colonna < dimensione; colonna++) {
				StackPane s = new StackPane();

				ImageView i = new ImageView();
				if (colonna % 2 == 0 && riga % 2 == 0) {
					i = new ImageView(quadratoBianco);
				} else {
					if (!(colonna % 2 == 0 || riga % 2 == 0)) {
						i = new ImageView(quadratoBianco);
					} else {
						i = new ImageView(quadratoNero);
					}
				}
				i.setFitWidth(60);
				i.setFitHeight(60);
				s.getChildren().add(i);

				ImageView p = new ImageView();
				//Aggiungo i pezzi ad un loro imageview e poi per ognuno e assoccio a p
				// per tutti i pezzi un dato con setUserData per poi sapere in seguito che tipo di pezzo è
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
				} else if (riga == 7 && colonna == 5) {
					p.setImage(biancoAlfiereDx); // Alfiere bianco a destra del Re bianco
					p.setUserData("alfiereDx_bianco");
				} else if (riga == 7 && colonna == 2) {
					p.setImage(biancoAlfiereSx); // Alfiere bianco a sinistra della Regina bianca
					p.setUserData("alfiereSx_bianco");
				} else if (riga == 0 && colonna == 5) {
					p.setImage(neroAlfiereDx); // Alfiere nero a destra del Re nero
					p.setUserData("alfiereDx_nero");
				} else if (riga == 0 && colonna == 2) {
					p.setImage(neroAlfiereSx); // Alfiere nero a sinistra della Regina nera
					p.setUserData("alfiereSx_nero");
				} else if (riga == 7 && colonna == 3) {
					p.setImage(biancoRegina); // Regina bianca
					p.setUserData("regina_bianco");
				} else if (riga == 0 && colonna == 3) {
					p.setImage(neroRegina); // Regina nera
					p.setUserData("regina_nero");
				} else if (riga == 7 && colonna == 6) {
					p.setImage(biancoCavalloDx); // Cavallo bianco a destra del Re bianco
					p.setUserData("cavalloDx_bianco");
				} else if (riga == 7 && colonna == 1) {
					p.setImage(biancoCavalloSx); // Cavallo bianco a sinistra della Regina bianca
					p.setUserData("cavalloSx_bianco");
				} else if (riga == 0 && colonna == 6) {
					p.setImage(neroCavalloDx); // Cavallo nero a destra del Re nero
					p.setUserData("cavalloDx_nero");
				} else if (riga == 0 && colonna == 1) {
					p.setImage(neroCavalloSx); // Cavallo nero a sinistra della Regina nera
					p.setUserData("cavalloSx_nero");
				} else if (riga == 7 && colonna == 7) {
					p.setImage(biancoTorreDx); // Torre bianca a destra del Re bianco
					p.setUserData("torreDx_bianco");
				} else if (riga == 7 && colonna == 0) {
					p.setImage(biancoTorreSx); // Torre bianca a destra della Regina bianca
					p.setUserData("torreSx_bianco");
				} else if (riga == 0 && colonna == 7) {
					p.setImage(neroTorreDx); // Torre nera a destra del Re nero
					p.setUserData("torreDx_nero");
				} else if (riga == 0 && colonna == 0) {
					p.setImage(neroTorreSx); // Torre nera a sinistra della Regina nera
					p.setUserData("torreSx_nero");
				}

				// Aggiungo il pezzo alla cella
				if (p.getImage() != null) {
					p.setFitWidth(60);
					p.setFitHeight(60);
					s.getChildren().add(p);
				}

				// Gestore evento click
				s.setOnMouseClicked(event -> mouseCliccato(s, event));

				// Aggiungi la cella alla scacchiera
				grid.add(s, colonna, riga);
			}
		}
		
		// Pannello di destra per scrivere delle informazioni
		VBox infoBox = new VBox(10);
		infoBox.setPadding(new Insets(10));
		infoBox.setPrefWidth(350);
		infoBox.setStyle("-fx-background-color: #f0f0f0;"
				+ "-fx-background-color: #f0f0f0;"
				+ "-fx-font-family: 'Arial';"
				+ "-fx-font-size: 14px;"
				+ "-fx-text-fill: black;");
		
		
		// Label con informazioni
		titolo = new Label("INFORMAZIONI PER GIOCARE");
		titolo.setFont(Font.font("Arial", FontWeight.NORMAL, 22));
		titolo.setTextFill(Color.RED);
		mosse = new Label("I pezzi si muovono:");
		pedone= new Label("- Pedone: si muove avanti di 1,\n  può mangiare in diagonale,\n"
				+ "  quando viene spostato dalla\n  casella di partenza può muoversi anche di 2");
		cavallo=new Label("- Cavallo: si muove a L");
		alfiere=new Label("- Alfiere: si muove in diagonale");
		torre=new Label("- Torre: si muove o in verticale o in orizzontale");
		re=new Label("- Re: si muove di una casella in tutte le direzioni");
		regina=new Label("- Regina: si muove in verticale, in orizzontale\n  e in diagonale");
		turno.setFont(Font.font("Arial", FontWeight.NORMAL, 18));
		informazioni = new Label("Il gioco termina quando il re viene mangiato,\n"
				+ "non esistono promozioni dei pedoni,\nmuove per primo sempre il bianco,\nsi muove una volta a testa.");
		
		// Aggiungi i label al pannello
		infoBox.getChildren().addAll(titolo,informazioni,turno,mosse,pedone,cavallo,alfiere,torre,re,regina);
		
		// Layout principale: scacchiera a sinistra, informazioni a destra
		HBox layoutPrincipale = new HBox();
		layoutPrincipale.getChildren().addAll(grid, infoBox);


		Scene scene = new Scene(layoutPrincipale);
		primaryStage.setTitle("Scacchiera");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private void mouseCliccato(StackPane cella, MouseEvent event) {
		ImageView pezzo = null;
		String vincitore;
		
		

		// Cerco nella cella cliccata se c'è un pezzo (escludendo il primo ImageView che
		// è lo sfondo)
		for (var node : cella.getChildren()) {
			if (node instanceof ImageView iv) {
				// Controllo che non è il primo ImageView ovvero lo sfondo e che ci sia
				// un'immagine
				if (cella.getChildren().indexOf(iv) != 0 && iv.getImage() != null) {
					pezzo = iv; // Assegno il pezzo trovato
					break; // Esco dal ciclo appena trovo il pezzo
				}
			}
		}

		// Controllo se non c'e nessun pezzo selezionato e se nella cella che clicco c'è
		// un pezzo
		if (cellaSelezionata == null && pezzo != null) {
			
			// Prendo il tipo del pezzo con UserData
			Object tipo = pezzo.getUserData();
			// Verifico che tipo di pezzo è
			if (tipo != null && (tipo.equals("pedone_bianco") || tipo.equals("pedone_nero")
					|| tipo.toString().contains("cavallo") || tipo.toString().contains("alfiere")
					|| tipo.equals("re_bianco") || tipo.equals("re_nero")||
					tipo.toString().contains("torre")|| tipo.toString().contains("regina"))) {
				// Se è un pezzo supportato, lo seleziono
				cellaSelezionata = cella;
				pezzoSelezionato = pezzo;
				System.out.println("Pezzo selezionato");
			} else {
				// sennò annullo tutto
				System.out.println("Pezzo non supportato. Selezione ignorata.");
				cellaSelezionata = null;
				pezzoSelezionato = null;
			}
			// Controllo se il pezzo è del colore corretto per il turno
			if ((turnoBianco && tipo.toString().contains("bianco")) ||
			    (!turnoBianco && tipo.toString().contains("nero"))) {
			    // Se è un pezzo supportato e del turno corretto, lo seleziono
			    cellaSelezionata = cella;
			    pezzoSelezionato = pezzo;
			} else {
			    System.out.println("Non è il tuo turno.");
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
			// PEDONE BIANCO
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
				 * controllo che va avanti di 1 che si sposta di una colonna che sia un'altro
				 * pezzo da poter mangiare e che sia un pezzo nero
				 */

				else if (startX - 1 == endX && Math.abs(startY - endY) == 1 && pezzo != null
						&& pezzo.getUserData() != null && pezzo.getUserData().toString().contains("nero")) {
					mossaValida = true;
				}
			}
			// PEDONE NERO
			else if (tipo != null && tipo.equals("pedone_nero")) {
				// Avanti di 1 senza mangiare
				if (startX + 1 == endX && startY == endY && pezzo == null) {
					mossaValida = true;
					// Avanti di 2 dalla riga iniziale
				} else if (startX == 1 && endX == 3 && startY == endY && pezzo == null) {
					mossaValida = true;
					// Mangia in diagonale
					/*
					 * controllo che va avanti di 1 che si sposta di una colonna che sia un'altro
					 * pezzo da poter mangiare e che sia un pezzo bianco
					 */
				} else if (startX + 1 == endX && Math.abs(startY - endY) == 1 && pezzo != null
						&& pezzo.getUserData() != null && pezzo.getUserData().toString().contains("bianco")) {
					mossaValida = true;
				}
			}
			// CAVALLI BIANCHI E NERI
			else if (tipo.toString().contains("cavallo")) {
				/*
				 * Calcolo nelle variabili la distanza delle righe e delle colonne da dove parte
				 * e dove arriva
				 */
			    int dx = Math.abs(startX - endX);
			    int dy = Math.abs(startY - endY);
			 // Controllo che il movimento sia di 2 passi e poi di 1 oppure il contrario
			    if ((dx == 2 && dy == 1) || (dx == 1 && dy == 2)) {
			 // Controllo se la casella dove lo sposto è vuota 
			        if (pezzo == null || 
			            (pezzo.getUserData() != null &&
			 // Controllo se il pezzo che sto spostando non contiene lo stesso colore del pezzo che voglio mangiare  
			             !pezzo.getUserData().toString().contains(
			                 tipo.toString().contains("bianco") ? "bianco" : "nero"))) {
			            mossaValida = true;
			        }
			    }
			}
			//RE BIANCO E NERO
			else if (tipo.equals("re_bianco") || tipo.equals("re_nero")) {

				//Calcolo il numero di righe e di colonne di differenza tra dove parto e dove arrivo
				int diffX = Math.abs(startX - endX);
				int diffY = Math.abs(startY - endY);
				// Il re può muoversi di una sola casella in qualsiasi direzione
				//Controllo verticale             controllo orizzontale          controllo diagonale
				if ((diffX == 1 && diffY == 0) || (diffX == 0 && diffY == 1) || (diffX == 1 && diffY == 1)) {
					// Controllo che la casella dove voglio spostare il pezzo 
					// non contenga un pezzo dello stesso colore di quello che voglio spostare
					if (pezzo == null || (
					tipo.toString().contains("bianco") && pezzo.getUserData().toString().contains("nero") ||
							tipo.toString().contains("nero") && pezzo.getUserData().toString().contains("bianco")
					)) {
						mossaValida = true;
					}
				}
			}
			// ALFIERI BIANCHI E NERI
			else if (tipo.toString().contains("alfiere")) {
				/*
				 * Calcolo nelle variabili la distanza delle righe e delle colonne da dove parte
				 * e dove arriva
				 */
				int dx = Math.abs(startX - endX);
				int dy = Math.abs(startY - endY);

				// Movimento diagonale
				if (dx == dy) {
					//Calcolo che se muove verso destra è +1 altrimenti -1
					int stepX = (endX - startX) > 0 ? 1 : -1;
					//Calcolo che se muove verso l'alto è +1 altrimenti -1
			        int stepY = (endY - startY) > 0 ? 1 : -1;

			        boolean ostacolo = false;

			        //for per scorrere tutte le caselle intermedie della diagonale
			        for (int i = 1; i < dx; i++) {
			        	//Calcolo tutte le coordinate di ogni casella intermedia
			            int x = startX + i * stepX;
			            int y = startY + i * stepY;

			            StackPane casellaIntermedia = null;

			            // Scorro tutti i nodi contenuti nella griglia
			            for (javafx.scene.Node node : grid.getChildren()) {
			            	//Per ogni nodi riprendo le righe e le colonne
			                Integer r = GridPane.getRowIndex(node);
			                Integer c = GridPane.getColumnIndex(node);
			                if (r == null) r = 0;
			                if (c == null) c = 0;

			                //Se la casella ha queste coordinate allora è la casella intermedia
			                if (r == x && c == y) {
			                	//Assegno a casellaIntermedia le coordinate della casella intermedia
			                    casellaIntermedia = (StackPane) node;
			                    break;
			                }
			            }
			            //se la casellaIntermedia non è vuota
			            if (casellaIntermedia != null) {
			                // Scorro tutti i figli di quella casella
			                for (javafx.scene.Node child : casellaIntermedia.getChildren()) {
			                //se trova un ImageView con qualcosa dentro 
			                //controlla che non sia il primo(quindi lo sfondo)
			                //se le condizioni sono vere allora c'è un ostacolo
			                    if (child instanceof ImageView iv && iv.getImage() != null && 
			                        casellaIntermedia.getChildren().indexOf(iv) != 0) {
			                        ostacolo = true;
			                        break;
			                    }
			                }
			            }
			            //Se c'è un ostacolo esco dal ciclo
			            if (ostacolo) {
			                break; 
			            }
			        }
			     // Controllo se non ci sono ostacoli
			        if (!ostacolo) {
			        	// Controllo che la casella sia vuota oppure che dove voglio spostare il pezzo 
						// contenga un pezzo di colore diverso quindi lo mangio e la mossa è valida
			            if (pezzo == null || (
								tipo.toString().contains("bianco") && pezzo.getUserData().toString().contains("nero") ||
								tipo.toString().contains("nero") && pezzo.getUserData().toString().contains("bianco")
						)) {
			                mossaValida = true;
			            } 
			        }
			    }
			}
			// TORRI BIANCHE E NERE
			else if (tipo.toString().contains("torre")) {
				/*
				 * Calcolo nelle variabili la distanza delle righe e delle colonne da dove parte
				 * e dove arriva
				 */
				int dx = Math.abs(startX - endX);
				int dy = Math.abs(startY - endY);

				// Movimento solo orizzontale o verticale
				if (dx == 0 || dy == 0) {
					//Primo controllo non si muove in verticale, poi se è positivo va in giù sennò in su
					int stepX = (endX - startX) == 0 ? 0 : (endX - startX > 0 ? 1 : -1);
					//Primo controllo non si muove in orizzontale, poi se è positivo va a destra sennò a sinistra
					int stepY = (endY - startY) == 0 ? 0 : (endY - startY > 0 ? 1 : -1);

					boolean ostacolo = false;

					//For per capire quanti passi Facciamo con Math.max
					for (int i = 1; i < Math.max(dx, dy); i++) {
					//stepX dice dove ti muovi, poi i* dice quante righe si deve muovere
						int x = startX + i * stepX;
					//stepY dice dove ti muovi, poi i* dice quante righe si deve muovere
						int y = startY + i * stepY;

						StackPane casellaIntermedia = null;

						 // Scorro tutti i nodi contenuti nella griglia
						for (javafx.scene.Node node : grid.getChildren()) {
							//Per ogni nodo riprendo le righe e le colonne
							Integer r = GridPane.getRowIndex(node);
							Integer c = GridPane.getColumnIndex(node);
							if (r == null) r = 0;
							if (c == null) c = 0;

							//Se la casella ha queste coordinate allora è la casella intermedia
							if (r == x && c == y) {
								//Assegno a casellaIntermedia le coordinate trovate sopra
								casellaIntermedia = (StackPane) node;
								break;
							}
						}

						//se la casellaIntermedia non è vuota
						if (casellaIntermedia != null) {
							// Scorro tutti i figli di quella casella
							for (javafx.scene.Node child : casellaIntermedia.getChildren()) {
								 //se trova un ImageView con qualcosa dentro 
				                //controlla che non sia il primo(quindi lo sfondo)
				                //se le condizioni sono vere allora c'è un ostacolo
								if (child instanceof ImageView iv && iv.getImage() != null &&
									casellaIntermedia.getChildren().indexOf(iv) != 0) {
									
									ostacolo = true;
									break;
								}
							}
						}

						//Se c'è un ostacolo esco dal ciclo
						if (ostacolo) {
							break;
						}
					}

					// Controllo se non ci sono ostacoli
					if (!ostacolo) {
						// Controllo che la casella sia vuota oppure che dove voglio spostare il pezzo 
						// contenga un pezzo di colore diverso quindi lo mangio e la mossa è valida
						if (pezzo == null || (
								tipo.toString().contains("bianco") && pezzo.getUserData().toString().contains("nero") ||
								tipo.toString().contains("nero") && pezzo.getUserData().toString().contains("bianco")
						)) {
							mossaValida = true;
						}
					}
				}
			}
			// REGINA BIANCA E NERA
			else if (tipo.toString().contains("regina")) {
				/*
				 * Calcolo nelle variabili la distanza delle righe e delle colonne da dove parte
				 * e dove arriva
				 */
				int dx = Math.abs(startX - endX);
				int dy = Math.abs(startY - endY);

				// La regina si muove in diagonale o in verticale e orizzontale
				if ((dx == dy) || (dx == 0 || dy == 0)) {

					// se stepX è +1 va giù se è -1 va su
					int stepX = (endX - startX) == 0 ? 0 : (endX - startX > 0 ? 1 : -1);
					// se stepY è +1 va a destra se è -1 va a sinistra
					int stepY = (endY - startY) == 0 ? 0 : (endY - startY > 0 ? 1 : -1);

					boolean ostacolo = false;

					// Controllo ogni casella intermedia tra partenza e arrivo
					for (int i = 1; i < Math.max(dx, dy); i++) {
						// x e y coordinate della prossima casella intermedia
						int x = startX + i * stepX;
						int y = startY + i * stepY;

						StackPane casellaIntermedia = null;

						// Scorro tutti i nodi contenuti nella griglia
						for (javafx.scene.Node node : grid.getChildren()) {
							//Per ogni nodo riprendo le righe e le colonne
							Integer r = GridPane.getRowIndex(node);
							Integer c = GridPane.getColumnIndex(node);
							if (r == null) r = 0;
							if (c == null) c = 0;

							//Se la casella ha queste coordinate allora è la casella intermedia
							if (r == x && c == y) {
							//Assegno a casellaIntermedia le coordinate trovate sopra
								casellaIntermedia = (StackPane) node;
								break;
							}
						}

						//se la casellaIntermedia non è vuota
						if (casellaIntermedia != null) {
							// Scorro tutti i figli di quella casella
							for (javafx.scene.Node child : casellaIntermedia.getChildren()) {
								//se trova un ImageView con qualcosa dentro 
				                //controlla che non sia il primo(quindi lo sfondo)
				                //se le condizioni sono vere allora c'è un ostacolo
								if (child instanceof ImageView iv && iv.getImage() != null &&
									casellaIntermedia.getChildren().indexOf(iv) != 0) {
									ostacolo = true;
									break;
								}
							}
						}

						//Se c'è un ostacolo esco dal ciclo
						if (ostacolo) {
							break;
						}
					}

					// Controllo se non ci sono ostacoli
					if (!ostacolo) {
						// Controllo che la casella sia vuota oppure che dove voglio spostare il pezzo 
						// contenga un pezzo di colore diverso quindi lo mangio e la mossa è valida
						if (pezzo == null || (
							tipo.toString().contains("bianco") && pezzo.getUserData().toString().contains("nero") ||
							tipo.toString().contains("nero") && pezzo.getUserData().toString().contains("bianco")
						)) {
							mossaValida = true;
						}
					}
				}
			}

			else {
				// Se è un movimento non supportato, annullo tutto
				System.out.println("Movimento non supportato. Selezione annullata.");
				cellaSelezionata = null;
				pezzoSelezionato = null;
				return;
			}
			// Se la mossa non è valida, blocco l'azione
			if (!mossaValida) {
				System.out.println("Mossa non valida!");
				cellaSelezionata = null;
				pezzoSelezionato = null;
				return;
			}
			// Ora sicuramente sarà una mossa valida
			// Adesso guardo se la nuova cella contiene un pezzo diverso da quello
			// selezionato
			if (pezzo != null && !pezzo.equals(pezzoSelezionato)) {
				// Rimuovo il pezzo mangiato
				cella.getChildren().remove(pezzo);
				System.out.println("Pezzo mangiato!");
			// Controllo se nella casella c'è un re 
				if (pezzo.getUserData() != null && pezzo.getUserData().toString().contains("re")) {
					// Se il pezzo mangiato è un Re, determina il vincitore
					if (pezzo.getUserData().toString().contains("bianco")) {
						vincitore="Nero";
						System.out.println("Ha vinto il nero");
					} else {
						vincitore="Bianco";
						System.out.println("Ha vinto il bianco");
					}

					// Mostro un messaggio di fine partita usando Alert che apre una piccol finestra 
					// e dice chi ha vinto e che la partita è finita
					Alert alert = new Alert(Alert.AlertType.INFORMATION);
					alert.setTitle("Scacco Matto");
					alert.setHeaderText(null);
					alert.setContentText("Scacco Matto! Ha vinto il " + vincitore+ "! Fine della partita.");
					alert.showAndWait();

					return; // Ferma il gioco
				}
			}
			// Altro caso sposto il pezzo selezionato nella nuova cella
			if (!cella.getChildren().contains(pezzoSelezionato)) {
				// Rimuovo il pezzo dalla cella da cui l'ho spostato
				cellaSelezionata.getChildren().remove(pezzoSelezionato);

				// Aggiungo il pezzo alla nuova cella
				cella.getChildren().add(pezzoSelezionato);
				System.out.println("Pezzo spostato.");
				// Cambio turno
				turnoBianco = !turnoBianco;
				turno.setText("Turno: " + (turnoBianco ? "Bianco" : "Nero"));
				System.out.println("Turno: " + (turnoBianco ? "Bianco" : "Nero"));
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
