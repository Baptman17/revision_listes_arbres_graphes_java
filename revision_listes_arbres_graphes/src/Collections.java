import java.util.*;

public class Collections {
    private static <T extends Collection<Integer>> void remplir(T lst) { //Méthode générique
        lst.add(11); lst.add(44);
        lst.add(33); lst.add(22);
        lst.add(88); lst.add(44);
    }

    private static <T extends Map<Integer, String>> void remplir(T lst) { //Méthode générique
        lst.put(11, "Onze"); lst.put(44, "Quarante-quatre");
        lst.put(33, "Trente-trois"); lst.put(22, "Vingt-deux");
        lst.put(88, "Huitante-huit"); lst.put(44, "Quarante-quatre bis");
    }

    private static void testArrayList() {
        ArrayList<Integer> lst = new ArrayList<>();
        remplir(lst);
        System.out.println(lst);
    }

    private static void testHashSet() {
        //Pas de doublons, écrase la première valeur à double
        HashSet<Integer> lst = new HashSet<>();
        remplir(lst);
        System.out.println(lst);
    }

    private static void testTreeSet() {
        //Pas de doublons, écrase la première valeur à double
        //Trié
        TreeSet<Integer> lst = new TreeSet<>();
        remplir(lst);
        System.out.println(lst);
    }

    private static void testLinkedHashSet() {
        //Pas de doublons, conserve la première valeur à double
        LinkedHashSet<Integer> lst = new LinkedHashSet<>();
        remplir(lst);
        System.out.println(lst);
    }

    private static void testHashMap() {
        //On travaille avec la clé et la valeur. On doit préciser le type de la clé et le type de la valeur.
        //Les clés sont uniques
        HashMap<Integer, String> lst = new HashMap<>();
        remplir(lst);
        System.out.println(lst);
        //Boucle d'affichage
        System.out.println("##############################################################");
        System.out.println("Boucle HashMap : ");
        for (Map.Entry<Integer, String> paire : lst.entrySet()) {
            //System.out.println(paire);
            System.out.println(paire.getKey() + " : " + paire.getValue());
        }
        System.out.println("##############################################################");
    }

    private static void testTreeMap() {
        //On travaille avec la clé et la valeur. On doit préciser le type de la clé et le type de la valeur.
        //Les clés sont uniques
        TreeMap<Integer, String> lst = new TreeMap<>();
        remplir(lst);
        System.out.println(lst);
        //Boucle d'affichage
        System.out.println("##############################################################");
        System.out.println("Boucle TreeMap : ");
        for (Map.Entry<Integer, String> paire : lst.entrySet()) {
            //System.out.println(paire);
            System.out.println(paire.getKey() + " : " + paire.getValue());
        }
        System.out.println("##############################################################");

    }


    public static void main(String[] args) {
        System.out.print("ArrayList     : "); testArrayList();
        System.out.print("HashSet       : "); testHashSet();
        System.out.print("TreeSet       : "); testTreeSet();
        System.out.print("LinkedHashSet : "); testLinkedHashSet();
        System.out.print("HashMap       : "); testHashMap();
        System.out.print("TreeMap       : "); testTreeMap();

    }
}
