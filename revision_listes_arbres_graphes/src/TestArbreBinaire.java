public class TestArbreBinaire {
    private TestArbreBinaire filsG;
    private int contenu;
    private TestArbreBinaire filsD;

    public TestArbreBinaire(int contenu) { this.contenu=contenu; }

    public static TestArbreBinaire inserer(int x, TestArbreBinaire a) {
        if (a == null) { return new TestArbreBinaire(x); }
        if (x < a.contenu) { a.filsG = inserer(x, a.filsG); } else if (x > a.contenu) { a.filsD = inserer(x, a.filsD); }
        return a;
    }

    public static void parcoursPrefixe(TestArbreBinaire a) {
        //depuis la racine, on parcours récursivement les fils de gauche à droite
        if (a == null) { return; }
        System.out.print(a.contenu + " ");
        parcoursPrefixe(a.filsG);
        parcoursPrefixe(a.filsD);
    }
    public static void parcoursInfixe(TestArbreBinaire a) {
        //on affiche le sous-arbre de gauche, la racine, puis le sous-arbre de droite
        if (a == null) { return; }
        parcoursInfixe(a.filsG);
        System.out.print(a.contenu + " ");
        parcoursInfixe(a.filsD);
    }
    public static void parcoursPostfixe(TestArbreBinaire a) {
        //on affiche le sous-arbre de gauche, puis le sous arbre de droite, puis la racine.
        if (a == null) { return; }
        parcoursPostfixe(a.filsG);
        parcoursPostfixe(a.filsD);
        System.out.print(a.contenu + " ");
    }

    /**
     * Recherche le contenu x dans l'arbre a.
     * @return l'arbre ayant x comme racine, ou null si x ne s'y trouve pas.
     */
    public static TestArbreBinaire chercher(int x, TestArbreBinaire a) {
        if (a == null || x == a.contenu) { return a; }
        return chercher(x, x < a.contenu ? a.filsG : a.filsD);
    }

    /**
     * Supprime de l'arbre a le noeud ayant x comme contenu.
     * @return l'arbre modifié.
     */
    public static TestArbreBinaire supprimer(int x, TestArbreBinaire a) {
        if (a == null) { return a; }
        if (x == a.contenu) { return supprimerNoeud(a); }
        if (x < a.contenu) { a.filsG = supprimer(x, a.filsG); } else { a.filsD = supprimer(x, a.filsD); }
        return a;
    }

    /**
     * Supprime le noeud reçu en paramètre.
     * @return le noeud remplaçant a, donc soit null si a était une feuille, soit le fils unique de a, ou sinon son prédécesseur.
     */
    private static TestArbreBinaire supprimerNoeud(TestArbreBinaire a) {
        //	si le noeud a est une feuille (n'a pas de fils), alors on l'élimine.
        //	si le noeud a possède un seul fils, on élimine a et on "remonte" ce fils.
        //	si le noeud a possède deux fils, on cherche le prédécesseur f de a. Celui-ci n'a pas de fils droit. On remplace le contenu de a par le contenu de f, et on élimine f.
        if (a.filsG == null) { return a.filsD; }
        if (a.filsD == null) { return a.filsG; }
        TestArbreBinaire f = dernierDescendant(a.filsG);
        a.contenu = f.contenu;
        a.filsG = supprimer(f.contenu, a.filsG);
        return a;
    }

    /**
     * Recherche la plus grande valeur dans a, donc le 1er noeud n'ayant pas de filsDroit.
     * @return le noeud ayant la plus grande valeur dans a.
     */
    private static TestArbreBinaire dernierDescendant(TestArbreBinaire a) {
        if (a.filsD == null) { return a; }
        return dernierDescendant(a.filsD);
    }

    public static void main (String[] args) {
        // 12 5 9 16 7 20 8 15 2 11 10 6
        TestArbreBinaire racine = new TestArbreBinaire(12);
        inserer(5, racine); inserer(9, racine); inserer(16, racine); inserer(7, racine); inserer(20, racine);
        inserer(8, racine); inserer(15, racine); inserer(2, racine); inserer(11, racine); inserer(10, racine); inserer(6, racine);

        parcoursPrefixe(racine);  System.out.println();
        parcoursInfixe(racine);   System.out.println();
        parcoursPostfixe(racine); System.out.println();

        supprimer(2, racine);
        supprimer(11, racine);
        supprimer(9, racine);
        parcoursInfixe(racine);   System.out.println();
    }
}