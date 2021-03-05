import java.util.*;

public class TestGraph {
    private Map<Integer, List<Integer>> lstNoeuds; // chaque noeud et la liste de ses relations
    private boolean oriente;

    public TestGraph(boolean oriente) {
        this.oriente = oriente;
        lstNoeuds = new HashMap<>();
    }

    public void addNoeud(int noeud) {
        //si le noeud à ajouter n'est pas une clé existante dans la liste des noeuds, on peut ajouter le nouveau noeud
        if (!lstNoeuds.keySet().contains(noeud)) {
            lstNoeuds.put(noeud, null);
        }
    }

    public void addRelation(int source, int destination) {
        addNoeud(source);
        addNoeud(destination);
        addArc(source, destination);
        if (!oriente) { addArc(destination, source); } //dans le cas d'un graphe non orienté

    }

    private void addArc(int source, int destination) {
        List<Integer> relations = lstNoeuds.get(source); //liste d'integer lié à la source
        if (relations == null) { //s'il n'y a pas encore de relation
            //on créé une nouvelle liste de relations
            relations = new LinkedList<>();
            relations.add(destination); //on ajoute la destination qui est une nouvelle relation de la source
            lstNoeuds.put(source, relations); //on met à jour la liste des noeuds du graphe, une map n'a pas de clé doublon
        } else { //le noeud source à déjà une liste de relations
            relations.add(destination); //on ajoute la destination à la liste déjà existante
        }
    }

    private void afficherRelations() {
        //parcourir chaque noeud de la liste des noeuds pour afficher sa liste de relations
        for (int source : lstNoeuds.keySet()) {
            System.out.print(source + " est en relation avec : ");
            if(lstNoeuds.get(source) != null) { //si le noeud a des relations
                for (int relation : lstNoeuds.get(source)) {
                    System.out.print(relation + " ");
                }
            }
            System.out.println();
        }
    }

    private int nombreDIles() {
        //on parcours tous les noeuds. Si le noeud n'est pas visité on incrémente un cpt puis on flag ses voisins comme visités
        int nb = 0; //cpt à incrémenter
        boolean[] dejaVisite = new boolean[lstNoeuds.size()]; //liste des noeud déjà visités
        for (int noeud : lstNoeuds.keySet()) { //pour chaque noeud de la liste (on parcourt les clés)
            if(!dejaVisite[noeud]) { //si le noeud n'a pas encore été visité
                nb++; //on incrémente le compteur
                parcourirProfondeur(noeud, dejaVisite); //on parcours toutes les relations de ce noeud pour les marquer comme visité
            }
        }
        return nb;
    }

    private void parcourirProfondeur(int noeud, boolean[] dejaVisite) {
        if(dejaVisite[noeud]) { return; } //point d'arrêt, on sort de la fonction si on tombe sur un noeud visité
        dejaVisite[noeud] = true; //le noeud courant est maintenant visité

        if (lstNoeuds.get(noeud) != null) { //si le noeud a des relations, il faut aussi les marquer comme visité
            for (int relation : lstNoeuds.get(noeud)) { //pour chaque noeud voisin du noeud courant
                parcourirProfondeur(relation, dejaVisite); //on va le marquer comme visité et visiter ses relations
            }
        }
    }

    private boolean contientUnCycle() {
        //on parcourt tous les noeuds et on parcourt leurs relations à la recherche d'une boucle (un cycle)
        for (int source : lstNoeuds.keySet()) { //pour chaque noeuds de la liste (on parcourt les clés)
            if (contientUnCycle(source)) {
                return true;
            }
        }
        return false;
    }

    private boolean contientUnCycle(int source) {
        boolean[] dejaVisite = new boolean[lstNoeuds.size()]; //liste des noeuds déjà visités
        if (lstNoeuds.get(source) != null) { //si le noeud a des voisins
            for (int voisin : lstNoeuds.get(source)) { //on parcourt les voisins du noeud courant
                if(contientUnCycle(voisin, source, dejaVisite)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean contientUnCycle(int noeud, int destination, boolean[] dejaVisite) {
        dejaVisite[noeud] = true; //le noeud courant est maintenant visité
        if (noeud == destination) { return true; } //si on retombe sur le noeud de départ
        if (lstNoeuds.get(noeud) != null) {
            for (int voisin : lstNoeuds.get(noeud)) {
                if (!dejaVisite[voisin]) {
                    if (contientUnCycle(voisin, destination, dejaVisite)) { return true; }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("Graph 1 (non orienté)");
        TestGraph g1 = new TestGraph(false);
        g1.addRelation(0,1); g1.addRelation(0,3);
        g1.addRelation(1,4); g1.addRelation(2,0);
        g1.addRelation(3,1); g1.addRelation(3,2);
        g1.addRelation(4,5); g1.addRelation(5,3);
        g1.afficherRelations();
        System.out.println("Nombre d'îles de g1 = " + g1.nombreDIles());
        System.out.println();


        System.out.println("Graph 2 (non orienté)");
        TestGraph g2 = new TestGraph(false);
        g2.addRelation(0,1); g2.addRelation(2,1);
        g2.addRelation(3,1); g2.addRelation(2,3);
        g2.addRelation(0,3); g2.addRelation(6,5);
        g2.addNoeud(4);
        g2.afficherRelations();
        System.out.println("Nombre d'îles de g2 = " + g2.nombreDIles());
        System.out.println();

        System.out.println("Graph 3 (orienté)");
        TestGraph g3 = new TestGraph(true);
        g3.addRelation(0,1); g3.addRelation(4,0);
        g3.addRelation(4,2); g3.addRelation(2,1);
        g3.addRelation(2,3); g3.addRelation(3,4);
        g3.afficherRelations();
        System.out.println("G3 contient un cycle : " + g3.contientUnCycle());
        System.out.println();
    }
}
