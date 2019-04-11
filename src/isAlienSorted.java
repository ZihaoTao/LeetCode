public class isAlienSorted {
    public boolean isAlienSorted(String[] words, String order) {
        int i = 0;

        int max = 0;
        for(String s : words) {
            max = Math.max(max, s.length());
        }
        while(i < max) {
            int pre = -1;
            for(String s : words) {
                int index = 0;
                if(s.length() > i) {
                    index = order.indexOf("" + s.charAt(i));
                }
                if(index >= pre) {
                    pre = index;
                } else {
                    return false;
                }
            }
            i++;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] ss = {"hello","leetcode"};
        System.out.println((new isAlienSorted()).isAlienSorted(ss, "hlabcdefgijkmnopqrstuvwxyz"));
    }
}
