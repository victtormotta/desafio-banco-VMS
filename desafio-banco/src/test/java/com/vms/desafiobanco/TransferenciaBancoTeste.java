package com.vms.desafiobanco;

        import cucumber.api.CucumberOptions;
        import cucumber.api.junit.Cucumber;
        import org.junit.runner.RunWith;

/**
 * @author mota- on 10/10/2020
 * @project desafio-banco
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:caracteristicas", tags = "@TransferenciaBancoTeste",
        glue = "com.vms.desafiobanco.passos", monochrome = true, dryRun = false)
public class TransferenciaBancoTeste {
}