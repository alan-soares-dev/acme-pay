package br.com.acmepay;

import br.com.acmepay.domain.Account;
import br.com.acmepay.domain.Customer;
import br.com.acmepay.exception.BalanceToWithDrawException;
import br.com.acmepay.exception.DocumentInvalidException;
import br.com.acmepay.exception.EmailInvalidException;

import java.math.BigDecimal;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws DocumentInvalidException, EmailInvalidException {
        Customer c1 = new Customer();
        c1.setName("A");
        c1.setId(1L);
        c1.setDocument("123");
        c1.setPhone("66666");
        c1.setEmail("email@email.com");
        c1.createCustomer(c1);

        Customer c2 = new Customer();
        c2.setName("B");
        c2.setId(2L);
        c2.setDocument("543");
        c2.setPhone("77777");
        c2.setEmail("abc@email.com");
        c1.createCustomer(c2);

        Customer c3 = new Customer();
        c3.setName("C");
        c3.setId(3L);
        c3.setDocument("789");
        c3.setPhone("8888888");
        c3.setEmail("abcz@email.com");
        c1.createCustomer(c3);


        c2.setEmail("zzz@email.com");
        c1.update(c2);
        c1.list();


    }
}
