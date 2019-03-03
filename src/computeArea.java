public class computeArea {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int areaOfA = (C - A) * (D - B);
        int areaOfB = (G - E) * (H - F);

        int top = Math.min(D, H);
        int left = Math.max(A, E);
        int right = Math.min(C, G);
        int bottom = Math.max(B, F);

        int overlap = 0;
        if(top > bottom && left < right) {
            overlap = (top - bottom) * (right - left);
        }
        return areaOfA + areaOfB - overlap;
    }
}
