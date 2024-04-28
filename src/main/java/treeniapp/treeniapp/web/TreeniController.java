package treeniapp.treeniapp.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import treeniapp.treeniapp.model.Treeni;
import treeniapp.treeniapp.model.TreeniRepository;
import treeniapp.treeniapp.model.TreenityyppiRepository;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class TreeniController {

    @Autowired
    private TreeniRepository repository;

    @Autowired
    private TreenityyppiRepository trepository;

    @RequestMapping(value="/login")
    public String login() {
        return "login";
    }
    
    //REST hae kaikki kirjat
    @GetMapping("/treenit")
    public @ResponseBody List<Treeni> getAllTreeniREST() {
        return (List<Treeni>) repository.findAll();
    }
    
    //REST hae kirja ID:n perusteella
    @GetMapping("/treenit/{id}")
    public @ResponseBody Optional<Treeni> getTreeniByIdREST(@PathVariable("id") Long id) {
        return repository.findById(id);
    }
    
    @GetMapping("/treenilista")
    public String listaaTreenit(Model model) {
        model.addAttribute("treenit", repository.findAll());
        return "treenilista";
    }

    @RequestMapping(value = "/lisaatreeni")
    public String lisaaTreeni(Model model) {
        model.addAttribute("treeni", new Treeni());
        model.addAttribute("treenityypit", trepository.findAll());
        return "lisaatreeni";
    }

    @SuppressWarnings("null")
    @PostMapping("/tallennatreeni")
    public String save(Treeni treeni) {
        repository.save(treeni);
        return "redirect:treenilista";
    }

    @SuppressWarnings("null")
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/delete/{id}")
    public String deleteTreeni(@PathVariable("id") Long id, Model model) {
        repository.deleteById(id);
        return "redirect:../treenilista";
    }

    @SuppressWarnings("null")
    @GetMapping("/edit/{id}")
    public String editTreeni(@PathVariable("id") Long id, Model model) {
        model.addAttribute("treeni", repository.findById(id));
        model.addAttribute("treenityypit", trepository.findAll());
        return "edittreeni";
    }

}
