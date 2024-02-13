package TestTechniqueCirilGroup;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Personnage {
    private Carte carte;
    private int x, y;
    String personnage = "*";

    public Personnage(Carte carte) {
        this.carte = carte;
    }

    public void deplacer(String chemin) throws IOException {
    	
    	BufferedReader reader = new BufferedReader(new FileReader(chemin));
        String coordonneesInitiales = reader.readLine();
        String[] coordonnees = coordonneesInitiales.split(",");
        x = Integer.parseInt(coordonnees[0]);
        y = Integer.parseInt(coordonnees[1]);

        String deplacements = reader.readLine();
        char[] deplacementsChars = deplacements.toCharArray();

        for (char deplacement : deplacementsChars) {
            commande(deplacement);
        }

        reader.close();
        
    }
    
    private void commande(char direction) {
        switch (direction) {
            case 'N':
                if (y > 0 && carte.getCase(x, y - 1) == ' ')
                    y--;
                break;
            case 'S':
                if (y < carte.getHauteur() - 1 && carte.getCase(x, y + 1) == ' ')
                    y++;
                break;
            case 'E':
                if (x < carte.getLargeur() - 1 && carte.getCase(x + 1, y) == ' ')
                    x++;
                break;
            case 'O':
                if (x > 0 && carte.getCase(x - 1, y) == ' ')
                    x--;
                break;
        }
    }

    public String getPosition() {
        return "(" + x + "," + y + ")";
    }
    
}
