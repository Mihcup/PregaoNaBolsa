package ImplementacaoLista;

public class Lista <T>{
    //<T> -> o tipo pode ser definido depois -> parametrizada
    /* classe interna -> encapsulada dentro de outra classe
     */
    private Node<T> head; // só quer o comportamento da lista
    private int size;


    public static class Node<T>{
        private T data;
        private Node<T> next;

        public Node(T data){
            this.data = data;
            this.next = null;
            // cada vez que criar o proximo, cria o proximo nulo
        }
    }

    public Lista(){
        this.head = null;
        // se cabeça igual a null, o novo nó vai ser o head
        this.size = 0;
    }
    // Adicionar um elemento em uma posição específica

    public int getSize(){
        return size;
    }

    public void exibir(){
        Node<T> current = head;
        while(current != null){
            System.out.print(current.data);
            current = current.next;
        }
        System.out.printf(" ");
    }

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

       /*public void remove(T data){
            if(head==null){
                return;
            }
            if(head.data == data) {
                head = head.next;
                return;
            }
            Node current = head;
            while(current.next != null) {
                if(current.next.data == data){
                    current.next = current.next.next;
                    return;
                }
            }
            current = current.next;
        }*/

    public void remove(T data){
        if(head==null){
            return;
        }
        if(head.data.equals(data)) {
            head = head.next;
            size--;
            return;
        }
        Node<T> current = head;
        while(current.next != null) {
            if(head.data.equals(data)){
                current.next = current.next.next;
                size--;
                return;
            }
        }
        current = current.next;
    }

    public Node<T> getHead() {
        return head;
    }

    public void percorrerLista() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

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
}