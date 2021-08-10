package lib;

import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;
import utils.Encrypt;
import utils.Generator;

public class LibExe extends AbstractJavaSamplerClient {

    public Arguments getDefaultParameters() {

        Arguments defaultArguments = new Arguments();
        defaultArguments.addArgument("WordOne", "${wordOne}");
        defaultArguments.addArgument("FirstNum", "${firstNum}");
        defaultArguments.addArgument("SecondNum", "${secondNum}");

        return defaultArguments;
    }

    public Generator generator = new Generator();
    public Encrypt encrypt = new Encrypt();

    @Override
    public SampleResult runTest(JavaSamplerContext javaSamplerContext) {
        String wordOneTo = javaSamplerContext.getParameter("WordOne");
        Integer firstNumTo = Integer.valueOf(javaSamplerContext.getParameter("FirstNum"));
        Integer secondNum = Integer.valueOf(javaSamplerContext.getParameter("SecondNum"));

        SampleResult sampleResult = new SampleResult();
        sampleResult.sampleStart();
        boolean success = true;

        String testStr = wordOneTo;
        String encryptTestStr = encrypt.encryptString(testStr);
        Integer generatedNum = generator.getRandomNumberUsingInts(firstNumTo,secondNum);

        try {
            javaSamplerContext.getJMeterVariables().put("testStr", testStr);
            javaSamplerContext.getJMeterVariables().put("encryptTestStr", encryptTestStr);
            javaSamplerContext.getJMeterVariables().put("generatedNum", String.valueOf(generatedNum));

        } catch (Exception e) {
            success = false;
            e.printStackTrace();
        }

        sampleResult.sampleEnd();
        sampleResult.setSuccessful(success);

        return sampleResult;
    }


}
