public class ClassTest {
    private int[] nums;
    private boolean isWord;
    public ClassTest(int[] nums, boolean isWord) {
        this.nums = nums;
        this.isWord = isWord;
    }

    public void setNums(int[] nums) {
        this.nums = nums;
    }

    public void setIsWord(boolean isWord) {
        this.isWord = isWord;
    }

    public int[] getNums() {
        return nums;
    }

    public boolean getIsWord() {
        return isWord;
    }
}
