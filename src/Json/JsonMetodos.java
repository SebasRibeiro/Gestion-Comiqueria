package Json;

import java.sql.Date;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonMetodos {


	private String nombre;

	public JsonMetodos() {
		this.nombre = null;
	}

	/**
	 * Pasa la lista catalogo a json y de ahi lo subo a un archivo.
	 * @return El Json en forma de String
	 */
	public String javaToJson() {
		
		
		JSONObject json=new JSONObject();
		try {
			JsonUtiles archi= new JsonUtiles();
			
			JSONArray catalogo=new JSONArray();
			json.put("Catalogo", catalogo);
			
			JSONObject cero= new JSONObject();
			cero.put("Descripcion", "Libro Mafalda");
			
			cero.put("Codigo barra", 111000);
			cero.put("Precio ", 499);
			cero.put("Stock",100);
			cero.put("Procedencia","Argentina");
			cero.put("Nombre", "Mafalda");
			cero.put("Editorial","De La Flor");
			cero.put("Genero","Infantil");
			cero.put("Fecha de publicacion",new Date(121,10,13));
			cero.put("Idioma", "Español");
			cero.put("Volumen",5);
			cero.put("Tipo de tapa", "papel");
			cero.put("Formato", "Fisico");
			
			
			JSONObject uno= new JSONObject();
			uno.put("Descripcion", "Libro Garfield");
			
			uno.put("Codigo barra", 111002);
			uno.put("Precio ", 200);
			uno.put("Stock",20);
			uno.put("Procedencia","Argentina");
			uno.put("Nombre", "Garfield");
			uno.put("Editorial","De La Flor");
			uno.put("Genero","Infantil");
			uno.put("Fecha de publicacion",new Date(119,2,3));
			uno.put("Idioma", "Español");
			uno.put("Volumen",4);
			uno.put("Tipo de tapa", "Blanda");
			uno.put("Formato", "Fisico");
			
			JSONObject dos= new JSONObject();
			dos.put("Concepto", "Carta Pokemon Charizard");
			
			dos.put("Codigo barra", 121111);
			dos.put("Precio ", 250000);
			dos.put("Stock ", 1);
			dos.put("Procedencia ", "Japon");
			dos.put("Descripcion ", "Carta Charizard Mega Ultimate Edition");
			dos.put("Fabricante ", "Pokemon");
			dos.put("Marca ", "WIZARDS");
			dos.put("Modelo ", "Ultimate");
			dos.put("Folio ", true);
			dos.put("Tipo de Rareza ", "Ultra rara");
			
			
			JSONObject tres=new JSONObject();
			tres.put("Concepto", "Carta Mago Oscuro");
			
			tres.put("Codigo barra", 121112);
			tres.put("Precio ", 100000);
			tres.put("Stock ", 4);
			tres.put("Procedencia ", "Japon");
			tres.put("Descripcion ", "Carta Mago oscuro");
			tres.put("Fabricante ", "Yu gi oh!");
			tres.put("Marca ", "Yu gi oh!");
			tres.put("Modelo ", "Base Set");
			tres.put("Folio ", true);
			tres.put("Tipo de Rareza ", "Rara");
			
			JSONObject cuatro=new JSONObject();
			cuatro.put("Descripcion ", "Comic Dc Rebirth");
			
			cuatro.put("Codigo de barra ", 111001);
			cuatro.put("Precio ", 499);
			cuatro.put("Stock ", 200);
			cuatro.put("Procedencia ", "Estados Unidos");
			cuatro.put("Nombre ", "DC Rebirth");
			cuatro.put("Editorial ", "DC");
			cuatro.put("Genero ", "Superheroes");
			cuatro.put("Fecha de publicacion ", new Date(122,9,12));
			cuatro.put("Idioma ", "Español");
			cuatro.put("Volumen ", 1);
			cuatro.put("Tipo de tapa ", "Blanda");
			cuatro.put("Formato ", "Fisico");
			cuatro.put("Colorista ", "Gary Frank");
			cuatro.put("Guionista ", "Gary Frank");
			
			
			JSONObject cinco= new JSONObject();
			cinco.put("Descripcion ", "Comic Flashpoint");
			
			cinco.put("Codigo de barra ", 111003);
			cinco.put("Precio ", 700);
			cinco.put("Stock ", 50);
			cinco.put("Procedencia ", "Estados Unidos");
			cinco.put("Nombre ", "FlashPoint");
			cinco.put("Editorial ", "DC");
			cinco.put("Genero ", "Superheroes");
			cinco.put("Fecha de publicacion ", new Date(120,10,5));
			cinco.put("Idioma ", "Español");
			cinco.put("Volumen ", 1);
			cinco.put("Tipo de tapa ", "Blanda");
			cinco.put("Formato ", "Fisico");
			cinco.put("Colorista ", "Andy Kubert");
			cinco.put("Guionista ", "Andy Kubert");
			
			JSONObject seis= new JSONObject();
			seis.put("Descripcion", "Dragon ball");
			
			seis.put("Codigo de barra ", 100000);
			seis.put("Precio ", 499);
			seis.put("Stock ", 70);
			seis.put("Procedencia ", "Japon");
			seis.put("Nombre ", "Dragonball Super");
			seis.put("Editorial ", "Ivrea");
			seis.put("Genero ", "Shonen");
			seis.put("Fecha de publicacion ", new Date(121,9,7));
			seis.put("Idioma ", "Español");
			seis.put("Volumen ", 1);
			seis.put("Tipo de tapa ", "Blanda");
			seis.put("Formato ", "Fisico");
			seis.put("Revista ", "Shonen Jump");
			seis.put("Mangaka ", "Akira Toriyama");
			seis.put("Dibujante ", "Toyotaro");
			
			JSONObject siete= new JSONObject();
			siete.put("Descripcion", "Slam Dunk");
			
			siete.put("Codigo de barra ", 100001);
			siete.put("Precio ", 600);
			siete.put("Stock ", 50);
			siete.put("Procedencia ", "Japon");
			siete.put("Nombre ", "Slum Dunk");
			siete.put("Editorial ", "Ivrea");
			siete.put("Genero ", "Shonen");
			siete.put("Fecha de publicacion ", new Date(120,1,2));
			siete.put("Idioma ", "Español");
			siete.put("Volumen ", 5);
			siete.put("Tipo de tapa ", "Blanda");
			siete.put("Formato ", "Fisico");
			siete.put("Revista ", "Shonen Jump");
			siete.put("Mangaka ", "Takehiko Inoue");
			siete.put("Dibujante ", "Takehiko Inoue");
			
			JSONObject ocho= new JSONObject();
			ocho.put("Descripcion", "Animedia");
			
			ocho.put("Codigo de barra ", 100002);
			ocho.put("Precio ", 80);
			ocho.put("Stock ", 10);
			ocho.put("Procedencia ", "Japon");
			ocho.put("Nombre ", "Animedia");
			ocho.put("Editorial ", "Palito");
			ocho.put("Genero ", "Infantil");
			ocho.put("Fecha de publicacion ", new Date (120,5,5));
			ocho.put("Idioma ", "Español");
			ocho.put("Volumen ", 3);
			ocho.put("Tipo de tapa ", "Blanda");
			ocho.put("Formato ", "Fisico");
			ocho.put("Categoria ", "Infantil");
			
			JSONObject nueve = new JSONObject();
			nueve.put("Descripcion", "Orsai");
			
			nueve.put("Codigo de barra ", 100003);
			nueve.put("Precio ", 100);
			nueve.put("Stock ", 20);
			nueve.put("Procedencia ", "Argentina");
			nueve.put("Nombre ", "Revista Orsai");
			nueve.put("Editorial ", "Orsai");
			nueve.put("Genero ", "Infantil");
			nueve.put("Fecha de publicacion ", new Date (119,5,7));
			nueve.put("Idioma ", "Español");
			nueve.put("Volumen ", 1);
			nueve.put("Tipo de tapa ", "Blanda");
			nueve.put("Formato ", "Fisico");
			nueve.put("Categoria ", "Infantil");
			
            JSONObject diez = new JSONObject();
            diez.put("Concepto", "Thanos");
            
            diez.put("Codigo de barra ", 100004);
            diez.put("Precio ", 5000);
            diez.put("Stock ", 2);
            diez.put("Procedencia ", "Estados Unidos");
            diez.put("Descripcion ", "Guantelete Thanos plastico,POSEE 5 GEMAS DEL INFINITO");
            diez.put("Fabricante ", "Infinity");
            diez.put("Franquicia ", "Thanos");
            diez.put("Personaje ", "Thanos");
            diez.put("Version del personaje ", "Guante completo con las 5 gemas del infinito");
            diez.put("Articulada ", false);
            diez.put("Altura ", 50);
             
            JSONObject once = new JSONObject();
            once.put("Concepto", "Goku");
            
            once.put("Codigo de barra ", 100005);
            once.put("Precio ", 7500);
            once.put("Stock ", 1);
            once.put("Procedencia ", "Japon");
            once.put("Descripcion ", "MUÑECOS DRAGON BALL SUPER SAIYAN SON GOKU BLUE GOD");
            once.put("Fabricante ", "BANPRESTO CHINA");
            once.put("Franquicia ", "NO");
            once.put("Personaje ", "Goku");
            once.put("Version del personaje ", "Goku Blue God");
            once.put("Articulada ", false);
            once.put("Altura ", 22);
            
            JSONObject doce = new JSONObject();
            doce.put("Concepto", "Monopoly");
            
            doce.put("Codigo de barra ", 100006);
            doce.put("Precio ", 700);
            doce.put("Stock ", 30);
            doce.put("Procedencia ", "Estados Unidos");
            doce.put("Descripcion ", "Comprometida en hacer del mundo un lugar mejor, Hasbro desarrolla pasatiempos que tienen el objetivo de crear experiencias inolvidables para todas las personas usuarias. Con el Monopoly Los Simpson las horas de diversión y entretenimiento compartidos están aseguradas.");
            doce.put("Fabricante ", "Hasbro");
            doce.put("Marca ", "Hasbro");
            doce.put("Nombre ", "Monopoly");
            doce.put("Edicion ", "Los Simpson");
            doce.put("Modelo alfanumerico ", "9770");
            doce.put("Tipo de juego ", "Estrategia");
            doce.put("Cantidad minima de jugadores ", 2);
            doce.put("Edad minima recomendada ", 8);
            
            JSONObject trece = new JSONObject();
            trece.put("Concepto", "TEG");
            
            trece.put("Codigo de barra ", 100007);
            trece.put("Precio ", 750);
            trece.put("Stock ", 20);
            trece.put("Procedencia ", "Estados Unidos");
            trece.put("Descripcion ", "¡Poné a prueba tu inteligencia y táctica en la batalla por conquistar el mundo! Tendrás que agrupar tus fuerzas estratégicamente para lograr cumplir las misiones y derribar a tus oponentes. Con el T.E.G. las horas de juego más entretenidas y apasionantes están garantizadas.");
            trece.put("Fabricante ", "Yetem");
            trece.put("Marca ", "Yetem");
            trece.put("Nombre ", "TEG");
            trece.put("Edicion ", "Tradicional");
            trece.put("Modelo alfanumerico ", "1546A");
            trece.put("Tipo de juego ", "Estrategia");
            trece.put("Cantidad minima de jugadores ", 2);
            trece.put("Edad minima recomendada ", 12);
            
            JSONObject catorce = new JSONObject();
            catorce.put("Concepto", "Remera");
            
            catorce.put("Codigo de barra ", 100008);
            catorce.put("Precio ", 500);
            catorce.put("Stock ", 15);
            catorce.put("Procedencia ", "Argentina");
            catorce.put("Descripcion ", "Prendas de alta calidad con las mejores telas del mercado y en todos los talles , hacemos prendas desde el talle XS hasta el talle 8XL");
            catorce.put("Fabricante ", "YORKSTONE");
            catorce.put("Marca ", "YORKSTONE");
            catorce.put("Modelo ", "XS,S,M,L,XL,XXL");
            catorce.put("Genero ", 'M');
            catorce.put("Tipo de manga ", "Corta");
            catorce.put("Tipo de cuello ", "Redondo");
            
            JSONObject quince = new JSONObject();
            quince.put("Remera2", "Remera");
            
            quince.put("Codigo de barra ", 100009);
            quince.put("Precio ", 750);
            quince.put("Stock ", 20);
            quince.put("Procedencia ", "Argentina");
            quince.put("Descripcion ", "Prendas de alta calidad con las mejores telas del mercado y en todos los talles , hacemos prendas desde el talle XS hasta el talle 8XL");
            quince.put("Fabricante ", "YORKSTONE");
            quince.put("Marca ", "YORKSTONE");
            quince.put("Modelo ", "XS,S,M,L,XL,XXL");
            quince.put("Genero ", 'F');
            quince.put("Tipo de manga ", "Larga");
            quince.put("Tipo de cuello ", "Redondo");
			
	        catalogo.put(cero);
			catalogo.put(uno);
			catalogo.put(dos);
			catalogo.put(tres);
			catalogo.put(cuatro);
			catalogo.put(cinco);
			catalogo.put(seis);
			catalogo.put(siete);
			catalogo.put(ocho);
			catalogo.put(nueve);
            catalogo.put(diez);
            catalogo.put(once);
            catalogo.put(doce);
            catalogo.put(trece);
            catalogo.put(catorce);
            catalogo.put(quince);
           
            archi.grabar(json);
    		}
			catch (JSONException e) {
				System.out.println(e.getMessage());
			}
		return json.toString();
		
	}
	
	/**
	 * Baja del archivo un Json y se pasa a java
	 * @param json
	 */
	public void jsonToJava(String json) {
		
		try {
		JSONObject inicio= new JSONObject(json);
		JSONArray array=inicio.getJSONArray("Catalogo");
		
		for(int i=0;i<2;i++) {
		JSONObject producto=array.getJSONObject(i);
		System.out.println(producto.getString("Descripcion"));
		System.out.println(producto.getString("Nombre"));
		System.out.println(producto.getString("Formato"));
		System.out.println(producto.getString("Idioma"));
		System.out.println(producto.getString("Procedencia"));
		System.out.println(producto.getString("Genero"));
		System.out.println(producto.getString("Tipo de tapa"));
		System.out.println(producto.getString("Editorial"));
		System.out.println(producto.getDouble("Precio "));
		System.out.println(producto.get("Fecha de publicacion"));
		System.out.println(producto.getInt("Stock"));
		System.out.println(producto.getInt("Volumen"));
		System.out.println(producto.getInt("Codigo barra"));
		System.out.println("-------------------------------------------------------------");
		}
		
		for(int i=2;i<4;i++) {
		
			JSONObject producto=array.getJSONObject(i);
			System.out.println(producto.getString("Concepto"));
			System.out.println(producto.getInt("Codigo barra"));
			System.out.println(producto.getDouble("Precio "));
			System.out.println(producto.getInt("Stock "));
			System.out.println(producto.getString("Procedencia "));
			System.out.println(producto.getString("Descripcion "));
			System.out.println(producto.getString("Fabricante "));
			System.out.println(producto.getString("Marca "));
			System.out.println(producto.getString("Modelo "));
			System.out.println(producto.getBoolean("Folio "));
			System.out.println(producto.getString("Tipo de Rareza "));
			System.out.println("-------------------------------------------------------------");
		}
		
		for(int i=4;i<6;i++) {
		
			JSONObject producto=array.getJSONObject(i);
			System.out.println(producto.getString("Descripcion "));
			System.out.println(producto.getInt("Codigo de barra "));
			System.out.println(producto.getDouble("Precio "));
			System.out.println(producto.getInt("Stock "));
			System.out.println(producto.getString("Procedencia "));
			System.out.println(producto.getString("Nombre "));
			System.out.println(producto.getString("Editorial "));
			System.out.println(producto.getString("Genero "));
			System.out.println(producto.get("Fecha de publicacion "));
			System.out.println(producto.getString("Idioma "));
			System.out.println(producto.getInt("Volumen "));
			System.out.println(producto.getString("Tipo de tapa "));
			System.out.println(producto.getString("Formato "));
			System.out.println(producto.getString("Colorista "));
			System.out.println(producto.getString("Guionista "));
			System.out.println("-------------------------------------------------------------");
		}
		
		for(int i=6;i<8;i++) {
			JSONObject producto=array.getJSONObject(i);
			System.out.println(producto.getString("Descripcion"));
			System.out.println(producto.getInt("Codigo de barra "));
			System.out.println(producto.getDouble("Precio "));
			System.out.println(producto.getInt("Stock "));
			System.out.println(producto.getString("Procedencia "));
			System.out.println(producto.getString("Nombre "));
			System.out.println(producto.getString("Editorial "));
			System.out.println(producto.getString("Genero "));
			System.out.println(producto.get("Fecha de publicacion "));
			System.out.println(producto.getString("Idioma "));
			System.out.println(producto.getInt("Volumen "));
			System.out.println(producto.getString("Tipo de tapa "));
			System.out.println(producto.getString("Formato "));
			System.out.println(producto.getString("Revista "));
			System.out.println(producto.getString("Mangaka "));
			System.out.println(producto.getString("Dibujante "));
			System.out.println("-------------------------------------------------------------");
		}
		
		for(int i=8;i<10;i++) { 
		
			JSONObject producto=array.getJSONObject(i);
			System.out.println(producto.getString("Descripcion"));
			System.out.println(producto.getInt("Codigo de barra "));
			System.out.println(producto.getDouble("Precio "));
			System.out.println(producto.getInt("Stock "));
			System.out.println(producto.getString("Procedencia "));
			System.out.println(producto.getString("Nombre "));
			System.out.println(producto.getString("Editorial "));
			System.out.println(producto.getString("Genero "));
			System.out.println(producto.get("Fecha de publicacion "));
			System.out.println(producto.getString("Idioma "));
			System.out.println(producto.getInt("Volumen "));
			System.out.println(producto.getString("Tipo de tapa "));
			System.out.println(producto.getString("Formato "));
			System.out.println(producto.getString("Categoria "));
			System.out.println("-------------------------------------------------------------");
		}
		
		for (int i=10;i<12;i++) {
			JSONObject producto=array.getJSONObject(i);
			System.out.println(producto.getInt("Codigo de barra "));
			System.out.println(producto.getDouble("Precio "));
			System.out.println(producto.getInt("Stock "));
			System.out.println(producto.getString("Procedencia "));
			System.out.println(producto.getString("Descripcion "));
			System.out.println(producto.getString("Fabricante "));
			System.out.println(producto.getString("Franquicia "));
			System.out.println(producto.getString("Personaje "));
			System.out.println(producto.getString("Version del personaje "));
			System.out.println(producto.getBoolean("Articulada "));
			System.out.println(producto.getInt("Altura "));
			System.out.println("-------------------------------------------------------------");
		}
		
		for (int i =12;i<14;i++) {
			JSONObject producto=array.getJSONObject(i);
			System.out.println(producto.getInt("Codigo de barra "));
			System.out.println(producto.getDouble("Precio "));
			System.out.println(producto.getInt("Stock "));
			System.out.println(producto.getString("Procedencia "));
			System.out.println(producto.getString("Descripcion "));
			System.out.println(producto.getString("Fabricante "));
			System.out.println(producto.getString("Marca "));
			System.out.println(producto.getString("Nombre "));
			System.out.println(producto.getString("Edicion "));
			System.out.println(producto.getString("Modelo alfanumerico "));
			System.out.println(producto.getString("Tipo de juego "));
			System.out.println(producto.getInt("Cantidad minima de jugadores "));
			System.out.println(producto.getInt("Edad minima recomendada "));
			System.out.println("-------------------------------------------------------------");
		}
		for (int i =14;i<16;i++) {
			JSONObject producto=array.getJSONObject(i);
			System.out.println(producto.getInt("Codigo de barra "));
			System.out.println(producto.getDouble("Precio "));
			System.out.println(producto.getInt("Stock "));
			System.out.println(producto.getString("Procedencia "));
			System.out.println(producto.getString("Descripcion "));
			System.out.println(producto.getString("Fabricante "));
			System.out.println(producto.getString("Marca "));
			System.out.println(producto.getString("Modelo "));
			System.out.println(producto.get("Genero "));
			System.out.println(producto.getString("Tipo de manga "));
			System.out.println(producto.getString("Tipo de cuello "));
			System.out.println("-------------------------------------------------------------");
		
		}
		}
		catch (JSONException e) {
			e.printStackTrace();
		}
		
	
		}
	}
