package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {
    // Adicionar Ninja (CREATE)
    @PostMapping("/criar")
    public String criarNinja() {
        return "Ninja criado";
    }

    // Mostrar Ninja por ID (READ)
    @GetMapping("/listar")
    public String mostrarTodosOsNinjas() {
        return "TodosNinjas";
    }

    // Mostrar todos os ninjas (READ)
    @GetMapping("/listarID")
    public String mostrarNinjasPorIDd() {
        return "Mostrar Ninja por ID";
    }

    // Alterar dados dos ninjas (UPTADE)
    @PutMapping("/alterarID")
    public String alterarNinjaPorId() {
        return "Alterar ninja por id";
    }

    // Deletar Ninja (DELETE)
    @DeleteMapping("/deletarID")
    public String deletarNinjaPorId() {
        return "Ninja deletado por id";
    }

}
