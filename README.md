# Sistema de Eleição 🗳️

Um sistema de votação simples em Java que simula uma eleição com estatísticas e gerenciamento de eleitores.

## 📌 Visão Geral

Este projeto é um sistema de eleição que permite:
- Cadastrar eleitores
- Realizar votação secreta
- Gerar estatísticas da eleição
- Visualizar resultados

## 🛠️ Tecnologias Utilizadas
- **Linguagem**: Java
- **Ferramenta de Build**: Apache Ant (via NetBeans)
- **Formato de Saída**: JAR executável

## 📦 Estrutura do Projeto

```
├── build/ # Arquivos compilados
├── dist/ # Distribuição (JAR)
├── nbproject/ # Configurações do NetBeans
├── src/ # Código-fonte
│ └── eleicao/ # Pacote principal
│ ├── Eleitor.java # Classe de eleitor
│ ├── Estatisticas.java # Classe de estatísticas
│ ├── Metodos.java # Métodos auxiliares
│ ├── Principal.java # Classe principal
│ └── Votacao1e2.java # Lógica de votação
├── build.xml # Script de build
├── LICENSE # Licença do projeto
└── manifest.mf # Manifesto para o JAR
```
text

## ▶️ Como Executar

### Pré-requisitos
- Java JDK 8 ou superior

### Opção 1: Usando o JAR pré-compilado
1. Baixe o arquivo `Sistema_de_Eleicao.jar` da pasta `dist/`
2. Execute com:
```bash
   java -jar Sistema_de_Eleicao.jar
```

Opção 2: Compilando do código-fonte
Clone o repositório:
```bash
   git clone https://github.com/GabrielGit10110/Sistema-de-Eleicao.git
``` 
Navegue até a pasta do projeto

Compile e execute com:

```bash
   ant compile
   ant jar
   ant run
```

📊 **Funcionalidades**

- Cadastro de eleitores

- Sistema de votação secreta

- Cálculo de estatísticas

- Visualização de resultados

- Persistência em memória

---
📄 **Licença**

Este projeto está licenciado sob a MIT License - veja o arquivo LICENSE para detalhes.
<br><br>
👥 **Contribuição** <br><br>
Contribuições são bem-vindas! Siga estes passos:

1. Faça um fork do projeto

2. Crie uma branch para sua feature (git checkout -b feature/awesome-feature)

3. Commit suas mudanças (git commit -m 'Add some awesome feature')

4. Push para a branch (git push origin feature/awesome-feature)

5. Abra um Pull Request

## Desenvolvido por Gabriel - 2023
