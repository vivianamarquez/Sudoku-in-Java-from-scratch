package Modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Score {

    private Map<String, Integer> scores = new HashMap<String, Integer>();

    public Score() {
        loadScore();
    }

    private void loadScore() {

        try {

            File archive = new File("Score/Score.txt");

            // if file doesnt exists, then create it
            if (!archive.exists()) {
                archive.createNewFile();
            }

            FileReader fr = new FileReader(archive);
            BufferedReader br = new BufferedReader(fr);

            String auxiliar = "";

            while ((auxiliar = br.readLine()) != null) {

                String aux[] = auxiliar.split(" ");
                this.scores.put(aux[0], Integer.parseInt(aux[aux.length-1]));

            }

            fr.close();
            br.close();

        } catch (Exception e) {
            System.err.println("Error reading files.");
        }

    }

    public void sort() {

        //Organiza el puntaje de mayor a menor
        this.scores = sortScore(this.scores);

        try {
            File archive = new File("Score/Score.txt");

            clearScore();
            FileWriter fw = new FileWriter(archive, true);

            for (String s : this.scores.keySet()) {
                fw.append(s + " " + this.scores.get(s) + "\n");
            }
            fw.close();
        } catch (Exception e) {
            System.err.println("Error reading files.");
        }

    }

    public <K, V extends Comparable<? super V>> Map<K, V> sortScore(final Map<K, V> mapToSort) {

        //Lista del tamaño del HashMap
        List<Map.Entry<K, V>> entries = new ArrayList<Map.Entry<K, V>>(mapToSort.size());

        //Agrega todas 
        entries.addAll(mapToSort.entrySet());

        //Lo organiza con el comparator
        Collections.sort(entries, new Comparator<Map.Entry<K, V>>() {

            //Cómo los compara
            public int compare(final Map.Entry<K, V> entry1, final Map.Entry<K, V> entry2) {
                return entry2.getValue().compareTo(entry1.getValue());
            }
        });

        //Crea Mapa ya organizado. :O Con linkedhash! Extiende de linkedhash.
        Map<K, V> sortedMap = new LinkedHashMap<K, V>();

        //Llena el mapa.
        for (Map.Entry<K, V> entry : entries) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;

    }

    public void addScore(String name) {

        if (name.isEmpty()) {

        } else {

            try {

                File archive = new File("Score/Score.txt");

                if (this.scores.containsKey(name)) {

                    this.scores.put(name, (this.scores.get(name) + 1));

                    clearScore();
                    
                    //True para que no sobre-escriba el archivo, sino que lo escriba al final.
                    FileWriter fw = new FileWriter(archive, true);

                    for (String s : this.scores.keySet()) {
                        fw.append(s + " " + this.scores.get(s) + "\n");
                    }
                    fw.close();

                } else {
                    this.scores.put(name, 1);

                    clearScore();
                    
                    //True para que no sobre-escriba el archivo, sino que lo escriba al final.
                    FileWriter fw = new FileWriter(archive, true);

                    for (String s : this.scores.keySet()) {
                        fw.append(s + " " + this.scores.get(s) + "\n");
                    }
                    fw.close();

                }

            } catch (Exception e) {
                System.err.println("Error reading files.");
            }
        }
    }

    public void clearScore() {

        try {

            File archive = new File("Score/Score.txt");
            //False para que sobre-escriba el archivo.
            FileWriter fw = new FileWriter(archive, false);
            fw.append("");
            fw.close();

        } catch (Exception e) {
            System.err.println("Error reading files.");
        }

    }

    public String toString() {

        String ans = "";
        int cont = 0;
        sort();

        for (String s : this.scores.keySet()) {
            ans = ans + s + "\t" + this.scores.get(s) + " puntos.\n";
            cont++;
            if (cont > 10) {
                break;
            }
        }

        return ans;

    }

    public Map<String, Integer> getArray() {
        sort();
        return this.scores;
    }

}
