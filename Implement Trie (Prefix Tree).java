public class Trie {
    private int ALPHABET_SIZE = 26;
    Node root;

    class Node{
        private boolean isLeaf;
        private Node[] link;
        
        public Node(){
            link = new Node[ALPHABET_SIZE];
        }
        
        public boolean isLeaf(){
            return isLeaf;
        }
            
        public void setLeaf(){
            isLeaf = true;
        }
        
        public boolean containsKey(char ch){
            if(link[ch - 'a'] != null)
                return true;
            else
                return false;
        }
        
        public Node get(char ch){
            return link[ch - 'a'];
        }
        
        public void put(char ch, Node node){
            link[ch - 'a'] = node;
        }
        
    }
    /** Initialize your data structure here. */
    public Trie() {
        root = new Node();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        if(word == null)
            return;
        String lowerKey = word.toLowerCase();
        Node current = root;
        for(int i = 0; i < lowerKey.length(); i++){
            char currentcharacter = lowerKey.charAt(i);
            if(!current.containsKey(currentcharacter)){
                current.put(currentcharacter,new Node());
            }
            current = current.get(currentcharacter);
        }
        current.setLeaf();
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if(word == null)
            return false;
        Node current = root;
        String lowerKey = word.toLowerCase();
        for(int i = 0; i < lowerKey.length(); i++){
            char currentcharacter = lowerKey.charAt(i);
            if(!current.containsKey(currentcharacter)){
                return false;
            }
            current = current.get(currentcharacter);
        }
        return current != null && current.isLeaf();
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if(prefix == null)
            return false;
        Node current = root;
        String lowerKey = prefix.toLowerCase();
        for(int i = 0; i < lowerKey.length(); i++){
            char currentcharacter = lowerKey.charAt(i);
            if(!current.containsKey(currentcharacter)){
                return false;
            }
            current = current.get(currentcharacter);
        }
        return current != null;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */