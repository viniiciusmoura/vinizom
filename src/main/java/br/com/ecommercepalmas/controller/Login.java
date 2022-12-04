package br.com.ecommercepalmas.controller;


import br.com.ecommercepalmas.model.entity.Usuario;
import br.com.ecommercepalmas.model.repository.RoleRepository;
import br.com.ecommercepalmas.model.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;


@Controller
public class Login {

    @Autowired
    UsuarioRepository user;

    @Autowired
    RoleRepository role;

    @GetMapping("/login")
    public String login(Usuario usuario){
        return "/clientes/login";
    }

    @PostMapping("/create")
    public ModelAndView create(@Valid Usuario usuario, BindingResult result,RedirectAttributes attributes,HttpServletRequest request) throws Exception {
        if(result.hasErrors()||(user.findByEmail(usuario.getEmail())!=null)) {
            attributes.addFlashAttribute("erroemail","O Email fornecido possuí cadastro!");
            return new ModelAndView("redirect:/login");
        }else{
            String senha = usuario.getPassword();
            usuario.setPassword(new BCryptPasswordEncoder().encode(usuario.getPassword()));
            usuario.getRoles().add(role.findByNome("ROLE_USER"));
            user.save(usuario);
            request.login(usuario.getUsername(),senha);
        }


        return new ModelAndView("/produtos/list");
    }

}

//$2a$10$bjybOX8lTdbRUQKL/7e58uOtkqzcbcYIiKj03sHKH6hqJ93Khxiq6
//Usuário/Senha inválidos
