package BinaryTreeV1;

public class Tree {
    private Node root;

    public Tree(){
        root = null;
    }

    public Node find(int key){
        Node current = root;

        while(current.iData != key){
            if(key < current.iData) {
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }

            if(current == null ) return null;
        }

        return current;
    }

    public void insert(int id, double dd){
        Node newNode = new Node();
        newNode.iData = id;
        newNode.fData = dd;

        if(root == null) {
            root = newNode;
        } else {
            Node current = root;
            Node parent;

            while(true){
                parent = current;
                if(id < current.iData) {
                    current = current.leftChild;
                    if(current == null){
                        parent.leftChild = newNode;
                        return;
                    }
                } else {
                    current = current.rightChild;
                    if(current == null){
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    public boolean delete(int key){
        Node current = root;
        Node parent = root;

        boolean isLeftChild = true;

        while(current.iData != key) {
            parent = current;
            if(current.iData > key) {
                isLeftChild = true;
                current = current.leftChild;
            } else {
                isLeftChild = false;
                current = current.rightChild;
            }
            if(current == null) return false;
        }

        if(current.leftChild == null && current.rightChild == null) {
            if(current == root) {
                root = null;
            } else if(isLeftChild) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
        } else if(current.rightChild == null){
            if(current == root) {
                root = current.leftChild;
            } else if(isLeftChild){
                parent.leftChild = current.leftChild;
            } else {
                parent.rightChild = current.leftChild;
            }
        } else if(current.leftChild == null) {
            if(current == root) {
                root = current.rightChild;
            } else if(isLeftChild) {
                parent.leftChild = current.rightChild;
            } else {
                parent.rightChild = current.rightChild;
            }
        } else {
            Node sucessor = getSucessor(current);

            if(current == root) {
                root = sucessor;
            } else if(isLeftChild) {
                parent.leftChild = sucessor;
            } else {
                parent.rightChild = sucessor;
            }
            sucessor.leftChild = current.leftChild;
        }
        return true;
    }

    private Node getSucessor(Node delNode){
        Node sucessorParent = delNode;
        Node sucessor = delNode;
        Node current = delNode.rightChild;

        while(current != null) {
            sucessorParent = sucessor;
            sucessor = current;
            current = current.leftChild;
        }
        if(sucessor != delNode.rightChild) {
            sucessorParent.leftChild = sucessor.rightChild;
            sucessor.rightChild = delNode.rightChild;
        }

        return sucessor;
    }

    private void inOrder(Node localRoot){
        if(localRoot != null) {
            inOrder(localRoot.leftChild);
            System.out.println(localRoot.iData);
            inOrder(localRoot.rightChild);
        }
    }

    public void display(){
        inOrder(root);
    }
}
