public class Word {
    public static final char SPACE = ' ';
    public static final char TAB = '\t';
    public static final char BREAK_LINE = '\n';
    private String st;

    public Word() {
    }

    public Word(String st) {
        this.st = st;
    }

    public String getSt() {
        return st;
    }

    public void setSt(String st) {
        this.st = st;
    }

    public int CountWord() {
        if (st == null) {
            return -1;
        }
        int count = 0;
        int size = st.length();
        boolean notCounted = true;
        for (int i = 0; i < size; i++) {
            if (st.charAt(i) != SPACE && st.charAt(i) != TAB
                    && st.charAt(i) != BREAK_LINE) {
                if (notCounted) {
                    count++;
                    notCounted = false;
                }
            } else {
                notCounted = true;
            }
        }
        return count;
    }

    public int CountChacterA() {
        int count = 0;
        for (int i = 0; i < st.length(); i++) {
            char kyTu = Character.toLowerCase(st.charAt(i));
            if (kyTu == 'a') {
                count++;
            }
        }
        return count;
    }

    public void StandardizeText(){
        st=st.trim();
        st=st.replaceAll("\\s+", " ");
    }

}
