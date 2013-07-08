package br.com.pa.web.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.pa.web.bean.Usuario;
import br.com.pa.web.contrato.IContrato;
import br.com.pa.web.contrato.UsuarioContrato;

@Controller
public class loginController {
	
	@RequestMapping("/")
	public String form(HttpSession session){
		session.setAttribute("usuarioLogado", null);
		return "redirect:login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(){
		return "login/login";
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public @ResponseBody String efetuarLogin(String login, String password, HttpSession session){
		try{
			String mensagem = "false";
			IContrato<Usuario> contrato = new UsuarioContrato();
			Usuario usuario = new Usuario();
			usuario.setLogin(login);
			usuario.setSenha(password);
			ArrayList<Usuario> usuarios = contrato.obterRegistro(usuario);
			
			if(!usuarios.isEmpty()){
				session.setAttribute("usuarioLogado", usuario);
				mensagem = "true";
			}
			
			return mensagem;
		}
		catch(Exception ex){
			return ex.getMessage();
		}
	}
}
