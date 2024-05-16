/*
 * Name: Jaznik Patel
 * PID:  A17268450
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Search Engine implementation.
 * 
 * @author Jaznik Patel
 * @since  May 13 2024
 */
public class SearchEngine {

    /**
     * Populate BSTrees from a file
     * 
     * @param movieTree  - BST to be populated with actors
     * @param studioTree - BST to be populated with studios
     * @param ratingTree - BST to be populated with ratings
     * @param fileName   - name of the input file
     * @returns false if file not found, true otherwise
     */
    public static boolean populateSearchTrees(
            BSTree<String> movieTree, BSTree<String> studioTree,
            BSTree<String> ratingTree, String fileName
    ) {
        File file = new File(fileName);
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                // read 5 lines per batch:
                // movie, cast, studios, rating, trailing hyphen
                String movie = scanner.nextLine().trim();
                String cast[] = scanner.nextLine().split(" ");
                String studios[] = scanner.nextLine().split(" ");
                String rating = scanner.nextLine().trim();
                scanner.nextLine();
                for (String actor : cast) {
                    actor = actor.toLowerCase().trim();
                    insertIntoTree(movieTree, actor, movie);
                    insertIntoTree(ratingTree, actor, rating);
                }
                for (String studio : studios) {
                    studio = studio.toLowerCase().trim();
                    insertIntoTree(studioTree, studio, movie);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            return false;
        }
        return true;
    }
    private static void insertIntoTree(BSTree<String> tree, String key, String value) {
        if (!tree.insert(key)) {
            tree.insertData(key, value);
        } else {
            tree.getRoot().addNewInfo(value);
        }
    }

    /**
     * Search a query in a BST
     * 
     * @param searchTree - BST to be searched
     * @param query      - query string
     */
    public static void searchMyQuery(BSTree<String> searchTree, String query) {
        /* Searches the Query */
        String[] keys = query.toLowerCase().split(" ");
    }

    /**
     * Print output of query
     * 
     * @param query     Query used to search tree
     * @param documents Output of documents from query
     */
    public static void print(String query, LinkedList<String> documents) {
        if (documents == null || documents.isEmpty())
            System.out.println("The search yielded no results for " + query);
        else {
            Object[] converted = documents.toArray();
            Arrays.sort(converted);
            System.out.println("Documents related to " + query
                    + " are: " + Arrays.toString(converted));
        }
    }

    /**
     * Main method that processes and query the given arguments
     * 
     * @param args command line arguments
     */
    public static void main(String[] args) {
        String fileName = args[0];
        int searchKind = Integer.parseInt(args[1]);
        if (args.length < 3) {
            System.out.println("Usage: java Main <file_name> <search_kind> <keyword1> <keyword2> ...");
            return;
        }
        try {
            searchKind = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            System.out.println("Search kind must be an integer.");
            return;
        }
        String[] keywords = Arrays.copyOfRange(args, 2, args.length);
        BSTree<String> movieTree = new BSTree<>();
        BSTree<String> studioTree = new BSTree<>();
        BSTree<String> ratingTree = new BSTree<>();
        if (!populateSearchTrees(movieTree, studioTree, ratingTree, fileName)) {
            System.out.println("Error reading file.");
            return;
        }
        BSTree<String> searchTree = null;
        if (searchKind == 1) {
            searchTree = movieTree;
        } else if (searchKind == 2) {
            searchTree = studioTree;
        } else if (searchKind == 3) {
            searchTree = ratingTree;
        } else {
            System.out.println("Invalid search kind.");
            return;
        }
        String query = String.join(" ", keywords);
        searchMyQuery(searchTree, query);

    }
}
