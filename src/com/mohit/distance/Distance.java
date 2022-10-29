package com.mohit.distance;

public class Distance {
    public static void main(String[] args) {
        LevenshteinDistance levenshtein = new LevenshteinDistance();
        System.out.println("computer > commuter: " + levenshtein.findMinDistance("computer", "commuter"));
        System.out.println("kitten > sitting: " + levenshtein.findMinDistance("kitten", "sitting"));
        System.out.println("party > park: " + levenshtein.findMinDistance("party", "park"));
        System.out.println("Carry > Bark: " + levenshtein.findMinDistance("Carry", "Bark"));
    }
}
