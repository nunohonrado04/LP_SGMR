package Trabalho;


public class Lista {
	Celula inicio; 
	Celula sorted; 
  
	public void push(NoBinTree val)  
    { 
    	Celula newnode = new Celula(val); 
        newnode.next = inicio; 
        inicio = newnode; 
    }//push
  
	public void insertionSort(Celula headref)  
	{ 
		sorted = null; 
	    Celula current = headref; 

	    while (current != null)  
	    { 
	    	Celula next = current.next; 
	    	sortedInsert(current); 
	        current = next; 
	    } 
	     
	    inicio = sorted; 
	}//insertionSort
	  
	public void sortedInsert(Celula newnode)  
	{     
		if (sorted == null || sorted.no.getHora().isAfter(newnode.no.getHora()))  
	    { 
			newnode.next = sorted; 
	        sorted = newnode; 
	    } 
	    else 
	    { 
	    	Celula current = sorted; 
	        while (current.next != null && current.next.no.getHora().isBefore(newnode.no.getHora()))  
	        { 
	        	current = current.next; 
	        } 
	        newnode.next = current.next; 
	        current.next = newnode; 
	    } 
	}//sortedInsert
  
    public void printlist(Celula head)  
    { 
    	while (head != null)  
        { 
            System.out.print(head.no.getValor() + " "); 
            head = head.next; 
        } 
    }//printlist
}//Lista
