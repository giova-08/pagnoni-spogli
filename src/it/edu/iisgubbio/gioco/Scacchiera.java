package it.edu.iisgubbio.gioco;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Scacchiera extends Application{
	
	@Override
    public void start(Stage primaryStage) {
        // Creazione della GridPane per la scacchiera
        GridPane grid = new GridPane();
        

        // Dimensioni della scacchiera 8x8
        int dimensione = 8;
        
        Image scacchiera = new Image(getClass().getResourceAsStream("scacchiera.png"));
        ImageView sfondo=new ImageView();
        sfondo.setFitWidth(480);
        sfondo.setFitHeight(480);
        sfondo.setImage(scacchiera);
        grid.add(sfondo, 0, 0, 8,8);
        
        
        // Caricamento delle immagini delle pedine
        Image biancoPedone = new Image(getClass().getResourceAsStream("pedone_bianco-1.png"));  // Percorso delle immagini
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
        
        
     
        
        
        // Aggiunta delle pedine sulla scacchiera
        for (int riga = 0; riga < dimensione; riga++) {
            for (int colonna = 0; colonna < dimensione; colonna++) {
                // Creazione della ImageView per ogni pedina
                ImageView imageView = new ImageView();

                // Posizionamento delle pedine
                if (riga == 6) {
                    imageView.setImage(biancoPedone); // Pedoni bianchi
                } else if (riga == 1) {
                    imageView.setImage(neroPedone); // Pedoni neri
                } else if (riga == 7 && colonna == 4) {
                    imageView.setImage(biancoRe); // Re bianco
                } else if (riga == 0 && colonna == 4) {
                    imageView.setImage(neroRe); // Re nero
                }else if (riga == 7 && colonna == 5) {
                    imageView.setImage(biancoAlfiereDx); // Alfiere bianco a destra del Re bianco
                }else if (riga == 7 && colonna == 2) {
                    imageView.setImage(biancoAlfiereSx); // Alfiere bianco a sinistra della Regina bianca
                }else if (riga == 0 && colonna == 5) {
                    imageView.setImage(neroAlfiereDx); // Alfiere nero a destra del Re nero
                }else if (riga == 0 && colonna == 2) {
                    imageView.setImage(neroAlfiereSx); // Alfiere nero a sinistra della Regina nera
                }else if (riga == 7 && colonna == 3) {
                    imageView.setImage(biancoRegina); //  Regina bianca
                }else if (riga == 0 && colonna == 3) {
                    imageView.setImage(neroRegina); //  Regina nera
                }else if (riga == 7 && colonna == 6) {
                    imageView.setImage(biancoCavalloDx); //  Cavallo bianco a destra del Re bianco
                }else if (riga == 7 && colonna == 1) {
                    imageView.setImage(biancoCavalloSx); //  Cavallo bianco a sinistra della Regina bianca
                }else if (riga == 0 && colonna == 6) {
                    imageView.setImage(neroCavalloDx); //  Cavallo nero a destra del Re nero
                }else if (riga == 0 && colonna == 1) {
                    imageView.setImage(neroCavalloSx); //  Cavallo nero a sinistra della Regina nera
                }else if (riga == 7 && colonna == 7) {
                    imageView.setImage(biancoTorreDx); //  Torre bianca a destra del Re bianco
                }else if (riga == 7 && colonna == 0) {
                    imageView.setImage(biancoTorreSx); //  Torre bianca a destra della Regina bianca
                }else if (riga == 0 && colonna == 7) {
                    imageView.setImage(neroTorreDx); //  Torre nera a destra del Re bianco
                }else if (riga == 0 && colonna == 0) {
                    imageView.setImage(neroTorreSx); //  Torre nera a sinistra della Regina nera
                }

                // Imposta la larghezza e altezza per ogni immagine
                imageView.setFitWidth(60);
                imageView.setFitHeight(60);
                
                // Aggiungi l'immagine alla GridPane
                grid.add(imageView, colonna, riga);
            }
        }

        // Impostazioni della scena e della finestra
        Scene scene = new Scene(grid, 480, 480);
        primaryStage.setTitle("Scacchiera");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    } 

}
