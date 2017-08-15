public class LRUCache {
    private HashMap<Integer,DoubleLinkedList> map = new HashMap<>();
        private DoubleLinkedList head = null;
        private DoubleLinkedList end = null;
        private DoubleLinkedList temp = null;
        private int len;
        private int capacity;

    public LRUCache(int capacity) {
       this.capacity = capacity;
       len = 0;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            DoubleLinkedList latest = map.get(key);
            
            remove(latest);
            setHead(latest);
            return latest.val;
        }else
            return -1;
    }
    
    public void put(int key, int value) {
        DoubleLinkedList newNode = new DoubleLinkedList(key,value);

        if(map.containsKey(key))
        {
            DoubleLinkedList oldNode = map.get(key);
            remove(oldNode);
            setHead(newNode);
            map.put(key,newNode);
        }else{
            if(len < capacity){
                setHead(newNode);
                map.put(key,newNode);
                len++;
            }else{
                map.remove(end.key);
                end = end.prev;
                if(end != null)
                    end.next = null;
                setHead(newNode);
                map.put(key,newNode);
            }
        }
        
    }
    
    public void setHead(DoubleLinkedList latest){
        if(head != null){
            latest.next = head;
            latest.prev = null;
            head.prev = latest;
            head = latest;
        }else{
            head = latest;
            end = latest;
        }
    }
    
    public void remove(DoubleLinkedList latest){
        if(latest.next != null){
            latest.next.prev = latest.prev;
        }else{
            end = latest.prev;
        }
        
        if(latest.prev != null){
            latest.prev.next = latest.next;
        }else
            head = latest.next;
    }
    
    public class DoubleLinkedList{
        int key;
        int val;
        DoubleLinkedList next;
        DoubleLinkedList prev;
        
        DoubleLinkedList(int key,int val)
        {
            this.key = key;
            this.val = val;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */