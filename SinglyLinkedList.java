public class SinglyLinkedList<E> {
    
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    public SinglyLinkedList(){

    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public E first(){
        if (isEmpty()){
            return null;
        } 
        return head.getElement();
    }

    public E last(){
        if (isEmpty()){
            return null;
        }
        return tail.getElement();
    }

    public void addFirst(E e){
        head = new Node<>(e, head);

        if (isEmpty()){
            tail = head;
        }
        size++;
    }

    public void addLast(E e){
        Node<E> newest = new Node<>(e, null);
        if (isEmpty()){
            head = newest;
        } else {
            tail.setNext(newest);
        }
        tail = newest;
        size++;
    }

    public E removeFirst(){
        if (isEmpty()){
            return null;
        }

        E answer = head.getElement();
        head = head.getNext();
        size--;

        if (isEmpty()){
            tail = null;
        }
        return answer;
    }

    // Write your codes below
    public String toString(){
        StringBuilder returnString = new StringBuilder();
        Node<E> nextNode = head;
        while (nextNode != null) {
            returnString.append(nextNode.getElement());
            nextNode = nextNode.getNext();
        }
        return returnString.toString();
    }

    public E removeLast(){
        if (isEmpty()) {
            return null;
        }

        E element = tail.getElement();

        if (head == tail) {
            head = null;
            tail = null;
            size = 0;
            return element;
        }

        Node<E> current = head;
        while (current.getNext() != tail) {
            current = current.getNext();
        }

        current.setNext(null);
        tail = current;
        size--;
        return element;
    }

    public void reverse() {
        if (size <= 1 || isEmpty()) {
            return;
        }
        Node<E> prev = null;
        Node<E> current = head;
        while (current != null) {
            Node<E> next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
        }
        tail = head;
        head = prev;

        
    }
}