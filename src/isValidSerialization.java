import java.util.Arrays;

public class isValidSerialization {
    public boolean isValidSerialization(String preorder) {
        String[] cs = preorder.split(",");
        return helper(cs);
    }

    private boolean helper(String[] cs) {
        if(cs.length == 1 && cs[0].equals("#")) return true;
        if(cs[0].equals("#")) return false;
        int node = 0;
        int nullNode = 0;
        int i = 1;
        for(; i < cs.length; i++) {
            if(!cs[i].equals("#")) {
                node++;
            } else {
                nullNode++;
            }
            if(node + 1 == nullNode) break;
        }
        if(i == cs.length - 1) return false;
        String[] left = Arrays.copyOfRange(cs, 1, i + 1);
        String[] right = Arrays.copyOfRange(cs, i + 1, cs.length);
        i++;
        for(; i < cs.length; i++) {
            if(!cs[i].equals("#")) {
                node--;
            } else {
                nullNode--;
            }
            if(node == nullNode) break;
        }

        if(i != cs.length - 1) return false;
        return helper(left) && helper(right);
    }

    public static void main(String[] args) {
        (new isValidSerialization()).isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#");
    }
}
