package ProjetoCardapio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeContoller {

    @GetMapping("/")
    public String exibirLogin() {
        return "login"; 
    }

    @PostMapping("/login")
    public String processarLogin(
            @RequestParam("matricula") String matricula,
            @RequestParam("senha") String senha,
            @RequestParam("perfil") String perfil,
            Model model) {

        if (senha.equals("123")) {
            
            if (perfil.equals("ALUNO")) {
                return "redirect:/aluno/dashboard";
            } else if (perfil.equals("NUTRICIONISTA")) {
                return "redirect:/nutricionista/dashboard";
            } else if (perfil.equals("COZINHEIRA")) {
                return "redirect:/cozinheira/dashboard";
            }
        }

        model.addAttribute("erro", "Matrícula ou senha inválidos!");
        return "login";
    }

    @GetMapping("/aluno/dashboard")
    public String dashboardAluno() { 
        return "dashboard-aluno"; 
    }

    @GetMapping("/nutricionista/dashboard")
    public String dashboardNutricionista() { 
        return "dashboard-nutricionista"; 
    }

    @GetMapping("/cozinheira/dashboard")
    public String dashboardCozinheira() { 
        return "dashboard-cozinheira"; 
    }
}
