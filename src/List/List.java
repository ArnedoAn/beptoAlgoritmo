package List;

import bepto.*;

public class List<T> {

    Node<T> firstNode;
    int size = 0;

    public List() {
        clean();
    }

    public int getSize() {
        return this.size;
    }

    private void clean() {
        firstNode = null;
        size = 0;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    public boolean add(Node<T> node) {

        if (!isEmpty()) {
            node.next = firstNode;
        }
        firstNode = node;
        size++;
        return true;
    }

    public boolean addEnd(Node<T> node) {
        Node<T> temp = null;

        if (isEmpty()) {
            firstNode = node;
        } else {
            temp = firstNode;
            while (temp.next != null)
                temp = temp.next;
            temp.next = node;
        }
        size++;
        return true;
    }

    public boolean addIntoNodes(Node<T> node) {
        Node<T> temp = null;
        Node<T> prev = null; //previous node

        if (isEmpty()) {
            firstNode = node;
        } else {
            temp = firstNode;
            prev = temp;
            boolean band = false;

            if (size == 1) {
                if (Integer.parseInt(temp.getData().toString()) < Integer.parseInt(node.getData().toString())) {
                    firstNode.next = node;
                } else {
                    node.next = firstNode;
                    firstNode = node;
                }
            } else {
                while (temp != null && Integer.parseInt(temp.getData().toString()) < Integer.parseInt(node.getData().toString())) {
                    prev = temp;
                    temp = temp.next;
                    band = true;
                }
                if (band) {
                    node.next = prev.next;
                    prev.next = node;
                } else {
                    node.next = temp;
                    firstNode = node;
                }
            }
        }
        size++;
        return true;
    }

    public boolean delete() {
        Node<T> temp = firstNode;
        System.out.println("***" + temp.getData());
        firstNode = temp.next;
        return true;
    }

    public void print() {
        if (!isEmpty()) {
            Node<T> temp = firstNode;
            while (temp != null) {
                System.out.println((temp.getData()));
                temp = temp.next;
            }
        } else {
            System.out.println("List is empty");
        }
    }

    public Rutas[] toArrayRutas() {
        Rutas[] listArray = new Rutas[this.size];
        if (!isEmpty()) {
            Node<T> temp = firstNode;
            int band = 0;
            while (temp != null) {
                listArray[band] = (Rutas) temp.getData();
                temp = temp.next;
                band++;
            }
        }
        return listArray;

    }

    public Nodo[] toArrayNodo(){
        Nodo[] listArray = new Nodo[this.size];
        if (!isEmpty()) {
            Node<T> temp = firstNode;
            int band = 0;
            while (temp != null) {
                listArray[band] = (Nodo) temp.getData();
                temp = temp.next;
                band++;
            }
        }
        return listArray;
    }

    public Arco[] toArrayArco(){
        Arco[] listArray = new Arco[this.size];
        if (!isEmpty()) {
            Node<T> temp = firstNode;
            int band = 0;
            while (temp != null) {
                listArray[band] = (Arco) temp.getData();
                temp = temp.next;
                band++;
            }
        }
        return listArray;
    }


    public int binarySearc(int key) {
        Rutas[] listArray = toArrayRutas();
        if (listArray != null) {
            int first = 0;
            int last = this.size - 1;
            while (first <= last) {
                int mid = first + (last - first) / 2;
                if (listArray[mid].getId() == key) {
                    return mid;
                }
                if (listArray[mid].getId() < key) {
                    first = mid + 1;
                } else {
                    last = mid - 1;
                }
            }
            return -1; //Index not found
        } else {
            return -2; //Array empty
        }
    }
}

