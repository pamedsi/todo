# To do List API
Uma API Rest para o gerenciamento de tarefas.<br>
Ações possíveis:<br>
- Criar tarefa
- Listar tarefas
- Concluir tarefa
- Excluir tarefa

# Pré-requisitos
Docker e Docker Compose instalados na máquina local.<br>
<span style="color:green">Recomendado:</span> instalar as versões mais recentes.

# Instalação
Clonando o Repositório:<br>
Primeiro, clone o repositório para o seu ambiente local com o comando:

$```git clone https://github.com/pamedsi/todo.git```<br>
$```cd todo```

Executando com Docker Compose:<br>
Após clonar o repositório, execute o seguinte comando para iniciar o projeto:

$```docker-compose up -d```

Este comando iniciará todas as imagens necessárias definidas no arquivo docker-compose.yml e colocará o projeto em execução no modo detached (-d).
Deixando seu terminal livre para ser utilizado.

Para parar o serviço, você pode usar o comando:

$```docker-compose down```

# Documentação:
Para acessar a documentação da sua API através do Swagger UI no localhost, você deve seguir estes passos:

Após iniciar o projeto com o docker compose, abra seu navegador de preferência acessando a URL:
http://localhost:8080/swagger-ui.html <br>
Ao acessar essa URL, você será redirecionado para a interface do Swagger UI, que exibirá a documentação da API.<br>

Esta interface permite que você visualize, teste e explore a API diretamente no navegador, facilitando o desenvolvimento e a compreensão da API.

# Tecnologias Utilizadas
Linguagens e Frameworks:<br>
- Spring Boot
- Java

ORM e Persistência: <br>
- JPA (Java Persistence API)
- Hibernate

Contêinerização e Orquestração:

- Docker
- Docker Compose

Banco de Dados:

- PostgreSQL