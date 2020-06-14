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
		restauranteMesas.inserirMesa(25);
		restauranteMesas.desenharArvore();
		
		/*System.out.println("    ***********************************************************");
		System.out.println("    * 1 - Ordenar as mesas pela hora de chegada               *");
		System.out.println("    * 2 - Ordenar as mesas vazias de forma a manter uma       *");
		System.out.println("    * distância de segurança entre os clientes                *");
		System.out.println("    * 3 - reserva/marcações                                   *");
		System.out.println("    * 4 - Inserir mesa                                        *");
		System.out.println("    * 5 - Retirar mesa                                        *");
		System.out.println("    ***********************************************************");
		
		restauranteMesas.inserirCliente(25);
		restauranteMesas.inserirCliente(20);
		restauranteMesas.inserirCliente(3);
		restauranteMesas.inserirCliente(1);
		restauranteMesas.inserirCliente(9);
		
		restauranteMesas.EliminarMesa(9);
		
		restauranteMesas.marcarMesa(4);
		
		restauranteMesas.desenharArvore();
		System.out.println("\nTravessia em preOrder");
		Lista ordemChegada = restauranteMesas.preOrder();
		ordemChegada.printlist(ordemChegada.inicio);
		ordemChegada.insertionSort(ordemChegada.inicio);
		System.out.println("");
		ordemChegada.printlist(ordemChegada.inicio);*/
		
		
		
		restauranteMesas.inserirComDistanciaEntreMesas();
		restauranteMesas.inserirComDistanciaEntreMesas();
		
		System.out.println("\nTravessia em preOrderOcupação");
		Lista ordemChegada = restauranteMesas.preOrder();
		ordemChegada.printlist(ordemChegada.inicio);
		ordemChegada.insertionSort(ordemChegada.inicio);
		System.out.println("");
		ordemChegada.printlist(ordemChegada.inicio);
	}

}
