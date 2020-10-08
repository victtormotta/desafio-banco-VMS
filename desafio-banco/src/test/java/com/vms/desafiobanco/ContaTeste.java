package com.vms.desafiobanco;

/**
 * @author mota- on 10/8/2020
 * @project desafio-banco
 */

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:caracteristicas", tags = "@ContaTeste",
        glue = "com.vms.desafiobanco.passos", monochrome = true, dryRun = false)
public class ContaTeste {
}