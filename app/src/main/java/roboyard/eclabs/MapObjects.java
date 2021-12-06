package roboyard.eclabs;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Alain on 21/01/2015.
 */
public class MapObjects {

    /*
     * Constructeur de la classe
     */
    public MapObjects(){

    }

    /*
     * Extract the data from the _data string
     * Returns a list of all extracted elements
     * Extrait les données de la chaine de caratère _data
     * Retourne une liste de tous les éléments extraits
     * @return ArrayList GridElement
     */
    public static ArrayList extractDataFromString(String data)
    {
        int x = 0;
        int y = 0;

        ArrayList<GridElement> elements = new ArrayList<GridElement>();

        // r=robot (vert, jeune, rouge, bleu)
        // c=target
        // m=wall (horizontal, vertival)
        List<String> objectTypes = Arrays.asList("mh", "mv", "rv", "rj", "rr", "rb", "cv", "cj", "cr", "cb", "cm");

        //On boucle pour chaque type d'objets
        //We loop for each type of object
        for(final String objectType: objectTypes) {

            List<String> allMatches = new ArrayList<String>();

            //On récupère toutes les lignes correspondant au type d'objet recherché
            //We retrieve all the lines corresponding to the type of object sought
            Matcher m = Pattern.compile(objectType+"\\d+,\\d+;").matcher(data);
            while (m.find()) {
                allMatches.add(m.group());
            }

            for(final String line: allMatches) {
                String[] values = line.split(",");
                //On extrait les coordonnées x et y
                if(values.length>=2) {
                    String valueX = values[0].replaceAll("[^0-9]", "");

                    if (valueX != "") {
                        x = Integer.decode(valueX);
                    }

                    String valueY = values[1].replaceAll("[^0-9]", "");

                    if (valueY != "") {
                        y = Integer.decode(valueY);
                    }

                    //On créé un Element GridElement correspondant à l'objet courant et on l'ajoute à la liste
                    GridElement p = new GridElement(x, y, objectType);
                    elements.add(p);
                }
            }
        }
        return elements;
    }

    /*
     * Génère une chaine de caractère contenant toutes les informations de la liste
     * @param Liste de GridElement contenant tout le contenu de la carte
     * @return String contenant toutes les informations de la carte
     */
    public static String createStringFromList( ArrayList<GridElement> data)
    {
        String content = "";

        //Pour chaque éléments, on ajoute une ligne contenant le type ainsi que la position x et y
        for(GridElement currentElement : data)
        {
            content += currentElement.getType() + currentElement.getX()+","+currentElement.getY()+";\n";
        }

        return content;
    }
}
