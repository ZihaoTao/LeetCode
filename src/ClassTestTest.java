import java.util.Arrays;

public class ClassTestTest {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        ClassTest classTest = new ClassTest(nums, false);
        int[] newNums = {1, 2, 3, 4};
        classTest.setNums(newNums);
        System.out.println(Arrays.toString(classTest.getNums()));
    }
}
