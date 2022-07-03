package pjatk.jaz23050nbp.currency.service;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pjatk.jaz23050nbp.currency.model.Currency;
import pjatk.jaz23050nbp.currency.repository.CurrRepository;

import java.util.Date;

@Service
public class CurrService {

    private final CurrRepository currRepository;

    public CurrService(CurrRepository currRepository) {
        this.currRepository = currRepository;
    }

    public String hello() {
        return "Hello in Currency Checker";
    }


    public Currency currencyCheck(Double avg, String datefrom, String dateto) {

        String uri = "http://api.nbp.pl/api/exchangerates/tables/a/" + avg + "/" + datefrom + "/" + dateto + "/?format=json";
        RestTemplate restTemplate = new RestTemplate();

        String result = restTemplate.getForObject(uri, String.class);
        DocumentContext context = JsonPath.parse(result);
        avg = context.read("$.code");
        Double num = 0.00;
        JSONArray jsonArray = JsonPath.read(result, "$.tables[*]");
        for (int i = 0; i < jsonArray.size(); i++) {
            num += context.read("$.tables[" + i + "]['mid']", Double.class);
        }
        num = num / jsonArray.size();
        Currency currency = new Currency(avg, datefrom, dateto, num, new Date());
        currRepository.save(currency);

        return currency;
    }

}

