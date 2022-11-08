package mx.com.gm.web;
//He movido esta clase al paquete web, en lugar de tenerlo en HelloSpringData
//Esta es la capa presentación, con thymeleaf y modelo MVC
//Aquí es donde meto las rutas, en el Controlador
import lombok.extern.slf4j.Slf4j;
import mx.com.gm.domain.Person;
import mx.com.gm.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j

public class InitController {

    //Para inyectar aquí la interface cuando no tengo capa de servicio:
    //@Autowired //para poder inyectar la interface y asi ya tengo todos los métodos del crud para el objeto tipo Person
    //private PersonDAO personDAO;

    //Para inyectar la capa de servicio cuando la tengo:
    @Autowired
    private PersonService personService;

    @GetMapping("/")

    public String  init(Model model){

        //Para recuperar lo objetos de tipo Person:
        var persons = personService.readPersons();//justo aquí es cuando se hace la implementación de mi clase PersonDAO

        log.info("ejecutando el controlador Spring MVC");
        model.addAttribute("persons", persons);//NO ES EL MISMO MODEL EN EL VIDEO QUE AQUÍ
        //comparto la variable persons (listado de persons)
        return "index";
    }

    @GetMapping("/add")
    public String  add(Person person){
        return "update";
    }

    @PostMapping("/save")
    public String  save(Person person){
        personService.save(person);
        return "redirect:/"; //así lo redirecciono a la página de inicio
    }

    @GetMapping("/edit/{idPerson}")
    public String update(Person person, Model model){
        person = personService.findPerson(person);
        model.addAttribute("person", person);
        return "update";
    }

    @GetMapping("/delete")
    public String eliminar(Person person){
        personService.delete(person);
        return "redirect:/";
    }
}

