package App;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.Date;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import ClaseElemento.Comic;
import ClaseElemento.Elemento;
import ClaseElemento.Libro;
import ClaseElemento.Manga;
import ClaseElemento.Revista;
import ClasePersonas.Cliente;
import ClasePersonas.Empleado;
import ClasePersonas.Factura;
import ClasePersonas.Persona;
import ClasesMerchandising.Carta;
import ClasesMerchandising.Figura;
import ClasesMerchandising.JuegoDeMesa;
import ClasesMerchandising.Remera;
import Colecciones.CarroCompra;
import Colecciones.Catalogo;
import Colecciones.ListaClientes;
import Colecciones.ListaEmpleados;
import Colecciones.ListaFactura;
import Colecciones.ListaPersonas;
import Excepciones.OutOfStockException;
import Excepciones.PassIncorrectExcepcion;
import Json.JsonMetodos;
import Json.JsonUtiles;

public class MenuEjecutor {

	private int a;
	
	public MenuEjecutor() {
		this.a = 0;
	}
	
	static Scanner scan;
	public void datos() {
		
		ListaEmpleados<Empleado>listaEmpleados=new ListaEmpleados<>();
	
		listaEmpleados.cargarListaArchivo();
		
		/**
		Empleado empleado1= new Empleado("Hugo","Gutierrez","+54 9 2235458963",01,"0123456789",60000);
		Empleado empleado2= new Empleado("Carolina","Sabatella","+54 9 2235485234",02,"0123456789",60000);
		Empleado empleado3= new Empleado("Franccesco","Virgolini","+54 9 2235854521",03,"0123456789",75000);
		
		listaEmpleados.agregarObjLista(empleado1);
		listaEmpleados.agregarObjLista(empleado2);
		listaEmpleados.agregarObjLista(empleado3);
		
		*/
		ListaClientes<Cliente>listaCliente=new ListaClientes<>();
		listaCliente.cargarListaArchivo();
		
		/*
		Cliente cliente1= new Cliente("Javier","Coronel","+54 9 223458796",01,2000);
		Cliente cliente2= new Cliente("Sabrina","Gomez","+54 9 3515487854",02,1500);
		Cliente cliente3= new Cliente("Bruno","Lopez","+54 9 341 5789632",03,0);
		Cliente cliente4= new Cliente("Maria","Cardona","+54 9 3515478521",04,0);
		
		listaCliente.agregarObjLista(cliente4);
		listaCliente.agregarObjLista(cliente1);
		listaCliente.agregarObjLista(cliente2);
		listaCliente.agregarObjLista(cliente3);
		*/
		ListaFactura<Factura> miFacturas = new ListaFactura<>();
		miFacturas.cargarListaArchivo();
		programaEjecucion(miFacturas,listaCliente,listaEmpleados);

		miFacturas.guardarListaArchivo();
		listaCliente.guardarListaArchivo();
		listaEmpleados.guardarListaArchivo();
	}
	
	public static void programaEjecucion(ListaFactura listaFacturas,ListaClientes listaClientes,ListaEmpleados listaEmpleados) {
		
		Menu menuPrincipal= new Menu();
		scan= new Scanner (System.in);	
		int select=0;
		
		while(menuPrincipal.isSalida()==false) {
		
		System.out.println("Seleccionar opcion: \n");
		
		System.out.println("1- Menú Empleado ");
		System.out.println("2- Menú Cliente  ");
		System.out.println("3- Salir");
			
		select=scan.nextInt();
		menuPrincipal.setSelect(select);
		
		switch(menuPrincipal.getSelect()) {
		
		case 1:
			Empleado aux=menuSeleccionEmpleado(listaEmpleados);
			System.out.println("Ingresar id: \n");
			int id=scan.nextInt();
			System.out.println("Ingresar contraseña: \n");
			String password=scan.next();
			
			try {
			if(aux.verificarUsu(password, id)){
				
				System.out.println("Loggin correcto \n");
				menuParaEmpleado(listaEmpleados);
			}
			}
			catch (PassIncorrectExcepcion e) {
				System.out.println(e.getMessage());
			}
			break;
		
		case 2:
			menuParaCliente(listaFacturas,listaClientes);
			break;
		
		case 3:
			menuPrincipal.setSalida(true);
			System.out.println("Programa finzalizado \n");
			break;
		
		default:
			System.out.println("Opcion incorrecta \n");
			break;
		}	
	}
	scan.close();
	}

	public static void menuParaEmpleado(ListaEmpleados listaEmpleados) {

		/**
		listaEmpleados.agregarObjLista(empleado1);
		listaEmpleados.agregarObjLista(empleado2);
		listaEmpleados.agregarObjLista(empleado3);
		*/
		Menu menuEmpleado= new Menu();
		int select=0;
		menuEmpleado.setSelect(select);
		
		while(menuEmpleado.isSalida()==false) {
			
			System.out.println("Elegir opcion: \n");
			
			System.out.println("1- Ver lista de empleados");
			System.out.println("2- Eliminar un empleado");
			System.out.println("3- Mostrar un empleado");
			System.out.println("4- Salir");
		
			select=scan.nextInt();
			menuEmpleado.setSelect(select);
			
			switch(menuEmpleado.getSelect()) {
			
			case 1:
			
				System.out.println(listaEmpleados.mostrarLista());
				
			break;
			case 2:
				int flag=0;
				
				System.out.println(listaEmpleados.mostrarLista());
				System.out.println("Ingrese el id del empleado a eliminar: ");
				int eliminar = scan.nextInt();
				listaEmpleados.buscarYeliminarObj(eliminar);
				break;
			
			case 3:
				
				int flag1=0;
				
				System.out.println(listaEmpleados.mostrarApYNomLista());
				System.out.println("\nEscoja el Id que desea ver: \n");
				flag1=scan.nextInt();
				Empleado miEmpleado;
				miEmpleado= (Empleado) listaEmpleados.retornarEmpleado(flag1);
				System.out.println(listaEmpleados.mostrarObjLista(miEmpleado));
				break;
	
			case 4:
				menuEmpleado.setSalida(true);
				break;
			default: 
			System.out.println("Opcion incorrecta \n");
			break;
			}
		}
	}
	
	public static Empleado menuSeleccionEmpleado(ListaEmpleados listaEmpleados) {
		
		int select=0;
		boolean flag=false;
		int i=0;
		
		Empleado empleado;
		System.out.println("Elegir Empleado para loggin \n");
		System.out.println(listaEmpleados.mostrarApYNomLista());
		System.out.println("Ingrese el id del empleado a loggin: ");
		int id = scan.nextInt();
		empleado=(Empleado) listaEmpleados.retornarEmpleado(id);
		return empleado;
	}
	
	public static void menuParaCliente(ListaFactura miFactura,ListaClientes listaClientes)  {
		
		Menu menuCliente= new Menu();
		Catalogo listaElemento= new Catalogo();
	
		Elemento mafalda= new Libro(111000,499,100,"Argentina","Mafalda","De La Flor","Infantil",new Date(121,10,13),"Español",5,"Papel","Fisico");
		Elemento garfield= new Libro(111002,200,20,"Argentina","Garfield","De La Flor","Infantil",new Date(119,2,3),"Español",4,"Blanda","Fisico");
		
		
		Elemento cartaCharizard= new Carta(121111,250000,1,"Japon","Carta Charizard Mega Ultimate Edition","Pokemon","WIZARDS","Ultimate",true,"Ultra Rara");
		Elemento cartaMagoOscuro= new Carta(121112,100000,4,"Japon","Carta Mago oscuro","Yu gi oh!","Yu gi oh!","Base Set",true,"Rara");
		
		Elemento comicDCRebirth= new Comic(111001,499,200,"Estados Unidos", "DC Rebirth","DC","Superheroes",new Date(122,9,12),"Español",1,"Blanda","Fisico","Gary Frank","Gary Frank");
		Elemento comicFlashpoint= new Comic(111003,700,50,"Estados Unidos","Flashpoint","DC","Superheroes",new Date(120,10,5),"Español",1,"Blanda","Fisico","Andy Kubert","Andy Kubert");
		
		Elemento dragonball= new Manga(100000,499,70,"Japon", "Dragonball Super","Ivrea","Shonen",new Date(121,9,7),"Español",1,"Blanda","Fisico","ShonenJump","Akira Toriyama","Toyotaro" );
		Elemento slamdunk= new Manga(100001,600,50,"Japon","Slum Dunk","Ivrea","Shonen",new Date(120,1,2),"Español",5,"Blanda","Fisico","Shonen Jump","Takehiko Inoue","Takehiko Inoue");
		
		Elemento animedia= new Revista(100002,80,10,"Japon","Animedia","Palito","Infantil",new Date (120,5,5),"Español",3,"Blanda","Fisico","Infantil");
		Elemento orsai= new Revista(100003,100,20,"Argentina","Revista Orsai","Orsai","Infantil",new Date(119,5,7),"Español",1,"Blanda","Fisico","Infantil");
		
		Elemento thanos= new Figura(100004,5000,2,"Estados Unidos","Guantelete Thanos plastico,POSEE 5 GEMAS DEL INFINITO","Infinity","Thanos","Thanos","Guante completo con las 5 gemas del infinito",false,50);
		Elemento goku= new Figura(100005,7500,1,"Japon","MUÑECOS DRAGON BALL SUPER SAIYAN SON GOKU BLUE GOD","BANPRESTO CHINA","NO","Goku","Goku Blue God",false,22);
		
		Elemento monopoly= new JuegoDeMesa(100006,700,30,"Estados Unidos","Comprometida en hacer del mundo un lugar mejor, Hasbro desarrolla pasatiempos que tienen el objetivo de crear experiencias inolvidables para todas las personas usuarias. Con el Monopoly Los Simpson las horas de diversión y entretenimiento compartidos están aseguradas.","Hasbro","Hasbro","Monopoly","Los Simpson","9770","Estrategia",2,8);
		Elemento teg= new JuegoDeMesa(100007, 750, 20, "Estados Unidos", "¡Poné a prueba tu inteligencia y táctica en la batalla por conquistar el mundo! Tendrás que agrupar tus fuerzas estratégicamente para lograr cumplir las misiones y derribar a tus oponentes. Con el T.E.G. las horas de juego más entretenidas y apasionantes están garantizadas.", "Yetem", "Yetem", "TEG", "Tradicional", "1546A", "Estrategia", 2, 12);
		
		Elemento remera= new Remera(100008,500,15,"Argentina","Prendas de alta calidad con las mejores telas del mercado y en todos los talles , hacemos prendas desde el talle XS hasta el talle 8XL","YORKSTONE","YORKSTONE","XS,S,M,L,XL,XXL",'M',"Corta","Redondo");
		Elemento remera2= new Remera(100009,750,20,"Argentina","Prendas de alta calidad con las mejores telas del mercado y en todos los talles , hacemos prendas desde el talle XS hasta el talle 8XL","YORKSTONE","YORKSTONE","XS,S,M,L,XL,XXL",'F',"Larga","Redondo");
		
		listaElemento.agregarObjLista(mafalda);
		listaElemento.agregarObjLista(garfield);
		listaElemento.agregarObjLista(cartaCharizard);
		listaElemento.agregarObjLista(cartaMagoOscuro);
		listaElemento.agregarObjLista(comicDCRebirth);
		listaElemento.agregarObjLista(comicFlashpoint);
		listaElemento.agregarObjLista(dragonball);
		listaElemento.agregarObjLista(slamdunk);
		listaElemento.agregarObjLista(animedia);
		listaElemento.agregarObjLista(orsai);
		listaElemento.agregarObjLista(thanos);
		listaElemento.agregarObjLista(goku);
		listaElemento.agregarObjLista(monopoly);
		listaElemento.agregarObjLista(teg);
		listaElemento.agregarObjLista(remera);
		listaElemento.agregarObjLista(remera2);
	
		while (!menuCliente.isSalida()) {
			
			System.out.println("Selecciones una opcion");
			
			System.out.println("1- Ver catalogo de productos");
			System.out.println("2- Eliminar un producto");
			System.out.println("3- Buscar un objeto del catalogo");
			System.out.println("4- Atender cliente");
			System.out.println("5- Pasar Catalogo de json al archivo");
			System.out.println("6- Bajar json del archivo a java");
			System.out.println("7- Ver facturas");
			System.out.println("8- Ordenar lista");
			System.out.println("9- Salir");
			
			int select=scan.nextInt();
			menuCliente.setSelect(select);
			switch(menuCliente.getSelect()) {
			case 1:
				System.out.println(listaElemento.mostrarLista());
			break;
			
			case 2:
				try {
				System.out.println("Elegir producto a eliminar por codigo  \n");	
				int codigoBuscar=scan.nextInt();	
				listaElemento.eliminarObjLista(listaElemento.buscarObjeto(codigoBuscar));
				}
				catch (NullPointerException e) {
					e.printStackTrace();
				}
				catch (Exception e) {
				
					e.printStackTrace();
				}
				break;
				
			case 3:
				System.out.println("Elegir producto a buscar por codigo  \n");	
				int codigoBuscar=scan.nextInt();	
				System.out.println(listaElemento.mostrarObjLista(listaElemento.buscarObjeto(codigoBuscar)));
				break;	
				
			case 4:
				menuAtenderCliente(listaElemento,miFactura,listaClientes);
				break;
				
			case 5:
				JsonUtiles archivo=new JsonUtiles();
				JsonMetodos metodo= new JsonMetodos();
				System.out.println(metodo.javaToJson());
				break;
				
			case 6:
				JsonUtiles archivo1=new JsonUtiles();
				JsonMetodos metodo1= new JsonMetodos();
				metodo1.jsonToJava(archivo1.leer());
				break;
				
			case 7:
				System.out.println(miFactura.mostrarLista());
				break;
				
			case 8:
				listaElemento.ordenarLista ();
				System.out.println(listaElemento.mostrarLista());
				menuCliente.setSalida(true);
				break;
			
			case 9:
				menuCliente.setSalida(true);
				break;
	
			default:
				System.out.println("Opcion incorrecta ");
				break;
			}			
		}
	}
	
	public static void menuAtenderCliente( Catalogo catalogo, ListaFactura miFactura,ListaClientes listaCliente) {
		
		System.out.println(listaCliente.mostrarLista());
		Menu menuAtender= new Menu();
		while(!menuAtender.isSalida()) {
			System.out.println("Seleccione cliente a atender: ");
			System.out.println(listaCliente.mostrarApYNomLista());
			int select=scan.nextInt();
			Cliente cliente =  new Cliente();
			if(listaCliente.isCliente(select)) {
			cliente=listaCliente.retornaCliente(select);
			menuAtender.setSelect(select);
				
				String siguiente="si";
				String puntaje ="si";
				while(siguiente.contains("si")) {
				
				try {
				System.out.println("Ingresar codigo del producto que desea meter al carrito");
				int idProducto=scan.nextInt();
				
				cliente.agregarCompra(catalogo, idProducto);
				catalogo.reducirStock(idProducto);
				System.out.println(cliente.mostrarCarritoCliente());
				}
				
				catch(OutOfStockException e) {
					System.out.println(e.getMessage());
				}
				
				catch (Exception e) {
					System.out.println(e.getMessage());
				}
				System.out.println("Desea seguir agregando compra al carrito? si/no");
				siguiente=scan.next();
				}
				System.out.println("Desea gastar sus puntos en la compra si/no");
				puntaje=scan.next();
				double precio =0;
				if(cliente.ifPuntos() && puntaje.contains("si"))
				{
				precio=cliente.calcPrecioTotal()*0.90;
				System.out.println("Precio total: $ "+precio);
				cliente.gastarPuntos();
				}
				else 
				{
				precio=cliente.calcPrecioTotal();	
				System.out.println("Precio total:$ "+cliente.calcPrecioTotal());
				cliente.sumarPuntaje(cliente.calcPrecioTotal());
				}
				Factura facturaCLiente1 = new Factura(cliente.getId(),cliente.devolverCarrito(),new Date(121,10,6),(float)precio);
				miFactura.agregarObjLista(facturaCLiente1);
				System.out.println(facturaCLiente1.toString()+", Puntos: "+cliente.getSistemaPuntos());
				System.out.println(facturaCLiente1.toStringCarrito(cliente.devolverCarrito()));
				cliente.vaciarCarrito();
			}
			else {
				System.out.println("Cliente no encontrado \n");
			}	
			System.out.println("Desea seguir operando?  si/no \n");
			String cont=scan.next();
			if( cont.contains("no") )
			{
				menuAtender.setSalida(true);
			}	
				
		}
	}
}	
