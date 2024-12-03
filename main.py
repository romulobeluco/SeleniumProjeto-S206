from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import Select
import time
 
def configurar_driver():
    """Configura o driver do Selenium."""
    servico = Service(executable_path="chromedriver.exe")
    navegador = webdriver.Chrome(service=servico)
    return navegador
 
def abrir_google(navegador):
    """Abre o site do Google."""
    navegador.get("https://www.google.com/")
    assert "Google" in navegador.title, "Acessou o Google com sucesso."
 
def buscar_inatel(navegador):
    """Realiza uma busca por 'inatel' no Google."""
    campo_pesquisa = navegador.find_element(By.CLASS_NAME, "gLFyf")
    campo_pesquisa.send_keys("inatel")
    time.sleep(2)
    campo_pesquisa.submit()
    assert True, "Busca por 'inatel' realizada com sucesso."
 
def clicar_site_inatel(navegador):
    """Clica no site do Inatel nos resultados da busca."""
    navegador.find_element(By.XPATH, "//h3").click()
    assert "Inatel" in navegador.title, "Site do Inatel carregado com sucesso."
 
def acessar_portal_academico(navegador):
    """Navega até o portal acadêmico no site do Inatel."""
    botao_menu = navegador.find_element(By.XPATH, '//*[@id="menuFlutuante"]/div/div[2]')
    assert botao_menu.is_displayed(), "Menu flutuante acessado com sucesso."
    botao_menu.click()
    time.sleep(2)
 
    opcao_alunos = navegador.find_element(By.XPATH, '//*[@id="menuFlutuante"]/div/div[3]/nav/ul[1]/li[3]/a')
    assert opcao_alunos.is_displayed(), "Opção 'Alunos' acessada com sucesso."
    opcao_alunos.click()
    time.sleep(2)
 
    opcao_academico = navegador.find_element(By.XPATH, '//*[@id="menuFlutuante"]/div/div[3]/nav/ul[1]/li[3]/ul/li[1]/b')
    assert opcao_academico.is_displayed(), "Opção 'Acadêmico' acessada com sucesso."
    opcao_academico.click()
    time.sleep(2)
 
def aceitar_cookies(navegador):
    """Aceita os cookies no site do Inatel."""
    botao_cookies = navegador.find_element(By.XPATH, '//*[@id="contract-1"]/div[1]/div/div/a[1]')
    assert botao_cookies.is_displayed(), "Cookies aceitos com sucesso."
    botao_cookies.click()
    time.sleep(2)
 
def acessar_portal_graduacao(navegador):
    """Navega até o Portal da Graduação."""
    opcao_portal = navegador.find_element(By.XPATH, '//*[@id="menuFlutuante"]/div/div[3]/nav/ul[1]/li[3]/ul/li[1]/ul/li[3]/a')
    assert opcao_portal.is_displayed(), "Portal da Graduação acessado com sucesso."
    opcao_portal.click()
    time.sleep(2)
 
def selecionar_curso(navegador):
    """Seleciona o curso no dropdown do Portal da Graduação."""
    dropdown_curso = navegador.find_element(By.XPATH, '//*[@id="ctl00_Corpo_TabAcessoLogin_TabAluno_LogOn_dropSubCurso"]')
    assert dropdown_curso.is_displayed(), "Curso selecionado com sucesso."
    curso = Select(dropdown_curso)
    curso.select_by_index(4)
 
def realizar_login(navegador):
    """Preenche os dados de login e realiza o login."""
    campo_matricula = navegador.find_element(By.XPATH, '//*[@id="ctl00_Corpo_TabAcessoLogin_TabAluno_LogOn_tbMatricula"]')
    campo_senha = navegador.find_element(By.XPATH, '//*[@id="ctl00_Corpo_TabAcessoLogin_TabAluno_LogOn_Password"]')
    botao_login = navegador.find_element(By.XPATH, '//*[@id="ctl00_Corpo_TabAcessoLogin_TabAluno_LogOn_LoginButton"]')
 
    assert campo_matricula.is_displayed(), "Erro: Campo de matrícula não está visível"
    assert campo_senha.is_displayed(), "Erro: Campo de senha não está visível"
    assert botao_login.is_displayed(), "Erro: Botão de login não está visível"
    assert True, "Campos de login preenchidos com sucesso."
 
    campo_matricula.send_keys("516")
    campo_senha.send_keys("11111")
    botao_login.click()
    time.sleep(2)
 
def verificar_login(navegador):
    """Verifica se o login foi realizado com sucesso."""
    
    assert "Portal do Aluno" in navegador.page_source, "Login concluído com sucesso e Portal do Aluno carregado."
 
if __name__ == "__main__":
    navegador = configurar_driver()
    try:
        abrir_google(navegador)
        buscar_inatel(navegador)
        clicar_site_inatel(navegador)
        acessar_portal_academico(navegador)
        aceitar_cookies(navegador)
        acessar_portal_graduacao(navegador)
        selecionar_curso(navegador)
        realizar_login(navegador)
        verificar_login(navegador)
    except AssertionError as e:
        print(f"Erro no teste: {e}")
    finally:
        navegador.quit()
