import java.util.Arrays;

public class isValidSerialization {
    int index = 0;
    public boolean isValidSerialization(String preorder) {
        if(preorder == null || preorder.isEmpty()) return true;
        String[] cs = preorder.split(",");
        return helper(cs) && index == cs.length - 1;
    }

    private boolean helper(String[] cs){
        if(index >= cs.length) return false;
        if(cs[index].equals("#")) return true;
        index++;
        if(!helper(cs)) return false;
        index++;
        if(!helper(cs)) return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println((new isValidSerialization()).isValidSerialization("#,1"));
    }
}
