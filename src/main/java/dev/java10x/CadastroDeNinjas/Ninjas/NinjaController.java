package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class NinjaController {

    @GetMapping("/boasvindas")
    public String boasVindas() {
        return "Essa é minha primeira mensagem nessa rota";
    }

    // Adicionar Ninja (CREATE)
    @PostMapping("/criar")
    public String criarNinja() {
        return "Ninja criado";
    }

    // Mostrar Ninja por ID (READ)
    @GetMapping("/todos")
    public String mostrarTodosOsNinjas() {
        return "TodosNinjas";
    }

    // Mostrar todos os ninjas (READ)
    @GetMapping("/todosID")
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
