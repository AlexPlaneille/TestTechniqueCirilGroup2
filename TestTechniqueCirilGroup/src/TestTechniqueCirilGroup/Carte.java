package TestTechniqueCirilGroup;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Carte {
    private char[][] grille;

    private Carte(char[][] grille) {
        this.grille = grille;
    }

    public static Carte chargerCarte(String chemin) throws IOException {
        // Lire le fichier txt ou est la carte
        BufferedReader reader = new BufferedReader(new FileReader(chemin));
        String ligne;
        int lignes = 0;
        int colonnes = 0;

        while ((ligne = reader.readLine()) != null) {
            lignes++;
            colonnes = Math.max(colonnes, ligne.length());
        }

        reader.close();

        char[][] grille = new char[lignes][colonnes];
        reader = new BufferedReader(new FileReader(chemin));

        int i = 0;
        while ((ligne = reader.readLine()) != null) {
            char[] ligneChars = ligne.toCharArray();
            System.arraycopy(ligneChars, 0, grille[i], 0, ligneChars.length);
            i++;
        }

        reader.close();
        return new Carte(grille);
    }
    
    public char getCase(int x, int y) {
        return grille[y][x];
    }

    public int getLargeur() {
        return grille[0].length;
    }

    public int getHauteur() {
        return grille.length;
    }
}

