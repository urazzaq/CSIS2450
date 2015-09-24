

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
public class Tester {
     public static void main(String[] args) {
        Term term1 = new Term("testOne",12412.55);
        Term term2 = new Term("testtwo",12415.55);
        Term term3 = new Term("testthree",12515.55);
         Term[] term = new Term[]{term1,term2,term3};
         for (Term term4 : term) {
             System.out.println(term4);
           
         }
         Comparator<Term> rwo = new Term.reverseOrder();
         Arrays.sort(term,rwo);
         for (Term term4 : term) {
             System.out.println(term4);
           
         }
         
     }
     }