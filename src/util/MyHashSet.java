//package util;
//
//import java.util.HashSet;
//
//public class MyHashSet<T> extends MySet<T>{
//	
//    //TODO: this class needs an Iterator!!
//    private static final int INITIAL_CAPACITY = 8;
//    private int size;
//    private MyNode<T>[] nodes;
//
//
//    public MyHashSet(){
//        this(INITIAL_CAPACITY);
//    }
//    
//    HashSet<String> h;
//
//    @SuppressWarnings("unchecked")
//	public MyHashSet(int capacity){
//        this.nodes = new MyNode[capacity];
//        this.size = 0;
//    }
//
//    @Override
//    public void add(T t) throws Exception{
//        int index = t.hashCode() % nodes.length;
//
//        MyNode<T> current = nodes[index];
//        MyNode<T> newNode = new MyNode<>(t);
//
//        if(current == null){ // the list is empty
//            nodes[index] = newNode;
//            size++;
//            return;
//        }
//        while(current.next != null){
//            if(current.data.equals(t)){
//                return;
//            }
//            current = current.next;
//        }
//
//        if(!current.data.equals(t)){
//            current.next = newNode;
//            size++;
//        }
//    }
//
//    @Override
//    boolean isEmpty() {
//        return this.size == 0;
//    }
//
//    @Override
//    public int size() {
//        return this.size;
//    }
//    //TODO: convert to boolean
//    @Override
//    public void remove(T t) {
//        int index = t.hashCode() % nodes.length;
//
//        MyNode<T> current = nodes[index];
//        MyNode<T> prevNode = null;
//
//        //TODO: provide more semantic messages when converting to boolean
//        if(current == null){ // the list is empty
//            return;
//        }
//        while(current.next != null){
//            if(current.data.equals(t)){ // current is the node we want to remove
//                if(prevNode != null){
//                    prevNode.next = current.next;
//                }else{
//                    current = current.next;
//                }
//                size--;
//                return;
//            }
//            prevNode = current;
//            current = current.next;
//        }
//        if(!current.data.equals(t)){
//            prevNode.next = null;
//            size--;
//        }
//    }
//
//    @Override
//    public String toString() {
//        return null;
//    }
//
//
//    @Override
//    protected void clear() {
//    }
//
//
//    //TODO: Do we need this!?!?!?!
//    @Override
//    public T get(T t) {
//        return null;
//    }
//
//    // TODO: remove from ancestry.com.
//    @Override
//    protected boolean checkDuplicates() {
//        return false;
//    }
//
//    @Override
//    public T next() {
//        return null;
//    }
//
//    @Override
//    public T previous() {
//        return null;
//    }
//}
//
//class MyNode<T> {
//    T data;
//    MyNode<T> next;
//
//    public MyNode(T data) {
//        this.data = data;
//        this.next = null;
//
//	}
//}
