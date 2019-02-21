import java.util.ArrayList;
import java.util.List;

public class fullJustify {
    List<String> ret;
    List<List<String>> res;
    public List<String> fullJustify(String[] words, int maxWidth) {
        ret = new ArrayList<>();
        res = new ArrayList<>();
        if(words.length == 0) return ret;
        List<String> list = new ArrayList<>();
        helper(words, maxWidth, list);
        while(res.size() > 1) {
            String str = generate(res.get(0), maxWidth);
            ret.add(str);
            res.remove(0);
        }
        if(res.size() == 1) {
            StringBuilder sb = new StringBuilder();
            for(String i : res.get(0)) {
                sb.append(i + " ");
            }
            String temp = sb.substring(0, sb.length() - 1);
            if(temp.length() < maxWidth) {
                int diff = maxWidth - temp.length();
                for(int i = 0; i < diff; i++) {
                    temp += " ";
                }
            }
            ret.add(temp);
        }
        return ret;
    }

    private void helper(String[] words, int maxWidth, List<String> list) {
        for(int i = 0; i < words.length; i++) {
            list.add(words[i]);
            if(size(list) > maxWidth) {
                list.remove(list.size() - 1);
                res.add(new ArrayList<>(list));
                list = new ArrayList<>();
                list.add(words[i]);
            }
        }
        res.add(list);
    }

    private int size(List<String> list) {
        int res = 0;
        for(String i : list) {
            res += i.length() + 1;
        }
        return res - 1;
    }

    private String generate(List<String> list, int maxWidth) {
        int size = 0;
        for(String i : list) {
            size += i.length();
        }
        int diff = maxWidth - size;
        if(list.size() == 1) {
            String res = list.get(0);
            for(int i = 0; i < diff; i++) {
                res += " ";
            }
            return res;
        }
        int space = diff / (list.size() - 1);
        int remain = diff % (list.size() - 1);
        int[] arr = new int[list.size() - 1];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = space;
        }

        for(int i = 0; i < remain; i++) {
            arr[i]++;
        }


        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < list.size(); i++) {
            if(i < list.size() - 1) {
                sb.append(list.get(i));
                for(int j = 0; j < arr[i]; j++) {
                    sb.append(" ");
                }
            } else {
                sb.append(list.get(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] strs = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;
        (new fullJustify()).fullJustify(strs, maxWidth);
    }
    //["Science   is what we","understand      well","enough to explain to","a   computer. Art is","everything  else  we","do                  "]
    //["Science  is  what we","understand      well","enough to explain to","a  computer.  Art is","everything  else  we","do                  "]
}
