package tiktactoe.viewer;

import java.util.Arrays;
import java.util.stream.Collectors;

public class BoardView {
    private static final String COLUMN = "|";
    private static final String ROW = "\n +-+-+-\n";

    public static void printBoard(String[][] draw) {
        StringBuilder builder = new StringBuilder();
        builder.append(Arrays.stream(draw[0]).collect(Collectors.joining(" ")));
        builder.append("\n");
        builder.append(Arrays.stream(draw[1]).collect(Collectors.joining(COLUMN)));
        builder.append(ROW);
        builder.append(Arrays.stream(draw[2]).collect(Collectors.joining(COLUMN)));
        builder.append(ROW);
        builder.append(Arrays.stream(draw[3]).collect(Collectors.joining(COLUMN)));

        builder.append("\n");
        System.out.println(builder);
    }


    }
