package extensions;

import com.codeborne.selenide.SelenideConfig;
import com.codeborne.selenide.SelenideDriver;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

import java.lang.annotation.Annotation;

public class SelenideDriverParametrResolver implements ParameterResolver {
    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.getParameter().getType() == SelenideDriver.class;
    }

    @Override
    public SelenideDriver resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        Annotation[] annotations = extensionContext.getRequiredTestMethod().getAnnotations();
        for (Annotation annotation : annotations) {
            if (annotation.annotationType() == Chrome.class)
                return new SelenideDriver(new SelenideConfig().browser("chrome"));
            if (annotation.annotationType() == FF.class)
                return new SelenideDriver(new SelenideConfig().browser("firefox"));
        }
        throw new ParameterResolutionException("Cannot find browser annotations");
    }
    }
