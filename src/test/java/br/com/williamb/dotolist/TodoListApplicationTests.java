package br.com.williamb.dotolist;

import br.com.williamb.dotolist.dtos.TodoDto;
import br.com.williamb.dotolist.repositories.TodoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TodoListApplicationTests {

	@Autowired
	private WebTestClient webTestClient;

	@Autowired
	private TodoRepository todoRepository;

	@BeforeEach
	void setUp() {
		todoRepository.deleteAll();
	}

	@Test
	void testeCreateTodoSuccess() {
		var todoDto = new TodoDto(null, "todo 1", "description 1", 1);
		webTestClient
				.post()
				.uri("/todos")
				.bodyValue(todoDto)
				.exchange()
				.expectStatus().isOk()
				.expectBody()
				.jsonPath("$.id").isNotEmpty()
				.jsonPath("$.name").isEqualTo(todoDto.name())
				.jsonPath("$.description").isEqualTo(todoDto.description())
				.jsonPath("$.priority").isEqualTo(todoDto.priority());
	}

	@Test
	void testeListTodosInitiallyEmpty() {
		webTestClient
				.get()
				.uri("/todos")
				.exchange()
				.expectStatus().isOk()
				.expectBody()
				.jsonPath("$").isArray()
				.jsonPath("$.length()").isEqualTo(0);
	}

	@Test
	void testeGetAllTodos() {
		webTestClient
				.get()
				.uri("/todos")
				.exchange()
				.expectStatus().isOk()
				.expectBody()
				.jsonPath("$").isArray();
	}

	@Test
	void testeListTodos() {
		webTestClient
				.get()
				.uri("/todos")
				.exchange()
				.expectStatus().isOk()
				.expectBody()
				.jsonPath("$").isArray();
	}


	@Test
	void testeUpdateTodoSuccess() {
		var todoDto = new TodoDto(null, "Estudar", "Estudar para a prova", 1);
		var updatedTodoDto = new TodoDto(null, "Estudar mais", "Estudar mais para a prova", 1);

		// Primeiro, cria um Todo
		var createdTodo = webTestClient
				.post()
				.uri("/todos")
				.bodyValue(todoDto)
				.exchange()
				.expectStatus().isOk()
				.expectBody(TodoDto.class)
				.returnResult()
				.getResponseBody();

		// Depois, atualiza o Todo criado
        assert createdTodo != null;
        webTestClient
				.put()
				.uri("/todos/{id}", createdTodo.id())
				.bodyValue(updatedTodoDto)
				.exchange()
				.expectStatus().isOk()
				.expectBody()
				.jsonPath("$.name").isEqualTo("Estudar mais")
				.jsonPath("$.description").isEqualTo("Estudar mais para a prova");
	}


	@Test
	void testeDeleteTodoSuccess() {
		var todoDto = new TodoDto(null, "Estudar", "Estudar para a prova", 1);

		// Primeiro, cria um Todo
		var createdTodo = webTestClient
				.post()
				.uri("/todos")
				.bodyValue(todoDto)
				.exchange()
				.expectStatus().isOk()
				.expectBody(TodoDto.class)
				.returnResult()
				.getResponseBody();

		// Depois, exclui o Todo criado
        assert createdTodo != null;
        webTestClient
				.delete()
				.uri("/todos/{id}", createdTodo.id())
				.exchange()
				.expectStatus().isOk()
				.expectBody(String.class).isEqualTo("Todo deleted successfully");
	}





}
