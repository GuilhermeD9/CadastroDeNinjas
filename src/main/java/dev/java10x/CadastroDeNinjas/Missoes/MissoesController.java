package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissoesController {
    private MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    // GET -- Mandar uma requisição para mostrar as missoes
    @GetMapping("/listar")
    public List<MissoesModel> listarMissao() {
        return missoesService.listarMissoes();
    }

    @GetMapping("/listar/{id}")
    public MissoesModel listarMissaoPorId(@PathVariable Long id) {
        return missoesService.listarMissaoPorId(id);
    }

    // POST -- Mandar uma requisição para criar as missoes
    @PostMapping("/criar")
    public MissoesModel criarMissao(@PathVariable MissoesModel missao) {
        return missoesService.criarMissao(missao);
    }
    // PUT -- Mandar uma requisição para alterar as missoes
    @PutMapping("/alterar")
    public String alterarMissao() {
        return "Missao alterada com sucesso";
    }
    // DELETE -- Mandar uma requisição para deletar as missoes
    @DeleteMapping("/deletar")
    public void deletarMissao(@PathVariable Long id) {
       missoesService.deletarMissaoPorId(id);
    }
}
