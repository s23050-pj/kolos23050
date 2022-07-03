package pjatk.jaz23050nbp.currency.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pjatk.jaz23050nbp.currency.model.Currency;
import pjatk.jaz23050nbp.currency.service.CurrService;


@RestController
@RequestMapping("/currencychecker")
public class CurrControler {
    private final CurrService currService;

    public CurrControler(CurrService currService) {
        this.currService = currService;
    }

    @ApiOperation(value = "Welcome Page", notes = "just welcome")
    @GetMapping("/")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok(currService.hello());
    }

    @ApiOperation(value = "Return number of avg course from X days")
    @GetMapping("/{avg}/{datefrom}/{dateto}")
    public ResponseEntity<Currency> currencyReturn(
            @ApiParam(value = "Short code of average", example = "4,7176")
            @PathVariable Double avg,
            @ApiParam(value = "Date from which we will check num", example = "2022-06-15")
            @PathVariable String datefrom,
            @ApiParam(value = "Date to which we will check num", example = "2022-06-16")
            @PathVariable String dateto) {
        return ResponseEntity.ok(currService.currencyCheck(avg, datefrom, dateto));
    }
}
