import java.util.ArrayList;
import java.util.List;

public class fullJustify {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<List<String>> list = new ArrayList<>();
        int count = 0;
        for(String i : words) {
            if(list.size() != 0 && count + i.length() + list.get(list.size() - 1).size() - 1 < maxWidth) {
                count += i.length();
                list.get(list.size() - 1).add(i);
            } else {
                count = i.length();
                list.add(new ArrayList<String>());
                list.get(list.size() - 1).add(i);
            }
        }
        List<String> res = new ArrayList<>();
        for(int i = 0; i < list.size() - 1; i++) {
            int sum = 0;
            for(String j : list.get(i)) {
                sum += j.length();
            }

            if(list.get(i).size() > 1) {
                int len = (maxWidth - sum) / (list.get(i).size() - 1);
                String space = "";
                for(int j = 0; j < len; j++) {
                    space += " ";
                }
                count = (maxWidth - sum) % (list.get(i).size() - 1);
                String s = "";
                for(String j : list.get(i)) {
                    s += j + space;
                    if(count > 0) {
                        s += " ";
                        count--;
                    }
                }
                res.add(s.trim());
            } else {
                String s = list.get(i).get(0);
                while(s.length() < maxWidth) {
                    s += " ";
                }
                res.add(s);
            }
        }

        List<String> last = list.get(list.size() - 1);

        String line = "";
        for(String i : last) {
            line += i + " ";
        }
        line = line.trim();
        while(line.length() < maxWidth) {
            line += " ";
        }
        res.add(line);

        return res;
    }

    public static void main(String[] args) {
        String[] strs = {"ask   not   what","your country can","do  for  you ask","what  you can do","for your country "};
        int maxWidth = 16;
        List<String> test = (new fullJustify()).fullJustify(strs, maxWidth);
        for(String i : test) {
            System.out.println(i + "|");
        }
    }
    //["Science   is what we","understand      well","enough to explain to","a   computer. Art is","everything  else  we","do                  "]
    //["Science  is  what we","understand      well","enough to explain to","a  computer.  Art is","everything  else  we","do                  "]
}
