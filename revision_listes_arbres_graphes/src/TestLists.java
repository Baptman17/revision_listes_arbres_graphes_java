import java.util.ArrayList;

public class TestLists {

    public static void theory() {
        /*------------------------
            ArrayList simple
        -------------------------*/
        System.out.println("------------------------- ArrayList simple -------------------------");
        ArrayList aLst = new ArrayList(); //déclaration d'une ArrayList
        System.out.printf("Création d'une liste vide: ");System.out.println(aLst); //on peut afficher la liste entiere

        //Remplir la liste
        aLst.add("Hello"); aLst.add("World"); aLst.add(123); aLst.add("Hello"); //n'importe quel type de valeurs est accepté, les doublons aussi
        System.out.printf("Affichage de la liste remplie: ");System.out.println(aLst);

        /*------------------------
            ArrayList typée
        -------------------------*/
        System.out.println("\n------------------------- ArrayList typée -------------------------");
        ArrayList<Integer> typedList = new ArrayList<>(); //déclaration d'une ArrayList typée

        //Remplir la liste
        typedList.add(11); typedList.add(22); typedList.add(33); typedList.add(22); //on remplit avec des integer, les doublons sont acceptés
        System.out.printf("Affichage de la liste typée remplie"); System.out.println(typedList);
        // typedList.add("Hello"); //impossible d'ajouter du texte

        /*------------------------
           Parcourir l'ArrayList
        -------------------------*/
        System.out.println("\n------------------------- Parcourir l'ArrayList -------------------------");
        System.out.println("Parcours de la liste avec une boucle classique: ");
        for (int i=0; i<aLst.size(); i++) {
            System.out.printf("Tour " +  i + " : ");System.out.println(aLst.get(i)); //on récupère l'élément de la liste selon son index : .get(i)
        }

        System.out.println("\nParcours de la liste avec une boucle for each");
        //on peut directement boucler sur les éléments car on connaît leur type (ici: int)
        for (int x : typedList) { //lire : pour chaque entier x de la liste typedList
            System.out.println(x);
        }

    }

    public static void main(String[] args) {
        theory();
    }
}
