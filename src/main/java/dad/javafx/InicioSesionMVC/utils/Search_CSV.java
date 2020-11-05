package dad.javafx.InicioSesionMVC.utils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.FileUtils;

public class Search_CSV {

	private static String ruta = "UsersAndPasswords.csv";
	private static final File Archivo = new File(ruta);
	private static String Keyword;
	private static boolean UserAndPasswordFound;
	private static int StringLength;
	
	public Search_CSV() {
		CreateFile();
	}
	
	public static boolean Buscar(String Usuario, String ContraseñaCifrada) throws IOException {
		Boolean ExistsAccount= false; //0 si todo correcto y 1 si no encuentra alguno de los campos
		if (!Archivo.exists()) {
			System.out.print("Este archivo no existe");
		}
		else {
			String content = FileUtils.readFileToString(
					Archivo, Charset.forName("UTF-8")
			);
			
			Keyword = Usuario+","+ContraseñaCifrada;
			StringLength = 0;
			
			UserAndPasswordFound = SearchKeyword(Usuario+","+ContraseñaCifrada,content);
			
			ExistsAccount= UserAndPasswordFound;
		}
		return ExistsAccount;
	}
	
	
	private static boolean SearchKeyword(String keyword, String content) {
		//Aquí está el error
		Boolean found = Arrays.asList(content.split("\r\n")).contains(keyword);
		return found;
	}
	
	
	private static void CreateFile () {
		try {
			File Archivo = new File(ruta);
			if (Archivo.createNewFile()) {
				System.out.println("File created: " + Archivo.getName());
			} else {
				System.out.println("File already exists.");
			}
		} catch (IOException e) {
			System.out.println("An error occurred.");
		}
	}
/*	
	public static void main(String args[]) {
		String Usuario = "chuck";
		String Contraseña = DigestUtils.md5Hex("norris").toUpperCase();
		try {
			Buscar(Usuario, Contraseña);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
*/
}
