import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Etudiant {

    //attributs

    private Map<String, Integer> resultat;
    private Map<String, List<Integer>> notes;
    private Identite identite;

    // constructeur
    public Etudiant(Identite id){
        this.resultat = new HashMap<String, Integer>();
        this.identite = id;
    }

    //methodes

    public void ajouterNote(int note, String matiere){
        if (note<0 || note>20){
            if (!notes.containsValue(matiere)){
                notes.put(matiere, new ArrayList<Integer>());
            }
            notes.get(matiere).add(note);
        }
        else System.out.println("note non valide");
    }

    public void moyenneMatière(String matière){

    }

    public void moyenneGenerale(){

    }

}
