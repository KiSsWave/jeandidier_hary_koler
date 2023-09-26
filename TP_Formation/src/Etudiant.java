import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Etudiant {
    private Identite identite;
    private Formation formation;
    private Map<String, List<Integer>> notes;

    public Etudiant(Identite identite, Formation formation) {
        this.identite = identite;
        this.formation = formation;
        this.notes = new HashMap<>();
    }

    public void ajouterNote(String matiere, int note) {
        if (formation.contientMatiere(matiere) && note >= 0 && note <= 20) {
            if (!notes.containsKey(matiere)) {
                notes.put(matiere, new ArrayList<>());
            }
            notes.get(matiere).add(note);
        } else {
            System.out.println("Impossible d'ajouter la note. Vérifiez la matière ou la note.");
        }
    }

    public double calculerMoyenneMatiere(String matiere) {
        if (notes.containsKey(matiere)) {
            List<Integer> listeNotes = notes.get(matiere);
            if (listeNotes.isEmpty()) {
                System.out.println("Aucune note trouvée pour la matière '" + matiere + "'.");
                return -1;
            }
            double somme = 0.0;
            for (int note : listeNotes) {
                somme += note;
            }
            return somme / listeNotes.size();
        } else {
            System.out.println("Aucune note trouvée pour la matière '" + matiere + "'.");
            return -1;
        }
    }

    public double calculerMoyenneGenerale() {
        double sommeNotes = 0.0;
        double sommeCoefficients = 0.0;

        for (String matiere : notes.keySet()) {
            double moyenneMatiere = calculerMoyenneMatiere(matiere);
            int coefficient = formation.getCoefMatiere(matiere);
            sommeNotes += moyenneMatiere * coefficient;
            sommeCoefficients += coefficient;
        }
        return sommeNotes / sommeCoefficients;
    }

    public Identite getIdentite() {
        return identite;
    }

    public Formation getFormation() {
        return formation;
    }

    public Map<String, List<Integer>> getNotes() {
        return notes;
    }


}

