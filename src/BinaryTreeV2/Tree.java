package BinaryTreeV2;

public class Tree {
    private Node root;

    Tree(){
        root = null;
    }

    public void insert(int data){
        Node newNode = new Node();
        newNode.data = data;

        if(root == null){
            root = newNode;
        } else {
            Node current = root;
            Node parent;

            while(current != null) {
                parent = current;
                if(current.data > data) {
                    current = current.leftChild;

                    if(current == null){
                        parent.leftChild = newNode;
                        return;
                    }

                } else {
                    current = current.rigthChild;

                    if(current == null){
                        parent.rigthChild = newNode;
                        return;
                    }
                }
            }

        }
    }

    public Node findNode(int key){
        Node current = root;

        while(current.data != key) {
            if(current.data > key) {
                current = current.leftChild;
            } else {
                current = current.rigthChild;
            }

            if (current == null) return null;
        }

        return current;
    }

    private void inOrder(Node localRoot){
        if(localRoot != null){
            inOrder(localRoot.leftChild);
            System.out.println(localRoot.data);
            inOrder(localRoot.rigthChild);
        }
    }

    public Node getSucessor(Node node){
        Node current = node;
        Node sucessor = current;

        while(current != null){
            sucessor = current;

            current = current.leftChild;
        }

        return sucessor;
    }

    public void delete(int key) {
        root = remove(key, root);
    }

    private Node remove(int key, Node node){
        if(node == null) {
            return  node;
        }

        if(key < node.data) {
            node.leftChild = remove(key, node.leftChild);
        } else if (key > node.data) {
            node.rigthChild = remove(key, node.rigthChild);
        } else {
            if(node.leftChild == null) {
                return node.rigthChild;
            } else if(node.rigthChild == null){
                return node.leftChild;
            } else {
                Node substituto = this.getSucessor(node.rigthChild);
                node.data = substituto.data;
                node.rigthChild = remove(substituto.data, node.rigthChild);
            }
        }
        return node;
    }

    public void display(){
        inOrder(root);
    }

}
