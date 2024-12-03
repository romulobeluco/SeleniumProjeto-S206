package com.meuprojeto.tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
public class SeleniumTestSuite {

    private static ExtentReports relatorio;
    private static ExtentTest teste;

    private static void configurarRelatorio() {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("RelatorioTeste.html");
        htmlReporter.config().setDocumentTitle("Relatório de Testes Selenium");
        htmlReporter.config().setReportName("Suíte de Testes Funcionais");
        htmlReporter.config().setTheme(Theme.STANDARD);
        relatorio = new ExtentReports();
        relatorio.attachReporter(htmlReporter);
        relatorio.setSystemInfo("Sistema Operacional", System.getProperty("os.name"));
        relatorio.setSystemInfo("Navegador", "Chrome");
        relatorio.setSystemInfo("Testador", "Seu Nome");
    }

    private static void finalizarRelatorio() {
        relatorio.flush();
    }

    // Configura o WebDriver
    public static WebDriver configurarDriver() {
        // Configura o caminho do ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Alvaro\\Desktop\\P6\\S206\\Trabalho\\Teste\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        ChromeOptions opcoes = new ChromeOptions();
        opcoes.addArguments("--remote-allow-origins=*");
        return new ChromeDriver(opcoes);
    }

    // Função para abrir o Google
    public static void abrirGoogle(WebDriver driver) throws Exception {
        teste = relatorio.createTest("Abrir Google", "Navega até o Google e verifica o título da página.");
        try {
            driver.get("https://www.google.com/");
            String titulo = driver.getTitle();
            assert titulo.contains("Google") : "Google não foi carregado corretamente";
            teste.pass("Google foi carregado corretamente. Título: " + titulo);
        } catch (AssertionError e) {
            teste.fail("Falha ao abrir o Google: " + e.getMessage());
            throw e;
        }
    }

    // Função para buscar 'inatel'
    public static void buscarInatel(WebDriver driver) throws Exception {
        teste = relatorio.createTest("Buscar Inatel", "Realiza uma busca por 'inatel' no Google.");
        try {
            WebElement elementoEntrada = driver.findElement(By.className("gLFyf"));
            elementoEntrada.sendKeys("inatel");
            elementoEntrada.submit();
            teste.pass("Busca por 'inatel' realizada com sucesso.");
        } catch (NoSuchElementException e) {
            teste.fail("Falha ao buscar 'inatel': " + e.getMessage());
            throw e;
        }
    }

    // Função para clicar no site do Inatel
    public static void clicarNoSiteDoInatel(WebDriver driver) throws Exception {
        teste = relatorio.createTest("Clicar no site do Inatel", "Clica no site do Inatel nos resultados da busca.");
        try {
            WebElement elementoLink = driver.findElement(By.xpath("//h3"));
            elementoLink.click();
            String titulo = driver.getTitle();
            assert titulo.contains("Inatel") : "Site do Inatel não foi carregado corretamente";
            teste.pass("Site do Inatel carregado com sucesso. Título: " + titulo);
        } catch (NoSuchElementException e) {
            teste.fail("Falha ao clicar no site do Inatel: " + e.getMessage());
            throw e;
        }
    }

    // Função para navegar até o portal acadêmico
    public static void navegarParaPortalAcademico(WebDriver driver) throws Exception {
        teste = relatorio.createTest("Navegar para Portal Acadêmico", "Navega até o portal acadêmico no site do Inatel.");
        try {
            WebElement botaoMenu = driver.findElement(By.xpath("//*[@id='menuFlutuante']/div/div[2]"));
            botaoMenu.click();

            WebElement opcaoAlunos = driver.findElement(By.xpath("//*[@id='menuFlutuante']/div/div[3]/nav/ul[1]/li[3]/a"));
            opcaoAlunos.click();

            WebElement opcaoAcademico = driver.findElement(By.xpath("//*[@id='menuFlutuante']/div/div[3]/nav/ul[1]/li[3]/ul/li[1]/b"));
            opcaoAcademico.click();

            teste.pass("Navegação para o portal acadêmico realizada com sucesso.");
        } catch (NoSuchElementException e) {
            teste.fail("Falha ao navegar para o portal acadêmico: " + e.getMessage());
            throw e;
        }
    }

    // Função para fazer login
    public static void realizarLogin(WebDriver driver) throws Exception {
        teste = relatorio.createTest("Realizar Login", "Realiza o login no portal acadêmico.");
        try {
            // Adicione os passos necessários para o login aqui
            WebElement botaoLogin = driver.findElement(By.id("loginButton"));
            botaoLogin.click();
            teste.pass("Login realizado com sucesso.");
        } catch (NoSuchElementException e) {
            teste.fail("Falha ao realizar o login: " + e.getMessage());
            throw e;
        }
    }

    // Função para verificar o login
    public static void verificarLogin(WebDriver driver) throws Exception {
        teste = relatorio.createTest("Verificar Login", "Verifica se o login foi realizado com sucesso.");
        try {
            WebElement botaoLogout = driver.findElement(By.id("logoutButton"));
            assert botaoLogout.isDisplayed() : "Botão de logout não está visível, login falhou.";
            teste.pass("Login verificado com sucesso.");
        } catch (AssertionError e) {
            teste.fail("Falha ao verificar o login: " + e.getMessage());
            throw e;
        }
    }

    // Método principal
    public static void main(String[] args) {
        configurarRelatorio();
        WebDriver driver = configurarDriver();

        try {
            abrirGoogle(driver);
            buscarInatel(driver);
            clicarNoSiteDoInatel(driver);
            navegarParaPortalAcademico(driver);
            realizarLogin(driver);
            verificarLogin(driver);
        } catch (Exception e) {
            teste.fail("Erro durante a execução do teste: " + e.getMessage());
        } finally {
            driver.quit();
            finalizarRelatorio();
        }
    }
}
