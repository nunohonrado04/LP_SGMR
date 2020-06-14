package Trabalho;

import java.time.LocalTime;

public class Lista {
	Celula inicio; 
	Celula sorted; 
  
	public void push(NoBinTree val)  
    { 
    	Celula newnode = new Celula(val); 
        newnode.next = inicio; 
        inicio = newnode; 
    } 
  
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
    } 
  
    private void sortedInsert(Celula newnode)  
    { 
    	System.out.println(sorted.no.getHora()); 
    	
	    
    
        if (sorted == null || sorted.no.getValor()<= newnode.no.getValor())   //<=
        { 
            newnode.next = sorted; 
            sorted = newnode; 
        } 
        else 
        { 
        	Celula current = sorted;
            while (current.next != null && current.next.no.getValor() < newnode.no.getValor())  //<
            { 
                current = current.next; 
            } 
            newnode.next = current.next; 
            current.next = newnode; 
        } 
    } 
  
    public void printlist(Celula head)  
    { 
    	while (head != null)  
        { 
            System.out.print(head.no.getValor() + " "); 
            head = head.next; 
        } 
    } 
}
