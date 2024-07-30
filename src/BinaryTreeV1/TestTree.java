package BinaryTreeV1;

public class TestTree {
    public static void main(String[] args) {
        Tree tree = new Tree();

        tree.insert(61, 25.3);
        tree.insert(43, 27.3);
        tree.insert(89, 28.3);
        tree.insert(66, 25.3);
        tree.insert(100, 27.3);
        tree.insert(90, 28.3);
        tree.insert(79, 25.3);
        tree.insert(77, 27.3);
        tree.insert(82, 28.3);
        tree.insert(16, 27.3);
        tree.insert(11, 28.3);
        tree.insert(32, 25.3);
        tree.insert(51, 27.3);
        tree.insert(55, 28.3);

        tree.delete(61);
        tree.display();
    }
}
