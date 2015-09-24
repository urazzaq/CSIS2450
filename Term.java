
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
public class Term implements Comparable<Term> {

    private String queryItem;
    private double itemWeight;
    public static int rValue;
    public static final Comparator<Term> prefix = new prefixOrder(rValue);
    public static final Comparator<Term> reverseWeight = new reverseOrder();

    // Initialize a term with the given query string and weight.
    public Term(String query, double weight) {
        queryItem = query;
        itemWeight = weight;
    }

    /**
     * Compare the terms in descending order by weight.
     */
    public static class reverseOrder implements Comparator<Term> {

        @Override
        public int compare(Term v, Term w) {

            if (v.itemWeight == w.itemWeight) {
                return 0;
            } else if (v.itemWeight > w.itemWeight) {
                return 1;
            } else {
                return -1;
            }
        }

    }

    /**
     * Compare the terms in lexicographic order but using only the first r
     * characters of each query.
     */
    public static class prefixOrder implements Comparator<Term> {
        private int rval;
        public prefixOrder(int r) {
            rval = r;
        }

      

        @Override
        public int compare(Term v, Term w) {
            return v.queryItem.substring(0,rval).compareTo(w.queryItem.substring(0,rval));
        }

    }

    // Compare the terms in lexicographic order by query.
    @Override
    public int compareTo(Term that) {
        return this.queryItem.toLowerCase().compareTo(that.queryItem.toLowerCase());
    }

    // Return a string representation of the term in the following format:
    // the weight, followed by a tab, followed by the query.
    @Override
    public String toString() {
        return String.format("%f\t%s ", itemWeight, queryItem);
    }

}
