package implementacoes;
public class Arvore {
    private Node root;
    private class Node {
        private int key;
        private Node left, right;
        public Node(int key) {
            this.key = key;
        }
    }
    public void add(int key) {
        root = add(root, key);
    }
    private Node add(Node node, int key) {
        if (node == null) {
            return new Node(key);
        }
        if (key < node.key) {
            node.left = add(node.left, key);
        } else if (key > node.key) {
            node.right = add(node.right, key);
        }
        return node;
    }
    public void remove(int key) {
        root = remove(root, key);
    }
    private Node remove(Node node, int key) {
        if (node == null) {
            return null;
        }
        if (key < node.key) {
            node.left = remove(node.left, key);
        } else if (key > node.key) {
            node.right = remove(node.right, key);
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            } else {
                Node minNode = findMin(node.right);

                node.key = minNode.key;
                node.right = remove(node.right, minNode.key);
            }
        }
        return node;
    }
    private Node findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
    public void emOrdem() {
        inorder(root);
    }
    private void inorder(Node node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.key + " ");
            inorder(node.right);
        }
    }
    public void preorder() {
        preorder(root);
    }
    private void preorder(Node node) {
        if (node != null) {
            System.out.print(node.key + " ");
            preorder(node.left);
            preorder(node.right);
        }
    }
    public void postorder() {
        postorder(root);
    }
    private void postorder(Node node) {
        if (node != null) {
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.key + " ");
        }
    }
    public void printTree() {
        if (root == null) {
            System.out.println("Árvore está vazia");
        } else {
            System.out.print("Elementos da árvore: ");
            printTree(root);
            System.out.println();
        }

    }
    private void printTree(Node node) {
        if (node != null) {
            printTree(node.left);
            System.out.print(node.key + " ");
            printTree(node.right);
        }
    }

    public int getSize() {
        return getSize(root);
    }

    private int getSize(Node node) {
        if (node == null) {
            return 0;
        }
        // O tamanho da árvore é igual ao tamanho da subárvore esquerda + tamanho da subárvore direita + 1 (para o nó atual).
        return getSize(node.left) + getSize(node.right) + 1;
    }

//    public boolean contem(int chave) {
//        return contem(root, chave);
//    }



}

