import java.io.*;
import java.util.*;

public class Tree {
    // List of box-drawing symbols needed to draw file tree
    private static final String a195 = "\u251c"; // ├ 
    private static final String a192 = "\u2514"; // └
    private static final String a196 = "\u2500\u2500\u2500"; // ───
    private static final String a179 = "\u2502"; // │

    public static void main(String[] args) {
        ArrayList<Boolean> isLastDir = new ArrayList<>();
        try {
            printFileTree(new File(args[0]), 0, isLastDir);
        } catch(Throwable t) {
            System.err.println(t);
        } finally {
            System.out.print("\n");
            System.out.println("Given path: " + args[0]);
        }
    }

    public static void printFileTree(File root, int level, ArrayList<Boolean> isLastDir) {
        File[] filesList = root.listFiles();

        for (int i = 0; i < filesList.length; i++) {
            // to print the trailing space for each level
            for (int j = 0; j < level; j++)
                // print starting from level 0 (from left to right)
                // if that level is the last directory, print empty spaces
                if (isLastDir.get(j))
                    System.out.print("    ");
                else
                    System.out.print(a179 + "   ");
            
            // to print the stem, either ├ or └
            if (i == filesList.length - 1)
                System.out.print(a192);
            else
                System.out.print(a195);

            // to list all files
            if (filesList[i].isFile()) {
                System.out.printf("%s%s\n", a196, filesList[i].getName());
            } else if (filesList[i].isDirectory()) {
                System.out.printf("%s%s\n", a196, filesList[i].getName());

                // keep track to see if the current directory is the last file in the current level
                isLastDir.add((i == filesList.length - 1));

                // recursive call to print tree in current directory
                printFileTree(filesList[i], level + 1, isLastDir);

                // remove the last boolean after finishing that directory
                isLastDir.remove(isLastDir.size() - 1);
            } else {}
        }
    }
}

/*
File class:
https://docs.oracle.com/javase/8/docs/api/

Printing box-drawing symbols
https://stackoverflow.com/questions/22273046/how-to-print-the-extended-ascii-code-in-java-from-integer-value?utm_medium=organic&utm_source=google_rich_qa&utm_campaign=google_rich_qa
*/