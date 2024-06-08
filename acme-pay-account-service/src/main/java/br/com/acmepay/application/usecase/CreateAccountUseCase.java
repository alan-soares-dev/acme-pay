package br.com.acmepay.application.usecase;

import br.com.acmepay.application.domain.model.AccountDomain;
import br.com.acmepay.application.ports.in.ICreateAccountUseCase;
import br.com.acmepay.application.ports.out.ICreateAccount;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateAccountUseCase implements ICreateAccountUseCase {

    private final ICreateAccount createAccount;

    @Override
    public void execute(AccountDomain domain) {
        domain.create(createAccount);
    }
}
