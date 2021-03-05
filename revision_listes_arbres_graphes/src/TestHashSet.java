import java.util.ArrayList;
import java.util.HashSet;

public class TestHashSet {
    public static void theory() {
        //Un HashSet est une liste qui n'accepte pas de doublons
        //L'ordre n'a pas d'importance
        /*------------------------
              HashSet simple
        -------------------------*/
        System.out.println("------------------------- HashSet simple -------------------------");
        HashSet set = new HashSet();
        System.out.printf("Création d'un HashSet vide: ");System.out.println(set); //on peut afficher la liste entiere

        //Remplir la liste
        set.add("Hello"); set.add(44);
        set.add("World"); set.add(22);
        set.add(88); set.add("Hello");
        System.out.printf("Affichage de la liste remplie: ");System.out.println(set); //les doublons ne s'affichent pas

        /*------------------------
            HashSet typé
        -------------------------*/
        System.out.println("\n------------------------- HashSet typé -------------------------");
        HashSet<Integer> typedSet = new HashSet<>(); //déclaration d'un HashSet typé

        //Remplir la liste
        typedSet.add(11); typedSet.add(44);
        typedSet.add(33); typedSet.add(22);
        typedSet.add(88); typedSet.add(44);
        System.out.printf("Affichage de la liste typée remplie: "); System.out.println(typedSet); //les doublons ne s'affichent pas
        // typedSet.add("Hello"); //impossible d'ajouter du texte

        /*------------------------
           Parcourir le HashSet
        -------------------------*/
        System.out.println("\n------------------------- Parcourir le HashSet -------------------------");
        System.out.println("Parcours du HashSet avec une boucle for each");
        //on peut directement boucler sur les éléments car on connaît leur type (ici: int)
        for (int x : typedSet) { //lire : pour chaque entier x de la liste typedList
            System.out.println(x);
        }

    }

    public static void main(String[] args) {
        theory();
    }
}
