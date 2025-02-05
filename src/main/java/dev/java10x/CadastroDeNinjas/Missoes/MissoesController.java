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
    public List<MissoesDTO> listarMissao() {
        return missoesService.listarMissoes();
    }

    @GetMapping("/listar/{id}")
    public MissoesDTO listarMissaoPorId(@PathVariable Long id) {
        return missoesService.listarMissaoPorId(id);
    }

    // POST -- Mandar uma requisição para criar as missoes
    @PostMapping("/criar")
    public MissoesDTO criarMissao(@PathVariable MissoesDTO missao) {
        return missoesService.criarMissao(missao);
    }
    // PUT -- Mandar uma requisição para alterar as missoes
    @PutMapping("/alterar/{id}")
    public MissoesDTO alterarMissao(@PathVariable Long id, @RequestBody MissoesDTO missaoAtualizada) {
        return missoesService.alterarMissao(id, missaoAtualizada);
    }
    // DELETE -- Mandar uma requisição para deletar as missoes
    @DeleteMapping("/deletar")
    public void deletarMissao(@PathVariable Long id) {
       missoesService.deletarMissaoPorId(id);
    }
}
