package pjatk.jaz23050nbp.currency.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pjatk.jaz23050nbp.currency.model.Currency;

public interface CurrRepository extends JpaRepository<Currency, Integer> {
}
