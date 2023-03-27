package Conversor;
import javax.swing.JOptionPane;


public class Conversor {

	public static void main(String[] args) {
	
	method1();
	
	}
		
	public static void method1() {
		
		// Variables para los valores de cada moneda basada en su valor contra el USD
		
		double USD = 1;
		double CAD = 0.73;
		double AUD = 0.66;
		double EUR = 1.06;
		double GBP = 1.20;
		double ARS = 0.0049;
		double COP = 0.00021;
		double MXN = 0.053;
		double GTQ = 0.13;
		double KWR = 0.00076;
		double JPY = 0.0075;
		
		//Se utiliza un array para tener acceso a todas las variables creadas de forma mas conveniente
		
		double[] tipoCam = {USD, CAD, AUD, EUR, GBP, ARS, COP, MXN, GTQ, KWR, JPY};
		
		
		//Muestra ventana de dialogo para escoger el conversor que se desea utilizar 
		
		String[] choices = {"Conversor de Moneda", "Conversor de Temperatura"};
		
		String SeleccionConversor = (String) JOptionPane.showInputDialog(null,"Seleccione una opción de conversión","Conversor",JOptionPane.QUESTION_MESSAGE, null,choices,choices[0]);
		
		String[] monedas = {"Dólar Estadounidense", "Dólar Canadiense", "Dólar Australiano", "Euro", "Libras Esterlinas", "Peso Argentino", "Peso Colombiano", "Peso Mexicano", "Quetzal Guatemalteco", "Won sul-coreano", "Yen Japonés"};
		
		//Si la opcion seleccionada es igual a posicion 0 del array se ejecuta el conversor de moneda
		
		if (SeleccionConversor == choices[0]) {
			
			//Ventanas de dialogo para escoger las monedas y la cantidad a convertir
			
			String SelMoneda1 = (String) JOptionPane.showInputDialog(null, "Seleccione la primera moneda", "Conversor",JOptionPane.QUESTION_MESSAGE, null, monedas, monedas[0]);
			String SelMoneda2 = (String) JOptionPane.showInputDialog(null, "Seleccione la segunda moneda", "Conversor",JOptionPane.QUESTION_MESSAGE, null, monedas, monedas[0]);
			String cantidadMon =  (String) JOptionPane.showInputDialog(null, "Ingrese la cantidad de " + SelMoneda1 + " a convertir", "Conversor", JOptionPane.QUESTION_MESSAGE);
			
			
			//Variable para convertir cantidad a double y mandar mensaje de error en caso de que lo ingresado por el usuario no sea un valor numerico
			double cantidad = 0;
			
			try { 
			cantidad = Double.parseDouble(cantidadMon);
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, "Valor no valido");
				method1();
			} 
			
			//Estas variables sirven para ubicar la posicion de la moneda dentro del array para poder seleccionar su valor
			
			int num1 = 0;
			int num2 = 0;
			
			for(int i = 0; i < monedas.length; i++) { 
				
				if (SelMoneda1 == monedas[i]) {
					num1 = i;
				}
			}
			
			for(int i = 0; i < monedas.length; i++) { 
				
				if (SelMoneda2 == monedas[i]) {
					num2 = i;
				}
			}
			
			//Operacion de conversion y cuadro de dialogo con resultado
			
			double resultado = cantidad * tipoCam[num1] * USD / tipoCam[num2];
			
			JOptionPane.showMessageDialog(null, cantidad + " " + SelMoneda1 + " equivalen a " + resultado + " " + SelMoneda2);
			
			//Cuadro de dialogo para preguntar al usuario si desea seguir utilizando el programa
			
			int pregunta = JOptionPane.showConfirmDialog(null, "¿Deseas continuar?");
			
			if (pregunta == JOptionPane.YES_OPTION) {
				method1();
			} else {
				JOptionPane.showMessageDialog(null, "Programa Finalizado");
			}
			
			
			// El caso de que el usuario escoga la opcion 1 del array se ejecuta el conversor de temperatura
			
		} else if (SeleccionConversor == choices[1]) {
			
			String[] temperatura = {"Conversión de Celsius a Fahrenheit", "Conversión de Celsius a Kelvin", "Conversión de Fahrenheit a Celsius", "Conversión de Fahrenheit a Kelvin"};
			
			String SelTemp = (String) JOptionPane.showInputDialog(null, "Seleccione la operacion que desea realizar", "Conversor",JOptionPane.QUESTION_MESSAGE, null, temperatura, temperatura[0]);
			String grados =  (String) JOptionPane.showInputDialog(null, "Ingrese cuantos grados desea convertir", "Conversor", JOptionPane.QUESTION_MESSAGE);
			
			double gradosDouble = 0;
			
			try { 
				gradosDouble = Double.parseDouble(grados);
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, "Valor no valido");
				method1();
			}
			
			if (SelTemp == temperatura[0]) {
				double resultado = gradosDouble * 9/5 + 32;
				JOptionPane.showMessageDialog(null, gradosDouble + " grados Celsius equivalen a " + resultado + " grados Fahrenheit");
				
			} else if (SelTemp == temperatura[1]) {
				double resultado = gradosDouble + 273.15;
				JOptionPane.showMessageDialog(null, gradosDouble + " grados Celsius equivalen a " + resultado + " grados Kelvin");
				
			} else if (SelTemp == temperatura[2]) {
				double resultado = (gradosDouble - 32) * 5/9;
				JOptionPane.showMessageDialog(null, gradosDouble + " grados Fahrenheit equivalen a " + resultado + " grados Celsius");
				
			} else {
				double resultado = (gradosDouble + 459.67) * 5/9;
				JOptionPane.showMessageDialog(null, gradosDouble + " grados Fahrenheit equivalen a " + resultado + " grados Kelvin");
			}
			
			int pregunta = JOptionPane.showConfirmDialog(null, "¿Deseas continuar?");
			
			if (pregunta == JOptionPane.YES_OPTION) {
				method1();
			} else {
				JOptionPane.showMessageDialog(null, "Programa Finalizado");
			}
			
		}
		
		

	}

}

