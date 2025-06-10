import java.util.*;

public class WORD_LADDER {
    static class Pair {
        String word;
        int steps;

        public Pair(String w, int s) {
            this.word = w;
            this.steps = s;
        }
    }

    public static int wordLadder(String[] wordList, String startWord, String endWord) {

        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(startWord, 1));

        Set<String> st = new HashSet<>();

        for (int i = 0; i < wordList.length; i++) {
            st.add(wordList[i]);
        }

        st.remove(startWord);

        while (!q.isEmpty()) {

            String currWord = q.peek().word;
            int S = q.peek().steps;
            q.remove();

            if (currWord.equals(endWord) == true)
                return S;

            for (int i = 0; i < currWord.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char[] charArray = currWord.toCharArray();

                    charArray[i] = ch;

                    String replacedWord = new String(charArray);

                    if (st.contains(replacedWord) == true) {
                        st.remove(replacedWord);
                        q.add(new Pair(replacedWord, S + 1));
                    }
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {

        // This input give zero as because of the UPPERCASE and in the function of
        // WordLadder we replace each character by the lowercase character(So also
        // consider this while solving this type of questions)
        // String[] wordList = { "POON", "PLEE", "SAME", "POIE", "PLEA", "PLIE", "POIN"
        // };

        String[] wordList2 = { "hot", "dot", "dog", "lot", "log", "cog" };
        System.out.println(wordLadder(wordList2, "hit", "cog"));
    }
}
