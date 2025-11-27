package classe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Covoiturage {
    private final String idCovoiturage;
    private final List<Etudiant> participants;

    public Covoiturage(String idCovoiturage) {
        if (idCovoiturage == null || idCovoiturage.isEmpty()) {
            throw new IllegalArgumentException("L'id du covoiturage ne peut pas être vide.");
        }
        this.idCovoiturage = idCovoiturage;
        this.participants = new ArrayList<>();
    }

    public void ajouterParticipant(Etudiant e) {
        if (e == null) 
            throw new IllegalArgumentException("Étudiant nul interdit.");
        if (!participants.contains(e))
            participants.add(e);
    }

    public void retirerParticipant(Etudiant e) {
        if (!participants.contains(e)) return;

        if (participants.size() == 1) {
            throw new IllegalStateException("Un covoiturage ne peut pas être vidé : il doit contenir au moins un étudiant."
            );
        }

        participants.remove(e);

    }

    public List<Etudiant> getParticipants() {
        return Collections.unmodifiableList(participants);
    }


    public String getIdCovoiturage() {
        return idCovoiturage;
    }

    public boolean contient(Etudiant e) {
        return participants.contains(e);
    }

    public boolean chvauche(Covoiturage autre){
        for (Etudiant e : participants){
            if (autre.participants.contains(e)){
                return true;
            }
        }
        return false;
    }

    public void fusionnerAvec(Covoiturage autre){
        for (Etudiant e : autre.participants) {
            if (!participants.contains(e)) {
                participants.add(e);
            }
        }
    }

    @Override
    public String toString() {
        return "Covoiturage{" +
                "id='" + idCovoiturage + '\'' +
                ", participants=" + participants +
                '}';
    }
}
