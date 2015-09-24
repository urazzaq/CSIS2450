
import java.nio.file.Path;
import java.nio.file.Paths;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Umer Razzaq
 */
public class AutoCompleteApp {
    public static void main(String[] args) {

    // read in the terms from a file
    Path p = Paths.get("C:\\Users\\Umer Razzaq\\Documents\\NetBeansProjects\\AutoComplete03-UmeRazzaq\\src\\cities.txt");
    String filename = p.getFileName().toString();
    In in = new In(filename);
    int N = in.readInt();
    Term[] terms = new Term[N];
    for (int i = 0; i < N; i++) {
        double weight = in.readDouble();       // read the next weight
        in.readChar();                         // scan past the tab
        String query = in.readLine();          // read the next query
        terms[i] = new Term(query, weight);    // construct the term
    }

    // read in queries from standard input and print out the top k matching terms
    
    AutoComplete autocomplete = new AutoComplete(terms);
    while (in.hasNextLine()) {
        String prefix = in.readLine();
        Term[] results = autocomplete.allMatches(prefix);
        for (int i = 0; i <  results.length; i++)
            StdOut.println(results[i]);
    }
}
}
