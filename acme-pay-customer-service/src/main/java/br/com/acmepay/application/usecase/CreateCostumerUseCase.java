package br.com.acmepay.application.usecase;

import br.com.acmepay.application.domain.model.CustomerDomain;
import br.com.acmepay.application.ports.in.ICreateCostumerUseCase;
import br.com.acmepay.application.ports.out.ICreateCostumer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
public class CreateCostumerUseCase implements ICreateCostumerUseCase {

    private final ICreateCostumer createCostumer;

    @Override
    public void execute(CustomerDomain domain) {
        domain.create(createCostumer);
    }
}
