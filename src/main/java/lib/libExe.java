package lib;

import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;

public class libExe extends AbstractJavaSamplerClient {


    public Arguments getDefaultParameters() {

        Arguments defaultArguments = new Arguments();
        defaultArguments.addArgument("Participant", "${participantCode}");
        defaultArguments.addArgument("RequesterParticipant", "");
        defaultArguments.addArgument("certificatesPath", "");

        return defaultArguments;
    }

    @Override
    public SampleResult runTest(JavaSamplerContext javaSamplerContext) {
        String ParticipantTo = javaSamplerContext.getParameter("Participant");
        String RequesterParticipantTo = javaSamplerContext.getParameter("RequesterParticipant");
        String certificatesPathTo = javaSamplerContext.getParameter("certificatesPath");

        SampleResult sampleResult = new SampleResult();
        sampleResult.sampleStart();
        boolean success = true;

        String testWord = "This is test lib for Jmeter";

        try {
            javaSamplerContext.getJMeterVariables().put("testWord", testWord );

        } catch (Exception e) {
            success = false;
        }

        sampleResult.sampleEnd();
        sampleResult.setSuccessful(success);

        return sampleResult;
    }
}
