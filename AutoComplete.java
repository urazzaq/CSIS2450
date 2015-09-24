


import java.util.Arrays;
import java.util.Comparator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Umer Razzaq
 */
public class AutoComplete  {
    Term[] term;
    Term[] matches;
      // Initialize the data structure from the given array of terms.
    public AutoComplete(Term[] terms)
    {   this.term = new Term[]{};
        term = terms;
        
    }

    // Return all terms that start with the given prefix, in descending order of weight.
    public Term[] allMatches(String prefix)  
    {   int r = prefix.length();
        
        Term.reverseOrder rwo = new Term.reverseOrder();
        Arrays.sort(term,rwo);
        Comparator<Term> pfp= new Term.prefixOrder(r);
        int first = BinarySearchDeluxe.firstIndexOf(term, r, pfp);
        int last = BinarySearchDeluxe.lastIndexOf(term,r,pfp);
        for (int i = first; i <= last; i++) {
         matches = new Term[]{term[i]} ;
        }
        return matches;
        
    }

    // Return the number of terms that start with the given prefix.
    public int numberOfMatches(String prefix)
    { int r = prefix.length();
    int size = matches.length;
    return size;
    
    
    
    }
}
