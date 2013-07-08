package br.com.pa.web.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;


import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import br.com.pa.web.bean.Editora;
import br.com.pa.web.bean.Mensagem;
import br.com.pa.web.bean.Obra;
import br.com.pa.web.bean.PadraoMensagem;
import br.com.pa.web.bean.Pais;
import br.com.pa.web.bean.TipoMensagem;
import br.com.pa.web.contrato.EditoraContrato;
import br.com.pa.web.contrato.IContrato;
import br.com.pa.web.contrato.ObraContrato;
import br.com.pa.web.contrato.PaisContrato;


@Controller
public class PrincipalController {
	
	@RequestMapping(value="principal", method=RequestMethod.GET)
	public String principal(Model model){
		return "principal";
	}
	
	@RequestMapping(value = "buscarobras", method = RequestMethod.GET)
	public String form(){
		return "formulario";
	}
	
	@RequestMapping("/teste")
	public @ResponseBody String teste(Pais pais){
		return pais.getNome();
	}
	
	@RequestMapping(value = "buscarobras", method = RequestMethod.POST)
	public String listaObras(Obra obra, Model model){
		Mensagem mensagem;
		try{
		IContrato<Obra> contrato = new ObraContrato();
		List<Obra> obras = contrato.obterRegistro(obra);
		model.addAttribute("obras", obras);
		
		return "listaObra";
		}
		catch(Exception ex){
			mensagem = new Mensagem(TipoMensagem.ERRO); 
			mensagem.setCorpo(ex.getMessage());
			
			model.addAttribute("mensagem", mensagem);
			return "user-controls/alerta";
		}
	}
	
	@RequestMapping(value = "cadastrarobra", method = RequestMethod.GET)
	public String formCadastroObra(Model model){
		Mensagem mensagem;
		try{
			IContrato<Pais> contratoPais = new PaisContrato();
			IContrato<Editora> contratoEditora = new EditoraContrato();
			ArrayList<Pais> paises = contratoPais.obterRegistro(new Pais());
			ArrayList<Editora> editoras = contratoEditora.obterRegistro(new Editora());
			model.addAttribute("paises", paises);
			model.addAttribute("editoras", editoras);
			
			return "user-controls/form-obra";
		}
		catch(Exception ex){
			mensagem = new Mensagem(TipoMensagem.ERRO); 
			mensagem.setCorpo(ex.getMessage());
			
			model.addAttribute("mensagem", mensagem);
			return "user-controls/alerta";
		}
	}
	
	@RequestMapping(value = "cadastrarobra", method = RequestMethod.POST)
	public String cadastrarObra(Obra obra, Model model){
		Mensagem mensagem;
		try{
			IContrato<Obra> contrato = new ObraContrato();
			obra = contrato.criarRegistro(obra);
			mensagem = new Mensagem(TipoMensagem.SUCESSO, PadraoMensagem.CRIAR);
			
			model.addAttribute("mensagem", mensagem);
			return "user-controls/alerta";
		}
		catch(Exception ex){
			mensagem = new Mensagem(TipoMensagem.ERRO); 
			mensagem.setCorpo(ex.getMessage());
			
			model.addAttribute("mensagem", mensagem);
			return "user-controls/alerta";
		}
	}
	
	@RequestMapping(value = "adicionarpais", method = RequestMethod.POST)
	public @ResponseBody String adicionarPais(Pais pais){
		try {
			IContrato<Pais> contrato = new PaisContrato();
			pais = contrato.criarRegistro(pais);
			
			return String.valueOf(pais.getId());
		}
		catch(Exception ex) {
			return ex.getMessage();
		}
	}
	
	@RequestMapping(value = "adicionareditora", method = RequestMethod.POST)
	public @ResponseBody String adicionarPais(Editora editora){
		try {
			IContrato<Editora> contrato = new EditoraContrato();
			editora = contrato.criarRegistro(editora);
			
			return String.valueOf(editora.getId());
		}
		catch(Exception ex) {
			return ex.getMessage();
		}
	}
	
	@RequestMapping(value = "/ok", method = RequestMethod.GET)
	public String ok(Model model){
		ArrayList<Editora> editoras = new ArrayList<Editora>();
		Editora editora = new Editora();
		
		editora.setId(1);
		editora.setNome("teste");
		editoras.add(editora);
		
		model.addAttribute("editoras", editoras);
		return "ok";
	}

	@RequestMapping(value = "/ok", method = RequestMethod.POST)
	public @ResponseBody String ok(@RequestParam MultipartFile file) 
			throws Exception{
		String name = file.getOriginalFilename();
		File f = new File("C:\\Image\\" + name);
		FileOutputStream fs = new FileOutputStream(f);
		
		IOUtils.write(file.getBytes(), fs);
		fs.close();
		
		return name;
	}
}
