package controller;


import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class KillController {

	private String os() {
		return System.getProperty("os.name");
	}
	
	
	public void listaProcessos() {
		String nomeOs = os();
		
		if(nomeOs.contains("Windows")) {
			
			try {
				Process p = Runtime.getRuntime().exec("TASKLIST /FO TABLE");
				InputStream stream = p.getInputStream();
				InputStreamReader reader = new InputStreamReader(stream);
				BufferedReader buffer = new BufferedReader(reader);
				
				String linha = buffer.readLine();
				while(linha != null) {
					System.out.println(linha);
					
					linha = buffer.readLine();
				}
				
				buffer.close();
				reader.close();
				stream.close();
				
			}catch(IOException e) {
				String err = e.getMessage();
				System.err.println(err);
			}
			
			
		}else if(nomeOs.contains("Linux")) {
			try {
				Process p = Runtime.getRuntime().exec("ps -ef");
				InputStream stream = p.getInputStream();
				InputStreamReader reader = new InputStreamReader(stream);
				BufferedReader buffer = new BufferedReader(reader);
				
				String linha = buffer.readLine();
				while(linha != null) {
					System.out.println(linha);
					
					linha = buffer.readLine();
				}
				
				buffer.close();
				reader.close();
				stream.close();
				
			}catch(IOException e) {
				String err = e.getMessage();
				System.err.println(err);
			}
			
			
		}else {
			System.out.println("Sistema operacional não indentificado");
		}
	}
	
	
	
	public void mataPid(String pid) {
		String nomeOs = os();
		
		if(nomeOs.contains("Windows")) {
			try {
			Runtime.getRuntime().exec("TASKKILL /PID "+pid);
			
			}catch(IOException e) {
				String err = e.getMessage();
				System.err.println(err);
			}
			
			
			
		}else if(nomeOs.contains("Linux")) {
			try {
				Runtime.getRuntime().exec("kill -9 "+pid);
				
				}catch(IOException e) {
					String err = e.getMessage();
					System.err.println(err);
				}
				
			
		}else {
			System.out.println("Sistema operacional não indentificado");
		}
	}
	
	
	
	
	public void mataNome(String nome) {
		String nomeOs = os();
		
		if(nomeOs.contains("Windows")) {
			try {
				Runtime.getRuntime().exec("TASKKILL /IM"+nome);
				
				}catch(IOException e) {
					String err = e.getMessage();
					System.err.println(err);
				}
			
		}else if(nomeOs.contains("Linux")) {
			try {
				Runtime.getRuntime().exec("pkill -f "+nome);
				
				}catch(IOException e) {
					String err = e.getMessage();
					System.err.println(err);
				}
			
			
		}else {
			System.out.println("Sistema operacional não indentificado");
		}
	}
}
