package aula;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Login")
public class Login extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			PrintWriter writer = response.getWriter();
		HttpSession sessao = request.getSession(true);
		Date dt_primeiro_acesso = new Date(sessao.getCreationTime());
		Date dt_ultimo_acesso = new Date(sessao.getLastAccessedTime());
		Integer acessos = (Integer) sessao.getAttribute("Numeros Acessos");
		writer.append("<HTML><body><h2>Informações da Sessão</h2>");
		writer.append("<HTML><body><h2> ID: "+sessao.getId());
		writer.append("<HTML><body><h2> Hora de criação: </h2>"+dt_primeiro_acesso);
		writer.append("<HTML><body><h2> Hora da ultima sessão: </h2>"+dt_ultimo_acesso);
		
		if(acessos == null) {
			acessos = 1;
		}else if(acessos == 5){
			writer.append("<HTML><body>Quinta sessão!");
		}else{
			acessos = acessos + 1;
			sessao.setAttribute("Numeros_acessos",acessos);
			
		}
				writer.append("<h1>Exemplo de sessão</h1>");
				writer.append("O documento foi acessado"+acessos+"vezes.");
			}catch (IOException e) {
				e.printStackTrace();
				
			}	
		}
	}

