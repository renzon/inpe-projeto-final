package tarefa2;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.esfinge.aom.api.model.IEntity;

public class ValidadorTarefa2 {
	
	public boolean validarEntidadeCobranca(IEntity cobranca) throws Exception{
		String cnpj= (String) cobranca.getProperty("cnpj").getValue();
		if (!Pattern.matches("[0-9]{2}\\.[0-9]{3}\\.[0-9]{3}\\/[0-9]{4}\\-[0-9]{2}", cnpj)){
			return false;
		}
		
		String empresa= (String) cobranca.getProperty("empresa").getValue();
		if (empresa==null || empresa == ""){
			return false;
		}
		
		double valor= (double) cobranca.getProperty("valor").getValue();
		if (valor>5000 || valor <0){
			return false;
		}
		
		int qtdItens= (int) cobranca.getProperty("quantidadeItens").getValue();
		if (qtdItens<=0){
			return false;
		}
		
		String destinatario= (String) cobranca.getProperty("destinatario").getValue();
		if (!Pattern.matches(".*@.*", destinatario)){
			return false;
		}
		
		Date agora=new Date();
		
		Date previsao= (Date) cobranca.getProperty("previsao").getValue();
		if (previsao.before(agora)){
			return false;
		}
		
		Date faturamento= (Date) cobranca.getProperty("faturamento").getValue();
		if (faturamento.after(agora)){
			return false;
		}
		
		return true;
	}

}
