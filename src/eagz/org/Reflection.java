package eagz.org;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Reflection {
	
	@SuppressWarnings("rawtypes")
	Class clase;
	Object cliente;
	Field campos[];
	Method metodo, metodos[], metodosGet[];
	Scanner sc = new Scanner(System.in);
	
	public Reflection() { 
		try {
			clase = Class.forName("eagz.org.Cliente");
			cliente = clase.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void getMethods() {
		try {
			System.out.println("Charging methods. ");
			metodos = clase.getDeclaredMethods();
			metodosGet = new Method[metodos.length/2];
			int z = 0;
				for (int i = 0; i < metodos.length; i++) {
					if (metodos[i].getName().startsWith("get")) {
						metodosGet[z] = metodos[i];
						z++;
					}
			}
		} catch (Exception e) {
				e.printStackTrace();}
	}
				
	@SuppressWarnings("unchecked")
	public void printValues() {
		try {						
			campos = clase.getDeclaredFields();
			System.out.println("Getting Fields. \n");
			for (int i = 0; i < campos.length; i++) { 
				metodo = clase.getDeclaredMethod(metodosGet[i].getName());
				System.out.println(campos[i].getName()+" = "+metodosGet[i].invoke(cliente));
			}
		}catch (Exception e) {
			e.printStackTrace();}
	}
	
	@SuppressWarnings("unchecked")
	public void values() {
		try {
			System.out.println("Reflection");
			metodo = clase.getMethod("setId", int.class);
			System.out.println("Id: ");
			metodo.invoke(cliente, sc.nextInt() );
			sc.nextLine();
			
			metodo = clase.getMethod("setName", String.class);
			System.out.println("Name: ");
			metodo.invoke(cliente, sc.nextLine() );
			
			metodo = clase.getMethod("setLastn", String.class);
			System.out.println("Last Name:  ");
			metodo.invoke(cliente, sc.nextLine() );
			
			System.out.println("Done \n");
			sc.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		Reflection rc = new Reflection();
		rc.values();
		rc.getMethods();
		rc.printValues();
	}
}