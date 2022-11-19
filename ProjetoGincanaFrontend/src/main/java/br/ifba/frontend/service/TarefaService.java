package br.ifba.frontend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import br.ifba.frontend.model.TarefaModel;
import reactor.core.publisher.Mono;


@Service
public class TarefaService {
	@Autowired
	private WebClient webClient;
	
	public TarefaModel getTarefa(Long id) {
		
		Mono<TarefaModel> tarefaModel = this.webClient
											.method(HttpMethod.GET)
											.uri("tarefa/{id}", id)
											.retrieve()
											.bodyToMono(TarefaModel.class);
		
		TarefaModel tm = tarefaModel.block();
		return tm;
	}
	
	public List<TarefaModel> getTarefas() {
		
		Mono<TarefaModel[]> tarefaModel = this.webClient
											.method(HttpMethod.GET)
											.uri("tarefa/listall")
											.retrieve()
											.bodyToMono(TarefaModel[].class);
		
		List<TarefaModel> list = new ArrayList<TarefaModel>();
		TarefaModel[] tm = tarefaModel.block();
		for (TarefaModel tarefaModel2 : tm) {
			list.add(tarefaModel2);
		}
		
		return list;
	}
	
	public Boolean deleteTarefa(Long id) {
		Mono<Boolean> tarefaDel = this.webClient
											.method(HttpMethod.DELETE)
											.uri("tarefa/{id}", id)
											.retrieve()
											.bodyToMono(Boolean.class);
		
		
		Boolean result = tarefaDel.block();
		return result;
	}
	
	public Boolean insert(TarefaModel tarefaModel) {
		Mono<Boolean> tarefa = this.webClient
									.method(HttpMethod.POST)
									.uri("tarefa/")
									.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
									.body(Mono.just(tarefaModel), TarefaModel.class)
									.retrieve()
									.bodyToMono(Boolean.class);
		Boolean result = tarefa.block();
		return result;
	}
	
	public TarefaModel update(TarefaModel tarefaModel) {
		System.out.println("update: " + tarefaModel);
		Mono<TarefaModel> tarefa = this.webClient
									.method(HttpMethod.PUT)
									.uri("tarefa/{id}", tarefaModel.getId())
									.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
									.body(Mono.just(tarefaModel), TarefaModel.class)
									.retrieve()
									.bodyToMono(TarefaModel.class);
		TarefaModel result = tarefa.block();
		return result;
	}
	
	
	
}
