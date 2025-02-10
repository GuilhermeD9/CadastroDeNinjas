package dev.java10x.CadastroDeNinjas.Missoes;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissoesController {
    private final MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    // POST -- Mandar uma requisição para criar as missoes
    @PostMapping("/criar")
    @Operation(summary = "Cria uma nova missão", description = "Rota cria uma nova missão e insere no banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Missão criada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro na criação da missão")
    })
    public ResponseEntity<String> criarMissao(@PathVariable MissoesDTO missao) {
        MissoesDTO novaMissao = missoesService.criarMissao(missao);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Missão criada com sucesso: " + novaMissao.getNome() + " (ID): " + novaMissao.getId());
    }

    // GET -- Mandar uma requisição para mostrar as missoes
    @GetMapping("/listar")
    @Operation(summary = "Lista todas as missões", description = "Rota lista todas as missões da aplicação")
    public ResponseEntity<List<MissoesDTO>> listarMissao() {
        List<MissoesDTO> missoes = missoesService.listarMissoes();
        return ResponseEntity.ok(missoes);
    }

    @GetMapping("/listar/{id}")
    @Operation(summary = "Lista a missão por ID", description = "Rota lista uma missão pelo seu ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Missão encontrada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Missão não encontrada")
    })
    public ResponseEntity<?> listarMissaoPorId(@PathVariable Long id) {
        MissoesDTO missao = missoesService.listarMissaoPorId(id);
        if (missao != null) {
            return ResponseEntity.ok(missao);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missão com o id: " + id + " não existe nos nossos registros!");
        }
    }

    // PUT -- Mandar uma requisição para alterar as missoes
    @PutMapping("/alterar/{id}")
    @Operation(summary = "Altera a missão por ID", description = "Rota altera uma missão pelo seu ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Missão alterada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Missão não encontrada, não foi possível alterar")
    })
    public ResponseEntity<?> alterarMissaoPorId(@PathVariable Long id, @RequestBody MissoesDTO missaoAtualizada) {
        MissoesDTO novaMissao = missoesService.alterarMissao(id, missaoAtualizada);
        if (novaMissao != null) {
            return ResponseEntity.ok(novaMissao);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("A missão com o id: " + id + " não foi encontrada!");
        }
    }
    // DELETE -- Mandar uma requisição para deletar as missoes
    @DeleteMapping("/deletar")
    @Operation(summary = "Deleta a missão por ID", description = "Rota deleta uma missão pelo seu ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Missão deletada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Missão não encontrada, não foi possível deletar")
    })
    public ResponseEntity<String> deletarMissaoPorId(@PathVariable Long id) {
        if (missoesService.listarMissaoPorId(id) != null) {
            missoesService.deletarMissaoPorId(id);
            return ResponseEntity.ok("Missão com o ID: " + id + " deletada com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("A missão com o id: " + id + " não foi encontrada!");
        }
    }
}
