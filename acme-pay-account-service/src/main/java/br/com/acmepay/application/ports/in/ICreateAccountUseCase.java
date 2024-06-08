package br.com.acmepay.application.ports.in;

import br.com.acmepay.application.domain.model.AccountDomain;

public interface ICreateAccountUseCase {
    void execute(AccountDomain domain);
}
