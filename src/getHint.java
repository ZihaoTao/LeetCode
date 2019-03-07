import java.util.HashMap;
import java.util.Map;

public class getHint {
    public String getHint(String secret, String guess) {
        int bull = 0;
        int cow = 0;
        boolean[] check = new boolean[secret.length()];
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < secret.length(); i++) {
          if(secret.charAt(i) == guess.charAt(i)) {
              bull++;
              check[i] = true;
          } else {
              if(!map.containsKey(secret.charAt(i))) {
                  map.put(secret.charAt(i), 1);
              } else {
                  map.put(secret.charAt(i), map.get(secret.charAt(i)) + 1);
              }
          }
        }

        for(int i = 0; i < guess.length(); i++) {
            if(!check[i]) {
                if(map.containsKey(guess.charAt(i))) {
                    if(map.get(guess.charAt(i)) > 0) {
                        cow ++;
                        map.put(guess.charAt(i), map.get(guess.charAt(i)) - 1);
                    }
                }
            }
        }
        return "" + bull + 'A' + cow + 'B';
    }
}
