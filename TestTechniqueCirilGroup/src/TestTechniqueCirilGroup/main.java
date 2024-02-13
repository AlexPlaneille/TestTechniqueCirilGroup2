package TestTechniqueCirilGroup;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;

public class main {
    public static void main(String[] args) throws IOException {

    	try {
    		
            Carte carte = Carte.chargerCarte("chemin/vers/carte.txt");

            
            // Déplacer le personnaghe
            Personnage personnage = new Personnage(carte);
            personnage.deplacer("carte v2.txt");

            // Afficher la position finale du personnage
            System.out.println("Position finale du personnage : " + personnage.getPosition());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

