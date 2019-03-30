public class majorityElement {
    public int majorityElement(int[] nums) {
        int candidate = 0;
        int count = 0;
        for(int i : nums) {
            if (i == candidate) {
                count++;
            } else if(count == 0) {
                candidate = i;
                count = 1;
            } else {
                count--;
            }
        }
        return candidate;
    }
}
