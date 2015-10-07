package br.com.acp.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FuncoesUteis {
	
	
	 public static boolean validEmail(String email) {
		    Pattern p = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@([\\w-]+\\.)+[a-zA-Z]{2,7}$"); 
		    Matcher m = p.matcher(email); 
		    if (m.find()){
		     // System.out.println("O email "+email+" e valido");
		      return true;
		    }
		    else{
		     // System.out.println("O E-mail "+email+" é inválido");
		      return false;
		    }  
		 }
	
	public static String limpaCaracter(String campo){
		campo = campo.replace(".","");
		campo = campo.replace("-", "");
		campo = campo.replace("/", "");
		return campo;
	}
	
	public static String cifraString(String campo){
		MessageDigest MD;
		String senhaCifrada = "";
		try {
			MD = MessageDigest.getInstance("MD5");
			MD.update(campo.getBytes(),0,campo.length());
			
		    senhaCifrada =   new BigInteger(1,MD.digest()).toString(16);
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return senhaCifrada;
	} 

	public static String converteStringToDataYYYYMMddThhmmssZ(Date data){
		String dataFormatada = null;
		if(data != null){
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ssZ");
			dataFormatada = simpleDateFormat.format(data);
		}
		return dataFormatada;
	}

	public static String converteDataToStringDDMMYYYY(Date data){
		String dataFormatada = null;
		if(data != null){
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
			dataFormatada = simpleDateFormat.format(data);
		}
		return dataFormatada;	
	}
	
	public static String recuperaAnoString(Date data){
		String dataFormatada = null;
		if(data != null){
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
			dataFormatada = simpleDateFormat.format(data);
		}
		return dataFormatada;	
	}
	
	public static String converteDataToStringExtenso(Date data){
		String dataFormatada = null;
		if(data != null){
			Locale locale = new Locale("pt", "BR"); 
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEEEE ',' dd ' de 'MMMM ' de ' yyyy", locale);
			dataFormatada = simpleDateFormat.format(data);
		}
		return dataFormatada;	
	}
	public static String preencheStringEsquerda(String palavra, int tamanho, String completarCom){
		  StringBuilder sb = new StringBuilder(palavra);
		  while (sb.length() < tamanho )
		  {
		      sb.insert(0,completarCom);
		  }
		  return  sb.toString();
	  }
	/*
	 * Devolve a diferença de Datas em DIAS;
	 */
	public static long duracaoDataEmDias(Date dataInicial, Date dataFinal) {
		Calendar di = Calendar.getInstance();
		Calendar df = Calendar.getInstance();
		di.setTime(dataInicial);
		df.setTime(dataFinal);
		long diff = (df.getTimeInMillis() - di.getTimeInMillis());
		int tempoDia = 1000 * 60 * 60 * 24;
		long res = diff / tempoDia;
		return res;
	}
	public static String preparaStringParaLike(String frase){

		String retorno = "";
		frase = frase.replaceAll("[^\\sA-Za-z0-9_]","_");
		//System.out.println(frase);
		StringTokenizer valores = new StringTokenizer(frase," "); 
		while(valores.hasMoreTokens()){ 
		retorno = retorno + "%"+ valores.nextToken() ;  
		}  
		return retorno + "%";
		}
	
	public static String colocarMascaraCPF(String cpf) {

		cpf = cpf.substring(0, 3) + '.' + cpf.substring(3, 6) + '.'
		+ cpf.substring(6, 9) + '-' + cpf.substring(9, 11);
		return cpf;
	}

    public static String aplicaRegex(String regex, String campo) {
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(campo);
        if (m.find()){
           return m.group();
        }
        else{
           return campo;
        }
    }

}

