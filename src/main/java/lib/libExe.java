package lib;

import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;
import utils.GenerateRandomNumber;

public class libExe extends AbstractJavaSamplerClient {

    private utils.GenerateRandomNumber generateRandomNumber = new utils.GenerateRandomNumber();

    public Arguments getDefaultParameters() {

        Arguments defaultArguments = new Arguments();
        defaultArguments.addArgument("WordOne", "${wordOne}");
        defaultArguments.addArgument("WordTwo", "${wordTwo}");

        return defaultArguments;
    }

    @Override
    public SampleResult runTest(JavaSamplerContext javaSamplerContext) {
        String WordOne = javaSamplerContext.getParameter("wordOne");
        String WordTwo = javaSamplerContext.getParameter("wordTwo");

        SampleResult sampleResult = new SampleResult();
        sampleResult.sampleStart();
        boolean success = true;

        String testWord = WordOne + " " + WordTwo;
        Integer GeneratedtestNumber = generateRandomNumber.getNumber(0,100000);
        try {
            javaSamplerContext.getJMeterVariables().put("testWord", testWord);
            javaSamplerContext.getJMeterVariables().put("GeneratedtestNumber", String.valueOf(GeneratedtestNumber));

        } catch (Exception e) {
            success = false;
        }

        sampleResult.sampleEnd();
        sampleResult.setSuccessful(success);

        return sampleResult;
    }
}
