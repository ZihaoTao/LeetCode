import java.util.HashSet;
import java.util.Set;

public class numUniqueEmails {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for(String i : emails) {
            System.out.println(convert(i));
            set.add(convert(i));
        }
        return set.size();
    }

    private String convert(String s) {
        String[] ss = s.split("@");
        String local = ss[0];
        String domain = ss[1];
        local = local.split("\\+")[0];
        local = String.join("", local.split("\\."));
        return local + "@" + domain;
    }

    public static void main(String[] args) {
        String[] ss = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        System.out.println((new numUniqueEmails()).numUniqueEmails(ss));
    }
}
