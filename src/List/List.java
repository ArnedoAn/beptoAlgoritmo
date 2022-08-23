package List;

public class List <T> {

    Node<T> firstNode;
    int size = 0;

    public List(){
        clean();
    }

    private void clean(){
        firstNode = null;
        size = 0;
    }

    private boolean isEmpty(){
        return size == 0;
    }

    public boolean add(Node<T> node){

        if (!isEmpty()) {
            node.next = firstNode;
        }
        firstNode = node;
        size++;
        return true;
    }

    public boolean addEnd(Node<T> node){
        Node<T> temp = null;

        if(isEmpty()){
            firstNode = node;
        }else{
            temp = firstNode;
            while(temp.next!=null)
                temp = temp.next;
            temp.next = node;
        }
        size++;
        return true;
    }

    public boolean addIntoNodes(Node<T> node){
        Node<T> temp = null;
        Node<T> prev = null; //previous node

        if(isEmpty()){
            firstNode = node;
        }else{
            temp = firstNode;
            prev = temp;
            boolean band = false;

            if(size == 1){
                if(Integer.parseInt(temp.getData().toString()) < Integer.parseInt(node.getData().toString())){
                    firstNode.next = node;
                }else{
                    node.next = firstNode;
                    firstNode = node;
                }
            }else{
                while(temp!=null && Integer.parseInt(temp.getData().toString()) < Integer.parseInt(node.getData().toString())){
                    prev = temp;
                    temp = temp.next;
                    band = true;
                }
                if (band){
                    node.next = prev.next;
                    prev.next = node;
                }else{
                    node.next = temp;
                    firstNode = node;
                }
            }
        }
        size++;
        return true;
    }

    public boolean delete(){
        Node<T> temp = firstNode;
        System.out.println("***" + temp.getData());
        firstNode = temp.next;
        return true;
    }

    public void imprimir(){
        if(!isEmpty()){
            Node<T> temp = firstNode;
            while(temp!=null){
                System.out.println(temp.getData());
                temp = temp.next;
            }
        }else{
            System.out.println("List is empty");
        }
    }
}

