import java.util.Arrays;

public class isScramble {
    public boolean isScramble(String s1, String s2) {
        if(s1.length() != s2.length()) return false;
        if(s1.equals(s2)) return true;
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        if(!Arrays.toString(c1).equals(Arrays.toString(c2))) {
            return false;
        }

        for(int i = 1; i < s1.length(); i++) {
            String s11 = s1.substring(0, i);
            String s12 = s1.substring(i);
            String s21 = s2.substring(0, i);
            String s22 = s2.substring(i);
            if(isScramble(s11, s21) && isScramble(s12, s22)) return true;
            s21 = s2.substring(s1.length() - i);
            s22 = s2.substring(0, s1.length() - i);
            if(isScramble(s11, s21) && isScramble(s12, s22)) return true;
        }
        return false;
    }

//    public boolean isScramble2(String s1, String s2) {
//        int len1 = s1.length();
//        int len2 = s2.length();
//        if(len1 != len2) return false;
//        boolean[][][] dp = new boolean[len1][len1][len1];
//        for (int i = 0; i < len1; i++) {
//            for(int j = 0; j < len1; j++) {
//                if(s1.charAt(i) == s2.charAt(i)) {
//                    dp[0][i][j] = true;
//                }
//            }
//        }
//
//        for(int k=1;k<len1; k++){
//            for(int i=0; i<len1-k ;i++){
//                for(int j=0; j<len1-k; j++){
//                    if(!dp[k][i][j]){
//                        for(int q = 0; q < k; q++){
//                            if( (dp[q][i][j] && dp[k-q-1][i+q+1][j+q+1]) || (dp[q][i][j+k-q] && dp[k-q-1][i+q+1][j]) )
//                                dp[k][i][j] = true;
//                        }
//                    }
//                }
//            }
//        }
//        return dp[len1-1][0][0];
//    }
}

//bool isScramble(string s1, string s2) {
//	int len1=s1.size(), len2=s2.size();
//	if(len1 != len2)
//		return false;
//	//相当于 bool dp[len1][len1][len1];
//	vector<vector<vector<bool> > > dp(len1, vector<vector<bool>>(len1,vector<bool>(len1,false)) );
//	//初始化数组，子串长度为一时，只要相等就是
//	for(int i=0; i<len1; i++){
//		for(int j=0; j<len1; j++){
//			if(s1[i] == s2[j])
//				dp[0][i][j] = true;
//		}
//	}
//	for(int k=1;k<len1; k++){
//		for(int i=0; i<len1-k ;i++){
//			for(int j=0; j<len1-k; j++){
//				if(false == dp[k][i][j]){
//					for(int q=0; q<k; q++){
//						if( (dp[q][i][j] && dp[k-q-1][i+q+1][j+q+1]) || (dp[q][i][j+k-q] && dp[k-q-1][i+q+1][j]) )
//							dp[k][i][j] = true;
//					}
//				}
//			}
//		}
//	}
//	return dp[len1-1][0][0];
//}
