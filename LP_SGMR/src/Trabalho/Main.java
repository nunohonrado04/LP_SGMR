package Trabalho;

import java.util.LinkedList;
import java.util.Scanner;


public class Main 
{
	public static void main(String[] args)
	{
		int opcao = 0;
		Celula head;
		Lista ordemChegada;
		Pilha p = new ListPilha();
		
		BinSearchTree restauranteMesas=new BinSearchTree();
		restauranteMesas.inserirMesa(8);
		restauranteMesas.inserirMesa(3);
		restauranteMesas.inserirMesa(20);
		restauranteMesas.inserirMesa(1);
		restauranteMesas.inserirMesa(5);
		restauranteMesas.inserirMesa(9);
		restauranteMesas.inserirMesa(25);
		
		System.out.println("Restaurante:");
		restauranteMesas.desenharArvore();
		
		System.out.println("\n");
		System.out.println("********************************************************");
		
		BinSearchTree esplanadaMesas=new BinSearchTree();
		esplanadaMesas.inserirMesa(7);
		esplanadaMesas.inserirMesa(3);
		esplanadaMesas.inserirMesa(19);
		esplanadaMesas.inserirMesa(2);
		esplanadaMesas.inserirMesa(8);
		esplanadaMesas.inserirMesa(4);
		esplanadaMesas.inserirMesa(22);
		
		System.out.println("Esplanada:");
		esplanadaMesas.desenharArvore();
		
		
		do 
		{
			System.out.println("\n");
			System.out.println("\n");
			System.out.println("    ***********************************************************");
			System.out.println("    *    1 - Ordenar as mesas da esplanada pela hora          *");
			System.out.println("    *        de chegada                                       *");
			System.out.println("    *    2 - Inserir cliente na esplanada                     *");
			System.out.println("    *    3 - Saber mesa para sentar no restaurante            *");
			System.out.println("    *        (dist�ncia entre mesas)                          *");
			System.out.println("    *    4 - Inserir mesa do restaurante para reservar        *");
			System.out.println("    *    5 - Inserir mesa no restaurante                      *");
			System.out.println("    *    6 - Retirar mesa no restaurante                      *");
			System.out.println("    *    7 - Inserir mesa na esplanada                        *");
			System.out.println("    *    8 - Retirar mesa na esplanada                        *");
			System.out.println("    *    9 - Mostrar esplanada e restaurante                  *");
			System.out.println("    *    0 - Sair do menu                                     *");
			System.out.println("    ***********************************************************");

			
			Scanner myObj = new Scanner(System.in);  
			System.out.println("Op��o -> ");

			opcao = myObj.nextInt(); 
			
			System.out.print("\n");
			
			switch (opcao) 
			{
				case 1:
					System.out.println("Op��o -> 1");
					System.out.println("\nOrdem de chegada pela hora");
				
					ordemChegada = esplanadaMesas.preOrder();
				
					//ordemChegada.printlist(ordemChegada.inicio);
					System.out.println("");
				
					ordemChegada.insertionSort(ordemChegada.inicio);
					ordemChegada.printlist(ordemChegada.inicio);
					break;
			
				case 2:
					System.out.println("Op��o -> 2");
					System.out.println("Insira o n�mero da mesa da esplanada -> ");
					int mesa = myObj.nextInt();
					esplanadaMesas.inserirCliente(mesa);
					break;
			
				case 3:
					System.out.println("Op��o -> 3");
					System.out.println("\nDist�ncia entre mesas:");
					Lista listaMesasDistancia = esplanadaMesas.preOrderOcupacao();
					head = listaMesasDistancia.inicio;
					while (head != null)  
					{ 
						p.colocar(head.no.getValor());
						head = head.next; 
					}	
					System.out.println("Mesa n�mero: "+esplanadaMesas.imprimirProximaMesa(p));
					p.retirar();
					break;
			
				case 4:
					System.out.println("Op��o -> 4");
					System.out.println("Reservar mesa n�mero -> ");
					int nMesaReservada = myObj.nextInt();
					restauranteMesas.marcarMesa(nMesaReservada);
					break;
			
				case 5:
					System.out.println("Op��o -> 5");
					System.out.println("Insira n�mero para a mesa do restaurante -> ");
					int nMesa = myObj.nextInt();
					restauranteMesas.inserirMesa(nMesa);
					break;
			
				case 6:
					System.out.println("Op��o -> 6");
					System.out.println("Eliminar mesa n�mero -> ");
					int nMesaEliminadaEsplanada = myObj.nextInt();
					restauranteMesas.EliminarMesa(nMesaEliminadaEsplanada);
					break;
			
				case 7:
					System.out.println("Op��o -> 7");
					System.out.println("Insira n�mero para a mesa da esplanada -> ");
					int nMesaInserida = myObj.nextInt();
					esplanadaMesas.inserirMesa(nMesaInserida);
					break;
			
				case 8:
					System.out.println("Op��o -> 8");
					System.out.println("Eliminar mesa n�mero -> ");
					int nMesaEliminada = myObj.nextInt();
					esplanadaMesas.EliminarMesa(nMesaEliminada);
					break;
				
				case 9:
					System.out.println("Op��o -> 9");
					System.out.println("Restaurante:");
					restauranteMesas.desenharArvore();
					System.out.println("\n");
					System.out.println("********************************************************");
					System.out.println("Esplanada:");
					esplanadaMesas.desenharArvore();
					break;
			
				case 0:
					break;
				
				default:
					System.out.println("Op��o Inv�lida!");
					break;
			}
			
		} while (opcao != 0);
			
	}//main

}//Main
