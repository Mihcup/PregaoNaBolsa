package implementacoes;

public class Lista <T>{
    private Node<T> head;
    private int size;

    public static class Node<T>{
        private T data;
        private Node<T> next;

        public Node(T data){
            this.data = data;
            this.next = null;
        }
    }

    public Lista(){
        this.head = null;
        this.size = 0;
    }

    public int getSize(){
        return size;
    }

    // método para exibição da lista
    public void exibir(){
        Node<T> current = head;
        while(current != null){
            System.out.print(current.data);
            current = current.next;
        }
        System.out.printf(" ");
    }

    //adicionar um elemento na primeira posição
    public void add(T data){
        Node<T> newNode = new Node<>(data);
        if(head==null){
            head=newNode;
        }else{
            Node<T> current = head;
            while(current.next != null){
                //enquanto corrente tiver proximo, não é null
                current = current.next;
                // aponta para o novo nó que foi criado
            }
            current.next = newNode;
        }
        size++;
    }

    //adicionar um elemento em qualquer posição da lista
    public void addAtIndex(int index, T data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Índice fora dos limites da lista.");
        }
        Node<T> newNode = new Node<>(data);

        if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }

        size++;
    }

    //adicionar um elemento na primeira posição
    public void addToFront(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = head;
        head = newNode;
        size++;
    }


    //remover um elemento na primeira posição
    public void remove(){
        if (head == null) {
            return; // A lista está vazia, não há nada para remover.
        }

        if (size == 1) {
            head = null;
        } else {
            head = head.next;
        }

        size--;
    }

    //remover um elemento em qualquer posição
    public void removeAtIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Índice fora dos limites da lista.");
        }

        if (index == 0) {
            head = head.next;
        } else {
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }

        size--;
    }

    //remove um elemento na última posição
    public void removeLast() {
        if (head == null) {
            return;
        }

        if (size == 1) {
            head = null;
        } else {
            Node<T> current = head;
            while (current.next.next != null) {
                current = current.next;
            }
            current.next = null;
        }

        size--;
    }

    public Node<T> getHead() {
        return head;
    }

    // percorrer a lista
    public void percorrerLista() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // método que busca retornar um valor numa determinada posição
    public T retornarValor(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Índice fora dos limites da lista");
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    //substiuição de um valor, importante para a ordenação da lista
    public void substituirValor(int index, T newValue) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Índice fora dos limites da lista");
        }

        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        current.data = newValue;
    }
}
