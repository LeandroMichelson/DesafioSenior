package senior.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import senior.model.Hospedagem;
import senior.model.Hospede;
import senior.repository.RepHospedagem;
import senior.repository.RepHospede;

@RestController
public class ConHospedagem {

	@Autowired
	RepHospede repHospede;
	@Autowired
	RepHospedagem repHospedagem;

	@RequestMapping(path = "/check-in", method = RequestMethod.POST)
	public Hospedagem checkIn(@RequestBody Hospedagem hospedagem) throws Exception {
		Hospede hospedeBanco = repHospede.findOne(hospedagem.getHospede().getId());

		// Verifica se o hospede é cadastrado
		if (hospedeBanco != null) {
			hospedagem.setHospede(hospedeBanco);
			hospedagem.setCheckOut(false);
			hospedagem.setValor(calcularValorHospedagem(hospedagem.getDataEntrada(), hospedagem.getDataSaida(),
					hospedagem.getAdicionalVeiculo(), hospedagem.getCheckOut()));

			return repHospedagem.save(hospedagem);
		}
		throw new Exception("Hospede ainda não cadastrado");
	}

	@RequestMapping(path = "/check-out", method = RequestMethod.POST)
	public Hospedagem checkOut(@RequestBody Hospedagem hospedagem) throws Exception {
		Hospede hospedeBanco = repHospede.findOne(hospedagem.getHospede().getId());
		hospedagem = repHospedagem.findOne(hospedagem.getId());

		// Verifica se existe a hospegadem e se já não foi feito check-out
		if (hospedagem != null && !hospedagem.getCheckOut()) {
			hospedagem.setHospede(hospedeBanco);
			hospedagem.setCheckOut(true);
			hospedagem.setValor(calcularValorHospedagem(hospedagem.getDataEntrada(), hospedagem.getDataSaida(),
					hospedagem.getAdicionalVeiculo(), hospedagem.getCheckOut()));

			return repHospedagem.save(hospedagem);
		}
		throw new Exception("Hospegadem invalida ou já foi feito o check out.");
	}

	@RequestMapping(path = "/consulta", method = RequestMethod.GET)
	public List<Hospede> consulta(@RequestParam Boolean checkOut) throws Exception {

		return repHospedagem.findByCheckOut(checkOut);
	}

	private Float calcularValorHospedagem(Date dataEntrada, Date dataSaida, Boolean adicionalVeiculo,
			Boolean checkOut) {
		Float total = 0F;
		Calendar entrada = new GregorianCalendar();
		Calendar saida = new GregorianCalendar();

		entrada.setTime(dataEntrada);
		saida.setTime(dataSaida);

		// Verifica se a data atual passou da tada de saida prevista
		if (checkOut) {
			if (saida.compareTo(Calendar.getInstance()) == -1) {
				saida.setTime(new Date());
			}
		}

		// Calcula o valor da hospedagem
		while (saida.compareTo(entrada) >= 0) {
			if (entrada.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY
					|| entrada.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
				total += (adicionalVeiculo) ? 170 : 150;
			} else {
				total += (adicionalVeiculo) ? 135 : 120;
			}
			entrada.add(Calendar.DATE, 1);
		}
		return total;
	}

}
