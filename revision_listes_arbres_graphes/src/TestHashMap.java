import java.util.HashMap;
import java.util.Map;

public class TestHashMap {

    public static void theory() {
        /*------------------------
                HashMap
        -------------------------*/
        System.out.println("------------------------- HashMap -------------------------");
        //On travaille avec la clé et la valeur. On doit préciser le type de la clé et le type de la valeur.
        //Les clés sont uniques
        HashMap<Integer, String> map = new HashMap<>(); //déclaration d'une HashMap, on précise le type des clés et des valeurs
        System.out.printf("Création d'une HashMap vide: ");System.out.println(map);

        //Remplir la map
        //On ajoute (put) un élément en spécifiant sa clé (int) et sa valeur (string)
        map.put(11, "Onze"); map.put(44, "Quarante-quatre");
        map.put(33, "Trente-trois"); map.put(22, "Vingt-deux");
        map.put(88, "Huitante-huit"); map.put(44, "Quarante-quatre bis");
        System.out.printf("Affichage de la liste remplie: ");System.out.println(map); //les clés sont uniques, on écrase la valeur

        /*------------------------
           Parcourir l'HashMap
        -------------------------*/
        System.out.println("\n------------------------- Parcourir l'HashMap -------------------------");
        for (Map.Entry<Integer, String> paire : map.entrySet()) {
            //On récupère les paires (clé/valeur) de la map selon le type
            //la clé est stockée dans    : paire.getKey()
            //la valeur est stockée dans : paire.getValue()
            System.out.println(paire.getKey() + " : " + paire.getValue());
        }

        /*------------------------
           Autres fonctions
        -------------------------*/
        System.out.println("\n------------------------- Autres fonctions de l'HashMap -------------------------");
        System.out.printf("Récupérer un élément grâce à sa clé (22) : "); System.out.println(map.get(22));
        System.out.printf("Vérifier l'existance d'une clé (2) : ");System.out.println(map.containsKey(2));
    }

    public static void main(String[] args) {
        theory();
    }
}
