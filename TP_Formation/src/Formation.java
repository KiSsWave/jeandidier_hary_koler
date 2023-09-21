import java.util.HashMap;
import java.util.Map;

public class Formation {
    private String identifiant;
    private Map<String, Integer> matieres;

    public Formation(String identifiant) {
        this.identifiant = identifiant;
        this.matieres = new HashMap<>();
    }

    public void ajouterMatiere(String matiere, int coefficient) {
        matieres.put(matiere, coefficient);
    }

    public void supprimerMatiere(String matiere) {
        if (matieres.containsKey(matiere)) {
            matieres.remove(matiere);
        } else {
            System.out.println("La matière " + matiere + " est pas dans la formation.");
        }
    }

    public int coefficientMatiere(String matiere) {
        if(matieres.containsKey(matiere)){
            return matieres.get(matiere);
        } else{
            System.out.println("La matière "  + matiere  + " est pas dans la formation.");
        }
    }
}

