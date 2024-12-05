package net.weg.gestao_operadora.controller.dto;

import lombok.Data;
import net.weg.gestao_operadora.model.Plano;
import net.weg.gestao_operadora.model.PlanoServico;
import net.weg.gestao_operadora.model.ServicoAdicional;

@Data
public class PlanoServicoRequestDTO {
    private Plano plano;
    private ServicoAdicional servicoAdicional;

    public PlanoServico conversao() {
        PlanoServico planoServico = new PlanoServico();
        planoServico.setPlano(this.getPlano());
        planoServico.setServico(this.getServicoAdicional());
        return planoServico;
    }

    public PlanoServicoRequestDTO(Plano plano, ServicoAdicional servicoAdicional) {
        this.plano = plano;
        this.servicoAdicional = servicoAdicional;
    }
}
