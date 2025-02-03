package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissoesService {
    private MissoesRepository missoesRepository;

    public MissoesService(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }

    public List<MissoesModel> listarMissoes() {
        return missoesRepository.findAll();
    }

    public MissoesModel listarMissaoPorId(Long id) {
        Optional<MissoesModel> missao = missoesRepository.findById(id);
        return missao.orElse(null);
    }

    public MissoesModel criarMissao(MissoesModel missao) {
        return missoesRepository.save(missao);
    }

    public void deletarMissaoPorId(Long id) {
        missoesRepository.deleteById(id);
    }
}
