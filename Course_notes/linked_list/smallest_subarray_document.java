// 1. If we encounter a word that is not in S, ignore it.
// 2. If we encounter a word in S, add it to the front of the list along with its index. Delete any previous   instance.
// 3. At any time, there is only one instance of a word in the list
// 4. After adding a word, if the list is full, i.e, if there are as many words as in S, we have a

public String getShortestSubString(String doc, HashSet<String> wordSet) {
    String result = null;
    //hashmap for mapping node in linked list
    HashMap<String, Node> nodeMap = new HashMap<>();
    //linkedlist for actual nodes - doubly linked list
    LinkedList linkedList = new LinkedList();

    // we can implement worditerator if interviewer asks to
    WordIterator iter = new WordIterator(doc);
    while (iter.hasNext()) {        
        WordIndex wordIndex = iter.next();
        String word = wordIndex.getWord();
        // if word is not equal to one provided skip
        if (!wordSet.contains(word))
            continue;
        
        // if reaches here than word is compared so see if it is available in linkedlist, if yes remove existing and add new one to tail
        if (nodeMap.containsKey(word)){
            Node toDelete = nodeMap.get(word);
            linkedList.delete(toDelete);
        }

        Node newNode = new Node(word, wordIndex.getIndex());
        linkedList.append(newNode);
        nodeMap.put(word, newNode);

        // now check if all the words provided to compare are there than update the reult if length is smaller else keep the same results
        if (nodeMap.size() == wordSet.size()) {
            int startIndex = linkedList.head.getIndex();
            int endIndex = linkedList.tail.getIndex() + linkedList.tail.getWord().length() - 1;
            if (result == null || (endIndex - startIndex + 1) < result.length()) {                
                result = doc.substring(startIndex, endIndex + 1);            
            }
        }
    }
}

// Doubly linked list
public class LinkedList {    
    Node head;    
    Node tail;    
    public LinkedList() {        
        head = null;        
        tail = null;    
    }

    public void append(Node toAdd) {        
        if (head == null) {            
            head = toAdd;        
        } else {            
            tail.setNext(toAdd);            
            toAdd.setPrev(tail);        
        }        
        tail = toAdd;    
    }

    public void delete(Node toDelete) {        
        if (toDelete == null)            
            return;

        if (toDelete.getPrev() != null)            
            toDelete.getPrev().setNext(toDelete.getNext());

        if (toDelete.getNext() != null)            
            toDelete.getNext().setPrev(toDelete.getPrev());

        if (toDelete == tail)            
            tail = toDelete.getPrev();  

        if (toDelete == head)
            head = toDelete.getNext();   
    }
}
