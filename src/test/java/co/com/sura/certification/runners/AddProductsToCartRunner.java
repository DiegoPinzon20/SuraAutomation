package co.com.sura.certification.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/adding_items_to_cart.feature",
        glue = "co.com.sura.certification.definitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        plugin = {
                "pretty",
                "html:target/serenity-reports/adding_items_to_cart/serenity-html-report.html",
                "rerun:target/serenity-reports/adding_items_to_cart/rerun.txt"
        }
)
public class AddProductsToCartRunner {

}