package it.edu.iisgubbio.gioco;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Scacchiera extends Application{
	
	@Override
    public void start(Stage primaryStage) {
        // Creazione della GridPane per la scacchiera
        GridPane grid = new GridPane();

        // Dimensioni della scacchiera 8x8
        int dimensione = 8;
        
        
        // Caricamento delle immagini delle pedine
        Image biancoPedone = new Image(getClass().getResourceAsStream("pedone_bianco-1.png"));  // Percorso delle immagini
        Image neroPedone = new Image(getClass().getResourceAsStream("pedone_nero-1.png"));
        Image biancoRe = new Image(getClass().getResourceAsStream("re_bianco-1.png"));
        Image neroRe = new Image(getClass().getResourceAsStream("re_nero-1.png"));

        
        // Aggiunta delle pedine sulla scacchiera
        for (int riga = 0; riga < dimensione; riga++) {
            for (int colonna = 0; colonna < dimensione; colonna++) {
                // Creazione della ImageView per ogni pedina
                ImageView imageView = new ImageView();

                // Posizionamento delle pedine
                if (riga == 1) {
                    imageView.setImage(biancoPedone); // Pedoni bianchi
                } else if (riga == 6) {
                    imageView.setImage(neroPedone); // Pedoni neri
                } else if (riga == 0 && colonna == 4) {
                    imageView.setImage(biancoRe); // Re bianco
                } else if (riga == 7 && colonna == 4) {
                    imageView.setImage(neroRe); // Re nero
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
