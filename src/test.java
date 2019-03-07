public class test {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(2);
        String s = (new Codec()).serialize(node);
        (new Codec()).deserialize(s);
    }
}
