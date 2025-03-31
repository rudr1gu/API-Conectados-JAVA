Diagrama Entidade Relacionamento 

```mermaid
erDiagram
    Usuarios {
        int id PK
        string nome
        string email
        string senha
        string tipo
        string foto
        int curso_id FK
    }

    Cursos {
        int id PK
        string periodo
        string nome
        string modulo
    }

    Postagens {
        int id PK
        string titulo
        string conteudo
        int usuario_id FK
        date data_criacao
        date data_atualizacao
        int curso_id FK
        int materia_id FK
    }

    Respostas {
        int id PK
        string conteudo
        date data_criacao
        date data_atualizacao
        int usuario_id FK
        int postagem_id FK
    }

    Estrelas {
        int id PK
        int quantidade
        int usuarios_id FK
        int resposta_id FK
    }

    Materias {
        int id PK
        string nome
    }

    Tags {
        int id PK
        string nome
    }

    cursos_materias {
        int id PK
        int curso_id FK
        int materia_id FK
    }

    materias_tags {
        int id PK
        int tags_id FK
        int materias_id FK
    }

    Usuarios ||--o{ Postagens : "1, n" "cria"
    Usuarios ||--o{ Respostas : "1, n" "responde"
    Usuarios ||--o{ Estrelas : "1, n" "avalia"
    Cursos ||--o{ Usuarios : "1, n" "possui"
    Cursos ||--o{ Postagens : "1, n" "relacionado"
    Cursos ||--o{ cursos_materias : "1, n" "relaciona"
    Postagens ||--o{ Respostas : "1, n" "possui"
    Respostas ||--|| Postagens : "1, 1" "recebe"
    Postagens ||--o{ Materias : "1, 1" "relacionada"
    Respostas ||--o{ Estrelas : "0, n" "recebe"
    Materias ||--o{ materias_tags : "1, n" "associadas"
    Tags ||--o{ materias_tags : "1, n" "tem"
    Materias ||--o{ cursos_materias : "1, n" "relaciona"
```