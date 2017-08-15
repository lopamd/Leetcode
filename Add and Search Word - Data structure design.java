public class WordDictionary {
    final static int ALPHABET_SIZE = 26;
	TriNode root;
	
	class TriNode{
		private boolean isLeaf;
		private TriNode[] link;

		public TriNode() {
			link = new TriNode[ALPHABET_SIZE];
		}
		public boolean isLeaf(){
			return isLeaf;
		}
		
		public void setLeaf(){
			isLeaf = true;
		}
		
		public boolean containsKey(char ch){
			return link[ch - 'a'] != null;
		}
		
		public TriNode get(char ch){
			return link[ch - 'a'];
		}
		
		public void put(char ch, TriNode node){
			link[ch - 'a'] = node;
		}
	}

	
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TriNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        if(word == null)
			return;
		//String lowerKey = word.toLowerCase();
		TriNode current  = root;
		for(int i = 0; i < word.length(); i++){
			char currentCharacter = word.charAt(i);
			if(!current.containsKey(currentCharacter)){
				current.put(currentCharacter, new TriNode());
			}
			current = current.get(currentCharacter);
		}
		current.setLeaf();
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        if(word == null){
			System.out.println("Search word is null");
			return false;
		}
		return searchHelper(word,0,root);
    }
    
    public boolean searchHelper(String word, int index, TriNode root){
		TriNode current = root;
    		if (index == word.length()){
        		if (current.isLeaf){
        			return true;
        		}
        		return false;
        	}
        	TriNode[] links = current.link;
			char currentCharacter = word.charAt(index);
			if(currentCharacter == '.' ){
			    for(int j = 0; j < links.length; j++){
			        if(links[j] != null){
			            boolean found = searchHelper(word, index + 1, links[j]);
			            if(found)
			                return true;
			        }
			    }
			    return false;

			    
			}
			current = current.get(currentCharacter);
			if(current == null){
				return false;
			}
	    return searchHelper(word, index + 1, current);

	}

}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */