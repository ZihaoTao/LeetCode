public class getHint {
    public String getHint(String secret, String guess) {
        int[] freq = new int[256];
        int bull = 0;
        int cow = 0;
        for(int i = 0; i < secret.length(); i++) {
            if(secret.charAt(i) == guess.charAt(i)) {
                bull++;
            } else {
                freq[secret.charAt(i)]++;
            }
        }
        for(int i = 0; i < secret.length(); i++) {
            if(secret.charAt(i) != guess.charAt(i) && freq[guess.charAt(i)] > 0) {
                freq[guess.charAt(i)]--;
                cow++;
            }
        }
        return bull + "A" + cow + "B";
    }

    public String getHint2(String secret, String guess) {
        int[] freq = new int[10];
        int bull = 0;
        int cow = 0;
        for(int i = 0; i < secret.length(); i++) {
            if(secret.charAt(i) == guess.charAt(i)) {
                bull++;
            } else {
                if (freq[secret.charAt(i) - '0']++ < 0) cow++;
                if (freq[guess.charAt(i) - '0']-- > 0) cow++;
            }
        }

        return bull + "A" + cow + "B";
    }
}
