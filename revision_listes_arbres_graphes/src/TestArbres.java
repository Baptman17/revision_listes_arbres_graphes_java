import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestArbres {
    private Noeud racine;

    public TestArbres() { racine=null; } //à ce stade, notre arbre est vide

    //Noeud
    static class Noeud {
        //un noeud avec une valeur qui possède une liste de noeud enfants
        private String nom; //la valeur
        private List<Noeud> fils; //les enfants, forcément des noeuds
        public Noeud(String nom, List<Noeud> fils) {
            this.nom=nom;
            this.fils=fils;
        }
        public String toString() { return nom; }
    }

    //méthodes de l'arbre

    public Noeud getRacine() {
        return racine;
    }

    public Noeud creer(String nom, Noeud... fils) {
        //on créé une liste de noeuds (enfants) si des enfants sont passés en paramètre
        //Si aucun fils n'est passé, il n'y a pas d'enfant et la liste est null
        List<Noeud> lstFils = fils.length==0 ? null : new ArrayList<>(Arrays.asList(fils));
        return racine = new Noeud(nom, lstFils);
    }

    public void parcoursArbre(Noeud n) {
        //On appelle la fonction avec un noeud à analyser (d'abord le noeud racine)
        System.out.println(n.nom);
        if (n.fils != null) { //si le noeud à une liste de noeuds enfants
            for (Noeud f : n.fils) { //pour chacun des noeuds enfant
                parcoursArbre(f); //on appelle la fonction d'affichage du nom avec le noeud enfant
            }
        }
    }

    public static void main(String[] args) {
        TestArbres a = new TestArbres(); //on créé un objet arbre vide
        a.creer("Adam",a.creer("Barry",a.creer("Caren"),a.creer("Carla",a.creer("Daria"),a.creer("Daryl")),a.creer("Caro")),a.creer("Ben",a.creer("Celia")),a.creer("Bill"),a.creer("Bob",a.creer("Cody",a.creer("Doly")),a.creer("Colin"),a.creer("Cora")));
        a.parcoursArbre(a.getRacine());
    }
}
