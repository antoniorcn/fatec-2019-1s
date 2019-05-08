package edu.curso;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class HelloWorldController {
	@RequestMapping("/welcome")
	public String bemVindo() {
		System.out.println("Função Bemvindo executada");
		return "bemvindo";
	}
}
