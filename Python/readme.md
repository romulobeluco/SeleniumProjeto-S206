# Automação Selenium: Acesso ao Portal Acadêmico do Inatel

Este projeto é uma automação criada com Python e Selenium para acessar o site do Inatel, navegar até o portal acadêmico e realizar login. É ideal para demonstração de automações simples com o Selenium WebDriver.

---

## 🛠️ Funcionalidades

1. **Abrir o site do Google e realizar uma busca por "Inatel".**
2. **Clicar no link do site oficial do Inatel nos resultados da busca.**
3. **Navegar até o portal acadêmico através do menu do site.**
4. **Aceitar cookies.**
5. **Selecionar um curso específico no portal.**
6. **Realizar login com credenciais simuladas.**
7. **Verificar o sucesso do login.**

---

## 🚀 Requisitos

- **Python 3.7+**
- **Google Chrome** (atualizado)
- **ChromeDriver** (compatível com sua versão do Chrome)
- **Bibliotecas Python**:
  - `selenium`

---

## 📦 Instalação

1. **Clone o repositório**:
    ```bash
    git clone https://github.com/seu-usuario/nome-do-repositorio.git
    cd nome-do-repositorio
    ```

2. **Crie um ambiente virtual e ative-o**:
    ```bash
    python -m venv venv
    source venv/bin/activate # Linux/Mac
    venv\Scripts\activate # Windows
    ```

3. **Instale as dependências**:
    ```bash
    pip install selenium
    ```

4. **Baixe o ChromeDriver**:
   - Faça o download do [ChromeDriver](https://googlechromelabs.github.io/chrome-for-testing/) compatível com a versão do seu Google Chrome.
   - Coloque o executável do `chromedriver` na mesma pasta do projeto ou adicione-o ao PATH do sistema.

---

## 🖥️ Uso

1. **Configure o `chromedriver.exe` no script.**
   Certifique-se de que o caminho para o ChromeDriver esteja correto na função `configurar_driver()`:
   ```python
   servico = Service(executable_path="chromedriver.exe")
   ```

2. **Execute o script**:
    ```bash
    python script.py
    ```

3. O script realizará automaticamente todas as etapas de navegação e login.

---

## ⚙️ Estrutura do Código

### Principais funções

- **`configurar_driver()`**: Configura o driver do Selenium.
- **`abrir_google()`**: Acessa o Google e valida o carregamento da página.
- **`buscar_inatel()`**: Pesquisa "inatel" no Google.
- **`clicar_site_inatel()`**: Clica no link do site oficial do Inatel nos resultados.
- **`acessar_portal_academico()`**: Navega pelo menu do site até o portal acadêmico.
- **`aceitar_cookies()`**: Aceita os cookies no site.
- **`acessar_portal_graduacao()`**: Navega até o Portal da Graduação.
- **`selecionar_curso()`**: Seleciona um curso em um menu suspenso.
- **`realizar_login()`**: Preenche as credenciais e realiza o login.
- **`verificar_login()`**: Verifica se o login foi concluído com sucesso.

---

## ⚠️ Observações

1. **Credenciais fictícias**:
   As credenciais usadas no script são fictícias:
   ```python
   campo_matricula.send_keys("516")
   campo_senha.send_keys("11111")
   ```
   Substitua pelas suas credenciais reais (ou use variáveis de ambiente para maior segurança).

2. **Manutenção do XPath**:
   Certifique-se de que os seletores de XPath no script correspondam aos elementos atuais do site. Caso o site seja atualizado, os caminhos podem precisar de ajustes.

3. **Política de uso**:
   Use esta automação apenas para fins educacionais e com permissão. Automação de sites sem consentimento pode violar termos de uso.


## 🤝 Contribuição

Contribuições são bem-vindas! Abra uma _issue_ ou envie um _pull request_ com melhorias, correções ou novas funcionalidades.
```

Depois de copiar e colar no arquivo `README.md` no seu repositório, substitua `"https://github.com/seu-usuario/nome-do-repositorio.git"` pelo link correto do seu repositório.
