package tarefa1;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.esfinge.aom.api.model.IEntityType;
import org.esfinge.aom.exceptions.EsfingeAOMException;
import org.esfinge.aom.model.impl.GenericEntityType;
import org.esfinge.aom.model.impl.GenericPropertyType;


public class FabricaTiposTarefa1 {
	
	public static IEntityType getTipoEntidadePessoa() throws EsfingeAOMException{
		IEntityType tipoPessoa = new GenericEntityType("Pessoa");
		
		//criando property types
		GenericPropertyType nomePropertyType = new GenericPropertyType("nome", String.class);
		Map<String,Object> nomeMetadados = new HashMap<>();
		nomeMetadados.put("min", 5);
		nomeMetadados.put("max", 50);
		nomePropertyType.setProperty("size", nomeMetadados);
		GenericPropertyType alturaPropertyType = new GenericPropertyType("altura", Integer.class);
		
		Map<String,Object> alturaMetadados = new HashMap<>();
		alturaMetadados.put("max", 215L);
		alturaMetadados.put("min", 0L);
		alturaPropertyType.setProperty("range", alturaMetadados);
		
		
		GenericPropertyType cpfPropertyType = new GenericPropertyType("cpf", String.class);
		cpfPropertyType.setProperty("pattern", "[0-9]{3}\\.[0-9]{3}\\.[0-9]{3}\\-[0-9]{2}");
		GenericPropertyType emailPropertyType = new GenericPropertyType("email", String.class);
		emailPropertyType.setProperty("email", true);
		GenericPropertyType profissaoPropertyType = new GenericPropertyType("profissao", String.class);
		profissaoPropertyType.setProperty("notempty", true);
		GenericPropertyType nascimentoPropertyType = new GenericPropertyType("nascimento", Date.class);
		nascimentoPropertyType.setProperty("past", true);
		GenericPropertyType loginPropertyType = new GenericPropertyType("login", String.class);
		
		//adicionando property types no tipo de entidade
		tipoPessoa.addPropertyType(nomePropertyType);
		tipoPessoa.addPropertyType(alturaPropertyType);
		tipoPessoa.addPropertyType(cpfPropertyType);
		tipoPessoa.addPropertyType(emailPropertyType);
		tipoPessoa.addPropertyType(profissaoPropertyType);
		tipoPessoa.addPropertyType(nascimentoPropertyType);
		tipoPessoa.addPropertyType(loginPropertyType);
		Map<String,Object> loginMetadados = new HashMap<>();
		loginMetadados.put("min", 7);
		loginMetadados.put("max", 50);
		loginPropertyType.setProperty("size", loginMetadados);
		return tipoPessoa;
	}

}
