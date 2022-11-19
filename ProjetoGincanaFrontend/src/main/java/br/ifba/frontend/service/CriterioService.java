package br.ifba.frontend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import org.springframework.web.reactive.function.client.WebClient;

import br.ifba.frontend.model.CriterioModel;

@Service
public class CriterioService {
	@Autowired
	private WebClient webClient;
	
	public CriterioModel getCriterio(Integer id) {
		
		Mono<CriterioModel> criterioModel = this.webClient
											.method(HttpMethod.GET)
											.uri("criterio/{id}", id)
											.retrieve()
											.bodyToMono(CriterioModel.class);
		
		CriterioModel tm = criterioModel.block();
		return tm;
	}
	
	public List<CriterioModel> getCriterios() {
		
		Mono<CriterioModel[]> criterioModel = this.webClient
											.method(HttpMethod.GET)
											.uri("criterio/listall")
											.retrieve()
											.bodyToMono(CriterioModel[].class);
		
		List<CriterioModel> list = new ArrayList<CriterioModel>();
		CriterioModel[] tm = criterioModel.block();
		for (CriterioModel criterioModel2 : tm) {
			list.add(criterioModel2);
		}
		
		return list;
	}
	
	public Boolean deleteCriterio(Integer id) {
		Mono<Boolean> criterioDel = this.webClient
											.method(HttpMethod.DELETE)
											.uri("criterio/{id}", id)
											.retrieve()
											.bodyToMono(Boolean.class);
		
		
		Boolean result = criterioDel.block();
		return result;
	}
	
	public Boolean insert(CriterioModel criterioModel) {
		Mono<Boolean> criterio = this.webClient
									.method(HttpMethod.POST)
									.uri("criterio/")
									.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
									.body(Mono.just(criterioModel), CriterioModel.class)
									.retrieve()
									.bodyToMono(Boolean.class);
		Boolean result = criterio.block();
		return result;
	}
	
	public CriterioModel update(CriterioModel criterioModel) {
		System.out.println("update: " + criterioModel);
		Mono<CriterioModel> criterio = this.webClient
									.method(HttpMethod.PUT)
									.uri("criterio/{id}", criterioModel.getId())
									.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
									.body(Mono.just(criterioModel), CriterioModel.class)
									.retrieve()
									.bodyToMono(CriterioModel.class);
		CriterioModel result = criterio.block();
		return result;
	}
	
	
	
}