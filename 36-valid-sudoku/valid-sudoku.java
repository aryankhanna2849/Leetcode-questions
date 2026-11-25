import java.util.*;

class Solution {
    public boolean isValidSudoku(char[][] board) {

        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] boxes = new HashSet[9];

        // Initialize HashSets
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        // Traverse the board
        for (int i = 0; i < 9; i++) {

            for (int j = 0; j < 9; j++) {

                char num = board[i][j];

                // Skip empty cells
                if (num == '.') {
                    continue;
                }

                // Calculate box index
                int boxIndex = (i / 3) * 3 + (j / 3);

                // Check duplicates
                if (!rows[i].add(num) ||
                    !cols[j].add(num) ||
                    !boxes[boxIndex].add(num)) {

                    return false;
                }
            }
        }

        return true;
    }
}