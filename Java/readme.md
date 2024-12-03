# Selenium Test Suite - Automação de Testes Funcionais com Java

Este projeto é uma suíte de testes automatizados utilizando **Java**, **Selenium WebDriver**, e **ExtentReports**. Ele realiza uma série de ações no navegador, como acessar o Google, buscar o site do Inatel, navegar até o portal acadêmico, realizar login e verificar o sucesso do login. 

Além disso, gera relatórios detalhados em HTML para cada execução.

---

## 🛠️ Funcionalidades

1. **Acesso ao Google e validação do título da página.**
2. **Busca pelo termo "inatel" e navegação para o site oficial.**
3. **Acesso ao portal acadêmico no site do Inatel.**
4. **Execução de login no portal acadêmico (etapa fictícia).**
5. **Verificação do sucesso do login.**
6. **Geração de relatórios detalhados em HTML utilizando ExtentReports.**

---

## 🚀 Requisitos

- **Java 8+**
- **Maven** (para gerenciamento de dependências)
- **Google Chrome** (atualizado)
- **ChromeDriver** (compatível com sua versão do Chrome)

---

## 📦 Configuração e Instalação

### 1. Clonar o repositório

```bash
git clone https://github.com/seu-usuario/nome-do-repositorio.git
cd nome-do-repositorio
```

### 2. Configurar dependências com Maven

Certifique-se de que o seguinte trecho está no arquivo `pom.xml` para incluir as dependências necessárias:

```xml
<dependencies>
    <!-- Selenium WebDriver -->
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>4.9.1</version>
    </dependency>

    <!-- WebDriver Manager -->
    <dependency>
        <groupId>io.github.bonigarcia</groupId>
        <artifactId>webdrivermanager</artifactId>
        <version>5.3.3</version>
    </dependency>

    <!-- ExtentReports -->
    <dependency>
        <groupId>com.aventstack</groupId>
        <artifactId>extentreports</artifactId>
        <version>5.0.9</version>
    </dependency>
</dependencies>
```

### 3. Configurar o ChromeDriver

- **Manual**: Faça o download do [ChromeDriver](https://googlechromelabs.github.io/chrome-for-testing/) e adicione o caminho do executável no método `configurarDriver()`:
    ```java
    System.setProperty("webdriver.chrome.driver", "caminho/para/chromedriver.exe");
    ```

- **Automático (WebDriverManager)**: O script já utiliza o **WebDriverManager** para configurar o ChromeDriver automaticamente.

---

## 🖥️ Uso

1. **Execute o projeto**:
    Certifique-se de que você está no diretório do projeto e execute a aplicação pelo seu IDE ou pela linha de comando:
    ```bash
    mvn clean install
    mvn exec:java -Dexec.mainClass="com.meuprojeto.tests.SeleniumTestSuite"
    ```

2. **Relatório de Teste**:
    Após a execução, um arquivo HTML chamado `RelatorioTeste.html` será gerado no diretório raiz do projeto. Abra-o no navegador para visualizar o relatório detalhado.

---

## ⚙️ Estrutura do Código

### Principais Classes e Métodos

#### 1. Configuração do WebDriver
```java
public static WebDriver configurarDriver()
```
Inicializa e configura o WebDriver do Chrome para uso nos testes.

#### 2. Configuração do ExtentReports
```java
private static void configurarRelatorio()
```
Define o formato e os dados do relatório gerado para cada execução.

#### 3. Métodos de Teste
- **`abrirGoogle()`**: Navega até o Google e valida o título da página.
- **`buscarInatel()`**: Realiza a busca pelo termo "inatel" no Google.
- **`clicarNoSiteDoInatel()`**: Acessa o site oficial do Inatel.
- **`navegarParaPortalAcademico()`**: Navega até o portal acadêmico dentro do site.
- **`realizarLogin()`**: Simula o login no portal acadêmico.
- **`verificarLogin()`**: Verifica se o login foi realizado com sucesso.

#### 4. Fluxo Principal
```java
public static void main(String[] args)
```
Executa as funções de teste em sequência e finaliza o WebDriver e o relatório.

---

## 📜 Relatórios de Teste

- **Formato**: Os relatórios são gerados em HTML e incluem detalhes como:
    - Nome do teste.
    - Status (sucesso, falha, erro).
    - Descrições detalhadas das ações realizadas.
    - Informações do sistema (SO, navegador, etc.).
---

## ⚠️ Observações

1. **Seletores de XPath**:
   Certifique-se de que os seletores de XPath utilizados no código correspondam aos elementos atuais do site. Caso o site seja alterado, os seletores precisarão de ajustes.

2. **Política de uso**:
   Utilize esta automação apenas com permissão e para fins educacionais ou de testes. Automação de sites sem consentimento pode violar termos de uso.

3. **Credenciais Fictícias**:
   O login no portal acadêmico é fictício. Substitua as credenciais por variáveis seguras (como variáveis de ambiente) para simular um fluxo real.
