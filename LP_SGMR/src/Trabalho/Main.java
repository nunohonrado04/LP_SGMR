package Trabalho;

public class Main {

	public static void main(String[] args)
	{
		BinSearchTree restauranteMesas=new BinSearchTree();
		restauranteMesas.inserirMesa(6);
		restauranteMesas.inserirMesa(3);
		restauranteMesas.inserirMesa(20);
		restauranteMesas.inserirMesa(1);
		restauranteMesas.inserirMesa(4);
		restauranteMesas.inserirMesa(9);
		restauranteMesas.inserirMesa(26);
		
		System.out.println("    ***********************************************************");
		System.out.println("    * 1 - Ordenar as mesas pela hora de chegada               *");
		System.out.println("    * 2 - Ordenar as mesas vazias de forma a manter uma       *");
		System.out.println("    * dist�ncia de seguran�a entre os clientes                *");
		System.out.println("    * 3 - reserva/marca��es                                   *");
		System.out.println("    * 4 - Inserir mesa                                        *");
		System.out.println("    * 5 - Retirar mesa                                        *");
		System.out.println("    ***********************************************************");
		
		restauranteMesas.inserirCliente(20);
		restauranteMesas.inserirCliente(3);
		restauranteMesas.inserirCliente(26);
		System.out.println(restauranteMesas.toString());
		
		System.out.println("\nTravessia em preOrder");
		Lista ordemChegada = restauranteMesas.preOrder();
		ordemChegada.printlist(ordemChegada.inicio);
		ordemChegada.insertionSort(ordemChegada.inicio);
		System.out.println("");
		ordemChegada.printlist(ordemChegada.inicio);
		
	}

}
